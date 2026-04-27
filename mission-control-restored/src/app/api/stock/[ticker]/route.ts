import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

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

function yfinanceFetch(ticker: string): any {
  try {
    const script = `
import yfinance as yf, json, sys
try:
    t = yf.Ticker("${ticker}")
    info = t.info or {}
    # earnings history
    rows = []
    try:
        ed = t.earnings_dates
        if ed is not None:
            for ts, row in ed.head(10).iterrows():
                est = row.get("EPS Estimate")
                act = row.get("Reported EPS")
                rows.append({
                    "date": ts.strftime("%Y-%m-%d") if hasattr(ts, "strftime") else str(ts)[:10],
                    "est": float(est) if est is not None and str(est) != "nan" else None,
                    "act": float(act) if act is not None and str(act) != "nan" else None,
                })
    except Exception:
        pass
    # next earnings
    next_eps = None
    try:
        cal = t.calendar
        if cal and "Earnings Date" in cal:
            d = cal["Earnings Date"]
            if isinstance(d, list) and d:
                next_eps = str(d[0])[:10]
    except Exception:
        pass
    out = {
        "description": info.get("longBusinessSummary", ""),
        "exchange": info.get("exchange", ""),
        "industry": info.get("industry", "") or info.get("sector", ""),
        "website": info.get("website", ""),
        "marketCap": info.get("marketCap"),
        "pe": info.get("trailingPE"),
        "eps": info.get("trailingEps"),
        "avgVol": info.get("averageVolume"),
        "volume": info.get("volume"),
        "targetPrice": info.get("targetMeanPrice"),
        "recommendation": info.get("recommendationKey", ""),
        "wk52High": info.get("fiftyTwoWeekHigh"),
        "wk52Low": info.get("fiftyTwoWeekLow"),
        "bookValue": info.get("bookValue"),
        "open": info.get("open"),
        "dayHigh": info.get("dayHigh"),
        "dayLow": info.get("dayLow"),
        "prevClose": info.get("previousClose"),
        "regularPrice": info.get("regularMarketPrice"),
        "regularChange": info.get("regularMarketChange"),
        "regularChangePct": info.get("regularMarketChangePercent"),
        "postPrice": info.get("postMarketPrice"),
        "postChange": info.get("postMarketChange"),
        "postChangePct": info.get("postMarketChangePercent"),
        "earnings": rows,
        "nextEarnings": next_eps,
    }
    print(json.dumps(out, default=str))
except Exception as e:
    print(json.dumps({"err": str(e)[:200]}))
`;
    const out = execSync(`python3 -c '${script.replace(/'/g, "'\\''")}' 2>/dev/null`, {
      timeout: 10000,
      encoding: 'utf-8',
      maxBuffer: 2 * 1024 * 1024,
    });
    return JSON.parse(out.trim());
  } catch {
    return {};
  }
}

export async function GET(
  _req: Request,
  { params }: { params: Promise<{ ticker: string }> }
) {
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
