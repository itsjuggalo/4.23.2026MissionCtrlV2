#!/usr/bin/env python3
"""eod_scorecard.py — end-of-day SCORECARD to #flow-picks: grades of today's picks
across THREE live, free sources (flow_picks_post's logged picks, setup_scanner +
explosion_score's self-logged alerts, and today's structure-rebound triggers) + a
catalyst/SNR read-through. Read-only. Cron 4:35 ET (moved from 4:10 2026-09-15 so
best3_grader.py --eod, 4:20 ET, has already rebuilt the scoreboard first).

2026-09-15: dropped the book-equity preamble (lib.portfolio.equity_day_pnl() +
real_money_holdings() — Alpaca paper + RH/Coinbase real-money) — doctrine
retirement (2026-08-11 Alpaca, 2026-09-12 portfolio views). The grading half
(did the pick's direction pan out) was always fine and stays. See docs/audits/
telegram-sweep-2026-09-15/trade-lanes.md Lane 2.

2026-09-15: broadened grading beyond flow_picks_post's cache (real but sometimes
thin) with two more free, live sources so a quiet flow day doesn't read as "no
picks" — setup_scanner/explosion_score alerts (signal_outcomes.sqlite `alerts`
table, graded here against a free Yahoo close since the nightly 20:15 ET grading
job runs AFTER this cron) and today's structure-rebound triggers (D5's pinned
sketches in rebound_ping_state.json).

2026-09-15: dropped the dead "/pick took/skip" block (`~/.openclaw/data/
trade_journal.jsonl`, 0 bytes since 2026-06-15). Root cause is NOT journal_sync.py
(that script writes a same-named but unrelated `trade_journal` TABLE in
missionctrl's dashboard_history.sqlite, from Alpaca fills — never this JSONL file
at all). The actual writer is aime_discord_bot.py's `_journal()`, called from the
persistent "took"/"skip" button View on its interactive Discord pick cards; that
bot (`aime-discord` PM2) is still online, so this reads as Mike having stopped
using that specific Discord interaction (migrated to Telegram) rather than a
pipeline failure — nothing here needs Alpaca/holdings to fix, and nothing to
repoint to; the feature is simply retired until/unless someone wires an
equivalent Telegram-side took/skip log.

Run with ~/.venv/bin/python (yfinance for underlying EOD prices).
"""
from __future__ import annotations

import json
import re
import sqlite3
import sys
import urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
import tg_format as tgf  # noqa: E402  (2026-09-15 Telegram format sweep)
from lib.heartbeat import beat  # noqa: E402
from lib.discord_threading import make_pick_key, post_to_pick_thread_bot  # noqa: E402

ET = ZoneInfo("America/New_York")
SYNTH_TOKEN_FILE = Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token"
STATE = Path.home() / ".openclaw" / "state"
NEWS_SNR_URL = "http://localhost:3000/api/news-snr?min=65"
# 2026-09-15: setup_scanner + explosion_score self-log every alert here (free,
# live, no Alpaca) — see signal_outcomes.py / setup_scanner.py's log_alert() calls.
SIGNAL_OUTCOMES_DB = Path("/AIWorkWSL/trading/analysis/signal_outcomes.sqlite")
SCANNER_SOURCES = ("setup_scanner", "explosion")
# Shared with pipeline/decision/rebound_setup.py (D5, 2026-09-15) — the same file
# that pins each triggered symbol's contract sketch.
REBOUND_PING_STATE = Path.home() / ".openclaw" / "data" / "decision" / "rebound_ping_state.json"


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


CRYPTO_SYMS = {"BTC", "ETH", "SOL"}   # setup_scanner/explosion_score's --crypto universe


def _last_any(symbol: str):
    """Like _last(), but routes a known crypto ticker to a free Coinbase spot quote —
    yfinance's bare 'BTC' resolves to the Grayscale Bitcoin Mini Trust ETF, not
    bitcoin (same gotcha setup_scanner's own test suite guards against:
    test_btc_skips_the_equity_chart_check). Grading a crypto alert against the ETF
    price produced a nonsense -99.96% move before this fix."""
    if symbol.upper() in CRYPTO_SYMS:
        try:
            from lib.portfolio import _crypto_prices   # market-data spot quote only — no holdings/account call
            px = _crypto_prices().get(symbol.upper())
            return float(px) if px else None
        except Exception:
            return None
    return _last(symbol)


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


