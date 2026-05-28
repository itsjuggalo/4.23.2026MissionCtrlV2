import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// Proxy to yfinance server (:3010/pcr) — SPY put/call ratio computed from options OI
const YFINANCE_SERVER = 'http://localhost:3010';

export async function GET(req: Request) {
  const url = new URL(req.url);
  const ticker = url.searchParams.get('ticker') || 'SPY';
  try {
    const res = await fetch(
      `${YFINANCE_SERVER}/pcr?ticker=${encodeURIComponent(ticker)}`,
      { signal: AbortSignal.timeout(30000), cache: 'no-store' }
    );
    if (!res.ok) throw new Error(`yfinance-server ${res.status}`);
    return NextResponse.json(await res.json());
  } catch (e: any) {
    return NextResponse.json({ error: e?.message || 'pcr unavailable' }, { status: 503 });
  }
}
