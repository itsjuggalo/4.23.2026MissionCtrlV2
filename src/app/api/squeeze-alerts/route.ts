import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const STATE_FILE = path.join(
  process.env.HOME || '/home/itsju',
  '.openclaw/workspace/state/squeeze_scanner_state.json'
);

export async function GET() {
  try {
    const raw = await readFile(STATE_FILE, 'utf-8');
    const data = JSON.parse(raw);
    const candidates = Object.entries(data).map(([ticker, v]: [string, any]) => ({
      ticker,
      score: v.score ?? 0,
      si_pct: v.si_pct ?? null,
      dtc: v.dtc ?? null,
      sweep: v.sweep ?? false,
      price: v.price ?? null,
      from_hi_pct: v.from_hi_pct ?? null,
      scanned_at: v.scanned_at ?? null,
      last_post: v.last_post ?? null,
    })).sort((a, b) => b.score - a.score);
    return NextResponse.json({ candidates, last_scan: candidates[0]?.last_post ?? null }, {
      headers: { 'Cache-Control': 'no-store' },
    });
  } catch {
    return NextResponse.json({ candidates: [], last_scan: null }, { status: 200 });
  }
}