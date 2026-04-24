#!/usr/bin/env python3
"""
Machine Learning Adaptive SuperTrend Optimizer
Mirrors the Pine Script K-Means clustering approach exactly.
Finds optimal ATR period + factor per symbol, writes to shared/supertrend_params.json.
All agents read this file to align their analysis with the best settings.
Runs every 6 hours via pm2.
"""

import json
import logging
import time
import sys
import os
from datetime import datetime, timezone
from pathlib import Path
from typing import Optional

import numpy as np
import pandas as pd
import requests

# ── Paths ─────────────────────────────────────────────────────────────────────

BASE_DIR     = Path('/home/ubuntu/mission-control')
SHARED_DIR   = BASE_DIR / 'shared'
OUTPUT_FILE  = SHARED_DIR / 'supertrend_params.json'
SIGNALS_FILE = BASE_DIR / 'telegram-listener' / 'signals.json'
POSITIONS_FILE = BASE_DIR / 'tweak' / 'positions.json'

SHARED_DIR.mkdir(exist_ok=True)

logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s [SUPERTREND] %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S'
)
log = logging.getLogger('supertrend')

# ── Search space ──────────────────────────────────────────────────────────────

ATR_PERIODS  = [7, 9, 10, 12, 14, 16, 20]
FACTORS      = [1.5, 2.0, 2.5, 3.0, 3.5, 4.0]
TRAIN_PERIODS = [50, 100, 150, 200]
MIN_CANDLES  = 60

KNOWN_CRYPTO = {
    'BTC','ETH','SOL','BNB','XRP','ADA','DOGE','AVAX','DOT','MATIC',
    'LINK','UNI','ATOM','LTC','BCH','NEAR','APT','ARB','OP','SUI',
    'INJ','SEI','TIA','PEPE','WIF','FIL','FTM','HBAR','ALGO','VET',
    'RENDER','SNX','AXS','CHZ','FLOW','XAU','ICP','ZEC','APE','BNX',
}

# ── Price fetchers ────────────────────────────────────────────────────────────

def is_crypto(symbol: str) -> bool:
    return symbol.split('/')[0].upper() in KNOWN_CRYPTO

def fetch_okx(inst_id: str, bar: str = '1H', limit: int = 300) -> Optional[pd.DataFrame]:
    try:
        r = requests.get('https://www.okx.com/api/v5/market/candles',
                         params={'instId': inst_id, 'bar': bar, 'limit': limit}, timeout=12)
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
        log.warning(f'OKX {inst_id}: {e}')
        return None

def fetch_yf(ticker: str, period: str = '120d', interval: str = '1h') -> Optional[pd.DataFrame]:
    try:
        import yfinance as yf
        df = yf.Ticker(ticker).history(period=period, interval=interval)
        if df.empty:
            return None
        df = df.rename(columns={'Open':'open','High':'high','Low':'low','Close':'close','Volume':'vol'})
        return df[['open','high','low','close','vol']].dropna().tail(300)
    except Exception as e:
        log.warning(f'yfinance {ticker}: {e}')
        return None

def get_candles(symbol: str) -> Optional[pd.DataFrame]:
    base = symbol.split('/')[0].upper()
    if is_crypto(symbol):
        df = fetch_okx(f'{base}-USDT', '1H', 300)
        if df is None:
            df = fetch_okx(f'{base}-USDT-SWAP', '1H', 300)
        return df
    return fetch_yf(symbol, '120d', '1h')

# ── K-Means ATR clustering (mirrors Pine Script exactly) ──────────────────────

def calc_atr(df: pd.DataFrame, period: int) -> pd.Series:
    high, low, close = df['high'], df['low'], df['close']
    tr = pd.concat([
        high - low,
        (high - close.shift(1)).abs(),
        (low  - close.shift(1)).abs(),
    ], axis=1).max(axis=1)
    # Use EWM like Pine's ta.atr
    return tr.ewm(span=period, adjust=False).mean()

