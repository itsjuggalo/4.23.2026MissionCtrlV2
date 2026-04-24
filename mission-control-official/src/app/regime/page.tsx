'use client';
import React, { useEffect, useState } from 'react';

export default function RegimePage() {
  const [regime, setRegime] = useState<any>(null);

  useEffect(() => {
    fetch('/api/regime')
      .then(res => res.json())
      .then(setRegime);
  }, []);

  if (!regime) return <div className="p-6">Loading...</div>;

  const regimeColors = {
    'Walking on Ice': 'text-yellow-500 border-yellow-500/30',
    'Steady State': 'text-green-500 border-green-500/30',
    'Overheating': 'text-red-500 border-red-500/30',
    'Crisis': 'text-red-700 border-red-700/30'
  };

  const regimeEmoji = {
    'Walking on Ice': '🟡',
    'Steady State': '🟢',
    'Overheating': '🔴',
    'Crisis': '💀'
  };

  return (
    <div className="min-h-screen bg-black p-6">
      <h1 className="text-3xl font-bold text-white mb-6">🌍 Macro Regime Dashboard</h1>

      <div className={`bg-[#1a1a1a] border-2 rounded-lg p-6 mb-6 ${regimeColors[regime.current as keyof typeof regimeColors]}`}>
        <div className="flex items-center justify-between mb-6">
          <div>
            <h2 className="text-4xl font-bold text-white mb-2">
              {regimeEmoji[regime.current as keyof typeof regimeEmoji]} {regime.current}
            </h2>
            <p className="text-[#888]">Score: {regime.score} ({regime.category})</p>
            <p className="text-xs text-[#666]">Updated: {new Date(regime.lastUpdated).toLocaleString()}</p>
          </div>
          <button className="bg-amber-600 hover:bg-amber-700 text-white px-6 py-3 rounded font-bold transition-colors">
            Refresh Regime
          </button>
        </div>

        <div className="grid grid-cols-4 gap-4 mb-6">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">VIX</div>
            <div className="text-2xl font-bold text-white">{regime.indicators.vix}</div>
            <div className="text-xs text-[#666]">Moderate</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">10Y Treasury</div>
            <div className="text-2xl font-bold text-white">{regime.indicators.treasury10y}%</div>
            <div className="text-xs text-[#666]">Neutral</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Unemployment</div>
            <div className="text-2xl font-bold text-white">{regime.indicators.unemployment}%</div>
            <div className="text-xs text-[#666]">Stable</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4 border border-amber-500/30">
            <div className="text-sm text-amber-500">Event Risk</div>
            <div className="text-sm font-bold text-white mt-1">{regime.indicators.eventRisk}</div>
          </div>
        </div>

        <div className="grid grid-cols-2 gap-6">
          <div>
            <h3 className="text-lg font-bold text-white mb-3">Trading Guidance</h3>
            <div className="space-y-2 text-sm">
              <div className="flex">
                <span className="text-[#888] w-32">Position Size:</span>
                <span className="text-white">{regime.guidance.positionSize}</span>
              </div>
              <div className="flex">
                <span className="text-[#888] w-32">Favor:</span>
                <span className="text-white">{regime.guidance.favor}</span>
              </div>
              <div className="flex">
                <span className="text-[#888] w-32">Avoid:</span>
                <span className="text-white">{regime.guidance.avoid}</span>
              </div>
              <div className="flex">
                <span className="text-[#888] w-32">Stop Losses:</span>
                <span className="text-white">{regime.guidance.stopLosses}</span>
              </div>
              <div className="flex">
                <span className="text-[#888] w-32">New Trades:</span>
                <span className="text-white">{regime.guidance.newTrades}</span>
              </div>
            </div>
          </div>

          <div>
            <h3 className="text-lg font-bold text-white mb-3">Recommended Allocation</h3>
            <div className="space-y-2 text-sm mb-4">
              <div className="flex items-center justify-between">
                <span className="text-[#888]">Equities</span>
                <span className="text-white font-bold">{(regime.allocation.equities * 100).toFixed(0)}%</span>
              </div>
              <div className="w-full bg-[#0a0a0a] rounded-full h-2">
                <div className="bg-amber-500 h-2 rounded-full" style={{ width: `${regime.allocation.equities * 100}%` }} />
              </div>

              <div className="flex items-center justify-between">
                <span className="text-[#888]">Bonds</span>
                <span className="text-white font-bold">{(regime.allocation.bonds * 100).toFixed(0)}%</span>
              </div>
              <div className="w-full bg-[#0a0a0a] rounded-full h-2">
                <div className="bg-blue-500 h-2 rounded-full" style={{ width: `${regime.allocation.bonds * 100}%` }} />
              </div>

              <div className="flex items-center justify-between">
                <span className="text-[#888]">Cash</span>
                <span className="text-white font-bold">{(regime.allocation.cash * 100).toFixed(0)}%</span>
              </div>
              <div className="w-full bg-[#0a0a0a] rounded-full h-2">
                <div className="bg-green-500 h-2 rounded-full" style={{ width: `${regime.allocation.cash * 100}%` }} />
              </div>
            </div>
            <div className="text-xs text-[#888] italic">{regime.allocation.rationale}</div>
          </div>
        </div>
      </div>

      <div className={`bg-[#1a1a1a] border rounded-lg p-6 ${
        regime.portfolioAlignment.status === 'OK' ? 'border-green-500/30' : 'border-yellow-500/30'
      }`}>
        <h3 className="text-lg font-bold text-white mb-3">Portfolio Alignment</h3>
        <div className="grid grid-cols-3 gap-4">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Current Equity %</div>
            <div className="text-3xl font-bold text-white">{regime.portfolioAlignment.current}%</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Recommended Max</div>
            <div className="text-3xl font-bold text-amber-500">{regime.portfolioAlignment.recommended}%</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Status</div>
            <div className={`text-2xl font-bold ${regime.portfolioAlignment.status === 'OK' ? 'text-green-500' : 'text-yellow-500'}`}>
              {regime.portfolioAlignment.status}
            </div>
          </div>
        </div>
        <div className="mt-4 p-4 bg-amber-900/20 rounded border border-amber-500/30">
          <p className="text-amber-500 font-bold">⚠️ {regime.portfolioAlignment.warning}</p>
        </div>
      </div>
    </div>
  );
}
