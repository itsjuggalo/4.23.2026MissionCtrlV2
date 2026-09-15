#!/usr/bin/env python3
"""eod_scorecard.py — end-of-day SCORECARD to #flow-picks: grades of today's flow
picks (did the underlying move the way the pick implied?) + a catalyst/SNR
read-through + any /pick took/skip outcomes. Read-only. Cron 4:10 ET.

2026-09-15: dropped the book-equity preamble (lib.portfolio.equity_day_pnl() +
real_money_holdings() — Alpaca paper + RH/Coinbase real-money) — doctrine
retirement (2026-08-11 Alpaca, 2026-09-12 portfolio views). The grading half
(did the pick's direction pan out) was always fine and stays. See docs/audits/
telegram-sweep-2026-09-15/trade-lanes.md Lane 2.

Run with ~/.venv/bin/python (yfinance for underlying EOD prices).
"""
from __future__ import annotations

import json
import sys
import urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from lib.discord_threading import make_pick_key, post_to_pick_thread_bot  # noqa: E402

ET = ZoneInfo("America/New_York")
SYNTH_TOKEN_FILE = Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token"
STATE = Path.home() / ".openclaw" / "state"
JOURNAL = Path.home() / ".openclaw" / "data" / "trade_journal.jsonl"
NEWS_SNR_URL = "http://localhost:3000/api/news-snr?min=65"


def _snr_corroboration_line() -> str:
    """One-line SNR corroboration: top 3 high-signal headlines (ticker + score).
    Silently skipped if the endpoint doesn't respond — advisory only, never blocks
    the scorecard."""
    try:
        req = urllib.request.Request(NEWS_SNR_URL, headers={"User-Agent": "mc-eod/1.0"})
        with urllib.request.urlopen(req, timeout=8) as r:
            data = json.loads(r.read())
        arts = sorted(data.get("articles") or [], key=lambda a: -(a.get("snr") or 0))[:3]
        if not arts:
            return ""
        parts = []
        for a in arts:
            tks = a.get("tickers") or []
            tag = tks[0] if tks else "—"
            parts.append(f"{tag} {int(a.get('snr') or 0)}")
        return "\n📰 **SNR corroboration (≥65):** " + " · ".join(parts)
    except Exception:
        return ""


def _last(ticker: str):
    try:
        import yfinance as yf
        i = yf.Ticker(ticker).history(period="1d", interval="5m")
        if len(i):
            return float(i["Close"].iloc[-1])
        h = yf.Ticker(ticker).history(period="1d")
        return float(h["Close"].iloc[-1]) if len(h) else None
    except Exception:
        return None


def _grade_picks():
    date = datetime.now(ET).strftime("%Y-%m-%d")
    path = STATE / f"flow_picks_log_{date}.jsonl"
    if not path.exists():
        return []
    picks = {}
    for ln in path.read_text().splitlines():
        try:
            r = json.loads(ln)
        except Exception:
            continue
        osym = r.get("optionSymbol")
        if osym and osym not in picks:   # earliest reference per contract
            picks[osym] = r
    out = []
    spot_cache = {}
    for r in picks.values():
        tk = r["symbol"]
        entry = r.get("spot")
        if tk not in spot_cache:
            spot_cache[tk] = _last(tk)
        now = spot_cache[tk]
        if not entry or not now:
            out.append((r, None))
            continue
        move = (now - entry) / entry * 100
        # call wants up, put wants down
        favorable = move if r.get("type", "C").upper() == "C" else -move
        out.append((r, (move, favorable, entry, now)))
    return out


def _post_grade_threads(graded) -> None:
    """Post each pick's EOD grade into its per-pick thread (same key flow_picks_post
    opened on entry), so entry → grade live together. Token-only, never raises."""
    if not graded:
        return
    try:
        tok = SYNTH_TOKEN_FILE.read_text().strip()
        parent = sd.resolve_channel("flow-picks")
        for r, g in graded:
            key = make_pick_key(r.get("symbol"), r.get("strike"),
                                str(r.get("type", ""))[:1], r.get("exp"))
            label = f"{r['symbol']} ${r['strike']:g}{r['type']}"
            if not g:
                msg = f"🏁 **EOD GRADE — {label}** — no data."
            else:
                move, fav, entry, now = g
                ic = "✅" if fav > 0.3 else ("❌" if fav < -0.3 else "➖")
                msg = (f"🏁 **EOD GRADE — {label}**\nUnderlying {entry:.2f}→{now:.2f} "
                       f"(**{move:+.1f}%**) · {ic} {fav:+.1f}% in the pick's direction")
            post_to_pick_thread_bot(key, msg, label, tok, parent)
    except Exception as e:  # noqa: BLE001
        print(f"[eod-scorecard] grade-thread err: {e}", flush=True)


