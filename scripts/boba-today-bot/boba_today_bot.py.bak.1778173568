#!/usr/bin/env python3
"""boba-today-bot - listens in #boba-cmd for !today, !today jazzy, !today both.

Subprocess-runs the boba-today shell helper and posts output back as a code-block.
Reuses discord_boba_qa_token. Auth-locked to mike_discord_user_id.
"""
import asyncio, os, sys, subprocess
from datetime import datetime, timezone
from pathlib import Path
import discord

SECRETS = Path.home() / ".openclaw" / "secrets"

def _read(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

TOKEN = _read("discord_boba_qa_token") or _read("discord_boba_token")
if not TOKEN:
    print("FATAL: no Discord bot token", flush=True)
    sys.exit(1)

AUTH_USER_ID = int(_read("mike_discord_user_id") or "0")
ALLOWED_CHANNELS = set()
boba_cmd_ch = _read("discord_boba_cmd_channel")
if boba_cmd_ch:
    ALLOWED_CHANNELS.add(int(boba_cmd_ch))

HELPER = "/home/ubuntu/.local/bin/boba-today"

intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True
client = discord.Client(intents=intents)


def run_helper(args):
    """Run boba-today with given args. Returns stdout truncated to fit Discord."""
    try:
        result = subprocess.run(
            [HELPER] + args,
            capture_output=True, text=True, timeout=30,
        )
        out = result.stdout
        if result.returncode != 0:
            out += f"\n[exit {result.returncode}]\n{result.stderr[:500]}"
        return out
    except subprocess.TimeoutExpired:
        return "[ERROR] boba-today timed out after 30s"
    except Exception as e:
        return f"[ERROR] {e}"


def chunk_for_discord(text, header=""):
    """Split text into <=1900 char code blocks."""
    chunks = []
    current = ""
    for line in text.split("\n"):
        if len(current) + len(line) + 1 > 1850:
            chunks.append(current)
            current = line + "\n"
        else:
            current += line + "\n"
    if current:
        chunks.append(current)
    return [f"{header}```\n{c}\n```" if i == 0 else f"```\n{c}\n```"
            for i, c in enumerate(chunks)]


@client.event
async def on_ready():
    print(f"[boba-today-bot] Logged in as {client.user} (id={client.user.id})", flush=True)
    print(f"[boba-today-bot] Auth user: {AUTH_USER_ID}", flush=True)
    print(f"[boba-today-bot] Allowed channels: {ALLOWED_CHANNELS}", flush=True)
    for g in client.guilds:
        print(f"  Guild: {g.name}", flush=True)


@client.event
async def on_message(message):
    if message.author.id == client.user.id:
        return
    if AUTH_USER_ID and message.author.id != AUTH_USER_ID:
        return
    if ALLOWED_CHANNELS and message.channel.id not in ALLOWED_CHANNELS:
        return
    content = message.content.strip().lower()
    if not content.startswith("!today") and not content.startswith("!boba-today"):
        return

    # Parse args
    parts = content.split()
    args = []
    i = 1
    while i < len(parts):
        tok = parts[i]
        if tok == "jazzy":
            args.append("--jazzy")
        elif tok == "both":
            args.append("--both")
        elif tok == "since" and i + 1 < len(parts):
            args.extend(["--since", parts[i+1]])
            i += 1
        elif tok == "help":
            args.append("--help")
        i += 1

    print(f"[boba-today-bot] {message.author.name}: !today {args}", flush=True)
    async with message.channel.typing():
        loop = asyncio.get_event_loop()
        out = await loop.run_in_executor(None, run_helper, args)

    chunks = chunk_for_discord(out, header=f"**boba-today** `{' '.join(args) or '(default)'}`\n")
    for c in chunks[:5]:  # cap at 5 messages to avoid spam
        await message.channel.send(c)


if __name__ == "__main__":
    client.run(TOKEN)
