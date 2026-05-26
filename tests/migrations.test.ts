/**
 * tests/migrations.test.ts — 7 scenarios for 0001_init.sql + db write helpers.
 *
 * Tests run against an in-memory SQLite DB to avoid touching the real data file.
 * Scenarios 1-6 validate the SQL schema. Scenario 7 validates write-helper contracts.
 */

import { describe, it, expect, beforeEach, afterAll } from 'vitest';
import Database from 'better-sqlite3';
import fs from 'fs';
import path from 'path';

const MIGRATION_SQL_PATH = path.join(
  __dirname,
  '../src/lib/db/migrations/0001_init.sql'
);

function freshDb(): Database.Database {
  const db = new Database(':memory:');
  db.pragma('foreign_keys = ON');
  const sql = fs.readFileSync(MIGRATION_SQL_PATH, 'utf-8');
  db.exec(sql);
  return db;
}

function makeItbRun(overrides: Record<string, unknown> = {}) {
  return {
    run_uuid: 'uuid-001',
    idempotency_key: 'idem-001',
    principal: 'browser:abc',
    ts: Date.now(),
    script: 'download',
    config: 'config.json',
    args_json: '{}',
    status: 'pending',
    ...overrides,
  };
}

function insertItbRun(db: Database.Database, row: Record<string, unknown>) {
  db.prepare(`
    INSERT INTO itb_runs (run_uuid, idempotency_key, principal, ts, script, config, args_json, status)
    VALUES (@run_uuid, @idempotency_key, @principal, @ts, @script, @config, @args_json, @status)
  `).run(row as Record<string, Database.BindingData>);
}

function insertFtRun(db: Database.Database, overrides: Record<string, unknown> = {}) {
  const row = {
    run_uuid: 'ft-uuid-001',
    idempotency_key: 'ft-idem-001',
    principal: 'browser:abc',
    ts: Date.now(),
    subcommand: 'backtesting',
    args_json: '{}',
    status: 'pending',
    ...overrides,
  };
  db.prepare(`
    INSERT INTO freqtrade_runs (run_uuid, idempotency_key, principal, ts, subcommand, args_json, status)
    VALUES (@run_uuid, @idempotency_key, @principal, @ts, @subcommand, @args_json, @status)
  `).run(row as Record<string, Database.BindingData>);
}

// ── Scenario 1 ──────────────────────────────────────────────────────────────

describe('Scenario 1: schema_version=1 after migration', () => {
  it('has schema_version row = 1', () => {
    const db = freshDb();
    const row = db.prepare('SELECT MAX(version) AS v FROM schema_version').get() as { v: number };
    expect(row.v).toBe(1);
    db.close();
  });
});

// ── Scenario 2 ──────────────────────────────────────────────────────────────

describe('Scenario 2: all expected tables exist', () => {
  const EXPECTED_TABLES = [
    'schema_version',
    'itb_runs',
    'freqtrade_runs',
    'freqtrade_backtest_curves',
    'freqtrade_backtest_trades',
    'live_strategy_pulse',
    'dashboard_metrics',
  ];

  it('creates all 7 tables', () => {
    const db = freshDb();
    const tables = (db.prepare(`SELECT name FROM sqlite_master WHERE type='table'`).all() as Array<{ name: string }>)
      .map(r => r.name);
    for (const t of EXPECTED_TABLES) {
      expect(tables).toContain(t);
    }
    db.close();
  });
});

// ── Scenario 3 ──────────────────────────────────────────────────────────────

describe('Scenario 3: itb_runs status CHECK constraint', () => {
  it('accepts all valid statuses', () => {
    const db = freshDb();
    const validStatuses = ['pending', 'running', 'ok', 'fail', 'killed', 'orphaned', 'ok_no_artifact'];
    for (const [i, status] of validStatuses.entries()) {
      expect(() =>
        insertItbRun(db, makeItbRun({ run_uuid: `uuid-${i}`, idempotency_key: `idem-${i}`, status }))
      ).not.toThrow();
    }
    db.close();
  });

  it('rejects invalid status', () => {
    const db = freshDb();
    expect(() =>
      insertItbRun(db, makeItbRun({ status: 'invalid_status' }))
    ).toThrow();
    db.close();
  });
});

