'use client';
import { useEffect, useState } from 'react';
import { Badge } from '../ui/Badge';
import { ProgressBar } from '../ui/ProgressBar';

interface Project {
  id: string;
  name: string;
  description: string;
  status: 'online' | 'offline' | 'degraded' | 'idle';
  health: number;
  metrics: { label: string; value: string }[];
  lastActivity: string;
  source: string;
}

function statusColor(s: string) {
  if (s === 'online') return '#66bb6a';
  if (s === 'degraded') return '#ff9800';
  if (s === 'offline') return '#ef5350';
  return '#607d8b';
}

function healthColor(h: number) {
  if (h >= 80) return '#66bb6a';
  if (h >= 50) return '#ff9800';
  return '#ef5350';
}

function formatTime(iso: string) {
  try {
    const d = new Date(iso);
    const now = new Date();
    const diff = Math.floor((now.getTime() - d.getTime()) / 1000);
    if (diff < 60) return `${diff}s ago`;
    if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
    if (diff < 86400) return `${Math.floor(diff / 3600)}h ago`;
    if (diff < 172800) return 'Yesterday';
    return `${Math.floor(diff / 86400)}d ago`;
  } catch {
    return '—';
  }
}

export function ProjectsPage() {
  const [projects, setProjects] = useState<Project[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchProjects() {
      try {
        const [reportRes, regimeRes, signalsRes, paramsRes] = await Promise.all([
          fetch('/api/daily-report').then(r => r.json()).catch(() => null),
          fetch('/api/regime').then(r => r.json()).catch(() => null),
          fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
          fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
        ]);

        const pm2 = reportRes?.infrastructure?.pm2 || {};
        const crons = reportRes?.infrastructure?.crons || {};
        const disk = reportRes?.infrastructure?.disk || {};
        const sigs = reportRes?.signals || {};

        // Signal Receiver
        const srProcess = pm2['signal-receiver'] || {};
        const srOnline = srProcess.status === 'online';
        const totalSignals = sigs.total || 0;
        const projectList: Project[] = [
          {
            id: 'signal-receiver',
            name: 'Signal Receiver',
            description: 'TradingView webhook → parser → Discord → state tracking',
            status: srOnline ? 'online' : 'offline',
            health: srOnline ? 100 : 0,
            metrics: [
              { label: 'Signals today', value: String(totalSignals) },
              { label: 'Buys / Sells', value: `${sigs.buys || 0} / ${sigs.sells || 0}` },
              { label: 'RAM', value: srProcess.memory_mb ? `${srProcess.memory_mb}MB` : '—' },
              { label: 'Restarts', value: String(srProcess.restarts || 0) },
            ],
            lastActivity: Object.values(signalsRes as Record<string, any>)[0]?.last_signal_time || '',
            source: 'PM2 + FastAPI',
          },
        ];

        // Active Positions
        const positions = Object.entries(signalsRes as Record<string, any>);
        if (positions.length > 0) {
          const posMetrics: { label: string; value: string }[] = [];
          let lastTime = '';
          positions.forEach(([ticker, data]: [string, any]) => {
            const dir = data.direction || 'FLAT';
            const entry = data.entry_price ? `$${data.entry_price.toLocaleString()}` : '—';
            posMetrics.push({ label: ticker, value: `${dir} @ ${entry}` });
            posMetrics.push({ label: `${ticker} signals`, value: String(data.signal_count || 0) });
            if (data.last_signal_time) lastTime = data.last_signal_time;
            const pnlHistory = data.pnl_history || [];
            if (pnlHistory.length > 0) {
              const totalPnl = pnlHistory.reduce((s: number, t: any) => s + (t.pnl_pct || 0), 0);
              posMetrics.push({ label: 'Total PnL', value: `${totalPnl > 0 ? '+' : ''}${totalPnl.toFixed(2)}%` });
            }
          });
          projectList.push({
            id: 'positions',
            name: 'Trading Positions',
            description: 'Live position tracking with PnL history',
            status: positions.some(([, d]: [string, any]) => d.direction) ? 'online' : 'idle',
            health: 100,
            metrics: posMetrics.slice(0, 4),
            lastActivity: lastTime,
            source: 'Signal Store',
          });
        }

        // SuperTrend Optimizer
        const optRan = crons.optimizer?.ran_today;
        projectList.push({
          id: 'optimizer',
          name: 'SuperTrend Optimizer',
          description: '72-param grid search across ATR × Multiplier combos',
          status: paramsRes?.recommended_atr_period ? 'online' : 'idle',
          health: paramsRes?.recommended_atr_period ? 100 : 30,
          metrics: [
            { label: 'Best ATR', value: paramsRes?.recommended_atr_period ? String(paramsRes.recommended_atr_period) : '—' },
            { label: 'Best Mult', value: paramsRes?.recommended_multiplier ? String(paramsRes.recommended_multiplier) : '—' },
            { label: 'Win Rate', value: paramsRes?.expected_win_rate ? `${paramsRes.expected_win_rate}%` : '—' },
            { label: 'Profit Factor', value: paramsRes?.expected_profit_factor ? String(paramsRes.expected_profit_factor) : '—' },
          ],
          lastActivity: paramsRes?.updated || '',
          source: optRan ? 'Ran today' : 'Cron: 6 PM ET',
        });

        // Market Regime Detector
        projectList.push({
          id: 'regime-detector',
          name: 'Regime Detector',
          description: 'ADX + Choppiness + Trend Efficiency across 1H/4H/1D',
          status: regimeRes?.overall_regime ? 'online' : 'offline',
          health: regimeRes?.overall_regime ? 100 : 0,
          metrics: [
            { label: 'Regime', value: regimeRes?.overall_regime?.replace(/_/g, ' ') || '—' },
            { label: 'Bias', value: regimeRes?.direction_bias || '—' },
            ...(regimeRes?.timeframes ? Object.entries(regimeRes.timeframes).map(([tf, data]: [string, any]) => ({
              label: tf, value: `ADX ${data.adx} | Chop ${data.choppiness}`,
            })) : []),
          ].slice(0, 4),
          lastActivity: regimeRes?.timestamp || '',
          source: 'Cron: Every 4h',
        });

        // Daily Report Generator
        projectList.push({
          id: 'daily-report',
          name: 'Daily Report',
          description: 'Signals, PnL, regime, infrastructure health summary',
          status: reportRes?.date ? 'online' : 'idle',
          health: reportRes?.date ? 100 : 30,
          metrics: [
            { label: 'Report date', value: reportRes?.date || 'Never' },
            { label: 'Signals logged', value: String(sigs.total || 0) },
            { label: 'Disk', value: disk.percent ? `${disk.used} / ${disk.total}` : '—' },
            { label: 'Disk usage', value: disk.percent || '—' },
          ],
          lastActivity: reportRes?.generated_at || '',
          source: 'Cron: 7:55 PM ET',
        });

        // Mission Control Dashboard
        const mcProcess = pm2['mission-control'] || {};
        projectList.push({
          id: 'mission-control',
          name: 'Mission Control Dashboard',
          description: 'Next.js web dashboard at missionctrl.serveftp.com',
          status: mcProcess.status === 'online' ? 'online' : 'offline',
          health: mcProcess.status === 'online' ? 100 : 0,
          metrics: [
            { label: 'Status', value: mcProcess.status || '—' },
            { label: 'RAM', value: mcProcess.memory_mb ? `${mcProcess.memory_mb}MB` : '—' },
            { label: 'Restarts', value: String(mcProcess.restarts || 0) },
            { label: 'Port', value: '3033' },
          ],
          lastActivity: '',
          source: 'PM2 + Next.js',
        });

        // OpenClaw Agent System
        const allOnline = Object.values(pm2).filter((p: any) => p.status === 'online').length;
        const allTotal = Object.keys(pm2).length;
        projectList.push({
          id: 'infrastructure',
          name: 'Infrastructure',
          description: 'Oracle Cloud VPS — PM2 processes, crons, disk',
          status: allOnline === allTotal ? 'online' : 'degraded',
          health: allTotal > 0 ? Math.round((allOnline / allTotal) * 100) : 0,
          metrics: [
            { label: 'Processes', value: `${allOnline} / ${allTotal} online` },
            { label: 'Disk', value: disk.percent || '—' },
            { label: 'Crons ran', value: `${Object.values(crons).filter((c: any) => c.ran_today).length} / ${Object.keys(crons).length}` },
            { label: 'Server', value: 'Oracle Cloud ARM' },
          ],
          lastActivity: reportRes?.generated_at || '',
          source: 'System',
        });

        setProjects(projectList);
      } catch (e) {
        console.error('Projects fetch error:', e);
      }
      setLoading(false);
    }

    fetchProjects();
    const interval = setInterval(fetchProjects, 30000);
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return <div style={{ color: '#607d8b', padding: 20, fontSize: 13 }}>Loading projects...</div>;
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 14 }}>
      {projects.map((project) => (
        <div
          key={project.id}
          style={{
            background: '#111118',
            border: '1px solid #1a3a4a',
            borderRadius: 10,
            padding: 16,
            borderLeft: `3px solid ${statusColor(project.status)}`,
          }}
        >
          {/* Header */}
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 10 }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
              <span style={{ fontSize: 15, fontFamily: "'Inter', sans-serif", fontWeight: 700, color: '#e0e0e0' }}>
                {project.name}
              </span>
              <Badge color={statusColor(project.status)}>{project.status}</Badge>
            </div>
            <span style={{ fontSize: 24, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: healthColor(project.health) }}>
              {project.health}%
            </span>
          </div>

          {/* Health bar */}
          <ProgressBar value={project.health} max={100} color={healthColor(project.health)} height={4} />

          {/* Description */}
          <div style={{ marginTop: 8, fontSize: 12, color: '#607d8b', fontFamily: "'Inter', sans-serif" }}>
            {project.description}
          </div>

          {/* Metrics grid */}
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 8, marginTop: 12 }}>
            {project.metrics.map((m, i) => (
              <div key={i} style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
                <div style={{ fontSize: 10, color: '#607d8b', marginBottom: 2 }}>{m.label}</div>
                <div style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#e0e0e0', fontWeight: 500 }}>{m.value}</div>
              </div>
            ))}
          </div>

          {/* Footer */}
          <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 10, fontSize: 10, fontFamily: "'JetBrains Mono', monospace", color: '#607d8b' }}>
            <span>{project.source}</span>
            {project.lastActivity && <span>Last activity: {formatTime(project.lastActivity)}</span>}
          </div>
        </div>
      ))}
    </div>
  );
}
