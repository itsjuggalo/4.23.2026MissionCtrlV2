import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";


const SECRETS = '/home/itsju/.openclaw/secrets';

async function readSecret(name: string): Promise<string> {
  try { return (await readFile(`${SECRETS}/${name}`, 'utf-8')).trim(); }
  catch { return ''; }
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    // R2 default account (paper)
    const keyId = await readSecret('alpaca-key-id');
    const keySecret = await readSecret('alpaca-secret');
    if (!keyId || !keySecret) {
      return NextResponse.json({ error: 'Missing Alpaca R2 credentials', bars: [] }, { status: 503 });
    }
    const url = 'https://paper-api.alpaca.markets/v2/account/portfolio/history?period=1D&timeframe=5Min&extended_hours=true';
    const r = await fetch(url, {
      headers: {
        'APCA-API-KEY-ID': keyId,
        'APCA-API-SECRET-KEY': keySecret,
      },
      cache: 'no-store',
      signal: AbortSignal.timeout(6000),
    });
    if (!r.ok) {
      const txt = await r.text();
      return NextResponse.json({ error: `Alpaca ${r.status}: ${txt.slice(0, 120)}`, bars: [] }, { status: 502 });
    }
    const d = await r.json();
    const ts: number[] = d.timestamp || [];
    const eq: number[] = d.equity || [];
    const bars = ts.map((t, i) => ({ t: t * 1000, eq: eq[i] }))
      .filter(b => b.eq !== null && b.eq !== undefined && !isNaN(b.eq));
    return NextResponse.json({ bars, base: d.base_value || 0, count: bars.length });
  } catch (e: any) {
    return NextResponse.json({ error: String(e), bars: [] }, { status: 500 });
  }
}