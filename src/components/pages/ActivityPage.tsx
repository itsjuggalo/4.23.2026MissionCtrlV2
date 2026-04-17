'use client';
import { useState, useEffect, useCallback, useMemo } from 'react';

interface ActivityEntry {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: string;
}

const CATEGORY_MAP: Record<string, { label: string; color: string; bg: string; icon: string }> = {
  'agent': { label: 'Agent', color: '#60a5fa', bg: '#60a5fa15', icon: '🤖' },
  'trade': { label: 'Trade', color: '#10b981', bg: '#10b98115', icon: '💰' },
  'signal': { label: 'Signal', color: '#f59e0b', bg: '#f59e0b15', icon: '📡' },
  'system': { label: 'System', color: '#8b5cf6', bg: '#8b5cf615', icon: '⚙️' },
  'alert': { label: 'Alert', color: '#ef4444', bg: '#ef444415', icon: '🚨' },
  'brief': { label: 'Brief', color: '#06b6d4', bg: '#06b6d415', icon: '📋' },
  'scraper': { label: 'Scraper', color: '#a78bfa', bg: '#a78bfa15', icon: '🔍' },
  'cron': { label: 'Cron', color: '#64748b', bg: '#64748b15', icon: '⏰' },
};

function categorize(entry: ActivityEntry): string {
  const action = (entry.action || '').toLowerCase();
  const agent = (entry.agent || '').toLowerCase();
  const type = (entry.type || '').toLowerCase();

  if (type && CATEGORY_MAP[type]) return type;
  if (action.includes('trade') || action.includes('buy') || action.includes('sell') || action.includes('order')) return 'trade';
  if (action.includes('signal') || action.includes('supertrend') || action.includes('webhook')) return 'signal';
  if (action.includes('alert') || action.includes('warning') || action.includes('risk')) return 'alert';
  if (action.includes('brief') || action.includes('morning') || action.includes('midday') || action.includes('eod') || action.includes('nightly')) return 'brief';
  if (action.includes('relay') || action.includes('scrape') || action.includes('fetch')) return 'scraper';
  if (action.includes('cron') || action.includes('heartbeat') || action.includes('cycle')) return 'cron';
  if (agent.includes('boba') || agent.includes('jazzy') || agent.includes('orion')) return 'agent';
  return 'system';
}

function timeAgo(dateStr: string): string {
  try {
    const date = new Date(dateStr);
    const diff = Date.now() - date.getTime();
    const mins = Math.floor(diff / 60000);
    if (mins < 1) return 'just now';
    if (mins < 60) return `${mins}m ago`;
    const hrs = Math.floor(mins / 60);
    if (hrs < 24) return `${hrs}h ago`;
    const days = Math.floor(hrs / 24);
    if (days < 7) return `${days}d ago`;
    return date.toLocaleDateString();
  } catch {
    return dateStr;
  }
}

function formatTimestamp(dateStr: string): string {
  try {
    const d = new Date(dateStr);
    return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) + ' ' +
      d.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', second: '2-digit' });
  } catch {
    return dateStr;
  }
}