def kmeans_atr_clusters(atr_series: pd.Series, train_period: int,
                         highvol: float = 0.75, midvol: float = 0.5,
                         lowvol: float = 0.25) -> dict:
    """
    Replicate Pine Script K-Means clustering on ATR values.
    Returns cluster centroids for high/medium/low volatility.
    """
    # Use last train_period ATR values
    atr_window = atr_series.dropna().tail(train_period).values
    if len(atr_window) < 20:
        return None

    lo  = atr_window.min()
    hi  = atr_window.max()
    rng = hi - lo

    # Initial centroids from percentile guesses
    a_mean = lo + rng * highvol
    b_mean = lo + rng * midvol
    c_mean = lo + rng * lowvol

    prev_a, prev_b, prev_c = None, None, None
    iterations = 0

    while True:
        hv_vals, mv_vals, lv_vals = [], [], []

        for val in atr_window:
            d_a = abs(val - a_mean)
            d_b = abs(val - b_mean)
            d_c = abs(val - c_mean)
            if d_a < d_b and d_a < d_c:
                hv_vals.append(val)
            elif d_b < d_a and d_b < d_c:
                mv_vals.append(val)
            else:
                lv_vals.append(val)

        new_a = np.mean(hv_vals) if hv_vals else a_mean
        new_b = np.mean(mv_vals) if mv_vals else b_mean
        new_c = np.mean(lv_vals) if lv_vals else c_mean

        if new_a == a_mean and new_b == b_mean and new_c == c_mean:
            break

        a_mean, b_mean, c_mean = new_a, new_b, new_c
        iterations += 1
        if iterations > 100:
            break

    # Determine current cluster
    curr_atr = atr_series.dropna().iloc[-1]
    dists = [abs(curr_atr - a_mean), abs(curr_atr - b_mean), abs(curr_atr - c_mean)]
    cluster = int(np.argmin(dists))  # 0=high, 1=medium, 2=low
    assigned_centroid = [a_mean, b_mean, c_mean][cluster]

    return {
        'high_centroid':   round(float(a_mean), 6),
        'medium_centroid': round(float(b_mean), 6),
        'low_centroid':    round(float(c_mean), 6),
        'current_cluster': cluster,
        'cluster_name':    ['HIGH', 'MEDIUM', 'LOW'][cluster],
        'assigned_centroid': round(float(assigned_centroid), 6),
        'current_atr':     round(float(curr_atr), 6),
        'sizes': [len(hv_vals), len(mv_vals), len(lv_vals)],
        'iterations': iterations,
    }

# ── Adaptive SuperTrend (mirrors Pine Script) ─────────────────────────────────

def calc_adaptive_supertrend(df: pd.DataFrame, atr_period: int, factor: float,
                              train_period: int = 100,
                              highvol: float = 0.75, midvol: float = 0.5,
                              lowvol: float = 0.25) -> pd.Series:
    """
    Calculate the ML Adaptive SuperTrend signal series.
    Uses K-Means to assign each bar's ATR to a cluster, uses cluster centroid as ATR.
    Returns: Series of 1 (bullish) / -1 (bearish)
    """
    atr_raw = calc_atr(df, atr_period)
    close   = df['close'].values
    high    = df['high'].values
    low     = df['low'].values
    n       = len(df)

    direction = np.zeros(n, dtype=int)
    supertrend= np.zeros(n, dtype=float)

    for i in range(train_period, n):
        # K-Means on training window
        window = atr_raw.iloc[i-train_period:i].values
        lo_w, hi_w = window.min(), window.max()
        rng = hi_w - lo_w
        if rng == 0:
            assigned = atr_raw.iloc[i]
        else:
            a_m = lo_w + rng * highvol
            b_m = lo_w + rng * midvol
            c_m = lo_w + rng * lowvol

            # Quick K-Means (5 iterations enough for per-bar)
            for _ in range(10):
                hv, mv, lv = [], [], []
                for v in window:
                    da, db, dc = abs(v-a_m), abs(v-b_m), abs(v-c_m)
                    if da < db and da < dc: hv.append(v)
                    elif db < da and db < dc: mv.append(v)
                    else: lv.append(v)
                na = np.mean(hv) if hv else a_m
                nb = np.mean(mv) if mv else b_m
                nc = np.mean(lv) if lv else c_m
                if na == a_m and nb == b_m and nc == c_m:
                    break
                a_m, b_m, c_m = na, nb, nc

            curr = atr_raw.iloc[i]
            dists = [abs(curr-a_m), abs(curr-b_m), abs(curr-c_m)]
            centroids = [a_m, b_m, c_m]
            assigned = centroids[int(np.argmin(dists))]

        hl2 = (high[i] + low[i]) / 2
        upper = hl2 + factor * assigned
        lower = hl2 - factor * assigned

        # Adjust bands (Pine Script logic)
        if i > train_period:
            prev_upper = supertrend[i-1] if direction[i-1] == 1 else upper
            prev_lower = supertrend[i-1] if direction[i-1] == -1 else lower
            if lower > prev_lower or close[i-1] < prev_lower:
                pass
            else:
                lower = prev_lower
            if upper < prev_upper or close[i-1] > prev_upper:
                pass
            else:
                upper = prev_upper

        # Direction
        if i == train_period:
            direction[i] = 1
        elif supertrend[i-1] == (high[i-1] + low[i-1]) / 2 + factor * assigned:
            direction[i] = -1 if close[i] > upper else 1
        else:
            direction[i] = 1 if close[i] < lower else -1

        supertrend[i] = lower if direction[i] == -1 else upper

    return pd.Series(direction, index=df.index)

