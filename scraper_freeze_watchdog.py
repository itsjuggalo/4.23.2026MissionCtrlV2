#!/usr/bin/env python3
"""scraper_freeze_watchdog.py — auto-revive option-signals if its flow feed freezes.

The scraper (PM2 option-signals) can hang inside its loop (e.g. a stuck request with no
socket timeout) while PM2 still reports it 'online' — so PM2 never restarts it and
flow2_alerts_today.json goes stale, blinding the whole flow cockpit. This happened
2026-06-15 at the open. This watchdog watches the FEED's freshness (not the process) and
force-restarts the scraper when the data stalls.

flow2_alerts_today writes every ~5 min (its endpoint interval), so a stall = the file's
mtime older than FREEZE_MIN during market hours. A cooldown prevents restart storms, and a
post-open grace lets the daily file-rollover settle.

Cron:  */3 9-16 * * 1-5  scraper_freeze_watchdog.py >> ~/logs/scraper_watchdog.log 2>&1
Test:  scraper_freeze_watchdog.py --check   (prints freshness verdict, never restarts)
"""
import glob
import json
import os
import subprocess
import sys
import time
from datetime import datetime
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
FEED = os.path.expanduser("~/trading/signals/option-scraper/data/flow2_alerts_today.json")
STATE = os.path.expanduser("~/.openclaw/scraper_watchdog_state.json")
TG = os.path.expanduser("~/bin/tg-send-msg")
PROC = "option-signals"
FREEZE_MIN = 12.0     # flow2 writes ~every 5 min; >12 min stale during hours = hung
COOLDOWN_MIN = 10.0   # never restart more than once per 10 min
OPEN_GRACE_MIN = 4    # minutes after 9:30 to let the daily rollover settle


def _now():
    return datetime.now(ET)


def _market_open(now):
    if now.weekday() >= 5:
        return False
    t = now.hour * 60 + now.minute
    return 9 * 60 + 30 <= t <= 16 * 60 + 5


def _age_min():
    try:
        return (time.time() - os.path.getmtime(FEED)) / 60.0
    except Exception:
        return 1e9


def _pm2():
    for c in glob.glob(os.path.expanduser("~/.nvm/versions/node/*/bin/pm2")):
        return c
    return "pm2"


def _state():
    try:
        return json.load(open(STATE))
    except Exception:
        return {}


def _save(s):
    try:
        json.dump(s, open(STATE, "w"))
    except Exception:
        pass


def _log(m):
    print(f"{_now():%Y-%m-%d %H:%M:%S} {m}", flush=True)


def main():
    check = "--check" in sys.argv
    now = _now()
    if not _market_open(now) and not check:
        return
    if now.hour == 9 and now.minute < 30 + OPEN_GRACE_MIN and not check:
        _log("post-open grace — skip")
        return
    age = _age_min()
    if age <= FREEZE_MIN:
        _log(f"ok — flow2 {age:.1f}m old")
        return
    if check:
        _log(f"WOULD RESTART — flow2 {age:.1f}m stale (> {FREEZE_MIN:.0f}m)")
        return
    s = _state()
    if time.time() - s.get("last_restart", 0) < COOLDOWN_MIN * 60:
        _log(f"FROZEN ({age:.1f}m) but within cooldown — skip")
        return
    _log(f"FROZEN: flow2 {age:.1f}m stale → restarting {PROC}")
    try:
        subprocess.run([_pm2(), "restart", PROC], timeout=40, capture_output=True)
    except Exception as e:
        _log(f"pm2 restart failed: {e}")
        return
    s["last_restart"] = time.time()
    _save(s)
    try:
        subprocess.run([TG, f"⚙️ Auto-revived the flow scraper — feed was {age:.0f}min "
                            f"stale (option-signals hung). Flow alerts resuming."], timeout=20)
    except Exception:
        pass


if __name__ == "__main__":
    main()
