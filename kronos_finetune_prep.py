#!/home/itsju/02_DATA/mc-kb/.venv/bin/python
"""
Kronos Fine-tune Data Prep — pulls Alpaca 1h historical bars for US stock tickers
and saves them in the CSV format required by finetune_csv/train_sequential.py.

Crypto tickers (BTCUSD, BTC) are fetched from Alpaca's crypto endpoint.

Output: ~/04_RESEARCH/Kronos/finetune_csv/data/us_stocks_1h_<TICKER>.csv
        ~/04_RESEARCH/Kronos/finetune_csv/data/us_stocks_1h_all.csv  (combined)

Usage:
    python3 kronos_finetune_prep.py
    python3 kronos_finetune_prep.py --tickers NVDA TSLA SPY QQQ AAPL BTCUSD
    python3 kronos_finetune_prep.py --days 365
"""
import argparse
from datetime import datetime, timezone, timedelta
from pathlib import Path
import requests
import pandas as pd

SECRETS = Path("/home/itsju/.openclaw/secrets")
OUTPUT_DIR = Path("/home/itsju/04_RESEARCH/Kronos/finetune_csv/data")
OUTPUT_DIR.mkdir(parents=True, exist_ok=True)

DEFAULT_TICKERS = ["NVDA", "TSLA", "SPY", "QQQ", "AAPL", "MSFT", "AMD", "SMCI", "META", "MU", "AMZN", "GOOGL", "COIN", "BTCUSD"]
DEFAULT_DAYS = 730  # 2 years of hourly data

CRYPTO_TICKERS = {"BTCUSD", "BTC", "ETHUSD", "ETH"}
ALPACA_CRYPTO_SYMBOL = {"BTCUSD": "BTC/USD", "BTC": "BTC/USD", "ETHUSD": "ETH/USD", "ETH": "ETH/USD"}


def get_alpaca_creds():
    key = (SECRETS / "alpaca-boba-key-id").read_text().strip()
    sec = (SECRETS / "alpaca-boba-secret").read_text().strip()
    return key, sec


def _parse_bars(all_bars: list) -> pd.DataFrame:
    rows = []
    for b in all_bars:
        rows.append({
            "timestamps": pd.Timestamp(b["t"]),
            "open": float(b["o"]),
            "high": float(b["h"]),
            "low": float(b["l"]),
            "close": float(b["c"]),
            "volume": float(b["v"]),
            "amount": float(b.get("vw", b["c"])) * float(b["v"]),
        })
    df = pd.DataFrame(rows)
    print(f"    Got {len(df)} bars. Range: {df['timestamps'].min()} → {df['timestamps'].max()}")
    return df


def fetch_crypto_bars(ticker: str, days: int, key: str, sec: str) -> pd.DataFrame:
    symbol = ALPACA_CRYPTO_SYMBOL[ticker.upper()]
    print(f"  Fetching {ticker} crypto ({days}d hourly via Alpaca)...")
    end = datetime.now(timezone.utc)
    start = end - timedelta(days=days)
    headers = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
    all_bars = []
    page_token = None
    while True:
        params = {
            "symbols": symbol, "timeframe": "1Hour",
            "start": start.strftime("%Y-%m-%dT%H:%M:%SZ"),
            "end": end.strftime("%Y-%m-%dT%H:%M:%SZ"), "limit": 10000,
        }
        if page_token:
            params["page_token"] = page_token
        r = requests.get("https://data.alpaca.markets/v1beta3/crypto/us/bars",
                         headers=headers, params=params, timeout=20)
        r.raise_for_status()
        data = r.json()
        all_bars.extend((data.get("bars") or {}).get(symbol, []))
        page_token = data.get("next_page_token")
        if not page_token:
            break
    return _parse_bars(all_bars)


def fetch_bars(ticker: str, days: int, key: str, sec: str) -> pd.DataFrame:
    print(f"  Fetching {ticker} ({days}d hourly)...")
    end = datetime.now(timezone.utc)
    start = end - timedelta(days=days)
    headers = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
    all_bars = []
    page_token = None
    while True:
        params = {
            "timeframe": "1Hour", "start": start.strftime("%Y-%m-%dT%H:%M:%SZ"),
            "end": end.strftime("%Y-%m-%dT%H:%M:%SZ"), "limit": 10000,
            "adjustment": "raw", "feed": "iex",
        }
        if page_token:
            params["page_token"] = page_token
        r = requests.get(f"https://data.alpaca.markets/v2/stocks/{ticker}/bars",
                         headers=headers, params=params, timeout=20)
        r.raise_for_status()
        data = r.json()
        all_bars.extend(data.get("bars") or [])
        page_token = data.get("next_page_token")
        if not page_token:
            break
    return _parse_bars(all_bars)


def main():
    p = argparse.ArgumentParser()
    p.add_argument("--tickers", nargs="+", default=DEFAULT_TICKERS)
    p.add_argument("--days", type=int, default=DEFAULT_DAYS)
    args = p.parse_args()

    key, sec = get_alpaca_creds()
    all_dfs = []

    for ticker in args.tickers:
        try:
            if ticker.upper() in CRYPTO_TICKERS:
                df = fetch_crypto_bars(ticker.upper(), args.days, key, sec)
            else:
                df = fetch_bars(ticker, args.days, key, sec)
            if len(df) < 200:
                print(f"  SKIP {ticker} — only {len(df)} bars")
                continue
            out = OUTPUT_DIR / f"us_stocks_1h_{ticker}.csv"
            df.to_csv(out, index=False)
            print(f"  Saved → {out}")
            all_dfs.append(df)
        except Exception as e:
            print(f"  ERROR {ticker}: {e}")

    if all_dfs:
        combined = pd.concat(all_dfs, ignore_index=True).sort_values("timestamps")
        combined_out = OUTPUT_DIR / "us_stocks_1h_all.csv"
        combined.to_csv(combined_out, index=False)
        print(f"\nCombined dataset: {len(combined)} rows → {combined_out}")
        print("\nNext steps:")
        print("  1. Edit ~/04_RESEARCH/Kronos/finetune_csv/configs/config_us_stocks_1h.yaml")
        print("  2. cd ~/04_RESEARCH/Kronos/finetune_csv")
        print("  3. ~/02_DATA/mc-kb/.venv/bin/python train_sequential.py --config configs/config_us_stocks_1h.yaml")
    else:
        print("No data fetched.")


if __name__ == "__main__":
    main()
