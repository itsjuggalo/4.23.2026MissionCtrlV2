#!/usr/bin/env python3
"""
Mission Control Skill Bot
Telegram bot that accepts text + images, routes to the right skill,
and responds using the local claude CLI (existing OAuth — no API key needed).

Routing:
  Chart / portfolio screenshot  → claude -p with image (vision via stream-json)
  Backtest / strategy requests  → vibe-trading CLI
  Pine Script requests          → claude -p with pine-developer system prompt
  General finance questions     → vibe-trading CLI

PM2: pm2 start bots/mc_skill_bot.py --name mc-skill-bot --interpreter python3 \
         --cwd /home/itsju/sites/missioncontrol/MissionCtrlV2
"""

import base64
import json
import os
import subprocess
import sys
import time
import requests
from datetime import datetime
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
try:
    from context_builder import get_live_context
except ImportError:
    def get_live_context(**_): return ""

# ── Secrets ──────────────────────────────────────────────────────────────────
SECRETS = Path.home() / ".openclaw" / "secrets"

def get_secret(name):
    for p in [SECRETS / name, Path.home() / ".openclaw" / "secrets" / f"{name}.txt"]:
        if p.exists():
            return p.read_text().strip()
    return os.environ.get(name.upper().replace("-", "_"))

BOT_TOKEN   = get_secret("telegram_mc_skill_bot_token") or get_secret("telegram-bot-token")
CHAT_ID_STR = get_secret("telegram-chat-id")
VIBE_BIN    = "/home/itsju/02_DATA/mc-kb/.venv/bin/vibe-trading"
CLAUDE_BIN  = "claude"

if not BOT_TOKEN:
    print("ERROR: no bot token found. Set ~/.openclaw/secrets/telegram_mc_skill_bot_token")
    sys.exit(1)

# Whitelist: if CHAT_ID_STR is set, only respond to that chat
ALLOWED_CHATS = set()
if CHAT_ID_STR:
    for cid in CHAT_ID_STR.replace(",", " ").split():
        try: ALLOWED_CHATS.add(int(cid))
        except: pass

STATE_FILE = Path.home() / ".openclaw" / "workspace" / "mc_skill_bot_state.json"
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)

def load_offset():
    try: return json.loads(STATE_FILE.read_text()).get("offset", 0)
    except: return 0

def save_offset(offset):
    STATE_FILE.write_text(json.dumps({"offset": offset}))

# ── Telegram helpers ──────────────────────────────────────────────────────────
def tg(method, **kwargs):
    try:
        r = requests.post(f"https://api.telegram.org/bot{BOT_TOKEN}/{method}",
                          json=kwargs, timeout=20)
        return r.json()
    except Exception as e:
        print(f"[tg] {method} error: {e}")
        return {}

def send(chat_id, text, reply_to=None, parse_mode="Markdown"):
    chunks = [text[i:i+4000] for i in range(0, len(text), 4000)] if len(text) > 4000 else [text]
    for i, chunk in enumerate(chunks):
        payload = {"chat_id": chat_id, "text": chunk, "parse_mode": parse_mode}
        if reply_to and i == 0:
            payload["reply_to_message_id"] = reply_to
        tg("sendMessage", **payload)

def send_typing(chat_id):
    tg("sendChatAction", chat_id=chat_id, action="typing")

def download_image(file_id):
    r = tg("getFile", file_id=file_id)
    path = r.get("result", {}).get("file_path")
    if not path:
        return None
    resp = requests.get(f"https://api.telegram.org/file/bot{BOT_TOKEN}/{path}", timeout=20)
    return resp.content if resp.ok else None

def get_updates(offset):
    r = tg("getUpdates", offset=offset, timeout=30, allowed_updates=["message"])
    return r.get("result", [])

# ── Routing ───────────────────────────────────────────────────────────────────
PINE_KEYWORDS = ["pine", "tradingview", "indicator", "pine script", "pinescript", "strategy script"]

def route_text(text: str) -> str:
    t = text.lower()
    if any(k in t for k in PINE_KEYWORDS): return "pine"
    return "vibe"

