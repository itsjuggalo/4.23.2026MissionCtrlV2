'use client';

import { useEffect, useState } from 'react';

interface TokenUsage {
  inputTokens: number;
  outputTokens: number;
  totalCost: number;
  model: string;
  sessionCount: number;
}

interface AgentStatus {
  name: string;
  role: string;
  status: 'online' | 'idle' | 'offline';
  lastAction: string;
  tasksToday: number;
}

interface PipelineEvent {
  time: string;
  source: string;
  message: string;
  type: 'alert' | 'signal' | 'trade' | 'info';
}

const MOCK_AGENTS: AgentStatus[] = [
  { name: 'Boba', role: 'Mission Control', status: 'online', lastAction: 'Morning brief generated', tasksToday: 12 },
  { name: 'JazzyHazzy', role: 'Research & Analysis', status: 'online', lastAction: 'LLY analysis complete', tasksToday: 8 },
  { name: 'Orion', role: 'Alert Monitoring', status: 'idle', lastAction: 'BTC signal scanned', tasksToday: 34 },
];

const MOCK_PIPELINE: PipelineEvent[] = [
  { time: '11:58', source: 'BOBA', message: 'Morning brief delivered — BTC WAIT, OXY pending Monday', type: 'info' },
  { time: '12:05', source: 'BOBA', message: 'LLY position: $935.58 — tightening stop to $910 for Monday', type: 'trade' },
  { time: '11:45', source: 'ORION', message: 'BTC SuperTrend: SELL signal, confidence 14/100', type: 'alert' },
  { time: '11:30', source: 'JAZZYHAZZY', message: 'GSAT M&A catalyst confirmed — Amazon $9B deal talks', type: 'signal' },
  { time: '10:15', source: 'ORION', message: 'NFP release 8:30 AM EST — market closed Good Friday', type: 'alert' },
];

const STATUS_COLOR = { online: '#2ed573', idle: '#ff9800', offline: '#ef5350' };
const TYPE_COLOR = { alert: '#ef5350', signal: '#4fc3f7', trade: '#2ed573', info: '#636e72' };
const SOURCE_COLOR: Record<string, string> = { BOBA: '#4fc3f7', JAZZYHAZZY: '#0984e3', ORION: '#e17055' };

