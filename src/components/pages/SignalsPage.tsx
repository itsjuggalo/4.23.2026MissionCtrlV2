'use client';
import { useState, useEffect, useCallback } from 'react';

interface Signal {
  id: string; symbol: string; shortName?: string; strike?: string; expiry?: number;
  buyTarget?: string; sellTarget?: string; sellTarget2?: string; sellTarget3?: string;
  earlyTarget?: string; stopLoss?: string; reduceLoss?: string; category?: string;
  isPut?: number; isWeekly?: number; free?: number; risk?: string; status?: string;
  source: string; type: 'option' | 'stock'; postedAt?: number;
}

function daysTo(ts?: number) { return ts ? Math.floor((ts * 1000 - Date.now()) / 86400000) : null; }
function expStr(ts?: number) { return ts ? new Date(ts * 1000).toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) : ''; }
function postedStr(ts?: number) {
  if (!ts) return '';
  const d = new Date(ts * 1000);
  const diffDays = Math.floor((Date.now() - d.getTime()) / 86400000);
  if (diffDays === 0) return 'Today ' + d.toLocaleTimeString('en-US', { hour: 'numeric', minute: '2-digit' });
  if (diffDays === 1) return 'Yesterday';
  if (diffDays < 7) return `${diffDays}d ago`;
  if (diffDays < 30) return `${Math.floor(diffDays / 7)}w ago`;
  return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
}
function ageBadge(ts?: number): { label: string; color: string } {
  if (!ts) return { label: '?', color: '#607d8b' };
  const diffDays = Math.floor((Date.now() - ts * 1000) / 86400000);
  if (diffDays <= 1) return { label: 'NEW', color: '#66bb6a' };
  if (diffDays <= 7) return { label: `${diffDays}D`, color: '#4fc3f7' };
  if (diffDays <= 30) return { label: `${Math.floor(diffDays / 7)}W`, color: '#ff9800' };
  return { label: `${Math.floor(diffDays / 30)}M+`, color: '#ef5350' };
}

