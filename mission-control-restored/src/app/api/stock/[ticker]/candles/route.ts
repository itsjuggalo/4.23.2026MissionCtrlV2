import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

const FINNHUB_KEY = process.env.FINNHUB_API_KEY || 'd70ov6hr01ql6rg044r0';
const FINNHUB = 'https://finnhub.io/api/v1';

const cache: Record<string, { data: any; expires: number }> = {};
// TF-aware cache: 1D refreshes every 60s, longer TFs every 5min
const CACHE_MS: Record<string, number> = {
  '1D': 60_000, '5D': 300_000, '1M': 300_000, '3M': 600_000,
  '6M': 600_000, '1Y': 3_600_000, '5Y': 3_600_000, 'YTD': 600_000, 'MAX': 3_600_000,
};

function tfToRange(tf: string): { res: string; from: number; to: number } {
  const now = Math.floor(Date.now() / 1000);
  const day = 86400;
  switch (tf) {
    case '1D':  return { res: '1',  from: now - day,       to: now };
    case '5D':  return { res: '15', from: now - 5 * day,   to: now };
    case '1M':  return { res: '60', from: now - 30 * day,  to: now };
    case '3M':  return { res: 'D',  from: now - 90 * day,  to: now };
    case '6M':  return { res: 'D',  from: now - 180 * day, to: now };
    case '1Y':  return { res: 'D',  from: now - 365 * day, to: now };
    case '5Y':  return { res: 'W',  from: now - 5 * 365 * day, to: now };
    case 'YTD': {
      const jan1 = Math.floor(new Date(new Date().getFullYear(), 0, 1).getTime() / 1000);
      return { res: 'D', from: jan1, to: now };
    }
    case 'MAX': return { res: 'W',  from: now - 20 * 365 * day, to: now };
    default:    return { res: '1',  from: now - day,       to: now };
  }
}

function tfToYfPeriod(tf: string): { period: string; interval: string } {
  switch (tf) {
    case '1D':  return { period: '1d',  interval: '1m' };
    case '5D':  return { period: '5d',  interval: '15m' };
    case '1M':  return { period: '1mo', interval: '60m' };
    case '3M':  return { period: '3mo', interval: '1d' };
    case '6M':  return { period: '6mo', interval: '1d' };
    case '1Y':  return { period: '1y',  interval: '1d' };
    case '5Y':  return { period: '5y',  interval: '1wk' };
    case 'YTD': return { period: 'ytd', interval: '1d' };
    case 'MAX': return { period: 'max', interval: '1mo' };
    default:    return { period: '1d',  interval: '1m' };
  }
}

function yfinanceCandles(ticker: string, tf: string): any {
  const { period, interval } = tfToYfPeriod(tf);
  try {
    const script = `
import yfinance as yf, json
try:
    t = yf.Ticker("${ticker}")
    h = t.history(period="${period}", interval="${interval}", auto_adjust=False, prepost=False)
    points = []
    for ts, row in h.iterrows():
        try:
            points.append({
                "t": int(ts.timestamp()),
                "c": float(row["Close"]),
            })
        except Exception:
            pass
    print(json.dumps({"points": points}))
except Exception as e:
    print(json.dumps({"points": [], "err": str(e)[:200]}))
`;
    const out = execSync(`python3 -c '${script.replace(/'/g, "'\\''")}' 2>/dev/null`, {
      timeout: 10000, encoding: 'utf-8', maxBuffer: 4 * 1024 * 1024,
    });
    return JSON.parse(out.trim());
  } catch {
    return { points: [] };
  }
}

export async function GET(
  req: Request,
  { params }: { params: Promise<{ ticker: string }> }
) {
  const { ticker: raw } = await params;
  const ticker = raw.toUpperCase();
  const url = new URL(req.url);
  const tf = (url.searchParams.get('tf') || '1D').toUpperCase();

  const cacheKey = `${ticker}_${tf}`;
  const cached = cache[cacheKey];
  if (cached && cached.expires > Date.now()) return NextResponse.json(cached.data);

  try {
    // Try Finnhub first
    const { res, from, to } = tfToRange(tf);
    const qs = new URLSearchParams({ symbol: ticker, resolution: res, from: String(from), to: String(to), token: FINNHUB_KEY });
    let points: { t: number; c: number }[] = [];

    try {
      const r = await fetch(`${FINNHUB}/stock/candle?${qs.toString()}`);
      if (r.ok) {
        const j = await r.json();
        if (j?.s === 'ok' && Array.isArray(j.t) && Array.isArray(j.c)) {
          points = j.t.map((ts: number, i: number) => ({ t: ts, c: j.c[i] }));
        }
      }
    } catch {}

    // Fall back to yfinance if Finnhub empty or denied (common for free tier on US stocks)
    let source = 'finnhub';
    if (points.length === 0) {
      const yf = yfinanceCandles(ticker, tf);
      points = yf.points || [];
      source = 'yfinance';
    }

    const data = { ticker, tf, points, source, fetchedAt: new Date().toISOString() };
    cache[cacheKey] = { data, expires: Date.now() + (CACHE_MS[tf] || 60_000) };
    return NextResponse.json(data);
  } catch (e) {
    return NextResponse.json({ ticker, tf, points: [], error: String(e).slice(0, 200) });
  }
}
