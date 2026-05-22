#!/usr/bin/env -S uv run --quiet --script
# /// script
# dependencies = ["yfinance"]
# ///
"""Standalone yfinance candle fetcher used by /api/stock/[ticker]/candles.

Usage: stock-candles.py TICKER PERIOD INTERVAL

Returns {points: [{t: unix_seconds, c: close_price}, ...]} matching the
Candles type in StockDetailDrawer.
"""
import json
import sys


def main() -> int:
    if len(sys.argv) < 4:
        print(json.dumps({"points": [], "err": "args: TICKER PERIOD INTERVAL"}))
        return 0
    ticker = sys.argv[1].upper()
    period = sys.argv[2]
    interval = sys.argv[3]
    try:
        import yfinance as yf

        t = yf.Ticker(ticker)
        h = t.history(period=period, interval=interval, auto_adjust=False, prepost=False)
        points = []
        for ts, row in h.iterrows():
            try:
                points.append({"t": int(ts.timestamp()), "c": float(row["Close"])})
            except Exception:
                pass
        print(json.dumps({"points": points}))
    except Exception as e:
        print(json.dumps({"points": [], "err": str(e)[:200]}))
    return 0


if __name__ == "__main__":
    sys.exit(main())
