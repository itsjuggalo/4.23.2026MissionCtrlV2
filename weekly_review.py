#!/usr/bin/env python3
"""weekly_review.py — Friday performance review → #performance-weekly (cron)."""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import weekly_review  # noqa: E402


def main():
    sd.post(sd.resolve_channel("performance-weekly"), weekly_review())
    print("[weekly-review] posted to #performance-weekly", flush=True)


if __name__ == "__main__":
    main()
