'use client';
import { useEffect, useState } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

// ============================================================================
// TERRAN REGIME ANALYZER — Market Conditions Intelligence
// Multi-timeframe regime detection, trend strength, strategy guidance
// ============================================================================

// Types
type TimeframeData = {
  direction?: string;
  regime?: string;
  adx?: number;
  choppiness?: number;
  trend_efficiency?: number;
  bbw?: number;
  plus_di?: number;
  minus_di?: number;
  current_price?: number;
  recommended_strategy?: string;
};
type RegimeData = {
  overall_regime?: string;
  direction_bias?: string;
  overall_recommendation?: string;
  timeframes?: Record<string, TimeframeData>;
};
type SignalsData = {
  BTCUSD?: { direction?: string; entry_price?: string | number; signal_count?: number };
  [key: string]: unknown;
};
type SupertrendParams = {
  recommended_atr_period?: number;
  recommended_multiplier?: number;
  backtest_return_pct?: number;
  timeframe?: string;
  top_results?: Record<string, unknown>[];
};
type MacroData = {
  verdict?: string;
  stance?: { label?: string; score?: number; color?: string };
  vix?: { level?: number; pct?: number };
  fearGreed?: { value?: number; label?: string; previousClose?: number; oneWeekAgo?: number; oneMonthAgo?: number; oneYearAgo?: number };
  yields?: { spread?: number; tenY?: number; twoY?: number };
  history?: { date?: string; stance?: string; score?: number; color?: string }[];
  playbook?: { edges?: string[]; avoids?: string[]; notes?: string[] };
  sizing?: { rPerTrade?: number; rBaseline?: number; maxConcurrent?: number; optionsPct?: number; reasoning?: string };
  sectors?: { symbol?: string; name?: string; return5d?: number; return20d?: number }[];
};

