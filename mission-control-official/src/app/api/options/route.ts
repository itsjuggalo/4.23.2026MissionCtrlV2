import { NextRequest, NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);

const SCRIPT = '/home/ubuntu/.openclaw/workspace/mission-control/scripts/options_engine.py';

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const ticker = searchParams.get('ticker')?.toUpperCase();
  const expiryIdx = searchParams.get('expiry') || '0';

  if (!ticker) {
    return NextResponse.json({ error: 'ticker param required' }, { status: 400 });
  }

  // Sanitize inputs
  if (!/^[A-Z]{1,6}$/.test(ticker)) {
    return NextResponse.json({ error: 'Invalid ticker' }, { status: 400 });
  }
  if (!/^\d+$/.test(expiryIdx)) {
    return NextResponse.json({ error: 'Invalid expiry index' }, { status: 400 });
  }

  try {
    const { stdout, stderr } = await execAsync(
      `python3 ${SCRIPT} ${ticker} ${expiryIdx}`,
      { timeout: 30000 }
    );

    if (!stdout.trim()) {
      throw new Error(stderr || 'No output from options engine');
    }

    const data = JSON.parse(stdout.trim());
    if (data.error) {
      return NextResponse.json({ error: data.error }, { status: 400 });
    }

    return NextResponse.json(data);
  } catch (err: any) {
    console.error('Options API error:', err);
    return NextResponse.json(
      { error: err.message || 'Failed to fetch options data' },
      { status: 500 }
    );
  }
}
