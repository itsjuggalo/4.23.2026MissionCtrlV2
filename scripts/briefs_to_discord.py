#!/usr/bin/env python3
"""
briefs_to_discord.py
Reads saved brief files from ~/.openclaw/workspace/memory/
and posts each one to the correct Discord webhook channel.
Tracks what's been sent so it never double-posts.
Run once to backfill history, then cron for ongoing.
"""

import requests
import json
import time
import os
import glob

SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"
MEMORY_DIR = "/home/ubuntu/.openclaw/workspace/memory"
SENT_FILE = "/home/ubuntu/.openclaw/workspace/briefs_sent_to_discord.json"


def load_secret(name):
    path = os.path.join(SECRETS_DIR, name)
    if os.path.exists(path):
        with open(path) as f:
            return f.read().strip()
    return None


# Webhook URLs from your secrets
WEBHOOKS = {
    "morning": load_secret("discord_morning_brief_webhook"),
    "midday": load_secret("discord_midday_brief_webhook"),
    "eod": load_secret("discord_eod_brief_webhook"),
    "nightly": load_secret("discord_afterhours_brief_webhook"),
    "premarket": load_secret("discord_afterhours_brief_webhook"),
}

# File pattern → brief type
FILE_PATTERNS = [
    {"glob": "*morning-brief*.md", "type": "morning", "label": "🌅 Morning Brief"},
    {"glob": "*midday*.md", "type": "midday", "label": "☀️ Midday Brief"},
    {"glob": "*eod-summary*.md", "type": "eod", "label": "🔔 EOD Brief"},
    {"glob": "*nightly*.md", "type": "nightly", "label": "🌙 Nightly Brief"},
    {"glob": "*premarket*.md", "type": "premarket", "label": "🌅 Premarket"},
]

# Skip these files even if they match patterns
SKIP_FILES = [
    "brief-delivery-fix",
    "ALL-SKILLS",
]


def load_sent():
    if os.path.exists(SENT_FILE):
        with open(SENT_FILE) as f:
            return set(json.load(f))
    return set()


def save_sent(sent):
    with open(SENT_FILE, "w") as f:
        json.dump(sorted(list(sent)), f, indent=2)


def send_to_discord(webhook_url, content, label, filename):
    """Send content to Discord, chunked if needed."""
    if not webhook_url:
        return False

    # Prepend header
    header = f"**{label}** — `{filename}`\n{'—'*30}\n"
    content = header + content

    chunks = []
    while content:
        if len(content) <= 1990:
            chunks.append(content)
            break
        split_at = content[:1990].rfind('\n')
        if split_at == -1 or split_at < 500:
            split_at = 1990
        chunks.append(content[:split_at])
        content = content[split_at:].lstrip('\n')

    for i, chunk in enumerate(chunks):
        payload = {
            "content": chunk,
            "username": label,
        }
        try:
            resp = requests.post(webhook_url, json=payload, timeout=10)
            if resp.status_code == 429:
                # Rate limited — wait and retry
                retry_after = resp.json().get("retry_after", 5)
                print(f"    Rate limited, waiting {retry_after}s...")
                time.sleep(retry_after)
                resp = requests.post(webhook_url, json=payload, timeout=10)
            if resp.status_code not in (200, 204):
                print(f"    Discord error {resp.status_code}")
                return False
        except Exception as e:
            print(f"    Request failed: {e}")
            return False
        # Pace messages to avoid rate limits
        time.sleep(1.5)

    return True


def main():
    print("Webhook status:")
    for name, url in WEBHOOKS.items():
        print(f"  {name}: {'OK' if url else 'MISSING'}")

    sent = load_sent()
    total_found = 0
    total_sent = 0
    total_skipped = 0

    for pattern in FILE_PATTERNS:
        files = sorted(glob.glob(os.path.join(MEMORY_DIR, pattern["glob"])))
        brief_type = pattern["type"]
        label = pattern["label"]
        webhook_url = WEBHOOKS.get(brief_type)

        for filepath in files:
            filename = os.path.basename(filepath)

            # Skip non-brief files
            if any(skip in filename for skip in SKIP_FILES):
                continue

            # Skip already sent
            if filename in sent:
                total_skipped += 1
                continue

            total_found += 1

            with open(filepath) as f:
                content = f.read().strip()

            if not content or len(content) < 50:
                print(f"  Skipping {filename} (too short)")
                continue

            print(f"\n📋 {label}: {filename}")

            if webhook_url:
                success = send_to_discord(webhook_url, content, label, filename)
                if success:
                    sent.add(filename)
                    total_sent += 1
                    print(f"  ✅ Sent to Discord")
                else:
                    print(f"  ❌ Failed")
            else:
                print(f"  ⚠️ No webhook for {brief_type}")

    save_sent(sent)
    print(f"\n{'='*40}")
    print(f"New briefs found: {total_found}")
    print(f"Sent to Discord:  {total_sent}")
    print(f"Already sent:     {total_skipped}")


if __name__ == "__main__":
    main()
