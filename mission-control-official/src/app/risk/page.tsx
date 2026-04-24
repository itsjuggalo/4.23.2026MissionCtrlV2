'use client';
import { mockRiskRules } from '@/lib/mock/risk';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { RiskStatus } from '@/lib/types';
import { XCircle, ShieldAlert } from 'lucide-react';

const ruleStatusVariant: Record<RiskStatus, 'success' | 'warning' | 'error'> = {
  ok: 'success',
  warning: 'warning',
  blocked: 'error',
};

export default function RiskPage() {
  const warningCount = mockRiskRules.filter(r => r.status === 'warning').length;
  const blockedCount = mockRiskRules.filter(r => r.status === 'blocked').length;

  return (
    <div>
      <PageHeader title="Risk" subtitle="Risk Management & Controls" />

      {/* Status header */}
      <div className="flex items-center gap-3 mb-6 bg-[#111] border border-[#1f1f1f] rounded-lg px-4 py-3">
        <ShieldAlert className="w-5 h-5 text-yellow-400" />
        <div>
          <p className="text-sm font-medium text-[#f0f0f0]">Risk Status</p>
          <p className="text-xs text-[#888]">{warningCount} rule{warningCount !== 1 ? 's' : ''} in warning state · {blockedCount} blocked</p>
        </div>
        <div className="ml-auto">
          <StatusBadge variant="warning">Warning</StatusBadge>
        </div>
      </div>

      {/* Daily drawdown bar */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 mb-6">
        <div className="flex items-center justify-between mb-2">
          <h2 className="text-sm font-semibold text-[#f0f0f0]">Daily Drawdown</h2>
          <span className="text-sm font-medium text-yellow-400">1.8% / 2.0%</span>
        </div>
        <div className="w-full bg-[#1a1a1a] rounded-full h-3">
          <div
            className="bg-yellow-400 h-3 rounded-full relative overflow-visible"
            style={{ width: '90%' }}
          >
            <span className="absolute right-0 top-1/2 -translate-y-1/2 w-4 h-4 rounded-full bg-yellow-300 border-2 border-[#111] shadow-lg" />
          </div>
        </div>
        <div className="flex justify-between text-xs text-[#555] mt-1">
          <span>0%</span>
          <span className="text-yellow-400 font-medium">90% of limit used</span>
          <span>2.0%</span>
        </div>
      </div>

      {/* Rules table */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg overflow-hidden mb-6">
        <div className="px-4 py-3 border-b border-[#1f1f1f]">
          <h2 className="text-sm font-semibold text-[#f0f0f0]">Risk Rules</h2>
        </div>
        <table className="w-full">
          <thead>
            <tr className="text-xs text-[#555] uppercase tracking-wider border-b border-[#1f1f1f]">
              <th className="text-left px-4 py-3">Rule</th>
              <th className="text-left px-4 py-3">Description</th>
              <th className="text-center px-4 py-3">Current</th>
              <th className="text-center px-4 py-3">Limit</th>
              <th className="text-center px-4 py-3">Status</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-[#1a1a1a]">
            {mockRiskRules.map(rule => (
              <tr key={rule.id} className="hover:bg-[#161616] transition-colors">
                <td className="px-4 py-3 text-sm font-medium text-[#f0f0f0]">{rule.name}</td>
                <td className="px-4 py-3 text-xs text-[#888]">{rule.description}</td>
                <td className="px-4 py-3 text-center">
                  <span className={`text-sm font-medium ${rule.status === 'warning' ? 'text-yellow-400' : rule.status === 'blocked' ? 'text-red-400' : 'text-[#f0f0f0]'}`}>
                    {rule.currentValue}
                  </span>
                </td>
                <td className="px-4 py-3 text-center text-xs text-[#555]">{rule.limit}</td>
                <td className="px-4 py-3 text-center">
                  <StatusBadge variant={ruleStatusVariant[rule.status]}>{rule.status}</StatusBadge>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Blocked Trades */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 mb-6">
        <h2 className="text-sm font-semibold text-[#f0f0f0] mb-3">Blocked Trades</h2>
        <div className="flex items-start gap-3 bg-red-500/5 border border-red-500/20 rounded-lg p-3">
          <XCircle className="w-4 h-4 text-red-400 mt-0.5 flex-shrink-0" />
          <div>
            <p className="text-sm font-medium text-[#f0f0f0]">AAPL — Long (MACD Cross)</p>
            <p className="text-xs text-red-400 mt-0.5">Rejected: Confidence below threshold (45% &lt; 60%)</p>
            <p className="text-xs text-[#555] mt-0.5">Conflicting signals on weekly timeframe · Low volume</p>
          </div>
        </div>
      </div>

      {/* Hard Rules */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
        <h2 className="text-sm font-semibold text-[#f0f0f0] mb-3">Hard Rules — Non-Negotiable</h2>
        <ul className="space-y-2 text-sm text-[#888]">
          {[
            'Maximum 1% capital at risk per single trade',
            'Stop loss required on every trade — no exceptions',
            'Minimum 2:1 reward-to-risk ratio',
            'Maximum 2% daily drawdown — system pauses if hit',
            'Maximum 5 open positions simultaneously',
            'No single asset can exceed 20% of portfolio',
            'All trades in simulation mode until approved',
          ].map((rule, i) => (
            <li key={i} className="flex items-start gap-2">
              <span className="text-green-400 flex-shrink-0 mt-0.5">✓</span>
              {rule}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
