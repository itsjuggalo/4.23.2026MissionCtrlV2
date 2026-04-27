#!/usr/bin/env python3
"""
BTC SuperTrend Enhanced Strategy
Exhaustive Optimizer + Live Signal Generator for Bitcoin (BTC-USDT)

Features:
- Faithful Pine Script SuperTrend replication (RMA ATR, exact band logic)
- Exhaustive parameter optimization (9 ATR periods × 7 multipliers × 3 sources
  × 3 timeframes × 2 ATR methods = 1134 combinations)
- Volume filter (vol > 20-period avg)
- RSI filter (no LONG if RSI>70, no SHORT if RSI<30)
- Multi-timeframe confirmation (1H signal must align with 4H trend)
- K-Means volatility clustering (from existing optimizer)
- Dynamic multiplier based on volatility regime (HIGH→×1.3, LOW→×0.8)
- Live signal generation every 5 minutes → shared/btc_supertrend_signal.json
- PM2-compatible stdout logging
"""

import json
import logging
import time
import sys
import os
from datetime import datetime, timezone
from pathlib import Path
from typing import Optional, Dict, List, Tuple, Any
from itertools import product as iproduct

import numpy as np
import pandas as pd
import requests

# ── Paths ─────────────────────────────────────────────────────────────────────

BASE_DIR   = Path('/home/ubuntu/mission-control')
SHARED_DIR = BASE_DIR / 'shared'
SHARED_DIR.mkdir(exist_ok=True)

OPTIMIZED_FILE = SHARED_DIR / 'btc_supertrend_optimized.json'
BACKTEST_FILE  = SHARED_DIR / 'btc_supertrend_backtest.json'
SIGNAL_FILE    = SHARED_DIR / 'btc_supertrend_signal.json'

# ── Logging ───────────────────────────────────────────────────────────────────

logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s [BTC-SUPERTREND] %(levelname)s %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S',
    handlers=[logging.StreamHandler(sys.stdout)]
)
log = logging.getLogger('btc_supertrend')

# ── Optimization Search Space ─────────────────────────────────────────────────

ATR_PERIODS   = [7, 8, 9, 10, 12, 14, 16, 20, 24]
MULTIPLIERS   = [1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]
SOURCES       = ['hl2', 'close', 'ohlc4']
TIMEFRAMES_OKX = {'1H': '1H', '4H': '4H', '1D': '1D'}
ATR_METHODS   = ['rma', 'sma']

# Scoring thresholds
MIN_WIN_RATE      = 55.0
MIN_PROFIT_FACTOR = 1.5
MAX_DRAWDOWN_PCT  = 25.0
MIN_TRADES        = 5    # Statistical significance floor (MTF filtering reduces trade count)

# Data targets
TARGET_CANDLES = {'1H': 2000, '4H': 600, '1D': 300}


# ═══════════════════════════════════════════════════════════════════════════════
# DATA FETCHING
# ═══════════════════════════════════════════════════════════════════════════════

def _fetch_batch(inst_id: str, bar: str, limit: int = 300,
                 after_ts_ms: Optional[int] = None) -> Optional[pd.DataFrame]:
    """Single OKX API call. Uses history-candles for older data."""
    endpoint = 'https://www.okx.com/api/v5/market/history-candles'
    params = {'instId': inst_id, 'bar': bar, 'limit': limit}
    if after_ts_ms:
        params['after'] = after_ts_ms  # fetch candles BEFORE this ts

    try:
        r = requests.get(endpoint, params=params, timeout=15)
        r.raise_for_status()
        data = r.json().get('data', [])
        if not data:
            # Fallback to regular candles endpoint
            endpoint2 = 'https://www.okx.com/api/v5/market/candles'
            r2 = requests.get(endpoint2, params=params, timeout=15)
            r2.raise_for_status()
            data = r2.json().get('data', [])
            if not data:
                return None

        df = pd.DataFrame(data, columns=['ts','open','high','low','close','vol','a','b','c'])
        for col in ['open','high','low','close','vol']:
            df[col] = pd.to_numeric(df[col], errors='coerce')
        df['ts'] = pd.to_datetime(pd.to_numeric(df['ts']), unit='ms', utc=True)
        df = df.sort_values('ts').reset_index(drop=True)
        return df[['ts','open','high','low','close','vol']].dropna()
    except Exception as e:
        log.warning(f'OKX fetch error {inst_id} {bar}: {e}')
        return None


def fetch_btc_history(bar: str, target: int = 2000) -> Optional[pd.DataFrame]:
    """
    Fetch BTC-USDT historical candles by paginating backwards.
    OKX history-candles returns up to 300 per request.
    """
    log.info(f'Fetching BTC-USDT {bar} history (target: {target} candles)...')
    all_batches = []
    oldest_ts_ms = None
    max_requests = 20  # Safety limit

    for req_num in range(max_requests):
        batch = _fetch_batch('BTC-USDT', bar, 300, oldest_ts_ms)
        if batch is None or len(batch) == 0:
            break

        all_batches.append(batch)
        total = sum(len(b) for b in all_batches)
        oldest_ts_ms = int(batch['ts'].iloc[0].timestamp() * 1000)

        log.info(f'  {bar} req#{req_num+1}: +{len(batch)} candles (total: {total}), '
                 f'oldest: {batch["ts"].iloc[0].strftime("%Y-%m-%d")}')
        time.sleep(0.4)

        if total >= target or len(batch) < 300:
            break

    if not all_batches:
        return None

    combined = pd.concat(all_batches, ignore_index=True)
    combined = combined.drop_duplicates('ts').sort_values('ts').reset_index(drop=True)
    log.info(f'{bar}: {len(combined)} candles '
             f'({combined["ts"].iloc[0].strftime("%Y-%m-%d")} → '
             f'{combined["ts"].iloc[-1].strftime("%Y-%m-%d")})')
    return combined


