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
import requests

G = int(get_secret("discord_guild_id").strip())
TOKEN = get_secret("discord_status_bot_token").strip()

# ── verify react-gate ──────────────────────────────────────────────────────
# status-token bot can LISTEN; the role grant is delegated to the ops bot
# (Administrator, role above @Member) via REST. @Verified is unreachable by
# our bots (role hierarchy), so the gate grants @Member, which the wall honors.
VERIFY_CHANNEL_ID = 1497766892864278580
MEMBER_ROLE_ID = 1518434759678627951
GATE_EMOJI = "✅"
_OPS = get_secret("discord_ops_bot_token").strip()


def _grant_member(user_id):
    try:
        r = requests.put(
            f"https://discord.com/api/v10/guilds/{G}/members/{user_id}/roles/{MEMBER_ROLE_ID}",
            headers={"Authorization": f"Bot {_OPS}", "User-Agent": "MCGate/1.0"}, timeout=20)
        print(f"gate: grant @Member to {user_id} -> {r.status_code}", flush=True)
    except Exception as ex:
        print(f"gate grant fail {user_id}: {ex}", flush=True)

# channel-name → reactions (custom-emoji NAME, or a literal unicode emoji)
TARGETS = {
    "flow-picks":      ["star", "fire"],
    "whale-flow":      ["whale"],
    "flow-unusual":    ["flow"],
    "flow-huge":       ["fire"],
    "flow-repeaters":  ["flow"],
    "flow-etf-weekly": ["flow"],
    "flow-results":    ["star"],
    "flow-live":       ["flow"],
    "flow-fg-alerts":  ["alert"],
    "pattern-alerts":  ["chart"],
    "premarket-brief": ["brief"],
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
async def on_raw_reaction_add(payload):
    if payload.channel_id != VERIFY_CHANNEL_ID:
        return
    if str(payload.emoji) != GATE_EMOJI and getattr(payload.emoji, "name", None) != GATE_EMOJI:
        return
    if payload.user_id == client.user.id:
        return
    _grant_member(payload.user_id)


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