# ── Claude CLI helpers ────────────────────────────────────────────────────────
VISION_SYSTEM = (
    "You are Mission Control's trading analyst. Analyze this trading image concisely.\n"
    "Identify type first: CHART / PORTFOLIO / BACKTEST / OPTIONS_FLOW / OTHER\n"
    "CHART: market structure, key levels, bias, actionable insight.\n"
    "PORTFOLIO: allocation, risk exposure, what stands out.\n"
    "BACKTEST: metrics verdict, strategy viability.\n"
    "OPTIONS_FLOW: signal quality, smart money read.\n"
    "Max 350 words. Bullet points. Be direct."
)

PINE_SYSTEM = (
    "You are a Pine Script v6 expert. Write clean, production-ready Pine Script v6.\n"
    "Rules: always //@version=6, never split ternary across lines, handle na values, "
    "add input groups and tooltips.\n"
    "Return the Pine Script in a code block then 3 bullet points explaining it."
)

def run_claude(prompt: str, system: str = "", timeout: int = 90) -> str:
    """Call claude -p with a text prompt using the existing OAuth session."""
    cmd = [CLAUDE_BIN, "-p", "--permission-mode", "auto"]
    if system:
        cmd += ["--system-prompt", system]
    try:
        r = subprocess.run(cmd, input=prompt, capture_output=True, text=True, timeout=timeout)
        return r.stdout.strip() or r.stderr.strip() or "No response."
    except subprocess.TimeoutExpired:
        return "⏱️ Timed out."
    except Exception as e:
        return f"❌ Error: {e}"

def run_claude_vision(image_bytes: bytes, prompt: str, timeout: int = 90) -> str:
    """Call claude -p with base64 image via stream-json (existing OAuth)."""
    b64 = base64.standard_b64encode(image_bytes).decode()
    content = [
        {"type": "image", "source": {"type": "base64", "media_type": "image/png", "data": b64}},
        {"type": "text", "text": prompt},
    ]
    message = json.dumps({"role": "user", "content": content})
    cmd = [CLAUDE_BIN, "-p", "--input-format", "stream-json",
           "--output-format", "text", "--permission-mode", "auto",
           "--system-prompt", VISION_SYSTEM]
    try:
        r = subprocess.run(cmd, input=message, capture_output=True, text=True, timeout=timeout)
        return r.stdout.strip() or r.stderr.strip() or "No response."
    except subprocess.TimeoutExpired:
        return "⏱️ Vision timed out."
    except Exception as e:
        return f"❌ Vision error: {e}"

def run_vibe(prompt: str, timeout: int = 120) -> str:
    env = os.environ.copy()
    env_file = Path.home() / ".vibe-trading" / ".env"
    if env_file.exists():
        for line in env_file.read_text().splitlines():
            if "=" in line and not line.startswith("#"):
                k, _, v = line.partition("=")
                env[k.strip()] = v.strip()
    try:
        r = subprocess.run([VIBE_BIN, "-p", prompt, "--no-rich"],
                           capture_output=True, text=True, timeout=timeout, env=env)
        out = r.stdout.strip()
        lines = out.split("\n")
        start, end = 0, len(lines)
        for i, line in enumerate(lines):
            if line.startswith("Prompt:"): start = i + 1
            if line.startswith("--show ") or line.startswith("Status: "):
                end = i; break
        return "\n".join(lines[start:end]).strip() or "No output."
    except subprocess.TimeoutExpired:
        return "⏱️ vibe-trading timed out. Try a simpler prompt."
    except Exception as e:
        return f"❌ vibe-trading error: {e}"

# ── Handlers ──────────────────────────────────────────────────────────────────
def handle_image(chat_id, image_bytes, caption, msg_id):
    send_typing(chat_id)
    prompt = caption if caption else "Analyze this trading image."
    result = run_claude_vision(image_bytes, prompt)
    send(chat_id, f"📊 *Analysis*\n\n{result}", reply_to=msg_id)
    if caption and any(w in caption.lower() for w in ["backtest", "run", "optimize"]):
        send_typing(chat_id)
        send(chat_id, run_vibe(caption), reply_to=msg_id)

