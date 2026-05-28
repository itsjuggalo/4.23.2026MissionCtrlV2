export async function GET() {
  // Mock go-trader trades until service is running
  return new Response(JSON.stringify({
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
  }), {
    status: 200,
    headers: { 'Content-Type': 'application/json' }
  });
}
