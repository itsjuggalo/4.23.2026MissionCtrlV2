'use client';
import { useState, useEffect } from 'react';

interface AgentInfo {
  name: string;
  model: string;
  role: string;
  type: 'ai' | 'service';
  status: 'online' | 'offline' | 'stopped' | 'error';
  specialty: string;
  knownIssues: string[];
  trustGrade: string;
  trustScore: number;
  metrics: Record<string, number>;
  pm2?: { restarts: number; memory: number; cpu: number; uptime: number };
}

const AI_AGENTS: Omit<AgentInfo, 'status' | 'trustGrade' | 'trustScore' | 'metrics' | 'pm2'>[] = [
  {
    name: 'Boba',
    model: 'Claude Sonnet 4-6',
    role: 'Commander / Primary Orchestrator',
    type: 'ai',
    specialty: 'Trading decisions, brief generation, strategy analysis, code generation',
    knownIssues: ['Stopped trading when API credits ran out (early April)'],
  },
  {
    name: 'JazzyHazzy',
    model: 'GPT-4o-mini',
    role: 'Research & News Analyst',
    type: 'ai',
    specialty: 'Market news, research summaries, sentiment analysis',
    knownIssues: ['Hallucinated BTC prices ($30K when actually $75K+)', '$X placeholder values', 'Fabricated news stories', 'Wrong timestamps/year'],
  },
  {
    name: 'Orion',
    model: 'Gemini 2.5 Flash',
    role: 'Scanner & Technical Analyst',
    type: 'ai',
    specialty: 'Technical indicators, chart scanning, data formatting',
    knownIssues: ['MSTR alert sent 7x duplicate', 'Thinking out loud in responses', 'HEARTBEAT_OK noise', 'Free tier limit (20 req/day)'],
  },
];

function timeAgo(ms: number): string {
  const mins = Math.floor(ms / 60000);
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
}

