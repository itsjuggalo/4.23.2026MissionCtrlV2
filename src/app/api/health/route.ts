/**
 * /api/health — Phase 6a health endpoint.
 * No auth required. Returns booleans + counts only (no sensitive data).
 */

import { NextResponse } from 'next/server';
import { dbRead } from '@/lib/dashboard-db';
import fs from 'fs';
import path from 'path';

export const runtime = 'nodejs';
export const dynamic = 'force-dynamic';

const DB_PATH = path.join(process.cwd(), 'data/dashboard_history.sqlite');
const AUDIT_LOG = path.join(process.cwd(), 'data/exec-audit.log');
const OHLC_CACHE_DIR = path.join(process.cwd(), 'data/ohlc_cache');

const WAL_SIZE_ALERT_MB = 100;
const PULSE_STALE_MS = 15 * 60 * 1000; // 15 min
const MAX_MISSING_BUCKETS = 3;
const PENDING_ALERT_MS = 10 * 60 * 1000; // 10 min

function getFileSizeMb(filePath: string): number {
  try {
    return fs.statSync(filePath).size / (1024 * 1024);
  } catch {
    return 0;
  }
}

function getDbHealth() {
  try {
    const result = dbRead(db => {
      const versionRow = db.prepare('SELECT MAX(version) AS v FROM schema_version').get() as { v: number | null } | undefined;
      const schemaVersion = versionRow?.v ?? 0;

      const walPath = DB_PATH + '-wal';
      const walSizeMb = getFileSizeMb(walPath);

      return { healthy: true, schema_version: schemaVersion, wal_size_mb: walSizeMb };
    });
    return result ?? { healthy: false, schema_version: 0, wal_size_mb: 0 };
  } catch {
    return { healthy: false, schema_version: 0, wal_size_mb: 0 };
  }
}

function getPulseHealth() {
  const now = Date.now();
  try {
    const result = dbRead(db => {
      const lastRow = db.prepare('SELECT ts FROM live_strategy_pulse ORDER BY ts DESC LIMIT 1').get() as { ts: number } | undefined;
      const lastBucketMs = lastRow?.ts ?? 0;

      // Count missing buckets in the trailing hour
      const hourAgo = now - 60 * 60 * 1000;
      const expectedBuckets = 12; // 1h / 5min
      const presentCount = (db.prepare(
        'SELECT COUNT(*) AS n FROM live_strategy_pulse WHERE ts >= ?'
      ).get(hourAgo) as { n: number } | undefined)?.n ?? 0;
      const missingLastHour = Math.max(0, expectedBuckets - presentCount);

      return { healthy: lastBucketMs > now - PULSE_STALE_MS, last_bucket_ms: lastBucketMs, missing_last_hour: missingLastHour };
    });
    return result ?? { healthy: false, last_bucket_ms: 0, missing_last_hour: 99 };
  } catch {
    return { healthy: false, last_bucket_ms: 0, missing_last_hour: 99 };
  }
}

function getOhlcHealth() {
  const stalePairs: string[] = [];
  try {
    if (!fs.existsSync(OHLC_CACHE_DIR)) return { healthy: true, stale_pairs: [] };
    const files = fs.readdirSync(OHLC_CACHE_DIR).filter(f => f.endsWith('.json'));
    for (const file of files) {
      const stat = fs.statSync(path.join(OHLC_CACHE_DIR, file));
      if (Date.now() - stat.mtimeMs > 2 * 60 * 60 * 1000) { // > 2h
        stalePairs.push(file.replace('-1h.json', '').replace('_', '/'));
      }
    }
    return { healthy: stalePairs.length === 0, stale_pairs: stalePairs };
  } catch {
    return { healthy: true, stale_pairs: [] };
  }
}

