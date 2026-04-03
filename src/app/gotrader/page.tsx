'use client';
import { useEffect, useState } from 'react';
import { PageHeader } from '@/components/shared/PageHeader';

export default function GoTraderPage() {
  const [data, setData] = useState<any>(null);

  useEffect(() => {
    fetch('/api/gotrader').then(r => r.json()).then(setData);
  }, []);

  if (!data) return <div className="p-6 text-[#888]">Loading...</div>;

  return (
    <div>
      <PageHeader title="Go-Trader" subtitle="Hybrid Trading Bot — Paper Trading" />

      {/* Status Summary */}
      <div className="grid grid-cols-3 gap-4 mb-6">
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <p className="text-xs text-[#888] uppercase mb-1">Status</p>
          <p className="text-xl font-bold text-green-400">🟢 {data.status}</p>
        </div>
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <p className="text-xs text-[#888] uppercase mb-1">Trades Today</p>
          <p className="text-xl font-bold text-[#f0f0f0]">{data.platforms.hyperliquid.trades_today + data.platforms.robinhood.trades_today + data.platforms.binance_us.trades_today}</p>
        </div>
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <p className="text-xs text-[#888] uppercase mb-1">Total P&L</p>
          <p className={`text-xl font-bold ${data.total_pnl >= 0 ? 'text-green-400' : 'text-red-400'}`}>
            ${data.total_pnl.toFixed(2)}
          </p>
        </div>
      </div>

      {/* Platform Status */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-6 mb-6">
        <h2 className="text-lg font-bold text-white mb-4">📊 Platform Status</h2>
        <div className="grid grid-cols-3 gap-4">
          {Object.entries(data.platforms).map(([name, info]: any) => (
            <div key={name} className="bg-[#0a0a0a] rounded p-4">
              <h3 className="font-semibold text-[#f0f0f0] capitalize mb-2">{name.replace('_', ' ')}</h3>
              <div className="text-xs text-[#888] space-y-1">
                <p>Status: <span className="text-green-400">{info.status}</span></p>
                <p>Trades: <span className="text-white">{info.trades_today}</span></p>
                <p>P&L: <span className={info.pnl >= 0 ? 'text-green-400' : 'text-red-400'}>${info.pnl.toFixed(2)}</span></p>
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Active Positions */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-6">
        <h2 className="text-lg font-bold text-white mb-4">📈 Active Positions</h2>
        {data.active_positions && data.active_positions.length > 0 ? (
          <table className="w-full text-sm">
            <thead className="border-b border-[#1f1f1f]">
              <tr className="text-[#888]">
                <th className="text-left py-2">Symbol</th>
                <th className="text-right py-2">Size</th>
                <th className="text-right py-2">Entry</th>
                <th className="text-right py-2">Current</th>
                <th className="text-right py-2">P&L</th>
              </tr>
            </thead>
            <tbody>
              {data.active_positions.map((pos: any) => (
                <tr key={pos.symbol} className="border-b border-[#0a0a0a]">
                  <td className="py-2 text-white">{pos.symbol}</td>
                  <td className="py-2 text-right text-[#888]">{pos.size}</td>
                  <td className="py-2 text-right text-[#888]">${pos.entry.toFixed(2)}</td>
                  <td className="py-2 text-right text-[#888]">${pos.current.toFixed(2)}</td>
                  <td className={`py-2 text-right font-semibold ${pos.pnl >= 0 ? 'text-green-400' : 'text-red-400'}`}>
                    ${pos.pnl.toFixed(2)}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p className="text-[#555] text-center py-4">No active positions</p>
        )}
      </div>
    </div>
  );
}
