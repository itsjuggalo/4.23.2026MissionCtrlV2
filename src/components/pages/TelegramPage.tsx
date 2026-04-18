'use client';
import { useState, useEffect } from 'react';

interface TelegramSignal {
  id: string;
  channel_name: string;
  timestamp: string;
  raw_text: string;
  symbol: string;
  direction: string | null;
  entry: number | null;
  score: number;
  status: string;
}

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

function fullTime(ts: string): string {
  const d = new Date(ts);
  return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) + ' ' +
    d.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit' });
}

const CHANNEL_COLORS: Record<string, string> = {
  'Coin Sonar V2': '#4fc3f7',
  'AICryptoSignals': '#66bb6a',
  'Ai Golden Crypto': '#ffd54f',
  'xCrypto Signals': '#ce93d8',
  'Ai Crypto Signals (Auto Bot)': '#4db6ac',
};

function getChannelColor(name: string): string {
  if (name in CHANNEL_COLORS) return CHANNEL_COLORS[name];
  if (name.includes('Whale') || name.includes('WHALE')) return '#ef5350';
  if (name.includes('Pump') || name.includes('Volume')) return '#ff9800';
  return '#78909c';
}

export function TelegramPage() {
  const [signals, setSignals] = useState<TelegramSignal[]>([]);
  const [loading, setLoading] = useState(true);
  const [filter, setFilter] = useState<string>('all');
  const [search, setSearch] = useState('');

  useEffect(() => {
    async function fetchSignals() {
      try {
        const res = await fetch('/api/telegram-signals');
        const data = await res.json();
        const entries = Array.isArray(data) ? data : data.signals || [];
        setSignals(entries);
      } catch {}
      setLoading(false);
    }
    fetchSignals();
    const i = setInterval(fetchSignals, 30000);
    return () => clearInterval(i);
  }, []);

  // Get unique channels
  const channels = [...new Set(signals.map(s => s.channel_name || 'Unknown'))].sort();

  // Filter
  let filtered = signals;
  if (filter !== 'all') {
    filtered = filtered.filter(s => s.channel_name === filter);
  }
  if (search) {
    const q = search.toLowerCase();
    filtered = filtered.filter(s =>
      (s.symbol || '').toLowerCase().includes(q) ||
      (s.raw_text || '').toLowerCase().includes(q)
    );
  }

  // Sort newest first
  filtered.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

  // Stats
  const totalSignals = signals.length;
  const channelCount = channels.length;
  const recentCount = signals.filter(s => Date.now() - new Date(s.timestamp).getTime() < 86400000).length;
  const highScoreCount = signals.filter(s => s.score >= 70).length;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: '16px' }}>
      <style>{`
        .tcard { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; transition: border-color 0.2s; }
        .tcard:hover { border-color: #4fc3f744; }
      `}</style>

      {/* Stats Row */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '12px' }}>
        {[
          { label: 'TOTAL SIGNALS', value: totalSignals, color: '#4fc3f7' },
          { label: 'CHANNELS', value: channelCount, color: '#ce93d8' },
          { label: 'LAST 24H', value: recentCount, color: '#66bb6a' },
          { label: 'HIGH SCORE (70+)', value: highScoreCount, color: '#ffd54f' },
        ].map((m, i) => (
          <div key={i} className="tcard" style={{ padding: '16px 20px', textAlign: 'center' }}>
            <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: '28px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Channel Filter + Search */}
      <div style={{ display: 'flex', gap: '12px', alignItems: 'center', flexWrap: 'wrap' }}>
        <button onClick={() => setFilter('all')}
          style={{ padding: '6px 14px', borderRadius: '6px', border: filter === 'all' ? '1px solid #4fc3f7' : '1px solid #1a3a4a', background: filter === 'all' ? '#4fc3f722' : 'transparent', color: filter === 'all' ? '#4fc3f7' : '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer', fontWeight: 600 }}>
          ALL ({totalSignals})
        </button>
        {channels.map(ch => {
          const count = signals.filter(s => s.channel_name === ch).length;
          const color = getChannelColor(ch);
          const shortName = ch.replace(/[^\w\s]/g, '').trim().slice(0, 20);
          return (
            <button key={ch} onClick={() => setFilter(ch)}
              style={{ padding: '6px 14px', borderRadius: '6px', border: filter === ch ? `1px solid ${color}` : '1px solid #1a3a4a', background: filter === ch ? `${color}22` : 'transparent', color: filter === ch ? color : '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', cursor: 'pointer', fontWeight: filter === ch ? 600 : 400 }}>
              {shortName} ({count})
            </button>
          );
        })}
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search symbol..."
          style={{ marginLeft: 'auto', padding: '6px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', width: '160px', outline: 'none' }} />
      </div>

      {/* Signal Feed */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: '8px' }}>
        {filtered.length === 0 ? (
          <div className="tcard" style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '14px' }}>
            No signals match filters
          </div>
        ) : filtered.slice(0, 100).map((s, i) => {
          const color = getChannelColor(s.channel_name || '');
          const scoreColor = s.score >= 70 ? '#66bb6a' : s.score >= 40 ? '#ffd54f' : '#ef5350';
          const dirColor = s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#607d8b';

          return (
            <div key={s.id || i} className="tcard" style={{ padding: '14px 18px', borderLeft: `3px solid ${color}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '8px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
                  {s.symbol && (
                    <span style={{ fontSize: '16px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol}</span>
                  )}
                  {s.direction && (
                    <span style={{ fontSize: '11px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>
                  )}
                  {s.entry && s.entry > 0 && (
                    <span style={{ fontSize: '13px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>@ ${s.entry.toFixed(s.entry < 1 ? 4 : 2)}</span>
                  )}
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
                  <span style={{ fontSize: '11px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${scoreColor}22`, color: scoreColor, fontFamily: 'var(--font-mc-mono)' }}>
                    {s.score}
                  </span>
                  <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }} title={fullTime(s.timestamp)}>
                    {timeAgo(s.timestamp)}
                  </span>
                </div>
              </div>
              <div style={{ fontSize: '12px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', lineHeight: '1.5', whiteSpace: 'pre-wrap', maxHeight: '60px', overflow: 'hidden' }}>
                {s.raw_text?.slice(0, 200) || ''}
              </div>
              <div style={{ marginTop: '8px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <span style={{ fontSize: '10px', color: color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>
                  {(s.channel_name || 'Unknown').replace(/[^\w\s]/g, '').trim().slice(0, 30)}
                </span>
                {s.status && s.status !== 'pending' && (
                  <span style={{ fontSize: '10px', color: s.status === 'accepted' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                    {s.status.toUpperCase()}
                  </span>
                )}
              </div>
            </div>
          );
        })}
      </div>

      {filtered.length > 100 && (
        <div style={{ textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', padding: '10px' }}>
          Showing 100 of {filtered.length} signals
        </div>
      )}
    </div>
  );
}
