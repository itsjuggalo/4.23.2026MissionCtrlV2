'use client';
import { useEffect, useRef, useState, useCallback } from 'react';

interface Position {
  id: string;
  symbol: string;
  side: string;
  entry_price: number;
  current_price: number | null;
  size_usd: number;
  strategy: string;
  source: string;
  asset_type?: string;
  target_price?: number | null;
  stop_loss?: number | null;
  unrealized_pnl: number;
  unrealized_pnl_pct: number;
  opened_at: string;
}

interface SupertrendParams {
  atr_period: number;
  multiplier: number;
  stats?: {
    win_rate?: number;
    profit_factor?: number;
    combined_score?: number;
    alignment?: number;
  };
  optimized_at?: string;
}

interface Signal {
  timestamp: string;
  ticker?: string;
  symbol?: string;
  action?: string;
  side?: string;
  price?: number;
  source?: string;
  strategy?: string;
}

interface Regime {
  regime?: string;
  confidence?: number;
  updated?: string;
}

interface ChartSignalsData {
  regime: Regime;
  signals: Signal[];
  optimal_params: Record<string, unknown>;
  latest_state: Record<string, unknown>;
  updated_at: string;
}

function toTVSymbol(raw: string): string {
  const base = raw.split('/')[0].toUpperCase();
  const map: Record<string, string> = {
    'BTC':'BINANCE:BTCUSDT','ETH':'BINANCE:ETHUSDT','SOL':'BINANCE:SOLUSDT',
    'BNB':'BINANCE:BNBUSDT','XRP':'BINANCE:XRPUSDT','ADA':'BINANCE:ADAUSDT',
    'DOGE':'BINANCE:DOGEUSDT','AVAX':'BINANCE:AVAXUSDT','DOT':'BINANCE:DOTUSDT',
    'MATIC':'BINANCE:MATICUSDT','LINK':'BINANCE:LINKUSDT','UNI':'BINANCE:UNIUSDT',
    'LTC':'BINANCE:LTCUSDT','ATOM':'BINANCE:ATOMUSDT','ARB':'BINANCE:ARBUSDT',
    'OP':'BINANCE:OPUSDT','SUI':'BINANCE:SUIUSDT','APT':'BINANCE:APTUSDT',
    'INJ':'BINANCE:INJUSDT','SEI':'BINANCE:SEIUSDT','FIL':'BINANCE:FILUSDT',
    'NEAR':'BINANCE:NEARUSDT','FTM':'BINANCE:FTMUSDT','HBAR':'BINANCE:HBARUSDT',
    'AMZN':'NASDAQ:AMZN','MSFT':'NASDAQ:MSFT','PLTR':'NYSE:PLTR',
    'INTC':'NASDAQ:INTC','OKTA':'NASDAQ:OKTA','NVDL':'NASDAQ:NVDL',
    'TQQQ':'NASDAQ:TQQQ','FCX':'NYSE:FCX','TLT':'NASDAQ:TLT',
    'AG':'NYSE:AG','FIG':'NYSE:FIG','EL':'NYSE:EL',
  };
  return map[base] || `BINANCE:${base}USDT`;
}

const SOURCE_COLORS: Record<string, string> = {
  ai_crypto:'#4fc3f7', firebase:'#ff9800', telegram:'#0088cc',
  grid:'#66bb6a', dca:'#4fc3f7',
};
function sourceColor(s: string) { return SOURCE_COLORS[s] || '#6b7280'; }

const REGIME_COLORS: Record<string, string> = {
  BULL: '#66bb6a', BEAR: '#ef5350', CHOP: '#ff9800',
};

const INTERVALS = [
  { label:'1m', value:'1' }, { label:'5m', value:'5' },
  { label:'15m', value:'15' }, { label:'1h', value:'60' },
  { label:'4h', value:'240' }, { label:'1D', value:'D' },
];

