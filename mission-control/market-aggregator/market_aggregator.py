#!/usr/bin/env python3
"""
Market Data Aggregator — Scrapes free sources, builds briefing for agents
Zero tokens. Runs on cron. Saves to directives for Boba to read.

Sources:
- CryptoCompare (OHLCV, price)
- CoinGecko (market cap, volume, dominance)
- Fear & Greed Index
- FRED (DXY, rates)
- Signal Receiver (our own signals + regime)
- SuperTrend Optimizer (best params)
"""

import json
import os
import sys
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
    get_secret = get_api_key

DIRECTIVES = os.path.expanduser("~/.openclaw/workspace/directives")
SIGNAL_DATA = os.path.expanduser("~/mission-control/signal-receiver/data")
os.makedirs(DIRECTIVES, exist_ok=True)


def _fetch_json(url, headers=None, timeout=15):
    """Safe JSON fetch."""
    req = urllib.request.Request(url, headers=headers or {"Accept": "application/json"})
    try:
        with urllib.request.urlopen(req, timeout=timeout) as resp:
            return json.loads(resp.read().decode("utf-8"))
    except Exception as e:
        print(f"  [FAIL] {url[:60]}: {e}")
        return None


def fetch_btc_price():
    """BTC price + 24h change from CoinGecko (free, no key)."""
    data = _fetch_json("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,solana&vs_currencies=usd&include_24hr_change=true&include_24hr_vol=true&include_market_cap=true")
    if not data:
        return {}
    result = {}
    for coin, info in data.items():
        result[coin] = {
            "price": info.get("usd", 0),
            "change_24h_pct": round(info.get("usd_24h_change", 0), 2),
            "volume_24h": round(info.get("usd_24h_vol", 0)),
            "market_cap": round(info.get("usd_market_cap", 0)),
        }
    return result


def fetch_fear_greed():
    """Crypto Fear & Greed Index (free)."""
    data = _fetch_json("https://api.alternative.me/fng/?limit=1")
    if not data or "data" not in data:
        return {}
    entry = data["data"][0]
    return {
        "value": int(entry.get("value", 0)),
        "label": entry.get("value_classification", ""),
        "timestamp": entry.get("timestamp", ""),
    }


def fetch_btc_ohlcv():
    """Last 24 candles from CryptoCompare (1H)."""
    try:
        api_key = get_api_key("cryptocompare")
    except Exception:
        api_key = None

    headers = {"Accept": "application/json"}
    if api_key:
        headers["authorization"] = f"Apikey {api_key}"

    data = _fetch_json("https://min-api.cryptocompare.com/data/v2/histohour?fsym=BTC&tsym=USD&limit=24", headers)
    if not data or data.get("Response") != "Success":
        return {}

    bars = data.get("Data", {}).get("Data", [])
    if not bars:
        return {}

    closes = [b["close"] for b in bars if b["close"] > 0]
    highs = [b["high"] for b in bars if b["high"] > 0]
    lows = [b["low"] for b in bars if b["low"] > 0]
    volumes = [b.get("volumefrom", 0) for b in bars]

    high_24h = max(highs) if highs else 0
    low_24h = min(lows) if lows else 0
    avg_volume = sum(volumes) / len(volumes) if volumes else 0

    # Simple trend: compare first vs last close
    trend = "UP" if closes[-1] > closes[0] else "DOWN" if closes[-1] < closes[0] else "FLAT"
    change_pct = ((closes[-1] - closes[0]) / closes[0] * 100) if closes[0] > 0 else 0

    return {
        "current": closes[-1] if closes else 0,
        "high_24h": high_24h,
        "low_24h": low_24h,
        "range_pct": round(((high_24h - low_24h) / low_24h * 100), 2) if low_24h > 0 else 0,
        "trend_24h": trend,
        "change_24h_pct": round(change_pct, 2),
        "avg_hourly_volume": round(avg_volume, 2),
        "candle_count": len(closes),
    }


