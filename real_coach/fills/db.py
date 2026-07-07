"""db.py — mike.sqlite schema + insert helpers (WAL, idempotent).

One personal DB for fills + derived lots/round-trips + (P2) profile answers +
(P3) decision ledger + (P4) scan history — cross-joins are the point (after-trade
interviews link to fills; decisions link to profile factors). Durable multi-year
ledger: lives in ~/portfolio/, NOT in the rolling-retention signal DBs.
"""
from __future__ import annotations

import json
import sqlite3
from pathlib import Path

DB = Path.home() / "portfolio" / "mike.sqlite"

SCHEMA = """
PRAGMA journal_mode=WAL;
CREATE TABLE IF NOT EXISTS fills(
  id INTEGER PRIMARY KEY,
  broker TEXT NOT NULL,            -- robinhood|coinbase
  asset_class TEXT NOT NULL,       -- stock|option|crypto
  broker_order_id TEXT NOT NULL,
  broker_fill_id TEXT NOT NULL DEFAULT '',
  symbol TEXT NOT NULL,            -- ORCL, DOGE; option underlying here, OCC in occ_symbol
  occ_symbol TEXT,
  side TEXT NOT NULL,              -- buy|sell
  position_effect TEXT,            -- options: open|close ; crypto: receive|send for transfers
  qty REAL NOT NULL,
  price REAL NOT NULL,
  fees REAL NOT NULL DEFAULT 0,
  amount_usd REAL,                 -- signed notional (buy negative cash, sell positive)
  filled_at TEXT NOT NULL,         -- ISO8601 UTC
  synthetic INTEGER NOT NULL DEFAULT 0,  -- 1 = basis estimated (transfer-in valued at market)
  raw TEXT,
  ingested_at TEXT DEFAULT (datetime('now')),
  UNIQUE(broker, asset_class, broker_order_id, broker_fill_id)
);
CREATE INDEX IF NOT EXISTS idx_fills_sym_t ON fills(symbol, filled_at);
CREATE INDEX IF NOT EXISTS idx_fills_bat ON fills(broker, asset_class, filled_at);
CREATE TABLE IF NOT EXISTS sync_state(
  source TEXT PRIMARY KEY, cursor TEXT, last_run_at TEXT, last_new INTEGER);
CREATE TABLE IF NOT EXISTS lots(              -- FIFO open lots (derived, rebuildable)
  broker TEXT, asset_class TEXT, symbol TEXT,
  qty REAL, price REAL, opened_at TEXT, synthetic INTEGER DEFAULT 0);
CREATE TABLE IF NOT EXISTS round_trips(       -- closed trades — the bias-mining substrate
  id INTEGER PRIMARY KEY,
  broker TEXT, asset_class TEXT, symbol TEXT, occ_symbol TEXT,
  qty REAL, entry_px REAL, exit_px REAL, entry_at TEXT, exit_at TEXT,
  pnl_usd REAL, pnl_pct REAL, hold_days REAL,
  fwd_ret_30d REAL,          -- post-sale runup (sold-winners-early metric; graded later)
  max_drawdown_pct REAL);    -- worst depth while held (holds-losers metric; graded later)
CREATE TABLE IF NOT EXISTS profile_answers(   -- P2
  id INTEGER PRIMARY KEY, qid TEXT NOT NULL, channel TEXT,
  asked_at TEXT, answered_at TEXT, answer TEXT,
  fill_id INTEGER, decision_id INTEGER);
CREATE TABLE IF NOT EXISTS decision_ledger(   -- P3
  id INTEGER PRIMARY KEY, ts TEXT NOT NULL,
  source TEXT, symbol TEXT, broker TEXT, bucket TEXT,
  verdict TEXT, confidence REAL,
  reasoning TEXT NOT NULL,
  profile_factors TEXT, ta_snapshot TEXT, price_at REAL, qty_at REAL,
  mike_action TEXT DEFAULT 'pending', override_why TEXT, action_ts TEXT);
CREATE TABLE IF NOT EXISTS decision_outcomes( -- P3
  decision_id INTEGER, horizon TEXT, price REAL, pnl_pct REAL,
  verdict_right INTEGER, scored_at TEXT,
  PRIMARY KEY(decision_id, horizon));
CREATE TABLE IF NOT EXISTS scan_history(      -- P4
  id INTEGER PRIMARY KEY, scanned_at TEXT, symbol TEXT, pivot REAL, score REAL,
  price_at REAL, fwd_max_ret_t20 REAL, fwd_max_ret_t60 REAL,
  hit30_before_neg15 INTEGER, graded_at TEXT);
"""


def connect() -> sqlite3.Connection:
    DB.parent.mkdir(parents=True, exist_ok=True)
    con = sqlite3.connect(str(DB), timeout=30)
    con.executescript(SCHEMA)
    return con


def insert_fill(con, *, broker, asset_class, order_id, fill_id="", symbol, occ_symbol=None,
                side, position_effect=None, qty, price, fees=0.0, amount_usd=None,
                filled_at, synthetic=0, raw=None) -> bool:
    """True if a NEW row landed (idempotent via UNIQUE + OR IGNORE)."""
    cur = con.execute(
        "INSERT OR IGNORE INTO fills(broker,asset_class,broker_order_id,broker_fill_id,"
        "symbol,occ_symbol,side,position_effect,qty,price,fees,amount_usd,filled_at,"
        "synthetic,raw) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
        (broker, asset_class, order_id, fill_id, symbol.upper(), occ_symbol, side,
         position_effect, float(qty), float(price), float(fees or 0),
         amount_usd, filled_at, int(synthetic),
         json.dumps(raw, default=str) if raw is not None else None))
    return cur.rowcount > 0


def set_cursor(con, source: str, cursor: str | None, new_rows: int) -> None:
    con.execute("INSERT INTO sync_state(source,cursor,last_run_at,last_new) "
                "VALUES(?,?,datetime('now'),?) ON CONFLICT(source) DO UPDATE SET "
                "cursor=excluded.cursor, last_run_at=excluded.last_run_at, "
                "last_new=excluded.last_new", (source, cursor, new_rows))


def get_cursor(con, source: str) -> str | None:
    row = con.execute("SELECT cursor FROM sync_state WHERE source=?", (source,)).fetchone()
    return row[0] if row else None
