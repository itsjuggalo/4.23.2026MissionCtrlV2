#!/usr/bin/env python3
"""
SuperTrend Backtester — Run strategy against historical data
Zero LLM calls. Pure Python math.
"""

from supertrend import calculate_supertrend


def backtest(candles: list, atr_period: int = 10, multiplier: float = 3.0,
             fee_pct: float = 0.1, initial_capital: float = 100000.0) -> dict:
    """
    Backtest a SuperTrend flip strategy.

    Rules:
    - BUY when SuperTrend flips bullish (direction changes from 1 to -1)
    - SELL when SuperTrend flips bearish (direction changes from -1 to 1)
    - Always in market (flip-to-exit)

    Returns performance stats dict.
    """
    highs = [c["high"] for c in candles]
    lows = [c["low"] for c in candles]
    closes = [c["close"] for c in candles]

    st = calculate_supertrend(highs, lows, closes, atr_period, multiplier)
    directions = st["direction"]

    trades = []
    position = None  # None, "LONG", "SHORT"
    entry_price = 0.0
    capital = initial_capital
    peak_capital = initial_capital
    max_drawdown = 0.0

    # Skip warmup period
    start_idx = atr_period + 1

    for i in range(start_idx, len(candles)):
        prev_dir = directions[i - 1]
        curr_dir = directions[i]

        # Detect flip
        if prev_dir != curr_dir:
            price = closes[i]

            # Close existing position
            if position == "LONG":
                pnl_pct = ((price - entry_price) / entry_price) * 100
                fee = price * (fee_pct / 100) + entry_price * (fee_pct / 100)
                net_pnl = (price - entry_price) - fee
                capital += net_pnl * (capital / entry_price)

                trades.append({
                    "direction": "LONG",
                    "entry_price": entry_price,
                    "exit_price": price,
                    "entry_time": candles[entry_idx]["datetime"],
                    "exit_time": candles[i]["datetime"],
                    "pnl_pct": round(pnl_pct, 4),
                    "net_pnl_pct": round(pnl_pct - (fee_pct * 2), 4),
                    "bars_held": i - entry_idx,
                })

            elif position == "SHORT":
                pnl_pct = ((entry_price - price) / entry_price) * 100
                fee = price * (fee_pct / 100) + entry_price * (fee_pct / 100)
                net_pnl = (entry_price - price) - fee
                capital += net_pnl * (capital / entry_price)

                trades.append({
                    "direction": "SHORT",
                    "entry_price": entry_price,
                    "exit_price": price,
                    "entry_time": candles[entry_idx]["datetime"],
                    "exit_time": candles[i]["datetime"],
                    "pnl_pct": round(pnl_pct, 4),
                    "net_pnl_pct": round(pnl_pct - (fee_pct * 2), 4),
                    "bars_held": i - entry_idx,
                })

            # Track drawdown
            if capital > peak_capital:
                peak_capital = capital
            dd = ((peak_capital - capital) / peak_capital) * 100
            if dd > max_drawdown:
                max_drawdown = dd

            # Open new position on flip
            entry_price = price
            entry_idx = i
            if curr_dir == -1:  # Bullish
                position = "LONG"
            else:  # Bearish
                position = "SHORT"

    # Stats
    if not trades:
        return {
            "atr_period": atr_period,
            "multiplier": multiplier,
            "total_trades": 0,
            "total_return_pct": 0,
            "win_rate": 0,
            "profit_factor": 0,
            "max_drawdown_pct": 0,
            "avg_trade_pct": 0,
            "avg_win_pct": 0,
            "avg_loss_pct": 0,
            "sharpe_approx": 0,
            "avg_bars_held": 0,
        }

    wins = [t for t in trades if t["net_pnl_pct"] > 0]
    losses = [t for t in trades if t["net_pnl_pct"] <= 0]

    gross_profit = sum(t["net_pnl_pct"] for t in wins) if wins else 0
    gross_loss = abs(sum(t["net_pnl_pct"] for t in losses)) if losses else 0.001

    all_returns = [t["net_pnl_pct"] for t in trades]
    avg_return = sum(all_returns) / len(all_returns)
    variance = sum((r - avg_return) ** 2 for r in all_returns) / len(all_returns)
    std_dev = variance ** 0.5

    total_return = ((capital - initial_capital) / initial_capital) * 100

    return {
        "atr_period": atr_period,
        "multiplier": multiplier,
        "total_trades": len(trades),
        "total_return_pct": round(total_return, 2),
        "win_rate": round(len(wins) / len(trades) * 100, 1),
        "profit_factor": round(gross_profit / gross_loss, 2) if gross_loss > 0 else 0,
        "max_drawdown_pct": round(max_drawdown, 2),
        "avg_trade_pct": round(avg_return, 4),
        "avg_win_pct": round(sum(t["net_pnl_pct"] for t in wins) / len(wins), 4) if wins else 0,
        "avg_loss_pct": round(sum(t["net_pnl_pct"] for t in losses) / len(losses), 4) if losses else 0,
        "sharpe_approx": round(avg_return / std_dev, 3) if std_dev > 0 else 0,
        "avg_bars_held": round(sum(t["bars_held"] for t in trades) / len(trades), 1),
        "longest_win_streak": _streak(trades, True),
        "longest_loss_streak": _streak(trades, False),
        "trades": trades,
    }


