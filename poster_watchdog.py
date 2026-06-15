#!/usr/bin/env python3
"""poster_watchdog.py — dead-man check for the auto-posters. If a poster's heartbeat
goes stale inside its active window (cron silently failed: ARIES down, yfinance error,
key issue), ping #system-logs. Read-only. Cron every 20 min.
"""
from __future__ import annotations

import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.heartbeat import age_min, beat_epoch  # noqa: E402

ET = ZoneInfo("America/New_York")


def main():
    now = datetime.now(ET)
    h, weekday = now.hour, now.weekday() < 5
    stale = []

    def check_freq(name, max_age, lo, hi, wd_only=False):
        if wd_only and not weekday:
            return
        if not (lo <= h < hi):
            return
        a = age_min(name)
        if a is None:
            stale.append(f"**{name}** — never ran")
        elif a > max_age:
            stale.append(f"**{name}** — last ran {a:.0f}m ago (expected <{max_age}m)")

    def check_daily(name, sched_hour, wd_only=True):
        if wd_only and not weekday:
            return
        if h < sched_hour + 1:        # 1h grace after scheduled time
            return
        e = beat_epoch(name)
        if not e or datetime.fromtimestamp(e, ET).date() != now.date():
            stale.append(f"**{name}** — no run today (due ~{sched_hour}:05 ET)")

    # frequent posters (silent failure most likely / most impactful)
    check_freq("flow_picks", 110, 10, 16, wd_only=True)   # 9:50/11/12:30/2/3:20
    check_freq("crypto_holdings", 45, 8, 22)              # every 30m
    check_freq("crypto_spike", 18, 8, 22)                 # every 5m
    # paper decision cycles (boba/jazzy) — 9:45/11/12:30/2/3:30 weekdays, ~90m max gap
    check_freq("boba_cycle", 115, 10, 16, wd_only=True)
    check_freq("jazzy_cycle", 115, 10, 16, wd_only=True)
    # once-daily EOD
    check_daily("crypto_eod", 16)
    check_daily("eod_scorecard", 16)

    if stale:
        stamp = now.strftime("%-I:%M %p ET")
        msg = "🔧 **CRON HEALTH — poster(s) stale** · " + stamp + "\n" + "\n".join("• " + s for s in stale) + \
              "\n_Check ~/02_DATA/skillcron.log. Likely ARIES down, yfinance/Coinbase error, or a key issue._"
        sd.post(sd.resolve_channel("system-logs"), msg)
        print(f"[poster-watchdog] ALERT: {len(stale)} stale", flush=True)
    else:
        print("[poster-watchdog] all posters healthy", flush=True)


if __name__ == "__main__":
    main()