def handle_text(chat_id, text, msg_id):
    t = text.strip()

    if t.startswith("/start"):
        send(chat_id,
             "👋 *Mission Control Skill Bot*\n\n"
             "Send me:\n"
             "• 📸 Chart screenshot → SMC / pattern analysis\n"
             "• 📸 Portfolio screenshot → allocation read\n"
             "• 💬 Any question → vibe-trading research\n"
             "• `/vt <prompt>` → vibe-trading directly\n"
             "• `/pine <idea>` → Pine Script generated\n"
             "• `/skills` → list vibe-trading skills\n"
             "• `/help` → this message", reply_to=msg_id)
        return
    if t.startswith("/help"):
        send(chat_id,
             "🛠️ *Commands*\n\n"
             "`/vt <prompt>` — research, backtest, analysis\n"
             "`/pine <idea>` — Pine Script indicator/strategy\n"
             "`/skills` — list all vibe-trading skills\n\n"
             "Or just send any text or image — I route it automatically.", reply_to=msg_id)
        return
    if t.startswith("/skills"):
        send_typing(chat_id)
        try:
            r = subprocess.run([VIBE_BIN, "--skills", "--no-rich"],
                               capture_output=True, text=True, timeout=10)
            send(chat_id, f"📚 *Skills*\n```\n{r.stdout[:3500]}\n```", reply_to=msg_id)
        except Exception as e:
            send(chat_id, f"Error: {e}", reply_to=msg_id)
        return
    if t.startswith("/vt "):
        send_typing(chat_id)
        send(chat_id, "🔬 Running...", reply_to=msg_id)
        send(chat_id, run_vibe(t[4:].strip()), reply_to=msg_id)
        return
    if t.startswith("/pine "):
        send_typing(chat_id)
        send(chat_id, run_claude(t[6:].strip(), system=PINE_SYSTEM), reply_to=msg_id)
        return

    live_ctx = get_live_context()
    send_typing(chat_id)
    if route_text(t) == "pine":
        send(chat_id, run_claude(t, system=PINE_SYSTEM), reply_to=msg_id)
    else:
        send(chat_id, "🔬 Analyzing...", reply_to=msg_id)
        full_prompt = f"{live_ctx}\n\n{t}" if live_ctx else t
        send(chat_id, run_vibe(full_prompt), reply_to=msg_id)

# ── Main loop ─────────────────────────────────────────────────────────────────
def process_message(msg):
    chat_id = msg.get("chat", {}).get("id")
    msg_id  = msg.get("message_id")
    user    = msg.get("from", {}).get("username", "?")

    if not chat_id:
        return
    if ALLOWED_CHATS and chat_id not in ALLOWED_CHATS:
        print(f"[bot] ignoring chat {chat_id}")
        return

    photos  = msg.get("photo")
    caption = msg.get("caption", "").strip()
    if photos:
        print(f"[bot] image from @{user}")
        largest = max(photos, key=lambda p: p.get("file_size", 0))
        image_bytes = download_image(largest["file_id"])
        if image_bytes:
            handle_image(chat_id, image_bytes, caption, msg_id)
        else:
            send(chat_id, "❌ Could not download image.", reply_to=msg_id)
        return

    # Document (e.g. PNG sent as file)
    doc = msg.get("document")
    if doc and doc.get("mime_type", "").startswith("image/"):
        print(f"[bot] image-doc from @{user} in {chat_id}")
        image_bytes = download_image(doc["file_id"])
        if image_bytes:
            handle_image(chat_id, image_bytes, caption or msg.get("text", ""), msg_id)
        return

    # Text message
    text = msg.get("text", "").strip()
    if text:
        print(f"[bot] text from @{user}: {text[:60]}")
        handle_text(chat_id, text, msg_id)

def main():
    print(f"[{datetime.now():%Y-%m-%d %H:%M}] MC Skill Bot starting")
    print(f"  Token : ...{BOT_TOKEN[-8:]}")
    print(f"  Vision: claude CLI (stream-json, OAuth)")
    print(f"  Vibe  : {VIBE_BIN}")
    print(f"  Chats : {ALLOWED_CHATS or 'open'}")

    offset = load_offset()
    while True:
        try:
            updates = get_updates(offset)
            for upd in updates:
                offset = upd["update_id"] + 1
                save_offset(offset)
                msg = upd.get("message")
                if msg:
                    process_message(msg)
        except KeyboardInterrupt:
            print("\n[bot] shutting down")
            break
        except Exception as e:
            print(f"[bot] poll error: {e}")
            time.sleep(5)
        time.sleep(1)

if __name__ == "__main__":
    main()
