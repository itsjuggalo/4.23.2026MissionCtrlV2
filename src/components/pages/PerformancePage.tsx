'use client';
import { useEffect, useState } from 'react';

// ============================================================================
// TERRAN PERFORMANCE ANALYTICS — Trading Intelligence Terminal
// Portfolio metrics, trade scorecards, optimizer results, P/L tracking
// ============================================================================

export function PerformancePage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [params, setParams] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [tick, setTick] = useState(0);

  const fetchAll = async () => {
    try {
      const [pRes, sRes, prRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/history?ticker=BTCUSD&limit=100').then(r => r.json()).catch(() => null),
        fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
      ]);
      if (pRes) setPortfolio(pRes);
      if (sRes) setSignals(sRes);
      if (prRes) setParams(prRes);
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  };

  useEffect(() => {
    fetchAll();
    const d = setInterval(fetchAll, 30000);
    const t = setInterval(() => setTick(x => x + 1), 1000);
    return () => { clearInterval(d); clearInterval(t); };
  }, []);

  const equity = parseFloat(portfolio?.equity || portfolio?.balance || '0');
  const lastEq = parseFloat(portfolio?.last_equity || '0');
  const cash = parseFloat(portfolio?.cash || '0');
  const buyingPower = parseFloat(portfolio?.buying_power || '0');
  const startCap = 100000;
  const totalReturn = ((equity - startCap) / startCap) * 100;
  const dailyChange = equity - lastEq;
  const dailyPct = lastEq ? (dailyChange / lastEq) * 100 : 0;
  const positions = portfolio?.positions || [];
  const goalPct = Math.min(((equity - startCap) / (110000 - startCap)) * 100, 100);

  // Trade metrics
  const pnlHistory = signals?.BTCUSD?.pnl_history || signals?.pnl_history || [];
  const totalTrades = pnlHistory.length;
  const wins = pnlHistory.filter((t: any) => t.pnl_pct > 0);
  const losses = pnlHistory.filter((t: any) => t.pnl_pct <= 0);
  const winRate = totalTrades > 0 ? (wins.length / totalTrades) * 100 : 0;
  const avgWin = wins.length > 0 ? wins.reduce((s: number, t: any) => s + t.pnl_pct, 0) / wins.length : 0;
  const avgLoss = losses.length > 0 ? losses.reduce((s: number, t: any) => s + t.pnl_pct, 0) / losses.length : 0;
  const totalWinPct = wins.reduce((s: number, t: any) => s + t.pnl_pct, 0);
  const totalLossPct = Math.abs(losses.reduce((s: number, t: any) => s + t.pnl_pct, 0));
  const profitFactor = totalLossPct > 0 ? totalWinPct / totalLossPct : 0;
  const bestTrade = pnlHistory.length > 0 ? Math.max(...pnlHistory.map((t: any) => t.pnl_pct)) : 0;
  const worstTrade = pnlHistory.length > 0 ? Math.min(...pnlHistory.map((t: any) => t.pnl_pct)) : 0;

  let maxDD = 0, cumEq = 100, peak = 100;
  pnlHistory.forEach((t: any) => {
    cumEq *= (1 + t.pnl_pct / 100);
    if (cumEq > peak) peak = cumEq;
    const dd = ((peak - cumEq) / peak) * 100;
    if (dd > maxDD) maxDD = dd;
  });

  const recentTrades = [...pnlHistory].reverse().slice(0, 12);
  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });

  // Win rate gauge percentage (capped)
  const gaugeAngle = Math.min(winRate, 100) * 1.8; // 0-180 degrees

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'perf-blink 1s infinite' }}>LOADING PERFORMANCE DATA...</div>
    </div>
  );

  return (
    <div style={{ padding: '20px', maxWidth: '1400px', margin: '0 auto' }}>
      <style>{`
        @keyframes perf-blink { 0%,100% { opacity: 1; } 50% { opacity: 0.3; } }
        @keyframes perf-fill { from { width: 0; } }
        @keyframes perf-glow { 0%,100% { box-shadow: 0 0 4px #4fc3f722; } 50% { box-shadow: 0 0 12px #4fc3f744; } }
        .perf-card { background: #0a1929; border: 1px solid #1a3a4a; border-radius: 8px; position: relative; overflow: hidden; }
        .perf-card::after { content: ''; position: absolute; bottom: 0; left: 0; right: 0; height: 1px; background: linear-gradient(90deg, transparent, #4fc3f733, transparent); }
        .perf-label { font-size: 10px; color: #607d8b; text-transform: uppercase; letter-spacing: 1.5px; font-family: var(--font-mc-mono); }
        .perf-bar { height: 6px; border-radius: 3px; background: #0d1117; overflow: hidden; }
        .perf-bar-fill { height: 100%; border-radius: 3px; animation: perf-fill 1s ease-out; }
      `}</style>

      {/* === HEADER === */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
        <div>
          <h1 style={{ fontSize: '18px', fontWeight: 700, color: '#4fc3f7', margin: 0, fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>PERFORMANCE ANALYTICS</h1>
          <p style={{ fontSize: '11px', color: '#455a64', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>Mission Control Trading Intelligence • Auto-refreshes 30s</p>
        </div>
        <button onClick={fetchAll} style={{ padding: '6px 14px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#607d8b', fontSize: '11px', cursor: 'pointer', fontFamily: 'var(--font-mc-mono)' }}>REFRESH</button>
      </div>

      {/* === PORTFOLIO HERO === */}
      <div className="perf-card" style={{ padding: '24px 28px', marginBottom: '16px' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-end' }}>
          <div>
            <div className="perf-label" style={{ marginBottom: '8px' }}>PORTFOLIO EQUITY</div>
            <div style={{ fontSize: '42px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', lineHeight: 1 }}>${fmt(equity)}</div>
            <div style={{ display: 'flex', gap: '20px', marginTop: '10px' }}>
              <span style={{ fontSize: '14px', fontFamily: 'var(--font-mc-mono)', color: dailyPct >= 0 ? '#66bb6a' : '#ef5350' }}>
                {dailyPct >= 0 ? '▲' : '▼'} {fmt(Math.abs(dailyPct), 2)}% today
              </span>
              <span style={{ fontSize: '14px', fontFamily: 'var(--font-mc-mono)', color: totalReturn >= 0 ? '#66bb6a' : '#ef5350' }}>
                {totalReturn >= 0 ? '+' : ''}{fmt(totalReturn, 1)}% total
              </span>
              <span style={{ fontSize: '14px', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
                ${fmt(Math.abs(dailyChange))} {dailyChange >= 0 ? 'gain' : 'loss'}
              </span>
            </div>
          </div>
          <div style={{ textAlign: 'right' }}>
            <div className="perf-label" style={{ marginBottom: '8px' }}>PHASE 1 GOAL: $110K</div>
            <div style={{ width: '200px' }}>
              <div className="perf-bar" style={{ height: '10px', marginBottom: '4px' }}>
                <div className="perf-bar-fill" style={{ width: `${Math.max(goalPct, 0)}%`, background: goalPct >= 100 ? '#66bb6a' : `linear-gradient(90deg, #4fc3f7, ${goalPct > 60 ? '#66bb6a' : '#4fc3f7'})` }} />
              </div>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{fmt(goalPct, 0)}% complete</div>
            </div>
          </div>
        </div>
      </div>

      {/* === METRICS ROW === */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(6, 1fr)', gap: '8px', marginBottom: '16px' }}>
        {[
          { label: 'WIN RATE', value: `${fmt(winRate, 1)}%`, color: winRate > 50 ? '#66bb6a' : winRate > 35 ? '#ff9800' : '#ef5350' },
          { label: 'PROFIT FACTOR', value: `${fmt(profitFactor)}`, color: profitFactor > 1.5 ? '#66bb6a' : profitFactor > 1 ? '#ff9800' : '#ef5350' },
          { label: 'MAX DRAWDOWN', value: `${fmt(maxDD, 1)}%`, color: maxDD < 10 ? '#66bb6a' : maxDD < 20 ? '#ff9800' : '#ef5350' },
          { label: 'AVG WIN', value: `+${fmt(avgWin)}%`, color: '#66bb6a' },
          { label: 'AVG LOSS', value: `${fmt(avgLoss)}%`, color: '#ef5350' },
          { label: 'TOTAL TRADES', value: `${totalTrades}`, color: '#4fc3f7' },
        ].map((m, i) => (
          <div key={i} className="perf-card" style={{ padding: '14px 16px', textAlign: 'center' }}>
            <div className="perf-label" style={{ marginBottom: '8px' }}>{m.label}</div>
            <div style={{ fontSize: '22px', fontWeight: 700, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* === TWO COLUMN: Positions + Trade Extremes === */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '16px' }}>
        {/* Positions with P/L bars */}
        <div className="perf-card" style={{ padding: '18px' }}>
          <div className="perf-label" style={{ marginBottom: '14px' }}>POSITION PERFORMANCE</div>
          {positions.length === 0 ? (
            <div style={{ color: '#455a64', fontSize: '12px', fontFamily: 'var(--font-mc-mono)' }}>No open positions</div>
          ) : positions.map((p: any, i: number) => {
            const pnl = parseFloat(p.unrealized_pl || '0');
            const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
            const dayPnl = parseFloat(p.unrealized_intraday_pl || '0');
            const g = pnl >= 0;
            const barWidth = Math.min(Math.abs(pnlPct) * 3, 100);
            return (
              <div key={i} style={{ marginBottom: '14px' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '6px' }}>
                  <div>
                    <span style={{ fontSize: '15px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{p.symbol}</span>
                    <span style={{ fontSize: '11px', color: '#455a64', marginLeft: '8px' }}>{p.qty} @ ${fmt(parseFloat(p.avg_entry_price || '0'))}</span>
                  </div>
                  <div style={{ textAlign: 'right' }}>
                    <span style={{ fontSize: '16px', fontWeight: 700, color: g ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                      {g ? '+' : ''}{fmt(pnlPct, 1)}%
                    </span>
                    <span style={{ fontSize: '11px', color: '#455a64', marginLeft: '8px' }}>
                      ${fmt(pnl)}
                    </span>
                  </div>
                </div>
                <div className="perf-bar">
                  <div className="perf-bar-fill" style={{ width: `${barWidth}%`, background: g ? 'linear-gradient(90deg, #66bb6a44, #66bb6a)' : 'linear-gradient(90deg, #ef535044, #ef5350)' }} />
                </div>
                <div style={{ fontSize: '10px', color: '#455a64', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>
                  Today: <span style={{ color: dayPnl >= 0 ? '#66bb6a' : '#ef5350' }}>{dayPnl >= 0 ? '+' : ''}${fmt(dayPnl)}</span>
                  &nbsp;&nbsp;|&nbsp;&nbsp;Current: ${fmt(parseFloat(p.current_price || '0'))}
                </div>
              </div>
            );
          })}
        </div>

        {/* Trade Extremes + Win/Loss Split */}
        <div className="perf-card" style={{ padding: '18px' }}>
          <div className="perf-label" style={{ marginBottom: '14px' }}>TRADE ANALYTICS</div>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '10px', marginBottom: '16px' }}>
            <div style={{ background: '#0d1117', borderRadius: '6px', padding: '12px', borderLeft: '3px solid #66bb6a' }}>
              <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>BEST TRADE</div>
              <div style={{ fontSize: '22px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>+{fmt(bestTrade)}%</div>
            </div>
            <div style={{ background: '#0d1117', borderRadius: '6px', padding: '12px', borderLeft: '3px solid #ef5350' }}>
              <div style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>WORST TRADE</div>
              <div style={{ fontSize: '22px', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{fmt(worstTrade)}%</div>
            </div>
          </div>
          {/* Win/Loss visual bar */}
          <div style={{ marginBottom: '14px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '6px' }}>
              <span style={{ fontSize: '11px', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>{wins.length} WINS</span>
              <span style={{ fontSize: '11px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{losses.length} LOSSES</span>
            </div>
            <div style={{ display: 'flex', height: '14px', borderRadius: '7px', overflow: 'hidden', background: '#0d1117' }}>
              <div style={{ width: `${winRate}%`, background: 'linear-gradient(90deg, #66bb6a88, #66bb6a)', transition: 'width 1s' }} />
              <div style={{ width: `${100 - winRate}%`, background: 'linear-gradient(90deg, #ef5350, #ef535088)', transition: 'width 1s' }} />
            </div>
          </div>
          {/* Additional stats */}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '6px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
            {[
              { l: 'BUYING POWER', v: `$${fmt(buyingPower)}`, c: '#4fc3f7' },
              { l: 'CASH', v: `$${fmt(cash)}`, c: cash >= 0 ? '#607d8b' : '#ef5350' },
              { l: 'TOTAL WIN %', v: `+${fmt(totalWinPct)}%`, c: '#66bb6a' },
              { l: 'TOTAL LOSS %', v: `${fmt(-totalLossPct)}%`, c: '#ef5350' },
            ].map((s, i) => (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 8px', background: '#0d1117', borderRadius: '4px' }}>
                <span style={{ color: '#607d8b' }}>{s.l}</span>
                <span style={{ color: s.c, fontWeight: 600 }}>{s.v}</span>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* === OPTIMIZER RESULTS === */}
      {params && (
        <div className="perf-card" style={{ padding: '18px', marginBottom: '16px' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '14px' }}>
            <div className="perf-label">SUPERTREND OPTIMIZER — {params.timeframe || '4H'}</div>
            <div style={{ fontSize: '12px', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#607d8b' }}>RECOMMENDED: </span>
              <span style={{ color: '#4fc3f7', fontWeight: 600 }}>ATR {params.recommended_atr_period} × {params.recommended_multiplier}</span>
            </div>
          </div>
          {params.top_results && (
            <div style={{ overflowX: 'auto' }}>
              <table style={{ width: '100%', borderCollapse: 'collapse', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                <thead>
                  <tr>
                    {['#', 'ATR', 'MULT', 'TRADES', 'WIN%', 'PF', 'RETURN', 'MAX DD', 'SHARPE'].map(h => (
                      <th key={h} style={{ textAlign: 'left', padding: '8px 10px', color: '#607d8b', borderBottom: '1px solid #1a3a4a', letterSpacing: '0.5px' }}>{h}</th>
                    ))}
                  </tr>
                </thead>
                <tbody>
                  {params.top_results.slice(0, 5).map((r: any, i: number) => (
                    <tr key={i} style={{ background: i === 0 ? '#4fc3f708' : 'transparent' }}>
                      <td style={{ padding: '8px 10px', color: i === 0 ? '#4fc3f7' : '#607d8b', borderBottom: '1px solid #0d1117' }}>{i === 0 ? '★' : i + 1}</td>
                      <td style={{ padding: '8px 10px', color: '#e0e0e0', borderBottom: '1px solid #0d1117' }}>{r.atr_period}</td>
                      <td style={{ padding: '8px 10px', color: '#e0e0e0', borderBottom: '1px solid #0d1117' }}>{r.multiplier}</td>
                      <td style={{ padding: '8px 10px', color: '#e0e0e0', borderBottom: '1px solid #0d1117' }}>{r.total_trades}</td>
                      <td style={{ padding: '8px 10px', color: r.win_rate > 50 ? '#66bb6a' : '#ff9800', borderBottom: '1px solid #0d1117' }}>{r.win_rate}%</td>
                      <td style={{ padding: '8px 10px', color: r.profit_factor > 1.5 ? '#66bb6a' : '#ff9800', borderBottom: '1px solid #0d1117' }}>{r.profit_factor}</td>
                      <td style={{ padding: '8px 10px', color: '#66bb6a', borderBottom: '1px solid #0d1117' }}>+{r.total_return_pct}%</td>
                      <td style={{ padding: '8px 10px', color: r.max_drawdown_pct < 10 ? '#66bb6a' : '#ff9800', borderBottom: '1px solid #0d1117' }}>{r.max_drawdown_pct}%</td>
                      <td style={{ padding: '8px 10px', color: '#607d8b', borderBottom: '1px solid #0d1117' }}>{r.sharpe_approx || 'N/A'}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      )}

      {/* === RECENT TRADES TIMELINE === */}
      <div className="perf-card" style={{ padding: '18px' }}>
        <div className="perf-label" style={{ marginBottom: '14px' }}>TRADE HISTORY — LAST {recentTrades.length}</div>
        {recentTrades.length === 0 ? (
          <div style={{ color: '#455a64', fontSize: '12px', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '20px' }}>No trade history</div>
        ) : (
          <div style={{ display: 'flex', flexDirection: 'column', gap: '3px' }}>
            {recentTrades.map((t: any, i: number) => {
              const g = t.pnl_pct > 0;
              const date = t.closed_at ? new Date(t.closed_at) : null;
              const dateStr = date ? `${date.toLocaleDateString('en-US', { month: 'short', day: 'numeric' })} ${date.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit' })}` : '?';
              const barW = Math.min(Math.abs(t.pnl_pct) * 15, 60);
              return (
                <div key={i} style={{
                  display: 'grid', gridTemplateColumns: '60px 50px 100px 1fr 80px',
                  alignItems: 'center', padding: '8px 12px',
                  background: i % 2 === 0 ? '#0d1117' : '#0a1929',
                  borderLeft: `2px solid ${g ? '#66bb6a' : '#ef5350'}`,
                  borderRadius: '3px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)',
                }}>
                  <span style={{ color: '#455a64' }}>{dateStr.split(' ')[0]}</span>
                  <span style={{ color: t.direction === 'LONG' ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>{t.direction}</span>
                  <span style={{ color: '#607d8b' }}>${fmt(t.entry)} → ${fmt(t.exit)}</span>
                  <div className="perf-bar" style={{ height: '4px' }}>
                    <div className="perf-bar-fill" style={{ width: `${barW}%`, background: g ? '#66bb6a' : '#ef5350' }} />
                  </div>
                  <span style={{ color: g ? '#66bb6a' : '#ef5350', fontWeight: 700, textAlign: 'right' }}>{g ? '+' : ''}{fmt(t.pnl_pct)}%</span>
                </div>
              );
            })}
          </div>
        )}
      </div>
    </div>
  );
}
