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
  'Coin Sonar V2': '#4fc3f7', 'AICryptoSignals': '#66bb6a', 'Ai Golden Crypto': '#ffd54f',
  'xCrypto Signals': '#ce93d8', 'Ai Crypto Signals (Auto Bot)': '#4db6ac',
};

function getChannelColor(name: string): string {
  for (const [key, color] of Object.entries(CHANNEL_COLORS)) { if (name.includes(key)) return color; }
  if (name.includes('Whale') || name.includes('WHALE')) return '#ef5350';
  if (name.includes('Pump') || name.includes('Volume')) return '#ff9800';
  return '#78909c';
}

function cleanChannelName(name: string): string {
  return name.replace(/[^\w\s()-]/g, '').trim().slice(0, 25);
}

function SignalRow({ s, isSelected, onClick }: { s: TelegramSignal; isSelected: boolean; onClick: () => void }) {
  const color = getChannelColor(s.channel_name || '');
  const scoreColor = s.score >= 70 ? '#66bb6a' : s.score >= 40 ? '#ffd54f' : '#ef5350';
  const dirColor = s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#607d8b';
  const fmtPrice = (p: number) => p < 0.01 ? `$${p.toFixed(6)}` : p < 1 ? `$${p.toFixed(4)}` : `$${p.toFixed(2)}`;

  return (
    <div onClick={onClick} style={{ padding: '10px 12px', background: isSelected ? '#0d2137' : 'transparent', border: `1px solid ${isSelected ? '#4fc3f7' : '#1a3a4a'}`, borderRadius: '6px', cursor: 'pointer', borderLeft: `3px solid ${color}`, marginBottom: '4px', transition: 'all 0.15s' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '6px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
          <span style={{ fontSize: '16px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol}</span>
          {s.direction && <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>}
          <span style={{ fontSize: '12px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: `${scoreColor}22`, color: scoreColor, fontFamily: 'var(--font-mc-mono)' }}>{s.score}</span>
        </div>
        <span style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(s.timestamp)}</span>
      </div>
      <div style={{ display: 'flex', gap: '12px', fontSize: '13px', fontFamily: 'var(--font-mc-mono)' }}>
        {s.entry && s.entry > 0 && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>IN </span><span style={{ color: '#66bb6a', fontWeight: 700 }}>{fmtPrice(s.entry)}</span></span>}
        {s.stop_loss && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>SL </span><span style={{ color: '#ef5350', fontWeight: 700 }}>{fmtPrice(s.stop_loss)}</span></span>}
        {s.targets && s.targets.length > 0 && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>TP </span><span style={{ color: '#4fc3f7', fontWeight: 700 }}>{fmtPrice(s.targets[0])}</span></span>}
        {s.leverage && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>LEV </span><span style={{ color: '#ff9800', fontWeight: 700 }}>{s.leverage}x</span></span>}
      </div>
      <div style={{ display: 'flex', gap: '4px', marginTop: '4px' }}>
        <span style={{ fontSize: '9px', padding: '1px 4px', borderRadius: '2px', background: `${color}22`, color: color, fontFamily: 'var(--font-mc-mono)' }}>{cleanChannelName(s.channel_name || 'Unknown')}</span>
        {s.targets && s.targets.length > 1 && <span style={{ fontSize: '9px', padding: '1px 4px', borderRadius: '2px', background: '#1a3a4a', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{s.targets.length} TPs</span>}
      </div>
    </div>
  );
}

export function TelegramPage() {
  const [signals, setSignals] = useState<TelegramSignal[]>([]);
  const [loading, setLoading] = useState(true);
  const [channelFilter, setChannelFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [scoreFilter, setScoreFilter] = useState<string>('0');
  const [selected, setSelected] = useState<TelegramSignal | null>(null);

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
          if (text.includes('🔒') || text.includes('🔐')) return false;
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

  const applyFilters = (sigs: TelegramSignal[]) => {
    let f = sigs;
    if (channelFilter !== 'all') f = f.filter(s => s.channel_name === channelFilter);
    if (search) { const q = search.toLowerCase(); f = f.filter(s => (s.symbol || '').toLowerCase().includes(q)); }
    if (scoreFilter !== '0') f = f.filter(s => s.score >= parseInt(scoreFilter));
    f.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());
    return f;
  };

  // 3 columns: LONG, SHORT, Accepted/High Score
  const longs = applyFilters(signals.filter(s => s.direction === 'LONG' && s.status !== 'rejected'));
  const shorts = applyFilters(signals.filter(s => s.direction === 'SHORT' && s.status !== 'rejected'));
  const accepted = applyFilters(signals.filter(s => s.status === 'accepted' || s.score >= 70));

  const recentCount = signals.filter(s => Date.now() - new Date(s.timestamp).getTime() < 86400000).length;

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer', outline: 'none' };
  const colHeader: React.CSSProperties = { fontSize: '13px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', padding: '10px 12px', borderBottom: '2px solid', marginBottom: '8px' };
  const fmtPrice = (p: number) => p < 0.01 ? `$${p.toFixed(6)}` : p < 1 ? `$${p.toFixed(4)}` : `$${p.toFixed(2)}`;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '16px' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  return (
    <div style={{ padding: '12px 16px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {/* Top Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '10px', flexWrap: 'wrap' }}>
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

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..." style={{ ...selectStyle, width: '100px' }} />
      </div>

      {/* 3-Column Layout + Detail Panel */}
      <div style={{ display: 'grid', gridTemplateColumns: selected ? '1fr 1fr 1fr 320px' : '1fr 1fr 1fr', gap: '10px', flex: 1, overflow: 'hidden', minHeight: 0 }}>

        {/* Column 1: LONG */}
        <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
          <div style={{ ...colHeader, color: '#66bb6a', borderColor: '#66bb6a44' }}>
            LONG <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>({longs.length})</span>
          </div>
          <div style={{ overflow: 'auto', padding: '0 8px 8px', flex: 1 }}>
            {longs.map((s, i) => <SignalRow key={`l-${s.id || i}`} s={s} isSelected={selected?.id === s.id} onClick={() => setSelected(selected?.id === s.id ? null : s)} />)}
            {longs.length === 0 && <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '12px' }}>No long signals</div>}
          </div>
        </div>

        {/* Column 2: SHORT */}
        <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
          <div style={{ ...colHeader, color: '#ef5350', borderColor: '#ef535044' }}>
            SHORT <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>({shorts.length})</span>
          </div>
          <div style={{ overflow: 'auto', padding: '0 8px 8px', flex: 1 }}>
            {shorts.map((s, i) => <SignalRow key={`s-${s.id || i}`} s={s} isSelected={selected?.id === s.id} onClick={() => setSelected(selected?.id === s.id ? null : s)} />)}
            {shorts.length === 0 && <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '12px' }}>No short signals</div>}
          </div>
        </div>

        {/* Column 3: HIGH SCORE / ACCEPTED */}
        <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
          <div style={{ ...colHeader, color: '#ffd54f', borderColor: '#ffd54f44' }}>
            TOP PICKS (70+ / ACCEPTED) <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>({accepted.length})</span>
          </div>
          <div style={{ overflow: 'auto', padding: '0 8px 8px', flex: 1 }}>
            {accepted.map((s, i) => <SignalRow key={`a-${s.id || i}`} s={s} isSelected={selected?.id === s.id} onClick={() => setSelected(selected?.id === s.id ? null : s)} />)}
            {accepted.length === 0 && <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '12px' }}>No top picks</div>}
          </div>
        </div>

        {/* Detail Panel */}
        {selected && (
          <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', padding: '16px', overflow: 'auto' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '12px' }}>
              <span style={{ fontSize: '22px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{selected.symbol}</span>
              <button onClick={() => setSelected(null)} style={{ background: 'none', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', padding: '2px 8px', cursor: 'pointer', fontFamily: 'var(--font-mc-mono)', fontSize: '11px' }}>✕</button>
            </div>

            <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '16px' }}>
              {selected.direction && <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: selected.direction === 'LONG' ? '#66bb6a22' : '#ef535022', color: selected.direction === 'LONG' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{selected.direction}</span>}
              <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: `${getChannelColor(selected.channel_name || '')}22`, color: getChannelColor(selected.channel_name || ''), fontFamily: 'var(--font-mc-mono)' }}>{cleanChannelName(selected.channel_name || '')}</span>
              <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: (selected.score >= 70 ? '#66bb6a' : selected.score >= 40 ? '#ffd54f' : '#ef5350') + '22', color: selected.score >= 70 ? '#66bb6a' : selected.score >= 40 ? '#ffd54f' : '#ef5350', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>SCORE: {selected.score}</span>
              <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: (selected.status === 'accepted' ? '#66bb6a' : selected.status === 'rejected' ? '#ef5350' : '#607d8b') + '22', color: selected.status === 'accepted' ? '#66bb6a' : selected.status === 'rejected' ? '#ef5350' : '#607d8b', fontFamily: 'var(--font-mc-mono)', fontWeight: 700, textTransform: 'uppercase' }}>{selected.status || 'pending'}</span>
            </div>

            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>PRICE LEVELS</div>
            {[
              { label: 'ENTRY', value: selected.entry && selected.entry > 0 ? fmtPrice(selected.entry) : null, color: '#66bb6a' },
              { label: 'STOP LOSS', value: selected.stop_loss ? fmtPrice(selected.stop_loss) : null, color: '#ef5350' },
              ...(selected.targets || []).map((t, i) => ({ label: `TARGET ${i + 1}`, value: fmtPrice(t), color: '#4fc3f7' })),
              { label: 'LEVERAGE', value: selected.leverage ? `${selected.leverage}x` : null, color: '#ff9800' },
            ].filter(t => t.value).map((t, i) => (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 0', borderBottom: '1px solid #0d1117' }}>
                <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{t.label}</span>
                <span style={{ fontSize: '16px', fontWeight: 700, color: t.color, fontFamily: 'var(--font-mc-mono)' }}>{t.value}</span>
              </div>
            ))}

            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>TIMING</div>
            <div style={{ display: 'flex', justifyContent: 'space-between', padding: '5px 0', borderBottom: '1px solid #0d1117' }}>
              <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Received</span>
              <span style={{ fontSize: '12px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{fullTime(selected.timestamp)}</span>
            </div>
            <div style={{ display: 'flex', justifyContent: 'space-between', padding: '5px 0' }}>
              <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Age</span>
              <span style={{ fontSize: '12px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{timeAgo(selected.timestamp)}</span>
            </div>

            {selected.raw_text && (
              <>
                <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>RAW MESSAGE</div>
                <div style={{ fontSize: '11px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', padding: '10px', background: '#0d1117', borderRadius: '6px', maxHeight: '200px', overflow: 'auto', whiteSpace: 'pre-wrap', lineHeight: '1.4' }}>{selected.raw_text.slice(0, 500)}</div>
              </>
            )}
          </div>
        )}
      </div>
    </div>
  );
}
