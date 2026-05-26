/**
 * ingest-livestrategy-pulse.mts — scheduled job for live strategy pulse + OHLC refresh.
 *
 * Called by: mc-livestrategy-pulse.timer (every 5 min, persistent=true)
 * Does NOT call /api/live-strategy over HTTP (R3.H2 — would need auth).
 * Instead imports collectPulse() directly.
 *
 * Jobs per tick:
 * 1. collectPulse() → upsert live_strategy_pulse row (idempotent bucket key)
 * 2. Refresh OHLC cache per pair (Python helper, 10s timeout, max 2 parallel)
 * 3. Bucket-gap detection → Discord webhook if >3 consecutive missing buckets
 * 4. reconcileRuns() sweep
 */

import { collectPulse } from '../src/lib/live-strategy-pulse-source.ts';
import { dbTelemetryWrite, dbRead } from '../src/lib/dashboard-db.ts';
import { reconcileRuns } from '../src/lib/reconcile-runs.ts';
import { spawn } from 'child_process';
import fs from 'fs';
import path from 'path';

const OHLC_CACHE_DIR = path.join(process.cwd(), 'data/ohlc_cache');
const OHLC_SCRIPT = path.join(process.cwd(), 'scripts/read_freqtrade_ohlc.py');
const MAX_PAIRS = parseInt(process.env.MISSIONCTRL_LS_MAX_PAIRS ?? '20', 10);
const MAX_PARALLEL = 2;
const SPAWN_TIMEOUT_MS = 10_000;
const BOT_DIAG_PATH = path.join(process.cwd(), 'data/alpaca_bot_status.json');

// Track consecutive spawn failures per pair (in-memory for single run)
const spawnFailures: Record<string, number> = {};

async function fireDiscordWebhook(message: string): Promise<void> {
  const webhookUrl = process.env.MISSIONCTRL_OPS_WEBHOOK;
  if (!webhookUrl) return;
  try {
    await fetch(webhookUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ content: message }),
    });
  } catch (err) {
    console.error('[pulse] Discord webhook failed:', err);
  }
}

function getPairs(): string[] {
  try {
    if (!fs.existsSync(BOT_DIAG_PATH)) return [];
    const raw = fs.readFileSync(BOT_DIAG_PATH, 'utf-8');
    const bs = JSON.parse(raw) as Record<string, unknown>;
    if (Array.isArray(bs.pairs)) {
      return (bs.pairs as unknown[])
        .filter((p): p is string => typeof p === 'string' && /^[A-Z0-9]{2,10}\/(USDT|USDC|USD|BTC|ETH)$/.test(p))
        .slice(0, MAX_PAIRS);
    }
    return [];
  } catch {
    return [];
  }
}

function refreshPairOhlc(pair: string): Promise<boolean> {
  return new Promise(resolve => {
    const safeName = pair.replace('/', '_');
    const outPath = path.join(OHLC_CACHE_DIR, `${safeName}-1h.json`);

    if (!fs.existsSync(OHLC_SCRIPT)) {
      console.warn(`[pulse] OHLC script not found: ${OHLC_SCRIPT}`);
      resolve(false);
      return;
    }

    const timer = setTimeout(() => {
      try { child.kill('SIGKILL'); } catch {}
      console.warn(`[pulse] OHLC spawn timed out for ${pair}`);
      resolve(false);
    }, SPAWN_TIMEOUT_MS);

    const child = spawn('python3', [OHLC_SCRIPT, '--pair', pair, '--out', outPath], {
      env: { ...process.env },
    });

    child.on('close', code => {
      clearTimeout(timer);
      if (code !== 0) {
        console.warn(`[pulse] OHLC spawn failed for ${pair} (exit ${code})`);
        spawnFailures[pair] = (spawnFailures[pair] ?? 0) + 1;
        resolve(false);
      } else {
        spawnFailures[pair] = 0;
        resolve(true);
      }
    });

    child.on('error', err => {
      clearTimeout(timer);
      console.error(`[pulse] OHLC spawn error for ${pair}:`, err);
      spawnFailures[pair] = (spawnFailures[pair] ?? 0) + 1;
      resolve(false);
    });
  });
}

async function refreshOhlcCaches(pairs: string[]): Promise<void> {
  if (!fs.existsSync(OHLC_CACHE_DIR)) {
    fs.mkdirSync(OHLC_CACHE_DIR, { recursive: true });
  }

  // Process in batches of MAX_PARALLEL
  for (let i = 0; i < pairs.length; i += MAX_PARALLEL) {
    const batch = pairs.slice(i, i + MAX_PARALLEL);
    await Promise.all(batch.map(refreshPairOhlc));

    // Check for 3+ consecutive failures → Discord alert
    for (const pair of batch) {
      if ((spawnFailures[pair] ?? 0) >= 3) {
        await fireDiscordWebhook(
          `[mc-ohlc] OHLC refresh failed 3+ consecutive times for ${pair}.\n` +
          `Check: journalctl --user -u mc-livestrategy-pulse -n 20`
        );
      }
    }
  }
}

async function checkBucketGaps(): Promise<void> {
  const now = Date.now();
  const hourAgo = now - 60 * 60 * 1000;
  const expectedBuckets = 12; // 1h / 5min

  const presentCount = dbRead(db =>
    (db.prepare('SELECT COUNT(*) AS n FROM live_strategy_pulse WHERE ts >= ?').get(hourAgo) as { n: number } | undefined)?.n ?? 0
  ) ?? 0;

  const missing = Math.max(0, expectedBuckets - presentCount);

  if (missing > 3) {
    await fireDiscordWebhook(
      `[mc-pulse] ${missing} buckets missing since ${new Date(hourAgo).toISOString()}\n` +
      `Expected: ${expectedBuckets}, present: ${presentCount}\n` +
      `Check: journalctl --user -u mc-livestrategy-pulse -n 20`
    );
  }
}

async function main(): Promise<void> {
  // Check feature flag
  if (process.env.MISSIONCTRL_LS_TIMER_ENABLED === 'false') {
    console.log('[pulse] MISSIONCTRL_LS_TIMER_ENABLED=false — exiting');
    process.exit(0);
  }

  console.log('[pulse] Starting tick at', new Date().toISOString());

  try {
    // 1. Collect pulse + upsert (idempotent by PRIMARY KEY = bucket ts)
    const pulse = await collectPulse();
    dbTelemetryWrite(db => {
      db.prepare(
        `INSERT OR REPLACE INTO live_strategy_pulse (ts, fill_rate, drift_score, signal_total)
         VALUES (?, ?, ?, ?)`
      ).run(pulse.ts_bucket, pulse.fill_rate, pulse.drift_score, pulse.signal_total);
    });
    console.log(`[pulse] Upserted bucket ts=${pulse.ts_bucket}, fill_rate=${pulse.fill_rate.toFixed(3)}, drift=${pulse.drift_score}`);

    // 2. Refresh OHLC caches
    const pairs = getPairs();
    if (pairs.length > 0) {
      await refreshOhlcCaches(pairs);
      console.log(`[pulse] OHLC refresh done for ${pairs.length} pairs`);
    }

    // 3. Bucket-gap detection
    await checkBucketGaps();

    // 4. Reconcile stale runs
    await reconcileRuns();

    console.log('[pulse] Tick complete');
  } catch (err) {
    console.error('[pulse] Fatal error in tick:', err);
    process.exit(1);
  }
}

main();
