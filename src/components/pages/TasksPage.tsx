'use client';
import { useState, useEffect } from 'react';

interface AgentTask {
  task: string;
  type?: string;
  schedule?: string;
  source?: string;
  ticker?: string;
  discovered_at?: string;
}

interface AgentData {
  color: string;
  icon: string;
  role: string;
  default_tasks: AgentTask[];
  discovered_tasks: AgentTask[];
}

interface AgentsPayload {
  version?: number;
  agents: Record<string, AgentData>;
  error?: string;
}

function timeAgo(ts: string): string {
  const diff = Date.now() - new Date(ts).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'now';
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
}

export function TasksPage() {
  const [data, setData] = useState<AgentsPayload>({ agents: {} });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/agent-tasks');
        const j = await res.json();
        setData(j);
        setError(false);
      } catch { setError(true); }
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 30000);
    return () => clearInterval(i);
  }, []);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-lg)' }}>
      LOADING AGENT TASKS...
    </div>
  );

  const agentNames = Object.keys(data.agents || {});
  const totalDefault = agentNames.reduce((s, n) => s + (data.agents[n]?.default_tasks?.length || 0), 0);
  const totalDiscovered = agentNames.reduce((s, n) => s + (data.agents[n]?.discovered_tasks?.length || 0), 0);

  return (
    <div style={{ padding: '16px 20px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '14px', flexWrap: 'wrap' }}>
        <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>AGENT OPERATIONS</span>
        <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
          {agentNames.length} agents · {totalDefault} core duties · {totalDiscovered} discovered
        </span>
        <span style={{ marginLeft: 'auto', fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
          Polling 30s
        </span>
      </div>

      {/* Agent column grid */}
      <div style={{ flex: 1, overflow: 'auto', minHeight: 0 }}>
        {agentNames.length === 0 ? (
          <div style={{ padding: '60px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)', background: '#0a1929', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
            No agent data loaded {data.error ? `(${data.error})` : ''}
          </div>
        ) : (
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(360px, 1fr))', gap: '12px', alignContent: 'start' }}>
            {agentNames.map(name => {
              const a = data.agents[name];
              const totalTasks = (a.default_tasks?.length || 0) + (a.discovered_tasks?.length || 0);
              return (
                <div key={name} style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', borderLeft: `3px solid ${a.color}`, display: 'flex', flexDirection: 'column', maxHeight: '560px', overflow: 'hidden' }}>
                  {/* Card header */}
                  <div style={{ padding: '12px 14px', borderBottom: '1px solid #1a3a4a', flexShrink: 0 }}>
                    <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '4px' }}>
                      <span style={{ fontSize: 'var(--mc-font-md)' }}>{a.icon}</span>
                      <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: a.color, fontFamily: 'var(--font-mc-mono)' }}>{name}</span>
                      <span style={{ marginLeft: 'auto', fontSize: '10px', padding: '2px 7px', borderRadius: '10px', background: `${a.color}22`, color: a.color, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{totalTasks}</span>
                    </div>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{a.role}</div>
                  </div>

                  {/* Card body — tasks */}
                  <div style={{ flex: 1, overflow: 'auto', padding: '6px', display: 'flex', flexDirection: 'column', gap: '4px' }}>
                    {/* Default core tasks */}
                    {(a.default_tasks || []).map((t, i) => (
                      <div key={`d-${i}`} style={{ padding: '7px 10px', background: '#0d1117', borderRadius: '4px', borderLeft: `2px solid ${a.color}55`, display: 'flex', alignItems: 'flex-start', gap: '6px' }}>
                        <span style={{ fontSize: '9px', fontWeight: 700, color: a.color, padding: '1px 5px', borderRadius: '3px', background: `${a.color}22`, fontFamily: 'var(--font-mc-mono)', flexShrink: 0, marginTop: '1px' }}>CORE</span>
                        <div style={{ flex: 1, minWidth: 0 }}>
                          <div style={{ fontSize: 'var(--mc-font-label)', color: '#cfd8dc', fontFamily: 'var(--font-mc-mono)', lineHeight: 1.4 }}>{t.task}</div>
                          {t.schedule && <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>⏰ {t.schedule}</div>}
                        </div>
                      </div>
                    ))}

                    {/* Discovered tasks */}
                    {(a.discovered_tasks || []).slice().reverse().map((t, i) => (
                      <div key={`x-${i}`} style={{ padding: '7px 10px', background: '#0d1117', borderRadius: '4px', borderLeft: `2px solid #ffd600`, display: 'flex', alignItems: 'flex-start', gap: '6px' }}>
                        <span style={{ fontSize: '9px', fontWeight: 700, color: '#ffd600', padding: '1px 5px', borderRadius: '3px', background: '#ffd60022', fontFamily: 'var(--font-mc-mono)', flexShrink: 0, marginTop: '1px' }}>NEW</span>
                        <div style={{ flex: 1, minWidth: 0 }}>
                          <div style={{ display: 'flex', alignItems: 'center', gap: '6px', flexWrap: 'wrap' }}>
                            <span style={{ fontSize: 'var(--mc-font-label)', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', lineHeight: 1.4 }}>{t.task}</span>
                            {t.ticker && <span style={{ fontSize: '10px', color: '#4fc3f7', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{t.ticker}</span>}
                          </div>
                          <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px', display: 'flex', gap: '8px' }}>
                            {t.source && <span>src: {t.source}</span>}
                            {t.discovered_at && <span>{timeAgo(t.discovered_at)}</span>}
                          </div>
                        </div>
                      </div>
                    ))}

                    {totalTasks === 0 && (
                      <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>No tasks defined</div>
                    )}
                  </div>
                </div>
              );
            })}
          </div>
        )}
      </div>
    </div>
  );
}