export function SignalsPage() {
  const [data, setData] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [sourceFilter, setSourceFilter] = useState('all');
  const [categoryFilter, setCategoryFilter] = useState('all');
  const [typeFilter, setTypeFilter] = useState('all');
  const [ageFilter, setAgeFilter] = useState('30d');
  const [search, setSearch] = useState('');
  const [selected, setSelected] = useState<Signal | null>(null);

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch('/api/trade-signals');
      if (r.ok) { setData(await r.json()); setLastUpdated(new Date()); }
    } catch {}
    setLoading(false);
  }, []);

  useEffect(() => { fetchData(); const i = setInterval(fetchData, 30000); return () => clearInterval(i); }, [fetchData]);

  if (loading) return <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '18px' }}>LOADING SIGNALS...</div>;

  const toSignals = (arr: any[], source: string, type: 'option' | 'stock'): Signal[] =>
    (arr || []).map((s: any) => ({ ...s, source, type, postedAt: s.id && /^\d{9,10}$/.test(s.id) ? parseInt(s.id) : undefined }))
    .filter((s: Signal) => { const dte = daysTo(s.expiry); return type === 'stock' || dte === null || dte > -2; });

  const nameOpts = toSignals(data?.name?.shortTerm || [], 'Name', 'option').concat(toSignals(data?.name?.longTerm || [], 'Name', 'option'));
  const nameStocks = toSignals(data?.name?.stocks || [], 'Name', 'stock');
  const name2Opts = toSignals(data?.name2?.shortTerm || [], 'Name2', 'option').concat(toSignals(data?.name2?.longTerm || [], 'Name2', 'option'));
  const vividOpts = toSignals(data?.vivid?.shortTerm || [], 'Vivid', 'option');
  const closed = toSignals(data?.name?.recentClosed || [], 'Closed', 'option');
  const allSignals = [...nameOpts, ...nameStocks, ...name2Opts, ...vividOpts];

  // Apply filters
  let filtered = sourceFilter === 'closed' ? closed : allSignals;
  if (sourceFilter !== 'all' && sourceFilter !== 'closed') filtered = filtered.filter(s => s.source === sourceFilter);
  if (categoryFilter !== 'all') filtered = filtered.filter(s => s.category === categoryFilter);
  if (typeFilter === 'calls') filtered = filtered.filter(s => !s.isPut && s.type === 'option');
  if (typeFilter === 'puts') filtered = filtered.filter(s => s.isPut && s.type === 'option');
  if (typeFilter === 'stocks') filtered = filtered.filter(s => s.type === 'stock');
  if (typeFilter === 'options') filtered = filtered.filter(s => s.type === 'option');
  if (search) { const q = search.toUpperCase(); filtered = filtered.filter(s => s.symbol?.includes(q)); }
  if (ageFilter !== 'all' && sourceFilter !== 'closed') {
    const maxDays = ageFilter === '1d' ? 1 : ageFilter === '7d' ? 7 : ageFilter === '30d' ? 30 : 9999;
    filtered = filtered.filter(s => { if (!s.postedAt) return true; return Math.floor((Date.now() - s.postedAt * 1000) / 86400000) <= maxDays; });
  }
  filtered.sort((a, b) => (b.postedAt || 0) - (a.postedAt || 0));

  const categories = [...new Set(allSignals.map(s => s.category).filter(Boolean))].sort();
  const summary = data?.summary || {};
  const freshCount = allSignals.filter(s => s.postedAt && Math.floor((Date.now() - s.postedAt * 1000) / 86400000) <= 7).length;
  const catColor = (c?: string) => c === 'SWING' ? '#4fc3f7' : c === 'SCALP' ? '#ff9800' : c === 'LONGTERM' ? '#ce93d8' : c?.includes('ER') ? '#ffeb3b' : '#607d8b';

  const selectStyle: React.CSSProperties = { padding: '8px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '13px', cursor: 'pointer', outline: 'none', minWidth: '120px' };

  return (
    <div style={{ padding: '16px 20px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {/* Top Bar — Status + Filters in dropdowns */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '12px', flexWrap: 'wrap' }}>
        <span style={{ width: '10px', height: '10px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 8px #66bb6a88', flexShrink: 0 }} />
        <span style={{ fontSize: '13px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>LIVE</span>
        <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{summary.totalActive || 0} signals · {freshCount} fresh</span>

        <div style={{ width: '1px', height: '20px', background: '#1a3a4a', margin: '0 4px' }} />

        <select value={sourceFilter} onChange={e => { setSourceFilter(e.target.value); setSelected(null); }} style={selectStyle}>
          <option value="all">All Sources ({summary.totalActive || 0})</option>
          <option value="Name">Name ({summary.nameActiveCount || 0})</option>
          <option value="Name2">Name2 ({summary.name2ActiveCount || 0})</option>
          <option value="Vivid">Vivid ({summary.vividActiveCount || 0})</option>
          <option value="closed">Closed ({closed.length})</option>
        </select>

        <select value={categoryFilter} onChange={e => setCategoryFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Categories</option>
          {categories.map(c => <option key={c} value={c}>{c}</option>)}
        </select>

        <select value={typeFilter} onChange={e => setTypeFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Types</option>
          <option value="options">Options Only</option>
          <option value="calls">Calls Only</option>
          <option value="puts">Puts Only</option>
          <option value="stocks">Stocks Only</option>
        </select>

        <select value={ageFilter} onChange={e => setAgeFilter(e.target.value)} style={selectStyle}>
          <option value="1d">Today Only</option>
          <option value="7d">Past Week</option>
          <option value="30d">Past Month</option>
          <option value="all">All Time</option>
        </select>

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..."
          style={{ ...selectStyle, width: '100px', flexShrink: 0 }} />

        <button onClick={fetchData} style={{ ...selectStyle, cursor: 'pointer', color: '#4fc3f7', borderColor: '#4fc3f7' }}>↻</button>
      </div>

      {/* 3-Panel Layout */}
      <div style={{ display: 'grid', gridTemplateColumns: selected ? '1fr 380px' : '1fr', gap: '12px', flex: 1, overflow: 'hidden', minHeight: 0 }}>

        {/* LEFT: Signal List */}
        <div style={{ overflow: 'auto', display: 'flex', flexDirection: 'column', gap: '6px', paddingRight: '4px' }}>
          <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', padding: '4px 0', borderBottom: '1px solid #1a3a4a', marginBottom: '4px' }}>
            Showing {filtered.length} of {allSignals.length} · Sorted newest first
          </div>
          {filtered.map((sig, i) => {
            const dte = daysTo(sig.expiry);
            const isCall = !sig.isPut;
            const isClosed = sourceFilter === 'closed';
            const won = sig.status?.toLowerCase().includes('profit') || sig.status?.toLowerCase().includes('booked');
            const age = ageBadge(sig.postedAt);
            const isSelected = selected?.id === sig.id && selected?.source === sig.source;
            return (
              <div key={`${sig.source}-${sig.id}-${i}`} onClick={() => setSelected(isSelected ? null : sig)}
                style={{ display: 'grid', gridTemplateColumns: '60px 1fr auto', gap: '12px', alignItems: 'center', padding: '12px 16px', background: isSelected ? '#0d2137' : '#0a1929', border: `1px solid ${isSelected ? '#4fc3f7' : '#1a3a4a'}`, borderRadius: '8px', cursor: 'pointer', borderLeft: `4px solid ${isClosed ? (won ? '#66bb6a' : '#ef5350') : isCall ? '#66bb6a' : '#ef5350'}`, transition: 'all 0.15s' }}>

                {/* Col 1: Symbol */}
                <div>
                  <div style={{ fontSize: '18px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{sig.symbol}</div>
                  {sig.strike && <div style={{ fontSize: '13px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>${sig.strike} {isCall ? 'C' : 'P'}</div>}
                </div>

                {/* Col 2: Entry/Target/Stop + Meta */}
                <div style={{ display: 'flex', gap: '20px', alignItems: 'center', flexWrap: 'wrap' }}>
                  <div style={{ display: 'flex', gap: '16px' }}>
                    {sig.buyTarget && <div><span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>ENTRY </span><span style={{ fontSize: '16px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>${sig.buyTarget}</span></div>}
                    {(sig.sellTarget || sig.earlyTarget) && <div><span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>TP </span><span style={{ fontSize: '16px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>${sig.sellTarget || sig.earlyTarget}</span></div>}
                    {(sig.stopLoss || sig.reduceLoss) && <div><span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>SL </span><span style={{ fontSize: '16px', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${sig.stopLoss || sig.reduceLoss}</span></div>}
                  </div>
                  <div style={{ display: 'flex', gap: '6px', alignItems: 'center' }}>
                    <span style={{ fontSize: '11px', padding: '2px 6px', borderRadius: '3px', background: `${catColor(sig.category)}22`, color: catColor(sig.category), fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.category}</span>
                    <span style={{ fontSize: '10px', padding: '2px 5px', borderRadius: '3px', background: '#1a3a4a', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{sig.source}</span>
                    {sig.risk && <span style={{ fontSize: '10px', padding: '2px 5px', borderRadius: '3px', background: sig.risk === 'VH' ? '#ef535022' : '#ff980022', color: sig.risk === 'VH' ? '#ef5350' : '#ff9800', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.risk}</span>}
                    {sig.free !== undefined && <span style={{ fontSize: '10px', padding: '2px 5px', borderRadius: '3px', background: sig.free ? '#66bb6a22' : '#ce93d822', color: sig.free ? '#66bb6a' : '#ce93d8', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.free ? 'FREE' : 'PRO'}</span>}
                  </div>
                  {isClosed && sig.status && <span style={{ fontSize: '13px', fontWeight: 700, color: won ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{won ? '✅' : '❌'} {sig.status}</span>}
                </div>

                {/* Col 3: Date + Expiry */}
                <div style={{ textAlign: 'right', minWidth: '90px' }}>
                  <div style={{ fontSize: '13px', fontWeight: 600, color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{postedStr(sig.postedAt)}</div>
                  <div style={{ display: 'flex', gap: '4px', justifyContent: 'flex-end', marginTop: '2px' }}>
                    <span style={{ fontSize: '10px', padding: '1px 5px', borderRadius: '3px', background: `${age.color}22`, color: age.color, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{age.label}</span>
                    {dte !== null && <span style={{ fontSize: '10px', padding: '1px 5px', borderRadius: '3px', background: '#0d1117', color: dte <= 7 ? '#ef5350' : '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{dte}d exp</span>}
                  </div>
                </div>
              </div>
            );
          })}
          {filtered.length === 0 && <div style={{ textAlign: 'center', padding: '60px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '15px' }}>No signals match filters</div>}
        </div>

        {/* RIGHT: Detail Panel (shows when signal selected) */}
        {selected && (
          <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '20px', overflow: 'auto' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px' }}>
              <div style={{ fontSize: '24px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{selected.symbol}</div>
              <button onClick={() => setSelected(null)} style={{ background: 'none', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', padding: '4px 10px', cursor: 'pointer', fontFamily: 'var(--font-mc-mono)', fontSize: '12px' }}>✕</button>
            </div>
            {selected.shortName && <div style={{ fontSize: '13px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '16px' }}>{selected.shortName}</div>}

            <div style={{ display: 'flex', gap: '8px', flexWrap: 'wrap', marginBottom: '20px' }}>
              <span style={{ fontSize: '12px', padding: '4px 10px', borderRadius: '4px', background: !selected.isPut ? '#66bb6a22' : '#ef535022', color: !selected.isPut ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{selected.type === 'stock' ? 'STOCK' : !selected.isPut ? 'CALL' : 'PUT'}</span>
              <span style={{ fontSize: '12px', padding: '4px 10px', borderRadius: '4px', background: `${catColor(selected.category)}22`, color: catColor(selected.category), fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{selected.category}</span>
              <span style={{ fontSize: '12px', padding: '4px 10px', borderRadius: '4px', background: '#1a3a4a', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{selected.source}</span>
              {selected.risk && <span style={{ fontSize: '12px', padding: '4px 10px', borderRadius: '4px', background: selected.risk === 'VH' ? '#ef535022' : '#ff980022', color: selected.risk === 'VH' ? '#ef5350' : '#ff9800', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>RISK: {selected.risk}</span>}
            </div>

            {/* Price Targets */}
            <div style={{ marginBottom: '20px' }}>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px' }}>PRICE TARGETS</div>
              {[
                { label: 'ENTRY', value: selected.buyTarget, color: '#66bb6a' },
                { label: 'TARGET 1', value: selected.sellTarget || selected.earlyTarget, color: '#4fc3f7' },
                { label: 'TARGET 2', value: selected.sellTarget2, color: '#4fc3f7' },
                { label: 'TARGET 3', value: selected.sellTarget3, color: '#4fc3f7' },
                { label: 'STOP LOSS', value: selected.stopLoss || selected.reduceLoss, color: '#ef5350' },
              ].filter(t => t.value).map((t, i) => (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '8px 0', borderBottom: '1px solid #0d1117' }}>
                  <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{t.label}</span>
                  <span style={{ fontSize: '18px', fontWeight: 700, color: t.color, fontFamily: 'var(--font-mc-mono)' }}>${t.value}</span>
                </div>
              ))}
            </div>

            {/* Contract Details */}
            <div style={{ marginBottom: '20px' }}>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px' }}>CONTRACT</div>
              {[
                { label: 'Strike', value: selected.strike ? `$${selected.strike}` : null },
                { label: 'Expiry', value: selected.expiry ? expStr(selected.expiry) : null },
                { label: 'DTE', value: daysTo(selected.expiry) !== null ? `${daysTo(selected.expiry)} days` : null },
                { label: 'Weekly', value: selected.isWeekly ? 'Yes' : null },
                { label: 'Access', value: selected.free !== undefined ? (selected.free ? 'FREE' : 'PREMIUM') : null },
              ].filter(d => d.value).map((d, i) => (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 0', borderBottom: '1px solid #0d1117' }}>
                  <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{d.label}</span>
                  <span style={{ fontSize: '13px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{d.value}</span>
                </div>
              ))}
            </div>

            {/* Timing */}
            <div>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px' }}>TIMING</div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 0' }}>
                <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Posted</span>
                <span style={{ fontSize: '13px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{selected.postedAt ? new Date(selected.postedAt * 1000).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' }) + ' ' + new Date(selected.postedAt * 1000).toLocaleTimeString('en-US', { hour: 'numeric', minute: '2-digit' }) : 'Unknown'}</span>
              </div>
              {selected.status && <div style={{ marginTop: '12px', padding: '10px', background: '#0d1117', borderRadius: '6px', fontSize: '14px', fontWeight: 700, color: selected.status.toLowerCase().includes('profit') ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{selected.status}</div>}
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
