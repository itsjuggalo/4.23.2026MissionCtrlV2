'use client';
import { useState, useEffect, useCallback } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

interface Signal {
  id: string; symbol: string; shortName?: string; strike?: string; expiry?: number;
  buyTarget?: string; sellTarget?: string; sellTarget2?: string; sellTarget3?: string;
  earlyTarget?: string; stopLoss?: string; reduceLoss?: string; category?: string;
  isPut?: number; isWeekly?: number; free?: number; risk?: string; status?: string;
  source: string; type: 'option' | 'stock'; postedAt?: number;
  quote?: any;
}

function daysTo(ts?: number) { return ts ? Math.floor((ts * 1000 - Date.now()) / 86400000) : null; }
function dateStr(ts?: number) { return ts ? new Date(ts * 1000).toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) : ''; }
function postedStr(ts?: number) {
  if (!ts) return '';
  const d = new Date(ts * 1000);
  return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
}

const M = 'var(--font-mc-mono)';
const F = 'var(--mc-font-label)';
const catColor = (c?: string) => c === 'SWING' ? '#4fc3f7' : c === 'SCALP' ? '#ff9800' : c === 'LONGTERM' ? '#ce93d8' : c?.includes('ER') ? '#ffeb3b' : '#607d8b';

function SignalCard({ sig, onClick, isSelected, onTAClick }: { sig: Signal; onClick: () => void; isSelected: boolean; onTAClick: (sym: string) => void }) {
  const dte = daysTo(sig.expiry);
  const isCall = !sig.isPut;
  return (
    <div onClick={onClick} style={{ padding: '12px', background: isSelected ? '#0d2137' : '#0d1117', border: '1px solid ' + (isSelected ? '#4fc3f7' : '#1a3a4a'), borderRadius: '6px', cursor: 'pointer', borderLeft: '3px solid ' + (isCall ? '#66bb6a' : '#ef5350'), marginBottom: '6px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
          <span style={{ fontSize: 'var(--mc-font-md)', fontWeight: 800, color: '#e0e0e0', fontFamily: M }}>{sig.symbol}</span>
          <span onClick={(e) => { e.stopPropagation(); onTAClick(sig.symbol); }} style={{ cursor: 'pointer', padding: '1px 6px', border: '1px solid #4fc3f755', borderRadius: '3px', fontSize: '9px', color: '#4fc3f7', fontWeight: 700, letterSpacing: '1px', fontFamily: M }}>TA</span>
          {sig.strike && <span style={{ fontSize: F, color: '#b0bec5', fontFamily: M, fontWeight: 600 }}>${sig.strike}{isCall ? 'C' : 'P'}</span>}
          <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: catColor(sig.category) + '22', border: '1px solid ' + catColor(sig.category) + '55', fontSize: 'var(--mc-font-label)', fontFamily: M, color: catColor(sig.category), fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sig.category}</span>
        </div>
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '4px', marginBottom: '6px' }}>
        {sig.buyTarget && <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Buy Target</div><div style={{ fontSize: F, color: '#66bb6a', fontWeight: 700, fontFamily: M }}>${sig.buyTarget}</div></div>}
        {(sig.stopLoss || sig.reduceLoss) && <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Stop Loss</div><div style={{ fontSize: F, color: '#ef5350', fontWeight: 700, fontFamily: M }}>${sig.stopLoss || sig.reduceLoss}</div></div>}
        {sig.risk ? <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Risk</div><div style={{ fontSize: F, color: sig.risk === 'VH' || sig.risk === 'HI' ? '#ef5350' : '#ff9800', fontWeight: 700, fontFamily: M }}>{sig.risk}</div></div> : <div />}
      </div>
      {(sig.sellTarget || sig.earlyTarget) && <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '4px', marginBottom: '6px' }}>
        <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Target 1</div><div style={{ fontSize: F, color: '#4fc3f7', fontWeight: 700, fontFamily: M }}>${sig.sellTarget || sig.earlyTarget}</div></div>
        {sig.sellTarget2 && <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Target 2</div><div style={{ fontSize: F, color: '#4fc3f7', fontWeight: 700, fontFamily: M }}>${sig.sellTarget2}</div></div>}
        {sig.sellTarget3 && <div><div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>Target 3</div><div style={{ fontSize: F, color: '#4fc3f7', fontWeight: 700, fontFamily: M }}>${sig.sellTarget3}</div></div>}
      </div>}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderTop: '1px solid #1a3a4a', paddingTop: '6px', fontSize: 'var(--mc-font-label)', fontFamily: M }}>
        <div style={{ display: 'flex', gap: '6px' }}>
          <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: '#1a3a4a', border: '1px solid #2a4a5a', color: '#90a4ae', fontWeight: 600, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sig.source}</span>
          {sig.free !== undefined && <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: sig.free ? '#66bb6a22' : '#ce93d822', border: sig.free ? '1px solid #66bb6a55' : '1px solid #ce93d855', color: sig.free ? '#66bb6a' : '#ce93d8', fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sig.free ? 'FREE' : 'PRO'}</span>}
        </div>
        <div style={{ display: 'flex', gap: '8px', color: '#607d8b' }}>
          {sig.postedAt && <span>Posted {postedStr(sig.postedAt)}</span>}
          {sig.expiry && <span style={{ color: dte !== null && dte <= 7 ? '#ef5350' : '#607d8b' }}>Exp {dateStr(sig.expiry)} ({dte}d)</span>}
        </div>
      </div>
    </div>
  );
}

