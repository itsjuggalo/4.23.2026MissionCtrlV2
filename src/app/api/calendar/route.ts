import { NextRequest, NextResponse } from 'next/server';
import { readFile, readdir } from 'fs/promises';

export const dynamic = 'force-dynamic';

const CALENDAR_DIR = '/home/ubuntu/mission-control/daily-reports/calendar';

async function safeRead(path: string) {
  try {
    return JSON.parse(await readFile(path, 'utf-8'));
  } catch {
    return null;
  }
}

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const month = searchParams.get('month'); // e.g., 2026-04

  try {
    // If month specified, return that month's calendar
    if (month) {
      const cal = await safeRead(`${CALENDAR_DIR}/${month}-calendar.json`);
      return NextResponse.json(cal || { month, days: {} });
    }

    // Default: return current month calendar + today's entry
    const now = new Date();
    const ym = `${now.getUTCFullYear()}-${String(now.getUTCMonth() + 1).padStart(2, '0')}`;
    const today = now.toISOString().split('T')[0];

    const cal = await safeRead(`${CALENDAR_DIR}/${ym}-calendar.json`);
    const todayEntry = await safeRead(`${CALENDAR_DIR}/${today}.json`);

    // Build events list from calendar days
    const events: any[] = [];
    const days = cal?.days || {};

    for (const [date, data] of Object.entries(days) as [string, any][]) {
      events.push({
        date,
        title: data.highlight || 'No activity',
        signals: data.signals_received || 0,
        trades: data.trades_closed || 0,
        pnl: data.total_pnl_pct || 0,
        regime: data.regime || 'UNKNOWN',
        bias: data.bias || 'UNKNOWN',
        health: `${data.processes_online || 0}/${data.processes_total || 0}`,
      });
    }

    return NextResponse.json({
      month: ym,
      today: todayEntry,
      events,
      summary: cal?.summary || {},
    });
  } catch (e: any) {
    return NextResponse.json({ month: '', events: [], error: e.message });
  }
}
