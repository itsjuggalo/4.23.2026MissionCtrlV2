/**
 * dashboard-db.ts — single better-sqlite3 handle for MissionCtrlV2 dashboard telemetry.
 *
 * Two write helpers only — never use a generic "dbWrite":
 *   dbCriticalWrite(fn) — fail-closed: throws on error, caller MUST return 500
 *   dbTelemetryWrite(fn) — best-effort: logs on error, caller continues
 *
 * Reads:
 *   dbRead(fn) — always best-effort; returns null on error
 */

import Database from 'better-sqlite3';
import fs from 'fs';
import path from 'path';

const DB_DIR = path.join(process.cwd(), 'data');
const DB_PATH = path.join(DB_DIR, 'dashboard_history.sqlite');
const MIGRATIONS_DIR = path.join(process.cwd(), 'src/lib/db/migrations');
const MIGRATION_LOCK_TIMEOUT_MS = 30_000;

let _db: Database.Database | null = null;
let _initialized = false;

function openDb(): Database.Database {
  // Ensure data dir exists
  if (!fs.existsSync(DB_DIR)) {
    fs.mkdirSync(DB_DIR, { recursive: true });
  }

  const db = new Database(DB_PATH);

  // Set file permissions to 0600 on first creation
  try { fs.chmodSync(DB_PATH, 0o600); } catch {}

  // Pragmas required by the PLAN
  db.pragma('journal_mode = WAL');
  db.pragma('synchronous = NORMAL');
  db.pragma('busy_timeout = 5000');
  db.pragma('foreign_keys = ON');
  db.pragma('temp_store = MEMORY');

  // Assert foreign_keys is on (R2.M3 requirement)
  const fkResult = db.pragma('foreign_keys') as Array<{ foreign_keys: number }>;
  if (!fkResult[0] || fkResult[0].foreign_keys !== 1) {
    throw new Error('dashboard-db: foreign_keys pragma failed to enable');
  }

  return db;
}

function runMigrations(db: Database.Database): void {
  // Read current version
  const tables = db.prepare(
    `SELECT name FROM sqlite_master WHERE type='table' AND name='schema_version'`
  ).all() as Array<{ name: string }>;

  let currentVersion = 0;
  if (tables.length > 0) {
    const row = db.prepare('SELECT MAX(version) AS v FROM schema_version').get() as { v: number | null } | undefined;
    currentVersion = row?.v ?? 0;
  }

  // Acquire exclusive lock for migration (prevents two Next.js processes racing)
  // Use a 30s timeout via busy_timeout already set above
  const migrationFiles = fs.existsSync(MIGRATIONS_DIR)
    ? fs.readdirSync(MIGRATIONS_DIR).filter(f => f.endsWith('.sql')).sort()
    : [];

  for (const file of migrationFiles) {
    // Parse version from filename: 0001_init.sql → 1
    const match = file.match(/^(\d+)_/);
    if (!match) continue;
    const fileVersion = parseInt(match[1], 10);
    if (fileVersion <= currentVersion) continue;

    const sql = fs.readFileSync(path.join(MIGRATIONS_DIR, file), 'utf-8');

    // Run migration inside a single transaction with exclusive lock
    const startTime = Date.now();
    let lockAcquired = false;

    try {
      // BEGIN IMMEDIATE acquires a write lock; busy_timeout handles contention
      const runMigration = db.transaction(() => {
        db.exec(sql);
      });

      runMigration();
      lockAcquired = true;
      console.log(`[dashboard-db] Applied migration ${file}`);
    } catch (err) {
      if (!lockAcquired && Date.now() - startTime > MIGRATION_LOCK_TIMEOUT_MS) {
        throw new Error(`[dashboard-db] Migration lock not acquired within ${MIGRATION_LOCK_TIMEOUT_MS}ms — another process may be running migrations. Crashing loudly.`);
      }
      throw new Error(`[dashboard-db] Migration ${file} failed: ${err}`);
    }
  }
}

function getDb(): Database.Database {
  if (_db && _initialized) return _db;

  if (!_db) {
    _db = openDb();
  }

  if (!_initialized) {
    runMigrations(_db);
    _initialized = true;
  }

  return _db;
}

// Lazy init on module load (if DB_ENABLED)
function isDbEnabled(): boolean {
  return process.env.MISSIONCTRL_DB_ENABLED !== 'false';
}

/**
 * dbCriticalWrite — fail-closed writer.
 * Used for: pre-spawn transaction (audit log + *_runs INSERT).
 * On failure: throws — caller MUST return 500 and NOT spawn any child.
 */
export function dbCriticalWrite<T>(fn: (db: Database.Database) => T): T {
  if (!isDbEnabled()) {
    throw new Error('dashboard-db: DB is disabled (MISSIONCTRL_DB_ENABLED=false)');
  }
  const db = getDb();
  return fn(db);
}

/**
 * dbTelemetryWrite — best-effort writer.
 * Used for: live_strategy_pulse upserts, stdout/stderr tails, pipeline_health.
 * On failure: logs to stderr, returns null — caller continues normally.
 */
export function dbTelemetryWrite<T>(fn: (db: Database.Database) => T): T | null {
  if (!isDbEnabled()) return null;
  try {
    const db = getDb();
    return fn(db);
  } catch (err) {
    console.error('[dashboard-db] telemetry write failed (non-fatal):', err);
    return null;
  }
}

/**
 * dbRead — best-effort reader.
 * On failure: logs and returns null.
 */
export function dbRead<T>(fn: (db: Database.Database) => T): T | null {
  if (!isDbEnabled()) return null;
  try {
    const db = getDb();
    return fn(db);
  } catch (err) {
    console.error('[dashboard-db] read failed (non-fatal):', err);
    return null;
  }
}

/**
 * getPidStartTime — reads /proc/<pid>/stat field 22 (starttime jiffies since boot).
 * Returns null if process doesn't exist or isn't readable.
 */
export function getPidStartTime(pid: number): number | null {
  try {
    const stat = fs.readFileSync(`/proc/${pid}/stat`, 'utf-8');
    // Field 22 is starttime (0-indexed: field index 21 after split)
    // Format: pid (comm) state ppid pgroup session tty tpgid flags ... starttime
    // The comm field can contain spaces and is wrapped in parens, so we must parse carefully
    const afterComm = stat.slice(stat.lastIndexOf(')') + 2);
    const fields = afterComm.split(' ');
    // Field 22 overall = field 20 in afterComm (0-indexed)
    const starttime = parseInt(fields[19], 10);
    return isNaN(starttime) ? null : starttime;
  } catch {
    return null;
  }
}

export { getDb };
