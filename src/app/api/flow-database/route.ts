import { NextResponse } from 'next/server';

// Proxy to the prod bridge service. The token never leaves the server.
const BRIDGE_URL = process.env.BRIDGE_URL || 'https://bridge.serveftp.com';
const BRIDGE_TOKEN = process.env.BRIDGE_TOKEN || '';

const ALLOWED_TABLES = new Set([
  'stats',
  'flow-alerts',
  'trade-signals',
  'notifications',
  'auto-trader-orders',
  'top-flow-tickers',
]);

export async function GET(request: Request) {
  if (!BRIDGE_TOKEN) {
    return NextResponse.json(
      { error: 'BRIDGE_TOKEN not configured on server. Add it to .env.local.' },
      { status: 500 }
    );
  }

  const url = new URL(request.url);
  const table = url.searchParams.get('table') || 'stats';

  if (!ALLOWED_TABLES.has(table)) {
    return NextResponse.json(
      { error: `unknown table: ${table}`, allowed: Array.from(ALLOWED_TABLES) },
      { status: 400 }
    );
  }

  // Forward whitelisted query params to the bridge
  const forward = new URLSearchParams();
  forward.set('token', BRIDGE_TOKEN);
  for (const key of ['limit', 'ticker', 'since', 'account']) {
    const v = url.searchParams.get(key);
    if (v) forward.set(key, v);
  }

  const upstream = `${BRIDGE_URL}/db/${table}?${forward.toString()}`;

  try {
    const r = await fetch(upstream, {
      method: 'GET',
      headers: { Accept: 'application/json' },
      cache: 'no-store',
      signal: AbortSignal.timeout(8000),
    });
    const text = await r.text();
    return new NextResponse(text, {
      status: r.status,
      headers: {
        'Content-Type': r.headers.get('Content-Type') || 'application/json',
        'Cache-Control': 'no-store',
      },
    });
  } catch (e: unknown) {
    return NextResponse.json(
      { error: `bridge fetch failed: ${(e instanceof Error ? e.message : String(e)).slice(0, 200)}`, upstream },
      { status: 502 }
    );
  }
}