export function RegimePage() {
  const [regime, setRegime] = useState<RegimeData | null>(null);
  const [signals, setSignals] = useState<SignalsData | null>(null);
  const [_params, setParams] = useState<SupertrendParams | null>(null);
  const [macro, setMacro] = useState<MacroData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [, setTick] = useState(0);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchAll = async () => {
    try {
      const [rRes, sRes, pRes, mRes] = await Promise.all([
        fetch('/api/regime').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/signals/latest').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/supertrend-params').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/macro-regime').then(r => r.ok ? r.json() : null).catch(() => null),
      ]);
      if (rRes) setRegime(rRes);
      if (sRes) setSignals(sRes);
      if (pRes) setParams(pRes);
      if (mRes) setMacro(mRes);
      setError(false);
    } catch (e) { console.error(e); setError(true); }
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
  const currentPrice: TimeframeData | undefined = Object.values(timeframes)[0];
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
      {/* ============ MACRO REGIME PRO PANEL ============ */}
      {macro && (
        <>
          {/* VERDICT — plain English headline */}
          <div className="cc" style={{ padding: '16px', marginBottom: '12px', borderLeft: '4px solid ' + (macro.stance?.color || '#607d8b') }}>
            <div className="lbl" style={{ marginBottom: '8px', letterSpacing: '2px', color: '#90a4ae' }}>TODAY&apos;S READ</div>
            <div style={{ fontSize: 'var(--mc-font-md)', color: '#e0e0e0', lineHeight: 1.6, fontFamily: 'var(--font-mc-sans)' }} dangerouslySetInnerHTML={{ __html: (macro.verdict || '').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/\*\*(.+?)\*\*/g, '<strong style="color:' + (macro.stance?.color || '#e0e0e0') + '">$1</strong>') }} />
          </div>

          {/* 4-TILE STANCE STRIP */}
          <div className="cc" style={{ padding: '16px', marginBottom: '12px' }}>
            <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px' }}>MARKET RISK STANCE</div>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(160px, 1fr))', gap: '12px' }}>
              <div style={{ background: '#0d1117', padding: '14px', borderRadius: '6px', borderLeft: '3px solid ' + (macro.stance?.color || '#607d8b') }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px', letterSpacing: '1px' }}>OVERALL</div>
                <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: macro.stance?.color || '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{macro.stance?.label || '—'}</div>
                <div style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>score {(macro.stance?.score ?? 0) >= 0 ? '+' : ''}{macro.stance?.score?.toFixed(2) || '—'}</div>
              </div>
              <div style={{ background: '#0d1117', padding: '14px', borderRadius: '6px', borderLeft: '3px solid ' + ((macro.vix?.level ?? 0) >= 25 ? '#ef5350' : (macro.vix?.level ?? 0) >= 20 ? '#ff9800' : (macro.vix?.level ?? 0) < 15 ? '#66bb6a' : '#4fc3f7') }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px', letterSpacing: '1px' }}>VIX (vol)</div>
                <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{macro.vix?.level?.toFixed(2) || '—'}</div>
                <div style={{ fontSize: 'var(--mc-font-badge)', color: (macro.vix?.pct || 0) >= 0 ? '#ef5350' : '#66bb6a', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{(macro.vix?.pct || 0) >= 0 ? '+' : ''}{macro.vix?.pct?.toFixed(2) || '0'}%</div>
              </div>
              <div style={{ background: '#0d1117', padding: '14px', borderRadius: '6px', borderLeft: '3px solid ' + ((macro.fearGreed?.value ?? 0) >= 75 ? '#66bb6a' : (macro.fearGreed?.value ?? 0) >= 55 ? '#9ccc65' : (macro.fearGreed?.value ?? 0) >= 45 ? '#607d8b' : (macro.fearGreed?.value ?? 0) >= 25 ? '#ff9800' : '#ef5350') }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px', letterSpacing: '1px' }}>FEAR & GREED</div>
                <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{macro.fearGreed?.value ?? '—'}</div>
                <div style={{ fontSize: 'var(--mc-font-badge)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>{macro.fearGreed?.label || '—'}</div>
              </div>
              <div style={{ background: '#0d1117', padding: '14px', borderRadius: '6px', borderLeft: '3px solid ' + ((macro.yields?.spread ?? 0) < 0 ? '#ef5350' : (macro.yields?.spread ?? 0) < 0.5 ? '#ff9800' : '#66bb6a') }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px', letterSpacing: '1px' }}>YIELD CURVE</div>
                <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{macro.yields?.spread != null ? (macro.yields.spread >= 0 ? '+' : '') + macro.yields.spread.toFixed(2) + 'pp' : '—'}</div>
                <div style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>10Y {macro.yields?.tenY?.toFixed(2) || '—'}% / 3M {macro.yields?.twoY?.toFixed(2) || '—'}%</div>
              </div>
            </div>
            {macro.fearGreed && (
              <div style={{ marginTop: '12px', display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(120px, 1fr))', gap: '8px', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', color: '#90a4ae' }}>
                <div>Prev close: <span style={{ color: '#e0e0e0' }}>{macro.fearGreed.previousClose}</span></div>
                <div>1W ago: <span style={{ color: '#e0e0e0' }}>{macro.fearGreed.oneWeekAgo}</span></div>
                <div>1M ago: <span style={{ color: '#e0e0e0' }}>{macro.fearGreed.oneMonthAgo}</span></div>
                <div>1Y ago: <span style={{ color: '#e0e0e0' }}>{macro.fearGreed.oneYearAgo}</span></div>
              </div>
            )}
          </div>

          {/* 30-DAY REGIME TRANSITION TIMELINE */}
          {macro.history && macro.history.length > 0 && (
            <div className="cc" style={{ padding: '16px', marginBottom: '12px' }}>
              <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px' }}>REGIME TRANSITIONS — LAST {macro.history.length} DAYS</div>
              <div style={{ display: 'flex', gap: '2px', height: '32px', borderRadius: '4px', overflow: 'hidden' }}>
                {macro.history.map((h: any, i: number) => (
                  <div key={h.date || i} title={`${h.date} — ${h.stance} (score ${h.score >= 0 ? '+' : ''}${h.score?.toFixed?.(2) || h.score})`} style={{ flex: 1, background: h.color || '#607d8b', cursor: 'help' }} />
                ))}
              </div>
              <div style={{ marginTop: '6px', display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-badge)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                <span>{macro.history[0]?.date || ''}</span>
                <span>← hover for daily detail →</span>
                <span>{macro.history[macro.history.length - 1]?.date || ''} (today)</span>
              </div>
            </div>
          )}

          {/* EDGE TODAY / AVOID TODAY */}
          {macro.playbook && (
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '12px' }}>
              <div className="cc" style={{ padding: '16px', borderTop: '3px solid #66bb6a' }}>
                <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px', color: '#66bb6a' }}>✓ EDGE TODAY</div>
                {(macro.playbook.edges || []).map((e: string, i: number) => (
                  <div key={i} style={{ padding: '8px 10px', marginBottom: '6px', background: '#0d1117', borderRadius: '4px', borderLeft: '2px solid #66bb6a', fontSize: 'var(--mc-font-sm)', color: '#e0e0e0', lineHeight: 1.5 }}>{e}</div>
                ))}
              </div>
              <div className="cc" style={{ padding: '16px', borderTop: '3px solid #ef5350' }}>
                <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px', color: '#ef5350' }}>✗ AVOID TODAY</div>
                {(macro.playbook.avoids || []).map((a: string, i: number) => (
                  <div key={i} style={{ padding: '8px 10px', marginBottom: '6px', background: '#0d1117', borderRadius: '4px', borderLeft: '2px solid #ef5350', fontSize: 'var(--mc-font-sm)', color: '#e0e0e0', lineHeight: 1.5 }}>{a}</div>
                ))}
              </div>
            </div>
          )}

          {/* PLAYBOOK NOTES */}
          {macro.playbook?.notes && macro.playbook.notes.length > 0 && (
            <div className="cc" style={{ padding: '16px', marginBottom: '12px', background: '#1a1f2e' }}>
              <div className="lbl" style={{ marginBottom: '8px', letterSpacing: '2px', color: '#ffd600' }}>⚠ NOTES</div>
              {macro.playbook.notes.map((n: string, i: number) => (
                <div key={i} style={{ padding: '6px 0', fontSize: 'var(--mc-font-sm)', color: '#ffd600', lineHeight: 1.5 }}>{n}</div>
              ))}
            </div>
          )}

          {/* POSITION SIZING */}
          {macro.sizing && (
            <div className="cc" style={{ padding: '16px', marginBottom: '12px' }}>
              <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px' }}>POSITION SIZING (computed from regime + VIX)</div>
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(140px, 1fr))', gap: '12px', marginBottom: '12px' }}>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>R PER TRADE</div>
                  <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#ffd600', fontFamily: 'var(--font-mc-mono)' }}>{macro.sizing.rPerTrade?.toFixed(2)}%</div>
                  <div style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>vs {macro.sizing.rBaseline?.toFixed(2)}% baseline</div>
                </div>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>MAX CONCURRENT</div>
                  <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{macro.sizing.maxConcurrent}</div>
                  <div style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>positions</div>
                </div>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>OPTIONS EXPOSURE</div>
                  <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{macro.sizing.optionsPct}%</div>
                  <div style={{ fontSize: 'var(--mc-font-badge)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>of book</div>
                </div>
              </div>
              <div style={{ fontSize: 'var(--mc-font-sm)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', padding: '8px 10px', background: '#0d1117', borderRadius: '4px' }}>
                <span style={{ color: '#607d8b' }}>WHY:</span> {macro.sizing.reasoning}
              </div>
            </div>
          )}

          {/* SECTOR ROTATION */}
          {macro.sectors && macro.sectors.length > 0 && (
            <div className="cc" style={{ padding: '16px', marginBottom: '12px' }}>
              <div className="lbl" style={{ marginBottom: '12px', letterSpacing: '2px' }}>SECTOR ROTATION (sorted by 5d return)</div>
              <div style={{ display: 'grid', gridTemplateColumns: '60px 1fr 100px 100px', gap: '8px', alignItems: 'center', padding: '6px 10px', background: '#0d1117', borderRadius: '4px', fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px', letterSpacing: '1px' }}>
                <div>SYM</div><div>SECTOR</div><div style={{ textAlign: 'right' }}>5D %</div><div style={{ textAlign: 'right' }}>20D %</div>
              </div>
              {macro.sectors.map((s: any, i: number) => (
                <div key={s.symbol || i} onClick={() => setDrawerTicker(s.symbol)} style={{ display: 'grid', gridTemplateColumns: '60px 1fr 100px 100px', gap: '8px', alignItems: 'center', padding: '8px 10px', borderBottom: '1px solid #0d1117', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)', cursor: 'pointer' }}>
                  <div style={{ fontWeight: 700, color: '#ffd600' }}>{s.symbol}</div>
                  <div style={{ color: '#e0e0e0' }}>{s.name}</div>
                  <div style={{ textAlign: 'right', fontWeight: 700, color: s.return5d >= 0 ? '#66bb6a' : '#ef5350' }}>{s.return5d >= 0 ? '+' : ''}{s.return5d?.toFixed(2)}%</div>
                  <div style={{ textAlign: 'right', color: s.return20d >= 0 ? '#66bb6a' : '#ef5350' }}>{s.return20d >= 0 ? '+' : ''}{s.return20d?.toFixed(2)}%</div>
                </div>
              ))}
            </div>
          )}
        </>
      )}

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

      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}

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
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
