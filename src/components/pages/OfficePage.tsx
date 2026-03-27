'use client';

import { useState, useEffect, useCallback } from 'react';

interface AgentPM2 {
  name: string;
  status: string;
  memMb: number;
  cpu: number;
  uptime: string;
  lastLog: string;
  restarts: number;
  pid: number;
}

interface Agent {
  id: string;
  name: string;
  pm2Name: string;
  role: string;
  emoji: string;
  color: string;
  deskX: number;
  deskY: number;
  status: string;
  lastLog: string;
  memMb: number;
  uptime: string;
  isBusy: boolean;
}

const AGENT_CONFIG = [
  { id: 'eric', name: 'Eric', pm2Name: 'telegram-listener', role: 'Signal Filter', emoji: '🔍', color: '#3B82F6', deskX: 60, deskY: 80 },
  { id: 'analyst', name: 'Analyst', pm2Name: 'analyst', role: 'Technical Analysis', emoji: '📊', color: '#10B981', deskX: 220, deskY: 80 },
  { id: 'risk', name: 'Risk Mgr', pm2Name: 'risk-manager', role: 'Capital Protection', emoji: '⚖️', color: '#EF4444', deskX: 380, deskY: 80 },
  { id: 'macro', name: 'Macro', pm2Name: 'macro-strategist', role: 'Macro Environment', emoji: '🌍', color: '#F59E0B', deskX: 540, deskY: 80 },
  { id: 'executor', name: 'Executor', pm2Name: 'executor', role: 'Trade Execution', emoji: '⚡', color: '#6366F1', deskX: 60, deskY: 240 },
  { id: 'portfolio', name: 'Portfolio', pm2Name: 'portfolio-monitor', role: 'Portfolio Tracking', emoji: '💰', color: '#14B8A6', deskX: 220, deskY: 240 },
  { id: 'sniper', name: 'Sniper', pm2Name: 'crypto-sniper', role: 'Token Detection', emoji: '🎯', color: '#00FF88', deskX: 380, deskY: 240 },
  { id: 'auditor', name: 'Auditor', pm2Name: 'auditor', role: 'Performance Review', emoji: '📝', color: '#F97316', deskX: 540, deskY: 240 },
  { id: 'shield', name: 'Shield', pm2Name: 'counter-intel', role: 'Counter-Intelligence', emoji: '🛡️', color: '#FF0040', deskX: 60, deskY: 400 },
  { id: 'psych', name: 'Psych', pm2Name: 'psychtechologist', role: 'Behavioral Finance', emoji: '🧠', color: '#8B5CF6', deskX: 220, deskY: 400 },
  { id: 'broadcaster', name: 'Broadcast', pm2Name: 'broadcaster', role: 'External Updates', emoji: '📢', color: '#EC4899', deskX: 380, deskY: 400 },
  { id: 'codex', name: 'Codex', pm2Name: 'codex-expert', role: 'System Health', emoji: '🔧', color: '#06B6D4', deskX: 540, deskY: 400 },
];

const FONT = "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace";

function PixelCharacter({ x, y, color, isBusy, status, frame }: {
  x: number; y: number; color: string; isBusy: boolean; status: string; frame: number;
}) {
  const isOnline = status === 'online';
  const bounce = isBusy ? Math.sin(frame * 0.15) * 2 : 0;
  const headY = y - 24 + bounce;
  return (
    <g opacity={isOnline ? 1 : 0.4}>
      <ellipse cx={x} cy={y + 4} rx={8} ry={3} fill="rgba(0,0,0,0.3)" />
      <rect x={x - 6} y={y - 12} width={12} height={14} rx={2} fill={color} />
      <rect x={x - 5} y={headY} width={10} height={10} rx={3} fill="#e8e8ed" />
      {isOnline ? (
        <>
          <rect x={x - 3} y={headY + 3} width={2} height={2} rx={0.5} fill="#111118" />
          <rect x={x + 1} y={headY + 3} width={2} height={2} rx={0.5} fill="#111118" />
        </>
      ) : (
        <>
          <text x={x - 3} y={headY + 6} fontSize={4} fill="#ff4757" fontWeight={700}>×</text>
          <text x={x + 1} y={headY + 6} fontSize={4} fill="#ff4757" fontWeight={700}>×</text>
        </>
      )}
      {isBusy && isOnline && [0, 1, 2].map(i => (
        <circle key={i} cx={x + 12 + i * 4} cy={headY - 2 - i * 2} r={1.5} fill={color} opacity={frame % 3 === i ? 1 : 0.3} />
      ))}
    </g>
  );
}