def fetch_latest_candles(bar: str, limit: int = 300) -> Optional[pd.DataFrame]:
    """Fetch most recent candles for live signal generation."""
    params = {'instId': 'BTC-USDT', 'bar': bar, 'limit': limit}
    try:
        r = requests.get('https://www.okx.com/api/v5/market/candles',
                         params=params, timeout=12)
        r.raise_for_status()
        data = r.json().get('data', [])
        if not data:
            return None
        rows = list(reversed(data))
        df = pd.DataFrame(rows, columns=['ts','open','high','low','close','vol','a','b','c'])
        for col in ['open','high','low','close','vol']:
            df[col] = pd.to_numeric(df[col], errors='coerce')
        df['ts'] = pd.to_datetime(pd.to_numeric(df['ts']), unit='ms', utc=True)
        return df[['ts','open','high','low','close','vol']].dropna()
    except Exception as e:
        log.warning(f'Live fetch error: {e}')
        return None


# ═══════════════════════════════════════════════════════════════════════════════
# INDICATORS
# ═══════════════════════════════════════════════════════════════════════════════

def calc_source(df: pd.DataFrame, source: str) -> pd.Series:
    """Calculate price source (hl2 / close / ohlc4)."""
    if source == 'hl2':
        return (df['high'] + df['low']) / 2
    elif source == 'ohlc4':
        return (df['open'] + df['high'] + df['low'] + df['close']) / 4
    else:  # close
        return df['close'].copy()


def calc_true_range(df: pd.DataFrame) -> pd.Series:
    """True Range = max(high-low, |high-prev_close|, |low-prev_close|)."""
    high, low, close = df['high'], df['low'], df['close']
    return pd.concat([
        high - low,
        (high - close.shift(1)).abs(),
        (low  - close.shift(1)).abs(),
    ], axis=1).max(axis=1)


def calc_rma(series: pd.Series, period: int) -> pd.Series:
    """
    Wilder's Moving Average / RMA — mirrors Pine Script's ta.rma().
    alpha = 1/period, equivalent to EWM with adjust=False.
    """
    return series.ewm(alpha=1.0 / period, adjust=False).mean()


def calc_atr(df: pd.DataFrame, period: int, method: str = 'rma') -> pd.Series:
    """ATR via RMA (Wilder) or SMA."""
    tr = calc_true_range(df)
    if method == 'rma':
        return calc_rma(tr, period)
    else:
        return tr.rolling(period).mean()


def calc_rsi(close: pd.Series, period: int = 14) -> pd.Series:
    """RSI using Wilder smoothing (same as Pine Script ta.rsi)."""
    delta = close.diff()
    gain  = delta.clip(lower=0)
    loss  = (-delta).clip(lower=0)
    avg_gain = calc_rma(gain, period)
    avg_loss = calc_rma(loss, period)
    rs = avg_gain / avg_loss.replace(0, np.nan)
    return 100 - (100 / (1 + rs))


def calc_supertrend_pine(df: pd.DataFrame,
                          atr_period: int,
                          multiplier: float,
                          source: str = 'hl2',
                          atr_method: str = 'rma') -> Tuple[np.ndarray, np.ndarray]:
    """
    Faithful replication of Pine Script SuperTrend:

        atr  = rma(tr, Periods)
        up   = src - (Multiplier * atr)
        up   = close[1] > up[1] ? max(up, up[1]) : up
        dn   = src + (Multiplier * atr)
        dn   = close[1] < dn[1] ? min(dn, dn[1]) : dn
        trend = trend == -1 and close > dn[1] ? 1
              : trend == 1  and close < up[1] ? -1
              : trend

    Returns:
        trend_arr  : np.ndarray int (1=bullish, -1=bearish, 0=undecided)
        st_line    : np.ndarray float (supertrend line value)
    """
    atr_s  = calc_atr(df, atr_period, atr_method).values
    src_s  = calc_source(df, source).values
    close  = df['close'].values
    n      = len(df)

    up    = np.full(n, np.nan)
    dn    = np.full(n, np.nan)
    trend = np.zeros(n, dtype=int)
    st    = np.full(n, np.nan)

    for i in range(n):
        if np.isnan(atr_s[i]):
            continue

        up_raw = src_s[i] - multiplier * atr_s[i]
        dn_raw = src_s[i] + multiplier * atr_s[i]

        if i == 0 or np.isnan(up[i-1]):
            up[i]    = up_raw
            dn[i]    = dn_raw
            trend[i] = 1
        else:
            # Band ratcheting (Pine Script exact)
            up[i] = max(up_raw, up[i-1]) if close[i-1] > up[i-1] else up_raw
            dn[i] = min(dn_raw, dn[i-1]) if close[i-1] < dn[i-1] else dn_raw

            # Trend direction
            if trend[i-1] == -1 and close[i] > dn[i-1]:
                trend[i] = 1
            elif trend[i-1] == 1 and close[i] < up[i-1]:
                trend[i] = -1
            else:
                trend[i] = trend[i-1]

        st[i] = up[i] if trend[i] == 1 else dn[i]

    return trend, st


# ═══════════════════════════════════════════════════════════════════════════════
# K-MEANS VOLATILITY CLUSTERING
# ═══════════════════════════════════════════════════════════════════════════════

