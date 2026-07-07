"""book.py — load Mike's real book (unified_book.json) + coach config + peak state.

The book is refreshed every 30 min market hours by wallets-refresh.sh; this module
only READS. Config carries the core/satellite bucket tags + rule thresholds.
State carries per-symbol peak marks so trailing suggestions ratchet monotonically
(same idea as portfolio_manage.hw_load/hw_peak — first sweep arms peak=current).
"""
from __future__ import annotations

import json
import os
import tempfile
from datetime import datetime
from pathlib import Path

try:
    from zoneinfo import ZoneInfo
    ET = ZoneInfo("America/New_York")
except Exception:  # pragma: no cover
    ET = None

PORT = Path.home() / "portfolio"
BOOK = PORT / "unified_book.json"
CONFIG = PORT / "coach_config.json"
STATE = PORT / ".coach_state.json"
VERDICTS = PORT / "coach_verdicts.json"

DEFAULT_CONFIG = {
    # bucket entries may be bare ("BTC" = any asset class) or qualified ("crypto:BTC",
    # "stock:QQQ") — qualified wins; RH lists a STOCK ticker "BTC" (Grayscale mini ETF)
    # that must NOT inherit the coin's core status.
    "buckets": {"core": ["crypto:BTC", "crypto:ETH", "stock:QQQ", "stock:IBIT"],
                "satellite": []},
    "core_note": "UNCONFIRMED defaults — Mike edits this list (or answers the CORE question)",
    "default_bucket": "satellite",
    "dust_max_usd": 5.0,
    "rules": {
        "dead_bag_pnl_pct": -50, "trim_gain_pct": 75, "concentration_pct": 25,
        "core_trail_pct": 15, "satellite_trail_pct": 8, "trim_trail_pct": 5,
        "satellite_hard_stop_pct": 10, "core_bear_factors_req": 3,
        "big_move_alert_pct": 8,
    },
}


def now_et() -> str:
    dt = datetime.now(ET) if ET else datetime.now()
    return dt.strftime("%Y-%m-%d %H:%M ET")


def _load_json(p: Path, default):
    try:
        return json.loads(p.read_text())
    except Exception:
        return default


def atomic_write(p: Path, obj) -> None:
    p.parent.mkdir(parents=True, exist_ok=True)
    fd, tmp = tempfile.mkstemp(dir=str(p.parent), prefix=p.name + ".")
    try:
        with os.fdopen(fd, "w") as f:
            json.dump(obj, f, indent=1, default=str)
        os.replace(tmp, str(p))
    except Exception:
        try:
            os.unlink(tmp)
        except OSError:
            pass
        raise


def load_config() -> dict:
    cfg = _load_json(CONFIG, None)
    if cfg is None:
        cfg = DEFAULT_CONFIG
        atomic_write(CONFIG, cfg)
    # merge missing rule keys so config edits never break on upgrades
    for k, v in DEFAULT_CONFIG["rules"].items():
        cfg.setdefault("rules", {}).setdefault(k, v)
    for k, v in DEFAULT_CONFIG.items():
        cfg.setdefault(k, v)
    return cfg


def load_state() -> dict:
    return _load_json(STATE, {"peaks": {}, "last_verdicts": {}, "alerted": {}})


def save_state(state: dict) -> None:
    atomic_write(STATE, state)


def load_book() -> dict:
    """Full book dict. Raises on missing/corrupt book (cron logs it; never fake a book)."""
    b = json.loads(BOOK.read_text())
    if not b.get("positions"):
        raise ValueError("unified_book.json has no positions")
    return b


def positions(book: dict, crypto_only: bool = False) -> list[dict]:
    """Non-cash positions, biggest first. Cash rows reported separately."""
    rows = [p for p in book["positions"] if p.get("asset_class") in ("stock", "crypto")]
    if crypto_only:
        rows = [p for p in rows if p["asset_class"] == "crypto"]
    return sorted(rows, key=lambda p: -abs(float(p.get("mkt_value") or 0)))


def bucket_of(symbol: str, asset_class: str, cfg: dict) -> str:
    """core | satellite. Entries may be bare (BTC) or asset-qualified (crypto:BTC)."""
    s = symbol.upper()
    q = f"{asset_class}:{s}".upper()
    for name in ("core", "satellite"):
        entries = {x.upper() for x in cfg["buckets"].get(name, [])}
        if q in entries or s in entries:
            return name
    return cfg.get("default_bucket", "satellite")


def peak_update(state: dict, key: str, current_price: float) -> float:
    """Monotonic per-position peak mark (ratchet basis). Arms at current on first sight."""
    peaks = state.setdefault("peaks", {})
    rec = peaks.get(key)
    if not rec or current_price > float(rec.get("peak", 0)):
        peaks[key] = {"peak": current_price, "at": now_et()}
        return current_price
    return float(rec["peak"])
