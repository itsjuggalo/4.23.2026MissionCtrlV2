import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';

export const dynamic = 'force-dynamic';

async function readSecret(name: string): Promise<string> {
  const p = path.join(process.env.HOME || '/home/ubuntu', '.openclaw', 'secrets', name);
  return (await fs.readFile(p, 'utf-8')).trim();
}

export async function GET() {
  try {
    const keyId = await readSecret('alpaca-key-id');
    const keySecret = await readSecret('alpaca-key-secret');
    const url = 'https://api.alpaca.markets/v2/account/portfolio/history?period=1D&timeframe=5Min&extended_hours=true';
    const r = await fetch(url, {
      headers: {
        'APCA-API-KEY-ID': keyId,
        'APCA-API-SECRET-KEY': keySecret,
      },
      cache: 'no-store',
    });
    if (!r.ok) {
      return NextResponse.json({ error: `Alpaca ${r.status}`, bars: [] }, { status: 200 });
    }
    const d = await r.json();
    const ts: number[] = d.timestamp || [];
    const eq: number[] = d.equity || [];
    const bars = ts.map((t, i) => ({ t: t * 1000, eq: eq[i] })).filter(b => b.eq !== null && b.eq !== undefined && !isNaN(b.eq));
    return NextResponse.json({ bars, base: d.base_value || 0, count: bars.length });
  } catch (e: any) {
    return NextResponse.json({ error: String(e), bars: [] }, { status: 200 });
  }
}
