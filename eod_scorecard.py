#!/usr/bin/env python3
"""eod_scorecard.py — end-of-day SCORECARD to #flow-picks: combined book P&L
(equity + real-money crypto) + grades of today's flow picks (did the underlying move
the way the pick implied?) + any /pick took/skip outcomes. Read-only. Cron 4:10 ET.

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
from lib.portfolio import real_money_holdings, equity_day_pnl  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from lib.discord_threading import make_pick_key, post_to_pick_thread_bot  # noqa: E402

ET = ZoneInfo("America/New_York")
SYNTH_TOKEN_FILE = Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token"
STATE = Path.home() / ".openclaw" / "state"
JOURNAL = Path.home() / ".openclaw" / "data" / "trade_journal.jsonl"


def _crypto_pnl():
    held = real_money_holdings()
    tot_val, tot_pl = 0.0, 0.0
    for sym, val in held.items():
        try:
            r = urllib.request.Request(
                f"https://api.exchange.coinbase.com/products/{sym}-USD/stats",
                headers={"User-Agent": "mc/1.0"})
            d = json.loads(urllib.request.urlopen(r, timeout=10).read())
            o = float(d.get("open", 0) or 0)
            last = float(d.get("last", 0) or 0)
            chg = (last - o) / o * 100 if o else 0
        except Exception:
            chg = 0
        tot_val += val
        tot_pl += val * (chg / (100 + chg)) if (100 + chg) else 0
    return tot_val, tot_pl


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
            oc.post_message_bot(cid, tok, embeds=[embed], components=[oc.pick_action_row()])
        print(f"[eod-scorecard] action cards: best {best[0]['symbol']} / worst {worst[0]['symbol']}", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[eod-scorecard] action-card err: {e}", flush=True)


def main():
    eq_val, eq_pl = equity_day_pnl()
    cr_val, cr_pl = _crypto_pnl()
    total_val = eq_val + cr_val
    total_pl = eq_pl + cr_pl
    arrow = "🟢" if total_pl >= 0 else "🔴"
    date = datetime.now(ET).strftime("%a %b %-d")

    lines = [f"📊 **EOD SCORECARD — {date}**",
             f"Book **${total_val:,.0f}**  ·  day {arrow} **${total_pl:+,.0f}**",
             f"   • Paper equity ${eq_val:,.0f} ({eq_pl:+,.0f})  • Crypto ${cr_val:,.0f} ({cr_pl:+,.0f})"]

    graded = _grade_picks()
    if graded:
        wins = sum(1 for _, g in graded if g and g[1] > 0.3)
        lines.append(f"\n**🎯 Today's flow picks — {wins}/{len(graded)} working:**")
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
        lines.append("\n_No flow picks logged today._")

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
    if "--print" in sys.argv:        # on-demand (/scorecard) — return text, don't post
        print(msg)
        return
    sd.post(sd.resolve_channel("flow-picks"), msg)
    _post_grade_threads(graded)        # land each grade in its per-pick thread (closes the loop)
    _post_grade_action_cards(graded)   # best + worst pick → tap-to-act cards
    beat("eod_scorecard")
    used = tg_brief(msg)
    print(f"[eod-scorecard] posted; book ${total_val:,.0f} day ${total_pl:+,.0f} picks={len(graded)} · tg→{used or 'skip'}", flush=True)


if __name__ == "__main__":
    main()
