#!/usr/bin/env python3
"""cron_watchdog.py — dead-man for the Discord trading hub → #system-logs.

Pings if a key process (the slash-command bot or the flow scraper/relay) is down,
or if the scheduled-cron log goes stale during market hours (a sign crons stopped
firing). Deduped per issue per day. Cheap; run every 15 min.
"""
import json
import os
import shutil
import subprocess
import sys
import time
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state" / "cron_watchdog_seen.json"
LOG = Path.home() / "02_DATA" / "skillcron.log"
WATCH_PROCS = ["aime-discord", "option-relay", "option-signals"]


def _pm2_bin():
    p = shutil.which("pm2")
    if p:
        return p
    for c in (Path.home() / ".nvm", Path("/usr/local/bin/pm2"), Path("/usr/bin/pm2"),
              Path.home() / ".npm-global/bin/pm2"):
        if c.is_file():
            return str(c)
        if c.is_dir():
            hits = list(c.glob("versions/node/*/bin/pm2"))
            if hits:
                return str(hits[-1])
    return "pm2"


def pm2_status():
    try:
        out = subprocess.run([_pm2_bin(), "jlist"], capture_output=True, text=True, timeout=20).stdout
        return {p["name"]: p["pm2_env"]["status"] for p in json.loads(out)}
    except Exception:
        return None


def load():
    try:
        return set(json.loads(STATE.read_text()))
    except Exception:
        return set()


def save(seen, today):
    seen = {k for k in seen if k.endswith(today)}
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps(list(seen)))
    os.replace(tmp, STATE)


def main():
    now = datetime.now(ET)
    today = now.strftime("%Y%m%d")
    seen = load()
    alerts = []
    st = pm2_status()
    if st is not None:   # only judge procs if we could read pm2 at all
        for p in WATCH_PROCS:
            s = st.get(p)
            if s != "online":
                key = f"DOWN:{p}:{today}"
                if key not in seen:
                    alerts.append(f"🔴 **{p}** is {s or 'MISSING'} (expected online)")
                    seen.add(key)
    mkt = now.weekday() < 5 and ((now.hour, now.minute) >= (9, 30)) and now.hour < 16
    if mkt and LOG.exists():
        age = (time.time() - LOG.stat().st_mtime) / 60
        if age > 25:
            key = f"STALE:{today}:{now.hour}"
            if key not in seen:
                alerts.append(f"⚠️ scheduled-cron log stale {age:.0f}m during market hours "
                              f"— crons may not be firing")
                seen.add(key)
    if alerts:
        sd.post(sd.resolve_channel("system-logs"),
                f"🛰️ WATCHDOG · {now:%-I:%M %p ET}\n" + "\n".join(alerts))
    save(seen, today)
    print(f"[cron-watchdog] {now:%H:%M} procs={ {p: (st or {}).get(p) for p in WATCH_PROCS} } "
          f"alerts={len(alerts)}", flush=True)


if __name__ == "__main__":
    main()
