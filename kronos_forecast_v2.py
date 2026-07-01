#!/home/itsju/04_RESEARCH/Kronos/kronos-env/bin/python
"""
Kronos Multi-Asset Forecast Service v2 — Mission Control

Supports stocks, ETFs, indices (via Alpaca) + BTC (via Kraken).
CPU inference runs ~2-4 min per ticker. Designed to be called in the background
by boba_decision_cycle.py (fire-and-forget), not blocking.

Usage:
    kronos_forecast_v2.py --ticker NVDA
    kronos_forecast_v2.py --ticker BTC
    kronos_forecast_v2.py --ticker QQQ --option-context "648C 05/15/26"
"""
import argparse
import json
import os
import sys
import time
from datetime import datetime, timezone, timedelta
from pathlib import Path

import pandas as pd
import numpy as np
import requests

sys.path.insert(0, str(Path.home() / "scripts"))
from lib.http_retry import requests_session
_SESSION = requests_session()  # retries idempotent GETs; POST (below) left untouched

sys.path.insert(0, '/home/itsju/04_RESEARCH/Kronos')

# Tier config: tokenizer, max_context, sample_count, default candle lookback
KRONOS_TIERS = {
    "mini":  {"tokenizer": "NeoQuasar/Kronos-Tokenizer-2k",  "max_context": 2048, "sample_count": 1, "default_candles": 1024},
    "small": {"tokenizer": "NeoQuasar/Kronos-Tokenizer-base", "max_context": 512,  "sample_count": 3, "default_candles": 400},
    "base":  {"tokenizer": "NeoQuasar/Kronos-Tokenizer-base", "max_context": 512,  "sample_count": 3, "default_candles": 400},
}

PRED_LEN = 24
import os as _os_kronos
KRONOS_MODEL = _os_kronos.environ.get("KRONOS_MODEL", "mini")
OUTPUT_DIR = Path("/home/itsju/.openclaw/workspace/directives/kronos_forecasts")
FINETUNED_DIR = Path("/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h")
OUTPUT_DIR.mkdir(parents=True, exist_ok=True)
SECRETS = Path("/home/itsju/.openclaw/secrets")
DISCORD_WEBHOOK_FILE = SECRETS / "discord-webhook-kronos.txt"

# Crypto tickers route to Kraken. Everything else goes to Alpaca (stocks/ETFs/indices).
CRYPTO_TICKERS = {"BTC", "BTCUSD", "BTCUSDT", "XBTUSD"}
# Map ticker variants to canonical Kraken symbols
KRAKEN_MAP = {"BTC": "XBTUSD", "BTCUSD": "XBTUSD", "BTCUSDT": "XBTUSD", "XBTUSD": "XBTUSD"}


def is_crypto(ticker: str) -> bool:
    return ticker.upper() in CRYPTO_TICKERS


def fetch_stock_bars_alpaca(ticker: str, limit: int = 400) -> pd.DataFrame:
    """Fetch hourly OHLCV bars from Alpaca's free historical data API."""
    print(f"[data] Alpaca → {ticker} hourly bars, target {limit} candles")
    key = (SECRETS / "alpaca-key-id").read_text().strip() if (SECRETS / "alpaca-key-id").exists() else ""
    sec = (SECRETS / "alpaca-secret").read_text().strip() if (SECRETS / "alpaca-secret").exists() else ""
    if not key or not sec:
        raise RuntimeError("No Alpaca credentials")

    # 1h bars: 400 bars ≈ 16 trading days, 1024 bars ≈ 41 days
    # Fetch up to 180 calendar days to safely reach 1024 bars
    end = datetime.now(timezone.utc)
    days_back = max(90, int(limit * 0.18))  # ~0.18 calendar days per bar (including weekends/nights)
    start = end - timedelta(days=days_back)

    all_bars = []
    page_token = None
    while True:
        params = {
            "timeframe": "1Hour",
            "start": start.strftime("%Y-%m-%dT%H:%M:%SZ"),
            "end": end.strftime("%Y-%m-%dT%H:%M:%SZ"),
            "limit": 10000,
            "adjustment": "raw",
            "feed": "iex",
        }
        if page_token:
            params["page_token"] = page_token
        r = _SESSION.get(
            f"https://data.alpaca.markets/v2/stocks/{ticker}/bars",
            headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec},
            params=params, timeout=15,
        )
        if r.status_code != 200:
            raise RuntimeError(f"Alpaca {ticker} bars API {r.status_code}: {r.text[:200]}")
        data = r.json()
        all_bars.extend(data.get("bars") or [])
        page_token = data.get("next_page_token")
        if not page_token:
            break

    if len(all_bars) < 100:
        raise RuntimeError(f"Only got {len(all_bars)} bars for {ticker} — need 100+")

    rows = []
    for b in all_bars[-limit:]:
        rows.append({
            "timestamps": pd.Timestamp(b["t"]),
            "open": float(b["o"]),
            "high": float(b["h"]),
            "low": float(b["l"]),
            "close": float(b["c"]),
            "volume": float(b["v"]),
            "amount": float(b["vw"]) * float(b["v"]) if "vw" in b else float(b["c"]) * float(b["v"]),
        })
    df = pd.DataFrame(rows)
    print(f"[data] Got {len(df)} bars. Latest ${df.iloc[-1]['close']:,.2f}")
    return df


