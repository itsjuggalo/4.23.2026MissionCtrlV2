import { NextResponse } from 'next/server';
import { NextRequest } from 'next/server';
import { spawn, execSync } from 'child_process';
import { existsSync, readdirSync, statSync, appendFileSync, chmodSync } from 'fs';
import path from 'path';
import { randomUUID } from 'crypto';
import {
  dbCriticalWrite, dbTelemetryWrite, dbRead, getPidStartTime,
} from '@/lib/dashboard-db';
import { assertExecAllowed, checkRateLimit, acquireRateLimit, releaseRateLimit } from '@/lib/exec-auth';
import { validateItbParams } from '@/lib/validate-exec-params';
import { redactTail, redactObject } from '@/lib/redact';

export const runtime = 'nodejs';

const REPO = '/home/itsju/LapClaw/intelligent-trading-bot';
const VENV_PY = path.join(REPO, '.venv/bin/python');
const CONFIG_DIR = path.join(REPO, 'configs');
const OUTPUTS_DIR = path.join(REPO, 'outputs');
const AUDIT_LOG = path.join(process.cwd(), 'data/exec-audit.log');

const PIPELINE_SCRIPTS = [
  'download', 'merge', 'features', 'labels',
  'train', 'predict', 'predict_rolling', 'signals', 'simulate', 'output',
] as const;
type Script = typeof PIPELINE_SCRIPTS[number];

function repoStatus() {
  const repoExists = existsSync(REPO);
  const venvExists = existsSync(VENV_PY);

  let commit: string | null = null;
  if (repoExists) {
    try {
      commit = execSync('git -C "' + REPO + '" log -1 --format="%h %ci %s"', { encoding: 'utf-8' }).trim();
    } catch {}
  }

  const configs = existsSync(CONFIG_DIR)
    ? readdirSync(CONFIG_DIR).filter(f => f.endsWith('.json') || f.endsWith('.jsonc'))
    : [];

  type OutputEntry = { name: string; size: number; modified: string };
  const outputs: OutputEntry[] = [];
  if (existsSync(OUTPUTS_DIR)) {
    const walk = (dir: string, prefix: string) => {
      for (const name of readdirSync(dir)) {
        const full = path.join(dir, name);
        const rel = prefix ? `${prefix}/${name}` : name;
        const s = statSync(full);
        if (s.isDirectory()) walk(full, rel);
        else outputs.push({ name: rel, size: s.size, modified: s.mtime.toISOString() });
      }
    };
    try { walk(OUTPUTS_DIR, ''); } catch {}
  }

  const depChecks: Record<string, boolean> = {};
  if (venvExists) {
    const probes = ['numpy', 'pandas', 'sklearn', 'lightgbm', 'tensorflow', 'binance', 'talib'];
    for (const pkg of probes) {
      try {
        execSync(`"${VENV_PY}" -c "import ${pkg}"`, { stdio: 'ignore', timeout: 8000 });
        depChecks[pkg] = true;
      } catch {
        depChecks[pkg] = false;
      }
    }
  }

  return {
    repo: REPO,
    repo_exists: repoExists,
    venv_exists: venvExists,
    venv_python: VENV_PY,
    commit,
    configs,
    outputs: outputs.sort((a, b) => b.modified.localeCompare(a.modified)).slice(0, 30),
    deps: depChecks,
    scripts: PIPELINE_SCRIPTS,
    service_cmd: `cd ${REPO} && .venv/bin/python -m service.server -c configs/<config>.jsonc`,
  };
}

// ── 3b. pipeline_health derivation ───────────────────────────────────────────
function derivePipelineHealth(runs: RunRow[]): Record<string, { p50_ms: number | null; last_ok_ts: number | null; last_fail_ts: number | null }> {
  const byScript: Record<string, RunRow[]> = {};
  for (const r of runs) {
    if (!byScript[r.script]) byScript[r.script] = [];
    byScript[r.script].push(r);
  }

  const health: Record<string, { p50_ms: number | null; last_ok_ts: number | null; last_fail_ts: number | null }> = {};
  for (const [script, scriptRuns] of Object.entries(byScript)) {
    const completedMs = scriptRuns
      .filter(r => r.elapsed_ms !== null)
      .map(r => r.elapsed_ms as number)
      .sort((a, b) => a - b);
    const p50 = completedMs.length > 0 ? completedMs[Math.floor(completedMs.length / 2)] : null;

    const okRun = scriptRuns.find(r => r.status === 'ok');
    const failRun = scriptRuns.find(r => r.status === 'fail');

    health[script] = {
      p50_ms: p50,
      last_ok_ts: okRun?.ts ?? null,
      last_fail_ts: failRun?.ts ?? null,
    };
  }
  return health;
}

