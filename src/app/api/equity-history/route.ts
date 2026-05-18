import {NextResponse, NextRequest } from 'next/server';
import { getEquityHistory, saveDailySnapshot } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

// GET - retrieve equity history for charting
export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const url = new URL(request.url);
    const days = parseInt(url.searchParams.get('days') || '90');
    const history = getEquityHistory(days);

    return NextResponse.json({
      history,
      count: history.length,
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error), history: [] },
      { status: 500 }
    );
  }
}

// POST - save today's snapshot (called by cron or EOD brief)
export async function POST(request: Request) {
  try {
    const data = await request.json();

    saveDailySnapshot({
      equity: data.equity || 0,
      cash: data.cash || 0,
      buying_power: data.buying_power || 0,
      daily_pnl: data.daily_pnl || 0,
      daily_pnl_pct: data.daily_pnl_pct || 0,
      total_return_pct: data.total_return_pct || 0,
      positions_json: JSON.stringify(data.positions || []),
      btc_price: data.btc_price || 0,
      regime: data.regime || '',
      bias: data.bias || '',
    });

    return NextResponse.json({ success: true, date: new Date().toISOString().split('T')[0] });
  } catch (error) {
    return NextResponse.json(
      { success: false, error: String(error) },
      { status: 500 }
    );
  }
}
