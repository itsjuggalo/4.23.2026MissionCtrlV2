/**
 * live-strategy-pulse-source.ts — shared data-collection logic for the live strategy pulse.
 *
 * Imported by BOTH:
 *   - src/app/api/live-strategy/route.ts (for reading current state)
 *   - scripts/ingest-livestrategy-pulse.mts (timer — writes to DB)
 *
 * No HTTP calls. No auth. Just reads local files/DBs.
 */

import Database from 'better-sqlite3';
import fs from 'fs';
import path from 'path';

const LIVE_DB_PATH = path.join(process.cwd(), 'data/live_trades.sqlite');
const TV_DB_PATH = path.join(process.cwd(), 'data/tv_webhook_log.sqlite');

export interface PulseData {
  fill_rate: number;
  drift_score: number;
  signal_total: number;
  ts_bucket: number; // floor(now_ms / 300_000) * 300_000
}

const BASELINE = {
  win_rate: 0.683,
  avg_profit_pct: 2.15,
  trades_per_month: 60 / 7.5,
  sharpe: 3.06,
  drawdown_pct: 0.39,
};

export async function collectPulse(): Promise<PulseData> {
  const now = Date.now();
  const ts_bucket = Math.floor(now / 300_000) * 300_000;

  let signalCounts: Record<string, number> = {};

  if (fs.existsSync(LIVE_DB_PATH)) {
    const db = new Database(LIVE_DB_PATH, { readonly: true });
    try {
      const since = new Date(now - 30 * 86400 * 1000).toISOString();
      const counts = db.prepare(
        `SELECT decision, COUNT(*) n FROM live_signals WHERE received_at >= ? GROUP BY decision`
      ).all(since) as { decision: string; n: number }[];
      signalCounts = Object.fromEntries(counts.map(c => [c.decision, c.n]));
    } finally {
      db.close();
    }
  }

  const submitted = signalCounts.submitted ?? 0;
  const rejected = signalCounts.rejected ?? 0;
  const total = Object.values(signalCounts).reduce((a, b) => a + b, 0);
  const fill_rate = submitted + rejected ? submitted / (submitted + rejected) : 1;

  const tradesPerDay = submitted / 30;
  const expectedPerDay = BASELINE.trades_per_month / 30;
  const freqRatio = expectedPerDay ? tradesPerDay / expectedPerDay : 0;

  let drift_score = 0;
  if (fill_rate < 0.95) drift_score += 3;
  if (fill_rate < 0.85) drift_score += 2;
  if (freqRatio < 0.3 || freqRatio > 2.5) drift_score += 2;

  return {
    fill_rate,
    drift_score,
    signal_total: total,
    ts_bucket,
  };
}

/**
 * Read timeseries data for the live strategy GET response.
 * Returns 30d daily buckets for fill_rate and drift_score.
 */
export function readPulseTimeseries(dashDb: Database.Database): {
  fill_rate_timeseries: Array<{ t: number; fill_rate: number }>;
  drift_timeseries: Array<{ t: number; drift_score: number }>;
  signal_timeseries: Array<{ t: number; signal_total: number }>;
} {
  const cutoff = Date.now() - 30 * 24 * 60 * 60 * 1000;

  try {
    const rows = dashDb.prepare(
      `SELECT ts, fill_rate, drift_score, signal_total
       FROM live_strategy_pulse WHERE ts >= ? ORDER BY ts ASC`
    ).all(cutoff) as Array<{ ts: number; fill_rate: number; drift_score: number; signal_total: number }>;

    return {
      fill_rate_timeseries: rows.map(r => ({ t: r.ts, fill_rate: r.fill_rate ?? 0 })),
      drift_timeseries: rows.map(r => ({ t: r.ts, drift_score: r.drift_score ?? 0 })),
      signal_timeseries: rows.map(r => ({ t: r.ts, signal_total: r.signal_total ?? 0 })),
    };
  } catch {
    return { fill_rate_timeseries: [], drift_timeseries: [], signal_timeseries: [] };
  }
}