// ── Scenario 4 ──────────────────────────────────────────────────────────────

describe('Scenario 4: freqtrade_runs status CHECK constraint', () => {
  it('accepts all valid statuses', () => {
    const db = freshDb();
    const validStatuses = ['pending', 'running', 'ok', 'fail', 'killed', 'orphaned', 'ok_no_artifact'];
    for (const [i, status] of validStatuses.entries()) {
      expect(() =>
        insertFtRun(db, { run_uuid: `ft-${i}`, idempotency_key: `ft-idem-${i}`, status })
      ).not.toThrow();
    }
    db.close();
  });

  it('rejects invalid status', () => {
    const db = freshDb();
    expect(() =>
      insertFtRun(db, { status: 'bad_status' })
    ).toThrow();
    db.close();
  });
});

// ── Scenario 5 ──────────────────────────────────────────────────────────────

describe('Scenario 5: UNIQUE constraints on itb_runs', () => {
  it('rejects duplicate run_uuid', () => {
    const db = freshDb();
    insertItbRun(db, makeItbRun({ run_uuid: 'dup-uuid', idempotency_key: 'idem-a' }));
    expect(() =>
      insertItbRun(db, makeItbRun({ run_uuid: 'dup-uuid', idempotency_key: 'idem-b' }))
    ).toThrow();
    db.close();
  });

  it('rejects duplicate idempotency_key', () => {
    const db = freshDb();
    insertItbRun(db, makeItbRun({ run_uuid: 'uuid-a', idempotency_key: 'dup-idem' }));
    expect(() =>
      insertItbRun(db, makeItbRun({ run_uuid: 'uuid-b', idempotency_key: 'dup-idem' }))
    ).toThrow();
    db.close();
  });
});

// ── Scenario 6 ──────────────────────────────────────────────────────────────

describe('Scenario 6: FK CASCADE — deleting freqtrade_run removes child rows', () => {
  it('cascades delete to backtest_curves and backtest_trades', () => {
    const db = freshDb();
    const runUuid = 'cascade-uuid';
    insertFtRun(db, { run_uuid: runUuid, idempotency_key: 'cascade-idem' });

    db.prepare(`
      INSERT INTO freqtrade_backtest_curves (run_uuid, ts, equity)
      VALUES (?, ?, ?)
    `).run(runUuid, 1000, 10000.0);

    db.prepare(`
      INSERT INTO freqtrade_backtest_trades (run_uuid, pair, open_ts, open_rate)
      VALUES (?, ?, ?, ?)
    `).run(runUuid, 'BTC/USDT', 1000, 50000.0);

    // Verify children exist
    const curvesBefore = db.prepare('SELECT COUNT(*) AS n FROM freqtrade_backtest_curves').get() as { n: number };
    const tradesBefore = db.prepare('SELECT COUNT(*) AS n FROM freqtrade_backtest_trades').get() as { n: number };
    expect(curvesBefore.n).toBe(1);
    expect(tradesBefore.n).toBe(1);

    db.prepare('DELETE FROM freqtrade_runs WHERE run_uuid = ?').run(runUuid);

    const curvesAfter = db.prepare('SELECT COUNT(*) AS n FROM freqtrade_backtest_curves').get() as { n: number };
    const tradesAfter = db.prepare('SELECT COUNT(*) AS n FROM freqtrade_backtest_trades').get() as { n: number };
    expect(curvesAfter.n).toBe(0);
    expect(tradesAfter.n).toBe(0);
    db.close();
  });
});

// ── Scenario 7 ──────────────────────────────────────────────────────────────

describe('Scenario 7: dbCriticalWrite is fail-closed, dbTelemetryWrite is best-effort', () => {
  it('dbCriticalWrite rethrows on fn error', async () => {
    // Fresh module to avoid singleton DB path collision in CI
    const { dbCriticalWrite } = await import('../src/lib/dashboard-db');
    expect(() =>
      dbCriticalWrite(() => { throw new Error('injected error'); })
    ).toThrow('injected error');
  });

  it('dbTelemetryWrite returns null on fn error without throwing', async () => {
    const { dbTelemetryWrite } = await import('../src/lib/dashboard-db');
    const result = dbTelemetryWrite(() => { throw new Error('telemetry fail'); });
    expect(result).toBeNull();
  });
});
