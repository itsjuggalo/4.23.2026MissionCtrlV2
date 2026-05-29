import { NextResponse } from 'next/server';
import Database from 'better-sqlite3';

// Read-only loops aggregator. Mirrors the local-SQLite pattern used by
// /api/desk-cycle (force-dynamic + better-sqlite3 readonly + fileMustExist).
// NEVER writes. Each loop is read in its own try/catch so a missing or
// corrupt DB degrades that single card to health='down' instead of
// taking down the whole endpoint.
export const dynamic = 'force-dynamic';
export const revalidate = 0;

const NIGHTSHIFT_DB = '/home/itsju/05_AUTOMATION/nightshift/nightshift.sqlite';
const WATCHDOG_DB = '/home/itsju/background_tasks.sqlite';
const PIPELINE_DB = '/home/itsju/LapClaw/pipeline/desk_pipeline.sqlite';

type Health = 'ok' | 'warn' | 'down';
type AnyRow = Record<string, unknown>;

interface Loop {
  name: string;
  lastRun: string | null;
  health: Health;
  summary: string;
  detail: Record<string, unknown>;
}

function openRead(path: string): Database.Database {
  return new Database(path, { readonly: true, fileMustExist: true });
}

// Parse an ISO-ish timestamp (handles both '2026-05-29T14:30:01+00:00' and
// '2026-05-29 13:50:16' bare-local forms) to epoch ms. Returns null on failure.
function tsToMs(ts: unknown): number | null {
  if (typeof ts !== 'string' || !ts) return null;
  // Bare 'YYYY-MM-DD HH:MM:SS' (no tz) → treat as UTC for stable relative math.
  const normalized = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/.test(ts)
    ? ts.replace(' ', 'T') + 'Z'
    : ts;
  const ms = new Date(normalized).getTime();
  return Number.isNaN(ms) ? null : ms;
}

function num(v: unknown): number {
  return typeof v === 'number' ? v : Number(v) || 0;
}

// ─── Night Shift ────────────────────────────────────────────────────────────
function readNightShift(): Loop {
  let db: Database.Database | null = null;
  try {
    db = openRead(NIGHTSHIFT_DB);

    const improvementRows = db
      .prepare(`SELECT status, COUNT(*) AS n FROM improvements GROUP BY status`)
      .all() as AnyRow[];
    const improvementsByStatus: Record<string, number> = {};
    for (const r of improvementRows) improvementsByStatus[String(r.status)] = num(r.n);
    const queued = improvementsByStatus.queued ?? 0;

    // Heal events in the last 24h, grouped by state.
    const sinceIso = new Date(Date.now() - 24 * 60 * 60 * 1000).toISOString();
    const healRows = db
      .prepare(
        `SELECT state, COUNT(*) AS n FROM heal_events WHERE ts >= ? GROUP BY state`,
      )
      .all(sinceIso) as AnyRow[];
    const healByState: Record<string, number> = {};
    for (const r of healRows) healByState[String(r.state)] = num(r.n);

    const latestHealRow = db
      .prepare(`SELECT MAX(ts) AS ts FROM heal_events`)
      .get() as AnyRow | undefined;
    const latestHealTs = (latestHealRow?.ts as string | null) ?? null;
    const latestHealMs = tsToMs(latestHealTs);

    const targets = db
      .prepare(
        `SELECT name, dry_streak, dry_cap, last_run_at, enabled
         FROM targets ORDER BY name`,
      )
      .all() as AnyRow[];

    // Most recent target run drives "last run".
    let lastRun: string | null = null;
    let lastRunMs = -1;
    for (const t of targets) {
      const ms = tsToMs(t.last_run_at);
      if (ms !== null && ms > lastRunMs) {
        lastRunMs = ms;
        lastRun = t.last_run_at as string;
      }
    }

    const restartFailed = healByState.restart_failed ?? 0;
    const flapping = healByState.flapping ?? 0;
    const unreachable = healByState.unreachable ?? 0;
    const restarts = healByState.restarted ?? 0;

    // Health: warn on any restart_failed/flapping in 24h, or no heal heartbeat
    // in >1h (a stalled healer). If there are simply zero heal events ever
    // recorded, treat as ok (healer hasn't had to act) rather than alarming.
    let health: Health = 'ok';
    const staleHeal =
      latestHealMs !== null && Date.now() - latestHealMs > 60 * 60 * 1000;
    if (restartFailed > 0 || flapping > 0 || unreachable > 0 || staleHeal) {
      health = 'warn';
    }

    const enabledTargets = targets.filter((t) => num(t.enabled) === 1).length;
    const summary = `${queued} queued · ${restarts} restart${restarts === 1 ? '' : 's'}/24h · ${enabledTargets}/${targets.length} targets`;

    return {
      name: 'Night Shift',
      lastRun,
      health,
      summary,
      detail: {
        queuedImprovements: queued,
        improvementsByStatus,
        heal24h: { restarts, restartFailed, flapping, unreachable },
        latestHealTs,
        targets: targets.map((t) => ({
          name: t.name,
          dryStreak: num(t.dry_streak),
          dryCap: num(t.dry_cap),
          lastRunAt: (t.last_run_at as string | null) ?? null,
          enabled: num(t.enabled) === 1,
        })),
      },
    };
  } catch {
    return {
      name: 'Night Shift',
      lastRun: null,
      health: 'down',
      summary: 'DB unreachable',
      detail: { error: 'nightshift.sqlite unavailable' },
    };
  } finally {
    if (db) db.close();
  }
}

