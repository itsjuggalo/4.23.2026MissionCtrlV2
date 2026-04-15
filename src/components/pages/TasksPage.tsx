'use client';
import { useEffect, useState } from 'react';

interface TaskItem {
  id: string;
  title: string;
  detail: string;
  priority: 'high' | 'medium' | 'low';
  source: string;
  timestamp?: string;
}

interface ColumnData {
  key: string;
  label: string;
  dotColor: string;
  tasks: TaskItem[];
}

function priorityColor(p: string) {
  return p === 'high' ? '#ff4757' : p === 'medium' ? '#ffa502' : '#5c5c72';
}

function formatTime(iso: string) {
  try {
    const d = new Date(iso);
    const now = new Date();
    const diff = Math.floor((now.getTime() - d.getTime()) / 1000);
    if (diff < 60) return `${diff}s ago`;
    if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
    if (diff < 86400) return `${Math.floor(diff / 3600)}h ago`;
    return d.toLocaleDateString();
  } catch {
    return '';
  }
}

export function TasksPage() {
  const [columns, setColumns] = useState<ColumnData[]>([
    { key: 'issues', label: 'Needs Attention', dotColor: '#ff4757', tasks: [] },
    { key: 'running', label: 'Running', dotColor: '#3498ff', tasks: [] },
    { key: 'scheduled', label: 'Scheduled', dotColor: '#ffa502', tasks: [] },
    { key: 'completed', label: 'Completed Today', dotColor: '#00d2a0', tasks: [] },
  ]);
  const [loading, setLoading] = useState(true);
  const [lastUpdate, setLastUpdate] = useState('');

  useEffect(() => {
    async function fetchTasks() {
      try {
        const [reportRes, regimeRes, signalsRes, paramsRes] = await Promise.all([
          fetch('/api/daily-report').then(r => r.json()).catch(() => null),
          fetch('/api/regime').then(r => r.json()).catch(() => null),
          fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
          fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
        ]);

        const issues: TaskItem[] = [];
        const running: TaskItem[] = [];
        const scheduled: TaskItem[] = [];
        const completed: TaskItem[] = [];

        // PM2 Processes
        const pm2 = reportRes?.infrastructure?.pm2 || {};
        let procCount = 0;
        Object.entries(pm2).forEach(([name, data]: [string, any]) => {
          procCount++;
          if (data.status === 'online') {
            running.push({
              id: `pm2-${name}`,
              title: name,
              detail: `${data.memory_mb}MB RAM | ${data.restarts} restarts`,
              priority: data.restarts > 10 ? 'medium' : 'low',
              source: 'PM2',
            });
          } else {
            issues.push({
              id: `pm2-${name}`,
              title: `${name} is DOWN`,
              detail: `Status: ${data.status} | ${data.restarts} restarts`,
              priority: 'high',
              source: 'PM2',
            });
          }
        });

        // Cron Jobs
        const crons = reportRes?.infrastructure?.crons || {};
        Object.entries(crons).forEach(([name, data]: [string, any]) => {
          if (data.ran_today) {
            completed.push({
              id: `cron-${name}`,
              title: `${name.replace(/_/g, ' ')} completed`,
              detail: data.last_entry?.slice(0, 60) || 'Ran successfully',
              priority: 'low',
              source: 'Cron',
            });
          } else {
            scheduled.push({
              id: `cron-${name}`,
              title: `${name.replace(/_/g, ' ')}`,
              detail: 'Scheduled — has not run today',
              priority: 'medium',
              source: 'Cron',
            });
          }
        });

        // Active Positions
        Object.entries(signalsRes).forEach(([ticker, data]: [string, any]) => {
          if (data.direction) {
            running.push({
              id: `pos-${ticker}`,
              title: `${ticker} ${data.direction}`,
              detail: data.entry_price ? `Entry: $${data.entry_price.toLocaleString()} | ${data.signal_count} signals` : `${data.signal_count} signals received`,
              priority: 'medium',
              source: 'Position',
              timestamp: data.last_signal_time,
            });
          }
        });

        // Regime Status
        if (regimeRes?.overall_regime) {
          const isVolatile = regimeRes.overall_regime.includes('VOLATILE') || regimeRes.overall_regime.includes('CHOP');
          (isVolatile ? issues : running).push({
            id: 'regime',
            title: `Regime: ${regimeRes.overall_regime.replace(/_/g, ' ')}`,
            detail: `Bias: ${regimeRes.direction_bias} | ${regimeRes.overall_recommendation || ''}`.slice(0, 80),
            priority: isVolatile ? 'high' : 'low',
            source: 'Regime Detector',
            timestamp: regimeRes.timestamp,
          });
        }

        // SuperTrend Params
        if (paramsRes?.recommended_atr_period) {
          completed.push({
            id: 'optimizer',
            title: 'SuperTrend optimized',
            detail: `ATR ${paramsRes.recommended_atr_period} / Mult ${paramsRes.recommended_multiplier} | WR ${paramsRes.expected_win_rate}%`,
            priority: 'low',
            source: 'Optimizer',
            timestamp: paramsRes.updated,
          });
        }

        // Signals processed today
        if (reportRes?.signals?.total > 0) {
          completed.push({
            id: 'signals-processed',
            title: `${reportRes.signals.total} signals processed`,
            detail: `${reportRes.signals.buys} buys | ${reportRes.signals.sells} sells | ${reportRes.signals.take_profits} TP | ${reportRes.signals.stop_losses} SL`,
            priority: 'low',
            source: 'Signal Receiver',
          });
        }

        // Disk usage
        const disk = reportRes?.infrastructure?.disk;
        if (disk?.percent) {
          const pct = parseInt(disk.percent);
          if (pct > 85) {
            issues.push({
              id: 'disk',
              title: 'Disk space low',
              detail: `${disk.used} / ${disk.total} (${disk.percent})`,
              priority: 'high',
              source: 'Infrastructure',
            });
          }
        }

        // Scheduled tasks (always show these)
        scheduled.push({
          id: 'sched-optimizer',
          title: 'Daily SuperTrend optimization',
          detail: 'Runs at 6:00 PM ET (10 PM UTC)',
          priority: 'low',
          source: 'Cron',
        });
        scheduled.push({
          id: 'sched-regime',
          title: 'Regime detection',
          detail: 'Every 4 hours',
          priority: 'low',
          source: 'Cron',
        });
        scheduled.push({
          id: 'sched-report',
          title: 'Daily report',
          detail: 'Runs at 7:55 PM ET (11:55 PM UTC)',
          priority: 'low',
          source: 'Cron',
        });

        // If nothing is broken, add a healthy note
        if (issues.length === 0) {
          issues.push({
            id: 'all-clear',
            title: 'All systems operational',
            detail: `${procCount} processes online | No issues detected`,
            priority: 'low',
            source: 'System',
          });
        }

        setColumns([
          { key: 'issues', label: 'Needs Attention', dotColor: issues.some(t => t.priority === 'high') ? '#ff4757' : '#00d2a0', tasks: issues },
          { key: 'running', label: 'Running', dotColor: '#3498ff', tasks: running },
          { key: 'scheduled', label: 'Scheduled', dotColor: '#ffa502', tasks: scheduled },
          { key: 'completed', label: 'Completed Today', dotColor: '#00d2a0', tasks: completed },
        ]);

        setLastUpdate(new Date().toLocaleTimeString());
      } catch (e) {
        console.error('Tasks fetch error:', e);
      }
      setLoading(false);
    }

    fetchTasks();
    const interval = setInterval(fetchTasks, 30000);
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return <div style={{ color: '#5c5c72', padding: 20, fontSize: 13 }}>Loading operations data...</div>;
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 16 }}>
      {/* Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <div style={{ fontSize: 11, color: '#5c5c72', fontFamily: "'JetBrains Mono', monospace" }}>
          Auto-refreshes every 30s | Last update: {lastUpdate}
        </div>
      </div>

      {/* Kanban Board */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
        {columns.map(({ key, label, dotColor, tasks }) => (
          <div key={key}>
            {/* Column header */}
            <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 12, padding: '0 4px' }}>
              <span style={{ width: 8, height: 8, borderRadius: '50%', background: dotColor, flexShrink: 0 }} />
              <span style={{ fontSize: 13, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e8e8ed' }}>
                {label}
              </span>
              <span style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', marginLeft: 'auto' }}>
                {tasks.length}
              </span>
            </div>
            {/* Task cards */}
            <div>
              {tasks.map((task) => (
                <div
                  key={task.id}
                  style={{
                    background: '#111118',
                    border: '1px solid #1e1e2a',
                    borderRadius: 8,
                    padding: 12,
                    marginBottom: 8,
                    borderLeft: `2px solid ${priorityColor(task.priority)}`,
                  }}
                >
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                    <span style={{ fontSize: 10, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72' }}>
                      {task.source}
                    </span>
                    {task.timestamp && (
                      <span style={{ fontSize: 10, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72' }}>
                        {formatTime(task.timestamp)}
                      </span>
                    )}
                  </div>
                  <div style={{ display: 'flex', alignItems: 'flex-start', gap: 8, marginBottom: 6 }}>
                    <span style={{ width: 6, height: 6, borderRadius: '50%', background: priorityColor(task.priority), marginTop: 5, flexShrink: 0 }} />
                    <span style={{ fontSize: 13, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e8e8ed', lineHeight: 1.4 }}>
                      {task.title}
                    </span>
                  </div>
                  <div style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', paddingLeft: 14 }}>
                    {task.detail}
                  </div>
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
