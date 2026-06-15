#!/home/itsju/.venv/bin/python
"""EOD wrap → LaptopClaude Telegram bot (16:08 ET weekdays).

ONE deterministic end-of-day buzz: account P&L + positions + what graded today +
graduation progress. Facts only, no LLM, no bloat. Honors the shared killswitch.
Cron: 8 16 * * 1-5.  Test: quantum_eod.py --dry-run
"""
import os, subprocess, sys
sys.path.insert(0, os.path.expanduser("~/scripts"))
import quantum_tg as Q

HALT = os.path.expanduser("~/.openclaw/quantum_HALT")
TG   = os.path.expanduser("~/bin/tg-send-msg")


def main():
    dry = "--dry-run" in sys.argv
    if os.path.exists(HALT) and not dry:
        return
    msg = Q.eod()
    if dry:
        print(msg)
        return
    try:
        subprocess.run([TG, msg], timeout=20)
    except Exception as e:
        print(f"[eod] send failed: {e}", file=sys.stderr)


if __name__ == "__main__":
    main()
