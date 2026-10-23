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
    sys.path.insert(0, "/home/itsju/scripts")
    import tg_fleet   # the confirmation is a send: through the fleet as the ping bot's lane (script-standard #6)
    tg_fleet.call("system_health", "sendMessage", chat_id=chat_id,
                  text="✅ Ping channel wired. ship-judge escalations land here — separate from briefs.")
    print(f"chat_id saved: {chat_id}")
    return 0


def ping(text: str, lane: str = "system_health") -> int:
    """Deliver `text` to a fleet lane. Default `system_health` — correct for the ~20 infra
    callers (backups, disk, boot check, cron health, watchdogs).

    2026-07-29: this is a SHARED pinger, so its default silently became the destination for
    everything that called it — including `decipher_execute.py`'s live BUY fills and
    `decipher_eod.py`'s P&L, which were landing on the infra lane wedged between disk-space
    warnings. Callers whose content is TRADE news now pass `--lane trading_command`. The
    fallback token file stays the ping bot either way, so a vault hiccup still delivers.
    2026-10-23 (script-standard #6): the raw ping-bot fallback is gone — it posted every lane's ping as the ping bot.
    tg_fleet already falls back to the lane's own token file; a failed send is reported, never silent.
    """
    try:
        sys.path.insert(0, "/home/itsju/scripts")
        from lib.notify import tg_push
        if tg_push(text, lane, loud=True, html=False):
            print(f"ping delivered ({lane})")
            return 0
        print(f"PING NOT DELIVERED — tg_fleet gave no ack for lane {lane} — surface inline.", file=sys.stderr)
    except Exception as e:  # never let a ping vanish silently
        print(f"PING NOT DELIVERED — fleet route failed: {e} — surface inline.", file=sys.stderr)
    return 1


if __name__ == "__main__":
    if len(sys.argv) >= 2 and sys.argv[1] == "--resolve-chat":
        sys.exit(resolve_chat())
    # --lane <fleet_fn> anywhere in argv; everything else is the message. Parsed by hand so
    # the 20+ existing `ping_mike.py "<msg>"` callers keep working untouched.
    args, lane = [], "system_health"
    i = 1
    while i < len(sys.argv):
        if sys.argv[i] == "--lane" and i + 1 < len(sys.argv):
            lane = sys.argv[i + 1]; i += 2; continue
        args.append(sys.argv[i]); i += 1
    if not args or not args[0].strip():
        print('usage: ping_mike.py [--lane <fleet_fn>] "<message>" | --resolve-chat',
              file=sys.stderr)
        sys.exit(2)
    sys.exit(ping(args[0], lane))
