'use client';
import { useState } from 'react';
import { PageHeader } from '@/components/shared/PageHeader';
import { CheckCircle, Zap } from 'lucide-react';

type Improvement = {
  id: string;
  title: string;
  reasoning: string;
  impact: 'High' | 'Medium' | 'Low';
};

type AppliedImprovement = {
  title: string;
  appliedDate: string;
  note: string;
};

const initialProposed: Improvement[] = [
  {
    id: '1',
    title: 'Add P&L chart to Dashboard',
    reasoning: 'Visual equity curve would help identify drawdown patterns faster',
    impact: 'High',
  },
  {
    id: '2',
    title: 'Scanner: Add multi-timeframe confluence filter',
    reasoning: 'Signals confirmed on multiple TFs have higher win rate',
    impact: 'Medium',
  },
  {
    id: '3',
    title: 'Risk panel: Add per-trade risk calculator',
    reasoning: 'Would help pre-validate position sizing before sending to pipeline',
    impact: 'Medium',
  },
];

const initialApplied: AppliedImprovement[] = [
  {
    title: 'Dark theme with Linear-style design',
    appliedDate: '2026-03-23',
    note: 'Base UI theme established',
  },
  {
    title: 'Modular mock data architecture',
    appliedDate: '2026-03-23',
    note: 'All data decoupled from UI components',
  },
];

const impactStyle: Record<string, string> = {
  High: 'bg-red-500/10 text-red-400 border border-red-500/20',
  Medium: 'bg-yellow-500/10 text-yellow-400 border border-yellow-500/20',
  Low: 'bg-green-500/10 text-green-400 border border-green-500/20',
};

export default function OptimizationPage() {
  const [proposed, setProposed] = useState<Improvement[]>(initialProposed);
  const [applied, setApplied] = useState<AppliedImprovement[]>(initialApplied);

  const apply = (item: Improvement) => {
    setProposed(prev => prev.filter(p => p.id !== item.id));
    setApplied(prev => [
      {
        title: item.title,
        appliedDate: '2026-03-23',
        note: item.reasoning,
      },
      ...prev,
    ]);
  };

  return (
    <div>
      <PageHeader title="Optimization" subtitle="System Improvement Tracker" />

      {/* Proposed */}
      <div className="mb-8">
        <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider mb-3 flex items-center gap-2">
          <Zap className="w-3.5 h-3.5 text-blue-400" />
          Proposed Improvements ({proposed.length})
        </h2>
        {proposed.length === 0 ? (
          <div className="text-center py-8 text-[#555] text-sm border border-dashed border-[#1f1f1f] rounded-lg">
            All improvements applied! 🎉
          </div>
        ) : (
          <div className="space-y-3">
            {proposed.map(item => (
              <div key={item.id} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
                <div className="flex items-start gap-3">
                  <div className="flex-1">
                    <div className="flex items-center gap-2 mb-1">
                      <h3 className="text-sm font-semibold text-[#f0f0f0]">{item.title}</h3>
                      <span className={`inline-flex items-center px-2 py-0.5 rounded text-xs font-medium ${impactStyle[item.impact]}`}>
                        {item.impact} Impact
                      </span>
                    </div>
                    <p className="text-xs text-[#888]">{item.reasoning}</p>
                  </div>
                  <button
                    onClick={() => apply(item)}
                    className="flex items-center gap-1.5 px-3 py-1.5 bg-blue-500/10 border border-blue-500/30 text-blue-400 rounded text-xs font-medium hover:bg-blue-500/20 transition-all flex-shrink-0"
                  >
                    <CheckCircle className="w-3.5 h-3.5" />
                    Apply
                  </button>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>

      {/* Applied */}
      <div>
        <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider mb-3 flex items-center gap-2">
          <CheckCircle className="w-3.5 h-3.5 text-green-400" />
          Applied Improvements ({applied.length})
        </h2>
        <div className="space-y-2">
          {applied.map((item, i) => (
            <div key={i} className="flex items-start gap-3 bg-[#0d0d0d] border border-[#1a1a1a] rounded-lg p-4 opacity-60">
              <CheckCircle className="w-4 h-4 text-green-400 flex-shrink-0 mt-0.5" />
              <div className="flex-1 min-w-0">
                <p className="text-sm font-medium text-[#888]">{item.title}</p>
                <p className="text-xs text-[#555] mt-0.5">{item.note}</p>
              </div>
              <span className="text-xs text-[#444] flex-shrink-0">Applied {item.appliedDate}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
