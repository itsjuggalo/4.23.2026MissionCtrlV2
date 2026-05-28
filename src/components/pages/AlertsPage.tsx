'use client';
import { useState, useEffect, useCallback, useMemo } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

interface AlertItem {
  id: string;
  time: string;
  severity: 'critical' | 'warning' | 'info';
  category: string;
  title: string;
  detail: string;
  value?: string;
  symbol?: string;
}

const SEVERITY = {
  critical: { color: '#ef4444', bg: '#ef444412', border: '#ef444433', icon: '🔴', label: 'CRITICAL' },
  warning: { color: '#f59e0b', bg: '#f59e0b12', border: '#f59e0b33', icon: '🟡', label: 'WARNING' },
  info: { color: '#60a5fa', bg: '#60a5fa12', border: '#60a5fa33', icon: '🔵', label: 'INFO' },
};

function timeAgo(dateStr: string): string {
  try {
    const diff = Date.now() - new Date(dateStr).getTime();
    const mins = Math.floor(diff / 60000);
    if (mins < 1) return 'just now';
    if (mins < 60) return `${mins}m ago`;
    const hrs = Math.floor(mins / 60);
    if (hrs < 24) return `${hrs}h ago`;
    return `${Math.floor(hrs / 24)}d ago`;
  } catch { return ''; }
}

function fmtTime(dateStr: string): string {
  try {
    const d = new Date(dateStr);
    return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) + ' ' +
      d.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit' });
  } catch { return dateStr; }
}