def _plan_triggered(symbol: str, direction: str, trigger: float, sent_ts: str, grade: str):
    """Did the underlying trade through the plan's entry trigger after the alert went out?
    True / False, or None when intraday bars are unavailable (never guessed). A TRIGGER-grade
    alert fired at send, so it counts as triggered."""
    if (grade or "").upper() == "TRIGGER":
        return True
    if symbol.upper() in CRYPTO_SYMS:
        return None
    try:
        import yfinance as yf
        h = yf.Ticker(symbol).history(period="1d", interval="5m", prepost=True)
        if not len(h):
            return None
        sent = datetime.fromisoformat(sent_ts)
        h = h[h.index >= sent.replace(second=0, microsecond=0)]
        if not len(h):
            return None
        return bool(h["High"].max() >= trigger) if direction != "SHORT" else bool(h["Low"].min() <= trigger)
    except Exception:
        return None


def _grade_scanner_alerts():
    """Today's setup_scanner + explosion_score alerts, self-logged (free, no Alpaca)
    to signal_outcomes.sqlite's `alerts` table. Graded here against a free Yahoo
    close — the nightly `signal_outcomes.py nightly` job (20:15 ET) that normally
    fills in px_eod/reod runs AFTER this cron, so those columns aren't populated
    yet at grading time. One row per symbol (earliest alert)."""
    if not SIGNAL_OUTCOMES_DB.exists():
        return []
    date = datetime.now(ET).strftime("%Y-%m-%d")
    try:
        con = sqlite3.connect(f"file:{SIGNAL_OUTCOMES_DB}?mode=ro&immutable=0", uri=True, timeout=10)
        placeholders = ",".join("?" * len(SCANNER_SOURCES))
        rows = con.execute(
            f"SELECT symbol, direction, grade, trigger, sent_ts FROM alerts "
            f"WHERE day = ? AND source IN ({placeholders}) AND trigger IS NOT NULL "
            f"ORDER BY sent_ts", (date, *SCANNER_SOURCES)).fetchall()
        con.close()
    except Exception as e:
        print(f"[eod-scorecard] signal_outcomes read err: {e}", flush=True)
        return []
    out, seen, spot_cache = [], set(), {}
    for symbol, direction, grade, trigger, sent_ts in rows:
        if not symbol or symbol in seen or not trigger:
            continue
        seen.add(symbol)
        if symbol not in spot_cache:
            spot_cache[symbol] = _last_any(symbol)
        now = spot_cache[symbol]
        r = {"symbol": symbol, "direction": (direction or "LONG").upper(), "grade": grade}
        r["triggered"] = _plan_triggered(symbol, r["direction"], trigger, sent_ts, grade)
        if not now:
            out.append((r, None))
            continue
        move = (now - trigger) / trigger * 100
        favorable = move if r["direction"] != "SHORT" else -move
        out.append((r, (move, favorable, trigger, now)))
    return out


def _grade_rebound_triggers():
    """Structure-rebound setups that TRIGGERED today (D5's pinned contract sketches
    in rebound_ping_state.json) — underlying move since the level it held. `stop`
    (level minus the detector's tolerance) is the closest thing to an "entry" this
    file has for a level-hold setup; a rebound call wants the underlying to move UP
    off that level, so favorable == move."""
    try:
        state = json.loads(REBOUND_PING_STATE.read_text())
    except Exception:
        return []
    today = datetime.now(ET).strftime("%Y-%m-%d")
    out = []
    for key, sketch in sorted((state.get("sketches") or {}).items()):
        sym, _, trig_date = key.partition("|")
        if trig_date != today or not sym or not isinstance(sketch, dict):
            continue
        level = sketch.get("stop")
        now = _last(sym)
        r = {"symbol": sym, "option": sketch.get("label")}
        if not now or not level:
            out.append((r, None))
            continue
        move = (now - level) / level * 100
        put = bool(re.search(r"\d(?:\.\d+)?P\b", str(sketch.get("label") or "")))
        out.append((r, (move, -move if put else move, level, now)))   # a put wants the underlying DOWN
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
                msg = f"🏁 **EOD GRADE — {label}** — no data: no live price from Yahoo at run time."
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


def _grade_glyph(val: float) -> str:
    return "✅" if val > 0.3 else ("❌" if val < -0.3 else "➖")


