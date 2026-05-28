import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// ECB rates via frankfurter.app — free, no key, updates once/day
const CURRENCIES = 'EUR,GBP,JPY,CAD,AUD,CHF,CNY,MXN';

let _cache: { data: object; date: string } | null = null;

export async function GET() {
  const today = new Date().toISOString().slice(0, 10);
  if (_cache?.date === today) {
    return NextResponse.json({ ..._cache.data, cached: true });
  }

  try {
    const res = await fetch(
      `https://api.frankfurter.app/latest?from=USD&to=${CURRENCIES}`,
      { signal: AbortSignal.timeout(8000), cache: 'no-store' }
    );
    if (!res.ok) throw new Error(`frankfurter ${res.status}`);
    const d = await res.json();
    const payload = {
      base: 'USD',
      date: d.date,
      rates: d.rates,
      // Invert for "1 USD = X" display
      EUR: d.rates.EUR,
      GBP: d.rates.GBP,
      JPY: d.rates.JPY,
      CAD: d.rates.CAD,
      AUD: d.rates.AUD,
      CHF: d.rates.CHF,
      CNY: d.rates.CNY,
      MXN: d.rates.MXN,
      source: 'frankfurter-ecb',
      timestamp: new Date().toISOString(),
      cached: false,
    };
    _cache = { data: payload, date: today };
    return NextResponse.json(payload);
  } catch (e: any) {
    if (_cache) return NextResponse.json({ ..._cache.data, cached: true, stale: true });
    return NextResponse.json({ error: e?.message }, { status: 500 });
  }
}
