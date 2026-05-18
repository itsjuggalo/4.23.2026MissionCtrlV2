'use client';
// MC_WATCHER_GUARD
if (typeof window !== 'undefined') { window.addEventListener('unhandledrejection', (e) => { console.warn('[OptionsWatcher]', e.reason); e.preventDefault(); }); }
import { useState, useEffect, useRef, useMemo } from 'react';

// ── TYPES ──
interface OptionContract {
  symbol: string; description: string; strike: number; option_type: string;
  last: number; change: number; volume: number; open_interest: number;
  bid: number; ask: number; high: number; low: number;
  greeks?: { delta: number; gamma: number; theta: number; vega: number; rho: number; mid_iv: number; smv_vol: number; };
}
interface Quote { symbol: string; last: number; change: number; change_percentage: number; prevclose: number; high: number; low: number; volume: number; }
interface FlowEntry { BidAskType: string; BlockType: string; COLOR: string; Expiry: number; ExpiryStr: string; OI: number; OptionType: string; Price: number; Spot: number; Strike: number; Symbol: string; Time: number; UnderlyingType: string; Value: number; Volume: number; }

type TabType = 'chain' | 'volatility' | 'strategy';
type FilterType = 'both' | 'call' | 'put';
type MoneynessType = 'both' | 'itm' | 'otm';

// ── HELPERS ──
const fmtVal = (n: number | null | undefined) => { if (n == null || !isFinite(n)) return '-'; return n >= 1e6 ? `$${(n/1e6).toFixed(1)}M` : n >= 1e3 ? `$${(n/1e3).toFixed(0)}K` : `$${n}`; };
const fmtPct = (n: number | null | undefined) => { if (n == null || !isFinite(n)) return '-'; return `${n >= 0 ? '+' : ''}${(n ?? 0).toFixed(2)}%`; };
const fmtPrice = (n: number | null | undefined) => { if (n == null || !isFinite(n)) return '-'; return n >= 1000 ? `$${(n ?? 0).toFixed(2)}` : n >= 1 ? `$${(n ?? 0).toFixed(2)}` : `$${(n ?? 0).toFixed(4)}`; };
const timeAgo = (ts: number) => { const m = Math.floor((Date.now()-ts)/60000); return m<1?'now':m<60?m+'m':m<1440?Math.floor(m/60)+'h':Math.floor(m/1440)+'d'; };
const premiumColor = (v: number) => v>=5e6?'#e040fb':v>=1e6?'#ffd600':v>=5e5?'#ff9800':v>=25e4?'#4fc3f7':v>=1e5?'#e0e0e0':v>=5e4?'#90a4ae':'#607d8b';

function isAsk(ba: string) { return ba === 'A' || ba === 'AA'; }
function getSentiment(f: FlowEntry): 'BULLISH' | 'BEARISH' {
  const ask = isAsk(f.BidAskType);
  if (f.OptionType === 'CALL' && ask) return 'BULLISH';
  if (f.OptionType === 'PUT' && !ask) return 'BULLISH';
  return 'BEARISH';
}

// ── STRATEGY DEFINITIONS ──
const STRATEGIES: Record<string, { name: string; legs: { type: 'call'|'put'; side: 'buy'|'sell'; strikeOffset: number }[] }[]> = {
  Bullish: [
    { name: 'Long Call', legs: [{ type: 'call', side: 'buy', strikeOffset: 0 }] },
    { name: 'Short Put', legs: [{ type: 'put', side: 'sell', strikeOffset: 0 }] },
    { name: 'Bull Call Spread', legs: [{ type: 'call', side: 'buy', strikeOffset: 0 }, { type: 'call', side: 'sell', strikeOffset: 5 }] },
    { name: 'Bull Put Spread', legs: [{ type: 'put', side: 'sell', strikeOffset: 0 }, { type: 'put', side: 'buy', strikeOffset: -5 }] },
    { name: 'Long Covered Call', legs: [{ type: 'call', side: 'sell', strikeOffset: 5 }] },
  ],
  Neutral: [
    { name: 'Short Straddle', legs: [{ type: 'call', side: 'sell', strikeOffset: 0 }, { type: 'put', side: 'sell', strikeOffset: 0 }] },
    { name: 'Short Strangle', legs: [{ type: 'call', side: 'sell', strikeOffset: 5 }, { type: 'put', side: 'sell', strikeOffset: -5 }] },
    { name: 'Long Call Butterfly', legs: [{ type: 'call', side: 'buy', strikeOffset: -5 }, { type: 'call', side: 'sell', strikeOffset: 0 }, { type: 'call', side: 'sell', strikeOffset: 0 }, { type: 'call', side: 'buy', strikeOffset: 5 }] },
    { name: 'Iron Condor', legs: [{ type: 'put', side: 'buy', strikeOffset: -10 }, { type: 'put', side: 'sell', strikeOffset: -5 }, { type: 'call', side: 'sell', strikeOffset: 5 }, { type: 'call', side: 'buy', strikeOffset: 10 }] },
    { name: 'Iron Butterfly', legs: [{ type: 'put', side: 'buy', strikeOffset: -5 }, { type: 'put', side: 'sell', strikeOffset: 0 }, { type: 'call', side: 'sell', strikeOffset: 0 }, { type: 'call', side: 'buy', strikeOffset: 5 }] },
    { name: 'Long Put Butterfly', legs: [{ type: 'put', side: 'buy', strikeOffset: -5 }, { type: 'put', side: 'sell', strikeOffset: 0 }, { type: 'put', side: 'sell', strikeOffset: 0 }, { type: 'put', side: 'buy', strikeOffset: 5 }] },
  ],
  Volatility: [
    { name: 'Long Straddle', legs: [{ type: 'call', side: 'buy', strikeOffset: 0 }, { type: 'put', side: 'buy', strikeOffset: 0 }] },
    { name: 'Long Strangle', legs: [{ type: 'call', side: 'buy', strikeOffset: 5 }, { type: 'put', side: 'buy', strikeOffset: -5 }] },
    { name: 'Short Call Butterfly', legs: [{ type: 'call', side: 'sell', strikeOffset: -5 }, { type: 'call', side: 'buy', strikeOffset: 0 }, { type: 'call', side: 'buy', strikeOffset: 0 }, { type: 'call', side: 'sell', strikeOffset: 5 }] },
    { name: 'Short Put Butterfly', legs: [{ type: 'put', side: 'sell', strikeOffset: -5 }, { type: 'put', side: 'buy', strikeOffset: 0 }, { type: 'put', side: 'buy', strikeOffset: 0 }, { type: 'put', side: 'sell', strikeOffset: 5 }] },
    { name: 'Long Iron Butterfly', legs: [{ type: 'put', side: 'sell', strikeOffset: -5 }, { type: 'put', side: 'buy', strikeOffset: 0 }, { type: 'call', side: 'buy', strikeOffset: 0 }, { type: 'call', side: 'sell', strikeOffset: 5 }] },
    { name: 'Long Iron Condor', legs: [{ type: 'put', side: 'sell', strikeOffset: -10 }, { type: 'put', side: 'buy', strikeOffset: -5 }, { type: 'call', side: 'buy', strikeOffset: 5 }, { type: 'call', side: 'sell', strikeOffset: 10 }] },
  ],
  Bearish: [
    { name: 'Long Put', legs: [{ type: 'put', side: 'buy', strikeOffset: 0 }] },
    { name: 'Short Call', legs: [{ type: 'call', side: 'sell', strikeOffset: 0 }] },
    { name: 'Bear Call Spread', legs: [{ type: 'call', side: 'sell', strikeOffset: 0 }, { type: 'call', side: 'buy', strikeOffset: 5 }] },
    { name: 'Bear Put Spread', legs: [{ type: 'put', side: 'buy', strikeOffset: 0 }, { type: 'put', side: 'sell', strikeOffset: -5 }] },
  ],
};

