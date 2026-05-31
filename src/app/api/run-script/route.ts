import { NextResponse } from 'next/server';
import { execSync } from 'child_process';

const ALLOWED_SCRIPTS: Record<string, { cmd: string; desc: string }> = {
  'market-data': { cmd: 'python3 /home/itsju/scripts/market_data_fetch.py', desc: 'Fetch latest market data' },
  'agent-health': { cmd: 'python3 /home/itsju/scripts/agent_health.py', desc: 'Run agent health check' },
  'activity-log': { cmd: 'python3 /home/itsju/scripts/activity_logger.py', desc: 'Log current activities' },
  'daily-snapshot': { cmd: 'python3 /home/itsju/scripts/daily_snapshot.py', desc: 'Capture daily equity snapshot' },
  'security-audit': { cmd: 'python3 /home/itsju/scripts/security_audit.py', desc: 'Run security audit' },
  'whale-flow': { cmd: 'python3 /home/itsju/scripts/whale_flow_filter.py', desc: 'Filter whale flow signals' },
  'brief-premarket': { cmd: 'python3 /home/itsju/scripts/market_data_fetch.py && echo "Data fetched for brief"', desc: 'Trigger premarket data fetch' },
  // 'rh-portfolio' removed 2026-05-30: it returned LIVE Robinhood balances with no
  // auth and was publicly reachable via the serveftp mirror. Wallet/balance data
  // now lives only on the local-only claudeclaw dashboard (:3141). Was orphaned
  // (no in-app caller) once the Wallets page moved.
};

export async function GET() {
  const scripts = Object.entries(ALLOWED_SCRIPTS).map(([id, s]) => ({
    id, description: s.desc,
  }));
  return NextResponse.json({ scripts });
}

export async function POST(req: Request) {
  try {
    const { script } = await req.json();
    const entry = ALLOWED_SCRIPTS[script];
    if (!entry) {
      return NextResponse.json({ error: 'Unknown script' }, { status: 400 });
    }
    const output = execSync(entry.cmd, { timeout: 30000, encoding: 'utf-8' });
    return NextResponse.json({ success: true, output: output.slice(0, 1000), script: entry.desc });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 300) }, { status: 500 });
  }
}
