import { NextRequest, NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';
export const revalidate = 0;
export const runtime = 'nodejs';

const FALLBACK = path.join(process.cwd(), 'public', 'kronos-forecast.json');
const SIDECAR = 'http://localhost:4711/forecast';
const GENERATE = 'http://localhost:4711/generate';

export async function GET(req: NextRequest) {
  const { searchParams } = req.nextUrl;
  const symbol = (searchParams.get('symbol') || searchParams.get('ticker') || '').toUpperCase().trim();
  const model = (searchParams.get('model') || '').toLowerCase().trim();

  if (symbol) {
    try {
      const url = `${SIDECAR}?symbol=${encodeURIComponent(symbol)}&model=${encodeURIComponent(model)}`;
      const r = await fetch(url, { cache: 'no-store', signal: AbortSignal.timeout(10000) });
      if (r.ok) {
        const data = await r.json();
        return NextResponse.json({ ...data, _via: 'sidecar', _model: model || data.model, _symbol: symbol });
      }
    } catch (_) {}
  }

  try {
    const txt = await readFile(FALLBACK, 'utf-8');
    const data = JSON.parse(txt);
    return NextResponse.json({ ...data, _file: 'fallback', _fallback: true, _requested_symbol: symbol || null });
  } catch (_) {}

  return NextResponse.json({ error: symbol ? `No forecast for ${symbol}` : 'No default forecast', symbol: symbol || null, missing: true }, { status: 404 });
}

// POST handler: trigger a new forecast generation via the sidecar
export async function POST(req: NextRequest) {
  const body = await req.json().catch(() => ({}));
  const ticker = (body.ticker || body.symbol || '').toUpperCase().trim();
  const model = (body.model || 'small').toLowerCase();
  if (!ticker) return NextResponse.json({ error: 'ticker required' }, { status: 400 });

  try {
    const r = await fetch(GENERATE, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ticker, model, source: 'vercel' }),
      cache: 'no-store',
      signal: AbortSignal.timeout(10000),
    });
    if (r.ok) {
      const data = await r.json();
      return NextResponse.json({ ...data, _via: 'sidecar' });
    }
  } catch (_) {}

  return NextResponse.json({ error: 'Failed to reach forecast service' }, { status: 502 });
}