export function AgentsPage() {
  const [trustData, setTrustData] = useState<any[]>([]);
  const [pm2Data, setPm2Data] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchData() {
      try {
        const [trustRes, agentsRes] = await Promise.all([
          fetch('/api/agent-trust').then(r => r.json()).catch(() => ({ agents: [] })),
          fetch('/api/agents').then(r => r.json()).catch(() => ({ agents: [] })),
        ]);
        setTrustData(trustRes.agents || []);
        setPm2Data(agentsRes.agents || []);
      } catch {}
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 15000);
    return () => clearInterval(i);
  }, []);

  const getTrust = (name: string) => {
    const t = trustData.find((a: any) => a.agent === name);
    if (!t) return { grade: 'N/A', score: 0, metrics: {} };
    const metrics: Record<string, number> = {};
    (t.metrics || []).forEach((m: any) => { metrics[m.metric_type] = Math.round(m.avg_val); });
    return { grade: t.grade, score: t.trust_score, metrics };
  };

  const getPm2 = (name: string) => {
    const p = pm2Data.find((a: any) => a.name?.toLowerCase().includes(name.toLowerCase()));
    if (!p) return null;
    return {
      status: p.status || 'unknown',
      restarts: p.restarts || 0,
      memory: Math.round((p.memory || 0) / 1048576),
      cpu: p.cpu || 0,
    };
  };

  const gradeColor = (grade: string) => {
    if (grade === 'A' || grade === 'A+') return '#66bb6a';
    if (grade === 'B') return '#4fc3f7';
    if (grade === 'C') return '#ff9800';
    if (grade === 'D' || grade === 'F') return '#ef5350';
    return '#607d8b';
  };

  // PM2 services (not AI agents)
  const services = pm2Data.filter((p: any) => {
    const name = (p.name || '').toLowerCase();
    return !['boba', 'jazzyhazzy', 'orion'].some(a => name.includes(a));
  });

  const onlineServices = services.filter((s: any) => s.status === 'online').length;
  const totalRestarts = services.reduce((sum: number, s: any) => sum + (s.restarts || 0), 0);
  const totalMemory = services.reduce((sum: number, s: any) => sum + ((s.memory || 0) / 1048576), 0);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      LOADING AGENT FLEET...
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .ag-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; transition: border-color 0.2s; }
        .ag-card:hover { border-color: #4fc3f744; }
        .ag-metric { padding: 8px 12px; background: #0d1117; border-radius: 6px; text-align: center; }
        @keyframes agPulse { 0%,100% { opacity:1; } 50% { opacity:0.5; } }
      `}</style>

      {/* Fleet Overview */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '12px', marginBottom: '24px' }}>
        {[
          { label: 'AI AGENTS', value: '3', color: '#4fc3f7', sub: 'Boba · JazzyHazzy · Orion' },
          { label: 'SERVICES', value: `${onlineServices}/${services.length}`, color: '#66bb6a', sub: 'PM2 processes online' },
          { label: 'TOTAL RESTARTS', value: String(totalRestarts), color: totalRestarts > 50 ? '#ef5350' : '#ff9800', sub: 'Across all services' },
          { label: 'MEMORY USAGE', value: `${Math.round(totalMemory)}MB`, color: '#ce93d8', sub: 'Total PM2 footprint' },
        ].map((m, i) => (
          <div key={i} className="ag-card" style={{ padding: '16px 20px', textAlign: 'center' }}>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: '28px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
            <div style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{m.sub}</div>
          </div>
        ))}
      </div>

      {/* AI Agents Section */}
      <div style={{ fontSize: '13px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #4fc3f744' }}>
        AI AGENT FLEET
      </div>

      <div style={{ display: 'flex', flexDirection: 'column', gap: '14px', marginBottom: '28px' }}>
        {AI_AGENTS.map((agent, i) => {
          const trust = getTrust(agent.name);
          const gc = gradeColor(trust.grade);

          return (
            <div key={i} className="ag-card" style={{ padding: '24px 28px', borderLeft: `4px solid ${gc}` }}>
              {/* Header */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '16px' }}>
                <div>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '6px' }}>
                    <span style={{ fontSize: '22px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{agent.name}</span>
                    <span style={{ fontSize: '11px', fontWeight: 600, padding: '3px 10px', borderRadius: '4px', background: '#4fc3f722', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{agent.model}</span>
                  </div>
                  <div style={{ fontSize: '14px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{agent.role}</div>
                </div>
                {/* Trust Grade */}
                <div style={{ textAlign: 'center', minWidth: '80px' }}>
                  <div style={{ fontSize: '36px', fontWeight: 900, color: gc, fontFamily: 'var(--font-mc-mono)', lineHeight: 1 }}>{trust.grade}</div>
                  <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{trust.score}/100</div>
                </div>
              </div>

              {/* Specialty */}
              <div style={{ marginBottom: '14px', padding: '10px 14px', background: '#0d1117', borderRadius: '8px' }}>
                <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>SPECIALTY</div>
                <div style={{ fontSize: '13px', color: '#b0bec5', fontFamily: 'var(--font-mc-mono)' }}>{agent.specialty}</div>
              </div>

              {/* Metrics Row */}
              {Object.keys(trust.metrics).length > 0 && (
                <div style={{ display: 'grid', gridTemplateColumns: `repeat(${Math.min(Object.keys(trust.metrics).length, 5)}, 1fr)`, gap: '8px', marginBottom: '14px' }}>
                  {Object.entries(trust.metrics).map(([key, val]) => {
                    const metricColor = val >= 90 ? '#66bb6a' : val >= 70 ? '#4fc3f7' : val >= 50 ? '#ff9800' : '#ef5350';
                    return (
                      <div key={key} className="ag-metric">
                        <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px', marginBottom: '4px', textTransform: 'uppercase' }}>{key}</div>
                        <div style={{ fontSize: '20px', fontWeight: 700, color: metricColor, fontFamily: 'var(--font-mc-mono)' }}>{val}</div>
                        {/* Bar */}
                        <div style={{ marginTop: '4px', height: '3px', background: '#1a3a4a', borderRadius: '2px', overflow: 'hidden' }}>
                          <div style={{ height: '100%', width: `${Math.min(val, 100)}%`, background: metricColor, borderRadius: '2px' }} />
                        </div>
                      </div>
                    );
                  })}
                </div>
              )}

              {/* Known Issues */}
              {agent.knownIssues.length > 0 && (
                <div>
                  <div style={{ fontSize: '10px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>KNOWN ISSUES</div>
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '4px' }}>
                    {agent.knownIssues.map((issue, j) => (
                      <div key={j} style={{ fontSize: '11px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', padding: '6px 10px', background: '#ef535008', borderRadius: '4px', borderLeft: '2px solid #ef535044' }}>
                        {issue}
                      </div>
                    ))}
                  </div>
                </div>
              )}
            </div>
          );
        })}
      </div>

      {/* Infrastructure Services */}
      <div style={{ fontSize: '13px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #66bb6a44' }}>
        INFRASTRUCTURE SERVICES
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '10px' }}>
        {services.map((svc: any, i: number) => {
          const isOnline = svc.status === 'online';
          const mem = Math.round((svc.memory || 0) / 1048576);
          const restarts = svc.restarts || 0;
          const statusColor = isOnline ? '#66bb6a' : '#ef5350';
          const restartColor = restarts === 0 ? '#66bb6a' : restarts < 10 ? '#ff9800' : '#ef5350';

          return (
            <div key={i} className="ag-card" style={{ padding: '16px 18px', borderLeft: `3px solid ${statusColor}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{
                    width: '8px', height: '8px', borderRadius: '50%', background: statusColor,
                    boxShadow: isOnline ? `0 0 6px ${statusColor}88` : 'none',
                    animation: isOnline ? 'agPulse 3s ease-in-out infinite' : 'none',
                  }} />
                  <span style={{ fontSize: '14px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{svc.name}</span>
                </div>
                <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${statusColor}22`, color: statusColor, fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>
                  {svc.status}
                </span>
              </div>
              <div style={{ display: 'flex', gap: '16px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                <div><span style={{ color: '#607d8b' }}>MEM: </span><span style={{ color: '#e0e0e0' }}>{mem}MB</span></div>
                <div><span style={{ color: '#607d8b' }}>CPU: </span><span style={{ color: '#e0e0e0' }}>{svc.cpu || 0}%</span></div>
                <div><span style={{ color: '#607d8b' }}>RST: </span><span style={{ color: restartColor, fontWeight: 600 }}>{restarts}</span></div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}
