#!/home/itsju/.venv/bin/python
"""LifeClaw Telegram responder — makes @LifeClaw727_Bot talk back.

Companion to the cron pusher (~/scripts/life-engine-run.py), which only SENDS
briefs. This daemon LISTENS (getUpdates long-poll) and answers Mike's messages
conversationally by shelling out to the local `claude` CLI on the subscription
wallet (ANTHROPIC_API_KEY stripped — same pattern as antigravity_aime_bot.py /
reference_claude_cli_subscription_shellout).

Scope = FULL life assistant, LIFE-ONLY (calendar / inbox / bills / weather /
todos / web), never trading. Owner-gated to Mike's chat_id.

Commands:  /brief [morning|midday|evening|nightly]  ·  /help  ·  /start
Run under PM2 `lifeclaw-bot` (see ecosystem.config.js).
"""
import json, os, subprocess, time, sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo
import requests

SECRETS     = Path.home() / ".openclaw/secrets"
BOT_TOKEN   = (SECRETS / "lifeclaw_telegram_bot_token").read_text().strip()
OWNER_CHAT  = (SECRETS / "lifeclaw_telegram_chat_id").read_text().strip()
TG_BASE     = f"https://api.telegram.org/bot{BOT_TOKEN}"
TG_MAX      = 4096
ET          = ZoneInfo("America/New_York")

CLAUDE_BIN  = str(Path.home() / ".local/bin/claude")   # subscription CLI, not API
CLAUDE_CWD  = str(Path.home())                          # home = trusted allowlists
CLAUDE_TOOLS = "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,TodoWrite"
ENGINE      = str(Path.home() / "scripts/life-engine-run.py")
ENGINE_PY   = "/home/itsju/.venv/bin/python"
CONFIG      = Path.home() / ".lifeclaw/config.json"

DEFAULT_PERSONA = (
    "You are Mike's warm, grounded life assistant and wellness coach (LifeClaw). "
    "He has ADD, so be encouraging, concrete, and zero-fluff. Eastern Time. "
    "Surface the single most useful LIFE thing right now — never trading or stocks."
)


def persona() -> str:
    try:
        return json.loads(CONFIG.read_text()).get("persona", DEFAULT_PERSONA)
    except Exception:
        return DEFAULT_PERSONA


SYSTEM_PROMPT = (
    persona()
    + " You are replying inside a Telegram chat, so keep answers short, plain-text, "
    "and skimmable (no markdown headers, no tables). You may use the `life-engine` "
    "skill and read-only tools (Bash/Read/WebFetch/WebSearch) to check his calendar, "
    "inbox, bills, weather, and todos when the question needs live data. Never act on "
    "trading/stocks. If you can't find something, say so briefly."
)


def tg(method, req_timeout=10, **kwargs):
    try:
        return requests.post(f"{TG_BASE}/{method}", json=kwargs, timeout=req_timeout).json()
    except Exception as e:
        print(f"tg {method} error: {e}", flush=True)
        return {"ok": False}


def send_reply(chat_id, text: str):
    text = text or "[empty]"
    for i in range(0, len(text), TG_MAX):
        tg("sendMessage", chat_id=chat_id, text=text[i:i + TG_MAX])


def ask_local(question: str) -> str:
    """Headless laptop copilot via `claude -p` on the subscription wallet."""
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", question,
             "--append-system-prompt", SYSTEM_PROMPT,
             "--model", "sonnet", "--output-format", "json",
             "--allowedTools", CLAUDE_TOOLS],
            capture_output=True, text=True, timeout=300, env=env, cwd=CLAUDE_CWD)
        if r.returncode != 0:
            return f"[LifeClaw brain error rc={r.returncode}] {r.stderr.strip()[:300]}"
        out = json.loads(r.stdout)
        return (out.get("result") or "").strip() or "[LifeClaw returned empty]"
    except subprocess.TimeoutExpired:
        return "[LifeClaw timed out after 300s — try a smaller question]"
    except Exception as e:
        return f"[LifeClaw error] {e}"


def _brief_for_hour(h: int) -> str:
    if 6 <= h < 11:   return "morning_brief"
    if 11 <= h < 15:  return "midday_checkin"
    if 15 <= h < 20:  return "evening_summary"
    return "nightly_wrap"


def run_brief(arg: str) -> str:
    aliases = {"morning": "morning_brief", "midday": "midday_checkin",
               "afternoon": "midday_checkin", "evening": "evening_summary",
               "night": "nightly_wrap", "nightly": "nightly_wrap"}
    bt = aliases.get(arg.strip().lower()) if arg.strip() else \
        _brief_for_hour(datetime.now(ET).hour)
    if not bt:
        return f"unknown brief '{arg}'. try: morning | midday | evening | nightly"
    try:
        subprocess.Popen([ENGINE_PY, ENGINE, "--force", bt],
                         cwd=CLAUDE_CWD,
                         stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        return f"📡 firing your {bt.replace('_', ' ')} now — incoming…"
    except Exception as e:
        return f"[brief error] {e}"


HELP = (
    "🪖 *LifeClaw* — your life copilot. Just text me like you text Claude.\n\n"
    "I can check your calendar, inbox, bills, weather, todos, and the web. Ask me "
    "things like \"what's on my calendar tomorrow?\", \"any bills due?\", "
    "\"draft a grocery list\", or just talk.\n\n"
    "Commands:\n"
    "/brief [morning|midday|evening|nightly] — send a fresh brief now\n"
    "/help — this message\n\n"
    "Life-only — for trading, use your trading bots."
)


def main():
    print("LifeClaw responder started", flush=True)
    tg("deleteWebhook")  # ensure getUpdates polling works (no competing webhook)
    offset = 0
    # Skip any backlog so we don't reply to ancient messages on first boot,
    # except keep the most recent so a just-sent message still lands.
    boot = tg("getUpdates", req_timeout=15, timeout=0)
    if boot.get("ok") and boot.get("result"):
        offset = boot["result"][-1]["update_id"]  # re-read the last one once
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
                if str(chat_id) != OWNER_CHAT:           # owner-gated
                    print(f"ignored non-owner chat {chat_id}", flush=True)
                    continue

                if text.startswith(("/help", "/start")):
                    tg("sendMessage", chat_id=chat_id, text=HELP, parse_mode="Markdown")
                    continue
                if text.startswith("/brief"):
                    arg = text.split(maxsplit=1)[1] if " " in text else ""
                    tg("sendMessage", chat_id=chat_id, text=run_brief(arg))
                    continue
                if text.startswith("/"):
                    tg("sendMessage", chat_id=chat_id,
                       text="unknown command — /help for what I can do")
                    continue

                print(f"[{chat_id}] Q: {text[:120]}", flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")
                try:
                    answer = ask_local(text)
                    send_reply(chat_id, answer)
                    print(f"[{chat_id}] A: {len(answer)} chars", flush=True)
                except Exception as e:
                    tg("sendMessage", chat_id=chat_id, text=f"⚠️ LifeClaw error: {e}")
                    print(f"[{chat_id}] ERR: {e}", flush=True)
        except Exception as e:
            print(f"Poll loop error: {e}", flush=True)
            time.sleep(5)


if __name__ == "__main__":
    main()
