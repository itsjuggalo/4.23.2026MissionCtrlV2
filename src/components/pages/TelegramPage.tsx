'use client';
import { useState, useEffect } from 'react';

interface TelegramSignal {
  id: string; channel_name: string; timestamp: string; raw_text: string; symbol: string;
  direction: string | null; entry: number | null; stop_loss: number | null;
  targets: number[]; leverage: number | null; score: number; status: string;
  price_change?: number; risk_reward?: number; confirmations?: number; confirmed_by?: string[];
}

const M = 'var(--font-mc-mono)';
const F = 'var(--mc-font-label)';
const LBL = 'var(--mc-font-label)';

function timeAgo(ts: string): string {
  const diff = Date.now() - new Date(ts).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'just now';
  if (mins < 60) return mins + 'm ago';
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return hrs + 'h ago';
  return Math.floor(hrs / 24) + 'd ago';
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

function assessQuality(s: TelegramSignal): { checks: { label: string; pass: boolean; reason: string }[]; grade: string; gradeColor: string } {
  const fmtP = (p: number) => p < 0.01 ? '$' + p.toFixed(6) : p < 1 ? '$' + p.toFixed(4) : '$' + p.toFixed(2);
  const checks = [
    { label: 'Entry', pass: !!(s.entry && s.entry > 0), reason: s.entry ? fmtP(s.entry) : 'No entry price' },
    { label: 'Stop Loss', pass: !!s.stop_loss, reason: s.stop_loss ? '$' + s.stop_loss : 'No SL' },
    { label: 'Targets', pass: !!(s.targets && s.targets.length > 0), reason: s.targets?.length ? s.targets.length + ' target' + (s.targets.length > 1 ? 's' : '') : 'No TP set' },
    { label: 'Direction', pass: !!s.direction, reason: s.direction || 'Unclear' },
    { label: 'Fresh', pass: Date.now() - new Date(s.timestamp).getTime() < 86400000, reason: timeAgo(s.timestamp) },
  ];
  const passed = checks.filter(c => c.pass).length;
  const grade = passed >= 4 ? 'ACTIONABLE' : passed >= 3 ? 'PARTIAL' : passed >= 2 ? 'WEAK' : 'NOISE';
  const gradeColor = passed >= 4 ? '#66bb6a' : passed >= 3 ? '#4fc3f7' : passed >= 2 ? '#ff9800' : '#ef5350';
  return { checks, grade, gradeColor };
}

// Channel grouping for the 6 boxes
function getChannelGroup(name: string): string {
  if (name.includes('Coin Sonar')) return 'COIN SONAR';
  if (name.includes('AICrypto') || name.includes('Ai Golden') || name.includes('Ai Crypto Signals')) return 'AI SIGNALS';
  if (name.includes('Bitcoin Crypto Signals') || name.includes('Sober Trading')) return 'STRUCTURED SIGNALS';
  if (name.includes('WHALE') && !name.includes('Liquidation')) return 'WHALE TRACKER';
  if (name.includes('Binance') || name.includes('Pump') || name.includes('Volume')) return 'BINANCE PUMP';
  if (name.includes('Whale Liquidation') || name.includes('Liquidation')) return 'WHALE LIQS';
  if (name.includes('xCrypto')) return 'xCRYPTO';
  return 'OTHER';
}

const fmtPrice = (p: number) => p < 0.01 ? '$' + p.toFixed(6) : p < 1 ? '$' + p.toFixed(4) : '$' + p.toFixed(2);

function SignalCard({ sig, onClick, isSelected }: { sig: TelegramSignal; onClick: () => void; isSelected: boolean }) {
  const dirColor = sig.direction === 'LONG' || sig.direction === 'BUY' ? '#66bb6a' : sig.direction === 'SHORT' ? '#ef5350' : '#607d8b';
  const q = assessQuality(sig);
  return (
    <div onClick={onClick} style={{ padding: '6px 10px', background: isSelected ? '#0d2137' : '#0d1117', border: '1px solid ' + (isSelected ? '#4fc3f7' : '#1a3a4a'), borderRadius: '6px', cursor: 'pointer', borderLeft: '3px solid ' + dirColor, marginBottom: '3px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '3px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
          <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 800, color: '#e0e0e0', fontFamily: M }}>{sig.symbol}</span>
          {sig.direction && <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: dirColor + '22', border: '1px solid ' + dirColor + '55', fontSize: LBL, fontFamily: M, color: dirColor, fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sig.direction}</span>}
          <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: q.gradeColor + '22', border: '1px solid ' + q.gradeColor + '55', fontSize: LBL, fontFamily: M, color: q.gradeColor, fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{q.grade}</span>
        </div>
        <span style={{ fontSize: LBL, color: '#607d8b', fontFamily: M }}>{timeAgo(sig.timestamp)}</span>
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '4px', marginBottom: '2px' }}>
        {sig.entry && sig.entry > 0 ? <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Entry</div><div style={{ fontSize: F, color: '#66bb6a', fontWeight: 700, fontFamily: M }}>{fmtPrice(sig.entry)}</div></div> : <div />}
        {sig.stop_loss ? <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Stop Loss</div><div style={{ fontSize: F, color: '#ef5350', fontWeight: 700, fontFamily: M }}>{fmtPrice(sig.stop_loss)}</div></div> : <div />}
        {sig.targets && sig.targets.length > 0 ? <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Target 1</div><div style={{ fontSize: F, color: '#4fc3f7', fontWeight: 700, fontFamily: M }}>{fmtPrice(sig.targets[0])}</div></div> : <div />}
      </div>
      {sig.leverage && <div style={{ fontSize: LBL, color: '#ff9800', fontFamily: M, fontWeight: 700 }}>Leverage: {sig.leverage}x</div>}
    </div>
  );
}

