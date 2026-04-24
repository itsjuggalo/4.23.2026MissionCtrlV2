'use client';
import { useState } from 'react';
import { mockActivity } from '@/lib/mock/activity';
import { PageHeader } from '@/components/shared/PageHeader';
import { ActivityEvent } from '@/lib/types';
import { ScanLine, Bot, Brain, Zap, Shield, AlertTriangle } from 'lucide-react';

type FilterType = 'all' | ActivityEvent['type'];

const filters: { value: FilterType; label: string }[] = [
  { value: 'all', label: 'All' },
  { value: 'scanner', label: 'Scanner' },
  { value: 'agent', label: 'Agent' },
  { value: 'decision', label: 'Decision' },
  { value: 'execution', label: 'Execution' },
  { value: 'risk_rejection', label: 'Risk' },
];

const severityBorder: Record<string, string> = {
  success: 'bg-green-500',
  warning: 'bg-yellow-500',
  error: 'bg-red-500',
  info: 'bg-blue-500',
};

function TypeIcon({ type }: { type: ActivityEvent['type'] }) {
  const cls = 'w-4 h-4';
  if (type === 'scanner') return <ScanLine className={cls} />;
  if (type === 'agent') return <Bot className={cls} />;
  if (type === 'memory') return <Brain className={cls} />;
  if (type === 'execution') return <Zap className={cls} />;
  if (type === 'risk_rejection') return <Shield className={cls} />;
  return <AlertTriangle className={cls} />;
}

export default function ActivityPage() {
  const [filter, setFilter] = useState<FilterType>('all');

  const filtered = filter === 'all'
    ? mockActivity
    : mockActivity.filter(e => e.type === filter);

  return (
    <div>
      <PageHeader title="Activity" subtitle="System Event Feed" />

      {/* Filter bar */}
      <div className="flex gap-1 mb-6 flex-wrap">
        {filters.map(f => (
          <button
            key={f.value}
            onClick={() => setFilter(f.value)}
            className={`px-3 py-1 text-xs rounded border transition-all ${
              filter === f.value
                ? 'bg-blue-500/10 text-blue-400 border-blue-500/30'
                : 'text-[#888] border-[#1f1f1f] hover:text-[#f0f0f0] hover:border-[#333]'
            }`}
          >
            {f.label}
          </button>
        ))}
      </div>

      {/* Feed */}
      <div className="space-y-1">
        {filtered.map(event => (
          <div key={event.id} className="flex items-start gap-3 bg-[#111] border border-[#1f1f1f] rounded-lg p-3 hover:bg-[#161616] transition-colors">
            {/* Severity bar */}
            <div className={`w-1 self-stretch rounded-full flex-shrink-0 ${severityBorder[event.severity]}`} />
            {/* Icon */}
            <span className="text-[#555] mt-0.5 flex-shrink-0">
              <TypeIcon type={event.type} />
            </span>
            {/* Content */}
            <div className="flex-1 min-w-0">
              <p className="text-sm text-[#f0f0f0]">{event.message}</p>
              <p className="text-xs text-[#555] mt-0.5">
                {event.type.replace('_', ' ')} · {new Date(event.timestamp).toLocaleString('en-US', { timeZone: 'UTC', hour: '2-digit', minute: '2-digit', month: 'short', day: 'numeric' })} UTC
              </p>
            </div>
            {/* Time */}
            <span className="text-xs text-[#444] flex-shrink-0">
              {new Date(event.timestamp).toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', timeZone: 'UTC' })}
            </span>
          </div>
        ))}
        {filtered.length === 0 && (
          <div className="text-center py-12 text-[#555] text-sm">No events for this filter.</div>
        )}
      </div>
    </div>
  );
}
