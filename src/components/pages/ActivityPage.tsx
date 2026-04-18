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
  const [typeFilter, setTypeFilter] = useState<string>('all');
  const [agentFilter, setAgentFilter] = useState<string>('all');

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/activity?limit=100');
        const data = await res.json();
        setActivities(data.activities || []);
      } catch {}
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

  const typeCounts: Record<string, number> = {};
  activities.forEach(a => { typeCounts[a.type] = (typeCounts[a.type] || 0) + 1; });

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      LOADING ACTIVITY...
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .act-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; transition: border-color 0.2s; }
        .act-card:hover { border-color: #4fc3f744; }
        .act-btn { padding: 5px 12px; border-radius: 5px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 11px; cursor: pointer; font-weight: 600; }
        .act-btn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
      `}</style>

      {/* Stats */}
      <div style={{ display: 'grid', gridTemplateColumns: `repeat(${Math.min(Object.keys(typeCounts).length + 1, 7)}, 1fr)`, gap: '10px', marginBottom: '16px' }}>
        <div className="act-card" style={{ padding: '14px', textAlign: 'center' }}>
          <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>TOTAL</div>
          <div style={{ fontSize: '24px', fontWeight: 800, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{activities.length}</div>
        </div>
        {Object.entries(typeCounts).slice(0, 6).map(([type, count]) => {
          const cfg = TYPE_CONFIG[type] || { color: '#607d8b', icon: '📌' };
          return (
            <div key={type} className="act-card" style={{ padding: '14px', textAlign: 'center', cursor: 'pointer' }} onClick={() => setTypeFilter(typeFilter === type ? 'all' : type)}>
              <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>{cfg.icon} {type.toUpperCase()}</div>
              <div style={{ fontSize: '24px', fontWeight: 800, color: cfg.color, fontFamily: 'var(--font-mc-mono)' }}>{count}</div>
            </div>
          );
        })}
      </div>

      {/* Filters */}
      <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '14px', alignItems: 'center' }}>
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Type:</span>
        <button className={`act-btn ${typeFilter === 'all' ? 'active' : ''}`} onClick={() => setTypeFilter('all')}>All</button>
        {types.map(t => {
          const cfg = TYPE_CONFIG[t] || { color: '#607d8b', icon: '📌' };
          return (
            <button key={t} className={`act-btn ${typeFilter === t ? 'active' : ''}`} onClick={() => setTypeFilter(t)}
              style={typeFilter === t ? { background: `${cfg.color}22`, borderColor: cfg.color, color: cfg.color } : {}}>
              {cfg.icon} {t}
            </button>
          );
        })}
        <div style={{ width: '1px', height: '20px', background: '#1a3a4a', margin: '0 4px' }} />
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Agent:</span>
        <button className={`act-btn ${agentFilter === 'all' ? 'active' : ''}`} onClick={() => setAgentFilter('all')}>All</button>
        {agents.slice(0, 8).map(a => (
          <button key={a} className={`act-btn ${agentFilter === a ? 'active' : ''}`} onClick={() => setAgentFilter(a)}>
            {a.slice(0, 12)}
          </button>
        ))}
      </div>

      <div style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '10px' }}>
        Showing {filtered.length} of {activities.length} activities
      </div>

      {/* Activity Feed */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
        {filtered.length === 0 ? (
          <div className="act-card" style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
            No activity matches filters
          </div>
        ) : filtered.map((a, i) => {
          const cfg = TYPE_CONFIG[a.type] || { color: '#607d8b', icon: '📌' };
          return (
            <div key={i} className="act-card" style={{ padding: '12px 16px', borderLeft: `3px solid ${cfg.color}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                <div style={{ flex: 1 }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '4px' }}>
                    <span style={{ fontSize: '13px' }}>{cfg.icon}</span>
                    <span style={{ fontSize: '13px', fontWeight: 700, color: cfg.color, fontFamily: 'var(--font-mc-mono)' }}>{a.agent}</span>
                    <span style={{ fontSize: '10px', padding: '1px 6px', borderRadius: '3px', background: `${cfg.color}22`, color: cfg.color, fontFamily: 'var(--font-mc-mono)' }}>{a.type}</span>
                  </div>
                  <div style={{ fontSize: '12px', color: '#b0bec5', fontFamily: 'var(--font-mc-mono)', lineHeight: '1.4' }}>
                    {a.action}
                  </div>
                </div>
                <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', flexShrink: 0, marginLeft: '12px' }} title={a.time}>
                  {timeAgo(a.time)}
                </span>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}
