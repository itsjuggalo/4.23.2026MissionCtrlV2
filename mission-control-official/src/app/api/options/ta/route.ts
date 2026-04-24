import { NextRequest, NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);
const SCRIPT = '/home/ubuntu/.openclaw/workspace/mission-control/scripts/ta_engine.py';

export async function GET(req: NextRequest) {
  const ticker = req.nextUrl.searchParams.get('ticker')?.toUpperCase();
  if (!ticker || !/^[A-Z]{1,6}$/.test(ticker)) {
    return NextResponse.json({ error: 'Invalid ticker' }, { status: 400 });
  }
  try {
    const { stdout } = await execAsync(`python3 ${SCRIPT} ${ticker}`, { timeout: 30000 });
    const data = JSON.parse(stdout.trim());
    if (data.error) return NextResponse.json({ error: data.error }, { status: 400 });
    return NextResponse.json(data);
  } catch (err: any) {
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}