function Desk({ x, y, color, name, isOnline }: {
  x: number; y: number; color: string; name: string; isOnline: boolean;
}) {
  return (
    <g>
      <rect x={x - 30} y={y + 6} width={60} height={6} rx={1} fill="#1a1a24" stroke="#2a2a3a" strokeWidth={0.5} />
      <rect x={x - 28} y={y + 12} width={3} height={10} fill="#1a1a24" />
      <rect x={x + 25} y={y + 12} width={3} height={10} fill="#1a1a24" />
      <rect x={x - 12} y={y - 8} width={24} height={14} rx={1} fill="#0a0a0f" stroke={isOnline ? color + '60' : '#2a2a3a'} strokeWidth={0.5} />
      {isOnline && <rect x={x - 10} y={y - 6} width={20} height={10} rx={0.5} fill={color} opacity={0.15} />}
      <rect x={x - 2} y={y + 6} width={4} height={2} fill="#2a2a3a" />
      <rect x={x - 20} y={y + 24} width={40} height={10} rx={3} fill={`${color}15`} stroke={`${color}30`} strokeWidth={0.5} />
      <text x={x} y={y + 31} fontSize={6} fontFamily={FONT} fontWeight={600} fill={color} textAnchor="middle">{name}</text>
    </g>
  );
}

function SpeechBubble({ x, y, text, color }: { x: number; y: number; text: string; color: string }) {
  if (!text || text === '—') return null;
  const display = text.length > 32 ? text.slice(0, 32) + '…' : text;
  const w = Math.min(Math.max(display.length * 4.5, 60), 150);
  return (
    <g>
      <rect x={x - w / 2} y={y - 22} width={w} height={16} rx={6} fill="#111118" stroke={`${color}40`} strokeWidth={0.5} />
      <polygon points={`${x - 3},${y - 6} ${x + 3},${y - 6} ${x},${y - 2}`} fill="#111118" />
      <text x={x} y={y - 12} fontSize={5} fontFamily={FONT} fill="#8b8b9e" textAnchor="middle">{display}</text>
    </g>
  );
}

function ActivityFeed({ agents }: { agents: Agent[] }) {
  const activities = agents
    .filter(a => a.lastLog && a.lastLog !== '—' && a.status === 'online')
    .map(a => ({ name: a.name, emoji: a.emoji, color: a.color, action: a.lastLog.length > 55 ? a.lastLog.slice(0, 55) + '…' : a.lastLog }))
    .slice(0, 8);
  return (
    <div style={{ width: 250, background: '#111118', border: '1px solid #1e1e2a', borderRadius: 10, padding: 14, flexShrink: 0, maxHeight: 560, overflowY: 'auto' }}>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 12 }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
          <span style={{ fontSize: 12 }}>⚡</span>
          <span style={{ fontSize: 12, fontFamily: FONT, fontWeight: 700, color: '#e8e8ed' }}>Live Activity</span>
        </div>
        <span style={{ fontSize: 9, fontFamily: FONT, color: '#5c5c72' }}>Last hour</span>
      </div>
      <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
        {activities.map((a, i) => (
          <div key={i} style={{ display: 'flex', gap: 8, alignItems: 'flex-start' }}>
            <span style={{ fontSize: 14, flexShrink: 0, marginTop: 1 }}>{a.emoji}</span>
            <div>
              <span style={{ fontSize: 11, fontFamily: FONT, fontWeight: 600, color: a.color }}>{a.name}</span>
              <div style={{ fontSize: 10, color: '#8b8b9e', lineHeight: 1.4, marginTop: 2 }}>{a.action}</div>
              <div style={{ fontSize: 9, fontFamily: FONT, color: '#5c5c72', marginTop: 2 }}>less than a minute ago</div>
            </div>
          </div>
        ))}
        {activities.length === 0 && <div style={{ fontSize: 11, color: '#5c5c72', textAlign: 'center', padding: 20 }}>No recent activity</div>}
      </div>
    </div>
  );
}

