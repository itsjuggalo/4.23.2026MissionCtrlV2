'use client';
import { useEffect, useState, useCallback } from 'react';
import { ErrorBoundary } from '@/components/shared/ErrorBoundary';
import { PageHeader } from '@/components/shared/PageHeader';
import { RefreshCw, Filter, TrendingUp, TrendingDown, Minus, CheckCircle, XCircle, Clock, Radio } from 'lucide-react';

interface Signal {
  id: string;
  channel_name: string;
  timestamp: string;
  symbol: string;
  direction: string | null;
  entry: number | null;
  stop_loss: number | null;
  targets: number[];
  score: number;
  status: 'approved' | 'rejected' | 'pending';
  raw_text: string;
  price_change: string | null;
  quality_flags: string[];
  tier_emoji: string;
  risk_reward: number | null;
  confirmed_by: string[];
}

interface Stats {
  total: number;
  approved: number;
  rejected: number;
  pending: number;
  highScore: number;
  sources: string[];
}

const statusColor: Record<string, string> = {
  approved: 'text-green-400 bg-green-500/10 border-green-500/20',
  rejected: 'text-red-400 bg-red-500/10 border-red-500/20',
  pending: 'text-yellow-400 bg-yellow-500/10 border-yellow-500/20',
};

const statusIcon: Record<string, any> = {
  approved: CheckCircle,
  rejected: XCircle,
  pending: Clock,
};

const scoreColor = (score: number) => {
  if (score >= 70) return 'text-green-400';
  if (score >= 50) return 'text-yellow-400';
  return 'text-red-400';
};

const dirIcon = (d: string | null) => {
  if (!d) return <Minus className="w-3 h-3 text-[#555]" />;
  if (d === 'LONG' || d === 'BUY') return <TrendingUp className="w-3 h-3 text-green-400" />;
  return <TrendingDown className="w-3 h-3 text-red-400" />;
};

function timeAgo(ts: string) {
  const diff = Date.now() - new Date(ts).getTime();
  const m = Math.floor(diff / 60000);
  const h = Math.floor(m / 60);
  const d = Math.floor(h / 24);
  if (d > 0) return `${d}d ago`;
  if (h > 0) return `${h}h ago`;
  if (m > 0) return `${m}m ago`;
  return 'just now';
}