def kmeans_atr_clusters(atr_series: pd.Series, train_period: int = 100,
                         highvol: float = 0.75, midvol: float = 0.5,
                         lowvol: float = 0.25) -> Optional[dict]:
    """
    K-Means clustering on ATR values — mirrors Pine Script ML clustering.
    Returns cluster centroids and current regime assignment.
    """
    atr_window = atr_series.dropna().tail(train_period).values
    if len(atr_window) < 20:
        return None

    lo, hi = atr_window.min(), atr_window.max()
    rng = hi - lo
    if rng < 1e-10:
        return None

    a_m = lo + rng * highvol
    b_m = lo + rng * midvol
    c_m = lo + rng * lowvol

    for _ in range(200):
        hv, mv, lv = [], [], []
        for val in atr_window:
            da, db, dc = abs(val - a_m), abs(val - b_m), abs(val - c_m)
            if da < db and da < dc:   hv.append(val)
            elif db < da and db < dc: mv.append(val)
            else:                     lv.append(val)

        na = np.mean(hv) if hv else a_m
        nb = np.mean(mv) if mv else b_m
        nc = np.mean(lv) if lv else c_m

        if na == a_m and nb == b_m and nc == c_m:
            break
        a_m, b_m, c_m = na, nb, nc

    curr = atr_series.dropna().iloc[-1]
    dists = [abs(curr - a_m), abs(curr - b_m), abs(curr - c_m)]
    cluster = int(np.argmin(dists))
    names = ['HIGH', 'MEDIUM', 'LOW']

    return {
        'high_centroid':     round(float(a_m), 6),
        'medium_centroid':   round(float(b_m), 6),
        'low_centroid':      round(float(c_m), 6),
        'current_cluster':   cluster,
        'cluster_name':      names[cluster],
        'assigned_centroid': round(float([a_m, b_m, c_m][cluster]), 6),
        'current_atr':       round(float(curr), 6),
    }


def get_dynamic_multiplier(base_mult: float, cluster_name: str) -> float:
    """
    Adjust multiplier based on volatility regime:
    HIGH vol → use larger multiplier (fewer whipsaws)
    LOW vol  → use smaller multiplier (tighter bands)
    """
    factors = {'HIGH': 1.3, 'MEDIUM': 1.0, 'LOW': 0.8}
    return round(base_mult * factors.get(cluster_name, 1.0), 2)


# ═══════════════════════════════════════════════════════════════════════════════
# BACKTEST ENGINE
# ═══════════════════════════════════════════════════════════════════════════════

def _build_4h_trend_lookup(df_1h: pd.DataFrame, df_4h: pd.DataFrame,
                             atr_period: int, multiplier: float,
                             source: str, atr_method: str) -> Optional[pd.Series]:
    """Compute 4H SuperTrend and build a lookup indexed by 4H timestamp."""
    if df_4h is None or len(df_4h) < atr_period + 10:
        return None
    trend_4h, _ = calc_supertrend_pine(df_4h, atr_period, multiplier, source, atr_method)
    return pd.Series(trend_4h, index=df_4h['ts'].values)


