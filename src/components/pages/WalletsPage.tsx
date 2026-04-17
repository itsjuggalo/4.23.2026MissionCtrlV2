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
        <style>{'@keyframes wGlow { 0%,100% { boxShadow: 0 0 15px #4fc3f711; } 50% { boxShadow: 0 0 30px #4fc3f722; } }'}</style>
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

  return (
    <div style={{ padding: '24px', maxWidth: '900px', margin: '0 auto' }}>
      <div style={{ marginBottom: '24px' }}>
        <h1 style={{ fontSize: '18px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', margin: 0 }}>WALLET VAULT</h1>
        <p style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>Authenticated</p>
      </div>
      {wallets.length === 0 ? (
        <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>No wallet data available</div>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
          {wallets.map((w: any, i: number) => {
            const balance = parseFloat(w.balance || w.equity || '0');
            const cash = parseFloat(w.cash || '0');
            const bp = parseFloat(w.buying_power || '0');
            return (
              <div key={i} style={{ background: 'linear-gradient(180deg, #0a1929 0%, #0d1420 100%)', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '24px' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <div>
                    <div style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
                      <div style={{ fontSize: '16px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{w.name || 'Wallet ' + (i+1)}</div>
                      {w.badge && <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', background: w.badge === 'LIVE' ? '#66bb6a22' : '#ff980022', color: w.badge === 'LIVE' ? '#66bb6a' : '#ff9800', border: '1px solid ' + (w.badge === 'LIVE' ? '#66bb6a44' : '#ff980044') }}>{w.badge}</span>}
                      {w.status === 'error' && <span style={{ fontSize: '9px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', fontFamily: 'var(--font-mc-mono)', background: '#ef535022', color: '#ef5350', border: '1px solid #ef535044' }}>ERROR</span>}
                    </div>
                    <div style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{w.type || 'Account'}</div>
                  </div>
                  <div style={{ fontSize: '28px', fontWeight: 800, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>${fmt(balance)}</div>
                </div>
                {(cash !== 0 || bp !== 0) && (
                  <div style={{ display: 'flex', gap: '20px', marginTop: '14px', paddingTop: '14px', borderTop: '1px solid #1a3a4a', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                    {cash !== 0 && <div><span style={{ color: '#607d8b' }}>CASH: </span><span style={{ color: cash >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>${fmt(cash)}</span></div>}
                    {bp !== 0 && <div><span style={{ color: '#607d8b' }}>BUYING POWER: </span><span style={{ color: '#4fc3f7', fontWeight: 600 }}>${fmt(bp)}</span></div>}
                  </div>
                )}
                {w.notes && (
                  <div style={{ marginTop: '10px', paddingTop: '10px', borderTop: '1px solid #1a3a4a', fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                    {w.notes}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}