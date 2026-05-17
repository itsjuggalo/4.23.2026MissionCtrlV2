#!/usr/bin/env python3
"""
firebase_signals — single source of truth for the Firebase provider trade-signal feed.

The feed is produced by firebase_signal_relay (polls Name/Name2/Vivid options paths
on the stock-signal-72772 RTDB) and written to FEED_PATH. Every consumer — Boba,
JazzyHazzy, askgrok — must load and render it through this module so the data is
showcased one consistent way.

Public API:
    load_signals()                       -> list[dict]   (newest-first, [] on any error)
    format_for_prompt(signals, max_show)  -> str          (prompt-ready text block)
    feed_health()                         -> dict         (liveness, no mtime guessing)
"""
import json
from datetime import datetime
from pathlib import Path

FEED_PATH = Path("/home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json")


def load_signals():
    """Load Firebase Name/Name2/Vivid trade signals, newest first. [] on any failure."""
    if not FEED_PATH.exists():
        return []
    try:
        signals = json.loads(FEED_PATH.read_text())
        if not isinstance(signals, list):
            return []
    except Exception:
        return []
    return sorted(signals, key=lambda x: x.get("captured_at", ""), reverse=True)


def _expiry_str(sig):
    """Convert the relay's epoch `expiry_ts` field to MM/DD. '?' if absent/bad."""
    ts = sig.get("expiry_ts")
    if not ts:
        return "?"
    try:
        return datetime.fromtimestamp(int(ts)).strftime("%m/%d")
    except Exception:
        return "?"


def format_for_prompt(signals, max_show=20):
    """Format the last N Firebase trade signals into one prompt-ready text block."""
    if not signals:
        return "  (no recent provider trade signals)"
    recent = sorted(signals, key=lambda x: x.get("captured_at", ""), reverse=True)[:max_show]
    lines = []
    for s in recent:
        side = "PUT" if s.get("is_put") else "CALL"
        free_tag = "FREE" if s.get("is_free") else "PREMIUM"
        lines.append(
            f"  - [{s.get('source', '?')}] {s.get('category', '?')}: "
            f"{s.get('ticker', '?')} ${s.get('strike', '?')} {side} "
            f"exp {_expiry_str(s)} | "
            f"Entry ${s.get('buy_target', '?')} -> Target ${s.get('sell_target', '?')} | "
            f"SL ${s.get('stop_loss', '?')} | Risk: {s.get('risk') or '?'} | {free_tag}"
        )
    return "\n".join(lines)


def feed_health():
    """Liveness from the relay's own status fields — not file mtime.

    The relay writes last_poll_ok / last_signal_at into a sibling status file so
    precycle_health can detect silent degradation (MIS-107 pattern) instead of
    being fooled by an mtime touch."""
    status_path = FEED_PATH.with_name("firebase_signal_relay_status.json")
    if not status_path.exists():
        return {"ok": False, "reason": "no relay status file"}
    try:
        st = json.loads(status_path.read_text())
    except Exception as e:
        return {"ok": False, "reason": f"status unreadable ({e})"}
    return {
        "ok": bool(st.get("last_poll_ok")),
        "last_poll_ok": st.get("last_poll_ok"),
        "last_poll_at": st.get("last_poll_at"),
        "last_signal_at": st.get("last_signal_at"),
        "consecutive_failures": st.get("consecutive_failures", 0),
    }
