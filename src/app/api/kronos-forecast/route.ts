import { NextRequest, NextResponse } from 'next/server';
import { readFile, readdir, stat } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';

const FORECASTS_DIR = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts';
const FALLBACK = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecast.json';

async function findLatestForSymbol(symbol: string): Promise<string | null> {
  try {
    const files = await readdir(FORECASTS_DIR);
    const sym = symbol.toUpperCase();
    // Try base + variants stripped of USDT/USD
    const candidates = [sym];
    const stripped = sym.replace(/USDT?$/, '');
    if (stripped !== sym) candidates.push(stripped);
    if (sym === 'BTCUSDT' || sym === 'BTCUSD') candidates.push('BTC');
    if (sym === 'ETHUSDT' || sym === 'ETHUSD') candidates.push('ETH');

    let bestPath: string | null = null;
    let bestMtime = 0;
    for (const c of candidates) {
      // Match files starting with SYMBOL_ or SYMBOL.json exactly
      const matches = files.filter(f =>
        f.toUpperCase().startsWith(c + '_') || f.toUpperCase() === c + '.JSON'
      );
      for (const m of matches) {
        const fp = path.join(FORECASTS_DIR, m);
        try {
          const st = await stat(fp);
          if (st.mtimeMs > bestMtime) { bestMtime = st.mtimeMs; bestPath = fp; }
        } catch {}
      }
      if (bestPath) break; // prefer first matched candidate base
    }
    return bestPath;
  } catch { return null; }
}

export async function GET(req: NextRequest) {
  const symbol = (req.nextUrl.searchParams.get('symbol') || '').toUpperCase();
  if (symbol) {
    const fp = await findLatestForSymbol(symbol);
    if (fp) {
      try {
        const txt = await readFile(fp, 'utf-8');
        const data = JSON.parse(txt);
        return NextResponse.json({ ...data, _file: path.basename(fp) });
      } catch (e: any) {
        return NextResponse.json({ error: 'parse error: ' + e.message, symbol }, { status: 500 });
      }
    }
    // Symbol requested but no file — return 404 so frontend can offer to generate
    return NextResponse.json({ error: 'No forecast found for ' + symbol, symbol, missing: true }, { status: 404 });
  }
  // No symbol — fallback to default file
  try {
    const txt = await readFile(FALLBACK, 'utf-8');
    return NextResponse.json(JSON.parse(txt));
  } catch {
    return NextResponse.json({ error: 'No default forecast' }, { status: 404 });
  }
}
