#!/usr/bin/env python3
"""tg_split — keep long / badly-formatted Telegram messages from being dropped (2026-09-28).

Telegram rejects a message over 4096 chars ("message is too long") and HTML with a broken
tag ("can't parse entities"). The shared send points (tg_fleet.send, lib/notify) use these
helpers so a long report arrives in parts and a markup slip arrives as plain text instead
of vanishing — the nightly SIGNAL REPORT CARD (15k chars) had failed every night.

  from lib.tg_split import chunks, plain
"""
from __future__ import annotations

import html as _html
import re

LIMIT = 4000   # headroom under Telegram's 4096


def chunks(text: str, limit: int = LIMIT) -> list[str]:
    """Split on line boundaries into parts <= limit (a single over-long line is hard-cut)."""
    text = text or ""
    if len(text) <= limit:
        return [text]
    out, cur = [], ""
    for line in text.split("\n"):
        while len(line) > limit:                       # pathological single line
            if cur:
                out.append(cur); cur = ""
            out.append(line[:limit]); line = line[limit:]
        if cur and len(cur) + 1 + len(line) > limit:
            out.append(cur); cur = line
        else:
            cur = f"{cur}\n{line}" if cur else line
    if cur:
        out.append(cur)
    return [c for c in out if c.strip()] or [text[:limit]]


def plain(text: str) -> str:
    """HTML → readable plain text (tags stripped, entities unescaped)."""
    return _html.unescape(re.sub(r"</?[a-zA-Z][^>]*>", "", text or ""))
