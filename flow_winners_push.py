#!/home/itsju/.venv/bin/python
"""flow_winners_push.py — scheduled push of the /winners board (today's app-pushed
flow + chase/skip verdicts). ANCHORED snapshots, not per-minute spam.

Complements flow_chase_guard.py: the guard fires real-time on single big screamers;
this posts the consolidated board a few times a day so Mike sees the whole picture.

Anti-bloat (Mike has ADD):
  • market-open only
  • skips an EMPTY board (nothing app-pushed yet → say nothing)
  • skips if the board is UNCHANGED since the last push (same contracts + tiers)
  • honors the shared killswitch ~/.openclaw/quantum_HALT

Cron (open-settle / midday / pre-close):
  45 9  * * 1-5  flow_winners_push.py
  30 12 * * 1-5  flow_winners_push.py
  30 15 * * 1-5  flow_winners_push.py
Test:  flow_winners_push.py --dry-run   (prints, never sends, ignores open/unchanged gates)
"""
import json
import os
import re
import subprocess
import sys
from datetime import datetime
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.expanduser("~/scripts"))
import flow_chase as FC
import quantum_tg as Q

ET = ZoneInfo("America/New_York")
STATE = os.path.expanduser("~/.openclaw/flow_winners_push_state.json")
HALT = os.path.expanduser("~/.openclaw/quantum_HALT")
TG = os.path.expanduser("~/bin/tg-send-msg")


def _sig(board):
    """Signature = tier-emoji + ticker+strike per line (ignores the wiggling move%)."""
    return re.findall(r"([🟢🟡🔴⏸]) \*([A-Z.]+ \$[0-9.]+[CP])\*", board)


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return  # killswitch
    if not Q._market_open() and not dry:
        print("flow-winners: market closed → silent")
        return
    board = FC.winners()
    if board.startswith("🔔 No big"):
        if dry:
            print("flow-winners: empty board → silent")
        return
    sig = _sig(board)
    try:
        last = json.load(open(STATE)).get("sig", [])
    except Exception:
        last = []
    if sig == last and not dry:
        return  # unchanged since last push — don't repeat the same board
    stamp = datetime.now(ET).strftime("%-I:%M%p ET").lower()
    msg = board.replace("🔔 *FLOW WINNERS — chase or skip*", f"🔔 *FLOW WINNERS · {stamp}*")
    if dry:
        print("WOULD PUSH:\n" + msg)
        return
    try:
        subprocess.run([TG, msg], timeout=20)
        json.dump({"sig": sig, "at": stamp}, open(STATE, "w"))
    except Exception as e:
        print(f"[flow-winners] send failed: {e}", file=sys.stderr)


if __name__ == "__main__":
    main()