def _build_discord_msg(graded, scanner_graded, rebound_graded, snr) -> str:
    """Discord-markdown scorecard (posted to #flow-picks via sd.post — unchanged)."""
    date = datetime.now(ET).strftime("%a %b %-d")
    lines = [f"📊 **EOD SCORECARD — {date}**"]

    if graded:
        wins = sum(1 for _, g in graded if g and g[1] > 0.3)
        lines.append(f"**🎯 Today's flow picks — {wins}/{len(graded)} working:**")
        for r, g in graded:
            label = f"{r['symbol']} ${r['strike']:g}{r['type']}"
            if not g:
                lines.append(f"   • {label} — no data")
                continue
            move, fav, entry, now = g
            lines.append(f"   {_grade_glyph(fav)} {label} — underlying {entry:.2f}→{now:.2f} ({move:+.1f}%)")
        lines.append("_Grade = did the underlying move the pick's direction since it posted._")
    else:
        lines.append("_No flow-signal picks logged today._")

    if scanner_graded:
        wins, cnt = _tg_ratio(scanner_graded)
        lines.append(f"\n**📡 Today's setup/explosion alerts (from entry trigger) — {wins}/{cnt} working:**")
        for r, g in scanner_graded:
            label = f"{r['symbol']} {r['direction']}"
            if r.get("triggered") is False:
                lines.append(f"   ⏸ {label} — plan never triggered, no trade")
                continue
            if not g:
                lines.append(f"   • {label} — no data")
                continue
            move, fav, entry, now = g
            lines.append(f"   {_grade_glyph(fav)} {label} — {entry:.2f}→{now:.2f} ({move:+.1f}%)")

    if rebound_graded:
        lines.append(f"\n**🏗 Today's structure triggers ({len(rebound_graded)}):**")
        for r, g in rebound_graded:
            opt = f" · {r['option']}" if r.get("option") else ""
            if not g:
                lines.append(f"   • {r['symbol']}{opt} — no data")
                continue
            move, _fav, entry, now = g
            lines.append(f"   {_grade_glyph(move)} {r['symbol']}{opt} — held {entry:.2f}, now {now:.2f} ({move:+.1f}%)")

    if snr:
        lines.append(snr)

    return "\n".join(lines)


def _tg_ratio(rows, favorable_idx=1):
    """(working, counted) over graded rows that actually triggered."""
    live = [(r, g) for r, g in rows if g and r.get("triggered") is not False]
    return sum(1 for _, g in live if g[favorable_idx] > 0.3), len(live)


