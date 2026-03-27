'use client';

import { useState, useEffect, useCallback, useRef } from 'react';

export interface AssetPrice {
  symbol: string;
  price: number;
  change24h: number;
}

export interface MarketDataState {
  prices: Record<string, AssetPrice>;
  cryptoError: string | null;
  stocksError: string | null;
  isLoading: boolean;
  lastUpdated: Date | null;
}

const COINGECKO_IDS = ['bitcoin', 'ethereum', 'solana', 'avalanche-2'] as const;
const COINGECKO_SYMBOL_MAP: Record<string, string> = {
  bitcoin: 'BTC/USDT',
  ethereum: 'ETH/USDT',
  solana: 'SOL/USDT',
  'avalanche-2': 'AVAX/USDT',
};

const STOCK_SYMBOLS = ['AAPL', 'NVDA', 'TSLA', 'MSFT'] as const;

type CoinGeckoResponse = Record<string, { usd: number; usd_24h_change: number }>;
type FinnhubResponse = { c: number; dp: number };

async function fetchCryptoPrices(): Promise<Record<string, AssetPrice>> {
  const ids = COINGECKO_IDS.join(',');
  const url = `/api/crypto?ids=${ids}&vs_currencies=usd&include_24hr_change=true`;
  let res: Response;
  try {
    res = await fetch(url, { signal: AbortSignal.timeout(8000) });
  } catch (err) {
    throw new Error(`Network error: ${err instanceof Error ? err.message : String(err)}`);
  }
  if (!res.ok) throw new Error(`CoinGecko responded with HTTP ${res.status}`);
  const data: CoinGeckoResponse = await res.json();

  const result: Record<string, AssetPrice> = {};
  for (const id of COINGECKO_IDS) {
    const entry = data[id];
    if (entry) {
      const sym = COINGECKO_SYMBOL_MAP[id];
      result[sym] = { symbol: sym, price: entry.usd, change24h: entry.usd_24h_change };
    }
  }
  if (Object.keys(result).length === 0) throw new Error('CoinGecko returned no price data');
  return result;
}

async function fetchStockPrice(symbol: string): Promise<AssetPrice> {
  let res: Response;
  try {
    const url = `/api/stocks?symbol=${symbol}`;
    res = await fetch(url, { signal: AbortSignal.timeout(8000) });
  } catch (err) {
    throw new Error(`Network error: ${err instanceof Error ? err.message : String(err)}`);
  }
  if (!res.ok) throw new Error(`Finnhub responded with HTTP ${res.status}`);
  const data: FinnhubResponse = await res.json();
  if (!data.c || data.c === 0) throw new Error(`No quote data returned for ${symbol}`);
  return { symbol, price: data.c, change24h: data.dp };
}

async function fetchAllStocks(): Promise<Record<string, AssetPrice>> {
  const results = await Promise.allSettled(
    STOCK_SYMBOLS.map((sym) => fetchStockPrice(sym))
  );

  const out: Record<string, AssetPrice> = {};
  const errors: string[] = [];

  results.forEach((r, i) => {
    if (r.status === 'fulfilled') {
      out[STOCK_SYMBOLS[i]] = r.value;
    } else {
      errors.push(`${STOCK_SYMBOLS[i]}: ${r.reason?.message ?? 'unknown'}`);
    }
  });

  // Only throw if we got nothing at all
  if (Object.keys(out).length === 0) {
    throw new Error(errors[0] ?? 'All stock quotes failed');
  }
  return out;
}

export function useMarketData(): MarketDataState {
  const pricesRef = useRef<Record<string, AssetPrice>>({});
  // Track whether the initial fetch for each source has settled
  const settledRef = useRef({ crypto: false, stocks: false });

  const [state, setState] = useState<MarketDataState>({
    prices: {},
    cryptoError: null,
    stocksError: null,
    isLoading: true,
    lastUpdated: null,
  });

  const checkLoading = useCallback(() => {
    return !settledRef.current.crypto || !settledRef.current.stocks;
  }, []);

  const refreshCrypto = useCallback(async () => {
    try {
      const crypto = await fetchCryptoPrices();
      pricesRef.current = { ...pricesRef.current, ...crypto };
      settledRef.current.crypto = true;
      setState((prev) => ({
        ...prev,
        prices: { ...pricesRef.current },
        cryptoError: null,
        isLoading: checkLoading(),
        lastUpdated: new Date(),
      }));
    } catch (err) {
      const message = err instanceof Error ? err.message : String(err);
      // Remove crypto prices from the map on error
      const next = { ...pricesRef.current };
      for (const sym of Object.values(COINGECKO_SYMBOL_MAP)) delete next[sym];
      pricesRef.current = next;
      settledRef.current.crypto = true;
      setState((prev) => ({
        ...prev,
        prices: { ...pricesRef.current },
        cryptoError: message,
        isLoading: checkLoading(),
      }));
    }
  }, [checkLoading]);

  const refreshStocks = useCallback(async () => {
    try {
      const stocks = await fetchAllStocks();
      pricesRef.current = { ...pricesRef.current, ...stocks };
      settledRef.current.stocks = true;
      setState((prev) => ({
        ...prev,
        prices: { ...pricesRef.current },
        stocksError: null,
        isLoading: checkLoading(),
        lastUpdated: new Date(),
      }));
    } catch (err) {
      const message = err instanceof Error ? err.message : String(err);
      const next = { ...pricesRef.current };
      for (const sym of STOCK_SYMBOLS) delete next[sym];
      pricesRef.current = next;
      settledRef.current.stocks = true;
      setState((prev) => ({
        ...prev,
        prices: { ...pricesRef.current },
        stocksError: message,
        isLoading: checkLoading(),
      }));
    }
  }, [checkLoading]);

  useEffect(() => {
    refreshCrypto();
    refreshStocks();

    const cryptoInterval = setInterval(refreshCrypto, 30_000);
    const stocksInterval = setInterval(refreshStocks, 60_000);

    return () => {
      clearInterval(cryptoInterval);
      clearInterval(stocksInterval);
    };
  }, [refreshCrypto, refreshStocks]);

  return state;
}
