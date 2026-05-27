import { NextResponse } from 'next/server';
import { spawnSync } from 'child_process';

const ALLOWED_ACTIONS = new Set(['restart', 'stop', 'start', 'reset']);
const SAFE_PROC_NAME = /^[\w.\-]+$/;

export async function POST(req: Request) {
  try {
    const { action, process: procName } = await req.json();

    if (!ALLOWED_ACTIONS.has(action)) {
      return NextResponse.json({ error: 'Invalid action' }, { status: 400 });
    }
    if (!procName || !SAFE_PROC_NAME.test(procName)) {
      return NextResponse.json({ error: 'Invalid process name' }, { status: 400 });
    }

    // Use spawnSync with args array — no shell interpolation, no injection risk
    const result = spawnSync('pm2', [action, procName], { timeout: 10000, encoding: 'utf-8' });
    if (result.error) throw result.error;
    const output = (result.stdout || '') + (result.stderr || '');
    return NextResponse.json({ success: result.status === 0, output: output.trim() });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}
