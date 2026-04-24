'use client';
import { mockTasks } from '@/lib/mock/tasks';
import { PageHeader } from '@/components/shared/PageHeader';
import { TaskStatus } from '@/lib/types';

const columns: { status: TaskStatus; label: string }[] = [
  { status: 'backlog', label: 'Backlog' },
  { status: 'in_progress', label: 'In Progress' },
  { status: 'review', label: 'Review' },
  { status: 'approved', label: 'Approved' },
  { status: 'rejected', label: 'Rejected' },
];

function timeAgo(dateStr: string) {
  const diff = Date.now() - new Date(dateStr).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 60) return `${mins}m ago`;
  return `${Math.floor(mins / 60)}h ago`;
}

function confidenceColor(conf: number) {
  if (conf >= 75) return 'bg-green-500';
  if (conf >= 50) return 'bg-yellow-500';
  return 'bg-red-500';
}

export default function TasksPage() {
  return (
    <div>
      <PageHeader title="Tasks" subtitle="Trade Pipeline — Kanban View" />
      <div className="flex gap-3 overflow-x-auto pb-4">
        {columns.map(col => {
          const tasks = mockTasks.filter(t => t.status === col.status);
          return (
            <div key={col.status} className="flex-shrink-0 w-[220px]">
              {/* Column header */}
              <div className="flex items-center justify-between mb-2 px-1">
                <span className="text-xs font-semibold text-[#888] uppercase tracking-wider">{col.label}</span>
                <span className="text-xs bg-[#1f1f1f] text-[#555] rounded px-1.5 py-0.5">{tasks.length}</span>
              </div>
              {/* Task cards */}
              <div className="space-y-2">
                {tasks.length === 0 ? (
                  <div className="h-16 border border-dashed border-[#1f1f1f] rounded-lg flex items-center justify-center">
                    <span className="text-xs text-[#333]">Empty</span>
                  </div>
                ) : (
                  tasks.map(task => (
                    <div
                      key={task.id}
                      className={`bg-[#111] border rounded-lg p-3 ${
                        col.status === 'rejected'
                          ? 'border-red-500/20 bg-red-500/5'
                          : col.status === 'approved'
                          ? 'border-green-500/20 bg-green-500/5'
                          : 'border-[#1f1f1f]'
                      }`}
                    >
                      {/* Symbol + direction */}
                      <div className="flex items-center gap-2 mb-2">
                        <span className="text-xs font-semibold text-[#f0f0f0]">{task.symbol}</span>
                        <span className={`text-[10px] font-bold px-1.5 py-0.5 rounded ${
                          task.direction === 'long'
                            ? 'bg-green-500/10 text-green-400'
                            : 'bg-red-500/10 text-red-400'
                        }`}>
                          {task.direction.toUpperCase()}
                        </span>
                      </div>
                      {/* Title */}
                      <p className="text-xs font-medium text-[#f0f0f0] leading-tight mb-2">{task.title}</p>
                      {/* Confidence bar */}
                      <div className="mb-2">
                        <div className="flex justify-between text-[10px] text-[#555] mb-1">
                          <span>Confidence</span>
                          <span>{task.confidence}%</span>
                        </div>
                        <div className="w-full bg-[#1a1a1a] rounded-full h-1.5">
                          <div
                            className={`h-1.5 rounded-full ${confidenceColor(task.confidence)}`}
                            style={{ width: `${task.confidence}%` }}
                          />
                        </div>
                      </div>
                      {/* Agent + time */}
                      <div className="flex items-center justify-between">
                        <span className="text-[10px] text-[#555] truncate">{task.assignedAgent}</span>
                        <span className="text-[10px] text-[#444] flex-shrink-0 ml-1">{timeAgo(task.createdAt)}</span>
                      </div>
                    </div>
                  ))
                )}
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}
