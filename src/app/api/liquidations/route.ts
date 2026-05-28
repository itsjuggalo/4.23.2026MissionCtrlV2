import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const JSONL = path.join(
  process.env.HOME || '/home/itsju',
  '.openclaw/workspace/state/liquidations/binance_liqs.jsonl'
);

interface LiqEvent {
  ts: number;
  symbol: string;
  side: string;
  price: number;
  qty: number;
  value: number;
}

export async function GET() {
  try {
    const raw = await readFile(JSONL, 'utf-8');
    const cutoffMs = Date.now() - 4 * 60 * 60 * 1000; // 4h window
    const events: LiqEvent[] = [];
    for (const line of raw.split('\n')) {
      if (!line.trim()) continue;
      try {
        const e = JSON.parse(line);
        if (typeof e.ts === 'number' && e.ts >= cutoffMs && /^[\x00-\x7F]+$/.test(e.symbol) && (e.symbol.endsWith('USDT') || e.symbol.endsWith('USDC'))) {
          events.push(e);
        }
      } catch { /* skip bad line */ }
    }

    let longLiq = 0, shortLiq = 0;
    const byCoin: Record<string, { long: number; short: number }> = {};
    const MIN = 1000;
    for (const e of events) {
      if (e.value < MIN) continue;
      const sym = e.symbol.replace(/USDT$|USDC$/, '');
      byCoin[sym] = byCoin[sym] || { long: 0, short: 0 };
      if (e.side === 'SELL') { longLiq += e.value; byCoin[sym].long += e.value; }
      else { shortLiq += e.value; byCoin[sym].short += e.value; }
    }

    const total = longLiq + shortLiq;
    const longPct = total > 0 ? (longLiq / total) * 100 : 50;
    const bias = longPct > 65 ? 'LONGS_WRECKED' : longPct < 35 ? 'SHORTS_WRECKED' : 'MIXED';

    const topCoins = Object.entries(byCoin)
      .map(([sym, v]) => ({ sym, total: v.long + v.short, long: v.long, short: v.short }))
      .sort((a, b) => b.total - a.total)
      .slice(0, 6);

    const largest = events
      .filter(e => /^[\x00-\x7F]+$/.test(e.symbol) && e.symbol.endsWith('USDT'))
      .sort((a, b) => b.value - a.value)
      .slice(0, 5)
      .map(e => ({ sym: e.symbol.replace('USDT', ''), side: e.side === 'SELL' ? 'LONG' : 'SHORT', value: e.value, price: e.price, ts: e.ts }));

    return NextResponse.json({
      window_hours: 4,
      events_total: events.length,
      long_liq: longLiq,
      short_liq: shortLiq,
      total,
      long_pct: longPct,
      bias,
      top_coins: topCoins,
      largest,
    }, { headers: { 'Cache-Control': 'no-store' } });
  } catch {
    return NextResponse.json({ window_hours: 4, events_total: 0, total: 0, bias: 'NO_DATA', top_coins: [], largest: [] }, { status: 200 });
  }
}