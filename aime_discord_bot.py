#!/usr/bin/env python3
"""aime_discord_bot.py — AIME in Discord (browserless, no window).

Mirrors the Telegram AIME bot for Discord. Ask AIME two ways:
  - Slash command:  /aime question:<text>        (works with no privileged intents)
  - Dedicated channel: set AIME_CHANNEL_ID and every message there is an AIME query
    (requires the Message Content intent enabled on the bot).

Uses the shared browserless client (~/scripts/aime_client.py) — pure HTTP + ainvest
cookie, never a browser. Bot token from ~/.openclaw/secrets/<DISCORD_AIME_TOKEN_FILE>.
"""
from __future__ import annotations

import asyncio
import os
import sys
from pathlib import Path

sys.path.insert(0, str(Path.home() / "scripts"))
import aime_client as aime  # noqa: E402
import discord  # noqa: E402
from discord import app_commands  # noqa: E402

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = os.environ.get("DISCORD_AIME_TOKEN_FILE", "discord_ops_bot_token")
TOKEN = (SEC / TOKEN_FILE).read_text(encoding="utf-8").strip()
CHANNEL_ID = int(os.environ.get("AIME_CHANNEL_ID", "0") or 0)
DISCORD_MAX = 2000


def _chunks(text: str):
    text = text or "[empty]"
    for i in range(0, len(text), DISCORD_MAX):
        yield text[i:i + DISCORD_MAX]


async def _answer(question: str) -> str:
    # ask_aime is blocking HTTP — run off the event loop
    return await asyncio.to_thread(aime.ask_aime, question)


intents = discord.Intents.default()
# Only request the privileged message-content intent if a channel listener is configured.
if CHANNEL_ID:
    intents.message_content = True

client = discord.Client(intents=intents)
tree = app_commands.CommandTree(client)


@tree.command(name="aime", description="Ask AInvest AIME (market/stock/options intelligence)")
@app_commands.describe(question="What do you want to ask AIME?")
async def aime_cmd(interaction: discord.Interaction, question: str):
    await interaction.response.defer(thinking=True)
    ans = await _answer(question)
    parts = list(_chunks(ans))
    await interaction.followup.send(parts[0])
    for p in parts[1:]:
        await interaction.followup.send(p)


@client.event
async def on_ready():
    try:
        gid = os.environ.get("AIME_GUILD_ID")
        if gid:
            g = discord.Object(id=int(gid))
            tree.copy_global_to(guild=g)
            await tree.sync(guild=g)
        else:
            await tree.sync()
    except Exception as e:  # noqa: BLE001
        print(f"[aime-discord] slash sync failed: {e}", flush=True)
    print(f"[aime-discord] ready as {client.user} | channel_listen={'on' if CHANNEL_ID else 'off'}",
          flush=True)


@client.event
async def on_message(message: discord.Message):
    if message.author.bot or not CHANNEL_ID or message.channel.id != CHANNEL_ID:
        return
    q = (message.content or "").strip()
    if not q or q.startswith("/"):
        return
    async with message.channel.typing():
        ans = await _answer(q)
    for p in _chunks(ans):
        await message.channel.send(p)


if __name__ == "__main__":
    client.run(TOKEN)
