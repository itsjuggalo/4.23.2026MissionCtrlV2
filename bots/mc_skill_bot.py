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
import uuid
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

BOT_TOKEN   = get_secret("telegram_laptopclaude_bot_token") or get_secret("telegram_mc_skill_bot_token") or get_secret("telegram-bot-token")
CHAT_ID_STR = get_secret("telegram-chat-id")
VIBE_BIN    = "/home/itsju/02_DATA/mc-kb/.venv/bin/vibe-trading"
VENV_PYTHON = "/home/itsju/mc-kb/.venv/bin/python"
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

# Conversation state — keyed by chat_id
# Each entry: {"session_id": str, "history": [...], "last_active": float}
# History entries: {"role": "user"|"assistant", "content": str}
SESSION_TIMEOUT = 1200   # 20 min inactivity clears the session
MAX_HISTORY     = 8      # max messages kept (4 exchanges)
conversations: dict = {}

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
    # timeout=10 (short poll) avoids WSL2 SSL EOF errors from long-hanging connections
    r = tg("getUpdates", offset=offset, timeout=10, allowed_updates=["message"])
    return r.get("result", [])

# ── Conversation history ──────────────────────────────────────────────────────
def get_session(chat_id: int) -> dict:
    now = time.time()
    s = conversations.get(chat_id)
    if s and (now - s["last_active"]) > SESSION_TIMEOUT:
        s = None
    if not s:
        s = {"session_id": str(uuid.uuid4()), "history": [], "last_active": now}
        conversations[chat_id] = s
    s["last_active"] = now
    return s

def clear_session(chat_id: int):
    conversations.pop(chat_id, None)

def add_to_history(chat_id: int, role: str, content: str):
    s = conversations.get(chat_id)
    if not s:
        return
    s["history"].append({"role": role, "content": content})
    if len(s["history"]) > MAX_HISTORY:
        s["history"] = s["history"][-MAX_HISTORY:]

def build_history_prefix(chat_id: int) -> str:
    s = conversations.get(chat_id)
    if not s or not s["history"]:
        return ""
    lines = ["[Conversation so far — continue from here:]\n"]
    for m in s["history"]:
        label = "User" if m["role"] == "user" else "Assistant"
        lines.append(f"{label}: {m['content']}")
    lines.append("\n[End of history — now respond to the new message below]")
    return "\n".join(lines) + "\n\n"

# ── Routing ───────────────────────────────────────────────────────────────────
PINE_KEYWORDS = ["pine", "tradingview", "indicator", "pine script", "pinescript", "strategy script"]
SYSTEM_KEYWORDS = ["voicepack", "voice pack", "peon", "peon-ping", "warroom", "war room",
                   "config", "switch voice", "switch pack", "sound pack", "persona", "agent voice",
                   "gemini voice", "cartesia", "tts", "text to speech"]

def route_text(text: str) -> str:
    t = text.lower()
    if any(k in t for k in PINE_KEYWORDS): return "pine"
    if any(k in t for k in SYSTEM_KEYWORDS): return "claude"
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

MC_SYSTEM = (
    "You are LaptopClaude, the Mission Control AI assistant running on Mike's laptop (WSL2/Ubuntu). "
    "You have full filesystem access via Claude Code tools. "
    "Key system facts: "
    "voicepacks/soundpacks live in peon-ping (~/.claude/hooks/peon-ping/), config at ~/.claude/hooks/peon-ping/config.json; "
    "trading bots (Boba, Jazzy) run via PM2; "
    "dashboard is ~/01_ACTIVE/sites/missioncontrol/MissionCtrlV2/ on port 3000; "
    "knowledge base at ~/mc-kb/ (query with python ~/mc-kb/query.py). "
    "When asked about system config, hooks, voicepacks, or local setup — read the actual files, don't guess. "
    "Be concise and direct."
)

BOT_LOCK = Path("/tmp/mc_bot_subprocess")

def _bot_env():
    env = os.environ.copy()
    env["MC_BOT_SUBPROCESS"] = "1"  # belt-and-suspenders; primary signal is BOT_LOCK file
    return env

def _strip_model_lines(text: str) -> str:
    """Remove model-name lines like [opus], [sonnet], [haiku] from CLI output."""
    lines = text.split("\n")
    cleaned = [l for l in lines if not (l.strip().startswith("[") and l.strip().endswith("]") and " " not in l.strip())]
    return "\n".join(cleaned).strip()

