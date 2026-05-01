#!/usr/bin/env python3
"""
Backtest runner CLI — wraps supertrend-engine for /backtest Discord command.

Usage: python3 run.py <symbol> <timeframe> <months> [strategy]

Outputs JSON to stdout with backtest results.
Exit 0 = success with stats, exit 1 = error (msg in stderr-stream stdout).
"""
import sys, os, json, traceback

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

# Timeframes data_fetcher actually accepts
VALID_TFS = ["1m", "5m", "15m", "30m", "1H", "2H", "4H", "1D"]
# Map common variants Mike might type → real timeframe
TF_NORMALIZE = {
    "5M": "5m", "15M": "15m", "30M": "30m",
    "1HR": "1H", "1HOUR": "1H",
    "4HR": "4H", "4HOUR": "4H",
    "DAILY": "1D", "1DAY": "1D",
}
# Bars per day for each timeframe (for sizing the fetch limit)
BARS_PER_DAY = {
    "1m": 1440, "5m": 288, "15m": 96, "30m": 48,
    "1H": 24, "2H": 12, "4H": 6, "1D": 1,
}

def main():
    if len(sys.argv) < 4:
        print(json.dumps({
            "error": "usage: run.py <symbol> <timeframe> <months> [strategy]",
            "examples": ["run.py BTC 1H 6", "run.py ETH 4H 12", "run.py BTC 1D 24"],
            "valid_timeframes": VALID_TFS,
        }))
        sys.exit(1)

    symbol = sys.argv[1].upper()
    tf_raw = sys.argv[2]
    months = int(sys.argv[3])
    strategy = sys.argv[4] if len(sys.argv) > 4 else "supertrend"

    # Normalize timeframe
    timeframe = TF_NORMALIZE.get(tf_raw.upper(), tf_raw)
    if timeframe not in VALID_TFS:
        print(json.dumps({
            "error": f"timeframe '{tf_raw}' not valid. Use one of {VALID_TFS}",
        }))
        sys.exit(1)

    if strategy != "supertrend":
        print(json.dumps({"error": f"strategy '{strategy}' not in registry. Available: supertrend"}))
        sys.exit(1)

    try:
        from data_fetcher import fetch_ohlcv
        from backtester import backtest

        # Compute fetch limit (CryptoCompare caps at 2000 per call)
        target_bars = BARS_PER_DAY[timeframe] * 30 * months
        target_bars = min(target_bars, 2000)

        candles = fetch_ohlcv(symbol=symbol, currency="USD",
                              timeframe=timeframe, limit=target_bars)
        if not candles or len(candles) < 50:
            print(json.dumps({"error": f"insufficient candles: {len(candles) if candles else 0}"}))
            sys.exit(1)

        # Normalize candle keys — fetch_ohlcv may use 'time' instead of 'datetime'
        for c in candles:
            if "datetime" not in c and "time" in c:
                c["datetime"] = c["time"]
            elif "datetime" not in c and "timestamp" in c:
                c["datetime"] = c["timestamp"]

        # Run backtest
        result = backtest(candles, atr_period=10, multiplier=3.0,
                          fee_pct=0.1, initial_capital=100000.0)

        # Buy-hold comparison
        first_price = candles[0]["close"]
        last_price = candles[-1]["close"]
        bh_pct = ((last_price - first_price) / first_price) * 100

        # Pull stats — match whatever keys backtester actually returns
        win_rate = result.get("win_rate_pct", result.get("win_rate", 0))
        max_dd = result.get("max_drawdown_pct", result.get("max_drawdown", 100))
        total_return = result.get("total_return_pct", result.get("total_pnl_pct", -100))
        total_trades = result.get("total_trades", len(result.get("trades", [])))
        pf = result.get("profit_factor", 0)

        beats_bh = total_return > bh_pct
        gate_pass = (win_rate >= 40) and (abs(max_dd) <= 25) and beats_bh

        print(json.dumps({
            "symbol": symbol,
            "timeframe": timeframe,
            "strategy": strategy,
            "months": months,
            "candles_used": len(candles),
            "first_close": round(first_price, 2),
            "last_close": round(last_price, 2),
            "buy_hold_pct": round(bh_pct, 2),
            "strategy_return_pct": round(total_return, 2),
            "win_rate_pct": round(win_rate, 2),
            "max_drawdown_pct": round(max_dd, 2),
            "total_trades": total_trades,
            "profit_factor": round(pf, 3),
            "beats_buy_hold": beats_bh,
            "gate_pass": gate_pass,
            "_raw_result_keys": list(result.keys()),
        }, indent=2))
        sys.exit(0)

    except Exception as e:
        print(json.dumps({
            "error": f"{type(e).__name__}: {e}",
            "traceback": traceback.format_exc(),
        }))
        sys.exit(1)

if __name__ == "__main__":
    main()
