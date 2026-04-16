'use client';
import { useEffect, useState } from 'react';
import { MetricCard } from '../ui/MetricCard';
import { Card } from '../ui/Card';
import { Badge } from '../ui/Badge';
import { SectionHeader } from '../ui/SectionHeader';
import { ProgressBar } from '../ui/ProgressBar';
import { BTCBiasWidget } from '../ui/BTCBiasWidget';
import { useMarketData } from '@/hooks/useMarketData';

export function DashboardPage() {
  const { prices } = useMarketData();
  const [portfolio, setPortfolio] = useState<any>(null);
  const [positions, setPositions] = useState<any>({});
  const [regime, setRegime] = useState<any>(null);
  const [report, setReport] = useState<any>(null);
  const [signals, setSignals] = useState<any[]>([]);
  const [params, setParams] = useState<any>(null);
  const [lastRefresh, setLastRefresh] = useState('');

  useEffect(() => {
    async function fetchAll() {
      const [portRes, posRes, regRes, repRes, sigRes, parRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/daily-report').then(r => r.json()).catch(() => null),
        fetch('/api/signals/history?ticker=BTCUSD&limit=10').then(r => r.json()).catch(() => []),
        fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
      ]);
      setPortfolio(portRes);
      setPositions(posRes || {});
      setRegime(regRes);
      setReport(repRes);
      setSignals(Array.isArray(sigRes) ? sigRes.reverse() : []);
      setParams(parRes);
      setLastRefresh(new Date().toLocaleTimeString());
    }
    fetchAll();
    const interval = setInterval(fetchAll, 15000);
    return () => clearInterval(interval);
  }, []);

  // Portfolio calcs
  const equity = portfolio?.balance || 0;
  const cash = portfolio?.cash || 0;
  const unrealizedPL = portfolio?.pl || 0;
  const dayPL = portfolio?.day_pl || 0;
  const startCapital = 100000;
  const totalReturn = equity > 0 ? ((equity - startCapital) / startCapital * 100) : 0;
  const goalCapital = 110000;
  const goalPct = Math.min(((equity - startCapital) / (goalCapital - startCapital)) * 100, 100);

  // Position calcs
  const openPositions = Object.entries(positions).filter(([, d]: [string, any]) => d.direction);
  const totalSignalsToday = report?.signals?.total || 0;
  const totalTradesToday = Object.values(report?.pnl || {}).reduce((s: number, p: any) => s + (p.trades_today || 0), 0) as number;

  // Win rate from all trade history
  let allWins = 0, allTrades = 0;
  Object.values(positions).forEach((p: any) => {
    (p.pnl_history || []).forEach((t: any) => { allTrades++; if (t.pnl_pct > 0) allWins++; });
  });
  const winRate = allTrades > 0 ? Math.round((allWins / allTrades) * 100) : 0;

  // BTC price from market data
  const btcPrice = prices['BTC']?.price || 0;
  const btcChange = prices['BTC']?.change24h || 0;

  function regimeColor(r: string) {
    if (r?.includes('STRONG_TREND')) return '#66bb6a';
    if (r?.includes('WEAK_TREND')) return '#ff9800';
    if (r?.includes('RANGING')) return '#4fc3f7';
    if (r?.includes('VOLATILE')) return '#ef5350';
    return '#607d8b';
  }

  function actionColor(a: string) {
    if (a === 'BUY') return '#66bb6a';
    if (a === 'SELL') return '#ef5350';
    return '#607d8b';
  }

  function formatTime(iso: string) {
    try {
      const d = new Date(iso);
      const now = new Date();
      const diff = Math.floor((now.getTime() - d.getTime()) / 1000);
      if (diff < 60) return `${diff}s ago`;
      if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
      if (diff < 86400) return `${Math.floor(diff / 3600)}h ago`;
      return d.toLocaleDateString();
    } catch { return ''; }
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <div>
          <h1 style={{ fontSize: 20, fontWeight: 700, color: '#e0e0e0', margin: 0 }}>Command Center</h1>
          <div style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", marginTop: 2 }}>
            PHASE 1 — PROVE ROI · Last refresh: {lastRefresh}
          </div>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
          <span style={{ width: 8, height: 8, borderRadius: '50%', background: '#66bb6a', animation: 'pulse 2s infinite' }} />
          <span style={{ fontSize: 12, color: '#66bb6a', fontWeight: 600 }}>LIVE</span>
        </div>
      </div>

      {/* Mission Progress */}
      <Card>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 8 }}>
          <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>MISSION PROGRESS</span>
          <span style={{ fontSize: 12, color: '#ef5350', fontFamily: "'JetBrains Mono', monospace" }}>Phase 1 of 2</span>
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: 6 }}>
          <span style={{ fontSize: 28, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: '#e0e0e0' }}>
            ${equity.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
          </span>
          <span style={{ fontSize: 13, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>→ ${goalCapital.toLocaleString()} goal</span>
        </div>
        <ProgressBar value={Math.max(goalPct, 0)} max={100} color="#4fc3f7" height={6} />
        <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 6 }}>
          <span style={{ fontSize: 11, color: totalReturn >= 0 ? '#66bb6a' : '#ef5350', fontFamily: "'JetBrains Mono', monospace" }}>
            {totalReturn >= 0 ? '+' : ''}${(equity - startCapital).toFixed(2)} earned
          </span>
          <span style={{ fontSize: 11, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace" }}>
            {goalPct.toFixed(1)}% complete
          </span>
        </div>
      </Card>

      {/* Key Metrics */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12 }}>
        <MetricCard label="BTC Price" value={btcPrice > 0 ? `$${btcPrice.toLocaleString()}` : '—'} subtitle={btcChange !== 0 ? `${btcChange >= 0 ? '+' : ''}${btcChange.toFixed(1)}% 24h` : 'loading'} color={btcChange >= 0 ? '#66bb6a' : '#ef5350'} />
        <MetricCard label="Day P&L" value={`${dayPL >= 0 ? '+' : ''}$${dayPL.toFixed(0)}`} subtitle={`${totalTradesToday} trades today`} color={dayPL >= 0 ? '#66bb6a' : '#ef5350'} />
        <MetricCard label="Win Rate" value={`${winRate}%`} subtitle={`${allWins}/${allTrades} trades`} color={winRate >= 50 ? '#66bb6a' : '#ff9800'} />
        <MetricCard label="Signals" value={String(totalSignalsToday)} subtitle={`${report?.signals?.buys || 0}B / ${report?.signals?.sells || 0}S`} color="#4fc3f7" />
      </div>

      {/* Regime + BTC Bias */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 16 }}>
        {/* Market Regime */}
        <Card>
          <SectionHeader title="Market Regime" />
          <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginTop: 8 }}>
            <span style={{ fontSize: 24, fontWeight: 700, color: regimeColor(regime?.overall_regime), fontFamily: "'JetBrains Mono', monospace" }}>
              {regime?.overall_regime?.replace(/_/g, ' ') || 'LOADING'}
            </span>
          </div>
          <div style={{ fontSize: 12, color: '#455a64', marginTop: 6 }}>Bias: {regime?.direction_bias || '—'}</div>
          <div style={{ fontSize: 11, color: '#607d8b', marginTop: 4 }}>{regime?.overall_recommendation || ''}</div>
          {regime?.timeframes && (
            <div style={{ display: 'flex', gap: 8, marginTop: 12 }}>
              {Object.entries(regime.timeframes).map(([tf, data]: [string, any]) => (
                <div key={tf} style={{ background: '#0d1117', borderRadius: 6, padding: '6px 10px', border: '1px solid #1a3a4a', flex: 1 }}>
                  <div style={{ fontSize: 11, fontWeight: 600, color: '#e0e0e0' }}>{tf}</div>
                  <div style={{ fontSize: 10, color: regimeColor(data.regime) }}>{data.regime?.replace(/_/g, ' ')}</div>
                  <div style={{ fontSize: 9, color: '#607d8b' }}>ADX {data.adx}</div>
                </div>
              ))}
            </div>
          )}
        </Card>

        {/* BTC Bias */}
        <BTCBiasWidget />
      </div>

      {/* Strategy Scoreboard + Position Book */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 16 }}>
        {/* Strategy Scoreboard */}
        <Card>
          <SectionHeader title="Strategy Parameters" />
          {params?.recommended_atr_period ? (
            <div style={{ marginTop: 8 }}>
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(2, 1fr)', gap: 8 }}>
                <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
                  <div style={{ fontSize: 10, color: '#607d8b' }}>ATR Period</div>
                  <div style={{ fontSize: 18, fontWeight: 700, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace" }}>{params.recommended_atr_period}</div>
                </div>
                <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
                  <div style={{ fontSize: 10, color: '#607d8b' }}>Multiplier</div>
                  <div style={{ fontSize: 18, fontWeight: 700, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace" }}>{params.recommended_multiplier}</div>
                </div>
                <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
                  <div style={{ fontSize: 10, color: '#607d8b' }}>Win Rate</div>
                  <div style={{ fontSize: 14, fontWeight: 600, color: '#66bb6a', fontFamily: "'JetBrains Mono', monospace" }}>{params.expected_win_rate}%</div>
                </div>
                <div style={{ background: '#0d1117', borderRadius: 6, padding: '8px 10px', border: '1px solid #1a3a4a' }}>
                  <div style={{ fontSize: 10, color: '#607d8b' }}>Profit Factor</div>
                  <div style={{ fontSize: 14, fontWeight: 600, color: '#66bb6a', fontFamily: "'JetBrains Mono', monospace" }}>{params.expected_profit_factor}</div>
                </div>
              </div>
              <div style={{ fontSize: 10, color: '#607d8b', marginTop: 8, fontFamily: "'JetBrains Mono', monospace" }}>
                Backtested: {params.backtest_return_pct}% return | Updated: {params.updated ? formatTime(params.updated) : '—'}
              </div>
            </div>
          ) : (
            <div style={{ color: '#607d8b', fontSize: 12, marginTop: 8 }}>Run optimizer to see params</div>
          )}
        </Card>

        {/* Position Book */}
        <Card>
          <SectionHeader title="Position Book" />
          <div style={{ marginTop: 8 }}>
            {openPositions.length === 0 ? (
              <div style={{ color: '#607d8b', fontSize: 12 }}>No open positions</div>
            ) : (
              openPositions.map(([ticker, data]: [string, any]) => (
                <div key={ticker} style={{ display: 'flex', alignItems: 'center', gap: 10, padding: '8px 0', borderBottom: '1px solid #1a3a4a' }}>
                  <span style={{ fontSize: 13, fontWeight: 600, color: '#e0e0e0', minWidth: 70 }}>{ticker}</span>
                  <Badge color={data.direction === 'LONG' ? '#66bb6a' : '#ef5350'}>{data.direction}</Badge>
                  <span style={{ flex: 1 }} />
                  <div style={{ textAlign: 'right' }}>
                    <div style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#e0e0e0' }}>
                      ${data.entry_price?.toLocaleString() || '—'}
                    </div>
                    <div style={{ fontSize: 10, color: '#607d8b' }}>{data.signal_count} signals</div>
                  </div>
                </div>
              ))
            )}
            {/* Portfolio summary */}
            <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 10, padding: '8px 0', borderTop: '1px solid #1a3a4a' }}>
              <span style={{ fontSize: 11, color: '#607d8b' }}>Cash available</span>
              <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#66bb6a' }}>${cash.toLocaleString()}</span>
            </div>
          </div>
        </Card>
      </div>

      {/* PM2 Process Status */}
      <div>
        <SectionHeader title="Infrastructure" />
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 10, marginTop: 8 }}>
          {Object.entries(report?.infrastructure?.pm2 || {}).map(([name, data]: [string, any]) => (
            <div key={name} style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 8, padding: '10px 14px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <div>
                <div style={{ fontSize: 13, fontWeight: 600, color: '#e0e0e0' }}>{name}</div>
                <div style={{ fontSize: 10, color: '#607d8b' }}>{data.memory_mb}MB · {data.restarts} restarts</div>
              </div>
              <Badge color={data.status === 'online' ? '#66bb6a' : '#ef5350'}>{data.status?.toUpperCase()}</Badge>
            </div>
          ))}
        </div>
      </div>

      {/* Live Signal Pipeline */}
      <Card>
        <SectionHeader title="Live Pipeline" />
        <div style={{ marginTop: 8, display: 'flex', flexDirection: 'column', gap: 6 }}>
          {signals.length === 0 ? (
            <div style={{ color: '#607d8b', fontSize: 12 }}>No signals yet today</div>
          ) : (
            signals.slice(0, 8).map((sig, i) => {
              const agentColors: Record<string, string> = { 'SUPERTREND_FLIP': '#4fc3f7', 'ENTRY': '#66bb6a', 'TP': '#ff9800', 'SL': '#ef5350' };
              const sigColor = agentColors[sig.signal_type] || '#607d8b';
              return (
                <div
                  key={i}
                  style={{
                    display: 'flex', alignItems: 'center', gap: 10,
                    padding: '8px 12px', borderLeft: `3px solid ${sigColor}`,
                    background: '#0d1117', borderRadius: '0 6px 6px 0',
                  }}
                >
                  <span style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#607d8b', minWidth: 50 }}>
                    {sig.timestamp ? new Date(sig.timestamp).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }) : ''}
                  </span>
                  <Badge color={sigColor}>{sig.signal_type || 'SIGNAL'}</Badge>
                  <span style={{ fontSize: 12, color: '#455a64', flex: 1 }}>
                    {sig.ticker} {sig.action} {sig.price ? `@ $${sig.price.toLocaleString()}` : ''}
                    {sig.timeframe && sig.timeframe !== 'UNKNOWN' ? ` · ${sig.timeframe}` : ''}
                  </span>
                  <span style={{ fontSize: 10, color: '#607d8b' }}>{formatTime(sig.timestamp)}</span>
                </div>
              );
            })
          )}
        </div>
      </Card>
    </div>
  );
}
