'use client';
import { mockAgents } from '@/lib/mock/agents';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { AgentStatus } from '@/lib/types';

const statusDot: Record<AgentStatus, string> = {
  active: 'bg-green-400',
  idle: 'bg-yellow-400',
  paused: 'bg-orange-400',
  error: 'bg-red-400',
};

const statusBadgeVariant: Record<AgentStatus, 'success' | 'warning' | 'error' | 'neutral'> = {
  active: 'success',
  idle: 'warning',
  paused: 'neutral',
  error: 'error',
};

function confidenceColor(conf: number) {
  if (conf >= 80) return 'bg-green-500';
  if (conf >= 60) return 'bg-yellow-500';
  return 'bg-red-500';
}

export default function AgentsPage() {
  return (
    <div>
      <PageHeader title="Agents" subtitle="AI Agent Fleet Status" />
      <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-4">
        {mockAgents.map(agent => (
          <div key={agent.id} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 space-y-3">
            {/* Name + Role */}
            <div>
              <h3 className="font-semibold text-[#f0f0f0]">{agent.name}</h3>
              <p className="text-sm text-[#888]">{agent.role}</p>
            </div>
            {/* Status */}
            <div className="flex items-center gap-2">
              <span className={`w-2 h-2 rounded-full ${statusDot[agent.status]} ${agent.status === 'active' ? 'animate-pulse' : ''}`} />
              <StatusBadge variant={statusBadgeVariant[agent.status]}>
                {agent.status.charAt(0).toUpperCase() + agent.status.slice(1)}
              </StatusBadge>
            </div>
            {/* Current Task */}
            <div>
              <p className="text-[10px] text-[#555] uppercase tracking-wider mb-0.5">Current Task</p>
              <p className="text-sm text-[#888] truncate">{agent.currentTask}</p>
            </div>
            {/* Last Action */}
            <div>
              <p className="text-[10px] text-[#555] uppercase tracking-wider mb-0.5">Last Action</p>
              <p className="text-sm text-[#888] truncate">{agent.lastAction}</p>
            </div>
            {/* Confidence */}
            <div>
              <div className="flex justify-between text-xs mb-1">
                <span className="text-[#555] uppercase tracking-wider text-[10px]">Confidence</span>
                <span className="text-[#f0f0f0] font-medium">{agent.confidence}%</span>
              </div>
              <div className="w-full bg-[#1a1a1a] rounded-full h-1.5">
                <div
                  className={`h-1.5 rounded-full ${confidenceColor(agent.confidence)}`}
                  style={{ width: `${agent.confidence}%` }}
                />
              </div>
            </div>
            {/* Last active */}
            <p className="text-xs text-[#444]">Last active: {agent.lastActiveAt}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
