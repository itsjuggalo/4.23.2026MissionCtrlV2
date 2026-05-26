/**
 * reconcile-runs.ts — sweep stale pending/running rows and flip them to terminal states.
 *
 * Runs at module init AND every 5 min from mc-livestrategy-pulse.timer.
 * PID reuse defeat: reads /proc/<pid>/stat field 22 (starttime) and compares
 * against the row's pid_start_time (R3.M4).
 */

import { dbCriticalWrite, dbTelemetryWrite, dbRead, getPidStartTime } from './dashboard-db';

// Per-subcommand stale thresholds (configurable via env)
function staleThresholdMs(subcommand: string): number {
  const envKey = `MISSIONCTRL_RUN_STALE_MS_${subcommand.toUpperCase().replace(/-/g, '_')}`;
  const envVal = process.env[envKey];
  if (envVal && !isNaN(Number(envVal))) return Number(envVal);

  const defaults: Record<string, number> = {
    backtesting: 2 * 60 * 60 * 1000,       // 2h
    'download-data': 60 * 60 * 1000,        // 1h
    default: 30 * 60 * 1000,               // 30m (ITB scripts)
  };
  return defaults[subcommand] ?? defaults.default;
}

// Track alerts per run to avoid re-firing (in-memory, process lifetime)
const alertedRuns = new Set<string>();

async function fireDiscordAlert(message: string): Promise<void> {
  const webhookUrl = process.env.MISSIONCTRL_OPS_WEBHOOK;
  if (!webhookUrl) return;
  try {
    await fetch(webhookUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ content: message }),
    });
  } catch (err) {
    console.error('[reconcile-runs] Discord webhook failed:', err);
  }
}

interface RunRow {
  run_uuid: string;
  status: string;
  pid: number | null;
  pid_start_time: number | null;
  started_at: number | null;
  ts: number;
  subcommand?: string;
  script?: string;
  stderr_tail?: string | null;
  artifact_path?: string | null;
}

function isProcessAlive(row: RunRow): boolean {
  if (!row.pid) return false;
  const currentStarttime = getPidStartTime(row.pid);
  if (currentStarttime === null) return false; // process doesn't exist
  if (row.pid_start_time === null) return false; // no stored starttime, treat as dead
  return currentStarttime === row.pid_start_time;
}

function buildStaleWhereClause(table: string, now: number): string {
  // Returns rows that are stale (older than their subcommand's threshold)
  // We can't easily do per-row dynamic thresholds in SQL, so we use a conservative
  // minimum threshold and filter further in JS
  const minThresholdMs = 30 * 60 * 1000; // 30m
  const cutoff = now - minThresholdMs;
  return `status IN ('pending', 'running') AND ts < ${cutoff}`;
}

export async function reconcileRuns(): Promise<void> {
  const now = Date.now();

  // Reconcile ITB runs
  const itbRows = dbRead(db =>
    db.prepare(
      `SELECT run_uuid, status, pid, pid_start_time, started_at, ts, script, stderr_tail
       FROM itb_runs WHERE status IN ('pending', 'running') AND ts < ?`
    ).all(now - 30 * 60 * 1000) as RunRow[]
  ) ?? [];

  for (const row of itbRows) {
    const threshold = staleThresholdMs(row.script ?? 'default');
    const age = now - row.ts;
    if (age < threshold) continue; // Not stale enough yet

    const alive = isProcessAlive(row);

    if (!alive) {
      const newStatus = row.status === 'pending' ? 'orphaned' : 'killed';
      dbTelemetryWrite(db => {
        db.prepare(
          `UPDATE itb_runs SET status = ?, ended_at = ? WHERE run_uuid = ? AND status = ?`
        ).run(newStatus, now, row.run_uuid, row.status);
      });
      console.log(`[reconcile-runs] ITB run ${row.run_uuid} → ${newStatus}`);
    } else {
      // Still running — check for stuck-run alert
      const doubleThreshold = threshold * 2;
      if (age > doubleThreshold && !alertedRuns.has(row.run_uuid)) {
        alertedRuns.add(row.run_uuid);
        const stderrExcerpt = row.stderr_tail?.slice(-200) ?? '(no stderr)';
        await fireDiscordAlert(
          `[mc-itb] Stuck run detected\n` +
          `run_uuid: ${row.run_uuid}\nscript: ${row.script}\nstarted_at: ${row.started_at}\n` +
          `stderr tail: ${stderrExcerpt}`
        );
      }
    }
  }

  // Reconcile Freqtrade runs
  const ftRows = dbRead(db =>
    db.prepare(
      `SELECT run_uuid, status, pid, pid_start_time, started_at, ts, subcommand, stderr_tail, artifact_path
       FROM freqtrade_runs WHERE status IN ('pending', 'running') AND ts < ?`
    ).all(now - 30 * 60 * 1000) as RunRow[]
  ) ?? [];

  for (const row of ftRows) {
    const threshold = staleThresholdMs(row.subcommand ?? 'default');
    const age = now - row.ts;
    if (age < threshold) continue;

    const alive = isProcessAlive(row);

    if (!alive) {
      const newStatus = row.status === 'pending' ? 'orphaned' : 'killed';
      dbTelemetryWrite(db => {
        db.prepare(
          `UPDATE freqtrade_runs SET status = ?, ended_at = ? WHERE run_uuid = ? AND status = ?`
        ).run(newStatus, now, row.run_uuid, row.status);
      });
      console.log(`[reconcile-runs] Freqtrade run ${row.run_uuid} → ${newStatus}`);

      // If killed with artifact_path, attempt one-shot ingestion
      if (newStatus === 'killed' && row.artifact_path) {
        await tryIngestArtifact(row.run_uuid, row.artifact_path);
      }
    } else {
      // Still running — check for stuck-run alert
      const doubleThreshold = threshold * 2;
      if (age > doubleThreshold && !alertedRuns.has(row.run_uuid)) {
        alertedRuns.add(row.run_uuid);
        const stderrExcerpt = row.stderr_tail?.slice(-200) ?? '(no stderr)';
        await fireDiscordAlert(
          `[mc-freqtrade] Stuck run detected\n` +
          `run_uuid: ${row.run_uuid}\nsubcommand: ${row.subcommand}\nstarted_at: ${row.started_at}\n` +
          `stderr tail: ${stderrExcerpt}`
        );
      }
    }
  }
}

async function tryIngestArtifact(runUuid: string, artifactPath: string): Promise<void> {
  // Best-effort one-shot ingestion for a killed run
  // Mark for ingestion — the next /api/freqtrade GET will pick this up
  import('fs').then(({ existsSync }) => {
    dbTelemetryWrite(db => {
      if (!existsSync(artifactPath)) {
        db.prepare(
          `UPDATE freqtrade_runs SET ingestion_status = 'failed' WHERE run_uuid = ?`
        ).run(runUuid);
        return;
      }
      db.prepare(
        `UPDATE freqtrade_runs SET ingestion_status = 'pending' WHERE run_uuid = ? AND ingestion_status = 'na'`
      ).run(runUuid);
    });
  }).catch(err => {
    console.error('[reconcile-runs] tryIngestArtifact failed:', err);
  });
}

// Run once at module load
let _ran = false;
if (!_ran) {
  _ran = true;
  reconcileRuns().catch(err => {
    console.error('[reconcile-runs] Initial reconciliation failed:', err);
  });
}