function ClosedRow({ sig }: { sig: Signal }) {
  const won = sig.status?.toLowerCase().includes('profit') || sig.status?.toLowerCase().includes('booked');
  return (
    <div style={{ padding: '8px 12px', border: '1px solid #1a3a4a', borderRadius: '6px', borderLeft: '3px solid ' + (won ? '#66bb6a' : '#ef5350'), marginBottom: '4px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '4px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
          <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#e0e0e0', fontFamily: M }}>{sig.symbol}</span>
          {sig.strike && <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>${sig.strike}</span>}
          <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: catColor(sig.category) + '22', border: '1px solid ' + catColor(sig.category) + '55', fontSize: 'var(--mc-font-label)', fontFamily: M, color: catColor(sig.category), fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sig.category}</span>
        </div>
        <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>{postedStr(sig.postedAt)}</span>
      </div>
      <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: won ? '#66bb6a' : '#ef5350', fontFamily: M }}>{won ? '\u2705' : '\u274c'} {sig.status}</div>
      <div style={{ display: 'flex', gap: '10px', fontSize: 'var(--mc-font-label)', fontFamily: M, marginTop: '4px', color: '#607d8b' }}>
        {sig.buyTarget && <span>In: ${sig.buyTarget}</span>}
        {sig.sellTarget && <span>TP: ${sig.sellTarget}</span>}
      </div>
    </div>
  );
}

function GridBox({ title, color, count, children }: { title: string; color: string; count: number; children: React.ReactNode }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', background: '#0a192908', borderRadius: '8px', border: '1px solid #1a3a4a', minHeight: 0 }}>
      <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, fontFamily: M, letterSpacing: '1px', padding: '10px 12px', borderBottom: '2px solid ' + color + '44', color, flexShrink: 0 }}>
        {title} <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontWeight: 400 }}>({count})</span>
      </div>
      <div style={{ overflow: 'auto', padding: '6px 8px', flex: 1 }}>
        {children}
      </div>
    </div>
  );
}

type SignalsApiData = {
  name?: { shortTerm?: Record<string, unknown>[]; longTerm?: Record<string, unknown>[]; stocks?: Record<string, unknown>[]; recentClosed?: Record<string, unknown>[] };
  name2?: { shortTerm?: Record<string, unknown>[]; longTerm?: Record<string, unknown>[] };
  vivid?: { shortTerm?: Record<string, unknown>[] };
  summary?: { totalActive?: number };
};

