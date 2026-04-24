#!/usr/bin/env python3
"""
supertrend_optimizer.py — Backtest SuperTrend across ATR/Multiplier combos
Fetches real BTC candle data from OKX and finds optimal parameters.

Usage:
  python3 supertrend_optimizer.py --timeframe 1H
  python3 supertrend_optimizer.py --timeframe 30m
  python3 supertrend_optimizer.py --timeframe 1H --mode long-short
  python3 supertrend_optimizer.py --timeframe 30m --top 10
"""

import json
import os
import sys
import time
import requests
import argparse
from datetime import datetime, timezone, timedelta

OUTPUT_DIR = "/home/ubuntu/mission-control/signal-receiver/data"


def fetch_candles(timeframe="1H", limit=500):
    """Fetch historical BTC candles from OKX. Max 300 per request, paginate for more."""
    all_candles = []
    after = ""
    
    bar_map = {"30m": "30m", "1H": "1H", "4H": "4H", "1D": "1D"}
    bar = bar_map.get(timeframe, "1H")
    
    # Fetch in batches
    batches_needed = (limit // 300) + 1
    
    for i in range(batches_needed):
        params = {"instId": "BTC-USDT", "bar": bar, "limit": "300"}
        if after:
            params["after"] = after
        
        try:
            r = requests.get("https://www.okx.com/api/v5/market/candles", params=params, timeout=15)
            data = r.json().get("data", [])
            if not data:
                break
            
            for c in data:
                all_candles.append({
                    "ts": int(c[0]),
                    "open": float(c[1]),
                    "high": float(c[2]),
                    "low": float(c[3]),
                    "close": float(c[4]),
                    "volume": float(c[5]),
                })
            
            after = data[-1][0]  # Last timestamp for pagination
            
            if len(data) < 300:
                break
            
            time.sleep(0.3)  # Rate limit
            
        except Exception as e:
            print(f"  Fetch error: {e}")
            break
    
    # Sort oldest first
    all_candles.sort(key=lambda x: x["ts"])
    
    if len(all_candles) > limit:
        all_candles = all_candles[-limit:]
    
    return all_candles


def calc_atr(candles, period):
    """Calculate Average True Range."""
    atrs = [0.0] * len(candles)
    
    for i in range(1, len(candles)):
        high = candles[i]["high"]
        low = candles[i]["low"]
        prev_close = candles[i-1]["close"]
        
        tr = max(high - low, abs(high - prev_close), abs(low - prev_close))
        
        if i < period:
            atrs[i] = tr
        elif i == period:
            # Initial ATR = average of first `period` TRs
            total = tr
            for j in range(1, period):
                h = candles[j]["high"]
                l = candles[j]["low"]
                pc = candles[j-1]["close"]
                total += max(h - l, abs(h - pc), abs(l - pc))
            atrs[i] = total / period
        else:
            atrs[i] = (atrs[i-1] * (period - 1) + tr) / period
    
    return atrs


def supertrend(candles, atr_period, multiplier):
    """Calculate SuperTrend indicator. Returns list of (trend, value) tuples.
    trend: 1 = bullish (price above), -1 = bearish (price below)
    """
    atrs = calc_atr(candles, atr_period)
    n = len(candles)
    
    upper_band = [0.0] * n
    lower_band = [0.0] * n
    supertrend_val = [0.0] * n
    direction = [0] * n  # 1=up, -1=down
    
    for i in range(atr_period, n):
        hl2 = (candles[i]["high"] + candles[i]["low"]) / 2
        atr = atrs[i]
        
        basic_upper = hl2 + multiplier * atr
        basic_lower = hl2 - multiplier * atr
        
        # Upper band
        if i == atr_period:
            upper_band[i] = basic_upper
        else:
            if basic_upper < upper_band[i-1] or candles[i-1]["close"] > upper_band[i-1]:
                upper_band[i] = basic_upper
            else:
                upper_band[i] = upper_band[i-1]
        
        # Lower band
        if i == atr_period:
            lower_band[i] = basic_lower
        else:
            if basic_lower > lower_band[i-1] or candles[i-1]["close"] < lower_band[i-1]:
                lower_band[i] = basic_lower
            else:
                lower_band[i] = lower_band[i-1]
        
        # Direction
        if i == atr_period:
            direction[i] = 1 if candles[i]["close"] > upper_band[i] else -1
        else:
            if direction[i-1] == 1:
                if candles[i]["close"] < lower_band[i]:
                    direction[i] = -1
                    supertrend_val[i] = upper_band[i]
                else:
                    direction[i] = 1
                    supertrend_val[i] = lower_band[i]
            else:
                if candles[i]["close"] > upper_band[i]:
                    direction[i] = 1
                    supertrend_val[i] = lower_band[i]
                else:
                    direction[i] = -1
                    supertrend_val[i] = upper_band[i]
    
    return direction, supertrend_val


def backtest(candles, atr_period, multiplier, mode="long-only"):
    """
    Backtest SuperTrend strategy.
    mode: 'long-only' = only take long trades
          'long-short' = take both long and short trades
    """
    direction, st_val = supertrend(candles, atr_period, multiplier)
    
    trades = []
    position = None  # {"side": "long"/"short", "entry": price, "entry_idx": i}
    
    start_idx = atr_period + 1
    
    for i in range(start_idx, len(candles)):
        prev_dir = direction[i-1]
        curr_dir = direction[i]
        close = candles[i]["close"]
        
        if prev_dir != curr_dir and prev_dir != 0:
            # Signal flip
            
            # Close existing position
            if position:
                exit_price = close
                if position["side"] == "long":
                    pnl_pct = (exit_price - position["entry"]) / position["entry"] * 100
                else:
                    pnl_pct = (position["entry"] - exit_price) / position["entry"] * 100
                
                trades.append({
                    "side": position["side"],
                    "entry": position["entry"],
                    "exit": exit_price,
                    "pnl_pct": pnl_pct,
                    "bars_held": i - position["entry_idx"],
                    "entry_time": datetime.fromtimestamp(candles[position["entry_idx"]]["ts"]/1000, tz=timezone.utc).isoformat(),
                    "exit_time": datetime.fromtimestamp(candles[i]["ts"]/1000, tz=timezone.utc).isoformat(),
                })
                position = None
            
            # Open new position
            if curr_dir == 1:
                # Bullish flip → go long
                position = {"side": "long", "entry": close, "entry_idx": i}
            elif curr_dir == -1 and mode == "long-short":
                # Bearish flip → go short (only in long-short mode)
                position = {"side": "short", "entry": close, "entry_idx": i}
    
    # Close any open position at end
    if position:
        exit_price = candles[-1]["close"]
        if position["side"] == "long":
            pnl_pct = (exit_price - position["entry"]) / position["entry"] * 100
        else:
            pnl_pct = (position["entry"] - exit_price) / position["entry"] * 100
        
        trades.append({
            "side": position["side"],
            "entry": position["entry"],
            "exit": exit_price,
            "pnl_pct": pnl_pct,
            "bars_held": len(candles) - 1 - position["entry_idx"],
            "entry_time": datetime.fromtimestamp(candles[position["entry_idx"]]["ts"]/1000, tz=timezone.utc).isoformat(),
            "exit_time": "OPEN",
        })
    
    return trades


def calc_stats(trades):
    """Calculate performance statistics from trades."""
    if not trades:
        return None
    
    n = len(trades)
    wins = [t for t in trades if t["pnl_pct"] > 0]
    losses = [t for t in trades if t["pnl_pct"] <= 0]
    
    win_rate = len(wins) / n * 100 if n else 0
    
    total_wins = sum(t["pnl_pct"] for t in wins)
    total_losses = abs(sum(t["pnl_pct"] for t in losses))
    profit_factor = total_wins / total_losses if total_losses > 0 else 999
    
    # Compounded return
    equity = 100
    peak = 100
    max_dd = 0
    equity_curve = [100]
    
    for t in trades:
        equity *= (1 + t["pnl_pct"] / 100)
        equity_curve.append(equity)
        if equity > peak:
            peak = equity
        dd = (peak - equity) / peak * 100
        if dd > max_dd:
            max_dd = dd
    
    total_return = equity - 100
    
    avg_trade = sum(t["pnl_pct"] for t in trades) / n
    avg_win = sum(t["pnl_pct"] for t in wins) / len(wins) if wins else 0
    avg_loss = sum(t["pnl_pct"] for t in losses) / len(losses) if losses else 0
    avg_bars = sum(t["bars_held"] for t in trades) / n
    
    # Sharpe approximation
    import statistics
    if n > 1:
        returns = [t["pnl_pct"] for t in trades]
        sharpe = statistics.mean(returns) / statistics.stdev(returns) if statistics.stdev(returns) > 0 else 0
    else:
        sharpe = 0
    
    # Consecutive losses
    max_consec_loss = 0
    consec = 0
    for t in trades:
        if t["pnl_pct"] <= 0:
            consec += 1
            max_consec_loss = max(max_consec_loss, consec)
        else:
            consec = 0
    
    return {
        "total_trades": n,
        "win_rate": round(win_rate, 1),
        "profit_factor": round(profit_factor, 2),
        "total_return_pct": round(total_return, 2),
        "max_drawdown_pct": round(max_dd, 2),
        "avg_trade_pct": round(avg_trade, 4),
        "avg_win_pct": round(avg_win, 4),
        "avg_loss_pct": round(avg_loss, 4),
        "avg_bars_held": round(avg_bars, 1),
        "sharpe_approx": round(sharpe, 3),
        "max_consecutive_losses": max_consec_loss,
        "best_trade_pct": round(max(t["pnl_pct"] for t in trades), 2),
        "worst_trade_pct": round(min(t["pnl_pct"] for t in trades), 2),
    }


def run_optimization(candles, mode, top_n=10):
    """Run SuperTrend optimization across parameter grid."""
    
    # Parameter grid
    atr_periods = [7, 8, 9, 10, 11, 12, 14, 16, 18, 20]
    multipliers = [1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0]
    
    results = []
    total = len(atr_periods) * len(multipliers)
    count = 0
    
    for atr in atr_periods:
        for mult in multipliers:
            count += 1
            
            trades = backtest(candles, atr, mult, mode)
            stats = calc_stats(trades)
            
            if stats and stats["total_trades"] >= 5:  # Minimum 5 trades
                stats["atr_period"] = atr
                stats["multiplier"] = mult
                stats["mode"] = mode
                results.append(stats)
            
            if count % 10 == 0:
                sys.stdout.write(f"\r  Testing {count}/{total} combinations...")
                sys.stdout.flush()
    
    print(f"\r  Tested {total} combinations, {len(results)} valid results")
    
    # Sort by profit factor first, then by total return
    results.sort(key=lambda x: (x["profit_factor"], x["total_return_pct"]), reverse=True)
    
    return results[:top_n]


def display_results(results, timeframe, mode, candle_count, date_range):
    """Pretty print optimization results."""
    
    print(f"\n{'='*80}")
    print(f"  SUPERTREND OPTIMIZER — BTC/USD {timeframe} | {mode.upper()}")
    print(f"  Data: {candle_count} candles | {date_range}")
    print(f"{'='*80}")
    
    print(f"\n  {'Rank':<5} {'ATR':<5} {'Mult':<6} {'Trades':<7} {'WinRate':<8} {'PF':<6} {'Return':<9} {'MaxDD':<8} {'AvgWin':<8} {'AvgLoss':<9} {'Sharpe':<7} {'ConsecL':<8}")
    print(f"  {'─'*4}  {'─'*4} {'─'*5} {'─'*6} {'─'*7} {'─'*5} {'─'*8} {'─'*7} {'─'*7} {'─'*8} {'─'*6} {'─'*7}")
    
    for i, r in enumerate(results):
        pf_str = f"{r['profit_factor']:.2f}" if r['profit_factor'] < 100 else "99+"
        print(f"  #{i+1:<4} {r['atr_period']:<5} {r['multiplier']:<6.1f} {r['total_trades']:<7} "
              f"{r['win_rate']:<8.1f} {pf_str:<6} {r['total_return_pct']:>+8.1f}% "
              f"{r['max_drawdown_pct']:>7.1f}% {r['avg_win_pct']:>+7.2f}% {r['avg_loss_pct']:>+8.2f}% "
              f"{r['sharpe_approx']:>6.3f} {r['max_consecutive_losses']:>7}")
    
    if results:
        best = results[0]
        print(f"\n  ★ RECOMMENDED: ATR {best['atr_period']}, Multiplier {best['multiplier']}")
        print(f"    {best['total_trades']} trades | {best['win_rate']}% win rate | "
              f"{best['profit_factor']:.2f} PF | {best['total_return_pct']:+.1f}% return | "
              f"{best['max_drawdown_pct']:.1f}% max DD")
        print(f"    Avg win: {best['avg_win_pct']:+.2f}% | Avg loss: {best['avg_loss_pct']:+.2f}% | "
              f"Best: {best['best_trade_pct']:+.2f}% | Worst: {best['worst_trade_pct']:+.2f}%")


def main():
    parser = argparse.ArgumentParser(description="SuperTrend Optimizer for BTC/USD")
    parser.add_argument("--timeframe", "-t", default="1H", choices=["30m", "1H", "4H"],
                       help="Candle timeframe (default: 1H)")
    parser.add_argument("--mode", "-m", default="long-only", choices=["long-only", "long-short"],
                       help="Trading mode (default: long-only)")
    parser.add_argument("--candles", "-c", type=int, default=1000,
                       help="Number of candles to fetch (default: 1000)")
    parser.add_argument("--top", type=int, default=10,
                       help="Show top N results (default: 10)")
    args = parser.parse_args()
    
    print(f"SuperTrend Optimizer — BTC/USD {args.timeframe}")
    print(f"Mode: {args.mode} | Fetching {args.candles} candles...")
    
    candles = fetch_candles(args.timeframe, args.candles)
    print(f"  Fetched {len(candles)} candles")
    
    if len(candles) < 100:
        print("ERROR: Not enough candle data. Need at least 100.")
        return
    
    first_date = datetime.fromtimestamp(candles[0]["ts"]/1000, tz=timezone.utc).strftime("%Y-%m-%d")
    last_date = datetime.fromtimestamp(candles[-1]["ts"]/1000, tz=timezone.utc).strftime("%Y-%m-%d")
    date_range = f"{first_date} → {last_date}"
    
    print(f"  Date range: {date_range}")
    print(f"\nRunning optimization ({len(candles)} candles, {args.mode})...")
    
    results = run_optimization(candles, args.mode, args.top)
    display_results(results, args.timeframe, args.mode, len(candles), date_range)
    
    # Save results
    if results:
        best = results[0]
        output = {
            "updated": datetime.now(timezone.utc).isoformat(),
            "symbol": "BTC/USD",
            "timeframe": args.timeframe,
            "mode": args.mode,
            "candles_tested": len(candles),
            "date_range": date_range,
            "recommended_atr_period": best["atr_period"],
            "recommended_multiplier": best["multiplier"],
            "expected_win_rate": best["win_rate"],
            "expected_profit_factor": best["profit_factor"],
            "backtest_return_pct": best["total_return_pct"],
            "max_drawdown_pct": best["max_drawdown_pct"],
            "top_results": results,
        }
        
        outfile = os.path.join(OUTPUT_DIR, f"optimal_params_{args.timeframe}.json")
        os.makedirs(OUTPUT_DIR, exist_ok=True)
        with open(outfile, "w") as f:
            json.dump(output, f, indent=2)
        print(f"\nResults saved: {outfile}")
        
        # Also show the best params for quick copy
        print(f"\n{'='*80}")
        print(f"  COPY THESE INTO TRADINGVIEW:")
        print(f"  Timeframe: {args.timeframe}")
        print(f"  ATR Period: {best['atr_period']}")
        print(f"  Multiplier: {best['multiplier']}")
        print(f"{'='*80}")


if __name__ == "__main__":
    main()
