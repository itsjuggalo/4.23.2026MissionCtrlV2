-- 0001_init.sql

CREATE TABLE schema_version (
  version    INTEGER PRIMARY KEY,
  applied_at INTEGER NOT NULL
);

CREATE TABLE itb_runs (
  id                 INTEGER PRIMARY KEY,
  run_uuid           TEXT NOT NULL UNIQUE,
  idempotency_key    TEXT NOT NULL UNIQUE,        -- R2.H4
  principal          TEXT NOT NULL,               -- 'browser:<sess_hash>' | 'headless'
  ts                 INTEGER NOT NULL,            -- request accepted
  started_at         INTEGER,                     -- transition to 'running'
  ended_at           INTEGER,                     -- transition to terminal
  script             TEXT NOT NULL,
  config             TEXT NOT NULL,
  args_json          TEXT NOT NULL,               -- typed object, post-validation
  status             TEXT NOT NULL DEFAULT 'pending'
    CHECK(status IN ('pending','running','ok','fail','killed','orphaned','ok_no_artifact')),
  exit_code          INTEGER,
  elapsed_ms         INTEGER,
  pid                INTEGER,                     -- child PID once spawned (R2.H4 + R3.M4)
  pid_start_time     INTEGER,                     -- /proc/<pid>/stat starttime, defeats PID reuse (R3.M4)
  stdout_tail        TEXT,                        -- redacted via lib/redact.ts before INSERT (R2.M2)
  stderr_tail        TEXT,                        -- ditto
  ingestion_status   TEXT NOT NULL DEFAULT 'na'
    CHECK(ingestion_status IN ('na','pending','ok','failed'))
);
CREATE INDEX idx_itb_runs_ts ON itb_runs(ts);
CREATE INDEX idx_itb_runs_status_started ON itb_runs(status, started_at);
CREATE INDEX idx_itb_runs_script_ts ON itb_runs(script, ts);

CREATE TABLE freqtrade_runs (
  id                 INTEGER PRIMARY KEY,
  run_uuid           TEXT NOT NULL UNIQUE,
  idempotency_key    TEXT NOT NULL UNIQUE,
  principal          TEXT NOT NULL,
  ts                 INTEGER NOT NULL,
  started_at         INTEGER,
  ended_at           INTEGER,
  subcommand         TEXT NOT NULL,
  args_json          TEXT NOT NULL,
  status             TEXT NOT NULL DEFAULT 'pending'
    CHECK(status IN ('pending','running','ok','fail','killed','orphaned','ok_no_artifact')),
  exit_code          INTEGER,
  elapsed_ms         INTEGER,
  pid                INTEGER,
  pid_start_time     INTEGER,
  artifact_path      TEXT,                        -- deterministic `backtest_<run_uuid>.json` (R1.H4)
  stdout_tail        TEXT,
  stderr_tail        TEXT,
  ingestion_status   TEXT NOT NULL DEFAULT 'na'
    CHECK(ingestion_status IN ('na','pending','ok','failed'))
);
CREATE INDEX idx_freqtrade_runs_ts ON freqtrade_runs(ts);
CREATE INDEX idx_freqtrade_runs_status_started ON freqtrade_runs(status, started_at);
CREATE INDEX idx_freqtrade_runs_subcommand_ts ON freqtrade_runs(subcommand, ts);

CREATE TABLE freqtrade_backtest_curves (
  run_uuid  TEXT NOT NULL REFERENCES freqtrade_runs(run_uuid) ON DELETE CASCADE,
  ts        INTEGER NOT NULL,
  equity    REAL NOT NULL,
  drawdown  REAL,
  PRIMARY KEY(run_uuid, ts)                       -- idempotent re-ingest (R2.H4)
);

CREATE TABLE freqtrade_backtest_trades (
  run_uuid    TEXT NOT NULL REFERENCES freqtrade_runs(run_uuid) ON DELETE CASCADE,
  pair        TEXT NOT NULL,
  open_ts     INTEGER NOT NULL,
  close_ts    INTEGER,
  open_rate   REAL NOT NULL,
  close_rate  REAL,
  profit_pct  REAL,
  PRIMARY KEY(run_uuid, pair, open_ts)            -- idempotent re-ingest
);
CREATE INDEX idx_ft_trades_run ON freqtrade_backtest_trades(run_uuid);

CREATE TABLE live_strategy_pulse (
  ts            INTEGER PRIMARY KEY,              -- floor(now_ms / 300_000) * 300_000
  fill_rate     REAL,
  drift_score   REAL,
  signal_total  INTEGER
);

CREATE TABLE dashboard_metrics (
  ts     INTEGER NOT NULL,
  key    TEXT NOT NULL,
  value  REAL,
  PRIMARY KEY(ts, key)
);
CREATE INDEX idx_dashboard_metrics_ts ON dashboard_metrics(ts);

INSERT INTO schema_version(version, applied_at) VALUES (1, strftime('%s','now')*1000);
