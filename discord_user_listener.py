#!/usr/bin/env python3
"""
discord_user_listener.py — LIVE gateway listener on Mike's personal Discord account.

The Discord equivalent of tg_responder.py: a persistent connection as Mike's
USER account that LOGS incoming DMs and @-mentions in real time. Read/log ONLY —
no auto-reply, single connection, backoff reconnect (lowest ban-risk profile).

RUN WITH THE ISOLATED VENV ONLY:
  ~/scripts/.venv-discord-self/bin/python ~/scripts/discord_user_listener.py
discord.py-self imports as `discord` and MUST NOT share a venv with the bots'
discord.py (namespace collision would break all 17 bots).

Output:
  ~/.openclaw/workspace/state/discord_user_messages.jsonl   (append-only log)
Optional: pings Mike's Telegram via tg-send-msg on a DM (DISCORD_LISTENER_TG=1, default on).
"""
import os, sys, json, asyncio, datetime
from pathlib import Path

sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret  # noqa: E402

import discord  # discord.py-self  # noqa: E402

STATE = Path.home() / ".openclaw" / "workspace" / "state"
STATE.mkdir(parents=True, exist_ok=True)
LOG = STATE / "discord_user_messages.jsonl"
TG_PING = os.environ.get("DISCORD_LISTENER_TG", "1") == "1"

TOKEN = get_secret("discord_user.token")
if not TOKEN:
    sys.exit("no discord_user.token in vault — run: discord_user.py set-token")

client = discord.Client()


def _log(rec: dict):
    rec["logged_at"] = datetime.datetime.now().isoformat(timespec="seconds")
    with LOG.open("a") as f:
        f.write(json.dumps(rec, ensure_ascii=False) + "\n")


def _tg(text: str):
    if not TG_PING:
        return
    try:
        import subprocess
        subprocess.run([str(Path.home() / "bin" / "tg-send-msg"), text],
                       timeout=15, capture_output=True)
    except Exception:
        pass


@client.event
async def on_ready():
    me = client.user
    print(f"✓ listener online as {me} (id {me.id}) — logging DMs + mentions to {LOG}",
          flush=True)


@client.event
async def on_message(message):
    me = client.user
    is_dm = message.guild is None
    mentioned = me in message.mentions
    if message.author.id == me.id:
        return                      # ignore our own sends
    if not (is_dm or mentioned):
        return                      # only DMs + @-mentions
    rec = {
        "type": "dm" if is_dm else "mention",
        "author": str(message.author),
        "author_id": message.author.id,
        "guild": (message.guild.name if message.guild else None),
        "channel": getattr(message.channel, "name", "DM"),
        "channel_id": message.channel.id,
        "content": message.content,
        "ts": message.created_at.isoformat(timespec="seconds"),
    }
    _log(rec)
    label = "DM" if is_dm else f"@mention in #{rec['channel']}"
    preview = (message.content or "[no text]")[:200]
    print(f"[{label}] {message.author}: {preview}", flush=True)
    if is_dm:
        _tg(f"🟣 Discord DM from {message.author}: {preview}")


def main():
    # discord.py-self handles user-account gateway + reconnect; run() blocks.
    client.run(TOKEN, reconnect=True)


if __name__ == "__main__":
    main()
