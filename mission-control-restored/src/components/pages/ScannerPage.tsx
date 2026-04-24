'use client';
import { useState, useEffect } from 'react';

export function ScannerPage() {
  const [crypto, setCrypto] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [telegram, setTelegram] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const [lastUpdate, setLastUpdate] = useState<Date | null>(null);

  useEffect(() => {
    async function fetchAll() {
      const [cRes, rRes, sRes, tRes] = await Promise.all([
        fetch('/api/crypto').then(r => r.json()).catch(() => ({})),
        fetch('/api/regime').then(r => r.json()).catch(() => ({})),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
        fetch('/api/telegram-signals?limit=10').then(r => r.json()).catch(() => []),
      ]);
      setCrypto(cRes); setRegime(rRes); setSignals(sRes);
      setTelegram(Array.isArray(tRes) ? tRes : tRes.signals || []);
      setLastUpdate(new Date());
      setLoading(false);
    }
    fetchAll();
    const i = setInterval(fetchAll, 15000);
    return () => clearInterval(i);
  }, []);

  const fmt = (n: number) => n?.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) || '0.00';
  const fmtK = (n: number) => n > 1000 ? `$${(n / 1000).toFixed(1)}K` : `$${fmt(n)}`;

  const regimeData = regime?.overall_regime || regime?.regime || 'Unknown';
  const regimeColor = regimeData.includes('UP') || regimeData.includes('BULL') ? '#66bb6a' : regimeData.includes('DOWN') || regimeData.includes('BEAR') ? '#ef5350' : '#ff9800';

  const btc = crypto?.BTC?.price || 0;
  const eth = crypto?.ETH?.price || 0;
  const sol = crypto?.SOL?.price || 0;
  const doge = crypto?.DOGE?.price || 0;

  const sigState = signals?.BTCUSD || signals?.btcusd || {};
  const lastAction = sigState.last_action || sigState.direction || 'NONE';

  // Recent high-score telegram signals
  const hotSignals = telegram.filter(s => s.score >= 50).slice(0, 6);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      SCANNING MARKETS...
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`.scan-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; }`}</style>

      {/* Status bar */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '16px', padding: '8px 14px', background: '#66bb6a0d', border: '1px solid #66bb6a33', borderRadius: '6px' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88', animation: 'pulse 2s infinite' }} />
        <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>LIVE SCANNING</span>
        {lastUpdate && <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Updated {Math.floor((Date.now() - lastUpdate.getTime()) / 1000)}s ago · 15s refresh</span>}
        <style>{`@keyframes pulse { 0%,100% { opacity:1; } 50% { opacity:0.4; } }`}</style>
      </div>

      {/* Regime + Signal */}
      <div style={{ display: 'grid', gridTemplateColumns: '2fr 1fr', gap: '12px', marginBottom: '16px' }}>
        <div className="scan-card" style={{ padding: '24px', textAlign: 'center', borderBottom: `3px solid ${regimeColor}` }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '6px' }}>MARKET REGIME</div>
          <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 900, color: regimeColor, fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>
            {regimeData.replace(/_/g, ' ')}
          </div>
        </div>
        <div className="scan-card" style={{ padding: '24px', textAlign: 'center', borderBottom: `3px solid ${lastAction === 'BUY' ? '#66bb6a' : '#ef5350'}` }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '6px' }}>SUPERTREND 1H</div>
          <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 900, color: lastAction === 'BUY' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
            {lastAction}
          </div>
        </div>
      </div>

      {/* Live Prices */}
      <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px', paddingBottom: '4px', borderBottom: '2px solid #4fc3f744' }}>
        LIVE PRICES
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '10px', marginBottom: '20px' }}>
        {[
          { sym: 'BTC', price: btc, color: '#ff9800' },
          { sym: 'ETH', price: eth, color: '#627eea' },
          { sym: 'SOL', price: sol, color: '#9945ff' },
          { sym: 'DOGE', price: doge, color: '#c2a633' },
        ].map((c, i) => (
          <div key={i} className="scan-card" style={{ padding: '16px 20px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: c.color, fontFamily: 'var(--font-mc-mono)' }}>{c.sym}</span>
              <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                {c.price > 1000 ? `$${c.price.toLocaleString(undefined, { maximumFractionDigits: 0 })}` : `$${fmt(c.price)}`}
              </span>
            </div>
          </div>
        ))}
      </div>

      {/* Hot Signals from Telegram */}
      {hotSignals.length > 0 && (
        <>
          <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px', paddingBottom: '4px', borderBottom: '2px solid #ef535044' }}>
            HOT SIGNALS (SCORE 50+)
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(260px, 1fr))', gap: '8px', marginBottom: '20px' }}>
            {hotSignals.map((s: any, i: number) => (
              <div key={i} className="scan-card" style={{ padding: '14px 16px', borderLeft: `3px solid ${s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#ff9800'}` }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '6px' }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                    <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{s.symbol || '?'}</span>
                    {s.direction && <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, padding: '2px 6px', borderRadius: '3px', background: s.direction === 'LONG' ? '#66bb6a22' : '#ef535022', color: s.direction === 'LONG' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{s.direction}</span>}
                  </div>
                  <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: s.score >= 70 ? '#66bb6a22' : '#ff980022', color: s.score >= 70 ? '#66bb6a' : '#ff9800', fontFamily: 'var(--font-mc-mono)' }}>{s.score}</span>
                </div>
                {s.entry && <div style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>Entry: ${s.entry}</div>}
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{s.channel_name?.slice(0, 25) || ''}</div>
              </div>
            ))}
          </div>
        </>
      )}

      {/* Active Scanners */}
      <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px', paddingBottom: '4px', borderBottom: '2px solid #66bb6a44' }}>
        ACTIVE SCANNERS
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '10px' }}>
        {[
          { name: 'SuperTrend 1H', desc: 'ATR 7 · BTC/USD Coinbase', freq: 'Webhook', color: '#66bb6a' },
          { name: 'Telegram Listener', desc: `${telegram.length > 0 ? telegram.length : '9 ch'} signals`, freq: 'Real-time', color: '#66bb6a' },
          { name: 'Option Flow', desc: 'Firebase Vivid2 scraper', freq: '5 min', color: '#66bb6a' },
          { name: 'go-trader HL', desc: '30 strategies BTC/ETH/SOL', freq: '5 min', color: '#66bb6a' },
          { name: 'Regime Detector', desc: `Current: ${regimeData.replace(/_/g, ' ')}`, freq: '4 hours', color: '#66bb6a' },
          { name: 'Market Aggregator', desc: 'Hourly briefing for agents', freq: 'Hourly', color: '#66bb6a' },
          { name: 'Whale Flow', desc: 'High-value options filter', freq: '5 min', color: '#66bb6a' },
          { name: 'SuperTrend 30m', desc: 'Second timeframe layer', freq: 'Planned', color: '#ff9800' },
        ].map((s, i) => (
          <div key={i} className="scan-card" style={{ padding: '14px 18px', borderLeft: `3px solid ${s.color}`, display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
            <div>
              <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{s.name}</div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>{s.desc}</div>
            </div>
            <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, padding: '3px 8px', borderRadius: '4px', background: `${s.color}22`, color: s.color, fontFamily: 'var(--font-mc-mono)' }}>{s.freq.toUpperCase()}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
