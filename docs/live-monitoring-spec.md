# Live Monitoring + Drift-Detection Spec — PullbackTrend_1h

**Author:** The Auditor (Tier-4)
**Date:** 2026-05-22
**Strategy under monitoring:** `PullbackTrend_1h_swing` (Pine) → `/api/tv-webhook/[secret]` → Alpaca paper (Boba/Jazzy)
**Backtest benchmark (the line we measure against):**
- OOS Oct-2025 → May-2026, 6-pair basket: 62 trades, 66.1% WR, +3.52%, 0.39% DD, Sharpe 2.72
- Train Jun-2024 → Oct-2025: 274 trades, 67.5% WR, +12.83%, 2.24% DD, Sharpe 2.56
- Expected live: ~3-8 trades/month/basket, ~65-70% WR, ~0.5-1.5% monthly profit

**Companion docs:**
- `tv-webhook-spec.md` (receiver + audit table `tv_webhook_log`)
- `strategy-risk-spec.md` (kill switches + risk caps)

> Spec only. Implementation by `@executor` after operator sign-off.

---

## 0. Design principles

1. **Separate signal from execution.** Pine fires; webhook decides whether to submit; Alpaca decides whether to fill. Three independent failure planes → three independent logs.
2. **Drift = (live distribution) vs (backtest distribution).** Every metric is a comparison, never an absolute. "Win rate 60%" means nothing without the 66.1% baseline.
3. **Catch silent degradation before $1k loss.** At 0.5% risk/trade on a $10k account = $50/trade. The system must trip before 20 consecutive process losses become regime breakdown. Threshold tuning is calibrated to that economics.
4. **Process loss vs edge loss.** Rules-followed-and-lost is fine. Rules-broken (or rules-still-firing-but-distribution-shifted) is a flag. Every alert says which.
5. **No new infra.** SQLite next to `tv_webhook_log.sqlite`. Systemd timers. Discord + Telegram. Reuse the existing webhook + mc-trades pattern.

---

## 1. Data schemas — what to log

### 1a. SQLite DB location

`~/sites/missioncontrol/MissionCtrlV2/data/live_trades.sqlite`

Driver: `better-sqlite3` (synchronous, matches `tv_webhook_log.sqlite`).
WAL mode enabled. Daily `VACUUM` via the 03:00 UTC reconciliation job (§4).

### 1b. Table `live_signals` — every Pine alert that hits the webhook, regardless of outcome

This is the *intent* log. One row per inbound alert. Pre-execution.

```sql
CREATE TABLE IF NOT EXISTS live_signals (
  id                  INTEGER PRIMARY KEY AUTOINCREMENT,           -- monotonic
  received_at         TEXT    NOT NULL,                            -- ISO-8601 UTC, server wall clock
  bar_time            TEXT    NOT NULL,                            -- ISO-8601 UTC, from Pine alert (close of signal bar)
  bar_time_epoch_ms   INTEGER NOT NULL,                            -- denormalised for fast joins
  strategy            TEXT    NOT NULL,                            -- 'PullbackTrend_1h_swing'
  strategy_version    TEXT    NOT NULL,                            -- semver-ish, e.g. '1.0.0', bumped on any Pine edit
  account             TEXT    NOT NULL,                            -- 'boba'|'jazzy'
  symbol              TEXT    NOT NULL,                            -- normalised, e.g. 'BTC/USD'
  timeframe           TEXT    NOT NULL,                            -- '1h'
  action              TEXT    NOT NULL,                            -- 'buy'|'sell'
  alert_price         REAL    NOT NULL,                            -- Pine's `close` at signal bar
  stop_price          REAL    NOT NULL,                            -- Pine-computed (close - 2.5*ATR)
  tp1_price           REAL    NOT NULL,                            -- Pine-computed (+1R partial)
  tp2_price           REAL    NOT NULL,                            -- Pine-computed (+3R)
  quantity_requested  REAL    NOT NULL,                            -- Pine's requested qty
  atr_at_signal       REAL,                                        -- nullable until Pine starts emitting it; PHASE 2
  rsi_at_signal       REAL,                                        -- nullable, PHASE 2
  htf_close           REAL,                                        -- daily close at signal bar, PHASE 2
  htf_ema50           REAL,                                        -- 1d EMA50 at signal bar, PHASE 2
  dedupe_key          TEXT    NOT NULL,                            -- same hash as tv_webhook_log.dedupe_key
  decision            TEXT    NOT NULL,                            -- 'submitted'|'suppressed'|'rejected'|'duplicate'
  suppression_reason  TEXT,                                        -- 'kill_switch'|'daily_dd'|'concurrent_cap'|'correlation_cap'|'symbol_unsupported'|'market_closed'|NULL
  rejection_reason    TEXT,                                        -- Alpaca-side: 'insufficient_buying_power'|'halted'|'4xx_other'|'5xx'|NULL
  webhook_log_id      INTEGER,                                     -- FK -> tv_webhook_log.id (cross-DB; store as int)
  raw_payload         TEXT    NOT NULL,                            -- full Pine JSON, secret-scrubbed
  notes               TEXT                                         -- free text from reconciliation pass
);
CREATE INDEX IF NOT EXISTS ix_sig_bartime    ON live_signals(bar_time_epoch_ms);
CREATE INDEX IF NOT EXISTS ix_sig_symbol_bt  ON live_signals(symbol, bar_time_epoch_ms);
CREATE INDEX IF NOT EXISTS ix_sig_dedupe     ON live_signals(dedupe_key);
CREATE INDEX IF NOT EXISTS ix_sig_decision   ON live_signals(decision, received_at DESC);
```

