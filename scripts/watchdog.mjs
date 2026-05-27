// watchdog.mjs — dashboard health check, auto-restart, and Discord alerts
// Invoked by mc-dashboard-watchdog.timer (every 2 min)
import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';
import { execSync } from 'child_process';

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const WEBHOOK_URL = process.env.MISSIONCTRL_OPS_WEBHOOK;
const STATE_FILE = path.join(process.env.HOME, '.mc-watchdog-state.json');
const HEALTH_URL = `http://127.0.0.1:${process.env.PORT ?? 3000}/api/health`;
const MAX_UNREACHABLE = 3;

const WAL_WARN_MB = 50;
const DISK_WARN_PCT = 85;

function tryRestartUnit(unit) {
  try {
    execSync(`systemctl --user restart ${unit}`, { timeout: 10000 });
    return true;
  } catch { return false; }
}

function diskUsagePct(mountPath) {
  try {
    const out = execSync(`df -P "${mountPath}" | tail -1`, { encoding: 'utf-8' });
    return parseInt(out.trim().split(/\s+/)[4]);
  } catch { return 0; }
}

let state = { lastOk: true, unreachableCount: 0, failingSubsystem: null, lastRestartTs: 0, lastPulseRestartTs: 0 };
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
      `[mc-dashboard] /api/health unreachable ${MAX_UNREACHABLE}+ consecutive ticks — restarting missionctrl.service`
    );
    // Auto-restart the dashboard service (systemd will kill orphans via ExecStartPre)
    const now = Date.now();
    const cooldown = 10 * 60 * 1000; // don't restart more than once per 10 min
    if (now - (state.lastRestartTs || 0) > cooldown) {
      tryRestartUnit('missionctrl.service');
      state.lastRestartTs = now;
      state.unreachableCount = 0;
    }
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

// ── Upstream scraper watchdog ────────────────────────────────────────────────
// If live_strategy_pulse is stale, restart the timer that feeds it (10-min cooldown)
const pulse = health.subsystems?.live_strategy_pulse;
const pulseRestartCooldown = 10 * 60 * 1000;
if (pulse && pulse.healthy === false && Date.now() - (state.lastPulseRestartTs || 0) > pulseRestartCooldown) {
  const ok = tryRestartUnit('mc-livestrategy-pulse.service');
  state.lastPulseRestartTs = Date.now();
  await postWebhook(`[mc-watchdog] live_strategy_pulse stale — ${ok ? '✅ restarted mc-livestrategy-pulse.service' : '❌ restart failed'}`);
}

// ── WAL size guard ───────────────────────────────────────────────────────────
const walMb = health.subsystems?.db?.wal_size_mb ?? 0;
if (walMb > WAL_WARN_MB) {
  try {
    const { default: Database } = await import('better-sqlite3');
    const dbPath = path.join(__dirname, '../data/dashboard_history.sqlite');
    if (fs.existsSync(dbPath)) {
      const db = new Database(dbPath);
      db.pragma('wal_checkpoint(TRUNCATE)');
      db.close();
      await postWebhook(`[mc-watchdog] WAL was ${walMb.toFixed(1)}MB — checkpoint ran.`);
    }
  } catch {}
}

// ── Disk space guard ─────────────────────────────────────────────────────────
const diskPct = diskUsagePct(process.env.HOME);
if (diskPct >= DISK_WARN_PCT) {
  await postWebhook(`[mc-watchdog] ⚠️ Disk ${diskPct}% full on /home — prune logs or free space.`);
}

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