def backtest_params(df_1h: pd.DataFrame,
                    df_4h: Optional[pd.DataFrame],
                    atr_period: int,
                    multiplier: float,
                    source: str,
                    atr_method: str,
                    use_volume_filter: bool = True,
                    use_rsi_filter:    bool = True,
                    use_mtf_filter:    bool = True,
                    return_full:       bool = False,
                    initial_capital:   float = 10000.0) -> dict:
    """
    Run backtest on 1H data with optional filters.
    Set return_full=True to get trades list + equity curve.
    """
    warmup = max(atr_period + 20, 25)
    if len(df_1h) < warmup + 10:
        return {'error': 'insufficient_data', 'n_trades': 0, 'score': 0.0}

    # ── Pre-compute indicators ──
    trend_arr, st_arr = calc_supertrend_pine(df_1h, atr_period, multiplier,
                                              source, atr_method)
    rsi_arr  = calc_rsi(df_1h['close']).values
    vol_ma   = df_1h['vol'].rolling(20).mean().values

    # 4H trend lookup (for MTF filter)
    trend_4h_series = None
    if use_mtf_filter and df_4h is not None:
        trend_4h_series = _build_4h_trend_lookup(
            df_1h, df_4h, atr_period, multiplier, source, atr_method)

    close  = df_1h['close'].values
    ts_arr = df_1h['ts'].values
    vol    = df_1h['vol'].values

    # ── Trade simulation ──
    trades       = []
    equity       = [initial_capital]
    capital      = initial_capital
    in_trade     = False
    entry_price  = None
    entry_dir    = None
    entry_ts_val = None

    for i in range(warmup, len(df_1h)):
        curr_trend = trend_arr[i]
        prev_trend = trend_arr[i - 1]

        if curr_trend == prev_trend or curr_trend == 0:
            equity.append(capital)
            continue

        # ── Signal detected ──

        # Volume filter
        if use_volume_filter and not np.isnan(vol_ma[i]):
            if vol[i] <= vol_ma[i]:
                equity.append(capital)
                continue

        # RSI filter
        if use_rsi_filter and not np.isnan(rsi_arr[i]):
            if curr_trend == 1  and rsi_arr[i] > 70:
                equity.append(capital)
                continue
            if curr_trend == -1 and rsi_arr[i] < 30:
                equity.append(capital)
                continue

        # MTF filter (1H must align with 4H trend)
        if use_mtf_filter and trend_4h_series is not None:
            curr_ts = ts_arr[i]
            # Find latest 4H candle at or before this 1H bar
            mask = trend_4h_series.index <= curr_ts
            if mask.any():
                t4_trend = trend_4h_series[mask].iloc[-1]
                if t4_trend != curr_trend:
                    equity.append(capital)
                    continue

        # ── Close existing trade ──
        if in_trade:
            pnl_pct = (close[i] - entry_price) / entry_price
            if entry_dir == -1:
                pnl_pct = -pnl_pct
            trade_pnl = capital * pnl_pct
            capital  += trade_pnl

            if return_full:
                trades.append({
                    'entry_ts':     str(entry_ts_val),
                    'exit_ts':      str(ts_arr[i]),
                    'entry_price':  float(entry_price),
                    'exit_price':   float(close[i]),
                    'direction':    'LONG' if entry_dir == 1 else 'SHORT',
                    'pnl_pct':      round(float(pnl_pct * 100), 4),
                    'pnl_dollar':   round(float(trade_pnl), 2),
                    'capital_after': round(float(capital), 2),
                })
            else:
                trades.append({'pnl_pct': pnl_pct, 'dir': entry_dir})

            in_trade = False

        # ── Open new trade ──
        in_trade     = True
        entry_price  = close[i]
        entry_dir    = curr_trend
        entry_ts_val = ts_arr[i]

        equity.append(capital)

    # Close open trade at end
    if in_trade:
        pnl_pct   = (close[-1] - entry_price) / entry_price
        if entry_dir == -1:
            pnl_pct = -pnl_pct
        trade_pnl = capital * pnl_pct
        capital  += trade_pnl

        if return_full:
            trades.append({
                'entry_ts':     str(entry_ts_val),
                'exit_ts':      str(ts_arr[-1]),
                'entry_price':  float(entry_price),
                'exit_price':   float(close[-1]),
                'direction':    'LONG' if entry_dir == 1 else 'SHORT',
                'pnl_pct':      round(float(pnl_pct * 100), 4),
                'pnl_dollar':   round(float(trade_pnl), 2),
                'capital_after': round(float(capital), 2),
                'open':         True,
            })
        else:
            trades.append({'pnl_pct': pnl_pct, 'dir': entry_dir})

        equity.append(capital)

    n_trades = len(trades)
    if n_trades < 5:
        return {'error': 'too_few_trades', 'n_trades': n_trades, 'score': 0.0}

    # ── Compute stats ──
    # pnl_pct is stored as decimal (0.05 = 5%) in compact mode, as percent in full mode
    if return_full:
        pnl_list = [t['pnl_pct'] / 100.0 for t in trades]  # convert back from percent
    else:
        pnl_list = [t['pnl_pct'] for t in trades]
    wins     = [p for p in pnl_list if p > 0]
    losses   = [abs(p) for p in pnl_list if p <= 0]

    win_rate      = len(wins) / n_trades * 100
    gross_wins    = sum(wins)
    gross_losses  = sum(losses)
    profit_factor = gross_wins / gross_losses if gross_losses > 0 else 99.0

    # Equity drawdown
    eq_arr = np.array(equity)
    peak   = np.maximum.accumulate(eq_arr)
    dd_arr = (peak - eq_arr) / peak * 100
    max_dd = float(np.max(dd_arr))

    # Sharpe (hourly returns, annualize √8760)
    eq_s    = pd.Series(equity)
    rets    = eq_s.pct_change().dropna()
    sharpe  = float(rets.mean() / rets.std() * np.sqrt(8760)) if rets.std() > 0 else 0.0

    net_ret = (capital - initial_capital) / initial_capital * 100

    meets = (
        win_rate >= MIN_WIN_RATE and
        profit_factor >= MIN_PROFIT_FACTOR and
        max_dd < MAX_DRAWDOWN_PCT and
        n_trades >= MIN_TRADES
    )

    if meets:
        score = (
            (win_rate / 100)                          * 30 +
            min(profit_factor / 5.0, 1.0)             * 30 +
            (MAX_DRAWDOWN_PCT - max_dd) / MAX_DRAWDOWN_PCT * 20 +
            min(n_trades / 100, 1.0)                  * 10 +
            np.clip(sharpe / 3.0, -1.0, 1.0)          * 10
        )
    else:
        score = 0.0

    result = {
        'meets_criteria':   meets,
        'n_trades':         n_trades,
        'n_wins':           len(wins),
        'n_losses':         len(losses),
        'win_rate':         round(win_rate, 2),
        'profit_factor':    round(profit_factor, 3),
        'max_drawdown_pct': round(max_dd, 2),
        'net_return_pct':   round(net_ret, 2),
        'sharpe_ratio':     round(sharpe, 3),
        'score':            round(score, 4),
        'capital_final':    round(float(capital), 2),
        'initial_capital':  initial_capital,
    }

    if return_full:
        # Build equity curve as list (downsample if huge)
        eq_list = [round(float(v), 2) for v in eq_arr]
        dd_list = [round(float(v), 2) for v in dd_arr]
        result['trades']       = trades
        result['equity_curve'] = eq_list
        result['drawdown_curve'] = dd_list

    return result


# ═══════════════════════════════════════════════════════════════════════════════
# EXHAUSTIVE OPTIMIZER
# ═══════════════════════════════════════════════════════════════════════════════

