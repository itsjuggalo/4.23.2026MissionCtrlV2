#!/usr/bin/env python3
"""psych_card_daily.py — Telegram the card-of-the-day from the psych deck.

Same deterministic pick as the missionctrl Psych Cards page (year*372 +
month*31 + day, mod deck size) so the phone card and the dashboard card always
match. Cron: 8:30 ET every morning. Deck: ~/portfolio/psych_cards.json.
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path

DECK = Path.home() / "portfolio" / "psych_cards.json"
TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"
PAGE = "https://g59-wsl.taile1328b.ts.net:3000/?page=psych-cards"

LEAK_LABEL = {
    "sizing": "Sizing (F)", "chase": "Chasing (C)", "dead-bag": "Holding losers (C)",
    "early-exit": "Selling early (B)", "options": "Options (D)", "process": "Process",
}


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    args = ap.parse_args()

    cards = json.loads(DECK.read_text())["cards"]
    # ET calendar day (cron sets TZ, but be explicit so a manual run matches too)
    now = datetime.now(timezone.utc) - timedelta(hours=4)
    idx = (now.year * 372 + now.month * 31 + now.day) % len(cards)
    c = cards[idx]

    msg = (f"🃏 CARD OF THE DAY — {LEAK_LABEL.get(c['leak'], c['leak'])}\n"
           f"{c['title']}  ·  {c['source']}\n\n"
           f"“{c['quote']}”\n\n"
           f"{c['idea']}\n\n"
           f"📊 YOUR EVIDENCE: {c['evidence']}\n\n"
           f"🎯 THE DRILL: {c['drill']}\n\n"
           f"deck: {PAGE}")

    print(msg)
    if args.send:
        subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                       capture_output=True, timeout=30)
    return 0


if __name__ == "__main__":
    sys.exit(main())