def fetch_btc_kraken(limit: int = 400) -> pd.DataFrame:
    """Kraken BTC hourly OHLCV — free, no key."""
    print(f"[data] Kraken → BTC hourly bars")
    r = _SESSION.get(
        "https://api.kraken.com/0/public/OHLC",
        params={"pair": "XBTUSD", "interval": 60, "since": 0},
        timeout=15,
    )
    r.raise_for_status()
    data = r.json()
    if data.get("error"):
        raise RuntimeError(f"Kraken error: {data['error']}")
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
            "amount": float(c[4]) * float(c[6]),
        })
    df = pd.DataFrame(rows).tail(limit).reset_index(drop=True)
    print(f"[data] Got {len(df)} bars. Latest ${df.iloc[-1]['close']:,.2f}")
    return df


def run_kronos_inference(df: pd.DataFrame, ticker: str, finetuned: bool = False) -> tuple:
    """Load model + run inference. Returns (pred_df, y_timestamps, current_price, sample_count)."""
    from model import Kronos, KronosTokenizer, KronosPredictor

    if finetuned:
        # Finetuned weights are based on Kronos-small — use small tier settings
        tier = KRONOS_TIERS["small"]
        tok_path = str(FINETUNED_DIR / "tokenizer" / "best_model")
        model_path = str(FINETUNED_DIR / "basemodel" / "best_model")
        label = f"Kronos-small (finetuned/us_stocks_1h)"
    else:
        tier = KRONOS_TIERS.get(KRONOS_MODEL, KRONOS_TIERS["mini"])
        tok_path = tier["tokenizer"]
        model_path = f"NeoQuasar/Kronos-{KRONOS_MODEL}"
        label = f"Kronos-{KRONOS_MODEL}"

    max_ctx = tier["max_context"]
    sample_count = tier["sample_count"]

    print(f"[kronos] Loading {label} (ctx={max_ctx}, samples={sample_count})...")
    t0 = time.time()
    tokenizer = KronosTokenizer.from_pretrained(tok_path)
    model = Kronos.from_pretrained(model_path)
    predictor = KronosPredictor(model, tokenizer, device="cpu", max_context=max_ctx)
    print(f"[kronos] Model loaded in {time.time()-t0:.1f}s")

    # Normalize timestamps to naive UTC
    df = df.copy()
    if df["timestamps"].dt.tz is not None:
        df["timestamps"] = df["timestamps"].dt.tz_convert("UTC").dt.tz_localize(None)
    else:
        df["timestamps"] = df["timestamps"]

    x_df = df[["open", "high", "low", "close", "volume", "amount"]].reset_index(drop=True)
    x_ts = df["timestamps"].reset_index(drop=True)

    last_ts = x_ts.iloc[-1]
    y_ts = pd.Series(pd.date_range(start=last_ts + pd.Timedelta(hours=1), periods=PRED_LEN, freq="1h"))

    print(f"[kronos] Running inference: {len(x_df)} candles → {PRED_LEN}h, {sample_count} path(s)")
    t1 = time.time()
    pred = predictor.predict(
        df=x_df, x_timestamp=x_ts, y_timestamp=y_ts,
        pred_len=PRED_LEN, T=1.0, top_p=0.9, sample_count=sample_count,
        verbose=False,
    )
    print(f"[kronos] Inference done in {time.time()-t1:.1f}s")
    current_price = float(df.iloc[-1]["close"])
    return pred, y_ts, current_price, sample_count, label


