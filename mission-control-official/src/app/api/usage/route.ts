import { NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);
const TRACKER = '/home/ubuntu/.openclaw/workspace/mission-control/scripts/token_tracker.py';

export async function GET() {
  try {
    const { stdout } = await execAsync(
      `python3 -c "
import sys
sys.path.insert(0, '/home/ubuntu/.openclaw/workspace/mission-control/scripts')
from token_tracker import daily_report, monthly_report, check_budget
import json
daily = daily_report()
monthly = monthly_report()
ok, msg = check_budget()
print(json.dumps({'daily': daily, 'monthly': monthly, 'budget_ok': ok, 'budget_msg': msg}))
"`,
      { timeout: 10000 }
    );
    return NextResponse.json(JSON.parse(stdout.trim()));
  } catch (err: any) {
    return NextResponse.json({
      daily:   { total_cost_usd: 0, calls: 0, total_tokens: 0, budget_used_pct: 0, by_source: {} },
      monthly: { total_cost_usd: 0, budget_used_pct: 0, by_model: {} },
      budget_ok: true,
      budget_msg: 'No usage data yet',
      error: err.message,
    });
  }
}
