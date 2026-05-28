import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const SECRETS = '/home/itsju/.openclaw/secrets';

let _cache: { data: any; ts: number } | null = null;
let _inflight: Promise<any> | null = null;
const CACHE_TTL = 60_000;

async function readSecret(name: string): Promise<string> {
  try { return (await readFile(`${SECRETS}/${name}`, 'utf-8')).trim(); }
  catch { return ''; }
}

async function fetchIntraday() {
  const keyId = await readSecret('alpaca-key-id');
  const keySecret = await readSecret('alpaca-secret');
  if (!keyId || !keySecret) throw new Error('Missing Alpaca R2 credentials');
  const url = 'https://paper-api.alpaca.markets/v2/account/portfolio/history?period=1D&timeframe=5Min&extended_hours=true';
  const r = await fetch(url, {
    headers: { 'APCA-API-KEY-ID': keyId, 'APCA-API-SECRET-KEY': keySecret },
    cache: 'no-store',
    signal: AbortSignal.timeout(6000),
  });
  if (!r.ok) {
    const txt = await r.text();
    throw new Error(`Alpaca ${r.status}: ${txt.slice(0, 120)}`);
  }
  const d = await r.json();
  const ts: number[] = d.timestamp || [];
  const eq: number[] = d.equity || [];
  const bars = ts.map((t, i) => ({ t: t * 1000, eq: eq[i] }))
    .filter(b => b.eq !== null && b.eq !== undefined && !isNaN(b.eq));
  return { bars, base: d.base_value || 0, count: bars.length };
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    if (_cache && Date.now() - _cache.ts < CACHE_TTL) {
      return NextResponse.json(_cache.data);
    }

    if (!_inflight) {
      _inflight = fetchIntraday()
        .then(data => { _cache = { data, ts: Date.now() }; return data; })
        .finally(() => { _inflight = null; });
    }

    const data = await _inflight;
    return NextResponse.json(data);
  } catch (e: unknown) {
    if (_cache) return NextResponse.json({ ..._cache.data, stale: true });
    return NextResponse.json({ error: String(e).slice(0, 200), bars: [] }, { status: 500 });
  }
}
