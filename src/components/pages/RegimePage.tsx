'use client';

import { useEffect, useState } from 'react';

interface RegimeData {
  regime: string;
  regime_score: number;
  indicators: { vix: number; treasury_10y: number; unemployment: number; cpi_tomorrow: boolean };
  allocation: { equities: number; bonds: number; cash: number; rationale: string };
  guidance: { position_sizing: string; sectors: string; avoid: string; stops: string; new_trades: string };
}

const MOCK_REGIME: RegimeData = {
  regime: 'Walking on Ice',
  regime_score: -1,
  indicators: { vix: 23.87, treasury_10y: 4.31, unemployment: 3.9, cpi_tomorrow: false },
  allocation: { equities: 0.5, bonds: 0.3, cash: 0.2, rationale: 'Defensive positioning, reduced risk, high selectivity' },
  guidance: {
    position_sizing: 'Reduced (50-75% normal)',
    sectors: 'Quality growth, large caps, dividend payers',
    avoid: 'Speculative, small caps, high volatility',
    stops: 'Normal (5-7%)',
    new_trades: 'Selective, wait for confirmation',
  },
};

const REGIME_COLOR: Record<number, string> = { 1: '#2ed573', 0: '#ff9800', '-1': '#ef5350', '-2': '#ef5350' };

export function RegimePage() {
  const [regime, setRegime] = useState<RegimeData>(MOCK_REGIME);
  const [loading, setLoading] = useState(false);
  const [lastUpdate, setLastUpdate] = useState(new Date());

  const fetchRegime = async () => {
    setLoading(true);
    try {
      const res = await fetch('/api/regime');
      if (res.ok) {
        const data = await res.json();
        if (data.regime) setRegime(data);
      }
    } catch { /* use mock */ }
    setLoading(false);
    setLastUpdate(new Date());
  };

  useEffect(() => {
    fetchRegime();
    const t = setInterval(fetchRegime, 60000);
    return () => clearInterval(t);
  }, []);

  const scoreColor = REGIME_COLOR[regime.regime_score] || '#ff9800';

  return (
    <div style={{ padding: '24px 28px', fontFamily: "'Inter', -apple-system, sans-serif", background: '#0a0a10', minHeight: '100vh' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 24 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 700, color: '#e0e0e0', margin: 0 }}>Macro Regime</h1>
          <p style={{ fontSize: 12, color: '#607d8b', marginTop: 4, fontFamily: "'JetBrains Mono', monospace" }}>
            Updated {lastUpdate.toLocaleTimeString()} {loading && '· refreshing...'}
          </p>
        </div>
        <button onClick={fetchRegime} style={{ padding: '6px 14px', background: '#1a3a4a', border: '1px solid #2e2e3a', borderRadius: 8, color: '#455a64', cursor: 'pointer', fontSize: 12 }}>
          Refresh
        </button>
      </div>

      {/* Regime Banner */}
      <div style={{ background: `${scoreColor}10`, border: `1px solid ${scoreColor}40`, borderRadius: 12, padding: '20px 24px', marginBottom: 20 }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <div>
            <div style={{ fontSize: 11, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 6 }}>CURRENT REGIME</div>
            <div style={{ fontSize: 26, fontWeight: 700, color: scoreColor }}>{regime.regime}</div>
            <div style={{ fontSize: 12, color: '#455a64', marginTop: 6 }}>{regime.allocation.rationale}</div>
          </div>
          <div style={{ textAlign: 'center' }}>
            <div style={{ fontSize: 36, fontWeight: 700, color: scoreColor, fontFamily: "'JetBrains Mono', monospace" }}>{regime.regime_score > 0 ? '+' : ''}{regime.regime_score}</div>
            <div style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>SCORE (-2 to +2)</div>
          </div>
        </div>
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 16, marginBottom: 20 }}>
        {/* Indicators */}
        <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px' }}>
          <div style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 14 }}>INDICATORS</div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
            {[
              { label: 'VIX', value: regime.indicators.vix.toFixed(2), status: regime.indicators.vix > 25 ? 'high' : 'normal', color: regime.indicators.vix > 25 ? '#ef5350' : '#2ed573' },
              { label: '10Y Yield', value: `${regime.indicators.treasury_10y.toFixed(2)}%`, status: 'neutral', color: '#ff9800' },
              { label: 'Unemployment', value: `${regime.indicators.unemployment.toFixed(1)}%`, status: 'stable', color: '#2ed573' },
              { label: 'CPI Status', value: regime.indicators.cpi_tomorrow ? 'TOMORROW' : 'Not imminent', status: regime.indicators.cpi_tomorrow ? 'warning' : 'ok', color: regime.indicators.cpi_tomorrow ? '#ff9800' : '#2ed573' },
            ].map((ind) => (
              <div key={ind.label} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '8px 12px', background: '#13131e', borderRadius: 8 }}>
                <span style={{ fontSize: 12, color: '#455a64' }}>{ind.label}</span>
                <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
                  <span style={{ fontSize: 13, fontWeight: 700, color: '#e0e0e0', fontFamily: "'JetBrains Mono', monospace" }}>{ind.value}</span>
                  <span style={{ width: 7, height: 7, borderRadius: '50%', background: ind.color }} />
                </div>
              </div>
            ))}
          </div>
        </div>

        {/* Allocation */}
        <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px' }}>
          <div style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 14 }}>RECOMMENDED ALLOCATION</div>
          {[
            { label: 'Equities', pct: regime.allocation.equities * 100, color: '#4fc3f7' },
            { label: 'Bonds', pct: regime.allocation.bonds * 100, color: '#0984e3' },
            { label: 'Cash', pct: regime.allocation.cash * 100, color: '#2ed573' },
          ].map((a) => (
            <div key={a.label} style={{ marginBottom: 12 }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 4 }}>
                <span style={{ fontSize: 12, color: '#455a64' }}>{a.label}</span>
                <span style={{ fontSize: 12, fontWeight: 700, color: a.color, fontFamily: "'JetBrains Mono', monospace" }}>{a.pct}%</span>
              </div>
              <div style={{ background: '#1a3a4a', borderRadius: 4, height: 6, overflow: 'hidden' }}>
                <div style={{ background: a.color, width: `${a.pct}%`, height: '100%', borderRadius: 4 }} />
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Trading Guidance */}
      <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: '18px 20px' }}>
        <div style={{ fontSize: 12, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px', marginBottom: 14 }}>TRADING GUIDANCE</div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 10 }}>
          {[
            { label: 'Position Sizing', value: regime.guidance.position_sizing, color: '#ff9800' },
            { label: 'Favor Sectors', value: regime.guidance.sectors, color: '#2ed573' },
            { label: 'Avoid', value: regime.guidance.avoid, color: '#ef5350' },
            { label: 'Stop Losses', value: regime.guidance.stops, color: '#455a64' },
            { label: 'New Trades', value: regime.guidance.new_trades, color: '#4fc3f7' },
          ].map((g) => (
            <div key={g.label} style={{ padding: '10px 12px', background: '#13131e', borderRadius: 8, borderLeft: `3px solid ${g.color}` }}>
              <div style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", marginBottom: 4 }}>{g.label}</div>
              <div style={{ fontSize: 12, color: '#c8c8d4', lineHeight: 1.4 }}>{g.value}</div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default RegimePage;
