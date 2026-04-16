'use client';

import { useEffect, useState } from 'react';

interface AgentMetrics {
  name: string;
  color: string;
  metrics: { label: string; value: string; sub?: string }[];
}

const MOCK_METRICS: AgentMetrics[] = [
  {
    name: 'Boba', color: '#4fc3f7',
    metrics: [
      { label: 'Total Trades', value: '3', sub: '2 open · 1 closed' },
      { label: 'Win Rate', value: '0%', sub: '0/1 resolved' },
      { label: 'Total P&L', value: '+$31.93', sub: 'unrealized' },
      { label: 'Decisions Today', value: '12', sub: 'briefs + analysis' },
    ],
  },
  {
    name: 'JazzyHazzy', color: '#0984e3',
    metrics: [
      { label: 'Signals Generated', value: '8', sub: 'this week' },
      { label: 'Catalyst Accuracy', value: 'N/A', sub: 'tracking started' },
      { label: 'Research Tasks', value: '24', sub: 'completed' },
      { label: 'Avg Response', value: '<2m', sub: 'per analysis' },
    ],
  },
  {
    name: 'Orion', color: '#e17055',
    metrics: [
      { label: 'Alerts Fired', value: '34', sub: 'today' },
      { label: 'False Alarm Rate', value: '8%', sub: 'est.' },
      { label: 'Scans Run', value: '144', sub: 'last 24h' },
      { label: 'Avg Speed', value: '<5s', sub: 'per scan' },
    ],
  },
];

const FUNNEL = [
  { label: 'Alerts', value: 34, color: '#e17055' },
  { label: 'Signals', value: 8, color: '#0984e3' },
  { label: 'Trades', value: 3, color: '#4fc3f7' },
  { label: 'Wins', value: 0, color: '#2ed573' },
];

export function PerformancePage() {
  const [refreshTime, setRefreshTime] = useState(new Date());

  useEffect(() => {
    const t = setInterval(() => setRefreshTime(new Date()), 30000);
    return () => clearInterval(t);
  }, []);

  return (
    <div style={{ padding: '24px 28px', fontFamily: "'Inter', -apple-system, sans-serif", background: '#0a0a10', minHeight: '100vh' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 24 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 700, color: '#e0e0e0', margin: 0 }}>Performance</h1>
          <p style={{ fontSize: 12, color: '#607d8b', marginTop: 4, fontFamily: "'JetBrains Mono', monospace" }}>
            Agent KPIs &nbsp;·&nbsp; Updated {refreshTime.toLocaleTimeString()}
          </p>
        </div>
      </div>

      {/* Agent KPI Cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16, marginBottom: 24 }}>
        {MOCK_METRICS.map((agent) => (
          <div key={agent.name} style={{ background: '#0d1117', border: `1px solid ${agent.color}30`, borderRadius: 12, padding: '18px 20px' }}>
            <div style={{ fontSize: 13, fontWeight: 700, color: agent.color, fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 14 }}>
              {agent.name.toUpperCase()}
            </div>
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 12 }}>
              {agent.metrics.map((m) => (
                <div key={m.label} style={{ background: '#13131e', borderRadius: 8, padding: '10px 12px' }}>
                  <div style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", marginBottom: 4 }}>{m.label}</div>
                  <div style={{ fontSize: 18, fontWeight: 700, color: '#e0e0e0', fontFamily: "'JetBrains Mono', monospace" }}>{m.value}</div>
                  {m.sub && <div style={{ fontSize: 10, color: '#455a64', marginTop: 2 }}>{m.sub}</div>}
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>

      {/* Conversion Funnel */}
      <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px' }}>
        <div style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 16 }}>TEAM PIPELINE FUNNEL</div>
        <div style={{ display: 'flex', alignItems: 'flex-end', gap: 16, justifyContent: 'center', height: 120 }}>
          {FUNNEL.map((f, i) => {
            const maxVal = FUNNEL[0].value;
            const height = Math.max(20, (f.value / maxVal) * 100);
            return (
              <div key={f.label} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 6 }}>
                <span style={{ fontSize: 16, fontWeight: 700, color: f.color, fontFamily: "'JetBrains Mono', monospace" }}>{f.value}</span>
                <div style={{ width: 60, height: height, background: `${f.color}20`, border: `1px solid ${f.color}50`, borderRadius: '4px 4px 0 0', display: 'flex', alignItems: 'flex-end' }}>
                  <div style={{ width: '100%', height: `${Math.min(100, height)}%`, background: `${f.color}60`, borderRadius: '4px 4px 0 0' }} />
                </div>
                <span style={{ fontSize: 11, color: '#455a64', fontFamily: "'JetBrains Mono', monospace" }}>{f.label}</span>
                {i < FUNNEL.length - 1 && (
                  <span style={{ fontSize: 10, color: '#607d8b', position: 'absolute', marginLeft: 80 }}>→</span>
                )}
              </div>
            );
          })}
        </div>
        <div style={{ textAlign: 'center', marginTop: 12, fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>
          Alert → Signal → Trade → Win conversion &nbsp;·&nbsp; Win rate target: 60%
        </div>
      </div>
    </div>
  );
}

export default PerformancePage;
