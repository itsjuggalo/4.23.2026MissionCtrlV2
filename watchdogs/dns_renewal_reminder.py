#!/usr/bin/env python3
"""
DNS renewal reminder for missionctrl.serveftp.com (serveftp.com requires renewal every 30 days).
Run via cron twice a week. Posts to Discord with countdown.

Mike updates the "last renewed" date by running:
  echo "$(date -u +%Y-%m-%d)" > ~/.openclaw/state/watchdogs/dns_last_renewed.txt
"""
import json
import os
import sys
from datetime import datetime, date
from pathlib import Path
import urllib.request
import urllib.error

STATE_FILE = Path.home() / ".openclaw/state/watchdogs/dns_last_renewed.txt"
WEBHOOK_FILE = Path.home() / ".openclaw/secrets/discord_dns_renewal_webhook"
RENEWAL_DAYS = 30

def post_discord(content: str, mention_everyone: bool = False):
    if not WEBHOOK_FILE.exists():
        print("No webhook configured", file=sys.stderr)
        return
    url = WEBHOOK_FILE.read_text().strip()
    if not url:
        return
    payload = {
        "content": ("@everyone " + content) if mention_everyone else content,
        "allowed_mentions": {"parse": ["everyone"] if mention_everyone else []},
    }
    req = urllib.request.Request(
        url,
        data=json.dumps(payload).encode(),
        headers={
            "Content-Type": "application/json",
            "User-Agent": "MissionCtrl-Watchdog/1.0 (+https://missionctrl.serveftp.com)",
        },
    )
    try:
        urllib.request.urlopen(req, timeout=10)
    except urllib.error.URLError as e:
        print(f"Discord post failed: {e}", file=sys.stderr)

def main():
    if not STATE_FILE.exists():
        # First run — initialize with today
        STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
        STATE_FILE.write_text(date.today().isoformat())
        post_discord("🔧 **DNS Watchdog initialized** — today set as last-renewed date for `missionctrl.serveftp.com`. Update with `echo \"$(date -u +%Y-%m-%d)\" > ~/.openclaw/state/watchdogs/dns_last_renewed.txt` after each renewal.")
        return

    last = date.fromisoformat(STATE_FILE.read_text().strip())
    days_since = (date.today() - last).days
    days_left = RENEWAL_DAYS - days_since

    if days_left <= 0:
        post_discord(
            f"🚨 **DNS EXPIRED** — `missionctrl.serveftp.com` last renewed {days_since} days ago (limit: {RENEWAL_DAYS}d).\n"
            f"Renew at https://www.noip.com/ or https://www.serveftp.com then run:\n"
            f"```\necho \"$(date -u +%Y-%m-%d)\" > ~/.openclaw/state/watchdogs/dns_last_renewed.txt\n```",
            
        )
    elif days_left <= 5:
        post_discord(
            f"⚠️ **DNS renewal due in {days_left} days** — `missionctrl.serveftp.com` (last renewed {last.isoformat()}).\n"
            f"Renew at your serveftp.com control panel now to avoid another `DNS_PROBE_FINISHED_NXDOMAIN` outage.",
            
        )
    elif days_left <= 10:
        post_discord(
            f"📅 DNS renewal reminder: **{days_left} days left** for `missionctrl.serveftp.com` (last renewed {last.isoformat()})."
        )
    else:
        # Quiet — don't spam Discord when there's plenty of runway
        print(f"DNS OK: {days_left}d left")

if __name__ == "__main__":
    main()
