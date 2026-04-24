'use client';
import { useState, useEffect } from 'react';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';

interface Position {
  symbol: string;
  qty: string;
  avg_entry_price: string;
  current_price: string;
  market_value: string;
  cost_basis: string;
  unrealized_pl: string;
  unrealized_plpc: string;
  side: string;
  change_today: string;
}

interface AccountData {
  portfolio_value: string;
  equity: string;
  cash: string;
  buying_power: string;
}

export default function PositionsPage() {
  const [positions, setPositions] = useState<Position[]>([]);
  const [account, setAccount] = useState<AccountData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Fetch positions and account data
        const [positionsRes, accountRes] = await Promise.all([
          fetch('/api/alpaca/positions'),
          fetch('/api/alpaca/account')
        ]);
        
        if (!positionsRes.ok || !accountRes.ok) {
          throw new Error('Failed to fetch data');
        }
        
        const positionsData = await positionsRes.json();
        const accountData = await accountRes.json();
        
        setPositions(positionsData);
        setAccount(accountData);
        setLoading(false);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'Unknown error');
        setLoading(false);
      }
    };

    fetchData();
    const interval = setInterval(fetchData, 5000); // Refresh every 5 seconds
    
    return () => clearInterval(interval);
  }, []);

  const totalMarketValue = positions.reduce((sum, p) => sum + parseFloat(p.market_value), 0);
  const totalPL = positions.reduce((sum, p) => sum + parseFloat(p.unrealized_pl), 0);
  const totalPLPC = totalMarketValue > 0 ? (totalPL / (totalMarketValue - totalPL)) * 100 : 0;

  if (loading) {
    return (
      <div>
        <PageHeader title="Live Positions" subtitle="Real-time portfolio tracking" />
        <div className="text-center py-8 text-[#888]">Loading positions...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div>
        <PageHeader title="Live Positions" subtitle="Real-time portfolio tracking" />
        <div className="bg-red-500/10 border border-red-500/30 rounded-lg p-4 text-red-400">
          Error: {error}
        </div>
      </div>
    );
  }

  return (
    <div>
      <PageHeader title="Live Positions" subtitle="Real-time portfolio tracking" />

      {/* Account Summary */}
      {account && (
        <div className="grid grid-cols-4 gap-4 mb-6">
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <p className="text-xs text-[#888] uppercase tracking-wider mb-1">Portfolio Value</p>
            <p className="text-2xl font-semibold text-[#f0f0f0]">
              ${parseFloat(account.portfolio_value).toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}
            </p>
          </div>
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <p className="text-xs text-[#888] uppercase tracking-wider mb-1">Cash Available</p>
            <p className="text-2xl font-semibold text-[#f0f0f0]">
              ${parseFloat(account.cash).toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}
            </p>
          </div>
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <p className="text-xs text-[#888] uppercase tracking-wider mb-1">Positions Value</p>
            <p className="text-2xl font-semibold text-[#f0f0f0]">
              ${totalMarketValue.toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}
            </p>
          </div>
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <p className="text-xs text-[#888] uppercase tracking-wider mb-1">Total P&L</p>
            <p className={`text-2xl font-semibold ${totalPL >= 0 ? 'text-green-400' : 'text-red-400'}`}>
              ${totalPL.toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}
              <span className="text-sm ml-2">
                ({totalPL >= 0 ? '+' : ''}{totalPLPC.toFixed(2)}%)
              </span>
            </p>
          </div>
        </div>
      )}

      {/* Positions Table */}
      {positions.length === 0 ? (
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-8 text-center">
          <p className="text-[#888]">No open positions</p>
          <p className="text-xs text-[#555] mt-2">Positions will appear here when trades are executed</p>
        </div>
      ) : (
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg overflow-hidden">
          <table className="w-full">
            <thead className="bg-[#0a0a0a] border-b border-[#1f1f1f]">
              <tr className="text-xs text-[#888] uppercase tracking-wider">
                <th className="text-left px-4 py-3">Symbol</th>
                <th className="text-right px-4 py-3">Qty</th>
                <th className="text-right px-4 py-3">Entry Price</th>
                <th className="text-right px-4 py-3">Current Price</th>
                <th className="text-right px-4 py-3">Market Value</th>
                <th className="text-right px-4 py-3">P&L</th>
                <th className="text-right px-4 py-3">P&L %</th>
                <th className="text-right px-4 py-3">Today %</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-[#1a1a1a]">
              {positions.map((position) => {
                const pl = parseFloat(position.unrealized_pl);
                const plpc = parseFloat(position.unrealized_plpc) * 100;
                const changeToday = parseFloat(position.change_today) * 100;
                
                return (
                  <tr key={position.symbol} className="hover:bg-[#0d0d0d] transition-colors">
                    <td className="px-4 py-3">
                      <div className="flex items-center gap-2">
                        <span className="font-bold text-[#f0f0f0]">{position.symbol}</span>
                        <StatusBadge variant="neutral">{position.side}</StatusBadge>
                      </div>
                    </td>
                    <td className="px-4 py-3 text-right font-mono text-[#f0f0f0]">{position.qty}</td>
                    <td className="px-4 py-3 text-right font-mono text-[#888]">
                      ${parseFloat(position.avg_entry_price).toFixed(2)}
                    </td>
                    <td className="px-4 py-3 text-right font-mono text-[#f0f0f0]">
                      ${parseFloat(position.current_price).toFixed(2)}
                    </td>
                    <td className="px-4 py-3 text-right font-mono text-[#f0f0f0]">
                      ${parseFloat(position.market_value).toLocaleString(undefined, {minimumFractionDigits: 2, maximumFractionDigits: 2})}
                    </td>
                    <td className={`px-4 py-3 text-right font-mono font-semibold ${pl >= 0 ? 'text-green-400' : 'text-red-400'}`}>
                      {pl >= 0 ? '+' : ''}${pl.toFixed(2)}
                    </td>
                    <td className={`px-4 py-3 text-right font-mono font-semibold ${plpc >= 0 ? 'text-green-400' : 'text-red-400'}`}>
                      {plpc >= 0 ? '+' : ''}{plpc.toFixed(2)}%
                    </td>
                    <td className={`px-4 py-3 text-right font-mono ${changeToday >= 0 ? 'text-green-400' : 'text-red-400'}`}>
                      {changeToday >= 0 ? '+' : ''}{changeToday.toFixed(2)}%
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      )}

      {/* Last Updated */}
      <p className="text-xs text-[#555] mt-4 text-center">
        Updates every 5 seconds • Paper Trading Account
      </p>
    </div>
  );
}
