'use client';
import { useState, useEffect, useCallback } from 'react';

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
  'btc-bias-scorer':     '#f59e0b',
  'macro-strategist':    '#8b5cf6',
  'analyst':             '#3b82f6',
  'portfolio-monitor':   '#10b981',
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
  high:     '#f59e0b',
  medium:   '#6c5ce7',
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

export function MemoryPage() {
  const [memories, setMemories] = useState<Memory[]>([]);
  const [stats,    setStats]    = useState<Stats | null>(null);
  const [loading,  setLoading]  = useState(true);
  const [query,    setQuery]    = useState('');
  const [srcFilter,setSrcFilter]= useState<string>('all');
  const [impFilter,setImpFilter]= useState<string>('all');
  const [showAdd,  setShowAdd]  = useState(false);
  const [newTitle, setNewTitle] = useState('');
  const [newContent,setNewContent]=useState('');
  const [newTags,  setNewTags]  = useState('');
  const [saving,   setSaving]   = useState(false);

  const fetchMemories = useCallback(async () => {
    try {
      const res  = await fetch('/api/memory-graph', { cache: 'no-store' });
      const data = await res.json();
      if (data.success) {
        setMemories(data.memories || []);
        setStats(data.stats || null);
      }
    } catch (e) {
      console.error('Memory fetch error:', e);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchMemories();
    const t = setInterval(fetchMemories, 30000);
    return () => clearInterval(t);
  }, [fetchMemories]);

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

  // Filters
  const sources = ['all', ...Object.keys(SOURCE_COLORS)];
  const filtered = memories.filter(m => {
    const q = query.toLowerCase();
    const matchQ = !q || m.title.toLowerCase().includes(q) ||
                   m.content.toLowerCase().includes(q) ||
                   m.tags.some(t => t.toLowerCase().includes(q));
    const matchS = srcFilter === 'all' || m.source === srcFilter;
    const matchI = impFilter === 'all' || m.importance === impFilter;
    return matchQ && matchS && matchI;
  });

  if (loading) {
    return (
      <div style={{ color: '#5c5c72', fontFamily: 'monospace', padding: 40, textAlign: 'center' }}>
        Loading memories...
      </div>
    );
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 16 }}>

      {/* Stats row */}
      {stats && (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12 }}>
          {[
            { label: 'Total Memories', value: stats.total, color: '#6c5ce7' },
            { label: 'Critical',       value: stats.critical, color: '#ef4444' },
            { label: 'High Priority',  value: stats.high,     color: '#f59e0b' },
            { label: 'Sources',        value: Object.keys(stats.bySource || {}).length, color: '#10b981' },
          ].map(card => (
            <div key={card.label} style={{
              background: '#111118', border: '1px solid #1e1e2a',
              borderRadius: 10, padding: '12px 16px',
            }}>
              <div style={{ fontSize: 11, color: '#5c5c72', fontFamily: 'monospace',
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

      {/* Search + Add */}
      <div style={{ display: 'flex', gap: 10 }}>
        <input
          type="text"
          value={query}
          onChange={e => setQuery(e.target.value)}
          placeholder="Search memories..."
          style={{
            flex: 1, padding: '10px 14px',
            background: '#111118', border: '1px solid #1e1e2a',
            borderRadius: 8, color: '#e8e8ed', fontSize: 13,
            fontFamily: 'monospace', outline: 'none',
          }}
        />
        <button
          onClick={() => setShowAdd(s => !s)}
          style={{
            padding: '10px 18px', borderRadius: 8, border: 'none',
            background: '#6c5ce7', color: '#fff', cursor: 'pointer',
            fontFamily: 'monospace', fontSize: 13, fontWeight: 600,
          }}
        >
          + Add Memory
        </button>
        <button
          onClick={fetchMemories}
          style={{
            padding: '10px 14px', borderRadius: 8,
            border: '1px solid #1e1e2a', background: 'transparent',
            color: '#5c5c72', cursor: 'pointer', fontFamily: 'monospace', fontSize: 12,
          }}
        >
          ↻
        </button>
      </div>

      {/* Add memory form */}
      {showAdd && (
        <div style={{
          background: '#111118', border: '1px solid #6c5ce7',
          borderRadius: 10, padding: 16, display: 'flex', flexDirection: 'column', gap: 10,
        }}>
          <input
            placeholder="Title..."
            value={newTitle}
            onChange={e => setNewTitle(e.target.value)}
            style={{ padding: '8px 12px', background: '#0d0d14', border: '1px solid #1e1e2a',
                     borderRadius: 6, color: '#e8e8ed', fontSize: 13, fontFamily: 'monospace' }}
          />
          <textarea
            placeholder="Content..."
            value={newContent}
            onChange={e => setNewContent(e.target.value)}
            rows={3}
            style={{ padding: '8px 12px', background: '#0d0d14', border: '1px solid #1e1e2a',
                     borderRadius: 6, color: '#e8e8ed', fontSize: 13, fontFamily: 'monospace',
                     resize: 'vertical' }}
          />
          <input
            placeholder="Tags (comma separated)..."
            value={newTags}
            onChange={e => setNewTags(e.target.value)}
            style={{ padding: '8px 12px', background: '#0d0d14', border: '1px solid #1e1e2a',
                     borderRadius: 6, color: '#e8e8ed', fontSize: 13, fontFamily: 'monospace' }}
          />
          <div style={{ display: 'flex', gap: 8 }}>
            <button
              onClick={addMemory}
              disabled={saving}
              style={{ padding: '8px 18px', borderRadius: 6, border: 'none',
                       background: '#6c5ce7', color: '#fff', cursor: 'pointer',
                       fontFamily: 'monospace', fontSize: 13 }}
            >
              {saving ? 'Saving...' : 'Save'}
            </button>
            <button
              onClick={() => setShowAdd(false)}
              style={{ padding: '8px 18px', borderRadius: 6,
                       border: '1px solid #1e1e2a', background: 'transparent',
                       color: '#5c5c72', cursor: 'pointer', fontFamily: 'monospace', fontSize: 13 }}
            >
              Cancel
            </button>
          </div>
        </div>
      )}

      {/* Filters */}
      <div style={{ display: 'flex', gap: 8, flexWrap: 'wrap', alignItems: 'center' }}>
        {/* Importance filter */}
        {['all', 'critical', 'high', 'medium', 'low'].map(imp => (
          <button
            key={imp}
            onClick={() => setImpFilter(imp)}
            style={{
              padding: '4px 12px', borderRadius: 20, border: 'none',
              cursor: 'pointer', fontSize: 11, fontFamily: 'monospace', fontWeight: 600,
              background: impFilter === imp
                ? (imp === 'all' ? '#6c5ce7' : impColor(imp))
                : '#1e1e2a',
              color: impFilter === imp ? '#fff' : '#5c5c72',
            }}
          >
            {imp.toUpperCase()}
          </button>
        ))}
        <div style={{ width: 1, height: 20, background: '#1e1e2a' }} />
        {/* Source filter */}
        <select
          value={srcFilter}
          onChange={e => setSrcFilter(e.target.value)}
          style={{
            padding: '4px 10px', borderRadius: 6,
            background: '#1e1e2a', border: '1px solid #2a2a3a',
            color: '#8b8b9e', fontSize: 11, fontFamily: 'monospace', cursor: 'pointer',
          }}
        >
          <option value="all">All Sources</option>
          {Object.keys(SOURCE_COLORS).map(s => (
            <option key={s} value={s}>{s}</option>
          ))}
        </select>
        <span style={{ color: '#5c5c72', fontSize: 11, fontFamily: 'monospace' }}>
          {filtered.length} memories
        </span>
      </div>

      {/* Memory cards */}
      {filtered.length === 0 ? (
        <div style={{ textAlign: 'center', padding: 40, color: '#5c5c72', fontFamily: 'monospace', fontSize: 13 }}>
          {memories.length === 0
            ? 'No memories yet — memory writer will populate this automatically.'
            : 'No memories match your filters.'}
        </div>
      ) : (
        filtered.map(mem => (
          <div key={mem.id} style={{
            background: '#111118',
            border: `1px solid #1e1e2a`,
            borderLeft: `3px solid ${impColor(mem.importance)}`,
            borderRadius: 10, padding: '14px 16px',
          }}>
            <div style={{ display: 'flex', justifyContent: 'space-between',
                          alignItems: 'flex-start', marginBottom: 8, gap: 12 }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: 8, flexWrap: 'wrap' }}>
                <span style={{ fontSize: 14, fontWeight: 700, color: '#e8e8ed' }}>
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
                <span style={{ fontSize: 11, fontFamily: 'monospace', color: '#5c5c72' }}>
                  {timeAgo(mem.timestamp)}
                </span>
              </div>
            </div>

            <p style={{ fontSize: 13, color: '#8b8b9e', lineHeight: 1.6, marginBottom: 10 }}>
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
                    background: '#1e1e2a', color: '#5c5c72',
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
    </div>
  );
}
