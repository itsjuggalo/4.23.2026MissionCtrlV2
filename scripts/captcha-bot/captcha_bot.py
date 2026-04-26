#!/usr/bin/env python3
"""Captcha gatekeeper — react-to-verify with ✅.

Flow:
  1. New member joins the guild
  2. Bot posts welcome message in #verify with a ✅ reaction
  3. Member clicks ✅
  4. Bot grants the "Verify" role
  5. Member gains access to rest of server (per channel perms)

No auto-kick. Console logging only. Ignores bots and self.

Persistence: tracks (guild_id, message_id) → user_id mapping in
~/.openclaw/workspace/state/captcha_pending.json so the bot can resume
after restarts without losing pending verifications.
"""
import asyncio, json, os, time, logging
from pathlib import Path
from datetime import datetime
import discord

SECRETS = Path.home() / ".openclaw" / "secrets"
TOKEN = (SECRETS / "discord_verify_token").read_text().strip()
GUILD_ID = int((SECRETS / "discord_guild_id").read_text().strip())
VERIFY_CHANNEL_ID = int((SECRETS / "discord_verify_channel").read_text().strip())
VERIFIED_ROLE_ID = 1497766452663554161  # "Verify" role granted on ✅
CHECK_EMOJI = "✅"

STATE_FILE = Path.home() / ".openclaw" / "workspace" / "captcha_pending.json"
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "captcha_bot.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)


def load_pending():
    if not STATE_FILE.exists():
        return {}
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {}


def save_pending(data):
    try:
        STATE_FILE.write_text(json.dumps(data, indent=2))
    except Exception as e:
        logging.error(f"save_pending: {e}")


# {message_id: user_id} - lookup on reaction add
pending = load_pending()


intents = discord.Intents.default()
intents.members = True
intents.guilds = True
intents.messages = True
intents.message_content = False  # don't need
intents.reactions = True

client = discord.Client(intents=intents)


@client.event
async def on_ready():
    logging.info(f"[captcha] logged in as {client.user} (id={client.user.id})")
    logging.info(f"[captcha] guild: {GUILD_ID}")
    logging.info(f"[captcha] verify channel: {VERIFY_CHANNEL_ID}")
    logging.info(f"[captcha] verified role: {VERIFIED_ROLE_ID}")
    logging.info(f"[captcha] {len(pending)} pending verifications loaded from state")
    # Sanity check role hierarchy
    guild = client.get_guild(GUILD_ID)
    if guild:
        target_role = guild.get_role(VERIFIED_ROLE_ID)
        bot_member = guild.get_member(client.user.id)
        if target_role and bot_member:
            bot_top = bot_member.top_role.position
            if bot_top <= target_role.position:
                logging.warning(
                    f"⚠️ ROLE HIERARCHY ISSUE: bot's top role at pos {bot_top}, "
                    f"target role '{target_role.name}' at pos {target_role.position}. "
                    f"Bot CANNOT grant. Drag bot role ABOVE target in Discord settings."
                )
            else:
                logging.info(
                    f"✓ Role hierarchy OK: bot top={bot_top}, target={target_role.position}"
                )


@client.event
async def on_member_join(member):
    if member.bot:
        return
    if member.guild.id != GUILD_ID:
        return

    chan = client.get_channel(VERIFY_CHANNEL_ID)
    if not chan:
        logging.error(f"verify channel {VERIFY_CHANNEL_ID} not found")
        return

    embed = discord.Embed(
        title="👋 Welcome to MissionCtrl",
        description=(
            f"Hey {member.mention}, please react with ✅ below to verify you're human "
            f"and gain access to the rest of the server.\n\n"
            f"_No timer, no rush — but you won't see other channels until you click._"
        ),
        color=0x2ecc71,
        timestamp=datetime.utcnow(),
    )
    embed.set_footer(text=f"User ID: {member.id}")

    try:
        msg = await chan.send(embed=embed)
        await msg.add_reaction(CHECK_EMOJI)
        pending[str(msg.id)] = member.id
        save_pending(pending)
        logging.info(f"[join] welcomed {member} (id={member.id}) — msg {msg.id}")
    except Exception as e:
        logging.error(f"on_member_join post failed: {e}")


@client.event
async def on_raw_reaction_add(payload):
    # raw event survives across restarts (cached events get lost)
    if payload.user_id == client.user.id:
        return  # ignore bot's own ✅
    if payload.guild_id != GUILD_ID:
        return
    if payload.channel_id != VERIFY_CHANNEL_ID:
        return
    if str(payload.emoji) != CHECK_EMOJI:
        return

    msg_id = str(payload.message_id)
    expected_user_id = pending.get(msg_id)

    # Allow verification if either:
    #   1. This is the user the welcome was for
    #   2. The message is in our pending state at all (handles edge cases)
    if expected_user_id is None:
        # Not a tracked welcome message — ignore silently
        return

    if payload.user_id != expected_user_id:
        # Wrong user reacted — ignore (don't process someone else's verification)
        logging.info(f"[react] wrong user {payload.user_id} on msg {msg_id} (expected {expected_user_id})")
        return

    guild = client.get_guild(GUILD_ID)
    if not guild:
        logging.error(f"guild {GUILD_ID} not found in cache")
        return
    member = guild.get_member(payload.user_id)
    if not member:
        # Try fetch
        try:
            member = await guild.fetch_member(payload.user_id)
        except Exception as e:
            logging.error(f"fetch_member {payload.user_id}: {e}")
            return

    role = guild.get_role(VERIFIED_ROLE_ID)
    if not role:
        logging.error(f"verified role {VERIFIED_ROLE_ID} not found")
        return

    if role in member.roles:
        logging.info(f"[verify] {member} already has role — skip")
        # Clear from pending anyway
        pending.pop(msg_id, None)
        save_pending(pending)
        return

    try:
        await member.add_roles(role, reason="Captcha verification ✅")
        logging.info(f"[verify] ✓ granted '{role.name}' to {member} (id={member.id})")
        pending.pop(msg_id, None)
        save_pending(pending)
    except discord.Forbidden as e:
        logging.error(f"[verify] FORBIDDEN granting role: {e}. Check role hierarchy "
                      f"(bot role must sit ABOVE target role).")
    except Exception as e:
        logging.error(f"[verify] add_roles failed: {e}")


if __name__ == "__main__":
    client.run(TOKEN)
