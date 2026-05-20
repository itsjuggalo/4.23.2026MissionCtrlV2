import { NextResponse } from 'next/server';
import { execSync } from 'child_process';
import { proxyToServeftp } from '../../../../lib/proxyToServeftp';

const FINNHUB_KEY = process.env.FINNHUB_API_KEY || 'd70ov6hr01ql6rg044r0';
const FINNHUB = 'https://finnhub.io/api/v1';

const cache: Record<string, { data: any; expires: number }> = {};
const CACHE_MS = 60_000;

async function finnhub(path: string, params: Record<string, string> = {}): Promise<any> {
  const qs = new URLSearchParams({ ...params, token: FINNHUB_KEY }).toString();
  try {
    const res = await fetch(`${FINNHUB}${path}?${qs}`);
    if (!res.ok) return null;
    return await res.json();
  } catch {
    return null;
  }
}

// yfinance lives in an ephemeral uv venv, not in system python. The script
// at ~/scripts/stock-info.py has a PEP 723 dep block declaring yfinance.
// PATH prefix avoids Node's inherited Windows /mnt/c paths clobbering uv.
function yfinanceFetch(ticker: string): any {
  try {
    const safe = ticker.replace(/[^A-Z0-9.\-]/gi, '');
    const out = execSync(
      `PATH=/home/itsju/.local/bin:/usr/local/bin:/usr/bin:/bin /home/itsju/.local/bin/uv run /home/itsju/scripts/stock-info.py ${safe}`,
      { timeout: 20000, encoding: 'utf-8', maxBuffer: 4 * 1024 * 1024 },
    );
    return JSON.parse(out.trim());
  } catch {
    return {};
  }
}

export async function GET(
  _req: Request,
  { params }: { params: Promise<{ ticker: string }> }
) {
  const __proxied = await proxyToServeftp(_req); if (__proxied) return __proxied;
  const { ticker: raw } = await params;
  const ticker = raw.toUpperCase();

  const cached = cache[ticker];
  if (cached && cached.expires > Date.now()) return NextResponse.json(cached.data);

  try {
    const [quote, profile, metrics, yf] = await Promise.all([
      finnhub('/quote', { symbol: ticker }),
      finnhub('/stock/profile2', { symbol: ticker }),
      finnhub('/stock/metric', { symbol: ticker, metric: 'all' }),
      new Promise<any>((r) => { try { r(yfinanceFetch(ticker)); } catch { r({}); } }),
    ]);

    const m = metrics?.metric || {};

    // Prefer yfinance for regular close + after-hours (it tracks session state);
    // fall back to Finnhub /quote for current price.
    const regularPrice = yf.regularPrice ?? quote?.c ?? null;
    const regularChange = yf.regularChange ?? quote?.d ?? null;
    const regularChangePct = yf.regularChangePct ?? quote?.dp ?? null;
    const postPrice = yf.postPrice ?? null;
    const postChange = yf.postChange ?? null;
    const postChangePct = yf.postChangePct ?? null;

    const data = {
      ticker,
      name: profile?.name || ticker,
      logo: profile?.logo || '',
      industry: yf.industry || profile?.finnhubIndustry || '',
      exchange: yf.exchange || profile?.exchange || '',
      ipoDate: profile?.ipo || '',
      website: yf.website || profile?.weburl || '',
      description: yf.description || '',

      // Prices (dual)
      regularPrice, regularChange, regularChangePct,
      postPrice, postChange, postChangePct,

      // Stats
      open: yf.open ?? quote?.o ?? null,
      high: yf.dayHigh ?? quote?.h ?? null,
      low: yf.dayLow ?? quote?.l ?? null,
      prevClose: yf.prevClose ?? quote?.pc ?? null,
      volume: yf.volume ?? null,
      avgVol: yf.avgVol ?? (m['10DayAverageTradingVolume'] ? m['10DayAverageTradingVolume'] * 1_000_000 : null),
      marketCap: yf.marketCap ?? (profile?.marketCapitalization ? profile.marketCapitalization * 1_000_000 : null),
      pe: yf.pe ?? m['peNormalizedAnnual'] ?? m['peTTM'] ?? null,
      eps: yf.eps ?? m['epsTTM'] ?? m['epsAnnual'] ?? null,
      wk52High: yf.wk52High ?? m['52WeekHigh'] ?? null,
      wk52Low: yf.wk52Low ?? m['52WeekLow'] ?? null,
      bookValue: yf.bookValue ?? m['bookValuePerShareAnnual'] ?? null,

      // Technical Analysis
      rating: (() => {
        const rec = (yf.recommendation || '').toLowerCase();
        if (rec.includes('buy') || rec.includes('strong_buy')) return 'BUY';
        if (rec.includes('sell')) return 'SELL';
        if (rec) return 'HOLD';
        const dp = quote?.dp || 0;
        return dp > 1 ? 'BUY' : dp < -1 ? 'SELL' : 'HOLD';
      })(),
      targetPrice: yf.targetPrice ?? (regularPrice ? regularPrice * 1.12 : null),
      support: yf.wk52Low ? (yf.wk52Low + (regularPrice - yf.wk52Low) * 0.15) : null,
      resistance: yf.wk52High ?? null,
      stopLoss: regularPrice ? regularPrice * 0.92 : null,

      // Earnings
      earnings: yf.earnings || [],
      nextEarnings: yf.nextEarnings || null,

      fetchedAt: new Date().toISOString(),
    };

    cache[ticker] = { data, expires: Date.now() + CACHE_MS };
    return NextResponse.json(data);
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200), ticker }, { status: 500 });
  }
}
