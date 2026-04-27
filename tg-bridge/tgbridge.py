#!/usr/bin/env python3
"""TGBridge — bidirectional Discord ↔ Telegram bridge.

DIRECTION 1 — Discord → Telegram (smart-filtered):
  Watches: flow_huge, flow_unusual, ts_picks, ss_picks, boba_cmd, sentiment_alerts, tg_bridge
  Filter: forward only messages with parsed premium >= $1M, OR Boba mentions, OR ANY message
          posted in #tg-bridge channel
  Target: Telegram group MissionCtrl Telegram Command Center (chat_id -5066886378)

DIRECTION 2 — Telegram → Discord (generic):
  Polls Telegram getUpdates for new messages in command center group.
  Forwards to Discord #tg-bridge channel verbatim.

Uses MissionControlTeleBot token (also used by Orion/Team).
Discord side runs as new bot account using discord_tgbridge_token.
"""
import asyncio, json, os, re, time, logging
from datetime import datetime, timezone
from pathlib import Path
import discord
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"

# Discord bot for receiving Discord messages
DISCORD_TOKEN = (SECRETS / "discord_tgbridge_token").read_text().strip()

# Channels to watch for smart-filter Discord → Telegram
WATCH_CHANNELS = {}
def _try_chan(name):
    p = SECRETS / f"discord_{name}_channel"
    if p.exists():
        try:
            WATCH_CHANNELS[int(p.read_text().strip())] = name
        except Exception:
            pass

for name in ("flow_huge", "flow_unusual", "ts_picks", "ss_picks",
             "boba_cmd", "sentiment_alerts", "tg_bridge"):
    _try_chan(name)

# The #tg-bridge channel - generic forwarder (no filter)
BRIDGE_CHANNEL = int((SECRETS / "discord_tg_bridge_channel").read_text().strip())

# Telegram credentials
TG_BOT_TOKEN = (SECRETS / "telegram-bot-token.txt").read_text().strip()
TG_CHAT_ID = (SECRETS / "telegram-chat-id.txt").read_text().strip()
TG_API = f"https://api.telegram.org/bot{TG_BOT_TOKEN}"

# Discord webhook for posting TG messages to Discord side
DISCORD_TG_WEBHOOK = (SECRETS / "discord_tg_bridge_webhook").read_text().strip()

PREMIUM_THRESHOLD = 1_000_000

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "tgbridge.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)

# State for TG → Discord polling
TG_STATE_FILE = Path.home() / ".openclaw" / "workspace" / "tgbridge_tg_offset.json"


def parse_premium(text):
    """Find largest $X.XM or $XK or $X,XXX,XXX value in text. Returns float or None."""
    if not text:
        return None
    largest = 0
    # $X.XM or $XM
    for m in re.finditer(r"\$(\d+(?:\.\d+)?)\s*M", text, re.IGNORECASE):
        largest = max(largest, float(m.group(1)) * 1_000_000)
    # $XXXK
    for m in re.finditer(r"\$(\d+(?:\.\d+)?)\s*K", text, re.IGNORECASE):
        largest = max(largest, float(m.group(1)) * 1_000)
    # $X,XXX,XXX
    for m in re.finditer(r"\$(\d{1,3}(?:,\d{3})+)", text):
        largest = max(largest, float(m.group(1).replace(",", "")))
    return largest if largest > 0 else None


def is_boba_alert(text):
    """Detect Boba-generated alerts."""
    if not text:
        return False
    t = text.lower()
    return any(kw in t for kw in ("boba", "🔫", "🔒", "scan:", "auto-thread", "live trade", "paper trade"))


def fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.2f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


# ─── Discord → Telegram ──────────────────────────────────────────────
def send_to_telegram(text, channel_name="discord"):
    """POST to Telegram sendMessage. text is raw Markdown-safe."""
    # Telegram has 4096 char limit
    if len(text) > 4000:
        text = text[:3997] + "..."
    payload = {
        "chat_id": TG_CHAT_ID,
        "text": text,
        "parse_mode": "HTML",
        "disable_web_page_preview": True,
    }
    try:
        r = requests.post(f"{TG_API}/sendMessage", json=payload, timeout=10)
        if r.status_code == 200:
            logging.info(f"→TG OK from #{channel_name}: {text[:60]}")
            return True
        else:
            logging.error(f"→TG FAIL {r.status_code}: {r.text[:200]}")
            return False
    except Exception as e:
        logging.error(f"→TG exception: {e}")
        return False


def html_escape(s):
    return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")


def format_for_tg(message):
    """Convert Discord message to Telegram-friendly HTML."""
    parts = []
    chan_name = WATCH_CHANNELS.get(message.channel.id, message.channel.name)
    parts.append(f"<b>#{html_escape(chan_name)}</b>")

    author = message.author.display_name if hasattr(message.author, "display_name") else str(message.author)
    parts.append(f"<i>{html_escape(author)}</i>")

    if message.content:
        parts.append(html_escape(message.content)[:3500])

    # Embeds
    for e in message.embeds[:3]:
        if e.title:
            parts.append(f"<b>{html_escape(e.title)}</b>")
        if e.description:
            parts.append(html_escape(e.description)[:2000])
        for f in e.fields[:8]:
            parts.append(f"• <b>{html_escape(f.name)}</b>: {html_escape(f.value)[:300]}")

    if message.attachments:
        for a in message.attachments[:3]:
            parts.append(f"📎 {html_escape(a.url)}")

    return "\n".join(parts)


