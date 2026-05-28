'use client';
import { useState, useEffect, useCallback, useRef } from 'react';
import { COLORS, FONTS } from '@/lib/constants';

// ============================= MEMORY LIST VIEW =============================

interface Memory {
  id:         string;
  title:      string;
  content:    string;
  source:     string;
  tags:       string[];
  importance: 'low' | 'medium' | 'high' | 'critical';
  timestamp:  string;
  date:       string;
}

interface Stats {
  total:    number;
  critical: number;
  high:     number;
  bySource: Record<string, number>;
}

const SOURCE_COLORS: Record<string, string> = {
  'btc-bias-scorer':     '#ff9800',
  'macro-strategist':    '#8b5cf6',
  'analyst':             '#4fc3f7',
  'portfolio-monitor':   '#66bb6a',
  'risk-manager':        '#ef4444',
  'counter-intelligence':'#6366f1',
  'crypto-sniper':       '#06b6d4',
  'execution-specialist':'#84cc16',
  'tweak':               '#f97316',
  'telegram-listener':   '#0088cc',
  'broadcaster':         '#ec4899',
  'manual':              '#6b7280',
};

const IMPORTANCE_COLORS: Record<string, string> = {
  critical: '#ef4444',
  high:     '#ff9800',
  medium:   '#4fc3f7',
  low:      '#4b5563',
};

function sourceColor(s: string) {
  return SOURCE_COLORS[s] || '#6b7280';
}

function impColor(i: string) {
  return IMPORTANCE_COLORS[i] || '#6b7280';
}

function timeAgo(iso: string): string {
  const diff = Date.now() - new Date(iso).getTime();
  const m    = Math.floor(diff / 60000);
  if (m < 1)  return 'just now';
  if (m < 60) return `${m}m ago`;
  const h = Math.floor(m / 60);
  if (h < 24) return `${h}h ago`;
  return `${Math.floor(h / 24)}d ago`;
}

// ============================= MEMORY GRAPH VIEW =============================

interface GraphNode {
  id: string;
  name: string;
  path: string;
  type: 'root' | 'memory' | 'second-brain' | 'directives' | 'skills';
  links: string[];
  size: number;
  modified: string;
}

interface GraphEdge {
  source: string;
  target: string;
}

interface MemoryFile extends GraphNode {
  content: string;
}

interface GraphData {
  nodes: GraphNode[];
  edges: GraphEdge[];
  files: MemoryFile[];
  workspace: string;
  generated: string;
}

const TYPE_COLOR: Record<string, string> = {
  'root':         COLORS.accent,
  'memory':       COLORS.green,
  'second-brain': COLORS.blue,
  'directives':   COLORS.amber,
  'skills':       COLORS.cyan,
};

const TYPE_LABEL: Record<string, string> = {
  'root':         'Root',
  'memory':       'Memory',
  'second-brain': 'Knowledge',
  'directives':   'Directives',
  'skills':       'Skills',
};

interface Pos { x: number; y: number; vx: number; vy: number }

function initPositions(nodes: GraphNode[], w: number, h: number): Map<string, Pos> {
  const m = new Map<string, Pos>();
  nodes.forEach((n, i) => {
    const angle  = (i / (nodes.length || 1)) * 2 * Math.PI;
    const radius = Math.min(w, h) * 0.35;
    m.set(n.id, {
      x:  w / 2 + Math.cos(angle) * radius * (0.5 + Math.random() * 0.5),
      y:  h / 2 + Math.sin(angle) * radius * (0.5 + Math.random() * 0.5),
      vx: 0, vy: 0,
    });
  });
  return m;
}