def run_optimization(data: Dict[str, pd.DataFrame]) -> Tuple[dict, dict]:
    """
    Exhaustive parameter search across all combinations.
    Phase 1: Fast search without MTF (find top candidates)
    Phase 2: Re-evaluate top candidates WITH MTF filter

    Returns:
        best_params: dict with best parameter set
        all_results: list of all evaluated combinations
    """
    log.info('=' * 60)
    log.info('EXHAUSTIVE OPTIMIZATION STARTING')
    log.info(f'Search space: {len(ATR_PERIODS)} ATR × {len(MULTIPLIERS)} mults × '
             f'{len(SOURCES)} src × {len(TIMEFRAMES_OKX)} TF × {len(ATR_METHODS)} ATR method'
             f' = {len(ATR_PERIODS)*len(MULTIPLIERS)*len(SOURCES)*len(TIMEFRAMES_OKX)*len(ATR_METHODS)} combos')
    log.info('=' * 60)

    all_results = []
    combo_num   = 0
    best_score  = -1
    best_params = {}

    tf_pairs = [
        ('1H', '4H'),   # primary 1H, MTF 4H
        ('4H', '1D'),   # primary 4H, MTF 1D
        ('1D', None),   # primary 1D, no MTF
    ]

    total_combos = (len(ATR_PERIODS) * len(MULTIPLIERS) *
                    len(SOURCES) * len(tf_pairs) * len(ATR_METHODS))

    for (primary_tf, mtf_tf), atr_period, multiplier, source, atr_method in iproduct(
        tf_pairs, ATR_PERIODS, MULTIPLIERS, SOURCES, ATR_METHODS
    ):
        combo_num += 1
        df_primary = data.get(primary_tf)
        df_mtf     = data.get(mtf_tf) if mtf_tf else None

        if df_primary is None or len(df_primary) < atr_period + 50:
            continue

        # Phase 1: Fast backtest WITHOUT MTF (to avoid expensive 4H ST computation)
        result = backtest_params(
            df_1h=df_primary,
            df_4h=None,
            atr_period=atr_period,
            multiplier=multiplier,
            source=source,
            atr_method=atr_method,
            use_volume_filter=True,
            use_rsi_filter=True,
            use_mtf_filter=False,
            return_full=False,
        )

        if combo_num % 100 == 0:
            log.info(f'  Progress: {combo_num}/{total_combos} '
                     f'(best_score={best_score:.3f})')

        combo_entry = {
            'primary_tf':  primary_tf,
            'mtf_tf':      mtf_tf,
            'atr_period':  atr_period,
            'multiplier':  multiplier,
            'source':      source,
            'atr_method':  atr_method,
            'no_mtf':      result,
        }
        all_results.append(combo_entry)

        if result.get('score', 0) > best_score:
            best_score  = result.get('score', 0)
            best_params = combo_entry.copy()

    log.info(f'Phase 1 done. Best score (no MTF): {best_score:.3f}')
    log.info('Phase 2: Re-evaluating top 30 with full MTF filter...')

    # Phase 2: Top 30 with MTF
    top_30 = sorted(all_results,
                    key=lambda x: x['no_mtf'].get('score', 0),
                    reverse=True)[:30]

    mtf_best_score = -1
    mtf_best = None

    for entry in top_30:
        primary_tf = entry['primary_tf']
        mtf_tf     = entry['mtf_tf']
        df_primary = data.get(primary_tf)
        df_mtf     = data.get(mtf_tf) if mtf_tf else None

        if df_primary is None:
            continue

        result_mtf = backtest_params(
            df_1h=df_primary,
            df_4h=df_mtf,
            atr_period=entry['atr_period'],
            multiplier=entry['multiplier'],
            source=entry['source'],
            atr_method=entry['atr_method'],
            use_volume_filter=True,
            use_rsi_filter=True,
            use_mtf_filter=(mtf_tf is not None),
            return_full=False,
        )
        entry['with_mtf'] = result_mtf

        sc = result_mtf.get('score', 0)
        if sc > mtf_best_score:
            mtf_best_score = sc
            mtf_best = entry.copy()
            log.info(f'  New MTF best: ATR={entry["atr_period"]} '
                     f'x{entry["multiplier"]} {entry["source"]} {entry["atr_method"]} '
                     f'on {primary_tf}/{mtf_tf} | '
                     f'wr={result_mtf.get("win_rate",0):.1f}% '
                     f'pf={result_mtf.get("profit_factor",0):.2f} '
                     f'dd={result_mtf.get("max_drawdown_pct",0):.1f}% '
                     f'trades={result_mtf.get("n_trades",0)} '
                     f'score={sc:.3f}')

    # If MTF best has good stats (meets criteria) use it,
    # otherwise fall back to the Phase 1 best that meets criteria
    if mtf_best and mtf_best.get('with_mtf', {}).get('meets_criteria', False):
        best_final = mtf_best
        log.info(f'Using Phase 2 (MTF) best. Score: {mtf_best_score:.3f}')
    else:
        # Fall back to the best Phase 1 result that meets criteria
        p1_meets = [r for r in all_results if r.get('no_mtf', {}).get('meets_criteria', False)]
        if p1_meets:
            best_final = p1_meets[0]
            log.info(f'Phase 2 MTF results had too few trades. '
                     f'Falling back to best Phase 1 result (meets_criteria=True). '
                     f'Score: {p1_meets[0]["no_mtf"].get("score",0):.3f}')
        else:
            # Nothing meets criteria — pick best raw score from Phase 1 on 1H
            p1_1h = [r for r in all_results if r.get('primary_tf') == '1H']
            if p1_1h:
                best_final = max(p1_1h, key=lambda x: x.get('no_mtf', {}).get('score', 0))
            else:
                best_final = best_params
            log.info(f'No result meets all criteria. Using best raw Phase 1 score. '
                     f'TF={best_final.get("primary_tf")} ATR={best_final.get("atr_period")}')

    log.info(f'Optimization complete. Final best score: {mtf_best_score:.3f}')

    # Sort all results by score for reporting
    all_results.sort(key=lambda x: x.get('with_mtf', x.get('no_mtf', {})).get('score', 0),
                     reverse=True)

    return best_final, all_results


# ═══════════════════════════════════════════════════════════════════════════════
# FULL BACKTEST WITH TRADES + EQUITY CURVE
# ═══════════════════════════════════════════════════════════════════════════════

