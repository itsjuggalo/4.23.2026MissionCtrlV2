'use client';

import { useMemo } from 'react';
import { generateSignals } from '@/lib/analysis/scanner';
import type { Signal } from '@/lib/types';
import type { MarketDataState } from './useMarketData';

export interface ScannerState {
  signals: Signal[];
  isLoading: boolean;
  cryptoError: string | null;
  stocksError: string | null;
}

const SYMBOL_TO_ASSET: Record<string, 'Crypto' | 'Stock'> = {
  'BTC/USDT': 'Crypto',
  'ETH/USDT': 'Crypto',
  'SOL/USDT': 'Crypto',
  'AVAX/USDT': 'Crypto',
  AAPL: 'Stock',
  NVDA: 'Stock',
  TSLA: 'Stock',
  MSFT: 'Stock',
};

export function useScanner(marketData: MarketDataState): ScannerState {
  const signals = useMemo<Signal[]>(() => {
    if (Object.keys(marketData.prices).length === 0) return [];

    const inputs = Object.values(marketData.prices).map((p) => ({
      symbol: p.symbol,
      asset: SYMBOL_TO_ASSET[p.symbol] ?? 'Stock',
      price: p.price,
      change24h: p.change24h,
    }));

    return generateSignals(inputs);
  }, [marketData.prices]);

  return {
    signals,
    isLoading: marketData.isLoading,
    cryptoError: marketData.cryptoError,
    stocksError: marketData.stocksError,
  };
}
