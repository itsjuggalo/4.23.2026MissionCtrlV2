import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

// Coinbase public API — no key, no geo-restrictions
const COINBASE_BASE = 'https://api.coinbase.com/v2/prices';

// Map raw symbol → Coinbase pair
const COINBASE_MAP: Record<string, string> = {
  'BTC/USDT': 'BTC-USD',
  'BTC/USD':  'BTC-USD',
  'BTC':      'BTC-USD',
  'ETH/USDT': 'ETH-USD',
  'ETH/USD':  'ETH-USD',
  'ETH':      'ETH-USD',
  'SOL/USDT': 'SOL-USD',
  'SOL':      'SOL-USD',
  'XRP/USDT': 'XRP-USD',
  'XRP':      'XRP-USD',
  'ADA/USDT': 'ADA-USD',
  'ADA':      'ADA-USD',
  'DOGE/USDT':'DOGE-USD',
  'DOGE':     'DOGE-USD',
  'DOT/USDT': 'DOT-USD',
  'DOT':      'DOT-USD',
  'AVAX/USDT':'AVAX-USD',
  'AVAX':     'AVAX-USD',
  'LINK/USDT':'LINK-USD',
  'LINK':     'LINK-USD',
  'MATIC/USDT':'MATIC-USD',
  'MATIC':    'MATIC-USD',
  'LTC/USDT': 'LTC-USD',
  'LTC':      'LTC-USD',
  'ATOM/USDT':'ATOM-USD',
  'ATOM':     'ATOM-USD',
};

async function fetchLivePrices(rawSymbols: string[]): Promise<Record<string, number>> {
  const prices: Record<string, number> = {};
  if (!rawSymbols.length) return prices;

  const unique = [...new Set(rawSymbols)];

  // Fetch all in parallel — one request per symbol
  await Promise.all(unique.map(async (raw) => {
    const pair = COINBASE_MAP[raw] || COINBASE_MAP[raw.toUpperCase()];
    if (!pair) {
      console.warn(`[trades] No Coinbase mapping for: ${raw}`);
      return;
    }
    try {
      const res = await fetch(`${COINBASE_BASE}/${pair}/spot`, { cache: 'no-store' });
      if (!res.ok) throw new Error(`Coinbase HTTP ${res.status}`);
      const data = await res.json();
      const price = parseFloat(data?.data?.amount);
      if (price > 0) prices[raw] = price;
    } catch (err) {
      console.error(`[trades] Coinbase fetch failed for ${raw}:`, err);
    }
  }));

  return prices;
}

export async function GET() {
  try {
    const tweakDir = '/home/ubuntu/mission-control/tweak';

    // ── Read wallet ──────────────────────────────────────────────────────────
    let base_wallet_balance = 0;
    try {
      const walletData = await fs.readFile(path.join(tweakDir, 'wallet.json'), 'utf-8');
      const wallet = JSON.parse(walletData);
      base_wallet_balance = wallet.balance_usd || 0;
    } catch {
      console.log('[trades] wallet.json not found');
    }

    // ── Read positions ───────────────────────────────────────────────────────
    let rawPositions: any[] = [];
    try {
      const posData = await fs.readFile(path.join(tweakDir, 'positions.json'), 'utf-8');
      const all = JSON.parse(posData);
      rawPositions = Array.isArray(all) ? all.filter((p: any) => p.status === 'open') : [];
    } catch {
      console.log('[trades] positions.json not found');
    }

    // ── Read trades ──────────────────────────────────────────────────────────
    let trades: any[] = [];
    try {
      const tradesData = await fs.readFile(path.join(tweakDir, 'trades.json'), 'utf-8');
      trades = JSON.parse(tradesData);
      if (Array.isArray(trades)) {
        trades.sort((a: any, b: any) =>
          new Date(b.timestamp || b.closed_at || 0).getTime() -
          new Date(a.timestamp || a.closed_at || 0).getTime()
        );
      }
    } catch {
      console.log('[trades] trades.json not found');
    }

    // ── Fetch live prices from Coinbase ──────────────────────────────────────
    const uniqueSymbols = [...new Set(rawPositions.map((p: any) => p.symbol as string))];
    const livePrices = await fetchLivePrices(uniqueSymbols);

    // ── Enrich positions ─────────────────────────────────────────────────────
    let total_unrealized_pnl = 0;

    const positions = rawPositions.map((p: any) => {
      const livePrice  = livePrices[p.symbol] ?? null;
      const entryPrice = p.entry_price || 0;
      const quantity   = p.quantity || 0;
      const sizeUsd    = p.size_usd || p.size || 0;

      let unrealized_pnl     = p.unrealized_pnl || 0;
      let unrealized_pnl_pct = p.unrealized_pnl_pct || 0;

      if (livePrice !== null && entryPrice > 0 && quantity > 0) {
        const side = (p.side || p.action || 'buy').toLowerCase();
        const rawDiff = (livePrice - entryPrice) * quantity;
        unrealized_pnl     = side === 'sell' ? -rawDiff : rawDiff;
        unrealized_pnl_pct = sizeUsd > 0 ? (unrealized_pnl / sizeUsd) * 100 : 0;
      }

      total_unrealized_pnl += unrealized_pnl;

      return {
        ...p,
        current_price: livePrice ?? p.current_price ?? null,
        unrealized_pnl,
        unrealized_pnl_pct,
      };
    });

    // ── Wallet = base + unrealized P&L ───────────────────────────────────────
    const wallet_balance = base_wallet_balance + total_unrealized_pnl;

    // ── P&L by source (optional) ─────────────────────────────────────────────
    let pnl_by_source: any = {};
    try {
      const pnlData = await fs.readFile(path.join(tweakDir, 'pnl_by_source.json'), 'utf-8');
      pnl_by_source = JSON.parse(pnlData);
    } catch { /* optional */ }

    // ── Trades today ─────────────────────────────────────────────────────────
    const todayStart = new Date();
    todayStart.setHours(0, 0, 0, 0);
    const total_trades_today = Array.isArray(trades)
      ? trades.filter((t: any) => new Date(t.timestamp || t.closed_at || 0) >= todayStart).length
      : 0;

    const grid_strategies = positions.filter((p: any) => p.strategy === 'grid').length;
    const dca_strategies  = positions.filter((p: any) => p.strategy === 'dca').length;

    return NextResponse.json({
      success: true,
      trades,
      positions,
      pnl_by_source,
      stats: {
        wallet_balance,
        available: base_wallet_balance,
        active_positions: positions.length,
        total_unrealized_pnl,
        total_trades_today,
        total_trades: Array.isArray(trades) ? trades.length : 0,
        grid_strategies,
        dca_strategies,
      },
      timestamp: new Date().toISOString(),
    });

  } catch (error) {
    console.error('[trades] Unhandled error:', error);
    return NextResponse.json({
      success: false,
      error: error instanceof Error ? error.message : 'Unknown error',
      trades: [],
      positions: [],
      pnl_by_source: {},
      stats: {
        wallet_balance: 0,
        available: 0,
        active_positions: 0,
        total_unrealized_pnl: 0,
        total_trades_today: 0,
        total_trades: 0,
        grid_strategies: 0,
        dca_strategies: 0,
      },
      timestamp: new Date().toISOString(),
    }, { status: 500 });
  }
}