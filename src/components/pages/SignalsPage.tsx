'use client';
import { useState, useEffect, useCallback } from 'react';

const FIREBASE_URLS = {
  shortOptions: 'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/ShortTermOptions.json',
  longOptions:  'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/LongTermOptions.json',
  shortStocks:  'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/ShortTermStocks.json',
  longStocks:   'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/LongTermStocks.json',
};

interface Signal {
  id: string;
  symbol: string;
  isOption: boolean;
  isCall: boolean;
  isBuy: boolean;
  strike: number | null;
  expiry: Date | null;
  daysToExpiry: number | null;
  buyTarget: string;
  stopLoss: string;
  sellTarget: string;
  status: string;
  lastPrice: number;
  volume: number;
  notes: string;
  category: string;
  raw: any;
}

function timeAgo(d: Date): string {
  const diff = Date.now() - d.getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
}

function parseSignal(id: string, raw: any, isBuy: boolean, isOption: boolean): Signal | null {
  const expiryUnix = raw.expiry || 0;
  const expiry = expiryUnix ? new Date(expiryUnix * 1000) : null;
  const daysToExpiry = expiry ? Math.floor((expiry.getTime() - Date.now()) / 86400000) : null;

  // FILTER: skip expired options (more than 1 day past expiry)
  if (isOption && daysToExpiry !== null && daysToExpiry < -1) return null;

  return {
    id,
    symbol: raw.symbol || id,
    isOption,
    isCall: !raw.isPut || raw.isPut === 0,
    isBuy,
    strike: raw.strike ? parseFloat(String(raw.strike)) : null,
    expiry,
    daysToExpiry,
    buyTarget: raw.buyTarget ? String(raw.buyTarget) : '',
    stopLoss: raw.stopLoss ? String(raw.stopLoss) : '',
    sellTarget: raw.sellTarget ? String(raw.sellTarget) : '',
    status: raw.status || '',
    lastPrice: raw.quote?.lastPrice || 0,
    volume: raw.quote?.totalVolume || 0,
    notes: raw.notes || '',
    category: raw.category || '',
    raw,
  };
}