function getRunsHealth() {
  const now = Date.now();
  try {
    const result = dbRead(db => {
      const pendingCount = (db.prepare(
        "SELECT COUNT(*) AS n FROM itb_runs WHERE status = 'pending'"
      ).get() as { n: number } | undefined)?.n ?? 0;
      const runningCount = (db.prepare(
        "SELECT COUNT(*) AS n FROM itb_runs WHERE status = 'running'"
      ).get() as { n: number } | undefined)?.n ?? 0;

      const pendingFt = (db.prepare(
        "SELECT COUNT(*) AS n FROM freqtrade_runs WHERE status = 'pending'"
      ).get() as { n: number } | undefined)?.n ?? 0;
      const runningFt = (db.prepare(
        "SELECT COUNT(*) AS n FROM freqtrade_runs WHERE status = 'running'"
      ).get() as { n: number } | undefined)?.n ?? 0;

      const dayAgo = now - 24 * 60 * 60 * 1000;
      const orphanedLast24h = (db.prepare(
        "SELECT COUNT(*) AS n FROM itb_runs WHERE status = 'orphaned' AND ended_at >= ?"
      ).get(dayAgo) as { n: number } | undefined)?.n ?? 0;
      const killedLast24h = (db.prepare(
        "SELECT COUNT(*) AS n FROM itb_runs WHERE status = 'killed' AND ended_at >= ?"
      ).get(dayAgo) as { n: number } | undefined)?.n ?? 0;

      return {
        pending: pendingCount + pendingFt,
        running: runningCount + runningFt,
        orphaned_last_24h: orphanedLast24h,
        killed_last_24h: killedLast24h,
      };
    });
    return result ?? { pending: 0, running: 0, orphaned_last_24h: 0, killed_last_24h: 0 };
  } catch {
    return { pending: 0, running: 0, orphaned_last_24h: 0, killed_last_24h: 0 };
  }
}

function getIngestionHealth() {
  const now = Date.now();
  const dayAgo = now - 24 * 60 * 60 * 1000;
  try {
    const result = dbRead(db => {
      const failedCount = (db.prepare(
        "SELECT COUNT(*) AS n FROM freqtrade_runs WHERE ingestion_status = 'failed' AND ended_at >= ?"
      ).get(dayAgo) as { n: number } | undefined)?.n ?? 0;
      return { failed_last_24h: failedCount };
    });
    return result ?? { failed_last_24h: 0 };
  } catch {
    return { failed_last_24h: 0 };
  }
}

function getRetentionHealth() {
  try {
    const result = dbRead(db => {
      const lastRow = db.prepare(
        "SELECT ts, value FROM dashboard_metrics WHERE key = 'retention_rows_pruned' ORDER BY ts DESC LIMIT 1"
      ).get() as { ts: number; value: number } | undefined;
      return {
        last_run_ts: lastRow?.ts ?? null,
        rows_pruned_last_run: lastRow?.value ?? 0,
      };
    });
    return result ?? { last_run_ts: null, rows_pruned_last_run: 0 };
  } catch {
    return { last_run_ts: null, rows_pruned_last_run: 0 };
  }
}

function getAuditLogHealth() {
  try {
    if (!fs.existsSync(AUDIT_LOG)) return { size_mb: 0, last_write_ms: null };
    const stat = fs.statSync(AUDIT_LOG);
    return { size_mb: stat.size / (1024 * 1024), last_write_ms: stat.mtimeMs };
  } catch {
    return { size_mb: 0, last_write_ms: null };
  }
}

export async function GET() {
  const now = Date.now();

  const db = getDbHealth();
  const pulse = getPulseHealth();
  const ohlc = getOhlcHealth();
  const runs = getRunsHealth();
  const ingestion = getIngestionHealth();
  const retention = getRetentionHealth();
  const auditLog = getAuditLogHealth();

  // ok=false conditions (per PLAN Phase 6a)
  const pendingTooLong = runs.pending > 0 && now - (runs as unknown as Record<string, number>).oldest_pending_ts > PENDING_ALERT_MS;
  const ok = db.healthy
    && pulse.healthy
    && pulse.missing_last_hour <= MAX_MISSING_BUCKETS
    && pulse.last_bucket_ms > now - PULSE_STALE_MS
    && ingestion.failed_last_24h === 0
    && db.wal_size_mb <= WAL_SIZE_ALERT_MB
    && !pendingTooLong;

  const execMode = process.env.MISSIONCTRL_EXEC_MODE ?? 'browser-session';

  return NextResponse.json({
    ok,
    ts: now,
    subsystems: {
      db,
      live_strategy_pulse: pulse,
      ohlc_cache: ohlc,
      exec_auth: {
        mode: execMode,
        rate_limited_last_hour: 0, // tracked in memory, not persisted
      },
      runs,
      ingestion,
      retention,
      audit_log: auditLog,
    },
  });
}