def _streak(trades: list, winning: bool) -> int:
    """Calculate longest win or loss streak."""
    max_streak = 0
    current = 0
    for t in trades:
        if (t["net_pnl_pct"] > 0) == winning:
            current += 1
            max_streak = max(max_streak, current)
        else:
            current = 0
    return max_streak


def backtest_long_only(candles: list, atr_period: int = 10, multiplier: float = 3.0,
                        fee_pct: float = 0.1, initial_capital: float = 100000.0) -> dict:
    """
    Long-only backtest — only BUY on bullish flip, SELL on bearish flip.
    No shorting. Sits in cash during bearish periods.
    """
    highs = [c["high"] for c in candles]
    lows = [c["low"] for c in candles]
    closes = [c["close"] for c in candles]

    st = calculate_supertrend(highs, lows, closes, atr_period, multiplier)
    directions = st["direction"]

    trades = []
    in_position = False
    entry_price = 0.0
    capital = initial_capital
    peak_capital = initial_capital
    max_drawdown = 0.0

    start_idx = atr_period + 1

    for i in range(start_idx, len(candles)):
        prev_dir = directions[i - 1]
        curr_dir = directions[i]

        if prev_dir != curr_dir:
            price = closes[i]

            if curr_dir == -1 and not in_position:  # Flip bullish → BUY
                entry_price = price
                entry_idx = i
                in_position = True

            elif curr_dir == 1 and in_position:  # Flip bearish → SELL
                pnl_pct = ((price - entry_price) / entry_price) * 100
                net_pnl_pct = pnl_pct - (fee_pct * 2)
                capital *= (1 + net_pnl_pct / 100)

                trades.append({
                    "direction": "LONG",
                    "entry_price": entry_price,
                    "exit_price": price,
                    "entry_time": candles[entry_idx]["datetime"],
                    "exit_time": candles[i]["datetime"],
                    "pnl_pct": round(pnl_pct, 4),
                    "net_pnl_pct": round(net_pnl_pct, 4),
                    "bars_held": i - entry_idx,
                })

                in_position = False

                if capital > peak_capital:
                    peak_capital = capital
                dd = ((peak_capital - capital) / peak_capital) * 100
                if dd > max_drawdown:
                    max_drawdown = dd

    if not trades:
        return {"atr_period": atr_period, "multiplier": multiplier, "total_trades": 0}

    wins = [t for t in trades if t["net_pnl_pct"] > 0]
    losses = [t for t in trades if t["net_pnl_pct"] <= 0]
    gross_profit = sum(t["net_pnl_pct"] for t in wins) if wins else 0
    gross_loss = abs(sum(t["net_pnl_pct"] for t in losses)) if losses else 0.001
    all_returns = [t["net_pnl_pct"] for t in trades]
    avg_return = sum(all_returns) / len(all_returns)
    variance = sum((r - avg_return) ** 2 for r in all_returns) / len(all_returns)
    std_dev = variance ** 0.5
    total_return = ((capital - initial_capital) / initial_capital) * 100

    return {
        "atr_period": atr_period,
        "multiplier": multiplier,
        "total_trades": len(trades),
        "total_return_pct": round(total_return, 2),
        "win_rate": round(len(wins) / len(trades) * 100, 1),
        "profit_factor": round(gross_profit / gross_loss, 2) if gross_loss > 0 else 0,
        "max_drawdown_pct": round(max_drawdown, 2),
        "avg_trade_pct": round(avg_return, 4),
        "avg_win_pct": round(sum(t["net_pnl_pct"] for t in wins) / len(wins), 4) if wins else 0,
        "avg_loss_pct": round(sum(t["net_pnl_pct"] for t in losses) / len(losses), 4) if losses else 0,
        "sharpe_approx": round(avg_return / std_dev, 3) if std_dev > 0 else 0,
        "avg_bars_held": round(sum(t["bars_held"] for t in trades) / len(trades), 1),
        "trades": trades,
    }
