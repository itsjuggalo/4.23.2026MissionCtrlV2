'use client';
import { useState, useEffect } from 'react';

export function RiskPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [tradeLog, setTradeLog] = useState<any>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchData() {
      const [pRes, rRes, tRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/trade-log?limit=50').then(r => r.json()).catch(() => null),
      ]);
      setPortfolio(pRes); setRegime(rRes); setTradeLog(tRes);
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 30000);
    return () => clearInterval(i);
  }, []);

  const stats = tradeLog?.stats || {};
  const equity = portfolio?.equity || portfolio?.account?.equity || 0;
  const cash = portfolio?.cash || portfolio?.account?.cash || 0;
  const startingCapital = 100000;
  const pnl = equity - startingCapital;
  const pnlPct = startingCapital > 0 ? (pnl / startingCapital * 100) : 0;
  const drawdown = stats.worst_trade || 0;
  const winRate = stats.win_rate || 0;
  const pf = stats.profit_factor || 0;

  const riskLevel = drawdown < -2 ? 'HIGH' : drawdown < -1 ? 'MEDIUM' : 'LOW';
  const riskColor = riskLevel === 'HIGH' ? '#ef5350' : riskLevel === 'MEDIUM' ? '#ff9800' : '#66bb6a';

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      CALCULATING RISK...
    </div>
  );

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      <style>{`.risk-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; }`}</style>

      {/* Risk Level Hero */}
      <div className="risk-card" style={{ padding: '32px', textAlign: 'center', marginBottom: '20px', borderBottom: `3px solid ${riskColor}` }}>
        <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '8px' }}>PORTFOLIO RISK LEVEL</div>
        <div style={{ fontSize: '48px', fontWeight: 900, color: riskColor, fontFamily: 'var(--font-mc-mono)', letterSpacing: '4px' }}>{riskLevel}</div>
        <div style={{ fontSize: '13px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '8px' }}>
          Max Drawdown: <span style={{ color: '#ef5350', fontWeight: 700 }}>{drawdown.toFixed(2)}%</span>
        </div>
      </div>

      {/* Portfolio Metrics */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '12px', marginBottom: '20px' }}>
        {[
          { label: 'PORTFOLIO VALUE', value: `$${equity.toLocaleString(undefined, { maximumFractionDigits: 0 })}`, color: '#4fc3f7' },
          { label: 'TOTAL P/L', value: `${pnl >= 0 ? '+' : ''}$${pnl.toLocaleString(undefined, { maximumFractionDigits: 0 })}`, color: pnl >= 0 ? '#66bb6a' : '#ef5350' },
          { label: 'RETURN', value: `${pnlPct >= 0 ? '+' : ''}${pnlPct.toFixed(1)}%`, color: pnlPct >= 0 ? '#66bb6a' : '#ef5350' },
          { label: 'CASH', value: `$${cash.toLocaleString(undefined, { maximumFractionDigits: 0 })}`, color: '#e0e0e0' },
        ].map((m, i) => (
          <div key={i} className="risk-card" style={{ padding: '16px 20px', textAlign: 'center' }}>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: '24px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Trading Stats */}
      <div style={{ fontSize: '13px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #4fc3f744' }}>
        TRADING PERFORMANCE RISK
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '12px', marginBottom: '20px' }}>
        {[
          { label: 'WIN RATE', value: `${winRate.toFixed(1)}%`, color: winRate >= 50 ? '#66bb6a' : winRate >= 40 ? '#ff9800' : '#ef5350', bar: winRate },
          { label: 'PROFIT FACTOR', value: pf.toFixed(2), color: pf >= 2 ? '#66bb6a' : pf >= 1 ? '#ff9800' : '#ef5350', bar: Math.min(pf * 25, 100) },
          { label: 'WORST TRADE', value: `${drawdown.toFixed(2)}%`, color: '#ef5350', bar: Math.min(Math.abs(drawdown) * 20, 100) },
        ].map((m, i) => (
          <div key={i} className="risk-card" style={{ padding: '20px 24px' }}>
            <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '6px' }}>{m.label}</div>
            <div style={{ fontSize: '28px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)', marginBottom: '8px' }}>{m.value}</div>
            <div style={{ height: '4px', background: '#1a3a4a', borderRadius: '2px', overflow: 'hidden' }}>
              <div style={{ height: '100%', width: `${m.bar}%`, background: m.color, borderRadius: '2px' }} />
            </div>
          </div>
        ))}
      </div>

      {/* Risk Rules */}
      <div style={{ fontSize: '13px', fontWeight: 700, color: '#ff9800', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1.5px', marginBottom: '12px', paddingBottom: '6px', borderBottom: '2px solid #ff980044' }}>
        RISK RULES
      </div>

      <div style={{ display: 'flex', flexDirection: 'column', gap: '8px' }}>
        {[
          { rule: 'Max position size: 5% of portfolio', status: 'Active', ok: true },
          { rule: 'Stop loss required on every trade', status: 'Active', ok: true },
          { rule: 'Max daily loss: 2% of portfolio', status: 'Active', ok: true },
          { rule: 'No trading during circuit breaker events', status: 'Active', ok: true },
          { rule: 'Reduce position size in ranging/choppy markets', status: 'Active', ok: true },
          { rule: 'Phase 1 goal: reach $110K before increasing risk', status: `${equity >= 110000 ? 'Achieved' : 'In Progress'}`, ok: equity >= 110000 },
        ].map((r, i) => (
          <div key={i} className="risk-card" style={{ padding: '14px 18px', display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderLeft: `3px solid ${r.ok ? '#66bb6a' : '#ff9800'}` }}>
            <span style={{ fontSize: '13px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{r.rule}</span>
            <span style={{ fontSize: '10px', fontWeight: 700, padding: '2px 10px', borderRadius: '4px', background: r.ok ? '#66bb6a22' : '#ff980022', color: r.ok ? '#66bb6a' : '#ff9800', fontFamily: 'var(--font-mc-mono)' }}>{r.status.toUpperCase()}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
