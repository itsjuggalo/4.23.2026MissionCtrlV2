"""Cross-check pure-numpy indicators against TA-Lib on real cached data.

Run AFTER populating the cache with system python:
    python3 -m ta_engine.tests.populate AAPL QCOM TSLA SPY NVDA
Then validate in the freqtrade venv (has TA-Lib):
    ~/web/missionctrl/freqtrade/.venv/bin/python -m ta_engine.tests.validate_vs_talib
"""
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

import numpy as np
import talib

from ta_engine import data, indicators as ind

TICKERS = sys.argv[1:] or ["AAPL", "QCOM", "TSLA", "SPY", "NVDA"]
TOL = {"rsi": 0.05, "ema20": 0.02, "ema50": 0.05, "macd_line": 0.02, "bb_upper": 0.05, "atr": 0.05}


def _last_finite(a):
    a = a[np.isfinite(a)]
    return float(a[-1]) if len(a) else float("nan")


def check(name, mine, theirs, tol):
    diff = abs(mine - theirs)
    ok = diff <= tol
    print(f"    {name:10s} mine={mine:12.4f}  talib={theirs:12.4f}  d={diff:.5f}  {'OK' if ok else 'FAIL'}")
    return ok


def main():
    all_ok = True
    for t in TICKERS:
        try:
            b = data.fetch_ohlcv(t)  # cache hit (yfinance not needed)
        except Exception as e:
            print(f"{t}: fetch failed ({e}) — populate cache first"); all_ok = False; continue
        c, h, l = b["close"], b["high"], b["low"]
        print(f"{t} ({len(c)} bars):")

        mine_rsi = ind.rsi(c, 14)
        their_rsi = _last_finite(talib.RSI(c, timeperiod=14))
        all_ok &= check("RSI14", mine_rsi, their_rsi, TOL["rsi"])

        all_ok &= check("EMA20", ind.ema(c, 20), _last_finite(talib.EMA(c, timeperiod=20)), TOL["ema20"])
        all_ok &= check("EMA50", ind.ema(c, 50), _last_finite(talib.EMA(c, timeperiod=50)), TOL["ema50"])

        m = ind.macd(c)
        tm, _, _ = talib.MACD(c, fastperiod=12, slowperiod=26, signalperiod=9)
        all_ok &= check("MACD.line", m["line"], _last_finite(tm), TOL["macd_line"])

        bb = ind.bollinger(c)
        tu, _, _ = talib.BBANDS(c, timeperiod=20, nbdevup=2, nbdevdn=2, matype=0)
        all_ok &= check("BB.upper", bb["upper"], _last_finite(tu), TOL["bb_upper"])

        all_ok &= check("ATR14", ind.atr(h, l, c, 14), _last_finite(talib.ATR(h, l, c, timeperiod=14)), TOL["atr"])
        print()

    print("=" * 50)
    print("ALL PASS" if all_ok else "SOME FAILED")
    sys.exit(0 if all_ok else 1)


if __name__ == "__main__":
    main()