def run_full_backtest(data: Dict[str, pd.DataFrame], params: dict) -> dict:
    """
    Run full backtest with the best parameters, returning complete trade list,
    equity curve, drawdown, Sharpe, profit factor, win rate.
    """
    primary_tf = params.get('primary_tf', '1H')
    mtf_tf     = params.get('mtf_tf', '4H')
    atr_period = params['atr_period']
    multiplier = params['multiplier']
    source     = params['source']
    atr_method = params['atr_method']

    df_primary = data.get(primary_tf)
    df_mtf     = data.get(mtf_tf) if mtf_tf else None

    log.info(f'Running full backtest: ATR={atr_period} x{multiplier} '
             f'{source}/{atr_method} on {primary_tf}/{mtf_tf}...')

    result = backtest_params(
        df_1h=df_primary,
        df_4h=df_mtf,
        atr_period=atr_period,
        multiplier=multiplier,
        source=source,
        atr_method=atr_method,
        use_volume_filter=True,
        use_rsi_filter=True,
        use_mtf_filter=(mtf_tf is not None),
        return_full=True,
        initial_capital=10000.0,
    )

    # Add metadata
    result['params'] = {
        'atr_period': atr_period,
        'multiplier': multiplier,
        'source': source,
        'atr_method': atr_method,
        'primary_tf': primary_tf,
        'mtf_tf': mtf_tf,
    }
    result['filters'] = {
        'volume_filter': True,
        'rsi_filter': True,
        'mtf_filter': mtf_tf is not None,
    }
    result['data_range'] = {
        'start': str(df_primary['ts'].iloc[0]) if df_primary is not None else None,
        'end':   str(df_primary['ts'].iloc[-1]) if df_primary is not None else None,
        'candles': len(df_primary) if df_primary is not None else 0,
    }
    result['backtested_at'] = datetime.now(timezone.utc).isoformat()

    # Compute K-Means clusters for best params
    if df_primary is not None:
        atr_s = calc_atr(df_primary, atr_period, atr_method)
        clusters = kmeans_atr_clusters(atr_s, train_period=100)
        result['volatility_clusters'] = clusters

    return result


# ═══════════════════════════════════════════════════════════════════════════════
# LIVE SIGNAL GENERATOR
# ═══════════════════════════════════════════════════════════════════════════════

def generate_signal(params: dict) -> dict:
    """
    Generate live BUY/SELL/HOLD signal using best params.
    Fetches latest candles from OKX and applies all filters.
    """
    atr_period = params['atr_period']
    multiplier = params['multiplier']
    source     = params['source']
    atr_method = params['atr_method']
    primary_tf = params.get('primary_tf', '1H')
    mtf_tf     = params.get('mtf_tf', '4H')

    ts_now = datetime.now(timezone.utc).isoformat()

    # Fetch latest candles
    df_1h = fetch_latest_candles(primary_tf, limit=300)
    df_4h = fetch_latest_candles(mtf_tf, limit=100) if mtf_tf else None

    if df_1h is None or len(df_1h) < atr_period + 30:
        return {
            'signal': 'HOLD',
            'confidence': 0,
            'reason': 'insufficient_data',
            'timestamp': ts_now,
        }

    # Compute K-Means for dynamic multiplier
    atr_s    = calc_atr(df_1h, atr_period, atr_method)
    clusters = kmeans_atr_clusters(atr_s, train_period=100)

    dyn_mult = multiplier
    cluster_name = 'UNKNOWN'
    if clusters:
        cluster_name = clusters['cluster_name']
        dyn_mult     = get_dynamic_multiplier(multiplier, cluster_name)

    # SuperTrend on primary TF
    trend_arr, st_arr = calc_supertrend_pine(df_1h, atr_period, dyn_mult, source, atr_method)
    rsi_arr  = calc_rsi(df_1h['close']).values
    vol_ma   = df_1h['vol'].rolling(20).mean().values

    last_idx  = len(df_1h) - 1
    curr_trend = trend_arr[last_idx]
    prev_trend = trend_arr[last_idx - 1]
    curr_close = df_1h['close'].iloc[-1]
    curr_rsi   = rsi_arr[last_idx]
    curr_vol   = df_1h['vol'].iloc[-1]
    curr_vol_ma = vol_ma[last_idx]
    st_val     = st_arr[last_idx]

    # Base signal from current trend
    if curr_trend == 1:
        base_signal = 'BUY'
    elif curr_trend == -1:
        base_signal = 'SELL'
    else:
        base_signal = 'HOLD'

    # Trend flip check
    is_new_signal = (curr_trend != prev_trend and curr_trend != 0)

    # Filters
    volume_ok = (not np.isnan(curr_vol_ma) and curr_vol > curr_vol_ma)

    rsi_ok = True
    rsi_blocked_reason = None
    if not np.isnan(curr_rsi):
        if curr_trend == 1  and curr_rsi > 70:
            rsi_ok = False
            rsi_blocked_reason = f'RSI={curr_rsi:.1f} overbought'
        if curr_trend == -1 and curr_rsi < 30:
            rsi_ok = False
            rsi_blocked_reason = f'RSI={curr_rsi:.1f} oversold'

    mtf_ok = True
    mtf_4h_trend = None
    if df_4h is not None and len(df_4h) >= atr_period + 10:
        trend_4h, _ = calc_supertrend_pine(df_4h, atr_period, dyn_mult, source, atr_method)
        mtf_4h_trend = int(trend_4h[-1])
        if mtf_4h_trend != curr_trend:
            mtf_ok = False

    # Confidence score (0-100)
    confidence = 50  # base

    # Signal direction confidence
    if is_new_signal:
        confidence += 20  # Fresh flip = more confident
    else:
        confidence += 5   # Continuation

    # Volume boost
    if not np.isnan(curr_vol_ma) and curr_vol > 0:
        vol_ratio = curr_vol / curr_vol_ma
        confidence += min(int((vol_ratio - 1.0) * 20), 15)

    # RSI in favorable zone
    if not np.isnan(curr_rsi):
        if curr_trend == 1 and 40 <= curr_rsi <= 60:
            confidence += 10
        elif curr_trend == -1 and 40 <= curr_rsi <= 60:
            confidence += 10

    # MTF alignment boost
    if mtf_ok and mtf_4h_trend == curr_trend:
        confidence += 15

    # Filter penalties
    if not volume_ok:
        confidence -= 20
    if not rsi_ok:
        confidence -= 30
    if not mtf_ok:
        confidence -= 25

    confidence = max(0, min(100, confidence))

    # Final signal with filters applied
    if not rsi_ok or not mtf_ok:
        final_signal = 'HOLD'
    else:
        final_signal = base_signal

    signal = {
        'signal':       final_signal,
        'confidence':   confidence,
        'base_signal':  base_signal,
        'is_new_flip':  is_new_signal,
        'current_trend': int(curr_trend),
        'price':        round(float(curr_close), 2),
        'supertrend_line': round(float(st_val), 2) if not np.isnan(st_val) else None,
        'rsi':          round(float(curr_rsi), 2) if not np.isnan(curr_rsi) else None,
        'volume':       round(float(curr_vol), 4),
        'volume_ma20':  round(float(curr_vol_ma), 4) if not np.isnan(curr_vol_ma) else None,
        'volume_ok':    bool(volume_ok),
        'rsi_ok':       bool(rsi_ok),
        'rsi_blocked':  rsi_blocked_reason,
        'mtf_ok':       bool(mtf_ok),
        'mtf_4h_trend': mtf_4h_trend,
        'volatility_regime': cluster_name,
        'dynamic_multiplier': dyn_mult,
        'atr':          round(float(atr_s.iloc[-1]), 2) if not np.isnan(atr_s.iloc[-1]) else None,
        'params': {
            'atr_period': atr_period,
            'multiplier': multiplier,
            'dynamic_multiplier': dyn_mult,
            'source': source,
            'atr_method': atr_method,
            'primary_tf': primary_tf,
            'mtf_tf': mtf_tf,
        },
        'timestamp': ts_now,
    }

    return signal


