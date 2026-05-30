"""Convert raw scraper rows into a canonical FlowEvent.

Source rows live in two shapes today:

  flow_alerts_today.json -> {key: {alert: {...}, quote: {...}}}
  flow_live_last100.json -> {key: {flat fields}}

Everything downstream of this module sees only FlowEvent.
"""
from __future__ import annotations

from dataclasses import dataclass
from datetime import datetime, timezone
from typing import Any


@dataclass(frozen=True)
class FlowEvent:
    source_id: str
    symbol: str
    strike: float
    opt_type: str           # "C" or "P"
    expiry_unix: int
    dte: int
    is_bullish: bool
    premium: float          # totalFlowValue or Value
    volume: int
    open_interest: int
    spot: float | None
    alert_price: float | None
    block_type: str         # "SWEEP" | "BLOCK" | ""
    bid_ask: str            # "A" | "B" | ""
    alert_type: str         # raw upstream type for diagnostics
    underlying_type: str    # "STOCK" | "ETF" | ""
    time_unix: int
    sweeps: int
    blocks: int


def _opt_letter(opt_type: Any) -> str:
    if not opt_type:
        return ""
    s = str(opt_type).upper()
    if s.startswith("C"):
        return "C"
    if s.startswith("P"):
        return "P"
    return ""


def _f(v: Any, default: float = 0.0) -> float:
    try:
        return float(v) if v not in (None, "", "?") else default
    except (TypeError, ValueError):
        return default


def _i(v: Any, default: int = 0) -> int:
    try:
        return int(float(v)) if v not in (None, "", "?") else default
    except (TypeError, ValueError):
        return default


def _dte_from_expiry(expiry_unix: int, now_unix: int | None = None) -> int:
    if expiry_unix <= 0:
        return 0
    now_unix = now_unix or int(datetime.now(timezone.utc).timestamp())
    return max(0, (expiry_unix - now_unix) // 86400)


def from_flow_alert(
    source_id: str,
    alert: dict[str, Any],
    quote: dict[str, Any] | None = None,
) -> FlowEvent:
    """Build a FlowEvent from a flow_alerts_today entry."""
    quote = quote or {}
    expiry = _i(alert.get("Expiry"))
    spot_raw = alert.get("Spot")
    return FlowEvent(
        source_id=source_id,
        symbol=str(alert.get("Symbol", "?")),
        strike=_f(alert.get("Strike")),
        opt_type=_opt_letter(alert.get("OptionType")),
        expiry_unix=expiry,
        dte=_i(alert.get("DTE"), _dte_from_expiry(expiry)),
        is_bullish=bool(alert.get("isBullish", False)),
        premium=_f(alert.get("totalFlowValue")),
        volume=_i(alert.get("Volume")),
        open_interest=_i(alert.get("OI")),
        spot=_f(spot_raw) if spot_raw not in (None, "") else None,
        alert_price=_f(alert.get("AlertPrice")) or None,
        block_type=str(alert.get("BlockType") or alert.get("option_activity_type") or "").upper(),
        bid_ask=str(alert.get("BidAskType") or "").upper()[:1],
        alert_type=str(alert.get("AlertType") or "").lower(),
        underlying_type=str(alert.get("UnderlyingType") or "").upper(),
        time_unix=_i(alert.get("Time")),
        sweeps=_i(alert.get("SWEEPS")),
        blocks=_i(alert.get("BLOCKS")),
    )


def from_flow_live(source_id: str, row: dict[str, Any]) -> FlowEvent:
    """Build a FlowEvent from a flow_live_last100 row."""
    opt = _opt_letter(row.get("OptionType"))
    bid_ask = str(row.get("BidAskType") or "").upper()[:1]
    is_bullish = (opt == "C" and bid_ask == "A") or (opt == "P" and bid_ask == "B")
    expiry = _i(row.get("Expiry"))
    spot_raw = row.get("Spot")
    return FlowEvent(
        source_id=source_id,
        symbol=str(row.get("Symbol", "?")),
        strike=_f(row.get("Strike")),
        opt_type=opt,
        expiry_unix=expiry,
        dte=_dte_from_expiry(expiry),
        is_bullish=is_bullish,
        premium=_f(row.get("Value")),
        volume=_i(row.get("Volume")),
        open_interest=_i(row.get("OI")),
        spot=_f(spot_raw) if spot_raw not in (None, "") else None,
        alert_price=_f(row.get("Price")) or None,
        block_type=str(row.get("BlockType") or "").upper(),
        bid_ask=bid_ask,
        alert_type="live",
        underlying_type="",
        time_unix=_i(row.get("Time")),
        sweeps=1 if row.get("BlockType") == "SWEEP" else 0,
        blocks=1 if row.get("BlockType") == "BLOCK" else 0,
    )
