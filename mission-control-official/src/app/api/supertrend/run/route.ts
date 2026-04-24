import { NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);

export async function POST() {
  try {
    // Run in background — don't await
    execAsync('python3 /home/ubuntu/mission-control/btc_supertrend_enhanced.py --once 2>/dev/null || python3 /home/ubuntu/mission-control/supertrend_optimizer.py 2>/dev/null &').catch(() => {});
    return NextResponse.json({ status: 'started', message: 'Optimizer triggered in background' });
  } catch (err: any) {
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}
