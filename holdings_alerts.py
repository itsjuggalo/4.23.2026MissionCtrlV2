#!/usr/bin/env python3
"""holdings_alerts.py — proactive risk pings on YOUR book → #risk-alerts (cron).

Watches Boba+Jazzy positions for big intraday moves and the accounts for day
drawdown, and pings #risk-alerts. Dedupes per symbol/account per day so it never
spams. Earnings/level reminders deferred until a working calendar key (finnhub dead).
"""
import json
import os
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402  (reuse channel resolver + bot-token poster)
from lib.portfolio import _rd, _ACCTS, _acct_data  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state" / "holdings_alerts_seen.json"
MOVE_PCT = 5.0       # per-position intraday move that triggers a ping
DRAWDOWN_PCT = 3.0   # account day-drawdown that triggers a ping
PROFIT_TGT = 15.0    # since-entry gain → take-profit nudge (the exit hand-holding)
STOP_PCT = 10.0      # since-entry loss → cut nudge


def load_seen():
    try:
        return set(json.loads(STATE.read_text()))
    except Exception:
        return set()


def save_seen(seen, today):
    seen = {k for k in seen if k.endswith(today)}   # keep only today's keys (auto-resets daily)
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps(list(seen)))
    os.replace(tmp, STATE)


def main():
    today = datetime.now(ET).strftime("%Y%m%d")
    seen = load_seen()
    alerts = []
    for name, (kid, ksec) in zip(("BOBA", "JAZZY"), _ACCTS):
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acct, pos = _acct_data(k, s)
        except Exception:
            continue
        eq = float(acct.get("equity", 0) or 0)
        le = float(acct.get("last_equity", eq) or eq)
        dpct = ((eq - le) / le * 100) if le else 0.0
        dkey = f"{name}:DD:{today}"
        if dpct <= -DRAWDOWN_PCT and dkey not in seen:
            alerts.append(f"🚨 **{name} DRAWDOWN** {dpct:+.1f}% today — equity ${eq:,.0f}")
            seen.add(dkey)
        for p in pos:
            sym = p["symbol"]
            mv = float(p.get("market_value", 0) or 0)
            mpct = float(p.get("unrealized_intraday_plpc", 0) or 0) * 100
            mkey = f"{name}:{sym}:{today}"
            if abs(mpct) >= MOVE_PCT and mkey not in seen:
                emo = "🟢" if mpct >= 0 else "🔴"
                alerts.append(f"{emo} **{sym}** {mpct:+.1f}% today ({name}, ${mv:,.0f})")
                seen.add(mkey)
            # exit signals on since-entry P&L (take-profit / cut)
            tpct = float(p.get("unrealized_plpc", 0) or 0) * 100
            if tpct >= PROFIT_TGT and f"{name}:{sym}:TP:{today}" not in seen:
                alerts.append(f"🎯 **TAKE PROFITS — {sym}** +{tpct:.1f}% since entry "
                              f"({name}, ${mv:,.0f}). Consider trimming into strength.")
                seen.add(f"{name}:{sym}:TP:{today}")
            elif tpct <= -STOP_PCT and f"{name}:{sym}:SL:{today}" not in seen:
                alerts.append(f"🛑 **CUT — {sym}** {tpct:.1f}% since entry "
                              f"({name}, ${mv:,.0f}). Review the thesis / honor the stop.")
                seen.add(f"{name}:{sym}:SL:{today}")
    if alerts:
        cid = sd.resolve_channel("risk-alerts")
        stamp = datetime.now(ET).strftime("%-I:%M %p ET")
        sd.post(cid, f"⚠️ HOLDINGS ALERTS · {stamp}\n" + "\n".join(alerts))
    save_seen(seen, today)
    print(f"[holdings-alerts] {datetime.now(ET):%H:%M ET} alerts={len(alerts)}", flush=True)


if __name__ == "__main__":
    main()
