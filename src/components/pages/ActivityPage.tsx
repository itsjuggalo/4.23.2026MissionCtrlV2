'use client';

import { useState, useEffect, useCallback } from 'react';
import { Badge } from '../ui/Badge';

interface ActivityEntry {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: string;
}

function typeColor(type: string) {
  switch (type) {
    case 'signal': return '#6c5ce7';
    case 'risk': return '#ffa502';
    case 'intel': return '#3498ff';
    case 'execution': return '#00d2a0';
    case 'memory': return '#00cec9';
    default: return '#5c5c72';
  }
}

export function ActivityPage() {
  const [entries, setEntries] = useState<ActivityEntry[]>([]);
  const [loading, setLoading] = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [secondsAgo, setSecondsAgo] = useState(0);

  const fetchActivity = useCallback(async () => {
    try {
      const res = await fetch('/api/activity');
      if (res.ok) {
        const data = await res.json();
        if (data.entries) {
          setEntries(data.entries);
          setLastUpdated(new Date());
        }
      }
    } catch {
      // silent fail
    } finally {
      setLoading(false);
    }
  }, []);

  // Fetch on mount + every 30 seconds
  useEffect(() => {
    fetchActivity();
    const interval = setInterval(fetchActivity, 30000);
    return () => clearInterval(interval);
  }, [fetchActivity]);

  // Update "seconds ago" counter every second
  useEffect(() => {
    const tick = setInterval(() => {
      if (lastUpdated) {
        setSecondsAgo(Math.floor((Date.now() - lastUpdated.getTime()) / 1000));
      }
    }, 1000);
    return () => clearInterval(tick);
  }, [lastUpdated]);

  if (loading) {
    return (
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: 200, color: '#5c5c72' }}>
        <div style={{ textAlign: 'center' }}>
          <div style={{ fontSize: 24, marginBottom: 8 }}>⏳</div>
          <div style={{ fontFamily: "'Inter', sans-serif", fontSize: 13 }}>Loading activity...</div>
        </div>
      </div>
    );
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 0 }}>
      {/* Live indicator */}
      <div style={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        padding: '10px 16px',
        borderBottom: '1px solid #1e1e2a',
        background: 'rgba(0,210,160,0.04)',
      }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
          <span style={{
            width: 8, height: 8, borderRadius: '50%',
            background: '#00d2a0',
            display: 'inline-block',
            animation: 'pulse 2s infinite',
          }} />
          <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#00d2a0' }}>
            LIVE
          </span>
          <span style={{ fontFamily: "'Inter', sans-serif", fontSize: 11, color: '#5c5c72' }}>
            • updated {secondsAgo}s ago • {entries.length} events
          </span>
        </div>
        <button
          onClick={fetchActivity}
          style={{
            background: 'rgba(108,92,231,0.15)',
            border: '1px solid rgba(108,92,231,0.3)',
            borderRadius: 4,
            color: '#a29bfe',
            padding: '4px 12px',
            fontSize: 11,
            fontFamily: "'JetBrains Mono', monospace",
            cursor: 'pointer',
          }}
        >
          Refresh
        </button>
      </div>

      {entries.length === 0 ? (
        <div style={{ padding: 40, textAlign: 'center', color: '#5c5c72', fontFamily: "'Inter', sans-serif", fontSize: 13 }}>
          No recent activity found
        </div>
      ) : (
        entries.map((entry, i) => {
          const dotColor = typeColor(entry.type);
          const isFirst = i === 0;
          return (
            <div
              key={i}
              style={{
                display: 'flex',
                gap: 16,
                padding: '14px 16px',
                background: isFirst ? 'rgba(108,92,231,0.06)' : 'transparent',
                borderBottom: '1px solid #1e1e2a',
              }}
            >
              <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 6, minWidth: 70 }}>
                <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#5c5c72' }}>
                  {entry.time.includes(' ') ? entry.time.split(' ')[1]?.slice(0, 5) || entry.time : entry.time}
                </span>
                <span style={{ width: 8, height: 8, borderRadius: '50%', background: dotColor, display: 'inline-block', flexShrink: 0 }} />
              </div>
              <div style={{ flex: 1 }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 4, flexWrap: 'wrap' }}>
                  <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 12, color: '#a29bfe', fontWeight: 600 }}>
                    {entry.agent}
                  </span>
                  <span style={{ fontSize: 13, fontFamily: "'Inter', sans-serif", fontWeight: 500, color: '#e8e8ed' }}>
                    {entry.action}
                  </span>
                  <Badge color={dotColor}>{entry.type}</Badge>
                </div>
                {entry.detail && (
                  <div style={{ fontSize: 12, fontFamily: "'Inter', sans-serif", color: '#8b8b9e', lineHeight: 1.5 }}>
                    {entry.detail}
                  </div>
                )}
              </div>
            </div>
          );
        })
      )}
    </div>
  );
}
