import type { NextRequest } from 'next/server';
import fs from 'fs';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const FINNHUB_KEY = (() => {
  const env = process.env.FINNHUB_KEY || process.env.NEXT_PUBLIC_FINNHUB_KEY;
  if (env) return env;
  try { return fs.readFileSync('/home/itsju/.openclaw/secrets/finnhub.key', 'utf-8').trim(); }
  catch { return ''; }
})();

export async function GET(request: NextRequest) {
  const { searchParams } = new URL(request.url);
  const symbol = searchParams.get('symbol') ?? '';

  const url = `https://finnhub.io/api/v1/quote?symbol=${encodeURIComponent(symbol)}&token=${FINNHUB_KEY}`;

  let res: Response;
  try {
    res = await fetch(url, { signal: AbortSignal.timeout(6000) });
  } catch (err) {
    return Response.json(
      { error: `Network error: ${err instanceof Error ? err.message : String(err)}` },
      { status: 502 }
    );
  }

  let data: unknown;
  try { data = await res.json(); }
  catch { data = { error: 'Invalid response from upstream' }; }
  return Response.json(data, { status: res.ok ? res.status : 502 });
}
