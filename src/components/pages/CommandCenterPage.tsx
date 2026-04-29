'use client';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';
import { useEffect, useState, useRef } from 'react';


// Parse OCC option symbol → "TICKER M/D/YY $STRIKEC/P". Returns symbol unchanged if not OCC.
function parseOCC(sym: string): string {
  if (!sym) return '';
  const m = /^([A-Z]+)(\d{2})(\d{2})(\d{2})([CP])(\d{8})$/.exec(sym);
  if (!m) return sym;
  const [, tk, yy, mm, dd, cp, strikeRaw] = m;
  const strike = parseInt(strikeRaw, 10) / 1000;
  const strikeStr = strike % 1 === 0 ? String(strike) : strike.toFixed(2).replace(/\.?0+$/, '');
  return `${tk} ${parseInt(mm,10)}/${parseInt(dd,10)}/${yy} $${strikeStr}${cp}`;
}

export function CommandCenterPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [activity, setActivity] = useState<any[]>([]);
  const [rhPositions, setRhPositions] = useState<any[]>([]);
  const [rhBalance, setRhBalance] = useState(0);
  const [allWallets, setAllWallets] = useState<any[]>([]);
  const [dashData, setDashData] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [unusualFlows, setUnusualFlows] = useState<any[]>([]);
  const [kronosForecast, setKronosForecast] = useState<any>(null);
  const [pipelineFeed, setPipelineFeed] = useState<any[]>([]);
  const [positionsExpanded, setPositionsExpanded] = useState(false);
  const [newsIdx, setNewsIdx] = useState(0);
  const newsTickerRef = useRef<HTMLDivElement>(null);
  const tvContainerRef = useRef<HTMLDivElement>(null);
  const tvLoadedRef = useRef(false);
  const [watchlist, setWatchlist] = useState<string[]>(['AAPL', 'NVDA', 'TSLA', 'MU', 'LLY']);
  const [showAddInput, setShowAddInput] = useState(false);
  const [newSymInput, setNewSymInput] = useState('');
  const [draggedIdx, setDraggedIdx] = useState<number | null>(null);
  const [equityHistory, setEquityHistory] = useState<any[]>([]);
  const [equityIntraday, setEquityIntraday] = useState<any[]>([]);
  const [liveQuotes, setLiveQuotes] = useState<Record<string, any>>({});
  const [kronosSymbol, setKronosSymbol] = useState<string>('BTCUSDT');
  const [showKronosInput, setShowKronosInput] = useState(false);
  const [kronosInput, setKronosInput] = useState('');
  const [kronosHistory, setKronosHistory] = useState<string[]>([]);
  const [kronosLoading, setKronosLoading] = useState(false);
  const [kronosError, setKronosError] = useState<string>('');
  const [showKronosHistory, setShowKronosHistory] = useState(false);
  const [selectedItem, setSelectedItem] = useState<{ type: string; data: any } | null>(null);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchData = async () => {
    try {
      const [pRes, sigRes, rRes, actRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/activity').then(r => r.json()).catch(() => []),
      ]);
      setPortfolio(pRes); setSignals(sigRes); setRegime(rRes);
      const acts = Array.isArray(actRes) ? actRes : (actRes?.activities || actRes?.entries || []);
      setActivity(acts.slice(0, 10));
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
    fetch('/api/pipeline-feed').then(r => r.ok ? r.json() : null).then(d => { if (d?.events) setPipelineFeed(d.events); }).catch(() => {});
    // Options flow refresh (was only in mount, now in 10s loop)
    fetch('/api/options-flow').then(r => r.ok ? r.json() : { flows: [], alerts: [] }).then(d => {
      const flows = d.flows || [];
      const alerts = d.alerts || [];
      const unusual: any = flows.filter((f: any) => f.Volume > f.OI && f.OI >= 0).sort((a: any, b: any) => b.Time - a.Time).slice(0, 10);
      unusual._allAlerts = alerts;
      unusual._allFlows = flows;
      setUnusualFlows(unusual);
    }).catch(() => {});
  };

  useEffect(() => {
    fetchData();
    fetch('/api/options-flow').then(r => r.ok ? r.json() : { flows: [], alerts: [] }).then(d => {
      const flows = d.flows || [];
      const alerts = d.alerts || [];
      const unusual: any = flows.filter((f: any) => f.Volume > f.OI && f.OI >= 0).sort((a: any, b: any) => b.Time - a.Time).slice(0, 10);
      unusual._allAlerts = alerts;
      unusual._allFlows = flows;
      setUnusualFlows(unusual);
    }).catch(() => {});
    fetch('/api/kronos-forecast?symbol=' + encodeURIComponent(kronosSymbol)).then(r => r.ok ? r.json() : null).then(d => { if (d) setKronosForecast(d); }).catch(() => {});
    fetch('/api/options-flow').then(r => r.ok ? r.json() : { flows: [], alerts: [] }).then(d => {
      const flows = d.flows || [];
      const alerts = d.alerts || [];
      const unusual: any = flows.filter((f: any) => f.Volume > f.OI && f.OI >= 0).sort((a: any, b: any) => b.Time - a.Time).slice(0, 10);
      unusual._allAlerts = alerts;
      unusual._allFlows = flows;
      setUnusualFlows(unusual);
    }).catch(() => {});
    fetch('/api/kronos-forecast?symbol=' + encodeURIComponent(kronosSymbol)).then(r => r.ok ? r.json() : null).then(d => { if (d) setKronosForecast(d); }).catch(() => {});
    fetch('/api/wallets').then(r => r.ok ? r.json() : []).then(wallets => {
      const tickers: any[] = []; let rhTotal = 0;
      for (const w of wallets) {
        if ((w.name || '').includes('Robinhood')) {
          rhTotal += w.balance || 0;
          if (w.positions) for (const p of w.positions) {
            if (p.equity > 1) {
              const pct = p.avg_cost > 0 ? ((p.price - p.avg_cost) / p.avg_cost * 100) : 0;
              tickers.push({ sym: p.symbol, val: '$' + (p.price < 1 ? p.price.toFixed(4) : p.price.toFixed(2)), chg: pct, color: pct >= 0 ? '#66bb6a' : '#ef5350' });
            }
          }
        }
      }
      setRhPositions(tickers); setRhBalance(rhTotal);
      // Save all wallet summary for marquee
      setAllWallets((wallets || []).map((w: any) => ({ name: w.name || 'Unknown', balance: w.balance || 0 })));
    }).catch(() => {});
    fetch('/api/directives?file=dashboard_data.json').then(r => r.ok ? r.json() : null).then(d => { if (d) setDashData(d); }).catch(() => {});
    fetch('/api/pipeline-feed').then(r => r.ok ? r.json() : null).then(d => { if (d?.events) setPipelineFeed(d.events); }).catch(() => {});
    const iv = setInterval(fetchData, 10000);
    return () => clearInterval(iv);
  }, []);

  // Arrow-key navigation for Market News ticker (when focused)
  useEffect(() => {
    const onKey = (e: KeyboardEvent) => {
      const ticker = newsTickerRef.current;
      if (!ticker) return;
      const focused = document.activeElement === ticker || ticker.contains(document.activeElement);
      if (!focused) return;
      const newsLen = (dashData?.news?.length || 0);
      if (newsLen === 0) return;
      if (e.key === 'ArrowRight') { e.preventDefault(); setNewsIdx(i => Math.min(i + 1, newsLen - 1)); }
      else if (e.key === 'ArrowLeft') { e.preventDefault(); setNewsIdx(i => Math.max(i - 1, 0)); }
    };
    window.addEventListener('keydown', onKey);
    return () => window.removeEventListener('keydown', onKey);
  }, [dashData]);

  // Load watchlist from localStorage on mount
  useEffect(() => {
    try {
      const saved = localStorage.getItem('cc-watchlist');
      if (saved) {
        const parsed = JSON.parse(saved);
        if (Array.isArray(parsed) && parsed.length > 0) setWatchlist(parsed);
      }
    } catch {}
  }, []);

  // Fetch live quotes for any watchlist symbols missing from dashboard_data
  useEffect(() => {
    if (!watchlist || watchlist.length === 0) return;
    const fetchLive = () => {
      fetch('/api/live-quotes?symbols=' + encodeURIComponent(watchlist.join(','))).then(r => r.ok ? r.json() : null).then(d => {
        if (d?.prices) setLiveQuotes(d.prices);
      }).catch(() => {});
    };
    fetchLive();
    const iv = setInterval(fetchLive, 30000);
    return () => clearInterval(iv);
  }, [watchlist]);

  // Persist watchlist changes to localStorage
  useEffect(() => {
    try { localStorage.setItem('cc-watchlist', JSON.stringify(watchlist)); } catch {}
  }, [watchlist]);

  // Fetch equity history for sparkline + intraday bars
  useEffect(() => {
    fetch('/api/equity-history').then(r => r.ok ? r.json() : null).then(d => {
      if (d?.history) setEquityHistory(d.history);
    }).catch(() => {});
    const fetchIntraday = () => {
      fetch('/api/equity-intraday').then(r => r.ok ? r.json() : null).then(d => {
        if (d?.bars) setEquityIntraday(d.bars);
      }).catch(() => {});
    };
    fetchIntraday();
    const iv = setInterval(fetchIntraday, 60000); // refresh every 60s
    return () => clearInterval(iv);
  }, []);

  // Refetch Kronos when symbol changes — handles 404 + updates history
  useEffect(() => {
    setKronosError(''); setKronosLoading(true);
    fetch('/api/kronos-forecast?symbol=' + encodeURIComponent(kronosSymbol))
      .then(async r => {
        if (r.ok) { return r.json(); }
        const j = await r.json().catch(() => ({}));
        if (j.missing) {
          setKronosError('No forecast for ' + kronosSymbol + '. Click GENERATE to create one (~3 min).');
        } else {
          setKronosError(j.error || 'Failed to load forecast');
        }
        return null;
      })
      .then(d => { if (d) { setKronosForecast(d); setKronosError(''); } })
      .catch(() => setKronosError('Network error'))
      .finally(() => setKronosLoading(false));
    // Update history (de-dupe, prepend, cap 10)
    setKronosHistory(prev => {
      const next = [kronosSymbol, ...prev.filter(s => s !== kronosSymbol)].slice(0, 10);
      try { localStorage.setItem('cc-kronos-history', JSON.stringify(next)); } catch {}
      return next;
    });
  }, [kronosSymbol]);

  // Load Kronos history from localStorage
  useEffect(() => {
    try {
      const h = localStorage.getItem('cc-kronos-history');
      if (h) setKronosHistory(JSON.parse(h));
    } catch {}
  }, []);

  // Persist Kronos symbol
  useEffect(() => {
    try {
      const s = localStorage.getItem('cc-kronos-symbol');
      if (s) setKronosSymbol(s);
    } catch {}
  }, []);
  useEffect(() => { try { localStorage.setItem('cc-kronos-symbol', kronosSymbol); } catch {} }, [kronosSymbol]);

  // TradingView widget loader for BTC SuperTrend chart (poll-based, robust to mount timing)
  useEffect(() => {
    if (tvLoadedRef.current) return;
    let attempts = 0;
    let cancelled = false;
    const tryInit = () => {
      if (cancelled || tvLoadedRef.current) return;
      const containerEl = document.getElementById('tv_btc_supertrend');
      const TV = (window as any).TradingView;
      if (!containerEl || !TV || !TV.widget) {
        attempts++;
        if (attempts < 40) setTimeout(tryInit, 250); // up to 10s
        return;
      }
      try {
        new TV.widget({
          width: '100%',
          height: 280,
          symbol: 'BITSTAMP:BTCUSD',
          interval: '60',
          timezone: 'America/New_York',
          theme: 'dark',
          style: '1',
          locale: 'en',
          toolbar_bg: '#0d1117',
          enable_publishing: false,
          hide_top_toolbar: false,
          hide_legend: false,
          allow_symbol_change: true,
          studies: ['STD;Supertrend'],
          container_id: 'tv_btc_supertrend',
        });
        tvLoadedRef.current = true;
      } catch (e) { console.error('TV widget init failed', e); }
    };
    const ensureScript = () => {
      if ((window as any).TradingView?.widget) { tryInit(); return; }
      const existing = document.querySelector('script[src="https://s3.tradingview.com/tv.js"]') as HTMLScriptElement | null;
      if (existing) { existing.addEventListener('load', tryInit); return; }
      const script = document.createElement('script');
      script.src = 'https://s3.tradingview.com/tv.js';
      script.async = true;
      script.onload = tryInit;
      document.head.appendChild(script);
    };
    ensureScript();
    return () => { cancelled = true; };
  }, []);

  const equity = parseFloat(portfolio?.equity || portfolio?.balance || '0');
  const lastEq = parseFloat(portfolio?.last_equity || '0');
  const dailyPct = lastEq ? ((equity - lastEq) / lastEq * 100) : 0;
  const totalReturn = ((equity - 500000) / 500000 * 100);
  const positions = portfolio?.positions || [];
  const btcSignal = signals?.BTCUSD || {};
  const regimeStr = regime?.overall_regime || regime?.regime || 'UNKNOWN';
  const bias = regime?.direction_bias || regime?.bias || '';
  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });

  // Huge Flow alerts (matches Options page categorizeAlert 'huge' logic, sorted by totalFlowValue DESC)
  const hugeAlerts = (() => {
    const flowsArr = (unusualFlows as any)?._allAlerts || [];
    return flowsArr.filter((a: any) => {
      const t = (a.AlertType || '').toLowerCase();
      if (t.includes('etf') || t.includes('weekly') || t.includes('repeat') || t.includes('unusual')) return false;
      return t.includes('high_flow') || t.includes('huge');
    }).sort((a: any, b: any) => (b.totalFlowValue || 0) - (a.totalFlowValue || 0));
  })();
  const quotes = dashData?.quotes || {};
  const intel = dashData?.intel || {};
  const news = dashData?.news || [];

  // Multi-timeframe regime data for SuperTrend MTF Quorum tile
  const tfData = regime?.timeframes || {};
  const mtfRows = (['1H', '4H', '1D'] as const).map(k => {
    const t = tfData[k] || {};
    return { tf: k, direction: t.direction || 'UNKNOWN', adx: t.adx || 0, choppiness: t.choppiness || 50 };
  });
  const dirCount = mtfRows.reduce((acc: any, r) => { acc[r.direction] = (acc[r.direction] || 0) + 1; return acc; }, {});
  const consensusDir = (dirCount.BULLISH || 0) > (dirCount.BEARISH || 0) ? 'BULL' : (dirCount.BEARISH || 0) > (dirCount.BULLISH || 0) ? 'BEAR' : 'MIXED';
  const consensusCount = Math.max(dirCount.BULLISH || 0, dirCount.BEARISH || 0);
  const consensusVerdict = consensusCount === 3 ? 'Strong ' + consensusDir : consensusCount === 2 ? 'Light ' + consensusDir + ' — wait' : 'Mixed — sit out';

  // Tradeability score (0-100)
  const adxAvg = mtfRows.reduce((s, r) => s + r.adx, 0) / 3;
  const choppyAvg = mtfRows.reduce((s, r) => s + r.choppiness, 0) / 3;
  const dirsArr = mtfRows.map(r => r.direction);
  const allBull = dirsArr.every(d => d === 'BULLISH');
  const allBear = dirsArr.every(d => d === 'BEARISH');
  const aligned = allBull || allBear;
  const partial = new Set(dirsArr).size === 2;
  const alignmentBonus = aligned ? 1 : (partial ? 0.5 : 0.25);
  const tradeability = Math.round(Math.min(adxAvg / 50, 1) * 40 + Math.max(0, (1 - choppyAvg / 100)) * 30 + alignmentBonus * 30);
  const tradeabilityColor = tradeability >= 60 ? '#66bb6a' : tradeability >= 30 ? '#ff9800' : '#ef5350';
  const tradeabilityLabel = tradeability >= 60 ? 'TRADEABLE' : tradeability >= 30 ? 'CAUTION' : 'CHOPPY';
  const volLabel = choppyAvg >= 60 ? 'HIGH' : choppyAvg >= 40 ? 'MED' : 'LOW';
  const dirArrow = (d: string) => d === 'BULLISH' ? '▲' : d === 'BEARISH' ? '▼' : '-';
  const dirColor = (d: string) => d === 'BULLISH' ? '#66bb6a' : d === 'BEARISH' ? '#ef5350' : '#ff9800';

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ fontSize: 'var(--mc-font-sm)', animation: 'blink 1s infinite' }}>INITIALIZING COMMAND CENTER...</div>
    </div>
  );

  return (
    <div style={{ padding: '20px', maxWidth: '1400px', margin: '0 auto', fontFamily: 'var(--font-mc-sans)' }}>
      <style>{`
        @keyframes blink { 0%,100% { opacity: 1; } 50% { opacity: 0.3; } }
        @keyframes pulse { 0%,100% { opacity: 0.4; } 50% { opacity: 1; } }
        @keyframes marquee { 0% { transform: translateX(0); } 100% { transform: translateX(-50%); } }
        .cc { background: #0a1929; border: 1px solid #1a3a4a; border-radius: 8px; overflow: hidden; position: relative; }
        .cc::before { content: ''; position: absolute; top: 0; left: 0; right: 0; height: 2px; background: linear-gradient(90deg, transparent, #4fc3f7, transparent); }
        .lbl { font-size: var(--mc-font-label); color: #607d8b; text-transform: uppercase; letter-spacing: 1.5px; font-family: var(--font-mc-mono); margin-bottom: 6px; }
        .beat { color: #66bb6a; } .miss { color: #ef5350; } .neu { color: #ff9800; }
        .news-row:hover { background: #0d1929 !important; }
      `}</style>

      {/* HEADER */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '12px', padding: '10px 20px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '12px' }}>
          <div style={{ width: '10px', height: '10px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 8px #66bb6a', animation: 'pulse 2s infinite' }} />
          <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>COMMAND CENTER</span>
        </div>
        <div style={{ display: 'flex', gap: '16px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
          <span>REGIME: <span style={{ color: bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800' }}>{regimeStr}</span></span>
          <span style={{ animation: 'blink 1.4s infinite', color: '#ef5350', display: 'flex', alignItems: 'center', gap: '4px' }}><span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#ef5350', display: 'inline-block' }} />LIVE</span>
        </div>
      </div>

      {/* TV TICKER */}
      <div style={{ marginBottom: '8px', borderRadius: '6px', overflow: 'hidden', border: '1px solid #1a3a4a' }}>
        <iframe src="https://s.tradingview.com/embed-widget/ticker-tape/?locale=en#%7B%22symbols%22%3A%5B%7B%22proName%22%3A%22NASDAQ%3AAAPL%22%7D%2C%7B%22proName%22%3A%22NASDAQ%3ANVDA%22%7D%2C%7B%22proName%22%3A%22NASDAQ%3ATSLA%22%7D%2C%7B%22proName%22%3A%22NASDAQ%3AMU%22%7D%2C%7B%22proName%22%3A%22NYSE%3ALLY%22%7D%2C%7B%22proName%22%3A%22BITSTAMP%3ABTCUSD%22%7D%2C%7B%22proName%22%3A%22FOREXCOM%3ASPXUSD%22%7D%2C%7B%22proName%22%3A%22FOREXCOM%3ANSXUSD%22%7D%5D%2C%22showSymbolLogo%22%3Atrue%2C%22isTransparent%22%3Atrue%2C%22displayMode%22%3A%22compact%22%2C%22colorTheme%22%3A%22dark%22%7D" style={{ width: '100%', height: '46px', border: 'none' }} title="ticker" />
      </div>

      {/* PORTFOLIO MARQUEE */}
      <div style={{ overflow: 'hidden', marginBottom: '12px', padding: '8px 0', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '6px' }}>
        <div style={{ display: 'flex', gap: '40px', animation: 'marquee 25s linear infinite', whiteSpace: 'nowrap' }}>
          {[...Array(2)].flatMap(() => [
            { sym: 'ALPACA', val: '$' + fmt(equity), chg: dailyPct, color: dailyPct >= 0 ? '#66bb6a' : '#ef5350' },
            { sym: 'RETURN', val: (totalReturn >= 0 ? '+' : '') + fmt(totalReturn, 1) + '%', chg: totalReturn, color: totalReturn >= 0 ? '#66bb6a' : '#ef5350' },
            ...((allWallets || []).map((w: any) => ({ sym: (w.name || '').toUpperCase().slice(0, 12), val: w.balance > 0 ? '$' + fmt(w.balance) : 'N/A', chg: 0, color: w.balance > 0 ? '#4fc3f7' : '#607d8b' }))),
            ...(rhPositions || []),
          ]).map((item, i) => (
            <span key={i} style={{ fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
              <span style={{ color: '#4fc3f7', marginRight: '6px' }}>{item.sym}</span>
              <span style={{ color: item.color, fontWeight: 600 }}>{item.val}</span>
              {item.chg ? <span style={{ color: item.color, marginLeft: '4px', fontSize: 'var(--mc-font-label)' }}>({item.chg >= 0 ? '+' : ''}{fmt(item.chg, 1)}%)</span> : null}
            </span>
          ))}
        </div>
      </div>

      {/* MARKET NEWS - full-width keyboard-navigable ticker */}
      <div className="cc" tabIndex={0} ref={newsTickerRef} style={{ padding: '12px 18px', marginBottom: '12px', cursor: 'pointer', outline: 'none' }} onClick={() => newsTickerRef.current?.focus()}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
          <div className="lbl">MARKET NEWS</div>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>
            {'←'} / {'→'} arrow keys · {newsIdx + 1} of {news.length || 0}
          </div>
        </div>
        {news.length > 0 && news[newsIdx] ? (
          <a href={news[newsIdx]?.url} target="_blank" rel="noopener noreferrer" style={{ display: 'flex', gap: '12px', alignItems: 'center', textDecoration: 'none', color: '#e0e0e0' }}>
            <span style={{ minWidth: '50px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontWeight: 600, fontSize: 'var(--mc-font-label)' }}>{news[newsIdx]?.time || ''}</span>
            <span style={{ flex: 1, fontSize: 'var(--mc-font-md)', fontWeight: 500, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{news[newsIdx]?.headline || ''}</span>
            <span style={{ minWidth: '70px', textAlign: 'right', color: '#607d8b', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>{news[newsIdx]?.source || ''}</span>
          </a>
        ) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-label)', textAlign: 'center', padding: '8px' }}>No news available</div>}
      </div>

      {/* METRIC CARDS - 5 tiles with redesigned SuperTrend MTF + Regime Tradeability */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr 1.4fr 1.4fr', gap: '10px', marginBottom: '12px', alignItems: 'stretch' }}>
        <div className="cc" style={{ padding: '16px 18px' }}>
          <div className="lbl">ALPACA EQUITY</div>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-end', gap: '10px' }}>
            <div style={{ minWidth: 0, flex: 1 }}>
              <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', color: '#4fc3f7' }}>${fmt(equity)}</div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', marginTop: '4px' }}>{(dailyPct >= 0 ? '+' : '') + fmt(dailyPct) + '% today'}</div>
            </div>
            {(() => {
              const bars = equityIntraday || [];
              if (bars.length < 2) return null;
              // Visual: vertical bars from premarket open through afterhours
              const w = 220, h = 60, gap = 1;
              const eqs = bars.map((b: any) => Number(b.eq)).filter((v: number) => !isNaN(v));
              if (eqs.length < 2) return null;
              const baseEq = eqs[0]; // first bar = market open of the day
              const maxAbsDelta = Math.max(...eqs.map((v: number) => Math.abs(v - baseEq))) || 1;
              const barW = Math.max(1, (w - (eqs.length - 1) * gap) / eqs.length);
              const midY = h / 2;
              return (
                <svg width={w} height={h} style={{ display: 'block', flexShrink: 0 }}>
                  <line x1={0} y1={midY} x2={w} y2={midY} stroke="#1a3a4a" strokeDasharray="2,2" strokeWidth="0.5" />
                  {eqs.map((v: number, i: number) => {
                    const delta = v - baseEq;
                    const barH = Math.max(1, Math.abs(delta) / maxAbsDelta * (h / 2 - 1));
                    const x = i * (barW + gap);
                    const y = delta >= 0 ? midY - barH : midY;
                    const c = delta >= 0 ? '#66bb6a' : '#ef5350';
                    return <rect key={i} x={x} y={y} width={barW} height={barH} fill={c} />;
                  })}
                </svg>
              );
            })()}
          </div>
        </div>

        <div className="cc" style={{ padding: '16px 18px' }}>
          <div className="lbl">P&amp;L SNAPSHOT</div>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-end', gap: '10px' }}>
            <div style={{ minWidth: 0, flex: 1 }}>
              <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', color: totalReturn >= 0 ? '#66bb6a' : '#ef5350' }}>{(totalReturn >= 0 ? '+' : '') + fmt(totalReturn, 1)}%</div>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', marginTop: '2px', fontFamily: 'var(--font-mc-mono)' }}>${fmt(equity - 100000, 0)} total</div>
              {(() => {
                const hist = (equityHistory || []).slice().reverse();
                if (hist.length < 2) return null;
                const week = hist[0]?.equity ? ((equity - hist[Math.min(6, hist.length-1)].equity) / hist[Math.min(6, hist.length-1)].equity * 100) : 0;
                return <div style={{ fontSize: 'var(--mc-font-label)', color: week >= 0 ? '#66bb6a' : '#ef5350', marginTop: '2px', fontFamily: 'var(--font-mc-mono)' }}>{week >= 0 ? '+' : ''}{fmt(week, 1)}% 7d</div>;
              })()}
            </div>
            {(() => {
              const data = (equityHistory || []).slice().reverse().map((h: any) => Number(h.equity)).filter((v: number) => !isNaN(v));
              if (data.length < 2) return null;
              const w = 90, h = 50;
              const min = Math.min(...data); const max = Math.max(...data); const range = max - min || 1;
              const pts = data.map((v: number, i: number) => `${(i / (data.length - 1)) * w},${h - ((v - min) / range) * h}`).join(' ');
              const up = data[data.length - 1] >= data[0];
              const color = up ? '#66bb6a' : '#ef5350';
              return (
                <svg width={w} height={h} style={{ display: 'block', flexShrink: 0 }}>
                  <polyline points={pts} fill="none" stroke={color} strokeWidth="1.5" strokeLinejoin="round" strokeLinecap="round" />
                  <circle cx={w} cy={h - ((data[data.length - 1] - min) / range) * h} r="2" fill={color} />
                </svg>
              );
            })()}
          </div>
        </div>

        <div className="cc" style={{ padding: '16px 18px', cursor: 'pointer' }} onClick={() => setPositionsExpanded(v => !v)}>
          <div className="lbl" style={{ display: 'flex', justifyContent: 'space-between' }}>
            <span>POSITIONS</span>
            <span style={{ color: '#4fc3f7' }}>{positionsExpanded ? '\u25BC' : '\u25B6'}</span>
          </div>
          <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', color: '#4fc3f7' }}>{positions.length}</div>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', marginTop: '4px' }}>
            {positions.slice(0, 3).map((pp: any, i: number) => (
              <div key={i}>{parseOCC(pp.symbol)}{pp.account ? ' ' + pp.account : ''}</div>
            ))}
            {positions.length > 3 && <div style={{ color: '#4fc3f7', marginTop: '2px' }}>+ {positions.length - 3} more (click)</div>}
          </div>
        </div>

        {/* SUPERTREND BTC - MTF Quorum */}
        <div className="cc" style={{ padding: '12px 14px' }}>
          <div className="lbl" style={{ marginBottom: '6px', display: 'flex', justifyContent: 'space-between' }}>
            <span>SUPERTREND BTC</span>
            <span style={{ color: '#607d8b', fontWeight: 400 }}>{btcSignal.entry_price ? '$' + Number(btcSignal.entry_price).toLocaleString() : ''}</span>
          </div>
          {mtfRows.map((r, i) => (
            <div key={i} style={{ display: 'grid', gridTemplateColumns: '24px 64px 1fr 60px', gap: '6px', alignItems: 'center', padding: '3px 0', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#607d8b', fontWeight: 600 }}>{r.tf}</span>
              <span style={{ color: dirColor(r.direction), fontWeight: 700 }}>{dirArrow(r.direction)} {r.direction === 'BULLISH' ? 'BUY' : r.direction === 'BEARISH' ? 'SELL' : '\u2014'}</span>
              <span style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                <span style={{ width: '50px', height: '5px', background: '#1a3a4a', borderRadius: '3px', overflow: 'hidden', display: 'inline-block' }}>
                  <span style={{ display: 'block', width: Math.min(r.adx / 50 * 100, 100) + '%', height: '100%', background: dirColor(r.direction) }} />
                </span>
                <span style={{ color: '#90a4ae', fontSize: '10px' }}>ADX{r.adx.toFixed(0)}</span>
              </span>
              <span style={{ color: r.choppiness >= 60 ? '#ef5350' : r.choppiness >= 40 ? '#ff9800' : '#66bb6a', textAlign: 'right', fontSize: '10px' }}>Chop{r.choppiness.toFixed(0)}</span>
            </div>
          ))}
          <div style={{ marginTop: '6px', paddingTop: '6px', borderTop: '1px solid #1a3a4a', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', color: dirColor(consensusDir === 'BULL' ? 'BULLISH' : consensusDir === 'BEAR' ? 'BEARISH' : 'MIXED'), fontWeight: 600 }}>
            {consensusCount}/3 {consensusDir} · {consensusVerdict}
          </div>
        </div>

        {/* REGIME (BTC) - Tradeability */}
        <div className="cc" style={{ padding: '12px 14px' }}>
          <div className="lbl" style={{ marginBottom: '6px' }}>REGIME (BTC)</div>
          <div style={{ display: 'flex', alignItems: 'baseline', gap: '8px', marginBottom: '6px', flexWrap: 'wrap' }}>
            <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>TRADEABILITY</span>
            <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: tradeabilityColor, fontFamily: 'var(--font-mc-mono)' }}>{tradeability}/100</span>
            <span style={{ fontSize: '10px', fontWeight: 600, color: tradeabilityColor, fontFamily: 'var(--font-mc-mono)' }}>{tradeabilityLabel}</span>
          </div>
          <div style={{ width: '100%', height: '6px', background: '#1a3a4a', borderRadius: '3px', overflow: 'hidden', marginBottom: '6px' }}>
            <div style={{ width: tradeability + '%', height: '100%', background: tradeabilityColor }} />
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: '36px 1fr 56px', gap: '6px', alignItems: 'center', fontSize: '10px', fontFamily: 'var(--font-mc-mono)', padding: '2px 0' }}>
            <span style={{ color: '#607d8b' }}>Trend</span>
            <span style={{ width: '100%', height: '5px', background: '#1a3a4a', borderRadius: '2px', overflow: 'hidden' }}><span style={{ display: 'block', width: Math.min(adxAvg / 50 * 100, 100) + '%', height: '100%', background: '#4fc3f7' }} /></span>
            <span style={{ color: '#90a4ae', textAlign: 'right' }}>ADX {adxAvg.toFixed(0)}</span>
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: '36px 1fr 56px', gap: '6px', alignItems: 'center', fontSize: '10px', fontFamily: 'var(--font-mc-mono)', padding: '2px 0' }}>
            <span style={{ color: '#607d8b' }}>Vol</span>
            <span style={{ width: '100%', height: '5px', background: '#1a3a4a', borderRadius: '2px', overflow: 'hidden' }}><span style={{ display: 'block', width: Math.min(choppyAvg, 100) + '%', height: '100%', background: choppyAvg >= 60 ? '#ef5350' : choppyAvg >= 40 ? '#ff9800' : '#66bb6a' }} /></span>
            <span style={{ color: '#90a4ae', textAlign: 'right' }}>{volLabel}</span>
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: '36px 1fr 56px', gap: '6px', alignItems: 'center', fontSize: '10px', fontFamily: 'var(--font-mc-mono)', padding: '2px 0' }}>
            <span style={{ color: '#607d8b' }}>Bias</span>
            <span style={{ display: 'flex', gap: '4px' }}>
              {mtfRows.map((r, i) => <span key={i} style={{ color: dirColor(r.direction), fontSize: '10px', fontWeight: 600 }}>{r.tf}{dirArrow(r.direction)}</span>)}
            </span>
            <span style={{ color: '#90a4ae', textAlign: 'right' }}>{aligned ? 'ALIGN' : partial ? 'PART' : 'MIX'}</span>
          </div>
          <div style={{ marginTop: '6px', paddingTop: '6px', borderTop: '1px solid #1a3a4a', fontSize: 'var(--mc-font-label)', color: tradeabilityColor, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>
            → {regime?.overall_recommendation || 'No data'}
          </div>
        </div>
      </div>

      {/* All positions inline (when expanded) */}
      {positionsExpanded && (
        <div className="cc" style={{ padding: '16px', marginBottom: '12px' }}>
          <div className="lbl" style={{ marginBottom: '10px' }}>ALL POSITIONS ({positions.length})</div>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(2, 1fr)', gap: '6px' }}>
            {positions.map((pp: any, i: number) => {
              const pnl = parseFloat(pp.unrealized_pl || '0');
              const pnlPct = parseFloat(pp.unrealized_plpc || '0') * 100;
              const g = pnl >= 0;
              return (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 10px', background: '#0d1117', borderRadius: '6px', border: '1px solid ' + (g ? '#66bb6a22' : '#ef535022'), fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                  <span style={{ color: '#e0e0e0' }}>{parseOCC(pp.symbol)}{pp.account ? ' ' + pp.account : ''}</span>
                  <span style={{ color: g ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>{g ? '+' : ''}${pnl.toFixed(0)} ({g ? '+' : ''}{pnlPct.toFixed(1)}%)</span>
                </div>
              );
            })}
          </div>
        </div>
      )}

      {/* TRADINGVIEW SUPERTREND MINI CHART (BTCUSD 1H) */}
      <div className="cc" style={{ padding: '12px 14px', marginBottom: '12px' }}>
        <div className="lbl" style={{ marginBottom: '8px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <span>BTC/USD · 1H · SUPERTREND LIVE</span>
          <span style={{ color: '#607d8b', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>via TradingView</span>
        </div>
        <div id="tv_btc_supertrend" ref={tvContainerRef} style={{ height: '280px', width: '100%' }} />
      </div>

      {/* WATCHLIST CARDS + PIPELINE */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '12px' }}>

        {/* WATCHLIST QUOTE CARDS */}
        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '12px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
            <span>WATCHLIST <span style={{ color: '#455a64', fontWeight: 400, marginLeft: '6px' }}>{watchlist.length}</span></span>
            <button
              onClick={() => setShowAddInput(v => !v)}
              style={{ background: showAddInput ? '#ef5350' : '#4fc3f7', color: '#0d1117', border: 'none', borderRadius: '4px', width: '24px', height: '24px', cursor: 'pointer', fontSize: '16px', fontWeight: 700, lineHeight: '20px', fontFamily: 'var(--font-mc-mono)' }}
              title={showAddInput ? 'Cancel' : 'Add symbol'}
            >{showAddInput ? '×' : '+'}</button>
          </div>
          {showAddInput && (
            <div style={{ display: 'flex', gap: '6px', marginBottom: '10px' }}>
              <input
                type="text"
                placeholder="SYMBOL"
                value={newSymInput}
                onChange={e => setNewSymInput(e.target.value.toUpperCase())}
                onKeyDown={e => {
                  if (e.key === 'Enter') {
                    const s = newSymInput.trim().toUpperCase();
                    if (s && !watchlist.includes(s)) setWatchlist([...watchlist, s]);
                    setNewSymInput(''); setShowAddInput(false);
                  } else if (e.key === 'Escape') {
                    setNewSymInput(''); setShowAddInput(false);
                  }
                }}
                autoFocus
                style={{ flex: 1, background: '#0d1117', color: '#e0e0e0', border: '1px solid #1a3a4a', borderRadius: '4px', padding: '6px 10px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', outline: 'none' }}
              />
              <button
                onClick={() => {
                  const s = newSymInput.trim().toUpperCase();
                  if (s && !watchlist.includes(s)) setWatchlist([...watchlist, s]);
                  setNewSymInput(''); setShowAddInput(false);
                }}
                style={{ background: '#66bb6a', color: '#0d1117', border: 'none', borderRadius: '4px', padding: '0 12px', cursor: 'pointer', fontSize: 'var(--mc-font-label)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}
              >ADD</button>
            </div>
          )}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
            {watchlist.map((sym, idx) => {
              const lq = liveQuotes[sym];
              const q = quotes[sym] || (lq ? { price: lq.price, change_p: lq.changePct } : null);
              const inf = intel[sym];
              const a = inf?.analyst;
              const e = inf?.earnings;
              const ins = inf?.insider;
              const chg = q?.change_p || 0;
              const green = chg >= 0;
              return (
                <div
                  key={sym}
                  draggable
                  onClick={() => setDrawerTicker(sym)}
                  onDragStart={() => setDraggedIdx(idx)}
                  onDragOver={e => e.preventDefault()}
                  onDrop={() => {
                    if (draggedIdx === null || draggedIdx === idx) { setDraggedIdx(null); return; }
                    const next = [...watchlist];
                    const [moved] = next.splice(draggedIdx, 1);
                    next.splice(idx, 0, moved);
                    setWatchlist(next);
                    setDraggedIdx(null);
                  }}
                  onDragEnd={() => setDraggedIdx(null)}
                  style={{ background: '#0d1117', border: '1px solid ' + (draggedIdx === idx ? '#4fc3f7' : '#1a3a4a'), borderRadius: '8px', padding: '12px', position: 'relative', cursor: 'grab', opacity: draggedIdx === idx ? 0.5 : 1 }}
                >
                  <button
                    onClick={() => setWatchlist(watchlist.filter((_, i) => i !== idx))}
                    onMouseDown={e => e.stopPropagation()}
                    style={{ position: 'absolute', top: '4px', right: '4px', background: 'transparent', border: 'none', color: '#455a64', cursor: 'pointer', fontSize: '14px', padding: '2px 6px', borderRadius: '3px', lineHeight: 1, fontFamily: 'var(--font-mc-mono)' }}
                    onMouseEnter={e => { (e.currentTarget as HTMLElement).style.color = '#ef5350'; }}
                    onMouseLeave={e => { (e.currentTarget as HTMLElement).style.color = '#455a64'; }}
                    title={'Remove ' + sym}
                  >×</button>
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '8px' }}>
                    <span style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{sym}</span>
                    <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, color: green ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>
                      {q ? '$' + (typeof q.price === 'number' ? q.price.toFixed(2) : q.price) : 'N/A'}
                    </span>
                  </div>
                  {q && <div style={{ fontSize: 'var(--mc-font-label)', color: green ? '#66bb6a' : '#ef5350', marginBottom: '6px', fontFamily: 'var(--font-mc-mono)' }}>{green ? '+' : ''}{typeof chg === 'number' ? chg.toFixed(2) : chg}%</div>}
                  {a && (
                    <div style={{ marginBottom: '6px' }}>
                      <div style={{ display: 'flex', height: '6px', borderRadius: '3px', overflow: 'hidden', background: '#1a3a4a' }}>
                        <div style={{ width: a.buyPct + '%', background: '#66bb6a' }} />
                        <div style={{ width: (100 - a.buyPct - ((a.sell + a.strongSell) / a.total * 100)) + '%', background: '#ff9800' }} />
                        <div style={{ width: ((a.sell + a.strongSell) / a.total * 100) + '%', background: '#ef5350' }} />
                      </div>
                      <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', marginTop: '3px', fontFamily: 'var(--font-mc-mono)' }}>{a.buyPct}% BUY ({a.total} analysts)</div>
                    </div>
                  )}
                  {e && <div style={{ fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: e.beat ? '#66bb6a' : '#ef5350' }}>{e.beat ? '\u2713 BEAT' : '\u2717 MISS'} {e.surprisePct > 0 ? '+' : ''}{e.surprisePct}% (Q{e.period?.slice(5,7)})</div>}
                  {ins && <div style={{ fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: ins.direction === 'BUYING' ? '#66bb6a' : '#ef5350', marginTop: '2px' }}>Insiders: {ins.direction} (MSPR {ins.mspr})</div>}
                </div>
              );
            })}
          </div>
        </div>

        {/* FLOW ALERTS - mirrors Options page Flow Alerts tab */}
        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '12px', display: 'flex', justifyContent: 'space-between' }}>
            <span><span style={{ display: 'flex', alignItems: 'center', gap: '4px' }}><span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#ef5350', animation: 'blink 1.4s infinite', display: 'inline-block' }} />FLOW ALERTS</span></span>
            <span style={{ color: '#455a64' }}>{(((unusualFlows as any)?._allAlerts || []) as any[]).length} alerts</span>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: '2px', maxHeight: '380px', overflowY: 'auto' }}>
            {(() => {
              const allAlerts = (((unusualFlows as any)?._allAlerts || []) as any[]);
              if (allAlerts.length === 0) {
                return <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '40px' }}>No flow alerts</div>;
              }
              const cat = (a: any): string | null => {
                const t = (a.AlertType || '').toLowerCase();
                if (t.includes('etf')) return 'etf';
                if (t.includes('weekly')) return 'weekly';
                if (t.includes('repeat')) return 'repeat';
                if (t.includes('unusual')) return 'unusual';
                if (t.includes('high_flow') || t.includes('huge')) return 'huge';
                return null;
              };
              const catColor = (c: string | null) => c === 'huge' ? '#e040fb' : c === 'unusual' ? '#ffd600' : c === 'repeat' ? '#4fc3f7' : c === 'weekly' ? '#ff9800' : c === 'etf' ? '#66bb6a' : '#607d8b';
              const sorted = allAlerts.slice().sort((a: any, b: any) => (b.Updated || 0) - (a.Updated || 0)).slice(0, 30);
              return [
                <div key="legend" style={{ display: 'flex', flexWrap: 'wrap', gap: '10px', padding: '4px 8px 8px', borderBottom: '1px solid #1a3a4a', marginBottom: '4px', fontSize: '10px', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
                  <span><span style={{ color: '#66bb6a', fontWeight: 700 }}>▲</span> bullish</span>
                  <span><span style={{ color: '#ef5350', fontWeight: 700 }}>▼</span> bearish</span>
                  <span><span style={{ color: '#ff9800' }}>⚡</span> sweep (urgency)</span>
                  <span><span style={{ color: '#ce93d8' }}>▦</span> block (institutional)</span>
                  <span><span style={{ color: '#66bb6a' }}>C</span> call</span>
                  <span><span style={{ color: '#ef5350' }}>P</span> put</span>
                </div>,
                ...sorted.map((a: any, i: number) => {
                const c = cat(a);
                const v = a.totalFlowValue || 0;
                const fmtV = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(2) + 'M' : '$' + (n/1000).toFixed(0) + 'K';
                const expStr = a.Expiry ? new Date(a.Expiry).toLocaleDateString('en-US', { month: 'numeric', day: 'numeric' }) : '';
                const ago = (() => { const m = Math.floor((Date.now() - (a.Updated||0)) / 60000); return m < 1 ? 'now' : m < 60 ? m+'m' : m < 1440 ? Math.floor(m/60)+'h' : Math.floor(m/1440)+'d'; })();
                return (
                  <div key={i} onClick={() => setSelectedItem({ type: 'alert', data: a })} style={{ cursor: 'pointer', display: 'grid', gridTemplateColumns: '34px 42px 50px 82px 44px 1fr 90px', gap: '6px', alignItems: 'center', padding: '5px 8px', borderLeft: '2px solid ' + catColor(c), background: '#0d1117', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                    <span style={{ color: '#607d8b' }}>{ago}</span>
                    <span style={{ color: catColor(c), fontWeight: 700, fontSize: '9px', textTransform: 'uppercase' }}>{c || '?'}</span>
                    <span style={{ color: '#e0e0e0', fontWeight: 700 }}>{a.Symbol}</span>
                    <span style={{ color: a.OptionType === 'CALL' ? '#66bb6a' : '#ef5350', fontWeight: 600, whiteSpace: 'nowrap' }} title={a.OptionType === 'CALL' ? 'CALL option' : 'PUT option'}>{a.OptionType === 'CALL' ? 'C' : 'P'} ${a.Strike}</span>
                    <span style={{ color: '#90a4ae' }}>{expStr}</span>
                    <span style={{ display: 'flex', alignItems: 'center', gap: '8px', overflow: 'hidden', whiteSpace: 'nowrap' }}>
                      <span style={{ color: a.isBullish ? '#66bb6a' : '#ef5350', fontWeight: 700 }} title={a.isBullish ? 'Bullish flow (buyers in control)' : 'Bearish flow (sellers in control)'}>{a.isBullish ? '▲' : '▼'}</span>
                      {(a.SWEEPS || 0) > 0 && <span title={(a.SWEEPS) + ' sweeps - aggressive multi-exchange fills (urgency)'} style={{ color: '#ff9800', fontWeight: 600 }}>⚡{a.SWEEPS}</span>}
                      {(a.BLOCKS || 0) > 0 && <span title={(a.BLOCKS) + ' blocks - large single negotiated trades (institutional)'} style={{ color: '#ce93d8', fontWeight: 600 }}>▦{a.BLOCKS}</span>}
                    </span>
                    <span style={{ color: catColor(c), fontWeight: 800, fontSize: 'var(--mc-font-md)', textAlign: 'right' }}>{fmtV(v)}</span>
                  </div>
                );
              })];
            })()}
          </div>
        </div>
      </div>

      {/* UNUSUAL FLOW + KRONOS FORECAST */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '12px' }}>
        <div className="cc" style={{ padding: '16px', maxHeight: '350px', overflowY: 'auto' }}>
          <div className="lbl" style={{ marginBottom: '10px', display: 'flex', justifyContent: 'space-between' }}>
            <span style={{ color: '#ffd600' }}>UNUSUAL FLOW (Vol {'>'} OI)</span>
            <span style={{ color: '#ffd600' }}>{unusualFlows.length}</span>
          </div>
          {unusualFlows.length > 0 ? unusualFlows.map((f: any, i: number) => {
            const isCall = f.OptionType === 'CALL';
            const isAsk = f.BidAskType === 'A' || f.BidAskType === 'AA';
            const bullish = (isCall && isAsk) || (!isCall && !isAsk);
            const sColor = bullish ? '#66bb6a' : '#ef5350';
            const isSweep = f.BlockType === 'SWEEP';
            const valColor = f.Value >= 5000000 ? '#e040fb' : f.Value >= 1000000 ? '#ffd600' : f.Value >= 500000 ? '#ff9800' : f.Value >= 250000 ? '#4fc3f7' : '#e0e0e0';
            const fmtV = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(1) + 'M' : n >= 1000 ? '$' + (n/1000).toFixed(0) + 'K' : '$' + n;
            const timeAgo = (ts: number) => { const m = Math.floor((Date.now() - ts) / 60000); if (m < 1) return 'now'; if (m < 60) return m + 'm'; const h = Math.floor(m/60); if (h < 24) return h + 'h'; return Math.floor(h/24) + 'd'; };
            return (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '7px 10px', borderBottom: '1px solid #0d1117', borderLeft: '3px solid #ffd600' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: sColor, boxShadow: '0 0 4px ' + sColor }} />
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(f.Time)}</span>
                  <span style={{ fontSize: 'var(--mc-font-sm)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{f.Symbol}</span>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: sColor }}>{f.OptionType?.slice(0,1)} ${f.Strike}</span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: 'var(--mc-font-sm)', color: valColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{fmtV(f.Value)}</span>
                  <span style={{ fontSize: 'var(--mc-font-label)', fontWeight: 700, padding: '1px 4px', borderRadius: '3px', background: isSweep ? '#ff980022' : '#4fc3f722', color: isSweep ? '#ff9800' : '#4fc3f7' }}>{isSweep ? 'SWP' : 'BLK'}</span>
                </div>
              </div>
            );
          }) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '30px' }}>No unusual flow detected</div>}
        </div>

        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '10px', display: 'flex', justifyContent: 'space-between' }}>
            <span style={{ color: '#ce93d8' }}>KRONOS {kronosForecast?.symbol || kronosSymbol} FORECAST</span>
            <span style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
              <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{kronosForecast?.symbol || kronosSymbol}</span>
              <button onClick={() => setShowKronosInput(v => !v)} style={{ background: showKronosInput ? '#ef5350' : '#1a3a4a', color: '#e0e0e0', border: 'none', borderRadius: '3px', width: '20px', height: '20px', cursor: 'pointer', fontSize: '12px', fontWeight: 700, lineHeight: '14px', fontFamily: 'var(--font-mc-mono)' }}>{showKronosInput ? '×' : '✎'}</button>
              <button onClick={() => setShowKronosHistory(v => !v)} title="History" style={{ background: '#1a3a4a', color: '#e0e0e0', border: 'none', borderRadius: '3px', padding: '2px 6px', cursor: 'pointer', fontSize: '10px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>HIST</button>
              <button onClick={async () => {
                setKronosLoading(true); setKronosError('');
                try {
                  const r = await fetch('/api/kronos-generate', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ ticker: kronosSymbol }) });
                  const j = await r.json();
                  if (j.status === 'generating') {
                    setKronosError('Generating ' + kronosSymbol + '... checking every 20s (~3 min)');
                    let attempts = 0;
                    const poll = setInterval(() => {
                      attempts++;
                      fetch('/api/kronos-forecast?symbol=' + encodeURIComponent(kronosSymbol)).then(r => r.ok ? r.json() : null).then(d => {
                        if (d && !d.error) { setKronosForecast(d); setKronosError(''); setKronosLoading(false); clearInterval(poll); }
                      });
                      if (attempts > 20) { setKronosError('Timeout waiting for forecast.'); setKronosLoading(false); clearInterval(poll); }
                    }, 20000);
                  } else { setKronosError(j.error || 'generation failed'); setKronosLoading(false); }
                } catch (e) { setKronosError(String(e)); setKronosLoading(false); }
              }} title="Generate fresh forecast" style={{ background: '#66bb6a', color: '#0d1117', border: 'none', borderRadius: '3px', padding: '2px 6px', cursor: 'pointer', fontSize: '10px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>GEN</button>
              {showKronosInput && (
                <input type="text" placeholder="SYMBOL" value={kronosInput} onChange={e => setKronosInput(e.target.value.toUpperCase())} onKeyDown={e => { if (e.key === 'Enter') { const s = kronosInput.trim().toUpperCase(); if (s) setKronosSymbol(s); setKronosInput(''); setShowKronosInput(false); } else if (e.key === 'Escape') { setKronosInput(''); setShowKronosInput(false); } }} autoFocus style={{ width: '90px', background: '#0d1117', color: '#e0e0e0', border: '1px solid #1a3a4a', borderRadius: '3px', padding: '3px 6px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', outline: 'none' }} />
              )}
              <span style={{ color: '#607d8b' }}>{kronosForecast?.generated_at ? new Date(kronosForecast.generated_at).toLocaleTimeString() : ''}</span>
            </span>
          </div>
          {showKronosHistory && kronosHistory.length > 0 && (
            <div className="kronos-history-dropdown" style={{ display: 'flex', flexWrap: 'wrap', gap: '6px', padding: '8px', background: '#0d1117', borderRadius: '4px', marginBottom: '8px', border: '1px solid #1a3a4a' }}>
              <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginRight: '4px' }}>RECENT:</span>
              {kronosHistory.map((s: string) => (
                <button key={s} onClick={() => { setKronosSymbol(s); setShowKronosHistory(false); }} style={{ background: s === kronosSymbol ? '#4fc3f7' : '#1a3a4a', color: s === kronosSymbol ? '#0d1117' : '#e0e0e0', border: 'none', borderRadius: '3px', padding: '3px 8px', cursor: 'pointer', fontSize: 'var(--mc-font-label)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{s}</button>
              ))}
            </div>
          )}
          {kronosError && <div style={{ color: '#ff9800', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px', padding: '6px 8px', background: '#ff980015', borderLeft: '2px solid #ff9800', borderRadius: '3px' }}>{kronosError}</div>}
          {kronosLoading && !kronosError && <div style={{ color: '#4fc3f7', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', marginBottom: '8px' }}>Loading {kronosSymbol}...</div>}
          {kronosForecast ? (
            <div>
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '8px', marginBottom: '12px' }}>
                <div style={{ background: '#0d1117', borderRadius: '6px', padding: '10px', textAlign: 'center' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>NOW</div>
                  <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>${kronosForecast.current_price?.toLocaleString()}</div>
                </div>
                <div style={{ background: '#0d1117', borderRadius: '6px', padding: '10px', textAlign: 'center' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>24H FORECAST</div>
                  <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: kronosForecast.summary?.direction === 'BULLISH' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>${kronosForecast.summary?.price_in_24h?.toLocaleString()}</div>
                </div>
                <div style={{ background: '#0d1117', borderRadius: '6px', padding: '10px', textAlign: 'center' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>DIRECTION</div>
                  <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: kronosForecast.summary?.direction === 'BULLISH' ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{kronosForecast.summary?.direction}</div>
                </div>
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 12px', background: '#0d1117', borderRadius: '6px' }}>
                <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Change: <span style={{ color: kronosForecast.summary?.change_pct >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 700 }}>{kronosForecast.summary?.change_pct >= 0 ? '+' : ''}{kronosForecast.summary?.change_pct?.toFixed(2)}%</span></span>
                <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>Range: <span style={{ color: '#ff9800' }}>${kronosForecast.summary?.predicted_low?.toLocaleString()} — ${kronosForecast.summary?.predicted_high?.toLocaleString()}</span></span>
              </div>
            </div>
          ) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '30px' }}>Awaiting Kronos forecast...</div>}
        </div>
      </div>

      {/* HUGE FLOW + MARKET STATS */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '12px' }}>
        <div className="cc" style={{ padding: '16px', maxHeight: '350px', overflowY: 'auto' }}>
          <div className="lbl" style={{ marginBottom: '10px', display: 'flex', justifyContent: 'space-between' }}>
            <span style={{ color: '#e040fb' }}>HUGE FLOW ($1M+)</span>
            <span style={{ color: '#e040fb' }}>{hugeAlerts.length}</span>
          </div>
          {hugeAlerts.length > 0 ? hugeAlerts.slice(0, 12).map((a: any, i: number) => {
            const v = a.totalFlowValue || 0;
            const valColor = v >= 5000000 ? '#e040fb' : v >= 2000000 ? '#ffd600' : '#ff9800';
            const fmtV = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(2) + 'M' : '$' + (n/1000).toFixed(0) + 'K';
            const expStr = a.Expiry ? new Date(a.Expiry).toLocaleDateString('en-US', { month: 'numeric', day: 'numeric' }) : '';
            const dirColor = a.isBullish ? '#66bb6a' : '#ef5350';
            return (
              <div key={i} onClick={() => setSelectedItem({ type: 'huge', data: a })} style={{ cursor: 'pointer', display: 'grid', gridTemplateColumns: '8px 60px 50px 60px 1fr 70px', gap: '6px', alignItems: 'center', padding: '5px 8px', borderBottom: '1px solid #1a3a4a', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                <span style={{ color: dirColor, fontWeight: 700 }}>{a.isBullish ? '▲' : '▼'}</span>
                <span style={{ color: '#e0e0e0', fontWeight: 700 }}>{a.Symbol}</span>
                <span style={{ color: a.OptionType === 'CALL' ? '#66bb6a' : '#ef5350' }}>{a.OptionType === 'CALL' ? 'C' : 'P'} ${a.Strike}</span>
                <span style={{ color: '#90a4ae' }}>{expStr}</span>
                <span style={{ color: '#607d8b', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{(a.SWEEPS||0)>0?(a.SWEEPS+'sw '):''}{(a.BLOCKS||0)>0?(a.BLOCKS+'bk '):''}{(a.DTE!=null)?(a.DTE+'d'):''}</span>
                <span style={{ color: valColor, fontWeight: 700, textAlign: 'right' }}>{fmtV(v)}</span>
              </div>
            );
          }) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '30px' }}>No huge-flow alerts today</div>}
        </div>

        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '10px' }}>FLOW SUMMARY</div>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
            {[
              { l: 'TOTAL FLOWS', v: (((unusualFlows as any)?._allFlows?.length) || unusualFlows.length || 0).toString(), c: '#4fc3f7' },
              { l: 'UNUSUAL', v: ((((unusualFlows as any)?._allAlerts || []) as any[]).filter((a: any) => (a.AlertType || '').toLowerCase().includes('unusual')).length).toString(), c: '#ffd600' },
              { l: '$1M+ ALERTS', v: hugeAlerts.length.toString(), c: '#e040fb' },
              { l: '$500K+ ALERTS', v: ((((unusualFlows as any)?._allAlerts || []) as any[]).filter((a: any) => (a.totalFlowValue || 0) >= 500000).length).toString(), c: '#ff9800' },
            ].map((m, i) => (
              <div key={i} style={{ background: '#0d1117', borderRadius: '6px', padding: '12px', textAlign: 'center' }}>
                <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>{m.l}</div>
                <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: m.c, fontFamily: 'var(--font-mc-mono)' }}>{m.v}</div>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* MARKET NEWS + ACTIVE POSITIONS */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px' }}>
        <div className="cc" style={{ padding: '16px', maxHeight: '350px', overflowY: 'auto' }}>
          <div className="lbl" style={{ marginBottom: '10px' }}>MARKET NEWS</div>
          {news.length > 0 ? news.slice(0, 12).map((n: any, i: number) => (
            <a key={i} href={n.url} target="_blank" rel="noopener noreferrer" className="news-row" style={{ display: 'flex', gap: '8px', padding: '6px 4px', borderBottom: '1px solid #1a3a4a', textDecoration: 'none', cursor: 'pointer' }}>
              <span style={{ minWidth: '42px', fontSize: 'var(--mc-font-label)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{n.time}</span>
              <span style={{ flex: 1, fontSize: 'var(--mc-font-label)', color: '#b0bec5', fontFamily: 'var(--font-mc-mono)' }}>{n.headline}</span>
              <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', minWidth: '50px', textAlign: 'right' }}>{n.source}</span>
            </a>
          )) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-label)' }}>Loading...</div>}
        </div>

        <div className="cc" style={{ padding: '16px', maxHeight: '350px', overflowY: 'auto' }}>
          <div className="lbl" style={{ marginBottom: '10px' }}>POSITIONS & INSIDER ACTIVITY</div>
          {positions.length > 0 ? positions.map((p: any, i: number) => {
            const pnl = parseFloat(p.unrealized_pl || '0');
            const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
            const g = pnl >= 0;
            return (
              <div key={i} onClick={() => setDrawerTicker(parseOCC(p.symbol))} style={{ cursor: 'pointer', display: 'flex', justifyContent: 'space-between', padding: '8px 10px', background: '#0d1117', borderRadius: '6px', border: '1px solid ' + (g ? '#66bb6a22' : '#ef535022'), marginBottom: '6px' }}>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{parseOCC(p.symbol)}{p.account ? ' ' + p.account : ''}</div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64' }}>{p.qty} @ ${fmt(parseFloat(p.avg_entry_price || '0'))}</div>
                </div>
                <div style={{ textAlign: 'right' }}>
                  <div style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: g ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{g ? '+' : ''}{fmt(pnlPct, 1)}%</div>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: g ? '#66bb6a' : '#ef5350' }}>{g ? '+' : ''}${fmt(pnl)}</div>
                </div>
              </div>
            );
          }) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', marginBottom: '12px' }}>No open positions</div>}
          <div className="lbl" style={{ marginTop: '12px', marginBottom: '8px' }}>INSIDER SENTIMENT</div>
          {watchlist.map(sym => {
            const ins = intel[sym]?.insider;
            if (!ins) return null;
            return (
              <div key={sym} style={{ display: 'flex', justifyContent: 'space-between', padding: '4px 8px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)' }}>
                <span style={{ color: '#4fc3f7' }}>{sym}</span>
                <span style={{ color: ins.direction === 'BUYING' ? '#66bb6a' : '#ef5350' }}>{ins.direction} (MSPR: {ins.mspr})</span>
              </div>
            );
          })}
        </div>
      {/* DETAIL SIDEBAR - mirrors Options page pattern */}
      {selectedItem && (
        <div style={{
          position: 'fixed', top: 0, right: 0, height: '100vh', width: '420px',
          background: '#0a1929', borderLeft: '2px solid #4fc3f7',
          boxShadow: '-8px 0 24px rgba(0, 0, 0, 0.4)',
          zIndex: 9999, overflowY: 'auto', padding: '20px',
          fontFamily: 'var(--font-mc-mono)', color: '#e0e0e0',
        }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px', paddingBottom: '12px', borderBottom: '1px solid #1a3a4a' }}>
            <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#4fc3f7', letterSpacing: '1px' }}>
              {selectedItem.type === 'alert' ? 'FLOW ALERT' : selectedItem.type === 'huge' ? 'HUGE FLOW' : selectedItem.type === 'position' ? 'POSITION' : 'DETAIL'}
            </span>
            <button onClick={() => setSelectedItem(null)} style={{ background: '#1a3a4a', color: '#e0e0e0', border: 'none', borderRadius: '4px', width: '28px', height: '28px', cursor: 'pointer', fontSize: '16px', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>×</button>
          </div>
          {(selectedItem.type === 'alert' || selectedItem.type === 'huge') && (() => {
            const a = selectedItem.data;
            const v = a.totalFlowValue || 0;
            const fmtV = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(2) + 'M' : '$' + (n/1000).toFixed(0) + 'K';
            const expStr = a.Expiry ? new Date(a.Expiry).toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' }) : '—';
            return (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
                  <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px', borderLeft: '3px solid ' + (a.isBullish ? '#66bb6a' : '#ef5350') }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', marginBottom: '4px' }}>SYMBOL</div>
                    <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: '#e0e0e0' }}>{a.Symbol}</div>
                  </div>
                  <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', marginBottom: '4px' }}>SIDE</div>
                    <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: a.OptionType === 'CALL' ? '#66bb6a' : '#ef5350' }}>{a.OptionType} ${a.Strike}</div>
                  </div>
                </div>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', marginBottom: '4px' }}>TOTAL FLOW VALUE</div>
                  <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 700, color: v >= 1000000 ? '#e040fb' : v >= 500000 ? '#ff9800' : '#4fc3f7' }}>{fmtV(v)}</div>
                </div>
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '8px' }}>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px', textAlign: 'center' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>VOLUME</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0' }}>{a.Volume?.toLocaleString() || '—'}</div>
                  </div>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px', textAlign: 'center' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>OI</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0' }}>{a.OI?.toLocaleString() || '—'}</div>
                  </div>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px', textAlign: 'center' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>VOL/OI</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#ffd600' }}>{a.OI > 0 ? (a.Volume / a.OI).toFixed(1) + 'x' : '—'}</div>
                  </div>
                </div>
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>SWEEPS / BLOCKS</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#ff9800' }}>{(a.SWEEPS || 0)}sw / {(a.BLOCKS || 0)}bk</div>
                  </div>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>EXPIRY ({a.DTE != null ? a.DTE + 'd' : '?'})</div>
                    <div style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: '#90a4ae' }}>{expStr}</div>
                  </div>
                </div>
                <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>SPOT / ALERT PRICE</div>
                  <div style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: '#e0e0e0' }}>${a.Spot?.toFixed(2) || '—'} / ${a.AlertPrice?.toFixed(2) || '—'}</div>
                </div>
                <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>ALERT TYPE</div>
                  <div style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: '#4fc3f7' }}>{a.AlertType || '—'}</div>
                </div>
                <button onClick={() => { setDrawerTicker(a.Symbol); setSelectedItem(null); }} style={{ background: 'linear-gradient(90deg, #4fc3f7 0%, #66bb6a 100%)', color: '#0d1117', border: 'none', borderRadius: '6px', padding: '12px', cursor: 'pointer', fontSize: 'var(--mc-font-md)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>OPEN FULL CHART + TA →</button>
                {a.OptionSymbol && (
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>OCC SYMBOL</div>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#e0e0e0', wordBreak: 'break-all' }}>{a.OptionSymbol}</div>
                  </div>
                )}
              </div>
            );
          })()}
          {selectedItem.type === 'position' && (() => {
            const p = selectedItem.data;
            const pnl = parseFloat(p.unrealized_pl || '0');
            const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
            return (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>SYMBOL</div>
                  <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: '#4fc3f7' }}>{p.symbol}</div>
                </div>
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>QTY</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0' }}>{p.qty}</div>
                  </div>
                  <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                    <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>AVG ENTRY</div>
                    <div style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: '#e0e0e0' }}>${parseFloat(p.avg_entry_price || '0').toFixed(2)}</div>
                  </div>
                </div>
                <div style={{ background: '#0d1117', padding: '12px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>UNREALIZED P&L</div>
                  <div style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: pnl >= 0 ? '#66bb6a' : '#ef5350' }}>{pnl >= 0 ? '+' : ''}${Math.abs(pnl).toFixed(2)} ({pnl >= 0 ? '+' : ''}{pnlPct.toFixed(2)}%)</div>
                </div>
                <div style={{ background: '#0d1117', padding: '10px', borderRadius: '6px' }}>
                  <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>ACCOUNT</div>
                  <div style={{ fontSize: 'var(--mc-font-md)', fontWeight: 700, color: '#ffd600' }}>{p.account || '—'}</div>
                </div>
              </div>
            );
          })()}
        </div>
      )}
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />


      </div>
    </div>
  );
}
