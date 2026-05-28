'use client';
import { useState, useEffect } from 'react';
import { StockDetailDrawer } from '../drawers/StockDetailDrawer';

const fmt = (n: number) => n.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 });
const fmtFull = (n: number) => n.toLocaleString(undefined, { maximumFractionDigits: 0 });
const fmtQty = (n: number) => n < 1 ? n.toFixed(6) : n < 100 ? n.toFixed(2) : n.toLocaleString(undefined, { maximumFractionDigits: 2 });
const fmtPrice = (n: number) => n > 0 && n < 0.01 ? n.toFixed(6) : n > 0 && n < 1 ? n.toFixed(4) : fmt(n);

const isPaper = (w: any): boolean => {
  const name = (w.name || '').toLowerCase();
  const notes = (w.notes || '').toLowerCase();
  if (name.includes('go-trader') || name.includes('gotrader')) return true;
  if (name.includes('paper')) return true;
  if (name.includes('alpaca')) return true;
  if (notes.includes('strategies') && notes.includes('active')) return true;
  const badge = (w.badge || '').toUpperCase();
  if (badge === 'PAPER') return true;
  if (badge === 'LIVE') return false;
  return false;
};

const parseNotesHoldings = (w: any): any[] => {
  if ((w.positions || []).length > 0) return w.positions;
  const notes = String(w.notes || '');
  if (!notes || notes.includes('Phase') || notes.includes('strategies')) return [];
  const parts = notes.split('|').map(s => s.trim()).filter(Boolean);
  const out: any[] = [];
  for (const part of parts) {
    let m = part.match(/^([A-Z0-9]+):\s*(-?[0-9.]+)\s*\(uPnL:\s*\$?(-?[0-9.]+)/i);
    if (m) {
      const sym = m[1], qty = parseFloat(m[2]), upnl = parseFloat(m[3]);
      out.push({ symbol: sym, quantity: qty, equity: Math.abs(upnl) || 0, type: 'crypto', avg_cost: 0, price: 0, pct_change: null, _notesOnly: true, _upnl: upnl });
      continue;
    }
    m = part.match(/^([A-Z0-9]+):\s*\$?([0-9.]+)/i);
    if (m) {
      const sym = m[1], val = parseFloat(m[2]);
      out.push({ symbol: sym, quantity: 0, equity: val, type: 'crypto', avg_cost: 0, price: 0, pct_change: null, _notesOnly: true });
    }
  }
  return out;
};

const mergeRobinhood = (wallets: any[]): any[] => {
  const stocks = wallets.find(w => (w.name || '').toLowerCase().includes('robinhood') && (w.name || '').toLowerCase().includes('stock'));
  const crypto = wallets.find(w => (w.name || '').toLowerCase().includes('robinhood') && (w.name || '').toLowerCase().includes('crypto'));
  if (!stocks && !crypto) return wallets;
  const merged: any = {
    name: 'Robinhood',
    badge: 'LIVE',
    type: 'Brokerage (Live)',
    balance: (stocks?.balance || 0) + (crypto?.balance || 0),
    cash: (stocks?.cash || 0) + (crypto?.cash || 0),
    buying_power: (stocks?.buying_power || 0) + (crypto?.buying_power || 0),
    status: (stocks?.status === 'error' || crypto?.status === 'error') ? 'error' : 'ok',
    updated_at: Math.max(stocks?.updated_at || 0, crypto?.updated_at || 0),
    notes: [stocks?.notes, crypto?.notes].filter(Boolean).join(' | '),
    positions: [
      ...(stocks?.positions || []).map((p: any) => ({ ...p, type: p.type || 'stock' })),
      ...(crypto?.positions || []).map((p: any) => ({ ...p, type: p.type || 'crypto' })),
    ],
    _merged: true,
  };
  return wallets.filter(w => w !== stocks && w !== crypto).concat(merged);
};

export function WalletsPage() {
  const [authenticated, setAuthenticated] = useState(false);
  const [checking, setChecking] = useState(true);
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [wallets, setWallets] = useState<any[]>([]);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);
  const [collapsed, setCollapsed] = useState<Record<string, boolean>>({});
  const [expanded, setExpanded] = useState<Record<string, boolean>>({});
  const [history, setHistory] = useState<{ date: string; total: number }[]>([]);

  const toggleCollapse = (name: string) => setCollapsed(prev => ({ ...prev, [name]: !prev[name] }));
  const toggleExpanded = (key: string) => setExpanded(prev => ({ ...prev, [key]: !prev[key] }));

  useEffect(() => {
    fetch('/api/wallets')
      .then(r => { if (r.ok) { setAuthenticated(true); return r.json(); } throw new Error(''); })
      .then(data => setWallets(Array.isArray(data) ? data : data.wallets || []))
      .catch(() => {})
      .finally(() => setChecking(false));
  }, []);

  // Total + 7-day chart track REAL-MONEY accounts only — paper accounts
  // (Alpaca, go-trader) are excluded so the chart reflects actual capital.
  const totalBalance = wallets.filter(w => !isPaper(w)).reduce((s, w) => s + (w.balance || 0), 0);

  useEffect(() => {
    if (totalBalance <= 0) return;
    try {
      const raw = localStorage.getItem('mc:wallet-history');
      const arr: { date: string; total: number }[] = raw ? JSON.parse(raw) : [];
      const today = new Date().toISOString().slice(0, 10);
      const filtered = arr.filter(h => h.date !== today);
      filtered.push({ date: today, total: totalBalance });
      const last7 = filtered.slice(-7);
      localStorage.setItem('mc:wallet-history', JSON.stringify(last7));
      setHistory(last7);
    } catch {}
  }, [totalBalance]);

  const handleLogin = async () => {
    setLoading(true); setError('');
    try {
      const res = await fetch('/api/wallet-auth', {
        method: 'POST', headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ password }),
      });
      if (res.ok) {
        setAuthenticated(true);
        const wRes = await fetch('/api/wallets');
        if (!wRes.ok) throw new Error(`HTTP ${wRes.status}`);
        const data = await wRes.json();
        setWallets(Array.isArray(data) ? data : data.wallets || []);
      } else { setError('Access denied'); }
    } catch { setError('Connection error'); }
    finally { setLoading(false); }
  };

  if (checking) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'wBlink 1s infinite' }}>VERIFYING ACCESS...</div>
      <style>{'@keyframes wBlink { 0%,100% { opacity:1; } 50% { opacity:0.3; } }'}</style>
    </div>
  );

  if (!authenticated) {
    return (
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh' }}>
        <div style={{ background: 'linear-gradient(180deg, #0a1929 0%, #0d1420 100%)', border: '1px solid #1a3a4a', borderRadius: '12px', padding: '48px 40px', maxWidth: '420px', width: '100%', textAlign: 'center' }}>
          <div style={{ fontSize: '48px', marginBottom: '16px' }}>&#x1F512;</div>
          <h2 style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', marginBottom: '8px' }}>VAULT ACCESS</h2>
          <p style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', marginBottom: '28px', fontFamily: 'var(--font-mc-mono)' }}>Enter authorization code to access wallet data</p>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} onKeyDown={(e) => e.key === 'Enter' && handleLogin()} placeholder="Password"
            style={{ width: '100%', padding: '14px 18px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '8px', color: '#e0e0e0', fontSize: 'var(--mc-font-lg)', fontFamily: 'var(--font-mc-mono)', marginBottom: '14px', outline: 'none', boxSizing: 'border-box', textAlign: 'center', letterSpacing: '4px' }} />
          {error && <p style={{ color: '#ef5350', fontSize: 'var(--mc-font-badge)', marginBottom: '14px', fontFamily: 'var(--font-mc-mono)' }}>{error}</p>}
          <button onClick={handleLogin} disabled={loading || !password}
            style={{ width: '100%', padding: '14px', background: loading ? '#1a3a4a' : 'linear-gradient(135deg, #1a3a4a, #0a1929)', color: '#4fc3f7', border: '1px solid #4fc3f744', borderRadius: '8px', fontSize: 'var(--mc-font-sm)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', cursor: loading ? 'wait' : 'pointer', opacity: !password ? 0.4 : 1 }}>
            {loading ? 'AUTHENTICATING...' : 'UNLOCK VAULT'}
          </button>
        </div>
      </div>
    );
  }

  // Build merged/hydrated wallet list
  const hydrated = wallets.map(w => {
    if ((w.positions || []).length === 0) {
      const parsed = parseNotesHoldings(w);
      if (parsed.length > 0) return { ...w, positions: parsed };
    }
    return w;
  });
  const merged = mergeRobinhood(hydrated);
  const paperWallets = merged.filter(isPaper);
  const liveWallets = merged.filter(w => !isPaper(w));
  const paperTotal = paperWallets.reduce((s, w) => s + (w.balance || 0), 0);
  const liveTotal = liveWallets.reduce((s, w) => s + (w.balance || 0), 0);
  const paperPct = totalBalance > 0 ? (paperTotal / totalBalance) * 100 : 0;
  const livePct = totalBalance > 0 ? (liveTotal / totalBalance) * 100 : 0;

  // Today delta
  const todayDelta = history.length >= 2 ? history[history.length - 1].total - history[history.length - 2].total : 0;
  const todayPct = history.length >= 2 && history[history.length - 2].total > 0
    ? (todayDelta / history[history.length - 2].total * 100) : 0;
  const deltaColor = todayDelta >= 0 ? '#66bb6a' : '#ef5350';

  // 7D bar chart values
  const maxTotal = history.length > 0 ? Math.max(...history.map(h => h.total), 1) : 1;
  const minTotal = history.length > 0 ? Math.min(...history.map(h => h.total)) : 0;
  const range = maxTotal - minTotal || 1;

  return (
    <div style={{ padding: '24px', maxWidth: '1400px', margin: '0 auto' }}>

      {/* COMMAND BAR */}
      <div style={{
        display: 'grid', gridTemplateColumns: '1fr 1fr 1fr',
        gap: '24px', alignItems: 'center',
        marginBottom: '20px', padding: '22px 26px',
        background: 'linear-gradient(180deg, #0d1420 0%, #0a1115 100%)',
        border: '1px solid #1a2332', borderRadius: '10px',
      }}>
        <div>
          <div style={{ fontSize: '11px', color: '#607d8b', letterSpacing: '2px', marginBottom: '8px', fontFamily: 'var(--font-mc-mono)' }}>TOTAL EQUITY</div>
          <div style={{ fontSize: '44px', fontWeight: 800, color: '#e0e0e0', lineHeight: 1, letterSpacing: '-0.5px', fontFamily: 'var(--font-mc-mono)' }}>
            ${fmtFull(totalBalance)}
          </div>
          <div style={{ fontSize: '13px', color: deltaColor, marginTop: '8px', fontWeight: 600, fontFamily: 'var(--font-mc-mono)' }}>
            {history.length >= 2 ? (
              <>{todayDelta >= 0 ? '+' : ''}${fmtFull(Math.abs(todayDelta))} today ({todayPct >= 0 ? '+' : ''}{todayPct.toFixed(1)}%)</>
            ) : (
              <span style={{ color: '#607d8b' }}>{wallets.length} accounts {'\u00B7'} tracking starts today</span>
            )}
          </div>
        </div>
        <div style={{ display: 'flex', gap: '32px', justifyContent: 'center', padding: '0 24px', borderLeft: '1px solid #1a2332', borderRight: '1px solid #1a2332' }}>
          <div style={{ textAlign: 'center' }}>
            <div style={{ fontSize: '11px', color: '#607d8b', letterSpacing: '2px', marginBottom: '8px', fontFamily: 'var(--font-mc-mono)' }}>PAPER</div>
            <div style={{ fontSize: '24px', fontWeight: 700, color: '#90a4ae', lineHeight: 1, fontFamily: 'var(--font-mc-mono)' }}>${fmt(paperTotal)}</div>
            <div style={{ fontSize: '11px', color: '#607d8b', marginTop: '6px', fontFamily: 'var(--font-mc-mono)' }}>{paperPct.toFixed(0)}%</div>
          </div>
          <div style={{ textAlign: 'center' }}>
            <div style={{ fontSize: '11px', color: '#607d8b', letterSpacing: '2px', marginBottom: '8px', fontFamily: 'var(--font-mc-mono)' }}>LIVE</div>
            <div style={{ fontSize: '24px', fontWeight: 700, color: '#66bb6a', lineHeight: 1, textShadow: '0 0 8px #66bb6a44', fontFamily: 'var(--font-mc-mono)' }}>${fmt(liveTotal)}</div>
            <div style={{ fontSize: '11px', color: '#607d8b', marginTop: '6px', fontFamily: 'var(--font-mc-mono)' }}>{livePct.toFixed(0)}%</div>
          </div>
        </div>
        <div>
          <div style={{ fontSize: '11px', color: '#607d8b', letterSpacing: '2px', marginBottom: '10px', fontFamily: 'var(--font-mc-mono)' }}>7D EQUITY</div>
          <div style={{ display: 'flex', alignItems: 'flex-end', gap: '4px', height: '50px' }}>
            {Array.from({ length: 7 }).map((_, i) => {
              const slot = history[history.length - 7 + i];
              if (!slot) {
                return <div key={i} style={{ flex: 1, height: '10px', background: '#1a232233', borderRadius: '2px', alignSelf: 'flex-end' }} />;
              }
              const relHeight = range > 0 ? ((slot.total - minTotal) / range) * 40 + 10 : 25;
              const prev = i > 0 && history[history.length - 7 + i - 1] ? history[history.length - 7 + i - 1].total : slot.total;
              const isUp = slot.total >= prev;
              return (
                <div key={i} style={{
                  flex: 1,
                  height: relHeight + 'px',
                  background: isUp ? '#66bb6a' : '#ef5350',
                  opacity: i === 6 ? 1 : 0.55,
                  borderRadius: '2px',
                  boxShadow: i === 6 ? '0 0 8px ' + (isUp ? '#66bb6a66' : '#ef535066') : undefined,
                  transition: 'all 0.3s',
                }} title={slot.date + ': $' + fmtFull(slot.total)} />
              );
            })}
          </div>
        </div>
      </div>

      {/* TWO-COLUMN WALLET LAYOUT */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '16px' }}>
        <WalletColumn label="PAPER" total={paperTotal} accentColor="#90a4ae" wallets={paperWallets} showGlow={false}
          collapsed={collapsed} toggleCollapse={toggleCollapse} expanded={expanded} toggleExpanded={toggleExpanded} onSymbolClick={setDrawerTicker} />
        <WalletColumn label="LIVE" total={liveTotal} accentColor="#66bb6a" wallets={liveWallets} showGlow={true}
          collapsed={collapsed} toggleCollapse={toggleCollapse} expanded={expanded} toggleExpanded={toggleExpanded} onSymbolClick={setDrawerTicker} />
      </div>

      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}

function WalletColumn({ label, total, accentColor, wallets, showGlow, collapsed, toggleCollapse, expanded, toggleExpanded, onSymbolClick }: {
  label: string;
  total: number;
  accentColor: string;
  wallets: any[];
  showGlow: boolean;
  collapsed: Record<string, boolean>;
  toggleCollapse: (name: string) => void;
  expanded: Record<string, boolean>;
  toggleExpanded: (key: string) => void;
  onSymbolClick: (t: string) => void;
}) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
      <div style={{
        padding: '10px 14px',
        background: '#0a1115',
        border: '1px solid #1a2332',
        borderLeft: '3px solid ' + accentColor,
        borderRadius: '6px',
        display: 'flex', justifyContent: 'space-between', alignItems: 'center',
      }}>
        <div style={{ fontSize: '11px', letterSpacing: '2px', color: accentColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)', textShadow: showGlow ? '0 0 6px ' + accentColor + '66' : undefined }}>{label}</div>
        <div style={{ fontSize: '18px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>${fmt(total)}</div>
      </div>
      {wallets.map((w, i) => (
        <WalletCard key={i} w={w} live={showGlow} collapsed={collapsed} toggleCollapse={toggleCollapse} expanded={expanded} toggleExpanded={toggleExpanded} onSymbolClick={onSymbolClick} />
      ))}
      {wallets.length === 0 && (
        <div style={{ padding: '24px', textAlign: 'center', color: '#607d8b', fontSize: '12px', fontFamily: 'var(--font-mc-mono)', border: '1px dashed #1a2332', borderRadius: '6px' }}>
          No {label.toLowerCase()} accounts
        </div>
      )}
    </div>
  );
}

function WalletCard({ w, live, collapsed, toggleCollapse, expanded, toggleExpanded, onSymbolClick }: {
  w: any;
  live: boolean;
  collapsed: Record<string, boolean>;
  toggleCollapse: (name: string) => void;
  expanded: Record<string, boolean>;
  toggleExpanded: (key: string) => void;
  onSymbolClick: (t: string) => void;
}) {
  const balance = w.balance || 0;
  const cash = w.cash || 0;
  const bp = w.buying_power || 0;
  const isError = w.status === 'error';
  const positions = w.positions || [];
  const isStrategy = (w.notes || '').includes('strategies');
  const hasPositions = positions.length > 0;
  const isCollapsed = !!collapsed[w.name];

  const stocks = positions.filter((p: any) => p.type !== 'crypto').sort((a: any, b: any) => (b.equity || 0) - (a.equity || 0));
  const crypto = positions.filter((p: any) => p.type === 'crypto').sort((a: any, b: any) => (b.equity || 0) - (a.equity || 0));
  const hasBoth = stocks.length > 0 && crypto.length > 0;

  const borderColor = isError ? '#ef5350' : (live ? '#66bb6a' : '#90a4ae');

  return (
    <div style={{
      background: 'linear-gradient(180deg, #0a1929 0%, #0d1420 100%)',
      border: '1px solid #1a3a4a',
      borderLeft: '3px solid ' + borderColor,
      borderRadius: '8px',
      padding: '14px 16px',
    }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
        <div style={{ display: 'flex', alignItems: 'flex-start', gap: '8px', flex: 1, minWidth: 0 }}>
          {(hasPositions || isStrategy) && (
            <span onClick={() => toggleCollapse(w.name)} style={{
              cursor: 'pointer', fontSize: '14px', color: '#607d8b', userSelect: 'none',
              marginTop: '2px', fontFamily: 'var(--font-mc-mono)',
            }}>{isCollapsed ? '\u25B8' : '\u25BE'}</span>
          )}
          <div style={{ flex: 1, minWidth: 0 }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '3px', flexWrap: 'wrap' }}>
              <span style={{ fontSize: '14px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{w.name}</span>
              {w.badge && <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 7px', borderRadius: '3px', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', background: w.badge === 'LIVE' ? '#66bb6a22' : '#ff980022', color: w.badge === 'LIVE' ? '#66bb6a' : '#ff9800', border: '1px solid ' + (w.badge === 'LIVE' ? '#66bb6a44' : '#ff980044') }}>{w.badge}</span>}
              {isError && <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 7px', borderRadius: '3px', fontFamily: 'var(--font-mc-mono)', background: '#ef535022', color: '#ef5350', border: '1px solid #ef535044' }}>ERROR</span>}
            </div>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
              {w.type}{hasPositions ? ' \u00B7 ' + positions.length + ' positions' : ''}
            </div>
          </div>
        </div>
        <div style={{ textAlign: 'right', marginLeft: '8px' }}>
          <div style={{ fontSize: '20px', fontWeight: 800, color: balance > 0 ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${fmt(balance)}</div>
        </div>
      </div>

      {!isCollapsed && (
        <>
          {(cash !== 0 || bp !== 0) && (
            <div style={{ display: 'flex', gap: '16px', marginTop: '10px', padding: '8px 12px', background: '#0d1117', borderRadius: '5px' }}>
              {cash !== 0 && <div>
                <div style={{ fontSize: '9px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '2px', letterSpacing: '1px' }}>CASH</div>
                <div style={{ fontSize: '13px', fontWeight: 600, color: cash >= 0 ? '#e0e0e0' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${fmt(cash)}</div>
              </div>}
              {bp !== 0 && bp !== cash && <div>
                <div style={{ fontSize: '9px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '2px', letterSpacing: '1px' }}>BUYING POWER</div>
                <div style={{ fontSize: '13px', fontWeight: 600, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>${fmt(bp)}</div>
              </div>}
            </div>
          )}

          {!isError && hasPositions && (
            <div style={{ marginTop: '10px' }}>
              {stocks.length > 0 && (
                <PositionSection
                  sectionKey={w.name + ':stocks'}
                  title={hasBoth ? 'STOCKS' : 'HOLDINGS'}
                  positions={stocks}
                  expanded={!!expanded[w.name + ':stocks']}
                  setExpanded={() => toggleExpanded(w.name + ':stocks')}
                  onSymbolClick={onSymbolClick}
                  symColor="#4fc3f7"
                />
              )}
              {crypto.length > 0 && (
                <div style={{ marginTop: hasBoth ? '12px' : 0 }}>
                  <PositionSection
                    sectionKey={w.name + ':crypto'}
                    title={hasBoth ? 'CRYPTO' : 'HOLDINGS'}
                    positions={crypto}
                    expanded={!!expanded[w.name + ':crypto']}
                    setExpanded={() => toggleExpanded(w.name + ':crypto')}
                    onSymbolClick={onSymbolClick}
                    symColor="#ce93d8"
                  />
                </div>
              )}
            </div>
          )}

          {isStrategy && (
            <div style={{ marginTop: '10px', padding: '10px 12px', background: '#0d1117', borderRadius: '5px' }}>
              <div style={{ fontSize: '9px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '5px', letterSpacing: '1px' }}>STRATEGY OVERVIEW</div>
              <div style={{ fontSize: '12px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', lineHeight: 1.5 }}>{w.notes}</div>
            </div>
          )}

          {!hasPositions && !isStrategy && w.notes && (
            <div style={{ marginTop: '10px', padding: '10px 12px', background: '#0d1117', borderRadius: '5px', color: '#607d8b', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
              {w.notes}
            </div>
          )}
        </>
      )}
    </div>
  );
}

function PositionSection({ sectionKey, title, positions, expanded, setExpanded, onSymbolClick, symColor }: {
  sectionKey: string;
  title: string;
  positions: any[];
  expanded: boolean;
  setExpanded: () => void;
  onSymbolClick: (t: string) => void;
  symColor: string;
}) {
  const shown = expanded ? positions : positions.slice(0, 8);
  return (
    <>
      <div style={{ fontSize: '9px', color: '#607d8b', letterSpacing: '1.5px', marginBottom: '6px', fontFamily: 'var(--font-mc-mono)' }}>{title}</div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(220px, 1fr))', gap: '6px' }}>
        {shown.map((p: any, i: number) => {
          const isStock = p.type !== 'crypto';
          const price = Number(p.price || 0);
          const avgCost = Number(p.avg_cost || 0);
          const equity = Number(p.equity || 0);
          const qty = Number(p.quantity || 0);
          const pctRet = p.pct_change != null ? p.pct_change : (avgCost > 0 ? ((price - avgCost) / avgCost) * 100 : null);
          const dollarPL = avgCost > 0 && qty ? (price - avgCost) * qty : null;
          const pctColor = pctRet != null ? (pctRet >= 0 ? '#66bb6a' : '#ef5350') : '#607d8b';
          const bgTint = pctRet != null ? (pctRet >= 0 ? 'rgba(102,187,106,0.05)' : 'rgba(239,83,80,0.05)') : '#0d1117';
          const borderTint = pctRet != null ? (pctRet >= 0 ? 'rgba(102,187,106,0.28)' : 'rgba(239,83,80,0.25)') : '#1a3a4a';
          return (
            <div key={i} onClick={() => onSymbolClick(p.symbol)} style={{
              cursor: 'pointer',
              padding: '9px 11px',
              background: 'linear-gradient(180deg, #0d1117 0%, ' + bgTint + ' 100%)',
              borderRadius: '5px',
              border: '1px solid ' + borderTint,
              display: 'flex', flexDirection: 'column', gap: '5px',
            }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
                <span style={{ fontSize: '13px', fontWeight: 800, color: symColor, letterSpacing: '0.5px', fontFamily: 'var(--font-mc-mono)' }}>{p.symbol}</span>
                <span style={{ fontSize: '8px', fontWeight: 700, color: '#607d8b', letterSpacing: '1.2px', fontFamily: 'var(--font-mc-mono)' }}>{isStock ? 'STOCK' : 'CRYPTO'}</span>
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
                <span style={{ fontSize: '16px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>${fmt(equity)}</span>
                {pctRet != null && (
                  <span style={{ fontSize: '10px', fontWeight: 700, color: pctColor, background: pctColor + '22', padding: '2px 6px', borderRadius: '3px', fontFamily: 'var(--font-mc-mono)' }}>
                    {pctRet >= 0 ? '+' : ''}{pctRet.toFixed(1)}%
                  </span>
                )}
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '9px', color: '#90a4ae', borderTop: '1px solid #1a2332', paddingTop: '4px', gap: '6px', fontFamily: 'var(--font-mc-mono)' }}>
                <span>{fmtQty(qty)} {isStock ? 'sh' : 'coins'}</span>
                {avgCost > 0 ? (
                  <span style={{ textAlign: 'right' }}>{'avg $' + fmtPrice(avgCost) + ' \u2192 $' + fmtPrice(price)}</span>
                ) : price > 0 ? (
                  <span>{'@ $' + fmtPrice(price)}</span>
                ) : (
                  <span>{'\u2014'}</span>
                )}
              </div>
              {dollarPL != null && Math.abs(dollarPL) > 0.01 && (
                <div style={{ fontSize: '9px', color: pctColor, textAlign: 'right', fontWeight: 600, fontFamily: 'var(--font-mc-mono)' }}>
                  {dollarPL >= 0 ? '+' : '-'}${fmt(Math.abs(dollarPL))} {dollarPL >= 0 ? 'gain' : 'loss'}
                </div>
              )}
            </div>
          );
        })}
      </div>
      {positions.length > 8 && (
        <button onClick={setExpanded} style={{
          marginTop: '8px', width: '100%',
          fontSize: '10px', color: '#4fc3f7', padding: '6px',
          background: 'transparent', border: '1px dashed #1a3a4a', borderRadius: '3px',
          cursor: 'pointer', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px',
          display: 'flex', alignItems: 'center', justifyContent: 'center', gap: '6px',
        }}>
          <span style={{ fontSize: '11px' }}>{expanded ? '\u25BE' : '\u25B8'}</span>
          {expanded ? 'Show Top 8' : 'Show All (' + positions.length + ')'}
        </button>
      )}
    </>
  );
}