function SignalRow({ sig, expanded, onToggle }: { sig: Signal; expanded: boolean; onToggle: () => void }) {
  const StatusIcon = statusIcon[sig.status] || Clock;
  return (
    <div
      className={`border rounded-lg transition-colors cursor-pointer ${
        expanded ? 'border-[#2a2a3a] bg-[#0d0d14]' : 'border-[#1a1a2a] bg-[#0a0a12] hover:border-[#222233]'
      }`}
      onClick={onToggle}
    >
      <div className="flex items-center gap-3 px-4 py-3">
        {/* Score */}
        <div className={`text-sm font-bold w-8 text-center ${scoreColor(sig.score)}`}>
          {sig.score}
        </div>

        {/* Direction */}
        <div className="flex-shrink-0">{dirIcon(sig.direction)}</div>

        {/* Symbol */}
        <div className="font-bold text-sm text-[#f0f0f0] w-24 truncate">
          {sig.symbol || '—'}
        </div>

        {/* Source */}
        <div className="text-xs text-[#555] flex-1 truncate">{sig.channel_name}</div>

        {/* Entry */}
        {sig.entry && (
          <div className="text-xs text-[#888] hidden sm:block">
            @ <span className="text-[#f0f0f0]">${sig.entry}</span>
          </div>
        )}

        {/* Direction badge */}
        {sig.direction && (
          <span className={`text-[10px] px-1.5 py-0.5 rounded font-medium border ${
            sig.direction === 'LONG' || sig.direction === 'BUY'
              ? 'text-green-400 bg-green-500/10 border-green-500/20'
              : 'text-red-400 bg-red-500/10 border-red-500/20'
          }`}>
            {sig.direction}
          </span>
        )}

        {/* Status */}
        <span className={`text-[10px] px-1.5 py-0.5 rounded font-medium border flex items-center gap-1 ${statusColor[sig.status]}`}>
          <StatusIcon className="w-2.5 h-2.5" />
          {sig.status}
        </span>

        {/* Time */}
        <div className="text-[10px] text-[#444] w-14 text-right">{timeAgo(sig.timestamp)}</div>
      </div>

      {/* Expanded detail */}
      {expanded && (
        <div className="border-t border-[#1a1a2a] px-4 py-3 space-y-2">
          <div className="grid grid-cols-2 sm:grid-cols-4 gap-3 text-xs">
            {sig.entry && <div><span className="text-[#555]">Entry</span><div className="text-[#f0f0f0] font-medium">${sig.entry}</div></div>}
            {sig.stop_loss && <div><span className="text-[#555]">Stop</span><div className="text-red-400 font-medium">${sig.stop_loss}</div></div>}
            {sig.targets?.length > 0 && <div><span className="text-[#555]">Targets</span><div className="text-green-400 font-medium">{sig.targets.map(t => `$${t}`).join(', ')}</div></div>}
            {sig.risk_reward && <div><span className="text-[#555]">R/R</span><div className="text-purple-400 font-medium">{sig.risk_reward}:1</div></div>}
            {sig.price_change && <div><span className="text-[#555]">24h Change</span><div className="text-[#f0f0f0] font-medium">{sig.price_change}</div></div>}
            <div><span className="text-[#555]">Confirmed by</span><div className="text-[#888]">{sig.confirmed_by?.join(', ') || '—'}</div></div>
          </div>

          {sig.quality_flags?.length > 0 && (
            <div className="flex flex-wrap gap-1">
              {sig.quality_flags.map(f => (
                <span key={f} className={`text-[10px] px-1.5 py-0.5 rounded border ${
                  f.startsWith('no-') || f === 'duplicate-signal' || f === 'low-score'
                    ? 'text-red-400/70 border-red-500/10 bg-red-500/5'
                    : 'text-green-400/70 border-green-500/10 bg-green-500/5'
                }`}>
                  {f}
                </span>
              ))}
            </div>
          )}

          <div className="text-[10px] text-[#444] font-mono leading-relaxed bg-[#060608] rounded p-2 max-h-20 overflow-y-auto">
            {sig.raw_text}
          </div>
        </div>
      )}
    </div>
  );
}