**Nullable rationale:** anything Pine doesn't currently emit (ATR, RSI, HTF state) is nullable now and required Phase 2 — see §6 lookahead audit, which needs them.

### 1c. Table `live_trades` — every Alpaca fill (entry + each exit leg)

This is the *execution* log. One row per **leg fill** (entry, TP1, TP2/SL exit, HTF-break manual close). Joined back to a signal via `signal_id` and to other legs via `bracket_group_id`.

```sql
CREATE TABLE IF NOT EXISTS live_trades (
  id                    INTEGER PRIMARY KEY AUTOINCREMENT,
  signal_id             INTEGER NOT NULL,                          -- FK -> live_signals.id
  bracket_group_id      TEXT    NOT NULL,                          -- shared by entry + both child orders (see tv-webhook §5b crypto OCO)
  alpaca_order_id       TEXT    NOT NULL UNIQUE,                   -- Alpaca's UUID
  alpaca_client_order_id TEXT   NOT NULL,                          -- our dedupe-derived id
  account               TEXT    NOT NULL,                          -- 'boba'|'jazzy'
  symbol                TEXT    NOT NULL,
  leg                   TEXT    NOT NULL,                          -- 'entry'|'tp1'|'tp2'|'sl'|'htf_break'|'manual_close'
  side                  TEXT    NOT NULL,                          -- 'buy'|'sell'
  order_type            TEXT    NOT NULL,                          -- 'market'|'limit'|'stop'|'stop_limit'
  submitted_at          TEXT    NOT NULL,                          -- ISO-8601 UTC
  filled_at             TEXT,                                      -- nullable: NULL until filled
  cancelled_at          TEXT,                                      -- nullable
  quantity_requested    REAL    NOT NULL,
  quantity_filled       REAL,                                      -- nullable until fill
  limit_price           REAL,                                      -- nullable
  stop_price            REAL,                                      -- nullable
  fill_price_avg        REAL,                                      -- avg fill, nullable until fill
  fees_paid             REAL,                                      -- nullable
  status                TEXT    NOT NULL,                          -- 'submitted'|'partial'|'filled'|'cancelled'|'rejected'|'expired'
  realized_pnl          REAL,                                      -- nullable; computed on exit-leg fills only
  realized_pnl_pct      REAL,                                      -- nullable; (exit - entry) / entry, sign-corrected
  realized_r            REAL,                                      -- nullable; (exit - entry) / (entry - stop), sign-corrected
  slippage_bps          REAL,                                      -- nullable; (fill_price_avg - alert_price)/alert_price*10000, side-signed
  alpaca_raw            TEXT    NOT NULL,                          -- full Alpaca order JSON snapshot at terminal state
  reconciled_at         TEXT,                                      -- nullable; set by §4 daily job
  reconciliation_status TEXT                                       -- nullable; 'match'|'missing_backtest'|'extra_live'|'param_drift'
);
CREATE INDEX IF NOT EXISTS ix_trd_signal   ON live_trades(signal_id);
CREATE INDEX IF NOT EXISTS ix_trd_bracket  ON live_trades(bracket_group_id);
CREATE INDEX IF NOT EXISTS ix_trd_symbol   ON live_trades(symbol, submitted_at DESC);
CREATE INDEX IF NOT EXISTS ix_trd_status   ON live_trades(status, submitted_at DESC);
CREATE INDEX IF NOT EXISTS ix_trd_filled   ON live_trades(filled_at);
```

### 1d. Supporting tables

