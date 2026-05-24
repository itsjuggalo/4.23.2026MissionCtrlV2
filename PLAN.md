# UI eye-candy upgrade: Desk / ITB / Freqtrade / Live Strategy

## Context

The four pages (`DeskPage`, `ITBPage`, `FreqtradePage`, `LiveStrategyPage`) are functional but visually drift from the rest of MissionCtrlV2 in two ways:

1. **Off-palette inline styles.** All four declare colors as inline hex (`#0f1620` bg, `#5fa3ff` blue, `#1f2a35` border) instead of the official tokens in `src/app/globals.css` (`--color-mc-bg: #0d1117`, `--color-mc-accent: #4fc3f7` cyan, `--color-mc-border: #1a3a4a`). The result is "close but visibly off" — a blueish dark-grey look against the rest of the site's cyan/navy.
2. **Walls of dense tables + zero charts.** `recharts ^3.8.1` is already installed but unused on these pages. Rich timeseries / categorical data (Live Strategy signals & drift, Freqtrade backtest equity, ITB pipeline runs, Desk lane×stage state) is rendered as monospace tables. Each page also re-declares its own local `Card` / `KV` / `MetricBox` helpers instead of using the shared `src/components/ui/*` set.

User goal: keep **all the data** visible, but make it **eye candy** — animated, glassy, with sparklines, a heatmap, gradient headers, and a buy/sell signal chart. Color scheme must be unified to the official `mc-*` tokens across the whole site (with a flagged audit of remaining offenders).

This work also serves as the test bed for Mark Kashef's `/claudex` workflow — Codex will pressure-test this plan in 3 rounds before any code is written (see [Workflow](#workflow) below).

---

## Workflow

1. Plan locks (this file).
2. Exit plan mode.
3. User fires `/claudex` → Codex roasts the plan in 3 rounds (design flaws → race conditions / auth gaps → rollback / versioning).
4. Revise plan if needed, then execute.

