// watchdog.mjs — dashboard health check + Discord alert on false transitions
// Invoked by mc-dashboard-watchdog.timer (every 2 min)
import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const WEBHOOK_URL = process.env.MISSIONCTRL_OPS_WEBHOOK;
const STATE_FILE = path.join(process.env.HOME, '.mc-watchdog-state.json');
const HEALTH_URL = `http://127.0.0.1:${process.env.PORT ?? 3000}/api/health`;
const MAX_UNREACHABLE = 3;

let state = { lastOk: true, unreachableCount: 0, failingSubsystem: null };
try { state = JSON.parse(fs.readFileSync(STATE_FILE, 'utf-8')); } catch {}

async function postWebhook(message) {
  if (!WEBHOOK_URL) return;
  try {
    await fetch(WEBHOOK_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ content: message }),
    });
  } catch {}
}

let health;
try {
  const res = await fetch(HEALTH_URL, { signal: AbortSignal.timeout(10000) });
  health = await res.json();
  state.unreachableCount = 0;
} catch {
  state.unreachableCount = (state.unreachableCount || 0) + 1;
  if (state.unreachableCount >= MAX_UNREACHABLE) {
    await postWebhook(
      `[mc-dashboard] /api/health unreachable ${MAX_UNREACHABLE}+ consecutive ticks since ${new Date().toISOString()}`
    );
  }
  fs.writeFileSync(STATE_FILE, JSON.stringify(state));
  process.exit(0);
}

const wasOk = state.lastOk;
const nowOk = health.ok;
const failingSub = Object.entries(health.subsystems || {})
  .find(([, v]) => v && typeof v === 'object' && v.healthy === false)?.[0] || null;

if (!nowOk && (wasOk || failingSub !== state.failingSubsystem)) {
  const subInfo = failingSub ? JSON.stringify(health.subsystems[failingSub]) : 'unknown';
  await postWebhook(
    `[mc-dashboard] Health check FAILED\nFailing subsystem: ${failingSub ?? 'unknown'}\nDetails: ${subInfo}`
  );
}

state.lastOk = nowOk;
state.failingSubsystem = failingSub;
fs.writeFileSync(STATE_FILE, JSON.stringify(state));

// Write health metrics to dashboard_metrics (best-effort)
try {
  const { default: Database } = await import('better-sqlite3');
  const db = new Database(path.join(__dirname, '../data/dashboard_history.sqlite'));
  db.pragma('foreign_keys = ON');
  const now = Date.now();
  const metrics = [
    ['health_pending_runs', health.subsystems?.runs?.pending ?? 0],
    ['health_missing_buckets', health.subsystems?.live_strategy_pulse?.missing_last_hour ?? 0],
    ['health_ingestion_failed', health.subsystems?.ingestion?.failed_last_24h ?? 0],
    ['health_wal_mb', health.subsystems?.db?.wal_size_mb ?? 0],
  ];
  for (const [key, value] of metrics) {
    db.prepare('INSERT OR REPLACE INTO dashboard_metrics (ts, key, value) VALUES (?, ?, ?)').run(now, key, value);
  }
  db.close();
} catch {}
