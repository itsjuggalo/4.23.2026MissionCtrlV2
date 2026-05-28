import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const DB = 'https://stock-signal-72772-default-rtdb.firebaseio.com';

let _cache: { data: any; ts: number } | null = null;
let _inflight: Promise<any> | null = null;
const CACHE_TTL = 15_000;

// Pull last N notifications from each Firebase mirror, merge, dedupe by key+title.
// Schema per record: { category: 'SCALP'|'SWING'|'LONGTERM', message, symbol, title }
// Key is unix timestamp.

async function pullSource(sourceName: string, node: string, limit = 50) {
  try {
    const url = `${DB}/${sourceName}/${node}.json?orderBy=%22%24key%22&limitToLast=${limit}`;
    const r = await fetch(url, { cache: 'no-store', signal: AbortSignal.timeout(6000) });
    if (!r.ok) return [];
    const data = await r.json();
    if (!data) return [];
    return Object.entries(data).map(([key, val]: [string, any]) => ({
      key,
      ts: parseInt(key, 10),
      source: sourceName,
      sourceGroup: sourceName.toLowerCase().includes('vivid') ? 'vivid' : 'name',
      category: (val?.category || '').toUpperCase(),
      message: val?.message || '',
      symbol: val?.symbol || '',
      title: val?.title || '',
      action: /:\s*BUY/i.test(val?.title || '') ? 'BUY'
            : /:\s*SELL/i.test(val?.title || '') ? 'SELL'
            : 'INFO',
    }));
  } catch {
    return [];
  }
}

async function fetchNotifications() {
  const sources = ['Name', 'Name2', 'Vivid', 'Vivid2'];
  const all = (await Promise.all(
    sources.map(s => pullSource(s, 'OptionNotifications', 50))
  )).flat();

  const seen = new Set<string>();
  const unique = all.filter(n => {
    const k = `${n.ts}|${n.title}`;
    if (seen.has(k)) return false;
    seen.add(k);
    return true;
  });
  unique.sort((a, b) => b.ts - a.ts);

  return {
    generated_at: new Date().toISOString(),
    total: unique.length,
    byTab: {
      scalps: unique.filter(n => n.category === 'SCALP'),
      swings: unique.filter(n => n.category === 'SWING'),
      leaps:  unique.filter(n => n.category === 'LONGTERM' || n.category === 'LEAP'),
    },
    all: unique.slice(0, 100),
  };
}

export async function GET() {
  try {
    if (_cache && Date.now() - _cache.ts < CACHE_TTL) {
      return NextResponse.json(_cache.data);
    }

    if (!_inflight) {
      _inflight = fetchNotifications()
        .then(data => { _cache = { data, ts: Date.now() }; return data; })
        .finally(() => { _inflight = null; });
    }

    const data = await _inflight;
    return NextResponse.json(data);
  } catch (err: unknown) {
    if (_cache) return NextResponse.json({ ..._cache.data, stale: true });
    return NextResponse.json({
      error: (err instanceof Error ? err.message : String(err)).slice(0, 200),
      byTab: { scalps: [], swings: [], leaps: [] },
      all: [],
    }, { status: 500 });
  }
}
