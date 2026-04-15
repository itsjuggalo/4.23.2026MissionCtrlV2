'use client';
import { useEffect, useState } from 'react';
import { Badge } from '../ui/Badge';
import { StatusDot } from '../ui/StatusDot';

interface CronJob {
  name: string;
  interval: string;
  status: 'active' | 'stopped' | 'unknown';
}

interface DayEntry {
  date: string;
  signals_received: number;
  trades_closed: number;
  total_pnl_pct: number;
  regime: string;
  bias: string;
  processes_online: number;
  processes_total: number;
  highlight: string;
}

interface SignalEntry {
  timestamp: string;
  ticker: string;
  action: string;
  signal_type: string;
  price: number | null;
  timeframe: string;
}

interface RegimeData {
  overall_regime: string;
  direction_bias: string;
  overall_recommendation: string;
  timeframes: Record<string, { regime: string; adx: number; choppiness: number }>;
}

interface DailyReport {
  date: string;
  signals: { total: number; buys: number; sells: number; take_profits: number; stop_losses: number };
  pnl: Record<string, { trades_today: number; total_pnl_pct: number; current_direction: string | null; current_entry: number | null }>;
  regime: { overall: string; bias: string; recommendation: string };
  infrastructure: { pm2: Record<string, { status: string; restarts: number; memory_mb: number }>; crons: Record<string, { ran_today: boolean }> };
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
    return iso;
  }
}

function regimeColor(regime: string) {
  if (regime.includes('STRONG_TREND')) return '#00d2a0';
  if (regime.includes('WEAK_TREND')) return '#ffa502';
  if (regime.includes('RANGING')) return '#3498ff';
  if (regime.includes('VOLATILE')) return '#ff4757';
  return '#5c5c72';
}

function actionColor(action: string) {
  if (action === 'BUY') return '#00d2a0';
  if (action === 'SELL') return '#ff4757';
  if (action === 'TAKE_PROFIT') return '#ffa502';
  if (action === 'STOP_LOSS') return '#ff6348';
  return '#5c5c72';
}

function pnlColor(pnl: number) {
  return pnl > 0 ? '#00d2a0' : pnl < 0 ? '#ff4757' : '#5c5c72';
}