export function ChartPage() {
  const containerRef              = useRef<HTMLDivElement>(null);
  const [positions,  setPositions]= useState<Position[]>([]);
  const [selected,   setSelected] = useState<Position | null>(null);
  const [tvSymbol,   setTvSymbol] = useState('BINANCE:BTCUSDT');
  const [interval,   setInterval_]= useState('60');
  const [loading,    setLoading]  = useState(true);
  const [error,      setError]    = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [showSignals,  setShowSignals]  = useState(false);

  // Supertrend params — agent optimized or manually overridden
  const [allParams,  setAllParams]= useState<Record<string, SupertrendParams>>({});
  const [atrPeriod,  setAtrPeriod]= useState(10);
  const [multiplier, setMultiplier]= useState(3.0);
  const [isOverride, setIsOverride]= useState(false);

  // K-Means settings (display only — for reference)
  const [trainLen,   setTrainLen] = useState(100);
  const [highVol,    setHighVol]  = useState(0.75);
  const [medVol,     setMedVol]   = useState(0.5);
  const [lowVol,     setLowVol]   = useState(0.25);

  // Chart signals data
  const [chartSignals, setChartSignals] = useState<ChartSignalsData | null>(null);

  const fetchPositions = useCallback(async () => {
    try {
      const res  = await fetch('/api/trades', { cache: 'no-store' });
      const data = await res.json();
      if (data.success) {
        const open = (data.positions || []).filter((p: Position) => p.current_price && p.current_price > 0);
        setPositions(open);
        setError(false);
        if (!selected && open.length > 0) {
          setSelected(open[0]);
          setTvSymbol(toTVSymbol(open[0].symbol));
        }
      }
      setLoading(false);
    } catch { setLoading(false); setError(true); }
  }, [selected]);

  const fetchParams = useCallback(async () => {
    try {
      const res  = await fetch('/api/supertrend-params', { cache: 'no-store' });
      const data = await res.json();
      if (data.success) setAllParams(data.params || {});
    } catch { /* params optional */ }
  }, []);

  const fetchChartSignals = useCallback(async () => {
    try {
      const res = await fetch('/api/chart-signals', { cache: 'no-store' });
      const data = await res.json();
      setChartSignals(data);
    } catch { /* optional */ }
  }, []);

  useEffect(() => {
    fetchPositions();
    fetchParams();
    fetchChartSignals();
    const t1 = setInterval(fetchPositions, 10000);
    const t2 = setInterval(fetchParams, 60000);
    const t3 = setInterval(fetchChartSignals, 30000);
    return () => { clearInterval(t1); clearInterval(t2); clearInterval(t3); };
  }, [fetchPositions, fetchParams, fetchChartSignals]);

  // When selected position changes, load its optimized params
  useEffect(() => {
    if (!selected || isOverride) return;
    const base   = selected.symbol.split('/')[0].toUpperCase();
    const params = allParams[base];
    if (params) {
      setAtrPeriod(params.atr_period);
      setMultiplier(params.multiplier);
    } else {
      setAtrPeriod(10);
      setMultiplier(3.0);
    }
  }, [selected, allParams, isOverride]);

  // Reload chart when symbol or interval changes
  useEffect(() => {
    if (!containerRef.current) return;
    containerRef.current.innerHTML = '';
    const script     = document.createElement('script');
    script.src       = 'https://s3.tradingview.com/external-embedding/embed-widget-advanced-chart.js';
    script.type      = 'text/javascript';
    script.async     = true;
    script.innerHTML = JSON.stringify({
      autosize: true, symbol: tvSymbol, interval, timezone: 'Etc/UTC',
      theme: 'dark', style: '1', locale: 'en',
      enable_publishing: false, hide_top_toolbar: false,
      save_image: true, calendar: false,
      support_host: 'https://www.tradingview.com',
      backgroundColor: '#0d1117', gridColor: '#1a3a4a',
    });
    containerRef.current.appendChild(script);
  }, [tvSymbol, interval]);

  const selectPosition = (pos: Position) => {
    setSelected(pos);
    setTvSymbol(toTVSymbol(pos.symbol));
    setIsOverride(false);
  };

  const fmt = {
    c:   (v: number | null | undefined) => `$${(v ?? 0).toFixed(2)}`,
    pct: (v: number | null | undefined) => { const n = v??0; return <span className={n>=0?'text-green-400':'text-red-400'}>{n>=0?'+':''}{n.toFixed(2)}%</span>; },
    pnl: (v: number | null | undefined) => { const n = v??0; return <span className={n>=0?'text-green-400':'text-red-400'}>{n>=0?'+':''}${n.toFixed(2)}</span>; },
  };

  const selectedBase   = selected?.symbol.split('/')[0].toUpperCase() || '';
  const agentParams    = allParams[selectedBase];
  const optimizedAt    = agentParams?.optimized_at
    ? new Date(agentParams.optimized_at).toLocaleString('en-US', { month:'short', day:'numeric', hour:'2-digit', minute:'2-digit' })
    : null;

  const regime = chartSignals?.regime;
  const regimeName = (regime?.regime || '').toUpperCase();
  const regimeColor = REGIME_COLORS[regimeName] || '#607d8b';
  const recentSignals = (chartSignals?.signals || []).slice(0, 15);
  const signalsUpdatedAt = chartSignals?.updated_at
    ? new Date(chartSignals.updated_at).toLocaleTimeString()
    : '';

  return (
    <div className="flex h-screen overflow-hidden" style={{ background: '#0d1117', flexDirection: 'column' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px', margin: '12px 12px 0' }}>⚠ API unavailable — data may be stale</div>}
      <div className="flex flex-1 overflow-hidden">

      {/* ── Left: position list ── */}
      <div className="w-60 flex-shrink-0 border-r border-gray-800 flex flex-col overflow-hidden">
        <div className="p-3 border-b border-gray-800">
          <h2 className="text-white font-bold">Live Positions</h2>
          <p className="text-gray-500 text-xs mt-0.5">{positions.length} open · click to chart</p>
        </div>
        <div className="flex-1 overflow-y-auto">
          {loading ? (
            <div className="p-4 text-gray-500 text-sm animate-pulse">Loading...</div>
          ) : positions.length === 0 ? (
            <div className="p-4 text-gray-500 text-sm">No open positions</div>
          ) : positions.map(pos => {
            const isActive = selected?.id === pos.id;
            const src = pos.source || pos.strategy || '';
            return (
              <div key={pos.id} onClick={() => selectPosition(pos)}
                className="px-3 py-2.5 cursor-pointer border-b border-gray-800/50 transition-colors hover:bg-slate-800/40"
                style={{ background: isActive ? '#1a1a2e' : 'transparent',
                         borderLeft: `3px solid ${isActive ? sourceColor(src) : 'transparent'}` }}>
                <div className="flex items-center justify-between mb-0.5">
                  <span className="text-white font-semibold text-sm">{pos.symbol}</span>
                  <span className={`text-xs px-1.5 py-0.5 rounded ${pos.side==='buy'?'bg-green-500/20 text-green-400':'bg-red-500/20 text-red-400'}`}>
                    {pos.side?.toUpperCase()}
                  </span>
                </div>
                <div className="flex justify-between text-xs">
                  <span className="text-gray-400">{fmt.c(pos.entry_price)}</span>
                  {fmt.pct(pos.unrealized_pnl_pct)}
                </div>
                {(pos.stop_loss || pos.target_price) && (
                  <div className="flex gap-2 mt-1 text-xs">
                    {pos.stop_loss    && <span className="text-red-400/70">SL: {fmt.c(pos.stop_loss)}</span>}
                    {pos.target_price && <span className="text-green-400/70">TP: {fmt.c(pos.target_price)}</span>}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      </div>

      {/* ── Main ── */}
      <div className="flex-1 flex flex-col overflow-hidden">

        {/* Toolbar */}
        <div className="flex items-center justify-between px-4 py-2 border-b border-gray-800 flex-shrink-0">
          <div className="flex items-center gap-3">
            <span className="text-white font-bold">{tvSymbol.split(':')[1] || tvSymbol}</span>
            {selected && (
              <span className="text-gray-400 text-xs">
                Entry: <span className="text-white">{fmt.c(selected.entry_price)}</span>
                {selected.stop_loss    && <span className="ml-2 text-red-400">SL: {fmt.c(selected.stop_loss)}</span>}
                {selected.target_price && <span className="ml-2 text-green-400">TP: {fmt.c(selected.target_price)}</span>}
              </span>
            )}
            {/* Regime badge */}
            {regimeName && (
              <span className="text-xs px-2 py-0.5 rounded font-mono"
                style={{ background: `${regimeColor}22`, color: regimeColor, border: `1px solid ${regimeColor}55` }}>
                {regimeName}{regime?.confidence ? ` ${(regime.confidence * 100).toFixed(0)}%` : ''}
              </span>
            )}
          </div>
          <div className="flex items-center gap-2">
            {/* Interval */}
            <div className="flex items-center gap-0.5 bg-gray-900 rounded-lg p-1">
              {INTERVALS.map(iv => (
                <button key={iv.value} onClick={() => setInterval_(iv.value)}
                  className="px-2.5 py-1 rounded text-xs font-medium transition-colors"
                  style={{ background: interval===iv.value ? '#4fc3f7':'transparent',
                           color:      interval===iv.value ? '#fff':'#6b7280' }}>
                  {iv.label}
                </button>
              ))}
            </div>
            {/* Signals toggle */}
            <button onClick={() => setShowSignals(s => !s)}
              className="px-3 py-1.5 rounded-lg text-xs font-medium transition-colors border"
              style={{ background: showSignals ? '#4fc3f722':'transparent',
                       borderColor: showSignals ? '#4fc3f7':'#374151',
                       color: showSignals ? '#4fc3f7':'#9ca3af' }}>
              📡 Signals {recentSignals.length > 0 && `(${recentSignals.length})`}
            </button>
            {/* Settings toggle */}
            <button onClick={() => setShowSettings(s => !s)}
              className="px-3 py-1.5 rounded-lg text-xs font-medium transition-colors border"
              style={{ background: showSettings ? '#4fc3f722':'transparent',
                       borderColor: showSettings ? '#4fc3f7':'#374151',
                       color: showSettings ? '#a78bfa':'#9ca3af' }}>
              ⚙ Supertrend
            </button>
          </div>
        </div>

        {/* Position info bar */}
        {selected && (
          <div className="flex items-center gap-5 px-4 py-1.5 border-b border-gray-800 flex-shrink-0 bg-slate-900/50 text-xs">
            <div><span className="text-gray-500">Size</span><span className="text-white ml-1">{fmt.c(selected.size_usd)}</span></div>
            <div><span className="text-gray-500">Current</span><span className="text-white ml-1">{fmt.c(selected.current_price)}</span></div>
            <div><span className="text-gray-500">P&L</span><span className="ml-1">{fmt.pnl(selected.unrealized_pnl)}</span></div>
            <div><span className="text-gray-500">P&L%</span><span className="ml-1">{fmt.pct(selected.unrealized_pnl_pct)}</span></div>
            <div><span className="text-gray-500">Opened</span>
              <span className="text-white ml-1">{new Date(selected.opened_at).toLocaleDateString('en-US',{month:'short',day:'numeric',hour:'2-digit',minute:'2-digit'})}</span>
            </div>
          </div>
        )}

        {/* Supertrend settings panel */}
        {showSettings && (
          <div className="flex-shrink-0 border-b border-gray-800 bg-slate-900/80 px-4 py-3">
            <div className="flex items-start gap-8 flex-wrap">

              {/* Agent params info */}
              <div className="min-w-48">
                <div className="text-xs text-purple-400 font-semibold uppercase tracking-wide mb-2">
                  🤖 Agent Optimized
                  {agentParams && <span className="ml-2 text-gray-500 normal-case font-normal">for {selectedBase}</span>}
                </div>
                {agentParams ? (
                  <div className="space-y-1 text-xs">
                    <div className="flex gap-4">
                      <span className="text-gray-400">ATR Period: <span className="text-white font-mono">{agentParams.atr_period}</span></span>
                      <span className="text-gray-400">Factor: <span className="text-white font-mono">{agentParams.multiplier}</span></span>
                    </div>
                    {agentParams.stats && (
                      <div className="flex gap-4 text-gray-500">
                        <span>Win rate: <span className="text-green-400">{agentParams.stats.win_rate?.toFixed(0)}%</span></span>
                        <span>PF: <span className="text-blue-400">{agentParams.stats.profit_factor?.toFixed(2)}</span></span>
                        <span>Alignment: <span className="text-amber-400">{agentParams.stats.alignment?.toFixed(0)}%</span></span>
                      </div>
                    )}
                    {optimizedAt && <div className="text-gray-600">Last optimized: {optimizedAt}</div>}
                    {isOverride && (
                      <button onClick={() => setIsOverride(false)}
                        className="mt-1 text-xs text-purple-400 hover:text-purple-300 underline">
                        ← Restore agent values
                      </button>
                    )}
                  </div>
                ) : (
                  <div className="text-xs text-gray-600">
                    Run <span className="font-mono text-gray-400">supertrend_optimizer.py</span> to generate
                  </div>
                )}
              </div>

              <div className="w-px h-12 bg-gray-800 self-center" />

              {/* SUPERTREND SETTINGS */}
              <div>
                <div className="text-xs text-gray-400 font-semibold uppercase tracking-wide mb-2">
                  Supertrend Settings
                  {isOverride && <span className="ml-2 text-amber-400 normal-case font-normal">· manually overridden</span>}
                </div>
                <div className="flex items-center gap-6">
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">ATR Length</span>
                    <input type="number" min={1} max={50} value={atrPeriod}
                      onChange={e => { setAtrPeriod(Number(e.target.value)); setIsOverride(true); }}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">SuperTrend Factor</span>
                    <input type="number" min={0.5} max={10} step={0.5} value={multiplier}
                      onChange={e => { setMultiplier(Number(e.target.value)); setIsOverride(true); }}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                </div>
              </div>

              <div className="w-px h-12 bg-gray-800 self-center" />

              {/* K-MEANS SETTINGS */}
              <div>
                <div className="text-xs text-gray-400 font-semibold uppercase tracking-wide mb-2">K-Means Settings</div>
                <div className="flex items-center gap-4 flex-wrap">
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">Training Data Length</span>
                    <input type="number" min={50} max={500} value={trainLen}
                      onChange={e => setTrainLen(Number(e.target.value))}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">High Vol %ile</span>
                    <input type="number" min={0} max={1} step={0.05} value={highVol}
                      onChange={e => setHighVol(Number(e.target.value))}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">Med Vol %ile</span>
                    <input type="number" min={0} max={1} step={0.05} value={medVol}
                      onChange={e => setMedVol(Number(e.target.value))}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                  <label className="flex flex-col gap-1">
                    <span className="text-xs text-gray-500">Low Vol %ile</span>
                    <input type="number" min={0} max={1} step={0.05} value={lowVol}
                      onChange={e => setLowVol(Number(e.target.value))}
                      className="w-20 px-2 py-1 rounded bg-gray-800 border border-gray-700 text-white text-sm font-mono text-center
                                 focus:outline-none focus:border-purple-500" />
                  </label>
                </div>
              </div>

              {/* Current active params summary */}
              <div className="ml-auto text-right">
                <div className="text-xs text-gray-500 mb-1">Active params</div>
                <div className="font-mono text-sm">
                  <span className="text-purple-400">ATR </span>
                  <span className="text-white font-bold">{atrPeriod}</span>
                  <span className="text-gray-500 mx-2">×</span>
                  <span className="text-purple-400">Factor </span>
                  <span className="text-white font-bold">{multiplier}</span>
                </div>
                <div className="text-xs text-gray-600 mt-0.5">
                  {isOverride ? 'manual override' : agentParams ? 'agent optimized' : 'default'}
                </div>
              </div>

            </div>
          </div>
        )}

        {/* TradingView chart */}
        <div className="flex-1 relative overflow-hidden">
          <div className="tradingview-widget-container h-full w-full">
            <div ref={containerRef} className="h-full w-full" />
          </div>
          {!selected && !loading && (
            <div className="absolute inset-0 flex items-center justify-center pointer-events-none">
              <p className="text-gray-600 text-sm">Select a position from the left panel</p>
            </div>
          )}
        </div>

        {/* ── SIGNALS PANEL (below chart, toggleable) ── */}
        {showSignals && (
          <div className="flex-shrink-0 border-t border-gray-800 bg-slate-900/80" style={{ height: '280px' }}>
            <div className="flex h-full">

              {/* Signals feed */}
              <div className="flex-1 flex flex-col border-r border-gray-800 overflow-hidden">
                <div className="flex items-center justify-between px-4 py-2 border-b border-gray-800">
                  <span className="text-xs font-semibold text-cyan-400 uppercase tracking-wide">Recent Signals</span>
                  <span className="text-xs text-gray-600 font-mono">
                    {signalsUpdatedAt ? `Updated ${signalsUpdatedAt}` : 'No data'}
                  </span>
                </div>
                <div className="flex-1 overflow-y-auto">
                  {recentSignals.length === 0 ? (
                    <div className="p-4 text-xs text-gray-600">
                      No signals received yet. Waiting for data from <span className="font-mono text-gray-500">signals_history.jsonl</span>
                    </div>
                  ) : (
                    <table className="w-full text-xs">
                      <thead>
                        <tr className="text-gray-500 uppercase text-[10px]">
                          <th className="text-left px-4 py-1.5">Time</th>
                          <th className="text-left px-2 py-1.5">Ticker</th>
                          <th className="text-left px-2 py-1.5">Action</th>
                          <th className="text-right px-2 py-1.5">Price</th>
                          <th className="text-left px-2 py-1.5">Source</th>
                        </tr>
                      </thead>
                      <tbody>
                        {recentSignals.map((s, i) => {
                          const ticker = (s.ticker || s.symbol || '').toUpperCase();
                          const action = (s.action || s.side || '').toUpperCase();
                          const isBuy = action === 'BUY' || action === 'LONG';
                          const src = s.source || s.strategy || '';
                          const time = s.timestamp
                            ? new Date(s.timestamp).toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', second: '2-digit' })
                            : '';
                          return (
                            <tr key={i} className="border-t border-gray-800/40 hover:bg-slate-800/30">
                              <td className="px-4 py-1.5 text-gray-500 font-mono">{time}</td>
                              <td className="px-2 py-1.5 text-white font-semibold">{ticker}</td>
                              <td className="px-2 py-1.5">
                                <span className={`px-1.5 py-0.5 rounded font-semibold ${isBuy ? 'bg-green-500/20 text-green-400' : 'bg-red-500/20 text-red-400'}`}>
                                  {action}
                                </span>
                              </td>
                              <td className="px-2 py-1.5 text-right text-white font-mono">
                                {s.price ? `$${Number(s.price).toFixed(2)}` : '—'}
                              </td>
                              <td className="px-2 py-1.5" style={{ color: sourceColor(src) }}>{src}</td>
                            </tr>
                          );
                        })}
                      </tbody>
                    </table>
                  )}
                </div>
              </div>

              {/* Right: regime + optimal params */}
              <div className="w-80 flex flex-col overflow-y-auto">
                {/* Regime */}
                <div className="p-4 border-b border-gray-800">
                  <div className="text-xs font-semibold text-cyan-400 uppercase tracking-wide mb-2">Market Regime</div>
                  {regimeName ? (
                    <>
                      <div className="flex items-baseline gap-3">
                        <span className="text-2xl font-bold font-mono" style={{ color: regimeColor }}>{regimeName}</span>
                        {regime?.confidence !== undefined && (
                          <span className="text-sm text-gray-400 font-mono">{(regime.confidence * 100).toFixed(1)}% conf</span>
                        )}
                      </div>
                      {regime?.updated && (
                        <div className="text-xs text-gray-600 mt-2 font-mono">
                          Updated: {new Date(regime.updated).toLocaleString()}
                        </div>
                      )}
                    </>
                  ) : (
                    <div className="text-xs text-gray-600">
                      No regime data. Check <span className="font-mono">market_regime.json</span>
                    </div>
                  )}
                </div>

                {/* Optimal params */}
                <div className="p-4 flex-1">
                  <div className="text-xs font-semibold text-cyan-400 uppercase tracking-wide mb-2">Optimal Parameters</div>
                  {chartSignals?.optimal_params && Object.keys(chartSignals.optimal_params).length > 0 ? (
                    <div className="space-y-1 text-xs font-mono">
                      {Object.entries(chartSignals.optimal_params).map(([key, val]) => (
                        <div key={key} className="flex justify-between py-1 border-b border-gray-800/40">
                          <span className="text-gray-400">{key}</span>
                          <span className="text-white">
                            {typeof val === 'object' ? JSON.stringify(val).substring(0, 40) : String(val)}
                          </span>
                        </div>
                      ))}
                    </div>
                  ) : (
                    <div className="text-xs text-gray-600">
                      No optimal params. Check <span className="font-mono">optimal_params.json</span>
                    </div>
                  )}
                </div>
              </div>

            </div>
          </div>
        )}
      </div>
      </div>
    </div>
  );
}
