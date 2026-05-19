'use client';
import { useLiveStream } from '@/hooks/useLiveStream';
import { LiveIndicator } from '@/components/ui/LiveIndicator';
import { useEffect, useState } from 'react';
import { CopilotSection } from './CopilotSection';
import { BTCBiasWidget } from '../ui/BTCBiasWidget';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';

function dbTickerOnly(sym: string): string {
  if (!sym) return '';
  const s = String(sym).trim().toUpperCase();
  const occMatch = s.match(/^([A-Z]+)\d{6}[CP]/);
  if (occMatch) return occMatch[1];
  const firstWord = s.split(/[\s/]/)[0];
  return firstWord.replace(/[^A-Z]/g, '') || s;
}

// ============================================================================
// TERRAN DASHBOARD — Trading Decision Headquarters
// The ONE page that answers: "What should I do RIGHT NOW?"
// ============================================================================

// Parse whale liquidation raw_text. Format:
//   ┌🟢 #BTC Liquidated $125.6K in Short - at $76173.4
//   └☠️ 24h Liquidation for $BTC: $33.35M
function parseWhaleLiq(s: any) {
  const txt = s.raw_text || '';
  // amount + direction + spot price
  const m1 = txt.match(/Liquidated\s+\$([0-9,.]+)\s*([MKk]?)\s+in\s+(Long|Short|long|short)\s+-\s+at\s+\$([0-9,.]+)/);
  // 24h aggregate
  const m2 = txt.match(/24h\s+Liquidation\s+for\s+\$?[A-Z]+:\s+\$([0-9,.]+)\s*([MKk]?)/);
  const toNum = (v: string, mult: string) => {
    const n = parseFloat((v || '0').replace(/,/g, ''));
    if (mult === 'M') return n * 1_000_000;
    if (mult === 'K' || mult === 'k') return n * 1_000;
    return n;
  };
  return {
    symbol: s.symbol || '?',
    amount: m1 ? toNum(m1[1], m1[2]) : 0,
    direction: m1 ? m1[3].toUpperCase() : (s.direction || 'SHORT'),
    spot: m1 ? parseFloat(m1[4].replace(/,/g, '')) : 0,
    total24h: m2 ? toNum(m2[1], m2[2]) : 0,
    timestamp: s.timestamp,
    id: s.id,
  };
}

function timeAgoShort(ts: string): string {
  const diff = Date.now() - new Date(ts).getTime();
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'now';
  if (mins < 60) return mins + 'm';
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return hrs + 'h';
  return Math.floor(hrs / 24) + 'd';
}

function fmtDollarShort(n: number): string {
  if (n >= 1_000_000) return '$' + (n / 1_000_000).toFixed(2) + 'M';
  if (n >= 1_000) return '$' + (n / 1_000).toFixed(1) + 'K';
  return '$' + n.toFixed(0);
}

