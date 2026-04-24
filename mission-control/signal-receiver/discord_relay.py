#!/usr/bin/env python3
"""
Discord Relay — Post parsed TradingView signals to #tv-signals
Uses webhook URL (no bot token needed, simpler setup)
"""

import json
import os
import sys
import urllib.request

sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

try:
    from mc_utils import get_secret
except ImportError:
    def get_secret(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()


# Color map for signal types
COLORS = {
    "BUY": 0x00FF00,       # Green
    "SELL": 0xFF0000,       # Red
    "TAKE_PROFIT": 0xFFD700,  # Gold
    "STOP_LOSS": 0xFF4500,    # Orange-Red
    "FLIP": 0x00BFFF,       # Blue
    "UNKNOWN": 0x808080,    # Gray
}

EMOJI = {
    "BUY": "🟢",
    "SELL": "🔴",
    "TAKE_PROFIT": "🎯",
    "STOP_LOSS": "🛑",
    "FLIP": "🔄",
    "UNKNOWN": "❓",
}


def post_signal_to_discord(parsed: dict):
    """Post a parsed signal as a Discord embed via webhook."""
    
    try:
        webhook_url = get_secret("discord_tv_signals_webhook")
    except (FileNotFoundError, Exception) as e:
        print(f"[discord_relay] No webhook configured: {e}")
        print("[discord_relay] Create ~/.openclaw/secrets/discord_tv_signals_webhook")
        print("[discord_relay] with the Discord webhook URL for #tv-signals channel")
        return
    
    action = parsed.get("action", "UNKNOWN")
    emoji = EMOJI.get(action, "❓")
    color = COLORS.get(action, 0x808080)
    
    # Build fields
    fields = []
    
    if parsed.get("price") is not None:
        fields.append({"name": "💰 Price", "value": f"${parsed['price']:,.2f}", "inline": True})
    
    if parsed.get("supertrend_band") is not None:
        fields.append({"name": "📊 ST Band", "value": f"${parsed['supertrend_band']:,.2f}", "inline": True})
    
    if parsed.get("atr_value") is not None:
        fields.append({"name": "📏 ATR", "value": f"{parsed['atr_value']:,.2f}", "inline": True})
    
    if parsed.get("atr_period") is not None:
        fields.append({"name": "⏱ ATR Period", "value": str(int(parsed['atr_period'])), "inline": True})
    
    if parsed.get("multiplier") is not None:
        fields.append({"name": "✖️ Multiplier", "value": str(parsed['multiplier']), "inline": True})
    
    if parsed.get("timeframe") and parsed["timeframe"] != "UNKNOWN":
        fields.append({"name": "🕐 Timeframe", "value": parsed["timeframe"], "inline": True})
    
    if parsed.get("take_profit") is not None:
        fields.append({"name": "🎯 TP", "value": f"${parsed['take_profit']:,.2f}", "inline": True})
    
    if parsed.get("stop_loss") is not None:
        fields.append({"name": "🛑 SL", "value": f"${parsed['stop_loss']:,.2f}", "inline": True})
    
    if parsed.get("volume") is not None:
        fields.append({"name": "📦 Volume", "value": f"{parsed['volume']:,.0f}", "inline": True})
    
    ticker = parsed.get("ticker", "UNKNOWN")
    signal_type = parsed.get("signal_type", "UNKNOWN")
    
    embed = {
        "title": f"{emoji} {action} — {ticker}",
        "description": f"**Signal Type:** {signal_type}",
        "color": color,
        "fields": fields,
        "footer": {"text": f"TV Signal Receiver | {parsed.get('timestamp', '')}"},
    }
    
    payload = {
        "username": "TV Signals",
        "embeds": [embed]
    }
    
    data = json.dumps(payload).encode("utf-8")
    req = urllib.request.Request(
        webhook_url,
        data=data,
        headers={"Content-Type": "application/json", "User-Agent": "SignalReceiver/1.0"},
        method="POST"
    )
    
    try:
        with urllib.request.urlopen(req) as resp:
            if resp.status in (200, 204):
                print(f"[discord_relay] Posted {action} {ticker} to Discord")
            else:
                print(f"[discord_relay] Discord responded: {resp.status}")
    except Exception as e:
        print(f"[discord_relay] Failed to post to Discord: {e}")


if __name__ == "__main__":
    # Test
    test_signal = {
        "timestamp": "2026-04-14T15:30:00Z",
        "ticker": "BTCUSD",
        "timeframe": "1H",
        "action": "BUY",
        "signal_type": "SUPERTREND_FLIP",
        "price": 86450.00,
        "supertrend_band": 85200.00,
        "atr_value": 1250.00,
        "atr_period": 10,
        "multiplier": 3.0,
        "volume": None,
        "take_profit": None,
        "stop_loss": None,
        "raw_message": "test",
    }
    post_signal_to_discord(test_signal)