export function CommandCenterPage() {
  const [agents, setAgents] = useState<AgentStatus[]>(MOCK_AGENTS);
  const [pipeline, setPipeline] = useState<PipelineEvent[]>(MOCK_PIPELINE);
  const [lastRefresh, setLastRefresh] = useState(new Date());
  const [tokens, setTokens] = useState<TokenUsage>({ inputTokens: 0, outputTokens: 0, totalCost: 0, model: 'claude-sonnet-4', sessionCount: 0 });

  const [portfolioValue, setPortfolioValue] = useState(100000);
  const targetValue = 110000;
  const startValue = 100000;
  const progress = Math.max(0, Math.min(100, ((portfolioValue - startValue) / (targetValue - startValue)) * 100));

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch('/api/agents');
        if (res.ok) {
          const data = await res.json();
          if (data?.agents?.length) setAgents(data.agents);
        }
      } catch { /* use mock */ }
      // Fetch token usage from OpenClaw stats
      try {
        const res = await fetch('/api/openclaw-stats');
        if (res.ok) {
          const data = await res.json();
          if (data?.tokens) setTokens(data.tokens);
        }
      } catch { /* use mock */ }
      // Fetch live portfolio
      try {
        const pRes = await fetch("/api/portfolio");
        if (pRes.ok) {
          const pData = await pRes.json();
          if (pData.balance) setPortfolioValue(pData.balance);
        }
      } catch {}
      // Fetch live signals for pipeline
      try {
        const sRes = await fetch("/api/signals/history?ticker=BTCUSD&limit=5");
        if (sRes.ok) {
          const sData = await sRes.json();
          if (Array.isArray(sData) && sData.length > 0) {
            const livePipe = sData.reverse().map((s: any) => ({
              time: s.timestamp ? new Date(s.timestamp).toLocaleTimeString([], {hour: "2-digit", minute: "2-digit"}) : "",
              source: s.action === "BUY" ? "SIGNAL" : "SIGNAL",
              message: s.ticker + " " + s.action + (s.price ? " @ $" + s.price.toLocaleString() : "") + " — " + (s.signal_type || "signal"),
              type: (s.action === "BUY" ? "trade" : "alert") as "trade" | "alert",
            }));
            setPipeline(livePipe);
          }
        }
      } catch {}
      setLastRefresh(new Date());
    };
    fetchData();
    const interval = setInterval(fetchData, 10000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div style={{ padding: '24px 28px', fontFamily: "'Inter', -apple-system, sans-serif", minHeight: '100vh', background: '#0a0a10' }}>

      {/* Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 24 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 700, color: '#e0e0e0', margin: 0, letterSpacing: '-0.3px' }}>Command Center</h1>
          <p style={{ fontSize: 12, color: '#607d8b', marginTop: 4, fontFamily: "'JetBrains Mono', monospace" }}>
            PHASE 1 — PROVE ROI &nbsp;·&nbsp; Last refresh: {lastRefresh.toLocaleTimeString()}
          </p>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', background: 'rgba(46,213,115,0.08)', border: '1px solid rgba(46,213,115,0.25)', borderRadius: 8 }}>
          <span style={{ width: 7, height: 7, borderRadius: '50%', background: '#2ed573' }} />
          <span style={{ fontSize: 11, color: '#2ed573', fontFamily: "'JetBrains Mono', monospace", fontWeight: 700 }}>LIVE</span>
        </div>
      </div>

      {/* Mission Progress */}
      <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px', marginBottom: 24 }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 10 }}>
          <span style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px' }}>MISSION PROGRESS</span>
          <span style={{ fontSize: 12, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace", fontWeight: 700 }}>Phase 1 of 2</span>
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 10 }}>
          <span style={{ fontSize: 20, fontWeight: 700, color: '#e0e0e0', fontFamily: "'JetBrains Mono', monospace" }}>${portfolioValue.toLocaleString()}</span>
          <span style={{ fontSize: 14, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>→ ${targetValue.toLocaleString()} goal</span>
        </div>
        <div style={{ background: '#1a3a4a', borderRadius: 6, height: 8, overflow: 'hidden' }}>
          <div style={{ background: 'linear-gradient(90deg, #4fc3f7, #81d4fa)', width: `${Math.max(1, progress)}%`, height: '100%', borderRadius: 6, transition: 'width 0.5s ease' }} />
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 6 }}>
          <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>+${(portfolioValue - startValue).toFixed(2)} earned</span>
          <span style={{ fontSize: 11, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace" }}>{progress.toFixed(2)}% complete</span>
        </div>
      </div>

      {/* AI Token Usage */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12, marginBottom: 24 }}>
        {[
          { label: 'Input Tokens', value: tokens.inputTokens > 0 ? tokens.inputTokens.toLocaleString() : '—', color: '#4fc3f7', sub: 'today' },
          { label: 'Output Tokens', value: tokens.outputTokens > 0 ? tokens.outputTokens.toLocaleString() : '—', color: '#0984e3', sub: 'today' },
          { label: 'Est. Cost', value: tokens.totalCost > 0 ? `$${tokens.totalCost.toFixed(3)}` : '—', color: '#ff9800', sub: 'today' },
          { label: 'Model', value: tokens.model || 'claude-sonnet-4', color: '#2ed573', sub: 'active' },
        ].map((stat) => (
          <div key={stat.label} style={{ background: '#0d1117', border: `1px solid ${stat.color}25`, borderRadius: 10, padding: '12px 14px' }}>
            <div style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", marginBottom: 6 }}>{stat.label}</div>
            <div style={{ fontSize: 18, fontWeight: 700, color: stat.color, fontFamily: "'JetBrains Mono', monospace" }}>{stat.value}</div>
            <div style={{ fontSize: 10, color: '#455a64', marginTop: 3 }}>{stat.sub}</div>
          </div>
        ))}
      </div>

      {/* Agent Cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16, marginBottom: 24 }}>
        {agents.map((agent) => (
          <div key={agent.name} style={{ background: '#0d1117', border: `1px solid ${STATUS_COLOR[agent.status]}30`, borderRadius: 12, padding: '16px 18px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: 10 }}>
              <div>
                <div style={{ fontSize: 15, fontWeight: 700, color: '#e0e0e0' }}>{agent.name}</div>
                <div style={{ fontSize: 11, color: '#455a64', marginTop: 2 }}>{agent.role}</div>
              </div>
              <div style={{ display: 'flex', alignItems: 'center', gap: 5, padding: '3px 8px', background: `${STATUS_COLOR[agent.status]}15`, border: `1px solid ${STATUS_COLOR[agent.status]}40`, borderRadius: 20 }}>
                <span style={{ width: 6, height: 6, borderRadius: '50%', background: STATUS_COLOR[agent.status] }} />
                <span style={{ fontSize: 10, color: STATUS_COLOR[agent.status], fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, textTransform: 'uppercase' }}>{agent.status}</span>
              </div>
            </div>
            <div style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", marginBottom: 8, lineHeight: 1.5 }}>
              {agent.lastAction}
            </div>
            <div style={{ fontSize: 11, color: '#455a64' }}>
              <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{agent.tasksToday}</span> tasks today
            </div>
          </div>
        ))}
      </div>

      {/* Pipeline Feed */}
      <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px' }}>
        <div style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 14 }}>LIVE PIPELINE</div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          {pipeline.map((event, i) => (
            <div key={i} style={{ display: 'flex', alignItems: 'flex-start', gap: 10, padding: '8px 12px', background: '#13131e', borderRadius: 8, borderLeft: `3px solid ${TYPE_COLOR[event.type]}` }}>
              <span style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", flexShrink: 0, marginTop: 2 }}>{event.time}</span>
              <span style={{ fontSize: 10, color: SOURCE_COLOR[event.source] || '#455a64', fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, flexShrink: 0 }}>[{event.source}]</span>
              <span style={{ fontSize: 12, color: '#c8c8d4', lineHeight: 1.5 }}>{event.message}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default CommandCenterPage;
