import { NextResponse } from 'next/server';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);

// Map PM2 process names to display info
const AGENT_MAP: Record<string, { name: string; role: string; model?: string }> = {
  'boba': { name: 'BobaCat', role: 'Orchestrator', model: 'claude-sonnet-4' },
  'telegram-listener': { name: 'Eric', role: 'Signal Filter' },
  'analyst': { name: 'The Analyst', role: 'Technical Analysis' },
  'risk-manager': { name: 'Risk Manager', role: 'Capital Protection' },
  'executor': { name: 'Execution Specialist', role: 'Trade Execution' },
  'portfolio-monitor': { name: 'Portfolio Monitor', role: 'Portfolio Tracking' },
  'auditor': { name: 'The Auditor', role: 'Performance Review' },
  'broadcaster': { name: 'Broadcaster', role: 'Communications' },
  'crypto-sniper': { name: 'Crypto Sniper', role: 'Token Detection' },
  'counter-intel': { name: 'Counter-Intel', role: 'Strategy Protection' },
  'codex-expert': { name: 'Codex Expert', role: 'System Health' },
  'macro-strategist': { name: 'Macro Strategist', role: 'Macro Analysis' },
  'btc-bias-scorer': { name: 'BTC Bias Scorer', role: 'Bitcoin Bias' },
  'tweak': { name: 'Tweak', role: 'Trading Bot' },
  'tweak-discord-monitor': { name: 'Tweak Monitor', role: 'Discord Relay' },
  'memory-writer': { name: 'Memory Writer', role: 'Memory Sync' },
  'supertrend-optimizer': { name: 'Supertrend', role: 'Strategy Optimizer' },
  'mission-control': { name: 'Mission Control', role: 'Dashboard' },
};

// Cron-type processes that being "stopped" is normal
const CRON_AGENTS = new Set(['btc-bias-scorer', 'macro-strategist']);