```sql
-- One row per "trade" (entry + all exits collapsed). Materialised view, rebuilt by reconciliation job.
CREATE TABLE IF NOT EXISTS live_trade_summary (
  bracket_group_id    TEXT PRIMARY KEY,
  signal_id           INTEGER NOT NULL,
  account             TEXT NOT NULL,
  symbol              TEXT NOT NULL,
  entry_time          TEXT NOT NULL,
  exit_time           TEXT,
  entry_price         REAL NOT NULL,
  exit_price_weighted REAL,
  quantity            REAL NOT NULL,
  net_pnl             REAL,                                        -- includes fees
  net_pnl_pct         REAL,
  net_r               REAL,
  hold_minutes        INTEGER,
  exit_reason         TEXT,                                        -- 'tp2'|'tp1+trail'|'sl'|'htf_break'|'manual'|'open'
  status              TEXT NOT NULL                                -- 'open'|'closed'|'partial'
);
CREATE INDEX IF NOT EXISTS ix_summ_account   ON live_trade_summary(account, entry_time DESC);
CREATE INDEX IF NOT EXISTS ix_summ_symbol    ON live_trade_summary(symbol, entry_time DESC);
CREATE INDEX IF NOT EXISTS ix_summ_status    ON live_trade_summary(status);

-- Computed drift snapshots, one row per metric per evaluation. Time-series of the audit.
CREATE TABLE IF NOT EXISTS drift_snapshots (
  id              INTEGER PRIMARY KEY AUTOINCREMENT,
  computed_at     TEXT NOT NULL,
  metric          TEXT NOT NULL,                                   -- see §2 enumeration
  scope           TEXT NOT NULL,                                   -- 'basket'|'pair:BTC/USD'|'account:boba'
  window_def      TEXT NOT NULL,                                   -- 'rolling_20'|'rolling_30d'|'mtd'|...
  live_value      REAL,
  baseline_value  REAL,
  delta           REAL,
  delta_pct       REAL,
  severity        TEXT NOT NULL,                                   -- 'ok'|'warning'|'critical'|'hard_kill'
  alerted         INTEGER NOT NULL DEFAULT 0,                      -- 0/1 — was alert dispatched
  notes           TEXT
);
CREATE INDEX IF NOT EXISTS ix_drift_metric ON drift_snapshots(metric, computed_at DESC);
CREATE INDEX IF NOT EXISTS ix_drift_sev    ON drift_snapshots(severity, computed_at DESC);

-- Daily backtest re-run output, one row per re-run.
CREATE TABLE IF NOT EXISTS backtest_replay (
  id               INTEGER PRIMARY KEY AUTOINCREMENT,
  run_at           TEXT NOT NULL,
  window_start     TEXT NOT NULL,
  window_end       TEXT NOT NULL,
  strategy_version TEXT NOT NULL,
  freqtrade_hash   TEXT NOT NULL,                                  -- git rev of freqtrade tree at run time
  trades_count     INTEGER NOT NULL,
  matched_count    INTEGER NOT NULL,                               -- (live ∩ replay)
  missed_count     INTEGER NOT NULL,                               -- (replay \ live)
  extra_count      INTEGER NOT NULL,                               -- (live \ replay)
  pnl_replay       REAL NOT NULL,
  pnl_live         REAL NOT NULL,
  pnl_delta_pct    REAL NOT NULL,
  drift_score      REAL NOT NULL,                                  -- 0..10, see §4
  report_json      TEXT NOT NULL                                   -- full per-trade comparison
);

-- Heartbeats: webhook receiver, Alpaca polling, TV last-seen.
CREATE TABLE IF NOT EXISTS heartbeats (
  component       TEXT PRIMARY KEY,                                -- 'webhook'|'alpaca_poll'|'tv_last_seen:BTC/USD'|...
  last_seen_at    TEXT NOT NULL,
  status          TEXT NOT NULL,                                   -- 'ok'|'degraded'|'down'
  detail          TEXT
);

-- Catastrophic event journal, append-only.
CREATE TABLE IF NOT EXISTS incident_journal (
  id              INTEGER PRIMARY KEY AUTOINCREMENT,
  occurred_at     TEXT NOT NULL,
  category        TEXT NOT NULL,                                   -- 'webhook_crash'|'alpaca_5xx'|'tv_silent'|'pine_nan'|'dd_breach'|'lookahead_diverge'
  severity        TEXT NOT NULL,                                   -- 'warning'|'critical'|'hard_kill'
  summary         TEXT NOT NULL,
  detail_json     TEXT NOT NULL,
  resolved_at     TEXT,
  resolved_by     TEXT
);
```

### 1e. Answering "did the live signal fire when the backtest signal fired?"

```sql
-- All backtest replay trades in the last 30d that DID NOT match a live signal:
SELECT br.report_json, ls.id
FROM backtest_replay br
LEFT JOIN live_signals ls
  ON json_extract(br.report_json, '$.dedupe_key') = ls.dedupe_key
WHERE br.run_at >= datetime('now','-30 days')
  AND ls.id IS NULL;
```

The `dedupe_key` hash (`sha256(account|symbol|action|bar_time|strategy)` — same formula as `tv_webhook_log`) is the join key. Replay generates the same hash for each historical entry; if not present in `live_signals`, the Pine alert never fired (or never reached us).

---

## 2. Drift metrics + thresholds

Computed every 15 minutes during US market hours, every 60 minutes off-hours. Each computation writes a row to `drift_snapshots`. Severity ladder: `ok` → `warning` → `critical` → `hard_kill`.