def build_forecast_json(ticker: str, pred: pd.DataFrame, y_ts, current_price: float,
                         candles_used: int, sample_count: int, model_label: str,
                         option_context: str = "") -> dict:
    pred_close = pred["close"].values
    final_price = float(pred_close[-1])
    change_pct = (final_price - current_price) / current_price * 100
    pred_high = float(max(pred["high"].values))
    pred_low = float(min(pred["low"].values))

    # Classify direction + confidence based on magnitude
    abs_move = abs(change_pct)
    if abs_move >= 2.0:
        confidence = "high"
    elif abs_move >= 0.8:
        confidence = "medium"
    else:
        confidence = "low"

    if change_pct > 0.3:
        direction = "bullish"
    elif change_pct < -0.3:
        direction = "bearish"
    else:
        direction = "neutral"

    forecast = {
        "ticker": ticker,
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "timeframe": "1h",
        "candles_analyzed": candles_used,
        "current_price": current_price,
        "forecast_24h_direction": direction,
        "forecast_24h_target": final_price,
        "forecast_24h_change_pct": round(change_pct, 2),
        "forecast_24h_confidence": confidence,
        "forecast_24h_high": pred_high,
        "forecast_24h_low": pred_low,
        "forecast_range_pct": round((pred_high - pred_low) / current_price * 100, 2),
        "model": model_label,
        "sample_paths": sample_count,
        "hourly_predictions": [
            {
                "hour": i + 1,
                "timestamp": y_ts[i].isoformat() if hasattr(y_ts[i], 'isoformat') else str(y_ts[i]),
                "close": float(pred["close"].values[i]),
                "high": float(pred["high"].values[i]),
                "low": float(pred["low"].values[i]),
            }
            for i in range(len(pred_close))
        ],
    }

    if option_context:
        forecast["option_context"] = option_context
        is_call = option_context.upper().split()[0].endswith("C") if option_context.split() else False
        is_put = option_context.upper().split()[0].endswith("P") if option_context.split() else False
        if is_call:
            forecast["option_in_forecast_direction"] = (direction == "bullish")
        elif is_put:
            forecast["option_in_forecast_direction"] = (direction == "bearish")

    return forecast


def post_to_discord(forecast: dict):
    if not DISCORD_WEBHOOK_FILE.exists():
        return False
    webhook = DISCORD_WEBHOOK_FILE.read_text().strip()
    direction = forecast["forecast_24h_direction"]
    color = {"bullish": 0x00FF00, "bearish": 0xFF4757, "neutral": 0x808080}.get(direction, 0x808080)
    arrow = {"bullish": "📈", "bearish": "📉", "neutral": "➡️"}.get(direction, "❓")

    title = f"{arrow} Kronos: {forecast['ticker']}"
    if forecast.get("option_context"):
        title += f" ({forecast['option_context']})"

    desc = [
        f"**Current:** ${forecast['current_price']:,.2f}",
        f"**24h target:** ${forecast['forecast_24h_target']:,.2f} ({forecast['forecast_24h_change_pct']:+.2f}%)",
        f"**Direction:** {direction.upper()} (confidence: {forecast['forecast_24h_confidence']})",
        f"**Predicted range:** ${forecast['forecast_24h_low']:,.2f} – ${forecast['forecast_24h_high']:,.2f}",
    ]
    if forecast.get("option_in_forecast_direction") is not None:
        match = "✅ agrees with option" if forecast["option_in_forecast_direction"] else "❌ conflicts with option"
        desc.append(f"**Option check:** {match}")

    payload = {
        "username": "Kronos",
        "embeds": [{
            "title": title,
            "description": "\n".join(desc),
            "color": color,
            "footer": {"text": f"{forecast['model']} • {forecast['candles_analyzed']} candles • {datetime.now(timezone.utc).strftime('%H:%M UTC')}"},
        }]
    }
    try:
        r = requests.post(webhook, json=payload, timeout=10)
        return r.status_code in (200, 204)
    except Exception as e:
        print(f"[discord] post failed: {e}", file=sys.stderr)
        return False


