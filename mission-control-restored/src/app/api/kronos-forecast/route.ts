import { NextResponse } from 'next/server';
import { readFileSync, existsSync, readdirSync, statSync } from 'fs';
import { join } from 'path';

const FORECAST_DIR = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts';
const LEGACY_FILE = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecast.json';

export async function GET(req: Request) {
  const url = new URL(req.url);
  const ticker = url.searchParams.get('ticker')?.toUpperCase();

  // Legacy behavior — no ticker = global forecast file
  if (!ticker) {
    if (!existsSync(LEGACY_FILE)) {
      return NextResponse.json({ error: 'No forecast available' }, { status: 404 });
    }
    try {
      return NextResponse.json(JSON.parse(readFileSync(LEGACY_FILE, 'utf-8')));
    } catch {
      return NextResponse.json({ error: 'Failed to read forecast' }, { status: 500 });
    }
  }

  // Per-ticker: find latest <TICKER>_<timestamp>.json
  if (!existsSync(FORECAST_DIR)) {
    return NextResponse.json({ error: 'No forecasts directory' }, { status: 404 });
  }

  try {
    const files = readdirSync(FORECAST_DIR)
      .filter(f => f.toUpperCase().startsWith(`${ticker}_`) && f.endsWith('.json'))
      .map(f => ({ f, m: statSync(join(FORECAST_DIR, f)).mtimeMs }))
      .sort((a, b) => b.m - a.m);

    if (files.length === 0) {
      return NextResponse.json({ error: `No forecast for ${ticker}`, ticker }, { status: 404 });
    }

    const latest = files[0];
    const content = JSON.parse(readFileSync(join(FORECAST_DIR, latest.f), 'utf-8'));
    return NextResponse.json({
      ...content,
      _filename: latest.f,
      _file_mtime: new Date(latest.m).toISOString(),
    });
  } catch (e: any) {
    return NextResponse.json({ error: e.message || 'Failed to read' }, { status: 500 });
  }
}

// POST triggers on-demand Kronos run
export async function POST(req: Request) {
  const { exec } = await import('child_process');
  const body = await req.json().catch(() => ({}));
  const ticker = (body.ticker || '').toString().toUpperCase().trim();

  if (!ticker || !/^[A-Z0-9]{1,10}$/.test(ticker)) {
    return NextResponse.json({ error: 'Invalid ticker' }, { status: 400 });
  }

  return new Promise((resolve) => {
    exec(
      `python3 /home/ubuntu/mission-control/agent-team/kronos/kronos_on_demand.py --ticker ${ticker}`,
      { timeout: 120000 },
      (err, stdout, stderr) => {
        if (err) {
          resolve(NextResponse.json({ error: stderr || err.message, stdout }, { status: 500 }));
        } else {
          resolve(NextResponse.json({ ok: true, ticker, output: stdout.slice(-500) }));
        }
      }
    );
  });
}
