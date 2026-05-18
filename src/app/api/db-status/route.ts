import { NextResponse } from 'next/server';
import { getDbStats, getTradeStats } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const dbStats = getDbStats();
    const tradeStats = getTradeStats();

    return NextResponse.json({
      status: 'online',
      database: dbStats,
      trading: tradeStats,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    return NextResponse.json(
      { status: 'error', error: String(error) },
      { status: 500 }
    );
  }
}
