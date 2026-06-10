#!/usr/bin/env python3
"""ping_mike.py — deliver an ESCALATION ping to Mike's dedicated Telegram ping channel.

ONLY for ship-judge escalations / "I need a decision" pings — deliberately SEPARATE from
briefs/alerts so a real decision request never gets buried or left unread. Briefs go to
Discord / the brief channels; this bot does nothing but pings.

One-time setup:
  1. @BotFather on Telegram → /newbot → name it (e.g. "Mike Ping") → copy the token.
  2. echo '<token>' > ~/.openclaw/secrets/telegram-ping-bot-token
  3. DM the new bot once (any message), then:  python3 ~/scripts/ping_mike.py --resolve-chat
     (captures your chat_id into ~/.openclaw/secrets/telegram-ping-chat-id + sends a test).

Usage:
  python3 ~/scripts/ping_mike.py "PING — <decision> | <why unsure> | need your call on X"
  python3 ~/scripts/ping_mike.py --resolve-chat
Exit 0 = delivered. Nonzero = NOT delivered → the caller MUST surface the ping inline instead
(a ping is never allowed to silently vanish).
"""
import json
import sys
import urllib.parse
import urllib.request
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "telegram-ping-bot-token"
CHAT_FILE = SEC / "telegram-ping-chat-id"


def _read(p: Path) -> str:
    return p.read_text().strip() if p.exists() else ""


def _api(token: str, method: str, params: dict) -> dict:
    url = f"https://api.telegram.org/bot{token}/{method}"
    data = urllib.parse.urlencode(params).encode()
    with urllib.request.urlopen(urllib.request.Request(url, data=data), timeout=15) as r:
        return json.loads(r.read())


def resolve_chat() -> int:
    token = _read(TOKEN_FILE)
    if not token:
        print(f"no ping-bot token at {TOKEN_FILE} — do the BotFather step first", file=sys.stderr)
        return 2
    res = _api(token, "getUpdates", {"limit": 5})
    chats = [u["message"]["chat"]["id"] for u in res.get("result", []) if "message" in u]
    if not chats:
        print("no updates yet — DM the bot once, then re-run --resolve-chat", file=sys.stderr)
        return 3
    chat_id = str(chats[-1])
    CHAT_FILE.write_text(chat_id)
    _api(token, "sendMessage", {
        "chat_id": chat_id,
        "text": "✅ Ping channel wired. ship-judge escalations land here — separate from briefs.",
    })
    print(f"chat_id saved: {chat_id}")
    return 0


def ping(text: str) -> int:
    token, chat = _read(TOKEN_FILE), _read(CHAT_FILE)
    if not (token and chat):
        print("PING NOT DELIVERED — ping bot not configured (token/chat_id missing). "
              "Surface the ping inline instead.", file=sys.stderr)
        return 1
    try:
        res = _api(token, "sendMessage", {
            "chat_id": chat, "text": text, "disable_web_page_preview": "true",
        })
        if res.get("ok"):
            print("ping delivered")
            return 0
        print(f"telegram error: {res} — surface inline.", file=sys.stderr)
        return 1
    except Exception as e:  # network/auth — never let a ping vanish silently
        print(f"PING NOT DELIVERED — {e} — surface inline.", file=sys.stderr)
        return 1


if __name__ == "__main__":
    if len(sys.argv) >= 2 and sys.argv[1] == "--resolve-chat":
        sys.exit(resolve_chat())
    if len(sys.argv) < 2 or not sys.argv[1].strip():
        print('usage: ping_mike.py "<message>" | --resolve-chat', file=sys.stderr)
        sys.exit(2)
    sys.exit(ping(sys.argv[1]))
