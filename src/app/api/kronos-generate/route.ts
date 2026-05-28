import { NextRequest, NextResponse } from 'next/server';
import { spawn } from 'child_process';

export async function GET() {
  return NextResponse.json({ status: 'ok', endpoint: 'kronos-generate', note: 'POST only — use POST with {ticker}' });
}

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

  // Proxy fallback: when running on Vercel, the local spawn won't work (no Python).
  // Try openclaw first; only fall through to local spawn if proxy unreachable.
  try {
    const proxyR = await fetch('https://claudeclaw.serveftp.com/api/kronos-generate', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ticker, model: body.model || 'small', source: 'vercel' }),
      cache: 'no-store',
      signal: AbortSignal.timeout(10000),
    });
    if (proxyR.ok) {
      const data = await proxyR.json();
      return NextResponse.json({ ...data, _via: 'proxy' });
    }
  } catch (_) {}

  // Spawn in background, fire-and-forget
  try {
    const child = spawn('python3', ['/home/itsju/scripts/kronos_forecast_v2.py', '--ticker', scriptTicker, '--model', body.model || 'small'], {
      detached: true,
      stdio: 'ignore',
      cwd: '/home/itsju',
    });
    child.unref();
    return NextResponse.json({ status: 'generating', ticker: scriptTicker, pid: child.pid });
  } catch (e: unknown) {
    return NextResponse.json({ error: String(e) }, { status: 500 });
  }
}
