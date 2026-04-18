'use client';
import { useState, useEffect } from 'react';

interface Task {
  id: string;
  title: string;
  description: string;
  status: 'backlog' | 'active' | 'review' | 'done';
  priority: 'critical' | 'high' | 'medium' | 'low';
  agent?: string;
  created: string;
  updated: string;
}

const PRIORITY_COLORS: Record<string, string> = {
  critical: '#ef5350', high: '#ff9800', medium: '#4fc3f7', low: '#66bb6a',
};

const COLUMN_CONFIG = [
  { key: 'backlog' as const, label: 'BACKLOG', color: '#607d8b' },
  { key: 'active' as const, label: 'IN PROGRESS', color: '#4fc3f7' },
  { key: 'review' as const, label: 'REVIEW', color: '#ff9800' },
  { key: 'done' as const, label: 'DONE', color: '#66bb6a' },
];

function timeAgo(ts: string): string {
  const diff = Date.now() - new Date(ts).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'just now';
  if (mins < 60) return `${mins}m ago`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h ago`;
  const days = Math.floor(hrs / 24);
  return `${days}d ago`;
}

const DEFAULT_TASKS: Task[] = [
  { id: '1', title: 'Pine Script Strategies', description: 'Holy Grail, DayTrader v1, Grid Bot v1 — build and deploy on TradingView', status: 'backlog', priority: 'high', agent: 'Boba', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '2', title: '30m SuperTrend Layer', description: 'Add 30-minute SuperTrend as second signal layer alongside 1H', status: 'backlog', priority: 'medium', agent: 'Boba', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '3', title: 'Massage Therapy Website', description: 'Marketing site on second Oracle Cloud instance with nginx + NoIP DNS', status: 'backlog', priority: 'medium', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '4', title: 'Boba Brief Prompt Upgrade', description: 'Sonnet should get the best brief prompt — currently same as others', status: 'backlog', priority: 'high', agent: 'Boba', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '5', title: 'WebSocket Real-Time Updates', description: 'Replace polling with SSE/WebSocket for live data push on dashboard', status: 'backlog', priority: 'medium', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '6', title: 'Wallet Page — Complete', description: 'All 5 wallets live with full position data, avg cost, return %', status: 'done', priority: 'critical', created: '2026-04-17T00:00:00Z', updated: '2026-04-18T00:00:00Z' },
  { id: '7', title: 'SQLite Database', description: '8 tables, 282 trades, daily snapshots, agent metrics', status: 'done', priority: 'critical', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '8', title: 'SuperTrend Auto-Trader', description: 'Signal receiver + auto-trader pipeline with Discord/Telegram alerts', status: 'done', priority: 'critical', agent: 'Boba', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '9', title: 'Hybrid Brief System', description: '5 daily briefs with real market data, no hallucinations', status: 'done', priority: 'high', agent: 'Boba', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '10', title: 'Security Hardening', description: 'Secrets consolidated, chmod 600, nginx blocks, wallet auth', status: 'done', priority: 'high', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
  { id: '11', title: 'Rotate Exposed Keys', description: 'Hyperliquid private key shared in chat — rotate ASAP', status: 'active', priority: 'critical', created: '2026-04-18T00:00:00Z', updated: '2026-04-18T00:00:00Z' },
  { id: '12', title: 'Signals + Telegram Pages', description: 'Clean up expired signals, build Telegram page with channel filters', status: 'active', priority: 'high', created: '2026-04-18T00:00:00Z', updated: '2026-04-18T00:00:00Z' },
  { id: '13', title: 'Wire Remaining Pages', description: 'Scanner, Risk, Office pages — apply Terran theme', status: 'backlog', priority: 'medium', created: '2026-04-18T00:00:00Z', updated: '2026-04-18T00:00:00Z' },
  { id: '14', title: 'Hardcoded API Keys', description: '4 source files still have hardcoded keys — extract to secrets', status: 'active', priority: 'high', created: '2026-04-17T00:00:00Z', updated: '2026-04-17T00:00:00Z' },
];

export function TasksPage() {
  const [tasks, setTasks] = useState<Task[]>(DEFAULT_TASKS);
  const [adding, setAdding] = useState(false);
  const [newTitle, setNewTitle] = useState('');
  const [newDesc, setNewDesc] = useState('');
  const [newPriority, setNewPriority] = useState<Task['priority']>('medium');
  const [dragId, setDragId] = useState<string | null>(null);

  const moveTask = (id: string, newStatus: Task['status']) => {
    setTasks(prev => prev.map(t => t.id === id ? { ...t, status: newStatus, updated: new Date().toISOString() } : t));
  };

  const addTask = () => {
    if (!newTitle.trim()) return;
    const task: Task = {
      id: String(Date.now()),
      title: newTitle.trim(),
      description: newDesc.trim(),
      status: 'backlog',
      priority: newPriority,
      created: new Date().toISOString(),
      updated: new Date().toISOString(),
    };
    setTasks(prev => [...prev, task]);
    setNewTitle(''); setNewDesc(''); setAdding(false);
  };

  const deleteTask = (id: string) => {
    setTasks(prev => prev.filter(t => t.id !== id));
  };

  return (
    <div style={{ padding: '24px' }}>
      <style>{`
        .kb-col { background: #0a192911; border-radius: 8px; padding: 12px; min-height: 300px; }
        .kb-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; padding: 14px; margin-bottom: 8px; cursor: grab; transition: border-color 0.2s, transform 0.1s; }
        .kb-card:hover { border-color: #4fc3f744; }
        .kb-card.dragging { opacity: 0.5; transform: scale(0.95); }
        .kb-col.dragover { background: #4fc3f711; border: 1px dashed #4fc3f744; }
      `}</style>

      {/* Header + Add Button */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
        <div>
          <h1 style={{ fontSize: '20px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', margin: 0 }}>MISSION BOARD</h1>
          <p style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', margin: '4px 0 0' }}>
            {tasks.filter(t => t.status === 'done').length}/{tasks.length} completed
          </p>
        </div>
        <button onClick={() => setAdding(!adding)} style={{ padding: '8px 18px', background: '#4fc3f722', border: '1px solid #4fc3f744', borderRadius: '6px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', fontWeight: 700, cursor: 'pointer', letterSpacing: '1px' }}>
          {adding ? 'CANCEL' : '+ NEW TASK'}
        </button>
      </div>

      {/* Add Task Form */}
      {adding && (
        <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '20px', marginBottom: '20px' }}>
          <input value={newTitle} onChange={e => setNewTitle(e.target.value)} placeholder="Task title..."
            style={{ width: '100%', padding: '10px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '14px', marginBottom: '10px', outline: 'none', boxSizing: 'border-box' }} />
          <input value={newDesc} onChange={e => setNewDesc(e.target.value)} placeholder="Description..."
            style={{ width: '100%', padding: '10px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', marginBottom: '10px', outline: 'none', boxSizing: 'border-box' }} />
          <div style={{ display: 'flex', gap: '8px', alignItems: 'center' }}>
            {(['critical', 'high', 'medium', 'low'] as const).map(p => (
              <button key={p} onClick={() => setNewPriority(p)}
                style={{ padding: '4px 12px', borderRadius: '4px', border: newPriority === p ? `1px solid ${PRIORITY_COLORS[p]}` : '1px solid #1a3a4a', background: newPriority === p ? `${PRIORITY_COLORS[p]}22` : 'transparent', color: newPriority === p ? PRIORITY_COLORS[p] : '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', cursor: 'pointer', fontWeight: 600, textTransform: 'uppercase' }}>
                {p}
              </button>
            ))}
            <button onClick={addTask} style={{ marginLeft: 'auto', padding: '8px 20px', background: '#66bb6a22', border: '1px solid #66bb6a44', borderRadius: '6px', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', fontWeight: 700, cursor: 'pointer' }}>
              ADD
            </button>
          </div>
        </div>
      )}

      {/* Kanban Board */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '12px' }}>
        {COLUMN_CONFIG.map(col => {
          const colTasks = tasks.filter(t => t.status === col.key).sort((a, b) => {
            const order = { critical: 0, high: 1, medium: 2, low: 3 };
            return order[a.priority] - order[b.priority];
          });
          return (
            <div key={col.key} className="kb-col"
              onDragOver={e => { e.preventDefault(); e.currentTarget.classList.add('dragover'); }}
              onDragLeave={e => { e.currentTarget.classList.remove('dragover'); }}
              onDrop={e => { e.currentTarget.classList.remove('dragover'); if (dragId) moveTask(dragId, col.key); setDragId(null); }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '12px', paddingBottom: '8px', borderBottom: `2px solid ${col.color}44` }}>
                <span style={{ fontSize: '12px', fontWeight: 700, color: col.color, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>{col.label}</span>
                <span style={{ fontSize: '11px', fontWeight: 700, padding: '1px 7px', borderRadius: '10px', background: `${col.color}22`, color: col.color, fontFamily: 'var(--font-mc-mono)' }}>{colTasks.length}</span>
              </div>
              {colTasks.map(task => (
                <div key={task.id} className={`kb-card ${dragId === task.id ? 'dragging' : ''}`}
                  draggable onDragStart={() => setDragId(task.id)} onDragEnd={() => setDragId(null)}
                  style={{ borderLeft: `3px solid ${PRIORITY_COLORS[task.priority]}` }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '6px' }}>
                    <span style={{ fontSize: '14px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', lineHeight: '1.3' }}>{task.title}</span>
                    <button onClick={() => deleteTask(task.id)} style={{ background: 'none', border: 'none', color: '#455a64', cursor: 'pointer', fontSize: '14px', padding: '0 0 0 8px', lineHeight: 1 }}>x</button>
                  </div>
                  {task.description && (
                    <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', lineHeight: '1.4', marginBottom: '8px', maxHeight: '40px', overflow: 'hidden' }}>
                      {task.description}
                    </div>
                  )}
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                    <div style={{ display: 'flex', gap: '6px', alignItems: 'center' }}>
                      <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: `${PRIORITY_COLORS[task.priority]}22`, color: PRIORITY_COLORS[task.priority], fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>{task.priority}</span>
                      {task.agent && <span style={{ fontSize: '9px', padding: '2px 6px', borderRadius: '3px', background: '#4fc3f722', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{task.agent}</span>}
                    </div>
                    <span style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(task.updated)}</span>
                  </div>
                  {/* Move buttons */}
                  <div style={{ display: 'flex', gap: '4px', marginTop: '8px' }}>
                    {COLUMN_CONFIG.filter(c => c.key !== col.key).map(c => (
                      <button key={c.key} onClick={() => moveTask(task.id, c.key)}
                        style={{ flex: 1, padding: '3px', borderRadius: '3px', border: `1px solid ${c.color}33`, background: 'transparent', color: c.color, fontFamily: 'var(--font-mc-mono)', fontSize: '9px', cursor: 'pointer', fontWeight: 600 }}>
                        {c.label.slice(0, 3)}
                      </button>
                    ))}
                  </div>
                </div>
              ))}
            </div>
          );
        })}
      </div>
    </div>
  );
}
