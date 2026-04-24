import type { NextRequest } from 'next/server';

const FINNHUB_KEY = process.env.NEXT_PUBLIC_FINNHUB_KEY ?? '';

export async function GET(request: NextRequest) {
  const { searchParams } = new URL(request.url);
  const symbol = searchParams.get('symbol') ?? '';

  const url = `https://finnhub.io/api/v1/quote?symbol=${encodeURIComponent(symbol)}&token=${FINNHUB_KEY}`;

  let res: Response;
  try {
    res = await fetch(url, { signal: AbortSignal.timeout(8000) });
  } catch (err) {
    return Response.json(
      { error: `Network error: ${err instanceof Error ? err.message : String(err)}` },
      { status: 502 }
    );
  }

  const data = await res.json();
  return Response.json(data, { status: res.status });
}
