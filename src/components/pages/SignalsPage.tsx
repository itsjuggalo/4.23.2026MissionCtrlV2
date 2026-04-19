'use client';
import { useState, useEffect, useCallback } from 'react';

interface Signal {
  id: string; symbol: string; shortName?: string; strike?: string; expiry?: number;
  buyTarget?: string; sellTarget?: string; sellTarget2?: string; sellTarget3?: string;
  earlyTarget?: string; stopLoss?: string; reduceLoss?: string; category?: string;
  isPut?: number; isWeekly?: number; free?: number; risk?: string; status?: string;
  source: string; type: 'option' | 'stock';
}

function daysTo(ts?: number) { return ts ? Math.floor((ts * 1000 - Date.now()) / 86400000) : null; }
function expStr(ts?: number) { return ts ? new Date(ts * 1000).toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) : ''; }

export function SignalsPage() {
  const [data, setData] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [sourceTab, setSourceTab] = useState<'all' | 'name' | 'name2' | 'vivid' | 'closed'>('all');
  const [typeFilter, setTypeFilter] = useState<'all' | 'calls' | 'puts'>('all');
  const [search, setSearch] = useState('');

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch('/api/trade-signals');
      if (r.ok) { setData(await r.json()); setLastUpdated(new Date()); }
    } catch {}
    setLoading(false);
  }, []);

  useEffect(() => { fetchData(); const i = setInterval(fetchData, 30000); return () => clearInterval(i); }, [fetchData]);

  if (loading) return <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>LOADING SIGNALS...</div>;

  const toSignals = (arr: any[], source: string, type: 'option' | 'stock'): Signal[] =>
    (arr || []).map((s: any) => ({ ...s, source, type })).filter((s: Signal) => {
      const dte = daysTo(s.expiry);
      return type === 'stock' || dte === null || dte > -2;
    });

  const nameOpts = toSignals(data?.name?.shortTerm || [], 'Name', 'option').concat(toSignals(data?.name?.longTerm || [], 'Name', 'option'));
  const nameStocks = toSignals(data?.name?.stocks || [], 'Name', 'stock');
  const name2Opts = toSignals(data?.name2?.shortTerm || [], 'Name2', 'option').concat(toSignals(data?.name2?.longTerm || [], 'Name2', 'option'));
  const vividOpts = toSignals(data?.vivid?.shortTerm || [], 'Vivid', 'option');
  const closed = toSignals(data?.name?.recentClosed || [], 'Closed', 'option');

  const allActive = [...nameOpts, ...nameStocks, ...name2Opts, ...vividOpts];

  let filtered: Signal[] = [];
  if (sourceTab === 'all') filtered = allActive;
  else if (sourceTab === 'name') filtered = [...nameOpts, ...nameStocks];
  else if (sourceTab === 'name2') filtered = name2Opts;
  else if (sourceTab === 'vivid') filtered = vividOpts;
  else if (sourceTab === 'closed') filtered = closed;

  if (typeFilter === 'calls') filtered = filtered.filter(s => !s.isPut);
  if (typeFilter === 'puts') filtered = filtered.filter(s => s.isPut);
  if (search) { const q = search.toUpperCase(); filtered = filtered.filter(s => s.symbol?.includes(q)); }

  filtered.sort((a, b) => {
    const da = daysTo(a.expiry); const db = daysTo(b.expiry);
    if (da !== null && db !== null) return da - db;
    if (da !== null) return -1; if (db !== null) return 1;
    return (a.symbol || '').localeCompare(b.symbol || '');
  });

  const summary = data?.summary || {};
  const options = allActive.filter(s => s.type === 'option');
  const callCount = options.filter(s => !s.isPut).length;
  const putCount = options.filter(s => s.isPut).length;

  const catColor = (c?: string) => {
    if (!c) return '#607d8b';
    if (c === 'SWING') return '#4fc3f7'; if (c === 'SCALP') return '#ff9800';
    if (c === 'LONGTERM') return '#ce93d8'; if (c.includes('ER')) return '#ffeb3b';
    return '#607d8b';
  };

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .sig-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; padding: 14px 18px; transition: border-color 0.2s; }
        .sig-card:hover { border-color: #4fc3f744; }
        .sig-btn { padding: 6px 14px; border-radius: 6px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 12px; cursor: pointer; font-weight: 600; transition: all 0.15s; }
        .sig-btn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
      `}</style>

      {/* Status Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '16px', padding: '10px 16px', background: '#66bb6a0d', border: '1px solid #66bb6a33', borderRadius: '8px' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: '12px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>FIREBASE LIVE — 4 SOURCES</span>
        {lastUpdated && <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Updated {Math.floor((Date.now() - lastUpdated.getTime()) / 60000)}m ago</span>}
        <button onClick={fetchData} style={{ marginLeft: 'auto', padding: '4px 12px', background: 'transparent', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', cursor: 'pointer' }}>Refresh</button>
      </div>

      {/* Stats Row */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '10px', marginBottom: '16px' }}>
        {[
          { label: 'TOTAL ACTIVE', value: summary.totalActive || 0, color: '#4fc3f7' },
          { label: 'NAME', value: summary.nameActiveCount || 0, color: '#66bb6a' },
          { label: 'NAME2', value: summary.name2ActiveCount || 0, color: '#ce93d8' },
          { label: 'VIVID', value: summary.vividActiveCount || 0, color: '#ff9800' },
          { label: 'CLOSED', value: closed.length, color: '#ef5350' },
        ].map((m, i) => (
          <div key={i} className="sig-card" style={{ textAlign: 'center', padding: '12px 8px', cursor: 'pointer', borderTop: sourceTab === ['all','name','name2','vivid','closed'][i] ? `2px solid ${m.color}` : '2px solid transparent' }}
            onClick={() => setSourceTab(['all','name','name2','vivid','closed'][i] as any)}>
            <div style={{ fontSize: '9px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>{m.label}</div>
            <div style={{ fontSize: '24px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Filters */}
      <div style={{ display: 'flex', gap: '8px', alignItems: 'center', flexWrap: 'wrap', marginBottom: '16px' }}>
        {sourceTab !== 'closed' && <>
          <button className={`sig-btn ${typeFilter === 'all' ? 'active' : ''}`} onClick={() => setTypeFilter('all')}>All</button>
          <button className={`sig-btn ${typeFilter === 'calls' ? 'active' : ''}`} onClick={() => setTypeFilter('calls')} style={typeFilter === 'calls' ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } : {}}>Calls ({callCount})</button>
          <button className={`sig-btn ${typeFilter === 'puts' ? 'active' : ''}`} onClick={() => setTypeFilter('puts')} style={typeFilter === 'puts' ? { background: '#ef535022', borderColor: '#ef5350', color: '#ef5350' } : {}}>Puts ({putCount})</button>
        </>}
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search ticker..."
          style={{ marginLeft: 'auto', padding: '6px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', width: '140px', outline: 'none' }} />
      </div>

      {/* Signal Cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '10px' }}>
        {filtered.map((sig, i) => {
          const dte = daysTo(sig.expiry);
          const isCall = !sig.isPut;
          const isClosed = sourceTab === 'closed';
          const won = sig.status?.toLowerCase().includes('profit') || sig.status?.toLowerCase().includes('booked');
          return (
            <div key={i} className="sig-card" style={{ borderLeft: `3px solid ${isClosed ? (won ? '#66bb6a' : '#ef5350') : isCall ? '#66bb6a' : '#ef5350'}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: '16px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{sig.symbol}</span>
                  {sig.strike && <span style={{ fontSize: '11px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>${sig.strike}</span>}
                  <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 5px', borderRadius: '3px', background: isCall ? '#66bb6a22' : '#ef535022', color: isCall ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                    {sig.type === 'stock' ? 'STOCK' : isCall ? 'CALL' : 'PUT'}
                  </span>
                  <span style={{ fontSize: '9px', padding: '2px 5px', borderRadius: '3px', background: `${catColor(sig.category)}22`, color: catColor(sig.category), fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.category}</span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: '9px', padding: '2px 5px', borderRadius: '3px', background: '#1a3a4a', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{sig.source}</span>
                  {dte !== null && <span style={{ fontSize: '11px', fontWeight: 700, color: dte <= 3 ? '#ef5350' : dte <= 14 ? '#ff9800' : '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>{dte}d</span>}
                </div>
              </div>
              {sig.shortName && <div style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>{sig.shortName}</div>}
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '4px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                {sig.buyTarget && <div><span style={{ color: '#607d8b' }}>Buy </span><span style={{ color: '#66bb6a' }}>${sig.buyTarget}</span></div>}
                {(sig.sellTarget || sig.earlyTarget) && <div><span style={{ color: '#607d8b' }}>TP </span><span style={{ color: '#4fc3f7' }}>${sig.sellTarget || sig.earlyTarget}</span></div>}
                {(sig.stopLoss || sig.reduceLoss) && <div><span style={{ color: '#607d8b' }}>SL </span><span style={{ color: '#ef5350' }}>${sig.stopLoss || sig.reduceLoss}</span></div>}
              </div>
              {sig.expiry && <div style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '6px' }}>Exp {expStr(sig.expiry)}{sig.risk ? ` · Risk: ${sig.risk}` : ''}{sig.free !== undefined ? ` · ${sig.free ? 'FREE' : 'PREMIUM'}` : ''}</div>}
              {isClosed && sig.status && <div style={{ fontSize: '11px', fontWeight: 700, color: won ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', marginTop: '6px' }}>{sig.status}</div>}
            </div>
          );
        })}
      </div>
      {filtered.length === 0 && <div style={{ textAlign: 'center', padding: '40px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>No signals match filters</div>}

      <div style={{ marginTop: '20px', padding: '10px 16px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
        Sources: Firebase (Name · Name2 · Vivid · FlowGreeks2) · {summary.totalActive || 0} active signals · Polling 30s · Expired options auto-filtered
      </div>
    </div>
  );
}
