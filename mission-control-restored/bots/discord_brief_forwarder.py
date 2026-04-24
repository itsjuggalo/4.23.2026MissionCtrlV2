#!/usr/bin/env python3
"""
Discord Brief Forwarder
Watches ~/.openclaw/workspace/memory/ for new brief files.
When a new file appears, POSTs the content to the matching Discord webhook.
Zero LLM tokens used.

PM2: pm2 start bots/discord_brief_forwarder.py --name brief-forwarder --interpreter python3
"""

import os
import time
import json
import requests
from pathlib import Path
from datetime import datetime

MEMORY_DIR = Path.home() / ".openclaw" / "workspace" / "memory"
SECRETS_DIR = Path.home() / ".openclaw" / "secrets"
STATE_FILE = Path.home() / "mission-control-restored" / "data" / "brief_forwarder_state.json"

# Map file patterns to webhook secret files
BRIEF_WEBHOOKS = {
    "morning-brief": "discord_morning_brief_webhook",
    "midday": "discord_midday_brief_webhook",
    "eod-summary": "discord_eod_brief_webhook",
    "nightly": "discord_afterhours_brief_webhook",
}

def read_secret(name):
    p = SECRETS_DIR / name
    if p.exists():
        return p.read_text().strip()
    return None

def load_state():
    try:
        return json.loads(STATE_FILE.read_text())
    except:
        return {"forwarded": {}}

def save_state(state):
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    STATE_FILE.write_text(json.dumps(state, indent=2))

def match_brief_type(filename):
    """Match a filename to a brief type."""
    name = filename.lower()
    for pattern, webhook_key in BRIEF_WEBHOOKS.items():
        if pattern in name:
            return pattern, webhook_key
    return None, None

def post_to_discord(webhook_url, content):
    """POST content to a Discord webhook. Splits if > 2000 chars."""
    # Discord max message is 2000 chars
    chunks = []
    while len(content) > 1900:
        # Find a good split point (newline near 1900)
        split_at = content.rfind('\n', 0, 1900)
        if split_at == -1:
            split_at = 1900
        chunks.append(content[:split_at])
        content = content[split_at:].lstrip('\n')
    if content:
        chunks.append(content)

    for i, chunk in enumerate(chunks):
        try:
            r = requests.post(
                webhook_url,
                json={"content": chunk},
                timeout=15,
            )
            if r.status_code == 204:
                print(f"  [discord] chunk {i+1}/{len(chunks)} sent OK")
            elif r.status_code == 429:
                retry_after = r.json().get("retry_after", 5)
                print(f"  [discord] rate limited, waiting {retry_after}s")
                time.sleep(retry_after)
                requests.post(webhook_url, json={"content": chunk}, timeout=15)
            else:
                print(f"  [discord] error {r.status_code}: {r.text[:200]}")
        except Exception as e:
            print(f"  [discord] send error: {e}")
        
        # Small delay between chunks to avoid rate limits
        if len(chunks) > 1 and i < len(chunks) - 1:
            time.sleep(1)

def scan_and_forward(state):
    """Scan memory dir for new brief files and forward to Discord."""
    if not MEMORY_DIR.exists():
        return state

    forwarded = state.get("forwarded", {})
    today = datetime.now().strftime("%Y-%m-%d")

    for f in sorted(MEMORY_DIR.iterdir()):
        if not f.is_file() or not f.name.endswith(".md"):
            continue
        
        # Only process today's files and yesterday's (for nightly briefs)
        if not (today in f.name or 
                (datetime.now().strftime("%Y-%m-") in f.name and 
                 f.stat().st_mtime > time.time() - 86400)):
            continue

        # Skip if already forwarded
        file_key = f.name
        file_mtime = f.stat().st_mtime
        if file_key in forwarded and forwarded[file_key] >= file_mtime:
            continue

        # Match to brief type
        brief_type, webhook_key = match_brief_type(f.name)
        if not brief_type:
            continue

        # Get webhook URL
        webhook_url = read_secret(webhook_key)
        if not webhook_url:
            print(f"[forwarder] No webhook for {webhook_key}")
            continue

        # Read and forward
        content = f.read_text().strip()
        if not content:
            continue

        print(f"[forwarder] New brief: {f.name} → {brief_type}")
        post_to_discord(webhook_url, content)

        # Mark as forwarded
        forwarded[file_key] = file_mtime
        state["forwarded"] = forwarded
        save_state(state)

    return state

def main():
    print(f"[forwarder] Starting Discord brief forwarder")
    print(f"[forwarder] Watching: {MEMORY_DIR}")
    print(f"[forwarder] Webhooks configured:")
    for pattern, key in BRIEF_WEBHOOKS.items():
        url = read_secret(key)
        status = "✓" if url else "✗ MISSING"
        print(f"  {pattern}: {status}")

    state = load_state()

    while True:
        try:
            state = scan_and_forward(state)
        except KeyboardInterrupt:
            print("\n[forwarder] Shutting down")
            break
        except Exception as e:
            print(f"[forwarder] Error: {e}")
        
        # Check every 60 seconds
        time.sleep(60)

if __name__ == "__main__":
    main()