function WhaleLiquidationsWidget() {
  const [liqs, setLiqs] = useState<any[]>([]);

  useEffect(() => {
    const fetch_ = async () => {
      try {
        const r = await fetch('/api/telegram-signals');
        const d = await r.json();
        const sigs = Array.isArray(d) ? d : (d.signals || []);
        const wl = sigs
          .filter((s: any) => (s.channel_name || '').includes('Liquidat'))
          .map(parseWhaleLiq)
          .filter((x: any) => x.amount > 0);
        setLiqs(wl);
      } catch {}
    };
    fetch_();
    const t = setInterval(fetch_, 30000);
    return () => clearInterval(t);
  }, []);

  if (liqs.length === 0) {
    return (
      <div className="db-card" style={{ padding: '16px' }}>
        <div className="db-label" style={{ marginBottom: '10px' }}>WHALE LIQUIDATIONS</div>
        <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)' }}>No liquidations in window</div>
      </div>
    );
  }

  // Pressure: longs wrecked vs shorts wrecked
  const longsCount = liqs.filter((l: any) => l.direction === 'LONG').length;
  const shortsCount = liqs.filter((l: any) => l.direction === 'SHORT').length;
  const total = longsCount + shortsCount;
  const longsPct = total > 0 ? Math.round((longsCount / total) * 100) : 0;
  const shortsPct = 100 - longsPct;

  // Per-symbol 24h totals (grab latest seen value per symbol)
  const bySymbol: Record<string, { total24h: number; count: number; lastSeen: number }> = {};
  for (const l of liqs) {
    if (!bySymbol[l.symbol] || new Date(l.timestamp).getTime() > bySymbol[l.symbol].lastSeen) {
      bySymbol[l.symbol] = {
        total24h: l.total24h || bySymbol[l.symbol]?.total24h || 0,
        count: (bySymbol[l.symbol]?.count || 0) + 1,
        lastSeen: new Date(l.timestamp).getTime(),
      };
    } else {
      bySymbol[l.symbol].count += 1;
    }
  }
  const symbolRows = Object.entries(bySymbol)
    .sort((a, b) => b[1].total24h - a[1].total24h)
    .slice(0, 5);
  const maxTotal = Math.max(...symbolRows.map(([, v]) => v.total24h), 1);
  const aggregateTotal = symbolRows.reduce((s, [, v]) => s + v.total24h, 0);

  // Latest 5 events
  const latest5 = [...liqs]
    .sort((a: any, b: any) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime())
    .slice(0, 5);

  return (
    <div className="db-card" style={{ padding: '16px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: '10px' }}>
        <div className="db-label">WHALE LIQUIDATIONS</div>
        <div style={{ fontSize: 'var(--mc-font-label)', color: '#ff9800', fontFamily: 'var(--font-mc-mono)', fontWeight: 700 }}>
          24h: {fmtDollarShort(aggregateTotal)}
        </div>
      </div>

      {/* Pressure bar */}
      <div style={{ marginBottom: '12px' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>
          <span style={{ color: '#66bb6a' }}>LONGS WRECKED {longsPct}%</span>
          <span style={{ color: '#ef5350' }}>{shortsPct}% SHORTS WRECKED</span>
        </div>
        <div style={{ height: '6px', background: '#0d1117', borderRadius: '3px', overflow: 'hidden', display: 'flex' }}>
          <div style={{ width: longsPct + '%', background: '#66bb6a', transition: 'width 0.5s' }} />
          <div style={{ width: shortsPct + '%', background: '#ef5350', transition: 'width 0.5s' }} />
        </div>
      </div>

      {/* Per-asset heat bars */}
      <div style={{ marginBottom: '12px' }}>
        {symbolRows.map(([sym, v]: [string, any]) => {
          const barPct = (v.total24h / maxTotal) * 100;
          return (
            <div key={sym} style={{ display: 'grid', gridTemplateColumns: '42px 1fr 78px 50px', gap: '8px', alignItems: 'center', padding: '3px 0', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{sym}</span>
              <div style={{ height: '8px', background: '#0d1117', borderRadius: '2px', overflow: 'hidden' }}>
                <div style={{ height: '100%', width: barPct + '%', background: 'linear-gradient(90deg, #ff9800, #ef5350)', borderRadius: '2px', transition: 'width 0.5s' }} />
              </div>
              <span style={{ color: '#e0e0e0', textAlign: 'right', fontWeight: 600 }}>{fmtDollarShort(v.total24h)}</span>
              <span style={{ color: '#607d8b', textAlign: 'right' }}>{v.count} liq{v.count !== 1 ? 's' : ''}</span>
            </div>
          );
        })}
      </div>

      {/* Latest-5 ticker */}
      <div style={{ borderTop: '1px solid #1a3a4a', paddingTop: '8px' }}>
        <div className="db-label" style={{ marginBottom: '6px' }}>LATEST</div>
        {latest5.map((l: any) => {
          const dirColor = l.direction === 'LONG' ? '#66bb6a' : '#ef5350';
          return (
            <div key={l.id} style={{ display: 'grid', gridTemplateColumns: '32px 42px 52px 1fr 80px', gap: '6px', alignItems: 'center', padding: '3px 0', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#607d8b' }}>{timeAgoShort(l.timestamp)}</span>
              <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{l.symbol}</span>
              <span style={{ display: 'inline-flex', alignItems: 'center', justifyContent: 'center', padding: '0 6px', borderRadius: '3px', background: dirColor + '22', border: '1px solid ' + dirColor + '55', color: dirColor, fontWeight: 700, fontSize: '9px' }}>{l.direction}</span>
              <span style={{ color: '#ff9800', fontWeight: 600 }}>-{fmtDollarShort(l.amount)}</span>
              <span style={{ color: '#90a4ae', textAlign: 'right' }}>@ ${l.spot >= 1000 ? l.spot.toLocaleString(undefined, { maximumFractionDigits: 0 }) : l.spot.toFixed(2)}</span>
            </div>
          );
        })}
      </div>
    </div>
  );
}


export function DashboardPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [report, setReport] = useState<any>(null);
  const [params, setParams] = useState<any>(null);
  const [crypto, setCrypto] = useState<any>(null);
  const [topFlowsCount, setTopFlowsCount] = useState<number>(0);
  useEffect(() => {
    const fetchFlows = () => {
      fetch('/api/options-flow')
        .then(r => r.ok ? r.json() : { flows: [] })
        .then(d => {
          const flows = d?.flows || [];
          const count = flows.filter((f: any) => (f.Value || 0) >= 1000000).length;
          setTopFlowsCount(count);
        })
        .catch(() => {});
    };
    fetchFlows();
    const iv = setInterval(fetchFlows, 30000);
    return () => clearInterval(iv);
  }, []);
  const live = useLiveStream(true);
  const [loading, setLoading] = useState(true);
  const [equityHist, setEquityHist] = useState<any[]>([]);
  const [tick, setTick] = useState(0);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchAll = async () => {
    try {
      const [pRes, sRes, rRes, repRes, prRes, cRes, ehRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/daily-report').then(r => r.json()).catch(() => null),
        fetch('/api/supertrend-params').then(r => r.json()).catch(() => null),
        fetch('/api/crypto').then(r => r.json()).catch(() => null),
        fetch('/api/equity-history?days=30').then(r => r.json()).catch(() => null),
      ]);
      setPortfolio(pRes); setSignals(sRes);
      if (ehRes?.history) setEquityHist(ehRes.history); setRegime(rRes);
      setReport(repRes); setParams(prRes); setCrypto(cRes);
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  };

  useEffect(() => {
    fetchAll();
    const d = setInterval(fetchAll, 15000);
    const t = setInterval(() => setTick(x => x + 1), 1000);
    return () => { clearInterval(d); clearInterval(t); };
  }, []);

  const equity = parseFloat(portfolio?.equity || portfolio?.balance || '0');
  const lastEq = parseFloat(portfolio?.last_equity || '0');
  const dailyPct = lastEq ? ((equity - lastEq) / lastEq * 100) : 0;
  const dailyChange = equity - lastEq;
  const totalReturn = ((equity - 500000) / 500000 * 100);
  const positions = portfolio?.positions || [];
  const btcSignal = signals?.BTCUSD || {};
  const regimeStr = regime?.overall_regime || 'UNKNOWN';
  const bias = regime?.direction_bias || '';
  const timeframes = regime?.timeframes || {};

  const pnlHistory = signals?.BTCUSD?.pnl_history || [];
  const wins = pnlHistory.filter((t: any) => t.pnl_pct > 0).length;
  const winRate = pnlHistory.length > 0 ? (wins / pnlHistory.length * 100) : 0;

  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ animation: 'db-blink 1s infinite' }}>LOADING DASHBOARD...</div>
    </div>
  );

  // Determine market stance
  const stanceColor = bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800';
  const stanceText = bias === 'BULLISH' ? 'RISK ON — Favor longs' : bias === 'BEARISH' ? 'RISK OFF — Defensive' : 'NEUTRAL — Wait for clarity';

  return (
    <div style={{ padding: '20px', maxWidth: '1400px', margin: '0 auto' }}>
      <style>{`
        @keyframes db-blink { 0%,100% { opacity: 1; } 50% { opacity: 0.3; } }
        @keyframes db-breathe { 0%,100% { box-shadow: 0 0 8px #4fc3f711; } 50% { box-shadow: 0 0 20px #4fc3f722; } }
        @keyframes db-slide { from { transform: translateX(-10px); opacity: 0; } to { transform: translateX(0); opacity: 1; } }
        .db-card { background: linear-gradient(180deg, #0a1929 0%, #0d1420 100%); border: 1px solid #1a3a4a; border-radius: 10px; position: relative; animation: db-breathe 4s ease-in-out infinite; }
        .db-label { font-size: 10px; color: #607d8b; text-transform: uppercase; letter-spacing: 1.5px; font-family: var(--font-mc-mono); }
        .db-glow-line { height: 2px; background: linear-gradient(90deg, transparent, #4fc3f7, transparent); border-radius: 1px; }
      `}</style>

      {/* === STANCE BANNER === */}
      <div style={{
        padding: '14px 24px', marginBottom: '16px', borderRadius: '10px',
        background: `linear-gradient(135deg, ${stanceColor}11, #0a1929)`,
        border: `1px solid ${stanceColor}33`,
        display: 'flex', justifyContent: 'space-between', alignItems: 'center',
      }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '14px' }}>
          <div style={{ width: '12px', height: '12px', borderRadius: '50%', background: stanceColor, boxShadow: `0 0 10px ${stanceColor}` }} />
          <div>
            <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: stanceColor, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>
              {regimeStr.replace(/_/g, ' ')} — {bias}
            </div>
            <div style={{ fontSize: 'var(--mc-font-badge)', color: '#607d8b', marginTop: '2px' }}>{stanceText}</div>
          </div>
        </div>
        <div style={{ textAlign: 'right' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>SUPERTREND</div>
          <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: btcSignal.direction === 'LONG' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
            {btcSignal.direction === 'LONG' ? '▲ LONG' : btcSignal.direction === 'SHORT' ? '▼ SHORT' : '— WAIT'}
          </div>
        </div>
      </div>

      {/* === MARKET PULSE BAR === */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '8px', marginBottom: '16px' }}>
        {[
          { sym: 'BTC', price: crypto?.bitcoin?.usd || 0, chg: crypto?.bitcoin?.usd_24h_change || 0 },
          { sym: 'ETH', price: crypto?.ethereum?.usd || 0, chg: crypto?.ethereum?.usd_24h_change || 0 },
          { sym: 'SOL', price: crypto?.solana?.usd || 0, chg: crypto?.solana?.usd_24h_change || 0 },
          { sym: '$1M+ FLOWS', price: topFlowsCount, chg: 0, isCount: true },
        ].map((c, i) => (
          <div key={i} onClick={() => { if (!(c as any).isCount) setDrawerTicker(c.sym); }} style={{
            background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px',
            padding: '12px 16px', display: 'flex', justifyContent: 'space-between', alignItems: 'center',
            cursor: (c as any).isCount ? 'default' : 'pointer',
          }}>
            <div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{c.sym}</div>
              <div style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                ${c.price >= 1000 ? fmt(c.price, 0) : fmt(c.price)}
              </div>
            </div>
            <div style={{
              fontSize: 'var(--mc-font-sm)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)',
              color: c.chg >= 0 ? '#66bb6a' : '#ef5350',
              padding: '4px 10px', borderRadius: '6px',
              background: c.chg >= 0 ? '#66bb6a11' : '#ef535011',
            }}>
              {c.chg >= 0 ? '+' : ''}{fmt(c.chg, 1)}%
            </div>
          </div>
        ))}
      </div>

      {/* === MAIN 3-COLUMN === */}
      <div style={{ display: 'grid', gridTemplateColumns: '700px 1fr 320px', gap: '14px' }}>

        {/* LEFT: Portfolio Deep Dive */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
          {/* Equity Card */}
          <div className="db-card" style={{ padding: '20px' }}>
            <div className="db-label" style={{ marginBottom: '8px' }}>PORTFOLIO EQUITY</div>
            <div style={{ fontSize: '34px', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', lineHeight: 1 }}>${fmt(equity)}</div>
            <div style={{ display: 'flex', gap: '16px', marginTop: '10px' }}>
              <div style={{ fontSize: 'var(--mc-font-xs)', color: dailyPct >= 0 ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                {dailyPct >= 0 ? '▲' : '▼'} {fmt(Math.abs(dailyPct))}%
              </div>
              <div style={{ fontSize: 'var(--mc-font-xs)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                ${fmt(Math.abs(dailyChange))}
              </div>
            </div>
            <div className="db-glow-line" style={{ marginTop: '14px' }} />
            <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '10px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#607d8b' }}>RETURN</span>
              <span style={{ color: totalReturn >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>{totalReturn >= 0 ? '+' : ''}{fmt(totalReturn, 1)}%</span>
            </div>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '4px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#607d8b' }}>WIN RATE</span>
              <span style={{ color: winRate > 50 ? '#66bb6a' : '#ff9800', fontWeight: 600 }}>{fmt(winRate, 0)}% ({wins}/{pnlHistory.length})</span>
            </div>
          </div>

          {/* Positions — Round 1 + Round 2 side by side */}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '14px' }}>

            {/* Round 1 Positions (R1 — PA3Y7UTNIQFZ) */}
            <div className="db-card" style={{ padding: '16px' }}>
              <div className="db-label" style={{ marginBottom: '12px', color: '#ff9800' }}>Round 1 Positions ({positions.filter((p: any) => p.account === 'R1').length})</div>
              {positions.filter((p: any) => p.account === 'R1').length === 0 ? (
                <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)' }}>No open positions</div>
              ) : positions.filter((p: any) => p.account === 'R1').map((p: any, i: number) => {
                const pnl = parseFloat(p.unrealized_pl || '0');
                const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
                const g = pnl >= 0;
                return (
                  <div key={i} style={{
                    padding: '12px', background: '#0d1117', borderRadius: '8px',
                    border: `1px solid ${g ? '#66bb6a22' : '#ef535022'}`,
                    marginBottom: '8px', animation: `db-slide 0.3s ease-out ${i * 0.1}s both`,
                  }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '6px' }}>
                      <span onClick={() => setDrawerTicker(dbTickerOnly(p.symbol))} style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', cursor: 'pointer' }}>{p.symbol}</span>
                      <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: g ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                        {g ? '+' : ''}{fmt(pnlPct, 1)}%
                      </span>
                    </div>
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                      <span>{p.qty} @ ${fmt(parseFloat(p.avg_entry_price || '0'))}</span>
                      <span style={{ color: g ? '#66bb6a' : '#ef5350' }}>{g ? '+' : ''}${fmt(pnl)}</span>
                    </div>
                    <div style={{ height: '3px', borderRadius: '2px', background: '#0a1929', marginTop: '8px', overflow: 'hidden' }}>
                      <div style={{ height: '100%', width: `${Math.min(Math.abs(pnlPct) * 3, 100)}%`, background: g ? '#66bb6a' : '#ef5350', borderRadius: '2px' }} />
                    </div>
                    {pnlPct > 10 && <div style={{ fontSize: 'var(--mc-font-label)', color: '#ff9800', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>⚠ Consider partial profit</div>}
                    {pnlPct < -3 && <div style={{ fontSize: 'var(--mc-font-label)', color: '#ef5350', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>⚠ Review stop loss</div>}
                  </div>
                );
              })}
            </div>

            {/* Round 2 (R2 — PA3R6MOPBWF7) */}
            <div className="db-card" style={{ padding: '16px' }}>
              <div className="db-label" style={{ marginBottom: '12px', color: '#4fc3f7' }}>Round 2 ({positions.filter((p: any) => p.account === 'R2' || !p.account).length})</div>
              {positions.filter((p: any) => p.account === 'R2' || !p.account).length === 0 ? (
                <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)' }}>No open positions</div>
              ) : positions.filter((p: any) => p.account === 'R2' || !p.account).map((p: any, i: number) => {
                const pnl = parseFloat(p.unrealized_pl || '0');
                const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
                const g = pnl >= 0;
                return (
                  <div key={i} style={{
                    padding: '12px', background: '#0d1117', borderRadius: '8px',
                    border: `1px solid ${g ? '#66bb6a22' : '#ef535022'}`,
                    marginBottom: '8px', animation: `db-slide 0.3s ease-out ${i * 0.1}s both`,
                  }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '6px' }}>
                      <span onClick={() => setDrawerTicker(dbTickerOnly(p.symbol))} style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', cursor: 'pointer' }}>{p.symbol}</span>
                      <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: g ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                        {g ? '+' : ''}{fmt(pnlPct, 1)}%
                      </span>
                    </div>
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
                      <span>{p.qty} @ ${fmt(parseFloat(p.avg_entry_price || '0'))}</span>
                      <span style={{ color: g ? '#66bb6a' : '#ef5350' }}>{g ? '+' : ''}${fmt(pnl)}</span>
                    </div>
                    <div style={{ height: '3px', borderRadius: '2px', background: '#0a1929', marginTop: '8px', overflow: 'hidden' }}>
                      <div style={{ height: '100%', width: `${Math.min(Math.abs(pnlPct) * 3, 100)}%`, background: g ? '#66bb6a' : '#ef5350', borderRadius: '2px' }} />
                    </div>
                    {pnlPct > 10 && <div style={{ fontSize: 'var(--mc-font-label)', color: '#ff9800', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>⚠ Consider partial profit</div>}
                    {pnlPct < -3 && <div style={{ fontSize: 'var(--mc-font-label)', color: '#ef5350', marginTop: '4px', fontFamily: 'var(--font-mc-mono)' }}>⚠ Review stop loss</div>}
                  </div>
                );
              })}
            </div>

          </div>
        </div>

        {/* CENTER: BTC Analysis */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
          {/* BTC Bias Widget */}
          <BTCBiasWidget />

          {/* Multi-Timeframe Technical */}
          <div className="db-card" style={{ padding: '18px' }}>
            <div className="db-label" style={{ marginBottom: '14px' }}>BTC MULTI-TIMEFRAME ANALYSIS</div>
            {Object.entries(timeframes).length === 0 ? (
              <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)' }}>Awaiting regime data...</div>
            ) : Object.entries(timeframes).map(([tf, data]: [string, any]) => {
              const dirColor = data.direction === 'BULLISH' ? '#66bb6a' : data.direction === 'BEARISH' ? '#ef5350' : '#ff9800';
              const adxWidth = Math.min((data.adx || 0) / 60 * 100, 100);
              return (
                <div key={tf} style={{ marginBottom: '14px', padding: '12px', background: '#0d1117', borderRadius: '6px', borderLeft: `3px solid ${dirColor}` }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                    <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{tf}</span>
                    <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 600, color: dirColor, fontFamily: 'var(--font-mc-mono)', padding: '2px 10px', background: `${dirColor}11`, borderRadius: '4px' }}>
                      {data.direction || data.regime || 'N/A'}
                    </span>
                  </div>
                  <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '8px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                    <div>
                      <span style={{ color: '#607d8b' }}>ADX</span>
                      <div style={{ height: '4px', background: '#0a1929', borderRadius: '2px', marginTop: '4px' }}>
                        <div style={{ height: '100%', width: `${adxWidth}%`, background: data.adx > 25 ? '#66bb6a' : '#ff9800', borderRadius: '2px' }} />
                      </div>
                      <span style={{ color: data.adx > 25 ? '#66bb6a' : '#ff9800' }}>{data.adx?.toFixed(1) || 'N/A'}</span>
                    </div>
                    <div>
                      <span style={{ color: '#607d8b' }}>CHOP</span>
                      <div style={{ marginTop: '4px', color: data.choppiness > 60 ? '#ef5350' : '#66bb6a' }}>{data.choppiness?.toFixed(1) || 'N/A'}</div>
                    </div>
                    <div>
                      <span style={{ color: '#607d8b' }}>EFFICIENCY</span>
                      <div style={{ marginTop: '4px', color: '#4fc3f7' }}>{data.trend_efficiency?.toFixed(3) || 'N/A'}</div>
                    </div>
                  </div>
                </div>
              );
            })}
          </div>

          {/* SuperTrend Signal */}
          <div className="db-card" style={{ padding: '18px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <div>
                <div className="db-label" style={{ marginBottom: '6px' }}>SUPERTREND SIGNAL</div>
                <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 800, color: btcSignal.direction === 'LONG' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                  {btcSignal.direction || 'N/A'}
                </div>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginTop: '4px' }}>
                  Entry: ${btcSignal.entry_price ? Number(btcSignal.entry_price).toLocaleString() : 'N/A'} | Signals: {btcSignal.signal_count || 0}
                </div>
              </div>
              {params && (
                <div style={{ textAlign: 'right' }}>
                  <div className="db-label" style={{ marginBottom: '4px' }}>OPTIMIZER</div>
                  <div style={{ fontSize: 'var(--mc-font-xs)', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>ATR {params.recommended_atr_period} × {params.recommended_multiplier}</div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>+{params.backtest_return_pct}% backtest</div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#ff9800', fontFamily: 'var(--font-mc-mono)' }}>{params.expected_win_rate}% WR | {params.expected_profit_factor} PF</div>
                </div>
              )}
            </div>
          </div>
        </div>

        {/* RIGHT: Signals + Daily Report */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
          {/* Today's Report */}
          {report && (
            <div className="db-card" style={{ padding: '16px' }}>
              <div className="db-label" style={{ marginBottom: '12px' }}>TODAY'S REPORT</div>
              {report.summary ? (
                <div style={{ fontSize: 'var(--mc-font-badge)', color: '#b0bec5', lineHeight: '1.6' }}>{report.summary}</div>
              ) : (
                <>
                  <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '6px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                    {[
                      { l: 'SIGNALS', v: report?.signals?.total || 0, c: '#4fc3f7' },
                      { l: 'TRADES', v: report?.trades || 0, c: '#66bb6a' },
                      (() => { const pn = typeof report?.pnl === 'object' ? (report.pnl?.BTCUSD?.total_pnl_pct ?? report.pnl?.total ?? report.pnl?.value ?? report.pnl?.amount ?? report.pnl?.daily ?? 0) : (typeof report?.pnl === 'number' ? report.pnl : 0); return { l: 'P/L', v: pn !== 0 ? `${pn >= 0 ? '+' : ''}${fmt(pn)}%` : 'N/A', c: pn >= 0 ? '#66bb6a' : '#ef5350' }; })(),
                      { l: 'ALERTS', v: report?.alerts || 0, c: '#ff9800' },
                    ].map((s, i) => (
                      <div key={i} style={{ padding: '8px 10px', background: '#0d1117', borderRadius: '4px', display: 'flex', justifyContent: 'space-between' }}>
                        <span style={{ color: '#607d8b' }}>{s.l}</span>
                        <span style={{ color: s.c, fontWeight: 600 }}>{s.v}</span>
                      </div>
                    ))}
                  </div>
                </>
              )}
            </div>
          )}

          {/* Recent Signal History */}
          <div className="db-card" style={{ padding: '16px' }}>
            <div className="db-label" style={{ marginBottom: '12px' }}>RECENT SIGNALS</div>
            {pnlHistory.length === 0 ? (
              <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)' }}>No signal history</div>
            ) : [...pnlHistory].reverse().slice(0, 8).map((t: any, i: number) => {
              const g = t.pnl_pct > 0;
              const d = t.closed_at ? new Date(t.closed_at) : null;
              return (
                <div key={i} style={{
                  display: 'flex', justifyContent: 'space-between', alignItems: 'center',
                  padding: '8px 10px', borderLeft: `2px solid ${g ? '#66bb6a' : '#ef5350'}`,
                  background: '#0d1117', borderRadius: '3px', marginBottom: '4px',
                  fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)',
                }}>
                  <span style={{ color: '#455a64', minWidth: '50px' }}>{d ? d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) : '?'}</span>
                  <span style={{ color: t.direction === 'LONG' ? '#66bb6a' : '#ef5350', minWidth: '40px' }}>{t.direction}</span>
                  <span style={{ color: '#607d8b' }}>${fmt(t.entry, 0)}→${fmt(t.exit, 0)}</span>
                  <span style={{ color: g ? '#66bb6a' : '#ef5350', fontWeight: 700 }}>{g ? '+' : ''}{fmt(t.pnl_pct)}%</span>
                </div>
              );
            })}
          </div>

          
          <WhaleLiquidationsWidget />

          {/* Equity History */}
          {equityHist.length > 1 && (
            <div className="db-card" style={{ padding: '16px' }}>
              <div className="db-label" style={{ marginBottom: '10px' }}>EQUITY CURVE ({equityHist.length} days)</div>
              <div style={{ display: 'flex', gap: '2px', alignItems: 'flex-end', height: '60px' }}>
                {equityHist.slice().reverse().map((s: any, i: number) => {
                  const min = Math.min(...equityHist.map((h: any) => h.equity));
                  const max = Math.max(...equityHist.map((h: any) => h.equity));
                  const range = max - min || 1;
                  const pct = ((s.equity - min) / range) * 100;
                  const g = s.daily_pnl_pct >= 0;
                  return (
                    <div key={i} style={{
                      flex: 1, minWidth: '4px', maxWidth: '12px',
                      height: `${Math.max(pct, 5)}%`,
                      background: g ? '#66bb6a' : '#ef5350',
                      borderRadius: '2px 2px 0 0',
                      opacity: 0.7 + (i / equityHist.length) * 0.3,
                    }} title={`${s.date}: $${s.equity?.toFixed(0)} (${s.daily_pnl_pct?.toFixed(1)}%)`} />
                  );
                })}
              </div>
            </div>
          )}

          {/* Quick Stats */}
          <div className="db-card" style={{ padding: '16px' }}>
            <div className="db-label" style={{ marginBottom: '10px' }}>ACCOUNT</div>
            {[
              { l: 'BUYING POWER', v: `$${fmt(parseFloat(portfolio?.buying_power || '0'))}`, c: '#4fc3f7' },
              { l: 'CASH', v: `$${fmt(parseFloat(portfolio?.cash || '0'))}`, c: '#607d8b' },
              { l: 'GOAL ($1M)', v: `${fmt(Math.min(Math.max(((equity - 500000) / 500000) * 100, 0), 100), 0)}%`, c: '#ff9800' },
            ].map((s, i) => (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 10px', background: '#0d1117', borderRadius: '4px', marginBottom: '4px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                <span style={{ color: '#607d8b' }}>{s.l}</span>
                <span style={{ color: s.c, fontWeight: 600 }}>{s.v}</span>
              </div>
            ))}
          </div>
        </div>
      </div>
      <CopilotSection />
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