def run_claude(prompt: str, system: str = "", timeout: int = 90, history_prefix: str = "") -> str:
    """Call claude -p with a text prompt using the existing OAuth session."""
    cmd = [CLAUDE_BIN, "-p", "--output-format", "text", "--permission-mode", "auto"]
    if system:
        cmd += ["--system-prompt", system]
    full_prompt = history_prefix + prompt if history_prefix else prompt
    BOT_LOCK.touch()
    try:
        r = subprocess.run(cmd, input=full_prompt, capture_output=True, text=True, timeout=timeout, env=_bot_env())
        out = r.stdout.strip() or r.stderr.strip() or "No response."
        return _strip_model_lines(out) or "No response."
    except subprocess.TimeoutExpired:
        return "⏱️ Timed out."
    except Exception as e:
        return f"❌ Error: {e}"
    finally:
        BOT_LOCK.unlink(missing_ok=True)

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
    BOT_LOCK.touch()
    try:
        r = subprocess.run(cmd, input=message, capture_output=True, text=True, timeout=timeout, env=_bot_env())
        return r.stdout.strip() or r.stderr.strip() or "No response."
    except subprocess.TimeoutExpired:
        return "⏱️ Vision timed out."
    except Exception as e:
        return f"❌ Vision error: {e}"
    finally:
        BOT_LOCK.unlink(missing_ok=True)

def run_vibe(prompt: str, timeout: int = 120, history_prefix: str = "") -> str:
    env = _bot_env()
    env_file = Path.home() / ".vibe-trading" / ".env"
    if env_file.exists():
        for line in env_file.read_text().splitlines():
            if "=" in line and not line.startswith("#"):
                k, _, v = line.partition("=")
                env[k.strip()] = v.strip()
    full_prompt = history_prefix + prompt if history_prefix else prompt
    BOT_LOCK.touch()
    try:
        r = subprocess.run([VIBE_BIN, "-p", full_prompt, "--no-rich"],
                           capture_output=True, text=True, timeout=timeout, env=env)
        out = r.stdout.strip()
        lines = out.split("\n")
        start, end = 0, len(lines)
        for i, line in enumerate(lines):
            if line.startswith("Prompt:"): start = i + 1
            if line.startswith("--show ") or line.startswith("Status: "):
                end = i; break
        cleaned = [l for l in lines[start:end] if not (l.strip().startswith("[") and l.strip().endswith("]") and " " not in l.strip())]
        return "\n".join(cleaned).strip() or "No output."
    except subprocess.TimeoutExpired:
        return "⏱️ vibe-trading timed out. Try a simpler prompt."
    except Exception as e:
        return f"❌ vibe-trading error: {e}"
    finally:
        BOT_LOCK.unlink(missing_ok=True)

# ── Chart generation ─────────────────────────────────────────────────────────
import re as _re
import tempfile as _tempfile

_INDEX_MAP  = {"SPX": "^GSPC", "NDX": "^NDX", "VIX": "^VIX", "RUT": "^RUT", "DJI": "^DJI", "SPY": "SPY", "QQQ": "QQQ"}
_SKIP_WORDS = {"CALL", "PUT", "EXP", "TARGET", "STOP", "THE", "FOR", "AND", "ALL", "TOP", "DAY",
               "BEST", "NEW", "SET", "BUY", "MAY", "ARE", "HAS", "ITS", "OUR", "CAN"}

def extract_ticker(text: str) -> str:
    candidates = _re.findall(r'\b([A-Z]{1,5})\b', text)
    for c in candidates:
        if c not in _SKIP_WORDS and len(c) >= 2:
            return _INDEX_MAP.get(c, c)
    return ""

_CHART_CODE = '''
import sys, warnings
warnings.filterwarnings("ignore")
ticker, out_path = sys.argv[1], sys.argv[2]
try:
    import yfinance as yf, mplfinance as mpf, matplotlib
    matplotlib.use("Agg")
    df = yf.download(ticker, period="60d", interval="1d", progress=False, auto_adjust=True)
    if df.empty: sys.exit(1)
    if hasattr(df.columns, "levels"): df.columns = df.columns.get_level_values(0)
    df["EMA20"] = df["Close"].ewm(span=20).mean()
    df["EMA50"] = df["Close"].ewm(span=50).mean()
    d = df["Close"].diff(); g = d.where(d>0,0).rolling(14).mean(); l = (-d.where(d<0,0)).rolling(14).mean()
    df["RSI"] = 100-(100/(1+g/l.replace(0,1e-10)))
    ap = [mpf.make_addplot(df["EMA20"],color="#2196F3",width=1.2),
          mpf.make_addplot(df["EMA50"],color="#FF9800",width=1.2),
          mpf.make_addplot(df["RSI"],panel=2,color="#9C27B0",width=1,ylabel="RSI")]
    mc = mpf.make_marketcolors(up="#26a69a",down="#ef5350",inherit=True)
    s  = mpf.make_mpf_style(marketcolors=mc,gridstyle="--",figcolor="#1a1a2e",facecolor="#1a1a2e",
                             edgecolor="#333",gridcolor="#333",y_on_right=False,
                             rc={"axes.labelcolor":"#ccc","xtick.color":"#ccc","ytick.color":"#ccc"})
    mpf.plot(df,type="candle",style=s,addplot=ap,volume=True,panel_ratios=(3,1,1),
             title=f"\\n{ticker} — 60D  |  EMA20/50 + RSI",figsize=(12,8),savefig=out_path)
    print("ok")
except Exception as e:
    print(f"error: {e}", file=sys.stderr); sys.exit(1)
'''

