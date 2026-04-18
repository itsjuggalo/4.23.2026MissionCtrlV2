import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';

const PM2_LOGS = join(process.env.HOME || '/home/ubuntu', '.pm2/logs');

interface LogEntry {
  timestamp: string;
  source: string;
  level: 'info' | 'warn' | 'error' | 'debug';
  message: string;
}

function parseLogLine(line: string, source: string, isError: boolean): LogEntry | null {
  if (!line.trim()) return null;

  // Try to extract timestamp
  const tsMatch = line.match(/^(\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2})/);
  const timestamp = tsMatch ? tsMatch[1] : new Date().toISOString();

  // Determine level
  let level: 'info' | 'warn' | 'error' | 'debug' = isError ? 'error' : 'info';
  const lower = line.toLowerCase();
  if (lower.includes('[error]') || lower.includes('error:') || lower.includes('traceback')) level = 'error';
  else if (lower.includes('[warn]') || lower.includes('warning')) level = 'warn';
  else if (lower.includes('[debug]') || lower.includes('debug:')) level = 'debug';

  // Clean message
  let message = line;
  if (tsMatch) message = line.slice(tsMatch[0].length).replace(/^\s*[:\|]\s*/, '').trim();
  if (!message) return null;

  return { timestamp, source, level, message };
}

function readLastLines(filepath: string, maxLines: number): string[] {
  try {
    if (!existsSync(filepath)) return [];
    const content = readFileSync(filepath, 'utf-8');
    const lines = content.split('\n').filter(l => l.trim());
    return lines.slice(-maxLines);
  } catch { return []; }
}

export async function GET(req: Request) {
  const url = new URL(req.url);
  const sourcesParam = url.searchParams.get('sources') || '';
  const limit = parseInt(url.searchParams.get('limit') || '200');

  const requestedSources = sourcesParam ? sourcesParam.split(',') : [];

  const allLogs: LogEntry[] = [];

  const processes = [
    'mission-control', 'signal-receiver', 'option-signals', 'option-signals-relay',
    'flow-monitor', 'telegram-listener', 'telegram-discord-relay', 'brief-forwarder',
    'coupon-claw', 'coupon-monitor', 'deepseek-bot', 'grok-bot', 'skill-scheduler',
  ];

  for (const proc of processes) {
    if (requestedSources.length > 0 && !requestedSources.includes(proc)) continue;

    // Read both out and error logs
    const outFile = join(PM2_LOGS, `${proc}-out.log`);
    const errFile = join(PM2_LOGS, `${proc}-error.log`);

    const outLines = readLastLines(outFile, 50);
    const errLines = readLastLines(errFile, 30);

    for (const line of outLines) {
      const entry = parseLogLine(line, proc, false);
      if (entry) allLogs.push(entry);
    }
    for (const line of errLines) {
      const entry = parseLogLine(line, proc, true);
      if (entry) allLogs.push(entry);
    }
  }

  // Sort by timestamp
  allLogs.sort((a, b) => new Date(a.timestamp).getTime() - new Date(b.timestamp).getTime());

  return NextResponse.json({ logs: allLogs.slice(-limit) });
}