interface RunRow {
  run_uuid: string;
  ts: number;
  script: string;
  config: string;
  status: string;
  exit_code: number | null;
  elapsed_ms: number | null;
  started_at: number | null;
  ended_at: number | null;
  pid: number | null;
}

export async function GET() {
  try {
    const base = repoStatus();

    // 3b: add runs + pipeline_health
    const runs = dbRead(db =>
      db.prepare(
        `SELECT run_uuid, ts, script, config, status, exit_code, elapsed_ms, started_at, ended_at, pid
         FROM itb_runs ORDER BY ts DESC LIMIT 50`
      ).all() as RunRow[]
    ) ?? [];

    const pipeline_health = derivePipelineHealth(runs);

    return NextResponse.json({ ...base, runs, pipeline_health });
  } catch (e) {
    return NextResponse.json({ error: String(e) }, { status: 500 });
  }
}

function appendAuditLog(entry: Record<string, unknown>): void {
  try {
    const line = JSON.stringify(entry) + '\n';
    appendFileSync(AUDIT_LOG, line, { flag: 'a' });
    try { chmodSync(AUDIT_LOG, 0o600); } catch {}
  } catch (err) {
    throw new Error(`Audit log append failed: ${err}`);
  }
}

export async function POST(req: NextRequest) {
  const execEnabled = process.env.MISSIONCTRL_EXEC_ENABLED !== 'false' &&
    process.env.MISSIONCTRL_EXEC_ENABLED === 'true';

  if (!execEnabled) {
    return NextResponse.json(
      { error: 'Execution is disabled (MISSIONCTRL_EXEC_ENABLED != true)' },
      { status: 503 }
    );
  }

  // Auth check
  const auth = assertExecAllowed(req, true);
  if (!auth.ok) return auth.errorResponse!;
  const principal = auth.principal!;

  // Rate limit
  if (!checkRateLimit('/api/itb', principal)) {
    return NextResponse.json({ error: 'Rate limit exceeded' }, { status: 429 });
  }

  try {
    const body = await req.json() as Record<string, unknown>;
    const action = body.action as 'run' | 'install-deps';

    if (action === 'install-deps') {
      acquireRateLimit('/api/itb', principal);
      try {
        return await runProcess(VENV_PY.replace('/python', '/pip'), ['install', '-r', path.join(REPO, 'requirements.txt')], REPO, 600_000);
      } finally {
        releaseRateLimit('/api/itb', principal);
      }
    }

    if (action === 'run') {
      // Require Idempotency-Key
      const idempotencyKey = req.headers.get('idempotency-key');
      if (!idempotencyKey) {
        return NextResponse.json({ error: 'Idempotency-Key header is required' }, { status: 400 });
      }

      // Validate params
      let validated;
      try {
        validated = validateItbParams(body);
      } catch (err) {
        return NextResponse.json({ error: String(err) }, { status: 400 });
      }

      const { script, config } = validated;
      const configPath = path.join(CONFIG_DIR, config);
      if (!existsSync(configPath)) {
        return NextResponse.json({ error: `Config not found: ${config}` }, { status: 400 });
      }

      const run_uuid = randomUUID();
      const ts = Date.now();
      const args_json = JSON.stringify(redactObject({ script, config }));

      // ── Fail-closed pre-spawn transaction (R2.H3) ─────────────────────────
      // If this throws, we return 500 and DO NOT spawn.
      try {
        dbCriticalWrite(db => {
          const tx = db.transaction(() => {
            // Check for idempotent duplicate
            const existing = db.prepare(
              `SELECT run_uuid, status FROM itb_runs WHERE idempotency_key = ?`
            ).get(idempotencyKey) as { run_uuid: string; status: string } | undefined;

            if (existing) {
              // Return early — caller will handle this case
              (tx as unknown as Record<string, unknown>).__duplicate = existing;
              return;
            }

            db.prepare(
              `INSERT INTO itb_runs (run_uuid, idempotency_key, principal, ts, script, config, args_json, status)
               VALUES (?, ?, ?, ?, ?, ?, ?, 'pending')`
            ).run(run_uuid, idempotencyKey, principal, ts, script, config, args_json);

            // Audit log append (must succeed before commit)
            appendAuditLog({
              ts,
              route: '/api/itb',
              run_uuid,
              mode: process.env.MISSIONCTRL_EXEC_MODE ?? 'browser-session',
              principal,
              args_redacted: { script, config },
              status_initial: 'pending',
            });
          });

          tx();
          return (tx as unknown as Record<string, unknown>).__duplicate as { run_uuid: string; status: string } | undefined;
        });
      } catch (err) {
        return NextResponse.json({ error: 'audit_unavailable', detail: String(err) }, { status: 500 });
      }

      // Check for idempotent duplicate after the transaction
      const existingRun = dbRead(db =>
        db.prepare(`SELECT run_uuid, status FROM itb_runs WHERE idempotency_key = ? AND run_uuid != ?`)
          .get(idempotencyKey, run_uuid) as { run_uuid: string; status: string } | undefined
      );
      if (existingRun) {
        return NextResponse.json({ run_uuid: existingRun.run_uuid, status: existingRun.status, idempotent: true });
      }

      // Spawn the child
      acquireRateLimit('/api/itb', principal);

      const spawnArgs = ['-m', `scripts.${script}`, '-c', configPath];
      const child = spawn(VENV_PY, spawnArgs, {
        cwd: REPO,
        env: { ...process.env, PYTHONUNBUFFERED: '1' },
      });

      const childPid = child.pid;
      const pidStartTime = childPid ? getPidStartTime(childPid) : null;
      const started_at = Date.now();

      // Update to 'running'
      dbTelemetryWrite(db => {
        db.prepare(
          `UPDATE itb_runs SET status = 'running', started_at = ?, pid = ?, pid_start_time = ? WHERE run_uuid = ?`
        ).run(started_at, childPid ?? null, pidStartTime, run_uuid);
      });

      const timeoutMs = 300_000;
      let stdout = '';
      let stderr = '';
      const timer = setTimeout(() => { try { child.kill('SIGKILL'); } catch {} }, timeoutMs);

      child.stdout?.on('data', (d: Buffer) => { stdout += d.toString(); });
      child.stderr?.on('data', (d: Buffer) => { stderr += d.toString(); });

      child.on('close', code => {
        clearTimeout(timer);
        releaseRateLimit('/api/itb', principal);
        const elapsed_ms = Date.now() - started_at;
        const finalStatus = code === 0 ? 'ok' : 'fail';
        dbTelemetryWrite(db => {
          db.prepare(
            `UPDATE itb_runs SET status = ?, exit_code = ?, elapsed_ms = ?, ended_at = ?,
             stdout_tail = ?, stderr_tail = ? WHERE run_uuid = ?`
          ).run(
            finalStatus,
            code,
            elapsed_ms,
            Date.now(),
            redactTail(stdout),
            redactTail(stderr),
            run_uuid
          );
        });
      });

      return NextResponse.json({ run_uuid, status: 'pending', script, config });
    }

    return NextResponse.json({ error: 'Unknown action' }, { status: 400 });
  } catch (e) {
    return NextResponse.json({ error: String(e) }, { status: 500 });
  }
}

function runProcess(cmd: string, args: string[], cwd: string, timeoutMs: number) {
  return new Promise<Response>(resolve => {
    let stdout = '';
    let stderr = '';
    const started = Date.now();
    const child = spawn(cmd, args, { cwd, env: { ...process.env, PYTHONUNBUFFERED: '1' } });
    const timer = setTimeout(() => {
      try { child.kill('SIGKILL'); } catch {}
    }, timeoutMs);
    child.stdout.on('data', (d: Buffer) => { stdout += d.toString(); });
    child.stderr.on('data', (d: Buffer) => { stderr += d.toString(); });
    child.on('error', err => {
      clearTimeout(timer);
      resolve(NextResponse.json({
        success: false, error: String(err), cmd, args, elapsed_ms: Date.now() - started,
      }, { status: 500 }));
    });
    child.on('close', code => {
      clearTimeout(timer);
      const MAX = 50_000;
      resolve(NextResponse.json({
        success: code === 0,
        exit_code: code,
        stdout: stdout.length > MAX ? '…' + stdout.slice(-MAX) : stdout,
        stderr: stderr.length > MAX ? '…' + stderr.slice(-MAX) : stderr,
        cmd, args, elapsed_ms: Date.now() - started,
      }));
    });
  });
}
