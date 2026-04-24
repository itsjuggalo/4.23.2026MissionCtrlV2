'use client';
import React from 'react';

interface AgentCardProps {
  id: string;
  name: string;
  model: string;
  role: string;
  status: 'idle' | 'working' | 'scanning' | 'analyzing' | 'error';
  lastActivity: string;
  currentTask: string | null;
  stats: any;
}

const statusColors = {
  idle: 'bg-yellow-500',
  working: 'bg-green-500',
  scanning: 'bg-blue-500',
  analyzing: 'bg-purple-500',
  error: 'bg-red-500'
};

const statusEmoji = {
  idle: '🟡',
  working: '🟢',
  scanning: '🔵',
  analyzing: '🟣',
  error: '🔴'
};

export default function AgentCard({ id, name, model, role, status, lastActivity, currentTask, stats }: AgentCardProps) {
  const timeSince = (date: string) => {
    const seconds = Math.floor((new Date().getTime() - new Date(date).getTime()) / 1000);
    if (seconds < 60) return `${seconds}s ago`;
    if (seconds < 3600) return `${Math.floor(seconds / 60)}m ago`;
    return `${Math.floor(seconds / 3600)}h ago`;
  };

  return (
    <div className="bg-[#1a1a1a] border border-[#333] rounded-lg p-4 hover:border-[#555] transition-colors">
      <div className="flex items-center justify-between mb-3">
        <div>
          <h3 className="text-lg font-bold text-white flex items-center gap-2">
            {statusEmoji[status]} {name}
          </h3>
          <p className="text-sm text-[#888]">{role}</p>
        </div>
        <div className={`w-3 h-3 rounded-full ${statusColors[status]} animate-pulse`} />
      </div>

      <div className="space-y-2 text-sm">
        <div className="flex justify-between">
          <span className="text-[#888]">Model:</span>
          <span className="text-[#aaa]">{model.split('/')[1]}</span>
        </div>
        
        <div className="flex justify-between">
          <span className="text-[#888]">Status:</span>
          <span className="text-[#aaa] capitalize">{status}</span>
        </div>

        <div className="flex justify-between">
          <span className="text-[#888]">Activity:</span>
          <span className="text-[#aaa]">{timeSince(lastActivity)}</span>
        </div>

        {currentTask && (
          <div className="pt-2 border-t border-[#333]">
            <p className="text-xs text-[#888]">Current Task:</p>
            <p className="text-sm text-[#aaa]">{currentTask}</p>
          </div>
        )}

        {id === 'boba' && (
          <div className="pt-2 border-t border-[#333] space-y-1">
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">Trades:</span>
              <span className="text-[#aaa]">{stats.tradesExecuted}</span>
            </div>
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">Win Rate:</span>
              <span className="text-[#aaa]">{stats.winRate}%</span>
            </div>
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">P&L:</span>
              <span className={stats.totalPL >= 0 ? 'text-green-500' : 'text-red-500'}>
                ${stats.totalPL.toFixed(2)}
              </span>
            </div>
          </div>
        )}

        {id === 'jazzyhazzy' && (
          <div className="pt-2 border-t border-[#333] space-y-1">
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">Signals:</span>
              <span className="text-[#aaa]">{stats.signalsGenerated}</span>
            </div>
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">Accuracy:</span>
              <span className="text-[#aaa]">{stats.signalAccuracy || 'N/A'}</span>
            </div>
          </div>
        )}

        {id === 'orion' && (
          <div className="pt-2 border-t border-[#333] space-y-1">
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">Alerts:</span>
              <span className="text-[#aaa]">{stats.alertsSent}/day</span>
            </div>
            <div className="flex justify-between text-xs">
              <span className="text-[#888]">False Alarms:</span>
              <span className="text-[#aaa]">{stats.falseAlarms}</span>
            </div>
          </div>
        )}
      </div>

      <div className="mt-3 pt-3 border-t border-[#333]">
        <button className="w-full bg-[#2a2a2a] hover:bg-[#3a3a3a] text-white py-2 px-3 rounded text-sm transition-colors">
          View Details →
        </button>
      </div>
    </div>
  );
}
