import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

interface CoinData { usd: number; usd_24h_change: number; usd_market_cap?: number; usd_24h_vol?: number; }

function getCmcKey(): string {
  return process.env.COINMARKETCAP_API_KEY || '';
}

// CoinMarketCap — primary source (300 calls/day free tier)
async function fetchCmc(): Promise<Record<string, CoinData> | null> {
  const key = getCmcKey();
  if (!key) return null;
  try {
    const res = await fetch(
      'https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETH,SOL,DOGE&convert=USD',
      {
        headers: { 'X-CMC_PRO_API_KEY': key, Accept: 'application/json' },
        signal: AbortSignal.timeout(8000),
        cache: 'no-store',
      }
    );
    if (!res.ok) return null;
    const json = await res.json();
    const d = json?.data;
    if (!d) return null;
    const map: Record<string, CoinData> = {};
    for (const [sym, entry] of Object.entries(d) as [string, any][]) {
      const q = entry?.quote?.USD;
      map[sym] = {
        usd: q?.price ?? 0,
        usd_24h_change: q?.percent_change_24h ?? 0,
        usd_market_cap: q?.market_cap ?? 0,
        usd_24h_vol: q?.volume_24h ?? 0,
      };
    }
    return map;
  } catch { return null; }
}

// Coinbase — fallback (free, no key needed)
async function fetchCoinbase(symbol: string): Promise<CoinData> {
  try {
    const [spot, stats] = await Promise.all([
      fetch(`https://api.coinbase.com/v2/prices/${symbol}-USD/spot`, { signal: AbortSignal.timeout(6000) }).then(r => r.ok ? r.json() : null).catch(() => null),
      fetch(`https://api.exchange.coinbase.com/products/${symbol}-USD/stats`, { signal: AbortSignal.timeout(6000) }).then(r => r.ok ? r.json() : null).catch(() => null),
    ]);
    const price = parseFloat(spot?.data?.amount || '0');
    const open = parseFloat(stats?.open || '0');
    const change = open > 0 ? ((price - open) / open) * 100 : 0;
    return { usd: price, usd_24h_change: change };
  } catch {
    return { usd: 0, usd_24h_change: 0 };
  }
}

export async function GET() {
  try {
    // Try CMC first; fall back to Coinbase per-coin if CMC fails
    const cmc = await fetchCmc();

    const [bitcoin, ethereum, solana, dogecoin] = cmc
      ? [cmc.BTC, cmc.ETH, cmc.SOL, cmc.DOGE]
      : await Promise.all([
          fetchCoinbase('BTC'),
          fetchCoinbase('ETH'),
          fetchCoinbase('SOL'),
          fetchCoinbase('DOGE'),
        ]);

    return NextResponse.json({
      // CoinGecko-style keys for DashboardPage
      bitcoin, ethereum, solana, dogecoin,
      // Legacy uppercase keys for ScannerPage
      BTC: { price: bitcoin?.usd ?? 0, symbol: 'BTC' },
      ETH: { price: ethereum?.usd ?? 0, symbol: 'ETH' },
      SOL: { price: solana?.usd ?? 0, symbol: 'SOL' },
      DOGE: { price: dogecoin?.usd ?? 0, symbol: 'DOGE' },
      source: cmc ? 'coinmarketcap' : 'coinbase',
      timestamp: new Date().toISOString(),
    });
  } catch (e) {
    // Surface total upstream failure instead of masking it as a 200: log it so
    // HEAL/monitoring can scrape it, and return 502 with an error field so the
    // dashboard (and any health check) can tell "all sources down" apart from a
    // successful response.
    console.error('[crypto] all sources failed:', e instanceof Error ? e.message : e);
    return NextResponse.json({ source: 'error', error: 'crypto fetch failed' }, { status: 502 });
  }
}
