#!/usr/bin/env python3
"""
Oracle Cloud gateway + OpenClaw health check.
Run via cron every 15 minutes.
Posts to Discord ONLY on failure, or once/day at 8am ET as green all-clear.
"""
import json
import os
import socket
import subprocess
import sys
from datetime import datetime, date
from pathlib import Path
import urllib.request
import urllib.error

STATE_DIR = Path.home() / ".openclaw/state/watchdogs"
STATE_DIR.mkdir(parents=True, exist_ok=True)
LAST_OK_FILE = STATE_DIR / "gateway_last_ok.txt"
LAST_REPORT_FILE = STATE_DIR / "gateway_last_daily_report.txt"
WEBHOOK_FILE = Path.home() / ".openclaw/secrets/discord_dns_renewal_webhook"

def post_discord(content: str, mention_everyone: bool = False):
    if not WEBHOOK_FILE.exists():
        return
    url = WEBHOOK_FILE.read_text().strip()
    if not url:
        return
    payload = {
        "content": ("@everyone " + content) if mention_everyone else content,
        "allowed_mentions": {"parse": ["everyone"] if mention_everyone else []},
    }
    req = urllib.request.Request(url, data=json.dumps(payload).encode(),
                                 headers={
                                     "Content-Type": "application/json",
                                     "User-Agent": "MissionCtrl-Watchdog/1.0 (+https://missionctrl.serveftp.com)",
                                 })
    try:
        urllib.request.urlopen(req, timeout=10)
    except urllib.error.URLError:
        pass

def check_outbound_internet() -> tuple[bool, str]:
    try:
        r = urllib.request.urlopen("https://ifconfig.me", timeout=8)
        ip = r.read().decode().strip()
        return True, ip
    except Exception as e:
        return False, str(e)

def check_oracle_metadata() -> tuple[bool, dict | str]:
    """Oracle's instance metadata endpoint — 169.254.169.254 only reachable from the VM."""
    try:
        req = urllib.request.Request(
            "http://169.254.169.254/opc/v2/instance/",
            headers={"Authorization": "Bearer Oracle"},
        )
        r = urllib.request.urlopen(req, timeout=5)
        data = json.loads(r.read().decode())
        return True, {"state": data.get("lifecycleState"), "shape": data.get("shape")}
    except Exception as e:
        return False, str(e)

def check_pm2_mission_control() -> tuple[bool, str]:
    try:
        out = subprocess.check_output(["/home/ubuntu/.npm-global/bin/pm2", "jlist"], timeout=10, stderr=subprocess.DEVNULL)
        procs = json.loads(out)
        for p in procs:
            if p.get("name") == "mission-control":
                status = p.get("pm2_env", {}).get("status", "unknown")
                return status == "online", status
        return False, "mission-control PM2 process not found"
    except Exception as e:
        return False, str(e)

def main():
    internet_ok, ip_or_err = check_outbound_internet()
    oracle_ok, oracle_info = check_oracle_metadata()
    pm2_ok, pm2_status = check_pm2_mission_control()

    all_ok = internet_ok and oracle_ok and pm2_ok
    now = datetime.utcnow()

    if all_ok:
        LAST_OK_FILE.write_text(now.isoformat())
        # Once-daily all-clear at 8am ET (12:00 UTC during EST, 13:00 UTC during EDT — range check)
        last_report = LAST_REPORT_FILE.read_text().strip() if LAST_REPORT_FILE.exists() else ""
        today_str = date.today().isoformat()
        if 12 <= now.hour <= 13 and last_report != today_str:
            post_discord(
                f"✅ **Oracle/OpenClaw all-clear** — IP `{ip_or_err}` · state `{oracle_info.get('state')}` · "
                f"shape `{oracle_info.get('shape')}` · mission-control `{pm2_status}`"
            )
            LAST_REPORT_FILE.write_text(today_str)
        else:
            print("OK")
        return

    # Something failed
    lines = []
    if not internet_ok: lines.append(f"❌ Outbound internet: `{ip_or_err[:100]}`")
    if not oracle_ok:   lines.append(f"❌ Oracle metadata: `{str(oracle_info)[:100]}`")
    if not pm2_ok:      lines.append(f"❌ mission-control PM2: `{pm2_status}`")

    # Compute how long since last OK
    since = "unknown"
    if LAST_OK_FILE.exists():
        try:
            last = datetime.fromisoformat(LAST_OK_FILE.read_text().strip())
            mins = int((now - last).total_seconds() / 60)
            since = f"{mins} min" if mins < 60 else f"{mins // 60}h {mins % 60}m"
        except Exception:
            pass

    msg = f"🚨 **Oracle/OpenClaw health check FAILED** (last OK {since} ago)\n" + "\n".join(lines)
    mention = False  # keep the channel quiet; failures are visible enough on their own
    post_discord(msg)

if __name__ == "__main__":
    main()
