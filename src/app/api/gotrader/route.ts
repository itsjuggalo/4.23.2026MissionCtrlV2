import { NextResponse } from 'next/server';

export async function GET() {
  return NextResponse.json({
    status: 'paper_trading',
    platforms: {
      hyperliquid: { status: 'ready', trades_today: 0, pnl: 0 },
      robinhood: { status: 'ready', trades_today: 0, pnl: 0 },
      binance_us: { status: 'ready', trades_today: 0, pnl: 0 }
    },
    active_positions: [],
    recent_trades: [],
    total_pnl: 0,
    config: 'scheduler/config.json'
  });
}
