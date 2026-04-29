import { NextRequest, NextResponse } from 'next/server';
import { readFile, readdir } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';

const FORECASTS_DIR = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts';
const FALLBACK = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecast.json';

export async function GET(req: NextRequest) {
  const symbol = req.nextUrl.searchParams.get('symbol') || '';
  const tryFiles: string[] = [];
  if (symbol) {
    const sym = symbol.toUpperCase();
    tryFiles.push(path.join(FORECASTS_DIR, `${sym}.json`));
    tryFiles.push(path.join(FORECASTS_DIR, `${sym}_forecast.json`));
    // Try without USDT/USD suffix variations
    const stripped = sym.replace(/USDT?$/, '');
    if (stripped !== sym) {
      tryFiles.push(path.join(FORECASTS_DIR, `${stripped}.json`));
      tryFiles.push(path.join(FORECASTS_DIR, `${stripped}USD.json`));
      tryFiles.push(path.join(FORECASTS_DIR, `${stripped}USDT.json`));
    }
  }
  tryFiles.push(FALLBACK);
  for (const f of tryFiles) {
    try {
      const txt = await readFile(f, 'utf-8');
      return NextResponse.json(JSON.parse(txt));
    } catch {}
  }
  return NextResponse.json({ error: 'No forecast found', symbol }, { status: 404 });
}