export function SignalsPage() {
  const [data, setData] = useState<SignalsApiData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [sourceFilter, setSourceFilter] = useState('all');
  const [categoryFilter, setCategoryFilter] = useState('all');
  const [ageFilter, setAgeFilter] = useState('30d');
  const [search, setSearch] = useState('');
  const [selected, setSelected] = useState<Signal | null>(null);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);
  const tickerOnly = (sym: string) => {
    if (!sym) return '';
    const s = String(sym).trim().toUpperCase();
    const occMatch = s.match(/^([A-Z]+)\d{6}[CP]/);
    if (occMatch) return occMatch[1];
    const firstWord = s.split(/[\s/]/)[0];
    return firstWord.replace(/[^A-Z]/g, '') || s;
  };
  const openTA = (sym: string) => setDrawerTicker(tickerOnly(sym));

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch('/api/trade-signals');
      if (r.ok) { setData(await r.json()); setError(false); }
      else setError(true);
    } catch { setError(true); }
    setLoading(false);
  }, []);

  // eslint-disable-next-line react-hooks/set-state-in-effect
  useEffect(() => { fetchData(); const i = setInterval(fetchData, 30000); return () => clearInterval(i); }, [fetchData]);

  if (loading) return <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: M, fontSize: 'var(--mc-font-xl)' }}>LOADING SIGNALS...</div>;
  if (error && !data) return <div style={{ padding: '24px' }}><div style={{ padding: '10px 16px', background: '#ef535014', border: '1px solid #ef535033', borderRadius: '6px', color: '#ef5350', fontFamily: M, fontSize: 'var(--mc-font-badge)' }}>⚠ Signals API unavailable — retrying every 30s</div></div>;

  const toSignals = (arr: any[], source: string, type: 'option' | 'stock'): Signal[] =>
    (arr || []).map((s: any) => ({ ...s, source, type, postedAt: s.id && /^\d{9,10}$/.test(s.id) ? parseInt(s.id, 10) : undefined }))
    .filter((s: Signal) => { const dte = daysTo(s.expiry); return type === 'stock' || dte === null || dte > -2; });

  const nameOpts = toSignals(data?.name?.shortTerm || [], 'Name', 'option').concat(toSignals(data?.name?.longTerm || [], 'Name', 'option'));
  const nameStocks = toSignals(data?.name?.stocks || [], 'Name', 'stock');
  const name2Opts = toSignals(data?.name2?.shortTerm || [], 'Name2', 'option').concat(toSignals(data?.name2?.longTerm || [], 'Name2', 'option'));
  const vividOpts = toSignals(data?.vivid?.shortTerm || [], 'Vivid', 'option');
  const closed = toSignals(data?.name?.recentClosed || [], 'Closed', 'option');
  const allActive = [...nameOpts, ...nameStocks, ...name2Opts, ...vividOpts];

  const applyFilters = (sigs: Signal[]) => {
    let f = sigs;
    if (sourceFilter !== 'all') f = f.filter(s => s.source === sourceFilter);
    if (categoryFilter !== 'all') f = f.filter(s => s.category === categoryFilter);
    if (search) { const q = search.toUpperCase(); f = f.filter(s => s.symbol?.includes(q)); }
    if (ageFilter !== 'all') {
      const maxDays = ageFilter === '1d' ? 1 : ageFilter === '7d' ? 7 : 30;
      f = f.filter(s => { if (!s.postedAt) return true; return Math.floor((Date.now() - s.postedAt * 1000) / 86400000) <= maxDays; });
    }
    f.sort((a, b) => (b.postedAt || 0) - (a.postedAt || 0));
    return f;
  };

  const swings = applyFilters(allActive.filter(s => s.type === 'option' && s.category === 'SWING'));
  const scalps = applyFilters(allActive.filter(s => s.type === 'option' && s.category === 'SCALP'));
  const erStocks = applyFilters(allActive.filter(s => s.type === 'stock' || s.category === 'ER PLAY'));
  const longterm = applyFilters(allActive.filter(s => s.category === 'LONGTERM'));
  const closedFiltered = search ? closed.filter(s => s.symbol?.includes(search.toUpperCase())) : closed;

  const categories = [...new Set(allActive.map(s => s.category).filter(Boolean))].sort();
  const summary = data?.summary || {};
  const selectStyle: React.CSSProperties = { padding: '6px 10px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '5px', color: '#e0e0e0', fontFamily: M, fontSize: 'var(--mc-font-badge)', cursor: 'pointer', outline: 'none' };
  const noSig = <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontFamily: M, fontSize: 'var(--mc-font-badge)' }}>No signals</div>;
  const sel = selected;

  return (
    <div style={{ padding: '12px 16px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '10px', flexWrap: 'wrap', flexShrink: 0 }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#66bb6a', fontFamily: M }}>LIVE</span>
        <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>{summary.totalActive || allActive.length} active</span>
        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />
        <select value={sourceFilter} onChange={e => setSourceFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Sources</option>
          <option value="Name">Name</option><option value="Name2">Name2</option><option value="Vivid">Vivid</option>
        </select>
        <select value={categoryFilter} onChange={e => setCategoryFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Categories</option>
          {categories.map(c => <option key={c} value={c}>{c}</option>)}
        </select>
        <select value={ageFilter} onChange={e => setAgeFilter(e.target.value)} style={selectStyle}>
          <option value="1d">Today</option><option value="7d">Past Week</option><option value="30d">Past Month</option><option value="all">All Time</option>
        </select>
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..." style={{ ...selectStyle, width: '90px' }} />
        <button onClick={fetchData} style={{ ...selectStyle, color: '#4fc3f7', borderColor: '#4fc3f7' }}>{'\u21bb'}</button>
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: selected ? '1fr 340px' : '1fr', gap: '10px', flex: 1, overflow: 'hidden', minHeight: 0 }}>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gridTemplateRows: '1fr 1fr', gap: '10px', overflow: 'hidden', minHeight: 0 }}>
        <GridBox title="SWING" color="#4fc3f7" count={swings.length}>
          {swings.length > 0 ? swings.map((s, i) => <SignalCard key={s.source + s.id + i} sig={s} isSelected={sel?.id === s.id && sel?.source === s.source} onClick={() => setSelected(sel?.id === s.id && sel?.source === s.source ? null : s)} onTAClick={openTA} />) : noSig}
        </GridBox>

        <GridBox title="SCALP" color="#ff9800" count={scalps.length}>
          {scalps.length > 0 ? scalps.map((s, i) => <SignalCard key={s.source + s.id + i} sig={s} isSelected={sel?.id === s.id && sel?.source === s.source} onClick={() => setSelected(sel?.id === s.id && sel?.source === s.source ? null : s)} onTAClick={openTA} />) : noSig}
        </GridBox>

        <GridBox title="ER PLAY & STOCKS" color="#ffeb3b" count={erStocks.length}>
          {erStocks.length > 0 ? erStocks.map((s, i) => <SignalCard key={s.source + s.id + i} sig={s} isSelected={sel?.id === s.id && sel?.source === s.source} onClick={() => setSelected(sel?.id === s.id && sel?.source === s.source ? null : s)} onTAClick={openTA} />) : noSig}
        </GridBox>

        <GridBox title="LONGTERM" color="#ce93d8" count={longterm.length}>
          {longterm.length > 0 ? longterm.map((s, i) => <SignalCard key={s.source + s.id + i} sig={s} isSelected={sel?.id === s.id && sel?.source === s.source} onClick={() => setSelected(sel?.id === s.id && sel?.source === s.source ? null : s)} onTAClick={openTA} />) : noSig}
        </GridBox>

        <GridBox title="RECENTLY CLOSED" color="#ef5350" count={closedFiltered.length}>
          {closedFiltered.length > 0 ? closedFiltered.map((s, i) => <ClosedRow key={'c' + s.id + i} sig={s} />) : noSig}
        </GridBox>

        </div>
        {sel ? (
          <div style={{ display: 'flex', flexDirection: 'column', overflow: 'hidden', background: '#0a1929', borderRadius: '8px', border: '1px solid #4fc3f7', minHeight: 0 }}>
            <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, fontFamily: M, letterSpacing: '1px', padding: '10px 12px', borderBottom: '2px solid #4fc3f744', color: '#4fc3f7', display: 'flex', justifyContent: 'space-between', flexShrink: 0 }}>
              SIGNAL DETAIL
              <button onClick={() => setSelected(null)} style={{ background: 'none', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', padding: '1px 8px', cursor: 'pointer', fontFamily: M, fontSize: 'var(--mc-font-label)' }}>{'\u2715'}</button>
            </div>
            <div style={{ overflow: 'auto', padding: '12px', flex: 1 }}>
              <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 800, color: '#e0e0e0', fontFamily: M, marginBottom: '4px', display: 'flex', alignItems: 'center', gap: '8px' }}>
                <span>{sel.symbol}</span>
                <span onClick={() => openTA(sel.symbol)} style={{ cursor: 'pointer', padding: '2px 8px', border: '1px solid #4fc3f755', borderRadius: '3px', fontSize: '10px', color: '#4fc3f7', fontWeight: 700, letterSpacing: '1px' }}>TA</span>
              </div>
              {sel.shortName && <div style={{ fontSize: F, color: '#607d8b', fontFamily: M, marginBottom: '12px' }}>{sel.shortName}</div>}
              <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '16px' }}>
                <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: !sel.isPut ? '#66bb6a22' : '#ef535022', border: !sel.isPut ? '1px solid #66bb6a55' : '1px solid #ef535055', fontSize: 'var(--mc-font-label)', fontFamily: M, color: !sel.isPut ? '#66bb6a' : '#ef5350', fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sel.type === 'stock' ? 'STOCK' : !sel.isPut ? 'CALL' : 'PUT'}</span>
                <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: catColor(sel.category) + '22', border: '1px solid ' + catColor(sel.category) + '55', fontSize: 'var(--mc-font-label)', fontFamily: M, color: catColor(sel.category), fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sel.category}</span>
                <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: '#1a3a4a', border: '1px solid #2a4a5a', fontSize: 'var(--mc-font-label)', fontFamily: M, color: '#90a4ae', fontWeight: 600, lineHeight: 1.2, whiteSpace: 'nowrap' }}>{sel.source}</span>
                {sel.risk && <span style={{ display: 'inline-flex', alignItems: 'center', padding: '2px 8px', borderRadius: '4px', background: '#ef535022', border: '1px solid #ef535055', fontSize: 'var(--mc-font-label)', fontFamily: M, color: '#ef5350', fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>RISK: {sel.risk}</span>}
              </div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginBottom: '8px' }}>PRICE TARGETS</div>
              {[
                { label: 'ENTRY', value: sel.buyTarget, color: '#66bb6a' },
                { label: 'TARGET 1', value: sel.sellTarget || sel.earlyTarget, color: '#4fc3f7' },
                { label: 'TARGET 2', value: sel.sellTarget2, color: '#4fc3f7' },
                { label: 'TARGET 3', value: sel.sellTarget3, color: '#4fc3f7' },
                { label: 'STOP LOSS', value: sel.stopLoss || sel.reduceLoss, color: '#ef5350' },
              ].filter(t => t.value).map((t, i) => (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 0', borderBottom: '1px solid #0d1117' }}>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>{t.label}</span>
                  <span style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: t.color, fontFamily: M }}>${t.value}</span>
                </div>
              ))}
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M, letterSpacing: '1.5px', marginTop: '16px', marginBottom: '8px' }}>CONTRACT INFO</div>
              {[
                { label: 'Strike', value: sel.strike ? '$' + sel.strike : null },
                { label: 'Expiry', value: sel.expiry ? dateStr(sel.expiry) + ' (' + daysTo(sel.expiry) + ' days)' : null },
                { label: 'Posted', value: sel.postedAt ? new Date(sel.postedAt * 1000).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' }) : null },
                { label: 'Access', value: sel.free !== undefined ? (sel.free ? 'FREE' : 'PREMIUM') : null },
              ].filter(d => d.value).map((d, i) => (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '5px 0', borderBottom: '1px solid #0d1117' }}>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: M }}>{d.label}</span>
                  <span style={{ fontSize: F, color: '#e0e0e0', fontFamily: M, fontWeight: 600 }}>{d.value}</span>
                </div>
              ))}
            </div>
          </div>
        ) : null}
      </div>
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
