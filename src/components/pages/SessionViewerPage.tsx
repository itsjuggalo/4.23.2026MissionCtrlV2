'use client';
import { useState, useEffect, useRef } from 'react';

interface LogEntry {
  timestamp: string;
  source: string;
  level: 'info' | 'warn' | 'error' | 'debug';
  message: string;
}

const LOG_SOURCES = [
  { id: 'mission-control', label: 'Mission Control', color: '#4fc3f7' },
  { id: 'signal-receiver', label: 'Signal Receiver', color: '#66bb6a' },
  { id: 'option-signals', label: 'Option Signals', color: '#ff9800' },
  { id: 'option-signals-relay', label: 'Signals Relay', color: '#ce93d8' },
  { id: 'flow-monitor', label: 'Flow Monitor', color: '#ef5350' },
  { id: 'telegram-listener', label: 'Telegram Listener', color: '#ffd54f' },
  { id: 'telegram-discord-relay', label: 'TG→Discord Relay', color: '#4db6ac' },
  { id: 'brief-forwarder', label: 'Brief Forwarder', color: '#90a4ae' },
  { id: 'coupon-claw', label: 'CouponClaw', color: '#78909c' },
  { id: 'deepseek-bot', label: 'DeepSheet Bot', color: '#ef5350' },
  { id: 'grok-bot', label: 'Groot Bot', color: '#ff9800' },
  { id: 'skill-scheduler', label: 'Skill Scheduler', color: '#607d8b' },
];

const LEVEL_COLORS: Record<string, string> = {
  info: '#4fc3f7',
  warn: '#ff9800',
  error: '#ef5350',
  debug: '#607d8b',
};

