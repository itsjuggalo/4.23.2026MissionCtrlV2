#!/usr/bin/env python3
"""
read_freqtrade_ohlc.py — reads Freqtrade's feather cache for a pair and writes JSON.

Usage: python3 read_freqtrade_ohlc.py --pair BTC/USDT --out data/ohlc_cache/BTC_USDT-1h.json

Source: ~/LapClaw/freqtrade/user_data/data/binanceus/<PAIR>-1h.feather
Output: JSON array of {t: unix_ms_1h_boundary, close: float}

Called by: scripts/ingest-livestrategy-pulse.mts (timer-side only)
NOT called from request path (R3.M3).
"""

import argparse
import json
import os
import sys
from pathlib import Path

FREQTRADE_DATA = Path('/home/itsju/LapClaw/freqtrade/user_data/data/binanceus')
MAX_BARS = 200
HISTORY_DAYS = int(os.environ.get('MISSIONCTRL_LS_HISTORY_DAYS', '7'))


def main():
    parser = argparse.ArgumentParser(description='Read Freqtrade OHLC feather cache')
    parser.add_argument('--pair', required=True, help='Pair (e.g. BTC/USDT)')
    parser.add_argument('--out', required=True, help='Output JSON file path')
    args = parser.parse_args()

    pair = args.pair
    out_path = Path(args.out)

    # Build the feather filename: BTC/USDT → BTC_USDT-1h.feather
    safe_pair = pair.replace('/', '_')
    feather_path = FREQTRADE_DATA / f'{safe_pair}-1h.feather'

    if not feather_path.exists():
        print(f'[ohlc] Feather not found: {feather_path}', file=sys.stderr)
        sys.exit(1)

    try:
        import pandas as pd

        df = pd.read_feather(feather_path)

        # Expected columns: date, open, high, low, close, volume
        if 'close' not in df.columns:
            print(f'[ohlc] No "close" column in {feather_path}', file=sys.stderr)
            sys.exit(1)

        # Filter to trailing HISTORY_DAYS
        cutoff_ms = (pd.Timestamp.now() - pd.Timedelta(days=HISTORY_DAYS)).timestamp() * 1000
        if 'date' in df.columns:
            df['ts_ms'] = pd.to_datetime(df['date']).astype('int64') // 1_000_000
        elif df.index.dtype.kind == 'M':
            df['ts_ms'] = df.index.astype('int64') // 1_000_000
        else:
            # Use positional index as fallback
            df['ts_ms'] = df.index * 3_600_000

        df = df[df['ts_ms'] >= cutoff_ms].tail(MAX_BARS)

        # Snap to 1h boundaries
        df['t'] = (df['ts_ms'] // 3_600_000) * 3_600_000

        bars = df[['t', 'close']].rename(columns={'close': 'close'}).to_dict(orient='records')

        # Ensure output directory exists
        out_path.parent.mkdir(parents=True, exist_ok=True)
        with open(out_path, 'w') as f:
            json.dump(bars, f)

        print(f'[ohlc] Wrote {len(bars)} bars for {pair} → {out_path}')

    except ImportError:
        print('[ohlc] pandas not available — install pandas to enable OHLC reading', file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        print(f'[ohlc] Error reading {feather_path}: {e}', file=sys.stderr)
        sys.exit(1)


if __name__ == '__main__':
    main()