**Baselines (frozen constants in `src/lib/live-monitoring/baselines.ts`):**
- `BASELINE_WIN_RATE = 0.661` (OOS, more conservative than 0.675 train)
- `BASELINE_AVG_PROFIT_PCT = 0.0057` (3.52% / 62 trades)
- `BASELINE_SHARPE = 2.72`
- `BASELINE_AVG_TRADES_PER_MONTH_PER_BASKET = 8.85` (62 / 7 months)
- `BASELINE_MAX_DD_PCT = 0.0039`
- `BASELINE_WIN_RATE_CI95 = [0.54, 0.78]` (Wilson score, n=62)

### 2.1 Rolling 20-trade win rate

| Field | Value |
|---|---|
| Definition | `wins / 20` where `wins = COUNT(*) WHERE net_pnl > 0` over the **last 20 closed trades**, scope = basket |
| Computation | `SELECT AVG(CASE WHEN net_pnl > 0 THEN 1.0 ELSE 0.0 END) FROM (SELECT net_pnl FROM live_trade_summary WHERE status='closed' ORDER BY exit_time DESC LIMIT 20)` |
| Warmup | Do not compute until ≥ 15 closed trades; emit `severity='ok'` and `notes='warmup'` |
| Warning | `live_wr < 0.51` (15 pp below 0.661) — Discord |
| Critical | `live_wr < 0.41` (25 pp below baseline) — Discord + Telegram. This is the operator's $1k tripwire: 20 trades × 0.5% risk × 60% loss rate ≈ -$60 net but the trajectory says next 20 will hurt |
| Hard kill | `live_wr < 0.30` over last 20 AND drawdown >2% — flip `TV_WEBHOOK_ENABLED=false` |
| Per-pair variant | Same metric scoped to each of the 6 pairs separately, warning at `pair_wr < 0.40` (lower bar because n is small — Wilson lower bound) |

### 2.2 Rolling 20-trade average profit %

| Field | Value |
|---|---|
| Definition | `AVG(net_pnl_pct)` over last 20 closed trades |
| Baseline | 0.57% (3.52% / 62) |
| Warning | `live_avg < 0.20%` — winners still happen but R has compressed (~3R targets hitting more as 1R partials) |
| Critical | `live_avg < 0.0%` — net negative over 20-trade window |
| Hard kill | `live_avg < -0.50%` over 20 trades — distribution has inverted |

### 2.3 Live Sharpe (rolling 30 days)

| Field | Value |
|---|---|
| Definition | Annualised Sharpe of daily equity-curve returns over the last 30 calendar days (zero rf). Daily return = `(equity_end - equity_start) / equity_start`. |
| Computation | `sharpe = mean(daily_returns) / stdev(daily_returns) * sqrt(365)` (crypto = 365, not 252) |
| Warmup | Need ≥ 20 calendar days and ≥ 10 trades — else emit `notes='warmup'` |
| Warning | `live_sharpe < 1.20` (~55% below 2.72 baseline; matches risk-spec live-go floor of 1.0 with a buffer) |
| Critical | `live_sharpe < 0.50` — not being paid for the risk |
| Hard kill | `live_sharpe < 0.0` AND drawdown > 2.5% — negative carry |

### 2.4 Slippage — fill price vs alert price