function runTick(
  pos: Map<string, Pos>,
  nodes: GraphNode[],
  edges: GraphEdge[],
  w: number, h: number,
): void {
  const REPEL  = 1800;
  const SPRING = 0.012;
  const REST   = 120;
  const DAMP   = 0.82;

  for (let i = 0; i < nodes.length; i++) {
    for (let j = i + 1; j < nodes.length; j++) {
      const a = pos.get(nodes[i].id)!;
      const b = pos.get(nodes[j].id)!;
      const dx = b.x - a.x; const dy = b.y - a.y;
      const d  = Math.sqrt(dx * dx + dy * dy) || 1;
      const f  = REPEL / (d * d);
      const fx = (dx / d) * f; const fy = (dy / d) * f;
      a.vx -= fx; a.vy -= fy;
      b.vx += fx; b.vy += fy;
    }
  }
  for (const e of edges) {
    const a = pos.get(e.source); const b = pos.get(e.target);
    if (!a || !b) continue;
    const dx = b.x - a.x; const dy = b.y - a.y;
    const d  = Math.sqrt(dx * dx + dy * dy) || 1;
    const f  = (d - REST) * SPRING;
    const fx = (dx / d) * f; const fy = (dy / d) * f;
    a.vx += fx; a.vy += fy;
    b.vx -= fx; b.vy -= fy;
  }
  for (const n of nodes) {
    const p = pos.get(n.id)!;
    p.vx += (w / 2 - p.x) * 0.001;
    p.vy += (h / 2 - p.y) * 0.001;
  }
  for (const n of nodes) {
    const p = pos.get(n.id)!;
    p.vx *= DAMP; p.vy *= DAMP;
    p.x  = Math.max(30, Math.min(w - 30, p.x + p.vx));
    p.y  = Math.max(30, Math.min(h - 30, p.y + p.vy));
  }
}

function ForceGraph({
  nodes, edges, selected, onSelect,
}: {
  nodes: GraphNode[];
  edges: GraphEdge[];
  selected: string | null;
  onSelect: (id: string | null) => void;
}) {
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const posRef    = useRef<Map<string, Pos>>(new Map());
  const rafRef    = useRef<number>(0);
  const tickRef   = useRef(0);

  useEffect(() => {
    const c = canvasRef.current;
    if (!c || nodes.length === 0) return;
    posRef.current = initPositions(nodes, c.width, c.height);
    tickRef.current = 0;
  }, [nodes.length]);

  useEffect(() => {
    const c = canvasRef.current;
    if (!c) return;
    const ctx = c.getContext('2d')!;

    const animate = () => {
      const w = c.width; const h = c.height;
      const pos = posRef.current;

      if (tickRef.current < 200) {
        runTick(pos, nodes, edges, w, h);
        tickRef.current++;
      }

      ctx.clearRect(0, 0, w, h);

      ctx.lineWidth = 1;
      for (const e of edges) {
        const a = pos.get(e.source); const b = pos.get(e.target);
        if (!a || !b) continue;
        const isHighlighted = e.source === selected || e.target === selected;
        ctx.strokeStyle = isHighlighted ? 'rgba(162,155,254,0.7)' : 'rgba(30,30,42,0.9)';
        ctx.lineWidth   = isHighlighted ? 1.5 : 1;
        ctx.beginPath();
        ctx.moveTo(a.x, a.y);
        ctx.lineTo(b.x, b.y);
        ctx.stroke();
      }

      for (const n of nodes) {
        const p = pos.get(n.id);
        if (!p) continue;
        const r     = n.id === selected ? 10 : 7;
        const color = TYPE_COLOR[n.type] || COLORS.accent;
        const isSelected = n.id === selected;

        if (isSelected) {
          ctx.shadowBlur  = 16;
          ctx.shadowColor = color;
        }
        ctx.beginPath();
        ctx.arc(p.x, p.y, r, 0, Math.PI * 2);
        ctx.fillStyle   = color;
        ctx.globalAlpha = isSelected ? 1 : 0.85;
        ctx.fill();
        ctx.globalAlpha = 1;
        ctx.shadowBlur  = 0;

        ctx.font      = `${isSelected ? 11 : 10}px Inter, sans-serif`;
        ctx.fillStyle = isSelected ? '#e0e0e0' : '#455a64';
        ctx.textAlign = 'center';
        ctx.fillText(n.name.length > 18 ? n.name.slice(0, 16) + '…' : n.name, p.x, p.y + r + 13);
      }

      rafRef.current = requestAnimationFrame(animate);
    };

    rafRef.current = requestAnimationFrame(animate);
    return () => cancelAnimationFrame(rafRef.current);
  }, [nodes, edges, selected]);

  const handleClick = (e: React.MouseEvent<HTMLCanvasElement>) => {
    const c = canvasRef.current;
    if (!c) return;
    const rect = c.getBoundingClientRect();
    const mx   = (e.clientX - rect.left) * (c.width / rect.width);
    const my   = (e.clientY - rect.top)  * (c.height / rect.height);
    const pos  = posRef.current;
    let closest: string | null = null;
    let minD = 20;
    for (const n of nodes) {
      const p = pos.get(n.id);
      if (!p) continue;
      const d = Math.sqrt((p.x - mx) ** 2 + (p.y - my) ** 2);
      if (d < minD) { minD = d; closest = n.id; }
    }
    onSelect(closest === selected ? null : closest);
  };

  return (
    <canvas
      ref={canvasRef}
      width={680}
      height={520}
      onClick={handleClick}
      style={{
        cursor:      'crosshair',
        borderRadius: 8,
        background:   '#050508',
        display:      'block',
        width:        '100%',
        height:       'auto',
      }}
    />
  );
}