// ── CHAIN TABLE ROW ──
function ChainRow({ call, put, strike, currentPrice }: { call?: OptionContract; put?: OptionContract; strike: number; currentPrice: number }) {
  const isATM = Math.abs(strike - currentPrice) < 1;
  const isITMCall = strike < currentPrice;
  const isITMPut = strike > currentPrice;

  const cellStyle = (isItm: boolean): React.CSSProperties => ({
    fontSize: 'var(--mc-font-xs)', fontFamily: 'var(--font-mc-mono)', padding: '4px 6px',
    textAlign: 'right', color: '#e0e0e0', background: isItm ? '#66bb6a08' : 'transparent',
  });

  const ivColor = (iv: number) => iv > 0.5 ? '#ef5350' : iv > 0.3 ? '#ff9800' : '#66bb6a';
  const deltaColor = (d: number) => d > 0 ? '#66bb6a' : '#ef5350';
  const volColor = (v: number) => v >= 10000 ? '#e040fb' : v >= 5000 ? '#ffd600' : v >= 1000 ? '#ff9800' : v >= 500 ? '#4fc3f7' : '#90a4ae';

  return (
    <tr style={{ borderBottom: '1px solid #0d1117', background: isATM ? '#4fc3f710' : 'transparent' }}>
      {/* CALL SIDE */}
      <td style={{ ...cellStyle(isITMCall), color: deltaColor(call?.greeks?.delta || 0) }}>{call?.greeks?.delta?.toFixed(4) || '--'}</td>
      <td style={{ ...cellStyle(isITMCall), color: ivColor(call?.greeks?.mid_iv || 0) }}>{call?.greeks?.mid_iv ? ((call?.greeks?.mid_iv ?? 0) * 100).toFixed(1) + '%' : '--'}</td>
      <td style={{ ...cellStyle(isITMCall), color: volColor(call?.open_interest || 0) }}>{call?.open_interest?.toLocaleString() || '--'}</td>
      <td style={{ ...cellStyle(isITMCall), color: volColor(call?.volume || 0) }}>{call?.volume?.toLocaleString() || '--'}</td>
      <td style={{ ...cellStyle(isITMCall), color: (call?.change || 0) >= 0 ? '#66bb6a' : '#ef5350' }}>{call?.change !== undefined ? ((call.change ?? 0) >= 0 ? "+" : "") + ((call.change ?? 0).toFixed(2)) : '--'}</td>
      <td style={{ ...cellStyle(isITMCall), fontWeight: 600 }}>{call?.last?.toFixed(2) || '--'}</td>
      <td style={{ ...cellStyle(isITMCall) }}>{call?.ask?.toFixed(2) || '--'}</td>
      <td style={{ ...cellStyle(isITMCall) }}>{call?.bid?.toFixed(2) || '--'}</td>

      {/* STRIKE */}
      <td style={{
        fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)', padding: '4px 10px',
        textAlign: 'center', fontWeight: 700, color: isATM ? '#4fc3f7' : '#e0e0e0',
        background: isATM ? '#4fc3f718' : '#0d1117', borderLeft: '2px solid #1a3a4a', borderRight: '2px solid #1a3a4a',
      }}>{strike}</td>

      {/* PUT SIDE */}
      <td style={{ ...cellStyle(isITMPut) }}>{put?.bid?.toFixed(2) || '--'}</td>
      <td style={{ ...cellStyle(isITMPut) }}>{put?.ask?.toFixed(2) || '--'}</td>
      <td style={{ ...cellStyle(isITMPut), fontWeight: 600 }}>{put?.last?.toFixed(2) || '--'}</td>
      <td style={{ ...cellStyle(isITMPut), color: (put?.change || 0) >= 0 ? '#66bb6a' : '#ef5350' }}>{put?.change !== undefined ? ((put.change ?? 0) >= 0 ? "+" : "") + ((put.change ?? 0).toFixed(2)) : '--'}</td>
      <td style={{ ...cellStyle(isITMPut), color: volColor(put?.volume || 0) }}>{put?.volume?.toLocaleString() || '--'}</td>
      <td style={{ ...cellStyle(isITMPut), color: volColor(put?.open_interest || 0) }}>{put?.open_interest?.toLocaleString() || '--'}</td>
      <td style={{ ...cellStyle(isITMPut), color: ivColor(put?.greeks?.mid_iv || 0) }}>{put?.greeks?.mid_iv ? ((put?.greeks?.mid_iv ?? 0) * 100).toFixed(1) + '%' : '--'}</td>
      <td style={{ ...cellStyle(isITMPut), color: deltaColor(put?.greeks?.delta || 0) }}>{put?.greeks?.delta?.toFixed(4) || '--'}</td>
    </tr>
  );
}