| Field | Value |
|---|---|
| Definition | `slippage_bps = (fill_price_avg - alert_price) / alert_price * 10000`, sign-corrected so positive = adverse |
| Per-fill threshold | Computed and stored on every `live_trades.leg='entry'` fill |
| Warning (single trade) | `|slippage_bps| > 10` (0.10%, the spec's tolerance — crypto majors should be tighter) |
| Critical (single trade) | `|slippage_bps| > 30` (0.30%) — also auto-Discord with `@here` |
| Warning (rolling) | `AVG(slippage_bps) over last 20 entries > 8 bps` |
| Critical (rolling) | `AVG(slippage_bps) over last 20 entries > 20 bps` |
| Per-pair sub-metric | Separately tracked: alts (LINK/LTC/XRP) get +5 bps tolerance vs BTC/ETH/SOL |

### 2.5 Fill rate

| Field | Value |
|---|---|
| Definition | `COUNT(decision='submitted' AND alpaca filled) / COUNT(decision != 'duplicate')` over last 7 days |
| Computation | `SELECT COUNT(CASE WHEN ls.decision='submitted' AND lt.status='filled' THEN 1 END) * 1.0 / NULLIF(COUNT(CASE WHEN ls.decision != 'duplicate' THEN 1 END), 0) FROM live_signals ls LEFT JOIN live_trades lt ON lt.signal_id=ls.id AND lt.leg='entry' WHERE ls.received_at >= datetime('now','-7 days')` |
| Warning | `< 0.95` |
| Critical | `< 0.85` — Discord + Telegram. Most signals are being suppressed or rejected; the strategy is effectively off |
| Hard kill | `< 0.50` AND `> 5` signals attempted in the window — pipeline is broken; flip kill switch |
| Companion view | Break out `suppression_reason` and `rejection_reason` in the alert body so the operator sees *why* (insufficient_buying_power vs kill_switch vs market_closed) |

### 2.6 Per-pair drift (basket can mask a rogue)

For each of the 6 pairs, compute (windowed to last 30 days OR last 10 trades on that pair, whichever has more samples):

| Sub-metric | Warning | Critical |
|---|---|---|
| Pair WR vs basket WR | `delta > 25 pp` adverse | `delta > 40 pp` adverse |
| Pair net P&L sign | Negative for 14+ consecutive days while basket positive | Negative for 30+ days |
| Pair trade count | `< 0.5 * expected` (expected = baseline 8.85/6 ≈ 1.5/month/pair, so warn at <1 in last 60 days) | `0 trades in 90 days` (pair has gone silent) |
| Pair slippage vs basket | `> 2x basket avg` | `> 4x basket avg` |

**Action on per-pair critical:** automated Discord with proposal: "Drop {pair} from whitelist? Reply react ✅ to disable." Operator confirms. Updates `TV_WEBHOOK_ACCOUNTS`-style symbol allowlist; does not flatten existing positions.

### 2.7 Calendar drift

| Field | Value |
|---|---|
| Definition | Histogram of fill timestamps by (a) hour-of-day UTC, (b) day-of-week, over rolling 60 days |
| Baseline | Backtest histogram (computed once from the OOS period and stored at `src/lib/live-monitoring/calendar-baseline.json`) |
| Distance metric | Chi-square test live histogram vs baseline; report p-value |
| Warning | `p < 0.05` — clustering is statistically distinguishable from backtest |
| Critical | `p < 0.01` AND `≥ 60%` of live trades fall in a single 6-hour window or single weekday — strong backtest-bias signal |
| Why it matters | If backtest pulled signals from low-liquidity hours (overnight Asia for USD pairs) and Pine `barstate.isconfirmed` on TV uses a different close-of-bar timestamp, live trades will cluster differently — a tell for a subtle data bug |

### 2.8 Trade frequency drift

| Field | Value |
|---|---|
| Definition | Trades in last 30 days vs baseline (8.85) |
| Warning | `live_30d < 4` OR `live_30d > 18` (under or over by ~2x) |
| Critical | `live_30d < 2` over a full 30 days — the strategy is essentially off, regime mismatch or Pine bug |
| Companion check | Number of *signals* should also be in range; if signals are normal but trades are not, that's a fill-rate issue (§2.5), not a Pine issue |

### 2.9 Drift score (composite, 0-10)

Single number on the dashboard. Stored as its own row in `drift_snapshots` with `metric='composite'`.

```
score = clamp(
    2.0 * indicator(WR violation severity)   // 0/1/2/3 for ok/warn/crit/hard
  + 1.5 * indicator(avg_profit violation)
  + 1.5 * indicator(sharpe violation)
  + 1.0 * indicator(slippage rolling violation)
  + 1.0 * indicator(fill_rate violation)
  + 1.5 * indicator(per-pair max violation across the 6)
  + 0.5 * indicator(calendar violation)
  + 1.0 * indicator(frequency violation)
, 0, 10)
```

Bands: 0-2 green, 3-5 yellow, 6-8 orange, 9-10 red. Dashboard surfaces this prominently. Hard-kill triggers when score hits 9 OR any single metric is in `hard_kill` state.

---

## 3. Alert channels

### 3.1 Channel matrix

| Severity | Discord (`discord_bobatrades_webhook`) | Telegram (`telegram_team_bot_token`, chat id from `~/.openclaw/secrets/telegram_team_chat_id`) | Programmatic action |
|---|---|---|---|
| `ok` | (no message; logged to `drift_snapshots` only) | — | — |
| `warning` | Yellow embed, no `@here` | — | — |
| `critical` | Red embed with `@here` | Plain message with summary + drift score | — |
| `hard_kill` | Red embed with `@here`, "KILL SWITCH ENGAGED" header | Plain message, prefixed `[KILL]` | (a) write `.env.local` programmatically: `TV_WEBHOOK_ENABLED=false`; (b) curl webhook `GET` health to verify `enabled:false`; (c) write `incident_journal` row with full state snapshot |

### 3.2 Rate limits (avoid pager fatigue)

- Per-metric per-severity: max 1 alert per 30 minutes. Suppressed repeats are aggregated into the next allowed message ("12 additional triggers in the last 30m").
- Hard-kill: no rate limit (must always fire).
- Discord posts via `fetch` to the webhook URL, body shape per `tv-webhook-spec.md §7`.
- Telegram: `POST https://api.telegram.org/bot{TOKEN}/sendMessage` with `chat_id` + `text` (Markdown disabled to avoid escaping bugs).

### 3.3 Kill-switch mechanism (the only programmatic side-effect)

```
1. Read current .env.local
2. Replace or insert TV_WEBHOOK_ENABLED=false
3. fsync write to a temp file, then atomic rename
4. POST {kind:'kill_switch_engaged', reason:..., metric:...} to webhook GET health (to log into tv_webhook_log)
5. Insert incident_journal row
6. Discord + Telegram
7. Do NOT auto-flatten open positions — broker-resident stops protect them (per risk-spec §8)
```

Manual re-enable only. Operator edits `.env.local`, restarts dev server (or in prod, PM2 restart). The job that engaged the kill switch must NOT also have authority to disengage it.

---

## 4. Daily backtest reconciliation (most important primitive)

### 4.1 Schedule

Systemd timer: `~/sites/missioncontrol/MissionCtrlV2/scripts/monitor/freqtrade-replay.timer`
```
OnCalendar=*-*-* 03:00:00 UTC
Persistent=true
```
Unit: `freqtrade-replay.service`, runs `~/sites/missioncontrol/MissionCtrlV2/scripts/monitor/run-replay.sh`.

### 4.2 Job algorithm

1. Snapshot current strategy: `git rev-parse HEAD` in `~/LapClaw/freqtrade` → `freqtrade_hash`. Refuse to run if dirty tree (uncommitted changes mean replay is non-reproducible).
2. Define window: trailing 30 days, `[now - 30d, now]` UTC, both anchored to 00:00.
3. Run `freqtrade backtesting --strategy PullbackTrend_1h --timeframe 1h --timerange <start>-<end> --config user_data/config-basket.json --export trades --export-filename /tmp/replay-{run_id}.json`.
4. Parse the export. For each backtest trade, compute the same `dedupe_key` as live (account is the basket-fixed default; otherwise use the receiving account in live).
5. Join replay trades vs `live_trade_summary` on `dedupe_key`:
   - **Matched:** present in both. Compare entry_price, exit_price, R, hold_minutes. If `|entry_price_delta| > 0.5%` OR `|R_delta| > 0.3` → flag `reconciliation_status='param_drift'` on the live row.
   - **Missed (replay-only):** flag in report. These are the silent failures: Pine should have fired, did not (or fired and we suppressed).
   - **Extra (live-only):** flag in report. Live fired without backtest agreement — possible Pine repaint, possible operator override.
6. Compute scalar diffs:
   - `pnl_replay` (sum of backtest profit_abs), `pnl_live` (sum of `live_trade_summary.net_pnl`)
   - `pnl_delta_pct = (live - replay) / replay`
7. **Drift score 0-10:**
   ```
   miss_rate = missed / max(replay_count, 1)
   extra_rate = extra / max(live_count, 1)
   pnl_dev = min(abs(pnl_delta_pct), 1.0)
   param_rate = COUNT(param_drift) / matched_count
   score = clamp(round(10 * (0.4*miss_rate + 0.2*extra_rate + 0.3*pnl_dev + 0.1*param_rate), 1), 0, 10)
   ```
8. Insert `backtest_replay` row with full per-trade comparison in `report_json`.
9. Discord summary (always posts, regardless of severity):
   ```
   [DAILY RECONCILIATION 30d window {start}..{end}]
   Replay: {trades_count} trades, {pnl_replay:+.2%}
   Live:   {live_count} trades, {pnl_live:+.2%}
   Match:  {matched}/{replay} ({matched/replay:.0%})
   Missed: {missed}  Extra: {extra}  Param-drift: {param_rate:.0%}
   Drift score: {score}/10   <green|yellow|red>
   ```
   Severity:
   - `score >= 7` → also Telegram + create `incident_journal` `category='reconciliation_diverge'` `severity='critical'`
   - `score >= 9` → trip hard-kill

### 4.3 Why this matters most

This is the only metric that catches **mechanical strategy drift** — when the Pine is no longer firing the trades freqtrade would. Win rate looking fine while replay shows 30% missed signals = the live strategy is a degraded sub-sampler of the backtest, not the backtest. That distinction matters when projecting forward.

### 4.4 Failure modes of the job itself

- Freqtrade backtest fails (config drift, data gap) → insert `incident_journal` `category='reconciliation_failed'`, Discord warning. Do NOT trip hard-kill on job failure alone.
- Job runs longer than 20 minutes → SIGTERM, log incident.
- Repeat consecutive failures (≥ 3) → Telegram + manual investigation flag.

---

## 5. Live dashboard — `Live Strategy` page

### 5.1 Sidebar entry

Add under EXECUTION group in `src/components/layout/Sidebar.tsx`. Slug: `live-strategy`. Page component: `src/components/pages/LiveStrategyPage.tsx`. Route via `AppShellClient.tsx` page map.

### 5.2 Data API surface (read-only, server-only)

Single endpoint, cursorless, returns a fat snapshot. All driven by `live_trades.sqlite`.

`GET /api/live-strategy/snapshot`:
```ts
{
  generated_at: string,                      // ISO-8601
  kill_switch: { enabled: boolean, last_changed_at: string, reason?: string },
  drift_score: { value: number, band: 'green'|'yellow'|'orange'|'red', as_of: string },
  equity_curve: Array<{ t: string, equity: number }>,            // daily points, last 90 days
  divergence_chart: Array<{ t: string, live_pnl_pct: number, replay_pnl_pct: number }>,  // last 30 days
  recent_trades: Array<{                                         // last 25 from live_trade_summary
    bracket_group_id: string, symbol: string, entry_time: string,
    exit_time: string|null, entry_price: number, exit_price_weighted: number|null,
    net_pnl_pct: number|null, net_r: number|null, exit_reason: string, status: 'open'|'closed'|'partial'
  }>,
  drift_metrics: Array<{                                         // latest snapshot per metric
    metric: string, scope: string, live_value: number|null,
    baseline_value: number|null, delta: number|null, severity: string
  }>,
  recent_signals_outcome: { submitted: number, suppressed: number, rejected: number, duplicate: number },  // last 7d
  per_pair: Array<{
    symbol: string, trades_30d: number, win_rate_30d: number|null,
    avg_slippage_bps_30d: number|null, net_pnl_pct_30d: number|null, severity: string
  }>,
  heartbeats: Array<{ component: string, last_seen_at: string, status: string }>,
  open_incidents: Array<{ id: number, category: string, severity: string, occurred_at: string, summary: string }>
}
```

`POST /api/live-strategy/kill-switch` body `{ action: 'engage'|'disengage', reason: string, ack: 'I_UNDERSTAND' }` — privileged, requires `MC_ADMIN_TOKEN` header (read from `~/.openclaw/secrets/mc-admin-token`).

### 5.3 Widgets (top-to-bottom, mobile-first stack)

1. **Status bar:** drift score chip (color-coded), kill switch toggle (with confirm modal requiring typed "DISABLE"), strategy version, last reconciliation timestamp.
2. **Equity curve:** sparkline + line chart, 90 days. Overlay backtest projected equity (constant slope from baseline expected return). Annotate kill-switch events.
3. **Live vs Backtest divergence chart:** two-series line, last 30 days. Shaded band = ±1 stddev of backtest daily P&L. Live exiting the band = visible drift.
4. **Drift metrics table:** every row from §2, columns: metric / scope / live / baseline / delta / severity / last alert at. Sortable. Severity column is the only colored cell.
5. **Per-pair grid:** 6 cards, one per pair. WR / trades / slippage / 30d P&L. Click → filtered recent trades.
6. **Recent trades table:** 25 rows, includes open positions. Columns per §5.2.
7. **Recent signals outcome:** 4-tile counter (submitted / suppressed / rejected / duplicate) with click-through to detail page.
8. **Heartbeats:** dot grid, one per component, green/yellow/red.
9. **Open incidents:** list, with `Resolve` button (writes `resolved_at`).

### 5.4 Component requirements

- Use the existing sqlite-page read pattern from `FlowDatabasePage.tsx`. No new chart lib — reuse whatever is already in `package.json`.
- Server component for the snapshot fetch (avoid client polling); revalidate every 60s via `next: { revalidate: 60 }`.
- Kill-switch toggle is the only mutation; uses a server action.

---

## 6. Survivorship / lookahead audit (weekly)

### 6.1 Schedule

Systemd timer: `OnCalendar=Sun *-*-* 04:00:00 UTC`. Runs after Sunday's daily reconciliation.

### 6.2 What it checks

Lookahead bias is when the Pine indicator silently consumes a future bar (TV's `request.security` without `lookahead=barmerge.lookahead_off` is the classic culprit — already mitigated in the Pine, but verify). Survivorship is when the live whitelist is filtered for "pairs that worked in backtest" and the backtest replay doesn't include the pairs that died.

### 6.3 Procedure

1. Pick a sample of 10 backtest trades from the trailing 7-day window (the daily replay).
2. For each, **re-run the backtest using only data through the signal bar timestamp** (truncated dataset). Specifically: copy `~/LapClaw/freqtrade/user_data/data/{pair}-1h-futures.feather` or equivalent into a temp dir, truncate rows to `<= bar_time`, re-run freqtrade `backtesting` against that pair only with `timerange` ending at `bar_time + 1h`.
3. If the truncated-data backtest still produces the same entry → no lookahead.
4. If the truncated-data backtest does NOT produce the entry → lookahead bias confirmed. Write `incident_journal` `category='lookahead_diverge'` `severity='critical'`, Discord + Telegram, attach the 10-trade diff.
5. Also: enumerate the live whitelist vs the backtest universe. Any pair in backtest universe that has not been traded in 60+ days AND is not in the live whitelist → survivorship flag.

### 6.4 Why weekly

The check is expensive (10 mini-backtests). Daily is overkill; monthly is too sparse to catch a Pine edit that silently introduces lookahead.

---

## 7. Catastrophic event handling

### 7.1 Event catalogue

| Event | Detection | Action |
|---|---|---|
| Webhook receiver crash | `heartbeats.webhook` `last_seen_at < now - 3min` (heartbeat written on every POST; supplementary self-ping every 60s by a sidecar script) | Telegram + Discord critical; auto-`pm2 restart missionctrl` (max 3 restarts per hour, else hard-kill) |
| Alpaca API 5xx > 5 min | Poller hits `/v2/account` every 60s; counts 5xx streak | After 5 consecutive 5xx (5 min): Discord warning. After 10 (10 min): critical + Telegram. Concurrent suppression of new entries via §3.3 kill-switch flag (not hard kill — just pause). Auto-resume after 3 consecutive 200s |
| TradingView silent > 24h on active pair | For each pair with ≥ 1 signal in trailing 30 days: if `last_seen_at < now - 24h` → flag | Discord warning (`@here`). If silent > 72h: Telegram critical. Possible causes: TV alert expired (TV alerts auto-expire after ~60d on free tier), Pine edited and reapplied wrong, exchange feed broken |
| Pine returns NaN | Webhook receiver validates payload: if any of `price/stop_price/tp1/tp2` is NaN/Infinity, mark `decision='rejected'` `rejection_reason='nan_payload'` | Discord critical. After 3 NaN payloads from same pair in 24h: per-pair disable + Telegram |
| Daily DD limit hit (-2%) | Computed from `live_trade_summary` aggregated by `entry_time` day | Per risk-spec §6: block new entries; existing positions run to stops. Discord + Telegram. Auto-resume next UTC day |
| Weekly DD limit hit (-5%) | Rolling 7-day P&L | Hard kill: flip `TV_WEBHOOK_ENABLED=false`. 48h pause. Telegram + Discord. Operator manual re-enable per §3.3 |
| Monthly DD limit hit (-10%) | Rolling 30-day P&L | Hard kill + `incident_journal` `severity='hard_kill'`. **No auto-resume.** Manual operator + risk-manager review required |
| TV webhook log + live_signals divergence | Hourly job: `tv_webhook_log` rows for `strategy='PullbackTrend_1h_swing'` should 1:1 match `live_signals` rows on `dedupe_key` over trailing 24h | If diverge > 2 rows: Discord warning. Likely cause: writer crash mid-insert |
| Disk full on data dir | `df -k ~/sites/missioncontrol/MissionCtrlV2/data` < 500MB free | Discord critical; auto-prune `tv_webhook_log` rows older than 90d (live_trades and drift_snapshots are kept indefinitely) |

### 7.2 Heartbeat writers

- Webhook receiver: write `heartbeats('webhook', now(), 'ok')` on every POST handler entry.
- Alpaca poll sidecar (new): `~/sites/missioncontrol/MissionCtrlV2/scripts/monitor/alpaca-poll.ts`, systemd timer every 60s. Pings `/v2/account` per account, writes `heartbeats('alpaca_poll:{account}', ...)`.
- TV last-seen: derived view (no writer), computed as `MAX(received_at) GROUP BY symbol` over `live_signals`.

---

## 8. Open questions for the operator

1. **Account scope:** monitor Boba only initially, or Boba+Jazzy from day 1? Spec assumes both, with `account` as a scope dimension in every drift metric. If Jazzy isn't running this strategy, set `TV_WEBHOOK_ACCOUNTS=boba` and the per-account metrics simply have one row.
2. **Baseline mutability:** when (if ever) do we re-baseline? Proposal: re-freeze constants in `baselines.ts` after each major Pine version bump AND only after 200 OOS trades on the new version. Until then, drift is measured against the originally validated baselines.
3. **Kill-switch auto-disengage:** spec says manual only. Operator preference confirmed?
4. **Telegram chat:** is the existing team chat the right destination, or should crypto-strategy alerts get a dedicated thread / topic to avoid noise?
5. **Replay job compute:** running on the laptop nightly costs ~5 min of CPU. Run on Oracle instead? Spec assumes laptop because freqtrade tree is local.
6. **Per-pair auto-disable on critical:** operator-confirmed via Discord reaction, or fully manual?

---

## 9. Hand-offs

- **Implementation:** `@executor` — sqlite schema, monitoring jobs, dashboard page, alert dispatch.
- **Pine edits to emit ATR/RSI/HTF state in payload (Phase 2):** `@executor` — required for §6 lookahead audit's truncated-data comparison and for richer drift attribution.
- **Risk-cap interaction:** `@risk-manager` — any threshold changes here must be cross-checked against `strategy-risk-spec.md §6` kill-switch triggers.
- **Portfolio rebalance follow-up if per-pair drift forces whitelist edit:** `@portfolio-monitor`.

---

## 10. The one rule that supersedes everything

> If a metric is unreachable because data is missing, treat that as **`critical`**, not `ok`. Silent monitoring is worse than no monitoring — it generates false comfort. The dashboard must distinguish "metric green" from "metric not computed" with different visual states.

