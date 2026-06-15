#!/home/itsju/.venv/bin/python
"""flow_chase_guard.py — mirror the FlowGreeks app's FCM pushes to Telegram, but add
the ONE thing the app never gives you: a JUMP-IN / STAY-OUT verdict (live option
price vs the price the flow alerted at).

Fires ONLY when ALL hold (anti-bloat — Mike has ADD):
  • NotifyAlert == 1     (the app actually pushed this one)
  • totalFlowValue ≥ $1.5M
  • alert is FRESH (updated within ~8 min — a chase decision is time-critical)
  • market is open
Deduped per contract/day · per-run cap 3 · per-day cap 12. If nothing new+big+fresh,
it says nothing. Shares the trading killswitch: touch ~/.openclaw/quantum_HALT.

Cron (fast — chase windows are minutes, not 20-min cycles):
  */3 9-16 * * 1-5  flow_chase_guard.py >> ~/logs/flow_chase.log 2>&1
Test:  flow_chase_guard.py --dry-run   (prints, never sends, ignores open/fresh gates)
"""
import json
import os
import subprocess
import sys
from datetime import datetime
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.expanduser("~/scripts"))
import flow_chase as FC

ET = ZoneInfo("America/New_York")
STATE = os.path.expanduser("~/.openclaw/flow_chase_state.json")
HALT = os.path.expanduser("~/.openclaw/quantum_HALT")
TG = os.path.expanduser("~/bin/tg-send-msg")
PER_RUN = 3
PER_DAY = 12


def _state():
    try:
        s = json.load(open(STATE))
    except Exception:
        s = {}
    today = datetime.now(ET).strftime("%Y-%m-%d")
    if s.get("date") != today:
        s = {"date": today}
    s.setdefault("sent", [])
    return s


def _save(s):
    try:
        json.dump(s, open(STATE, "w"))
    except Exception as e:
        print(f"[flow-chase] state save failed: {e}", file=sys.stderr)


def _send(msg):
    subprocess.run([TG, msg], timeout=20)


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return  # killswitch
    s = _state()
    if len(s["sent"]) >= PER_DAY and not dry:
        return  # daily cap reached — stay quiet
    hits = FC.scan_pushed(require_open=not dry, fresh_min=(1e9 if dry else 8))
    sent = 0
    for occ, a, v in hits:
        if occ in s["sent"] and not dry:
            continue
        msg = FC.format_alert(a, v)
        if dry:
            print("WOULD SEND:\n" + msg + "\n")
            sent += 1
        else:
            try:
                _send(msg)
                s["sent"].append(occ)
                sent += 1
            except Exception as e:
                print(f"[flow-chase] send failed: {e}", file=sys.stderr)
        if sent >= PER_RUN:
            break
    if not dry and sent:
        _save(s)
    if dry and not sent:
        print("flow-chase: nothing app-pushed + ≥$1.5M + fresh → silent")


if __name__ == "__main__":
    main()