def _post_grade_action_cards(graded) -> None:
    """Action cards for the day's BEST + WORST graded pick — tap to re-up the winner
    or cut the loser. Posted AS SynthControl so the buttons route. Never raises."""
    g2 = [(r, g) for r, g in (graded or []) if g]
    if not g2:
        return
    try:
        from lib import ops_card as oc
        tok = SYNTH_TOKEN_FILE.read_text().strip()
        cid = sd.resolve_channel("flow-picks")
        best = max(g2, key=lambda x: x[1][1])
        worst = min(g2, key=lambda x: x[1][1])
        seen = set()
        for tag, (r, g) in (("BEST", best), ("WORST", worst)):
            sym = str(r.get("symbol", "")).upper()
            if sym in seen:        # best == worst (only one graded) → one card
                continue
            seen.add(sym)
            move, fav, entry, now = g
            embed = {
                "title": f"{'🏆' if tag == 'BEST' else '🩹'} {tag} PICK · {sym}",
                "color": 0x2ECC71 if fav >= 0 else 0xE74C3C,
                "description": f"**{sym} ${r['strike']:g}{r['type']}** · underlying {entry:.2f}→{now:.2f} (**{move:+.1f}%**)",
                "fields": [
                    {"name": "In pick's direction", "value": f"{fav:+.1f}%", "inline": True},
                    {"name": "Read", "value": ("let it run / re-up" if tag == "BEST" else "cut / reassess"),
                     "inline": True},
                ],
                "footer": {"text": f"tk:{sym} · EOD grade · tap to act"},
            }
            oc.post_message_bot(cid, tok, embeds=[embed], components=oc.pick_action_rows())
        print(f"[eod-scorecard] action cards: best {best[0]['symbol']} / worst {worst[0]['symbol']}", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[eod-scorecard] action-card err: {e}", flush=True)


def _post_scorecard_card(graded) -> None:
    """Post the visual EOD scorecard card (best/worst mini-charts + grades). No book/
    equity block — see module docstring."""
    try:
        from lib import chart_renderer as cr, ops_card as oc
        tok = SYNTH_TOKEN_FILE.read_text().strip()
        cid = sd.resolve_channel("flow-picks")
        g2 = [(r, g) for r, g in (graded or []) if g]
        wins = sum(1 for _, g in g2 if g[1] > 0.3)
        spec = {"headline": f"{wins}/{len(graded or [])} picks working today", "rows": []}
        for r, g in g2[:6]:
            spec["rows"].append((f"{r['symbol']} ${r['strike']:g}{r['type']}", g[0], g[1] > 0.3))
        if g2:
            best = max(g2, key=lambda x: x[1][1])
            worst = min(g2, key=lambda x: x[1][1])
            for key, (r, g) in (("best", best), ("worst", worst)):
                df = cr.ohlc(str(r["symbol"]), days=12, interval="1d")
                spec[key] = {"sym": r["symbol"], "move": g[0],
                             "series": list(df["Close"].values[-15:]) if df is not None else None}
        png = cr.scorecard_card(spec)
        ok = png and oc.post_image_bot(cid, tok, png, content="📊 **EOD Scorecard**")
        print(f"[eod-scorecard] scorecard card: {'ok' if ok else 'FAILED'}", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[eod-scorecard] scorecard-card err: {e}", flush=True)


def main():
    date = datetime.now(ET).strftime("%a %b %-d")
    lines = [f"📊 **EOD SCORECARD — {date}**"]

    graded = _grade_picks()
    if graded:
        wins = sum(1 for _, g in graded if g and g[1] > 0.3)
        lines.append(f"**🎯 Today's flow picks — {wins}/{len(graded)} working:**")
        for r, g in graded:
            label = f"{r['symbol']} ${r['strike']:g}{r['type']}"
            if not g:
                lines.append(f"   • {label} — no data")
                continue
            move, fav, entry, now = g
            ic = "✅" if fav > 0.3 else ("❌" if fav < -0.3 else "➖")
            lines.append(f"   {ic} {label} — underlying {entry:.2f}→{now:.2f} ({move:+.1f}%)")
        lines.append("_Grade = did the underlying move the pick's direction since it posted._")
    else:
        lines.append("_No flow picks logged today._")

    snr = _snr_corroboration_line()
    if snr:
        lines.append(snr)

    # /pick took/skip decisions today
    took, skip = [], []
    if JOURNAL.exists():
        for ln in JOURNAL.read_text().splitlines():
            try:
                r = json.loads(ln)
                dt = datetime.fromisoformat(r["ts"]).astimezone(ET)
                if dt.date() == datetime.now(ET).date():
                    (took if r.get("action") == "took" else skip if r.get("action") == "skip" else []).append(r.get("ticker"))
            except Exception:
                pass
    if took or skip:
        lines.append(f"\n**Your calls:** ✅ took {', '.join(took) or '—'} · ❌ skipped {', '.join(skip) or '—'}")

    msg = "\n".join(lines)
    if "--print" in sys.argv or "--dry-run" in sys.argv:   # on-demand (/scorecard) or verify — return text, don't post
        print(msg)
        return
    sd.post(sd.resolve_channel("flow-picks"), msg)
    _post_grade_threads(graded)        # land each grade in its per-pick thread (closes the loop)
    _post_scorecard_card(graded)       # visual scorecard card
    _post_grade_action_cards(graded)   # best + worst pick → tap-to-act cards
    beat("eod_scorecard")
    used = tg_brief(msg, chain=("flow_digest", "daily_briefs"))  # 2026-06-24: EOD Scorecard → flow_digest (fallback SpaceCoast)
    print(f"[eod-scorecard] posted; picks={len(graded)} · tg→{used or 'skip'}", flush=True)


if __name__ == "__main__":
    main()
