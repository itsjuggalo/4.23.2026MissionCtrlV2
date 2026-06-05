'use client';
import { useState, useEffect } from 'react';

// ARIES — Agent Resource Intelligence & Execution Status.
// Composite system-health view. Data: GET /api/aries (aggregates agent trust,
// activity, errors, skills, cost, and active alerts from mission-control.db).

interface AgentHealth {
  name: string;
  trust_score: number;
  grade: string;
  recent_24h: number;
  errors_7d: number;
  total_activities: number;
  last_active: string | null;
  status: 'online' | 'idle' | 'offline';
}
interface Vitals {
  activity_24h: number; errors_24h: number; skill_success_pct: number;
  skill_runs_7d: number; cost_7d: number; active_alerts: number;
  critical_alerts: number; warning_alerts: number;
}
interface AlertRow { severity: string; category: string; title: string; detail: string; created_at: string; }
interface AriesData {
  timestamp: string; health_score: number; health_label: string;
  agents: AgentHealth[]; vitals: Vitals; alerts: AlertRow[]; recommendations: string[];
}

function timeAgo(iso: string | null): string {
  if (!iso) return 'never';
  const ms = Date.now() - new Date(iso.replace(' ', 'T') + (iso.includes('Z') ? '' : 'Z')).getTime();
  if (isNaN(ms)) return iso;
  const m = Math.floor(ms / 60000);
  if (m < 1) return 'just now';
  if (m < 60) return `${m}m ago`;
  const h = Math.floor(m / 60);
  if (h < 24) return `${h}h ago`;
  return `${Math.floor(h / 24)}d ago`;
}

const gradeColor = (g: string) => g === 'A' ? '#66bb6a' : g === 'B' ? '#4fc3f7' : g === 'C' ? '#ff9800' : '#ef5350';
const healthColor = (s: number) => s >= 85 ? '#66bb6a' : s >= 60 ? '#4fc3f7' : s >= 35 ? '#ff9800' : '#ef5350';
const sevColor = (s: string) => s === 'critical' ? '#ef5350' : s === 'warning' ? '#ff9800' : '#4fc3f7';

