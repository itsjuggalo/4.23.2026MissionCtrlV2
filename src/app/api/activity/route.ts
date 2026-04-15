import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';
import { readdirSync } from 'fs';

const PM2_LOG_DIR = path.join(process.env.HOME || '/home/ubuntu', '.pm2/logs');
const SCRAPER_DIR = '/home/ubuntu/mission-control-restored/Option-Signals-Scraper';

const EXTRA_LOGS = [
  { file: path.join(PM2_LOG_DIR, 'btc-alert.log'), agent: 'BTC Alert' },
  { file: path.join(PM2_LOG_DIR, 'altcoin-alert.log'), agent: 'Altcoin Alert' },
  { file: path.join(PM2_LOG_DIR, 'stock-alert.log'), agent: 'Stock Alert' },
  { file: path.join(SCRAPER_DIR, 'scraper.log'), agent: 'Option Signals Scraper' },
  { file: path.join(SCRAPER_DIR, 'relay.log'), agent: 'Discord Relay' },
];

const NAME_MAP: Record<string, string> = {
  'option-signals': 'Option Signals Scraper',
  'option-signals-relay': 'Discord Relay',
  'mission-control': 'Mission Control',
  'skill-scheduler': 'Skill Scheduler',
  'telegram-listener': 'Eric (Signal Filter)',
  'analyst': 'The Analyst',
  'risk-manager': 'Risk Manager',
  'macro-strategist': 'Macro Strategist',
  'executor': 'Execution Specialist',
  'portfolio-monitor': 'Portfolio Monitor',
  'auditor': 'The Auditor',
  'broadcaster': 'The Broadcaster',
  'crypto-sniper': 'Crypto Sniper',
  'counter-intel': 'Counter-Intelligence',
  'btc-bias-scorer': 'BTC Bias Scorer',
};

function sanitizeLine(line: string): string | null {
  const upper = line.toUpperCase();
  if (upper.includes('API_KEY=') || upper.includes('SECRET=') || upper.includes('TOKEN=') || upper.includes('PASS=') || upper.includes('PRIVATE')) {
    return null;
  }
  return line;
}

function inferType(line: string): string {
  const lower = line.toLowerCase();
  if (lower.includes('alert') || lower.includes('signal') || lower.includes('rsi') || lower.includes('overbought') || lower.includes('oversold')) return 'signal';
  if (lower.includes('trade') || lower.includes('order') || lower.includes('execution') || lower.includes('buy') || lower.includes('sell')) return 'execution';
  if (lower.includes('risk') || lower.includes('stop') || lower.includes('loss')) return 'risk';
  if (lower.includes('memory') || lower.includes('save') || lower.includes('cache')) return 'memory';
  if (lower.includes('intel') || lower.includes('shield') || lower.includes('threat')) return 'intel';
  return 'system';
}

function parseTimestamp(line: string): string | null {
  // Match: 2026-04-13 22:15:30
  const m1 = line.match(/(\d{4}-\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2})/);
  if (m1) return m1[1];
  // Match: PM2 prefix like "4|mission- |"
  const m2 = line.match(/^\d+\|[^|]+\|\s*(.*)/);
  if (m2) {
    const inner = m2[1].match(/(\d{4}-\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2})/);
    if (inner) return inner[1];
  }
  return null;
}

function cleanLogLine(line: string): string {
  // Strip PM2 prefix
  return line.replace(/^\d+\|[^|]+\|\s*/, '').replace(/^\d{4}-\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}\s+(INFO|WARNING|ERROR|DEBUG)\s*/i, '').trim();
}

async function getLastLines(filePath: string, maxLines: number): Promise<string[]> {
  try {
    const content = await readFile(filePath, 'utf-8');
    const lines = content.trim().split('\n').filter(Boolean);
    return lines.slice(-maxLines);
  } catch {
    return [];
  }
}

export async function GET() {
  try {
    const entries: Array<{
      time: string;
      agent: string;
      action: string;
      detail: string;
      type: string;
      sortKey: number;
    }> = [];

    // Read PM2 out logs
    try {
      const files = readdirSync(PM2_LOG_DIR).filter(f => f.endsWith('-out.log'));
      for (const file of files) {
        const procName = file.replace('-out.log', '');
        const agentName = NAME_MAP[procName] || procName;
        const lines = await getLastLines(path.join(PM2_LOG_DIR, file), 30);

        for (const line of lines) {
          const safe = sanitizeLine(line);
          if (!safe || safe.trim().length < 5) continue;

          const ts = parseTimestamp(safe);
          const cleaned = cleanLogLine(safe);
          if (!cleaned || cleaned.length < 3) continue;

          const type = inferType(cleaned);
          const action = cleaned.slice(0, 80);
          const detail = cleaned.length > 80 ? cleaned.slice(80, 200) : '';

          entries.push({
            time: ts || new Date().toISOString().slice(0, 19).replace('T', ' '),
            agent: agentName,
            action,
            detail,
            type,
            sortKey: ts ? new Date(ts).getTime() : 0,
          });
        }
      }
    } catch {
      // PM2 logs dir might not exist
    }

    // Read extra logs (cron alerts, scraper, relay)
    for (const { file, agent } of EXTRA_LOGS) {
      const lines = await getLastLines(file, 20);
      for (const line of lines) {
        const safe = sanitizeLine(line);
        if (!safe || safe.trim().length < 5) continue;

        const ts = parseTimestamp(safe);
        const cleaned = cleanLogLine(safe);
        if (!cleaned || cleaned.length < 3) continue;

        const type = inferType(cleaned);
        const action = cleaned.slice(0, 80);
        const detail = cleaned.length > 80 ? cleaned.slice(80, 200) : '';

        entries.push({
          time: ts || new Date().toISOString().slice(0, 19).replace('T', ' '),
          agent,
          action,
          detail,
          type,
          sortKey: ts ? new Date(ts).getTime() : 0,
        });
      }
    }

    // Sort by time descending, limit to 50
    entries.sort((a, b) => b.sortKey - a.sortKey);
    const limited = entries.slice(0, 50).map(({ sortKey, ...rest }) => rest);

    return NextResponse.json({
      success: true,
      timestamp: new Date().toISOString(),
      count: limited.length,
      entries: limited,
    });
  } catch (error) {
    return NextResponse.json(
      { success: false, error: 'Failed to read activity logs', entries: [] },
      { status: 500 }
    );
  }
}
