#!/usr/bin/env python3
"""
AntiGravityG59Laptop Telegram Bot — AIME relay
Polls Telegram for messages, routes to tech.ainvest.com/gateway/aime/stream-query, responds.
"""
import json, time, secrets, sys
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

def tg(method, **kwargs):
    r = requests.post(f"{TG_BASE}/{method}", json=kwargs, timeout=30)
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
            data = tg("getUpdates", offset=offset, timeout=30,
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

                if not chat_id or not text or text.startswith("/"):
                    continue

                print(f"[{chat_id}] Q: {text[:120]}", flush=True)
                tg("sendChatAction", chat_id=chat_id, action="typing")

                try:
                    answer = ask_aime(text)
                    send_reply(chat_id, answer)
                    print(f"[{chat_id}] A: {len(answer)} chars", flush=True)
                except Exception as e:
                    err = f"⚠️ AIME error: {e}"
                    tg("sendMessage", chat_id=chat_id, text=err)
                    print(f"[{chat_id}] ERR: {e}", flush=True)

        except Exception as e:
            print(f"Poll loop error: {e}", flush=True)
            time.sleep(5)

if __name__ == "__main__":
    main()
