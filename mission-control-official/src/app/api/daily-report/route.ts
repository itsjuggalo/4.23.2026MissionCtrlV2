import { NextRequest, NextResponse } from 'next/server';
import { readFile, readdir } from 'fs/promises';

export const dynamic = 'force-dynamic';

const DATA_DIR = '/home/ubuntu/mission-control/signal-receiver/data';
const REPORTS_DIR = '/home/ubuntu/mission-control/daily-reports/reports';
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
  const type = searchParams.get('type') || 'today';

  try {
    if (type === 'today') {
      const data = await safeRead(`${DATA_DIR}/daily_report.json`);
      return NextResponse.json(data || { date: 'none', signals: { total: 0 } });
    }

    if (type === 'history') {
      const files = await readdir(REPORTS_DIR).catch(() => []);
      const reports: any[] = [];
      for (const f of files.slice(-30)) {
        if (f.endsWith('.json')) {
          const r = await safeRead(`${REPORTS_DIR}/${f}`);
          if (r) reports.push(r);
        }
      }
      return NextResponse.json(reports);
    }

    if (type === 'calendar') {
      const now = new Date();
      const ym = `${now.getUTCFullYear()}-${String(now.getUTCMonth() + 1).padStart(2, '0')}`;
      const cal = await safeRead(`${CALENDAR_DIR}/${ym}-calendar.json`);
      return NextResponse.json(cal || { month: ym, days: {} });
    }

    return NextResponse.json({ error: 'Unknown type. Use: today, history, calendar' });
  } catch (e: any) {
    return NextResponse.json({ error: e.message }, { status: 500 });
  }
}
