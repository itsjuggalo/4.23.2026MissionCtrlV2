"""notify — mirror a brief/pick to Mike's Telegram via the bot fleet.

Routes THROUGH tg_fleet (does NOT duplicate it): tries the dedicated `daily_briefs`
bot, then falls back to `flow_digest` (@Boba2Telegram_Bot, a live push bot) so briefs
reach Mike's phone TODAY and auto-upgrade the moment a dedicated daily_briefs token is
set in the vault. Best-effort: never raises, never blocks the Discord post.

  from lib.notify import tg_brief
  tg_brief("🌅 morning brief …")
"""
from __future__ import annotations

import subprocess

PY = "/home/itsju/.venv/bin/python"
FLEET = "/home/itsju/scripts/tg_fleet.py"


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