// ─── Background watchdog ─────────────────────────────────────────────────────
function readWatchdog(): Loop {
  let db: Database.Database | null = null;
  try {
    db = openRead(WATCHDOG_DB);

    const rows = db
      .prepare(`SELECT status, COUNT(*) AS n FROM tasks GROUP BY status`)
      .all() as AnyRow[];
    const byStatus: Record<string, number> = {};
    for (const r of rows) byStatus[String(r.status)] = num(r.n);

    const running = byStatus.running ?? 0;
    const complete = byStatus.complete ?? 0;
    const ghost = byStatus.ghost ?? 0;

    const latestRow = db
      .prepare(`SELECT MAX(started_at) AS ts FROM tasks`)
      .get() as AnyRow | undefined;
    const lastRun = (latestRow?.ts as string | null) ?? null;

    // Health: ghost tasks are the failure signal the watchdog exists to catch.
    const health: Health = ghost > 0 ? 'warn' : 'ok';
    const summary = `${running} running · ${complete} complete · ${ghost} ghost`;

    return {
      name: 'Background Watchdog',
      lastRun,
      health,
      summary,
      detail: { running, complete, ghost, byStatus },
    };
  } catch {
    return {
      name: 'Background Watchdog',
      lastRun: null,
      health: 'down',
      summary: 'DB unreachable',
      detail: { error: 'background_tasks.sqlite unavailable' },
    };
  } finally {
    if (db) db.close();
  }
}

// ─── Desk pipeline ───────────────────────────────────────────────────────────
function readDeskPipeline(): Loop {
  let db: Database.Database | null = null;
  try {
    db = openRead(PIPELINE_DB);

    // Latest cycle per asset_class.
    const latestPerClass = db
      .prepare(
        `SELECT cm.asset_class, cm.cycle_id, cm.status, cm.started_at, cm.completed_at
         FROM cycle_metadata cm
         JOIN (
           SELECT asset_class, MAX(started_at) AS mx
           FROM cycle_metadata GROUP BY asset_class
         ) latest
           ON cm.asset_class = latest.asset_class
          AND cm.started_at = latest.mx`,
      )
      .all() as AnyRow[];

    // In-progress cycles (started but no completed_at recorded).
    const inProgressRows = db
      .prepare(
        `SELECT cycle_id, asset_class, started_at
         FROM cycle_metadata
         WHERE completed_at IS NULL OR completed_at = ''`,
      )
      .all() as AnyRow[];
    const inProgressCount = inProgressRows.length;

    // Most recent cycle overall → "last run".
    let lastRun: string | null = null;
    let lastRunMs = -1;
    for (const c of latestPerClass) {
      const ms = tsToMs(c.started_at);
      if (ms !== null && ms > lastRunMs) {
        lastRunMs = ms;
        lastRun = c.started_at as string;
      }
    }

    // Health: warn if any in-progress cycle has been running > 2h (stalled).
    let stalled = 0;
    const now = Date.now();
    for (const c of inProgressRows) {
      const ms = tsToMs(c.started_at);
      if (ms !== null && now - ms > 2 * 60 * 60 * 1000) stalled++;
    }
    const health: Health = stalled > 0 ? 'warn' : 'ok';

    const byClass = latestPerClass.map((c) => ({
      assetClass: c.asset_class,
      status: c.status,
      startedAt: c.started_at,
    }));
    const summary = `${byClass.length} asset classes · ${inProgressCount} in progress${stalled > 0 ? ` · ${stalled} stalled >2h` : ''}`;

    return {
      name: 'Desk Pipeline',
      lastRun,
      health,
      summary,
      detail: { latestPerClass: byClass, inProgressCount, stalled },
    };
  } catch {
    return {
      name: 'Desk Pipeline',
      lastRun: null,
      health: 'down',
      summary: 'DB unreachable',
      detail: { error: 'desk_pipeline.sqlite unavailable' },
    };
  } finally {
    if (db) db.close();
  }
}

export async function GET() {
  const loops: Loop[] = [readNightShift(), readWatchdog(), readDeskPipeline()];
  return NextResponse.json({ loops, generatedAt: new Date().toISOString() });
}
