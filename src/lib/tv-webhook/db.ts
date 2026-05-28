import Database from 'better-sqlite3';
import path from 'path';
import fs from 'fs';

const DB_DIR = path.join(process.cwd(), 'data');
const DB_PATH = path.join(DB_DIR, 'tv_webhook_log.sqlite');

if (!fs.existsSync(DB_DIR)) fs.mkdirSync(DB_DIR, { recursive: true });

let _db: Database.Database | null = null;

export function getTvDb(): Database.Database {
  if (_db) return _db;
  _db = new Database(DB_PATH);
  _db.pragma('journal_mode = WAL');
  _db.pragma('busy_timeout = 5000');
  _db.pragma('synchronous = NORMAL');
  _db.exec(`
    CREATE TABLE IF NOT EXISTS tv_webhook_log (
      id              INTEGER PRIMARY KEY AUTOINCREMENT,
      received_at     TEXT    NOT NULL,
      remote_ip       TEXT,
      account         TEXT,
      strategy        TEXT,
      symbol          TEXT,
      action          TEXT,
      quantity        REAL,
      price           REAL,
      stop_loss       REAL,
      take_profit     REAL,
      bar_time        TEXT,
      dedupe_key      TEXT,
      outcome         TEXT    NOT NULL,
      http_status     INTEGER NOT NULL,
      alpaca_order_id TEXT,
      alpaca_status   TEXT,
      alpaca_error    TEXT,
      raw_payload     TEXT    NOT NULL,
      duration_ms     INTEGER
    );
    CREATE INDEX IF NOT EXISTS ix_tv_log_received ON tv_webhook_log(received_at DESC);
    CREATE INDEX IF NOT EXISTS ix_tv_log_symbol   ON tv_webhook_log(symbol, received_at DESC);

    CREATE TABLE IF NOT EXISTS tv_dedupe (
      dedupe_key  TEXT PRIMARY KEY,
      created_at  TEXT NOT NULL,
      account     TEXT NOT NULL,
      symbol      TEXT NOT NULL
    );
    CREATE INDEX IF NOT EXISTS ix_tv_dedupe_created ON tv_dedupe(created_at);
  `);
  return _db;
}

export function pruneOldDedupe(maxAgeHours = 24): number {
  const cutoff = new Date(Date.now() - maxAgeHours * 3600 * 1000).toISOString();
  return getTvDb().prepare(`DELETE FROM tv_dedupe WHERE created_at < ?`).run(cutoff).changes;
}
