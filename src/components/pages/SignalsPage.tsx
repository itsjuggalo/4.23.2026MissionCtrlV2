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
  const now = Date.now();
  const diffMs = now - d.getTime();
  const diffDays = Math.floor(diffMs / 86400000);
  if (diffDays === 0) return 'Today ' + d.toLocaleTimeString('en-US', { hour: 'numeric', minute: '2-digit' });
  if (diffDays === 1) return 'Yesterday';
  if (diffDays < 7) return `${diffDays}d ago`;
  if (diffDays < 30) return `${Math.floor(diffDays / 7)}w ago`;
  return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: diffDays > 365 ? 'numeric' : undefined });
}
function ageBadge(ts?: number): { label: string; color: string } {
  if (!ts) return { label: 'UNKNOWN', color: '#607d8b' };
  const diffDays = Math.floor((Date.now() - ts * 1000) / 86400000);
  if (diffDays <= 1) return { label: 'NEW', color: '#66bb6a' };
  if (diffDays <= 7) return { label: `${diffDays}D OLD`, color: '#4fc3f7' };
  if (diffDays <= 30) return { label: `${Math.floor(diffDays / 7)}W OLD`, color: '#ff9800' };
  if (diffDays <= 90) return { label: `${Math.floor(diffDays / 30)}M OLD`, color: '#ef5350' };
  return { label: `${Math.floor(diffDays / 30)}M+ STALE`, color: '#b71c1c' };
}

