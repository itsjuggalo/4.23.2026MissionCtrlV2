# MissionCtrlV2 Rollout Log

Records each canary check outcome per Phase 5d. Update this file as you flip flags.

---

## Phase 5b Step 1 — Deploy with everything off

**Date:**
**Operator:**
**Flags:** `DB_ENABLED=true`, `EXEC_ENABLED=false`, `AUTH_MODE=warn`, `UI_V2_PAGES=`, `RETENTION_ENABLED=false`

**Checks:**
- [ ] `npm run dev` starts without errors
- [ ] `curl http://localhost:3000/api/health | jq` returns `ok: true`
- [ ] `data/dashboard_history.sqlite` created with `schema_version=1`
- [ ] All four pages still render (Desk, ITB, Freqtrade, Live Strategy)
- [ ] No regression on Flow Database / Performance pages

**Outcome:**
**Notes:**

---

## Phase 5b Step 2 — DB telemetry soak (1 day)

**Date:**
**Operator:**

**Checks:**
- [ ] `live_strategy_pulse` rows accumulating (5-min buckets)
- [ ] `dashboard_history.sqlite` size is stable
- [ ] No `dbTelemetryWrite` errors in server log

**Outcome:**
**Notes:**

---

## Phase 5b Step 3 — Flip AUTH_MODE warn → enforce

**Date:**
**Operator:**

**Pre-checks:**
- [ ] Visit `http://localhost:3000/dashboard?page=desk` in browser
- [ ] DevTools → Application → Cookies → confirm `mc_sess` (HttpOnly) + `mc_csrf` (readable) are set
- [ ] Sensitive GET works: `curl -b <mc_sess_cookie> http://localhost:3000/api/live-strategy` → 200
- [ ] Watch warn-log for 1 hour — no unauthenticated cron/scraper hitting sensitive routes

**After flip:**
- [ ] `curl http://localhost:3000/api/live-strategy` (no cookie) → 401
- [ ] With cookie → 200

**Outcome:**
**Notes:**

---

## Phase 5b Step 4 — UI_V2_PAGES rollout (per-page)

### desk

**Date:**
**Checks:**
- [ ] Desk page renders with v2 Heatmap + cycle timeline (no console errors)
- [ ] Heatmap cells are keyboard-accessible
- [ ] Collapsible data table present under heatmap

**Outcome:**

### itb

**Date:**
**Checks:**
- [ ] ITB page renders with v2 run history chart
- [ ] Existing pipeline buttons still work

**Outcome:**

### freqtrade

**Date:**
**Checks:**
- [ ] Freqtrade page renders with v2 backtest gallery
- [ ] Existing subcommand buttons still work

**Outcome:**

### live-strategy

**Date:**
**Checks:**
- [ ] Live Strategy renders with SignalChart per pair
- [ ] Empty-state renders when `price_source=unavailable`

**Outcome:**

---

## Phase 5d Canary — Enable EXEC_ENABLED=true

**Date:**
**Operator:**
**Day:** (recommend Sunday — low activity)

**Pre-requisites (must all pass):**
- [ ] `tests/migrations.test.ts` — all 7 scenarios pass
- [ ] `tests/auth.test.ts` — all auth scenarios pass

**Smoke tests:**
- [ ] Run ITB script from UI → reaches `status='ok'`, audit log has line
- [ ] Run Freqtrade backtest → `artifact_path` = deterministic `backtest_<uuid>.json`, curves + trades ingested
- [ ] Kill Next.js mid-backtest, restart → reconciler flips orphan to `killed`, artifact ingested
- [ ] Double-click Run button → second POST returns same `run_uuid`, no second child
- [ ] Load test: 10× page refresh in 30s during backtest → exec p99 < 200ms

**All passed?** [ ] Yes → flip `EXEC_ENABLED=true`

**Outcome:**
**Notes:**

---

## Phase 5b Step 6 — Enable RETENTION_ENABLED=true

**Date:** (target: 1 month after initial deploy)
**Operator:**

**Checks:**
- [ ] `systemctl --user start mc-dashboard-retention.service` — runs without error
- [ ] Journal shows rows pruned count
- [ ] `schema_version=1` still intact after prune

**Outcome:**
**Notes:**