// ── FLOW ROW ──
function FlowRow({ f }: { f: FlowEntry }) {
  const sentiment = getSentiment(f);
  const sc = sentiment === 'BULLISH' ? '#66bb6a' : '#ef5350';
  const unusual = f.Volume > f.OI && f.OI >= 0;
  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '5px 8px', borderBottom: '1px solid #0d1117', borderLeft: unusual ? '3px solid #ffd600' : '3px solid transparent', fontSize: 'var(--mc-font-label)' }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '5px' }}>
        <span style={{ width: '6px', height: '6px', borderRadius: '50%', background: sc, display: 'inline-block' }} />
        <span style={{ color: '#455a64', fontFamily: 'var(--font-mc-mono)', width: '24px' }}>{timeAgo(f.Time)}</span>
        <span style={{ color: sc, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{f.Symbol}</span>
        <span style={{ color: sc }}>{f.OptionType?.slice(0,1)} ${f.Strike}</span>
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: '4px' }}>
        <span style={{ color: premiumColor(f.Value), fontWeight: 600, fontFamily: 'var(--font-mc-mono)' }}>{fmtVal(f.Value)}</span>
        {unusual && <span style={{ fontSize: '8px', fontWeight: 700, padding: '0 3px', borderRadius: '2px', background: '#ffd60022', color: '#ffd600', border: '1px solid #ffd60044' }}>U</span>}
        <span style={{ fontSize: '8px', fontWeight: 700, padding: '1px 3px', borderRadius: '3px', background: f.BlockType === 'SWEEP' ? '#ff980022' : '#4fc3f722', color: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7' }}>{f.BlockType === 'SWEEP' ? 'SWP' : 'BLK'}</span>
      </div>
    </div>
  );
}

// ── PAYOFF CHART ──
function PayoffChart({ legs, currentPrice, lotSize }: { legs: { type: string; side: string; strike: number; premium: number }[]; currentPrice: number; lotSize: number }) {
  const range = currentPrice * 0.1;
  const points: { x: number; y: number }[] = [];
  for (let p = currentPrice - range; p <= currentPrice + range; p += range / 50) {
    let pnl = 0;
    for (const leg of legs) {
      const mult = leg.side === 'buy' ? 1 : -1;
      let intrinsic = 0;
      if (leg.type === 'call') intrinsic = Math.max(0, p - leg.strike);
      else intrinsic = Math.max(0, leg.strike - p);
      pnl += (intrinsic - leg.premium) * mult * lotSize;
    }
    points.push({ x: p, y: pnl });
  }
  if (points.length === 0) return null;

  const maxY = Math.max(...points.map(p => p.y));
  const minY = Math.min(...points.map(p => p.y));
  const xMin = points[0].x;
  const xMax = points[points.length - 1].x;
  const rangeY = maxY - minY || 1;

  const w = 600, h = 200, pad = 30;
  const toX = (x: number) => pad + ((x - xMin) / (xMax - xMin)) * (w - 2 * pad);
  const toY = (y: number) => h - pad - ((y - minY) / rangeY) * (h - 2 * pad);

  const pathD = points.map((p, i) => `${i === 0 ? 'M' : 'L'} ${toX(p.x).toFixed(1)} ${toY(p.y).toFixed(1)}`).join(' ');
  const zeroY = toY(0);

  return (
    <svg viewBox={`0 0 ${w} ${h}`} style={{ width: '100%', height: '200px', background: '#0a1929', borderRadius: '6px', border: '1px solid #1a3a4a' }}>
      {/* Zero line */}
      <line x1={pad} y1={zeroY} x2={w - pad} y2={zeroY} stroke="#455a64" strokeWidth="1" strokeDasharray="4,4" />
      {/* Current price line */}
      <line x1={toX(currentPrice)} y1={pad / 2} x2={toX(currentPrice)} y2={h - pad / 2} stroke="#4fc3f7" strokeWidth="1" strokeDasharray="2,2" />
      {/* P&L curve */}
      <path d={pathD} fill="none" stroke="#66bb6a" strokeWidth="2" />
      {/* Fill profit area */}
      {points.filter(p => p.y > 0).length > 0 && (
        <path d={`${pathD} L ${toX(xMax)} ${zeroY} L ${toX(xMin)} ${zeroY} Z`} fill="#66bb6a10" />
      )}
      {/* Labels */}
      <text x={pad} y={h - 5} fill="#607d8b" fontSize="9" fontFamily="var(--font-mc-mono)">${(xMin ?? 0).toFixed(0)}</text>
      <text x={w - pad} y={h - 5} fill="#607d8b" fontSize="9" fontFamily="var(--font-mc-mono)" textAnchor="end">${(xMax ?? 0).toFixed(0)}</text>
      <text x={5} y={toY(maxY)} fill="#66bb6a" fontSize="9" fontFamily="var(--font-mc-mono)">${(maxY ?? 0).toFixed(0)}</text>
      <text x={5} y={toY(minY)} fill="#ef5350" fontSize="9" fontFamily="var(--font-mc-mono)">${(minY ?? 0).toFixed(0)}</text>
      <text x={toX(currentPrice)} y={pad / 2 - 2} fill="#4fc3f7" fontSize="9" fontFamily="var(--font-mc-mono)" textAnchor="middle">NOW</text>
    </svg>
  );
}