def main():
    p = argparse.ArgumentParser()
    p.add_argument("--ticker", required=True, help="e.g. NVDA, QQQ, BTC")
    p.add_argument("--model", default="mini", choices=["mini","small","base"], help="Kronos model variant")
    p.add_argument("--no-disk", action="store_true", help="Skip writing forecast JSON to disk; only print to stdout")
    p.add_argument("--option-context", default="", help="e.g. '648C 05/15/26'")
    p.add_argument("--candles", type=int, default=0, help="Override candle lookback (0 = use tier default)")
    p.add_argument("--finetuned", action="store_true", help="Use finetuned US-stocks weights from finetune_csv/finetuned/us_stocks_1h/")
    p.add_argument("--no-discord", action="store_true")
    args = p.parse_args()
    _os_kronos.environ["KRONOS_MODEL"] = args.model
    global KRONOS_MODEL; KRONOS_MODEL = args.model

    tier = KRONOS_TIERS["small"] if args.finetuned else KRONOS_TIERS.get(KRONOS_MODEL, KRONOS_TIERS["mini"])
    candles = args.candles if args.candles > 0 else tier["default_candles"]

    ticker = args.ticker.upper()
    ft_tag = " | finetuned=us_stocks_1h" if args.finetuned else ""
    print(f"{'='*60}\nKRONOS FORECAST: {ticker} | model={KRONOS_MODEL} | candles={candles}{ft_tag}\n{'='*60}")
    t_total = time.time()

    try:
        if is_crypto(ticker):
            df = fetch_btc_kraken(candles)
            canonical_ticker = "BTC"
        else:
            df = fetch_stock_bars_alpaca(ticker, candles)
            canonical_ticker = ticker
    except Exception as e:
        err = {"ticker": ticker, "error": f"data fetch failed: {e}",
               "generated_at": datetime.now(timezone.utc).isoformat()}
        print(json.dumps(err, indent=2))
        # Errors go to a sidecar file — never clobber the last good latest_<T>.json
        (OUTPUT_DIR / f"latest_{ticker}.error.json").write_text(json.dumps(err, indent=2))
        return 1

    try:
        pred, y_ts, current, sample_count, model_label = run_kronos_inference(df, canonical_ticker, finetuned=args.finetuned)
    except Exception as e:
        err = {"ticker": canonical_ticker, "error": f"kronos inference failed: {e}",
               "generated_at": datetime.now(timezone.utc).isoformat()}
        print(json.dumps(err, indent=2))
        # Errors go to a sidecar file — never clobber the last good latest_<T>.json
        (OUTPUT_DIR / f"latest_{canonical_ticker}.error.json").write_text(json.dumps(err, indent=2))
        return 1

    forecast = build_forecast_json(canonical_ticker, pred, y_ts, current, len(df), sample_count, model_label, args.option_context)

    # Save to both timestamped + latest files
    ts = datetime.now(timezone.utc).strftime("%Y%m%dT%H%M%S")
    (OUTPUT_DIR / f"{canonical_ticker}_{ts}.json").write_text(json.dumps(forecast, indent=2))
    (OUTPUT_DIR / f"latest_{canonical_ticker}.json").write_text(json.dumps(forecast, indent=2))

    if not args.no_discord:
        posted = post_to_discord(forecast)
        forecast["discord_posted"] = posted

    print(f"\n{'='*60}")
    print(f"TICKER:    {canonical_ticker}")
    print(f"NOW:       ${current:,.2f}")
    print(f"24H TGT:   ${forecast['forecast_24h_target']:,.2f} ({forecast['forecast_24h_change_pct']:+.2f}%)")
    print(f"DIRECTION: {forecast['forecast_24h_direction'].upper()} ({forecast['forecast_24h_confidence']} conf)")
    print(f"TOTAL:     {time.time()-t_total:.1f}s")
    print(f"{'='*60}")

    # Also print JSON for wrappers that parse stdout
    print(json.dumps(forecast, indent=2))
    return 0


if __name__ == "__main__":
    sys.exit(main())
