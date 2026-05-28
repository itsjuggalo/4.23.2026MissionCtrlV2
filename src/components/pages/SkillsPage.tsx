'use client';
import { useEffect, useState } from 'react';

interface Skill {
  name: string;
  agent: string;
  category: string;
  description: string;
  hasScripts: boolean;
  lastRun?: string;
}

const AGENT_COLORS: Record<string, string> = {
  boba: '#4fc3f7',
  jazzyhazzy: '#ff9800',
  orion: '#66bb6a',
  shared: '#81d4fa',
  reference: '#607d8b',
  unknown: '#455a64',
};

const AGENT_LABELS: Record<string, string> = {
  boba: 'BOBA · Claude Sonnet 4.6',
  jazzyhazzy: 'JAZZYHAZZY · GPT-4o-mini',
  orion: 'ORION · Gemini Flash',
  shared: 'SHARED · All Agents',
  reference: 'REFERENCE · Read-Only',
};

const CATEGORY_MAP: Record<string, string> = {
  'alpaca-trading': 'Trading',
  'auto-trading-strategy': 'Trading',
  'algo-builder': 'Trading',
  'btc-analysis': 'Analysis',
  'stock-analysis': 'Analysis',
  'trading-analysis': 'Analysis',
  'catalyst-scanner': 'Research',
  'announcement-search': 'Research',
  'calendar-research': 'Research',
  'ai-readiness': 'Research',
  'audit-xls': 'Tools',
  '3-statement-model': 'Reference',
  'ARK-Invest-2026-Big-Ideas': 'Reference',
  'BlackRock-2026-Global-Outlook': 'Reference',
  'George-Soros-Financial-Alchemy': 'Reference',
  'Howard-Marks-Oaktree-Memos': 'Reference',
  'Mark-Douglas-Trading-Psychology': 'Reference',
  'Peter-Lynch-Beating-the-Street': 'Reference',
  'Philip-Fisher-Common-Stocks': 'Reference',
  'Ray-Dalio-Principles': 'Reference',
  'Robert-Kiyosaki-Rich-Dad': 'Reference',
  'Templeton-Reverse-Investment': 'Reference',
  'Vanguard-2026-Economic-Outlook': 'Reference',
};

function classifyAgent(name: string): string {
  const tradingSkills = ['alpaca-trading', 'auto-trading-strategy', 'algo-builder'];
  const researchSkills = ['catalyst-scanner', 'announcement-search', 'calendar-research', 'ai-readiness'];
  const scannerSkills = ['btc-analysis', 'stock-analysis', 'trading-analysis'];
  if (tradingSkills.includes(name)) return 'boba';
  if (researchSkills.includes(name)) return 'jazzyhazzy';
  if (scannerSkills.includes(name)) return 'orion';
  if (name.includes('Invest') || name.includes('Marks') || name.includes('Dalio') ||
      name.includes('Soros') || name.includes('Lynch') || name.includes('Fisher') ||
      name.includes('Douglas') || name.includes('Kiyosaki') || name.includes('Templeton') ||
      name.includes('Vanguard') || name.includes('BlackRock') || name.includes('model')) return 'reference';
  return 'shared';
}

