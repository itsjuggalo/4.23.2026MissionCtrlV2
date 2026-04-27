#!/usr/bin/env python3
"""
Market Regime Detector — Classify market as TRENDING or RANGING
Zero LLM calls. Pure Python math.

Checks:
1. ADX (Average Directional Index) — trend strength
2. Bollinger Band Width — volatility
3. Price vs moving averages — trend direction consistency

Output: JSON with regime classification + recommended strategy
"""

import json
import os
import sys
import math
import urllib.request
from datetime import datetime, timezone

sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

try:
    from mc_utils import get_api_key, get_secret
except ImportError:
    def get_api_key(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()
    def get_secret(name):
        return get_api_key(name)

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
RESULTS_DIR = os.path.join(BASE_DIR, "results")
WORKSPACE_DIR = os.path.expanduser("~/.openclaw/workspace/directives")
os.makedirs(RESULTS_DIR, exist_ok=True)
os.makedirs(WORKSPACE_DIR, exist_ok=True)


def fetch_candles(symbol="BTC", currency="USD", timeframe="1H", limit=200):
    """Fetch recent candles from CryptoCompare."""
    tf_map = {
        "1H": ("histohour", 1),
        "4H": ("histohour", 4),
        "1D": ("histoday", 1),
    }
    endpoint, aggregate = tf_map.get(timeframe, ("histohour", 1))

    try:
        api_key = get_api_key("cryptocompare")
    except Exception:
        api_key = None

    url = f"https://min-api.cryptocompare.com/data/v2/{endpoint}"
    url += f"?fsym={symbol}&tsym={currency}&limit={limit}&aggregate={aggregate}"

    headers = {"Accept": "application/json"}
    if api_key:
        headers["authorization"] = f"Apikey {api_key}"

    req = urllib.request.Request(url, headers=headers)
    with urllib.request.urlopen(req, timeout=30) as resp:
        data = json.loads(resp.read().decode("utf-8"))

    candles = []
    for bar in data.get("Data", {}).get("Data", []):
        if bar["close"] > 0:
            candles.append({
                "high": bar["high"],
                "low": bar["low"],
                "close": bar["close"],
                "open": bar["open"],
                "volume": bar.get("volumefrom", 0),
            })
    return candles


def calc_ema(values, period):
    """Exponential Moving Average."""
    ema = [0.0] * len(values)
    k = 2.0 / (period + 1)
    ema[0] = values[0]
    for i in range(1, len(values)):
        ema[i] = values[i] * k + ema[i - 1] * (1 - k)
    return ema


def calc_adx(highs, lows, closes, period=14):
    """Average Directional Index — measures trend strength."""
    n = len(closes)
    if n < period * 2:
        return 0, 0, 0

    plus_dm = [0.0] * n
    minus_dm = [0.0] * n
    tr = [0.0] * n

    for i in range(1, n):
        up_move = highs[i] - highs[i - 1]
        down_move = lows[i - 1] - lows[i]

        plus_dm[i] = up_move if up_move > down_move and up_move > 0 else 0
        minus_dm[i] = down_move if down_move > up_move and down_move > 0 else 0

        tr[i] = max(
            highs[i] - lows[i],
            abs(highs[i] - closes[i - 1]),
            abs(lows[i] - closes[i - 1])
        )

    # Smoothed averages
    atr = [0.0] * n
    plus_di_arr = [0.0] * n
    minus_di_arr = [0.0] * n

    atr[period] = sum(tr[1:period + 1]) / period
    s_plus = sum(plus_dm[1:period + 1]) / period
    s_minus = sum(minus_dm[1:period + 1]) / period

    for i in range(period + 1, n):
        atr[i] = (atr[i - 1] * (period - 1) + tr[i]) / period
        s_plus = (s_plus * (period - 1) + plus_dm[i]) / period
        s_minus = (s_minus * (period - 1) + minus_dm[i]) / period

        if atr[i] > 0:
            plus_di_arr[i] = (s_plus / atr[i]) * 100
            minus_di_arr[i] = (s_minus / atr[i]) * 100

    # DX and ADX
    dx = [0.0] * n
    for i in range(period, n):
        denom = plus_di_arr[i] + minus_di_arr[i]
        if denom > 0:
            dx[i] = abs(plus_di_arr[i] - minus_di_arr[i]) / denom * 100

    adx = [0.0] * n
    start = period * 2
    if start < n:
        adx[start] = sum(dx[period:start + 1]) / period
        for i in range(start + 1, n):
            adx[i] = (adx[i - 1] * (period - 1) + dx[i]) / period

    current_adx = adx[-1]
    current_plus = plus_di_arr[-1]
    current_minus = minus_di_arr[-1]

    return current_adx, current_plus, current_minus


def calc_bbw(closes, period=20, std_mult=2.0):
    """Bollinger Band Width — measures volatility."""
    if len(closes) < period:
        return 0

    recent = closes[-period:]
    sma = sum(recent) / period
    variance = sum((c - sma) ** 2 for c in recent) / period
    std = variance ** 0.5

    upper = sma + std_mult * std
    lower = sma - std_mult * std

    bbw = ((upper - lower) / sma) * 100
    return bbw


def calc_choppiness(highs, lows, closes, period=14):
    """Choppiness Index — 0-100, above 61 = choppy, below 38 = trending."""
    n = len(closes)
    if n < period + 1:
        return 50

    tr_sum = 0
    for i in range(n - period, n):
        tr = max(
            highs[i] - lows[i],
            abs(highs[i] - closes[i - 1]) if i > 0 else highs[i] - lows[i],
            abs(lows[i] - closes[i - 1]) if i > 0 else highs[i] - lows[i]
        )
        tr_sum += tr

    highest_high = max(highs[n - period:n])
    lowest_low = min(lows[n - period:n])
    hl_range = highest_high - lowest_low

    if hl_range <= 0 or tr_sum <= 0:
        return 50

    chop = 100 * math.log10(tr_sum / hl_range) / math.log10(period)
    return min(100, max(0, chop))


def calc_trend_consistency(closes, period=50):
    """How consistently price has moved in one direction."""
    if len(closes) < period:
        return 0, "NEUTRAL"

    recent = closes[-period:]
    net_move = recent[-1] - recent[0]
    total_move = sum(abs(recent[i] - recent[i - 1]) for i in range(1, len(recent)))

    if total_move == 0:
        return 0, "NEUTRAL"

    efficiency = abs(net_move) / total_move

    direction = "BULLISH" if net_move > 0 else "BEARISH"
    return efficiency, direction


def detect_regime(symbol="BTC", currency="USD"):
    """
    Detect market regime across timeframes.

    Returns classification:
    - STRONG_TREND: ADX > 30, choppiness < 40 → use SuperTrend
    - WEAK_TREND: ADX 20-30 → use SuperTrend with caution
    - RANGING: ADX < 20, choppiness > 55 → use Grid Bot
    - VOLATILE_CHOP: High BBW + high choppiness → reduce size or sit out
    """
    results = {}

    for tf in ["1H", "4H", "1D"]:
        candles = fetch_candles(symbol, currency, tf, 200)
        if not candles:
            continue

        highs = [c["high"] for c in candles]
        lows = [c["low"] for c in candles]
        closes = [c["close"] for c in candles]

        adx, plus_di, minus_di = calc_adx(highs, lows, closes, 14)
        bbw = calc_bbw(closes, 20)
        chop = calc_choppiness(highs, lows, closes, 14)
        efficiency, direction = calc_trend_consistency(closes, 50)

        # Classify
        if adx > 30 and chop < 40:
            regime = "STRONG_TREND"
            strategy = "SuperTrend Combined"
        elif adx > 20 and chop < 55:
            regime = "WEAK_TREND"
            strategy = "SuperTrend (cautious)"
        elif adx < 20 and chop > 55:
            regime = "RANGING"
            strategy = "Grid Bot"
        elif bbw > 8 and chop > 55:
            regime = "VOLATILE_CHOP"
            strategy = "Reduce size / sit out"
        else:
            regime = "TRANSITIONAL"
            strategy = "DayTrader (light size)"

        results[tf] = {
            "regime": regime,
            "recommended_strategy": strategy,
            "direction": direction,
            "adx": round(adx, 1),
            "plus_di": round(plus_di, 1),
            "minus_di": round(minus_di, 1),
            "bbw": round(bbw, 2),
            "choppiness": round(chop, 1),
            "trend_efficiency": round(efficiency, 3),
            "current_price": closes[-1],
        }

    # Overall recommendation
    tf_regimes = [r["regime"] for r in results.values()]

    if all(r == "STRONG_TREND" for r in tf_regimes):
        overall = "STRONG_TREND"
        rec = "Full size SuperTrend Combined — all timeframes agree"
    elif "STRONG_TREND" in tf_regimes:
        overall = "MIXED_TREND"
        rec = "SuperTrend on trending TFs, Grid Bot on ranging TFs"
    elif all(r == "RANGING" for r in tf_regimes):
        overall = "RANGING"
        rec = "Grid Bot — all timeframes showing range-bound"
    elif "VOLATILE_CHOP" in tf_regimes:
        overall = "VOLATILE_CHOP"
        rec = "Reduce position sizes — high volatility with no direction"
    else:
        overall = "MIXED"
        rec = "DayTrader light size — no clear regime"

    # Determine direction bias
    directions = [r["direction"] for r in results.values()]
    if all(d == "BULLISH" for d in directions):
        bias = "BULLISH"
    elif all(d == "BEARISH" for d in directions):
        bias = "BEARISH"
    else:
        bias = "MIXED"

    output = {
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "symbol": f"{symbol}/{currency}",
        "overall_regime": overall,
        "overall_recommendation": rec,
        "direction_bias": bias,
        "timeframes": results,
    }

    return output


def run_and_save(symbol="BTC", currency="USD"):
    """Run detection and save results."""
    print(f"\n{'='*60}")
    print(f"Market Regime Detector — {symbol}/{currency}")
    print(f"{'='*60}\n")

    output = detect_regime(symbol, currency)

    print(f"Overall: {output['overall_regime']}")
    print(f"Bias:    {output['direction_bias']}")
    print(f"Action:  {output['overall_recommendation']}")
    print()

    for tf, data in output["timeframes"].items():
        print(f"  {tf}: {data['regime']:<16} ADX={data['adx']:<6} Chop={data['choppiness']:<6} "
              f"BBW={data['bbw']:<7} Dir={data['direction']:<8} → {data['recommended_strategy']}")

    # Save for agents
    config_path = os.path.join(WORKSPACE_DIR, f"market_regime_{symbol}.json")
    with open(config_path, "w") as f:
        json.dump(output, f, indent=2)
    print(f"\nSaved: {config_path}")

    # Save to signal receiver
    sr_path = os.path.expanduser("~/mission-control/signal-receiver/data/market_regime.json")
    try:
        with open(sr_path, "w") as f:
            json.dump(output, f, indent=2)
        print(f"Saved: {sr_path}")
    except Exception:
        pass

    # Post to Discord
    try:
        webhook = get_secret("discord_tv_signals_webhook")
        regime_colors = {
            "STRONG_TREND": 65280,
            "WEAK_TREND": 16776960,
            "RANGING": 255,
            "VOLATILE_CHOP": 16711680,
            "MIXED_TREND": 16744448,
            "MIXED": 8421504,
            "TRANSITIONAL": 8421504,
        }
        color = regime_colors.get(output["overall_regime"], 8421504)

        tf_lines = []
        for tf, data in output["timeframes"].items():
            tf_lines.append(f"**{tf}**: {data['regime']} (ADX {data['adx']}, Chop {data['choppiness']})")

        embed = {
            "title": f"Market Regime — {symbol}/{currency}",
            "description": f"**{output['overall_regime']}** | Bias: {output['direction_bias']}",
            "color": color,
            "fields": [
                {"name": "Recommendation", "value": output["overall_recommendation"], "inline": False},
                {"name": "Timeframes", "value": "\n".join(tf_lines), "inline": False},
                {"name": "Price", "value": f"${output['timeframes'].get('1H', {}).get('current_price', 0):,.2f}", "inline": True},
            ],
            "footer": {"text": f"Regime Detector | {output['timestamp']}"},
        }

        payload = json.dumps({"username": "Regime Detector", "embeds": [embed]}).encode("utf-8")
        req = urllib.request.Request(
            webhook, data=payload,
            headers={"Content-Type": "application/json", "User-Agent": "SignalReceiver/1.0"},
            method="POST"
        )
        urllib.request.urlopen(req)
        print("Posted to Discord")
    except Exception as e:
        print(f"Discord error: {e}")

    return output


if __name__ == "__main__":
    symbol = sys.argv[1] if len(sys.argv) > 1 else "BTC"
    currency = sys.argv[2] if len(sys.argv) > 2 else "USD"
    run_and_save(symbol, currency)
