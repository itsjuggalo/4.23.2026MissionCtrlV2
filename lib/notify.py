"""notify — mirror a brief/pick/alert to Mike's Telegram via the bot fleet.

Routes THROUGH tg_fleet (does NOT duplicate the registry): the vault is the single
source of truth for every bot token. Two entry points, both best-effort (never raise,
never block the caller):

  tg_brief(text)        — for briefs/digests; tries `daily_briefs` then falls back to
                          `flow_digest` (a live push bot) so it reaches Mike's phone today.
  tg_push(text, fn,…)   — for a specific function bot, with HTML + loud/silent control and
                          (the old raw-token-file fallback is gone: tg_fleet.call is the only sender). This is what the push senders migrate onto.

  from lib.notify import tg_brief, tg_push
  tg_brief("🌅 morning brief …")
  tg_push("🛑 STOP …", "flow_signals", loud=True, fallback_token_file="telegram-bot-token.txt")
"""
from __future__ import annotations

import json
import os
import subprocess

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


def _send_message(fn: str, chat: str, text: str, *, loud: bool, html: bool) -> bool:
    """Long text -> parts (was cut at 4096 -> 400); a part whose HTML Telegram rejects is re-sent as plain text so a
    markup slip never drops an alert (2026-09-28). Every part goes through tg_fleet.call as lane `fn` (pinned bot,
    ledger, TG_DRY_RUN) - no raw Bot API call here (script-standard #6, 2026-10-22). tg_push already ran tg_lint."""
    import sys as _s
    _s.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
    import tg_fleet
    from lib.tg_split import chunks, plain

    def one(part: str, as_html: bool) -> bool:
        kw = {"chat_id": chat, "text": part, "disable_web_page_preview": "true",
              "disable_notification": "false" if loud else "true", "_review": False}
        if as_html:
            kw["parse_mode"] = "HTML"
        return bool(tg_fleet.call(fn, "sendMessage", **kw).get("ok"))

    ok = True
    for part in chunks(text):
        sent = one(part, html)
        if not sent and html:
            sent = one(plain(part), False)
        ok = ok and sent
    return ok


def tg_push(text: str, fn: str, *, loud: bool = True, html: bool = True,
            fallback_token_file: str | None = None, chat: str | None = None) -> str | None:
    """Push a plain-text alert to Mike via the fleet function `fn` (vault-backed token),
    with HTML + loud/silent control, sent through tg_fleet.call (pinned bot). `fallback_token_file` is kept for old
    callers and ignored. Returns 'fn', 'held' (tg_lint held it), or None. Never raises."""
    chat = _chat_id(chat)
    if not chat:
        return None
    try:   # FYI pushes fold into the next digest (lib/tg_digest.py) — 2026-09-28
        from lib.tg_digest import intercept
        if intercept(fn, text, html):
            return fn
    except Exception:
        pass
    try:   # pre-send review (lib/tg_lint.py) — same gate as tg_fleet; fail-open by design (remedial W4 item 19)
        from lib.tg_lint import review
        reviewed, notes = review(fn, text)
        if reviewed is None:
            print(f"held by pre-send review: {'; '.join(notes)}")
            return "held"
        text = reviewed
    except Exception:
        pass
    try:
        if _send_message(fn, chat, text, loud=loud, html=html):
            return fn
    except Exception:
        pass
    # fallback_token_file is accepted for old callers but no longer used: tg_fleet already falls back to the lane's
    # own token file, and a raw token could post as the wrong bot (pinned lanes refuse that).
    return None
