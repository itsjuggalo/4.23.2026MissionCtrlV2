'use client';
import { useState, useEffect } from 'react';

interface ActivityEntry {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: string;
}

const TYPE_CONFIG: Record<string, { color: string; icon: string }> = {
  agent: { color: '#4fc3f7', icon: '🤖' },
  trade: { color: '#66bb6a', icon: '💰' },
  signal: { color: '#ff9800', icon: '📡' },
  system: { color: '#ce93d8', icon: '⚙️' },
  alert: { color: '#ef5350', icon: '🚨' },
  brief: { color: '#4db6ac', icon: '📋' },
  scraper: { color: '#78909c', icon: '🔍' },
  cron: { color: '#607d8b', icon: '⏰' },
};

function timeAgo(ts: string): string {
  const diff = Date.now() - new Date(ts).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'now';
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
}

export function ActivityPage() {
  const [activities, setActivities] = useState<ActivityEntry[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [typeFilter, setTypeFilter] = useState<string>('all');
  const [agentFilter, setAgentFilter] = useState<string>('all');
  const [search, setSearch] = useState('');

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/activity?limit=100');
        const data = await res.json();
        setActivities(data.activities || []);
        setError(false);
      } catch { setError(true); }
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 15000);
    return () => clearInterval(i);
  }, []);

  const agents = [...new Set(activities.map(a => a.agent))].sort();
  const types = [...new Set(activities.map(a => a.type))].sort();

  let filtered = activities;
  if (typeFilter !== 'all') filtered = filtered.filter(a => a.type === typeFilter);
  if (agentFilter !== 'all') filtered = filtered.filter(a => a.agent === agentFilter);
  if (search) { const q = search.toLowerCase(); filtered = filtered.filter(a => a.action?.toLowerCase().includes(q) || a.agent?.toLowerCase().includes(q)); }

  // Group consecutive identical events (same agent + same action text) into a single row with count
  type GroupedActivity = ActivityEntry & { _count: number; _firstTime: string; _lastTime: string };
  const grouped: GroupedActivity[] = [];
  for (const a of filtered) {
    const last = grouped[grouped.length - 1];
    if (last && last.agent === a.agent && last.action === a.action && last.type === a.type) {
      last._count += 1;
      last._lastTime = last.time;
      last.time = a.time; // keep most-recent timestamp visible
    } else {
      grouped.push({ ...a, _count: 1, _firstTime: a.time, _lastTime: a.time });
    }
  }

  // Detect error severity from action text
  const isError = (a: ActivityEntry) => /error|fail|409|500|timeout|exception|crash/i.test(a.action || '');
  const isWarn  = (a: ActivityEntry) => /warn|retry|reconnect|throttle/i.test(a.action || '');

  const typeCounts: Record<string, number> = {};
  activities.forEach(a => { typeCounts[a.type] = (typeCounts[a.type] || 0) + 1; });

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', cursor: 'pointer', outline: 'none' };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-lg)' }}>
      LOADING ACTIVITY...
    </div>
  );

  return (
    <div style={{ padding: '16px 20px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Top Bar — Status + Dropdown Filters */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '12px', flexWrap: 'wrap' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>LIVE</span>
        <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{activities.length} events · Polling 15s</span>

        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />

        <select value={typeFilter} onChange={e => setTypeFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Types ({activities.length})</option>
          {types.map(t => {
            const cfg = TYPE_CONFIG[t] || { icon: '📌' };
            return <option key={t} value={t}>{cfg.icon} {t} ({typeCounts[t] || 0})</option>;
          })}
        </select>

        <select value={agentFilter} onChange={e => setAgentFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Agents</option>
          {agents.map(a => <option key={a} value={a}>{a}</option>)}
        </select>

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search..."
          style={{ ...selectStyle, width: '120px' }} />

        <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginLeft: 'auto' }}>
          {grouped.length} groups · {filtered.length} of {activities.length} events
        </span>
      </div>

      {/* Activity Feed — per-agent blocks grid */}
      <div style={{ flex: 1, overflow: 'auto', minHeight: 0 }}>
        {filtered.length === 0 ? (
          <div style={{ padding: '60px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)', background: '#0a1929', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
            No activity matches filters
          </div>
        ) : (() => {
          // Bucket grouped events by agent
          const byAgent: Record<string, GroupedActivity[]> = {};
          for (const g of grouped) {
            if (!byAgent[g.agent]) byAgent[g.agent] = [];
            byAgent[g.agent].push(g);
          }
          // Sort agents: most recent activity first
          const agentOrder = Object.keys(byAgent).sort((a, b) => {
            const ta = new Date(byAgent[a][0].time).getTime();
            const tb = new Date(byAgent[b][0].time).getTime();
            return tb - ta;
          });

          return (
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(420px, 1fr))', gap: '12px', alignContent: 'start' }}>
              {agentOrder.map(agentName => {
                const items = byAgent[agentName];
                const headType = items[0].type;
                const cfg = TYPE_CONFIG[headType] || { color: '#607d8b', icon: '📌' };
                const totalEvents = items.reduce((sum, x) => sum + x._count, 0);
                const errCount = items.filter(x => isError(x)).reduce((sum, x) => sum + x._count, 0);
                return (
                  <div key={agentName} style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', borderLeft: `3px solid ${cfg.color}`, display: 'flex', flexDirection: 'column', maxHeight: '380px', overflow: 'hidden' }}>
                    {/* Block header */}
                    <div style={{ padding: '10px 14px', borderBottom: '1px solid #1a3a4a', display: 'flex', alignItems: 'center', gap: '8px', flexShrink: 0 }}>
                      <span style={{ fontSize: 'var(--mc-font-sm)' }}>{cfg.icon}</span>
                      <span style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, color: cfg.color, fontFamily: 'var(--font-mc-mono)' }}>{agentName}</span>
                      <span style={{ fontSize: '10px', padding: '1px 6px', borderRadius: '3px', background: `${cfg.color}22`, color: cfg.color, fontFamily: 'var(--font-mc-mono)' }}>{headType}</span>
                      <span style={{ marginLeft: 'auto', fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                        {totalEvents} event{totalEvents !== 1 ? 's' : ''}{errCount > 0 ? <span style={{ color: '#ef5350', marginLeft: '6px' }}>· {errCount} err</span> : null}
                      </span>
                    </div>
                    {/* Block body — scrollable rows */}
                    <div style={{ flex: 1, overflow: 'auto', padding: '6px', display: 'flex', flexDirection: 'column', gap: '3px' }}>
                      {items.map((a, i) => {
                        const sevColor = isError(a) ? '#ef5350' : isWarn(a) ? '#ff9800' : cfg.color;
                        const bgColor = isError(a) ? '#1a0a0d' : '#0d1117';
                        return (
                          <div key={i} style={{ padding: '6px 10px', background: bgColor, borderRadius: '4px', borderLeft: `2px solid ${sevColor}`, display: 'flex', alignItems: 'center', gap: '8px', minWidth: 0 }}>
                            {a._count > 1 && <span style={{ fontSize: '10px', fontWeight: 700, color: '#0d1117', background: sevColor, padding: '1px 5px', borderRadius: '10px', fontFamily: 'var(--font-mc-mono)', flexShrink: 0 }}>×{a._count}</span>}
                            <span style={{ fontSize: 'var(--mc-font-label)', color: '#b0bec5', fontFamily: 'var(--font-mc-mono)', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap', flex: 1, minWidth: 0 }} title={a.action}>{a.action}</span>
                            <span style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', flexShrink: 0 }} title={a.time}>{timeAgo(a.time)}</span>
                          </div>
                        );
                      })}
                    </div>
                  </div>
                );
              })}
            </div>
          );
        })()}
      </div>
    </div>
  );
}
