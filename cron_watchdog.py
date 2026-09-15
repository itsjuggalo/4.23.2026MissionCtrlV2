#!/usr/bin/env python3
"""cron_watchdog.py — dead-man for the Discord trading hub → system_health Telegram lane.

Pings if a key process (the slash-command bot or the flow scraper/relay) is down,
or if the scheduled-cron log goes stale during market hours (a sign crons stopped
firing). Cheap; run every 15 min.

Gated via lib/alert_gate.py (2026-09-15 telegram lane charter fix, replacing the old
per-day/per-hour homegrown dedup — that let a standing STALE-log condition re-alert
every hour, under the charter's 6h floor). Fingerprint = sorted set of current issue
ids; cooldown 6h.
"""
import argparse
import json
import shutil
import subprocess
import sys
import time
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.alert_gate import should_send, mark_sent  # noqa: E402

ET = ZoneInfo("America/New_York")
LOG = Path.home() / "02_DATA" / "skillcron.log"
WATCH_PROCS = ["aime-discord", "option-relay", "option-signals"]
ALERT_GATE_KEY = "cron_watchdog"
ALERT_REPEAT_AFTER = 6 * 3600


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


def main(dry_run: bool = False):
    now = datetime.now(ET)
    alerts = []      # human-readable lines for the message
    issue_ids = []    # stable ids (no timestamps/minutes) for the alert_gate fingerprint
    st = pm2_status()
    if st is not None:   # only judge procs if we could read pm2 at all
        for p in WATCH_PROCS:
            s = st.get(p)
            if s != "online":
                alerts.append(f"🔴 **{p}** is {s or 'MISSING'} (expected online)")
                issue_ids.append(f"DOWN:{p}")
    mkt = now.weekday() < 5 and ((now.hour, now.minute) >= (9, 30)) and now.hour < 16
    if mkt and LOG.exists():
        age = (time.time() - LOG.stat().st_mtime) / 60
        if age > 25:
            alerts.append(f"⚠️ scheduled-cron log stale {age:.0f}m during market hours "
                          f"— crons may not be firing")
            issue_ids.append("STALE:cron_log")
    if alerts:
        # Discord disabled 2026-06-16 (Mike: ops off Discord). These watch the LIVE
        # flow relay / trade cycles, so the alert is genuinely important — route it to
        # Telegram (system_health) instead of dropping it.
        _msg = f"🛰️ CRON WATCHDOG · {now:%-I:%M %p ET}\n" + "\n".join(alerts)
        fp = "|".join(sorted(issue_ids))
        ok, why = should_send(ALERT_GATE_KEY, fp, repeat_after=ALERT_REPEAT_AFTER)
        if dry_run:
            print(f"[cron-watchdog] DRY-RUN would-send={ok} ({why}) fp={fp}\n{_msg}", flush=True)
        elif not ok:
            print(f"[cron-watchdog] SUPPRESS ({why}) fp={fp}", flush=True)
        else:
            try:
                import sys as _sys
                _sys.path.insert(0, "/home/itsju/scripts")
                from lib.notify import tg_push
                if tg_push("⚠️ " + _msg, "system_health", loud=False, html=False,
                           fallback_token_file="telegram-ping-bot-token"):
                    mark_sent(ALERT_GATE_KEY, fp)
            except Exception as _e:
                print(f"[cron-watchdog] telegram alert failed: {_e}", flush=True)
    print(f"[cron-watchdog] {now:%H:%M} procs={ {p: (st or {}).get(p) for p in WATCH_PROCS} } "
          f"alerts={len(alerts)}", flush=True)


if __name__ == "__main__":
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true", help="print what would be sent, send nothing")
    a = ap.parse_args()
    main(dry_run=a.dry_run)
