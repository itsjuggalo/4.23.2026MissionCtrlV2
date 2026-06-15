#!/usr/bin/env python3
"""journal_recap.py — EOD trade-journal recap → #trade-reviews (cron, after journal_sync)."""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import daily_journal_recap  # noqa: E402


def main():
    sd.post(sd.resolve_channel("trade-reviews"), daily_journal_recap())
    print("[journal-recap] posted to #trade-reviews", flush=True)


if __name__ == "__main__":
    main()
