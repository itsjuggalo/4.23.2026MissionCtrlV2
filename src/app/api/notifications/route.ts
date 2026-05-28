import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const DB = 'https://stock-signal-72772-default-rtdb.firebaseio.com';

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

export async function GET() {
  try {
    const sources = ['Name', 'Name2', 'Vivid', 'Vivid2'];
    const all = (await Promise.all(
      sources.map(s => pullSource(s, 'OptionNotifications', 50))
    )).flat();

    // Dedupe by ts+title (same notification mirrored across sources)
    const seen = new Set<string>();
    const unique = all.filter(n => {
      const k = `${n.ts}|${n.title}`;
      if (seen.has(k)) return false;
      seen.add(k);
      return true;
    });

    // Sort newest-first
    unique.sort((a, b) => b.ts - a.ts);

    // Bucket by tab (scalps/swings/leaps) using category field
    const byTab = {
      scalps: unique.filter(n => n.category === 'SCALP'),
      swings: unique.filter(n => n.category === 'SWING'),
      leaps:  unique.filter(n => n.category === 'LONGTERM' || n.category === 'LEAP'),
    };

    return NextResponse.json({
      generated_at: new Date().toISOString(),
      total: unique.length,
      byTab,
      all: unique.slice(0, 100),
    });
  } catch (err: any) {
    return NextResponse.json({
      error: err?.message || 'unknown error',
      byTab: { scalps: [], swings: [], leaps: [] },
      all: [],
    }, { status: 500 });
  }
}