def fetch_global_crypto():
    """Global crypto market data from CoinGecko (free)."""
    data = _fetch_json("https://api.coingecko.com/api/v3/global")
    if not data or "data" not in data:
        return {}
    d = data["data"]
    return {
        "total_market_cap_usd": round(d.get("total_market_cap", {}).get("usd", 0)),
        "total_volume_24h": round(d.get("total_volume", {}).get("usd", 0)),
        "btc_dominance": round(d.get("market_cap_percentage", {}).get("btc", 0), 1),
        "eth_dominance": round(d.get("market_cap_percentage", {}).get("eth", 0), 1),
        "active_cryptos": d.get("active_cryptocurrencies", 0),
        "market_cap_change_24h": round(d.get("market_cap_change_percentage_24h_usd", 0), 2),
    }


def fetch_fred_data():
    """DXY and Treasury rates from FRED (free key)."""
    try:
        api_key = get_api_key("fred")
    except Exception:
        return {}

    result = {}
    series = {
        "DXY": "DTWEXBGS",
        "treasury_10y": "DGS10",
        "fed_funds_rate": "FEDFUNDS",
        "unemployment": "UNRATE",
    }

    for name, series_id in series.items():
        url = f"https://api.stlouisfed.org/fred/series/observations?series_id={series_id}&api_key={api_key}&file_type=json&sort_order=desc&limit=1"
        data = _fetch_json(url)
        if data and "observations" in data and data["observations"]:
            obs = data["observations"][0]
            try:
                result[name] = {
                    "value": float(obs["value"]),
                    "date": obs["date"],
                }
            except (ValueError, KeyError):
                pass

    return result


def load_internal_data():
    """Load our own signal receiver / regime / optimizer data."""
    internal = {}

    # Regime
    try:
        with open(f"{SIGNAL_DATA}/market_regime.json", "r") as f:
            regime = json.load(f)
            internal["regime"] = {
                "overall": regime.get("overall_regime"),
                "bias": regime.get("direction_bias"),
                "recommendation": regime.get("overall_recommendation"),
                "timeframes": {tf: {"regime": d.get("regime"), "adx": d.get("adx"), "choppiness": d.get("choppiness")} for tf, d in regime.get("timeframes", {}).items()},
            }
    except Exception:
        internal["regime"] = None

    # Optimal params
    try:
        with open(f"{SIGNAL_DATA}/optimal_params.json", "r") as f:
            params = json.load(f)
            internal["optimal_params"] = {
                "atr_period": params.get("recommended_atr_period"),
                "multiplier": params.get("recommended_multiplier"),
                "win_rate": params.get("expected_win_rate"),
                "profit_factor": params.get("expected_profit_factor"),
                "backtest_return": params.get("backtest_return_pct"),
            }
    except Exception:
        internal["optimal_params"] = None

    # Latest position state
    try:
        with open(f"{SIGNAL_DATA}/latest_state.json", "r") as f:
            internal["positions"] = json.load(f)
    except Exception:
        internal["positions"] = {}

    # Daily report
    try:
        with open(f"{SIGNAL_DATA}/daily_report.json", "r") as f:
            report = json.load(f)
            internal["today"] = {
                "signals": report.get("signals"),
                "pnl": report.get("pnl"),
            }
    except Exception:
        internal["today"] = None

    return internal


