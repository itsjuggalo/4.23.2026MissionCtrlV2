#!/usr/bin/env python3
"""
market_data_fetch.py — Pre-fetches ALL market data into a single JSON file.
Agents read this file instead of fetching their own data.
Run 5 minutes before each brief cron.

Usage:
  python3 market_data_fetch.py          # Full fetch (morning/EOD)
  python3 market_data_fetch.py --quick   # Quick fetch (midday/heartbeat)
"""

import json
import os
import sys
import requests
from datetime import datetime, timezone, timedelta

EST = timezone(timedelta(hours=-4))
NOW = datetime.now(EST)
SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"
OUTPUT_FILE = "/home/ubuntu/.openclaw/workspace/market_data_latest.json"
DATA_DIR = "/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data"
SIGNAL_DIR = "/home/ubuntu/mission-control/signal-receiver/data"

QUICK_MODE = "--quick" in sys.argv


def load_secret(name):
    for fname in [name, name + ".txt"]:
        path = os.path.join(SECRETS_DIR, fname)
        if os.path.exists(path):
            with open(path) as f:
                return f.read().strip()
    return None


def safe_get(url, params=None, timeout=10):
    """Fetch URL, return JSON or empty dict on failure."""
    try:
        r = requests.get(url, params=params, timeout=timeout)
        if r.status_code == 200:
            return r.json()
    except:
        pass
    return {}


def fetch_crypto_prices():
    """BTC, ETH, SOL, and top 30 coins from CoinGecko."""
    # Core prices
    core = safe_get("https://api.coingecko.com/api/v3/simple/price", {
        "ids": "bitcoin,ethereum,solana,dogecoin,ripple,cardano,avalanche-2,chainlink,polkadot,litecoin,sui,near,aptos,cosmos,injective-protocol,optimism,arbitrum",
        "vs_currencies": "usd",
        "include_24hr_change": "true",
        "include_24hr_vol": "true",
        "include_market_cap": "true"
    })

    # Top movers
    top30 = safe_get("https://api.coingecko.com/api/v3/coins/markets", {
        "vs_currency": "usd", "order": "market_cap_desc",
        "per_page": "30", "sparkline": "false",
        "price_change_percentage": "1h,24h,7d"
    })

    # Global data (dominance, total market cap)
    global_data = safe_get("https://api.coingecko.com/api/v3/global")

    return {
        "prices": core,
        "top30": [{
            "symbol": c.get("symbol", "").upper(),
            "name": c.get("name", ""),
            "price": c.get("current_price", 0),
            "change_1h": c.get("price_change_percentage_1h_in_currency", 0),
            "change_24h": c.get("price_change_percentage_24h", 0),
            "change_7d": c.get("price_change_percentage_7d_in_currency", 0),
            "volume": c.get("total_volume", 0),
            "market_cap": c.get("market_cap", 0),
        } for c in (top30 if isinstance(top30, list) else [])],
        "btc_dominance": global_data.get("data", {}).get("market_cap_percentage", {}).get("btc", 0),
        "total_market_cap": global_data.get("data", {}).get("total_market_cap", {}).get("usd", 0),
    }


def fetch_fear_greed():
    data = safe_get("https://api.alternative.me/fng/")
    entry = data.get("data", [{}])[0] if data.get("data") else {}
    return {
        "value": int(entry.get("value", 50)),
        "label": entry.get("value_classification", "Unknown"),
    }


def fetch_btc_funding():
    data = safe_get("https://www.okx.com/api/v5/public/funding-rate", {"instId": "BTC-USDT-SWAP"})
    rate = float(data.get("data", [{}])[0].get("fundingRate", 0)) * 100 if data.get("data") else 0
    return {
        "rate_pct": round(rate, 5),
        "squeeze_risk": "HIGH" if abs(rate) > 0.05 else "LOW" if abs(rate) < 0.01 else "MODERATE",
    }


def fetch_btc_candles():
    """Fetch 1H and 4H candles for technical analysis."""
    result = {}
    for tf in ["1H", "4H", "1D"]:
        data = safe_get("https://www.okx.com/api/v5/market/candles", {
            "instId": "BTC-USDT", "bar": tf, "limit": "50"
        })
        candles = data.get("data", [])
        if candles:
            parsed = []
            for c in candles[:30]:
                parsed.append({
                    "ts": int(c[0]),
                    "open": float(c[1]),
                    "high": float(c[2]),
                    "low": float(c[3]),
                    "close": float(c[4]),
                    "volume": float(c[5]),
                })
            
            highs = [x["high"] for x in parsed[:10]]
            lows = [x["low"] for x in parsed[:10]]
            closes = [x["close"] for x in parsed]
            
            # Simple RSI calculation
            rsi = calc_rsi(closes)
            
            # Simple trend
            avg20 = sum(closes[:20]) / min(len(closes), 20)
            current = closes[0]
            if current > avg20 * 1.01:
                trend = "BULLISH"
            elif current < avg20 * 0.99:
                trend = "BEARISH"
            else:
                trend = "NEUTRAL"
            
            result[tf] = {
                "candles": parsed[:10],  # Last 10 only to save space
                "current_price": parsed[0]["close"],
                "high_10": max(highs),
                "low_10": min(lows),
                "support": min(lows[:5]),
                "resistance": max(highs[:5]),
                "trend": trend,
                "rsi_14": round(rsi, 1) if rsi else None,
                "avg_volume": sum(x["volume"] for x in parsed[:20]) / 20,
            }
    return result


