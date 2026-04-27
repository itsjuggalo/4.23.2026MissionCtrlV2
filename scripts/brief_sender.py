#!/usr/bin/env python3
"""Mission Control Brief Sender — Fetches data then sends to Discord"""
import json, os, sys, subprocess
from datetime import datetime, timezone, timedelta
try:
    import requests
except:
    subprocess.check_call([sys.executable,'-m','pip','install','requests','--break-system-packages','-q'])
    import requests

SECRETS = '/home/ubuntu/.openclaw/secrets'
DATA_FILE = '/home/ubuntu/.openclaw/workspace/directives/pre_brief_data.md'

def read_secret(n):
    try: return open(f'{SECRETS}/{n}').read().strip()
    except: return ''

def get_edt_now():
    return datetime.now(timezone.utc) - timedelta(hours=4)

def send(brief_type):
    now = get_edt_now()
    ts = now.strftime('%I:%M %p')
    ds = now.strftime('%A, %B %d, %Y')
    is_wknd = now.weekday() >= 5

    try: data = open(DATA_FILE).read()
    except: data = 'No data available'

    webhook_map = {
        'overnight': 'discord-webhook-nightly-brief.txt',
        'premarket': 'discord-webhook-morning-brief.txt',
        'morning': 'discord-webhook-morning-brief.txt',
        'midday': 'discord-webhook-midday-brief.txt',
        'closing': 'discord-webhook-eod-brief.txt',
        'evening': 'discord-webhook-nightly-brief.txt',
    }

    emoji_map = {'overnight':'🌙','premarket':'🟡','morning':'🌞','midday':'☀️','closing':'🔔','evening':'🌙'}

    webhook_url = read_secret(webhook_map.get(brief_type, 'discord-webhook-morning-brief.txt'))
    if not webhook_url:
        for alt in ['discord_morning_brief_webhook','discord_midday_brief_webhook','discord_eod_brief_webhook','discord_afterhours_brief_webhook']:
            webhook_url = read_secret(alt)
            if webhook_url: break

    if not webhook_url:
        print(f"ERROR: No webhook for {brief_type}")
        return False

    emoji = emoji_map.get(brief_type, '📋')
    ctx = "WEEKEND — NYSE/LSE closed. Crypto + after-hours movers." if is_wknd else "WEEKDAY"
    header = f"{emoji} **{brief_type.upper()} BRIEF** — {ds} — {ts} EDT\n{ctx}\n\n"
    msg = header + data[:1800]

    try:
        r = requests.post(webhook_url, json={'content': msg}, timeout=10)
        print(f"Discord {brief_type}: {r.status_code}")
        return r.status_code in [200, 204]
    except Exception as e:
        print(f"Error: {e}")
        return False

if __name__ == '__main__':
    bt = sys.argv[1] if len(sys.argv) > 1 else 'morning'
    print(f"=== {bt.upper()} BRIEF ===")
    subprocess.run([sys.executable, '/home/ubuntu/scripts/brief_data_fetcher.py', bt])
    send(bt)
