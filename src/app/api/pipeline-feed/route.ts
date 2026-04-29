import { NextRequest, NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

interface PipelineEvent {
  ts: number;
  source: 'BOBA' | 'WHALE' | 'SIGNAL' | 'FLOW';
  label: string;
  message: string;
  color: string;
}

export async function GET(req: NextRequest) {
  const base = req.nextUrl.origin;
  const events: PipelineEvent[] = [];
  const now = Date.now();
  const window6h = 6 * 60 * 60 * 1000;
  const window30m = 30 * 60 * 1000;

  // BOBA from /api/activity
  try {
    const r = await fetch(`${base}/api/activity`, { cache: 'no-store' });
    if (r.ok) {
      const d = await r.json();
      const acts = Array.isArray(d) ? d : (d?.activities || []);
      for (const a of acts.slice(0, 30)) {
        const t = new Date(a.time).getTime();
        if (!t || now - t > window6h) continue;
        events.push({ ts: t, source: 'BOBA', label: (a.agent || 'sys').toUpperCase(), message: a.action || a.detail || '', color: '#4fc3f7' });
      }
    }
  } catch {}

  // WHALE from /api/live-signals
  try {
    const r = await fetch(`${base}/api/live-signals`, { cache: 'no-store' });
    if (r.ok) {
      const d = await r.json();
      for (const w of (d?.topWatched || []).slice(0, 5)) {
        events.push({ ts: now - 60000, source: 'WHALE', label: w.ticker || '?', message: `${w.latestTier || ''} ${w.latestValue || ''} \u00b7 ${w.flowCount || 0}x \u00b7 score ${w.maxScore || 0}`.trim(), color: '#ce93d8' });
      }
    }
  } catch {}

  // SIGNAL from /api/analyst-signals (last 30min open)
  try {
    const r = await fetch(`${base}/api/analyst-signals`, { cache: 'no-store' });
    if (r.ok) {
      const d = await r.json();
      const tabs = ['scalps', 'swings', 'leaps'] as const;
      for (const tab of tabs) {
        const open = d?.byTab?.[tab]?.open || [];
        for (const s of open.slice(0, 10)) {
          const ts = (s.ts || 0) * 1000;
          if (!ts || now - ts > window30m) continue;
          events.push({ ts, source: 'SIGNAL', label: s.ticker || s.symbol || '?', message: `New ${tab.slice(0, -1).toUpperCase()}: ${s.action || ''} ${s.contractName || s.option_symbol || ''}`.trim(), color: '#ffd600' });
        }
      }
    }
  } catch {}

  // FLOW from /api/options-flow recent unusual ($250K+)
  try {
    const r = await fetch(`${base}/api/options-flow`, { cache: 'no-store' });
    if (r.ok) {
      const d = await r.json();
      const flows = (d?.flows || []).filter((f: any) => f.Volume > f.OI && f.Value >= 250000).sort((a: any, b: any) => (b.Time || 0) - (a.Time || 0)).slice(0, 8);
      for (const f of flows) {
        const ts = (f.Time || 0) * 1000;
        if (!ts || now - ts > window6h) continue;
        const tier = f.Value >= 1000000 ? 'WHALE' : f.Value >= 500000 ? 'BIG' : 'UNUSUAL';
        const fmtV = (n: number) => n >= 1000000 ? '$' + (n / 1000000).toFixed(1) + 'M' : '$' + (n / 1000).toFixed(0) + 'K';
        events.push({ ts, source: 'FLOW', label: f.Ticker || f.Symbol || '?', message: `${tier} ${fmtV(f.Value)} ${f.OptionType || ''} ${f.Strike || ''} \u00b7 V/OI ${(f.Volume / Math.max(f.OI, 1)).toFixed(1)}x`.trim(), color: '#ff9800' });
      }
    }
  } catch {}

  events.sort((a, b) => b.ts - a.ts);
  return NextResponse.json({ events: events.slice(0, 30), count: events.length });
}
