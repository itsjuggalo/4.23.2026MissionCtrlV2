#!/usr/bin/env python3
"""Grok Telegram Bot — webhook + streaming + short history."""

import json
import sys
import threading
import time
import requests
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
from context_builder import get_live_context

SECRETS = Path.home() / ".openclaw" / "secrets"
DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)

BOT_TOKEN = (SECRETS / "telegram_grok_bot_token").read_text().strip()
API_KEY = (SECRETS / "deepseek_api_key").read_text().strip()
MODEL = "deepseek-chat"
API_URL = "https://api.deepseek.com/chat/completions"

SYSTEM_PROMPT = (
    "You are Grok, a Mission Control trading agent. "
    "Be concise, direct, and a bit witty. "
    "Help with trading analysis, market insights, and strategy discussions. "
    "When discussing any options signal or flow alert, ALWAYS include the full contract spec: "
    "ticker, CALL or PUT, strike price, and expiration date. Never omit these details. "
    "Format signals as: TICKER CALL/PUT $STRIKE exp YYYY-MM-DD."
)

MAX_HISTORY = 8   # last 8 messages (4 user+assistant pairs)
EDIT_INTERVAL = 1.0  # seconds between progressive Telegram message edits

conversations = {}


def log_usage(input_tokens, output_tokens):
    try:
        import sys
        sys.path.insert(0, str(Path.home() / "mission-control-restored" / "bots"))
        from usage_logger import log_usage as _log
        _log("grok-bot", "deepseek", MODEL, input_tokens, output_tokens)
    except Exception as e:
        print(f"  [usage] skipped: {e}")


def send_message(chat_id, text, reply_to=None):
    """Send a new Telegram message. Returns message_id of the last sent chunk."""
    chunks = [text[i:i+4000] for i in range(0, len(text), 4000)] if len(text) > 4000 else [text]
    last_id = None
    for chunk in chunks:
        payload = {"chat_id": chat_id, "text": chunk}
        if reply_to:
            payload["reply_to_message_id"] = reply_to
        try:
            r = requests.post(
                f"https://api.telegram.org/bot{BOT_TOKEN}/sendMessage",
                json=payload,
                timeout=15,
            )
            if r.ok:
                last_id = r.json()["result"]["message_id"]
        except Exception as e:
            print(f"  [send] error: {e}")
    return last_id


def edit_message(chat_id, message_id, text):
    """Edit an existing Telegram message in-place (rate-limited by caller)."""
    try:
        requests.post(
            f"https://api.telegram.org/bot{BOT_TOKEN}/editMessageText",
            json={"chat_id": chat_id, "message_id": message_id, "text": text[:4096]},
            timeout=10,
        )
    except Exception as e:
        print(f"  [edit] error: {e}")


def call_grok_stream(messages, chat_id, placeholder_id):
    """Stream from xAI API and progressively edit the Telegram placeholder."""
    try:
        r = requests.post(
            API_URL,
            headers={
                "Authorization": f"Bearer {API_KEY}",
                "Content-Type": "application/json",
            },
            json={
                "model": MODEL,
                "messages": messages,
                "max_tokens": 1024,
                "temperature": 0.7,
                "reasoning_effort": "low",
                "stream": True,
            },
            stream=True,
            timeout=90,
        )
        if r.status_code != 200:
            err = f"Grok API error: {r.status_code}"
            edit_message(chat_id, placeholder_id, err)
            return err

        buffer = ""
        last_edit = 0
        prompt_tokens = completion_tokens = 0

        for line in r.iter_lines():
            if not line:
                continue
            decoded = line.decode("utf-8")
            if not decoded.startswith("data: "):
                continue
            data_str = decoded[6:]
            if data_str == "[DONE]":
                break
            try:
                data = json.loads(data_str)
                delta = data["choices"][0]["delta"].get("content", "")
                if delta:
                    buffer += delta
                    now = time.time()
                    if now - last_edit >= EDIT_INTERVAL:
                        edit_message(chat_id, placeholder_id, buffer + " ▍")
                        last_edit = now
                usage = data.get("usage")
                if usage:
                    prompt_tokens = usage.get("prompt_tokens", 0)
                    completion_tokens = usage.get("completion_tokens", 0)
            except Exception:
                continue

        if buffer:
            edit_message(chat_id, placeholder_id, buffer)
        if prompt_tokens or completion_tokens:
            log_usage(prompt_tokens, completion_tokens)
        return buffer

    except Exception as e:
        err = f"Error calling Grok: {e}"
        edit_message(chat_id, placeholder_id, err)
        return err


