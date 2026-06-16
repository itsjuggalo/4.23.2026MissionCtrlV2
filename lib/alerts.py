#!/usr/bin/env python3
"""alerts.py — user-set price alerts created from the Discord "🔔 Set Alert" button.

The Set-Alert modal writes {ticker, price, direction, note, user, ts} here; a small
checker (alert_checker.py, on a market-data cron) reads pending alerts, pulls the
live price, and fires the ones that crossed — then marks them done so they fire once.

State: ~/.openclaw/state/user_price_alerts.json  → {"alerts": [ {...}, ... ]}.
Pure stdlib, never raises.
"""
from __future__ import annotations

import json
import time
from pathlib import Path

STATE = Path.home() / ".openclaw" / "state" / "user_price_alerts.json"


def _load() -> dict:
    try:
        d = json.loads(STATE.read_text())
        if isinstance(d, dict) and isinstance(d.get("alerts"), list):
            return d
    except Exception:
        pass
    return {"alerts": []}


def _save(d: dict) -> None:
    try:
        STATE.parent.mkdir(parents=True, exist_ok=True)
        STATE.write_text(json.dumps(d, indent=2))
    except Exception:
        pass


def add_alert(ticker: str, price: float, direction: str = "above",
              note: str = "", user: str = "") -> dict:
    """Register a one-shot price alert. direction: 'above' | 'below'."""
    t = (ticker or "").upper().strip()
    direction = "below" if str(direction).lower().startswith("b") else "above"
    rec = {"id": f"{t}-{int(time.time())}", "ticker": t, "price": float(price),
           "direction": direction, "note": (note or "")[:200], "user": user,
           "ts": time.time(), "fired": False}
    d = _load()
    d["alerts"].append(rec)
    _save(d)
    return rec


def pending() -> list[dict]:
    return [a for a in _load().get("alerts", []) if not a.get("fired")]


def list_for(ticker: str = None) -> list[dict]:
    al = pending()
    if ticker:
        t = ticker.upper().strip()
        al = [a for a in al if a.get("ticker") == t]
    return al


def mark_fired(alert_id: str) -> None:
    d = _load()
    for a in d.get("alerts", []):
        if a.get("id") == alert_id:
            a["fired"] = True
            a["fired_ts"] = time.time()
    # garbage-collect alerts fired > 3 days ago
    cutoff = time.time() - 3 * 86400
    d["alerts"] = [a for a in d.get("alerts", [])
                   if not (a.get("fired") and a.get("fired_ts", 0) < cutoff)]
    _save(d)


def crossed(alert: dict, last_price: float) -> bool:
    """Has this alert's condition been met by last_price?"""
    try:
        p = float(alert.get("price"))
    except (TypeError, ValueError):
        return False
    if alert.get("direction") == "below":
        return last_price <= p
    return last_price >= p


if __name__ == "__main__":
    import sys
    if len(sys.argv) >= 2 and sys.argv[1] == "list":
        for a in pending():
            print(f"{a['ticker']} {a['direction']} {a['price']}  ({a.get('note','')})")
    else:
        print(json.dumps(_load(), indent=2))
