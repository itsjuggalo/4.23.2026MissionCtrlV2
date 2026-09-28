#!/usr/bin/env python3
"""astro_trace.py — request tracing for the astrology bot (privacy-safe).

One JSONL line per handled request at ~/logs/astrology/trace.jsonl:
  request_id, ts (ET), chat (sha256 prefix — never the raw id), intent, calculator, cache_hit,
  event_count, model, duration_ms, delivery, error.
NEVER logged: message text, answers, names, birth dates/times/places, coordinates.

  astro_trace.py tail [N]   → last N lines
"""
from __future__ import annotations

import hashlib
import os
import json
import sys
import time
import uuid
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

TRACE = Path(os.environ.get("ASTRO_TRACE") or Path.home() / "logs/astrology/trace.jsonl")
ALLOWED = {"request_id", "ts", "chat", "intent", "calculator", "cache_hit", "event_count", "model",
           "duration_ms", "delivery", "error", "lane", "command"}


def new_id() -> str:
    return uuid.uuid4().hex[:12]


def chat_hash(chat_id) -> str:
    return hashlib.sha256(str(chat_id).encode()).hexdigest()[:10] if chat_id is not None else ""


def log(**fields) -> dict:
    """Append one trace row. Unknown keys are DROPPED (so private content can't leak in by accident)."""
    row = {k: v for k, v in fields.items() if k in ALLOWED}
    row.setdefault("request_id", new_id())
    row.setdefault("ts", datetime.now(ZoneInfo("America/New_York")).isoformat(timespec="seconds"))
    if "chat" in row:
        row["chat"] = chat_hash(row["chat"]) if not (isinstance(row["chat"], str) and len(row["chat"]) == 10) else row["chat"]
    if isinstance(row.get("error"), str):
        row["error"] = row["error"][:120]
    try:
        TRACE.parent.mkdir(parents=True, exist_ok=True)
        with TRACE.open("a") as f:
            f.write(json.dumps(row) + "\n")
    except Exception:
        pass
    return row


class Timer:
    def __enter__(self):
        self.t0 = time.monotonic(); return self

    def __exit__(self, *a):
        self.ms = int((time.monotonic() - self.t0) * 1000)


if __name__ == "__main__":
    if sys.argv[1:2] == ["tail"]:
        n = int(sys.argv[2]) if len(sys.argv) > 2 else 20
        for ln in (TRACE.read_text().splitlines()[-n:] if TRACE.exists() else []):
            print(ln)
