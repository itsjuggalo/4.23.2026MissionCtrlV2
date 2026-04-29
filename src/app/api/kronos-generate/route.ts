import { NextRequest, NextResponse } from 'next/server';
import { spawn } from 'child_process';

export const dynamic = 'force-dynamic';

export async function POST(req: NextRequest) {
  const body = await req.json().catch(() => ({}));
  const ticker = (body.ticker || '').toUpperCase().trim();
  if (!ticker) return NextResponse.json({ error: 'ticker required' }, { status: 400 });
  if (!/^[A-Z0-9]{1,10}$/.test(ticker.replace(/USDT?$/, ''))) {
    return NextResponse.json({ error: 'invalid ticker' }, { status: 400 });
  }
  // Map common crypto suffixes to bare symbol expected by script
  let scriptTicker = ticker;
  if (ticker === 'BTCUSDT' || ticker === 'BTCUSD') scriptTicker = 'BTC';
  if (ticker === 'ETHUSDT' || ticker === 'ETHUSD') scriptTicker = 'ETH';

  // Spawn in background, fire-and-forget
  try {
    const child = spawn('python3', ['/home/ubuntu/scripts/kronos_forecast_v2.py', '--ticker', scriptTicker], {
      detached: true,
      stdio: 'ignore',
      cwd: '/home/ubuntu',
    });
    child.unref();
    return NextResponse.json({ status: 'generating', ticker: scriptTicker, pid: child.pid });
  } catch (e: any) {
    return NextResponse.json({ error: String(e) }, { status: 500 });
  }
}