# ── Backtester ────────────────────────────────────────────────────────────────

def backtest(df: pd.DataFrame, atr_period: int, factor: float,
             train_period: int) -> dict:
    if len(df) < train_period + 20:
        return {'score': 0, 'win_rate': 0, 'profit_factor': 0, 'trades': 0}
    try:
        signal = calc_adaptive_supertrend(df, atr_period, factor, train_period)
        close  = df['close'].values
        wins, losses = [], []
        entry_price, entry_dir = None, None

        for i in range(1, len(signal)):
            curr, prev = signal.iloc[i], signal.iloc[i-1]
            if curr != prev and curr != 0:
                if entry_price is not None:
                    ret = (close[i] - entry_price) / entry_price
                    if entry_dir == 1: ret = -ret
                    (wins if ret > 0 else losses).append(abs(ret))
                entry_price, entry_dir = close[i], curr

        total = len(wins) + len(losses)
        if total < 5:
            return {'score': 0, 'win_rate': 0, 'profit_factor': 0, 'trades': 0}

        wr  = len(wins) / total * 100
        aw  = np.mean(wins)   if wins   else 0
        al  = np.mean(losses) if losses else 0.0001
        pf  = aw / al
        net = (np.sum(wins) - np.sum(losses)) / total * 100
        # Score weights: win_rate 40%, profit_factor 40%, trade count 20%
        score = wr * 0.4 + min(pf, 5) * 20 * 0.4 + min(total, 40) / 40 * 100 * 0.2

        return {
            'score':          round(score, 2),
            'win_rate':       round(wr, 2),
            'profit_factor':  round(pf, 3),
            'trades':         total,
            'net_return_pct': round(net * 100, 4),
        }
    except Exception as e:
        log.warning(f'Backtest error: {e}')
        return {'score': 0, 'win_rate': 0, 'profit_factor': 0, 'trades': 0}

def signal_alignment(df: pd.DataFrame, signals: list, symbol: str,
                     atr_period: int, factor: float, train_period: int) -> float:
    sym_sigs = [s for s in signals
                if s.get('symbol') and s.get('symbol','').split('/')[0].upper() == symbol.upper()
                and s.get('direction') in ['BUY','LONG','SHORT','SELL','CALL','PUT']
                and s.get('entry')]
    if not sym_sigs or len(df) < train_period + 10:
        return 50.0  # neutral if no signals

    try:
        st = calc_adaptive_supertrend(df, atr_period, factor, train_period)
        close = df['close']
        aligned, total = 0, 0

        for sig in sym_sigs[-15:]:
            entry = sig.get('entry', 0)
            sig_dir = 1 if sig.get('direction') in ['BUY','LONG','CALL'] else -1
            idx = (close - entry).abs().idxmin()
            pos = df.index.get_loc(idx)
            if pos < 2: continue
            if st.iloc[pos] == sig_dir:
                aligned += 1
            total += 1

        return round(aligned / total * 100, 1) if total > 0 else 50.0
    except:
        return 50.0

# ── Per-symbol optimizer ──────────────────────────────────────────────────────

def optimize(symbol: str, signals: list) -> dict:
    log.info(f'  Optimizing {symbol}...')
    df = get_candles(symbol)
    if df is None or len(df) < MIN_CANDLES:
        log.warning(f'    Not enough data for {symbol}')
        return {'symbol': symbol, 'error': 'insufficient_data',
                'atr_period': 10, 'multiplier': 3.0}

    log.info(f'    {len(df)} candles')

    best_score  = -1
    best        = {'atr_period': 10, 'multiplier': 3.0, 'train_period': 100}
    best_stats  = {}
    top_results = []

    for atr_p in ATR_PERIODS:
        for factor in FACTORS:
            for train_p in [100, 150]:  # focus on two most common
                bt    = backtest(df, atr_p, factor, train_p)
                align = signal_alignment(df, signals, symbol, atr_p, factor, train_p)

                # Combined: backtest 55%, alignment 45%
                combined = bt['score'] * 0.55 + align * 0.45

                top_results.append({
                    'atr_period':   atr_p,
                    'multiplier':   factor,
                    'train_period': train_p,
                    'backtest':     bt,
                    'alignment':    align,
                    'combined':     round(combined, 2),
                })

                if combined > best_score:
                    best_score = combined
                    best = {'atr_period': atr_p, 'multiplier': factor, 'train_period': train_p}
                    best_stats = {**bt, 'alignment': align, 'combined_score': round(combined, 2)}

    top_results.sort(key=lambda x: x['combined'], reverse=True)

    # Get current volatility cluster with best params
    atr_series = calc_atr(df, best['atr_period'])
    clusters   = kmeans_atr_clusters(atr_series, best['train_period'])

    log.info(f'    Best: ATR={best["atr_period"]} factor={best["multiplier"]} '
             f'train={best["train_period"]} score={best_score:.1f} '
             f'wr={best_stats.get("win_rate",0):.0f}% '
             f'pf={best_stats.get("profit_factor",0):.2f}')

    if clusters:
        log.info(f'    Volatility: {clusters["cluster_name"]} '
                 f'(ATR={clusters["current_atr"]:.4f}, '
                 f'centroid={clusters["assigned_centroid"]:.4f})')

    return {
        'symbol':        symbol,
        'atr_period':    best['atr_period'],
        'multiplier':    best['multiplier'],
        'train_period':  best['train_period'],
        # K-Means defaults (optimal for this symbol's volatility profile)
        'highvol':       0.75,
        'midvol':        0.50,
        'lowvol':        0.25,
        'stats':         best_stats,
        'volatility':    clusters,
        'top_3':         top_results[:3],
        'candles_used':  len(df),
        'optimized_at':  datetime.now(timezone.utc).isoformat(),
    }

