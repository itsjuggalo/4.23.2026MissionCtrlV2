#!/usr/bin/env node
/**
 * drift-check.ts — compares recent live signal/trade distribution against the
 * PullbackTrend_1h_swing backtest benchmark. Run via:
 *   npx tsx scripts/drift-check.ts
 *
 * Spec: docs/live-monitoring-spec.md §2 (drift metrics)
 */
import Database from 'better-sqlite3';
import path from 'path';

const ROOT = path.dirname(__dirname);
const TV_DB = path.join(ROOT, 'data/tv_webhook_log.sqlite');
const LIVE_DB = path.join(ROOT, 'data/live_trades.sqlite');

// Benchmark from PullbackTrend_1h_swing OOS Oct-2025 → May-2026
const BASELINE = {
  win_rate: 0.683,
  avg_profit_pct: 2.15,
  trades_per_month: 60 / 7.5,
  sharpe: 3.06,
};

const THRESHOLDS = {
  wr_warn_delta_pp: 15,        // warn if rolling 20-trade WR < baseline - 15pp = ~53%
  wr_critical_delta_pp: 25,    // critical < baseline - 25pp = ~43%
  wr_kill_delta_pp: 35,        // hard-kill < baseline - 35pp = ~33%
  fill_rate_warn: 0.95,
  fill_rate_critical: 0.85,
  fill_rate_kill: 0.50,
  drift_score_warn: 5,
  drift_score_critical: 7,
  drift_score_kill: 9,
};

interface Signal {
  id: number;
  received_at: string;
  bar_time: string;
  strategy: string;
  account: string;
  symbol: string;
  action: string;
  decision: string;
  suppression_reason: string | null;
  rejection_reason: string | null;
}

function loadRecentSignals(days: number): Signal[] {
  const db = new Database(LIVE_DB, { readonly: true });
  try {
    const since = new Date(Date.now() - days * 86400 * 1000).toISOString();
    return db.prepare(`
      SELECT id, received_at, bar_time, strategy, account, symbol, action,
             decision, suppression_reason, rejection_reason
      FROM live_signals
      WHERE received_at >= ?
      ORDER BY received_at DESC
    `).all(since) as Signal[];
  } finally {
    db.close();
  }
}

function fmt(n: number, digits = 2): string {
  return Number.isFinite(n) ? n.toFixed(digits) : '—';
}

function pct(n: number, total: number): string {
  if (!total) return 'n/a';
  return `${((n / total) * 100).toFixed(1)}%`;
}

function severity(value: number, warn: number, critical: number, kill: number, lowerIsWorse = true): string {
  if (lowerIsWorse) {
    if (value < kill) return '🔴 KILL';
    if (value < critical) return '🟠 CRITICAL';
    if (value < warn) return '🟡 WARN';
  } else {
    if (value > kill) return '🔴 KILL';
    if (value > critical) return '🟠 CRITICAL';
    if (value > warn) return '🟡 WARN';
  }
  return '🟢 OK';
}

function main() {
  const days = Number(process.argv[2] ?? 30);
  const signals = loadRecentSignals(days);

  console.log(`\n=== Drift check — last ${days} days ===\n`);
  console.log(`Live signals seen: ${signals.length}`);

  if (signals.length === 0) {
    console.log('No live signals to compare. (Strategy may not have fired yet.)');
    return;
  }

  // 1. Decision breakdown
  const decisions: Record<string, number> = {};
  for (const s of signals) decisions[s.decision] = (decisions[s.decision] ?? 0) + 1;
  console.log('\nDecision breakdown:');
  for (const [d, n] of Object.entries(decisions).sort((a, b) => b[1] - a[1])) {
    console.log(`  ${d.padEnd(12)} ${String(n).padStart(4)}  (${pct(n, signals.length)})`);
  }

  // 2. Fill rate = submitted / (submitted + rejected) — excludes suppressed/dry-run/dupe
  const submitted = decisions.submitted ?? 0;
  const rejected = decisions.rejected ?? 0;
  const fillRate = submitted + rejected ? submitted / (submitted + rejected) : 1.0;
  console.log(`\nFill rate: ${pct(submitted, submitted + rejected)}  ${severity(fillRate, THRESHOLDS.fill_rate_warn, THRESHOLDS.fill_rate_critical, THRESHOLDS.fill_rate_kill, true)}`);

  // 3. Trade frequency vs expected
  const tradesPerDay = signals.filter(s => s.decision === 'submitted').length / days;
  const expectedPerDay = BASELINE.trades_per_month / 30;
  const freqRatio = tradesPerDay / expectedPerDay;
  console.log(`\nTrade frequency: ${fmt(tradesPerDay)}/day  (expected ${fmt(expectedPerDay)}/day, ratio ${fmt(freqRatio)})`);
  if (freqRatio < 0.3) console.log('  🟠 Live trading much less than backtest — may indicate Pine not firing or gates over-restrictive');
  else if (freqRatio > 2.5) console.log('  🟠 Live trading much more than backtest — Pine may have repaint or wrong timeframe');

  // 4. Per-pair distribution (where are signals concentrating?)
  const bySymbol: Record<string, number> = {};
  for (const s of signals.filter(x => x.decision === 'submitted')) {
    bySymbol[s.symbol] = (bySymbol[s.symbol] ?? 0) + 1;
  }
  if (Object.keys(bySymbol).length) {
    console.log('\nPer-symbol submitted breakdown:');
    for (const [sym, n] of Object.entries(bySymbol).sort((a, b) => b[1] - a[1])) {
      console.log(`  ${sym.padEnd(12)} ${String(n).padStart(4)}`);
    }
  }

  // 5. Suppression reasons (why did the webhook block alerts?)
  const supReasons: Record<string, number> = {};
  for (const s of signals.filter(x => x.decision === 'suppressed' && x.suppression_reason)) {
    supReasons[s.suppression_reason!] = (supReasons[s.suppression_reason!] ?? 0) + 1;
  }
  if (Object.keys(supReasons).length) {
    console.log('\nSuppression reasons:');
    for (const [r, n] of Object.entries(supReasons).sort((a, b) => b[1] - a[1])) {
      console.log(`  ${r.padEnd(24)} ${String(n).padStart(4)}`);
    }
  }

  // 6. Drift score (0–10 composite, rough heuristic)
  let drift = 0;
  if (fillRate < THRESHOLDS.fill_rate_warn) drift += 3;
  if (fillRate < THRESHOLDS.fill_rate_critical) drift += 2;
  if (freqRatio < 0.3 || freqRatio > 2.5) drift += 2;
  if ((supReasons['kill_switch'] ?? 0) > submitted) drift += 1;
  if ((supReasons['account_not_allowed'] ?? 0) > 0) drift += 1;
  if ((supReasons['symbol_unsupported'] ?? 0) > 0) drift += 1;

  console.log(`\nDrift score: ${drift}/10  ${severity(drift, THRESHOLDS.drift_score_warn, THRESHOLDS.drift_score_critical, THRESHOLDS.drift_score_kill, false)}`);
  console.log(`\nBaseline expectation: ~${fmt(BASELINE.win_rate * 100, 0)}% WR, +${fmt(BASELINE.avg_profit_pct, 1)}% avg profit, Sharpe ${fmt(BASELINE.sharpe, 1)}`);
  console.log('(Win-rate + Sharpe live comparison requires Alpaca fill polling — TODO Phase 2)\n');
}

main();
