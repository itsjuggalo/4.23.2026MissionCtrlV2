'use client';
import { useLiveStream } from '@/hooks/useLiveStream';
import { LiveIndicator } from '@/components/ui/LiveIndicator';
import { useEffect, useState } from 'react';

// ============================================================================
// TERRAN COMMAND CENTER — Operations War Room
// Real-time agent fleet status, pipeline flow, system vitals
// ============================================================================

export function CommandCenterPage() {
  const [agents, setAgents] = useState<any[]>([]);
  const [stats, setStats] = useState<any>(null);
  const [portfolio, setPortfolio] = useState<any>(null);
  const [signals, setSignals] = useState<any>(null);
  const [regime, setRegime] = useState<any>(null);
  const [activity, setActivity] = useState<any[]>([]);
  const live = useLiveStream(true);
  const [loading, setLoading] = useState(true);
  const [tick, setTick] = useState(0);

  const fetchData = async () => {
    try {
      const [aRes, sRes, pRes, sigRes, rRes, actRes] = await Promise.all([
        fetch('/api/agents').then(r => r.json()).catch(() => []),
        fetch('/api/openclaw-stats').then(r => r.json()).catch(() => null),
        fetch('/api/portfolio').then(r => r.json()).catch(() => null),
        fetch('/api/signals/latest').then(r => r.json()).catch(() => null),
        fetch('/api/regime').then(r => r.json()).catch(() => null),
        fetch('/api/activity').then(r => r.json()).catch(() => []),
      ]);
      setAgents(Array.isArray(aRes) ? aRes : aRes?.agents || []);
      setStats(sRes);
      setPortfolio(pRes);
      setSignals(sigRes);
      setRegime(rRes);
      const acts = Array.isArray(actRes) ? actRes : actRes?.entries || [];
      setActivity(acts.slice(0, 12));
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  };

  useEffect(() => {
    fetchData();
    const data = setInterval(fetchData, 10000);
    const pulse = setInterval(() => setTick(t => t + 1), 1000);
    return () => { clearInterval(data); clearInterval(pulse); };
  }, []);

  const equity = parseFloat(portfolio?.equity || portfolio?.balance || '0');
  const lastEq = parseFloat(portfolio?.last_equity || '0');
  const dailyPct = lastEq ? ((equity - lastEq) / lastEq * 100) : 0;
  const totalReturn = ((equity - 100000) / 100000 * 100);
  const positions = portfolio?.positions || [];
  const btcSignal = signals?.BTCUSD || {};
  const regimeStr = regime?.overall_regime || regime?.regime || 'UNKNOWN';
  const bias = regime?.direction_bias || regime?.bias || '';
  const onlineCount = agents.filter(a => a.status === 'online' || a.status === 'active').length;

  const AGENT_COLORS: Record<string, string> = {
    'boba': '#4fc3f7', 'jazzyhazzy': '#66bb6a', 'orion': '#ff9800',
    'commander': '#81d4fa', 'default': '#607d8b'
  };

  const fmt = (n: number, d = 2) => n.toLocaleString(undefined, { minimumFractionDigits: d, maximumFractionDigits: d });

  const timeAgo = (s: string) => {
    try {
      const diff = Date.now() - new Date(s).getTime();
      const m = Math.floor(diff / 60000);
      if (m < 1) return 'NOW';
      if (m < 60) return `${m}m`;
      return `${Math.floor(m / 60)}h`;
    } catch { return '?'; }
  };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
      <div style={{ textAlign: 'center' }}>
        <div style={{ fontSize: '14px', animation: 'terran-blink 1s infinite' }}>INITIALIZING COMMAND CENTER...</div>
      </div>
    </div>
  );

  return (
    <div style={{ padding: '20px', maxWidth: '1400px', margin: '0 auto', fontFamily: 'var(--font-mc-sans)' }}>
      <style>{`
        @keyframes terran-scan { 0% { transform: translateY(-100%); } 100% { transform: translateY(100%); } }
        @keyframes terran-pulse { 0%,100% { opacity: 0.4; } 50% { opacity: 1; } }
        @keyframes terran-blink { 0%,100% { opacity: 1; } 50% { opacity: 0.3; } }
        @keyframes marquee { 0% { transform: translateX(0); } 100% { transform: translateX(-50%); } }
        .cc-card { background: #0a1929; border: 1px solid #1a3a4a; border-radius: 8px; overflow: hidden; position: relative; }
        .cc-card::before { content: ''; position: absolute; top: 0; left: 0; right: 0; height: 2px; background: linear-gradient(90deg, transparent, #4fc3f7, transparent); }
        .cc-card-red::before { background: linear-gradient(90deg, transparent, #ef5350, transparent); }
        .cc-card-green::before { background: linear-gradient(90deg, transparent, #66bb6a, transparent); }
        .cc-card-amber::before { background: linear-gradient(90deg, transparent, #ff9800, transparent); }
        .cc-label { font-size: 10px; color: #607d8b; text-transform: uppercase; letter-spacing: 1.5px; font-family: var(--font-mc-mono); margin-bottom: 6px; }
        .cc-value { font-size: 28px; font-weight: 700; font-family: var(--font-mc-mono); }
        .cc-sub { font-size: 11px; color: #455a64; margin-top: 4px; }
      `}</style>

      {/* === HEADER === */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px', padding: '12px 20px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: '12px' }}>
          <div style={{ width: '10px', height: '10px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 8px #66bb6a', animation: 'terran-pulse 2s infinite' }} />
          <span style={{ fontSize: '16px', fontWeight: 700, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', letterSpacing: '2px' }}>COMMAND CENTER</span>
          <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>MISSION CONTROL v2.0</span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: '16px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
          <span>AGENTS: <span style={{ color: onlineCount === agents.length ? '#66bb6a' : '#ff9800' }}>{onlineCount}/{agents.length}</span></span>
          <span>REGIME: <span style={{ color: bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800' }}>{regimeStr}</span></span>
          <span style={{ animation: 'terran-blink 1.4s infinite', color: '#ef5350' }}>● LIVE</span>
        </div>
      </div>

      {/* === TICKER MARQUEE === */}
      <div style={{ overflow: 'hidden', marginBottom: '16px', padding: '8px 0', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '6px' }}>
        <div style={{ display: 'flex', gap: '40px', animation: 'marquee 25s linear infinite', whiteSpace: 'nowrap' }}>
          {[...Array(2)].flatMap(() => [
            { sym: 'PORTFOLIO', val: `$${fmt(equity)}`, chg: dailyPct, color: dailyPct >= 0 ? '#66bb6a' : '#ef5350' },
            { sym: 'BTC SIGNAL', val: btcSignal.direction || 'N/A', chg: 0, color: btcSignal.direction === 'LONG' ? '#66bb6a' : '#ef5350' },
            { sym: 'RETURN', val: `${totalReturn >= 0 ? '+' : ''}${fmt(totalReturn, 1)}%`, chg: totalReturn, color: totalReturn >= 0 ? '#66bb6a' : '#ef5350' },
            ...(positions.map((p: any) => ({
              sym: p.symbol, val: `$${fmt(parseFloat(p.current_price || '0'))}`,
              chg: parseFloat(p.unrealized_plpc || '0') * 100,
              color: parseFloat(p.unrealized_pl || '0') >= 0 ? '#66bb6a' : '#ef5350',
            }))),
          ]).map((item, i) => (
            <span key={i} style={{ fontSize: '12px', fontFamily: 'var(--font-mc-mono)', color: '#607d8b' }}>
              <span style={{ color: '#4fc3f7', marginRight: '6px' }}>{item.sym}</span>
              <span style={{ color: item.color, fontWeight: 600 }}>{item.val}</span>
              {item.chg ? <span style={{ color: item.color, marginLeft: '4px', fontSize: '10px' }}>({item.chg >= 0 ? '+' : ''}{fmt(item.chg, 1)}%)</span> : null}
            </span>
          ))}
        </div>
      </div>

      {/* === METRIC CARDS === */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: '10px', marginBottom: '16px' }}>
        {[
          { label: 'EQUITY', value: `$${fmt(equity)}`, sub: `${dailyPct >= 0 ? '+' : ''}${fmt(dailyPct)}% today`, color: '#4fc3f7', cls: dailyPct >= 0 ? 'cc-card-green' : 'cc-card-red' },
          { label: 'TOTAL RETURN', value: `${totalReturn >= 0 ? '+' : ''}${fmt(totalReturn, 1)}%`, sub: `From $100K`, color: totalReturn >= 0 ? '#66bb6a' : '#ef5350', cls: totalReturn >= 0 ? 'cc-card-green' : 'cc-card-red' },
          { label: 'POSITIONS', value: `${positions.length}`, sub: positions.map((p: any) => p.symbol).join(' · ') || 'None', color: '#4fc3f7', cls: '' },
          { label: 'SUPERTREND', value: btcSignal.direction || 'N/A', sub: btcSignal.entry_price ? `$${Number(btcSignal.entry_price).toLocaleString()}` : '', color: btcSignal.direction === 'LONG' ? '#66bb6a' : '#ef5350', cls: btcSignal.direction === 'LONG' ? 'cc-card-green' : 'cc-card-red' },
          { label: 'REGIME', value: regimeStr.replace(/_/g, ' '), sub: `Bias: ${bias}`, color: bias === 'BULLISH' ? '#66bb6a' : bias === 'BEARISH' ? '#ef5350' : '#ff9800', cls: bias === 'BULLISH' ? 'cc-card-green' : 'cc-card-amber' },
        ].map((m, i) => (
          <div key={i} className={`cc-card ${m.cls}`} style={{ padding: '16px 18px' }}>
            <div className="cc-label">{m.label}</div>
            <div className="cc-value" style={{ color: m.color }}>{m.value}</div>
            <div className="cc-sub">{m.sub}</div>
          </div>
        ))}
      </div>

      {/* === 3 COLUMN LAYOUT === */}
      <div style={{ display: 'grid', gridTemplateColumns: '260px 1fr 300px', gap: '12px' }}>

        {/* LEFT: Agent Fleet */}
        <div className="cc-card" style={{ padding: '16px' }}>
          <div className="cc-label" style={{ marginBottom: '14px', display: 'flex', alignItems: 'center', gap: '6px' }}>
            <span style={{ animation: 'terran-pulse 2s infinite', color: '#4fc3f7' }}>◆</span> AGENT FLEET
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: '8px' }}>
            {agents.length === 0 ? (
              <div style={{ color: '#455a64', fontSize: '12px', fontFamily: 'var(--font-mc-mono)' }}>No agent data</div>
            ) : agents.map((a, i) => {
              const name = (a.name || a.id || '').toLowerCase();
              const color = AGENT_COLORS[name] || AGENT_COLORS.default;
              const isOnline = a.status === 'online' || a.status === 'active';
              return (
                <div key={i} style={{ background: '#0d1117', border: `1px solid ${isOnline ? color + '33' : '#1a3a4a'}`, borderRadius: '6px', padding: '12px', position: 'relative', overflow: 'hidden' }}>
                  {isOnline && <div style={{ position: 'absolute', top: 0, left: 0, right: 0, bottom: 0, background: `linear-gradient(180deg, transparent 0%, ${color}08 50%, transparent 100%)`, animation: 'terran-scan 3s linear infinite', pointerEvents: 'none' }} />}
                  <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', position: 'relative' }}>
                    <div>
                      <div style={{ fontSize: '13px', fontWeight: 600, color, fontFamily: 'var(--font-mc-mono)' }}>{(a.name || a.id || '').toUpperCase()}</div>
                      <div style={{ fontSize: '10px', color: '#455a64', marginTop: '2px' }}>{a.role || a.model || ''}</div>
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', gap: '6px' }}>
                      <div style={{ width: '7px', height: '7px', borderRadius: '50%', background: isOnline ? '#66bb6a' : '#ef5350', boxShadow: isOnline ? '0 0 6px #66bb6a' : 'none', animation: isOnline ? 'terran-pulse 2s infinite' : 'none' }} />
                      <span style={{ fontSize: '10px', color: isOnline ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{(a.status || 'OFF').toUpperCase()}</span>
                    </div>
                  </div>
                </div>
              );
            })}
          </div>
        </div>

        {/* CENTER: Pipeline */}
        <div className="cc-card" style={{ padding: '16px' }}>
          <div className="cc-label" style={{ marginBottom: '14px', display: 'flex', justifyContent: 'space-between' }}>
            <span><span style={{ animation: 'terran-blink 1.4s infinite', color: '#ef5350' }}>●</span> LIVE PIPELINE</span>
            <span style={{ color: '#455a64' }}>{activity.length} events</span>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: '3px', maxHeight: '420px', overflowY: 'auto' }}>
            {activity.length === 0 ? (
              <div style={{ color: '#455a64', fontSize: '12px', fontFamily: 'var(--font-mc-mono)', textAlign: 'center', padding: '40px' }}>Awaiting pipeline data...</div>
            ) : activity.map((entry, i) => {
              const agentName = (entry.agent || 'system').toLowerCase();
              const color = AGENT_COLORS[agentName] || '#607d8b';
              const isAlert = (entry.action || '').toLowerCase().includes('alert');
              const isTrade = (entry.action || '').toLowerCase().includes('buy') || (entry.action || '').toLowerCase().includes('sell');
              const borderColor = isAlert ? '#ef5350' : isTrade ? '#66bb6a' : '#1a3a4a';
              return (
                <div key={i} style={{
                  display: 'flex', gap: '10px', padding: '8px 12px',
                  background: i === 0 ? '#0d1929' : '#0d1117',
                  borderLeft: `2px solid ${borderColor}`, borderRadius: '3px',
                  opacity: 1 - (i * 0.05),
                }}>
                  <div style={{ minWidth: '32px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', fontSize: '10px' }}>{timeAgo(entry.time)}</div>
                  <div style={{ minWidth: '65px', color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600, fontSize: '10px' }}>{(entry.agent || 'SYS').toUpperCase()}</div>
                  <div style={{ flex: 1, color: '#b0bec5', fontSize: '11px', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>{entry.action}</div>
                </div>
              );
            })}
          </div>
        </div>

        {/* RIGHT: Positions + Vitals */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
          <div className="cc-card" style={{ padding: '16px' }}>
            <div className="cc-label" style={{ marginBottom: '12px' }}>ACTIVE POSITIONS</div>
            {positions.length === 0 ? (
              <div style={{ color: '#455a64', fontSize: '12px', fontFamily: 'var(--font-mc-mono)' }}>No positions</div>
            ) : positions.map((p: any, i: number) => {
              const pnl = parseFloat(p.unrealized_pl || '0');
              const pnlPct = parseFloat(p.unrealized_plpc || '0') * 100;
              const g = pnl >= 0;
              return (
                <div key={i} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px 12px', background: '#0d1117', borderRadius: '6px', border: `1px solid ${g ? '#66bb6a22' : '#ef535022'}`, marginBottom: '6px' }}>
                  <div>
                    <div style={{ fontSize: '14px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>{p.symbol}</div>
                    <div style={{ fontSize: '10px', color: '#455a64' }}>{p.qty} @ ${fmt(parseFloat(p.avg_entry_price || '0'))}</div>
                  </div>
                  <div style={{ textAlign: 'right' }}>
                    <div style={{ fontSize: '16px', fontWeight: 700, color: g ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>{g ? '+' : ''}{fmt(pnlPct, 1)}%</div>
                    <div style={{ fontSize: '10px', color: g ? '#66bb6a' : '#ef5350' }}>{g ? '+' : ''}${fmt(pnl)}</div>
                  </div>
                </div>
              );
            })}
          </div>

          <div className="cc-card" style={{ padding: '16px' }}>
            <div className="cc-label" style={{ marginBottom: '10px' }}>SYSTEM VITALS</div>
            {[
              { l: 'UPTIME', v: stats?.uptime || 'N/A', c: '#66bb6a' },
              { l: 'VERSION', v: stats?.version || 'N/A', c: '#4fc3f7' },
              { l: 'CRONS', v: `${stats?.crons?.enabled || '?'}/${stats?.crons?.total || '?'}`, c: '#ff9800' },
              { l: 'SIGNALS', v: `${btcSignal.signal_count || 0}`, c: '#4fc3f7' },
            ].map((v, i) => (
              <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '6px 10px', background: '#0d1117', borderRadius: '4px', marginBottom: '4px', fontSize: '11px', fontFamily: 'var(--font-mc-mono)' }}>
                <span style={{ color: '#607d8b' }}>{v.l}</span>
                <span style={{ color: v.c, fontWeight: 600 }}>{v.v}</span>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}
