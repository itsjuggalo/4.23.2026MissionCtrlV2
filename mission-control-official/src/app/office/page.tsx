'use client';
import { useState, useEffect } from 'react';
import { PageHeader } from '@/components/shared/PageHeader';
import { SouthParkAgent } from '@/components/office/SouthParkAgent';
import useSWR from 'swr';

const fetcher = (url: string) => fetch(url).then(res => res.json());

// Agent positions in the office grid with colors
const agentPositions: Record<string, {x: number, y: number, color: string}> = {
  'analyst': { x: 1, y: 1, color: '#4a9eff' }, // blue
  'auditor': { x: 3, y: 1, color: '#22c55e' }, // green
  'broadcaster': { x: 5, y: 1, color: '#ef4444' }, // red
  'btc-bias-scorer': { x: 1, y: 3, color: '#f97316' }, // orange
  'codex-expert': { x: 3, y: 3, color: '#8b5cf6' }, // purple
  'counter-intel': { x: 5, y: 3, color: '#14b8a6' }, // teal
  'crypto-sniper': { x: 1, y: 5, color: '#eab308' }, // yellow
  'executor': { x: 3, y: 5, color: '#ec4899' }, // pink
  'macro-strategist': { x: 5, y: 5, color: '#06b6d4' }, // cyan
  'memory-writer': { x: 1, y: 7, color: '#a855f7' }, // violet
  'mission-control': { x: 3, y: 7, color: '#f59e0b' }, // amber
  'portfolio-monitor': { x: 5, y: 7, color: '#10b981' }, // emerald
  'risk-manager': { x: 2, y: 2, color: '#6366f1' }, // indigo
  'telegram-listener': { x: 4, y: 2, color: '#0ea5e9' }, // sky
  'tweak': { x: 2, y: 4, color: '#f43f5e' }, // rose
  'tweak-discord-monitor': { x: 4, y: 4, color: '#84cc16' }, // lime
};

export default function OfficePage() {
  const { data: agentsData } = useSWR('/api/agents/status', fetcher, {
    refreshInterval: 3000, // 3 seconds
  });

  const agents = agentsData?.agents || [];
  
  const getAgentActivity = (name: string) => {
    const agent = agents.find((a: any) => a.name === name);
    if (!agent) return { status: 'offline', activity: '' };
    
    const status = agent.status === 'online' ? 'online' : 'offline';
    const activity = agent.status === 'online' 
      ? (agent.cpu > 5 ? '💼 Working' : '☕ Idle')
      : '💤 Offline';
    
    return { status, activity };
  };

  return (
    <div>
      <PageHeader 
        title="AI Office" 
        subtitle="Watch your agents work in real-time"
      />
      
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-6">
        <div className="grid grid-cols-6 gap-4" style={{ minHeight: '600px' }}>
          {Object.entries(agentPositions).map(([name, pos]) => {
            const { status, activity } = getAgentActivity(name);
            const isOnline = status === 'online';
            
            return (
              <div
                key={name}
                className={`
                  col-start-${pos.x} row-start-${pos.y}
                  bg-[#0a0a0a] border rounded-lg p-4
                  transition-all duration-300
                  ${isOnline 
                    ? 'border-green-500/30 shadow-lg shadow-green-500/10' 
                    : 'border-[#1f1f1f] opacity-60'
                  }
                `}
                style={{
                  gridColumn: pos.x,
                  gridRow: pos.y,
                }}
              >
                <SouthParkAgent 
                  name={name}
                  status={status as 'online' | 'offline'}
                  activity={activity}
                  color={pos.color}
                />
              </div>
            );
          })}
        </div>
      </div>
      
      <div className="mt-4 grid grid-cols-3 gap-4">
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <div className="text-xs text-[#555] uppercase tracking-wider mb-2">Online</div>
          <div className="text-2xl font-bold text-green-400">
            {agents.filter((a: any) => a.status === 'online').length}
          </div>
        </div>
        
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <div className="text-xs text-[#555] uppercase tracking-wider mb-2">Working</div>
          <div className="text-2xl font-bold text-blue-400">
            {agents.filter((a: any) => a.status === 'online' && a.cpu > 5).length}
          </div>
        </div>
        
        <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
          <div className="text-xs text-[#555] uppercase tracking-wider mb-2">Memory</div>
          <div className="text-2xl font-bold text-purple-400">
            {(agents.reduce((sum: number, a: any) => sum + (a.memory || 0), 0) / (1024 * 1024)).toFixed(0)}MB
          </div>
        </div>
      </div>
    </div>
  );
}
