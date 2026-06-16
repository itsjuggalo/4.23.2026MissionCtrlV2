"""tg_wellness_card.py — send a Life & Wellness photo/animation card WITH inline buttons.

Vault-backed token (fleet `life_wellness`), stdlib-only multipart (no requests dependency).
Used by life-engine-run.py (brief cards + quick-action buttons) and bodywork_quiz.py
(technique clips + A/B/C answers). Best-effort: returns False rather than raising.

  send_card_with_buttons(media_path, caption, buttons=[[{text, callback_data|url}], ...],
                         fn="life_wellness", animation=False, silent=False)
"""
from __future__ import annotations

import json
import mimetypes
import os
import subprocess
import sys
import urllib.request
import uuid
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


def _multipart(fields: dict, file_field: str, file_path: str) -> tuple[bytes, str]:
    boundary = "----mc" + uuid.uuid4().hex
    nl = b"\r\n"
    buf = []
    for k, v in fields.items():
        buf += [b"--" + boundary.encode() + nl,
                f'Content-Disposition: form-data; name="{k}"'.encode() + nl + nl,
                str(v).encode() + nl]
    fn = os.path.basename(file_path)
    ctype = mimetypes.guess_type(fn)[0] or "application/octet-stream"
    buf += [b"--" + boundary.encode() + nl,
            f'Content-Disposition: form-data; name="{file_field}"; filename="{fn}"'.encode() + nl,
            f"Content-Type: {ctype}".encode() + nl + nl,
            Path(file_path).read_bytes() + nl,
            b"--" + boundary.encode() + b"--" + nl]
    return b"".join(buf), boundary


def send_card_with_buttons(media_path: str, caption: str, buttons: list | None = None, *,
                           fn: str = "life_wellness", chat: str | None = None,
                           animation: bool = False, silent: bool = False) -> bool:
    """sendPhoto (or sendAnimation if `animation`) + optional inline_keyboard. Returns bool."""
    tok = _token(fn)
    chat = _chat(chat)
    if not tok or not chat or not media_path or not os.path.exists(media_path):
        return False
    method = "sendAnimation" if animation else "sendPhoto"
    file_field = "animation" if animation else "photo"
    fields = {"chat_id": chat, "caption": (caption or "")[:1024], "parse_mode": "HTML"}
    if silent:
        fields["disable_notification"] = "true"
    if buttons:
        fields["reply_markup"] = json.dumps({"inline_keyboard": buttons})
    body, boundary = _multipart(fields, file_field, media_path)
    req = urllib.request.Request(
        f"https://api.telegram.org/bot{tok}/{method}", data=body, method="POST",
        headers={"Content-Type": f"multipart/form-data; boundary={boundary}"})
    try:
        with urllib.request.urlopen(req, timeout=60) as r:
            return json.loads(r.read()).get("ok", False)
    except Exception as e:
        print(f"[tg_wellness_card] {method} failed: {e}", file=sys.stderr)
        return False
