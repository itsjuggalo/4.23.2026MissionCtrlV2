#!/usr/bin/env python3
"""Watchlist Signals — alert layer (capytrade clone), data-only.

  watchlist_exec.py alert   # LIVE: post the swing signal-drop to Discord + Telegram

Auto-exec (`exec` mode) is RETIRED 2026-09-16 — Alpaca is DATA-only doctrine, no
account/order use. `exec` now just prints a retirement notice and exits 0.
Reuses verified rails: lib/discord_post.post_discord, tg_fleet.send.
"""
import json, sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo
sys.path.insert(0, "/home/itsju/scripts")
sys.path.insert(0, "/home/itsju/scripts/lib")
from tg_format import esc, b, hdr, section, row, footer, join

SIGNALS = Path("/AIWorkWSL/web/missionctrl/data/watchlist-signals.json")
ET = ZoneInfo("America/New_York")
NOW_ET = lambda: datetime.now(ET).strftime("%H:%M")


def load(): return json.load(open(SIGNALS))


def _discord(msg):
    try:
        from discord_post import post_discord
        return bool(post_discord(msg))
    except Exception as e:
        print("discord err:", e); return False


def _tg(msg, html=True):
    try:
        from tg_fleet import send as tg_send
        tg_send("trading_command", msg, html=html); return True
    except Exception as e:
        print("tg err:", e); return False


def live_last(symbols):
    """audit 2026-10-22 (market-data §2, script-standards #2): the "last" a card shows is re-read at send time through
    price_guard.fresh (Robinhood first, Yahoo labelled), with its source + data time; never the producer's yfinance
    daily close. {SYM: "last 377.87 · src Robinhood 15:10 ET"} or "last UNAVAILABLE (<reason>)"."""
    try:
        from price_guard import fresh
        res = fresh(sorted({s.upper() for s in symbols}))
    except Exception as e:  # noqa: BLE001
        return {s.upper(): f"last UNAVAILABLE (price guard error {type(e).__name__})" for s in symbols}
    out = {}
    for s in symbols:
        r = res.get(s.upper()) or {}
        out[s.upper()] = (f"last {float(r['price']):.2f} · {r.get('src')}" if r.get("ok") and r.get("price")
                          else f"last UNAVAILABLE ({r.get('reason') or 'no quote'})")
    return out


def fmt_swing(s, html=True, last=None):
    arrow = "⬆" if s["dir"] == "LONG" else "⬇"
    glyph = "⭐" if s.get("hiConv") else "▸"
    facts = (f"{s['dir']} {arrow}", f"score {s['score']}/10",
             (last or {}).get(s["symbol"].upper()) or "last UNAVAILABLE (not re-read)")
    if html:
        return row(s['symbol'], *facts, glyph=glyph)
    return f"{glyph} **{s['symbol']}** · " + " · ".join(facts)  # Discord markdown


def _swing_board(swing, auto, html):
    """Shared structure for the Telegram (HTML) and Discord (plain/** markdown) renders —
    same tickers/numbers, glyph-matched Hi-Conviction/Setups grouping either way."""
    top = swing[:6]
    last = live_last([s["symbol"] for s in top])
    stars = [s for s in top if s.get("hiConv")]
    rest = [s for s in top if not s.get("hiConv")]
    # 2026-10-08 audit F16: header said "10 fired" over 6 rows. Count what is shown.
    sub = (f"swing drop {NOW_ET()} ET · {len(top)} shown"
           + (f" (top of {len(swing)})" if len(swing) > len(top) else ""))
    b_, foot = (b, footer) if html else (lambda x: f"**{x}**", lambda x: f"\n_{x}_")
    lines = [hdr("📡", "Watchlist Signals", sub=sub) if html
             else f"📡 {b_('WATCHLIST SIGNALS')} · {sub}"]
    if stars:
        lines.append(section("Hi-Conviction") if html else f"\n{b_('HI-CONVICTION')}")
        lines += [fmt_swing(s, html, last) for s in stars]
    if rest:
        if stars:
            lines.append(section("Setups") if html else f"\n{b_('SETUPS')}")
        lines += [fmt_swing(s, html, last) for s in rest]
    lines.append(foot("advisory only · recommendation surface · auto-exec "
                       + ("ARMED" if auto else "OFF")))
    return join(*lines) if html else "\n".join(str(x) for x in lines if x)


def alert(dry=False):
    d = load(); swing = d.get("swing", [])
    if not swing:
        if dry:
            print("no swing signals to alert")
        return
    auto = d.get("mode", {}).get("autoExec")
    tg_body = _swing_board(swing, auto, html=True)
    dc_body = _swing_board(swing, auto, html=False)
    if dry:
        print("WOULD SEND telegram:\n" + tg_body)
        print("\nWOULD SEND discord:\n" + dc_body)
        return
    ok1, ok2 = _discord(dc_body), _tg(tg_body)
    print(f"alert sent — discord={ok1} tg={ok2}")


def exec_mode():
    """Retired 2026-09-16 — Alpaca is data-only doctrine, no order/account use.
    Kept runnable (exits 0) since cron still calls `exec` daily; does nothing."""
    print("exec mode retired 2026-09-16 (Alpaca is data-only)")


if __name__ == "__main__":
    args = sys.argv[1:]
    dry = "--dry-run" in args
    mode = next((a for a in args if not a.startswith("--")), "alert")
    if mode == "alert":
        alert(dry=dry)
    elif mode == "exec":
        exec_mode()
    else:
        alert(dry=dry)
