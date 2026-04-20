'use client';
import { useEffect, useState } from 'react';

export function CommandCenterPage() {
  const [portfolio, setPortfolio] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [activity, setActivity] = useState<any[]>([]);
  const [rhPositions, setRhPositions] = useState<any[]>([]);
  const [rhBalance, setRhBalance] = useState(0);
  const [dashData, setDashData] = useState<any>(null);
  const [loading, setLoading] = useState(true);
  const [unusualFlows, setUnusualFlows] = useState<any[]>([]);
  const [kronosForecast, setKronosForecast] = useState<any>(null);

  const fetchData = async () => {
    try {
      const [pRes, sigRes, rRes, actRes] = await Promise.all([
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/activity').then(r => r.json()).catch(() => []),
      ]);
      setPortfolio(pRes); setSignals(sigRes); setRegime(rRes);
      const acts = Array.isArray(actRes) ? actRes : actRes?.entries || [];
      setActivity(acts.slice(0, 10));
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  };

  useEffect(() => {
    fetchData();
    fetch('/api/options-flow').then(r => r.ok ? r.json() : { flows: [] }).then(d => {
      const flows = d.flows || [];
      const unusual = flows.filter((f: any) => f.Volume > f.OI && f.OI >= 0).sort((a: any, b: any) => b.Time - a.Time);
      setUnusualFlows(unusual.slice(0, 10));
    }).catch(() => {});
    fetch('/api/kronos-forecast').then(r => r.ok ? r.json() : null).then(d => { if (d) setKronosForecast(d); }).catch(() => {});
    fetch('/api/options-flow').then(r => r.ok ? r.json() : { flows: [] }).then(d => {
      const flows = d.flows || [];
      setUnusualFlows(flows.filter((f: any) => f.Volume > f.OI && f.OI >= 0).sort((a: any, b: any) => b.Time - a.Time).slice(0, 10));
    }).catch(() => {});
    fetch('/api/kronos-forecast').then(r => r.ok ? r.json() : null).then(d => { if (d) setKronosForecast(d); }).catch(() => {});
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
    }).catch(() => {});
    fetch('/api/directives?file=dashboard_data.json').then(r => r.ok ? r.json() : null).then(d => { if (d) setDashData(d); }).catch(() => {});
    const iv = setInterval(fetchData, 10000);
    return () => clearInterval(iv);
  }, []);

  const equity = parseFloat(portfolio?.equity || portfolio?.balance || '0');
  const lastEq = parseFloat(portfolio?.last_equity || '0');
  const dailyPct = lastEq ? ((equity - lastEq) / lastEq * 100) : 0;
  const totalReturn = ((equity - 100000) / 100000 * 100);
  const positions = portfolio?.positions || [];
  const btcSignal = signals?.BTCUSD || {};
  const regimeStr = regime?.overall_regime || regime?.regime || 'UNKNOWN';
  const bias = regime?.direction_bias || regime?.bias || '';
  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });
  const quotes = dashData?.quotes || {};
  const intel = dashData?.intel || {};
  const news = dashData?.news || [];
  const SYMS = ['AAPL', 'NVDA', 'TSLA', 'MU', 'LLY'];

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
            { sym: 'ROBINHOOD', val: rhBalance > 0 ? '$' + fmt(rhBalance) : 'N/A', chg: 0, color: '#4fc3f7' },
            { sym: 'RETURN', val: (totalReturn >= 0 ? '+' : '') + fmt(totalReturn, 1) + '%', chg: totalReturn, color: totalReturn >= 0 ? '#66bb6a' : '#ef5350' },
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

      {/* METRIC CARDS */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '10px', marginBottom: '12px' }}>
        {[
          { l: 'ALPACA EQUITY', v: '$' + fmt(equity), s: (dailyPct >= 0 ? '+' : '') + fmt(dailyPct) + '% today', c: '#4fc3f7' },
          { l: 'TOTAL RETURN', v: (totalReturn >= 0 ? '+' : '') + fmt(totalReturn, 1) + '%', s: 'From $100K', c: totalReturn >= 0 ? '#66bb6a' : '#ef5350' },
          { l: 'POSITIONS', v: '' + positions.length, s: positions.map((p: any) => p.symbol).join(' \u00b7 ') || 'None', c: '#4fc3f7' },
          { l: 'SUPERTREND', v: btcSignal.direction || 'N/A', s: btcSignal.entry_price ? '$' + Number(btcSignal.entry_price).toLocaleString() : '', c: btcSignal.direction === 'LONG' ? '#66bb6a' : '#ef5350' },
          { l: 'REGIME', v: regimeStr.replace(/_/g, ' '), s: 'Bias: ' + bias, c: bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800' },
        ].map((m, i) => (
          <div key={i} className="cc" style={{ padding: '16px 18px' }}>
            <div className="lbl">{m.l}</div>
            <div style={{ fontSize: 'var(--mc-font-3xl)', fontWeight: 700, fontFamily: 'var(--font-mc-mono)', color: m.c }}>{m.v}</div>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', marginTop: '4px' }}>{m.s}</div>
          </div>
        ))}
      </div>

      {/* WATCHLIST CARDS + PIPELINE */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px', marginBottom: '12px' }}>

        {/* WATCHLIST QUOTE CARDS */}
        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '12px' }}>WATCHLIST</div>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
            {SYMS.map(sym => {
              const q = quotes[sym];
              const inf = intel[sym];
              const a = inf?.analyst;
              const e = inf?.earnings;
              const ins = inf?.insider;
              const chg = q?.change_p || 0;
              const green = chg >= 0;
              return (
                <div key={sym} style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '8px', padding: '12px' }}>
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

        {/* LIVE PIPELINE */}
        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '12px', display: 'flex', justifyContent: 'space-between' }}>
            <span><span style={{ display: 'flex', alignItems: 'center', gap: '4px' }}><span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#ef5350', animation: 'blink 1.4s infinite', display: 'inline-block' }} />LIVE PIPELINE</span></span>
            <span style={{ color: '#455a64' }}>{activity.length} events</span>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: '3px', maxHeight: '380px', overflowY: 'auto' }}>
            {activity.length === 0 ? (
              <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '40px' }}>Awaiting pipeline data...</div>
            ) : activity.map((entry, i) => (
              <div key={i} style={{ display: 'flex', gap: '10px', padding: '8px 12px', background: i === 0 ? '#0d1929' : '#0d1117', borderLeft: '2px solid #1a3a4a', borderRadius: '3px', opacity: 1 - (i * 0.05) }}>
                <div style={{ minWidth: '65px', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontWeight: 600, fontSize: 'var(--mc-font-label)' }}>{(entry.agent || 'SYS').toUpperCase()}</div>
                <div style={{ flex: 1, color: '#b0bec5', fontSize: 'var(--mc-font-label)', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{entry.action}</div>
              </div>
            ))}
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
            <span style={{ color: '#ce93d8' }}>KRONOS BTC FORECAST</span>
            <span style={{ color: '#607d8b' }}>{kronosForecast?.generated_at || ''}</span>
          </div>
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
            <span style={{ color: '#e040fb' }}>{unusualFlows.filter((f: any) => f.Value >= 1000000).length}</span>
          </div>
          {unusualFlows.filter((f: any) => f.Value >= 1000000).length > 0 ? unusualFlows.filter((f: any) => f.Value >= 1000000).map((f: any, i: number) => {
            const isCall = f.OptionType === 'CALL';
            const isAsk = f.BidAskType === 'A' || f.BidAskType === 'AA';
            const bull = (isCall && isAsk) || (!isCall && !isAsk);
            const sc = bull ? '#66bb6a' : '#ef5350';
            const fv = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(1) + 'M' : '$' + (n/1000).toFixed(0) + 'K';
            const ta = (ts: number) => { const m = Math.floor((Date.now() - ts) / 60000); return m < 1 ? 'now' : m < 60 ? m + 'm' : m < 1440 ? Math.floor(m/60) + 'h' : Math.floor(m/1440) + 'd'; };
            return (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '8px 12px', borderBottom: '1px solid #0d1117', borderLeft: '3px solid #e040fb', background: '#e040fb08' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                  <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: sc, boxShadow: '0 0 4px ' + sc, display: 'inline-block' }} />
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{ta(f.Time)}</span>
                  <span style={{ fontSize: 'var(--mc-font-sm)', color: sc, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{f.Symbol}</span>
                  <span style={{ fontSize: 'var(--mc-font-xs)', color: sc }}>{f.OptionType?.slice(0,1)} ${f.Strike}</span>
                </div>
                <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                  <span style={{ fontSize: 'var(--mc-font-sm)', color: '#e040fb', fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{fv(f.Value)}</span>
                  <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 700, padding: '1px 5px', borderRadius: '3px', background: f.BlockType === 'SWEEP' ? '#ff980022' : '#4fc3f722', color: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7' }}>{f.BlockType === 'SWEEP' ? 'SWP' : 'BLK'}</span>
                </div>
              </div>
            );
          }) : <div style={{ color: '#455a64', fontSize: 'var(--mc-font-badge)', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '30px' }}>No $1M+ flows today</div>}
        </div>

        <div className="cc" style={{ padding: '16px' }}>
          <div className="lbl" style={{ marginBottom: '10px' }}>FLOW SUMMARY</div>
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px' }}>
            {[
              { l: 'TOTAL FLOWS', v: unusualFlows.length.toString(), c: '#4fc3f7' },
              { l: 'UNUSUAL', v: unusualFlows.filter((f: any) => f.Volume > f.OI).length.toString(), c: '#ffd600' },
              { l: '$1M+ FLOWS', v: unusualFlows.filter((f: any) => f.Value >= 1000000).length.toString(), c: '#e040fb' },
              { l: '$500K+ FLOWS', v: unusualFlows.filter((f: any) => f.Value >= 500000).length.toString(), c: '#ff9800' },
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
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 10px', background: '#0d1117', borderRadius: '6px', border: '1px solid ' + (g ? '#66bb6a22' : '#ef535022'), marginBottom: '6px' }}>
                <div>
                  <div style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{p.symbol}</div>
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
          {SYMS.map(sym => {
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
      </div>
    </div>
  );
}