export function AriesPage() {
  const [data, setData] = useState<AriesData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/aries').then(r => r.ok ? r.json() : null).catch(() => null);
        if (res) { setData(res); setError(false); } else { setError(true); }
      } catch { setError(true); }
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 15000);
    return () => clearInterval(i);
  }, []);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      INITIALIZING ARIES...
    </div>
  );

  const v = data?.vitals;
  const hc = healthColor(data?.health_score ?? 0);

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ ARIES API unavailable — data may be stale</div>}
      <style>{`
        .ar-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; transition: border-color 0.2s; }
        .ar-card:hover { border-color: #4fc3f744; }
        @keyframes arPulse { 0%,100% { opacity:1; } 50% { opacity:0.5; } }
      `}</style>

      {/* Header + overall health */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: '20px', flexWrap: 'wrap', gap: '16px' }}>
        <div>
          <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 900, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>ARIES</div>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Agent Resource Intelligence &amp; Execution Status</div>
        </div>
        <div className="ar-card" style={{ padding: '16px 28px', textAlign: 'center', borderLeft: `4px solid ${hc}`, minWidth: '200px' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>SYSTEM HEALTH</div>
          <div style={{ fontSize: '44px', fontWeight: 900, color: hc, fontFamily: 'var(--font-mc-mono)', lineHeight: 1.1 }}>{data?.health_score ?? '—'}</div>
          <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: hc, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>{data?.health_label ?? ''}</div>
        </div>
      </div>

      {/* Vitals */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(150px, 1fr))', gap: '12px', marginBottom: '24px' }}>
        {[
          { label: 'ACTIVITY 24H', value: String(v?.activity_24h ?? 0), color: '#4fc3f7' },
          { label: 'ERRORS 24H', value: String(v?.errors_24h ?? 0), color: (v?.errors_24h ?? 0) > 0 ? '#ef5350' : '#66bb6a' },
          { label: 'SKILL SUCCESS', value: `${v?.skill_success_pct ?? 100}%`, color: (v?.skill_success_pct ?? 100) >= 80 ? '#66bb6a' : '#ff9800' },
          { label: 'LLM COST 7D', value: `$${(v?.cost_7d ?? 0).toFixed(2)}`, color: '#ce93d8' },
          { label: 'ACTIVE ALERTS', value: String(v?.active_alerts ?? 0), color: (v?.critical_alerts ?? 0) > 0 ? '#ef5350' : (v?.active_alerts ?? 0) > 0 ? '#ff9800' : '#66bb6a' },
        ].map((m, i) => (
          <div key={i} className="ar-card" style={{ padding: '16px 20px', textAlign: 'center' }}>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Recommendations */}
      {data?.recommendations && data.recommendations.length > 0 && (
        <div className="ar-card" style={{ padding: '14px 18px', marginBottom: '24px', borderLeft: '4px solid #4fc3f7' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '8px' }}>ARIES RECOMMENDATIONS</div>
          {data.recommendations.map((r, i) => (
            <div key={i} style={{ fontSize: 'var(--mc-font-xs)', color: '#b0bec5', fontFamily: 'var(--font-mc-mono)', padding: '3px 0' }}>• {r}</div>
          ))}
        </div>
      )}

      {/* Agent fleet health */}
      <div style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #4fc3f744' }}>
        AGENT FLEET HEALTH
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '10px', marginBottom: '28px' }}>
        {(data?.agents ?? []).map((a, i) => {
          const gc = gradeColor(a.grade);
          const statusColor = a.status === 'online' ? '#66bb6a' : a.status === 'idle' ? '#ff9800' : '#ef5350';
          return (
            <div key={i} className="ar-card" style={{ padding: '16px 18px', borderLeft: `3px solid ${gc}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '10px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: statusColor, boxShadow: a.status === 'online' ? `0 0 6px ${statusColor}88` : 'none', animation: a.status === 'online' ? 'arPulse 3s ease-in-out infinite' : 'none' }} />
                  <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{a.name}</span>
                </div>
                <div style={{ textAlign: 'center' }}>
                  <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 900, color: gc, fontFamily: 'var(--font-mc-mono)' }}>{a.grade}</span>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginLeft: '6px' }}>{a.trust_score}</span>
                </div>
              </div>
              <div style={{ display: 'flex', gap: '14px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                <div><span style={{ color: '#607d8b' }}>24H: </span><span style={{ color: '#e0e0e0' }}>{a.recent_24h}</span></div>
                <div><span style={{ color: '#607d8b' }}>ERR: </span><span style={{ color: a.errors_7d > 0 ? '#ef5350' : '#66bb6a', fontWeight: 600 }}>{a.errors_7d}</span></div>
                <div><span style={{ color: '#607d8b' }}>SEEN: </span><span style={{ color: '#e0e0e0' }}>{timeAgo(a.last_active)}</span></div>
              </div>
            </div>
          );
        })}
      </div>

      {/* Active alerts */}
      <div style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #ef535044' }}>
        ACTIVE ALERTS {data?.alerts?.length ? `(${data.alerts.length})` : ''}
      </div>
      {data?.alerts && data.alerts.length > 0 ? (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
          {data.alerts.map((al, i) => {
            const c = sevColor(al.severity);
            return (
              <div key={i} className="ar-card" style={{ padding: '10px 14px', borderLeft: `3px solid ${c}` }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{al.title}</span>
                  <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${c}22`, color: c, fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>{al.severity}</span>
                </div>
                {al.detail && <div style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{al.detail}</div>}
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{al.category} · {timeAgo(al.created_at)}</div>
              </div>
            );
          })}
        </div>
      ) : (
        <div style={{ fontSize: 'var(--mc-font-sm)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', padding: '12px 0' }}>✓ No active alerts</div>
      )}
    </div>
  );
}

export default AriesPage;
