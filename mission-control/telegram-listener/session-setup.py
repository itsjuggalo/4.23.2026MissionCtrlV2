#!/usr/bin/env python3
"""
Run this ONCE interactively to authenticate your Telegram session.
It will save mc_feed.session in the same directory as this script.
"""
import asyncio
import os

from telethon import TelegramClient

API_ID = 31236866
API_HASH = "ee3934cfcd4a6c5ab575dd0f59016330"
SESSION_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "mc_feed")


async def main():
    print("=== Mission Control Telegram Session Setup ===")
    print(f"Session will be saved to: {SESSION_FILE}.session")
    print()
    client = TelegramClient(SESSION_FILE, API_ID, API_HASH)
    await client.start()
    me = await client.get_me()
    print(f"\n✅ Authenticated as: {me.first_name} (@{me.username})")
    print("Session saved. You can now run listener.py with PM2.")
    await client.disconnect()


if __name__ == "__main__":
    asyncio.run(main())
