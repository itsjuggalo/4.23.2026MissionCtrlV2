'use client';
import { useState, useEffect } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

function tickerOnly(sym: string): string {
  if (!sym) return '';
  const s = String(sym).trim().toUpperCase();
  const occMatch = s.match(/^([A-Z]+)\d{6}[CP]/);
  if (occMatch) return occMatch[1];
  const firstWord = s.split(/[\s/]/)[0];
  return firstWord.replace(/[^A-Z]/g, '') || s;
}

// Types
type CryptoData = { BTC?: { price?: number }; ETH?: { price?: number }; SOL?: { price?: number }; DOGE?: { price?: number }; [key: string]: unknown };
type RegimeData = { overall_regime?: string; regime?: string };
type SignalsData = { BTCUSD?: { last_action?: string; direction?: string }; btcusd?: { last_action?: string; direction?: string }; [key: string]: unknown };
type TelegramSignal = { score?: number; symbol?: string; direction?: string; entry?: string | number; channel_name?: string };
type SqueezeData = { candidates: { ticker?: string; score?: number; si_pct?: number | null; dtc?: number | null; sweep?: boolean; price?: number | null; from_hi_pct?: number | null }[] };
type LiqData = {
  bias: string;
  top_coins: { sym: string; total: number; long: number; short?: number }[];
  largest: unknown[];
  total?: number;
  events_total?: number;
  long_liq?: number;
  short_liq?: number;
};