export function AlertsPage() {
  const [alerts, setAlerts] = useState<AlertItem[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [filter, setFilter] = useState<string>('all');
  const [lastUpdate, setLastUpdate] = useState(new Date());
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchAlerts = useCallback(async () => {
    try {
      const [portfolioRes, signalsRes, regimeRes, activityRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/signals/latest').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/regime').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/activity').then(r => r.ok ? r.json() : []).catch(() => []),
      ]);

      const now = new Date().toISOString();
      const newAlerts: AlertItem[] = [];
      let id = 0;

      // Portfolio alerts
      if (portfolioRes) {
        const equity = parseFloat(portfolioRes.equity || '0');
        const lastEq = parseFloat(portfolioRes.last_equity || '0');
        const dailyPct = lastEq ? ((equity - lastEq) / lastEq) * 100 : 0;

        if (dailyPct < -2) {
          newAlerts.push({ id: `p${id++}`, time: now, severity: 'critical', category: 'Portfolio',
            title: 'Account Down >2% Today', detail: `Portfolio dropped ${dailyPct.toFixed(2)}% ($${(equity - lastEq).toFixed(2)})`, value: `${dailyPct.toFixed(1)}%` });
        }
        if (dailyPct < -1 && dailyPct >= -2) {
          newAlerts.push({ id: `p${id++}`, time: now, severity: 'warning', category: 'Portfolio',
            title: 'Account Down >1% Today', detail: `Portfolio is ${dailyPct.toFixed(2)}% today`, value: `${dailyPct.toFixed(1)}%` });
        }
        if (equity > 110000 && equity < 115000) {
          newAlerts.push({ id: `p${id++}`, time: now, severity: 'info', category: 'Portfolio',
            title: 'Approaching Phase 1 Goal', detail: `Equity $${equity.toFixed(0)} — close to $110K milestone`, value: `$${equity.toFixed(0)}` });
        }

        // Position alerts
        const positions = portfolioRes.positions || [];
        for (const p of positions) {
          const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
          const sym = p.symbol;
          if (pnlPct < -5) {
            newAlerts.push({ id: `pos${id++}`, time: now, severity: 'critical', category: 'Position',
              title: `${sym} Down ${pnlPct.toFixed(1)}%`, detail: `Consider stop loss — entry $${parseFloat(p.avg_entry_price).toFixed(2)} → $${parseFloat(p.current_price).toFixed(2)}`, value: `${pnlPct.toFixed(1)}%`, symbol: sym });
          } else if (pnlPct < -3) {
            newAlerts.push({ id: `pos${id++}`, time: now, severity: 'warning', category: 'Position',
              title: `${sym} Down ${pnlPct.toFixed(1)}%`, detail: `Tighten stop — entry $${parseFloat(p.avg_entry_price).toFixed(2)} → $${parseFloat(p.current_price).toFixed(2)}`, value: `${pnlPct.toFixed(1)}%`, symbol: sym });
          }
          if (pnlPct > 20) {
            newAlerts.push({ id: `pos${id++}`, time: now, severity: 'warning', category: 'Position',
              title: `${sym} Up ${pnlPct.toFixed(1)}% — Take Profit?`, detail: `Extended position — consider partial profit at $${parseFloat(p.current_price).toFixed(2)}`, value: `+${pnlPct.toFixed(1)}%`, symbol: sym });
          } else if (pnlPct > 10) {
            newAlerts.push({ id: `pos${id++}`, time: now, severity: 'info', category: 'Position',
              title: `${sym} Up ${pnlPct.toFixed(1)}%`, detail: `On track — current $${parseFloat(p.current_price).toFixed(2)}`, value: `+${pnlPct.toFixed(1)}%`, symbol: sym });
          }
        }
      }

      // Signal alerts
      if (signalsRes?.BTCUSD) {
        const btc = signalsRes.BTCUSD;
        newAlerts.push({ id: `sig${id++}`, time: btc.last_signal_time || now, severity: 'info', category: 'Signal',
          title: `SuperTrend: ${btc.direction}`, detail: `Entry: $${(btc.entry_price || 0).toLocaleString()} | Signals: ${btc.signal_count}`, value: btc.direction });
      }

      // Regime alerts
      if (regimeRes) {
        const regime = regimeRes.overall_regime || regimeRes.regime || '';
        const bias = regimeRes.direction_bias || regimeRes.bias || '';
        const sev: 'info' | 'warning' = regime.includes('CHOPPY') ? 'warning' : 'info';
        newAlerts.push({ id: `reg${id++}`, time: regimeRes.timestamp || now, severity: sev, category: 'Regime',
          title: `Market Regime: ${regime}`, detail: `Bias: ${bias}`, value: regime });

        // RSI alerts from regime timeframes
        const tfs: Record<string, { adx?: number }> = regimeRes.timeframes || {};
        for (const [tf, data] of Object.entries(tfs)) {
          if ((data?.adx ?? 0) > 40) {
            newAlerts.push({ id: `rsi${id++}`, time: now, severity: 'info', category: 'Technical',
              title: `Strong Trend on ${tf}`, detail: `ADX: ${data.adx} — directional movement is strong`, value: `ADX ${data.adx}` });
          }
        }
      }

      // Activity-based alerts (filter to actual alerts from recent activity)
      const activities = Array.isArray(activityRes) ? activityRes : activityRes?.entries || [];
      for (const a of activities.slice(0, 20)) {
        const action = (a.action || '').toLowerCase();
        if (action.includes('alert') || action.includes('warning') || action.includes('error') || action.includes('fail')) {
          const sev: 'critical' | 'warning' | 'info' = action.includes('error') || action.includes('fail') ? 'critical' : action.includes('warning') ? 'warning' : 'info';
          newAlerts.push({ id: `act${id++}`, time: a.time, severity: sev, category: 'System',
            title: a.agent || 'System', detail: a.action });
        }
      }

      // Sort by severity then time
      const sevOrder = { critical: 0, warning: 1, info: 2 };
      newAlerts.sort((a, b) => sevOrder[a.severity] - sevOrder[b.severity] || new Date(b.time).getTime() - new Date(a.time).getTime());

      setAlerts(newAlerts);
      setLastUpdate(new Date());
      setError(false);
    } catch (e) {
      console.error('Alerts fetch error:', e);
      setError(true);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchAlerts();
    const interval = setInterval(fetchAlerts, 15000);
    return () => clearInterval(interval);
  }, [fetchAlerts]);

  const filtered = useMemo(() =>
    filter === 'all' ? alerts : alerts.filter(a => a.severity === filter || a.category.toLowerCase() === filter),
    [alerts, filter]
  );

  const critCount = alerts.filter(a => a.severity === 'critical').length;
  const warnCount = alerts.filter(a => a.severity === 'warning').length;
  const infoCount = alerts.filter(a => a.severity === 'info').length;

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
        <div>
          <h1 style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: '#f0f0f0', margin: 0 }}>🚨 Alerts</h1>
          <p style={{ fontSize: 'var(--mc-font-badge)', color: '#555', marginTop: '4px' }}>
            {alerts.length} active • {critCount} critical • {warnCount} warnings • Updated {timeAgo(lastUpdate.toISOString())}
          </p>
        </div>
        <button onClick={fetchAlerts} style={{
          padding: '8px 14px', background: '#111', border: '1px solid #222',
          borderRadius: '8px', color: '#888', fontSize: 'var(--mc-font-badge)', cursor: 'pointer',
        }}>Refresh</button>
      </div>

      {/* Severity summary */}
      <div style={{ display: 'flex', gap: '10px', marginBottom: '20px' }}>
        {[
          { key: 'all', label: 'All', count: alerts.length, color: '#888' },
          { key: 'critical', label: '🔴 Critical', count: critCount, color: '#ef4444' },
          { key: 'warning', label: '🟡 Warning', count: warnCount, color: '#f59e0b' },
          { key: 'info', label: '🔵 Info', count: infoCount, color: '#60a5fa' },
        ].map(f => (
          <button key={f.key} onClick={() => setFilter(f.key)} style={{
            padding: '8px 16px', borderRadius: '8px', fontSize: 'var(--mc-font-badge)', fontWeight: 500,
            border: `1px solid ${filter === f.key ? f.color + '44' : '#1a1a1a'}`,
            background: filter === f.key ? f.color + '15' : '#111',
            color: filter === f.key ? f.color : '#666',
            cursor: 'pointer',
          }}>
            {f.label} ({f.count})
          </button>
        ))}
      </div>

      {/* Alerts list */}
      {loading ? (
        <div style={{ textAlign: 'center', padding: '40px', color: '#555' }}>Scanning for alerts...</div>
      ) : filtered.length === 0 ? (
        <div style={{ textAlign: 'center', padding: '60px', color: '#555' }}>
          <div style={{ fontSize: '48px', marginBottom: '12px' }}>✅</div>
          <div style={{ fontSize: 'var(--mc-font-lg)', color: '#666' }}>All clear — no alerts at this severity level</div>
        </div>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
          {filtered.map((alert, i) => {
            const sev = SEVERITY[alert.severity];
            return (
              <div key={alert.id || i} style={{
                display: 'flex', alignItems: 'flex-start', gap: '14px',
                padding: '14px 18px', background: sev.bg, border: `1px solid ${sev.border}`,
                borderRadius: '10px', borderLeft: `4px solid ${sev.color}`,
              }}>
                <span style={{ fontSize: 'var(--mc-font-xl)', flexShrink: 0 }}>{sev.icon}</span>
                <div style={{ flex: 1, minWidth: 0 }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '4px' }}>
                    <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 600, color: sev.color }}>{alert.title}</span>
                    {alert.symbol && (
                      <span onClick={() => setDrawerTicker(alert.symbol!)} style={{ cursor: 'pointer', padding: '1px 6px', marginLeft: '0', border: '1px solid #4fc3f755', borderRadius: '3px', fontSize: '9px', color: '#4fc3f7', fontWeight: 700, letterSpacing: '1px' }}>TA</span>
                    )}
                    <span style={{
                      fontSize: 'var(--mc-font-label)', padding: '2px 8px', borderRadius: '10px',
                      background: '#ffffff08', color: '#888', border: '1px solid #ffffff10',
                    }}>{alert.category}</span>
                  </div>
                  <div style={{ fontSize: 'var(--mc-font-xs)', color: '#aaa', lineHeight: '1.5' }}>{alert.detail}</div>
                </div>
                <div style={{ flexShrink: 0, textAlign: 'right' }}>
                  {alert.value && (
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: sev.color, marginBottom: '4px' }}>
                      {alert.value}
                    </div>
                  )}
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#555' }}>{timeAgo(alert.time)}</div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#444' }}>{fmtTime(alert.time)}</div>
                </div>
              </div>
            );
          })}
        </div>
      )}
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
