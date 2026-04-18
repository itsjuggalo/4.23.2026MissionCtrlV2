'use client';
import { useState, useEffect } from 'react';

export function ScannerPage() {
  const [regime, setRegime] = useState<any>(null);
  const [crypto, setCrypto] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchData() {
      const [rRes, cRes, sRes] = await Promise.all([
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/crypto').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
      ]);
      setRegime(rRes); setCrypto(cRes); setSignals(sRes);
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 30000);
    return () => clearInterval(i);
  }, []);

  const fmt = (n: number) => n?.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) || '0.00';

  // Parse regime data
  const regimeData = regime?.regime || regime?.current_regime || 'Unknown';
  const regimeColor = regimeData === 'trending_up' ? '#66bb6a' : regimeData === 'trending_down' ? '#ef5350' : regimeData === 'ranging' ? '#ff9800' : '#4fc3f7';

  // Parse crypto
  const btcData = crypto?.BTC || crypto?.btc || {};
  const ethData = crypto?.ETH || crypto?.eth || {};
  const solData = crypto?.SOL || crypto?.sol || {};
  const btcPrice = btcData.price || btcData.usd || 0;
  const ethPrice = ethData.price || ethData.usd || 0;
  const solPrice = solData.price || solData.usd || 0;

  // Signal state
  const sigState = signals?.BTCUSD || signals?.btcusd || {};
  const lastAction = sigState.last_action || sigState.direction || 'NONE';
  const signalCount = sigState.signal_count || 0;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      SCANNING MARKETS...
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`
        .scan-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; }
        @keyframes scanLine { 0% { transform: translateX(-100%); } 100% { transform: translateX(200%); } }
      `}</style>

      {/* Market Regime Hero */}
      <div className="scan-card" style={{ padding: '32px', textAlign: 'center', marginBottom: '20px', borderBottom: `3px solid ${regimeColor}` }}>
        <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>CURRENT MARKET REGIME</div>
        <div style={{ fontSize: '36px', fontWeight: 900, color: regimeColor, fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase', letterSpacing: '3px' }}>
          {regimeData.replace('_', ' ')}
        </div>
        <div style={{ marginTop: '12px', fontSize: '13px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
          SuperTrend Signal: <span style={{ color: lastAction === 'BUY' ? '#66bb6a' : '#ef5350', fontWeight: 700 }}>{lastAction}</span>
          <span style={{ margin: '0 12px', color: '#1a3a4a' }}>|</span>
          {signalCount} signals processed
        </div>
      </div>

      {/* Price Tickers */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '12px', marginBottom: '20px' }}>
        {[
          { symbol: 'BTC', price: btcPrice, color: '#ff9800' },
          { symbol: 'ETH', price: ethPrice, color: '#627eea' },
          { symbol: 'SOL', price: solPrice, color: '#9945ff' },
        ].map((c, i) => (
          <div key={i} className="scan-card" style={{ padding: '20px 24px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <div>
                <div style={{ fontSize: '14px', fontWeight: 700, color: c.color, fontFamily: 'var(--font-mc-mono)' }}>{c.symbol}</div>
                <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>USD</div>
              </div>
              <div style={{ fontSize: '24px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                ${c.price > 1000 ? c.price.toLocaleString(undefined, { maximumFractionDigits: 0 }) : fmt(c.price)}
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Scanner Grid */}
      <div style={{ fontSize: '13px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #4fc3f744' }}>
        ACTIVE SCANNERS
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '12px' }}>
        {[
          { name: 'SuperTrend 1H', status: 'Active', desc: 'ATR 7, Mult 5.0 — BTC/USD on Coinbase', source: 'TradingView → Signal Receiver', color: '#66bb6a' },
          { name: 'Option Flow Monitor', status: 'Active', desc: 'Scraping unusual options activity', source: 'Firebase Vivid2', color: '#66bb6a' },
          { name: 'Telegram Listener', status: 'Active', desc: '9 channels — crypto signals + whale alerts', source: 'Telethon + WebSocket', color: '#66bb6a' },
          { name: 'Whale Flow Filter', status: 'Active', desc: 'Filtering high-value options flow from scraper', source: 'Cron every 5 min', color: '#66bb6a' },
          { name: 'Regime Detector', status: 'Active', desc: 'Multi-timeframe regime classification', source: 'Cron every 4 hours', color: '#66bb6a' },
          { name: 'Market Aggregator', status: 'Active', desc: 'Hourly market briefing data fetch', source: 'Cron every hour', color: '#66bb6a' },
          { name: 'go-trader Hyperliquid', status: 'Active', desc: '30 strategies across BTC/ETH/SOL perps', source: 'Cron every 5 min', color: '#66bb6a' },
          { name: 'SuperTrend 30m', status: 'Planned', desc: 'Second timeframe layer — not yet deployed', source: 'Pending', color: '#ff9800' },
        ].map((scanner, i) => (
          <div key={i} className="scan-card" style={{ padding: '18px 20px', borderLeft: `3px solid ${scanner.color}` }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
              <span style={{ fontSize: '15px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{scanner.name}</span>
              <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${scanner.color}22`, color: scanner.color, fontFamily: 'var(--font-mc-mono)' }}>{scanner.status.toUpperCase()}</span>
            </div>
            <div style={{ fontSize: '12px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>{scanner.desc}</div>
            <div style={{ fontSize: '10px', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{scanner.source}</div>
          </div>
        ))}
      </div>
    </div>
  );
}
