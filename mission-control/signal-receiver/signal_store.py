#!/usr/bin/env python3
"""
Signal Store — Persist parsed signals and maintain position state
"""

import json
import os
from datetime import datetime, timezone

import time
import requests as _requests

def _fetch_btc_price():
    """Fetch current BTC price when TradingView doesn't send one."""
    try:
        r = _requests.get("https://api.coingecko.com/api/v3/simple/price",
            params={"ids": "bitcoin", "vs_currencies": "usd"}, timeout=5)
        return r.json().get("bitcoin", {}).get("usd")
    except:
        return None

# Debounce: ignore signals within 3 seconds of last signal for same ticker
_last_signal_times = {}

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
os.makedirs(DATA_DIR, exist_ok=True)

HISTORY_FILE = os.path.join(DATA_DIR, "signals_history.jsonl")
STATE_FILE = os.path.join(DATA_DIR, "latest_state.json")


def store_signal(parsed: dict):
    """Append parsed signal to history and update position state."""

    # Debounce: skip if same ticker+action within 3 seconds
    ticker_key = f"{parsed.get('ticker')}_{parsed.get('action')}"
    now = time.time()
    if ticker_key in _last_signal_times:
        elapsed = now - _last_signal_times[ticker_key]
        if elapsed < 3.0:
            print(f"[signal-store] Debounced {ticker_key} ({elapsed:.1f}s since last)")
            with open(HISTORY_FILE, "a") as f:
                f.write(json.dumps(parsed) + "\n")
            return
    _last_signal_times[ticker_key] = now

    # If price is missing, fetch it
    if parsed.get("price") is None and "BTC" in parsed.get("ticker", ""):
        fetched = _fetch_btc_price()
        if fetched:
            parsed["price"] = fetched
            print(f"[signal-store] Fetched BTC price: ${fetched:,.2f}")

    # Append to history
    with open(HISTORY_FILE, "a") as f:
        f.write(json.dumps(parsed) + "\n")
    
    # Update latest state
    state = _load_state()
    ticker = parsed.get("ticker", "UNKNOWN")
    action = parsed.get("action", "UNKNOWN")
    
    if ticker not in state:
        state[ticker] = {
            "direction": None,
            "entry_price": None,
            "last_signal_time": None,
            "last_action": None,
            "signal_count": 0,
            "pnl_history": [],
        }
    
    pos = state[ticker]
    pos["last_signal_time"] = parsed.get("timestamp")
    pos["last_action"] = action
    pos["signal_count"] += 1
    
    # Update position tracking
    if action in ("BUY", "SELL", "FLIP"):
        # If flipping direction, calculate paper PnL on the close
        if pos["direction"] and pos["entry_price"] and parsed.get("price"):
            old_dir = pos["direction"]
            entry = pos["entry_price"]
            exit_price = parsed["price"]
            
            if old_dir == "LONG":
                pnl_pct = ((exit_price - entry) / entry) * 100
            else:
                pnl_pct = ((entry - exit_price) / entry) * 100
            
            pos["pnl_history"].append({
                "closed_at": parsed["timestamp"],
                "direction": old_dir,
                "entry": entry,
                "exit": exit_price,
                "pnl_pct": round(pnl_pct, 4),
            })
            
            # Keep last 100 trades
            pos["pnl_history"] = pos["pnl_history"][-100:]
        
        # Set new position
        if action in ("BUY", "FLIP") and "buy" in parsed.get("raw_message", "").lower():
            pos["direction"] = "LONG"
        elif action == "BUY":
            pos["direction"] = "LONG"
        elif action == "SELL":
            pos["direction"] = "SHORT"
        elif action == "FLIP":
            # Toggle
            pos["direction"] = "SHORT" if pos["direction"] == "LONG" else "LONG"
        
        pos["entry_price"] = parsed.get("price")
    
    elif action in ("TAKE_PROFIT", "STOP_LOSS"):
        # Position closed
        if pos["entry_price"] and parsed.get("price"):
            old_dir = pos["direction"] or "LONG"
            entry = pos["entry_price"]
            exit_price = parsed["price"]
            
            if old_dir == "LONG":
                pnl_pct = ((exit_price - entry) / entry) * 100
            else:
                pnl_pct = ((entry - exit_price) / entry) * 100
            
            pos["pnl_history"].append({
                "closed_at": parsed["timestamp"],
                "direction": old_dir,
                "entry": entry,
                "exit": exit_price,
                "pnl_pct": round(pnl_pct, 4),
                "exit_type": action,
            })
            pos["pnl_history"] = pos["pnl_history"][-100:]
        
        pos["direction"] = None
        pos["entry_price"] = None
    
    _save_state(state)


def get_latest_state() -> dict:
    """Return current position state for all tickers."""
    return _load_state()


def get_signal_history(ticker: str, limit: int = 50) -> list:
    """Return recent signals for a specific ticker."""
    results = []
    if not os.path.exists(HISTORY_FILE):
        return results
    
    with open(HISTORY_FILE, "r") as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            try:
                signal = json.loads(line)
                if signal.get("ticker", "").upper() == ticker.upper():
                    results.append(signal)
            except json.JSONDecodeError:
                continue
    
    return results[-limit:]


def get_performance_summary(ticker: str) -> dict:
    """Quick performance stats for a ticker."""
    state = _load_state()
    if ticker not in state:
        return {"error": "No data for ticker"}
    
    pos = state[ticker]
    history = pos.get("pnl_history", [])
    
    if not history:
        return {"ticker": ticker, "trades": 0}
    
    wins = [t for t in history if t["pnl_pct"] > 0]
    losses = [t for t in history if t["pnl_pct"] <= 0]
    
    return {
        "ticker": ticker,
        "total_trades": len(history),
        "wins": len(wins),
        "losses": len(losses),
        "win_rate": round(len(wins) / len(history) * 100, 1) if history else 0,
        "avg_win_pct": round(sum(t["pnl_pct"] for t in wins) / len(wins), 4) if wins else 0,
        "avg_loss_pct": round(sum(t["pnl_pct"] for t in losses) / len(losses), 4) if losses else 0,
        "total_pnl_pct": round(sum(t["pnl_pct"] for t in history), 4),
        "current_direction": pos.get("direction"),
        "current_entry": pos.get("entry_price"),
    }


def _load_state() -> dict:
    if os.path.exists(STATE_FILE):
        with open(STATE_FILE, "r") as f:
            return json.load(f)
    return {}


def _save_state(state: dict):
    with open(STATE_FILE, "w") as f:
        json.dump(state, f, indent=2)
