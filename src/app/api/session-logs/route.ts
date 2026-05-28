import { NextResponse } from 'next/server';
import { readFileSync, existsSync, statSync } from 'fs';
import { join } from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const PM2_LOGS = join(process.env.HOME || '/home/itsju', '.pm2/logs');

const SOURCES = [
  { out: 'mission-control-out.log', err: 'mission-control-error.log', name: 'Mission Control' },
  { out: 'signal-receiver-out.log', err: 'signal-receiver-error.log', name: 'Signal Receiver' },
  { out: 'option-signals-out.log', err: 'option-signals-error.log', name: 'Option Signals' },
  { out: 'option-signals-relay-out.log', err: 'option-signals-relay-error.log', name: 'Signals Relay' },
  { out: 'flow-monitor-out.log', err: 'flow-monitor-error.log', name: 'Flow Monitor' },
  { out: 'telegram-listener-out.log', err: 'telegram-listener-error.log', name: 'Telegram Listener' },
  { out: 'telegram-discord-relay-out.log', err: 'telegram-discord-relay-error.log', name: 'TG→Discord Relay' },
  { out: 'brief-forwarder-out.log', err: 'brief-forwarder-error.log', name: 'Brief Forwarder' },
  { out: 'coupon-claw-out.log', err: 'coupon-claw-error.log', name: 'CouponClaw' },
  { out: 'skill-scheduler-out.log', err: 'skill-scheduler-error.log', name: 'Skill Scheduler' },
  { out: 'deepseek-bot-out.log', err: 'deepseek-bot-error.log', name: 'DeepSheet Bot' },
  { out: 'grok-bot-out.log', err: 'grok-bot-error.log', name: 'Groot Bot' },
  { out: 'coupon-monitor-out.log', err: 'coupon-monitor-error.log', name: 'Coupon Monitor' },
];

function parseTimestamp(line: string, fileMtime: Date): string {
  // Try ISO format: 2026-04-18T19:42:15.917583+00:00
  const isoMatch = line.match(/(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2})/);
  if (isoMatch) return new Date(isoMatch[1] + 'Z').toISOString();

  // Try bracket format: [2026-04-18 15:32:12]
  const bracketMatch = line.match(/\[(\d{4}-\d{2}-\d{2})\s+(\d{2}:\d{2}:\d{2})\]/);
  if (bracketMatch) return new Date(bracketMatch[1] + 'T' + bracketMatch[2] + 'Z').toISOString();

  // Try date prefix: 2026-04-18 15:32:12
  const dateMatch = line.match(/^(\d{4}-\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2})/);
  if (dateMatch) return new Date(dateMatch[1].replace(' ', 'T') + 'Z').toISOString();

  // Fallback to file modification time
  return fileMtime.toISOString();
}

function readLogFile(filepath: string, source: string, level: 'info' | 'error', limit: number): any[] {
  try {
    if (!existsSync(filepath)) return [];
    const stat = statSync(filepath);
    const content = readFileSync(filepath, 'utf-8');
    const lines = content.split('\n').filter(l => l.trim().length > 5);
    const tail = lines.slice(-limit);

    return tail.map(line => ({
      timestamp: parseTimestamp(line, stat.mtime),
      source,
      level,
      message: line.replace(/^\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2}[^\s]*\s*/, '').replace(/^\[.*?\]\s*/, '').trim() || line,
    }));
  } catch { return []; }
}

export async function GET(req: Request) {
  try {
    const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
    const url = new URL(req.url);
    const limit = Math.min(parseInt(url.searchParams.get('limit') || '200', 10) || 200, 500);
    const perFile = Math.ceil(limit / (SOURCES.length * 2));

    let logs: any[] = [];
    for (const src of SOURCES) {
      logs.push(...readLogFile(join(PM2_LOGS, src.out), src.name, 'info', perFile));
      logs.push(...readLogFile(join(PM2_LOGS, src.err), src.name, 'error', perFile));
    }

    logs.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());
    logs = logs.slice(0, limit);

    return NextResponse.json({ logs, sources: SOURCES.map(s => s.name) });
  } catch (e: unknown) {
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}