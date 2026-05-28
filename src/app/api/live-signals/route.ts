import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import Database from 'better-sqlite3';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';

const SIDECAR = '/home/itsju/mission-control/signal-receiver/data/scored_signals_recent.json';
const JOURNAL = '/home/itsju/.openclaw/workspace/skill_outputs/boba_decisions_validated.json';
const PIPELINE_DB = '/home/itsju/LapClaw/pipeline/desk_pipeline.sqlite';
const FIREBASE_FLOW = 'https://stock-signal-72772-default-rtdb.firebaseio.com/FlowGreeks/LiveFlowLast100.json';
const STALE_MS = 8 * 60 * 60 * 1000;

async function latestFirebaseFlowTime(): Promise<string | null> {
  try {
    const r = await fetch(FIREBASE_FLOW, { cache: 'no-store', signal: AbortSignal.timeout(4000) });
    if (!r.ok) return null;
    const raw = await r.json();
    if (!raw) return null;
    // Firebase keys are ms timestamps; values may also carry a Time field
    const entries: [string, any][] = Array.isArray(raw)
      ? raw.map((v: any, i: number) => [String(i), v])
      : Object.entries(raw);
    let maxTime = 0;
    for (const [key, f] of entries) {
      const t = parseInt(key) || (f as any)?.Time || 0;
      if (t > maxTime) maxTime = t;
    }
    return maxTime > 0 ? new Date(maxTime).toISOString() : null;
  } catch {
    return null;
  }
}

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

  // Determine lastCycleTime — prefer journal; fall back to desk-cycle pipeline
  // then Firebase flow feed when journal is stale (>8h).
  let lastCycleTime: string | null = lastCycle?.cycle_time || null;
  const journalAge = lastCycleTime ? Date.now() - new Date(lastCycleTime).getTime() : Infinity;
  if (journalAge > STALE_MS) {
    // Secondary fallback: desk-cycle pipeline (local SQLite, no network dependency)
    try {
      const db = new Database(PIPELINE_DB, { readonly: true, fileMustExist: true });
      const row = db.prepare(
        `SELECT completed_at FROM cycle_metadata WHERE status='complete' ORDER BY completed_at DESC LIMIT 1`
      ).get() as { completed_at: string } | undefined;
      db.close();
      if (row?.completed_at) {
        const pipelineAge = Date.now() - new Date(row.completed_at).getTime();
        if (pipelineAge < journalAge) lastCycleTime = row.completed_at;
      }
    } catch {}
    // Tertiary fallback: live Firebase flow feed
    const currentAge = lastCycleTime ? Date.now() - new Date(lastCycleTime).getTime() : Infinity;
    if (currentAge > STALE_MS) {
      const fbTime = await latestFirebaseFlowTime();
      if (fbTime) lastCycleTime = fbTime;
    }
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
    lastCycleTime,
    lastCycleSummary: lastCycle?.cycle_summary || '',
    picksExecuted: (lastCycle?.raw_response?.picks || []),
    passedOn: (lastCycle?.raw_response?.passed_on || []),
    totalCycles: allCycles.length,
  });
}