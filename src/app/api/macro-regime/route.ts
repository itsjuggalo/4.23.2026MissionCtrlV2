import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// Cache for 60 seconds to avoid hammering external APIs
let CACHE: { ts: number; data: any } | null = null;
const TTL = 60_000;

const FINNHUB_KEY = process.env.FINNHUB_API_KEY || '';
const UA = 'Mozilla/5.0 (compatible; MissionControl/1.0)';

async function fetchFearGreed(): Promise<{ value: number; label: string; previousClose: number; oneWeekAgo: number; oneMonthAgo: number; oneYearAgo: number } | null> {
  try {
    const res = await fetch('https://production.dataviz.cnn.io/index/fearandgreed/graphdata', {
      headers: { 'User-Agent': UA, 'Accept': 'application/json' },
    });
    if (!res.ok) return null;
    const j = await res.json();
    const fg = j?.fear_and_greed;
    if (!fg) return null;
    return {
      value: Math.round(fg.score),
      label: String(fg.rating || '').toUpperCase(),
      previousClose: Math.round(fg.previous_close || 0),
      oneWeekAgo: Math.round(fg.previous_1_week || 0),
      oneMonthAgo: Math.round(fg.previous_1_month || 0),
      oneYearAgo: Math.round(fg.previous_1_year || 0),
    };
  } catch {
    return null;
  }
}

async function fetchYahooQuote(symbol: string): Promise<{ price: number; change: number; pct: number } | null> {
  try {
    const url = `https://query1.finance.yahoo.com/v8/finance/chart/${encodeURIComponent(symbol)}?interval=1d&range=5d`;
    const res = await fetch(url, { headers: { 'User-Agent': UA, 'Accept': 'application/json' } });
    if (!res.ok) return null;
    const j = await res.json();
    const result = j?.chart?.result?.[0];
    if (!result) return null;
    const meta = result.meta || {};
    const price = Number(meta.regularMarketPrice ?? 0);
    const prev = Number(meta.chartPreviousClose ?? meta.previousClose ?? price);
    const change = price - prev;
    const pct = prev !== 0 ? (change / prev) * 100 : 0;
    if (!Number.isFinite(price) || price === 0) return null;
    return { price, change, pct };
  } catch {
    return null;
  }
}

function computeRiskStance(args: { vix: number | null; fg: number | null; yieldSpread: number | null }): { label: string; color: string; score: number } {
  // Score components, each in [-1, +1] where +1 = risk-on, -1 = risk-off
  const parts: number[] = [];
  if (args.vix != null) {
    // VIX: <15 risk-on (+1), 15-20 mild (+0.5), 20-25 neutral (0), 25-30 risk-off (-0.5), 30+ panic (-1)
    if (args.vix < 15) parts.push(1);
    else if (args.vix < 20) parts.push(0.5);
    else if (args.vix < 25) parts.push(0);
    else if (args.vix < 30) parts.push(-0.5);
    else parts.push(-1);
  }
  if (args.fg != null) {
    // Fear & Greed: scale 0-100 -> -1 to +1, midpoint 50
    parts.push((args.fg - 50) / 50);
  }
  if (args.yieldSpread != null) {
    // Yield curve: positive = normal/risk-on, negative (inverted) = recession warning
    if (args.yieldSpread > 0.5) parts.push(0.5);
    else if (args.yieldSpread > 0) parts.push(0.2);
    else if (args.yieldSpread > -0.5) parts.push(-0.5);
    else parts.push(-1);
  }
  const score = parts.length ? parts.reduce((a, b) => a + b, 0) / parts.length : 0;
  let label: string, color: string;
  if (score > 0.4) { label = 'RISK ON'; color = '#66bb6a'; }
  else if (score > 0.1) { label = 'MILD RISK ON'; color = '#9ccc65'; }
  else if (score > -0.1) { label = 'NEUTRAL'; color = '#607d8b'; }
  else if (score > -0.4) { label = 'CAUTIOUS'; color = '#ff9800'; }
  else { label = 'RISK OFF'; color = '#ef5350'; }
  return { label, color, score: Math.round(score * 100) / 100 };
}

export async function GET() {
  if (CACHE && Date.now() - CACHE.ts < TTL) {
    return NextResponse.json(CACHE.data);
  }

  // Fetch in parallel: F&G, VIX, 10Y, 2Y
  const [fg, vixQ, tnxQ, irxQ] = await Promise.all([
    fetchFearGreed(),
    fetchYahooQuote('^VIX'),
    fetchYahooQuote('^TNX'),  // 10Y treasury yield (in tenths of a percent)
    fetchYahooQuote('^IRX'),  // 13-week T-bill (proxy short-term)
  ]);

  // Yahoo returns ^TNX directly as percent (e.g. 4.42 = 4.42%). Same for ^IRX.
  const tenY = tnxQ ? Math.round(tnxQ.price * 100) / 100 : null;
  const twoY = irxQ ? Math.round(irxQ.price * 100) / 100 : null;
  const yieldSpread = tenY != null && twoY != null ? Math.round((tenY - twoY) * 100) / 100 : null;

  const stance = computeRiskStance({
    vix: vixQ?.price ?? null,
    fg: fg?.value ?? null,
    yieldSpread,
  });

  const out = {
    ts: Date.now(),
    stance,
    vix: vixQ ? { level: Math.round(vixQ.price * 100) / 100, change: Math.round(vixQ.change * 100) / 100, pct: Math.round(vixQ.pct * 100) / 100 } : null,
    fearGreed: fg,
    yields: { tenY, twoY, spread: yieldSpread },
  };

  CACHE = { ts: Date.now(), data: out };
  return NextResponse.json(out);
}
