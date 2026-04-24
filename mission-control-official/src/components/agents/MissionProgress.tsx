'use client';
import React from 'react';

interface MissionProgressProps {
  current: number;
  target: number;
  daysRemaining: number;
  dailyTarget: number;
  todayPL: number;
}

export default function MissionProgress({ current, target, daysRemaining, dailyTarget, todayPL }: MissionProgressProps) {
  const progress = ((current - 100000) / (target - 100000)) * 100;
  const remaining = target - current;
  
  return (
    <div className="bg-gradient-to-r from-[#1a1a1a] to-[#2a2a2a] border border-[#333] rounded-lg p-6 mb-6">
      <div className="flex items-center justify-between mb-4">
        <div>
          <h2 className="text-2xl font-bold text-white">Mission: Prove Profitability</h2>
          <p className="text-[#888] text-sm">Grow account to secure better resources</p>
        </div>
        <div className="text-right">
          <div className="text-3xl font-bold text-white">
            ${current.toLocaleString()}
          </div>
          <div className="text-sm text-[#888]">
            → ${target.toLocaleString()}
          </div>
        </div>
      </div>

      <div className="relative w-full h-8 bg-[#0a0a0a] rounded-full overflow-hidden mb-4">
        <div 
          className="absolute h-full bg-gradient-to-r from-amber-500 to-amber-600 transition-all duration-500 flex items-center justify-end pr-3"
          style={{ width: `${Math.max(progress, 2)}%` }}
        >
          <span className="text-xs font-bold text-white">{progress.toFixed(1)}%</span>
        </div>
      </div>

      <div className="grid grid-cols-4 gap-4">
        <div className="bg-[#0a0a0a] rounded p-3">
          <div className="text-xs text-[#888]">Days Remaining</div>
          <div className="text-xl font-bold text-white">{daysRemaining}</div>
        </div>
        
        <div className="bg-[#0a0a0a] rounded p-3">
          <div className="text-xs text-[#888]">Daily Target</div>
          <div className="text-xl font-bold text-amber-500">+${dailyTarget.toLocaleString()}</div>
        </div>
        
        <div className="bg-[#0a0a0a] rounded p-3">
          <div className="text-xs text-[#888]">Today's P&L</div>
          <div className={`text-xl font-bold ${todayPL >= 0 ? 'text-green-500' : 'text-red-500'}`}>
            {todayPL >= 0 ? '+' : ''}${todayPL.toFixed(2)}
          </div>
        </div>
        
        <div className="bg-[#0a0a0a] rounded p-3">
          <div className="text-xs text-[#888]">Remaining</div>
          <div className="text-xl font-bold text-white">${remaining.toLocaleString()}</div>
        </div>
      </div>
    </div>
  );
}
