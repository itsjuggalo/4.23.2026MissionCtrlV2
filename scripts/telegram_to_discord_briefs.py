#!/usr/bin/env python3
"""
telegram_to_discord_briefs.py
Reads Telegram bot conversation history, identifies briefs by their first line,
and forwards each one to the correct Discord webhook channel.
Run once to backfill, then add to cron for ongoing mirroring.
"""

import requests
import json
import time
import os

SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"

def load_secret(name):
    path = os.path.join(SECRETS_DIR, name)
    if os.path.exists(path):
        with open(path) as f:
            return f.read().strip()
    return None

TG_TOKEN = load_secret("telegram-bot-token.txt")
TG_CHAT_ID = "7888676328"

# Webhook URLs from your existing secrets files
WEBHOOKS = {
    "morning": load_secret("discord_morning_brief_webhook"),
    "midday": load_secret("discord_midday_brief_webhook"),
    "eod": load_secret("discord_eod_brief_webhook"),
    "nightly": load_secret("discord_afterhours_brief_webhook"),
    "premarket": load_secret("discord_afterhours_brief_webhook"),
    "portfolio": load_secret("discord_midday_brief_webhook"),
}

# Match brief type based on first 300 chars of message
BRIEF_PATTERNS = [
    {"keywords": ["premarket", "4am", "4:00 am", "premarket snapshot"], "type": "premarket"},
    {"keywords": ["morning brief", "daily market brief", "good morning", "market pulse", "today's trade setups"], "type": "morning"},
    {"keywords": ["midday", "mid-day", "midday brief", "midday verdict", "trade follow-up"], "type": "midday"},
    {"keywords": ["eod", "end of day", "eod brief", "closing bell", "portfolio final", "trade scorecard"], "type": "eod"},
    {"keywords": ["nightly", "overnight", "nightly brief", "overnight snapshot", "tomorrow watch"], "type": "nightly"},
    {"keywords": ["portfolio balance", "portfolio check", "account value", "portfolio update"], "type": "portfolio"},
    {"keywords": ["market alert", "vix spike", "volatility surge", "risk alert"], "type": "morning"},
    {"keywords": ["win rate", "win/loss", "weekly win rate"], "type": "eod"},
    {"keywords": ["calendar research", "earnings this week", "economic calendar"], "type": "morning"},
]

SENT_IDS_FILE = "/home/ubuntu/.openclaw/workspace/briefs_sent_to_discord.json"


def load_sent_ids():
    if os.path.exists(SENT_IDS_FILE):
        with open(SENT_IDS_FILE) as f:
            return set(json.load(f))
    return set()


def save_sent_ids(sent_ids):
    with open(SENT_IDS_FILE, "w") as f:
        json.dump(list(sent_ids), f)


def get_telegram_messages():
    messages = []
    url = f"https://api.telegram.org/bot{TG_TOKEN}/getUpdates"
    params = {"offset": 0, "limit": 100}

    while True:
        resp = requests.get(url, params=params)
        data = resp.json()

        if not data.get("ok") or not data.get("result"):
            break

        for update in data["result"]:
            msg = update.get("message") or update.get("channel_post") or {}
            text = msg.get("text", "")
            msg_id = msg.get("message_id", 0)
            msg_date = msg.get("date", 0)
            from_bot = msg.get("from", {}).get("is_bot", False)
            chat_id = str(msg.get("chat", {}).get("id", ""))

            if text and from_bot and chat_id == TG_CHAT_ID:
                messages.append({
                    "id": msg_id,
                    "date": msg_date,
                    "text": text,
                })

            params["offset"] = update["update_id"] + 1

        if len(data["result"]) < 100:
            break

    return messages


def identify_brief_type(text):
    header = text[:300].lower()
    for pattern in BRIEF_PATTERNS:
        for keyword in pattern["keywords"]:
            if keyword.lower() in header:
                return pattern["type"]
    return None


def send_to_discord(webhook_url, text, brief_type):
    if not webhook_url:
        print(f"  No webhook URL for {brief_type}")
        return False

    chunks = []
    while text:
        if len(text) <= 1990:
            chunks.append(text)
            break
        split_at = text[:1990].rfind('\n')
        if split_at == -1:
            split_at = 1990
        chunks.append(text[:split_at])
        text = text[split_at:].lstrip('\n')

    for i, chunk in enumerate(chunks):
        payload = {
            "content": chunk,
            "username": f"{brief_type.title()} Brief",
        }
        resp = requests.post(webhook_url, json=payload)
        if resp.status_code not in (200, 204):
            print(f"  Discord error {resp.status_code}: {resp.text[:100]}")
            return False
        if i < len(chunks) - 1:
            time.sleep(1)

    return True


def main():
    if not TG_TOKEN:
        print("No Telegram bot token found")
        return

    print("Webhook status:")
    for name, url in WEBHOOKS.items():
        status = "OK" if url else "MISSING"
        print(f"  {name}: {status}")

    print("\nFetching Telegram messages...")
    messages = get_telegram_messages()
    print(f"  Found {len(messages)} bot messages")

    sent_ids = load_sent_ids()
    briefs_found = 0
    briefs_sent = 0

    for msg in messages:
        msg_id = str(msg["id"])

        if msg_id in sent_ids:
            continue

        brief_type = identify_brief_type(msg["text"])
        if not brief_type:
            continue

        briefs_found += 1
        timestamp = time.strftime('%Y-%m-%d %H:%M', time.localtime(msg["date"]))
        print(f"\nFound {brief_type} brief from {timestamp}")
        print(f"  Preview: {msg['text'][:80]}...")

        webhook_url = WEBHOOKS.get(brief_type)

        if webhook_url:
            success = send_to_discord(webhook_url, msg["text"], brief_type)
            if success:
                sent_ids.add(msg_id)
                briefs_sent += 1
                print(f"  Sent to Discord #{brief_type}")
            else:
                print(f"  Failed to send")
        else:
            print(f"  No webhook for '{brief_type}'")

    save_sent_ids(sent_ids)
    print(f"\n{'='*40}")
    print(f"Briefs found: {briefs_found}")
    print(f"Briefs sent:  {briefs_sent}")
    print(f"Already sent: {len(sent_ids)}")


if __name__ == "__main__":
    main()