def build_briefing():
    """Build complete market briefing."""
    print(f"\n{'='*60}")
    print(f"Market Data Aggregator — {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M UTC')}")
    print(f"{'='*60}\n")

    briefing = {
        "generated": datetime.now(timezone.utc).isoformat(),
        "generated_human": datetime.now(timezone.utc).strftime("%B %d, %Y %I:%M %p UTC"),
    }

    print("Fetching BTC price...")
    briefing["prices"] = fetch_btc_price()

    print("Fetching BTC OHLCV 24h...")
    briefing["btc_24h"] = fetch_btc_ohlcv()

    print("Fetching Fear & Greed...")
    briefing["fear_greed"] = fetch_fear_greed()

    print("Fetching global crypto market...")
    briefing["global_market"] = fetch_global_crypto()

    print("Fetching FRED macro data...")
    briefing["macro"] = fetch_fred_data()

    print("Loading internal data...")
    briefing["internal"] = load_internal_data()

    # Build text summary for Boba
    btc = briefing.get("prices", {}).get("bitcoin", {})
    fg = briefing.get("fear_greed", {})
    ohlcv = briefing.get("btc_24h", {})
    regime = briefing.get("internal", {}).get("regime", {})
    params = briefing.get("internal", {}).get("optimal_params", {})
    macro = briefing.get("macro", {})
    global_mkt = briefing.get("global_market", {})
    positions = briefing.get("internal", {}).get("positions", {})

    summary_lines = [
        f"# Market Briefing — {briefing['generated_human']}",
        "",
        f"## BTC: ${btc.get('price', 0):,.2f} ({btc.get('change_24h_pct', 0):+.1f}% 24h)",
        f"- 24h Range: ${ohlcv.get('low_24h', 0):,.0f} — ${ohlcv.get('high_24h', 0):,.0f} ({ohlcv.get('range_pct', 0):.1f}%)",
        f"- 24h Trend: {ohlcv.get('trend_24h', '?')}",
        f"- Volume: {btc.get('volume_24h', 0):,.0f} USD",
        f"- Fear & Greed: {fg.get('value', '?')} ({fg.get('label', '?')})",
        "",
        f"## Market Regime: {regime.get('overall', 'UNKNOWN') if regime else 'UNKNOWN'}",
        f"- Bias: {regime.get('bias', '?') if regime else '?'}",
        f"- Recommendation: {regime.get('recommendation', '') if regime else ''}",
    ]

    if regime and regime.get("timeframes"):
        for tf, d in regime["timeframes"].items():
            summary_lines.append(f"- {tf}: {d.get('regime', '?')} (ADX {d.get('adx', '?')}, Chop {d.get('choppiness', '?')})")

    summary_lines.append("")
    if params:
        summary_lines.append(f"## Optimal SuperTrend: ATR {params.get('atr_period')} / Mult {params.get('multiplier')}")
        summary_lines.append(f"- Win Rate: {params.get('win_rate')}% | PF: {params.get('profit_factor')} | Return: {params.get('backtest_return')}%")

    summary_lines.append("")
    summary_lines.append("## Positions")
    for ticker, data in positions.items():
        if isinstance(data, dict) and data.get("direction"):
            entry = data.get("entry_price")
            summary_lines.append(f"- {ticker}: {data['direction']} @ ${entry:,.2f}" if entry else f"- {ticker}: {data['direction']}")

    if macro:
        summary_lines.append("")
        summary_lines.append("## Macro")
        for name, d in macro.items():
            if isinstance(d, dict):
                summary_lines.append(f"- {name}: {d.get('value', '?')} (as of {d.get('date', '?')})")

    if global_mkt:
        summary_lines.append("")
        summary_lines.append(f"## Global Crypto")
        summary_lines.append(f"- Total Market Cap: ${global_mkt.get('total_market_cap_usd', 0):,.0f}")
        summary_lines.append(f"- BTC Dominance: {global_mkt.get('btc_dominance', 0)}%")
        summary_lines.append(f"- 24h Change: {global_mkt.get('market_cap_change_24h', 0):+.1f}%")

    summary_text = "\n".join(summary_lines)
    briefing["summary"] = summary_text

    # Save JSON
    json_path = os.path.join(DIRECTIVES, "market_briefing.json")
    with open(json_path, "w") as f:
        json.dump(briefing, f, indent=2)
    print(f"\nJSON saved: {json_path}")

    # Save readable markdown
    md_path = os.path.join(DIRECTIVES, "market_briefing.md")
    with open(md_path, "w") as f:
        f.write(summary_text)
    print(f"Markdown saved: {md_path}")

    # Print summary
    print(f"\n{summary_text}")

    return briefing


if __name__ == "__main__":
    build_briefing()
