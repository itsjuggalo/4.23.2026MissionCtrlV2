import { NextResponse } from 'next/server';
import { insertTrade, closeTrade, getRecentTrades, getTradeStats } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

// GET - retrieve trade history + stats
export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const url = new URL(request.url);
    const limit = parseInt(url.searchParams.get('limit') || '50');
    const trades = getRecentTrades(limit);
    const stats = getTradeStats();

    return NextResponse.json({
      trades,
      stats,
      count: trades.length,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error), trades: [], stats: {} },
      { status: 500 }
    );
  }
}

// POST - log a new trade
export async function POST(request: Request) {
  try {
    const data = await request.json();

    if (!data.symbol || !data.direction) {
      return NextResponse.json(
        { error: 'symbol and direction required' },
        { status: 400 }
      );
    }

    const result = insertTrade({
      symbol: data.symbol,
      direction: data.direction,
      entry_price: data.entry_price || data.price || 0,
      quantity: data.quantity || data.qty || 0,
      source: data.source || 'manual',
      notes: data.notes || '',
    });

    return NextResponse.json({
      success: true,
      trade_id: result.lastInsertRowid,
    });
  } catch (error) {
    return NextResponse.json(
      { success: false, error: String(error) },
      { status: 500 }
    );
  }
}

// PUT - close a trade
export async function PUT(request: Request) {
  try {
    const data = await request.json();

    if (!data.id || !data.exit_price) {
      return NextResponse.json(
        { error: 'id and exit_price required' },
        { status: 400 }
      );
    }

    closeTrade(data.id, data.exit_price, data.pnl_dollars || 0, data.pnl_pct || 0);

    return NextResponse.json({ success: true });
  } catch (error) {
    return NextResponse.json(
      { success: false, error: String(error) },
      { status: 500 }
    );
  }
}