export function ActivityPage() {
  const [entries, setEntries] = useState<ActivityEntry[]>([]);
  const [loading, setLoading] = useState(true);
  const [filter, setFilter] = useState<string>('all');
  const [lastUpdate, setLastUpdate] = useState<Date>(new Date());

  const fetchActivity = useCallback(async () => {
    try {
      const res = await fetch('/api/activity');
      const data = await res.json();
      const items = Array.isArray(data) ? data : data.entries || data.activities || [];
      setEntries(items);
      setLastUpdate(new Date());
    } catch (e) {
      console.error('Activity fetch error:', e);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchActivity();
    const interval = setInterval(fetchActivity, 15000);
    return () => clearInterval(interval);
  }, [fetchActivity]);

  const categorized = useMemo(() =>
    entries.map(e => ({ ...e, category: categorize(e) })),
    [entries]
  );

  const filtered = useMemo(() =>
    filter === 'all' ? categorized : categorized.filter(e => e.category === filter),
    [categorized, filter]
  );

  const counts = useMemo(() => {
    const c: Record<string, number> = { all: categorized.length };
    categorized.forEach(e => { c[e.category] = (c[e.category] || 0) + 1; });
    return c;
  }, [categorized]);

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
        <div>
          <h1 style={{ fontSize: '22px', fontWeight: 700, color: '#f0f0f0', margin: 0 }}>⚡ Activity Feed</h1>
          <p style={{ fontSize: '12px', color: '#555', marginTop: '4px' }}>
            {entries.length} events • Updated {timeAgo(lastUpdate.toISOString())} • Auto-refreshes every 15s
          </p>
        </div>
        <button onClick={fetchActivity} style={{
          padding: '8px 14px', background: '#111', border: '1px solid #222',
          borderRadius: '8px', color: '#888', fontSize: '12px', cursor: 'pointer',
        }}>
          Refresh
        </button>
      </div>

      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '6px', marginBottom: '20px' }}>
        <button
          onClick={() => setFilter('all')}
          style={{
            padding: '6px 14px', borderRadius: '20px', fontSize: '12px', fontWeight: 500,
            border: `1px solid ${filter === 'all' ? '#444' : '#1a1a1a'}`,
            background: filter === 'all' ? '#222' : '#111',
            color: filter === 'all' ? '#f0f0f0' : '#666',
            cursor: 'pointer',
          }}
        >
          All ({counts.all || 0})
        </button>
        {Object.entries(CATEGORY_MAP).map(([key, cat]) => (
          counts[key] ? (
            <button
              key={key}
              onClick={() => setFilter(key)}
              style={{
                padding: '6px 14px', borderRadius: '20px', fontSize: '12px', fontWeight: 500,
                border: `1px solid ${filter === key ? cat.color + '44' : '#1a1a1a'}`,
                background: filter === key ? cat.bg : '#111',
                color: filter === key ? cat.color : '#666',
                cursor: 'pointer',
              }}
            >
              {cat.icon} {cat.label} ({counts[key]})
            </button>
          ) : null
        ))}
      </div>

      {loading ? (
        <div style={{ textAlign: 'center', padding: '40px', color: '#555' }}>Loading activity...</div>
      ) : filtered.length === 0 ? (
        <div style={{ textAlign: 'center', padding: '40px', color: '#555' }}>No activity found</div>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '4px' }}>
          {filtered.map((entry, i) => {
            const cat = CATEGORY_MAP[(entry as any).category] || CATEGORY_MAP.system;
            return (
              <div key={i} style={{
                display: 'flex', alignItems: 'flex-start', gap: '12px',
                padding: '12px 16px', background: '#111', border: '1px solid #1a1a1a',
                borderRadius: '8px', borderLeft: `3px solid ${cat.color}`,
              }}>
                <div style={{ flexShrink: 0, textAlign: 'center', minWidth: '32px' }}>
                  <span style={{ fontSize: '18px' }}>{cat.icon}</span>
                </div>
                <div style={{ flex: 1, minWidth: 0 }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '4px' }}>
                    <span style={{ fontSize: '12px', fontWeight: 600, color: cat.color }}>{entry.agent || 'System'}</span>
                    <span style={{
                      fontSize: '10px', padding: '1px 8px', borderRadius: '10px',
                      background: cat.bg, color: cat.color, border: `1px solid ${cat.color}33`,
                    }}>
                      {cat.label}
                    </span>
                  </div>
                  <div style={{ fontSize: '13px', color: '#c8c8c8', lineHeight: '1.5' }}>{entry.action}</div>
                  {entry.detail && <div style={{ fontSize: '12px', color: '#555', marginTop: '4px' }}>{entry.detail}</div>}
                </div>
                <div style={{ flexShrink: 0, textAlign: 'right', minWidth: '100px' }}>
                  <div style={{ fontSize: '12px', color: '#888', fontWeight: 500 }}>{timeAgo(entry.time)}</div>
                  <div style={{ fontSize: '10px', color: '#444', marginTop: '2px' }}>{formatTimestamp(entry.time)}</div>
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}