export function CalendarPage() {
  const [signals, setSignals] = useState<SignalEntry[]>([]);
  const [regime, setRegime] = useState<RegimeData | null>(null);
  const [report, setReport] = useState<DailyReport | null>(null);
  const [calendar, setCalendar] = useState<Record<string, DayEntry>>({});
  const [cronJobs, setCronJobs] = useState<CronJob[]>([]);
  const [loading, setLoading] = useState(true);

  const today = new Date().toLocaleDateString('en-US', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });

  useEffect(() => {
    async function fetchAll() {
      try {
        const [sigRes, regRes, repRes, calRes] = await Promise.all([
          fetch('/api/signals/history?ticker=BTCUSD&limit=15').then(r => r.json()).catch(() => []),
          fetch('/api/regime').then(r => r.json()).catch(() => null),
          fetch('/api/daily-report').then(r => r.json()).catch(() => null),
          fetch('/api/calendar').then(r => r.json()).catch(() => ({ days: {} })),
        ]);
        setSignals(Array.isArray(sigRes) ? sigRes.reverse() : []);
        setRegime(regRes);
        setReport(repRes);
        setCalendar(calRes?.days || {});

        // Build cron jobs from infrastructure data
        const jobs: CronJob[] = [
          { name: 'Signal Receiver', interval: 'Always on (PM2)', status: 'active' },
          { name: 'SuperTrend Optimizer', interval: 'Daily 6:00 PM ET', status: repRes?.infrastructure?.crons?.optimizer?.ran_today ? 'active' : 'stopped' },
          { name: 'Regime Detector', interval: 'Every 4 hours', status: regRes?.timestamp ? 'active' : 'stopped' },
          { name: 'Daily Report', interval: 'Daily 7:55 PM ET', status: repRes?.date ? 'active' : 'stopped' },
        ];
        setCronJobs(jobs);
      } catch (e) {
        console.error('Calendar fetch error:', e);
      }
      setLoading(false);
    }
    fetchAll();
    const interval = setInterval(fetchAll, 30000);
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return <div style={{ color: '#5c5c72', padding: 20, fontSize: 13 }}>Loading live data...</div>;
  }

  const totalPnl = report ? Object.values(report.pnl || {}).reduce((sum, p) => sum + (p.total_pnl_pct || 0), 0) : 0;
  const totalTrades = report ? Object.values(report.pnl || {}).reduce((sum, p) => sum + (p.trades_today || 0), 0) : 0;

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Title */}
      <h2 style={{ fontSize: 16, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e8e8ed', margin: 0 }}>
        {today} — Daily schedule
      </h2>

      {/* Summary Cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 10 }}>
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 8, padding: '12px 16px' }}>
          <div style={{ fontSize: 11, color: '#5c5c72', marginBottom: 4 }}>Signals Today</div>
          <div style={{ fontSize: 20, fontWeight: 600, color: '#e8e8ed' }}>{report?.signals?.total || 0}</div>
          <div style={{ fontSize: 11, color: '#5c5c72' }}>{report?.signals?.buys || 0}B / {report?.signals?.sells || 0}S</div>
        </div>
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 8, padding: '12px 16px' }}>
          <div style={{ fontSize: 11, color: '#5c5c72', marginBottom: 4 }}>PnL Today</div>
          <div style={{ fontSize: 20, fontWeight: 600, color: pnlColor(totalPnl) }}>{totalPnl > 0 ? '+' : ''}{totalPnl.toFixed(2)}%</div>
          <div style={{ fontSize: 11, color: '#5c5c72' }}>{totalTrades} trades</div>
        </div>
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 8, padding: '12px 16px' }}>
          <div style={{ fontSize: 11, color: '#5c5c72', marginBottom: 4 }}>Market Regime</div>
          <div style={{ fontSize: 14, fontWeight: 600, color: regimeColor(regime?.overall_regime || '') }}>{regime?.overall_regime?.replace(/_/g, ' ') || 'UNKNOWN'}</div>
          <div style={{ fontSize: 11, color: '#5c5c72' }}>Bias: {regime?.direction_bias || '—'}</div>
        </div>
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 8, padding: '12px 16px' }}>
          <div style={{ fontSize: 11, color: '#5c5c72', marginBottom: 4 }}>Infrastructure</div>
          <div style={{ fontSize: 20, fontWeight: 600, color: '#00d2a0' }}>{report?.infrastructure?.pm2 ? Object.values(report.infrastructure.pm2).filter((p: any) => p.status === 'online').length : '—'}</div>
          <div style={{ fontSize: 11, color: '#5c5c72' }}>processes online</div>
        </div>
      </div>

      {/* Live Signal Feed */}
      <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 10, overflow: 'hidden' }}>
        <div style={{ padding: '12px 16px', borderBottom: '1px solid #1e1e2a', fontSize: 14, fontWeight: 600, color: '#e8e8ed' }}>
          Live Signal Feed
        </div>
        {signals.length === 0 ? (
          <div style={{ padding: '20px 16px', fontSize: 13, color: '#5c5c72' }}>No signals received today</div>
        ) : (
          signals.slice(0, 10).map((sig, i) => (
            <div
              key={i}
              style={{
                display: 'flex', alignItems: 'center', gap: 14, padding: '10px 16px',
                borderBottom: i < Math.min(signals.length, 10) - 1 ? '1px solid #1e1e2a' : 'none',
                borderLeft: `2px solid ${actionColor(sig.action)}`,
              }}
            >
              <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#5c5c72', minWidth: 55 }}>
                {formatTime(sig.timestamp)}
              </span>
              <span style={{ fontSize: 13, fontWeight: 500, color: '#e8e8ed', minWidth: 70 }}>{sig.ticker}</span>
              <Badge color={actionColor(sig.action)}>{sig.action}</Badge>
              {sig.price && (
                <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#8b8b9e' }}>
                  ${sig.price.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
                </span>
              )}
              <span style={{ flex: 1 }} />
              <Badge color="#5c5c72">{sig.signal_type}</Badge>
              {sig.timeframe && sig.timeframe !== 'UNKNOWN' && (
                <span style={{ fontSize: 11, color: '#5c5c72' }}>{sig.timeframe}</span>
              )}
            </div>
          ))
        )}
      </div>

      {/* Regime Breakdown */}
      {regime?.timeframes && (
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 10, padding: 16 }}>
          <div style={{ fontSize: 14, fontWeight: 600, color: '#e8e8ed', marginBottom: 14 }}>
            Market Regime by Timeframe
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 10 }}>
            {Object.entries(regime.timeframes).map(([tf, data]) => (
              <div
                key={tf}
                style={{
                  padding: '10px 12px', background: '#0f0f17', borderRadius: 8,
                  border: '1px solid #1e1e2a',
                }}
              >
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                  <span style={{ fontSize: 14, fontWeight: 600, color: '#e8e8ed' }}>{tf}</span>
                  <Badge color={regimeColor(data.regime)}>{data.regime.replace(/_/g, ' ')}</Badge>
                </div>
                <div style={{ fontSize: 11, color: '#5c5c72' }}>
                  ADX: {data.adx} | Chop: {data.choppiness}
                </div>
              </div>
            ))}
          </div>
          {regime.overall_recommendation && (
            <div style={{ marginTop: 12, padding: '8px 12px', background: '#0f0f17', borderRadius: 6, fontSize: 12, color: '#8b8b9e', borderLeft: `2px solid ${regimeColor(regime.overall_regime)}` }}>
              {regime.overall_recommendation}
            </div>
          )}
        </div>
      )}

      {/* Recurring Jobs / Cron Status */}
      <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 10, padding: 16 }}>
        <div style={{ fontSize: 14, fontWeight: 600, color: '#e8e8ed', marginBottom: 14 }}>
          Automated Jobs
        </div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 10 }}>
          {cronJobs.map((job, i) => (
            <div
              key={i}
              style={{
                display: 'flex', alignItems: 'center', gap: 10, padding: '10px 12px',
                background: '#0f0f17', borderRadius: 8, border: '1px solid #1e1e2a',
              }}
            >
              <StatusDot status={job.status === 'active' ? 'active' : 'offline'} />
              <div style={{ flex: 1 }}>
                <div style={{ fontSize: 13, color: '#e8e8ed', fontWeight: 500, marginBottom: 2 }}>{job.name}</div>
                <div style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72' }}>{job.interval}</div>
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Monthly History */}
      {Object.keys(calendar).length > 0 && (
        <div style={{ background: '#111118', border: '1px solid #1e1e2a', borderRadius: 10, padding: 16 }}>
          <div style={{ fontSize: 14, fontWeight: 600, color: '#e8e8ed', marginBottom: 14 }}>
            Monthly History
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 6 }}>
            {Object.entries(calendar).sort(([a], [b]) => b.localeCompare(a)).slice(0, 14).map(([date, day]) => (
              <div
                key={date}
                style={{
                  display: 'flex', alignItems: 'center', gap: 12, padding: '8px 12px',
                  background: '#0f0f17', borderRadius: 6, border: '1px solid #1e1e2a',
                  borderLeft: `2px solid ${pnlColor(day.total_pnl_pct)}`,
                }}
              >
                <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#8b8b9e', minWidth: 80 }}>{date}</span>
                <span style={{ fontSize: 12, color: pnlColor(day.total_pnl_pct), fontWeight: 500, minWidth: 60 }}>
                  {day.total_pnl_pct > 0 ? '+' : ''}{day.total_pnl_pct.toFixed(2)}%
                </span>
                <span style={{ fontSize: 11, color: '#5c5c72' }}>{day.signals_received} signals</span>
                <span style={{ fontSize: 11, color: '#5c5c72' }}>{day.trades_closed} trades</span>
                <span style={{ flex: 1 }} />
                <Badge color={regimeColor(day.regime)}>{day.regime?.replace(/_/g, ' ') || '—'}</Badge>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}
