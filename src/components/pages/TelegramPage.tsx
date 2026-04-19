'use client';
import { useState, useEffect } from 'react';

interface TelegramSignal {
  id: string; channel_name: string; timestamp: string; raw_text: string; symbol: string;
  direction: string | null; entry: number | null; stop_loss: number | null;
  targets: number[]; leverage: number | null; score: number; status: string;
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

// Transparent quality assessment — shows WHY a signal is good or bad
function assessQuality(s: TelegramSignal): { checks: { label: string; pass: boolean; reason: string }[]; grade: string; gradeColor: string } {
  const checks = [
    { label: 'Entry', pass: !!(s.entry && s.entry > 0), reason: s.entry ? `$${s.entry < 1 ? s.entry.toFixed(4) : s.entry.toFixed(2)}` : 'No entry price' },
    { label: 'Stop Loss', pass: !!s.stop_loss, reason: s.stop_loss ? `$${s.stop_loss}` : 'No SL — risky' },
    { label: 'Targets', pass: !!(s.targets && s.targets.length > 0), reason: s.targets?.length ? `${s.targets.length} target${s.targets.length > 1 ? 's' : ''}` : 'No TP set' },
    { label: 'Direction', pass: !!s.direction, reason: s.direction || 'Unclear bias' },
    { label: 'Fresh', pass: Date.now() - new Date(s.timestamp).getTime() < 86400000, reason: timeAgo(s.timestamp) },
  ];
  const passed = checks.filter(c => c.pass).length;
  const grade = passed >= 4 ? 'ACTIONABLE' : passed >= 3 ? 'PARTIAL' : passed >= 2 ? 'WEAK' : 'NOISE';
  const gradeColor = passed >= 4 ? '#66bb6a' : passed >= 3 ? '#4fc3f7' : passed >= 2 ? '#ff9800' : '#ef5350';
  return { checks, grade, gradeColor };
}

export function TelegramPage() {
  const [signals, setSignals] = useState<TelegramSignal[]>([]);
  const [loading, setLoading] = useState(true);
  const [channelFilter, setChannelFilter] = useState<string>('all');
  const [search, setSearch] = useState('');
  const [qualityFilter, setQualityFilter] = useState<string>('all');
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

  let filtered = signals;
  if (channelFilter !== 'all') filtered = filtered.filter(s => s.channel_name === channelFilter);
  if (search) { const q = search.toLowerCase(); filtered = filtered.filter(s => (s.symbol || '').toLowerCase().includes(q)); }
  if (qualityFilter !== 'all') {
    filtered = filtered.filter(s => {
      const q = assessQuality(s);
      return q.grade === qualityFilter;
    });
  }
  filtered.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

  // Group by time for the left column
  const now = Date.now();
  const lastHour = filtered.filter(s => now - new Date(s.timestamp).getTime() < 3600000);
  const today = filtered.filter(s => { const d = now - new Date(s.timestamp).getTime(); return d >= 3600000 && d < 86400000; });
  const older = filtered.filter(s => now - new Date(s.timestamp).getTime() >= 86400000);

  const recentCount = signals.filter(s => now - new Date(s.timestamp).getTime() < 86400000).length;
  const actionableCount = signals.filter(s => assessQuality(s).grade === 'ACTIONABLE').length;
  const fmtPrice = (p: number) => p < 0.01 ? `$${p.toFixed(6)}` : p < 1 ? `$${p.toFixed(4)}` : `$${p.toFixed(2)}`;

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer', outline: 'none' };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '16px' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  const renderSignal = (s: TelegramSignal, i: number) => {
    const color = getChannelColor(s.channel_name || '');
    const dirColor = s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#607d8b';
    const q = assessQuality(s);
    const isSelected = selected?.id === s.id;

    return (
      <div key={`${s.id || i}`} onClick={() => setSelected(isSelected ? null : s)}
        style={{ padding: '10px 12px', background: isSelected ? '#0d2137' : 'transparent', border: `1px solid ${isSelected ? '#4fc3f7' : '#1a3a4a'}`, borderRadius: '6px', cursor: 'pointer', borderLeft: `3px solid ${dirColor}`, marginBottom: '4px', transition: 'all 0.15s' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '6px' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
            <span style={{ fontSize: '16px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol}</span>
            {s.direction && <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>}
            <span style={{ fontSize: '10px', padding: '2px 6px', borderRadius: '3px', background: `${q.gradeColor}22`, color: q.gradeColor, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{q.grade}</span>
          </div>
          <div style={{ display: 'flex', alignItems: 'center', gap: '4px' }}>
            <span style={{ fontSize: '9px', padding: '1px 4px', borderRadius: '2px', background: `${color}22`, color: color, fontFamily: 'var(--font-mc-mono)' }}>{cleanChannelName(s.channel_name || '')}</span>
            <span style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(s.timestamp)}</span>
          </div>
        </div>
        <div style={{ display: 'flex', gap: '12px', fontSize: '13px', fontFamily: 'var(--font-mc-mono)' }}>
          {s.entry && s.entry > 0 && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>IN </span><span style={{ color: '#66bb6a', fontWeight: 700 }}>{fmtPrice(s.entry)}</span></span>}
          {s.stop_loss && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>SL </span><span style={{ color: '#ef5350', fontWeight: 700 }}>{fmtPrice(s.stop_loss)}</span></span>}
          {s.targets && s.targets.length > 0 && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>TP </span><span style={{ color: '#4fc3f7', fontWeight: 700 }}>{fmtPrice(s.targets[0])}</span></span>}
          {s.leverage && <span><span style={{ color: '#607d8b', fontSize: '10px' }}>LEV </span><span style={{ color: '#ff9800', fontWeight: 700 }}>{s.leverage}x</span></span>}
        </div>
        {/* Quality checkmarks — visible reason for the grade */}
        <div style={{ display: 'flex', gap: '8px', marginTop: '5px', fontSize: '10px', fontFamily: 'var(--font-mc-mono)' }}>
          {q.checks.map((c, ci) => (
            <span key={ci} style={{ color: c.pass ? '#66bb6a88' : '#ef535066' }}>{c.pass ? '✓' : '✗'} {c.label}</span>
          ))}
        </div>
      </div>
    );
  };

  const sectionStyle: React.CSSProperties = { fontSize: '12px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', padding: '8px 12px', borderBottom: '2px solid', marginBottom: '6px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' };

  return (
    <div style={{ padding: '12px 16px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {/* Top Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '10px', flexWrap: 'wrap' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: '12px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>LIVE</span>
        <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
          {signals.length} signals · {channels.length} channels · {actionableCount} actionable
        </span>
        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />

        <select value={channelFilter} onChange={e => setChannelFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Channels ({signals.length})</option>
          {channels.map(ch => <option key={ch} value={ch}>{cleanChannelName(ch)} ({channelCounts[ch] || 0})</option>)}
        </select>

        <select value={qualityFilter} onChange={e => setQualityFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Quality</option>
          <option value="ACTIONABLE">Actionable Only</option>
          <option value="PARTIAL">Partial</option>
          <option value="WEAK">Weak</option>
          <option value="NOISE">Noise</option>
        </select>

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..." style={{ ...selectStyle, width: '100px' }} />
      </div>

      {/* 2-Panel: Signal Feed + Detail */}
      <div style={{ display: 'grid', gridTemplateColumns: selected ? '1fr 360px' : '1fr', gap: '12px', flex: 1, overflow: 'hidden', minHeight: 0 }}>

        {/* LEFT: Time-grouped signal feed */}
        <div style={{ overflow: 'auto', paddingRight: '4px' }}>
          {lastHour.length > 0 && (
            <div>
              <div style={{ ...sectionStyle, color: '#66bb6a', borderColor: '#66bb6a44' }}>
                <span>LAST HOUR</span>
                <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>{lastHour.length}</span>
              </div>
              {lastHour.map((s, i) => renderSignal(s, i))}
            </div>
          )}
          {today.length > 0 && (
            <div style={{ marginTop: lastHour.length > 0 ? '12px' : '0' }}>
              <div style={{ ...sectionStyle, color: '#4fc3f7', borderColor: '#4fc3f744' }}>
                <span>TODAY</span>
                <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>{today.length}</span>
              </div>
              {today.map((s, i) => renderSignal(s, i + 1000))}
            </div>
          )}
          {older.length > 0 && (
            <div style={{ marginTop: '12px' }}>
              <div style={{ ...sectionStyle, color: '#607d8b', borderColor: '#607d8b44' }}>
                <span>OLDER</span>
                <span style={{ fontSize: '11px', color: '#607d8b', fontWeight: 400 }}>{older.length}</span>
              </div>
              {older.slice(0, 50).map((s, i) => renderSignal(s, i + 2000))}
            </div>
          )}
          {filtered.length === 0 && <div style={{ padding: '60px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '14px' }}>No signals match filters</div>}
        </div>

        {/* RIGHT: Detail Panel */}
        {selected && (() => {
          const q = assessQuality(selected);
          const dirColor = selected.direction === 'LONG' ? '#66bb6a' : selected.direction === 'SHORT' ? '#ef5350' : '#607d8b';
          return (
            <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', padding: '16px', overflow: 'auto' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '12px' }}>
                <span style={{ fontSize: '22px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{selected.symbol}</span>
                <button onClick={() => setSelected(null)} style={{ background: 'none', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', padding: '2px 8px', cursor: 'pointer', fontFamily: 'var(--font-mc-mono)', fontSize: '11px' }}>✕</button>
              </div>

              <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '16px' }}>
                {selected.direction && <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: `${dirColor}22`, color: dirColor, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{selected.direction}</span>}
                <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: `${getChannelColor(selected.channel_name || '')}22`, color: getChannelColor(selected.channel_name || ''), fontFamily: 'var(--font-mc-mono)' }}>{cleanChannelName(selected.channel_name || '')}</span>
                <span style={{ fontSize: '11px', padding: '3px 8px', borderRadius: '4px', background: `${q.gradeColor}22`, color: q.gradeColor, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{q.grade}</span>
              </div>

              {/* Signal Quality Breakdown — transparent scoring */}
              <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>SIGNAL QUALITY</div>
              <div style={{ marginBottom: '16px', padding: '10px', background: '#0d1117', borderRadius: '6px' }}>
                {q.checks.map((c, i) => (
                  <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '5px 0', borderBottom: i < q.checks.length - 1 ? '1px solid #1a3a4a' : 'none' }}>
                    <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                      <span style={{ fontSize: '13px', color: c.pass ? '#66bb6a' : '#ef5350' }}>{c.pass ? '✓' : '✗'}</span>
                      <span style={{ fontSize: '12px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{c.label}</span>
                    </div>
                    <span style={{ fontSize: '12px', color: c.pass ? '#e0e0e0' : '#455a64', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{c.reason}</span>
                  </div>
                ))}
                <div style={{ marginTop: '8px', paddingTop: '8px', borderTop: '1px solid #1a3a4a', display: 'flex', justifyContent: 'space-between' }}>
                  <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>VERDICT</span>
                  <span style={{ fontSize: '14px', fontWeight: 700, color: q.gradeColor, fontFamily: 'var(--font-mc-mono)' }}>{q.grade} ({q.checks.filter(c => c.pass).length}/5)</span>
                </div>
              </div>

              {/* Price Levels */}
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

              {/* R:R Ratio if we have entry + SL + TP */}
              {selected.entry && selected.stop_loss && selected.targets?.length > 0 && (() => {
                const risk = Math.abs(selected.entry! - selected.stop_loss!);
                const reward = Math.abs(selected.targets[0] - selected.entry!);
                const rr = risk > 0 ? (reward / risk).toFixed(1) : '?';
                return (
                  <div style={{ marginTop: '12px', padding: '10px', background: '#0d1117', borderRadius: '6px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                    <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>RISK:REWARD</span>
                    <span style={{ fontSize: '18px', fontWeight: 800, color: parseFloat(rr) >= 2 ? '#66bb6a' : parseFloat(rr) >= 1 ? '#ff9800' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>1:{rr}</span>
                  </div>
                );
              })()}

              {/* Timing */}
              <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>TIMING</div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '5px 0' }}>
                <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Received</span>
                <span style={{ fontSize: '12px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{fullTime(selected.timestamp)}</span>
              </div>

              {/* Raw Message */}
              {selected.raw_text && (
                <>
                  <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>RAW MESSAGE</div>
                  <div style={{ fontSize: '11px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', padding: '10px', background: '#0d1117', borderRadius: '6px', maxHeight: '180px', overflow: 'auto', whiteSpace: 'pre-wrap', lineHeight: '1.4' }}>{selected.raw_text.slice(0, 500)}</div>
                </>
              )}
            </div>
          );
        })()}
      </div>
    </div>
  );
}
