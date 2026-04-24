import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';

const SIDECAR = '/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json';
const JOURNAL = '/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json';

export async function GET() {
  let signals: any[] = [];
  let lastCycle: any = null;
  let allCycles: any[] = [];

  if (existsSync(SIDECAR)) {
    try { signals = JSON.parse(readFileSync(SIDECAR, 'utf-8')); } catch {}
  }
  if (existsSync(JOURNAL)) {
    try {
      allCycles = JSON.parse(readFileSync(JOURNAL, 'utf-8'));
      lastCycle = allCycles[allCycles.length - 1] || null;
    } catch {}
  }

  // Build "top watched" — tickers with highest score in sidecar
  const tickerScores: Record<string, { ticker: string; maxScore: number; latestTier: string; latestValue: string; flowCount: number; latestReasons: string[] }> = {};
  for (const s of signals.slice(0, 40)) {
    const t = s.ticker;
    if (!t) continue;
    if (!tickerScores[t]) {
      tickerScores[t] = { ticker: t, maxScore: 0, latestTier: s.tier || '', latestValue: s.flow_value_raw || '', flowCount: 0, latestReasons: s.reasons || [] };
    }
    tickerScores[t].flowCount += 1;
    if ((s.score || 0) > tickerScores[t].maxScore) {
      tickerScores[t].maxScore = s.score || 0;
      tickerScores[t].latestTier = s.tier || '';
      tickerScores[t].latestValue = s.flow_value_raw || '';
      tickerScores[t].latestReasons = s.reasons || [];
    }
  }
  const topWatched = Object.values(tickerScores)
    .sort((a, b) => b.maxScore - a.maxScore)
    .slice(0, 3);

  return NextResponse.json({
    signalsCount: signals.length,
    topWatched,
    recentSignals: signals.slice(0, 10),
    lastCycleTime: lastCycle?.cycle_time || null,
    lastCycleSummary: lastCycle?.cycle_summary || '',
    picksExecuted: (lastCycle?.raw_response?.picks || []),
    passedOn: (lastCycle?.raw_response?.passed_on || []),
    totalCycles: allCycles.length,
  });
}
