'use client';
import React, { useState, useEffect } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

function tradesTickerOnly(sym: string): string {
  if (!sym) return '';
  const s = String(sym).trim().toUpperCase();
  const stripped = s.replace(/USDT$|USD$|-PERP$/, '');
  const occMatch = stripped.match(/^([A-Z]+)\d{6}[CP]/);
  if (occMatch) return occMatch[1];
  const firstWord = stripped.split(/[\s/]/)[0];
  return firstWord.replace(/[^A-Z]/g, '') || stripped;
}

interface Trade {
  id: string;
  timestamp: string;
  bot: string;
  action: string;
  side: string;
  symbol: string;
  size: number;
  size_usd?: number;
  price: number;
  strategy: string;
  source?: string;
  signal?: string;
  type?: string;
  grid_level?: number;
  profit_pct?: number;
  btc_bias?: string;
  btc_score?: number;
  dip_detected?: boolean;
}

interface Position {
  id: string;
  symbol: string;
  side: string;
  action?: string;
  entry_price: number;
  price?: number;
  current_price: number | null;
  size: number;
  size_usd?: number;
  strategy: string;
  source?: string;
  channel?: string;
  score?: number;
  asset_type?: string;
  signal_data?: any;
  opened_at: string;
  status: string;
  unrealized_pnl: number;
  unrealized_pnl_pct: number;
}

interface TweakStats {
  wallet_balance: number;
  available: number;
  active_positions: number;
  total_unrealized_pnl: number;
  total_trades_today: number;
  total_trades: number;
  grid_strategies: number;
  dca_strategies: number;
}

const SOURCE_COLORS: Record<string, string> = {
  ai_crypto: '#4fc3f7',
  firebase:  '#ff9800',
  telegram:  '#0088cc',
  grid:      '#66bb6a',
  dca:       '#4fc3f7',
};

const CRYPTO_SYMBOLS = new Set([
  'BTC','ETH','SOL','BNB','XRP','ADA','DOGE','AVAX','DOT','MATIC',
  'LINK','UNI','LTC','ATOM','PEPE','WIF','BONK','SUI','APT','OP',
  'ARB','AXS','RENDER','SNX','FIL','INJ','SEI','TIA','BLUR','GMX',
  'NEAR','FLOW','HBAR','VET','XLM','EOS','TRX','XMR','FTM','ALGO',
]);

function sourceColor(s: string) {
  return SOURCE_COLORS[s] || '#6b7280';
}

// Detect asset type from position data
function getAssetType(pos: Position): 'crypto' | 'option' | 'stock' {
  if (pos.asset_type === 'option') return 'option';

  // Detect option: signal direction was CALL/PUT
  const sig = pos.signal_data as Record<string, unknown> | null | undefined;
  const dir = sig?.direction || '';
  if (dir === 'CALL' || dir === 'PUT') return 'option';

  // Detect option by price: entry under $50 for a non-crypto symbol
  const base = pos.symbol.split('/')[0].toUpperCase();
  if (!CRYPTO_SYMBOLS.has(base) && pos.entry_price > 0 && pos.entry_price < 50) return 'option';

  // Crypto
  if (CRYPTO_SYMBOLS.has(base) || pos.symbol.includes('/')) return 'crypto';

  return 'stock';
}

