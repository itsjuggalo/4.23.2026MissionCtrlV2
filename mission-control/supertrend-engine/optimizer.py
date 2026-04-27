#!/usr/bin/env python3
"""
SuperTrend Grid Optimizer — Test parameter combos, rank by performance
Zero LLM calls. Pure Python.

Usage:
    python3 optimizer.py                    # Default BTCUSD 1H
    python3 optimizer.py ETH USD 4H         # Custom symbol/timeframe
    python3 optimizer.py BTC USD 1H long    # Long-only mode
"""

import json
import os
import sys
import time
from datetime import datetime, timezone

from data_fetcher import fetch_extended, save_cache, load_cache
from backtester import backtest, backtest_long_only

# Output dirs
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
RESULTS_DIR = os.path.join(BASE_DIR, "results")
WORKSPACE_DIR = os.path.expanduser("~/.openclaw/workspace/directives")
os.makedirs(RESULTS_DIR, exist_ok=True)
os.makedirs(WORKSPACE_DIR, exist_ok=True)


# Parameter grid
ATR_PERIODS = [7, 8, 9, 10, 11, 12, 14, 16, 20]
MULTIPLIERS = [1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0]


def run_optimization(symbol: str = "BTC", currency: str = "USD",
                     timeframe: str = "1H", total_candles: int = 5000,
                     mode: str = "both", fee_pct: float = 0.1) -> dict:
    """
    Run full parameter grid optimization.

    mode: 'both' (long+short), 'long' (long-only), 'all' (run both modes)
    """
    print(f"\n{'='*60}")
    print(f"SuperTrend Grid Optimizer")
    print(f"{'='*60}")
    print(f"Symbol:     {symbol}/{currency}")
    print(f"Timeframe:  {timeframe}")
    print(f"Candles:    {total_candles}")
    print(f"Mode:       {mode}")
    print(f"Fee:        {fee_pct}%")
    print(f"Grid size:  {len(ATR_PERIODS)} × {len(MULTIPLIERS)} = {len(ATR_PERIODS) * len(MULTIPLIERS)} combos")
    print(f"{'='*60}\n")

    # Fetch data (use cache if available)
    candles = load_cache(symbol, timeframe)
    if not candles or len(candles) < total_candles * 0.8:
        print(f"Fetching {total_candles} candles from CryptoCompare...")
        candles = fetch_extended(symbol, currency, timeframe, total_candles)
        if candles:
            save_cache(candles, symbol, timeframe)
    
    if not candles:
        print("ERROR: No data fetched. Check API key.")
        return {}

    print(f"Data range: {candles[0]['datetime']} → {candles[-1]['datetime']}")
    print(f"Total candles: {len(candles)}")
    print(f"\nRunning backtests...\n")

    results = []
    total = len(ATR_PERIODS) * len(MULTIPLIERS)
    count = 0

    for atr_p in ATR_PERIODS:
        for mult in MULTIPLIERS:
            count += 1

            if mode in ("both", "all"):
                res = backtest(candles, atr_period=atr_p, multiplier=mult, fee_pct=fee_pct)
                res_clean = {k: v for k, v in res.items() if k != "trades"}
                res_clean["mode"] = "long+short"
                results.append(res_clean)

            if mode in ("long", "all"):
                res_long = backtest_long_only(candles, atr_period=atr_p, multiplier=mult, fee_pct=fee_pct)
                res_long_clean = {k: v for k, v in res_long.items() if k != "trades"}
                res_long_clean["mode"] = "long-only"
                results.append(res_long_clean)

            if count % 10 == 0:
                print(f"  [{count}/{total}] ATR={atr_p} Mult={mult}")

    print(f"\n  [{total}/{total}] Complete!\n")

    # Sort by total return
    results.sort(key=lambda x: x.get("total_return_pct", 0), reverse=True)

    # Print top 10
    print(f"{'='*60}")
    print(f"TOP 10 PARAMETER COMBINATIONS")
    print(f"{'='*60}")
    print(f"{'Rank':<5} {'ATR':<5} {'Mult':<6} {'Mode':<12} {'Return%':<10} {'WinRate':<9} {'PF':<6} {'MaxDD%':<8} {'Trades':<7} {'Sharpe':<7}")
    print("-" * 80)

    for i, r in enumerate(results[:10]):
        print(f"{i+1:<5} {r['atr_period']:<5} {r['multiplier']:<6} {r.get('mode',''):<12} "
              f"{r.get('total_return_pct',0):<10} {r.get('win_rate',0):<9} "
              f"{r.get('profit_factor',0):<6} {r.get('max_drawdown_pct',0):<8} "
              f"{r.get('total_trades',0):<7} {r.get('sharpe_approx',0):<7}")

    # Print worst 5 too
    print(f"\n{'='*60}")
    print(f"WORST 5 (avoid these)")
    print(f"{'='*60}")
    for i, r in enumerate(results[-5:]):
        print(f"  ATR={r['atr_period']} Mult={r['multiplier']} Mode={r.get('mode','')} "
              f"Return={r.get('total_return_pct',0)}% DD={r.get('max_drawdown_pct',0)}%")

    # Save results
    output = {
        "run_time": datetime.now(timezone.utc).isoformat(),
        "symbol": f"{symbol}/{currency}",
        "timeframe": timeframe,
        "candles": len(candles),
        "data_range": f"{candles[0]['datetime']} → {candles[-1]['datetime']}",
        "fee_pct": fee_pct,
        "grid": {"atr_periods": ATR_PERIODS, "multipliers": MULTIPLIERS},
        "top_10": results[:10],
        "all_results": results,
        "best": results[0] if results else None,
    }

    # Save to results dir
    results_file = os.path.join(RESULTS_DIR, f"optimization_{symbol}_{timeframe}_{int(time.time())}.json")
    with open(results_file, "w") as f:
        json.dump(output, f, indent=2)
    print(f"\nFull results saved: {results_file}")

    # Save best config for agents to read
    best = results[0] if results else {}
    agent_config = {
        "updated": datetime.now(timezone.utc).isoformat(),
        "symbol": f"{symbol}/{currency}",
        "timeframe": timeframe,
        "recommended_atr_period": best.get("atr_period"),
        "recommended_multiplier": best.get("multiplier"),
        "expected_win_rate": best.get("win_rate"),
        "expected_profit_factor": best.get("profit_factor"),
        "backtest_return_pct": best.get("total_return_pct"),
        "max_drawdown_pct": best.get("max_drawdown_pct"),
        "mode": best.get("mode"),
        "data_range": output["data_range"],
        "top_3": results[:3],
    }

    config_file = os.path.join(WORKSPACE_DIR, f"supertrend_config_{symbol}_{timeframe}.json")
    with open(config_file, "w") as f:
        json.dump(agent_config, f, indent=2)
    print(f"Agent config saved: {config_file}")

    # Also save latest to signal-receiver data dir
    sr_config = os.path.expanduser("~/mission-control/signal-receiver/data/optimal_params.json")
    try:
        with open(sr_config, "w") as f:
            json.dump(agent_config, f, indent=2)
        print(f"Signal receiver config: {sr_config}")
    except Exception:
        pass

    return output


if __name__ == "__main__":
    # Parse args
    symbol = sys.argv[1] if len(sys.argv) > 1 else "BTC"
    currency = sys.argv[2] if len(sys.argv) > 2 else "USD"
    timeframe = sys.argv[3] if len(sys.argv) > 3 else "1H"
    mode = sys.argv[4] if len(sys.argv) > 4 else "all"

    run_optimization(symbol, currency, timeframe, total_candles=5000, mode=mode)
