#!/usr/bin/env python3
"""portfolio_to_discord.py — scheduled positions + P&L snapshot → #main-portfolios.

Deterministic Alpaca read (Boba + Jazzy), no LLM. Reuses skill_to_discord's
channel resolver + bot-token poster. Cron one-shot (morning + EOD).
"""
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import portfolio_summary  # noqa: E402


def main():
    text = portfolio_summary()
    stamp = datetime.now(ZoneInfo("America/New_York")).strftime("%a %b %-d %-I:%M %p ET")
    cid = sd.resolve_channel("main-portfolios")
    sd.post(cid, f"📸 SNAPSHOT · {stamp}\n{text}")
    print(f"[portfolio] posted snapshot to #main-portfolios @ {stamp}", flush=True)


if __name__ == "__main__":
    main()
