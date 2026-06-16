"""notify — mirror a brief/pick/alert to Mike's Telegram via the bot fleet.

Routes THROUGH tg_fleet (does NOT duplicate the registry): the vault is the single
source of truth for every bot token. Two entry points, both best-effort (never raise,
never block the caller):

  tg_brief(text)        — for briefs/digests; tries `daily_briefs` then falls back to
                          `flow_digest` (a live push bot) so it reaches Mike's phone today.
  tg_push(text, fn,…)   — for a specific function bot, with HTML + loud/silent control and
                          a raw-token-file fallback so a vault hiccup can't silence a LIVE
                          trade alert. This is what the push senders migrate onto.

  from lib.notify import tg_brief, tg_push
  tg_brief("🌅 morning brief …")
  tg_push("🛑 STOP …", "flow_signals", loud=True, fallback_token_file="telegram-bot-token.txt")
"""
from __future__ import annotations

import json
import os
import subprocess
import urllib.parse
import urllib.request

PY = "/home/itsju/.venv/bin/python"
FLEET = "/home/itsju/scripts/tg_fleet.py"
SEC = os.path.expanduser("~/.openclaw/secrets")
CHAT_FILE = os.path.join(SEC, "telegram-chat-id.txt")


def tg_brief(text: str, chain=("daily_briefs", "flow_digest")) -> str | None:
    """Send via the first fleet function that has a live token. Returns the function
    used, or None if all failed / no token. Telegram caps text at 4096 chars."""
    body = text if len(text) <= 4000 else text[:3990] + "\n…(truncated)"
    for fn in chain:
        if not fn:
            continue
        try:
            r = subprocess.run([PY, FLEET, "send", fn, body],
                               capture_output=True, text=True, timeout=30)
            if r.returncode == 0 and "sent" in (r.stdout or ""):
                return fn
        except Exception:
            continue
    return None


def _vault_token(fn: str) -> str | None:
    """Vault-first resolved token for a function, via tg_fleet (the single source)."""
    try:
        r = subprocess.run([PY, FLEET, "token", fn],
                           capture_output=True, text=True, timeout=15)
        tok = (r.stdout or "").strip()
        return tok if (r.returncode == 0 and tok) else None
    except Exception:
        return None


def _chat_id(chat: str | None) -> str | None:
    if chat:
        return chat
    try:
        return open(CHAT_FILE).read().strip()
    except Exception:
        return None


def _send_message(tok: str, chat: str, text: str, *, loud: bool, html: bool) -> bool:
    data = {"chat_id": chat, "text": text[:4096],
            "disable_web_page_preview": "true",
            "disable_notification": "false" if loud else "true"}
    if html:
        data["parse_mode"] = "HTML"
    req = urllib.request.Request(
        f"https://api.telegram.org/bot{tok}/sendMessage",
        data=urllib.parse.urlencode(data).encode())
    with urllib.request.urlopen(req, timeout=20) as r:
        return bool(json.load(r).get("ok"))


def tg_push(text: str, fn: str, *, loud: bool = True, html: bool = True,
            fallback_token_file: str | None = None, chat: str | None = None) -> str | None:
    """Push a plain-text alert to Mike via the fleet function `fn` (vault-backed token),
    with HTML + loud/silent control. If the vault lookup or send fails, fall back to a raw
    token file (name under ~/.openclaw/secrets, or an absolute path) so a vault hiccup can
    never silence a live trade alert. Returns 'fn', 'fallback', or None. Never raises."""
    chat = _chat_id(chat)
    if not chat:
        return None
    tok = _vault_token(fn)
    if tok:
        try:
            if _send_message(tok, chat, text, loud=loud, html=html):
                return fn
        except Exception:
            pass
    if fallback_token_file:
        path = (fallback_token_file if os.path.isabs(fallback_token_file)
                else os.path.join(SEC, fallback_token_file))
        try:
            ftok = open(path).read().strip()
            if ftok and _send_message(ftok, chat, text, loud=loud, html=html):
                return "fallback"
        except Exception:
            pass
    return None
