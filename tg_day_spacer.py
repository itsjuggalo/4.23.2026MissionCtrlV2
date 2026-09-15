#!/usr/bin/env python3
"""tg_day_spacer.py — one silent day-divider per Telegram lane at 11:59 PM ET.

Why: the lanes are a continuous scroll. Opening Trading Command in the morning, there is
nothing that says where yesterday ended and today began — so a 4 PM card and an 8 AM card
look like the same conversation. This drops a dated ruler in each lane at the end of the
day, so the first thing above the fold tomorrow is "everything below this is today."

ALWAYS SILENT (disable_notification) — a divider must never buzz Mike's phone at midnight.

  python3 tg_day_spacer.py            # send to every lane in LANES
  python3 tg_day_spacer.py --dry      # print what would be sent, send nothing
  python3 tg_day_spacer.py --lanes trading_command,flow_signals

Cron: 59 23 * * *
"""
from __future__ import annotations

import argparse
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.notify import tg_push  # noqa: E402

ET = ZoneInfo("America/New_York")

# The lanes Mike actually reads. Deliberately NOT every entry in tg_fleet.FLEET — the relay
# and one-shot bots would just get a ruler nobody sees.
# system_health dropped 2026-09-15 (telegram lane charter): that lane is restricted to
# DEAD/heal-failed/cron-failure/BLIND alerts only — a daily divider is routine furniture,
# not a failure, so it doesn't belong there even silent. See tg_fleet.FLEET["system_health"].
LANES = [
    "trading_command",   # what do I do right now
    "flow_signals",      # positions I'm already in
    "flow_digest",       # the 30-min digest + BEST-3
    "research_desk",     # Trading Lab (the learning lane)
    "life_wellness",     # life + important mail
]

# 🚨 @ResearchDaMoney_Bot is Mike's MASSAGE BUSINESS chat with real clients in it. It is not
# a fleet lane and must never receive automation. Hard block by token, not by name, because
# the fleet registry has pointed the wrong function at this bot before (see memory
# reference_telegram_lane_routing). Belt-and-braces: it isn't in LANES either.
FORBIDDEN_BOTS = {"ResearchDaMoney_Bot"}


def divider(now: datetime) -> str:
    """The ruler itself. Dated, so scrolling back tells you WHICH day you're in."""
    return (f"────────────────\n"
            f"📅 <b>{now:%a %b %-d}</b> ends here\n"
            f"────────────────")


def _bot_username(fn: str) -> str | None:
    """Resolve the lane to its live @username so we can refuse to post into the massage chat."""
    try:
        import json
        import urllib.request
        from lib.notify import _vault_token
        tok = _vault_token(fn)
        if not tok:
            return None
        with urllib.request.urlopen(
                f"https://api.telegram.org/bot{tok}/getMe", timeout=10) as r:
            return json.load(r).get("result", {}).get("username")
    except Exception:
        return None


def main() -> int:
    ap = argparse.ArgumentParser(description="Send a dated day-divider to each Telegram lane.")
    ap.add_argument("--dry", action="store_true", help="print only, send nothing")
    ap.add_argument("--lanes", help="comma-separated lane override")
    a = ap.parse_args()

    lanes = [s.strip() for s in a.lanes.split(",")] if a.lanes else LANES
    now = datetime.now(ET)
    msg = divider(now)

    if a.dry:
        print(f"would send to {len(lanes)} lane(s) at {now:%Y-%m-%d %H:%M ET}:\n{msg}")
        for fn in lanes:
            print(f"  {fn:16} → @{_bot_username(fn) or '?'}")
        return 0

    sent, skipped = [], []
    for fn in lanes:
        user = _bot_username(fn)
        if user in FORBIDDEN_BOTS:
            skipped.append(f"{fn} (@{user} is the massage chat — refused)")
            continue
        # silent: a divider is furniture, not news
        if tg_push(msg, fn, loud=False, html=True):
            sent.append(fn)
        else:
            skipped.append(f"{fn} (no live token / send failed)")

    print(f"[spacer] {now:%Y-%m-%d %H:%M ET} — sent {len(sent)}: {', '.join(sent) or 'none'}")
    if skipped:
        print(f"[spacer] skipped: {'; '.join(skipped)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