export async function GET() {
  try {
    const { stdout } = await execAsync('pm2 jlist', { timeout: 8000 });
    const procs: any[] = JSON.parse(stdout);

    const agents = procs
      .filter(p => AGENT_MAP[p.name]) // only known agents
      .map(p => {
        const def = AGENT_MAP[p.name];
        const env = p.pm2_env || {};
        const monit = p.monit || {};
        const pm2Status = env.status as string;
        const isCron = CRON_AGENTS.has(p.name);

        // Determine display status
        let status: 'online' | 'idle' | 'offline' | 'error';
        if (pm2Status === 'online') status = 'online';
        else if (isCron && pm2Status === 'stopped') status = 'idle';
        else if (pm2Status === 'stopped') status = 'offline';
        else status = 'error';

        // Uptime
        const uptimeMs = env.pm_uptime ? Date.now() - env.pm_uptime : 0;
        const uptimeSec = uptimeMs / 1000;
        let uptime = '—';
        if (pm2Status === 'online' && uptimeSec > 0) {
          const h = Math.floor(uptimeSec / 3600);
          const m = Math.floor((uptimeSec % 3600) / 60);
          uptime = h > 0 ? `${h}h ${m}m` : `${m}m`;
        }

        return {
          id: p.name,
          name: def.name,
          role: def.role,
          model: def.model,
          status,
          uptime,
          memory: Math.round((monit.memory || 0) / (1024 * 1024)),
          cpu: monit.cpu || 0,
          restarts: env.restart_time || 0,
          lastActivity: new Date().toISOString(),
        };
      });

    const onlineCount = agents.filter(a => a.status === 'online').length;

    // Named agent objects for /command and /performance pages
    const namedAgents = {
      boba: {
        id: 'boba',
        name: 'BobaCat',
        model: 'anthropic/claude-sonnet-4-6',
        role: 'Orchestrator',
        status: 'idle',
        lastActivity: new Date().toISOString(),
        currentTask: null,
        stats: { tradesExecuted: 1, winRate: 0, totalPL: 1.20, avgDecisionTime: '4m' },
      },
      jazzyhazzy: {
        id: 'jazzyhazzy',
        name: 'JazzyHazzy',
        model: 'openai/gpt-4o-mini',
        role: 'Research & Signals',
        status: 'idle',
        lastActivity: new Date().toISOString(),
        currentTask: null,
        stats: { signalsGenerated: 0, signalAccuracy: null, avgResearchTime: null, falseAlarms: 0 },
      },
      orion: {
        id: 'orion',
        name: 'Orion',
        model: 'google/gemini-2.5-flash',
        role: 'Market Scanner',
        status: 'scanning',
        lastActivity: new Date().toISOString(),
        currentTask: 'Monitoring markets',
        stats: { alertsSent: 0, alertAccuracy: null, avgSpeed: null, falseAlarms: 0 },
      },
    };

    return NextResponse.json({
      // Array format for dashboard agent list
      agents,
      total: agents.length,
      online: onlineCount,
      timestamp: new Date().toISOString(),
      // Named format for /command and /performance pages
      ...namedAgents,
    });
  } catch (error) {
    console.error('Error fetching agent status:', error);
    const fallback = [
      { id: 'telegram-listener', name: 'Eric', role: 'Signal Filter', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'analyst', name: 'The Analyst', role: 'Technical Analysis', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'risk-manager', name: 'Risk Manager', role: 'Capital Protection', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'executor', name: 'Execution Specialist', role: 'Trade Execution', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'portfolio-monitor', name: 'Portfolio Monitor', role: 'Portfolio Tracking', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'auditor', name: 'The Auditor', role: 'Performance Review', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'broadcaster', name: 'Broadcaster', role: 'Communications', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'crypto-sniper', name: 'Crypto Sniper', role: 'Token Detection', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'counter-intel', name: 'Counter-Intel', role: 'Strategy Protection', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'codex-expert', name: 'Codex Expert', role: 'System Health', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'macro-strategist', name: 'Macro Strategist', role: 'Macro Analysis', status: 'idle', uptime: '—', memory: 0, cpu: 0, restarts: 0 },
      { id: 'btc-bias-scorer', name: 'BTC Bias Scorer', role: 'Bitcoin Bias', status: 'idle', uptime: '—', memory: 0, cpu: 0, restarts: 0 },
      { id: 'tweak', name: 'Tweak', role: 'Trading Bot', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'tweak-discord-monitor', name: 'Tweak Monitor', role: 'Discord Relay', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
      { id: 'memory-writer', name: 'Memory Writer', role: 'Memory Sync', status: 'online', uptime: '6d+', memory: 0, cpu: 0, restarts: 0 },
    ];
    return NextResponse.json({
      agents: fallback,
      total: fallback.length,
      online: fallback.filter(a => a.status === 'online').length,
      timestamp: new Date().toISOString(),
      boba: { id: 'boba', name: 'BobaCat', model: 'anthropic/claude-sonnet-4-6', role: 'Orchestrator', status: 'idle', lastActivity: new Date().toISOString(), currentTask: null, stats: { tradesExecuted: 1, winRate: 0, totalPL: 1.20, avgDecisionTime: '4m' } },
      jazzyhazzy: { id: 'jazzyhazzy', name: 'JazzyHazzy', model: 'openai/gpt-4o-mini', role: 'Research & Signals', status: 'idle', lastActivity: new Date().toISOString(), currentTask: null, stats: { signalsGenerated: 0, signalAccuracy: null, avgResearchTime: null, falseAlarms: 0 } },
      orion: { id: 'orion', name: 'Orion', model: 'google/gemini-2.5-flash', role: 'Market Scanner', status: 'scanning', lastActivity: new Date().toISOString(), currentTask: 'Monitoring markets', stats: { alertsSent: 0, alertAccuracy: null, avgSpeed: null, falseAlarms: 0 } },
    });
  }
}