# ─── Telegram → Discord ──────────────────────────────────────────────
def get_last_offset():
    if not TG_STATE_FILE.exists():
        return 0
    try:
        return json.loads(TG_STATE_FILE.read_text()).get("offset", 0)
    except Exception:
        return 0


def save_offset(offset):
    TG_STATE_FILE.write_text(json.dumps({"offset": offset}))


async def poll_telegram_loop():
    """Poll Telegram getUpdates and forward to Discord webhook."""
    logging.info("[tgbridge] starting TG poll loop")
    bot_id = None
    try:
        r = requests.get(f"{TG_API}/getMe", timeout=8)
        if r.status_code == 200:
            bot_id = r.json().get("result", {}).get("id")
            logging.info(f"[tgbridge] tg bot id: {bot_id}")
    except Exception:
        pass

    offset = get_last_offset()
    while True:
        try:
            r = requests.get(
                f"{TG_API}/getUpdates",
                params={"offset": offset + 1, "timeout": 30, "limit": 100},
                timeout=40,
            )
            if r.status_code != 200:
                logging.error(f"TG poll failed: {r.status_code}")
                await asyncio.sleep(15)
                continue

            data = r.json()
            for update in data.get("result", []):
                offset = max(offset, update["update_id"])
                msg = update.get("message") or update.get("channel_post")
                if not msg:
                    continue
                # Skip if from this same bot (avoid loop)
                if bot_id and msg.get("from", {}).get("id") == bot_id:
                    continue
                # Only handle messages from our target chat
                if str(msg.get("chat", {}).get("id")) != TG_CHAT_ID:
                    continue

                sender = msg.get("from", {})
                sender_name = sender.get("username") or sender.get("first_name") or "tg-user"
                text = msg.get("text") or msg.get("caption") or "[non-text message]"

                # POST to Discord webhook
                payload = {
                    "username": f"TG: {sender_name}",
                    "content": f"{text[:1900]}",
                    "allowed_mentions": {"parse": []},
                }
                try:
                    rr = requests.post(DISCORD_TG_WEBHOOK, json=payload, timeout=10)
                    if rr.status_code in (200, 204):
                        logging.info(f"TG→Discord: {sender_name}: {text[:60]}")
                    else:
                        logging.error(f"webhook fail {rr.status_code}: {rr.text[:120]}")
                except Exception as e:
                    logging.error(f"webhook err: {e}")

            save_offset(offset)
        except Exception as e:
            logging.error(f"poll loop err: {e}")
            await asyncio.sleep(15)
        await asyncio.sleep(2)


# ─── Discord client ──────────────────────────────────────────────────
intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True

client = discord.Client(intents=intents)


@client.event
async def on_ready():
    logging.info(f"[tgbridge] logged in as {client.user} (id={client.user.id})")
    logging.info(f"[tgbridge] watching {len(WATCH_CHANNELS)} channels for D→TG forwarding")
    for chan_id, name in WATCH_CHANNELS.items():
        logging.info(f"  - {name}: {chan_id}")
    logging.info(f"[tgbridge] bridge channel: {BRIDGE_CHANNEL}")
    logging.info(f"[tgbridge] TG chat: {TG_CHAT_ID}")
    # Start TG polling loop
    client.loop.create_task(poll_telegram_loop())


@client.event
async def on_message(message):
    # Ignore self
    if message.author.id == client.user.id:
        return

    # Ignore other bot messages from this bridge to prevent loops
    if message.author.bot and message.author.display_name and "TG:" in message.author.display_name:
        return

    # Decide if we forward
    text_blob = message.content or ""
    for e in message.embeds:
        text_blob += " " + (e.title or "") + " " + (e.description or "")
        for f in e.fields:
            text_blob += " " + f.name + " " + f.value

    forward = False
    reason = ""

    # Generic forwarder for #tg-bridge channel
    if message.channel.id == BRIDGE_CHANNEL:
        forward = True
        reason = "bridge-channel"
    # Smart filter for watched channels
    elif message.channel.id in WATCH_CHANNELS:
        prem = parse_premium(text_blob)
        if prem and prem >= PREMIUM_THRESHOLD:
            forward = True
            reason = f"premium {fmt_prem(prem)}"
        elif is_boba_alert(text_blob):
            forward = True
            reason = "boba-alert"

    if not forward:
        return

    formatted = format_for_tg(message)
    ok = send_to_telegram(formatted, WATCH_CHANNELS.get(message.channel.id, "tg-bridge"))
    if ok:
        logging.info(f"D→TG fwd ({reason}): {message.channel.name}")


if __name__ == "__main__":
    client.run(DISCORD_TOKEN)