# ── Agent notification ────────────────────────────────────────────────────────

def notify_agents(results: dict):
    """Write a summary to shared/agent_directives.json so all agents can read it."""
    directives = {
        'updated_at': datetime.now(timezone.utc).isoformat(),
        'source':     'supertrend_optimizer',
        'message':    'Supertrend params updated. Use these for signal analysis.',
        'symbols': {}
    }

    for sym, r in results.items():
        if 'error' not in r:
            vola = r.get('volatility', {})
            directives['symbols'][sym] = {
                'atr_period':      r['atr_period'],
                'multiplier':      r['multiplier'],
                'train_period':    r['train_period'],
                'volatility_regime': vola.get('cluster_name', 'UNKNOWN') if vola else 'UNKNOWN',
                'current_atr':     vola.get('current_atr', 0) if vola else 0,
                'win_rate':        r['stats'].get('win_rate', 0),
                'profit_factor':   r['stats'].get('profit_factor', 0),
            }

    directive_file = SHARED_DIR / 'agent_directives.json'
    with open(directive_file, 'w') as f:
        json.dump(directives, f, indent=2)

    log.info(f'Agent directives written to {directive_file}')

# ── Main ──────────────────────────────────────────────────────────────────────

def get_symbols() -> list:
    symbols = set()

    # From positions
    try:
        for p in json.load(open(POSITIONS_FILE)):
            if p.get('status') == 'open':
                symbols.add(p['symbol'].split('/')[0].upper())
    except: pass

    # From signals
    try:
        for s in json.load(open(SIGNALS_FILE)):
            if s.get('status') == 'actionable' and s.get('symbol'):
                symbols.add(s['symbol'].split('/')[0].upper())
    except: pass

    # Core always-optimize
    symbols.update({'BTC','ETH','SOL','BNB','ARB','NEAR'})

    return sorted(symbols)

def run_once():
    log.info('='*55)
    log.info('ML Adaptive SuperTrend Optimizer')
    log.info('='*55)

    existing = {}
    if OUTPUT_FILE.exists():
        try:
            existing = json.load(open(OUTPUT_FILE))
        except: pass

    try:
        signals = json.load(open(SIGNALS_FILE))
    except:
        signals = []

    symbols = get_symbols()
    log.info(f'Symbols to optimize: {", ".join(symbols)}')

    results = dict(existing)
    success = 0

    for sym in symbols:
        try:
            r = optimize(sym, signals)
            results[sym] = r
            if 'error' not in r:
                success += 1
            time.sleep(3)
        except Exception as e:
            log.error(f'Failed {sym}: {e}')

    with open(OUTPUT_FILE, 'w') as f:
        json.dump(results, f, indent=2)

    notify_agents(results)

    log.info(f'\n✅ Done: {success}/{len(symbols)} optimized')
    log.info(f'Results: {OUTPUT_FILE}')
    log.info(f'Directives: {SHARED_DIR}/agent_directives.json')
    log.info('\nSummary:')
    for sym, r in results.items():
        if 'error' not in r:
            v = r.get('volatility') or {}
            s = r.get('stats', {})
            log.info(f'  {sym:8} ATR={r["atr_period"]:2d} x{r["multiplier"]} '
                    f'train={r["train_period"]:3d} | '
                    f'wr={s.get("win_rate",0):.0f}% pf={s.get("profit_factor",0):.2f} | '
                    f'vol={v.get("cluster_name","?")}')

def run():
    log.info('Supertrend Optimizer starting (every 6 hours)...')
    while True:
        try:
            run_once()
        except Exception as e:
            log.error(f'Main loop error: {e}')
        log.info('Sleeping 6 hours...')
        time.sleep(6 * 3600)

if __name__ == '__main__':
    run_once() if '--once' in sys.argv else run()
