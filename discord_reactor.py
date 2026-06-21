#!/usr/bin/env python3
"""
discord_reactor.py — auto-reacts to new posts in key PUBLIC channels with the branded
custom emojis (UX flair + seeds engagement). Real bot (discord.py) under the System
Status identity. Needs only default intents (guilds+messages) — NO message_content,
so no Dev-Portal toggle. Reactions don't require reading content.

Run: /home/itsju/.venv/bin/python ~/scripts/discord_reactor.py   (PM2: discord-reactor)
"""
import sys, asyncio
from pathlib import Path
sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret
import discord

G = int(get_secret("discord_guild_id").strip())
TOKEN = get_secret("discord_status_bot_token").strip()

# channel-name → reactions (custom-emoji NAME, or a literal unicode emoji)
TARGETS = {
    "flow-picks":      ["star", "fire"],
    "whale-flow":      ["whale"],
    "flow-unusual":    ["flow"],
    "flow-huge":       ["fire"],
    "flow-repeaters":  ["flow"],
    "flow-etf-weekly": ["flow"],
    "flow-results":    ["star"],
    "fg-live-flow":    ["flow"],
    "fg-option-alerts":["alert"],
    "pattern-alerts":  ["chart"],
    "premarket-brief": ["brief"],
    "morning-briefs":  ["brief"],
    "midday-brief":    ["brief"],
    "closing-brief":   ["brief"],
    "macro":           ["macro"],
    "earnings":        ["chart"],
    "crypto-signals":  ["rocket"],
}

intents = discord.Intents.default()      # guilds + messages; NOT message_content
client = discord.Client(intents=intents)
_chan_react = {}   # channel_id -> [emoji obj or unicode str]


def _resolve(guild):
    emap = {e.name: e for e in guild.emojis}
    out = {}
    for cname, names in TARGETS.items():
        ch = discord.utils.get(guild.text_channels, name=cname)
        if not ch:
            continue
        out[ch.id] = [emap.get(n, n) for n in names]   # custom Emoji or unicode fallback
    return out


@client.event
async def on_ready():
    global _chan_react
    guild = client.get_guild(G)
    _chan_react = _resolve(guild)
    print(f"✓ reactor online as {client.user} — watching {len(_chan_react)} channels "
          f"(emojis: {len(guild.emojis)})", flush=True)


@client.event
async def on_message(message):
    if message.author.id == client.user.id:
        return
    reacts = _chan_react.get(message.channel.id)
    if not reacts:
        return
    for e in reacts:
        try:
            await message.add_reaction(e)
            await asyncio.sleep(0.3)
        except Exception as ex:
            print(f"react fail #{getattr(message.channel,'name','?')}: {ex}", flush=True)


client.run(TOKEN, log_handler=None)
