"""Populate the OHLCV cache for the given tickers (run with system python, has yfinance)."""
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

from ta_engine import data

for t in sys.argv[1:] or ["AAPL", "QCOM", "TSLA", "SPY", "NVDA"]:
    try:
        b = data.fetch_ohlcv(t, use_cache=False)
        print(f"{t}: cached {len(b['close'])} bars (last {b['close'][-1]:.2f} @ {b['dates'][-1]})")
    except Exception as e:
        print(f"{t}: FAILED {e}")
