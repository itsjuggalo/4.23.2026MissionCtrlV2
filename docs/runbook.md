# MissionCtrlV2 Runbook

Anchors in this file are referenced in Discord alert webhook payloads.
Format: `#<alert-slug>` (lowercase, hyphens).

---

## pulse-missing-buckets

**Alert:** `[mc-pulse] N buckets missing since X`

| | |
|---|---|
| **Likely cause** | Timer dead, system was sleeping, or feather cache broken |
| **First action** | `systemctl --user status mc-livestrategy-pulse.timer`<br>`journalctl --user -u mc-livestrategy-pulse -n 50` |
| **Rollback** | `MISSIONCTRL_LS_TIMER_ENABLED=false` + restart Next.js; investigate out-of-band |

---

## migration-failed

**Alert:** `[mc-dashboard] /api/health unreachable` or crash on startup

| | |
|---|---|
| **Likely cause** | Two Next.js processes raced for migration lock, or migration SQL has a bug |
| **First action** | Check `journalctl --user -u mc-dashboard` for the loud crash message<br>Ensure only one process is running<br>If SQL bug: fix migration file, bump version (never edit shipped migrations in place) |
| **Rollback** | If migration partially applied: `MISSIONCTRL_DB_ENABLED=false`, restore `data/dashboard_history.sqlite` from backup (daily borg), retry |

---

## audit-write-rejected

**Alert:** `500 { error: 'audit_unavailable' }` on exec POST

| | |
|---|---|
| **Likely cause** | Disk full, or `data/exec-audit.log` perms wrong |
| **First action** | `df -h ~/sites/missioncontrol/MissionCtrlV2/data`<br>`ls -la data/exec-audit.log` |
| **Fix** | Free disk; `chmod 600 data/exec-audit.log`; restart Next.js |
| **Rollback** | `MISSIONCTRL_EXEC_ENABLED=false` until disk/perms resolved |

---

## ingestion-failed

**Alert:** `ingestion.failed_last_24h > 0` in health check

| | |
|---|---|
| **Likely cause** | Freqtrade JSON schema changed (version upgrade), or artifact file missing |
| **First action** | Find the affected `run_uuid`: `sqlite3 data/dashboard_history.sqlite "SELECT run_uuid, artifact_path, stderr_tail FROM freqtrade_runs WHERE ingestion_status='failed' ORDER BY ts DESC LIMIT 5;"`<br>Inspect `artifact_path` manually |
| **Impact** | Run row stays `status='ok'`, UI shows "metrics unavailable for this run" badge — no data loss |
| **Rollback** | No rollback needed; manually patch the ingestion parser if Freqtrade changed its schema |

---

## stuck-run

**Alert:** `[mc-itb] Stuck run` or `[mc-freqtrade] Stuck run`

| | |
|---|---|
| **Likely cause** | Process hung, DB never got UPDATE, or reconciler is not running |
| **First action** | `pgrep freqtrade` / `pgrep python`<br>If dead: reconciler should have caught it — check `systemctl --user status mc-livestrategy-pulse.timer` |
| **Fix** | If reconciler is broken: manually `UPDATE freqtrade_runs SET status='killed', ended_at=<now_ms> WHERE run_uuid='<uuid>';`<br>`MISSIONCTRL_EXEC_ENABLED=false` until root-caused |

---

## retention-failed

**Alert:** `retention.last_run_ts` is old or missing

| | |
|---|---|
| **Likely cause** | Nightly timer dead, or DELETE locked by long-running read txn |
| **First action** | `systemctl --user status mc-dashboard-retention.timer`<br>`journalctl --user -u mc-dashboard-retention -n 20` |
| **Fix** | `systemctl --user start mc-dashboard-retention.service` to run manually |
| **Rollback** | `MISSIONCTRL_RETENTION_ENABLED=false`; if WAL is huge: `sqlite3 data/dashboard_history.sqlite 'PRAGMA wal_checkpoint(FULL);'` |

---

## wal-large

**Alert:** `db.wal_size_mb > 100`

| | |
|---|---|
| **Likely cause** | Long-running read txn preventing checkpoint, or retention not pruning |
| **First action** | `sqlite3 data/dashboard_history.sqlite 'PRAGMA wal_checkpoint(FULL);'`<br>Restart Next.js to release any leaked read txns |
| **Rollback** | Investigate; if persistent: `MISSIONCTRL_DB_ENABLED=false` |

---

## health-unreachable

**Alert:** `[mc-dashboard] /api/health unreachable since X`

| | |
|---|---|
| **Likely cause** | Next.js process crashed or was killed |
| **First action** | `pm2 status` / `systemctl --user status missionctrlv2`<br>`journalctl --user -u missionctrlv2 -n 50` |
| **Fix** | Restart: `pm2 restart missionctrlv2` or `npm run dev` |

---

## general

**Alert:** Any unclassified `ok: false`

| | |
|---|---|
| **First action** | `curl http://localhost:3000/api/health | jq` — read subsystem detail |
| **Rollback matrix** | See PLAN.md Phase 5c for per-feature rollback steps |
