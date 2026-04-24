'use client';
import { useState } from 'react';
import { mockScanResults } from '@/lib/mock/scanner';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { ScanResult } from '@/lib/types';

function trendIcon(trend: string) {
  if (trend === 'bullish') return <span className="text-green-400 font-bold">▲</span>;
  if (trend === 'bearish') return <span className="text-red-400 font-bold">▼</span>;
  return <span className="text-[#555]">—</span>;
}

function strengthVariant(s: string): 'success' | 'warning' | 'neutral' {
  if (s === 'strong') return 'success';
  if (s === 'moderate') return 'warning';
  return 'neutral';
}

function statusVariant(s: string): 'info' | 'neutral' | 'success' {
  if (s === 'new') return 'info';
  if (s === 'sent_to_pipeline') return 'success';
  return 'neutral';
}

function statusLabel(s: string) {
  if (s === 'sent_to_pipeline') return 'Pipeline';
  return s.charAt(0).toUpperCase() + s.slice(1);
}

export default function ScannerPage() {
  const [assetFilter, setAssetFilter] = useState<'all' | 'crypto' | 'stock'>('all');
  const [strengthFilter, setStrengthFilter] = useState<'all' | 'strong' | 'moderate' | 'weak'>('all');
  const [search, setSearch] = useState('');
  const [expanded, setExpanded] = useState<string | null>(null);

  const filtered = mockScanResults.filter(r => {
    if (assetFilter !== 'all' && r.asset_class !== assetFilter) return false;
    if (strengthFilter !== 'all' && r.signalStrength !== strengthFilter) return false;
    if (search && !r.symbol.toLowerCase().includes(search.toLowerCase())) return false;
    return true;
  });

  const total = filtered.length;
  const newCount = filtered.filter(r => r.status === 'new').length;
  const strongCount = filtered.filter(r => r.signalStrength === 'strong').length;

  const toggleExpand = (id: string) => setExpanded(prev => prev === id ? null : id);

  return (
    <div>
      <PageHeader title="Scanner" subtitle="Signal Detection Engine" />

      {/* Filter bar */}
      <div className="flex flex-wrap items-center gap-3 mb-4">
        <div className="flex gap-1">
          {(['all', 'crypto', 'stock'] as const).map(v => (
            <button
              key={v}
              onClick={() => setAssetFilter(v)}
              className={`px-3 py-1 text-xs rounded border transition-all ${
                assetFilter === v
                  ? 'bg-blue-500/10 text-blue-400 border-blue-500/30'
                  : 'text-[#888] border-[#1f1f1f] hover:text-[#f0f0f0] hover:border-[#333]'
              }`}
            >
              {v.charAt(0).toUpperCase() + v.slice(1)}
            </button>
          ))}
        </div>
        <div className="flex gap-1">
          {(['all', 'strong', 'moderate', 'weak'] as const).map(v => (
            <button
              key={v}
              onClick={() => setStrengthFilter(v)}
              className={`px-3 py-1 text-xs rounded border transition-all ${
                strengthFilter === v
                  ? 'bg-blue-500/10 text-blue-400 border-blue-500/30'
                  : 'text-[#888] border-[#1f1f1f] hover:text-[#f0f0f0] hover:border-[#333]'
              }`}
            >
              {v.charAt(0).toUpperCase() + v.slice(1)}
            </button>
          ))}
        </div>
        <input
          value={search}
          onChange={e => setSearch(e.target.value)}
          placeholder="Search symbol..."
          className="px-3 py-1 text-xs bg-[#111] border border-[#1f1f1f] rounded text-[#f0f0f0] placeholder-[#555] focus:outline-none focus:border-blue-500/50 w-40"
        />
        <div className="ml-auto flex items-center gap-4 text-xs text-[#888]">
          <span>{total} total</span>
          <span className="text-blue-400">{newCount} new</span>
          <span className="text-green-400">{strongCount} strong</span>
        </div>
      </div>

      {/* Table */}
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg overflow-hidden">
        <table className="w-full">
          <thead>
            <tr className="text-xs text-[#555] uppercase tracking-wider border-b border-[#1f1f1f]">
              <th className="text-left px-4 py-3">Symbol</th>
              <th className="text-left px-4 py-3">Class</th>
              <th className="text-left px-4 py-3">TF</th>
              <th className="text-right px-4 py-3">Price</th>
              <th className="text-center px-4 py-3">Trend</th>
              <th className="text-center px-4 py-3">Strength</th>
              <th className="text-left px-4 py-3">Scanner</th>
              <th className="text-left px-4 py-3">Time</th>
              <th className="text-center px-4 py-3">Status</th>
              <th className="text-right px-4 py-3">Actions</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-[#1a1a1a]">
            {filtered.map(r => (
              <>
                <tr key={r.id} className="hover:bg-[#161616] transition-colors">
                  <td className="px-4 py-3 font-medium text-[#f0f0f0] text-sm">{r.symbol}</td>
                  <td className="px-4 py-3">
                    <span className="text-xs text-[#888] capitalize">{r.asset_class}</span>
                  </td>
                  <td className="px-4 py-3 text-xs text-[#888]">{r.timeframe}</td>
                  <td className="px-4 py-3 text-right font-mono text-sm text-[#f0f0f0]">
                    ${r.price.toLocaleString('en-US', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
                  </td>
                  <td className="px-4 py-3 text-center">{trendIcon(r.trend)}</td>
                  <td className="px-4 py-3 text-center">
                    <StatusBadge variant={strengthVariant(r.signalStrength)}>
                      {r.signalStrength}
                    </StatusBadge>
                  </td>
                  <td className="px-4 py-3 text-xs text-[#888]">{r.scannerType}</td>
                  <td className="px-4 py-3 text-xs text-[#555]">
                    {new Date(r.timestamp).toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', timeZone: 'UTC' })}
                  </td>
                  <td className="px-4 py-3 text-center">
                    <StatusBadge variant={statusVariant(r.status)}>{statusLabel(r.status)}</StatusBadge>
                  </td>
                  <td className="px-4 py-3 text-right">
                    <div className="flex items-center justify-end gap-2">
                      <button
                        onClick={() => toggleExpand(r.id)}
                        className="text-xs px-2 py-1 border border-[#333] rounded text-[#888] hover:text-[#f0f0f0] hover:border-[#555] transition-all"
                      >
                        {expanded === r.id ? 'Hide' : 'Details'}
                      </button>
                      {r.status === 'new' && (
                        <button className="text-xs px-2 py-1 border border-blue-500/30 rounded text-blue-400 hover:bg-blue-500/10 transition-all">
                          → Pipeline
                        </button>
                      )}
                    </div>
                  </td>
                </tr>
                {expanded === r.id && (
                  <tr key={`${r.id}-expanded`} className="bg-[#0d0d0d]">
                    <td colSpan={10} className="px-4 py-3">
                      <div className="text-xs text-[#888] leading-relaxed border-l-2 border-blue-500/40 pl-3">
                        <span className="text-[#555] uppercase tracking-wider text-[10px] block mb-1">Reasoning</span>
                        {r.reasoning}
                      </div>
                    </td>
                  </tr>
                )}
              </>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
