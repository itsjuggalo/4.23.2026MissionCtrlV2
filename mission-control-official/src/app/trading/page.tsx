'use client';
import { useState, useEffect, useRef } from 'react';
import { ErrorBoundary } from '@/components/shared/ErrorBoundary';
import { TrendingUp, TrendingDown, Minus, RefreshCw, Play, BarChart2, Activity, Zap } from 'lucide-react';

// ─── TradingView Widget ───────────────────────────────────────────────────────
function TradingViewChart({ symbol = 'BTCUSDT', interval = '60' }: { symbol?: string; interval?: string }) {
  const containerRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    if (!containerRef.current) return;
    containerRef.current.innerHTML = '';

    const script = document.createElement('script');
    script.src = 'https://s3.tradingview.com/external-embedding/embed-widget-advanced-chart.js';
    script.type = 'text/javascript';
    script.async = true;
    script.innerHTML = JSON.stringify({
      autosize: true,
      symbol: `BINANCE:${symbol}`,
      interval,
      timezone: 'Etc/UTC',
      theme: 'dark',
      style: '1',
      locale: 'en',
      backgroundColor: 'rgba(10, 10, 18, 1)',
      gridColor: 'rgba(30, 30, 42, 1)',
      hide_top_toolbar: false,
      hide_legend: false,
      allow_symbol_change: true,
      save_image: false,
      studies: [
        'STD;SuperTrend',
        'STD;RSI',
        'STD;MACD',
        'STD;Volume',
      ],
      support_host: 'https://www.tradingview.com',
    });

    containerRef.current.appendChild(script);
  }, [symbol, interval]);

  return <div ref={containerRef} className="w-full h-full" />;
}

// ─── SuperTrend Signal Card ───────────────────────────────────────────────────
function SuperTrendSignal({ signal, optimized, loading }: { signal: any; optimized: any; loading: boolean }) {
  if (loading) {
    return (
      <div className="flex items-center gap-2 text-[#555] text-sm">
        <RefreshCw className="w-4 h-4 animate-spin" />
        Loading signal...
      </div>
    );
  }

  if (!signal || signal.status === 'no_signal' || signal.status === 'pending') {
    return (
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 text-center">
        <p className="text-[#555] text-sm mb-1">Optimizer running...</p>
        <p className="text-[10px] text-[#333]">BTC SuperTrend backtest in progress (~15 min first run)</p>
      </div>
    );
  }

  const dir = signal.signal || signal.direction || 'HOLD';
  const isLong = dir === 'BUY' || dir === 'LONG';
  const isShort = dir === 'SELL' || dir === 'SHORT';
  const dirColor = isLong ? 'text-green-400' : isShort ? 'text-red-400' : 'text-yellow-400';
  const bgColor = isLong ? 'bg-green-500/10 border-green-500/30' : isShort ? 'bg-red-500/10 border-red-500/30' : 'bg-yellow-500/10 border-yellow-500/30';

  const params = optimized || signal.params || {};
  const stats  = optimized?.stats || signal.stats || {};

  return (
    <div className={`rounded-lg border p-4 ${bgColor}`}>
      <div className="flex items-center gap-3 mb-3">
        {isLong ? <TrendingUp className="w-5 h-5 text-green-400" /> :
         isShort ? <TrendingDown className="w-5 h-5 text-red-400" /> :
         <Minus className="w-5 h-5 text-yellow-400" />}
        <div>
          <div className={`text-lg font-bold ${dirColor}`}>{dir}</div>
          <div className="text-[10px] text-[#555]">
            {signal.timestamp ? new Date(signal.timestamp).toLocaleTimeString() : 'Live'}
          </div>
        </div>
        {signal.confidence !== undefined && (
          <div className="ml-auto text-right">
            <div className="text-sm font-bold text-[#f0f0f0]">{Math.round(signal.confidence * 100)}%</div>
            <div className="text-[10px] text-[#555]">confidence</div>
          </div>
        )}
      </div>

      <div className="grid grid-cols-2 gap-2 text-xs mb-3">
        {signal.price && <div><span className="text-[#555]">BTC Price</span><div className="text-[#f0f0f0] font-mono">${Number(signal.price).toLocaleString()}</div></div>}
        {signal.supertrend_level && <div><span className="text-[#555]">ST Level</span><div className={`font-mono ${dirColor}`}>${Number(signal.supertrend_level).toLocaleString()}</div></div>}
        {params.atr_period && <div><span className="text-[#555]">ATR Period</span><div className="text-[#f0f0f0] font-mono">{params.atr_period}</div></div>}
        {params.multiplier && <div><span className="text-[#555]">Multiplier</span><div className="text-[#f0f0f0] font-mono">{params.multiplier}x</div></div>}
        {params.volatility_regime && <div><span className="text-[#555]">Vol Regime</span><div className="text-purple-400 font-mono">{params.volatility_regime}</div></div>}
        {signal.timeframe && <div><span className="text-[#555]">Timeframe</span><div className="text-[#f0f0f0] font-mono">{signal.timeframe}</div></div>}
      </div>

      {signal.filters && (
        <div className="flex flex-wrap gap-1 text-[10px]">
          {Object.entries(signal.filters).map(([k, v]: [string, any]) => (
            <span key={k} className={`px-1.5 py-0.5 rounded ${v ? 'bg-green-500/10 text-green-400' : 'bg-red-500/10 text-red-400'}`}>
              {k}: {v ? '✓' : '✗'}
            </span>
          ))}
        </div>
      )}
    </div>
  );
}

