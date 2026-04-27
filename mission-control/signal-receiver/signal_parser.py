#!/usr/bin/env python3
"""
Signal Parser — Classify TradingView webhook payloads
Zero LLM calls. Pure rule-based Python.
"""

import re
from datetime import datetime, timezone


# Keywords for classification
BUY_KEYWORDS = ["buy", "long", "entry_long", "open_long", "bullish", "call"]
SELL_KEYWORDS = ["sell", "short", "entry_short", "open_short", "bearish", "put"]
TP_KEYWORDS = ["take_profit", "tp", "target", "profit", "close_long", "close_short", "exit"]
SL_KEYWORDS = ["stop_loss", "sl", "stop", "stopped"]
FLIP_KEYWORDS = ["flip", "reverse", "supertrend_flip", "direction_change"]


def _detect_action(payload: dict, raw_text: str) -> tuple:
    """
    Returns (action, signal_type) tuple.
    action: BUY | SELL | TAKE_PROFIT | STOP_LOSS | UNKNOWN
    signal_type: ENTRY | EXIT | SUPERTREND_FLIP | TP | SL | UNKNOWN
    """
    # Check structured fields first
    action_field = str(payload.get("action", "")).lower().strip()
    order_field = str(payload.get("order", "")).lower().strip()
    strategy_field = str(payload.get("strategy", "")).lower().strip()
    msg_field = str(payload.get("message", "")).lower().strip()
    
    # Handle new TradingView format with sentiment field
    sentiment_field = str(payload.get("sentiment", "")).lower().strip()
    
    # Combine all text for keyword search
    all_text = f"{action_field} {order_field} {strategy_field} {msg_field} {raw_text}".lower()
    
    # If sentiment field exists, use it to determine signal_type
    # This handles the new format: {"ticker":"BTCUSD","action":"buy","orderType":"market","sentiment":"long"}
    if sentiment_field in ("long", "short"):
        # Treat sentiment as the authoritative direction signal
        if sentiment_field == "long":
            return "BUY", "SUPERTREND_FLIP"
        else:
            return "SELL", "SUPERTREND_FLIP"
    
    # Check for flip/reversal first (highest priority)
    if any(kw in all_text for kw in FLIP_KEYWORDS):
        # Determine direction of flip
        if any(kw in all_text for kw in BUY_KEYWORDS):
            return "BUY", "SUPERTREND_FLIP"
        elif any(kw in all_text for kw in SELL_KEYWORDS):
            return "SELL", "SUPERTREND_FLIP"
        return "FLIP", "SUPERTREND_FLIP"
    
    # Check TP/SL before entry signals
    if any(kw in all_text for kw in SL_KEYWORDS):
        return "STOP_LOSS", "SL"
    
    if any(kw in all_text for kw in TP_KEYWORDS):
        return "TAKE_PROFIT", "TP"
    
    # Entry signals
    if any(kw in all_text for kw in BUY_KEYWORDS):
        return "BUY", "ENTRY"
    
    if any(kw in all_text for kw in SELL_KEYWORDS):
        return "SELL", "ENTRY"
    
    return "UNKNOWN", "UNKNOWN"


def _extract_number(payload: dict, keys: list, raw_text: str = "") -> float:
    """Try to extract a numeric value from payload by checking multiple key names."""
    for key in keys:
        val = payload.get(key)
        if val is not None:
            try:
                return float(val)
            except (ValueError, TypeError):
                continue
    
    # Try regex on raw text for patterns like "price: 86450" or "price=86450"
    for key in keys:
        pattern = rf'{key}\s*[=:]\s*([\d.]+)'
        match = re.search(pattern, raw_text, re.IGNORECASE)
        if match:
            try:
                return float(match.group(1))
            except ValueError:
                continue
    
    return None


def _extract_ticker(payload: dict, raw_text: str) -> str:
    """Extract ticker symbol."""
    # Check common field names
    for key in ["ticker", "symbol", "pair", "instrument", "coin"]:
        val = payload.get(key)
        if val:
            return str(val).upper().replace("/", "")
    
    # Try regex for common patterns: BTCUSD, BTC/USD, BTC-USD
    pattern = r'\b([A-Z]{2,10})[/-]?([A-Z]{2,5})\b'
    match = re.search(pattern, raw_text.upper())
    if match:
        return f"{match.group(1)}{match.group(2)}"
    
    return "UNKNOWN"


def _extract_timeframe(payload: dict, raw_text: str) -> str:
    """Extract timeframe."""
    for key in ["timeframe", "tf", "interval", "resolution", "period"]:
        val = payload.get(key)
        if val:
            return str(val).upper()
    
    # Regex for patterns like "1H", "4h", "15m", "1D"
    match = re.search(r'\b(\d+[mhHdDwW])\b', raw_text)
    if match:
        return match.group(1).upper()
    
    return "UNKNOWN"


def parse_signal(payload: dict, raw_text: str) -> dict:
    """
    Parse a TradingView webhook payload into a structured signal dict.
    
    Handles:
    - Pine Script JSON alerts: {"ticker":"BTCUSD","action":"buy","price":86450}
    - TradingView condition alerts: "BTCUSD Greater Than SuperTrend"
    - Custom formatted alerts with various field names
    """
    
    action, signal_type = _detect_action(payload, raw_text)
    
    parsed = {
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "ticker": _extract_ticker(payload, raw_text),
        "timeframe": _extract_timeframe(payload, raw_text),
        "action": action,
        "signal_type": signal_type,
        "price": _extract_number(payload, ["price", "close", "last", "entry", "entry_price"], raw_text),
        "supertrend_band": _extract_number(payload, ["supertrend", "supertrend_band", "st_band", "band"], raw_text),
        "atr_value": _extract_number(payload, ["atr", "atr_value", "atr14"], raw_text),
        "atr_period": _extract_number(payload, ["atr_period", "atr_len", "atr_length"], raw_text),
        "multiplier": _extract_number(payload, ["multiplier", "factor", "mult"], raw_text),
        "volume": _extract_number(payload, ["volume", "vol"], raw_text),
        "take_profit": _extract_number(payload, ["take_profit", "tp", "target"], raw_text),
        "stop_loss": _extract_number(payload, ["stop_loss", "sl", "stop"], raw_text),
        "raw_message": raw_text[:2000],  # Cap at 2k chars
    }
    
    # Clean out None values for cleaner storage (keep the key but mark as null)
    return parsed


if __name__ == "__main__":
    # Test cases
    tests = [
        # Pine Script JSON
        ({"ticker": "BTCUSD", "action": "buy", "price": 86450, "supertrend": 85200, "atr": 1250}, 
         '{"ticker":"BTCUSD","action":"buy","price":86450}'),
        
        # Plain text alert
        ({}, "BTCUSD SuperTrend Flip Long at 86450"),
        
        # Sell signal
        ({"ticker": "BTCUSD", "action": "sell", "price": 84000, "signal_type": "supertrend_flip"},
         "sell signal"),
        
        # Take profit
        ({"ticker": "ETHUSD", "action": "take_profit", "price": 3200},
         "take profit hit"),
        
        # Stop loss
        ({"ticker": "BTCUSD", "action": "stop_loss", "price": 82000},
         "stopped out"),
    ]
    
    import json
    for payload, raw in tests:
        result = parse_signal(payload, raw)
        print(f"\n{'='*50}")
        print(f"Input: {raw[:60]}")
        print(json.dumps(result, indent=2))
