import { NextResponse } from 'next/server';
import { getDbStats, getTradeStats } from '@/lib/db';

export async function GET() {
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
