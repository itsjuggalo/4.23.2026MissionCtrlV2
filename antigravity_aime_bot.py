#!/usr/bin/env python3
"""
AntiGravityG59Laptop Telegram Bot — AIME relay + local copilot pin-mode
Default: relays messages to tech.ainvest.com AIME.
Pin-mode (AIME-style @): /agent <name> pins a local Claude agent for the chat —
all messages then run headless `claude -p "/ainvest ..."` on the laptop
(offline-first copilot, subscription billing). /exit unpins. /ainvest <q> = one-shot.
"""
import json, os, subprocess, time, secrets, sys
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw/secrets"
BOT_TOKEN = (SECRETS / "telegram_antigravity_bot_token").read_text().strip()
COOKIE    = (SECRETS / "ainvest_cookie.txt").read_text().strip()
USER_ID   = "1844221468"

TG_BASE   = f"https://api.telegram.org/bot{BOT_TOKEN}"
AIME_URL  = "https://tech.ainvest.com/gateway/aime/stream-query"
AIME_HDRS = {
    "content-type": "application/json",
    "accept":        "text/event-stream",
    "x-source":      "ths_wencai_international_pc_robot",
    "Cookie":        COOKIE,
}

TG_MAX = 4096

# --- local copilot pin-mode (AIME @-agent equivalent) -------------------------
PIN_FILE   = Path.home() / ".openclaw/data/antigravity_pins.json"
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")  # subscription CLI, not API wrapper
CLAUDE_CWD = str(Path.home())  # home project = trusted settings/allowlists
# read-only analysis surface; local routes are owner-gated below anyway
CLAUDE_TOOLS = "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"
try:  # only Mike's DM may reach the local copilot (AIME relay stays open to all)
    OWNER_CHATS = {(SECRETS / "telegram-chat-id.txt").read_text().strip()}
except Exception:
    OWNER_CHATS = set()
PIN_AGENTS = {
    "copilot":  "ainvest-copilot",  "analysis": "ainvest-copilot",
    "screener": "ainvest-screener", "screen":   "ainvest-screener",
    "charts":   "ainvest-charts",   "chart":    "ainvest-charts",
    "news":     "ainvest-news",
    "predict":  "ainvest-predict",  "forecast": "ainvest-predict",
    "crypto":   "crypto-sniper",
    "options":  "options-desk",     # routes to the options-desk master skill
}

def load_pins() -> dict:
    try:
        return json.loads(PIN_FILE.read_text())
    except Exception:
        return {}

def save_pins(pins: dict):
    PIN_FILE.parent.mkdir(parents=True, exist_ok=True)
    PIN_FILE.write_text(json.dumps(pins))

def ask_local(question: str, agent: str | None = None) -> str:
    """Headless laptop copilot via claude -p (same pattern as flow_digest_cron.sh)."""
    if agent == "options-desk":
        prompt = f"/options-desk {question}"
    elif agent and agent != "ainvest-copilot":
        prompt = f"/ainvest [vertical={agent.removeprefix('ainvest-')}] {question}"
    else:
        prompt = f"/ainvest {question}"
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", prompt, "--model", "sonnet", "--output-format", "json",
             "--allowedTools", CLAUDE_TOOLS],
            capture_output=True, text=True, timeout=300, env=env, cwd=CLAUDE_CWD)
        if r.returncode != 0:
            return f"[copilot error rc={r.returncode}] {r.stderr.strip()[:300]}"
        out = json.loads(r.stdout)
        return (out.get("result") or "").strip() or "[copilot returned empty]"
    except subprocess.TimeoutExpired:
        return "[copilot timeout after 300s]"
    except Exception as e:
        return f"[copilot error] {e}"

def tg(method, req_timeout=10, **kwargs):
    r = requests.post(f"{TG_BASE}/{method}", json=kwargs, timeout=req_timeout)
    return r.json()

