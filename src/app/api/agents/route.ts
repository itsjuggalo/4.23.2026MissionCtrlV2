import { NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';
import { readFile } from 'fs/promises';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const execAsync = promisify(exec);

const PM2_LOG_DIR = path.join(process.env.HOME || '/home/itsju', '.pm2/logs');

// Agent definitions with tiers
const AGENT_DEFINITIONS = {
  'telegram-listener': { name: 'Eric', tier: 1, role: 'Signal Filter', dna: 'Point72', emoji: '📡', specialty: 'Telegram signal detection' },
  'analyst': { name: 'The Analyst', tier: 2, role: 'Technical Analysis', dna: 'Renaissance Tech', emoji: '📊', specialty: 'Technical analysis' },
  'risk-manager': { name: 'Risk Manager', tier: 2, role: 'Capital Protection', dna: 'Bridgewater', emoji: '⚖️', specialty: 'Risk management' },
  'macro-strategist': { name: 'Macro Strategist', tier: 1, role: 'Macro Environment', dna: 'Soros Fund', emoji: '🌍', specialty: 'Macro analysis', isCron: true },
  'executor': { name: 'Execution Specialist', tier: 3, role: 'Trade Execution', dna: 'Citadel', emoji: '⚡', specialty: 'Trade execution' },
  'portfolio-monitor': { name: 'Portfolio Monitor', tier: 3, role: 'Portfolio Tracking', dna: 'BlackRock', emoji: '💰', specialty: 'Portfolio tracking' },
  'auditor': { name: 'The Auditor', tier: 4, role: 'Performance Review', dna: 'DE Shaw', emoji: '📝', specialty: 'Performance review' },
  'broadcaster': { name: 'The Broadcaster', tier: 5, role: 'External Updates', dna: '', emoji: '📢', specialty: 'Communications' },
  'crypto-sniper': { name: 'Crypto Sniper', tier: 1, role: 'New Token Detection', dna: '', emoji: '🎯', specialty: 'Token detection' },
  'counter-intel': { name: 'Counter-Intelligence', tier: 5, role: 'Strategy Protection & ML', dna: '', emoji: '🛡️', specialty: 'Security & ML' },
  'codex-expert': { name: 'Codex Expert', tier: 5, role: 'System Health & Auto-Fix', dna: '', emoji: '🤖', specialty: 'System health' },
  'btc-bias-scorer': { name: 'BTC Bias Scorer', tier: 1, role: 'Bitcoin Directional Bias', dna: '', emoji: '₿', specialty: 'BTC bias scoring', isCron: true },
  'tweak': { name: 'Boba', tier: 3, role: 'Trading Bot', dna: '', emoji: '🎯', specialty: 'Automated trading' },
  'mission-control': { name: 'Mission Control', tier: 5, role: 'Dashboard & UI', dna: '', emoji: '🖥️', specialty: 'Web dashboard' },
};

async function getLastLogLine(name: string): Promise<string> {
  const logPath = path.join(PM2_LOG_DIR, `${name}-out.log`);
  try {
    const content = await readFile(logPath, 'utf-8');
    const lines = content.trim().split('\n').filter(Boolean);
    if (!lines.length) return '—';
    const last = lines[lines.length - 1];
    return last.replace(/^\d+\|[^|]+\|\s*/, '').replace(/^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2} /, '').trim().slice(0, 120);
  } catch {
    return '—';
  }
}

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const { stdout } = await execAsync('pm2 jlist', { timeout: 10000 });
    const procs: Array<Record<string, unknown>> = JSON.parse(stdout);

    const agents = await Promise.all(procs.map(async (p) => {
      const pm2Name = p.name as string;
      const def = AGENT_DEFINITIONS[pm2Name as keyof typeof AGENT_DEFINITIONS] || { name: pm2Name, tier: 5, role: 'Unknown', emoji: '❓' };
      
      const env = (p.pm2_env as Record<string, unknown>) || {};
      const monit = (p.monit as Record<string, number>) || {};
      const status = env.status as string;
      const restarts = env.restart_time as number ?? 0;
      const memBytes = monit.memory ?? 0;
      const memMb = Math.round(memBytes / (1024 * 1024));
      const cpu = monit.cpu ?? 0;

      // Uptime calculation
      const uptimeMs = env.pm_uptime ? Date.now() - (env.pm_uptime as number) : 0;
      const uptimeSec = uptimeMs / 1000;
      let uptime = '—';
      if (status === 'online' && uptimeSec > 0) {
        const h = Math.floor(uptimeSec / 3600);
        const m = Math.floor((uptimeSec % 3600) / 60);
        uptime = h > 0 ? `${h}h ${m}m` : `${m}m`;
      }

      const lastLog = status === 'online' ? await getLastLogLine(pm2Name) : '—';
      const isCron = (def as any).isCron || false;

      // Determine if status is "expected" for cron jobs
      const statusStr = (isCron && status === 'stopped') ? 'idle' : status;

      return {
        id: pm2Name,
        name: def.name,
        tier: def.tier,
        tierName: ['', 'Intelligence', 'Analysis', 'Execution', 'Review', 'Support'][def.tier] || 'Support',
        dna: def.dna,
        emoji: def.emoji,
        status: statusStr,
        specialty: def.specialty,
        description: def.role,
        stats: {
          uptime,
          memMb,
          cpu,
          restarts,
          lastLog,
          pid: p.pid,
        },
        uptime,
        lastActive: lastLog,
      };
    }));

    return NextResponse.json({
      success: true,
      agents,
      timestamp: new Date().toISOString(),
    });
  } catch (err) {
    const msg = err instanceof Error ? err.message : String(err);
    // pm2 isn't installed on every host (e.g. the local laptop). That's not a
    // server error — there are simply no pm2-managed agents to report.
    if (/not found|ENOENT|command not found/i.test(msg)) {
      return NextResponse.json({
        success: true,
        agents: [],
        note: 'pm2 not available on this host',
        timestamp: new Date().toISOString(),
      });
    }
    console.error('Error in agents API:', err);
    return NextResponse.json({
      success: false,
      agents: [],
      error: msg,
      timestamp: new Date().toISOString(),
    }, { status: 500 });
  }
}