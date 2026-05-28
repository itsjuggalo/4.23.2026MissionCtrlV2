import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

async function fetchOne(symbol: string) {
  try {
    const [spot, stats] = await Promise.all([
      fetch(`https://api.coinbase.com/v2/prices/${symbol}-USD/spot`, { signal: AbortSignal.timeout(6000) }).then(r => r.json()).catch(() => null),
      fetch(`https://api.exchange.coinbase.com/products/${symbol}-USD/stats`, { signal: AbortSignal.timeout(6000) }).then(r => r.json()).catch(() => null),
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
    const [bitcoin, ethereum, solana, dogecoin] = await Promise.all([
      fetchOne('BTC'),
      fetchOne('ETH'),
      fetchOne('SOL'),
      fetchOne('DOGE'),
    ]);
    return NextResponse.json({
      // CoinGecko-style keys for DashboardPage
      bitcoin, ethereum, solana, dogecoin,
      // Legacy uppercase keys for ScannerPage
      BTC: { price: bitcoin.usd, symbol: 'BTC' },
      ETH: { price: ethereum.usd, symbol: 'ETH' },
      SOL: { price: solana.usd, symbol: 'SOL' },
      DOGE: { price: dogecoin.usd, symbol: 'DOGE' },
      timestamp: new Date().toISOString(),
    });
  } catch {
    return NextResponse.json({});
  }
}
