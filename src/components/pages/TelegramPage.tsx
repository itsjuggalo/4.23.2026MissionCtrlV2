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
  stop_loss: number | null;
  targets: number[];
  leverage: number | null;
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
  return `${Math.floor(hrs / 24)}d ago`;
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
  for (const [key, color] of Object.entries(CHANNEL_COLORS)) {
    if (name.includes(key)) return color;
  }
  if (name.includes('Whale') || name.includes('WHALE')) return '#ef5350';
  if (name.includes('Pump') || name.includes('Volume')) return '#ff9800';
  return '#78909c';
}

function cleanChannelName(name: string): string {
  return name.replace(/[^\w\s()-]/g, '').trim().slice(0, 30);
}

export function TelegramPage() {
  const [signals, setSignals] = useState<TelegramSignal[]>([]);
  const [loading, setLoading] = useState(true);
  const [channelFilter, setChannelFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [scoreFilter, setScoreFilter] = useState<string>('0');
  const [statusFilter, setStatusFilter] = useState<string>('all');
  const [dirFilter, setDirFilter] = useState<string>('all');

  useEffect(() => {
    async function fetchSignals() {
      try {
        const res = await fetch('/api/telegram-signals');
        const data = await res.json();
        const entries = Array.isArray(data) ? data : data.signals || [];
        const cleaned = entries.filter((s: any) => {
          const text = (s.raw_text || '').toLowerCase();
          const sym = (s.symbol || '').toUpperCase();
          if (['bingx', 'deposit', 'usdt completely free', 'receive up to', 'join now', 'bonus', 'exclusive benefit', 'sign up'].some(w => text.includes(w))) return false;
          if (text.includes('\u{1f512}') || text.includes('\u{1f510}') || text.includes('🔒') || text.includes('🔐')) return false;
          if (!sym || sym === '???' || sym === 'NO' || sym === 'UNKNOWN' || sym.length < 2) return false;
          if (!s.entry && !s.direction && s.score < 15) return false;
          return true;
        });
        const deduped: any[] = [];
        const seen = new Map<string, number>();
        for (const s of cleaned) {
          const key = (s.symbol || '') + '|' + (s.channel_name || '');
          const ts = new Date(s.timestamp).getTime();
          const lastTs = seen.get(key);
          if (lastTs && Math.abs(ts - lastTs) < 600000) continue;
          seen.set(key, ts);
          deduped.push(s);
        }
        setSignals(deduped);
      } catch {}
      setLoading(false);
    }
    fetchSignals();
    const i = setInterval(fetchSignals, 30000);
    return () => clearInterval(i);
  }, []);

  const channels = [...new Set(signals.map(s => s.channel_name || 'Unknown'))].sort();
  const channelCounts: Record<string, number> = {};
  signals.forEach(s => { const ch = s.channel_name || 'Unknown'; channelCounts[ch] = (channelCounts[ch] || 0) + 1; });

  let filtered = signals;
  if (channelFilter !== 'all') filtered = filtered.filter(s => s.channel_name === channelFilter);
  if (search) { const q = search.toLowerCase(); filtered = filtered.filter(s => (s.symbol || '').toLowerCase().includes(q) || (s.raw_text || '').toLowerCase().includes(q)); }
  if (scoreFilter !== '0') filtered = filtered.filter(s => s.score >= parseInt(scoreFilter));
  if (statusFilter !== 'all') filtered = filtered.filter(s => s.status === statusFilter);
  if (dirFilter !== 'all') filtered = filtered.filter(s => s.direction === dirFilter);
  filtered.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

  const recentCount = signals.filter(s => Date.now() - new Date(s.timestamp).getTime() < 86400000).length;
  const fmtPrice = (p: number) => p < 0.01 ? `$${p.toFixed(6)}` : p < 1 ? `$${p.toFixed(4)}` : `$${p.toFixed(2)}`;

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer', outline: 'none' };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '16px' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  return (
    <div style={{ padding: '16px 20px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {/* Top Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '12px', flexWrap: 'wrap' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: '12px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>LIVE</span>
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
          {signals.length} signals · {channels.length} channels · {recentCount} last 24h
        </span>
        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />

        <select value={channelFilter} onChange={e => setChannelFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Channels ({signals.length})</option>
          {channels.map(ch => <option key={ch} value={ch}>{cleanChannelName(ch)} ({channelCounts[ch] || 0})</option>)}
        </select>

        <select value={scoreFilter} onChange={e => setScoreFilter(e.target.value)} style={selectStyle}>
          <option value="0">All Scores</option>
          <option value="40">Score 40+</option>
          <option value="70">Score 70+</option>
          <option value="85">Score 85+</option>
        </select>

        <select value={statusFilter} onChange={e => setStatusFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Status</option>
          <option value="accepted">Accepted</option>
          <option value="rejected">Rejected</option>
          <option value="pending">Pending</option>
        </select>

        <select value={dirFilter} onChange={e => setDirFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Directions</option>
          <option value="LONG">Long Only</option>
          <option value="SHORT">Short Only</option>
        </select>

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..."
          style={{ ...selectStyle, width: '100px' }} />

        <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginLeft: 'auto' }}>
          {filtered.length} of {signals.length}
        </span>
      </div>

      {/* Signal Feed — scrollable */}
      <div style={{ flex: 1, overflow: 'auto', display: 'flex', flexDirection: 'column', gap: '4px', minHeight: 0 }}>
        {filtered.length === 0 ? (
          <div style={{ padding: '60px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '14px', background: '#0a1929', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
            No signals match filters
          </div>
        ) : filtered.slice(0, 100).map((s, i) => {
          const color = getChannelColor(s.channel_name || '');
          const scoreColor = s.score >= 70 ? '#66bb6a' : s.score >= 40 ? '#ffd54f' : '#ef5350';
          const dirColor = s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#607d8b';
          const statusColor = s.status === 'accepted' ? '#66bb6a' : s.status === 'rejected' ? '#ef5350' : '#607d8b';
          const hasData = !!(s.entry || s.direction || s.stop_loss || (s.targets && s.targets.length > 0));

          return (
            <div key={s.id || i} style={{ padding: hasData ? '14px 16px' : '10px 16px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '6px', borderLeft: `3px solid ${color}`, transition: 'border-color 0.2s' }}>
              {/* Header */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: hasData ? '10px' : '0' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  {s.symbol && <span style={{ fontSize: '18px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol}</span>}
                  {s.direction && <span style={{ fontSize: '11px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>}
                  <span style={{ fontSize: '11px', color: color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{cleanChannelName(s.channel_name || 'Unknown')}</span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: '12px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${scoreColor}22`, color: scoreColor, fontFamily: 'var(--font-mc-mono)' }}>{s.score}</span>
                  <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: `${statusColor}22`, color: statusColor, fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>{s.status || 'pending'}</span>
                  <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }} title={fullTime(s.timestamp)}>{timeAgo(s.timestamp)}</span>
                </div>
              </div>

              {/* Price data */}
              {hasData && (
                <div style={{ display: 'flex', gap: '16px', fontSize: '13px', fontFamily: 'var(--font-mc-mono)' }}>
                  {s.entry && s.entry > 0 && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>ENTRY </span><span style={{ color: '#66bb6a', fontWeight: 700 }}>{fmtPrice(s.entry)}</span></span>}
                  {s.stop_loss && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>SL </span><span style={{ color: '#ef5350', fontWeight: 700 }}>${s.stop_loss}</span></span>}
                  {s.targets && s.targets.length > 0 && s.targets.slice(0, 3).map((t, ti) => (
                    <span key={ti}><span style={{ color: '#607d8b', fontSize: '10px' }}>TP{ti + 1} </span><span style={{ color: '#4fc3f7', fontWeight: 700 }}>{fmtPrice(t)}</span></span>
                  ))}
                  {s.leverage && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>LEV </span><span style={{ color: '#ff9800', fontWeight: 700 }}>{s.leverage}x</span></span>}
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
