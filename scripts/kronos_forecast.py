#!/usr/bin/env python3
"""Kronos BTC Forecast Service — Mission Control
Uses waterfall data sourcing: Kraken → CryptoCompare → Finnhub → CoinGecko"""

import sys, os, json, time
from datetime import datetime, timezone, timedelta
import requests
import pandas as pd
import numpy as np

sys.path.insert(0, '/home/ubuntu/Kronos')

LOOKBACK = 400
PRED_LEN = 24
SAMPLE_COUNT = 5
OUTPUT_DIR = "/home/ubuntu/.openclaw/workspace/directives"
FORECAST_JSON = os.path.join(OUTPUT_DIR, "kronos_forecast.json")
FORECAST_MD = os.path.join(OUTPUT_DIR, "kronos_forecast.md")
DISCORD_WEBHOOK_FILE = "/home/ubuntu/.openclaw/secrets/discord-webhook-kronos.txt"
FINNHUB_KEY = "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"


def fetch_from_kraken(limit=400):
    """Kraken — free, no key, no geo-block, real exchange OHLCV."""
    print("[1/4] Trying Kraken...")
    try:
        # Kraken returns max 720 candles per request
        r = requests.get(
            "https://api.kraken.com/0/public/OHLC",
            params={"pair": "XBTUSD", "interval": 60, "since": 0},
            timeout=15
        )
        r.raise_for_status()
        data = r.json()
        if data.get("error") and len(data["error"]) > 0:
            raise Exception(f"Kraken error: {data['error']}")

        pair_key = list(data["result"].keys())[0]
        if pair_key == "last":
            pair_key = list(data["result"].keys())[1]

        rows = []
        for c in data["result"][pair_key]:
            rows.append({
                "timestamps": pd.Timestamp(int(c[0]), unit="s", tz="UTC"),
                "open": float(c[1]),
                "high": float(c[2]),
                "low": float(c[3]),
                "close": float(c[4]),
                "volume": float(c[6]),
            })
        df = pd.DataFrame(rows).tail(limit)
        if len(df) >= 100:
            print(f"  Kraken: {len(df)} candles, latest ${df.iloc[-1]['close']:,.2f}")
            return df
        raise Exception(f"Only got {len(df)} candles")
    except Exception as e:
        print(f"  Kraken failed: {e}")
        return None


def fetch_from_cryptocompare(limit=400):
    """CryptoCompare — free, no key needed, good OHLCV."""
    print("[2/4] Trying CryptoCompare...")
    try:
        r = requests.get(
            "https://min-api.cryptocompare.com/data/v2/histohour",
            params={"fsym": "BTC", "tsym": "USD", "limit": limit},
            timeout=15
        )
        r.raise_for_status()
        data = r.json()
        if data.get("Response") != "Success":
            raise Exception(f"API: {data.get('Message', 'unknown')}")

        rows = []
        for c in data["Data"]["Data"]:
            if c["close"] > 0:
                rows.append({
                    "timestamps": pd.Timestamp(c["time"], unit="s", tz="UTC"),
                    "open": float(c["open"]),
                    "high": float(c["high"]),
                    "low": float(c["low"]),
                    "close": float(c["close"]),
                    "volume": float(c.get("volumefrom", 0)),
                })
        df = pd.DataFrame(rows)
        if len(df) >= 100:
            print(f"  CryptoCompare: {len(df)} candles, latest ${df.iloc[-1]['close']:,.2f}")
            return df
        raise Exception(f"Only got {len(df)} candles")
    except Exception as e:
        print(f"  CryptoCompare failed: {e}")
        return None


def fetch_from_finnhub(limit=400):
    """Finnhub — key on file, crypto candles endpoint."""
    print("[3/4] Trying Finnhub...")
    try:
        now = int(time.time())
        start = now - (limit * 3600)
        r = requests.get(
            "https://finnhub.io/api/v1/crypto/candle",
            params={
                "symbol": "COINBASE:BTC-USD",
                "resolution": "60",
                "from": start,
                "to": now,
                "token": FINNHUB_KEY,
            },
            timeout=15
        )
        r.raise_for_status()
        data = r.json()
        if data.get("s") != "ok" or not data.get("t"):
            raise Exception(f"No data: {data.get('s', 'unknown')}")

        rows = []
        for i in range(len(data["t"])):
            rows.append({
                "timestamps": pd.Timestamp(data["t"][i], unit="s", tz="UTC"),
                "open": float(data["o"][i]),
                "high": float(data["h"][i]),
                "low": float(data["l"][i]),
                "close": float(data["c"][i]),
                "volume": float(data["v"][i]),
            })
        df = pd.DataFrame(rows)
        if len(df) >= 100:
            print(f"  Finnhub: {len(df)} candles, latest ${df.iloc[-1]['close']:,.2f}")
            return df
        raise Exception(f"Only got {len(df)} candles")
    except Exception as e:
        print(f"  Finnhub failed: {e}")
        return None