export function TradesPage() {
  const [trades, setTrades]       = useState<Trade[]>([]);
  const [positions, setPositions] = useState<Position[]>([]);
  const [stats, setStats]         = useState<TweakStats | null>(null);
  const [loading, setLoading]     = useState(true);
  const [error, setError]         = useState(false);
  const [filter, setFilter]       = useState<'all' | 'grid' | 'dca' | 'telegram' | 'ai_crypto' | 'firebase'>('all');
  const [cryptoPage, setCryptoPage] = useState(0);
  const [stockPage,  setStockPage]  = useState(0);
  const [optionPage, setOptionPage] = useState(0);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);
  const POS_PER_PAGE = 8;

  useEffect(() => {
    fetchData();
    const interval = setInterval(fetchData, 5000);
    return () => clearInterval(interval);
  }, []);

  const fetchData = async () => {
    try {
      const res  = await fetch('/api/trades', { cache: 'no-store' });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      if (data.success) {
        setTrades(data.trades || []);
        setPositions(data.positions || []);
        setStats(data.stats || null);
        setError(false);
      }
      setLoading(false);
    } catch (err) {
      console.error('Error fetching trades:', err);
      setError(true);
      setLoading(false);
    }
  };

  const fmt = {
    currency: (v: number | null | undefined) => `$${(v ?? 0).toFixed(2)}`,
    time:     (ts: string) => new Date(ts).toLocaleTimeString(),
  };

  const pnlClass = (v: number | null | undefined) =>
    (v ?? 0) >= 0 ? 'text-green-400' : 'text-red-400';

  const formatPnL = (v: number | null | undefined) => {
    const n = v ?? 0;
    return <span className={pnlClass(n)}>{n >= 0 ? '+' : ''}${n.toFixed(2)}</span>;
  };

  const formatPct = (v: number | null | undefined) => {
    const n = v ?? 0;
    return <span className={pnlClass(n)}>{n >= 0 ? '+' : ''}{n.toFixed(2)}%</span>;
  };

  const filteredTrades = trades.filter(t => {
    if (filter === 'all')       return true;
    if (filter === 'grid')      return t.type?.includes('grid') || t.strategy === 'grid';
    if (filter === 'dca')       return t.type?.includes('dca')  || t.strategy === 'dca';
    if (filter === 'telegram')  return t.source === 'telegram'  || t.strategy === 'telegram';
    if (filter === 'ai_crypto') return t.source === 'ai_crypto' || t.strategy === 'ai_crypto';
    if (filter === 'firebase')  return t.source === 'firebase'  || t.strategy === 'firebase';
    return true;
  });

  // Split positions by asset type
  const cryptoPositions = positions.filter(p => getAssetType(p) === 'crypto');
  const stockPositions  = positions.filter(p => getAssetType(p) === 'stock');
  const optionPositions = positions.filter(p => getAssetType(p) === 'option');

  const _sourceCount = positions.reduce((acc, p) => {
    const s = p.source || p.strategy || 'unknown';
    acc[s] = (acc[s] || 0) + 1;
    return acc;
  }, {} as Record<string, number>);

  if (loading) {
    return (
      <div className="flex items-center justify-center h-screen">
        <div className="text-white text-xl animate-pulse">Loading trades...</div>
      </div>
    );
  }

  // ── Reusable position table ───────────────────────────────────────────────
  const PositionTable = ({
    title, icon, positions: pos, page, setPage, color, note,
  }: {
    title: string;
    icon: string;
    positions: Position[];
    page: number;
    setPage: (p: number) => void;
    color: string;
    note?: string;
  }) => {
    if (pos.length === 0) return null;
    const totalPages = Math.ceil(pos.length / POS_PER_PAGE);
    const paged      = pos.slice(page * POS_PER_PAGE, (page + 1) * POS_PER_PAGE);

    return (
      <div className="bg-slate-800 rounded-lg p-6">
        <div className="flex items-center justify-between mb-4">
          <div>
            <h2 className="text-xl font-bold text-white flex items-center gap-2">
              <span>{icon}</span>
              <span style={{ color }}>{title}</span>
              <span className="text-sm font-normal text-gray-400 ml-1">({pos.length})</span>
            </h2>
            {note && (
              <p className="text-xs text-gray-500 mt-0.5 ml-7">{note}</p>
            )}
          </div>
          {totalPages > 1 && (
            <div className="flex items-center gap-2 text-sm">
              <button
                onClick={() => setPage(Math.max(0, page - 1))}
                disabled={page === 0}
                className="px-3 py-1 rounded bg-slate-700 text-gray-300 disabled:opacity-40"
              >←</button>
              <span className="text-gray-400">{page + 1} / {totalPages}</span>
              <button
                onClick={() => setPage(Math.min(totalPages - 1, page + 1))}
                disabled={page === totalPages - 1}
                className="px-3 py-1 rounded bg-slate-700 text-gray-300 disabled:opacity-40"
              >→</button>
            </div>
          )}
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-sm">
            <thead>
              <tr className="text-gray-400 text-xs border-b border-gray-700 uppercase tracking-wide">
                <th className="text-left pb-3">Symbol</th>
                <th className="text-left pb-3">Side</th>
                <th className="text-left pb-3">Entry</th>
                <th className="text-left pb-3">Current</th>
                <th className="text-left pb-3">Size</th>
                <th className="text-left pb-3">Source</th>
                <th className="text-left pb-3">P&L</th>
                <th className="text-left pb-3">P&L %</th>
              </tr>
            </thead>
            <tbody>
              {paged.map((position) => {
                const side = (position.side || position.action || 'buy').toLowerCase();
                const src  = position.source || position.strategy || '';
                const isOption = getAssetType(position) === 'option';
                return (
                  <tr key={position.id} className="border-b border-gray-700/40 hover:bg-slate-700/30 transition-colors">
                    <td className="py-2.5 font-semibold text-white">
                      <span onClick={() => setDrawerTicker(tradesTickerOnly(position.symbol))} style={{ cursor: 'pointer' }}>{position.symbol}</span>
                      {position.score && (
                        <span className="ml-1.5 text-xs text-gray-500">⭐{position.score}</span>
                      )}
                    </td>
                    <td className="py-2.5">
                      <span className={`px-2 py-0.5 rounded text-xs font-medium ${
                        side === 'buy' ? 'bg-green-500/20 text-green-400' : 'bg-red-500/20 text-red-400'
                      }`}>
                        {side.toUpperCase()}
                      </span>
                    </td>
                    <td className="py-2.5 tabular-nums text-gray-300">
                      {fmt.currency(position.entry_price || position.price)}
                    </td>
                    <td className="py-2.5 tabular-nums text-gray-300">
                      {isOption ? (
                        <span className="text-xs text-amber-500/70 italic">options contract</span>
                      ) : position.current_price != null ? (
                        fmt.currency(position.current_price)
                      ) : (
                        <span className="text-gray-600 text-xs animate-pulse">fetching…</span>
                      )}
                    </td>
                    <td className="py-2.5 tabular-nums text-gray-300">
                      {fmt.currency(position.size_usd || position.size)}
                    </td>
                    <td className="py-2.5">
                      <span className="text-xs font-medium px-2 py-0.5 rounded"
                            style={{ background: `${sourceColor(src)}22`, color: sourceColor(src) }}>
                        {src || '—'}
                      </span>
                    </td>
                    <td className="py-2.5 tabular-nums">
                      {isOption
                        ? <span className="text-gray-500 text-xs">tracking</span>
                        : formatPnL(position.unrealized_pnl)
                      }
                    </td>
                    <td className="py-2.5">
                      {isOption
                        ? <span className="text-gray-500 text-xs">—</span>
                        : formatPct(position.unrealized_pnl_pct)
                      }
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>

        {totalPages > 1 && (
          <div className="mt-3 text-xs text-gray-500 text-center">
            Showing {page * POS_PER_PAGE + 1}–{Math.min((page + 1) * POS_PER_PAGE, pos.length)} of {pos.length}
          </div>
        )}
      </div>
    );
  };

  return (
    <div className="p-6 space-y-6">

      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}

      {/* Header */}
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold text-white">Trades</h1>
          <p className="text-gray-400 mt-1">Boba&apos;s automated trading activity</p>
        </div>
        <div className="flex items-center space-x-4">
          <div className="px-4 py-2 rounded-lg bg-blue-500/20 text-blue-400">
            <span className="font-semibold">📄 PAPER TRADING</span>
          </div>
          <button disabled className="px-4 py-2 bg-gray-700 text-gray-400 rounded-lg cursor-not-allowed">
            Enable Live Trading (Coming Soon)
          </button>
        </div>
      </div>

      {/* Stats */}
      {stats && (
        <div className="grid grid-cols-2 md:grid-cols-5 gap-4">
          <div className="bg-slate-800 rounded-lg p-4">
            <div className="text-gray-400 text-sm">Wallet Balance</div>
            <div className="text-white text-2xl font-bold mt-1">
              {fmt.currency(stats.wallet_balance)}
            </div>
            {stats.total_unrealized_pnl !== 0 && (
              <div className="text-xs mt-1">
                {formatPnL(stats.total_unrealized_pnl)}
                <span className="text-gray-500 ml-1">unrealized</span>
              </div>
            )}
          </div>
          <div className="bg-slate-800 rounded-lg p-4">
            <div className="text-gray-400 text-sm">Active Positions</div>
            <div className="text-white text-2xl font-bold mt-1">{stats.active_positions}</div>
            <div className="text-xs mt-1 space-y-0.5">
              {cryptoPositions.length > 0 && <div className="text-blue-400">₿ crypto: {cryptoPositions.length}</div>}
              {stockPositions.length  > 0 && <div className="text-green-400">📈 stocks: {stockPositions.length}</div>}
              {optionPositions.length > 0 && <div className="text-amber-400">🎯 options: {optionPositions.length}</div>}
            </div>
          </div>
          <div className="bg-slate-800 rounded-lg p-4">
            <div className="text-gray-400 text-sm">Trades Today</div>
            <div className="text-white text-2xl font-bold mt-1">{stats.total_trades_today}</div>
          </div>
          <div className="bg-slate-800 rounded-lg p-4">
            <div className="text-gray-400 text-sm">Grid Strategies</div>
            <div className="text-white text-2xl font-bold mt-1">{stats.grid_strategies}</div>
          </div>
          <div className="bg-slate-800 rounded-lg p-4">
            <div className="text-gray-400 text-sm">DCA Strategies</div>
            <div className="text-white text-2xl font-bold mt-1">{stats.dca_strategies}</div>
          </div>
        </div>
      )}

      {/* ── Crypto Positions ── */}
      <PositionTable
        title="Crypto Positions"
        icon="₿"
        positions={cryptoPositions}
        page={cryptoPage}
        setPage={setCryptoPage}
        color="#4fc3f7"
      />

      {/* ── Stock Positions ── */}
      <PositionTable
        title="Stock Positions"
        icon="📈"
        positions={stockPositions}
        page={stockPage}
        setPage={setStockPage}
        color="#66bb6a"
      />

      {/* ── Options Positions ── */}
      <PositionTable
        title="Options Contracts"
        icon="🎯"
        positions={optionPositions}
        page={optionPage}
        setPage={setOptionPage}
        color="#ff9800"
        note="Live contract prices require a paid options API. Entry prices shown. P&L tracked on close."
      />

      {/* Trade Filter */}
      <div className="flex flex-wrap gap-2">
        {(['all', 'telegram', 'ai_crypto', 'firebase', 'grid', 'dca'] as const).map(f => (
          <button
            key={f}
            onClick={() => setFilter(f)}
            className={`px-4 py-2 rounded-lg text-sm capitalize transition-colors ${
              filter === f ? 'bg-blue-500 text-white' : 'bg-slate-800 text-gray-400 hover:text-white'
            }`}
            style={filter === f && f !== 'all' ? { backgroundColor: sourceColor(f) } : {}}
          >
            {f === 'all' ? 'All Trades' : f.replace('_', ' ')}
          </button>
        ))}
      </div>

      {/* Trade History */}
      <div className="bg-slate-800 rounded-lg p-6">
        <h2 className="text-xl font-bold text-white mb-4">
          Recent Trades
          <span className="ml-2 text-sm font-normal text-gray-400">
            ({filteredTrades.length} shown)
          </span>
        </h2>
        {filteredTrades.length === 0 ? (
          <div className="text-center text-gray-400 py-8">
            No trades yet. Boba is monitoring markets...
          </div>
        ) : (
          <div className="space-y-1.5 max-h-96 overflow-y-auto pr-1">
            {filteredTrades.slice(0, 100).map((trade, i) => {
              const side = (trade.side || trade.action || '').toLowerCase();
              const src  = trade.source || trade.strategy || '';
              return (
                <div key={`${trade.timestamp}-${i}`}
                     className="bg-slate-700/40 rounded-lg px-4 py-3 flex items-center justify-between">
                  <div className="flex items-center gap-3 flex-wrap">
                    <span className="text-gray-500 text-xs tabular-nums">{fmt.time(trade.timestamp)}</span>
                    <span className={`px-2 py-0.5 rounded text-xs font-medium ${
                      side === 'buy' ? 'bg-green-500/20 text-green-400' : 'bg-red-500/20 text-red-400'
                    }`}>
                      {side.toUpperCase() || 'N/A'}
                    </span>
                    <span onClick={() => setDrawerTicker(tradesTickerOnly(trade.symbol))} className="text-white font-semibold" style={{ cursor: 'pointer' }}>{trade.symbol}</span>
                    <span className="text-gray-400 tabular-nums">{fmt.currency(trade.size_usd || trade.size)}</span>
                    <span className="text-gray-500">@</span>
                    <span className="text-gray-400 tabular-nums">{fmt.currency(trade.price)}</span>
                    {src && (
                      <span className="text-xs px-2 py-0.5 rounded font-medium"
                            style={{ background: `${sourceColor(src)}22`, color: sourceColor(src) }}>
                        {src.replace('_', ' ')}
                      </span>
                    )}
                  </div>
                  {trade.profit_pct !== undefined && (
                    <div className="text-right ml-4">{formatPct(trade.profit_pct)}</div>
                  )}
                </div>
              );
            })}
          </div>
        )}
      </div>
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