export function SessionViewerPage() {
  const [logs, setLogs] = useState<LogEntry[]>([]);
  const [selectedSources, setSelectedSources] = useState<Set<string>>(new Set(LOG_SOURCES.map(s => s.id)));
  const [levelFilter, setLevelFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [autoScroll, setAutoScroll] = useState(true);
  const [loading, setLoading] = useState(true);
  const [streaming, setStreaming] = useState(false);
  const [error, setError] = useState(false);
  const logEndRef = useRef<HTMLDivElement>(null);
  const intervalRef = useRef<NodeJS.Timeout | null>(null);

  const fetchLogs = async () => {
    try {
      const sources = Array.from(selectedSources).join(',');
      const res = await fetch(`/api/session-logs?sources=${sources}&limit=200`);
      const data = await res.json();
      setLogs(data.logs || []);
      setError(false);
      setLoading(false);
    } catch { setError(true); setLoading(false); }
  };

  useEffect(() => {
    fetchLogs();
    if (streaming) {
      intervalRef.current = setInterval(fetchLogs, 3000);
    }
    return () => { if (intervalRef.current) clearInterval(intervalRef.current); };
  }, [streaming, selectedSources]);

  useEffect(() => {
    if (autoScroll && logEndRef.current) {
      logEndRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  }, [logs, autoScroll]);

  const toggleSource = (id: string) => {
    setSelectedSources(prev => {
      const next = new Set(prev);
      if (next.has(id)) next.delete(id); else next.add(id);
      return next;
    });
  };

  const selectAll = () => setSelectedSources(new Set(LOG_SOURCES.map(s => s.id)));
  const selectNone = () => setSelectedSources(new Set());

  let filtered = logs;
  if (levelFilter !== 'all') filtered = filtered.filter(l => l.level === levelFilter);
  if (search) {
    const q = search.toLowerCase();
    filtered = filtered.filter(l => l.message.toLowerCase().includes(q) || l.source.toLowerCase().includes(q));
  }

  const getSourceColor = (src: string) => LOG_SOURCES.find(s => s.id === src)?.color || '#607d8b';

  return (
    <div style={{ padding: '24px', maxWidth: '1200px', margin: '0 auto', height: 'calc(100vh - 80px)', display: 'flex', flexDirection: 'column' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      <style>{`
        .sv-btn { padding: 4px 10px; border-radius: 4px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 10px; cursor: pointer; font-weight: 600; transition: all 0.15s; }
        .sv-btn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
        .sv-btn:hover { border-color: #4fc3f744; }
        .log-line { font-family: var(--font-mc-mono); font-size: 12px; padding: 4px 12px; border-bottom: 1px solid #0d1117; display: flex; gap: 8px; align-items: flex-start; }
        .log-line:hover { background: #4fc3f708; }
      `}</style>

      {/* Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '12px' }}>
        <div>
          <h1 style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', margin: 0 }}>SESSION VIEWER</h1>
          <p style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', margin: '4px 0 0' }}>
            {filtered.length} log entries · {selectedSources.size} sources active
          </p>
        </div>
        <div style={{ display: 'flex', gap: '8px', alignItems: 'center' }}>
          <button className={`sv-btn ${autoScroll ? 'active' : ''}`} onClick={() => setAutoScroll(!autoScroll)}>
            Auto-scroll {autoScroll ? 'ON' : 'OFF'}
          </button>
          <button className={`sv-btn ${streaming ? 'active' : ''}`} onClick={() => setStreaming(!streaming)}
            style={streaming ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a', animation: 'pulse 2s infinite' } : {}}>
            {streaming ? '● LIVE' : '○ Paused'}
          </button>
          <button className="sv-btn" onClick={fetchLogs}>Refresh</button>
        </div>
      </div>

      {/* Source filters */}
      <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '8px', alignItems: 'center' }}>
        <button className="sv-btn" onClick={selectAll}>All</button>
        <button className="sv-btn" onClick={selectNone}>None</button>
        <div style={{ width: '1px', height: '20px', background: '#1a3a4a' }} />
        {LOG_SOURCES.map(s => (
          <button key={s.id} className={`sv-btn ${selectedSources.has(s.id) ? 'active' : ''}`} onClick={() => toggleSource(s.id)}
            style={selectedSources.has(s.id) ? { background: `${s.color}22`, borderColor: s.color, color: s.color } : {}}>
            {s.label}
          </button>
        ))}
      </div>

      {/* Level + Search */}
      <div style={{ display: 'flex', gap: '8px', marginBottom: '12px', alignItems: 'center' }}>
        {['all', 'info', 'warn', 'error', 'debug'].map(l => (
          <button key={l} className={`sv-btn ${levelFilter === l ? 'active' : ''}`} onClick={() => setLevelFilter(l)}
            style={levelFilter === l && l !== 'all' ? { background: `${LEVEL_COLORS[l]}22`, borderColor: LEVEL_COLORS[l], color: LEVEL_COLORS[l] } : {}}>
            {l.toUpperCase()}
          </button>
        ))}
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search logs..."
          style={{ marginLeft: 'auto', padding: '4px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-label)', width: '200px', outline: 'none' }} />
      </div>

      {/* Log Stream */}
      <div style={{ flex: 1, background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', overflow: 'auto', minHeight: 0 }}>
        {loading ? (
          <div style={{ padding: '40px', textAlign: 'center', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>Loading logs...</div>
        ) : filtered.length === 0 ? (
          <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>No logs match filters</div>
        ) : (
          filtered.map((log, i) => (
            <div key={i} className="log-line">
              <span style={{ color: '#455a64', minWidth: '75px', flexShrink: 0 }}>
                {new Date(log.timestamp).toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) + ' ' + new Date(log.timestamp).toLocaleTimeString('en-US', { hour12: false })}
              </span>
              <span style={{ color: LEVEL_COLORS[log.level] || '#607d8b', minWidth: '40px', fontWeight: 700, flexShrink: 0 }}>
                {log.level.toUpperCase()}
              </span>
              <span style={{ color: getSourceColor(log.source), minWidth: '120px', fontWeight: 600, flexShrink: 0 }}>
                {LOG_SOURCES.find(s => s.id === log.source)?.label || log.source}
              </span>
              <span style={{ color: log.level === 'error' ? '#ef5350' : '#b0bec5', wordBreak: 'break-word' }}>
                {log.message}
              </span>
            </div>
          ))
        )}
        <div ref={logEndRef} />
      </div>
    </div>
  );
}