def generate_chart(ticker: str) -> str | None:
    safe = ticker.replace("^", "").replace("/", "_")
    out  = Path(_tempfile.gettempdir()) / f"mc_chart_{safe}.png"
    try:
        r = subprocess.run([VENV_PYTHON, "-c", _CHART_CODE, ticker, str(out)],
                           capture_output=True, text=True, timeout=30)
        if r.returncode == 0 and out.exists():
            return str(out)
        print(f"[chart] {r.stderr.strip()[:200]}")
    except Exception as e:
        print(f"[chart] {e}")
    return None

def send_photo(chat_id: int, photo_path: str, caption: str = ""):
    try:
        with open(photo_path, "rb") as f:
            requests.post(
                f"https://api.telegram.org/bot{BOT_TOKEN}/sendPhoto",
                data={"chat_id": chat_id, "caption": caption[:1000], "parse_mode": "Markdown"},
                files={"photo": f},
                timeout=30,
            )
    except Exception as e:
        print(f"[photo] {e}")

# ── Handlers ──────────────────────────────────────────────────────────────────
def handle_image(chat_id, image_bytes, caption, msg_id):
    send_typing(chat_id)
    prompt = caption if caption else "Analyze this trading image."
    result = run_claude_vision(image_bytes, prompt)
    send(chat_id, f"📊 *Analysis*\n\n{result}", reply_to=msg_id)
    add_to_history(chat_id, "user", f"[image] {prompt}")
    add_to_history(chat_id, "assistant", result)
    if caption and any(w in caption.lower() for w in ["backtest", "run", "optimize"]):
        send_typing(chat_id)
        vibe_result = run_vibe(caption)
        send(chat_id, vibe_result, reply_to=msg_id)

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
             "• `/new` → start a fresh conversation\n"
             "• `/help` → this message", reply_to=msg_id)
        return
    if t.startswith("/help"):
        send(chat_id,
             "🛠️ *Commands*\n\n"
             "`/vt <prompt>` — research, backtest, analysis\n"
             "`/pine <idea>` — Pine Script indicator/strategy\n"
             "`/skills` — list all vibe-trading skills\n"
             "`/new` — clear conversation history\n\n"
             "Or just send any text or image — I route it automatically.", reply_to=msg_id)
        return
    if t.startswith("/new"):
        clear_session(chat_id)
        send(chat_id, "🔄 Conversation cleared. Fresh start!", reply_to=msg_id)
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
        history_prefix = build_history_prefix(chat_id)
        result = run_vibe(t[4:].strip(), history_prefix=history_prefix)
        send(chat_id, result, reply_to=msg_id)
        add_to_history(chat_id, "user", t)
        add_to_history(chat_id, "assistant", result)
        return
    if t.startswith("/pine "):
        send_typing(chat_id)
        result = run_claude(t[6:].strip(), system=PINE_SYSTEM)
        send(chat_id, result, reply_to=msg_id)
        add_to_history(chat_id, "user", t)
        add_to_history(chat_id, "assistant", result)
        return

    # Ensure session exists before routing
    get_session(chat_id)
    history_prefix = build_history_prefix(chat_id)

    live_ctx = get_live_context()
    send_typing(chat_id)
    route = route_text(t)
    print(f"[route] '{t[:60]}' → {route}")
    if route == "pine":
        result = run_claude(t, system=PINE_SYSTEM, history_prefix=history_prefix)
        send(chat_id, result, reply_to=msg_id)
    elif route == "claude":
        result = run_claude(t, system=MC_SYSTEM, history_prefix=history_prefix)
        send(chat_id, result, reply_to=msg_id)
    else:
        send(chat_id, "🔬 Analyzing...", reply_to=msg_id)
        base_prompt = f"{live_ctx}\n\n{t}" if live_ctx else t
        result = run_vibe(base_prompt)
        print(f"[vibe_raw] {repr(result[:200])}")
        send(chat_id, result, reply_to=msg_id)
        ticker = extract_ticker(result)
        if ticker:
            chart_path = generate_chart(ticker)
            if chart_path:
                send_photo(chat_id, chart_path, caption=f"📊 *{ticker}* — 60D Technical Analysis\nEMA20 (blue) · EMA50 (orange) · RSI")

    add_to_history(chat_id, "user", t)
    add_to_history(chat_id, "assistant", result)

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
