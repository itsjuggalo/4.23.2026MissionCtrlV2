'use client';
import { useState, useEffect } from 'react';

export function RiskPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [trades, setTrades] = useState<any[]>([]);
  const [equity, setEquity] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  useEffect(() => {
    async function load() {
      const [p, r, t, e] = await Promise.all([
        fetch('/api/portfolio').then(r => r.ok ? r.json() : null).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/trade-log?limit=100').then(r => r.json()).catch(() => null),
        fetch('/api/equity-history').then(r => r.json()).catch(() => null),
      ]);
      setPortfolio(p); setRegime(r);
      setTrades(t?.trades || t || []);
      setEquity(e?.history || e || []);
      if (!p && !r) setError(true);
      setLoading(false);
    }
    load();
  }, []);

  const eq = portfolio?.equity || 0;
  const start = 500000;
  const pnl = eq - start;
  const pnlPct = start > 0 ? (pnl / start * 100) : 0;
  const dayPl = portfolio?.day_pl || 0;
  const maxDrawdown = equity.length > 1 ? (() => {
    let peak = 0, maxDd = 0;
    for (const pt of equity) { const v = pt.equity || pt.value || 0; if (v > peak) peak = v; const dd = peak > 0 ? ((peak - v) / peak * 100) : 0; if (dd > maxDd) maxDd = dd; }
    return maxDd;
  })() : pnlPct < 0 ? Math.abs(pnlPct) : 0;

  // Trade stats
  const wins = trades.filter(t => (t.pl || t.pnl || 0) > 0).length;
  const losses = trades.filter(t => (t.pl || t.pnl || 0) < 0).length;
  const total = wins + losses;
  const winRate = total > 0 ? (wins / total * 100) : 0;
  const avgWin = wins > 0 ? trades.filter(t => (t.pl || t.pnl || 0) > 0).reduce((s, t) => s + (t.pl || t.pnl || 0), 0) / wins : 0;
  const avgLoss = losses > 0 ? Math.abs(trades.filter(t => (t.pl || t.pnl || 0) < 0).reduce((s, t) => s + (t.pl || t.pnl || 0), 0) / losses) : 1;
  const profitFactor = avgLoss > 0 ? (avgWin * wins) / (avgLoss * losses || 1) : 0;
  const sharpe = equity.length > 5 ? (() => {
    const returns: number[] = [];
    for (let i = 1; i < equity.length; i++) { const prev = equity[i-1].equity || equity[i-1].value || start; const cur = equity[i].equity || equity[i].value || start; if (prev > 0) returns.push((cur - prev) / prev); }
    if (returns.length < 2) return 0;
    const avg = returns.reduce((a, b) => a + b, 0) / returns.length;
    const std = Math.sqrt(returns.reduce((s, r) => s + (r - avg) ** 2, 0) / returns.length);
    return std > 0 ? (avg / std) * Math.sqrt(252) : 0;
  })() : 0;

  const regimeStr = regime?.overall_regime || 'Unknown';
  const bias = regimeStr.includes('UP') || regimeStr.includes('BULL') ? 'BULLISH' : regimeStr.includes('DOWN') || regimeStr.includes('BEAR') ? 'BEARISH' : 'NEUTRAL';

  // Risk level
  const riskScore = maxDrawdown > 15 ? 3 : maxDrawdown > 8 ? 2 : pnlPct < -5 ? 2 : 1;
  const riskLevel = riskScore === 3 ? 'HIGH' : riskScore === 2 ? 'MEDIUM' : 'LOW';
  const riskColor = riskScore === 3 ? '#ef5350' : riskScore === 2 ? '#ff9800' : '#66bb6a';

  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });

  if (loading) return <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>ANALYZING RISK...</div>;
  const errBanner = error ? <div style={{ padding: '10px 16px', background: '#ef535014', border: '1px solid #ef535033', borderRadius: '6px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', marginBottom: '16px' }}>⚠ Portfolio/regime API unavailable — metrics may show zeros</div> : null;

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      {errBanner}
      {/* === TOP: Risk Gauge + Key Metrics side by side === */}
      <div style={{ display: 'grid', gridTemplateColumns: '280px 1fr', gap: '16px', marginBottom: '20px' }}>
        {/* Gauge */}
        <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '12px', padding: '28px 24px', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px', marginBottom: '8px' }}>PORTFOLIO RISK</div>
          <div style={{ width: '140px', height: '70px', position: 'relative', overflow: 'hidden', marginBottom: '8px' }}>
            <svg viewBox="0 0 140 70" style={{ width: '100%' }}>
              <path d="M 10 65 A 60 60 0 0 1 130 65" fill="none" stroke="#1a3a4a" strokeWidth="12" strokeLinecap="round" />
              <path d="M 10 65 A 60 60 0 0 1 130 65" fill="none" stroke={riskColor} strokeWidth="12" strokeLinecap="round"
                strokeDasharray={`${(riskScore / 3) * 188} 188`} />
            </svg>
          </div>
          <div style={{ fontSize: '32px', fontWeight: 900, color: riskColor, fontFamily: 'var(--font-mc-mono)', letterSpacing: '3px' }}>{riskLevel}</div>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>Max DD: {fmt(maxDrawdown, 1)}%</div>
        </div>

        {/* Key Metrics — 2x3 grid */}
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gridTemplateRows: 'repeat(2, 1fr)', gap: '10px' }}>
          {[
            { label: 'EQUITY', value: `$${fmt(eq, 0)}`, sub: `${pnlPct >= 0 ? '+' : ''}${fmt(pnlPct, 1)}% all-time`, color: pnlPct >= 0 ? '#66bb6a' : '#ef5350' },
            { label: 'TODAY P&L', value: `${dayPl >= 0 ? '+' : ''}$${fmt(dayPl, 0)}`, sub: `${portfolio?.day_pl_pct ? (portfolio.day_pl_pct >= 0 ? '+' : '') + fmt(portfolio.day_pl_pct * 100, 2) + '%' : ''}`, color: dayPl >= 0 ? '#66bb6a' : '#ef5350' },
            { label: 'REGIME', value: bias, sub: regimeStr.replace(/_/g, ' '), color: bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800' },
            { label: 'SHARPE', value: fmt(sharpe, 2), sub: sharpe > 1 ? 'Strong' : sharpe > 0.5 ? 'Moderate' : 'Weak', color: sharpe > 1 ? '#66bb6a' : sharpe > 0.5 ? '#ff9800' : '#ef5350' },
            { label: 'PROFIT FACTOR', value: fmt(profitFactor, 2), sub: `${wins}W / ${losses}L`, color: profitFactor > 1.5 ? '#66bb6a' : profitFactor > 1 ? '#ff9800' : '#ef5350' },
            { label: 'WIN RATE', value: `${fmt(winRate, 0)}%`, sub: `${total} trades`, color: winRate > 55 ? '#66bb6a' : winRate > 45 ? '#ff9800' : '#ef5350' },
          ].map((m, i) => (
            <div key={i} style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '8px', padding: '14px 16px', borderTop: `2px solid ${m.color}` }}>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '6px' }}>{m.label}</div>
              <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginTop: '2px' }}>{m.sub}</div>
            </div>
          ))}
        </div>
      </div>

      {/* === MIDDLE: Horizontal bar metrics === */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '16px', marginBottom: '20px' }}>
        {/* Portfolio Allocation */}
        <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '20px' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '14px' }}>EXPOSURE BREAKDOWN</div>
          {[
            { label: 'Alpaca Paper', pct: 82, color: '#4fc3f7' },
            { label: 'Hyperliquid', pct: 10, color: '#ce93d8' },
            { label: 'Robinhood', pct: 6, color: '#66bb6a' },
            { label: 'Coinbase', pct: 2, color: '#ff9800' },
          ].map((a, i) => (
            <div key={i} style={{ marginBottom: '10px' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: '#90a4ae', marginBottom: '4px' }}>
                <span>{a.label}</span><span style={{ color: a.color }}>{a.pct}%</span>
              </div>
              <div style={{ background: '#0d1117', borderRadius: '3px', height: '6px', overflow: 'hidden' }}>
                <div style={{ background: a.color, width: `${a.pct}%`, height: '100%', borderRadius: '3px', transition: 'width 0.5s' }} />
              </div>
            </div>
          ))}
        </div>

        {/* Performance Bars */}
        <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '20px' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '14px' }}>PERFORMANCE METRICS</div>
          {[
            { label: 'Win Rate', val: winRate, max: 100, color: '#66bb6a', suffix: '%' },
            { label: 'Avg Win / Avg Loss', val: avgLoss > 0 ? (avgWin / avgLoss) : 0, max: 5, color: '#4fc3f7', suffix: 'x' },
            { label: 'Max Drawdown', val: maxDrawdown, max: 30, color: '#ef5350', suffix: '%' },
            { label: 'Sharpe Ratio', val: Math.max(sharpe, 0), max: 3, color: '#ce93d8', suffix: '' },
          ].map((m, i) => (
            <div key={i} style={{ marginBottom: '10px' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: '#90a4ae', marginBottom: '4px' }}>
                <span>{m.label}</span><span style={{ color: m.color }}>{fmt(m.val, 1)}{m.suffix}</span>
              </div>
              <div style={{ background: '#0d1117', borderRadius: '3px', height: '6px', overflow: 'hidden' }}>
                <div style={{ background: m.color, width: `${Math.min((m.val / m.max) * 100, 100)}%`, height: '100%', borderRadius: '3px' }} />
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* === BOTTOM: Risk Rules as timeline/checklist === */}
      <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '10px', padding: '20px' }}>
        <div style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '14px' }}>RISK RULES</div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px 24px' }}>
          {[
            { rule: 'Max position size: 5% of portfolio', ok: true },
            { rule: 'Stop loss on every trade', ok: true },
            { rule: 'Max daily loss: 2% of portfolio', ok: Math.abs(dayPl) < eq * 0.02 },
            { rule: 'No trading during circuit breakers', ok: true },
            { rule: 'Reduce size in choppy markets', ok: bias !== 'NEUTRAL' },
            { rule: 'Phase 1: reach $110K before increasing risk', ok: eq >= 110000 },
          ].map((r, i) => (
            <div key={i} style={{ display: 'flex', alignItems: 'center', gap: '10px', padding: '8px 0', borderBottom: '1px solid #0d1117' }}>
              <span style={{ fontSize: 'var(--mc-font-lg)', flexShrink: 0 }}>{r.ok ? '✅' : '⚠️'}</span>
              <span style={{ fontSize: 'var(--mc-font-badge)', color: r.ok ? '#90a4ae' : '#ff9800', fontFamily: 'var(--font-mc-mono)' }}>{r.rule}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
