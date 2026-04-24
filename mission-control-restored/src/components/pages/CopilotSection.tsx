'use client';
import { useEffect, useState } from 'react';

function fmtTimeAgo(iso: string) {
  if (!iso) return '—';
  const mins = Math.floor((Date.now() - new Date(iso).getTime()) / 60000);
  if (mins < 1) return 'now';
  if (mins < 60) return `${mins}m ago`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h ago`;
  return `${Math.floor(hrs / 24)}d ago`;
}

// 1. RIGHT NOW
function RightNowBlock() {
  const [data, setData] = useState<any>(null);
  useEffect(() => {
    const fetch2 = () => fetch('/api/live-signals').then(r => r.json()).then(setData).catch(() => {});
    fetch2();
    const t = setInterval(fetch2, 30000);
    return () => clearInterval(t);
  }, []);

  if (!data) return <div className="db-card" style={{ padding: 16 }}><div className="db-label">RIGHT NOW</div><div style={{ color: '#607d8b', fontSize: 12, marginTop: 8 }}>Loading…</div></div>;

  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: 10 }}>
        <div className="db-label">RIGHT NOW — TOP 3 WATCHED</div>
        <div style={{ fontSize: 10, color: '#607d8b' }}>Cycle: {fmtTimeAgo(data.lastCycleTime)}</div>
      </div>
      {data.topWatched?.length === 0 ? (
        <div style={{ color: '#607d8b', fontSize: 12 }}>No whale signals yet</div>
      ) : data.topWatched.map((t: any) => (
        <div key={t.ticker} style={{ padding: '10px 0', borderBottom: '1px solid #1a2a35', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <div>
            <div style={{ fontWeight: 700, fontSize: 14, color: '#e8e8ed', fontFamily: 'var(--font-mc-mono)' }}>{t.ticker}</div>
            <div style={{ fontSize: 11, color: '#8b8b9e' }}>{t.latestTier} · {t.flowCount} flows · score {t.maxScore}</div>
          </div>
          <div style={{ textAlign: 'right', fontSize: 12, color: '#00d2a0', fontFamily: 'var(--font-mc-mono)' }}>{t.latestValue}</div>
        </div>
      ))}
      <div style={{ marginTop: 10, fontSize: 11, color: '#607d8b' }}>
        {data.picksExecuted?.length > 0 ? `✓ Boba executed ${data.picksExecuted.length} last cycle · ${data.passedOn?.length} passed` : `${data.passedOn?.length || 0} passed last cycle`}
      </div>
    </div>
  );
}

// 2. KRONOS QUERY
function KronosBlock() {
  const [ticker, setTicker] = useState('');
  const [result, setResult] = useState<any>(null);
  const [running, setRunning] = useState(false);
  const [error, setError] = useState('');

  const lookup = async (t: string) => {
    setError('');
    setResult(null);
    if (!t) return;
    try {
      const r = await fetch(`/api/kronos-forecast?ticker=${encodeURIComponent(t)}`);
      if (r.ok) setResult(await r.json());
      else setError((await r.json()).error || 'not found');
    } catch (e: any) { setError(e.message); }
  };

  const runLive = async () => {
    if (!ticker) return;
    setRunning(true); setError(''); setResult(null);
    try {
      const r = await fetch('/api/kronos-forecast', { method: 'POST', headers: { 'content-type': 'application/json' }, body: JSON.stringify({ ticker: ticker.toUpperCase() }) });
      const j = await r.json();
      if (!r.ok) setError(j.error || 'failed');
      else { await new Promise(r => setTimeout(r, 1500)); await lookup(ticker.toUpperCase()); }
    } catch (e: any) { setError(e.message); }
    setRunning(false);
  };

  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div className="db-label" style={{ marginBottom: 10 }}>KRONOS FORECAST</div>
      <div style={{ display: 'flex', gap: 6, marginBottom: 10 }}>
        <input
          value={ticker}
          onChange={e => setTicker(e.target.value.toUpperCase())}
          onKeyDown={e => e.key === 'Enter' && lookup(ticker)}
          placeholder="NVDA"
          maxLength={8}
          style={{ flex: 1, padding: '6px 10px', fontSize: 13, background: '#0a1929', color: '#e8e8ed', border: '1px solid #1a3a4a', borderRadius: 4, fontFamily: 'var(--font-mc-mono)' }}
        />
        <button onClick={() => lookup(ticker)} style={{ padding: '6px 10px', fontSize: 11, background: '#1a3a4a', color: '#e8e8ed', border: 'none', borderRadius: 4, cursor: 'pointer' }}>CACHED</button>
        <button onClick={runLive} disabled={running} style={{ padding: '6px 10px', fontSize: 11, background: running ? '#2a4a5a' : '#00d2a0', color: running ? '#607d8b' : '#0a1929', border: 'none', borderRadius: 4, cursor: running ? 'wait' : 'pointer', fontWeight: 700 }}>{running ? 'RUNNING…' : 'LIVE'}</button>
      </div>
      {error && <div style={{ color: '#ef5350', fontSize: 11 }}>{error}</div>}
      {result && (
        <div style={{ fontSize: 12, color: '#e8e8ed', fontFamily: 'var(--font-mc-mono)', lineHeight: 1.6 }}>
          <div><span style={{ color: '#607d8b' }}>Direction:</span> <b style={{ color: result.forecast_24h_direction === 'bullish' ? '#00d2a0' : result.forecast_24h_direction === 'bearish' ? '#ef5350' : '#ffa502' }}>{String(result.forecast_24h_direction || '—').toUpperCase()}</b></div>
          <div><span style={{ color: '#607d8b' }}>Current:</span> ${result.current_price?.toFixed(2) ?? '—'}</div>
          <div><span style={{ color: '#607d8b' }}>24h target:</span> ${result.forecast_24h_target?.toFixed(2) ?? '—'}</div>
          <div><span style={{ color: '#607d8b' }}>Confidence:</span> {result.forecast_24h_confidence || '—'}</div>
          <div style={{ fontSize: 10, color: '#607d8b', marginTop: 6 }}>Updated: {fmtTimeAgo(result._file_mtime || result.generated_at)}</div>
        </div>
      )}
    </div>
  );
}

// 3. PASSED ON
function PassedOnBlock() {
  const [data, setData] = useState<any>(null);
  useEffect(() => {
    const f = () => fetch('/api/live-signals').then(r => r.json()).then(setData).catch(() => {});
    f();
    const t = setInterval(f, 120000);
    return () => clearInterval(t);
  }, []);

  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div className="db-label" style={{ marginBottom: 10 }}>PASSED ON — LAST CYCLE</div>
      {!data?.passedOn?.length ? (
        <div style={{ color: '#607d8b', fontSize: 12 }}>No rejections last cycle</div>
      ) : (
        <div style={{ maxHeight: 180, overflowY: 'auto' }}>
          {data.passedOn.map((p: any, i: number) => (
            <div key={i} style={{ padding: '8px 0', borderBottom: '1px solid #1a2a35' }}>
              <div style={{ fontSize: 12, fontWeight: 700, color: '#ffa502', fontFamily: 'var(--font-mc-mono)' }}>{p.ticker}</div>
              <div style={{ fontSize: 11, color: '#8b8b9e', marginTop: 2 }}>{p.reason}</div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

// 4. PRE-TRADE CALCULATOR
function PreTradeBlock() {
  const [ticker, setTicker] = useState('');
  const [data, setData] = useState<any>(null);
  const [loading, setLoading] = useState(false);

  const lookup = async () => {
    if (!ticker) return;
    setLoading(true);
    const [ls, kn, jr] = await Promise.all([
      fetch('/api/live-signals').then(r => r.json()).catch(() => null),
      fetch(`/api/kronos-forecast?ticker=${ticker}`).then(r => r.ok ? r.json() : null).catch(() => null),
      fetch('/api/boba-journal').then(r => r.ok ? r.json() : null).catch(() => null),
    ]);
    const matchingFlows = (ls?.recentSignals || []).filter((s: any) => s.ticker === ticker).slice(0, 3);
    setData({ flows: matchingFlows, kronos: kn, journal: jr });
    setLoading(false);
  };

  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div className="db-label" style={{ marginBottom: 10 }}>PRE-TRADE CALCULATOR</div>
      <div style={{ display: 'flex', gap: 6, marginBottom: 10 }}>
        <input
          value={ticker}
          onChange={e => setTicker(e.target.value.toUpperCase())}
          onKeyDown={e => e.key === 'Enter' && lookup()}
          placeholder="Ticker…"
          maxLength={8}
          style={{ flex: 1, padding: '6px 10px', fontSize: 13, background: '#0a1929', color: '#e8e8ed', border: '1px solid #1a3a4a', borderRadius: 4, fontFamily: 'var(--font-mc-mono)' }}
        />
        <button onClick={lookup} disabled={loading} style={{ padding: '6px 12px', fontSize: 11, background: '#1a3a4a', color: '#e8e8ed', border: 'none', borderRadius: 4, cursor: 'pointer' }}>ANALYZE</button>
      </div>
      {data && (
        <div style={{ fontSize: 11, color: '#e8e8ed', fontFamily: 'var(--font-mc-mono)', lineHeight: 1.6 }}>
          <div style={{ color: '#607d8b', fontSize: 10, marginBottom: 4 }}>WHALE FLOW ({data.flows.length})</div>
          {data.flows.length === 0 && <div style={{ color: '#607d8b', fontSize: 11, marginBottom: 6 }}>No recent flow on {ticker}</div>}
          {data.flows.map((f: any, i: number) => (
            <div key={i} style={{ fontSize: 11, color: '#e8e8ed', marginBottom: 2 }}>{f.option_type} ${f.strike} · {f.flow_value_raw} · score {f.score}</div>
          ))}
          <div style={{ color: '#607d8b', fontSize: 10, marginTop: 8, marginBottom: 4 }}>KRONOS</div>
          {data.kronos ? (
            <div>{String(data.kronos.forecast_24h_direction || '').toUpperCase()} → ${data.kronos.forecast_24h_target?.toFixed(2) ?? '—'}</div>
          ) : <div style={{ color: '#607d8b' }}>No cached forecast</div>}
        </div>
      )}
    </div>
  );
}

// 5. WHY DID I (NOT) TAKE THIS?
function WhyTakeBlock() {
  const [ticker, setTicker] = useState('');
  const [hit, setHit] = useState<any>(null);
  const [checked, setChecked] = useState(false);

  const check = async () => {
    if (!ticker) return;
    setChecked(false);
    const j = await fetch('/api/boba-journal').then(r => r.json()).catch(() => null);
    const entries = j?.entries || [];
    for (const e of entries) {
      const picks = e.raw?.raw_response?.picks || [];
      const passed = e.raw?.raw_response?.passed_on || [];
      const tookIt = picks.find((p: any) => p.ticker === ticker);
      const passedIt = passed.find((p: any) => p.ticker === ticker);
      if (tookIt || passedIt) {
        setHit({ took: !!tookIt, reason: tookIt?.reasoning || passedIt?.reason || '', when: e.raw?.cycle_time });
        setChecked(true);
        return;
      }
    }
    setHit(null);
    setChecked(true);
  };

  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div className="db-label" style={{ marginBottom: 10 }}>WHY DID I (NOT) TAKE THIS?</div>
      <div style={{ display: 'flex', gap: 6, marginBottom: 10 }}>
        <input
          value={ticker}
          onChange={e => setTicker(e.target.value.toUpperCase())}
          onKeyDown={e => e.key === 'Enter' && check()}
          placeholder="Ticker…"
          maxLength={8}
          style={{ flex: 1, padding: '6px 10px', fontSize: 13, background: '#0a1929', color: '#e8e8ed', border: '1px solid #1a3a4a', borderRadius: 4, fontFamily: 'var(--font-mc-mono)' }}
        />
        <button onClick={check} style={{ padding: '6px 12px', fontSize: 11, background: '#1a3a4a', color: '#e8e8ed', border: 'none', borderRadius: 4, cursor: 'pointer' }}>CHECK</button>
      </div>
      {checked && !hit && <div style={{ color: '#607d8b', fontSize: 11 }}>{ticker} not seen in recent cycles</div>}
      {hit && (
        <div style={{ fontSize: 11, color: '#e8e8ed', lineHeight: 1.5 }}>
          <div style={{ fontSize: 11, fontWeight: 700, color: hit.took ? '#00d2a0' : '#ffa502', marginBottom: 6 }}>
            {hit.took ? '✓ TOOK IT' : '⏸ PASSED'} · {fmtTimeAgo(hit.when)}
          </div>
          <div style={{ fontSize: 11, color: '#8b8b9e', maxHeight: 140, overflowY: 'auto' }}>{hit.reason}</div>
        </div>
      )}
    </div>
  );
}

// 6. PATTERN LIBRARY
function PatternLibraryBlock() {
  const PATTERNS_TAKE = [
    'Whale flow $1M+ + Kronos AGREES',
    'Vol/OI > 5x + institutional tier',
    'DTE 10-30 + high conviction',
    'Sector momentum (multiple tickers same direction)',
  ];
  const PATTERNS_AVOID = [
    'DTE < 5 (gamma risk)',
    'Vol/OI > 200x on LEAPs (index arb noise)',
    'Kronos CONFLICTS with option direction',
    'Single whale source, no confirmation',
  ];
  return (
    <div className="db-card" style={{ padding: 16, minHeight: 240 }}>
      <div className="db-label" style={{ marginBottom: 10 }}>PATTERN LIBRARY</div>
      <div style={{ fontSize: 10, color: '#00d2a0', marginBottom: 4 }}>✓ BOBA TAKES</div>
      {PATTERNS_TAKE.map((p, i) => (
        <div key={i} style={{ fontSize: 11, color: '#e8e8ed', marginBottom: 3 }}>• {p}</div>
      ))}
      <div style={{ fontSize: 10, color: '#ef5350', marginBottom: 4, marginTop: 10 }}>✗ BOBA AVOIDS</div>
      {PATTERNS_AVOID.map((p, i) => (
        <div key={i} style={{ fontSize: 11, color: '#8b8b9e', marginBottom: 3 }}>• {p}</div>
      ))}
    </div>
  );
}

export function CopilotSection() {
  return (
    <div style={{ marginTop: 24 }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 14, padding: '0 4px' }}>
        <div style={{ height: 1, flex: 1, background: 'linear-gradient(90deg, transparent, #1a3a4a, transparent)' }} />
        <div style={{ fontSize: 11, color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: 2 }}>COPILOT</div>
        <div style={{ height: 1, flex: 1, background: 'linear-gradient(90deg, transparent, #1a3a4a, transparent)' }} />
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(320px, 1fr))', gap: 14 }}>
        <RightNowBlock />
        <KronosBlock />
        <PassedOnBlock />
        <PreTradeBlock />
        <WhyTakeBlock />
        <PatternLibraryBlock />
      </div>
    </div>
  );
}