function AgentBar({ agents, selectedId, onSelect }: { agents: Agent[]; selectedId: string | null; onSelect: (id: string) => void }) {
  return (
    <div style={{ display: 'grid', gridTemplateColumns: 'repeat(6, 1fr)', gap: 6, marginTop: 12 }}>
      {agents.map(a => (
        <button key={a.id} onClick={() => onSelect(a.id)} style={{
          background: selectedId === a.id ? `${a.color}15` : '#111118',
          border: `1px solid ${selectedId === a.id ? a.color + '40' : '#1e1e2a'}`,
          borderRadius: 8, padding: '8px 6px', cursor: 'pointer', textAlign: 'left',
        }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
            <span style={{ fontSize: 14 }}>{a.emoji}</span>
            <span style={{ fontSize: 10, fontFamily: FONT, fontWeight: 600, color: '#e8e8ed' }}>{a.name}</span>
            <div style={{
              width: 6, height: 6, borderRadius: '50%', marginLeft: 'auto', flexShrink: 0,
              background: a.status === 'online' ? '#00d2a0' : a.status === 'stopped' ? '#ffa502' : '#ff4757',
            }} />
          </div>
          <div style={{ fontSize: 9, color: '#5c5c72', marginTop: 3, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
            {a.status === 'online' ? (a.lastLog !== '—' ? a.lastLog.slice(0, 28) : a.role) : a.status}
          </div>
        </button>
      ))}
    </div>
  );
}

export function OfficePage() {
  const [agents, setAgents] = useState<Agent[]>(AGENT_CONFIG.map(c => ({ ...c, status: 'unknown', lastLog: '—', memMb: 0, uptime: '—', isBusy: false })));
  const [selectedId, setSelectedId] = useState<string | null>(null);
  const [frame, setFrame] = useState(0);

  useEffect(() => { const i = setInterval(() => setFrame(f => f + 1), 300); return () => clearInterval(i); }, []);

  const fetchData = useCallback(async () => {
    try {
      const res = await fetch('/api/agents');
      if (!res.ok) return;
      const json = await res.json(); const data: AgentPM2[] = json.agents || json || [];
      setAgents(prev => prev.map(agent => {
        const proc = data.find((p: any) => p.id === agent.pm2Name);
        if (proc) return { ...agent, status: proc.status, lastLog: (proc as any).stats?.lastLog || proc.lastLog || '—', memMb: (proc as any).stats?.memMb || proc.memMb || 0, uptime: (proc as any).stats?.uptime || proc.uptime || '—', isBusy: ((proc as any).stats?.lastLog || '—') !== '—' && proc.status === 'online' };
        if (agent.pm2Name === 'psychtechologist') return { ...agent, status: 'online', lastLog: 'Ready for Commander', memMb: 0, uptime: '∞', isBusy: false };
        return agent;
      }));
    } catch { /* ignore */ }
  }, []);

  useEffect(() => { fetchData(); const i = setInterval(fetchData, 15000); return () => clearInterval(i); }, [fetchData]);

  const selectedAgent = agents.find(a => a.id === selectedId) || null;
  const onlineCount = agents.filter(a => a.status === 'online').length;

  return (
    <div style={{ display: 'flex', gap: 16 }}>
      <div style={{ flex: 1, minWidth: 0 }}>
        {/* Header */}
        <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 14 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 6, background: '#111118', border: '1px solid #1e1e2a', borderRadius: 8, padding: '6px 12px' }}>
            <div style={{ width: 7, height: 7, borderRadius: '50%', background: '#00d2a0', boxShadow: '0 0 6px #00d2a0' }} />
            <span style={{ fontSize: 11, fontFamily: FONT, color: '#00d2a0', fontWeight: 600 }}>{onlineCount}/{agents.length} ONLINE</span>
          </div>
        </div>

        {/* Office SVG */}
        <div style={{ background: '#0a0a0f', border: '1px solid #1e1e2a', borderRadius: 12, overflow: 'hidden', position: 'relative' }}>
          <svg viewBox="0 0 700 520" style={{ width: '100%', display: 'block' }}>
            {/* Grid */}
            <defs>
              <pattern id="grid" width="40" height="40" patternUnits="userSpaceOnUse">
                <path d="M 40 0 L 0 0 0 40" fill="none" stroke="#1e1e2a" strokeWidth="0.3" opacity="0.3" />
              </pattern>
            </defs>
            <rect width="700" height="520" fill="url(#grid)" />

            {/* Commander */}
            <rect x={260} y={8} width={180} height={30} rx={6} fill="#FFD70008" stroke="#FFD70030" strokeWidth={0.5} strokeDasharray="4 2" />
            <text x={350} y={27} fontSize={8} fontFamily={FONT} fontWeight={700} fill="#FFD700" textAnchor="middle">👑 COMMANDER&apos;S OFFICE</text>

            {/* Row labels */}
            <text x={10} y={130} fontSize={7} fontFamily={FONT} fill="#2a2a3a" letterSpacing={1}>INTEL</text>
            <text x={10} y={290} fontSize={7} fontFamily={FONT} fill="#2a2a3a" letterSpacing={1}>OPS</text>
            <text x={10} y={450} fontSize={7} fontFamily={FONT} fill="#2a2a3a" letterSpacing={1}>SUPPORT</text>

            {/* Dividers */}
            <line x1={40} y1={190} x2={660} y2={190} stroke="#2a2a3a" strokeWidth={0.3} strokeDasharray="6 4" opacity={0.4} />
            <line x1={40} y1={350} x2={660} y2={350} stroke="#2a2a3a" strokeWidth={0.3} strokeDasharray="6 4" opacity={0.4} />

            {/* Plants */}
            <text x={680} y={130} fontSize={14}>🌿</text>
            <text x={680} y={290} fontSize={14}>🌱</text>
            <text x={680} y={450} fontSize={14}>🪴</text>

            {/* Conference table */}
            <ellipse cx={350} cy={280} rx={40} ry={16} fill="#16161f" stroke="#2a2a3a" strokeWidth={0.5} />

            {/* Agents */}
            {agents.map((agent, idx) => (
              <g key={agent.id} onClick={() => setSelectedId(selectedId === agent.id ? null : agent.id)} style={{ cursor: 'pointer' }}>
                <Desk x={agent.deskX + 30} y={agent.deskY + 30} color={agent.color} name={agent.name} isOnline={agent.status === 'online'} />
                <PixelCharacter x={agent.deskX + 30} y={agent.deskY + 16} color={agent.color} isBusy={agent.isBusy} status={agent.status} frame={frame + idx} />
                {agent.status === 'online' && agent.lastLog !== '—' && (
                  <SpeechBubble x={agent.deskX + 30} y={agent.deskY - 10} text={agent.lastLog} color={agent.color} />
                )}
                {selectedId === agent.id && (
                  <rect x={agent.deskX - 5} y={agent.deskY - 35} width={70} height={100} rx={8} fill="none" stroke={agent.color} strokeWidth={1.5} strokeDasharray="4 2" opacity={0.5} />
                )}
              </g>
            ))}
          </svg>

          {/* Selected agent panel */}
          {selectedAgent && (
            <div style={{
              position: 'absolute', bottom: 0, left: 0, right: 0, background: '#111118',
              borderTop: `2px solid ${selectedAgent.color}`, borderRadius: '12px 12px 0 0',
              padding: 16, display: 'flex', alignItems: 'center', gap: 16, zIndex: 10,
            }}>
              <div style={{ width: 48, height: 48, borderRadius: 12, background: `${selectedAgent.color}15`, border: `1px solid ${selectedAgent.color}30`, display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: 24, flexShrink: 0 }}>{selectedAgent.emoji}</div>
              <div style={{ flex: 1, minWidth: 0 }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
                  <span style={{ fontSize: 15, fontWeight: 700, color: '#e8e8ed' }}>{selectedAgent.name}</span>
                  <span style={{ fontSize: 9, fontFamily: FONT, padding: '2px 8px', borderRadius: 4, background: selectedAgent.status === 'online' ? '#00d2a018' : '#ff475718', color: selectedAgent.status === 'online' ? '#00d2a0' : '#ff4757', fontWeight: 600 }}>{selectedAgent.status?.toUpperCase()}</span>
                </div>
                <div style={{ fontSize: 11, color: selectedAgent.color, fontFamily: FONT, marginTop: 2 }}>{selectedAgent.role}</div>
                <div style={{ fontSize: 10, color: '#8b8b9e', marginTop: 4, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{selectedAgent.lastLog}</div>
              </div>
              <div style={{ display: 'flex', gap: 16, flexShrink: 0 }}>
                <div style={{ textAlign: 'center' }}><div style={{ fontSize: 8, fontFamily: FONT, color: '#5c5c72' }}>MEM</div><div style={{ fontSize: 13, fontFamily: FONT, fontWeight: 600, color: '#e8e8ed' }}>{selectedAgent.memMb}mb</div></div>
                <div style={{ textAlign: 'center' }}><div style={{ fontSize: 8, fontFamily: FONT, color: '#5c5c72' }}>UP</div><div style={{ fontSize: 13, fontFamily: FONT, fontWeight: 600, color: '#e8e8ed' }}>{selectedAgent.uptime}</div></div>
              </div>
              <button onClick={() => setSelectedId(null)} style={{ background: 'rgba(255,255,255,0.05)', border: '1px solid #2a2a3a', borderRadius: 6, color: '#5c5c72', cursor: 'pointer', width: 28, height: 28, display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: 14, flexShrink: 0 }}>✕</button>
            </div>
          )}
        </div>

        {/* Agent bar */}
        <AgentBar agents={agents} selectedId={selectedId} onSelect={id => setSelectedId(selectedId === id ? null : id)} />
      </div>

      {/* Activity feed */}
      <ActivityFeed agents={agents} />
    </div>
  );
}