def calc_rsi(closes, period=14):
    """Calculate RSI from close prices (newest first)."""
    if len(closes) < period + 1:
        return None
    # Reverse so oldest first for calculation
    prices = list(reversed(closes[:period + 10]))
    gains = []
    losses = []
    for i in range(1, len(prices)):
        diff = prices[i] - prices[i-1]
        gains.append(max(diff, 0))
        losses.append(max(-diff, 0))
    
    if len(gains) < period:
        return None
    
    avg_gain = sum(gains[:period]) / period
    avg_loss = sum(losses[:period]) / period
    
    for i in range(period, len(gains)):
        avg_gain = (avg_gain * (period - 1) + gains[i]) / period
        avg_loss = (avg_loss * (period - 1) + losses[i]) / period
    
    if avg_loss == 0:
        return 100
    rs = avg_gain / avg_loss
    return 100 - (100 / (1 + rs))


def fetch_alpaca():
    """Full Alpaca paper account data."""
    key = load_secret("alpaca-key-id")
    secret = load_secret("alpaca-secret")
    if not key or not secret:
        return {"error": "No Alpaca keys found"}
    
    headers = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": secret}
    base = "https://paper-api.alpaca.markets"
    
    acct = safe_get(f"{base}/v2/account")
    if not acct:
        try:
            r = requests.get(f"{base}/v2/account", headers=headers, timeout=10)
            acct = r.json()
        except:
            acct = {}
    else:
        # safe_get doesn't pass headers, retry with headers
        try:
            r = requests.get(f"{base}/v2/account", headers=headers, timeout=10)
            acct = r.json()
        except:
            pass
    
    positions = []
    try:
        r = requests.get(f"{base}/v2/positions", headers=headers, timeout=10)
        pos_data = r.json()
        for p in pos_data:
            positions.append({
                "symbol": p.get("symbol"),
                "qty": float(p.get("qty", 0)),
                "side": p.get("side"),
                "avg_entry": float(p.get("avg_entry_price", 0)),
                "current_price": float(p.get("current_price", 0)),
                "market_value": float(p.get("market_value", 0)),
                "unrealized_pnl": float(p.get("unrealized_pl", 0)),
                "unrealized_pnl_pct": round(float(p.get("unrealized_plpc", 0)) * 100, 2),
                "intraday_pnl": float(p.get("unrealized_intraday_pl", 0)),
                "change_today": round(float(p.get("change_today", 0)) * 100, 2),
            })
    except:
        pass
    
    # Recent orders
    orders = []
    try:
        r = requests.get(f"{base}/v2/orders", headers=headers, 
            params={"status": "all", "limit": "20", "direction": "desc"}, timeout=10)
        for o in r.json()[:10]:
            orders.append({
                "symbol": o.get("symbol"),
                "side": o.get("side"),
                "type": o.get("type"),
                "qty": o.get("qty"),
                "filled_qty": o.get("filled_qty"),
                "filled_avg_price": o.get("filled_avg_price"),
                "status": o.get("status"),
                "submitted_at": o.get("submitted_at"),
                "filled_at": o.get("filled_at"),
            })
    except:
        pass
    
    return {
        "equity": float(acct.get("equity", 0)),
        "cash": float(acct.get("cash", 0)),
        "buying_power": float(acct.get("buying_power", 0)),
        "last_equity": float(acct.get("last_equity", 0)),
        "portfolio_value": float(acct.get("portfolio_value", 0)),
        "daily_change": float(acct.get("equity", 0)) - float(acct.get("last_equity", 0)),
        "daily_change_pct": round(
            (float(acct.get("equity", 0)) - float(acct.get("last_equity", 0))) / 
            max(float(acct.get("last_equity", 1)), 1) * 100, 2
        ),
        "total_return_pct": round(
            (float(acct.get("equity", 0)) - 100000) / 100000 * 100, 2
        ),
        "positions": positions,
        "recent_orders": orders,
    }


def fetch_supertrend():
    """Read local SuperTrend signal state."""
    try:
        with open(os.path.join(SIGNAL_DIR, "latest_state.json")) as f:
            data = json.load(f)
        btc = data.get("BTCUSD", {})
        return {
            "direction": btc.get("direction", "UNKNOWN"),
            "entry_price": btc.get("entry_price", 0),
            "signal_count": btc.get("signal_count", 0),
            "last_action": btc.get("last_action", "UNKNOWN"),
        }
    except:
        return {"direction": "UNKNOWN", "entry_price": 0}