export function SkillsPage() {
  const [skills, setSkills] = useState<Skill[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [filter, setFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [schedulerStatus, setSchedulerStatus] = useState<'online' | 'stopped' | 'unknown'>('unknown');

  useEffect(() => {
    async function load() {
      try {
        const res = await fetch('/api/skills');
        if (res.ok) {
          const data = await res.json();
          setSkills(data.skills || []);
          setSchedulerStatus(data.schedulerStatus || 'unknown');
          setError(false);
        }
      } catch (e) {
        console.error('Failed to load skills', e);
        setError(true);
      }
      setLoading(false);
    }
    load();
  }, []);

  const filtered = skills.filter(s => {
    if (filter !== 'all' && s.agent !== filter && s.category !== filter) return false;
    if (search && !s.name.toLowerCase().includes(search.toLowerCase())) return false;
    return true;
  });

  const agentCounts = skills.reduce((acc, s) => {
    acc[s.agent] = (acc[s.agent] || 0) + 1;
    return acc;
  }, {} as Record<string, number>);

  const categoryCounts = skills.reduce((acc, s) => {
    acc[s.category] = (acc[s.category] || 0) + 1;
    return acc;
  }, {} as Record<string, number>);

  return (
    <div style={{ padding: 24, fontFamily: "'Orbitron', 'Segoe UI', sans-serif", color: '#e0e0e0', minHeight: '100vh' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 24 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 700, color: '#4fc3f7', margin: 0, fontFamily: "'Orbitron', sans-serif", letterSpacing: 2 }}>
            SKILL LIBRARY
          </h1>
          <p style={{ fontSize: 13, color: '#607d8b', margin: '4px 0 0', fontFamily: "'Segoe UI', sans-serif" }}>
            {skills.length} skills across {Object.keys(agentCounts).length} agents
          </p>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
          <div style={{
            padding: '6px 14px', borderRadius: 6, fontSize: 12, fontWeight: 600, fontFamily: "'Segoe UI', sans-serif",
            background: schedulerStatus === 'online' ? 'rgba(102,187,106,0.15)' : 'rgba(239,83,80,0.15)',
            color: schedulerStatus === 'online' ? '#66bb6a' : '#ef5350',
            border: `1px solid ${schedulerStatus === 'online' ? 'rgba(102,187,106,0.3)' : 'rgba(239,83,80,0.3)'}`,
          }}>
            ● SCHEDULER {schedulerStatus === 'online' ? 'ONLINE' : schedulerStatus === 'stopped' ? 'STOPPED' : '…'}
          </div>
        </div>
      </div>

      {/* Agent Roster Bar */}
      <div style={{ display: 'flex', gap: 8, marginBottom: 16, flexWrap: 'wrap' }}>
        <button onClick={() => setFilter('all')} style={{
          padding: '6px 14px', borderRadius: 6, fontSize: 12, cursor: 'pointer', border: 'none', fontWeight: 600, fontFamily: "'Segoe UI', sans-serif",
          background: filter === 'all' ? '#4fc3f7' : '#1a3a4a', color: filter === 'all' ? '#0d1117' : '#81d4fa',
        }}>ALL ({skills.length})</button>
        {Object.entries(agentCounts).sort((a, b) => b[1] - a[1]).map(([agent, count]) => (
          <button key={agent} onClick={() => setFilter(agent)} style={{
            padding: '6px 14px', borderRadius: 6, fontSize: 12, cursor: 'pointer', border: 'none', fontWeight: 600, fontFamily: "'Segoe UI', sans-serif",
            background: filter === agent ? (AGENT_COLORS[agent] || '#455a64') : '#1a3a4a',
            color: filter === agent ? '#0d1117' : (AGENT_COLORS[agent] || '#607d8b'),
          }}>{agent.toUpperCase()} ({count})</button>
        ))}
      </div>

      {/* Category filters */}
      <div style={{ display: 'flex', gap: 8, marginBottom: 16, flexWrap: 'wrap' }}>
        {Object.entries(categoryCounts).sort((a, b) => b[1] - a[1]).map(([cat, count]) => (
          <button key={cat} onClick={() => setFilter(filter === cat ? 'all' : cat)} style={{
            padding: '4px 10px', borderRadius: 4, fontSize: 11, cursor: 'pointer', fontFamily: "'Segoe UI', sans-serif",
            border: filter === cat ? '1px solid #4fc3f7' : '1px solid #2a4a5a',
            background: filter === cat ? 'rgba(79,195,247,0.1)' : 'transparent',
            color: filter === cat ? '#4fc3f7' : '#607d8b',
          }}>{cat} ({count})</button>
        ))}
      </div>

      {/* Search */}
      <input
        type="text"
        placeholder="Search skills..."
        value={search}
        onChange={e => setSearch(e.target.value)}
        style={{
          width: '100%', maxWidth: 400, padding: '8px 14px', borderRadius: 6, marginBottom: 20,
          background: '#1a3a4a', border: '1px solid #2a4a5a', color: '#e0e0e0', fontSize: 13,
          fontFamily: "'Segoe UI', sans-serif", outline: 'none',
        }}
      />

      {/* Skills Grid */}
      {loading ? (
        <div style={{ textAlign: 'center', padding: 40, color: '#607d8b' }}>Loading skills...</div>
      ) : (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(320px, 1fr))', gap: 12 }}>
          {filtered.map(skill => {
            const agentColor = AGENT_COLORS[skill.agent] || '#455a64';
            return (
              <div key={skill.name} style={{
                background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 8, padding: 16,
                borderLeft: `3px solid ${agentColor}`, transition: 'border-color 0.2s',
              }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: 8 }}>
                  <h3 style={{
                    fontSize: 13, fontWeight: 700, color: '#e0e0e0', margin: 0,
                    fontFamily: "'Orbitron', sans-serif", letterSpacing: 0.5,
                    maxWidth: '70%', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap',
                  }}>
                    {skill.name}
                  </h3>
                  <span style={{
                    fontSize: 10, fontWeight: 600, padding: '2px 8px', borderRadius: 4,
                    background: `${agentColor}22`, color: agentColor, textTransform: 'uppercase',
                    fontFamily: "'Segoe UI', sans-serif",
                  }}>
                    {skill.agent}
                  </span>
                </div>
                <p style={{
                  fontSize: 12, color: '#607d8b', margin: '0 0 10px', lineHeight: 1.4,
                  fontFamily: "'Segoe UI', sans-serif",
                  display: '-webkit-box', WebkitLineClamp: 2, WebkitBoxOrient: 'vertical', overflow: 'hidden',
                }}>
                  {skill.description || 'No description'}
                </p>
                <div style={{ display: 'flex', gap: 8, alignItems: 'center' }}>
                  <span style={{
                    fontSize: 10, padding: '2px 6px', borderRadius: 3,
                    background: 'rgba(79,195,247,0.1)', color: '#81d4fa', fontFamily: "'Segoe UI', sans-serif",
                  }}>
                    {skill.category}
                  </span>
                  {skill.hasScripts && (
                    <span style={{
                      fontSize: 10, padding: '2px 6px', borderRadius: 3,
                      background: 'rgba(102,187,106,0.1)', color: '#66bb6a', fontFamily: "'Segoe UI', sans-serif",
                    }}>
                      has scripts
                    </span>
                  )}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}

export default SkillsPage;
