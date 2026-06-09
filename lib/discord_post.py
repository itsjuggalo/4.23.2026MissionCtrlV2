#!/usr/bin/env python3
"""Canonical Discord webhook poster — use this instead of hand-rolling urllib.

Why this exists (2026-06-09): Discord/Cloudflare returns 403 for the default
Python-urllib User-Agent, and at least 5 alert scripts were silently failing
because of it (each had its own copy-pasted poster with no UA header). One
helper, fixed once. curl posts are unaffected, which makes the bug easy to
mis-clear — a curl 204 does NOT prove a urllib poster works.

Usage:
    from lib.discord_post import post_discord
    post_discord("message")                                   # bobatrades webhook
    post_discord("message", webhook_name="discord_new_stuff_webhook")
    post_discord("message", username="My Bot")                # webhook display name

Returns True only on HTTP 2xx. Never raises.
"""
from __future__ import annotations

import json
import urllib.request
from pathlib import Path

SECRETS = Path.home() / ".openclaw" / "secrets"
DEFAULT_WEBHOOK = "discord_bobatrades_webhook"
MAX_LEN = 1900  # Discord hard limit 2000; headroom for ellipsis/expansion


def post_discord(content: str, webhook_name: str = DEFAULT_WEBHOOK,
                 username: str | None = None, timeout: int = 10) -> bool:
    try:
        url = (SECRETS / webhook_name).read_text().strip()
        if not url:
            return False
        url = url.replace("discordapp.com", "discord.com")
        payload: dict = {"content": str(content)[:MAX_LEN]}
        if username:
            payload["username"] = username
        req = urllib.request.Request(
            url, data=json.dumps(payload).encode(),
            headers={"Content-Type": "application/json",
                     "User-Agent": "mc-discord-post/1.0"})
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return 200 <= r.status < 300
    except Exception:
        return False
