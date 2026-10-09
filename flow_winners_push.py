#!/home/itsju/.venv/bin/python
"""flow_winners_push.py — scheduled push of the /winners board (today's app-pushed
flow + chase/skip verdicts). ANCHORED snapshots, not per-minute spam.

Complements flow_chase_guard.py: the guard fires real-time on single big screamers;
this posts the consolidated board a few times a day so Mike sees the whole picture.

Anti-bloat (Mike has ADD):
  • market-open only
  • skips an EMPTY board (nothing app-pushed yet → say nothing)
  • skips if the contract set is unchanged (re-shows a contract only on tier change or a ≥25-pt move)
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
TG_FLEET = os.path.expanduser("~/scripts/tg_fleet.py")

# 2026-09-15 format sweep: winners() now renders HTML via tg_format (row() wraps the
# ticker in <b>...</b> and spells out CALL/PUT, not a Markdown *...*[CP] shorthand).
# The OLD pattern (`\*([A-Z.]+ \$[0-9.]+[CP])\*`) never actually matched this board's
# real "SYM $STRIKE CALL/PUT" text (verified: re.findall on a live board line returned
# [] against the pre-sweep source too) — so `sig == last` was always [] == [] and this
# push silently never detected a changed board. Fixed for real this time; test below.
_SIG_RE = re.compile(r"([🟢🟡🔴⏸]) <b>([A-Z.]+ \$[0-9.]+ (?:CALL|PUT))</b>")


def _sig(board):
    """Signature = tier-emoji + ticker+strike+type per line (ignores the wiggling move%)."""
    return _SIG_RE.findall(board)


def _changed(items, last):
    """Re-show only when a contract is new, changed tier (emoji), or moved >=25 pts since it was
    last shown (audit F4: 13 near-identical sends/day, same 4 contracts)."""
    for k, it in items.items():
        old = last.get(k)
        if old is None or old.get("emoji") != it.get("emoji"):
            return True
        m0, m1 = old.get("move"), it.get("move")
        if m0 is None or m1 is None:
            if m0 != m1:
                return True
        elif abs(m1 - m0) >= 25:
            return True
    return False


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return  # killswitch
    if not Q._market_open() and not dry:
        print("flow-winners: market closed → silent")
        return
    board, items = FC._winners_build()
    if board.startswith("🔔 No big"):
        if dry:
            print("flow-winners: empty board → silent")
        return
    today = datetime.now(ET).strftime("%Y-%m-%d")
    try:
        st = json.load(open(STATE))
    except Exception:
        st = {}
    last = st.get("shown", {}) if st.get("date") == today else {}
    if not _changed(items, last) and not dry:
        return  # same contracts, same tiers, no big move — don't repeat the board
    stamp = datetime.now(ET).strftime("%-I:%M%p ET").lower()
    msg = board  # winners()'s own hdr() already stamps the current ET time in the header
    if dry:
        print("WOULD PUSH:\n" + msg)
        return
    try:
        subprocess.run([sys.executable, TG_FLEET, "sendhtml", "trading_command", msg], timeout=20)
        merged = dict(last)
        merged.update(items)   # baseline = what was last SHOWN, so drift accumulates
        json.dump({"date": today, "shown": merged, "at": stamp}, open(STATE, "w"))
    except Exception as e:
        print(f"[flow-winners] send failed: {e}", file=sys.stderr)


if __name__ == "__main__":
    main()
