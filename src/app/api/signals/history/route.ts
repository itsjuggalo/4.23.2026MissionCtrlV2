import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../../lib/proxyToServeftp";

const HISTORY_FILE = '/home/itsju/mission-control/signal-receiver/data/signals_history.jsonl';

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;

  const { searchParams } = new URL(req.url);
  const ticker = (searchParams.get('ticker') || '').toUpperCase();
  const limit = parseInt(searchParams.get('limit') || '50', 10);

  try {
    const raw = await readFile(HISTORY_FILE, 'utf-8');
    const lines = raw.trim().split('\n').filter(Boolean);
    let signals = lines.map(line => {
      try { return JSON.parse(line); } catch { return null; }
    }).filter(Boolean);

    if (ticker) {
      signals = signals.filter((s: any) => (s.ticker || '').toUpperCase() === ticker);
    }

    return NextResponse.json(signals.slice(-limit));
  } catch {
    return NextResponse.json([]);
  }
}
