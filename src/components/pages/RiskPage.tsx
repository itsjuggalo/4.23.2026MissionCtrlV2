'use client';
import { useEffect, useState } from 'react';
import { MetricCard } from '../ui/MetricCard';
import { Card } from '../ui/Card';
import { Badge } from '../ui/Badge';
import { ProgressBar } from '../ui/ProgressBar';

interface Position {
  ticker: string;
  direction: string | null;
  entry_price: number | null;
  signal_count: number;
  pnl_history: { pnl_pct: number; closed_at: string; direction: string }[];
}

interface Alert {
  level: 'critical' | 'warning' | 'info' | 'success';
  message: string;
  time?: string;
}

export function RiskPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [positions, setPositions] = useState<Record<string, Position>>({});
  const [regime, setRegime] = useState<any>(null);
  const [report, setReport] = useState<any>(null);
  const [alerts, setAlerts] = useState<Alert[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchAll() {
      try {
        const [portRes, posRes, regRes, repRes] = await Promise.all([
          fetch('/api/portfolio').then(r => r.json()).catch(() => null),
          fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
          fetch('/api/regime').then(r => r.json()).catch(() => null),
          fetch('/api/daily-report').then(r => r.json()).catch(() => null),
        ]);

        setPortfolio(portRes);
        setPositions(posRes || {});
        setRegime(regRes);
        setReport(repRes);

        // Build live alerts
        const liveAlerts: Alert[] = [];

        // Regime alerts
        if (regRes?.overall_regime?.includes('VOLATILE')) {
          liveAlerts.push({ level: 'critical', message: `Market regime: ${regRes.overall_regime.replace(/_/g, ' ')} — reduce position sizes or sit out` });
        } else if (regRes?.overall_regime?.includes('RANGING')) {
          liveAlerts.push({ level: 'warning', message: `Market regime: RANGING — SuperTrend may whipsaw, consider Grid Bot` });
        } else if (regRes?.overall_regime?.includes('STRONG_TREND')) {
          liveAlerts.push({ level: 'success', message: `Market regime: STRONG TREND (${regRes.direction_bias}) — SuperTrend active` });
        }

        // PnL alerts
        Object.entries(posRes || {}).forEach(([ticker, data]: [string, any]) => {
          const history = data.pnl_history || [];
          if (history.length > 0) {
            const lastTrade = history[history.length - 1];
            if (lastTrade.pnl_pct < -3) {
              liveAlerts.push({ level: 'critical', message: `${ticker} last trade: ${lastTrade.pnl_pct.toFixed(2)}% loss — review stop placement` });
            }
            const consecutive = history.slice(-3);
            const allLosses = consecutive.length >= 3 && consecutive.every((t: any) => t.pnl_pct < 0);
            if (allLosses) {
              liveAlerts.push({ level: 'warning', message: `${ticker} 3 consecutive losses — consider reducing size or pausing` });
            }
          }
          if (data.direction && data.entry_price) {
            liveAlerts.push({ level: 'info', message: `${ticker} ${data.direction} @ $${data.entry_price.toLocaleString()} — ${data.signal_count} signals tracked` });
          }
        });

        // Infrastructure alerts
        const pm2 = repRes?.infrastructure?.pm2 || {};
        const crashed = Object.entries(pm2).filter(([, p]: [string, any]) => p.status !== 'online');
        if (crashed.length > 0) {
          liveAlerts.push({ level: 'critical', message: `${crashed.length} process(es) down: ${crashed.map(([n]) => n).join(', ')}` });
        }

        // Disk alert
        const disk = repRes?.infrastructure?.disk;
        if (disk?.percent) {
          const pct = parseInt(disk.percent);
          if (pct > 85) {
            liveAlerts.push({ level: 'warning', message: `Disk usage at ${disk.percent} — consider cleanup` });
          }
        }

        // Portfolio alerts
        if (portRes?.pl && portRes.pl < -5000) {
          liveAlerts.push({ level: 'critical', message: `Unrealized P&L: -$${Math.abs(portRes.pl).toLocaleString()} — review positions` });
        }

        if (liveAlerts.length === 0) {
          liveAlerts.push({ level: 'success', message: 'No active risk alerts — all systems normal' });
        }

        setAlerts(liveAlerts);
      } catch (e) {
        console.error('Risk fetch error:', e);
      }
      setLoading(false);
    }

    fetchAll();
    const interval = setInterval(fetchAll, 30000);
    return () => clearInterval(interval);
  }, []);

  if (loading) {
    return <div style={{ color: '#607d8b', padding: 20, fontSize: 13 }}>Loading risk data...</div>;
  }

  // Calculate metrics
  const equity = portfolio?.balance || 0;
  const cash = portfolio?.cash || 0;
  const unrealizedPL = portfolio?.pl || 0;
  const buyingPower = portfolio?.buying_power || 0;
  const dayPL = portfolio?.day_pl || 0;

  const openPositionCount = Object.values(positions).filter((p: any) => p.direction).length;
  const totalSignals = report?.signals?.total || 0;

  // Exposure calc
  const exposure = equity > 0 ? Math.round(((equity - cash) / equity) * 100) : 0;
  const exposureLimit = 75;

  // Drawdown from PnL history
  let maxDrawdown = 0;
  Object.values(positions).forEach((p: any) => {
    const history = p.pnl_history || [];
    let running = 0;
    let peak = 0;
    history.forEach((t: any) => {
      running += t.pnl_pct;
      if (running > peak) peak = running;
      const dd = peak - running;
      if (dd > maxDrawdown) maxDrawdown = dd;
    });
  });

  // Win rate from all trades today
  let totalTrades = 0;
  let wins = 0;
  Object.values(positions).forEach((p: any) => {
    (p.pnl_history || []).forEach((t: any) => {
      totalTrades++;
      if (t.pnl_pct > 0) wins++;
    });
  });
  const winRate = totalTrades > 0 ? Math.round((wins / totalTrades) * 100) : 0;

  // Exposure breakdown
  const cryptoExposure = exposure; // All positions are crypto for now
  const equitiesExposure = 0;
  const cashPct = equity > 0 ? Math.round((cash / equity) * 100) : 100;

  function alertColor(level: string) {
    if (level === 'critical') return '#ef5350';
    if (level === 'warning') return '#ff9800';
    if (level === 'success') return '#66bb6a';
    return '#4fc3f7';
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Metric cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
        <MetricCard
          label="Exposure"
          value={`${exposure}%`}
          subtitle={`Limit: ${exposureLimit}%`}
          color="#ff9800"
        />
        <MetricCard
          label="Drawdown"
          value={`${maxDrawdown.toFixed(2)}%`}
          subtitle="Max: -5%"
          color={maxDrawdown > 5 ? '#ef5350' : '#66bb6a'}
        />
        <MetricCard
          label="Win Rate"
          value={`${winRate}%`}
          subtitle={`${wins}/${totalTrades} trades`}
          color={winRate >= 50 ? '#66bb6a' : '#ff9800'}
        />
        <MetricCard
          label="Open Positions"
          value={String(openPositionCount)}
          subtitle={`Equity: $${(equity / 1000).toFixed(1)}K`}
          color="#e0e0e0"
        />
      </div>

      {/* Portfolio Overview */}
      <Card>
        <div style={{ fontSize: 14, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e0e0e0', marginBottom: 16 }}>
          Portfolio Overview
        </div>
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12, marginBottom: 16 }}>
          <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
            <div style={{ fontSize: 10, color: '#607d8b', marginBottom: 2 }}>Equity</div>
            <div style={{ fontSize: 14, fontFamily: "'JetBrains Mono', monospace", color: '#e0e0e0', fontWeight: 600 }}>${equity.toLocaleString(undefined, { maximumFractionDigits: 0 })}</div>
          </div>
          <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
            <div style={{ fontSize: 10, color: '#607d8b', marginBottom: 2 }}>Cash</div>
            <div style={{ fontSize: 14, fontFamily: "'JetBrains Mono', monospace", color: '#66bb6a', fontWeight: 600 }}>${cash.toLocaleString(undefined, { maximumFractionDigits: 0 })}</div>
          </div>
          <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
            <div style={{ fontSize: 10, color: '#607d8b', marginBottom: 2 }}>Unrealized P&L</div>
            <div style={{ fontSize: 14, fontFamily: "'JetBrains Mono', monospace", color: unrealizedPL >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>{unrealizedPL >= 0 ? '+' : ''}${unrealizedPL.toLocaleString(undefined, { maximumFractionDigits: 0 })}</div>
          </div>
          <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
            <div style={{ fontSize: 10, color: '#607d8b', marginBottom: 2 }}>Day P&L</div>
            <div style={{ fontSize: 14, fontFamily: "'JetBrains Mono', monospace", color: dayPL >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>{dayPL >= 0 ? '+' : ''}${dayPL.toLocaleString(undefined, { maximumFractionDigits: 0 })}</div>
          </div>
        </div>
      </Card>

      {/* Risk exposure card */}
      <Card>
        <div style={{ fontSize: 14, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e0e0e0', marginBottom: 16 }}>
          Risk Exposure
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: 10 }}>
          <span style={{ fontSize: 32, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: exposure > exposureLimit ? '#ef5350' : '#ff9800' }}>
            {exposure}%
          </span>
          <span style={{ fontSize: 13, fontFamily: "'JetBrains Mono', monospace", color: '#607d8b' }}>
            {exposureLimit}% limit
          </span>
        </div>
        <ProgressBar value={exposure} max={exposureLimit} color={exposure > exposureLimit ? '#ef5350' : '#ff9800'} height={8} />

        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16, marginTop: 20 }}>
          {[
            { label: 'Crypto', pct: cryptoExposure, color: '#00cec9' },
            { label: 'Equities', pct: equitiesExposure, color: '#4fc3f7' },
            { label: 'Cash', pct: cashPct, color: '#66bb6a' },
          ].map((item) => (
            <div key={item.label}>
              <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                <span style={{ fontSize: 12, fontFamily: "'Inter', sans-serif", color: '#455a64' }}>{item.label}</span>
                <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: item.color }}>{item.pct}%</span>
              </div>
              <ProgressBar value={item.pct} max={100} color={item.color} height={4} />
            </div>
          ))}
        </div>
      </Card>

      {/* Trade History */}
      {totalTrades > 0 && (
        <Card>
          <div style={{ fontSize: 14, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e0e0e0', marginBottom: 12 }}>
            Recent Trades
          </div>
          {Object.entries(positions).map(([ticker, data]: [string, any]) => (
            (data.pnl_history || []).slice(-5).reverse().map((trade: any, i: number) => (
              <div
                key={`${ticker}-${i}`}
                style={{
                  display: 'flex', alignItems: 'center', gap: 12,
                  padding: '8px 0',
                  borderBottom: '1px solid #1a3a4a',
                }}
              >
                <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#607d8b', minWidth: 70 }}>
                  {ticker}
                </span>
                <Badge color={trade.direction === 'LONG' ? '#66bb6a' : '#ef5350'}>
                  {trade.direction}
                </Badge>
                <span style={{ flex: 1 }} />
                <span style={{
                  fontSize: 13, fontFamily: "'JetBrains Mono', monospace", fontWeight: 600,
                  color: trade.pnl_pct >= 0 ? '#66bb6a' : '#ef5350',
                }}>
                  {trade.pnl_pct >= 0 ? '+' : ''}{trade.pnl_pct.toFixed(2)}%
                </span>
                {trade.exit_type && (
                  <Badge color={trade.exit_type === 'TAKE_PROFIT' ? '#ff9800' : '#ef5350'}>
                    {trade.exit_type}
                  </Badge>
                )}
                <span style={{ fontSize: 10, fontFamily: "'JetBrains Mono', monospace", color: '#607d8b' }}>
                  {new Date(trade.closed_at).toLocaleTimeString()}
                </span>
              </div>
            ))
          ))}
        </Card>
      )}

      {/* Active alerts */}
      <div>
        <div style={{ fontSize: 14, fontFamily: "'Inter', sans-serif", fontWeight: 600, color: '#e0e0e0', marginBottom: 12 }}>
          Active Alerts
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          {alerts.map((alert, i) => (
            <div
              key={i}
              style={{
                background: '#111118',
                border: '1px solid #1a3a4a',
                borderLeft: `3px solid ${alertColor(alert.level)}`,
                borderRadius: '0 10px 10px 0',
                padding: '12px 16px',
                display: 'flex',
                alignItems: 'center',
                gap: 12,
              }}
            >
              <Badge color={alertColor(alert.level)}>{alert.level}</Badge>
              <span style={{ fontSize: 13, fontFamily: "'Inter', sans-serif", color: '#455a64' }}>
                {alert.message}
              </span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
