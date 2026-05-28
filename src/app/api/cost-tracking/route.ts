import { NextResponse } from 'next/server';
import { getCostSummary, logSession, getDb } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const url = new URL(request.url);
    const days = parseInt(url.searchParams.get('days') || '30', 10) || 30;
    const summary = getCostSummary(days);

    // Also get daily totals for charting
    const db = getDb();
    const dailyCosts = db.prepare(`
      SELECT date(started_at) as date,
        SUM(cost_dollars) as daily_cost,
        SUM(input_tokens) as daily_input,
        SUM(output_tokens) as daily_output,
        COUNT(*) as sessions
      FROM sessions
      WHERE started_at >= datetime('now', '-' || ? || ' days')
      GROUP BY date(started_at)
      ORDER BY date ASC
    `).all(days);

    return NextResponse.json({
      summary,
      daily: dailyCosts,
      total_cost: summary.reduce((s: number, r: any) => s + (r.total_cost || 0), 0),
      total_sessions: summary.reduce((s: number, r: any) => s + (r.sessions || 0), 0),
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error).slice(0, 200), summary: [], daily: [] },
      { status: 500 }
    );
  }
}

export async function POST(request: Request) {
  try {
    const data = await request.json();
    logSession(
      data.agent || 'unknown',
      data.model || 'unknown',
      data.input_tokens || 0,
      data.output_tokens || 0,
      data.cost || 0,
      data.task || ''
    );
    return NextResponse.json({ success: true });
  } catch (error) {
    return NextResponse.json({ success: false, error: String(error).slice(0, 200) }, { status: 500 });
  }
}