# ═══════════════════════════════════════════════════════════════════════════════
# MAIN FLOWS
# ═══════════════════════════════════════════════════════════════════════════════

def run_optimize_and_backtest():
    """
    Full optimization run:
    1. Fetch historical data for 1H, 4H, 1D
    2. Exhaustive parameter optimization
    3. Full backtest with best params
    4. Write output JSON files
    """
    log.info('╔══════════════════════════════════════════════╗')
    log.info('║  BTC SuperTrend Enhanced — Optimizer Mode   ║')
    log.info('╚══════════════════════════════════════════════╝')

    # ── Fetch data ──
    data = {}
    for bar, target in TARGET_CANDLES.items():
        df = fetch_btc_history(bar, target)
        if df is not None and len(df) > 50:
            data[bar] = df
        else:
            log.warning(f'Failed to fetch {bar} data')

    if '1H' not in data:
        log.error('1H data unavailable. Cannot optimize.')
        sys.exit(1)

    # ── Baseline backtest (original Pine Script params: ATR=10, mult=3.0, hl2) ──
    log.info('Running BASELINE backtest (ATR=10, mult=3.0, hl2/rma, no filters)...')
    baseline = backtest_params(
        df_1h=data['1H'],
        df_4h=data.get('4H'),
        atr_period=10,
        multiplier=3.0,
        source='hl2',
        atr_method='rma',
        use_volume_filter=False,
        use_rsi_filter=False,
        use_mtf_filter=False,
        return_full=False,
    )
    log.info(f'Baseline (no filters): wr={baseline.get("win_rate",0):.1f}% '
             f'pf={baseline.get("profit_factor",0):.2f} '
             f'dd={baseline.get("max_drawdown_pct",0):.1f}% '
             f'trades={baseline.get("n_trades",0)}')

    # ── Run exhaustive optimization ──
    best_params, all_results = run_optimization(data)

    # ── Full backtest with best params + all filters ──
    log.info('Running full backtest with best params (all filters on)...')
    full_result = run_full_backtest(data, best_params)

    # Also run best params without filters for comparison
    log.info('Running best params WITHOUT filters for comparison...')
    no_filter_result = backtest_params(
        df_1h=data[best_params.get('primary_tf', '1H')],
        df_4h=None,
        atr_period=best_params['atr_period'],
        multiplier=best_params['multiplier'],
        source=best_params['source'],
        atr_method=best_params['atr_method'],
        use_volume_filter=False,
        use_rsi_filter=False,
        use_mtf_filter=False,
        return_full=False,
    )
    log.info(f'Best params (no filters): wr={no_filter_result.get("win_rate",0):.1f}% '
             f'pf={no_filter_result.get("profit_factor",0):.2f} '
             f'trades={no_filter_result.get("n_trades",0)}')

    # ── Write optimized params ──
    optimized_output = {
        'symbol':       'BTC',
        'instrument':   'BTC-USDT',
        'optimized_at': datetime.now(timezone.utc).isoformat(),
        'best_params': {
            'atr_period':  best_params['atr_period'],
            'multiplier':  best_params['multiplier'],
            'source':      best_params['source'],
            'atr_method':  best_params['atr_method'],
            'primary_tf':  best_params.get('primary_tf', '1H'),
            'mtf_tf':      best_params.get('mtf_tf', '4H'),
        },
        'filters': {
            'volume_filter':  True,
            'rsi_filter':     True,
            'mtf_confirmation': True,
            'kmeans_clustering': True,
            'dynamic_multiplier': True,
        },
        'stats': full_result,
        'baseline_stats': baseline,
        'no_filter_stats': no_filter_result,
        'data_summary': {
            tf: {'candles': len(df), 'start': str(df['ts'].iloc[0]), 'end': str(df['ts'].iloc[-1])}
            for tf, df in data.items()
        },
        'top_10_combinations': [
            {
                'rank': i+1,
                'primary_tf': r['primary_tf'],
                'mtf_tf': r['mtf_tf'],
                'atr_period': r['atr_period'],
                'multiplier': r['multiplier'],
                'source': r['source'],
                'atr_method': r['atr_method'],
                'score': r.get('with_mtf', r.get('no_mtf', {})).get('score', 0),
                'win_rate': r.get('with_mtf', r.get('no_mtf', {})).get('win_rate', 0),
                'profit_factor': r.get('with_mtf', r.get('no_mtf', {})).get('profit_factor', 0),
                'max_drawdown_pct': r.get('with_mtf', r.get('no_mtf', {})).get('max_drawdown_pct', 0),
                'n_trades': r.get('with_mtf', r.get('no_mtf', {})).get('n_trades', 0),
            }
            for i, r in enumerate(all_results[:10])
        ],
    }

    with open(OPTIMIZED_FILE, 'w') as f:
        json.dump(optimized_output, f, indent=2, default=str)
    log.info(f'✅ Optimized params written: {OPTIMIZED_FILE}')

    # ── Write backtest results ──
    with open(BACKTEST_FILE, 'w') as f:
        json.dump(full_result, f, indent=2, default=str)
    log.info(f'✅ Full backtest written: {BACKTEST_FILE}')

    # ── Summary ──
    log.info('')
    log.info('═' * 60)
    log.info('OPTIMIZATION COMPLETE — BEST PARAMS:')
    log.info(f'  ATR Period : {best_params["atr_period"]}')
    log.info(f'  Multiplier : {best_params["multiplier"]}')
    log.info(f'  Source     : {best_params["source"]}')
    log.info(f'  ATR Method : {best_params["atr_method"]}')
    log.info(f'  Timeframe  : {best_params.get("primary_tf","1H")} / MTF: {best_params.get("mtf_tf","4H")}')
    log.info(f'  Win Rate   : {full_result.get("win_rate", 0):.2f}%')
    log.info(f'  Profit Factor: {full_result.get("profit_factor", 0):.3f}')
    log.info(f'  Max Drawdown : {full_result.get("max_drawdown_pct", 0):.2f}%')
    log.info(f'  Sharpe Ratio : {full_result.get("sharpe_ratio", 0):.3f}')
    log.info(f'  Net Return   : {full_result.get("net_return_pct", 0):.2f}%')
    log.info(f'  Trades       : {full_result.get("n_trades", 0)}')
    log.info(f'  Score        : {full_result.get("score", 0):.4f}')
    log.info(f'  Meets Criteria: {full_result.get("meets_criteria", False)}')
    log.info('═' * 60)

    return best_params