// ── MAIN PAGE ──
export function OptionsWatcherPage() {
  const [ticker, setTicker] = useState('SPY');
  const [searchInput, setSearchInput] = useState('SPY');
  const [activeTab, setActiveTab] = useState<TabType>('chain');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  // Chain state
  const [expirations, setExpirations] = useState<string[]>([]);
  const [selectedExp, setSelectedExp] = useState('');
  const [calls, setCalls] = useState<OptionContract[]>([]);
  const [puts, setPuts] = useState<OptionContract[]>([]);
  const [strikes, setStrikes] = useState<number[]>([]);
  const [quote, setQuote] = useState<Quote | null>(null);
  const [maxPain, setMaxPain] = useState(0);
  const [putCallRatio, setPutCallRatio] = useState('N/A');
  const [chainStats, setChainStats] = useState({ totalCallOI: 0, totalPutOI: 0, totalCallVol: 0, totalPutVol: 0 });

  // Filters
  const [typeFilter, setTypeFilter] = useState<FilterType>('both');
  const [moneynessFilter, setMoneynessFilter] = useState<MoneynessType>('both');
  const [strikeCount, setStrikeCount] = useState(20);
  const [sortDir, setSortDir] = useState<'asc' | 'desc'>('asc');

  // Flows
  const [flows, setFlows] = useState<FlowEntry[]>([]);

  // Strategy Builder
  const [stratCategory, setStratCategory] = useState('Bullish');
  const [selectedStrategy, setSelectedStrategy] = useState('Long Call');
  const [stratStrike, setStratStrike] = useState(0);
  const [stratExpIdx, setStratExpIdx] = useState(0);
  const [lotSize, setLotSize] = useState(100);

  // Load expirations on ticker change
  useEffect(() => {
    async function loadExpirations() {
      setLoading(true); setError('');
      try {
        const res = await fetch(`/api/options-chain?symbol=${ticker}`);
        const data = await res.json();
        if (data.error) { setError(data.error); return; }
        setExpirations(data.expirations || []);
        if (data.quote) setQuote(data.quote);
        if (data.expirations?.length > 0) setSelectedExp(data.expirations[0]);
        if (data.quote?.last) setStratStrike(Math.round(data.quote.last));
      } catch (e: any) { setError(e.message); }
      finally { setLoading(false); }
    }
    loadExpirations();
  }, [ticker]);

  // Load chain on expiration change
  useEffect(() => {
    if (!selectedExp) return;
    async function loadChain() {
      setLoading(true);
      try {
        const res = await fetch(`/api/options-chain?symbol=${ticker}&expiration=${selectedExp}&greeks=true`);
        const data = await res.json();
        if (data.error) { setError(data.error); return; }
        setCalls(data.calls || []);
        setPuts(data.puts || []);
        setStrikes(data.strikes || []);
        setMaxPain(data.maxPain || 0);
        setPutCallRatio(data.putCallRatio || 'N/A');
        setChainStats({ totalCallOI: data.totalCallOI, totalPutOI: data.totalPutOI, totalCallVol: data.totalCallVol, totalPutVol: data.totalPutVol });
        if (data.quote) setQuote(data.quote);
      } catch {}
      finally { setLoading(false); }
    }
    loadChain();
  }, [ticker, selectedExp]);

  // Load flows
  useEffect(() => {
    async function loadFlows() {
      try {
        const res = await fetch('/api/options-flow');
        const data = await res.json();
        const allFlows = (data.flows || []).sort((a: FlowEntry, b: FlowEntry) => b.Time - a.Time);
        // Filter to current ticker if available, else show all
        const tickerFlows = allFlows.filter((f: FlowEntry) => f.Symbol === ticker);
        setFlows(tickerFlows.length > 0 ? tickerFlows : allFlows.slice(0, 30));
      } catch {}
    }
    loadFlows();
    const iv = setInterval(loadFlows, 20000);
    return () => clearInterval(iv);
  }, [ticker]);

  // Filtered strikes for chain display
  const filteredStrikes = useMemo(() => {
    let s = [...strikes];
    const cp = quote?.last || 0;
    if (moneynessFilter === 'itm') s = s.filter(st => (typeFilter === 'put' ? st > cp : st < cp));
    else if (moneynessFilter === 'otm') s = s.filter(st => (typeFilter === 'put' ? st < cp : st > cp));

    // Limit to strikeCount around ATM
    if (strikeCount > 0 && strikeCount < s.length) {
      const atmIdx = s.findIndex(st => st >= cp);
      const half = Math.floor(strikeCount / 2);
      const start = Math.max(0, atmIdx - half);
      s = s.slice(start, start + strikeCount);
    }
    if (sortDir === 'desc') s.reverse();
    return s;
  }, [strikes, quote, moneynessFilter, typeFilter, strikeCount, sortDir]);

  // Strategy payoff calculation
  const strategyPayoff = useMemo(() => {
    const stratDef = STRATEGIES[stratCategory]?.find(s => s.name === selectedStrategy);
    if (!stratDef || !stratStrike) return null;

    const legs = stratDef.legs.map(leg => {
      const strike = stratStrike + leg.strikeOffset;
      const chain = leg.type === 'call' ? calls : puts;
      const contract = chain.find(c => Math.abs(c.strike - strike) < 0.5);
      const premium = contract ? (contract.bid + contract.ask) / 2 : 0;
      return { type: leg.type, side: leg.side, strike, premium };
    });

    // Calculate max profit, max loss, breakeven
    let maxProfit = -Infinity, maxLoss = Infinity;
    const breakevens: number[] = [];
    const range = stratStrike * 0.15;

    for (let p = stratStrike - range; p <= stratStrike + range; p += 0.5) {
      let pnl = 0;
      for (const leg of legs) {
        const mult = leg.side === 'buy' ? 1 : -1;
        const intrinsic = leg.type === 'call' ? Math.max(0, p - leg.strike) : Math.max(0, leg.strike - p);
        pnl += (intrinsic - leg.premium) * mult * lotSize;
      }
      maxProfit = Math.max(maxProfit, pnl);
      maxLoss = Math.min(maxLoss, pnl);
    }

    // Find breakevens (where P&L crosses zero)
    let prevPnl = 0;
    for (let p = stratStrike - range; p <= stratStrike + range; p += 0.1) {
      let pnl = 0;
      for (const leg of legs) {
        const mult = leg.side === 'buy' ? 1 : -1;
        const intrinsic = leg.type === 'call' ? Math.max(0, p - leg.strike) : Math.max(0, leg.strike - p);
        pnl += (intrinsic - leg.premium) * mult * lotSize;
      }
      if (prevPnl !== 0 && ((prevPnl > 0 && pnl <= 0) || (prevPnl < 0 && pnl >= 0))) {
        breakevens.push(Math.round(p * 100) / 100);
      }
      prevPnl = pnl;
    }

    // Aggregate Greeks
    let totalDelta = 0, totalGamma = 0, totalTheta = 0, totalVega = 0, totalRho = 0;
    for (const leg of legs) {
      const chain = leg.type === 'call' ? calls : puts;
      const contract = chain.find(c => Math.abs(c.strike - leg.strike) < 0.5);
      if (contract?.greeks) {
        const mult = leg.side === 'buy' ? 1 : -1;
        totalDelta += (contract.greeks.delta || 0) * mult;
        totalGamma += (contract.greeks.gamma || 0) * mult;
        totalTheta += (contract.greeks.theta || 0) * mult;
        totalVega += (contract.greeks.vega || 0) * mult;
        totalRho += (contract.greeks.rho || 0) * mult;
      }
    }

    return { legs, maxProfit, maxLoss, breakevens, delta: totalDelta, gamma: totalGamma, theta: totalTheta, vega: totalVega, rho: totalRho };
  }, [stratCategory, selectedStrategy, stratStrike, calls, puts, lotSize]);

  // IV data for volatility chart
  const ivData = useMemo(() => {
    return filteredStrikes.map(strike => {
      const call = calls.find(c => c.strike === strike);
      const put = puts.find(p => p.strike === strike);
      return {
        strike,
        callIV: call?.greeks?.mid_iv ? (call?.greeks?.mid_iv ?? 0) * 100 : null,
        putIV: put?.greeks?.mid_iv ? (put?.greeks?.mid_iv ?? 0) * 100 : null,
      };
    }).filter(d => d.callIV || d.putIV);
  }, [filteredStrikes, calls, puts]);

  const currentPrice = quote?.last || 0;
  const priceChange = quote?.change || 0;
  const pricePct = quote?.change_percentage || 0;

  const btnStyle = (active: boolean): React.CSSProperties => ({
    padding: '4px 10px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', fontWeight: 600,
    border: '1px solid ' + (active ? '#4fc3f7' : '#1a3a4a'), borderRadius: '4px', cursor: 'pointer',
    background: active ? '#4fc3f718' : 'transparent', color: active ? '#4fc3f7' : '#607d8b',
  });

  const tabStyle = (active: boolean): React.CSSProperties => ({
    padding: '8px 16px', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)', fontWeight: 700,
    border: 'none', borderBottom: active ? '2px solid #4fc3f7' : '2px solid transparent', cursor: 'pointer',
    background: 'transparent', color: active ? '#4fc3f7' : '#607d8b', letterSpacing: '0.5px',
  });

  const headerCol = (label: string): React.CSSProperties => ({
    fontSize: '9px', fontWeight: 700, color: '#607d8b', fontFamily: 'var(--font-mc-mono)',
    letterSpacing: '0.5px', padding: '6px 6px', textAlign: 'right', whiteSpace: 'nowrap',
  });

  // Days to expiry calculation
  const getDTE = (exp: string) => {
    const d = new Date(exp + 'T16:00:00');
    const now = new Date();
    return Math.max(0, Math.ceil((d.getTime() - now.getTime()) / 86400000));
  };

  return (
    <div style={{ display: 'flex', height: '100%', overflow: 'hidden', fontFamily: 'var(--font-mc-sans)' }}>
      {/* LEFT: FLOW MONITOR */}
      <div style={{ width: '320px', flexShrink: 0, background: '#0a1929', borderRight: '1px solid #1a3a4a', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
        {/* Price header */}
        <div style={{ padding: '14px', borderBottom: '1px solid #1a3a4a', background: '#0d1117' }}>
          <div style={{ display: 'flex', gap: '6px', marginBottom: '10px' }}>
            <input value={searchInput} onChange={e => setSearchInput(e.target.value.toUpperCase())}
              onKeyDown={e => { if (e.key === 'Enter') setTicker(searchInput); }}
              placeholder="Ticker..." style={{ flex: 1, padding: '6px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)', outline: 'none' }} />
            <button onClick={() => setTicker(searchInput)} style={{ padding: '6px 12px', background: '#4fc3f718', border: '1px solid #4fc3f7', borderRadius: '4px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-xs)', cursor: 'pointer', fontWeight: 700 }}>GO</button>
          </div>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline' }}>
            <span style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 800, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{ticker}</span>
            <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>{currentPrice ? fmtPrice(currentPrice) : '--'}</span>
          </div>
          <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '4px' }}>
            <span style={{ fontSize: 'var(--mc-font-label)', color: pricePct >= 0 ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{fmtPct(pricePct)}</span>
            <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Max Pain: <span style={{ color: '#ff9800', fontWeight: 700 }}>${maxPain}</span></span>
          </div>
          {/* Stats row */}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '6px', marginTop: '8px' }}>
            <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', padding: '4px 8px', textAlign: 'center' }}>
              <div style={{ fontSize: '8px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>P/C RATIO</div>
              <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: parseFloat(putCallRatio) > 1 ? '#ef5350' : '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>{putCallRatio}</div>
            </div>
            <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', padding: '4px 8px', textAlign: 'center' }}>
              <div style={{ fontSize: '8px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>CONTRACTS</div>
              <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{calls.length + puts.length}</div>
            </div>
          </div>
        </div>

        {/* Flows Monitor */}
        <div style={{ padding: '8px', borderBottom: '1px solid #1a3a4a', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, color: '#ffd600', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px' }}>FLOWS MONITOR</span>
          <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{flows.length}</span>
        </div>
        <div style={{ flex: 1, overflow: 'auto' }}>
          {flows.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} />)}
          {flows.length === 0 && <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>No flow data for {ticker}</div>}
        </div>
      </div>

      {/* RIGHT: MAIN CONTENT */}
      <div style={{ flex: 1, display: 'flex', flexDirection: 'column', overflow: 'hidden', minWidth: 0 }}>
        {/* Tab bar */}
        <div style={{ display: 'flex', borderBottom: '1px solid #1a3a4a', background: '#0d1117', padding: '0 16px' }}>
          <button style={tabStyle(activeTab === 'chain')} onClick={() => setActiveTab('chain')}>Option Chain</button>
          <button style={tabStyle(activeTab === 'volatility')} onClick={() => setActiveTab('volatility')}>Volatility</button>
          <button style={tabStyle(activeTab === 'strategy')} onClick={() => setActiveTab('strategy')}>Strategy Builder</button>
        </div>

        {/* Tab content */}
        <div style={{ flex: 1, overflow: 'auto', padding: '12px 16px' }}>

          {error && <div style={{ padding: '16px', background: '#ef535015', border: '1px solid #ef5350', borderRadius: '6px', color: '#ef5350', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)', marginBottom: '12px' }}>{error}</div>}

          {/* ═══ OPTION CHAIN TAB ═══ */}
          {activeTab === 'chain' && (
            <>
              {/* Filters */}
              <div style={{ display: 'flex', gap: '8px', marginBottom: '10px', flexWrap: 'wrap', alignItems: 'center' }}>
                <div style={{ display: 'flex', gap: '2px' }}>
                  {(['both', 'call', 'put'] as FilterType[]).map(f => (
                    <button key={f} style={btnStyle(typeFilter === f)} onClick={() => setTypeFilter(f)}>{f === 'both' ? 'Both' : f === 'call' ? 'Call' : 'Put'}</button>
                  ))}
                </div>
                <div style={{ display: 'flex', gap: '2px' }}>
                  {(['both', 'itm', 'otm'] as MoneynessType[]).map(m => (
                    <button key={m} style={btnStyle(moneynessFilter === m)} onClick={() => setMoneynessFilter(m)}>{m.toUpperCase()}</button>
                  ))}
                </div>
                <div style={{ display: 'flex', gap: '2px' }}>
                  {[10, 20, 40].map(n => (
                    <button key={n} style={btnStyle(strikeCount === n)} onClick={() => setStrikeCount(n)}>{n}</button>
                  ))}
                  <button style={btnStyle(strikeCount === 999)} onClick={() => setStrikeCount(999)}>All</button>
                </div>
                <button style={btnStyle(false)} onClick={() => setSortDir(sortDir === 'asc' ? 'desc' : 'asc')}>{sortDir === 'asc' ? 'Asc ↑' : 'Desc ↓'}</button>
              </div>

              {/* Expiration selector */}
              <div style={{ display: 'flex', gap: '4px', marginBottom: '12px', flexWrap: 'wrap' }}>
                {expirations.slice(0, 20).map(exp => {
                  const dte = getDTE(exp);
                  const active = exp === selectedExp;
                  return (
                    <button key={exp} onClick={() => setSelectedExp(exp)} style={{
                      padding: '3px 8px', fontSize: '10px', fontFamily: 'var(--font-mc-mono)',
                      border: active ? '1px solid #4fc3f7' : '1px solid #1a3a4a', borderRadius: '4px', cursor: 'pointer',
                      background: active ? '#4fc3f718' : 'transparent', color: active ? '#4fc3f7' : '#90a4ae',
                    }}>
                      {new Date(exp + 'T00:00:00').toLocaleDateString('en-US', { month: 'short', day: 'numeric' })}
                      <span style={{ color: '#455a64', marginLeft: '3px' }}>({dte}d)</span>
                    </button>
                  );
                })}
                {expirations.length > 20 && <span style={{ fontSize: '10px', color: '#455a64', padding: '3px', fontFamily: 'var(--font-mc-mono)' }}>+{expirations.length - 20} more</span>}
              </div>

              {/* Chain table */}
              {loading ? (
                <div style={{ padding: '40px', textAlign: 'center', color: '#4fc3f7', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)' }}>Loading chain...</div>
              ) : filteredStrikes.length === 0 ? (
                <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)' }}>{expirations.length === 0 ? 'Enter a ticker and press GO to load options chain' : 'No data for selected expiration'}</div>
              ) : (
                <div style={{ overflow: 'auto', border: '1px solid #1a3a4a', borderRadius: '6px' }}>
                  <table style={{ width: '100%', borderCollapse: 'collapse', minWidth: '900px' }}>
                    <thead>
                      <tr style={{ background: '#0d1117', position: 'sticky', top: 0, zIndex: 1 }}>
                        <th colSpan={8} style={{ padding: '6px', fontSize: '11px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', borderBottom: '1px solid #1a3a4a', borderRight: '2px solid #1a3a4a' }}>CALLS</th>
                        <th style={{ padding: '6px', fontSize: '11px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', borderBottom: '1px solid #1a3a4a', borderLeft: '2px solid #1a3a4a', borderRight: '2px solid #1a3a4a' }}>STRIKE</th>
                        <th colSpan={8} style={{ padding: '6px', fontSize: '11px', fontWeight: 700, color: '#ef5350', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', borderBottom: '1px solid #1a3a4a', borderLeft: '2px solid #1a3a4a' }}>PUTS</th>
                      </tr>
                      <tr style={{ background: '#0d1117' }}>
                        {['Delta', 'IV', 'OI', 'Vol', 'Chg', 'Last', 'Ask', 'Bid'].map(h => (
                          <th key={'c' + h} style={headerCol(h) as any}>{h}</th>
                        ))}
                        <th style={{ ...headerCol('Strike') as any, textAlign: 'center', borderLeft: '2px solid #1a3a4a', borderRight: '2px solid #1a3a4a' }}>Strike</th>
                        {['Bid', 'Ask', 'Last', 'Chg', 'Vol', 'OI', 'IV', 'Delta'].map(h => (
                          <th key={'p' + h} style={headerCol(h) as any}>{h}</th>
                        ))}
                      </tr>
                    </thead>
                    <tbody>
                      {filteredStrikes.map(strike => {
                        const call = typeFilter !== 'put' ? calls.find(c => c.strike === strike) : undefined;
                        const put = typeFilter !== 'call' ? puts.find(p => p.strike === strike) : undefined;
                        return <ChainRow key={strike} call={call} put={put} strike={strike} currentPrice={currentPrice} />;
                      })}
                    </tbody>
                  </table>
                </div>
              )}

              {/* Chain stats footer */}
              {filteredStrikes.length > 0 && (
                <div style={{ display: 'flex', gap: '16px', marginTop: '10px', padding: '8px 12px', background: '#0d1117', borderRadius: '6px', border: '1px solid #1a3a4a', flexWrap: 'wrap' }}>
                  {[
                    { l: 'Call OI', v: chainStats.totalCallOI.toLocaleString(), c: '#66bb6a' },
                    { l: 'Put OI', v: chainStats.totalPutOI.toLocaleString(), c: '#ef5350' },
                    { l: 'Call Vol', v: chainStats.totalCallVol.toLocaleString(), c: '#66bb6a' },
                    { l: 'Put Vol', v: chainStats.totalPutVol.toLocaleString(), c: '#ef5350' },
                    { l: 'P/C Ratio', v: putCallRatio, c: parseFloat(putCallRatio) > 1 ? '#ef5350' : '#66bb6a' },
                    { l: 'Max Pain', v: '$' + maxPain, c: '#ff9800' },
                  ].map((s, i) => (
                    <span key={i} style={{ fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
                      {s.l}: <span style={{ color: s.c, fontWeight: 700 }}>{s.v}</span>
                    </span>
                  ))}
                </div>
              )}
            </>
          )}

          {/* ═══ VOLATILITY TAB ═══ */}
          {activeTab === 'volatility' && (
            <>
              <div style={{ marginBottom: '12px' }}>
                <h3 style={{ fontSize: 'var(--mc-font-md)', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>Volatility Curves — IV Skew</h3>
                <p style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Implied volatility across strikes for {selectedExp || 'selected expiration'}</p>
              </div>

              {ivData.length > 0 ? (
                <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', padding: '16px', marginBottom: '16px' }}>
                  <svg viewBox="0 0 700 250" style={{ width: '100%', height: '250px' }}>
                    {/* Grid lines */}
                    {[0, 25, 50, 75, 100].map(pct => {
                      const y = 230 - (pct / 100) * 200;
                      return <g key={pct}>
                        <line x1={50} y1={y} x2={680} y2={y} stroke="#1a3a4a" strokeWidth="1" />
                        <text x={45} y={y + 3} fill="#607d8b" fontSize="9" fontFamily="var(--font-mc-mono)" textAnchor="end">{pct}%</text>
                      </g>;
                    })}
                    {/* Current price line */}
                    {(() => {
                      const xMin = ivData[0]?.strike || 0;
                      const xMax = ivData[ivData.length - 1]?.strike || 1;
                      const cpX = 50 + ((currentPrice - xMin) / (xMax - xMin)) * 630;
                      return <line x1={cpX} y1={20} x2={cpX} y2={235} stroke="#4fc3f7" strokeWidth="1" strokeDasharray="3,3" />;
                    })()}
                    {/* Call IV line */}
                    <path d={ivData.filter(d => d.callIV).map((d, i) => {
                      const x = 50 + (i / (ivData.length - 1)) * 630;
                      const y = 230 - ((d.callIV || 0) / 100) * 200;
                      return `${i === 0 ? 'M' : 'L'} ${x} ${y}`;
                    }).join(' ')} fill="none" stroke="#66bb6a" strokeWidth="2" />
                    {/* Put IV line */}
                    <path d={ivData.filter(d => d.putIV).map((d, i) => {
                      const x = 50 + (i / (ivData.length - 1)) * 630;
                      const y = 230 - ((d.putIV || 0) / 100) * 200;
                      return `${i === 0 ? 'M' : 'L'} ${x} ${y}`;
                    }).join(' ')} fill="none" stroke="#ef5350" strokeWidth="2" />
                    {/* Strike labels */}
                    {ivData.filter((_, i) => i % Math.ceil(ivData.length / 10) === 0).map((d, i) => {
                      const x = 50 + (ivData.indexOf(d) / (ivData.length - 1)) * 630;
                      return <text key={i} x={x} y={248} fill="#607d8b" fontSize="8" fontFamily="var(--font-mc-mono)" textAnchor="middle">{d.strike}</text>;
                    })}
                    {/* Legend */}
                    <rect x={55} y={8} width={10} height={3} fill="#66bb6a" />
                    <text x={68} y={12} fill="#66bb6a" fontSize="9" fontFamily="var(--font-mc-mono)">Call IV</text>
                    <rect x={115} y={8} width={10} height={3} fill="#ef5350" />
                    <text x={128} y={12} fill="#ef5350" fontSize="9" fontFamily="var(--font-mc-mono)">Put IV</text>
                  </svg>
                </div>
              ) : (
                <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)' }}>Load an options chain to see volatility data</div>
              )}

              {/* ATM IV Term Structure */}
              <div style={{ marginBottom: '12px' }}>
                <h3 style={{ fontSize: 'var(--mc-font-md)', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', marginBottom: '6px' }}>ATM IV Term Structure</h3>
                <p style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>ATM implied volatility across expiration dates</p>
              </div>
              <div style={{ padding: '30px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', background: '#0a1929', borderRadius: '8px', border: '1px solid #1a3a4a' }}>
                Term structure chart loads when multiple expirations are fetched. Select different expiration dates to build the curve.
              </div>
            </>
          )}

          {/* ═══ STRATEGY BUILDER TAB ═══ */}
          {activeTab === 'strategy' && (
            <>
              {/* Category buttons */}
              <div style={{ display: 'flex', gap: '8px', marginBottom: '12px' }}>
                {Object.keys(STRATEGIES).map(cat => (
                  <button key={cat} onClick={() => { setStratCategory(cat); setSelectedStrategy(STRATEGIES[cat][0].name); }}
                    style={{ padding: '6px 14px', fontSize: 'var(--mc-font-xs)', fontFamily: 'var(--font-mc-mono)', fontWeight: 700,
                      border: stratCategory === cat ? '1px solid #4fc3f7' : '1px solid #1a3a4a', borderRadius: '6px', cursor: 'pointer',
                      background: stratCategory === cat ? '#4fc3f718' : 'transparent',
                      color: stratCategory === cat ? '#4fc3f7' : '#607d8b',
                      textDecoration: stratCategory === cat ? 'underline' : 'none', textUnderlineOffset: '4px',
                    }}>{cat}</button>
                ))}
              </div>

              {/* Strategy selector */}
              <div style={{ display: 'flex', gap: '6px', marginBottom: '16px', flexWrap: 'wrap' }}>
                {STRATEGIES[stratCategory]?.map(s => (
                  <button key={s.name} onClick={() => setSelectedStrategy(s.name)}
                    style={{ padding: '5px 10px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)',
                      border: selectedStrategy === s.name ? '1px solid #ff9800' : '1px solid #1a3a4a', borderRadius: '4px', cursor: 'pointer',
                      background: selectedStrategy === s.name ? '#ff980018' : 'transparent',
                      color: selectedStrategy === s.name ? '#ff9800' : '#90a4ae',
                    }}>{s.name}</button>
                ))}
              </div>

              {/* Inputs */}
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '10px', marginBottom: '16px' }}>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>Strike Price</div>
                  <input type="number" value={stratStrike} onChange={e => setStratStrike(Number(e.target.value))}
                    style={{ width: '100%', padding: '6px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)' }} />
                </div>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>Lot Size</div>
                  <input type="number" value={lotSize} onChange={e => setLotSize(Number(e.target.value))}
                    style={{ width: '100%', padding: '6px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)' }} />
                </div>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>Expiration</div>
                  <select value={selectedExp} onChange={e => setSelectedExp(e.target.value)}
                    style={{ width: '100%', padding: '6px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)' }}>
                    {expirations.map(exp => <option key={exp} value={exp}>{exp} ({getDTE(exp)}d)</option>)}
                  </select>
                </div>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>Underlying</div>
                  <div style={{ padding: '6px 10px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#4fc3f7', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-sm)' }}>${(currentPrice ?? 0).toFixed(2)}</div>
                </div>
              </div>

              {/* Payoff diagram */}
              {strategyPayoff && strategyPayoff.legs.length > 0 && (
                <>
                  <PayoffChart legs={strategyPayoff.legs} currentPrice={currentPrice} lotSize={lotSize} />

                  {/* Results grid */}
                  <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '8px', marginTop: '12px' }}>
                    {[
                      { l: 'Max Profit', v: strategyPayoff.maxProfit === Infinity ? 'Unlimited' : `$${(strategyPayoff.maxProfit ?? 0).toFixed(0)}`, c: '#66bb6a' },
                      { l: 'Max Loss', v: strategyPayoff.maxLoss === -Infinity ? 'Unlimited' : `$${(strategyPayoff.maxLoss ?? 0).toFixed(0)}`, c: '#ef5350' },
                      { l: 'Breakeven', v: strategyPayoff.breakevens.length > 0 ? strategyPayoff.breakevens.map(b => '$' + (b ?? 0).toFixed(2)).join(', ') : '--', c: '#e0e0e0' },
                      { l: 'Lot Size', v: String(lotSize), c: '#4fc3f7' },
                      { l: 'Strategy', v: selectedStrategy, c: '#ff9800' },
                    ].map((s, i) => (
                      <div key={i} style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', padding: '8px', textAlign: 'center' }}>
                        <div style={{ fontSize: '8px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px', marginBottom: '4px' }}>{s.l}</div>
                        <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: s.c, fontFamily: 'var(--font-mc-mono)' }}>{s.v}</div>
                      </div>
                    ))}
                  </div>

                  {/* Greeks */}
                  <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '8px', marginTop: '8px' }}>
                    {[
                      { l: 'Delta', v: (strategyPayoff.delta ?? 0).toFixed(4) },
                      { l: 'Gamma', v: (strategyPayoff.gamma ?? 0).toFixed(4) },
                      { l: 'Theta', v: (strategyPayoff.theta ?? 0).toFixed(4) },
                      { l: 'Vega', v: (strategyPayoff.vega ?? 0).toFixed(4) },
                      { l: 'Rho', v: (strategyPayoff.rho ?? 0).toFixed(4) },
                    ].map((g, i) => (
                      <div key={i} style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', padding: '8px', textAlign: 'center' }}>
                        <div style={{ fontSize: '8px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px', marginBottom: '4px' }}>{g.l}</div>
                        <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: '#ce93d8', fontFamily: 'var(--font-mc-mono)' }}>{g.v}</div>
                      </div>
                    ))}
                  </div>
                </>
              )}
              {(!strategyPayoff || strategyPayoff.legs.length === 0) && (
                <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-sm)', fontFamily: 'var(--font-mc-mono)' }}>Load an options chain to calculate strategy payoff</div>
              )}
            </>
          )}
        </div>
      </div>
    </div>
  );
}