def ask_aime(question: str) -> str:
    payload = {
        "question":    question,
        "input_type":  "typewrite",
        "session_id":  secrets.token_hex(16),
        "user_id":     USER_ID,
        "source":      "ths_wencai_international_pc_robot",
        "events":      [{"event_name": "auto_agent", "event_type": "user_input"}],
        "entity_info": {"comefrom": "WebaimeRobot", "device_type": "pc"},
        "add_info":    {"async_generate_data": True, "urp": {"component_version": "1.1.3"}},
        "log_info":    {},
        "version":     "3.4.1",
        "suggest_resultpage_only": True,
    }
    answer = ""
    with requests.post(AIME_URL, headers=AIME_HDRS, json=payload,
                       stream=True, timeout=120) as r:
        if r.status_code != 200:
            return f"[AIME HTTP {r.status_code}]"
        buf = ""
        for chunk in r.iter_content(chunk_size=None):
            if not chunk:
                continue
            buf += chunk.decode("utf-8", errors="replace")
            while "\n" in buf:
                line, buf = buf.split("\n", 1)
                if not line.startswith("data:"):
                    continue
                try:
                    ev  = json.loads(line[5:])
                    sec = ev.get("section", {})
                    if (ev.get("answer_path") == "other/openAnswer"
                            and sec.get("show_type") == "rich_text"):
                        answer += sec.get("text_answer", "")
                        if sec.get("is_last"):
                            return answer.strip()
                except Exception:
                    pass
    return answer.strip() or "[No answer received from AIME]"

def send_reply(chat_id: int, text: str):
    text = text or "[empty]"
    for i in range(0, len(text), TG_MAX):
        tg("sendMessage", chat_id=chat_id, text=text[i:i + TG_MAX])

def main():
    print("AntiGravityG59Laptop AIME bot started", flush=True)
    offset = 0
    while True:
        try:
            data = tg("getUpdates", req_timeout=35, offset=offset, timeout=25,
                      allowed_updates=["message"])
            if not data.get("ok"):
                print(f"getUpdates not ok: {data}", flush=True)
                time.sleep(5)
                continue

            for upd in data.get("result", []):
                offset = upd["update_id"] + 1
                msg     = upd.get("message", {})
                chat_id = msg.get("chat", {}).get("id")
                text    = (msg.get("text") or "").strip()

                if not chat_id or not text:
                    continue

                pins = load_pins()
                key  = str(chat_id)
                is_owner = key in OWNER_CHATS

                # --- pin-mode commands (AIME @-agent equivalent, owner-only) ---
                if text.startswith(("/agent", "/exit", "/ainvest")) and not is_owner:
                    continue  # local copilot = Mike's DM only; others get AIME relay
                if text.startswith("/agent"):
                    arg = text.split(maxsplit=1)[1].strip().lower() if " " in text else ""
                    if arg in PIN_AGENTS:
                        pins[key] = PIN_AGENTS[arg]
                        save_pins(pins)
                        tg("sendMessage", chat_id=chat_id,
                           text=f"📌 dialogue with {PIN_AGENTS[arg]} — /exit to unpin")
                    else:
                        tg("sendMessage", chat_id=chat_id,
                           text="agents: " + ", ".join(sorted(set(PIN_AGENTS))))
                    continue
                if text.startswith("/exit"):
                    if pins.pop(key, None):
                        save_pins(pins)
                        tg("sendMessage", chat_id=chat_id, text="📍 unpinned — back to AIME relay")
                    continue
                if text.startswith("/ainvest"):
                    q = text.split(maxsplit=1)[1].strip() if " " in text else ""
                    if q:
                        tg("sendChatAction", chat_id=chat_id, action="typing")
                        send_reply(chat_id, ask_local(q))
                    continue
                if text.startswith("/"):
                    continue

                print(f"[{chat_id}] Q: {text[:120]}", flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")

                try:
                    pinned = pins.get(key)
                    answer = ask_local(text, agent=pinned) if pinned else ask_aime(text)
                    send_reply(chat_id, answer)
                    print(f"[{chat_id}] A({'local:'+pinned if pinned else 'aime'}): {len(answer)} chars", flush=True)
                except Exception as e:
                    err = f"⚠️ bot error: {e}"
                    tg("sendMessage", chat_id=chat_id, text=err)
                    print(f"[{chat_id}] ERR: {e}", flush=True)

        except Exception as e:
            print(f"Poll loop error: {e}", flush=True)
            time.sleep(5)

if __name__ == "__main__":
    main()
