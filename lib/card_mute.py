#!/usr/bin/env python3
"""card_mute.py — per-ticker mute state for the Discord action cards.

The "🔇 Mute" button on a pick/action card writes a ticker → until-timestamp here.
Posters (flow_picks_post, command_center) call is_muted(ticker) and skip / dim a
name the operator has muted, so a chatty ticker can be silenced for a few hours
without code changes. State: ~/.openclaw/state/card_mute.json  {TICKER: until_epoch}.

Pure stdlib, never raises — a mute-state hiccup must never drop a real alert.
"""
from __future__ import annotations

import json
import time
from pathlib import Path

STATE = Path.home() / ".openclaw" / "state" / "card_mute.json"
DEFAULT_HOURS = 6


def _load() -> dict:
    try:
        return json.loads(STATE.read_text())
    except Exception:
        return {}


def _save(d: dict) -> None:
    try:
        STATE.parent.mkdir(parents=True, exist_ok=True)
        STATE.write_text(json.dumps(d, indent=2))
    except Exception:
        pass


def mute(ticker: str, hours: float = DEFAULT_HOURS) -> float:
    """Mute a ticker for `hours`. Returns the until-epoch."""
    t = (ticker or "").upper().strip()
    if not t:
        return 0.0
    d = _load()
    until = time.time() + hours * 3600
    d[t] = until
    _save(d)
    return until


def unmute(ticker: str) -> None:
    t = (ticker or "").upper().strip()
    d = _load()
    if t in d:
        d.pop(t, None)
        _save(d)


def is_muted(ticker: str) -> bool:
    """True if the ticker is currently muted. Lazily expires stale entries."""
    t = (ticker or "").upper().strip()
    if not t:
        return False
    d = _load()
    until = d.get(t, 0)
    now = time.time()
    if until and until > now:
        return True
    if t in d:                    # expired → clean up
        d.pop(t, None)
        _save(d)
    return False


def active() -> dict:
    """Currently-muted {TICKER: minutes_remaining} (for status displays)."""
    now = time.time()
    return {k: round((v - now) / 60) for k, v in _load().items() if v > now}


if __name__ == "__main__":
    import sys
    if len(sys.argv) >= 2 and sys.argv[1] == "list":
        print(json.dumps(active(), indent=2))
    elif len(sys.argv) >= 3 and sys.argv[1] == "mute":
        h = float(sys.argv[3]) if len(sys.argv) > 3 else DEFAULT_HOURS
        print(f"muted {sys.argv[2].upper()} until +{h}h ({mute(sys.argv[2], h)})")
    elif len(sys.argv) >= 3 and sys.argv[1] == "unmute":
        unmute(sys.argv[2]); print(f"unmuted {sys.argv[2].upper()}")
    else:
        print("usage: card_mute.py [list | mute TICKER [hours] | unmute TICKER]")
