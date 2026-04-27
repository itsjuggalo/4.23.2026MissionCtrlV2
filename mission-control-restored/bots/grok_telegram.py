#!/usr/bin/env python3
"""
Grok Telegram Bot
Polls Telegram for messages, forwards to xAI Grok API, replies in the chat.
PM2: pm2 start bots/grok_telegram.py --name grok-bot --interpreter python3
"""

import json
import os
import time
import requests
from pathlib import Path
from datetime import datetime

SECRETS = Path.home() / ".openclaw" / "secrets"
DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = DATA_DIR / "grok_bot_state.json"


def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None


BOT_TOKEN = get_secret("telegram_grok_bot_token")
API_KEY = get_secret("xai_api_key")
MODEL = "grok-3-mini"
API_URL = "https://api.x.ai/v1/chat/completions"

SYSTEM_PROMPT = "You are Grok, a Mission Control trading agent. Be concise, direct, and a bit witty. Help with trading analysis, market insights, and strategy discussions."

conversations = {}


def load_state():
    try:
        return json.loads(STATE_FILE.read_text()).get("last_update_id", 0)
    except:
        return 0


def save_state(update_id):
    STATE_FILE.write_text(json.dumps({"last_update_id": update_id}))


def log_usage(input_tokens, output_tokens):
    try:
        import sys
        sys.path.insert(0, str(Path.home() / "mission-control-restored" / "bots"))
        from usage_logger import log_usage as _log
        _log("grok-bot", "xai", MODEL, input_tokens, output_tokens)
    except Exception as e:
        print(f"  [usage] skipped: {e}")


def call_grok(messages):
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
            },
            timeout=60,
        )
        if r.status_code == 200:
            data = r.json()
            choice = data["choices"][0]["message"]["content"]
            usage = data.get("usage", {})
            log_usage(usage.get("prompt_tokens", 0), usage.get("completion_tokens", 0))
            return choice
        else:
            print(f"  [grok] API error {r.status_code}: {r.text[:200]}")
            return f"Grok API error: {r.status_code}"
    except Exception as e:
        return f"Error calling Grok: {e}"


def send_message(chat_id, text, reply_to=None):
    try:
        chunks = [text[i:i+4000] for i in range(0, len(text), 4000)] if len(text) > 4000 else [text]
        for chunk in chunks:
            payload = {"chat_id": chat_id, "text": chunk}
            if reply_to:
                payload["reply_to_message_id"] = reply_to
            requests.post(
                f"https://api.telegram.org/bot{BOT_TOKEN}/sendMessage",
                json=payload,
                timeout=15,
            )
    except Exception as e:
        print(f"  [telegram] send error: {e}")


def handle_message(msg):
    chat_id = msg.get("chat", {}).get("id")
    text = msg.get("text", "").strip()
    msg_id = msg.get("message_id")
    user = msg.get("from", {}).get("username", "user")

    if not text or not chat_id:
        return

    if text.startswith("/start"):
        send_message(chat_id, "Hey! I'm Grok, connected to Mission Control. Ask me anything about trading, markets, or your portfolio.")
        conversations[chat_id] = []
        return
    if text.startswith("/reset") or text.startswith("/clear"):
        conversations[chat_id] = []
        send_message(chat_id, "Conversation reset.")
        return

    print(f"[grok] {user} (chat {chat_id}): {text[:80]}")

    history = conversations.get(chat_id, [])
    messages = [{"role": "system", "content": SYSTEM_PROMPT}]
    messages.extend(history[-10:])
    messages.append({"role": "user", "content": text})

    response = call_grok(messages)

    history.append({"role": "user", "content": text})
    history.append({"role": "assistant", "content": response})
    conversations[chat_id] = history[-20:]

    send_message(chat_id, response, reply_to=msg_id)
    print(f"  [grok] replied ({len(response)} chars)")


def main():
    if not BOT_TOKEN:
        print("[grok] ERROR: No telegram_grok_bot_token in secrets")
        return
    if not API_KEY:
        print("[grok] ERROR: No xai_api_key in secrets")
        return

    last_id = load_state()
    print(f"[grok] Bot starting (last_id: {last_id})")
    print(f"[grok] Model: {MODEL}")

    while True:
        try:
            r = requests.get(
                f"https://api.telegram.org/bot{BOT_TOKEN}/getUpdates",
                params={"offset": last_id + 1, "timeout": 30},
                timeout=35,
            )
            if r.status_code != 200:
                print(f"[grok] Telegram error: {r.status_code}")
                time.sleep(5)
                continue

            data = r.json()
            if not data.get("ok"):
                print(f"[grok] Not ok: {data}")
                time.sleep(5)
                continue

            for update in data.get("result", []):
                update_id = update.get("update_id", 0)
                last_id = max(last_id, update_id)
                msg = update.get("message") or update.get("channel_post")
                if msg:
                    handle_message(msg)
                save_state(last_id)

        except requests.exceptions.Timeout:
            continue
        except KeyboardInterrupt:
            print("\n[grok] Shutting down")
            save_state(last_id)
            break
        except Exception as e:
            print(f"[grok] Error: {e}")
            time.sleep(5)


if __name__ == "__main__":
    main()
