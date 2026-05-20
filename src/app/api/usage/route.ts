import { NextResponse } from 'next/server';
import { execSync } from 'child_process';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const DATA_DIR = join(process.env.HOME || '/home/itsju', '.mission-control');
const USAGE_FILE = join(DATA_DIR, 'api_usage.json');

export async function GET() {
  // Get real PM2 memory/cpu usage
  let pm2Data: any[] = [];
  try {
    const raw = execSync('pm2 jlist 2>/dev/null', { encoding: 'utf-8', timeout: 5000 });
    pm2Data = JSON.parse(raw);
  } catch {}

  const totalMemMB = pm2Data.reduce((s, p) => s + (p.monit?.memory || 0), 0) / 1024 / 1024;
  const totalCpu = pm2Data.reduce((s, p) => s + (p.monit?.cpu || 0), 0);
  const processCount = pm2Data.length;
  const uptimeHrs = pm2Data.length > 0 ? Math.round((Date.now() - Math.min(...pm2Data.map(p => p.pm2_env?.pm_uptime || Date.now()))) / 3600000) : 0;

  // Estimate API costs from log activity
  let anthropicCalls = 0, openaiCalls = 0, geminiCalls = 0, deepseekCalls = 0, xaiCalls = 0;
  const logDir = join(process.env.HOME || '/home/itsju', '.pm2/logs');
  
  try {
    // Count API calls from skill scheduler logs (today)
    const schedulerLog = join(logDir, 'skill-scheduler-out.log');
    if (existsSync(schedulerLog)) {
      const content = readFileSync(schedulerLog, 'utf-8');
      const today = new Date().toISOString().split('T')[0];
      const todayLines = content.split('\n').filter(l => l.includes(today) && l.includes('success'));
      // Each skill run uses ~1 API call
      geminiCalls = todayLines.filter(l => l.includes('crypto-')).length;
      anthropicCalls = todayLines.filter(l => l.includes('portfolio') || l.includes('morning') || l.includes('sentiment')).length;
    }
  } catch {}

  // Estimated costs (rough per-call estimates)
  const costs = {
    anthropic: { calls: anthropicCalls, cost: anthropicCalls * 0.015, budget: 50 },
    gemini: { calls: geminiCalls, cost: geminiCalls * 0.001, budget: 0 },
    openai: { calls: openaiCalls, cost: openaiCalls * 0.005, budget: 20 },
    deepseek: { calls: deepseekCalls, cost: deepseekCalls * 0.002, budget: 20 },
    xai: { calls: xaiCalls, cost: xaiCalls * 0.005, budget: 20 },
  };

  const totalCost = Object.values(costs).reduce((s, c) => s + c.cost, 0);
  const totalCalls = Object.values(costs).reduce((s, c) => s + c.calls, 0);

  return NextResponse.json({
    balances: Object.fromEntries(
      Object.entries(costs).map(([k, v]) => [k, {
        budget: v.budget,
        spent: Math.round(v.cost * 100) / 100,
        remaining: Math.round((v.budget - v.cost) * 100) / 100,
        pct_used: v.budget > 0 ? Math.round((v.cost / v.budget) * 10000) / 100 : 0,
        calls_today: v.calls,
      }])
    ),
    infrastructure: {
      processes: processCount,
      memory_mb: Math.round(totalMemMB),
      cpu_pct: Math.round(totalCpu * 10) / 10,
      uptime_hrs: uptimeHrs,
    },
    totals: {
      cost_today: Math.round(totalCost * 100) / 100,
      calls_today: totalCalls,
    },
    spendByProvider: Object.fromEntries(Object.entries(costs).filter(([,v]) => v.cost > 0).map(([k, v]) => [k, v.cost])),
    tokensByProvider: {},
  });
}