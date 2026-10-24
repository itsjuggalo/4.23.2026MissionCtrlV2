"""tg_wellness_card.py — send a Life & Wellness photo/animation card WITH inline buttons.

Vault-backed token (fleet `life_wellness`), stdlib-only multipart (no requests dependency).
Used by life-engine-run.py (brief cards + quick-action buttons) and bodywork_quiz.py
(technique clips + A/B/C answers). Best-effort: returns False rather than raising.

  send_card_with_buttons(media_path, caption, buttons=[[{text, callback_data|url}], ...],
                         fn="life_wellness", animation=False, silent=False)
"""
from __future__ import annotations

import os
import subprocess
import sys
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"


def _token(fn: str = "life_wellness") -> str | None:
    """Vault-first via tg_fleet; flat-file fallback so a vault miss can't silence the bot."""
    try:
        r = subprocess.run(["/home/itsju/.venv/bin/python",
                            "/home/itsju/scripts/tg_fleet.py", "token", fn],
                           capture_output=True, text=True, timeout=15)
        t = (r.stdout or "").strip()
        if t:
            return t
    except Exception:
        pass
    p = SEC / "lifeclaw_telegram_bot_token"
    return p.read_text().strip() if p.exists() else None


def _chat(chat: str | None = None) -> str | None:
    if chat:
        return chat
    for n in ("lifeclaw_telegram_chat_id", "telegram-chat-id.txt"):
        p = SEC / n
        if p.exists():
            return p.read_text().strip()
    return None


def send_card_with_buttons(media_path: str, caption: str, buttons: list | None = None, *,
                           fn: str = "life_wellness", chat: str | None = None,
                           animation: bool = False, silent: bool = False) -> bool:
    """sendPhoto (or sendAnimation if `animation`) + optional inline_keyboard. Returns bool."""
    tok = _token(fn)
    chat = _chat(chat)
    if not tok or not chat or not media_path or not os.path.exists(media_path):
        return False
    # tg_fleet.send_upload as lane `fn` (pinned bot, ledgered) — script-standard #6, 2026-10-23 (was a raw multipart
    # POST with the same token). Same caption, HTML mode, buttons, silent flag and chat.
    extra = {}
    if chat != _chat(None):
        extra["chat_id"] = chat
    if silent:
        extra["disable_notification"] = "true"
    if buttons:
        extra["reply_markup"] = {"inline_keyboard": buttons}
    try:
        sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
        import tg_fleet
        rc = tg_fleet.send_upload(fn, media_path, (caption or "")[:1024], html=True, extra=extra, animation=animation)
        return rc == 0 and os.environ.get("TG_DRY_RUN") != "1"
    except Exception as e:
        print(f"[tg_wellness_card] send failed: {e}", file=sys.stderr)
        return False
