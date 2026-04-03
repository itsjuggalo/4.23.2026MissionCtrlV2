'use client';

import { useState, useEffect, useCallback, useRef } from 'react';
import { COLORS, FONTS } from '@/lib/constants';

// ── Types ─────────────────────────────────────────────────────────────────────

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

// ── Colours per node type ─────────────────────────────────────────────────────

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

// ── Mini force-layout (no external dep) ──────────────────────────────────────

interface Pos { x: number; y: number; vx: number; vy: number }

function initPositions(nodes: GraphNode[], w: number, h: number): Map<string, Pos> {
  const m = new Map<string, Pos>();
  nodes.forEach((n, i) => {
    const angle  = (i / nodes.length) * 2 * Math.PI;
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

  // Repulsion
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
  // Spring attraction along edges
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
  // Centre gravity
  for (const n of nodes) {
    const p = pos.get(n.id)!;
    p.vx += (w / 2 - p.x) * 0.001;
    p.vy += (h / 2 - p.y) * 0.001;
  }
  // Integrate
  for (const n of nodes) {
    const p = pos.get(n.id)!;
    p.vx *= DAMP; p.vy *= DAMP;
    p.x  = Math.max(30, Math.min(w - 30, p.x + p.vx));
    p.y  = Math.max(30, Math.min(h - 30, p.y + p.vy));
  }
}

// ── Canvas graph component ────────────────────────────────────────────────────

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

  // Init positions when nodes change
  useEffect(() => {
    const c = canvasRef.current;
    if (!c || nodes.length === 0) return;
    posRef.current = initPositions(nodes, c.width, c.height);
    tickRef.current = 0;
  }, [nodes.length]); // eslint-disable-line

  // Animation loop
  useEffect(() => {
    const c = canvasRef.current;
    if (!c) return;
    const ctx = c.getContext('2d')!;

    const animate = () => {
      const w = c.width; const h = c.height;
      const pos = posRef.current;

      // Run physics for first 200 ticks
      if (tickRef.current < 200) {
        runTick(pos, nodes, edges, w, h);
        tickRef.current++;
      }

      // Draw
      ctx.clearRect(0, 0, w, h);

      // Edges
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

      // Nodes
      for (const n of nodes) {
        const p = pos.get(n.id);
        if (!p) continue;
        const r     = n.id === selected ? 10 : 7;
        const color = TYPE_COLOR[n.type] || COLORS.accent;
        const isSelected = n.id === selected;

        // Glow for selected
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

        // Label
        ctx.font      = `${isSelected ? 11 : 10}px Inter, sans-serif`;
        ctx.fillStyle = isSelected ? '#e8e8ed' : '#8b8b9e';
        ctx.textAlign = 'center';
        ctx.fillText(n.name.length > 18 ? n.name.slice(0, 16) + '…' : n.name, p.x, p.y + r + 13);
      }

      rafRef.current = requestAnimationFrame(animate);
    };

    rafRef.current = requestAnimationFrame(animate);
    return () => cancelAnimationFrame(rafRef.current);
  }, [nodes, edges, selected]);

  // Click to select
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

// ── Main page ─────────────────────────────────────────────────────────────────

export function MemoryGraphPage() {
  const [data,     setData]     = useState<GraphData | null>(null);
  const [loading,  setLoading]  = useState(true);
  const [selected, setSelected] = useState<string | null>(null);
  const [filter,   setFilter]   = useState<string>('all');
  const [search,   setSearch]   = useState('');

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch('/api/memory-graph');
      const d = await r.json();
      setData(d);
    } catch { /* silent */ }
    finally { setLoading(false); }
  }, []);

  useEffect(() => { fetchData(); }, [fetchData]);

  const selectedFile = data?.files.find(f => f.id === selected);

  const filteredNodes = (data?.nodes ?? []).filter(n => {
    if (filter !== 'all' && n.type !== filter) return false;
    if (search && !n.name.toLowerCase().includes(search.toLowerCase())) return false;
    return true;
  });

  const filteredEdges = (data?.edges ?? []).filter(
    e => filteredNodes.some(n => n.id === e.source) &&
         filteredNodes.some(n => n.id === e.target)
  );

  const typeCounts = (data?.nodes ?? []).reduce<Record<string, number>>((acc, n) => {
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
    <div style={{ fontFamily: FONTS.sans, color: COLORS.text, display: 'flex', flexDirection: 'column', gap: 20 }}>

      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: 12 }}>
        <div>
          <h2 style={{ margin: 0, fontSize: 18, fontWeight: 700, fontFamily: FONTS.mono, color: COLORS.text }}>
            🧠 Memory Graph
          </h2>
          <p style={{ margin: '4px 0 0', fontSize: 12, color: COLORS.textMuted }}>
            {data ? `${data.nodes.length} notes · ${data.edges.length} links · workspace: ${data.workspace}` : 'Loading…'}
          </p>
        </div>
        <button
          onClick={fetchData}
          style={{
            background: 'rgba(108,92,231,0.12)', border: '1px solid rgba(108,92,231,0.3)',
            color: COLORS.accentLight, fontSize: 12, padding: '6px 14px',
            borderRadius: 6, cursor: 'pointer', fontFamily: FONTS.mono,
          }}
        >
          ↻ Refresh
        </button>
      </div>

      {/* Legend + filter tabs */}
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
            {t === 'all' ? `All (${data?.nodes.length ?? 0})` : `${TYPE_LABEL[t] ?? t} (${typeCounts[t] ?? 0})`}
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

      {/* Main layout */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 340px', gap: 16, alignItems: 'start' }}>

        {/* Graph */}
        <div style={{
          background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
          borderRadius: 12, padding: 16, overflow: 'hidden',
        }}>
          {loading ? (
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

        {/* Side panel */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>

          {/* Selected file */}
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
                          const target = data?.nodes.find(n => n.name.toLowerCase() === l.toLowerCase());
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

          {/* File tree */}
          <div style={{
            background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
            borderRadius: 12, padding: 16, maxHeight: 280, overflowY: 'auto',
          }}>
            <div style={{ fontSize: 11, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 10 }}>
              All Notes
            </div>
            {(data?.nodes ?? [])
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

      {/* Obsidian setup tip */}
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
  );
}
