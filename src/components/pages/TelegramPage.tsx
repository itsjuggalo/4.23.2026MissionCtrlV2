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
  const [filter, setFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [scoreFilter, setScoreFilter] = useState<number>(0);
  const [statusFilter, setStatusFilter] = useState<string>('all');

  useEffect(() => {
    async function fetchSignals() {
      try {
        const res = await fetch('/api/telegram-signals');
        const data = await res.json();
        const entries = Array.isArray(data) ? data : data.signals || [];
        // Filter out junk
        const cleaned = entries.filter((s: any) => {
          const text = (s.raw_text || '').toLowerCase();
          const sym = (s.symbol || '').toUpperCase();
          // Remove promos
          if (['bingx', 'deposit', 'usdt completely free', 'receive up to', 'join now', 'bonus', 'exclusive benefit', 'sign up'].some(w => text.includes(w))) return false;
          // Remove locked content
          if (text.includes('\u{1f512}') || text.includes('\u{1f510}') || text.includes('🔒') || text.includes('🔐')) return false;
          // Remove no-symbol entries
          if (!sym || sym === '???' || sym === 'NO' || sym === 'UNKNOWN' || sym.length < 2) return false;
          // Remove entries with no useful data
          if (!s.entry && !s.direction && s.score < 15) return false;
          return true;
        });

        // Deduplicate: same symbol + same channel within 10 minutes
        const deduped: any[] = [];
        const seen = new Map<string, number>();
        for (const s of cleaned) {
          const key = (s.symbol || '') + '|' + (s.channel_name || '');
          const ts = new Date(s.timestamp).getTime();
          const lastTs = seen.get(key);
          if (lastTs && Math.abs(ts - lastTs) < 600000) continue; // skip if within 10 min
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

  let filtered = signals;
  if (filter !== 'all') filtered = filtered.filter(s => s.channel_name === filter);
  if (search) {
    const q = search.toLowerCase();
    filtered = filtered.filter(s => (s.symbol || '').toLowerCase().includes(q) || (s.raw_text || '').toLowerCase().includes(q));
  }
  if (scoreFilter > 0) filtered = filtered.filter(s => s.score >= scoreFilter);
  if (statusFilter !== 'all') filtered = filtered.filter(s => s.status === statusFilter);

  filtered.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

  const totalSignals = signals.length;
  const channelCount = channels.length;
  const recentCount = signals.filter(s => Date.now() - new Date(s.timestamp).getTime() < 86400000).length;
  const highScoreCount = signals.filter(s => s.score >= 70).length;
  const acceptedCount = signals.filter(s => s.status === 'accepted').length;
  const rejectedCount = signals.filter(s => s.status === 'rejected').length;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .tcard { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; transition: border-color 0.2s; }
        .tcard:hover { border-color: #4fc3f744; }
        .tbtn { padding: 6px 12px; border-radius: 6px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 11px; cursor: pointer; font-weight: 600; transition: all 0.15s; }
        .tbtn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
      `}</style>

      {/* Stats */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(6, 1fr)', gap: '10px', marginBottom: '20px' }}>
        {[
          { label: 'TOTAL', value: totalSignals, color: '#4fc3f7' },
          { label: 'CHANNELS', value: channelCount, color: '#ce93d8' },
          { label: 'LAST 24H', value: recentCount, color: recentCount > 0 ? '#66bb6a' : '#ef5350' },
          { label: 'SCORE 70+', value: highScoreCount, color: '#ffd54f' },
          { label: 'ACCEPTED', value: acceptedCount, color: '#66bb6a' },
          { label: 'REJECTED', value: rejectedCount, color: '#ef5350' },
        ].map((m, i) => (
          <div key={i} className="tcard" style={{ padding: '14px', textAlign: 'center' }}>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>{m.label}</div>
            <div style={{ fontSize: '24px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Channel Filters */}
      <div style={{ display: 'flex', gap: '8px', alignItems: 'center', flexWrap: 'wrap', marginBottom: '12px' }}>
        <button className={`tbtn ${filter === 'all' ? 'active' : ''}`} onClick={() => setFilter('all')}>
          ALL ({totalSignals})
        </button>
        {channels.map(ch => {
          const count = signals.filter(s => s.channel_name === ch).length;
          const color = getChannelColor(ch);
          return (
            <button key={ch} className={`tbtn ${filter === ch ? 'active' : ''}`} onClick={() => setFilter(ch)}
              style={filter === ch ? { background: `${color}22`, borderColor: color, color: color } : {}}>
              {cleanChannelName(ch)} ({count})
            </button>
          );
        })}
      </div>

      {/* Score + Status + Search */}
      <div style={{ display: 'flex', gap: '8px', alignItems: 'center', flexWrap: 'wrap', marginBottom: '16px' }}>
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Score:</span>
        {[0, 40, 70].map(s => (
          <button key={s} className={`tbtn ${scoreFilter === s ? 'active' : ''}`} onClick={() => setScoreFilter(s)}>
            {s === 0 ? 'All' : `${s}+`}
          </button>
        ))}
        <div style={{ width: '1px', height: '24px', background: '#1a3a4a', margin: '0 4px' }} />
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Status:</span>
        {['all', 'accepted', 'rejected', 'pending'].map(s => (
          <button key={s} className={`tbtn ${statusFilter === s ? 'active' : ''}`} onClick={() => setStatusFilter(s)}
            style={statusFilter === s && s === 'accepted' ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } :
                   statusFilter === s && s === 'rejected' ? { background: '#ef535022', borderColor: '#ef5350', color: '#ef5350' } : {}}>
            {s.charAt(0).toUpperCase() + s.slice(1)}
          </button>
        ))}
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search..."
          style={{ marginLeft: 'auto', padding: '6px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', width: '140px', outline: 'none' }} />
      </div>

      {/* Showing count */}
      <div style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '10px' }}>
        Showing {Math.min(filtered.length, 100)} of {filtered.length} signals
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
          const statusColor = s.status === 'accepted' ? '#66bb6a' : s.status === 'rejected' ? '#ef5350' : '#607d8b';

          const hasStructuredData = !!(s.entry || s.direction || s.stop_loss || (s.targets && s.targets.length > 0));
          const fmtPrice = (p: number) => p < 0.01 ? `$${p.toFixed(6)}` : p < 1 ? `$${p.toFixed(4)}` : `$${p.toFixed(2)}`;

          return (
            <div key={s.id || i} className="tcard" style={{ padding: '16px 20px', borderLeft: `3px solid ${color}` }}>
              {/* Header: Symbol + Badges + Score + Time */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: hasStructuredData ? '12px' : '8px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
                  {s.symbol && <span style={{ fontSize: '20px', fontWeight: 800, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol}</span>}
                  {s.direction && <span style={{ fontSize: '11px', fontWeight: 700, padding: '3px 10px', borderRadius: '4px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>}
                  <span style={{ fontSize: '11px', color: color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>
                    {cleanChannelName(s.channel_name || 'Unknown')}
                  </span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{ fontSize: '12px', fontWeight: 700, padding: '3px 10px', borderRadius: '4px', background: `${scoreColor}22`, color: scoreColor, fontFamily: 'var(--font-mc-mono)' }}>{s.score}</span>
                  <span style={{ fontSize: '10px', fontWeight: 700, padding: '3px 8px', borderRadius: '4px', background: `${statusColor}22`, color: statusColor, fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>{s.status || 'pending'}</span>
                  <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }} title={fullTime(s.timestamp)}>{timeAgo(s.timestamp)}</span>
                </div>
              </div>

              {/* Structured Data Grid — only when parsed data exists */}
              {hasStructuredData && (
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(120px, 1fr))', gap: '8px', marginBottom: '8px' }}>
                  {s.entry && s.entry > 0 && (
                    <div style={{ padding: '8px 10px', background: '#0d1117', borderRadius: '6px' }}>
                      <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '3px' }}>ENTRY</div>
                      <div style={{ fontSize: '15px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{fmtPrice(s.entry)}</div>
                    </div>
                  )}
                  {s.stop_loss && (
                    <div style={{ padding: '8px 10px', background: '#0d1117', borderRadius: '6px' }}>
                      <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '3px' }}>STOP LOSS</div>
                      <div style={{ fontSize: '15px', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${s.stop_loss}</div>
                    </div>
                  )}
                  {s.targets && s.targets.length > 0 && s.targets.map((t: number, ti: number) => (
                    <div key={ti} style={{ padding: '8px 10px', background: '#0d1117', borderRadius: '6px' }}>
                      <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '3px' }}>TP {ti + 1}</div>
                      <div style={{ fontSize: '15px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>${t}</div>
                    </div>
                  ))}
                  {s.leverage && (
                    <div style={{ padding: '8px 10px', background: '#0d1117', borderRadius: '6px' }}>
                      <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '3px' }}>LEVERAGE</div>
                      <div style={{ fontSize: '15px', fontWeight: 700, color: '#ff9800', fontFamily: 'var(--font-mc-mono)' }}>{s.leverage}x</div>
                    </div>
                  )}
                </div>
              )}

              {/* Raw text — only show if no structured data, or collapsed summary */}
              {!hasStructuredData ? (
                <div style={{ fontSize: '12px', color: '#78909c', fontFamily: 'var(--font-mc-mono)', lineHeight: '1.5', whiteSpace: 'pre-wrap', maxHeight: '60px', overflow: 'hidden' }}>
                  {(s.raw_text || '').slice(0, 200)}
                </div>
              ) : null}
            </div>
          );
        })}
      </div>

      {/* Footer */}
      <div style={{ marginTop: '20px', padding: '10px 16px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
        Sources: {channelCount} Telegram channels · {totalSignals} signals indexed · Auto-refresh 30s
      </div>
    </div>
  );
}