export function SignalsPage() {
  const [signals, setSignals] = useState<Signal[]>([]);
  const [loading, setLoading] = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [tab, setTab] = useState<'options' | 'stocks'>('options');
  const [typeFilter, setTypeFilter] = useState<'all' | 'calls' | 'puts'>('all');
  const [dirFilter, setDirFilter] = useState<'all' | 'buy' | 'sell'>('all');
  const [search, setSearch] = useState('');

  const fetchSignals = useCallback(async () => {
    try {
      const results: Signal[] = [];
      const entries = Object.entries(FIREBASE_URLS);
      const responses = await Promise.all(entries.map(([, url]) => fetch(url).then(r => r.json()).catch(() => null)));

      responses.forEach((data, idx) => {
        if (!data || typeof data !== 'object') return;
        const key = entries[idx][0];
        const isBuy = key.includes('short') || key.includes('Short');
        const isOption = key.includes('Option');

        const items = Array.isArray(data) ? data : Object.values(data);
        items.forEach((item: any, i: number) => {
          if (!item || typeof item !== 'object') return;
          const sig = parseSignal(`${key}-${item.symbol || i}`, item, isBuy, isOption);
          if (sig) results.push(sig);
        });
      });

      setSignals(results);
      setLastUpdated(new Date());
    } catch {}
    setLoading(false);
  }, []);

  useEffect(() => {
    fetchSignals();
    const i = setInterval(fetchSignals, 60000);
    return () => clearInterval(i);
  }, [fetchSignals]);

  // Filter
  const options = signals.filter(s => s.isOption);
  const stocks = signals.filter(s => !s.isOption);

  let filtered = tab === 'options' ? options : stocks;
  if (typeFilter === 'calls') filtered = filtered.filter(s => s.isCall);
  if (typeFilter === 'puts') filtered = filtered.filter(s => !s.isCall);
  if (dirFilter === 'buy') filtered = filtered.filter(s => s.isBuy);
  if (dirFilter === 'sell') filtered = filtered.filter(s => !s.isBuy);
  if (search) {
    const q = search.toUpperCase();
    filtered = filtered.filter(s => s.symbol.includes(q));
  }

  // Sort: expiring soonest first for options, alphabetical for stocks
  if (tab === 'options') {
    filtered.sort((a, b) => (a.daysToExpiry ?? 999) - (b.daysToExpiry ?? 999));
  } else {
    filtered.sort((a, b) => a.symbol.localeCompare(b.symbol));
  }

  // Group options by urgency
  const expiringSoon = filtered.filter(s => s.daysToExpiry !== null && s.daysToExpiry <= 7 && s.daysToExpiry >= 0);
  const monthly = filtered.filter(s => s.daysToExpiry !== null && s.daysToExpiry > 7 && s.daysToExpiry <= 60);
  const leaps = filtered.filter(s => s.daysToExpiry !== null && s.daysToExpiry > 60);
  const noExpiry = filtered.filter(s => s.daysToExpiry === null);

  const callCount = options.filter(s => s.isCall).length;
  const putCount = options.filter(s => !s.isCall).length;

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .sig-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 8px; padding: 14px 18px; transition: border-color 0.2s; }
        .sig-card:hover { border-color: #4fc3f744; }
        .sig-btn { padding: 6px 14px; border-radius: 6px; border: 1px solid #1a3a4a; background: transparent; color: #607d8b; font-family: var(--font-mc-mono); font-size: 12px; cursor: pointer; font-weight: 600; transition: all 0.15s; }
        .sig-btn.active { background: #4fc3f722; border-color: #4fc3f7; color: #4fc3f7; }
      `}</style>

      {/* Status Bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '20px', padding: '10px 16px', background: '#66bb6a0d', border: '1px solid #66bb6a33', borderRadius: '8px' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: '12px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px' }}>
          FIREBASE LIVE
        </span>
        {lastUpdated && (
          <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
            Updated {timeAgo(lastUpdated)} ago · Polling 60s
          </span>
        )}
        <button onClick={fetchSignals} style={{ marginLeft: 'auto', padding: '4px 12px', background: 'transparent', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', cursor: 'pointer' }}>
          Refresh
        </button>
      </div>

      {/* Stats */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '12px', marginBottom: '20px' }}>
        {[
          { label: 'OPTIONS', value: options.length, color: '#4fc3f7' },
          { label: 'CALLS', value: callCount, color: '#66bb6a' },
          { label: 'PUTS', value: putCount, color: '#ef5350' },
          { label: 'STOCKS', value: stocks.length, color: '#ff9800' },
        ].map((m, i) => (
          <div key={i} className="sig-card" style={{ textAlign: 'center', padding: '16px' }}>
            <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: '28px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Tabs + Filters */}
      <div style={{ display: 'flex', gap: '8px', alignItems: 'center', flexWrap: 'wrap', marginBottom: '16px' }}>
        <button className={`sig-btn ${tab === 'options' ? 'active' : ''}`} onClick={() => setTab('options')}>
          Options ({options.length})
        </button>
        <button className={`sig-btn ${tab === 'stocks' ? 'active' : ''}`} onClick={() => setTab('stocks')}>
          Stocks ({stocks.length})
        </button>
        <div style={{ width: '1px', height: '24px', background: '#1a3a4a', margin: '0 4px' }} />
        {tab === 'options' && (
          <>
            <button className={`sig-btn ${typeFilter === 'all' ? 'active' : ''}`} onClick={() => setTypeFilter('all')}>All</button>
            <button className={`sig-btn ${typeFilter === 'calls' ? 'active' : ''}`} onClick={() => setTypeFilter('calls')} style={typeFilter === 'calls' ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } : {}}>Calls</button>
            <button className={`sig-btn ${typeFilter === 'puts' ? 'active' : ''}`} onClick={() => setTypeFilter('puts')} style={typeFilter === 'puts' ? { background: '#ef535022', borderColor: '#ef5350', color: '#ef5350' } : {}}>Puts</button>
            <div style={{ width: '1px', height: '24px', background: '#1a3a4a', margin: '0 4px' }} />
          </>
        )}
        <button className={`sig-btn ${dirFilter === 'all' ? 'active' : ''}`} onClick={() => setDirFilter('all')}>All</button>
        <button className={`sig-btn ${dirFilter === 'buy' ? 'active' : ''}`} onClick={() => setDirFilter('buy')} style={dirFilter === 'buy' ? { background: '#66bb6a22', borderColor: '#66bb6a', color: '#66bb6a' } : {}}>Buy</button>
        <button className={`sig-btn ${dirFilter === 'sell' ? 'active' : ''}`} onClick={() => setDirFilter('sell')} style={dirFilter === 'sell' ? { background: '#ef535022', borderColor: '#ef5350', color: '#ef5350' } : {}}>Sell</button>
        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Search symbol..."
          style={{ marginLeft: 'auto', padding: '6px 14px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', width: '140px', outline: 'none' }} />
      </div>

      {loading ? (
        <div style={{ textAlign: 'center', padding: '40px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>Loading signals...</div>
      ) : tab === 'options' ? (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '20px' }}>
          {[
            { label: 'EXPIRING WITHIN 7 DAYS', items: expiringSoon, color: '#ef5350', icon: '⚡' },
            { label: 'MONTHLY (8-60 DAYS)', items: monthly, color: '#ff9800', icon: '📅' },
            { label: 'LEAPS (60+ DAYS)', items: leaps, color: '#4fc3f7', icon: '🏔' },
            { label: 'NO EXPIRY SET', items: noExpiry, color: '#607d8b', icon: '📌' },
          ].filter(g => g.items.length > 0).map((group, gi) => (
            <div key={gi}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '10px', paddingBottom: '6px', borderBottom: `2px solid ${group.color}44` }}>
                <span style={{ fontSize: '14px' }}>{group.icon}</span>
                <span style={{ fontSize: '13px', fontWeight: 700, color: group.color, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>{group.label}</span>
                <span style={{ fontSize: '11px', padding: '1px 7px', borderRadius: '10px', background: `${group.color}22`, color: group.color, fontFamily: 'var(--font-mc-mono)' }}>{group.items.length}</span>
              </div>
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '8px' }}>
                {group.items.map((sig, si) => (
                  <div key={si} className="sig-card" style={{ borderLeft: `3px solid ${sig.isCall ? '#66bb6a' : '#ef5350'}` }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                      <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                        <span style={{ fontSize: '16px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{sig.symbol}</span>
                        <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: sig.isCall ? '#66bb6a22' : '#ef535022', color: sig.isCall ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                          {sig.isCall ? 'CALL' : 'PUT'}
                        </span>
                        <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: sig.isBuy ? '#66bb6a22' : '#ef535022', color: sig.isBuy ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                          {sig.isBuy ? 'BUY' : 'SELL'}
                        </span>
                      </div>
                      {sig.daysToExpiry !== null && (
                        <span style={{ fontSize: '11px', fontWeight: 700, color: sig.daysToExpiry <= 7 ? '#ef5350' : sig.daysToExpiry <= 30 ? '#ff9800' : '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>
                          {sig.daysToExpiry}d
                        </span>
                      )}
                    </div>
                    <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '4px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                      {sig.strike && <div><span style={{ color: '#607d8b' }}>Strike: </span><span style={{ color: '#e0e0e0' }}>${sig.strike}</span></div>}
                      {sig.lastPrice > 0 && <div><span style={{ color: '#607d8b' }}>Price: </span><span style={{ color: '#e0e0e0' }}>${sig.lastPrice.toFixed(2)}</span></div>}
                      {sig.buyTarget && <div><span style={{ color: '#607d8b' }}>Buy: </span><span style={{ color: '#66bb6a' }}>${sig.buyTarget}</span></div>}
                      {sig.stopLoss && <div><span style={{ color: '#607d8b' }}>Stop: </span><span style={{ color: '#ef5350' }}>${sig.stopLoss}</span></div>}
                      {sig.sellTarget && <div><span style={{ color: '#607d8b' }}>Target: </span><span style={{ color: '#66bb6a' }}>${sig.sellTarget}</span></div>}
                      {sig.volume > 0 && <div><span style={{ color: '#607d8b' }}>Vol: </span><span style={{ color: '#e0e0e0' }}>{sig.volume.toLocaleString()}</span></div>}
                    </div>
                    {sig.expiry && (
                      <div style={{ marginTop: '6px', fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
                        Exp: {sig.expiry.toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' })}
                      </div>
                    )}
                  </div>
                ))}
              </div>
            </div>
          ))}
          {filtered.length === 0 && (
            <div style={{ textAlign: 'center', padding: '40px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '14px' }}>No signals match filters</div>
          )}
        </div>
      ) : (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '8px' }}>
          {filtered.map((sig, si) => (
            <div key={si} className="sig-card" style={{ borderLeft: `3px solid ${sig.isBuy ? '#66bb6a' : '#ef5350'}` }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                <span style={{ fontSize: '16px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{sig.symbol}</span>
                <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: sig.isBuy ? '#66bb6a22' : '#ef535022', color: sig.isBuy ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                  {sig.isBuy ? 'BUY' : 'SELL'}
                </span>
              </div>
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '4px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                {sig.lastPrice > 0 && <div><span style={{ color: '#607d8b' }}>Price: </span><span style={{ color: '#e0e0e0' }}>${sig.lastPrice.toFixed(2)}</span></div>}
                {sig.buyTarget && <div><span style={{ color: '#607d8b' }}>Buy: </span><span style={{ color: '#66bb6a' }}>${sig.buyTarget}</span></div>}
                {sig.stopLoss && <div><span style={{ color: '#607d8b' }}>Stop: </span><span style={{ color: '#ef5350' }}>${sig.stopLoss}</span></div>}
                {sig.sellTarget && <div><span style={{ color: '#607d8b' }}>Target: </span><span style={{ color: '#66bb6a' }}>${sig.sellTarget}</span></div>}
              </div>
              {sig.notes && <div style={{ marginTop: '6px', fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{sig.notes}</div>}
            </div>
          ))}
          {filtered.length === 0 && (
            <div style={{ textAlign: 'center', padding: '40px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '14px', gridColumn: '1 / -1' }}>No stock signals match filters</div>
          )}
        </div>
      )}

      {/* Footer */}
      <div style={{ marginTop: '20px', padding: '10px 16px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
        Sources: Firebase (Vivid2) · AI Crypto Signals · Polling every 60s · Expired options auto-filtered
      </div>
    </div>
  );
}
