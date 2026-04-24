#!/usr/bin/env python3
"""
Discord Archive Channel Setup
Creates the 🗄️ ARCHIVES category + 11 archive channels + webhooks,
then writes the webhook URLs directly into each bot's .env file.

Usage:
  python3 setup-discord-archives.py --token YOUR_BOT_TOKEN

Get a bot token:
  1. Go to https://discord.com/developers/applications
  2. Create New Application → Bot → Reset Token → copy it
  3. Under OAuth2 → URL Generator: scopes=bot, perms=Manage Channels + Manage Webhooks
  4. Open the generated URL to invite the bot to your server
"""
import argparse
import json
import os
import re
import sys
import time

import requests

GUILD_ID = "1486025777970548908"
BOT_DIR  = os.path.expanduser("~/mission-control")

# Archive channels: (channel_name, description, bot_env_file, env_key)
ARCHIVE_CHANNELS = [
    (
        "archive-eric",
        "Archived signals from Eric's Telegram listener",
        "telegram-listener/.env",
        "DISCORD_ARCHIVE_ERIC_WEBHOOK",
    ),
    (
        "archive-analyst",
        "Archived technical analysis results",
        "analyst/.env",
        "DISCORD_ARCHIVE_ANALYST_WEBHOOK",
    ),
    (
        "archive-risk",
        "Archived risk manager decisions",
        "risk-manager/.env",
        "DISCORD_ARCHIVE_RISK_WEBHOOK",
    ),
    (
        "archive-executions",
        "Archived trade execution plans and fills",
        "execution-specialist/.env",
        "DISCORD_ARCHIVE_EXECUTIONS_WEBHOOK",
    ),
    (
        "archive-portfolio",
        "Archived portfolio snapshots",
        "portfolio-monitor/.env",
        "DISCORD_ARCHIVE_PORTFOLIO_WEBHOOK",
    ),
    (
        "archive-broadcaster",
        "Archived broadcast logs",
        "broadcaster/.env",
        "DISCORD_ARCHIVE_BROADCASTER_WEBHOOK",
    ),
    (
        "archive-sniper",
        "Archived token launch records",
        "crypto-sniper/.env",
        "DISCORD_ARCHIVE_SNIPER_WEBHOOK",
    ),
    (
        "archive-counter-intel",
        "Archived threat logs and optimization history",
        "counter-intelligence/.env",
        "DISCORD_ARCHIVE_CI_WEBHOOK",
    ),
    (
        "archive-auditor",
        "Archived trade journal and performance reports",
        "auditor/.env",
        "DISCORD_ARCHIVE_AUDITOR_WEBHOOK",
    ),
    (
        "archive-macro",
        "Archived macro outlook history",
        "macro-strategist/.env",
        "DISCORD_ARCHIVE_MACRO_WEBHOOK",
    ),
    (
        "archive-psych",
        "Archived PsychTechologist insights and journal entries",
        None,  # psych bot not built yet
        "DISCORD_ARCHIVE_PSYCH_WEBHOOK",
    ),
]


def api(method: str, path: str, token: str, **kwargs):
    """Discord REST API call with rate-limit handling."""
    url = f"https://discord.com/api/v10{path}"
    headers = {
        "Authorization": f"Bot {token}",
        "Content-Type": "application/json",
        "User-Agent": "MissionControlArchiveSetup/1.0",
    }
    for attempt in range(5):
        r = getattr(requests, method)(url, headers=headers, **kwargs)
        if r.status_code == 429:
            retry = float(r.headers.get("Retry-After", 1.0))
            print(f"  Rate limited — waiting {retry:.1f}s")
            time.sleep(retry + 0.1)
            continue
        return r
    raise RuntimeError(f"API call failed after retries: {path}")


def add_or_update_env(env_path: str, key: str, value: str) -> None:
    """Add or update a key=value line in a .env file."""
    full = os.path.join(BOT_DIR, env_path)
    if not os.path.exists(full):
        print(f"  ⚠️  {env_path} not found — skipping .env update")
        return

    with open(full) as f:
        content = f.read()

    if key in content:
        content = re.sub(rf"^{re.escape(key)}=.*$", f"{key}={value}", content, flags=re.MULTILINE)
        print(f"  Updated {key} in {env_path}")
    else:
        content = content.rstrip("\n") + f"\n{key}={value}\n"
        print(f"  Added {key} to {env_path}")

    with open(full, "w") as f:
        f.write(content)
    os.chmod(full, 0o600)


