'use client';
import { useEffect, useState } from 'react';

// ============================================================================
// TERRAN REGIME ANALYZER — Market Conditions Intelligence
// Multi-timeframe regime detection, trend strength, strategy guidance
// ============================================================================

export function RegimePage() {
  const [regime, setRegime] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [params, setParams] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [tick, setTick] = useState(0);

  const fetchAll = async () => {
    try {
      const [rRes, sRes, pRes] = await Promise.all([
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
        fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
      ]);
      if (rRes) setRegime(rRes);
      if (sRes) setSignals(sRes);
      if (pRes) setParams(pRes);
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  };

  useEffect(() => {
    fetchAll();
    const d = setInterval(fetchAll, 30000);
    const t = setInterval(() => setTick(x => x + 1), 1000);
    return () => { clearInterval(d); clearInterval(t); };
  }, []);

  const overallRegime = regime?.overall_regime || 'UNKNOWN';
  const overallBias = regime?.direction_bias || '';
  const recommendation = regime?.overall_recommendation || '';
  const timeframes = regime?.timeframes || {};
  const btcSignal = signals?.BTCUSD || {};
  const currentPrice = Object.values(timeframes)[0] as any;
  const price = currentPrice?.current_price || 0;

  const fmt = (n: number, d = 2) => n?.toFixed(d) || 'N/A';

  const REGIME_COLORS: Record<string, string> = {
    'STRONG_TREND': '#66bb6a', 'TRENDING': '#66bb6a', 'WEAK_TREND': '#ff9800',
    'TRANSITIONAL': '#ff9800', 'MIXED': '#ff9800', 'MIXED_TREND': '#ff9800',
    'CHOPPY': '#ef5350', 'RANGING': '#4fc3f7', 'VOLATILE': '#ef5350',
    'BULLISH': '#66bb6a', 'BEARISH': '#ef5350', 'NEUTRAL': '#607d8b',
  };

  const getColor = (key: string) => REGIME_COLORS[key] || '#607d8b';

  const STRATEGY_MAP: Record<string, { strategy: string; sizing: string; style: string }> = {
    'STRONG_TREND': { strategy: 'Trend Following — SuperTrend, breakout entries', sizing: 'Full size (10% per trade)', style: 'Aggressive — ride the wave' },
    'TRENDING': { strategy: 'Trend Following — pullback entries', sizing: 'Normal size (8% per trade)', style: 'Confident — buy dips in trend' },
    'WEAK_TREND': { strategy: 'Hybrid — trend + mean reversion', sizing: 'Reduced (5% per trade)', style: 'Selective — only A+ setups' },
    'TRANSITIONAL': { strategy: 'Wait for confirmation — no new entries', sizing: 'Light (3% per trade)', style: 'Patient — regime changing' },
    'MIXED': { strategy: 'Mixed approach — scalp + swing', sizing: 'Light (5% per trade)', style: 'Adaptable — read each setup' },
    'MIXED_TREND': { strategy: 'Careful trend following — tight stops', sizing: 'Light (5% per trade)', style: 'Cautious — mixed signals' },
    'CHOPPY': { strategy: 'Mean Reversion — fade extremes', sizing: 'Minimal (3% per trade)', style: 'Defensive — expect whipsaws' },
    'RANGING': { strategy: 'Range Trading — buy support, sell resistance', sizing: 'Normal (7% per trade)', style: 'Structured — clear levels' },
    'VOLATILE': { strategy: 'Reduce exposure — widen stops or sit out', sizing: 'Minimal (2% per trade)', style: 'Protective — capital preservation' },
  };

  const strat = STRATEGY_MAP[overallRegime] || STRATEGY_MAP['MIXED'];

  // Gauge component
  const Gauge = ({ value, max, label, color, unit }: { value: number; max: number; label: string; color: string; unit?: string }) => {
    const pct = Math.min((value / max) * 100, 100);
    return (
      <div style={{ textAlign: 'center' }}>
        <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px', letterSpacing: '1px' }}>{label}</div>
        <div style={{ position: 'relative', width: '100%', height: '8px', background: '#0d1117', borderRadius: '4px', overflow: 'hidden' }}>
          <div style={{
            position: 'absolute', top: 0, left: 0, height: '100%',
            width: `${pct}%`, background: `linear-gradient(90deg, ${color}44, ${color})`,
            borderRadius: '4px', transition: 'width 0.8s ease-out',
          }} />
        </div>
        <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color, fontFamily: 'var(--font-mc-mono)', marginTop: '6px' }}>
          {fmt(value, 1)}{unit || ''}
        </div>
      </div>
    );
  };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'rg-blink 1s infinite' }}>ANALYZING MARKET REGIME...</div>
    </div>
  );

  return (
    <div style={{ padding: '20px', maxWidth: '1400px', margin: '0 auto' }}>
      <style>{`
        @keyframes rg-blink { 0%,100% { opacity: 1; } 50% { opacity: 0.3; } }
        @keyframes rg-pulse { 0%,100% { transform: scale(1); } 50% { transform: scale(1.05); } }
        @keyframes rg-glow { 0%,100% { box-shadow: 0 0 10px #4fc3f711; } 50% { box-shadow: 0 0 25px #4fc3f722; } }
        .rg-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; }
        .rg-label { font-size: 10px; color: #607d8b; text-transform: uppercase; letter-spacing: 1.5px; font-family: var(--font-mc-mono); }
      `}</style>

      {/* === REGIME HERO === */}
      <div className="rg-card" style={{
        padding: '28px 32px', marginBottom: '16px', textAlign: 'center',
        animation: 'rg-glow 4s ease-in-out infinite',
        borderColor: getColor(overallRegime) + '44',
      }}>
        <div className="rg-label" style={{ marginBottom: '10px' }}>CURRENT MARKET REGIME</div>
        <div style={{
          fontSize: '42px', fontWeight: 900, fontFamily: 'var(--font-mc-mono)',
          color: getColor(overallRegime), letterSpacing: '4px',
          textShadow: `0 0 30px ${getColor(overallRegime)}44`,
        }}>
          {overallRegime.replace(/_/g, ' ')}
        </div>
        <div style={{ fontSize: 'var(--mc-font-lg)', color: getColor(overallBias), marginTop: '8px', fontFamily: 'var(--font-mc-mono)' }}>
          BIAS: {overallBias || 'NEUTRAL'} {overallBias === 'BULLISH' ? '▲' : overallBias === 'BEARISH' ? '▼' : '—'}
        </div>
        {recommendation && (
          <div style={{ fontSize: 'var(--mc-font-xs)', color: '#607d8b', marginTop: '8px', fontStyle: 'italic' }}>{recommendation}</div>
        )}
        {price > 0 && (
          <div style={{ fontSize: 'var(--mc-font-sm)', color: '#4fc3f7', marginTop: '10px', fontFamily: 'var(--font-mc-mono)' }}>
            BTC: ${price.toLocaleString()} | SuperTrend: {btcSignal.direction || 'N/A'}
          </div>
        )}
      </div>

      {/* === STRATEGY RECOMMENDATION === */}
      <div className="rg-card" style={{ padding: '20px 24px', marginBottom: '16px', borderLeft: `4px solid ${getColor(overallRegime)}` }}>
        <div className="rg-label" style={{ marginBottom: '12px' }}>STRATEGY RECOMMENDATION FOR {overallRegime.replace(/_/g, ' ')}</div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '16px' }}>
          <div>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>APPROACH</div>
            <div style={{ fontSize: 'var(--mc-font-sm)', color: '#e0e0e0', lineHeight: '1.5' }}>{strat.strategy}</div>
          </div>
          <div>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>POSITION SIZING</div>
            <div style={{ fontSize: 'var(--mc-font-sm)', color: '#4fc3f7' }}>{strat.sizing}</div>
          </div>
          <div>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>TRADING STYLE</div>
            <div style={{ fontSize: 'var(--mc-font-sm)', color: getColor(overallRegime) }}>{strat.style}</div>
          </div>
        </div>
      </div>

      {/* === TIMEFRAME ANALYSIS CARDS === */}
      <div className="rg-label" style={{ marginBottom: '10px', padding: '0 4px' }}>MULTI-TIMEFRAME BREAKDOWN</div>
      <div style={{ display: 'grid', gridTemplateColumns: `repeat(${Object.keys(timeframes).length || 3}, 1fr)`, gap: '12px', marginBottom: '16px' }}>
        {Object.entries(timeframes).length === 0 ? (
          <div className="rg-card" style={{ padding: '30px', textAlign: 'center', color: '#455a64', gridColumn: '1 / -1' }}>
            <div style={{ fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)' }}>Awaiting regime data from market_regime.json...</div>
          </div>
        ) : Object.entries(timeframes).map(([tf, data]: [string, any]) => {
          const dirColor = getColor(data.direction || '');
          const regColor = getColor(data.regime || '');
          const adx = data.adx || 0;
          const chop = data.choppiness || 0;
          const eff = data.trend_efficiency || 0;
          const plusDI = data.plus_di || 0;
          const minusDI = data.minus_di || 0;
          const bbw = data.bbw || 0;

          return (
            <div key={tf} className="rg-card" style={{ padding: '20px', borderTop: `3px solid ${dirColor}` }}>
              {/* TF Header */}
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px' }}>
                <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 800, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{tf}</div>
                <div style={{
                  fontSize: 'var(--mc-font-label)', fontWeight: 600, color: dirColor, fontFamily: 'var(--font-mc-mono)',
                  padding: '4px 12px', borderRadius: '6px', background: `${dirColor}15`, border: `1px solid ${dirColor}33`,
                }}>
                  {data.direction || 'N/A'}
                </div>
              </div>

              {/* Regime label */}
              <div style={{ textAlign: 'center', marginBottom: '16px' }}>
                <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: regColor, fontFamily: 'var(--font-mc-mono)' }}>
                  {(data.regime || 'UNKNOWN').replace(/_/g, ' ')}
                </div>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', marginTop: '2px' }}>{data.recommended_strategy || ''}</div>
              </div>

              {/* Gauges */}
              <div style={{ display: 'flex', flexDirection: 'column', gap: '14px' }}>
                <Gauge value={adx} max={60} label="ADX — TREND STRENGTH" color={adx > 25 ? '#66bb6a' : adx > 15 ? '#ff9800' : '#ef5350'} />
                <Gauge value={chop} max={100} label="CHOPPINESS INDEX" color={chop > 60 ? '#ef5350' : chop > 40 ? '#ff9800' : '#66bb6a'} />
                <Gauge value={eff * 100} max={50} label="TREND EFFICIENCY" color={eff > 0.2 ? '#66bb6a' : eff > 0.1 ? '#ff9800' : '#ef5350'} unit="%" />
                <Gauge value={bbw} max={10} label="BOLLINGER WIDTH" color={bbw > 4 ? '#ef5350' : bbw > 2 ? '#ff9800' : '#66bb6a'} unit="%" />
              </div>

              {/* DI Comparison */}
              <div style={{ marginTop: '16px', padding: '12px', background: '#0d1117', borderRadius: '6px' }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px', letterSpacing: '1px' }}>DIRECTIONAL MOVEMENT</div>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '6px' }}>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>+DI: {fmt(plusDI, 1)}</span>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>-DI: {fmt(minusDI, 1)}</span>
                </div>
                <div style={{ display: 'flex', height: '10px', borderRadius: '5px', overflow: 'hidden', background: '#0a1929' }}>
                  <div style={{ width: `${(plusDI / (plusDI + minusDI || 1)) * 100}%`, background: '#66bb6a', transition: 'width 0.5s' }} />
                  <div style={{ width: `${(minusDI / (plusDI + minusDI || 1)) * 100}%`, background: '#ef5350', transition: 'width 0.5s' }} />
                </div>
                <div style={{ fontSize: 'var(--mc-font-label)', color: plusDI > minusDI ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', marginTop: '6px', textAlign: 'center' }}>
                  {plusDI > minusDI ? '▲ BULLS LEADING' : '▼ BEARS LEADING'} ({fmt(Math.abs(plusDI - minusDI), 1)} spread)
                </div>
              </div>

              {/* Price */}
              {data.current_price && (
                <div style={{ marginTop: '12px', textAlign: 'center', fontSize: 'var(--mc-font-badge)', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
                  ${data.current_price.toLocaleString()}
                </div>
              )}
            </div>
          );
        })}
      </div>

      {/* === REGIME LEGEND === */}
      <div className="rg-card" style={{ padding: '18px' }}>
        <div className="rg-label" style={{ marginBottom: '12px' }}>REGIME DEFINITIONS</div>
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '8px', fontSize: 'var(--mc-font-label)' }}>
          {[
            { regime: 'STRONG TREND', desc: 'ADX >30, clear direction. Ride the trend.', color: '#66bb6a' },
            { regime: 'WEAK TREND', desc: 'ADX 15-30, direction unclear. Be selective.', color: '#ff9800' },
            { regime: 'TRANSITIONAL', desc: 'Regime changing. Wait for confirmation.', color: '#ff9800' },
            { regime: 'CHOPPY', desc: 'High choppiness, no trend. Fade extremes.', color: '#ef5350' },
            { regime: 'RANGING', desc: 'Clear support/resistance. Trade the range.', color: '#4fc3f7' },
            { regime: 'VOLATILE', desc: 'High BBW, rapid moves. Reduce size or sit out.', color: '#ef5350' },
          ].map((r, i) => (
            <div key={i} style={{ display: 'flex', gap: '8px', padding: '8px 10px', background: '#0d1117', borderRadius: '4px', borderLeft: `2px solid ${r.color}` }}>
              <div>
                <div style={{ fontWeight: 600, color: r.color, fontFamily: 'var(--font-mc-mono)' }}>{r.regime}</div>
                <div style={{ color: '#607d8b', marginTop: '2px' }}>{r.desc}</div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
