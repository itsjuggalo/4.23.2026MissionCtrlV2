import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';

const projects = [
  {
    name: 'Mission Control',
    status: 'active',
    priority: 'high',
    progress: 35,
    description: 'Central platform for all trading operations',
  },
  {
    name: 'Strategy Engine',
    status: 'planned',
    priority: 'high',
    progress: 0,
    description: 'Multi-strategy signal generation and validation',
  },
  {
    name: 'Risk Engine',
    status: 'active',
    priority: 'critical',
    progress: 60,
    description: 'Hard risk rules, drawdown control, position sizing',
  },
  {
    name: 'Execution System',
    status: 'planned',
    priority: 'medium',
    progress: 0,
    description: 'Automated trade execution with simulation layer',
  },
  {
    name: 'Intelligence System',
    status: 'in_progress',
    priority: 'medium',
    progress: 20,
    description: 'Market intelligence aggregation and memory system',
  },
];

const statusVariant: Record<string, 'success' | 'info' | 'neutral'> = {
  active: 'success',
  in_progress: 'info',
  planned: 'neutral',
};

const priorityStyle: Record<string, string> = {
  critical: 'bg-red-500/10 text-red-400 border border-red-500/20',
  high: 'bg-orange-500/10 text-orange-400 border border-orange-500/20',
  medium: 'bg-yellow-500/10 text-yellow-400 border border-yellow-500/20',
};

const progressBarColor: Record<string, string> = {
  critical: 'bg-red-400',
  high: 'bg-blue-400',
  medium: 'bg-yellow-400',
};

function statusLabel(s: string) {
  return s.replace('_', ' ').replace(/\b\w/g, c => c.toUpperCase());
}

export default function ProjectsPage() {
  return (
    <div>
      <PageHeader title="Projects" subtitle="System Development Roadmap" />
      <div className="grid grid-cols-1 xl:grid-cols-2 gap-4">
        {projects.map((p, i) => (
          <div key={i} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <div className="flex items-start gap-2 mb-2">
              <h3 className="text-base font-semibold text-[#f0f0f0] flex-1">{p.name}</h3>
              <StatusBadge variant={statusVariant[p.status]}>{statusLabel(p.status)}</StatusBadge>
              <span className={`inline-flex items-center px-2 py-0.5 rounded text-xs font-medium ${priorityStyle[p.priority]}`}>
                {p.priority.charAt(0).toUpperCase() + p.priority.slice(1)}
              </span>
            </div>
            <p className="text-sm text-[#888] mb-4">{p.description}</p>
            <div>
              <div className="flex justify-between text-xs mb-1">
                <span className="text-[#555]">Progress</span>
                <span className="text-[#f0f0f0] font-medium">{p.progress}%</span>
              </div>
              <div className="w-full bg-[#1a1a1a] rounded-full h-2">
                <div
                  className={`h-2 rounded-full ${progressBarColor[p.priority]}`}
                  style={{ width: `${p.progress}%` }}
                />
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