def main():
    parser = argparse.ArgumentParser(description="Create Discord archive channels + webhooks")
    parser.add_argument("--token", required=True, help="Discord bot token")
    parser.add_argument("--dry-run", action="store_true", help="Print plan but don't create anything")
    args = parser.parse_args()

    token = args.token.strip()

    # Verify token
    print("Verifying bot token...")
    me = api("get", "/users/@me", token)
    if me.status_code != 200:
        print(f"❌ Invalid token: {me.status_code} {me.text}")
        sys.exit(1)
    bot = me.json()
    print(f"✅ Authenticated as: {bot['username']}#{bot.get('discriminator','0')}\n")

    if args.dry_run:
        print("DRY RUN — no changes will be made\n")

    # Check existing channels to avoid duplicates
    print("Fetching existing channels...")
    ch_resp = api("get", f"/guilds/{GUILD_ID}/channels", token)
    if ch_resp.status_code != 200:
        print(f"❌ Cannot fetch channels: {ch_resp.status_code} {ch_resp.text}")
        sys.exit(1)
    existing = ch_resp.json()
    existing_names = {c["name"]: c["id"] for c in existing}
    existing_categories = {c["name"]: c["id"] for c in existing if c["type"] == 4}
    print(f"  Found {len(existing)} existing channels, {len(existing_categories)} categories\n")

    # Create or find category
    CATEGORY_NAME = "🗄️ ARCHIVES"
    if CATEGORY_NAME in existing_categories:
        category_id = existing_categories[CATEGORY_NAME]
        print(f"Category already exists: {CATEGORY_NAME} (id: {category_id})")
    else:
        print(f"Creating category: {CATEGORY_NAME}")
        if not args.dry_run:
            r = api("post", f"/guilds/{GUILD_ID}/channels", token, json={
                "name":  CATEGORY_NAME,
                "type":  4,  # GUILD_CATEGORY
            })
            if r.status_code not in (200, 201):
                print(f"❌ Failed to create category: {r.status_code} {r.text}")
                sys.exit(1)
            category_id = r.json()["id"]
            print(f"  ✅ Created category (id: {category_id})")
            time.sleep(0.5)
        else:
            category_id = "DRY_RUN_ID"

    # Create channels + webhooks
    results = []
    for chan_name, topic, env_file, env_key in ARCHIVE_CHANNELS:
        print(f"\n--- #{chan_name} ---")

        # Channel
        if chan_name in existing_names:
            chan_id = existing_names[chan_name]
            print(f"  Channel already exists (id: {chan_id})")
        else:
            print(f"  Creating channel #{chan_name}")
            if not args.dry_run:
                r = api("post", f"/guilds/{GUILD_ID}/channels", token, json={
                    "name":      chan_name,
                    "type":      0,  # GUILD_TEXT
                    "topic":     topic,
                    "parent_id": category_id,
                    "permission_overwrites": [
                        # @everyone can read but not send messages
                        {
                            "id":   GUILD_ID,  # @everyone role has same id as guild
                            "type": 0,
                            "allow": "1024",   # VIEW_CHANNEL + READ_MESSAGE_HISTORY
                            "deny":  "2048",   # SEND_MESSAGES
                        }
                    ],
                })
                if r.status_code not in (200, 201):
                    print(f"  ❌ Failed: {r.status_code} {r.text}")
                    results.append((chan_name, env_key, None, "FAILED"))
                    continue
                chan_id = r.json()["id"]
                print(f"  ✅ Channel created (id: {chan_id})")
                time.sleep(0.4)
            else:
                chan_id = f"DRY_{chan_name}"

        # Webhook
        print(f"  Creating webhook for #{chan_name}")
        if not args.dry_run:
            r = api("post", f"/channels/{chan_id}/webhooks", token, json={
                "name": f"Mission Control — {chan_name.replace('archive-','').title()}",
            })
            if r.status_code not in (200, 201):
                print(f"  ❌ Webhook failed: {r.status_code} {r.text}")
                results.append((chan_name, env_key, None, "WEBHOOK_FAILED"))
                continue
            wh = r.json()
            webhook_url = f"https://discord.com/api/webhooks/{wh['id']}/{wh['token']}"
            print(f"  ✅ Webhook created")
            time.sleep(0.4)

            # Write to .env
            if env_file:
                add_or_update_env(env_file, env_key, webhook_url)
            results.append((chan_name, env_key, webhook_url, "OK"))
        else:
            results.append((chan_name, env_key, "https://discord.com/api/webhooks/DRY/RUN", "DRY_RUN"))

    # Summary
    print("\n" + "="*60)
    print("SETUP COMPLETE\n")
    ok  = [r for r in results if r[3] == "OK"]
    err = [r for r in results if r[3] not in ("OK","DRY_RUN")]
    print(f"✅ {len(ok)} channels + webhooks created")
    if err:
        print(f"❌ {len(err)} failed: {[e[0] for e in err]}")

    print("\nWebhook env keys added:")
    for name, key, url, status in results:
        mark = "✅" if status in ("OK","DRY_RUN") else "❌"
        print(f"  {mark} {key}")

    if args.dry_run:
        print("\nRe-run without --dry-run to apply changes.")

    # Save results to file for reference
    out_path = os.path.join(BOT_DIR, "discord-archive-setup-results.json")
    with open(out_path, "w") as f:
        json.dump([
            {"channel": r[0], "env_key": r[1],
             "webhook_url": "[REDACTED]" if r[2] else None,
             "status": r[3]}
            for r in results
        ], f, indent=2)
    os.chmod(out_path, 0o600)
    print(f"\nResults saved to: {out_path}")


if __name__ == "__main__":
    main()