def fetch_market_regime():
    """Read local market regime data."""
    try:
        with open(os.path.join(SIGNAL_DIR, "market_regime.json")) as f:
            return json.load(f)
    except:
        return {"overall_regime": "UNKNOWN"}


def fetch_optimal_params():
    """Read local SuperTrend optimal params."""
    try:
        with open(os.path.join(SIGNAL_DIR, "optimal_params.json")) as f:
            return json.load(f)
    except:
        return {}


def fetch_whale_flow():
    """Read scraped FlowGreeks data for high-value institutional flow."""
    whales = []
    for fname in ["flow_alerts_today.json", "flow2_alerts_today.json"]:
        path = os.path.join(DATA_DIR, fname)
        if not os.path.exists(path):
            continue
        try:
            with open(path) as f:
                data = json.load(f)
            items = data.values() if isinstance(data, dict) else data
            for item in items:
                alert = item.get("alert", item) if isinstance(item, dict) else {}
                quote = item.get("quote", {}) if isinstance(item, dict) else {}
                value = float(alert.get("totalFlowValue", 0))
                if value >= 500_000:  # $500K+ 
                    whales.append({
                        "symbol": alert.get("Symbol", "?"),
                        "strike": alert.get("Strike", "?"),
                        "option_type": alert.get("OptionType", "?"),
                        "value": value,
                        "bullish": alert.get("isBullish"),
                        "sweeps": alert.get("SWEEPS", 0),
                        "blocks": alert.get("BLOCKS", 0),
                        "volume": alert.get("Volume", 0),
                        "oi": alert.get("OI", 0),
                        "spot": alert.get("Spot", 0),
                        "dte": alert.get("DTE", 0),
                        "alert_price": alert.get("AlertPrice", 0),
                        "last_price": quote.get("Last", 0),
                        "day_high": quote.get("DayHigh", 0),
                    })
        except:
            pass
    
    whales.sort(key=lambda x: x["value"], reverse=True)
    return whales[:15]


def fetch_active_signals():
    """Read active option signal trade recommendations."""
    signals = []
    for fname in ["short_term_options.json", "option_notifications.json"]:
        path = os.path.join(DATA_DIR, fname)
        if not os.path.exists(path):
            continue
        try:
            with open(path) as f:
                data = json.load(f)
            items = list(data.values()) if isinstance(data, dict) else data
            for item in items[-10:]:
                if isinstance(item, dict) and item.get("symbol"):
                    signals.append({
                        "symbol": item.get("symbol"),
                        "title": item.get("title", ""),
                        "category": item.get("category", ""),
                        "message": item.get("message", ""),
                        "strike": item.get("strike", ""),
                        "expiry": item.get("expiry", ""),
                        "buyTarget": item.get("buyTarget", ""),
                        "sellTarget": item.get("sellTarget", ""),
                        "sellTarget2": item.get("sellTarget2", ""),
                        "stopLoss": item.get("stopLoss", ""),
                    })
        except:
            pass
    return signals[-10:]


def main():
    print(f"[{NOW.strftime('%I:%M %p EST')}] Fetching market data...")
    
    result = {
        "fetched_at": NOW.isoformat(),
        "fetched_at_readable": NOW.strftime("%A, %B %d, %Y %I:%M %p EST"),
        "mode": "quick" if QUICK_MODE else "full",
    }
    
    # Always fetch
    print("  Crypto prices...")
    result["crypto"] = fetch_crypto_prices()
    
    print("  Fear & Greed...")
    result["fear_greed"] = fetch_fear_greed()
    
    print("  BTC funding...")
    result["funding"] = fetch_btc_funding()
    
    print("  BTC candles & technicals...")
    result["btc_technicals"] = fetch_btc_candles()
    
    print("  Alpaca portfolio...")
    result["portfolio"] = fetch_alpaca()
    
    print("  SuperTrend signal...")
    result["supertrend"] = fetch_supertrend()
    
    print("  Market regime...")
    result["market_regime"] = fetch_market_regime()
    
    if not QUICK_MODE:
        print("  Optimal params...")
        result["optimal_params"] = fetch_optimal_params()
        
        print("  Whale flow ($500K+)...")
        result["whale_flow"] = fetch_whale_flow()
        
        print("  Active trade signals...")
        result["active_signals"] = fetch_active_signals()
    
    # Write output
    os.makedirs(os.path.dirname(OUTPUT_FILE), exist_ok=True)
    with open(OUTPUT_FILE, "w") as f:
        json.dump(result, f, indent=2, default=str)
    
    size = os.path.getsize(OUTPUT_FILE)
    print(f"\nSaved to {OUTPUT_FILE} ({size:,} bytes)")
    print("Done. Agents can now read this file for their briefs.")


if __name__ == "__main__":
    main()