function GridBox({ title, color, count, children }: { title: string; color: string; count: number; children: React.ReactNode }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', background: '#0a192908', borderRadius: '8px', border: '1px solid #1a3a4a', minHeight: 0 }}>
      <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, fontFamily: M, letterSpacing: '1px', padding: '10px 12px', borderBottom: '2px solid ' + color + '44', color: color, flexShrink: 0 }}>
        {title} <span style={{ fontSize: LBL, color: '#607d8b', fontWeight: 400 }}>({count})</span>
      </div>
      <div style={{ overflow: 'auto', padding: '6px 8px', flex: 1 }}>{children}</div>
    </div>
  );
}

export function TelegramPage() {
  const [signals, setSignals] = useState<TelegramSignal[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [search, setSearch] = useState('');
  const [qualityFilter, setQualityFilter] = useState<string>('all');
  const [selected, setSelected] = useState<TelegramSignal | null>(null);

  useEffect(() => {
    async function fetchSignals() {
      try {
        const res = await fetch('/api/telegram-signals');
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const data = await res.json();
        const entries = Array.isArray(data) ? data : data.signals || [];
        const cleaned = entries.filter((s: any) => {
          const text = (s.raw_text || '').toLowerCase();
          const sym = (s.symbol || '').toUpperCase();
          if (['bingx', 'deposit', 'usdt completely free', 'receive up to', 'join now', 'bonus', 'exclusive benefit', 'sign up'].some(w => text.includes(w))) return false;
          if (text.includes('\ud83d\udd12') || text.includes('\ud83d\udd10')) return false;
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
        setError(false);
      } catch { setError(true); }
      setLoading(false);
    }
    fetchSignals();
    const i = setInterval(fetchSignals, 30000);
    return () => clearInterval(i);
  }, []);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: M, fontSize: 'var(--mc-font-lg)' }}>
      <div style={{ animation: 'tBlink 1s infinite' }}>SCANNING CHANNELS...</div>
      <style>{'@keyframes tBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );
  const errBanner = error ? <div style={{ padding: '10px 16px', background: '#ef535014', border: '1px solid #ef535033', borderRadius: '6px', color: '#ef5350', fontFamily: M, fontSize: 'var(--mc-font-badge)', marginBottom: '10px', flexShrink: 0 }}>⚠ Telegram signals API unavailable — retrying every 30s</div> : null;

  const actionableCount = signals.filter(s => assessQuality(s).grade === 'ACTIONABLE').length;
  const channels = [...new Set(signals.map(s => s.channel_name || 'Unknown'))].sort();

  let filtered = signals;
  if (search) { const q = search.toLowerCase(); filtered = filtered.filter(s => (s.symbol || '').toLowerCase().includes(q)); }
  if (qualityFilter !== 'all') filtered = filtered.filter(s => assessQuality(s).grade === qualityFilter);
  filtered.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

  const byGroup = (group: string) => filtered.filter(s => getChannelGroup(s.channel_name || '') === group);
  const coinSonar = byGroup('COIN SONAR');
  const aiSignals = byGroup('AI SIGNALS');
  const structuredSignals = byGroup('STRUCTURED SIGNALS');
  const _whaleTracker = byGroup('WHALE TRACKER');
  const binancePump = byGroup('BINANCE PUMP');
  const whaleLiqs = byGroup('WHALE LIQS');
  const xCrypto = byGroup('xCRYPTO');

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: M, fontSize: 'var(--mc-font-badge)', cursor: 'pointer', outline: 'none' };
  const noSig = <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontFamily: M, fontSize: 'var(--mc-font-badge)' }}>No signals</div>;
  const sel = selected;
  const isSel = (s: TelegramSignal) => sel?.id === s.id;
  const toggle = (s: TelegramSignal) => setSelected(isSel(s) ? null : s);

  return (
    <div style={{ padding: '12px 16px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {errBanner}
      {/* Top Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '10px', flexWrap: 'wrap', flexShrink: 0 }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#66bb6a', fontFamily: M }}>LIVE</span>
        <span style={{ fontSize: LBL, color: '#607d8b', fontFamily: M }}>
          {signals.length} signals {' \u00b7 '} {channels.length} channels {' \u00b7 '} {actionableCount} actionable
        </span>
        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />
        <select value={qualityFilter} onChange={e => setQualityFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Quality</option>
          <option value="ACTIONABLE">Actionable Only</option>
          <option value="PARTIAL">Partial</option>
          <option value="WEAK">Weak</option>
          <option value="NOISE">Noise</option>
        </select>
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..." style={{ ...selectStyle, width: '100px' }} />
      </div>

      {/* Outer: 3x2 grid + optional sidebar */}
      <div style={{ display: 'grid', gridTemplateColumns: sel ? '1fr 340px' : '1fr', gap: '10px', flex: 1, overflow: 'hidden', minHeight: 0 }}>
        {/* Inner 3x2 grid */}
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gridTemplateRows: '1fr 1fr', gap: '10px', overflow: 'hidden', minHeight: 0 }}>
          <GridBox title="COIN SONAR" color="#4fc3f7" count={coinSonar.length}>
            {coinSonar.length > 0 ? coinSonar.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
          <GridBox title="AI SIGNALS" color="#66bb6a" count={aiSignals.length}>
            {aiSignals.length > 0 ? aiSignals.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
          <GridBox title="BITCOIN CRYPTO + SOBER TRADING" color="#66bb6a" count={structuredSignals.length}>
            {structuredSignals.length > 0 ? structuredSignals.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
          <GridBox title="BINANCE PUMP" color="#ff9800" count={binancePump.length}>
            {binancePump.length > 0 ? binancePump.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
          <GridBox title="WHALE LIQUIDATIONS" color="#ff4757" count={whaleLiqs.length}>
            {whaleLiqs.length > 0 ? whaleLiqs.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
          <GridBox title="xCRYPTO" color="#ce93d8" count={xCrypto.length}>
            {xCrypto.length > 0 ? xCrypto.map((s, i) => <SignalCard key={s.id + i} sig={s} isSelected={isSel(s)} onClick={() => toggle(s)} />) : noSig}
          </GridBox>
        </div>

        {/* Sidebar detail panel */}
        {sel && (() => {
          const q = assessQuality(sel);
          const dirColor = sel.direction === 'LONG' || sel.direction === 'BUY' ? '#66bb6a' : sel.direction === 'SHORT' ? '#ef5350' : '#607d8b';
          return (
            <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', background: '#0a1929', borderRadius: '8px', border: '1px solid #4fc3f7', minHeight: 0 }}>
              <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, fontFamily: M, letterSpacing: '1px', padding: '10px 12px', borderBottom: '2px solid #4fc3f744', color: '#4fc3f7', display: 'flex', justifyContent: 'space-between', flexShrink: 0 }}>
                SIGNAL DETAIL
                <button onClick={() => setSelected(null)} style={{ background: 'none', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', padding: '1px 8px', cursor: 'pointer', fontFamily: M, fontSize: LBL }}>\u2715</button>
              </div>
              <div style={{ overflow: 'auto', padding: '12px', flex: 1 }}>
                <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 800, color: '#e0e0e0', fontFamily: M, marginBottom: '8px' }}>{sel.symbol}</div>
                <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '16px' }}>
                  {sel.direction && <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: dirColor + '22', border: '1px solid ' + dirColor + '55', fontSize: LBL, fontFamily: M, color: dirColor, fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sel.direction}</span>}
                  <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: getChannelColor(sel.channel_name || '') + '22', border: '1px solid ' + getChannelColor(sel.channel_name || '') + '55', fontSize: LBL, fontFamily: M, color: getChannelColor(sel.channel_name || ''), fontWeight: 600, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{cleanChannelName(sel.channel_name || '')}</span>
                  <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: q.gradeColor + '22', border: '1px solid ' + q.gradeColor + '55', fontSize: LBL, fontFamily: M, color: q.gradeColor, fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{q.grade}</span>
                </div>

                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginBottom: '8px' }}>SIGNAL QUALITY</div>
                <div style={{ marginBottom: '16px', padding: '10px', background: '#0d1117', borderRadius: '6px' }}>
                  {q.checks.map((c: any, i: number) => (
                    <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '5px 0', borderBottom: i < q.checks.length - 1 ? '1px solid #1a3a4a' : 'none' }}>
                      <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                        <span style={{ fontSize: F, color: c.pass ? '#66bb6a' : '#ef5350' }}>{c.pass ? '\u2713' : '\u2717'}</span>
                        <span style={{ fontSize: 'var(--mc-font-badge)', color: '#90a4ae', fontFamily: M }}>{c.label}</span>
                      </div>
                      <span style={{ fontSize: 'var(--mc-font-badge)', color: c.pass ? '#e0e0e0' : '#455a64', fontFamily: M, fontWeight: 600 }}>{c.reason}</span>
                    </div>
                  ))}
                  <div style={{ marginTop: '8px', paddingTop: '8px', borderTop: '1px solid #1a3a4a', display: 'flex', justifyContent: 'space-between' }}>
                    <span style={{ fontSize: 'var(--mc-font-badge)', color: '#607d8b', fontFamily: M, fontWeight: 700 }}>VERDICT</span>
                    <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: q.gradeColor, fontFamily: M }}>{q.grade} ({q.checks.filter((c: any) => c.pass).length}/5)</span>
                  </div>
                </div>

                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginBottom: '8px' }}>PRICE LEVELS</div>
                {[
                  { label: 'ENTRY', value: sel.entry && sel.entry > 0 ? fmtPrice(sel.entry) : null, color: '#66bb6a' },
                  { label: 'STOP LOSS', value: sel.stop_loss ? fmtPrice(sel.stop_loss) : null, color: '#ef5350' },
                  ...(sel.targets || []).map((t: number, i: number) => ({ label: 'TARGET ' + (i + 1), value: fmtPrice(t), color: '#4fc3f7' })),
                  { label: 'LEVERAGE', value: sel.leverage ? sel.leverage + 'x' : null, color: '#ff9800' },
                ].filter(t => t.value).map((t, i) => (
                  <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 0', borderBottom: '1px solid #0d1117' }}>
                    <span style={{ fontSize: LBL, color: '#607d8b', fontFamily: M }}>{t.label}</span>
                    <span style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: t.color, fontFamily: M }}>{t.value}</span>
                  </div>
                ))}

                {sel.entry && sel.stop_loss && sel.targets?.length > 0 && (() => {
                  const risk = Math.abs(sel.entry! - sel.stop_loss!);
                  const reward = Math.abs(sel.targets[0] - sel.entry!);
                  const rr = risk > 0 ? (reward / risk).toFixed(1) : '?';
                  return (
                    <div style={{ marginTop: '12px', padding: '10px', background: '#0d1117', borderRadius: '6px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <span style={{ fontSize: 'var(--mc-font-badge)', color: '#607d8b', fontFamily: M }}>RISK:REWARD</span>
                      <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 800, color: parseFloat(rr) >= 2 ? '#66bb6a' : parseFloat(rr) >= 1 ? '#ff9800' : '#ef5350', fontFamily: M }}>1:{rr}</span>
                    </div>
                  );
                })()}

                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>TIMING</div>
                <div style={{ display: 'flex', justifyContent: 'space-between', padding: '5px 0' }}>
                  <span style={{ fontSize: LBL, color: '#607d8b', fontFamily: M }}>Received</span>
                  <span style={{ fontSize: 'var(--mc-font-badge)', color: '#e0e0e0', fontFamily: M, fontWeight: 600 }}>{fullTime(sel.timestamp)}</span>
                </div>

                {sel.raw_text && (
                  <>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>RAW MESSAGE</div>
                    <div style={{ fontSize: LBL, color: '#90a4ae', fontFamily: M, padding: '10px', background: '#0d1117', borderRadius: '6px', maxHeight: '180px', overflow: 'auto', whiteSpace: 'pre-wrap', lineHeight: '1.4' }}>{sel.raw_text.slice(0, 500)}</div>
                  </>
                )}
              </div>
            </div>
          );
        })()}
      </div>
    </div>
  );
}