// ============================= MAIN MEMORY PAGE =============================

export function MemoryPage() {
  const [activeTab, setActiveTab] = useState<'list' | 'graph'>('graph');

  // List state
  const [memories, setMemories] = useState<Memory[]>([]);
  const [stats,    setStats]    = useState<Stats | null>(null);
  const [, setLoading]  = useState(true);
  const [query,    setQuery]    = useState('');
  const [srcFilter,setSrcFilter]= useState<string>('all');
  const [impFilter,setImpFilter]= useState<string>('all');
  const [showAdd,  setShowAdd]  = useState(false);
  const [newTitle, setNewTitle] = useState('');
  const [newContent,setNewContent]=useState('');
  const [newTags,  setNewTags]  = useState('');
  const [saving,   setSaving]   = useState(false);

  // Graph state
  const [graphData, setGraphData] = useState<GraphData | null>(null);
  const [graphLoading, setGraphLoading] = useState(true);
  const [selected, setSelected] = useState<string | null>(null);
  const [filter,   setFilter]   = useState<string>('all');
  const [search,   setSearch]   = useState('');
  const [error,    setError]    = useState(false);

  const fetchMemories = useCallback(async () => {
    try {
      const res  = await fetch('/api/memory-graph', { cache: 'no-store' });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      if (data.success) {
        setMemories(data.memories || []);
        setStats(data.stats || null);
        setError(false);
      }
    } catch (e) {
      console.error('Memory fetch error:', e);
      setError(true);
    } finally {
      setLoading(false);
    }
  }, []);

  const fetchGraphData = useCallback(async () => {
    try {
      const r = await fetch('/api/memory-graph');
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      const d = await r.json();
      setGraphData(d);
    } catch { /* silent */ }
    finally { setGraphLoading(false); }
  }, []);

  useEffect(() => {
    fetchMemories();
    fetchGraphData();
    const t = setInterval(() => {
      fetchMemories();
      fetchGraphData();
    }, 30000);
    return () => clearInterval(t);
  }, [fetchMemories, fetchGraphData]);

  const addMemory = async () => {
    if (!newTitle.trim() || !newContent.trim()) return;
    setSaving(true);
    try {
      await fetch('/api/memory-graph', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          title:   newTitle,
          content: newContent,
          tags:    newTags.split(',').map(t => t.trim()).filter(Boolean),
        }),
      });
      setNewTitle(''); setNewContent(''); setNewTags('');
      setShowAdd(false);
      fetchMemories();
    } finally {
      setSaving(false);
    }
  };

  const filtered = memories.filter(m => {
    const q = query.toLowerCase();
    const matchQ = !q || m.title.toLowerCase().includes(q) ||
                   m.content.toLowerCase().includes(q) ||
                   m.tags.some(t => t.toLowerCase().includes(q));
    const matchS = srcFilter === 'all' || m.source === srcFilter;
    const matchI = impFilter === 'all' || m.importance === impFilter;
    return matchQ && matchS && matchI;
  });

  const selectedFile = graphData?.files.find(f => f.id === selected);

  const filteredNodes = (graphData?.nodes ?? []).filter(n => {
    if (filter !== 'all' && n.type !== filter) return false;
    if (search && !n.name.toLowerCase().includes(search.toLowerCase())) return false;
    return true;
  });

  const filteredEdges = (graphData?.edges ?? []).filter(
    e => filteredNodes.some(n => n.id === e.source) &&
         filteredNodes.some(n => n.id === e.target)
  );

  const typeCounts = (graphData?.nodes ?? []).reduce<Record<string, number>>((acc, n) => {
    acc[n.type] = (acc[n.type] || 0) + 1;
    return acc;
  }, {});

  const relTime = (iso: string) => {
    const diff = Math.floor((Date.now() - new Date(iso).getTime()) / 1000);
    if (diff < 60)   return `${diff}s ago`;
    if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
    if (diff < 86400)return `${Math.floor(diff / 3600)}h ago`;
    return `${Math.floor(diff / 86400)}d ago`;
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 16 }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}

      {/* Tab switcher */}
      <div style={{ display: 'flex', gap: 8 }}>
        <button
          onClick={() => setActiveTab('list')}
          style={{
            padding: '8px 16px', borderRadius: 8, border: 'none',
            background: activeTab === 'list' ? '#4fc3f7' : '#1a3a4a',
            color: activeTab === 'list' ? '#fff' : '#607d8b',
            cursor: 'pointer', fontFamily: 'monospace', fontSize: 13, fontWeight: 600,
          }}
        >
          📋 Memory List
        </button>
        <button
          onClick={() => setActiveTab('graph')}
          style={{
            padding: '8px 16px', borderRadius: 8, border: 'none',
            background: activeTab === 'graph' ? '#4fc3f7' : '#1a3a4a',
            color: activeTab === 'graph' ? '#fff' : '#607d8b',
            cursor: 'pointer', fontFamily: 'monospace', fontSize: 13, fontWeight: 600,
          }}
        >
          🧠 Knowledge Graph
        </button>
      </div>

      {/* LIST VIEW */}
      {activeTab === 'list' && (
        <>
          {stats && (
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12 }}>
              {[
                { label: 'Total Memories', value: stats.total, color: '#4fc3f7' },
                { label: 'Critical',       value: stats.critical, color: '#ef4444' },
                { label: 'High Priority',  value: stats.high,     color: '#ff9800' },
                { label: 'Sources',        value: Object.keys(stats.bySource || {}).length, color: '#66bb6a' },
              ].map(card => (
                <div key={card.label} style={{
                  background: '#111118', border: '1px solid #1a3a4a',
                  borderRadius: 10, padding: '12px 16px',
                }}>
                  <div style={{ fontSize: 11, color: '#607d8b', fontFamily: 'monospace',
                                textTransform: 'uppercase', letterSpacing: '0.5px' }}>
                    {card.label}
                  </div>
                  <div style={{ fontSize: 24, fontWeight: 700, color: card.color, marginTop: 4 }}>
                    {card.value}
                  </div>
                </div>
              ))}
            </div>
          )}

          <div style={{ display: 'flex', gap: 10 }}>
            <input
              type="text"
              value={query}
              onChange={e => setQuery(e.target.value)}
              placeholder="Search memories..."
              style={{
                flex: 1, padding: '10px 14px',
                background: '#111118', border: '1px solid #1a3a4a',
                borderRadius: 8, color: '#e0e0e0', fontSize: 13,
                fontFamily: 'monospace', outline: 'none',
              }}
            />
            <button
              onClick={() => setShowAdd(s => !s)}
              style={{
                padding: '10px 18px', borderRadius: 8, border: 'none',
                background: '#4fc3f7', color: '#fff', cursor: 'pointer',
                fontFamily: 'monospace', fontSize: 13, fontWeight: 600,
              }}
            >
              + Add Memory
            </button>
            <button
              onClick={fetchMemories}
              style={{
                padding: '10px 14px', borderRadius: 8,
                border: '1px solid #1a3a4a', background: 'transparent',
                color: '#607d8b', cursor: 'pointer', fontFamily: 'monospace', fontSize: 12,
              }}
            >
              ↻
            </button>
          </div>

          {showAdd && (
            <div style={{
              background: '#111118', border: '1px solid #4fc3f7',
              borderRadius: 10, padding: 16, display: 'flex', flexDirection: 'column', gap: 10,
            }}>
              <input
                placeholder="Title..."
                value={newTitle}
                onChange={e => setNewTitle(e.target.value)}
                style={{ padding: '8px 12px', background: '#0d1117', border: '1px solid #1a3a4a',
                         borderRadius: 6, color: '#e0e0e0', fontSize: 13, fontFamily: 'monospace' }}
              />
              <textarea
                placeholder="Content..."
                value={newContent}
                onChange={e => setNewContent(e.target.value)}
                rows={3}
                style={{ padding: '8px 12px', background: '#0d1117', border: '1px solid #1a3a4a',
                         borderRadius: 6, color: '#e0e0e0', fontSize: 13, fontFamily: 'monospace',
                         resize: 'vertical' }}
              />
              <input
                placeholder="Tags (comma separated)..."
                value={newTags}
                onChange={e => setNewTags(e.target.value)}
                style={{ padding: '8px 12px', background: '#0d1117', border: '1px solid #1a3a4a',
                         borderRadius: 6, color: '#e0e0e0', fontSize: 13, fontFamily: 'monospace' }}
              />
              <div style={{ display: 'flex', gap: 8 }}>
                <button
                  onClick={addMemory}
                  disabled={saving}
                  style={{ padding: '8px 18px', borderRadius: 6, border: 'none',
                           background: '#4fc3f7', color: '#fff', cursor: 'pointer',
                           fontFamily: 'monospace', fontSize: 13 }}
                >
                  {saving ? 'Saving...' : 'Save'}
                </button>
                <button
                  onClick={() => setShowAdd(false)}
                  style={{ padding: '8px 18px', borderRadius: 6,
                           border: '1px solid #1a3a4a', background: 'transparent',
                           color: '#607d8b', cursor: 'pointer', fontFamily: 'monospace', fontSize: 13 }}
                >
                  Cancel
                </button>
              </div>
            </div>
          )}

          <div style={{ display: 'flex', gap: 8, flexWrap: 'wrap', alignItems: 'center' }}>
            {['all', 'critical', 'high', 'medium', 'low'].map(imp => (
              <button
                key={imp}
                onClick={() => setImpFilter(imp)}
                style={{
                  padding: '4px 12px', borderRadius: 20, border: 'none',
                  cursor: 'pointer', fontSize: 11, fontFamily: 'monospace', fontWeight: 600,
                  background: impFilter === imp
                    ? (imp === 'all' ? '#4fc3f7' : impColor(imp))
                    : '#1a3a4a',
                  color: impFilter === imp ? '#fff' : '#607d8b',
                }}
              >
                {imp.toUpperCase()}
              </button>
            ))}
            <div style={{ width: 1, height: 20, background: '#1a3a4a' }} />
            <select
              value={srcFilter}
              onChange={e => setSrcFilter(e.target.value)}
              style={{
                padding: '4px 10px', borderRadius: 6,
                background: '#1a3a4a', border: '1px solid #2a2a3a',
                color: '#455a64', fontSize: 11, fontFamily: 'monospace', cursor: 'pointer',
              }}
            >
              <option value="all">All Sources</option>
              {Object.keys(SOURCE_COLORS).map(s => (
                <option key={s} value={s}>{s}</option>
              ))}
            </select>
            <span style={{ color: '#607d8b', fontSize: 11, fontFamily: 'monospace' }}>
              {filtered.length} memories
            </span>
          </div>

          {filtered.length === 0 ? (
            <div style={{ textAlign: 'center', padding: 40, color: '#607d8b', fontFamily: 'monospace', fontSize: 13 }}>
              {memories.length === 0
                ? 'No memories yet — memory writer will populate this automatically.'
                : 'No memories match your filters.'}
            </div>
          ) : (
            filtered.map(mem => (
              <div key={mem.id} style={{
                background: '#111118',
                border: `1px solid #1a3a4a`,
                borderLeft: `3px solid ${impColor(mem.importance)}`,
                borderRadius: 10, padding: '14px 16px',
              }}>
                <div style={{ display: 'flex', justifyContent: 'space-between',
                              alignItems: 'flex-start', marginBottom: 8, gap: 12 }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 8, flexWrap: 'wrap' }}>
                    <span style={{ fontSize: 14, fontWeight: 700, color: '#e0e0e0' }}>
                      {mem.title}
                    </span>
                    <span style={{
                      fontSize: 10, fontFamily: 'monospace', fontWeight: 700,
                      padding: '1px 8px', borderRadius: 10,
                      background: `${impColor(mem.importance)}22`,
                      color: impColor(mem.importance),
                    }}>
                      {mem.importance.toUpperCase()}
                    </span>
                  </div>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 8, flexShrink: 0 }}>
                    <span style={{
                      fontSize: 10, fontFamily: 'monospace', fontWeight: 600,
                      padding: '2px 8px', borderRadius: 8,
                      background: `${sourceColor(mem.source)}22`,
                      color: sourceColor(mem.source),
                    }}>
                      {mem.source}
                    </span>
                    <span style={{ fontSize: 11, fontFamily: 'monospace', color: '#607d8b' }}>
                      {timeAgo(mem.timestamp)}
                    </span>
                  </div>
                </div>

                <p style={{ fontSize: 13, color: '#455a64', lineHeight: 1.6, marginBottom: 10 }}>
                  {mem.content}
                </p>

                <div style={{ display: 'flex', gap: 6, flexWrap: 'wrap' }}>
                  {mem.tags.map(tag => (
                    <span
                      key={tag}
                      onClick={() => setQuery(tag)}
                      style={{
                        fontSize: 10, fontFamily: 'monospace',
                        padding: '2px 8px', borderRadius: 8,
                        background: '#1a3a4a', color: '#607d8b',
                        cursor: 'pointer', border: '1px solid #2a2a3a',
                      }}
                    >
                      #{tag}
                    </span>
                  ))}
                </div>
              </div>
            ))
          )}
        </>
      )}

      {/* GRAPH VIEW */}
      {activeTab === 'graph' && (
        <div style={{ fontFamily: FONTS.sans, color: COLORS.text, display: 'flex', flexDirection: 'column', gap: 20 }}>

          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: 12 }}>
            <div>
              <h2 style={{ margin: 0, fontSize: 18, fontWeight: 700, fontFamily: FONTS.mono, color: COLORS.text }}>
                🧠 Memory Graph
              </h2>
              <p style={{ margin: '4px 0 0', fontSize: 12, color: COLORS.textMuted }}>
                {graphData ? `${graphData.nodes.length} notes · ${graphData.edges.length} links · workspace: ${graphData.workspace}` : 'Loading…'}
              </p>
            </div>
            <button
              onClick={fetchGraphData}
              style={{
                background: 'rgba(108,92,231,0.12)', border: '1px solid rgba(108,92,231,0.3)',
                color: COLORS.accentLight, fontSize: 12, padding: '6px 14px',
                borderRadius: 6, cursor: 'pointer', fontFamily: FONTS.mono,
              }}
            >
              ↻ Refresh
            </button>
          </div>

          <div style={{ display: 'flex', alignItems: 'center', gap: 6, flexWrap: 'wrap' }}>
            {(['all', 'root', 'memory', 'second-brain', 'directives'] as const).map(t => (
              <button
                key={t}
                onClick={() => setFilter(t)}
                style={{
                  padding: '5px 12px', fontSize: 11, borderRadius: 6, cursor: 'pointer',
                  fontFamily: FONTS.mono, border: 'none',
                  background: filter === t
                    ? (t === 'all' ? COLORS.accent : TYPE_COLOR[t] || COLORS.accent)
                    : COLORS.bgSurface,
                  color: filter === t ? '#fff' : COLORS.textMuted,
                  opacity: filter === t ? 1 : 0.7,
                }}
              >
                {t === 'all' ? `All (${graphData?.nodes.length ?? 0})` : `${TYPE_LABEL[t] ?? t} (${typeCounts[t] ?? 0})`}
              </button>
            ))}
            <input
              value={search}
              onChange={e => setSearch(e.target.value)}
              placeholder="Search nodes…"
              style={{
                marginLeft: 'auto', padding: '5px 12px', fontSize: 12,
                background: COLORS.bgSurface, border: `1px solid ${COLORS.border}`,
                borderRadius: 6, color: COLORS.text, fontFamily: FONTS.sans, outline: 'none', width: 160,
              }}
            />
          </div>

          <div style={{ display: 'grid', gridTemplateColumns: '1fr 340px', gap: 16, alignItems: 'start' }}>

            <div style={{
              background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
              borderRadius: 12, padding: 16, overflow: 'hidden',
            }}>
              {graphLoading ? (
                <div style={{ height: 400, display: 'flex', alignItems: 'center', justifyContent: 'center', color: COLORS.textDim, fontSize: 13 }}>
                  Loading knowledge graph…
                </div>
              ) : filteredNodes.length === 0 ? (
                <div style={{ height: 400, display: 'flex', alignItems: 'center', justifyContent: 'center', color: COLORS.textDim, fontSize: 13 }}>
                  No nodes match current filter
                </div>
              ) : (
                <ForceGraph
                  nodes={filteredNodes}
                  edges={filteredEdges}
                  selected={selected}
                  onSelect={setSelected}
                />
              )}
            </div>

            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>

              {selectedFile ? (
                <div style={{
                  background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
                  borderRadius: 12, padding: 16,
                }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: 10 }}>
                    <div>
                      <div style={{ fontSize: 14, fontWeight: 700, color: TYPE_COLOR[selectedFile.type] || COLORS.accent, marginBottom: 2 }}>
                        {selectedFile.name}
                      </div>
                      <div style={{ fontSize: 11, color: COLORS.textDim, fontFamily: FONTS.mono }}>
                        {selectedFile.path}
                      </div>
                    </div>
                    <button onClick={() => setSelected(null)} style={{
                      background: 'none', border: 'none', color: COLORS.textDim,
                      cursor: 'pointer', fontSize: 16, lineHeight: 1,
                    }}>×</button>
                  </div>

                  <div style={{ fontSize: 11, color: COLORS.textMuted, marginBottom: 10 }}>
                    Modified {relTime(selectedFile.modified)} · {(selectedFile.size / 1024).toFixed(1)} KB
                  </div>

                  {selectedFile.links.length > 0 && (
                    <div style={{ marginBottom: 10 }}>
                      <div style={{ fontSize: 10, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 5 }}>Links</div>
                      <div style={{ display: 'flex', flexWrap: 'wrap', gap: 4 }}>
                        {selectedFile.links.map(l => (
                          <span key={l} style={{
                            background: 'rgba(108,92,231,0.12)', color: COLORS.accentLight,
                            fontSize: 10, padding: '2px 7px', borderRadius: 4, fontFamily: FONTS.mono,
                            cursor: 'pointer',
                          }}
                            onClick={() => {
                              const target = graphData?.nodes.find(n => n.name.toLowerCase() === l.toLowerCase());
                              if (target) setSelected(target.id);
                            }}
                          >
                            [[{l}]]
                          </span>
                        ))}
                      </div>
                    </div>
                  )}

                  <div style={{
                    background: '#050508', borderRadius: 6, padding: 10,
                    fontSize: 11, fontFamily: FONTS.mono, color: COLORS.textMuted,
                    whiteSpace: 'pre-wrap', overflowY: 'auto', maxHeight: 260,
                    lineHeight: 1.6, wordBreak: 'break-word',
                  }}>
                    {selectedFile.content || '(empty)'}
                  </div>
                </div>
              ) : (
                <div style={{
                  background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
                  borderRadius: 12, padding: 20, color: COLORS.textDim, fontSize: 12, textAlign: 'center',
                }}>
                  Click a node to view its content
                </div>
              )}

              <div style={{
                background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
                borderRadius: 12, padding: 16, maxHeight: 280, overflowY: 'auto',
              }}>
                <div style={{ fontSize: 11, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 10 }}>
                  All Notes
                </div>
                {(graphData?.nodes ?? [])
                  .sort((a, b) => new Date(b.modified).getTime() - new Date(a.modified).getTime())
                  .map(n => (
                    <div
                      key={n.id}
                      onClick={() => setSelected(n.id === selected ? null : n.id)}
                      style={{
                        padding: '6px 8px', borderRadius: 6, cursor: 'pointer',
                        background: n.id === selected ? 'rgba(108,92,231,0.1)' : 'transparent',
                        display: 'flex', alignItems: 'center', gap: 8, marginBottom: 2,
                      }}
                    >
                      <span style={{
                        width: 6, height: 6, borderRadius: '50%', flexShrink: 0,
                        background: TYPE_COLOR[n.type] || COLORS.accent,
                      }} />
                      <span style={{ fontSize: 12, color: n.id === selected ? COLORS.text : COLORS.textMuted, flex: 1, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                        {n.name}
                      </span>
                      <span style={{ fontSize: 10, color: COLORS.textDim, flexShrink: 0 }}>
                        {relTime(n.modified)}
                      </span>
                    </div>
                  ))}
              </div>
            </div>
          </div>

          <div style={{
            background: 'rgba(108,92,231,0.06)', border: '1px solid rgba(108,92,231,0.2)',
            borderRadius: 8, padding: '10px 14px', fontSize: 12, color: COLORS.textMuted,
          }}>
            💡 <strong style={{ color: COLORS.accentLight }}>Obsidian tip:</strong> Open your vault at{' '}
            <code style={{ fontFamily: FONTS.mono, background: COLORS.bgSurface, padding: '1px 5px', borderRadius: 3 }}>
              ~/.openclaw/workspace
            </code>{' '}
            — enable Graph View (Ctrl+G) and the Dataview plugin for a full knowledge graph experience.
          </div>
        </div>
      )}
    </div>
  );
}
