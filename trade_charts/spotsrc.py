"""Spot + source label for the chart-card captions (audit 2026-10-22, market-data §2 / script-standards #2): every
price a card shows comes through ~/scripts/price_guard.fresh (quote_client.require_fresh: Robinhood first, Yahoo
labelled "not Robinhood", within the send-guard age) and carries its source + data time, e.g.
"src Robinhood 09:35 ET". A stale or missing spot returns (None, reason) so the caller fails closed."""
from __future__ import annotations

import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))   # ~/scripts (price_guard)


def live_spot(sym: str) -> tuple[float | None, str]:
    """(price, "src Robinhood 09:35 ET") or (None, "spot UNAVAILABLE — <reason>")."""
    from price_guard import fresh
    try:
        r = fresh([sym]).get(sym.strip().upper()) or {}
    except Exception as e:  # noqa: BLE001
        return None, f"spot UNAVAILABLE — price guard error ({type(e).__name__})"
    if r.get("ok") and r.get("price"):
        return float(r["price"]), r.get("src") or "src unknown"
    return None, f"spot UNAVAILABLE — {r.get('reason') or 'no quote'}"


def et_hm(ts) -> str:
    """A data time (epoch s / pandas Timestamp / datetime) → "10-22 15:59 ET"; "time n/a" when unknown."""
    from datetime import datetime
    from zoneinfo import ZoneInfo
    try:
        d = ts if isinstance(ts, datetime) else (ts.to_pydatetime() if hasattr(ts, "to_pydatetime") else datetime.fromtimestamp(float(ts), ZoneInfo("UTC")))
        if d.tzinfo is None:
            d = d.replace(tzinfo=ZoneInfo("UTC"))
        return d.astimezone(ZoneInfo("America/New_York")).strftime("%m-%d %H:%M ET")
    except Exception:  # noqa: BLE001
        return "time n/a"
