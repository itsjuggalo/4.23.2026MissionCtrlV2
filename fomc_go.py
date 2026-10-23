#!/usr/bin/env python3
"""fomc_go.py — post-FOMC "which branch fired + GO" nudge. Fires ~45 min after the
2:00 PM decision, reads the market's reaction, classifies hawkish/dovish/muted, and
pushes the matching buy list from Mike's FOMC battle plan. ALERT-ONLY, READ-ONLY.

Self-gating: no-ops unless today is an FOMC decision day (embedded FOMC_2026 from
macro_calendar_alert), so a standing `45 14 * * 3` cron auto-fires only the 8 Fed days
a year. Reaction = avg SPY/QQQ move off the 14:00 bar (+ TLT yields, SMH semis as
confirmation). Share sizes live-quoted at run time.

  fomc_go.py            # print (no send) — default
  fomc_go.py --send     # push to trading_command Telegram (loud)
  fomc_go.py --force    # bypass the FOMC-day gate (for testing)
Run with ~/.venv/bin/python.
"""
from __future__ import annotations

import argparse
import json
import sys
import urllib.request
from datetime import datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
from macro_calendar_alert import FOMC_2026, et_today  # reuse embedded Fed calendar

ET = ZoneInfo("America/New_York")
YAHOO = "https://query1.finance.yahoo.com/v8/finance/chart/{sym}?range=1d&interval=1m&includePrePost=false"


def _get(url: str):
    try:
        req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0 (fomc-go)"})
        with urllib.request.urlopen(req, timeout=12) as r:
            return json.loads(r.read())
    except Exception:
        return None


def _bars_1m(sym: str) -> list[tuple[datetime, float]]:
    """[(bar time UTC, close)] for today's regular session from Yahoo's free chart JSON (1-min). Empty on any failure.
    Free replacement for the Alpaca IEX 1-min bars (market-data §1: Alpaca is not a price source)."""
    j = _get(YAHOO.format(sym=sym))
    try:
        res = j["chart"]["result"][0]
        closes = res["indicators"]["quote"][0]["close"]
        return [(datetime.fromtimestamp(t, tz=timezone.utc), c) for t, c in zip(res.get("timestamp") or [], closes) if c is not None]
    except Exception:
        return []


_AS_OF: dict[str, str] = {}   # symbol -> newest 1-min bar time used (the as_of of each % move)


def moves_since_2pm() -> dict[str, float]:
    """% move from the 14:00 ET bar close to the latest, per symbol."""
    start = datetime.now(timezone.utc).astimezone(ET).replace(
        hour=13, minute=55, second=0, microsecond=0).astimezone(timezone.utc)
    out = {}
    for s in ("SPY", "QQQ", "SMH", "TLT"):
        bars = [(t, c) for t, c in _bars_1m(s) if t >= start]
        if not bars:
            continue
        base = None
        for t, c in bars:
            et = t.astimezone(ET)
            if et.hour == 14 and et.minute == 0:
                base = c
                break
        base = base if base is not None else bars[0][1]
        last = bars[-1][1]
        out[s] = (last / base - 1) * 100 if base else 0.0
        _AS_OF[s] = bars[-1][0].strftime("%Y-%m-%dT%H:%M:%SZ")
    return out


def classify(m: dict[str, float]) -> str:
    if not m:
        return "unknown"
    eq = (m.get("SPY", 0) + m.get("QQQ", 0)) / 2
    if eq <= -0.4:
        return "hawkish"
    if eq >= 0.4:
        return "dovish"
    return "muted"


def build(send: bool):
    m = moves_since_2pm()
    verdict = classify(m)

    tape = (f"SPY {m.get('SPY',0):+.1f}% · QQQ {m.get('QQQ',0):+.1f}% · "
            f"SMH {m.get('SMH',0):+.1f}% · TLT {m.get('TLT',0):+.1f}% (since 2:00)")
    # market-data §2: a sent number names its source + data time. These % moves are computed from Yahoo 1-min
    # bars (no free intraday Robinhood bar history here) — labelled "not Robinhood", never a price.
    newest = max(_AS_OF.values()) if _AS_OF else None
    when = (datetime.fromisoformat(newest.replace("Z", "+00:00")).astimezone(ET).strftime("%H:%M ET")
            if newest else "time n/a")
    tape += f" · src Yahoo 1-min bars, not Robinhood, as of {when}"
    L = [f"🏛️ <b>FOMC REACTION — {verdict.upper()}</b>",
         f"FOMC TAPE (local SPY/QQQ/SMH/TLT move since 14:00 heuristic, not the canonical regime): "
         f"{verdict}",
         tape]
    if verdict == "unknown" or not m:
        L.append("⚠️ Data gap — tape unavailable.")
    return "\n".join(L), verdict


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--force", action="store_true", help="bypass FOMC-day gate (testing)")
    a = ap.parse_args()
    today = et_today().isoformat()
    if not a.force and today not in FOMC_2026:
        print(f"[fomc_go] {today} not an FOMC decision day — no-op", flush=True)
        return
    msg, verdict = build(a.send)
    if not a.send:
        print(msg.replace("<b>", "").replace("</b>", ""))
        print(f"\n[dry-run] verdict={verdict} · would send LOUD", flush=True)
        return
    try:
        from lib.notify import tg_push
        fn = tg_push(msg, "trading_command", loud=True,
                     fallback_token_file="telegram_laptopclaude_bot_token")
        print(f"[fomc_go] sent via {fn} (verdict={verdict})", flush=True)
    except Exception as e:
        print(f"[fomc_go] send FAILED: {e}", flush=True)


if __name__ == "__main__":
    main()
