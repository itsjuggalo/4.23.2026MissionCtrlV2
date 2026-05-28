import {NextResponse, NextRequest } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const DATA_DIR = '/home/itsju/.openclaw/data/best-options';

function todayET(): string {
  return new Intl.DateTimeFormat('en-CA', {
    timeZone: 'America/New_York', year: 'numeric', month: '2-digit', day: '2-digit'
  }).format(new Date());
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  const url = new URL(req.url);
  const date = url.searchParams.get('date') || todayET();
  const tier = url.searchParams.get('tier');
  const limit = parseInt(url.searchParams.get('limit') || '100', 10);
  if (!/^\d{4}-\d{2}-\d{2}$/.test(date)) {
    return NextResponse.json({ error: 'Invalid date format' }, { status: 400 });
  }
  const fp = path.join(DATA_DIR, `${date}.json`);
  try {
    const raw = await fs.readFile(fp, 'utf-8');
    const snap = JSON.parse(raw);
    let list = snap.sorted_by_premium || [];
    if (tier) list = list.filter((c: any) => c.tier === tier);
    list = list.slice(0, limit);
    return NextResponse.json({
      date: snap.date, last_run_at: snap.last_run_at, last_run_human: snap.last_run_human,
      total_contracts: snap.total_contracts, tier_counts: snap.tier_counts,
      highest_premium: snap.highest_premium, contracts: list,
    });
  } catch (e: any) {
    if (e.code === 'ENOENT') {
      try {
        const files = await fs.readdir(DATA_DIR);
        const dates = files.filter(f => /^\d{4}-\d{2}-\d{2}\.json$/.test(f))
          .map(f => f.replace('.json', '')).sort().reverse();
        if (dates.length) {
          // No snapshot for the requested date — serve the most recent one instead
          const latest = dates[0];
          const raw = await fs.readFile(path.join(DATA_DIR, `${latest}.json`), 'utf-8');
          const snap = JSON.parse(raw);
          let list = snap.sorted_by_premium || [];
          if (tier) list = list.filter((c: any) => c.tier === tier);
          list = list.slice(0, limit);
          return NextResponse.json({
            date: snap.date, requested_date: date, fallback: true,
            last_run_at: snap.last_run_at, last_run_human: snap.last_run_human,
            total_contracts: snap.total_contracts, tier_counts: snap.tier_counts,
            highest_premium: snap.highest_premium, available_dates: dates, contracts: list,
          });
        }
        return NextResponse.json({ date, error: 'No data', available_dates: [], contracts: [] }, { status: 404 });
      } catch { return NextResponse.json({ date, error: 'No data dir', contracts: [] }, { status: 404 }); }
    }
    return NextResponse.json({ date, error: String(e) }, { status: 500 });
  }
}