#!/usr/bin/env python3
"""alert_gate — "only tell me when something CHANGED" for the push bots.

Built 2026-07-29. The Trading Command lane was carrying 600 messages in 7 days
(86/day). Almost none of it was new information: the SPY R:R picks card re-posted
every 15 minutes whether or not the picks moved, GREEN-LIGHT re-confirmed the same
contract, PULLBACK re-flagged the same parked runner. At that volume Mike stops
reading the lane — which costs him the ONE message that mattered.

The gate is deliberately dumb and shared, so every sender behaves the same way:

    from lib.alert_gate import should_send, mark_sent

    fp = f"{ticker}|{strike}|{side}|{bucket}"        # what makes this alert DIFFERENT
    ok, why = should_send("spy_rr_picks", fp)
    if ok:
        send(msg)
        mark_sent("spy_rr_picks", fp)

`fingerprint` is the caller's answer to "what would make this a genuinely new
alert?" — usually ticker + strike + direction, with continuous values bucketed so
noise-level drift doesn't read as change. Bucket prices; never fingerprint a
timestamp, or every call looks new and the gate does nothing.

Rules:
  • fingerprint changed          -> SEND
  • same fingerprint, < repeat_after -> SILENT
  • same fingerprint, >= repeat_after -> SEND (a standing setup is worth one reminder)

Off-switch for one key:  ALERT_GATE_OFF=1  (or per-key ALERT_GATE_OFF_<KEY>=1)
State: ~/.openclaw/state/alert_gate.json  — plain JSON, safe to delete (worst case
you get one extra message per key).
"""
from __future__ import annotations

import json
import os
import time
from pathlib import Path

STATE = Path.home() / ".openclaw" / "state" / "alert_gate.json"
DEFAULT_REPEAT_AFTER = 4 * 3600     # a standing, unchanged setup reminds once per 4h


def _off(key: str) -> bool:
    if os.environ.get("ALERT_GATE_OFF", "0").lower() in ("1", "true", "yes"):
        return True
    per_key = f"ALERT_GATE_OFF_{key.upper().replace('-', '_')}"
    return os.environ.get(per_key, "0").lower() in ("1", "true", "yes")


def _load() -> dict:
    try:
        return json.loads(STATE.read_text(encoding="utf-8"))
    except Exception:
        return {}


def _save(d: dict) -> None:
    try:
        STATE.parent.mkdir(parents=True, exist_ok=True)
        STATE.write_text(json.dumps(d, indent=1), encoding="utf-8")
    except Exception:
        pass        # never let bookkeeping break an alert path


SEEN_KEEP = 50                      # recent fingerprints remembered per key (recall=True)


def should_send(key: str, fingerprint: str, *,
                repeat_after: int = DEFAULT_REPEAT_AFTER, recall: bool = False) -> tuple[bool, str]:
    """(send?, reason). `key` = the alert family; `fingerprint` = what makes it new.
    recall=True also silences a fingerprint DELIVERED under this key within repeat_after even when
    another one came in between (A→B→A does not re-alert A) — audit W5 MC-AUD-081, 2026-10-21."""
    if _off(key):
        return True, "gate off"
    prev = _load().get(key)
    if not prev:
        return True, "first alert of this kind"
    if prev.get("fp") != fingerprint:
        seen_ts = (prev.get("seen") or {}).get(fingerprint) if recall else None
        if seen_ts is not None and time.time() - float(seen_ts) < repeat_after:
            return False, f"seen earlier ({int((time.time() - float(seen_ts)) // 60)}m ago)"
        return True, "changed"
    age = time.time() - float(prev.get("ts") or 0)
    if age >= repeat_after:
        return True, f"unchanged but standing {int(age // 3600)}h"
    return False, f"unchanged ({int(age // 60)}m ago)"


def mark_sent(key: str, fingerprint: str) -> None:
    """Call only after the send was acknowledged — a failed send must stay unmarked so it retries."""
    d = _load()
    now = time.time()
    seen = dict((d.get(key) or {}).get("seen") or {})
    seen[fingerprint] = now
    seen = dict(sorted(seen.items(), key=lambda kv: kv[1])[-SEEN_KEEP:])
    d[key] = {"fp": fingerprint, "ts": now, "seen": seen}
    _save(d)


def gate(key: str, fingerprint: str, *, repeat_after: int = DEFAULT_REPEAT_AFTER):
    """Context-manager-free convenience: returns (ok, reason) and marks on ok.
    Use only when the send cannot fail — otherwise call mark_sent() after a real send."""
    ok, why = should_send(key, fingerprint, repeat_after=repeat_after)
    if ok:
        mark_sent(key, fingerprint)
    return ok, why


def bucket(value, step) -> str:
    """Bucket a continuous value so noise-level drift is not treated as change.
    bucket(740.63, 1) -> '740' ; bucket(0.62, 0.05) -> '0.60'"""
    try:
        v = float(value)
    except (TypeError, ValueError):
        return str(value)
    return f"{(v // step) * step:.2f}"