Mark's `/claudex` source: `~/second-brain/skool/earlyaidopters/undated_claudex_-_Codex_grills_Claude_Code's_plans_before_you_build_·_Early_AI-dopters.md` (github.com/promptadvisers/claudex).

---

## Phase 1 — Color/token migration (foundation)

**Why first:** every visual upgrade below uses the official tokens. Doing colors last would mean two passes.

**Token mapping** (apply to all 4 pages):

| Old inline hex | New token |
|---|---|
| `#0f1620`, `#0a1117`, `#070b10` | `bg-mc-bg-surface` / `bg-mc-bg` (surface vs page) |
| `#0f1620` card bg | `bg-mc-bg-card` |
| `#1f2a35`, `#2a3540`, `#1a2530` borders | `border-mc-border` / `border-mc-border-light` on hover |
| `#5fa3ff` blue accent | `text-mc-accent` / `bg-mc-accent` (#4fc3f7 cyan) |
| `#cfd6dd`, `#e0e6ec`, `#e6edf3` body | `text-mc-text` (#e0e0e0) |
| `#8a99a8`, `#94a3b8` muted | `text-mc-text-muted` (#607d8b) |
| `#5a6470`, `#455a64`, `#64748b` dim | `text-mc-text-dim` (#455a64) |
| `#22c55e`, `#86efac` green | `text-mc-green` (#66bb6a) |
| `#ef4444`, `#fca5a5`, `#dc2626` red | `text-mc-red` (#ef5350) |
| `#f59e0b`, `#f97316`, `#facc15`, `#ff9800` amber | `text-mc-amber` (#ff9800) |

**Per-page changes:** convert inline `style={{ background, color, border }}` to Tailwind classes referencing the tokens. Keep layout/spacing inline styles untouched to limit blast radius.

**Drop locally re-declared `Card` / `KV` / `MetricBox` / `Stat` / `FloorCard`** at the bottom of each page. Replace usages with:
- `src/components/ui/Card.tsx`
- `src/components/ui/MetricCard.tsx` (extend with optional `trend`, `sparklineData`, `severity` props — see Phase 2)
- `src/components/ui/Badge.tsx` for verdict/decision pills
- `src/components/ui/StatusDot.tsx` + `LiveIndicator.tsx` for the pulse pills
- `src/components/ui/SectionHeader.tsx` for the cyan section labels

**Site-wide audit (read-only report, no auto-edits):** add `scripts/audit-inline-colors.mjs` that greps `src/components/**/*.tsx` for hex literals not in the whitelist and writes `audit-inline-colors.md` listing file:line offenders. Run it once at end of Phase 1, commit the report, leave other pages untouched. User decides follow-up.

---

## Phase 2 — Shared visual primitives (build once, reuse on all 4 pages)

Add to `src/components/ui/`:

1. **`Sparkline.tsx`** — tiny line chart (recharts `LineChart` with no axes, single mc-accent stroke, optional gradient fill). Props: `data: number[]`, `color?`, `height = 32`, `fill?: boolean`. Used inside KPI cards.
2. **`RadialGauge.tsx`** — recharts `RadialBarChart`, single arc, severity-colored. Props: `value`, `max`, `severity?`. Used for fill rate / drift score.
3. **`Heatmap.tsx`** — generic 2-D heatmap (CSS grid + token-driven cell color). Props: `rows`, `cols`, `value(r,c) → { score, label, severity }`. Used for Desk lane×stage and Freqtrade pair grid.
4. **`SignalChart.tsx`** — **the buy/sell signal chart the user asked for.** recharts `ComposedChart`: price `LineChart` + `ReferenceDot`s where buys (green ▲) and sells (red ▼) fired. Props: `priceSeries: {t, close}[]`, `signals: {t, side: 'buy'|'sell', price}[]`, `height = 220`. Used on Live Strategy (per-pair) and embeddable on Freqtrade (backtest signals).
5. **`PulseDot.tsx`** — extend `StatusDot` with a `pulse?: boolean` prop driving a `@keyframes pulse` (already defined locally in LiveStrategyPage — promote it).
6. **`GlassPanel.tsx`** — wrapper applying `backdrop-blur-sm bg-mc-bg-card/70 border border-mc-border` + a 1-px gradient top stripe (`linear-gradient(90deg, mc-accent 0%, transparent 50%)`). Glassmorphism container.
7. **`GradientHeader.tsx`** — section/page header with the cyan→navy gradient accent stripe.

All seven use the mc-* tokens, no hardcoded hex.

---

## Phase 3 — Backend reshape (new API fields + persistence)

Per user's "Full rebuild including backend reshape" choice — all changes are **additive** so the dashboard works during rollout.

### 3a. New SQLite store for run history

New file: `data/dashboard_history.sqlite` (local to MissionCtrlV2, separate from `options_flow.sqlite` per the data-layer rule — RAG = memory, trade SQL = trades, this is **dashboard telemetry**).

Tables:
- `itb_runs(id, ts, script, config, exit_code, elapsed_ms, stdout_tail, stderr_tail)` — written by `/api/itb` POST handler
- `freqtrade_runs(id, ts, subcommand, args, exit_code, elapsed_ms)` — written by `/api/freqtrade` POST handler
- `freqtrade_backtest_curves(run_id, ts, equity, drawdown)` — populated when `backtesting` exits OK by parsing its result JSON
- `live_strategy_pulse(ts, fill_rate, drift_score, signal_total)` — written hourly by a small cron / on each `/api/live-strategy` GET (debounced 5 min) so we can build a true 30-day timeseries

Helper: `src/lib/dashboard-db.ts` — single sqlite3 handle, prepared statements, init-if-missing.

### 3b. API extensions (all backwards-compatible — additive fields only)

| Route | Add |
|---|---|
| `/api/itb` GET | `runs: { ts, script, ok, elapsed_ms }[]` (last 50), `pipeline_health: { script: { p50_ms, last_ok_ts } }` |
| `/api/freqtrade` GET | `runs: ...[]` (last 50), `backtest_history: { strategy, pair, equity_curve: [{t,equity}], total_profit_pct, win_rate, sharpe }[]` parsed from `backtest_results/` JSONs |
| `/api/live-strategy` GET | `signal_timeseries: { t, n_submitted, n_suppressed, n_rejected }[]` (30d daily buckets), `fill_rate_timeseries: { t, fill_rate }[]`, `drift_timeseries: { t, drift_score }[]`, **per-pair `price_history` + `signal_markers`** for `SignalChart` |
| `/api/desk-cycle` GET | `cycle_history: { cycle_id, ran_at, n_candidates, n_dossiers, n_shortlist, duration_s }[]` (last 30 cycles), `lane_stage_matrix: { lane, stages: { slot: 'pass'\|'fail'\|'pending'\|'na' } }` ready-baked for the heatmap |

### 3c. Persistence hooks

- `/api/itb` POST handler: on script completion, INSERT into `itb_runs`.
- `/api/freqtrade` POST handler: same. When subcommand is `backtesting` and exit_code===0, also parse the newest `user_data/backtest_results/*.json` and insert curve points.
- `/api/live-strategy` GET: append a `live_strategy_pulse` row at most every 5 minutes (cheap upsert).

---

## Phase 4 — Page-by-page visual upgrade

### LiveStrategyPage (`src/components/pages/LiveStrategyPage.tsx`)

- Hero: replace 4 plain KPI cards with `<MetricCard>` + embedded `<Sparkline>` (signals last 30d, fill_rate last 30d, drift last 30d, frequency ratio last 30d).
- Drift card upgraded to `<RadialGauge value={drift} max={10} severity={ds.label}>` — color-coded arc.
- Webhook pill: promote inline `@keyframes pulse` to global, use `<PulseDot pulse={data.config.enabled}>`.
- **New section: per-pair `<SignalChart>`** — for each pair in `bot_status.pairs`, render the user's requested chart: 1h price series + green ▲ on buy fires, red ▼ on sell fires, mc-accent cyan baseline. Pulled from new `price_history` + `signal_markers` fields.
- Account panels wrapped in `<GlassPanel>` (backdrop-blur).
- "RECENT SIGNALS" / "RECENT WEBHOOK LOG" tables: same data, but use `<Badge severity=...>` for decision/outcome cells and pulse-fade-in animation on the newest row.

### DeskPage (`src/components/pages/DeskPage.tsx`)

- Top bar wrapped in `<GradientHeader>`.
- **Floor 3 / Floor 4 lanes×stages → `<Heatmap>`** — replaces the dense chip grid. Cells colored mc-green / mc-amber / mc-red / mc-text-dim per stage state. Hover tooltip shows the lane verdict + key observations.
- Floor 1 scout chips: keep grid layout, add a sparkline of `n_candidates` per scout over last N cycles (from new `cycle_history`).
- Cycle history (new): horizontal mini-timeline above the floors — last 30 cycles as colored bars, height = `n_dossiers`. Click → scrubs the rest of the page to that cycle.
- Asset-class filter chips: use `<Badge>` with mc-accent active state.

### ITBPage (`src/components/pages/ITBPage.tsx`)

- Repo / venv / configs cards → shared `<MetricCard>` with status pulse dots.
- Dep grid: keep the chip layout, swap inline reds/greens for tokens, add fade-in on dep load.
- **Pipeline buttons → `<Heatmap>` row showing last-run health per script** — color = last exit code, intensity = recency. Click still runs the script.
- New section "RUN HISTORY" — last 50 runs as a `<ComposedChart>` (bar per run, height = elapsed_ms, color = exit_code).
- Output console wrapped in `<GlassPanel>`, ANSI colors preserved.

### FreqtradePage (`src/components/pages/FreqtradePage.tsx`)

- Status cards → shared `<MetricCard>`.
- Subcommand buttons: keep grid, add per-command "last-run-ago" sparkline pulled from `freqtrade_runs`.
- **New section "BACKTEST GALLERY"** — for each row in `backtest_history`, render a card with: strategy + pair badges, `<Sparkline>` of equity curve, win-rate ring (`<RadialGauge>`), profit% big number. Click a card → expands with full `<SignalChart>` of buys/sells over the backtest window.
- Strategies / Data / Backtest file tables: same data, in `<GlassPanel>` with `<Badge>` for file types.

---

## Critical files

- Migrate / rewrite: `src/components/pages/{DeskPage,ITBPage,FreqtradePage,LiveStrategyPage}.tsx`
- Extend APIs (additive): `src/app/api/{itb,freqtrade,live-strategy,desk-cycle}/route.ts`
- New shared primitives: `src/components/ui/{Sparkline,RadialGauge,Heatmap,SignalChart,PulseDot,GlassPanel,GradientHeader}.tsx`
- Extend: `src/components/ui/{Card,MetricCard,Badge,StatusDot}.tsx`
- New: `src/lib/dashboard-db.ts`, `data/dashboard_history.sqlite` (gitignored)
- New: `scripts/audit-inline-colors.mjs` + generated `audit-inline-colors.md`
- Possibly touch `src/app/globals.css` to promote the local `@keyframes pulse` from LiveStrategyPage to global.

**Reuse, don't recreate:**
- `src/components/ui/Card.tsx`, `MetricCard.tsx`, `Badge.tsx`, `StatusDot.tsx`, `LiveIndicator.tsx`, `ProgressBar.tsx`, `SignalBar.tsx`, `SectionHeader.tsx`, `TrendArrow.tsx` — all already token-correct.

---

## Verification

1. **Dev server**: `cd ~/sites/missioncontrol/MissionCtrlV2 && npm run dev` → open `http://localhost:3000/dashboard?page=desk` (and `=itb`, `=freqtrade`, `=live-strategy`). Visually confirm cyan/navy palette matches Flow Database + Performance pages.
2. **Color audit**: `node scripts/audit-inline-colors.mjs` — should report 0 offenders inside the four target pages and a list (not a fix) for everywhere else.
3. **API regression**: hit each route directly (`curl localhost:3000/api/itb | jq` etc.) — confirm all original fields still present (additive-only contract).
4. **Backend persistence**: trigger an ITB script run from the UI → confirm new row in `itb_runs`. Trigger a Freqtrade backtest → confirm `freqtrade_backtest_curves` populated. Wait 5 min on Live Strategy page → confirm `live_strategy_pulse` row.
5. **Charts render**: each page should show at least one recharts component without console errors. SignalChart specifically should show buy ▲ / sell ▼ markers on the price line on Live Strategy.
6. **No regression on Flow Database / Performance / other untouched pages** (smoke-click them).
7. **Lighthouse / perf**: backdrop-blur is GPU-heavy — confirm scroll stays >50fps on the Desk page with all floors visible.
