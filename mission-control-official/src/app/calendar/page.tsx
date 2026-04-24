import { PageHeader } from '@/components/shared/PageHeader';
import { Clock, Activity } from 'lucide-react';

const jobs = [
  { name: 'Morning Scan', schedule: '09:00 UTC', frequency: 'Daily', status: 'active', pulse: false },
  { name: 'Midday Review', schedule: '13:00 UTC', frequency: 'Daily', status: 'active', pulse: false },
  { name: 'Evening Summary', schedule: '20:00 UTC', frequency: 'Daily', status: 'active', pulse: false },
  { name: 'Continuous Monitoring', schedule: 'Always', frequency: 'Real-time', status: 'running', pulse: true },
  { name: 'Weekly Performance Report', schedule: 'Sunday 20:00 UTC', frequency: 'Weekly', status: 'active', pulse: false },
];

export default function CalendarPage() {
  return (
    <div>
      <PageHeader title="Scheduler" subtitle="Recurring jobs and daily routines" />
      <div className="space-y-3 max-w-2xl">
        {jobs.map((job, i) => (
          <div key={i} className="flex items-center gap-4 bg-[#111] border border-[#1f1f1f] rounded-lg px-4 py-3">
            <div className="flex items-center gap-2 flex-shrink-0">
              <span className={`w-2 h-2 rounded-full bg-green-400 ${job.pulse ? 'animate-pulse' : ''}`} />
            </div>
            <div className="flex items-center gap-2 flex-shrink-0 text-[#555]">
              {job.status === 'running' ? <Activity className="w-4 h-4" /> : <Clock className="w-4 h-4" />}
            </div>
            <div className="flex-1">
              <p className="text-sm font-medium text-[#f0f0f0]">{job.name}</p>
              <p className="text-xs text-[#555]">{job.frequency}</p>
            </div>
            <div className="text-right">
              <p className="text-sm text-[#888] font-mono">{job.schedule}</p>
              <p className={`text-xs font-medium ${job.status === 'running' ? 'text-green-400' : 'text-green-400'}`}>
                {job.status === 'running' ? '● Running' : '● Active'}
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