export function ScannerPage() {
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);
  const [crypto, setCrypto] = useState<CryptoData | null>(null);
  const [regime, setRegime] = useState<RegimeData | null>(null);
  const [signals, setSignals] = useState<SignalsData | null>(null);
  const [telegram, setTelegram] = useState<TelegramSignal[]>([]);
  const [squeeze, setSqueeze] = useState<SqueezeData>({ candidates: [] });
  const [liq, setLiq] = useState<LiqData>({ bias: 'NO_DATA', top_coins: [], largest: [] });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [lastUpdate, setLastUpdate] = useState<Date | null>(null);

  useEffect(() => {
    async function fetchAll() {
      try {
        const [cRes, rRes, sRes, tRes, qRes, lRes] = await Promise.all([
          fetch('/api/crypto').then(r => r.ok ? r.json() : {}).catch(() => ({})),
          fetch('/api/regime').then(r => r.ok ? r.json() : {}).catch(() => ({})),
          fetch('/api/signals/latest').then(r => r.ok ? r.json() : {}).catch(() => ({})),
          fetch('/api/telegram-signals?limit=10').then(r => r.ok ? r.json() : []).catch(() => []),
          fetch('/api/squeeze-alerts', { cache: 'no-store' }).then(r => r.ok ? r.json() : { candidates: [] }).catch(() => ({ candidates: [] })),
          fetch('/api/liquidations', { cache: 'no-store' }).then(r => r.ok ? r.json() : { bias: 'NO_DATA', top_coins: [], largest: [] }).catch(() => ({ bias: 'NO_DATA', top_coins: [], largest: [] })),
        ]);
        setCrypto(cRes); setRegime(rRes); setSignals(sRes);
        setTelegram(Array.isArray(tRes) ? tRes : tRes.signals || []);
        setSqueeze(qRes); setLiq(lRes);
        setLastUpdate(new Date());
        setError(false);
      } catch { setError(true); }
      setLoading(false);
    }
    fetchAll();
    const i = setInterval(fetchAll, 15000);
    return () => clearInterval(i);
  }, []);

  const fmt = (n: number) => n?.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) || '0.00';
  const _fmtK = (n: number) => n > 1000 ? `$${(n / 1000).toFixed(1)}K` : `$${fmt(n)}`;

  const regimeData = regime?.overall_regime || regime?.regime || 'Unknown';
  const regimeColor = regimeData.includes('UP') || regimeData.includes('BULL') ? '#66bb6a' : regimeData.includes('DOWN') || regimeData.includes('BEAR') ? '#ef5350' : '#ff9800';

  const btc = crypto?.BTC?.price || 0;
  const eth = crypto?.ETH?.price || 0;
  const sol = crypto?.SOL?.price || 0;
  const doge = crypto?.DOGE?.price || 0;

  const sigState = signals?.BTCUSD || signals?.btcusd || {};
  const lastAction = sigState.last_action || sigState.direction || 'NONE';

  // Recent high-score telegram signals
  const hotSignals = telegram.filter(s => (s.score ?? 0) >= 50).slice(0, 6);

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      SCANNING MARKETS...
    </div>
  );
  const errBanner = error ? <div style={{ padding: '10px 16px', background: '#ef535014', border: '1px solid #ef535033', borderRadius: '6px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', marginBottom: '12px' }}>⚠ One or more data sources unavailable — retrying every 15s</div> : null;

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`.scan-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; }`}</style>
      {errBanner}
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
              <div key={s.symbol || i} className="scan-card" onClick={() => setDrawerTicker(tickerOnly(s.symbol || ''))} style={{ padding: '14px 16px', borderLeft: `3px solid ${s.direction === 'LONG' ? '#66bb6a' : s.direction === 'SHORT' ? '#ef5350' : '#ff9800'}`, cursor: 'pointer' }}>
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

      {/* Squeeze Candidates */}
      {squeeze?.candidates?.length > 0 && (
        <>
          <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#ff9800', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px', paddingBottom: '4px', borderBottom: '2px solid #ff980044' }}>
            SQUEEZE CANDIDATES (SCORE 50+)
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(220px, 1fr))', gap: '8px', marginBottom: '20px' }}>
            {squeeze.candidates.slice(0, 12).map((c: any, i: number) => {
              const tone = c.score >= 70 ? '#ef5350' : c.score >= 60 ? '#ff9800' : '#fdd835';
              return (
                <div key={c.ticker || i} className="scan-card" onClick={() => setDrawerTicker(tickerOnly(c.ticker || ''))} style={{ padding: '12px 14px', borderLeft: `3px solid ${tone}`, cursor: 'pointer' }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '6px' }}>
                    <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{c.ticker}</span>
                    <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, padding: '2px 8px', borderRadius: '4px', background: `${tone}22`, color: tone, fontFamily: 'var(--font-mc-mono)' }}>{c.score}</span>
                  </div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>
                    SI {c.si_pct != null ? `${c.si_pct.toFixed(1)}%` : '—'} · DTC {c.dtc != null ? c.dtc.toFixed(1) : '—'}{c.sweep ? ' · 🐋' : ''}
                  </div>
                  {c.price != null && c.price > 0 && (
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>
                      ${c.price.toFixed(2)}{c.from_hi_pct != null && c.from_hi_pct > -5 ? ` · ${c.from_hi_pct.toFixed(1)}% vs 52w-hi` : ''}
                    </div>
                  )}
                </div>
              );
            })}
          </div>
        </>
      )}

      {/* Liquidation Bias */}
      {(liq?.total ?? 0) > 0 && (
        <>
          <div style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, color: '#9c27b0', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '10px', paddingBottom: '4px', borderBottom: '2px solid #9c27b044' }}>
            CRYPTO LIQUIDATIONS · LAST 4H
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '20px' }}>
            <div className="scan-card" style={{ padding: '18px 20px', borderBottom: `3px solid ${liq.bias === 'LONGS_WRECKED' ? '#ef5350' : liq.bias === 'SHORTS_WRECKED' ? '#66bb6a' : '#607d8b'}` }}>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '6px' }}>BIAS</div>
              <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 900, color: liq.bias === 'LONGS_WRECKED' ? '#ef5350' : liq.bias === 'SHORTS_WRECKED' ? '#66bb6a' : '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                {liq.bias.replace('_', ' ')}
              </div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', marginTop: '6px' }}>
                Total: ${((liq.total ?? 0) / 1_000_000).toFixed(2)}M · {liq.events_total} events
              </div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>
                🔴 Longs liq: ${((liq.long_liq ?? 0) / 1_000_000).toFixed(2)}M
              </div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>
                🟢 Shorts liq: ${((liq.short_liq ?? 0) / 1_000_000).toFixed(2)}M
              </div>
            </div>
            <div className="scan-card" style={{ padding: '14px 18px' }}>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>TOP COINS</div>
              {liq.top_coins.slice(0, 6).map((c: any, i: number) => {
                const longShare = c.total > 0 ? (c.long / c.total) * 100 : 50;
                const tone = longShare > 65 ? '#ef5350' : longShare < 35 ? '#66bb6a' : '#607d8b';
                return (
                  <div key={c.sym || i} style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', marginBottom: '3px' }}>
                    <span style={{ color: '#e0e0e0', fontWeight: 700 }}>{c.sym}</span>
                    <span style={{ color: tone }}>${c.total >= 1_000_000 ? `${(c.total/1_000_000).toFixed(2)}M` : `${(c.total/1000).toFixed(0)}K`}</span>
                  </div>
                );
              })}
            </div>
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
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
