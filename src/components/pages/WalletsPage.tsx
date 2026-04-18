'use client';
import { useState, useEffect } from 'react';

export function WalletsPage() {
  const [authenticated, setAuthenticated] = useState(false);
  const [checking, setChecking] = useState(true);
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [wallets, setWallets] = useState<any[]>([]);

  useEffect(() => {
    fetch('/api/wallets')
      .then(r => { if (r.ok) { setAuthenticated(true); return r.json(); } throw new Error(''); })
      .then(data => setWallets(Array.isArray(data) ? data : data.wallets || []))
      .catch(() => {})
      .finally(() => setChecking(false));
  }, []);

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
        const data = await wRes.json();
        setWallets(Array.isArray(data) ? data : data.wallets || []);
      } else { setError('Access denied'); }
    } catch { setError('Connection error'); }
    finally { setLoading(false); }
  };

  const fmt = (n: number) => n.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 });

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
          <h2 style={{ fontSize: '18px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', marginBottom: '8px' }}>VAULT ACCESS</h2>
          <p style={{ fontSize: '12px', color: '#455a64', marginBottom: '28px', fontFamily: 'var(--font-mc-mono)' }}>Enter authorization code to access wallet data</p>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} onKeyDown={(e) => e.key === 'Enter' && handleLogin()} placeholder="Password"
            style={{ width: '100%', padding: '14px 18px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '8px', color: '#e0e0e0', fontSize: '16px', fontFamily: 'var(--font-mc-mono)', marginBottom: '14px', outline: 'none', boxSizing: 'border-box', textAlign: 'center', letterSpacing: '4px' }} />
          {error && <p style={{ color: '#ef5350', fontSize: '12px', marginBottom: '14px', fontFamily: 'var(--font-mc-mono)' }}>{error}</p>}
          <button onClick={handleLogin} disabled={loading || !password}
            style={{ width: '100%', padding: '14px', background: loading ? '#1a3a4a' : 'linear-gradient(135deg, #1a3a4a, #0a1929)', color: '#4fc3f7', border: '1px solid #4fc3f744', borderRadius: '8px', fontSize: '14px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', cursor: loading ? 'wait' : 'pointer', opacity: !password ? 0.4 : 1 }}>
            {loading ? 'AUTHENTICATING...' : 'UNLOCK VAULT'}
          </button>
        </div>
      </div>
    );
  }

  const totalBalance = wallets.reduce((s, w) => s + (w.balance || 0), 0);

  return (
    <div style={{ padding: '24px', maxWidth: '1000px', margin: '0 auto' }}>
      <style>{`
        @keyframes wBreathe { 0%,100% { box-shadow: 0 0 8px #4fc3f711; } 50% { box-shadow: 0 0 20px #4fc3f722; } }
        .w-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; animation: wBreathe 4s ease-in-out infinite; }
      `}</style>

      {/* Total Portfolio Value */}
      <div className="w-card" style={{ padding: '28px 32px', marginBottom: '20px', textAlign: 'center' }}>
        <div style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>TOTAL PORTFOLIO VALUE</div>
        <div style={{ fontSize: '42px', fontWeight: 800, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>${fmt(totalBalance)}</div>
        <div style={{ fontSize: '14px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '8px' }}>
          {wallets.length} accounts connected
        </div>
      </div>

      {/* Individual Wallets */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: '16px' }}>
        {wallets.map((w: any, i: number) => {
          const balance = w.balance || 0;
          const cash = w.cash || 0;
          const bp = w.buying_power || 0;
          const pctOfTotal = totalBalance > 0 ? (balance / totalBalance * 100) : 0;
          const isError = w.status === 'error';

          // Parse holdings from notes
          const holdings = (w.notes || '').split(' | ').filter((n: string) => n && !n.startsWith('Phase') && !n.includes('strategies'));
          const isStrategyNote = (w.notes || '').includes('strategies');

          return (
            <div key={i} className="w-card" style={{ padding: '24px 28px', borderLeft: `4px solid ${isError ? '#ef5350' : w.badge === 'LIVE' ? '#66bb6a' : '#ff9800'}` }}>
              {/* Header Row */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '16px' }}>
                <div>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginBottom: '6px' }}>
                    <span style={{ fontSize: '20px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{w.name}</span>
                    {w.badge && (
                      <span style={{
                        fontSize: '11px', fontWeight: 700, padding: '3px 10px', borderRadius: '4px',
                        fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px',
                        background: w.badge === 'LIVE' ? '#66bb6a22' : '#ff980022',
                        color: w.badge === 'LIVE' ? '#66bb6a' : '#ff9800',
                        border: `1px solid ${w.badge === 'LIVE' ? '#66bb6a44' : '#ff980044'}`,
                      }}>{w.badge}</span>
                    )}
                    {isError && (
                      <span style={{ fontSize: '11px', fontWeight: 700, padding: '3px 10px', borderRadius: '4px', fontFamily: 'var(--font-mc-mono)', background: '#ef535022', color: '#ef5350', border: '1px solid #ef535044' }}>ERROR</span>
                    )}
                  </div>
                  <div style={{ fontSize: '14px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{w.type}</div>
                </div>
                <div style={{ textAlign: 'right' }}>
                  <div style={{ fontSize: '32px', fontWeight: 800, color: balance > 0 ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                    ${fmt(balance)}
                  </div>
                  <div style={{ fontSize: '13px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>
                    {pctOfTotal.toFixed(1)}% of portfolio
                  </div>
                </div>
              </div>

              {/* Cash / Buying Power Row */}
              {(cash !== 0 || bp !== 0) && (
                <div style={{ display: 'flex', gap: '24px', marginBottom: '16px', padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
                  {cash !== 0 && (
                    <div>
                      <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>CASH</div>
                      <div style={{ fontSize: '18px', fontWeight: 600, color: cash >= 0 ? '#e0e0e0' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${fmt(cash)}</div>
                    </div>
                  )}
                  {bp !== 0 && (
                    <div>
                      <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>BUYING POWER</div>
                      <div style={{ fontSize: '18px', fontWeight: 600, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>${fmt(bp)}</div>
                    </div>
                  )}
                </div>
              )}

              {/* Holdings / Positions */}
              {isStrategyNote ? (
                <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
                  <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px' }}>STRATEGY OVERVIEW</div>
                  <div style={{ fontSize: '15px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{w.notes}</div>
                </div>
              ) : holdings.length > 0 && holdings[0] !== 'No holdings' && holdings[0] !== 'No open positions' ? (
                <div>
                  <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '10px', letterSpacing: '1px' }}>HOLDINGS</div>
                  <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(200px, 1fr))', gap: '8px' }}>
                    {holdings.map((h: string, j: number) => {
                      // Parse "SYMBOL: amount ($value)" or "SYMBOL: size (uPnL: $x)"
                      const parts = h.trim().split(':');
                      const symbol = parts[0]?.trim() || '?';
                      const rest = parts.slice(1).join(':').trim();

                      // Extract dollar value
                      const dollarMatch = rest.match(/\(\$?([\d,.-]+)\)/);
                      const upnlMatch = rest.match(/uPnL:\s*\$?([\d,.-]+)/);
                      const value = dollarMatch ? parseFloat(dollarMatch[1].replace(',', '')) : 0;
                      const upnl = upnlMatch ? parseFloat(upnlMatch[1].replace(',', '')) : null;

                      return (
                        <div key={j} style={{
                          padding: '12px 14px', background: '#0d1117', borderRadius: '6px',
                          border: '1px solid #1a3a4a', display: 'flex', justifyContent: 'space-between', alignItems: 'center',
                        }}>
                          <div>
                            <div style={{ fontSize: '15px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{symbol}</div>
                            <div style={{ fontSize: '12px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>
                              {rest.split('(')[0]?.trim() || rest}
                            </div>
                          </div>
                          <div style={{ textAlign: 'right' }}>
                            {value > 0 && (
                              <div style={{ fontSize: '16px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                                ${fmt(value)}
                              </div>
                            )}
                            {upnl !== null && (
                              <div style={{ fontSize: '13px', fontWeight: 600, color: upnl >= 0 ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                                {upnl >= 0 ? '+' : ''}${upnl.toFixed(2)}
                              </div>
                            )}
                          </div>
                        </div>
                      );
                    })}
                  </div>
                </div>
              ) : (
                <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px', color: '#455a64', fontSize: '14px', fontFamily: 'var(--font-mc-mono)' }}>
                  {w.notes || 'No holdings'}
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