export function SignalsPage() {
  const [data, setData] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [sourceTab, setSourceTab] = useState<'all' | 'name' | 'name2' | 'vivid' | 'closed'>('all');
  const [typeFilter, setTypeFilter] = useState<'all' | 'calls' | 'puts'>('all');
  const [freshOnly, setFreshOnly] = useState(true);
  const [search, setSearch] = useState('');

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
    (arr || []).map((s: any) => {
      const postedAt = s.id && /^\d{9,10}$/.test(s.id) ? parseInt(s.id) : undefined;
      return { ...s, source, type, postedAt };
    }).filter((s: Signal) => {
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
  if (freshOnly && sourceTab !== 'closed') {
    filtered = filtered.filter(s => {
      if (!s.postedAt) return true;
      const ageDays = Math.floor((Date.now() - s.postedAt * 1000) / 86400000);
      return ageDays <= 30;
    });
  }

  // Sort newest first by posted date
  filtered.sort((a, b) => (b.postedAt || 0) - (a.postedAt || 0));

  const summary = data?.summary || {};
  const options = allActive.filter(s => s.type === 'option');
  const callCount = options.filter(s => !s.isPut).length;
  const putCount = options.filter(s => s.isPut).length;
  const freshCount = allActive.filter(s => s.postedAt && Math.floor((Date.now() - s.postedAt * 1000) / 86400000) <= 7).length;

  const catColor = (c?: string) => {
    if (!c) return '#607d8b';
    if (c === 'SWING') return '#4fc3f7'; if (c === 'SCALP') return '#ff9800';
    if (c === 'LONGTERM') return '#ce93d8'; if (c.includes('ER')) return '#ffeb3b';
    return '#607d8b';
  };

  return (
    <div style={{ padding: '24px', maxWidth: '1200px', margin: '0 auto' }}>
      <style>{`
        .sig-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; padding: 16px 20px; transition: border-color 0.2s; }
        .sig-card:hover { border-color: #4fc3f744; }
        .sig-btn { padding: 8px 16px; border-radius: 6px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 13px; cursor: pointer; font-weight: 600; transition: all 0.15s; }
        .sig-btn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
      `}</style>

      {/* Status Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '16px', padding: '12px 18px', background: '#66bb6a0d', border: '1px solid #66bb6a33', borderRadius: '8px' }}>
        <span style={{ width: '10px', height: '10px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 8px #66bb6a88' }} />
        <span style={{ fontSize: '14px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>FIREBASE LIVE — 4 SOURCES</span>
        {lastUpdated && <span style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Updated {Math.floor((Date.now() - lastUpdated.getTime()) / 60000)}m ago</span>}
        <span style={{ fontSize: '12px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{freshCount} fresh this week</span>
        <button onClick={fetchData} style={{ marginLeft: 'auto', padding: '6px 14px', background: 'transparent', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer' }}>Refresh</button>
      </div>

      {/* Stats Row — clickable source tabs */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '10px', marginBottom: '16px' }}>
        {[
          { label: 'TOTAL ACTIVE', value: summary.totalActive || 0, color: '#4fc3f7', tab: 'all' },
          { label: 'NAME', value: summary.nameActiveCount || 0, color: '#66bb6a', tab: 'name' },
          { label: 'NAME2', value: summary.name2ActiveCount || 0, color: '#ce93d8', tab: 'name2' },
          { label: 'VIVID', value: summary.vividActiveCount || 0, color: '#ff9800', tab: 'vivid' },
          { label: 'CLOSED', value: closed.length, color: '#ef5350', tab: 'closed' },
        ].map((m, i) => (
          <div key={i} className="sig-card" style={{ textAlign: 'center', padding: '14px 8px', cursor: 'pointer', borderTop: sourceTab === m.tab ? `3px solid ${m.color}` : '3px solid transparent' }}
            onClick={() => setSourceTab(m.tab as any)}>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '4px' }}>{m.label}</div>
            <div style={{ fontSize: '28px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Filters */}
      <div style={{ display: 'flex', gap: '8px', alignItems: 'center', flexWrap: 'wrap', marginBottom: '16px' }}>
        {sourceTab !== 'closed' && <>
          <button className={`sig-btn ${typeFilter === 'all' ? 'active' : ''}`} onClick={() => setTypeFilter('all')}>All</button>
          <button className={`sig-btn ${typeFilter === 'calls' ? 'active' : ''}`} onClick={() => setTypeFilter('calls')} style={typeFilter === 'calls' ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } : {}}>Calls ({callCount})</button>
          <button className={`sig-btn ${typeFilter === 'puts' ? 'active' : ''}`} onClick={() => setTypeFilter('puts')} style={typeFilter === 'puts' ? { background: '#ef535022', borderColor: '#ef5350', color: '#ef5350' } : {}}>Puts ({putCount})</button>
          <div style={{ width: '1px', height: '24px', background: '#1a3a4a', margin: '0 4px' }} />
          <button className={`sig-btn ${freshOnly ? 'active' : ''}`} onClick={() => setFreshOnly(!freshOnly)}
            style={freshOnly ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } : {}}>
            {freshOnly ? 'Fresh Only (30d)' : 'Show All Ages'}
          </button>
        </>}
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search ticker..."
          style={{ marginLeft: 'auto', padding: '8px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '13px', width: '160px', outline: 'none' }} />
      </div>

      {/* Signal Cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(340px, 1fr))', gap: '12px' }}>
        {filtered.map((sig, i) => {
          const dte = daysTo(sig.expiry);
          const isCall = !sig.isPut;
          const isClosed = sourceTab === 'closed';
          const won = sig.status?.toLowerCase().includes('profit') || sig.status?.toLowerCase().includes('booked');
          const age = ageBadge(sig.postedAt);
          return (
            <div key={i} className="sig-card" style={{ borderLeft: `4px solid ${isClosed ? (won ? '#66bb6a' : '#ef5350') : isCall ? '#66bb6a' : '#ef5350'}` }}>
              {/* Row 1: Symbol + Tags */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '10px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{ fontSize: '20px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{sig.symbol}</span>
                  {sig.strike && <span style={{ fontSize: '14px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>${sig.strike}</span>}
                  <span style={{ fontSize: '11px', fontWeight: 700, padding: '3px 7px', borderRadius: '4px', background: isCall ? '#66bb6a22' : '#ef535022', color: isCall ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                    {sig.type === 'stock' ? 'STOCK' : isCall ? 'CALL' : 'PUT'}
                  </span>
                  <span style={{ fontSize: '11px', padding: '3px 7px', borderRadius: '4px', background: `${catColor(sig.category)}22`, color: catColor(sig.category), fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.category}</span>
                </div>
                {dte !== null && <span style={{ fontSize: '14px', fontWeight: 700, color: dte <= 3 ? '#ef5350' : dte <= 14 ? '#ff9800' : '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>{dte}d to exp</span>}
              </div>

              {sig.shortName && <div style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px' }}>{sig.shortName}</div>}

              {/* Row 2: Entry / Target / Stop — LARGE */}
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '8px', marginBottom: '10px' }}>
                {sig.buyTarget && <div style={{ textAlign: 'center', padding: '6px', background: '#0d1117', borderRadius: '6px' }}>
                  <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>ENTRY</div>
                  <div style={{ fontSize: '18px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>${sig.buyTarget}</div>
                </div>}
                {(sig.sellTarget || sig.earlyTarget) && <div style={{ textAlign: 'center', padding: '6px', background: '#0d1117', borderRadius: '6px' }}>
                  <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>TARGET</div>
                  <div style={{ fontSize: '18px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>${sig.sellTarget || sig.earlyTarget}</div>
                </div>}
                {(sig.stopLoss || sig.reduceLoss) && <div style={{ textAlign: 'center', padding: '6px', background: '#0d1117', borderRadius: '6px' }}>
                  <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>STOP</div>
                  <div style={{ fontSize: '18px', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${sig.stopLoss || sig.reduceLoss}</div>
                </div>}
              </div>

              {/* Row 3: Meta info — date posted, source, expiry, age badge */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', flexWrap: 'wrap', gap: '6px' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  {sig.postedAt && <span style={{ fontSize: '12px', fontWeight: 600, color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>
                    {postedStr(sig.postedAt)}
                  </span>}
                  <span style={{ fontSize: '10px', padding: '2px 6px', borderRadius: '3px', background: `${age.color}22`, color: age.color, fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{age.label}</span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: '10px', padding: '2px 6px', borderRadius: '3px', background: '#1a3a4a', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{sig.source}</span>
                  {sig.expiry && <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>Exp {expStr(sig.expiry)}</span>}
                  {sig.risk && <span style={{ fontSize: '10px', padding: '2px 5px', borderRadius: '3px', background: sig.risk === 'VH' ? '#ef535022' : sig.risk === 'H' ? '#ff980022' : '#66bb6a22', color: sig.risk === 'VH' ? '#ef5350' : sig.risk === 'H' ? '#ff9800' : '#66bb6a', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>RISK: {sig.risk}</span>}
                  {sig.free !== undefined && <span style={{ fontSize: '10px', padding: '2px 5px', borderRadius: '3px', background: sig.free ? '#66bb6a22' : '#ce93d822', color: sig.free ? '#66bb6a' : '#ce93d8', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>{sig.free ? 'FREE' : 'PREMIUM'}</span>}
                </div>
              </div>

              {/* Additional targets */}
              {(sig.sellTarget2 || sig.sellTarget3) && <div style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '6px' }}>
                TP2: ${sig.sellTarget2 || '—'} {sig.sellTarget3 ? `· TP3: $${sig.sellTarget3}` : ''}
              </div>}

              {isClosed && sig.status && <div style={{ fontSize: '14px', fontWeight: 700, color: won ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', marginTop: '8px', padding: '6px 0', borderTop: '1px solid #1a3a4a' }}>{won ? '✅' : '❌'} {sig.status}</div>}
            </div>
          );
        })}
      </div>
      {filtered.length === 0 && <div style={{ textAlign: 'center', padding: '60px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '16px' }}>No signals match filters{freshOnly ? ' — try "Show All Ages"' : ''}</div>}

      <div style={{ marginTop: '20px', padding: '12px 18px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', fontSize: '12px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
        Sources: Firebase (Name · Name2 · Vivid · FlowGreeks2) · {summary.totalActive || 0} total · Showing {filtered.length} · Sorted newest first · Polling 30s
      </div>
    </div>
  );
}
