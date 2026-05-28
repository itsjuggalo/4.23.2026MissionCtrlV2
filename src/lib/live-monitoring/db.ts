import Database from 'better-sqlite3';
import path from 'path';
import fs from 'fs';

const DB_DIR = path.join(process.cwd(), 'data');
const DB_PATH = path.join(DB_DIR, 'live_trades.sqlite');

if (!fs.existsSync(DB_DIR)) fs.mkdirSync(DB_DIR, { recursive: true });

let _db: Database.Database | null = null;

export function getLiveDb(): Database.Database {
  if (_db) return _db;
  _db = new Database(DB_PATH);
  _db.pragma('journal_mode = WAL');
  _db.pragma('busy_timeout = 5000');
  _db.pragma('synchronous = NORMAL');
  _db.exec(`
    CREATE TABLE IF NOT EXISTS live_signals (
      id                  INTEGER PRIMARY KEY AUTOINCREMENT,
      received_at         TEXT    NOT NULL,
      bar_time            TEXT    NOT NULL,
      bar_time_epoch_ms   INTEGER NOT NULL,
      strategy            TEXT    NOT NULL,
      strategy_version    TEXT    NOT NULL DEFAULT '1.0.0',
      account             TEXT    NOT NULL,
      symbol              TEXT    NOT NULL,
      timeframe           TEXT    NOT NULL DEFAULT '1h',
      action              TEXT    NOT NULL,
      alert_price         REAL    NOT NULL,
      stop_price          REAL    NOT NULL,
      tp1_price           REAL,
      tp2_price           REAL    NOT NULL,
      quantity_requested  REAL    NOT NULL,
      atr_at_signal       REAL,
      rsi_at_signal       REAL,
      htf_close           REAL,
      htf_ema50           REAL,
      dedupe_key          TEXT    NOT NULL,
      decision            TEXT    NOT NULL,
      suppression_reason  TEXT,
      rejection_reason    TEXT,
      webhook_log_id      INTEGER,
      raw_payload         TEXT    NOT NULL,
      notes               TEXT
    );
    CREATE INDEX IF NOT EXISTS ix_sig_bartime   ON live_signals(bar_time_epoch_ms);
    CREATE INDEX IF NOT EXISTS ix_sig_symbol_bt ON live_signals(symbol, bar_time_epoch_ms);
    CREATE INDEX IF NOT EXISTS ix_sig_dedupe    ON live_signals(dedupe_key);
    CREATE INDEX IF NOT EXISTS ix_sig_decision  ON live_signals(decision, received_at DESC);

    CREATE TABLE IF NOT EXISTS live_trades (
      id                     INTEGER PRIMARY KEY AUTOINCREMENT,
      signal_id              INTEGER NOT NULL,
      bracket_group_id       TEXT    NOT NULL,
      alpaca_order_id        TEXT    NOT NULL UNIQUE,
      alpaca_client_order_id TEXT    NOT NULL,
      account                TEXT    NOT NULL,
      symbol                 TEXT    NOT NULL,
      leg                    TEXT    NOT NULL,
      side                   TEXT    NOT NULL,
      order_type             TEXT    NOT NULL,
      submitted_at           TEXT    NOT NULL,
      filled_at              TEXT,
      cancelled_at           TEXT,
      quantity_requested     REAL    NOT NULL,
      quantity_filled        REAL,
      limit_price            REAL,
      stop_price             REAL,
      fill_avg_price         REAL,
      fees                   REAL,
      pnl_usd                REAL,
      pnl_r                  REAL,
      status                 TEXT,
      raw_response           TEXT,
      created_at             TEXT NOT NULL DEFAULT (datetime('now'))
    );
    CREATE INDEX IF NOT EXISTS ix_tr_signal  ON live_trades(signal_id);
    CREATE INDEX IF NOT EXISTS ix_tr_bracket ON live_trades(bracket_group_id);
    CREATE INDEX IF NOT EXISTS ix_tr_symbol  ON live_trades(symbol, submitted_at DESC);
  `);
  return _db;
}

export interface SignalInsert {
  bar_time: string;
  strategy: string;
  account: string;
  symbol: string;
  action: 'buy' | 'sell';
  alert_price: number;
  stop_price: number;
  tp1_price?: number | null;
  tp2_price: number;
  quantity_requested: number;
  dedupe_key: string;
  decision: 'submitted' | 'suppressed' | 'rejected' | 'duplicate' | 'dry_run';
  suppression_reason?: string | null;
  rejection_reason?: string | null;
  webhook_log_id?: number | null;
  raw_payload: string;
}

export function insertSignal(s: SignalInsert): number {
  const stmt = getLiveDb().prepare(`
    INSERT INTO live_signals (
      received_at, bar_time, bar_time_epoch_ms, strategy, account, symbol, action,
      alert_price, stop_price, tp1_price, tp2_price, quantity_requested,
      dedupe_key, decision, suppression_reason, rejection_reason,
      webhook_log_id, raw_payload
    ) VALUES (
      @received_at, @bar_time, @bar_time_epoch_ms, @strategy, @account, @symbol, @action,
      @alert_price, @stop_price, @tp1_price, @tp2_price, @quantity_requested,
      @dedupe_key, @decision, @suppression_reason, @rejection_reason,
      @webhook_log_id, @raw_payload
    )
  `);
  const res = stmt.run({
    received_at: new Date().toISOString(),
    bar_time_epoch_ms: Date.parse(s.bar_time),
    suppression_reason: s.suppression_reason ?? null,
    rejection_reason: s.rejection_reason ?? null,
    webhook_log_id: s.webhook_log_id ?? null,
    tp1_price: s.tp1_price ?? null,
    ...s,
  });
  return Number(res.lastInsertRowid);
}

export interface TradeInsert {
  signal_id: number;
  bracket_group_id: string;
  alpaca_order_id: string;
  alpaca_client_order_id: string;
  account: string;
  symbol: string;
  leg: 'entry' | 'tp1' | 'tp2' | 'sl' | 'htf_break' | 'manual_close';
  side: 'buy' | 'sell';
  order_type: string;
  quantity_requested: number;
  limit_price?: number | null;
  stop_price?: number | null;
  status?: string | null;
  raw_response?: string | null;
}

export function insertTrade(t: TradeInsert): number {
  const stmt = getLiveDb().prepare(`
    INSERT INTO live_trades (
      signal_id, bracket_group_id, alpaca_order_id, alpaca_client_order_id,
      account, symbol, leg, side, order_type, submitted_at,
      quantity_requested, limit_price, stop_price, status, raw_response
    ) VALUES (
      @signal_id, @bracket_group_id, @alpaca_order_id, @alpaca_client_order_id,
      @account, @symbol, @leg, @side, @order_type, @submitted_at,
      @quantity_requested, @limit_price, @stop_price, @status, @raw_response
    )
  `);
  const res = stmt.run({
    submitted_at: new Date().toISOString(),
    limit_price: t.limit_price ?? null,
    stop_price: t.stop_price ?? null,
    status: t.status ?? null,
    raw_response: t.raw_response ?? null,
    ...t,
  });
  return Number(res.lastInsertRowid);
}
