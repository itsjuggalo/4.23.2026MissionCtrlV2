import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// Proxy to yfinance server (:3010/trends) which runs pytrends
const YFINANCE_SERVER = 'http://localhost:3010';

export async function GET(req: Request) {
  const url = new URL(req.url);
  const symbols = url.searchParams.get('symbols') || 'SPY,QQQ,NVDA,AAPL,TSLA';
  try {
    const res = await fetch(
      `${YFINANCE_SERVER}/trends?symbols=${encodeURIComponent(symbols)}`,
      { signal: AbortSignal.timeout(30000), cache: 'no-store' }
    );
    if (!res.ok) throw new Error(`yfinance-server ${res.status}`);
    return NextResponse.json(await res.json());
  } catch (e: any) {
    return NextResponse.json({ error: e?.message || 'trends unavailable' }, { status: 503 });
  }
}
