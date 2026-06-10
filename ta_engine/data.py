"""OHLCV fetch with a small on-disk TTL cache (limits yfinance rate-limit exposure).

Daily bars by default. Returns plain numpy arrays so the cache is portable across
the laptop (pandas 3.x) and Oracle (pandas 2.x) — we never pickle a DataFrame.
"""
import os
import time
import warnings

import numpy as np

warnings.filterwarnings("ignore")

CACHE_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), ".cache")
TTL_SECONDS = 600  # 10 min


def _cache_path(ticker, period, interval):
    safe = f"{ticker.upper()}_{period}_{interval}".replace("/", "_").replace("\\", "_")
    return os.path.join(CACHE_DIR, safe + ".npz")


def fetch_ohlcv(ticker, period="1y", interval="1d", use_cache=True):
    """Fetch OHLCV for `ticker`. Returns dict of numpy arrays:
    open/high/low/close/volume (float) + dates (ISO 'YYYY-MM-DD' strings).
    Raises ValueError if no data.
    """
    os.makedirs(CACHE_DIR, exist_ok=True)
    cp = _cache_path(ticker, period, interval)
    if use_cache and os.path.exists(cp) and (time.time() - os.path.getmtime(cp)) < TTL_SECONDS:
        try:
            d = np.load(cp, allow_pickle=True)
            return {k: d[k] for k in d.files}
        except Exception:
            pass  # corrupt cache → refetch

    import yfinance as yf  # lazy: only needed on a cache miss

    hist = yf.Ticker(ticker.upper()).history(period=period, interval=interval)
    if hist is None or hist.empty:
        raise ValueError(f"no OHLCV for {ticker} (period={period}, interval={interval})")

    out = {
        "open": hist["Open"].to_numpy(dtype=float),
        "high": hist["High"].to_numpy(dtype=float),
        "low": hist["Low"].to_numpy(dtype=float),
        "close": hist["Close"].to_numpy(dtype=float),
        "volume": hist["Volume"].to_numpy(dtype=float),
        "dates": np.array([str(x)[:10] for x in hist.index], dtype=object),
    }
    try:
        np.savez(cp, **out)
    except Exception:
        pass
    return out


if __name__ == "__main__":
    import sys

    sym = sys.argv[1] if len(sys.argv) > 1 else "AAPL"
    bars = fetch_ohlcv(sym)
    print(f"{sym}: {len(bars['close'])} bars, last close {bars['close'][-1]:.2f} on {bars['dates'][-1]}")
