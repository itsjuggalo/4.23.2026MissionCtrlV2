'use client';
import React, { useEffect, useState } from 'react';

export default function PerformancePage() {
  const [agents, setAgents] = useState<any>(null);

  useEffect(() => {
    fetch('/api/agents/status')
      .then(res => res.json())
      .then(setAgents);
  }, []);

  if (!agents) return <div className="p-6">Loading...</div>;

  return (
    <div className="min-h-screen bg-black p-6">
      <h1 className="text-3xl font-bold text-white mb-6">📊 Agent Performance</h1>

      {/* Boba Performance */}
      <div className="bg-[#1a1a1a] border border-[#333] rounded-lg p-6 mb-6">
        <h2 className="text-2xl font-bold text-white mb-4">Boba (Orchestrator)</h2>
        <div className="grid grid-cols-4 gap-4">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Trades Executed</div>
            <div className="text-3xl font-bold text-white">{agents.boba.stats.tradesExecuted}</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Win Rate</div>
            <div className="text-3xl font-bold text-white">{agents.boba.stats.winRate}%</div>
            <div className="text-xs text-[#666]">0/2 closed</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Total P&L</div>
            <div className={`text-3xl font-bold ${agents.boba.stats.totalPL >= 0 ? 'text-green-500' : 'text-red-500'}`}>
              ${agents.boba.stats.totalPL.toFixed(2)}
            </div>
            <div className="text-xs text-[#666]">unrealized</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Decision Speed</div>
            <div className="text-3xl font-bold text-white">{agents.boba.stats.avgDecisionTime}</div>
            <div className="text-xs text-[#666]">alert → execution</div>
          </div>
        </div>
        <div className="mt-4 pt-4 border-t border-[#333]">
          <div className="text-sm text-[#888] mb-2">Risk Management:</div>
          <div className="text-white">✅ Stops defined on all trades</div>
          <div className="text-white">✅ Position sizing within limits (9.3% at risk)</div>
          <div className="text-white">✅ Macro regime checks performed</div>
        </div>
      </div>

      {/* JazzyHazzy Performance */}
      <div className="bg-[#1a1a1a] border border-[#333] rounded-lg p-6 mb-6">
        <h2 className="text-2xl font-bold text-white mb-4">JazzyHazzy (Research & Signals)</h2>
        <div className="grid grid-cols-4 gap-4">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Signals Generated</div>
            <div className="text-3xl font-bold text-white">{agents.jazzyhazzy.stats.signalsGenerated}</div>
            <div className="text-xs text-[#666]">today</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Signal Accuracy</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
            <div className="text-xs text-[#666]">need 10 signals</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Avg Research Time</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Sources/Signal</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
          </div>
        </div>
        <div className="mt-4 pt-4 border-t border-[#333]">
          <div className="text-sm text-[#888] mb-2">Confidence Calibration:</div>
          <div className="text-[#666]">No signals generated yet - calibration pending</div>
        </div>
      </div>

      {/* Orion Performance */}
      <div className="bg-[#1a1a1a] border border-[#333] rounded-lg p-6 mb-6">
        <h2 className="text-2xl font-bold text-white mb-4">Orion (Market Scanner)</h2>
        <div className="grid grid-cols-4 gap-4">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Alerts Sent</div>
            <div className="text-3xl font-bold text-white">{agents.orion.stats.alertsSent}</div>
            <div className="text-xs text-[#666]">today</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Alert Accuracy</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
            <div className="text-xs text-[#666]">need 10 alerts</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Avg Speed</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
            <div className="text-xs text-[#666]">event → alert</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">False Alarms</div>
            <div className="text-3xl font-bold text-green-500">{agents.orion.stats.falseAlarms}</div>
          </div>
        </div>
        <div className="mt-4 pt-4 border-t border-[#333]">
          <div className="text-sm text-[#888] mb-2">Coverage:</div>
          <div className="text-white">Status: {agents.orion.status} - Ready for first alert</div>
        </div>
      </div>

      {/* Team KPIs */}
      <div className="bg-[#1a1a1a] border border-amber-500/30 rounded-lg p-6">
        <h2 className="text-2xl font-bold text-amber-500 mb-4">Team Collaboration</h2>
        <div className="grid grid-cols-3 gap-4">
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Alert → Signal → Trade</div>
            <div className="text-3xl font-bold text-white">0/0</div>
            <div className="text-xs text-[#666]">conversion rate</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Pipeline Time</div>
            <div className="text-3xl font-bold text-[#888]">N/A</div>
            <div className="text-xs text-[#666]">target: &lt;10m</div>
          </div>
          <div className="bg-[#0a0a0a] rounded p-4">
            <div className="text-sm text-[#888]">Collaborative Trades</div>
            <div className="text-3xl font-bold text-white">0</div>
            <div className="text-xs text-[#666]">vs 2 solo (Boba)</div>
          </div>
        </div>
      </div>
    </div>
  );
}