def run_live(params: Optional[dict] = None):
    """
    Live signal generation loop.
    Runs every 5 minutes, writes to shared/btc_supertrend_signal.json.
    """
    log.info('╔══════════════════════════════════════════════╗')
    log.info('║  BTC SuperTrend Enhanced — Live Signal Mode ║')
    log.info('╚══════════════════════════════════════════════╝')

    # Load params from file if not provided
    if params is None:
        if OPTIMIZED_FILE.exists():
            with open(OPTIMIZED_FILE) as f:
                data = json.load(f)
            params = data.get('best_params', {
                'atr_period': 10, 'multiplier': 3.0,
                'source': 'hl2', 'atr_method': 'rma',
                'primary_tf': '1H', 'mtf_tf': '4H',
            })
            log.info(f'Loaded params from {OPTIMIZED_FILE}')
        else:
            params = {
                'atr_period': 10, 'multiplier': 3.0,
                'source': 'hl2', 'atr_method': 'rma',
                'primary_tf': '1H', 'mtf_tf': '4H',
            }
            log.info('Using default params (Pine Script original)')

    log.info(f'Active params: ATR={params["atr_period"]} x{params["multiplier"]} '
             f'{params["source"]}/{params["atr_method"]} '
             f'TF={params.get("primary_tf","1H")}/{params.get("mtf_tf","4H")}')

    while True:
        try:
            signal = generate_signal(params)

            # Write to shared file
            with open(SIGNAL_FILE, 'w') as f:
                json.dump(signal, f, indent=2, default=str)

            # Log to stdout (PM2-visible)
            conf_bar = '█' * (signal['confidence'] // 10) + '░' * (10 - signal['confidence'] // 10)
            log.info(
                f"SIGNAL={signal['signal']:4s} | "
                f"conf={signal['confidence']:3d}% [{conf_bar}] | "
                f"price=${signal['price']:,.0f} | "
                f"RSI={signal.get('rsi', 'N/A')} | "
                f"vol_ok={signal['volume_ok']} | "
                f"MTF={signal['mtf_ok']} | "
                f"regime={signal['volatility_regime']} | "
                f"{'🔔NEW FLIP' if signal['is_new_flip'] else '↔️ continuation'}"
            )

        except Exception as e:
            log.error(f'Signal generation error: {e}', exc_info=True)
            try:
                error_signal = {
                    'signal': 'HOLD',
                    'confidence': 0,
                    'error': str(e),
                    'timestamp': datetime.now(timezone.utc).isoformat(),
                }
                with open(SIGNAL_FILE, 'w') as f:
                    json.dump(error_signal, f, indent=2)
            except:
                pass

        time.sleep(300)  # 5 minutes


# ═══════════════════════════════════════════════════════════════════════════════
# ENTRY POINT
# ═══════════════════════════════════════════════════════════════════════════════

if __name__ == '__main__':
    mode = sys.argv[1] if len(sys.argv) > 1 else 'optimize'

    if mode == 'optimize':
        # Run optimization then exit
        best_params = run_optimize_and_backtest()
        log.info('Optimization complete. Run with "live" to start signal generation.')

    elif mode == 'live':
        # Start live signal loop (for pm2)
        run_live()

    elif mode == 'all':
        # Optimize then start live loop
        best_params = run_optimize_and_backtest()
        log.info('Starting live signal generation...')
        run_live(best_params)

    else:
        print('Usage: python btc_supertrend_enhanced.py [optimize|live|all]')
        sys.exit(1)