def fetch_from_coingecko(limit=400):
    """CoinGecko — last resort, interpolated hourly data."""
    print("[4/4] Trying CoinGecko...")
    try:
        r = requests.get(
            "https://api.coingecko.com/api/v3/coins/bitcoin/market_chart",
            params={"vs_currency": "usd", "days": 14, "interval": "hourly"},
            timeout=15
        )
        r.raise_for_status()
        prices = r.json()["prices"]
        rows = []
        for p in prices:
            price = float(p[1])
            rows.append({
                "timestamps": pd.Timestamp(p[0], unit="ms", tz="UTC"),
                "open": price,
                "high": price * 1.002,
                "low": price * 0.998,
                "close": price,
                "volume": 0.0,
            })
        df = pd.DataFrame(rows).tail(limit)
        if len(df) >= 50:
            print(f"  CoinGecko: {len(df)} hourly points (interpolated OHLCV)")
            return df
        raise Exception(f"Only got {len(df)} points")
    except Exception as e:
        print(f"  CoinGecko failed: {e}")
        return None


def fetch_btc_candles(limit=400):
    """Waterfall: Kraken → CryptoCompare → Finnhub → CoinGecko"""
    for fetcher in [fetch_from_kraken, fetch_from_cryptocompare, fetch_from_finnhub, fetch_from_coingecko]:
        df = fetcher(limit)
        if df is not None:
            return df
    return None


def run_forecast(df):
    from model import Kronos, KronosTokenizer, KronosPredictor

    print("Loading Kronos model...")
    t0 = time.time()
    tokenizer = KronosTokenizer.from_pretrained("NeoQuasar/Kronos-Tokenizer-base")
    model = Kronos.from_pretrained("NeoQuasar/Kronos-small")
    predictor = KronosPredictor(model, tokenizer, device="cpu", max_context=512)
    print(f"Model loaded in {time.time()-t0:.1f}s")

    x_df = df[["open", "high", "low", "close", "volume"]].reset_index(drop=True)
    x_ts = pd.Series(df["timestamps"].values).reset_index(drop=True)

    last_ts = x_ts.iloc[-1]
    if hasattr(last_ts, 'tz') and last_ts.tz is not None:
        last_ts = last_ts.tz_localize(None)
    x_ts = x_ts.dt.tz_localize(None)
    y_ts = pd.Series(pd.date_range(start=last_ts + pd.Timedelta(hours=1), periods=PRED_LEN, freq="1h"))

    print(f"Running inference ({len(x_df)} candles -> {PRED_LEN}h, {SAMPLE_COUNT} paths)...")
    t1 = time.time()
    pred = predictor.predict(
        df=x_df, x_timestamp=x_ts, y_timestamp=y_ts,
        pred_len=PRED_LEN, T=1.0, top_p=0.9, sample_count=SAMPLE_COUNT
    )
    print(f"Inference complete in {time.time()-t1:.1f}s")
    return pred, y_ts


