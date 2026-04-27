import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';

const DB_PATH = join(process.env.HOME || '/home/ubuntu', '.mission-control/mission-control.db');
const PM2_LOGS = join(process.env.HOME || '/home/ubuntu', '.pm2/logs');

interface Activity {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: string;
}

function getFromPm2Logs(limit: number): Activity[] {
  const activities: Activity[] = [];
  const processes = [
    { file: 'signal-receiver-out.log', agent: 'Signal Receiver', type: 'signal' },
    { file: 'mission-control-out.log', agent: 'Mission Control', type: 'system' },
    { file: 'telegram-listener-out.log', agent: 'Telegram Listener', type: 'signal' },
    { file: 'flow-monitor-out.log', agent: 'Flow Monitor', type: 'scraper' },
    { file: 'option-signals-out.log', agent: 'Option Signals', type: 'scraper' },
    { file: 'brief-forwarder-out.log', agent: 'Brief Forwarder', type: 'brief' },
    { file: 'telegram-discord-relay-out.log', agent: 'TG→Discord', type: 'agent' },
    { file: 'grok-bot-out.log', agent: 'Groot', type: 'agent' },
    { file: 'deepseek-bot-out.log', agent: 'DeepSheet', type: 'agent' },
  ];

  for (const proc of processes) {
    const filepath = join(PM2_LOGS, proc.file);
    try {
      if (!existsSync(filepath)) continue;
      const content = readFileSync(filepath, 'utf-8');
      const lines = content.split('\n').filter(l => l.trim()).slice(-20);
      
      for (const line of lines) {
        const tsMatch = line.match(/^(\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2})/);
        const timestamp = tsMatch ? tsMatch[1] : new Date().toISOString();
        let message = line;
        if (tsMatch) message = line.slice(tsMatch[0].length).replace(/^\s*[:\|]\s*/, '').trim();
        if (!message || message.length < 5) continue;

        activities.push({
          time: timestamp.includes('T') ? timestamp : timestamp.replace(' ', 'T') + 'Z',
          agent: proc.agent,
          action: message.slice(0, 80),
          detail: message,
          type: proc.type,
        });
      }
    } catch {}
  }

  activities.sort((a, b) => new Date(b.time).getTime() - new Date(a.time).getTime());
  return activities.slice(0, limit);
}

export async function GET(req: Request) {
  const url = new URL(req.url);
  const limit = parseInt(url.searchParams.get('limit') || '50');

  // Try SQLite first
  try {
    if (existsSync(DB_PATH)) {
      const { execSync } = require('child_process');
      const result = execSync(
        `sqlite3 "${DB_PATH}" "SELECT time, agent, action, detail, type FROM activities ORDER BY time DESC LIMIT ${limit};" 2>/dev/null`,
        { encoding: 'utf-8', timeout: 5000 }
      );
      if (result.trim()) {
        const rows = result.trim().split('\n').map(row => {
          const [time, agent, action, detail, type] = row.split('|');
          return { time, agent, action, detail: detail || action, type: type || 'system' };
        });
        if (rows.length > 0) {
          return NextResponse.json({ activities: rows });
        }
      }
    }
  } catch {}

  // Fallback: read PM2 logs
  const activities = getFromPm2Logs(limit);
  return NextResponse.json({ activities });
}
