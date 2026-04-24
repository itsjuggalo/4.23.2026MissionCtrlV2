import { NextResponse } from 'next/server';

export async function GET() {
  // TODO: Read from Alpaca account + trade logs
  // For now, return known values
  
  const mission = {
    current: 99997,
    target: 110000,
    progress: 0,
    daysRemaining: 7,
    dailyTarget: 1429,
    todayPL: -3,
    openPositions: 2,
    closedTrades: 0,
    winRate: 0,
    totalRisk: 9.3 // % of portfolio at risk
  };

  return NextResponse.json(mission);
}