def format_forecast(pred, y_ts, current_price):
    now_est = datetime.now(timezone(timedelta(hours=-4)))
    pred_close = pred["close"].values
    pred_high = pred["high"].values
    pred_low = pred["low"].values

    forecast_data = {
        "generated_at": now_est.strftime("%Y-%m-%d %I:%M %p EDT"),
        "model": "Kronos-small",
        "symbol": "BTCUSDT",
        "current_price": current_price,
        "lookback_hours": LOOKBACK,
        "forecast_hours": PRED_LEN,
        "sample_paths": SAMPLE_COUNT,
        "predictions": [],
        "summary": {
            "price_in_24h": float(pred_close[-1]),
            "change_pct": float((pred_close[-1] - current_price) / current_price * 100),
            "predicted_high": float(max(pred_high)),
            "predicted_low": float(min(pred_low)),
            "direction": "BULLISH" if pred_close[-1] > current_price else "BEARISH",
            "range_pct": float((max(pred_high) - min(pred_low)) / current_price * 100),
        }
    }

    for i in range(len(pred_close)):
        forecast_data["predictions"].append({
            "hour": i + 1,
            "timestamp": y_ts[i].strftime("%Y-%m-%d %H:%M"),
            "open": float(pred["open"].values[i]),
            "high": float(pred_high[i]),
            "low": float(pred_low[i]),
            "close": float(pred_close[i]),
        })

    s = forecast_data["summary"]
    de = "🟢" if s["direction"] == "BULLISH" else "🔴"

    md = f"""# Kronos BTC Forecast
Generated: {forecast_data['generated_at']}
Model: {forecast_data['model']} | Paths: {SAMPLE_COUNT}

## Summary
- Current: **${current_price:,.2f}**
- 24H Forecast: **${s['price_in_24h']:,.2f}** ({s['change_pct']:+.2f}%)
- Direction: {de} **{s['direction']}**
- Predicted Range: ${s['predicted_low']:,.2f} — ${s['predicted_high']:,.2f} ({s['range_pct']:.1f}%)

## Hourly Predictions
| Hour | Time | Close | vs Now |
|------|------|-------|--------|
"""
    for p in forecast_data["predictions"]:
        chg = (p["close"] - current_price) / current_price * 100
        md += f"| {p['hour']}h | {p['timestamp'][-5:]} | ${p['close']:,.2f} | {chg:+.2f}% |\n"

    return forecast_data, md


def post_to_discord(forecast_data):
    if not os.path.exists(DISCORD_WEBHOOK_FILE):
        print("No Discord webhook. Skipping.")
        return
    webhook = open(DISCORD_WEBHOOK_FILE).read().strip()
    s = forecast_data["summary"]
    color = 0x00FF00 if s["direction"] == "BULLISH" else 0xFF0000
    de = "🟢" if s["direction"] == "BULLISH" else "🔴"
    embed = {
        "title": f"🔮 Kronos BTC Forecast — {forecast_data['generated_at']}",
        "color": color,
        "fields": [
            {"name": "Current Price", "value": f"${forecast_data['current_price']:,.2f}", "inline": True},
            {"name": "24H Forecast", "value": f"${s['price_in_24h']:,.2f}", "inline": True},
            {"name": "Change", "value": f"{s['change_pct']:+.2f}%", "inline": True},
            {"name": "Direction", "value": f"{de} {s['direction']}", "inline": True},
            {"name": "Predicted High", "value": f"${s['predicted_high']:,.2f}", "inline": True},
            {"name": "Predicted Low", "value": f"${s['predicted_low']:,.2f}", "inline": True},
            {"name": "Range", "value": f"{s['range_pct']:.1f}%", "inline": True},
            {"name": "Model", "value": f"Kronos-small ({SAMPLE_COUNT} paths)", "inline": True},
        ],
        "footer": {"text": "Kronos AI | Mission Control"}
    }
    try:
        r = requests.post(webhook, json={"embeds": [embed], "username": "🔮 Kronos"}, timeout=10)
        print(f"Discord: {r.status_code}")
    except Exception as e:
        print(f"Discord error: {e}")


def main():
    print("=" * 60)
    print("KRONOS BTC FORECAST SERVICE")
    print("=" * 60)

    df = fetch_btc_candles(LOOKBACK)
    if df is None or len(df) < 100:
        print("ERROR: Not enough data. All sources failed.")
        return

    current_price = float(df.iloc[-1]["close"])
    pred, y_ts = run_forecast(df)
    forecast_data, md = format_forecast(pred, y_ts, current_price)

    os.makedirs(OUTPUT_DIR, exist_ok=True)
    with open(FORECAST_JSON, "w") as f:
        json.dump(forecast_data, f, indent=2)
    with open(FORECAST_MD, "w") as f:
        f.write(md)

    print(f"\nSaved: {FORECAST_JSON}")
    print(f"Saved: {FORECAST_MD}")

    s = forecast_data["summary"]
    print(f"\n{'='*40}")
    print(f"BTC NOW:      ${current_price:,.2f}")
    print(f"24H FORECAST: ${s['price_in_24h']:,.2f} ({s['change_pct']:+.2f}%)")
    print(f"DIRECTION:    {s['direction']}")
    print(f"RANGE:        ${s['predicted_low']:,.2f} — ${s['predicted_high']:,.2f}")
    print(f"{'='*40}")

    post_to_discord(forecast_data)
    print("\nKronos forecast complete.")


if __name__ == "__main__":
    main()
