#!/usr/bin/env python3
"""
Historical Data Fetcher — Pull OHLCV from CryptoCompare
Zero LLM calls. Pure Python.
"""

import json
import os
import sys
import time
import urllib.request
from datetime import datetime, timezone

sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

try:
    from mc_utils import get_api_key
except ImportError:
    def get_api_key(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()

CACHE_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "cache")
os.makedirs(CACHE_DIR, exist_ok=True)


def fetch_ohlcv(symbol: str = "BTC", currency: str = "USD",
                timeframe: str = "1H", limit: int = 2000) -> list:
    """
    Fetch historical OHLCV data from CryptoCompare.

    timeframe: '1H', '4H', '1D', '15m', '5m', '1m'
    limit: max candles to fetch (up to 2000)

    Returns list of dicts: [{timestamp, open, high, low, close, volume}, ...]
    """

    # Map timeframe to API endpoint
    tf_map = {
        "1m": ("histominute", 1),
        "5m": ("histominute", 5),
        "15m": ("histominute", 15),
        "30m": ("histominute", 30),
        "1H": ("histohour", 1),
        "2H": ("histohour", 2),
        "4H": ("histohour", 4),
        "1D": ("histoday", 1),
    }

    if timeframe not in tf_map:
        raise ValueError(f"Unsupported timeframe: {timeframe}. Use: {list(tf_map.keys())}")

    endpoint, aggregate = tf_map[timeframe]

    # Try to get API key
    try:
        api_key = get_api_key("cryptocompare")
    except Exception:
        api_key = None

    # Build URL
    url = f"https://min-api.cryptocompare.com/data/v2/{endpoint}"
    url += f"?fsym={symbol}&tsym={currency}&limit={limit}&aggregate={aggregate}"

    headers = {"Accept": "application/json"}
    if api_key:
        headers["authorization"] = f"Apikey {api_key}"

    req = urllib.request.Request(url, headers=headers)

    try:
        with urllib.request.urlopen(req, timeout=30) as resp:
            data = json.loads(resp.read().decode("utf-8"))
    except Exception as e:
        print(f"[data_fetcher] API error: {e}")
        return []

    if data.get("Response") != "Success":
        print(f"[data_fetcher] API returned: {data.get('Message', 'Unknown error')}")
        return []

    candles = []
    for bar in data.get("Data", {}).get("Data", []):
        candles.append({
            "timestamp": bar["time"],
            "datetime": datetime.fromtimestamp(bar["time"], tz=timezone.utc).isoformat(),
            "open": bar["open"],
            "high": bar["high"],
            "low": bar["low"],
            "close": bar["close"],
            "volume": bar.get("volumefrom", 0),
        })

    # Filter out zero-price candles
    candles = [c for c in candles if c["close"] > 0]

    return candles


def fetch_extended(symbol: str = "BTC", currency: str = "USD",
                   timeframe: str = "1H", total_candles: int = 5000) -> list:
    """
    Fetch more than 2000 candles by paginating backwards.
    """
    all_candles = []
    to_ts = None
    remaining = total_candles

    while remaining > 0:
        batch_size = min(remaining, 2000)

        tf_map = {
            "1m": ("histominute", 1),
            "5m": ("histominute", 5),
            "15m": ("histominute", 15),
            "30m": ("histominute", 30),
            "1H": ("histohour", 1),
            "2H": ("histohour", 2),
            "4H": ("histohour", 4),
            "1D": ("histoday", 1),
        }

        endpoint, aggregate = tf_map[timeframe]

        try:
            api_key = get_api_key("cryptocompare")
        except Exception:
            api_key = None

        url = f"https://min-api.cryptocompare.com/data/v2/{endpoint}"
        url += f"?fsym={symbol}&tsym={currency}&limit={batch_size}&aggregate={aggregate}"
        if to_ts:
            url += f"&toTs={to_ts}"

        headers = {"Accept": "application/json"}
        if api_key:
            headers["authorization"] = f"Apikey {api_key}"

        req = urllib.request.Request(url, headers=headers)

        try:
            with urllib.request.urlopen(req, timeout=30) as resp:
                data = json.loads(resp.read().decode("utf-8"))
        except Exception as e:
            print(f"[data_fetcher] Pagination error: {e}")
            break

        if data.get("Response") != "Success":
            break

        bars = data.get("Data", {}).get("Data", [])
        if not bars:
            break

        candles = [{
            "timestamp": b["time"],
            "datetime": datetime.fromtimestamp(b["time"], tz=timezone.utc).isoformat(),
            "open": b["open"],
            "high": b["high"],
            "low": b["low"],
            "close": b["close"],
            "volume": b.get("volumefrom", 0),
        } for b in bars if b["close"] > 0]

        all_candles = candles + all_candles
        to_ts = bars[0]["time"] - 1
        remaining -= len(candles)

        time.sleep(0.3)  # Rate limit courtesy

    # Deduplicate by timestamp
    seen = set()
    unique = []
    for c in all_candles:
        if c["timestamp"] not in seen:
            seen.add(c["timestamp"])
            unique.append(c)

    unique.sort(key=lambda x: x["timestamp"])
    return unique


def save_cache(candles: list, symbol: str, timeframe: str):
    """Cache candles to disk."""
    path = os.path.join(CACHE_DIR, f"{symbol}_{timeframe}.json")
    with open(path, "w") as f:
        json.dump(candles, f)
    print(f"[data_fetcher] Cached {len(candles)} candles to {path}")


def load_cache(symbol: str, timeframe: str) -> list:
    """Load cached candles from disk."""
    path = os.path.join(CACHE_DIR, f"{symbol}_{timeframe}.json")
    if os.path.exists(path):
        with open(path, "r") as f:
            candles = json.load(f)
        print(f"[data_fetcher] Loaded {len(candles)} candles from cache")
        return candles
    return []


if __name__ == "__main__":
    print("Fetching BTCUSD 1H data...")
    candles = fetch_ohlcv("BTC", "USD", "1H", 100)
    print(f"Got {len(candles)} candles")
    if candles:
        print(f"First: {candles[0]['datetime']} @ ${candles[0]['close']:,.2f}")
        print(f"Last:  {candles[-1]['datetime']} @ ${candles[-1]['close']:,.2f}")