function AlertsInner() {
  const [signals, setSignals] = useState<Signal[]>([]);
  const [stats, setStats] = useState<Stats | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [filterStatus, setFilterStatus] = useState<string>('');
  const [filterSource, setFilterSource] = useState<string>('');
  const [minScore, setMinScore] = useState(0);
  const [expanded, setExpanded] = useState<string | null>(null);
  const [autoRefresh, setAutoRefresh] = useState(true);

  const fetchSignals = useCallback(async () => {
    try {
      const params = new URLSearchParams({ limit: '100' });
      if (filterStatus) params.set('status', filterStatus);
      if (filterSource) params.set('source', filterSource);
      if (minScore > 0) params.set('minScore', String(minScore));

      const res = await fetch(`/api/eric-signals?${params}`);
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      setSignals(data.signals || []);
      setStats(data.stats || null);
      setError(null);
    } catch (e: any) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  }, [filterStatus, filterSource, minScore]);

  useEffect(() => {
    fetchSignals();
  }, [fetchSignals]);

  useEffect(() => {
    if (!autoRefresh) return;
    const id = setInterval(fetchSignals, 5000);
    return () => clearInterval(id);
  }, [autoRefresh, fetchSignals]);

  if (loading) return (
    <div className="flex items-center justify-center py-20">
      <Radio className="w-6 h-6 text-[#333] animate-pulse mr-3" />
      <p className="text-sm text-[#555]">Connecting to Eric's signal feed…</p>
    </div>
  );

  const sources = stats?.sources || [];

  return (
    <div>
      {/* Stats row */}
      {stats && (
        <div className="grid grid-cols-5 gap-3 mb-6">
          {[
            { label: 'Total', value: stats.total, color: 'text-[#f0f0f0]' },
            { label: 'Approved', value: stats.approved, color: 'text-green-400' },
            { label: 'Rejected', value: stats.rejected, color: 'text-red-400' },
            { label: 'Pending', value: stats.pending, color: 'text-yellow-400' },
            { label: 'High Score (70+)', value: stats.highScore, color: 'text-purple-400' },
          ].map(s => (
            <div key={s.label} className="bg-[#0d0d12] border border-[#1a1a2a] rounded-lg p-3 text-center">
              <div className={`text-2xl font-bold ${s.color}`}>{s.value}</div>
              <div className="text-[10px] text-[#444] mt-0.5">{s.label}</div>
            </div>
          ))}
        </div>
      )}

      {/* Filters */}
      <div className="flex items-center gap-3 mb-4 flex-wrap">
        <Filter className="w-3.5 h-3.5 text-[#444]" />

        <select
          value={filterStatus}
          onChange={e => setFilterStatus(e.target.value)}
          className="bg-[#0d0d12] border border-[#1a1a2a] text-xs text-[#f0f0f0] rounded px-2 py-1.5 focus:outline-none"
        >
          <option value="">All status</option>
          <option value="approved">Approved</option>
          <option value="rejected">Rejected</option>
          <option value="pending">Pending</option>
        </select>

        <select
          value={filterSource}
          onChange={e => setFilterSource(e.target.value)}
          className="bg-[#0d0d12] border border-[#1a1a2a] text-xs text-[#f0f0f0] rounded px-2 py-1.5 focus:outline-none max-w-[180px]"
        >
          <option value="">All sources</option>
          {sources.map(s => <option key={s} value={s}>{s}</option>)}
        </select>

        <div className="flex items-center gap-1.5">
          <span className="text-[10px] text-[#555]">Min score:</span>
          <select
            value={minScore}
            onChange={e => setMinScore(parseInt(e.target.value))}
            className="bg-[#0d0d12] border border-[#1a1a2a] text-xs text-[#f0f0f0] rounded px-2 py-1.5 focus:outline-none"
          >
            <option value={0}>Any</option>
            <option value={50}>50+</option>
            <option value={70}>70+</option>
            <option value={85}>85+</option>
          </select>
        </div>

        <div className="ml-auto flex items-center gap-2">
          <button
            onClick={() => setAutoRefresh(r => !r)}
            className={`text-[10px] px-2 py-1 rounded border transition-colors flex items-center gap-1 ${
              autoRefresh
                ? 'text-green-400 border-green-500/20 bg-green-500/5'
                : 'text-[#555] border-[#1a1a2a]'
            }`}
          >
            <Radio className="w-2.5 h-2.5" />
            {autoRefresh ? 'LIVE' : 'Paused'}
          </button>
          <button onClick={fetchSignals} className="p-1.5 text-[#555] hover:text-[#f0f0f0] transition-colors">
            <RefreshCw className="w-3.5 h-3.5" />
          </button>
        </div>
      </div>

      {error && (
        <div className="bg-red-500/10 border border-red-500/20 rounded p-3 text-sm text-red-400 mb-4">{error}</div>
      )}

      {/* Score legend */}
      <div className="flex items-center gap-4 text-[10px] mb-3 text-[#444]">
        <span>Score: <span className="text-green-400">70+ pass</span> · <span className="text-yellow-400">50-69 watch</span> · <span className="text-red-400">&lt;50 noise</span></span>
        <span>{signals.length} signals shown</span>
      </div>

      {/* Signal list */}
      <div className="space-y-1.5">
        {signals.length === 0 ? (
          <div className="text-center py-16 text-[#444] text-sm">No signals match filters</div>
        ) : (
          signals.map(sig => (
            <SignalRow
              key={sig.id}
              sig={sig}
              expanded={expanded === sig.id}
              onToggle={() => setExpanded(prev => prev === sig.id ? null : sig.id)}
            />
          ))
        )}
      </div>
    </div>
  );
}

export default function AlertsPage() {
  return (
    <div>
      <PageHeader title="Eric — Live Signal Feed" subtitle="Real-time Telegram signals · scored · filtered · updated every 5s" />
      <ErrorBoundary name="Alerts">
        <AlertsInner />
      </ErrorBoundary>
    </div>
  );
}
