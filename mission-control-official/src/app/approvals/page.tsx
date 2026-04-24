'use client';
import { useState } from 'react';
import { mockTasks } from '@/lib/mock/tasks';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { CheckCircle, XCircle } from 'lucide-react';

export default function ApprovalsPage() {
  const pendingTasks = mockTasks.filter(t => t.status === 'review');
  const [decisions, setDecisions] = useState<Record<string, 'approved' | 'rejected'>>({});

  const decide = (id: string, action: 'approved' | 'rejected') => {
    setDecisions(prev => ({ ...prev, [id]: action }));
  };

  const remaining = pendingTasks.filter(t => !decisions[t.id]);

  return (
    <div>
      <PageHeader title="Approvals" subtitle="Pending Trade Decisions" />

      {remaining.length === 0 ? (
        <div className="flex flex-col items-center justify-center py-24 text-center">
          <CheckCircle className="w-12 h-12 text-green-400 mb-4 opacity-50" />
          <h2 className="text-lg font-semibold text-[#f0f0f0] mb-1">All Clear</h2>
          <p className="text-sm text-[#555]">No pending approvals at this time.</p>
        </div>
      ) : (
        <div className="space-y-4 max-w-2xl">
          {remaining.map(task => (
            <div key={task.id} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-5">
              {/* Header */}
              <div className="flex items-center gap-3 mb-3">
                <span className="text-lg font-semibold text-[#f0f0f0]">{task.symbol}</span>
                <span className={`text-xs font-bold px-2 py-0.5 rounded ${
                  task.direction === 'long'
                    ? 'bg-green-500/10 text-green-400 border border-green-500/20'
                    : 'bg-red-500/10 text-red-400 border border-red-500/20'
                }`}>
                  {task.direction.toUpperCase()}
                </span>
                <span className="ml-auto text-sm text-[#888] font-medium">{task.confidence}% confidence</span>
              </div>

              {/* Title */}
              <h3 className="text-sm font-medium text-[#f0f0f0] mb-2">{task.title}</h3>

              {/* Reasoning */}
              <p className="text-sm text-[#888] mb-4 leading-relaxed border-l-2 border-[#1f1f1f] pl-3">{task.reasoning}</p>

              {/* Risk checks */}
              <div className="grid grid-cols-2 gap-2 mb-4">
                {[
                  { label: '✓ Stop loss set', ok: true },
                  { label: '✓ R/R: 2.3:1', ok: true },
                  { label: '✓ Exposure OK', ok: true },
                  { label: '⚠ Drawdown near limit', ok: false },
                ].map(check => (
                  <span
                    key={check.label}
                    className={`text-xs px-2 py-1 rounded border ${
                      check.ok
                        ? 'bg-green-500/5 border-green-500/20 text-green-400'
                        : 'bg-yellow-500/5 border-yellow-500/20 text-yellow-400'
                    }`}
                  >
                    {check.label}
                  </span>
                ))}
              </div>

              {/* Actions */}
              <div className="flex gap-3">
                <button
                  onClick={() => decide(task.id, 'approved')}
                  className="flex items-center gap-1.5 px-4 py-2 bg-green-500/10 border border-green-500/30 text-green-400 rounded text-sm font-medium hover:bg-green-500/20 transition-all"
                >
                  <CheckCircle className="w-4 h-4" />
                  Approve
                </button>
                <button
                  onClick={() => decide(task.id, 'rejected')}
                  className="flex items-center gap-1.5 px-4 py-2 bg-red-500/10 border border-red-500/30 text-red-400 rounded text-sm font-medium hover:bg-red-500/20 transition-all"
                >
                  <XCircle className="w-4 h-4" />
                  Reject
                </button>
              </div>
            </div>
          ))}
        </div>
      )}

      {/* Decided items */}
      {Object.keys(decisions).length > 0 && (
        <div className="mt-8">
          <h2 className="text-sm font-semibold text-[#555] uppercase tracking-wider mb-3">Decided This Session</h2>
          <div className="space-y-2">
            {pendingTasks.filter(t => decisions[t.id]).map(task => (
              <div key={task.id} className="flex items-center gap-3 px-4 py-2 bg-[#0d0d0d] border border-[#1a1a1a] rounded-lg">
                <span className="text-sm text-[#888]">{task.symbol}</span>
                <span className="text-xs text-[#555]">{task.title}</span>
                <StatusBadge variant={decisions[task.id] === 'approved' ? 'success' : 'error'}>
                  {decisions[task.id]}
                </StatusBadge>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}
