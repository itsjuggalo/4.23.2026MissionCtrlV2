import { NextResponse } from 'next/server';
import { spawn, execSync } from 'child_process';
import { existsSync, readdirSync, statSync } from 'fs';
import path from 'path';

let _statusCache: { data: any; ts: number } | null = null;
let _statusInflight: Promise<any> | null = null;
const STATUS_TTL = 30_000;

export const revalidate = 0;

const REPO = '/home/itsju/LapClaw/freqtrade';
const VENV_PY = path.join(REPO, '.venv/bin/python');
const VENV_BIN = path.join(REPO, '.venv/bin/freqtrade');
const USERDIR = path.join(REPO, 'user_data');
const STRATEGY_DIR = path.join(USERDIR, 'strategies');
const DATA_DIR = path.join(USERDIR, 'data');
const BT_DIR = path.join(USERDIR, 'backtest_results');
const LOCAL_CONFIG = path.join(REPO, 'config.json');

const ALLOWED_SUBCOMMANDS = [
  'list-strategies', 'list-exchanges', 'list-markets', 'list-pairs',
  'list-timeframes', 'list-data', 'download-data', 'backtesting',
  'show-config', 'install-ui',
] as const;
type Sub = typeof ALLOWED_SUBCOMMANDS[number];

function listFiles(dir: string, exts?: string[]): { name: string; size: number; modified: string }[] {
  if (!existsSync(dir)) return [];
  const out: { name: string; size: number; modified: string }[] = [];
  const walk = (d: string, prefix: string) => {
    for (const name of readdirSync(d)) {
      const full = path.join(d, name);
      const rel = prefix ? `${prefix}/${name}` : name;
      const s = statSync(full);
      if (s.isDirectory()) walk(full, rel);
      else if (!exts || exts.some(e => name.endsWith(e))) {
        out.push({ name: rel, size: s.size, modified: s.mtime.toISOString() });
      }
    }
  };
  try { walk(dir, ''); } catch {}
  return out.sort((a, b) => b.modified.localeCompare(a.modified));
}

function status() {
  const repoExists = existsSync(REPO);
  const venvExists = existsSync(VENV_PY);
  const ftInstalled = existsSync(VENV_BIN);

  let commit: string | null = null;
  if (repoExists) {
    try { commit = execSync(`git -C "${REPO}" log -1 --format="%h %ci %s"`, { encoding: 'utf-8' }).trim(); } catch {}
  }

  let version: string | null = null;
  if (ftInstalled) {
    try { version = execSync(`"${VENV_BIN}" --version`, { encoding: 'utf-8', timeout: 10000 }).trim(); } catch {}
  }

  return {
    repo: REPO,
    repo_exists: repoExists,
    venv_exists: venvExists,
    ft_installed: ftInstalled,
    venv_python: VENV_PY,
    commit,
    version,
    userdir: USERDIR,
    userdir_exists: existsSync(USERDIR),
    local_config_exists: existsSync(LOCAL_CONFIG),
    strategies: listFiles(STRATEGY_DIR, ['.py']).slice(0, 50),
    data_files: listFiles(DATA_DIR, ['.json', '.feather', '.parquet']).slice(0, 30),
    backtest_results: listFiles(BT_DIR).slice(0, 20),
    subcommands: ALLOWED_SUBCOMMANDS,
  };
}

export async function GET() {
  try {
    if (_statusCache && Date.now() - _statusCache.ts < STATUS_TTL) {
      return NextResponse.json(_statusCache.data);
    }

    if (!_statusInflight) {
      _statusInflight = Promise.resolve()
        .then(() => status())
        .then(data => { _statusCache = { data, ts: Date.now() }; return data; })
        .finally(() => { _statusInflight = null; });
    }

    const data = await _statusInflight;
    return NextResponse.json(data);
  } catch (e) {
    if (_statusCache) return NextResponse.json({ ..._statusCache.data, stale: true });
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}

export async function POST(req: Request) {
  try {
    const body = await req.json();
    if (body.action !== 'run') {
      return NextResponse.json({ error: 'Unknown action' }, { status: 400 });
    }
    const sub = body.subcommand as Sub;
    if (!ALLOWED_SUBCOMMANDS.includes(sub)) {
      return NextResponse.json({ error: `Subcommand not allowed: ${sub}` }, { status: 400 });
    }
    const extraArgs: string[] = Array.isArray(body.args) ? body.args.filter((a: unknown) => typeof a === 'string' && /^[\w\-./,:=@ ]+$/.test(a as string)) : [];
    const args = [sub, '--userdir', USERDIR, ...extraArgs];
    if (sub === 'backtesting' || sub === 'show-config') {
      if (existsSync(LOCAL_CONFIG) && !extraArgs.includes('-c') && !extraArgs.includes('--config')) {
        args.push('-c', LOCAL_CONFIG);
      }
    }
    return await runProcess(VENV_BIN, args, REPO, 300_000);
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}

function runProcess(cmd: string, args: string[], cwd: string, timeoutMs: number) {
  return new Promise<Response>(resolve => {
    let stdout = '';
    let stderr = '';
    const started = Date.now();
    const child = spawn(cmd, args, { cwd, env: { ...process.env, PYTHONUNBUFFERED: '1' } });
    const timer = setTimeout(() => { try { child.kill('SIGKILL'); } catch {} }, timeoutMs);
    child.stdout.on('data', d => { stdout += d.toString(); });
    child.stderr.on('data', d => { stderr += d.toString(); });
    child.on('error', err => {
      clearTimeout(timer);
      resolve(NextResponse.json({ success: false, error: String(err).slice(0, 200), cmd, args, elapsed_ms: Date.now() - started }, { status: 500 }));
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
