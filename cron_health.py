#!/usr/bin/env python3
"""cron_health.py — silent-failure watchdog for Mission Control cron jobs.

Every finding in the 2026-06-04 ops audit had failed SILENTLY for days. This is the
generalized fix: ping Mike's PingPong Telegram when a critical job's log is STALE past its
expected cadence, or its recent tail shows a hard error. One ping per incident (latch),
auto-clears on recovery. Generalization of decipher_watchdog.py.

Cron: */30 * * * *  /usr/bin/python3 ~/05_AUTOMATION/scripts/cron_health.py
"""
import json
import re
import subprocess
import time
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

HOME = Path.home()
SEC = HOME / ".openclaw" / "secrets"
PING = HOME / "scripts" / "ping_mike.py"
LATCH = HOME / ".openclaw" / "cron_health_latches"
ALPACA = "https://paper-api.alpaca.markets/v2"
ERR = re.compile(r"Traceback|ModuleNotFoundError|ImportError|database is locked|"
                 r"OperationalError|NameError|No such file|name resolution|FAILED", re.I)
ERRSCAN_FRESH_MIN = 360   # only error-scan logs touched in the last 6h (ignore ancient errors)

# (name, log path, max_age_min | None, market_hours_only, error_scan)
JOBS = [
    ("decipher-manage",  HOME / "logs/decipher_manage.log",            15,   True,  True),
    ("decipher-main",    HOME / "logs/decipher.log",                   45,   True,  True),
    ("flow-ingest",      HOME / "logs/flow-ingest.log",                30,   False, True),
    ("refresh-holdings", HOME / "portfolio/refresh.log",               1500, False, True),
    ("flow-outcomes",    HOME / "logs/flow-outcomes.log",              None, False, True),
    ("equity-snapshot",  HOME / "scripts/audit/equity-snapshot.log",   None, False, True),
    ("sector-rotation",  HOME / "LapClaw/pipeline/logs/sector_rotation.log",  None, False, True),
    ("catalyst-scanner", HOME / "LapClaw/pipeline/logs/catalyst_scanner.log", None, False, True),
]


def market_open():
    try:
        h = {"APCA-API-KEY-ID": (SEC / "alpaca-boba-key-id").read_text().strip(),
             "APCA-API-SECRET-KEY": (SEC / "alpaca-boba-secret").read_text().strip()}
        r = json.load(urllib.request.urlopen(
            urllib.request.Request(f"{ALPACA}/clock", headers=h), timeout=10))
        return bool(r.get("is_open"))
    except Exception:
        return None   # unknown


def ping(msg):
    try:
        return subprocess.run(["python3", str(PING), msg], timeout=20).returncode == 0
    except Exception:
        return False


def main():
    LATCH.mkdir(parents=True, exist_ok=True)
    mo = market_open()
    now = time.time()
    for name, log, max_age, mh, errscan in JOBS:
        latch = LATCH / name
        problems = []
        if not log.exists():
            problems.append("log missing")
        else:
            age_min = (now - log.stat().st_mtime) / 60
            # Staleness — skip for market-hours jobs when the market isn't open.
            if max_age is not None and not (mh and mo is not True):
                if age_min > max_age:
                    problems.append(f"stale {age_min:.0f}m (>{max_age}m)")
            # Error scan — only on recently-active logs (avoid ancient tracebacks).
            if errscan and age_min <= ERRSCAN_FRESH_MIN:
                try:
                    tail = "\n".join(log.read_text(errors="ignore").splitlines()[-40:])
                    m = ERR.search(tail)
                    if m:
                        problems.append(f"recent error: {m.group(0)}")
                except Exception:
                    pass
        if problems:
            if not latch.exists():   # one ping per incident
                if ping(f"⚠️ CRON HEALTH — {name}: {'; '.join(problems)}"):
                    latch.write_text(datetime.now(timezone.utc).isoformat())
        else:
            latch.unlink(missing_ok=True)   # recovered → re-arm


if __name__ == "__main__":
    main()