def _build_tg_msg(graded, scanner_graded, rebound_graded, snr, now=None) -> str:
    """Telegram HTML scorecard — tg_format.py layout. Takeaway first; every section
    states its basis; stock moves are never printed as option P&L (none is tracked)."""
    now = now or datetime.now(ET)
    clock = now.strftime("%H:%M ET")
    blocks = [tgf.hdr("📊", "EOD Scorecard", now)]

    # one-line takeaway
    bits = []
    if graded:
        w, n = _tg_ratio(graded)
        bits.append(f"flow picks {w}/{n} moved the right way")
    if scanner_graded:
        w, n = _tg_ratio(scanner_graded)
        skipped = sum(1 for r, _ in scanner_graded if r.get("triggered") is False)
        bits.append(f"setups {w}/{n} working" + (f" ({skipped} never triggered)" if skipped else ""))
    if rebound_graded:
        w, n = _tg_ratio(rebound_graded)
        bits.append(f"structure {w}/{n} holding")
    blocks.append("Takeaway: " + (" · ".join(bits) if bits else "no picks logged today")
                  + ". Stock moves, not option P&L.")

    if graded:
        w, n = _tg_ratio(graded)
        blocks.append(tgf.section(f"Flow picks · {w}/{n} working"))
        blocks.append("<i>Basis: the stock's move since the pick posted, in the pick's direction.</i>")
        for r, g in graded:
            pick = f"pick ${r['strike']:g}{r['type']}"
            if not g:
                blocks.append(tgf.row(r["symbol"], "no data: no spot at post or no live price at "
                                      + clock, pick))
                continue
            move, fav, entry, now_px = g
            blocks.append(tgf.row(r["symbol"], f"stock {entry:.2f}→{now_px:.2f}", tgf.pct(move), pick,
                                   glyph=_grade_glyph(fav)))
    else:
        blocks.append(tgf.section("Flow picks"))
        blocks.append("No flow-signal picks logged today.")

    if scanner_graded:
        w, n = _tg_ratio(scanner_graded)
        blocks.append(tgf.section(f"Setup/explosion alerts · {w}/{n} working"))
        blocks.append("<i>Basis: from the entry trigger, not from the alert. Plans that never "
                      "reached their trigger are not trades and are not counted.</i>")
        for r, g in scanner_graded:
            label = f"{r['symbol']} {r['direction']}"
            if r.get("triggered") is False:
                blocks.append(tgf.row(label, "plan never triggered — no trade", glyph="⏸"))
                continue
            if not g:
                blocks.append(tgf.row(label, "no data: no live price from Yahoo at " + clock))
                continue
            move, fav, entry, now_px = g
            blocks.append(tgf.row(label, f"stock from entry {entry:.2f}→{now_px:.2f}", tgf.pct(move),
                                   glyph=_grade_glyph(fav)))

    if rebound_graded:
        w, n = _tg_ratio(rebound_graded)
        blocks.append(tgf.section(f"Structure triggers · {w}/{n} holding"))
        blocks.append("<i>Basis: the stock's move since the level held, in the option's direction. "
                      "Option cost is the plan's estimate, not a fill.</i>")
        for r, g in rebound_graded:
            opt = f"plan {r['option']}" if r.get("option") else None
            if not g:
                blocks.append(tgf.row(r["symbol"], "no data: no live price or level at " + clock, opt))
                continue
            move, fav, entry, now_px = g
            blocks.append(tgf.row(r["symbol"], f"stock held {entry:.2f}→{now_px:.2f}", tgf.pct(move), opt,
                                   glyph=_grade_glyph(fav)))

    if snr:
        # strip the Discord "📰 **…**" wrapper _snr_corroboration_line() built — reuse
        # just the trailing "TICKER 76 · TICKER 70 …" payload as the footer body.
        payload = snr.split(":**", 1)[-1].strip() if ":**" in snr else snr.lstrip("\n")
        blocks.append(tgf.footer(f"SNR corroboration (≥65): {payload}"))
    blocks.append(tgf.footer(f"Source: Yahoo last price as of {clock}. Option P&L: not tracked (no fills). "
                             "The nightly Signal Report Card grades since the alert, so the two can differ."))

    return tgf.join(*blocks)


def _tg_send_html(text: str, chain=("flow_digest", "daily_briefs")) -> str | None:
    """Chain-fallback Telegram send with parse_mode=HTML. Mirrors lib.notify.tg_brief's
    fallback logic but keeps the <b>/<i> tags live — tg_brief's plain-text `send` would
    print the raw tags on the phone. Local to this script; never raises."""
    import subprocess
    PY = "/home/itsju/.venv/bin/python"
    FLEET = "/home/itsju/scripts/tg_fleet.py"
    body = text if len(text) <= 4000 else text[:3990] + "\n…(truncated)"
    for fn in chain:
        if not fn:
            continue
        try:
            r = subprocess.run([PY, FLEET, "sendhtml", fn, body],
                               capture_output=True, text=True, timeout=30)
            if r.returncode == 0 and "sent" in (r.stdout or ""):
                return fn
        except Exception:
            continue
    return None


def main():
    graded = _grade_picks()
    scanner_graded = _grade_scanner_alerts()
    rebound_graded = _grade_rebound_triggers()
    snr = _snr_corroboration_line()

    msg = _build_discord_msg(graded, scanner_graded, rebound_graded, snr)
    tg_msg = _build_tg_msg(graded, scanner_graded, rebound_graded, snr)

    if "--print" in sys.argv or "--dry-run" in sys.argv:   # on-demand (/scorecard) or verify — return text, don't post
        print(tg_msg)
        return
    sd.post(sd.resolve_channel("flow-picks"), msg)
    _post_grade_threads(graded)        # land each grade in its per-pick thread (closes the loop)
    _post_scorecard_card(graded)       # visual scorecard card
    _post_grade_action_cards(graded)   # best + worst pick → tap-to-act cards
    beat("eod_scorecard")
    used = _tg_send_html(tg_msg, chain=("flow_digest", "daily_briefs"))  # 2026-06-24: EOD Scorecard → flow_digest (fallback SpaceCoast)
    print(f"[eod-scorecard] posted; picks={len(graded)} · tg→{used or 'skip'}", flush=True)


if __name__ == "__main__":
    main()