// ─── Backtest Results ─────────────────────────────────────────────────────────
function BacktestResults({ backtest }: { backtest: any }) {
  if (!backtest || backtest.status === 'pending') {
    return (
      <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 text-center">
        <BarChart2 className="w-6 h-6 text-[#333] mx-auto mb-2" />
        <p className="text-xs text-[#555]">Backtest results will appear here after optimization completes</p>
      </div>
    );
  }

  const s = backtest.stats || backtest;
  const trades = backtest.trades || [];

  return (
    <div className="space-y-3">
      <div className="grid grid-cols-2 gap-2">
        {[
          { label: 'Win Rate',      value: `${(s.win_rate || 0).toFixed(1)}%`,     color: (s.win_rate || 0) >= 55 ? 'text-green-400' : 'text-red-400' },
          { label: 'Profit Factor', value: (s.profit_factor || 0).toFixed(2),      color: (s.profit_factor || 0) >= 1.5 ? 'text-green-400' : 'text-red-400' },
          { label: 'Net Return',    value: `${(s.net_return_pct || 0).toFixed(1)}%`, color: (s.net_return_pct || 0) >= 0 ? 'text-green-400' : 'text-red-400' },
          { label: 'Max Drawdown',  value: `${(s.max_drawdown_pct || 0).toFixed(1)}%`, color: (s.max_drawdown_pct || 0) <= 25 ? 'text-yellow-400' : 'text-red-400' },
          { label: 'Sharpe Ratio',  value: (s.sharpe || 0).toFixed(2),             color: (s.sharpe || 0) >= 1 ? 'text-green-400' : 'text-yellow-400' },
          { label: 'Total Trades',  value: s.total_trades || s.trades || 0,        color: 'text-[#f0f0f0]' },
        ].map(m => (
          <div key={m.label} className="bg-[#0a0a12] border border-[#1a1a2a] rounded p-2.5">
            <div className="text-[10px] text-[#555] mb-0.5">{m.label}</div>
            <div className={`text-base font-bold font-mono ${m.color}`}>{m.value}</div>
          </div>
        ))}
      </div>

      {backtest.best_params && (
        <div className="bg-amber-500/10 border border-amber-500/20 rounded p-3 text-xs">
          <div className="text-amber-400 font-semibold mb-1">Best Parameters Found</div>
          <div className="grid grid-cols-3 gap-2 font-mono text-[#f0f0f0]">
            <div><span className="text-[#555]">ATR: </span>{backtest.best_params.atr_period}</div>
            <div><span className="text-[#555]">Mult: </span>{backtest.best_params.multiplier}x</div>
            <div><span className="text-[#555]">TF: </span>{backtest.best_params.timeframe || '1H'}</div>
            {backtest.best_params.source && <div><span className="text-[#555]">Src: </span>{backtest.best_params.source}</div>}
            {backtest.best_params.vol_regime && <div><span className="text-[#555]">Vol: </span>{backtest.best_params.vol_regime}</div>}
          </div>
        </div>
      )}

      {trades.length > 0 && (
        <div>
          <div className="text-[10px] text-[#555] uppercase tracking-wider mb-2">Recent Trades</div>
          <div className="space-y-1 max-h-48 overflow-y-auto">
            {trades.slice(-10).reverse().map((t: any, i: number) => (
              <div key={i} className="flex items-center gap-2 text-xs bg-[#0a0a12] rounded px-2 py-1.5">
                <span className={t.pnl_pct >= 0 ? 'text-green-400' : 'text-red-400'}>
                  {t.pnl_pct >= 0 ? '▲' : '▼'}
                </span>
                <span className="text-[#888]">{t.direction || t.side}</span>
                <span className="text-[#f0f0f0] flex-1">{t.entry_date || t.date || ''}</span>
                <span className={`font-mono font-semibold ${t.pnl_pct >= 0 ? 'text-green-400' : 'text-red-400'}`}>
                  {t.pnl_pct >= 0 ? '+' : ''}{Number(t.pnl_pct || 0).toFixed(2)}%
                </span>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

// ─── Main Page ────────────────────────────────────────────────────────────────
export default function TradingPage() {
  const [symbol, setSymbol] = useState('BTCUSDT');
  const [chartInterval, setChartInterval] = useState('60');
  const [signal, setSignal] = useState<any>(null);
  const [backtest, setBacktest] = useState<any>(null);
  const [optimized, setOptimized] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [activeTab, setActiveTab] = useState<'chart' | 'backtest'>('chart');
  const [optimizing, setOptimizing] = useState(false);

  const fetchData = async () => {
    try {
      const [sigRes, btRes, optRes] = await Promise.all([
        fetch('/api/supertrend?type=signal'),
        fetch('/api/supertrend?type=backtest'),
        fetch('/api/supertrend?type=optimized'),
      ]);
      const [sig, bt, opt] = await Promise.all([sigRes.json(), btRes.json(), optRes.json()]);
      setSignal(sig);
      setBacktest(bt);
      setOptimized(opt);
    } catch {}
    setLoading(false);
  };

  useEffect(() => {
    fetchData();
    const id = window.setInterval(fetchData, 30000);
    return () => window.clearInterval(id);
  }, []);

  const runOptimizer = async () => {
    setOptimizing(true);
    try {
      await fetch('/api/supertrend/run', { method: 'POST' });
    } catch {}
    setTimeout(() => { setOptimizing(false); fetchData(); }, 3000);
  };

  const SYMBOLS = ['BTCUSDT', 'ETHUSDT', 'SOLUSDT', 'BNBUSDT', 'NVDA', 'AAPL', 'SPY', 'QQQ'];
  const INTERVALS = [
    { label: '1m', value: '1' }, { label: '5m', value: '5' }, { label: '15m', value: '15' },
    { label: '1H', value: '60' }, { label: '4H', value: '240' }, { label: '1D', value: 'D' },
  ];

  return (
    <div className="flex flex-col h-full gap-4">
      {/* Header */}
      <div className="flex items-center gap-3 flex-wrap">
        <h1 className="text-lg font-bold text-[#f0f0f0]">TradingView</h1>
        <div className="text-[#555]">·</div>
        <span className="text-xs text-[#555]">SuperTrend AI Strategy</span>

        <div className="flex gap-1 ml-auto flex-wrap">
          {/* Symbol picker */}
          <select
            value={symbol}
            onChange={e => setSymbol(e.target.value)}
            className="bg-[#111] border border-[#1f1f1f] text-xs text-[#f0f0f0] rounded px-2 py-1.5 focus:outline-none"
          >
            {SYMBOLS.map(s => <option key={s} value={s}>{s}</option>)}
          </select>

          {/* Interval picker */}
          <div className="flex gap-0.5">
            {INTERVALS.map(iv => (
              <button key={iv.value} onClick={() => setChartInterval(iv.value)}
                className={`px-2 py-1.5 text-xs rounded transition-colors ${
                  chartInterval === iv.value ? 'bg-amber-500/10 text-amber-400 border border-amber-500/20' : 'text-[#555] hover:text-[#f0f0f0]'
                }`}>
                {iv.label}
              </button>
            ))}
          </div>

          {/* Tab toggle */}
          <div className="flex gap-0.5 border border-[#1f1f1f] rounded overflow-hidden">
            <button onClick={() => setActiveTab('chart')}
              className={`px-3 py-1.5 text-xs transition-colors ${activeTab === 'chart' ? 'bg-[#1f1f1f] text-[#f0f0f0]' : 'text-[#555]'}`}>
              Chart
            </button>
            <button onClick={() => setActiveTab('backtest')}
              className={`px-3 py-1.5 text-xs transition-colors ${activeTab === 'backtest' ? 'bg-[#1f1f1f] text-[#f0f0f0]' : 'text-[#555]'}`}>
              Backtest
            </button>
          </div>
        </div>
      </div>

      <div className="flex gap-4 flex-1 min-h-0">
        {/* Main chart / backtest area */}
        <div className="flex-1 min-h-0">
          {activeTab === 'chart' ? (
            <div className="rounded-lg overflow-hidden border border-[#1f1f1f]" style={{ height: '100%', minHeight: 500 }}>
              <ErrorBoundary name="TradingView Chart">
                <TradingViewChart symbol={symbol} interval={chartInterval} />
              </ErrorBoundary>
            </div>
          ) : (
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 h-full overflow-y-auto">
              <div className="flex items-center gap-2 mb-4">
                <BarChart2 className="w-4 h-4 text-purple-400" />
                <h2 className="text-sm font-semibold text-[#f0f0f0]">BTC SuperTrend Backtest Results</h2>
                <button onClick={fetchData} className="ml-auto text-[#555] hover:text-[#f0f0f0] transition-colors">
                  <RefreshCw className="w-3.5 h-3.5" />
                </button>
              </div>
              <ErrorBoundary name="Backtest">
                <BacktestResults backtest={backtest} />
              </ErrorBoundary>
            </div>
          )}
        </div>

        {/* Right panel — SuperTrend signal + controls */}
        <div className="w-72 flex-shrink-0 space-y-3 overflow-y-auto">
          {/* Live signal */}
          <div className="bg-[#0d0d12] border border-[#1a1a2a] rounded-lg p-3">
            <div className="flex items-center gap-2 mb-3">
              <Activity className="w-4 h-4 text-amber-400" />
              <span className="text-xs font-semibold text-[#f0f0f0]">BTC SuperTrend Signal</span>
              <span className="ml-auto w-2 h-2 rounded-full bg-green-400 animate-pulse" />
            </div>
            <ErrorBoundary name="Signal">
              <SuperTrendSignal signal={signal} optimized={optimized} loading={loading} />
            </ErrorBoundary>
          </div>

          {/* Run optimizer button */}
          <button
            onClick={runOptimizer}
            disabled={optimizing}
            className="w-full flex items-center justify-center gap-2 px-4 py-3 bg-purple-500/10 hover:bg-purple-500/20 border border-purple-500/30 text-purple-400 rounded-lg text-sm font-semibold transition-colors disabled:opacity-50"
          >
            {optimizing ? (
              <><RefreshCw className="w-4 h-4 animate-spin" /> Running...</>
            ) : (
              <><Zap className="w-4 h-4" /> Run BTC Optimizer</>
            )}
          </button>
          <p className="text-[10px] text-[#333] text-center -mt-1">
            Backtests all ATR/multiplier combos · optimizes for win rate & profit factor
          </p>

          {/* Original Pine Script */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-3">
            <div className="text-[10px] text-[#555] uppercase tracking-wider mb-2">Original Pine Script Strategy</div>
            <div className="text-[10px] text-[#888] font-mono leading-relaxed bg-[#060608] rounded p-2 overflow-x-auto">
              {`// SuperTrend by KivancOzbilgic\nATR Period: 10\nMultiplier: 3.0\nSource: hl2\n\nup = hl2-(mult×atr)\nup = prev_close>prev_up ? max(up,prev_up) : up\ndn = hl2+(mult×atr)\ndn = prev_close<prev_dn ? min(dn,prev_dn) : dn\n\nBUY  when trend flips to +1\nSELL when trend flips to -1`}
            </div>
          </div>

          {/* Enhancements */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-3">
            <div className="text-[10px] text-[#555] uppercase tracking-wider mb-2">AI Enhancements Active</div>
            <div className="space-y-1.5 text-[10px]">
              {[
                ['K-Means Vol Clustering', 'Dynamic ATR sizing per regime'],
                ['RSI Filter', 'Block entries at extremes (>70/<30)'],
                ['Volume Confirmation', 'Signal only on above-avg volume'],
                ['MTF Alignment', '1H signal + 4H trend must agree'],
                ['Dynamic Multiplier', 'Higher mult in high-vol regime'],
              ].map(([title, desc]) => (
                <div key={title} className="flex items-start gap-1.5">
                  <span className="text-green-400 mt-0.5">✓</span>
                  <div>
                    <span className="text-[#f0f0f0] font-medium">{title}</span>
                    <span className="text-[#444] ml-1">{desc}</span>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