def handle_message(msg):
    chat_id = msg.get("chat", {}).get("id")
    text = msg.get("text", "").strip()
    msg_id = msg.get("message_id")
    user = msg.get("from", {}).get("username", "user")

    if not text or not chat_id:
        return

    if text.startswith("/start"):
        conversations[chat_id] = []
        send_message(
            chat_id,
            "Hey! I'm Grok, connected to Mission Control. Ask me anything about trading, markets, or your portfolio.",
        )
        return

    if text.startswith("/reset") or text.startswith("/clear"):
        conversations[chat_id] = []
        send_message(chat_id, "Conversation reset.")
        return

    print(f"[grok] {user} (chat {chat_id}): {text[:80]}", flush=True)

    history = conversations.get(chat_id, [])
    live_ctx = get_live_context()
    system_content = SYSTEM_PROMPT + ("\n\n" + live_ctx if live_ctx else "")
    messages = [{"role": "system", "content": system_content}]
    messages.extend(history[-MAX_HISTORY:])
    messages.append({"role": "user", "content": text})

    # Send placeholder immediately; stream the real response into it
    placeholder_id = send_message(chat_id, "⏳", reply_to=msg_id)
    response = call_grok_stream(messages, chat_id, placeholder_id)

    history.append({"role": "user", "content": text})
    history.append({"role": "assistant", "content": response})
    conversations[chat_id] = history[-MAX_HISTORY:]

    print(f"  [grok] replied ({len(response)} chars)", flush=True)


def poll_loop():
    """Long-poll getUpdates. Laptop migration 2026-06-16: was a Flask webhook on
    :8444; converted to polling so grok-bot needs no public endpoint. deleteWebhook
    switches Telegram push→poll; only ONE poller may hold this token (Oracle's
    grok-bot is stopped at cutover)."""
    base = f"https://api.telegram.org/bot{BOT_TOKEN}"
    try:
        requests.post(f"{base}/deleteWebhook", json={"drop_pending_updates": False}, timeout=10)
    except Exception as e:
        print(f"[grok] deleteWebhook warn: {e}", flush=True)
    print(f"[grok] polling getUpdates — model {MODEL}", flush=True)
    offset = 0
    while True:
        try:
            r = requests.get(f"{base}/getUpdates",
                             params={"offset": offset, "timeout": 50}, timeout=60).json()
            for upd in r.get("result", []):
                offset = upd["update_id"] + 1
                msg = upd.get("message") or upd.get("channel_post")
                if msg:
                    threading.Thread(target=handle_message, args=(msg,), daemon=True).start()
                mcm = upd.get("my_chat_member")
                if mcm:
                    chat = mcm.get("chat", {})
                    new_status = mcm.get("new_chat_member", {}).get("status")
                    print(f"[grok] chat_member update: chat_id={chat.get('id')} title={chat.get('title')!r} status={new_status}", flush=True)
                    if new_status == "member" and chat.get("id"):
                        send_message(chat.get("id"), "👋 Grok online — I see live flow + analyst signals. Ask me anything.")
        except Exception as e:
            print(f"[grok] poll error: {e}", flush=True)
            time.sleep(3)


if __name__ == "__main__":
    print("[grok] Grok Telegram bot starting (polling mode)", flush=True)
    poll_loop()
