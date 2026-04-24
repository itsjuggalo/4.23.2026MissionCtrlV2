import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

export async function POST(req: Request) {
  try {
    const { action, process: procName } = await req.json();
    
    const allowed = ['restart', 'stop', 'start', 'reset'];
    if (!allowed.includes(action)) {
      return NextResponse.json({ error: 'Invalid action' }, { status: 400 });
    }

    const result = execSync(`pm2 ${action} "${procName}"`, { timeout: 10000, encoding: 'utf-8' });
    return NextResponse.json({ success: true, output: result.trim() });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}
