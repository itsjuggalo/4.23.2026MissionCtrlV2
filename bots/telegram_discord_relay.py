#!/usr/bin/env python3
"""
Telegram → Discord Brief Relay
Monitors JazzyHazzy's Telegram messages and routes briefs to Discord channels.
Zero tokens — pure keyword matching.
PM2: pm2 start bots/telegram_discord_relay.py --name telegram-discord-relay --interpreter python3
"""

import json
import os
import time
import requests
from pathlib import Path
from datetime import datetime

SECRETS_DIR = Path.home() / ".openclaw" / "secrets"
DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = DATA_DIR / "relay_last_id.json"

def get_secret(name):
    p = SECRETS_DIR / name
    return p.read_text().strip() if p.exists() else None

# JazzyHazzy's Telegram bot token (the one JazzyHazzy sends briefs through)
BOT_TOKEN = get_secret("telegram_jazzyhazzy_bot_token") or get_secret("telegram_bot_token")

# Discord webhooks per channel
WEBHOOKS = {
    "morning": get_secret("discord_morning_brief_webhook"),
    "midday": get_secret("discord_midday_brief_webhook"),
    "eod": get_secret("discord_eod_brief_webhook"),
    "afterhours": get_secret("discord_afterhours_brief_webhook"),
}

# Keyword routing rules (checked in order, first match wins)
ROUTES = [
    {
        "name": "morning",
        "keywords": ["morning", "premarket", "daily market brief", "pre-market", "market open", "good morning", "daily brief"],
        "color": 0x4FC3F7,
        "title_prefix": "Morning Brief",
    },
    {
        "name": "midday",
        "keywords": ["midday", "mid-day", "lunch", "noon", "1pm", "midday brief"],
        "color": 0xFF9800,
        "title_prefix": "Midday Brief",
    },
    {
        "name": "eod",
        "keywords": ["eod", "end of day", "closing", "market close", "close brief", "4pm", "daily win rate"],
        "color": 0x66BB6A,
        "title_prefix": "EOD Brief",
    },
    {
        "name": "afterhours",
        "keywords": ["after hours", "afterhours", "nightly", "overnight", "after-hours", "night brief", "8:30 pm", "evening"],
        "color": 0xCE93D8,
        "title_prefix": "After Hours Brief",
    },
]


def load_last_id():
    try:
        return json.loads(STATE_FILE.read_text()).get("last_update_id", 0)
    except:
        return 0


def save_last_id(update_id):
    STATE_FILE.write_text(json.dumps({"last_update_id": update_id}))


def classify_message(text):
    """Determine which brief channel a message belongs to."""
    lower = text.lower()
    for route in ROUTES:
        if any(kw in lower for kw in route["keywords"]):
            return route
    return None


def send_to_discord(webhook_url, route, message_text, timestamp):
    """Send formatted embed to Discord webhook."""
    if not webhook_url:
        print(f"  [relay] No webhook for {route['name']}, skipping")
        return False

    # Truncate if needed (Discord embed limit is 4096)
    if len(message_text) > 4000:
        message_text = message_text[:4000] + "\n\n... (truncated)"

    payload = {
        "embeds": [{
            "title": f"{route['title_prefix']}",
            "description": message_text,
            "color": route["color"],
            "footer": {
                "text": f"Mission Control • {timestamp}"
            },
            "timestamp": datetime.utcnow().isoformat()
        }],
        "username": "JazzyHazzy",
    }

    try:
        r = requests.post(webhook_url, json=payload, timeout=10)
        if r.status_code in (200, 204):
            print(f"  [relay] Sent to #{route['name']} ({len(message_text)} chars)")
            return True
        else:
            print(f"  [relay] Discord error {r.status_code}: {r.text[:100]}")
            return False
    except Exception as ex:
        print(f"  [relay] Discord send error: {ex}")
        return False


def poll_telegram():
    """Long-poll Telegram for new messages."""
    if not BOT_TOKEN:
        print("[relay] ERROR: No Telegram bot token found")
        print("[relay] Set telegram_jazzyhazzy_bot_token in ~/.openclaw/secrets/")
        return

    missing = [k for k, v in WEBHOOKS.items() if not v]
    if missing:
        print(f"[relay] WARNING: Missing webhooks for: {', '.join(missing)}")
        print(f"[relay] Set discord_{{name}}_brief_webhook in ~/.openclaw/secrets/")

    last_id = load_last_id()
    print(f"[relay] Starting relay (last_id: {last_id})")
    print(f"[relay] Webhooks configured: {', '.join(k for k, v in WEBHOOKS.items() if v)}")
    print(f"[relay] Polling Telegram...\n")

    base_url = f"https://api.telegram.org/bot{BOT_TOKEN}"
    consecutive_errors = 0

    while True:
        try:
            params = {"offset": last_id + 1, "timeout": 30}
            r = requests.get(f"{base_url}/getUpdates", params=params, timeout=35)

            if r.status_code != 200:
                print(f"[relay] Telegram API error: {r.status_code}")
                consecutive_errors += 1
                time.sleep(min(30, 5 * consecutive_errors))
                continue

            data = r.json()
            if not data.get("ok"):
                print(f"[relay] Telegram response not ok: {data}")
                time.sleep(10)
                continue

            consecutive_errors = 0

            for update in data.get("result", []):
                update_id = update.get("update_id", 0)
                last_id = max(last_id, update_id)

                msg = update.get("message") or update.get("channel_post") or {}
                text = msg.get("text", "")
                if not text:
                    continue

                chat = msg.get("chat", {})
                ts = datetime.fromtimestamp(msg.get("date", time.time())).strftime("%Y-%m-%d %I:%M %p")

                print(f"[relay] New message from {chat.get('title', chat.get('username', 'unknown'))} at {ts}")
                print(f"  Preview: {text[:80]}...")

                route = classify_message(text)
                if route:
                    webhook = WEBHOOKS.get(route["name"])
                    send_to_discord(webhook, route, text, ts)
                else:
                    print(f"  [relay] No keyword match — not forwarded")

                save_last_id(last_id)

        except requests.exceptions.Timeout:
            continue
        except KeyboardInterrupt:
            print("\n[relay] Shutting down")
            save_last_id(last_id)
            break
        except Exception as ex:
            print(f"[relay] Error: {ex}")
            consecutive_errors += 1
            time.sleep(min(30, 5 * consecutive_errors))


if __name__ == "__main__":
    poll_telegram()
