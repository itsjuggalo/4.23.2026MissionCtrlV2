import { NextRequest, NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';

export const dynamic = 'force-dynamic';

let _cache: { data: any; ts: number } | null = null;
let _inflight: Promise<any> | null = null;
const CACHE_TTL = 15_000;

const SIDECAR = '/home/itsju/mission-control/signal-receiver/data/scored_signals_recent.json';

interface PipelineEvent {
  ts: number;
  source: 'BOBA' | 'WHALE' | 'SIGNAL' | 'FLOW';
  label: string;
  message: string;
  color: string;
}

async function fetchPipelineFeed(req: NextRequest) {
  const FETCH_OPTS = { cache: 'no-store' as const, signal: AbortSignal.timeout(6000) };
  const base = req.nextUrl.origin;
  const events: PipelineEvent[] = [];
  const now = Date.now();
  const window6h = 6 * 60 * 60 * 1000;
  const window30m = 30 * 60 * 1000;

  const [actRes, liveRes, analystRes, flowRes] = await Promise.allSettled([
    fetch(`${base}/api/activity`, FETCH_OPTS).then(r => r.ok ? r.json() : null).catch(() => null),
    fetch(`${base}/api/live-signals`, FETCH_OPTS).then(r => r.ok ? r.json() : null).catch(() => null),
    fetch(`${base}/api/analyst-signals`, FETCH_OPTS).then(r => r.ok ? r.json() : null).catch(() => null),
    fetch(`${base}/api/options-flow`, FETCH_OPTS).then(r => r.ok ? r.json() : null).catch(() => null),
  ]);

  // BOBA from /api/activity
  const actD = actRes.status === 'fulfilled' ? actRes.value : null;
  if (actD) {
    const acts = Array.isArray(actD) ? actD : (actD?.activities || []);
    for (const a of acts.slice(0, 30)) {
      const t = new Date(a.time).getTime();
      if (!t || now - t > window6h) continue;
      events.push({ ts: t, source: 'BOBA', label: (a.agent || 'sys').toUpperCase(), message: a.action || a.detail || '', color: '#4fc3f7' });
    }
  }

  // WHALE from /api/live-signals (with direct sidecar fallback when self-fetch fails/times out)
  const liveD = liveRes.status === 'fulfilled' ? liveRes.value : null;
  let topWatched: any[] = liveD?.topWatched || [];
  if (topWatched.length === 0 && existsSync(SIDECAR)) {
    try {
      const signals: any[] = JSON.parse(readFileSync(SIDECAR, 'utf-8'));
      const scores: Record<string, any> = {};
      for (const s of signals.slice(0, 40)) {
        const t = s.ticker;
        if (!t) continue;
        if (!scores[t]) scores[t] = { ticker: t, maxScore: 0, latestTier: s.tier || '', latestValue: s.flow_value_raw || '', flowCount: 0 };
        scores[t].flowCount += 1;
        if ((s.score || 0) > scores[t].maxScore) {
          scores[t].maxScore = s.score || 0;
          scores[t].latestTier = s.tier || '';
          scores[t].latestValue = s.flow_value_raw || '';
        }
      }
      topWatched = Object.values(scores).sort((a: any, b: any) => b.maxScore - a.maxScore).slice(0, 3);
    } catch {}
  }
  for (const w of topWatched.slice(0, 5)) {
    events.push({ ts: now - 60000, source: 'WHALE', label: w.ticker || '?', message: `${w.latestTier || ''} ${w.latestValue || ''} \u00b7 ${w.flowCount || 0}x \u00b7 score ${w.maxScore || 0}`.trim(), color: '#ce93d8' });
  }

  // SIGNAL from /api/analyst-signals (last 30min open)
  const analystD = analystRes.status === 'fulfilled' ? analystRes.value : null;
  if (analystD) {
    const tabs = ['scalps', 'swings', 'leaps'] as const;
    for (const tab of tabs) {
      const open = analystD?.byTab?.[tab]?.open || [];
      for (const s of open.slice(0, 10)) {
        const ts = (s.ts || 0) * 1000;
        if (!ts || now - ts > window30m) continue;
        events.push({ ts, source: 'SIGNAL', label: s.ticker || s.symbol || '?', message: `New ${tab.slice(0, -1).toUpperCase()}: ${s.action || ''} ${s.contractName || s.option_symbol || ''}`.trim(), color: '#ffd600' });
      }
    }
  }

  // FLOW from /api/options-flow recent unusual ($250K+)
  const flowD = flowRes.status === 'fulfilled' ? flowRes.value : null;
  if (flowD) {
    const flows = (flowD?.flows || []).filter((f: any) => f.Volume > f.OI && f.Value >= 250000).sort((a: any, b: any) => (b.Time || 0) - (a.Time || 0)).slice(0, 8);
    for (const f of flows) {
      const ts = f.Time || 0;  // f.Time is already ms
      if (!ts || now - ts > window6h) continue;
      const tier = f.Value >= 1000000 ? 'WHALE' : f.Value >= 500000 ? 'BIG' : 'UNUSUAL';
      const fmtV = (n: number) => n >= 1000000 ? '$' + (n / 1000000).toFixed(1) + 'M' : '$' + (n / 1000).toFixed(0) + 'K';
      events.push({ ts, source: 'FLOW', label: f.Ticker || f.Symbol || '?', message: `${tier} ${fmtV(f.Value)} ${f.OptionType || ''} ${f.Strike || ''} \u00b7 V/OI ${(f.Volume / Math.max(f.OI, 1)).toFixed(1)}x`.trim(), color: '#ff9800' });
    }
  }

  events.sort((a, b) => b.ts - a.ts);
  return { events: events.slice(0, 30), count: events.length };
}

export async function GET(req: NextRequest) {
  try {
    if (_cache && Date.now() - _cache.ts < CACHE_TTL) {
      return NextResponse.json(_cache.data);
    }

    if (!_inflight) {
      _inflight = fetchPipelineFeed(req)
        .then(data => { _cache = { data, ts: Date.now() }; return data; })
        .finally(() => { _inflight = null; });
    }

    const data = await _inflight;
    return NextResponse.json(data);
  } catch (e) {
    if (_cache) return NextResponse.json({ ..._cache.data, stale: true });
    return NextResponse.json({ events: [], count: 0, error: String(e).slice(0, 200) }, { status: 500 });
  }
}
