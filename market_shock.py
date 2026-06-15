#!/usr/bin/env python3
"""market_shock.py — proactive volatility / market-shock alert → #risk-alerts.

Cheap data check (yfinance ^VIX + SPY) every 20 min market hours; pings only when
VIX is elevated/spiking or SPY moves sharply intraday. Template-only (no LLM cost),
deduped per trigger-type per day. Run with ~/.venv/bin/python (yfinance).
"""
import json
import os
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402  (channel resolver + bot-token poster)
import yfinance as yf  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state" / "market_shock_seen.json"
VIX_LEVEL = 25.0   # absolute elevated-fear line
VIX_JUMP = 10.0    # % spike on the day
SPY_MOVE = 1.5     # |intraday %| on SPY


def quote(sym):
    try:
        fi = yf.Ticker(sym).fast_info
        cur = float(fi.last_price)
        prev = float(fi.previous_close)
        return cur, ((cur - prev) / prev * 100 if prev else 0.0)
    except Exception:
        return None, None


def load():
    try:
        return set(json.loads(STATE.read_text()))
    except Exception:
        return set()


def save(seen, today):
    seen = {k for k in seen if k.endswith(today)}
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps(list(seen)))
    os.replace(tmp, STATE)


def main():
    today = datetime.now(ET).strftime("%Y%m%d")
    seen = load()
    alerts = []
    vix, vixp = quote("^VIX")
    spy, spyp = quote("SPY")
    if vix is not None:
        if vix >= VIX_LEVEL and f"VIXLVL:{today}" not in seen:
            alerts.append(f"🌋 **VIX {vix:.1f}** ({vixp:+.0f}% today) — elevated fear. "
                          f"Risk-off: tighten stops, cut size, favor defined-risk.")
            seen.add(f"VIXLVL:{today}")
        elif vixp is not None and vixp >= VIX_JUMP and f"VIXJMP:{today}" not in seen:
            alerts.append(f"🌋 **VIX spiking** {vix:.1f} ({vixp:+.0f}% today) — "
                          f"volatility expanding. Be cautious adding risk.")
            seen.add(f"VIXJMP:{today}")
    if spy is not None and spyp is not None and abs(spyp) >= SPY_MOVE:
        key = f"SPY{'DN' if spyp < 0 else 'UP'}:{today}"
        if key not in seen:
            icon = "🔻" if spyp < 0 else "🚀"
            verb = "dropping" if spyp < 0 else "ripping"
            alerts.append(f"{icon} **SPY {spyp:+.1f}%** today — market {verb} hard. "
                          f"Check exposure across your book.")
            seen.add(key)
    if alerts:
        cid = sd.resolve_channel("risk-alerts")
        stamp = datetime.now(ET).strftime("%-I:%M %p ET")
        sd.post(cid, f"⚠️ MARKET SHOCK · {stamp}\n" + "\n".join(alerts))
    save(seen, today)
    print(f"[market-shock] {datetime.now(ET):%H:%M} vix={vix} spy%={spyp} alerts={len(alerts)}",
          flush=True)


if __name__ == "__main__":
    main()
