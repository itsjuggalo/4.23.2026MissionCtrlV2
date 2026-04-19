'use client';
import { useState, useEffect } from 'react';

interface FlowEntry {
  BidAskType: string; BlockType: string; COLOR: string; Expiry: number; ExpiryStr: string;
  OI: number; OptionType: string; Price: number; Spot: number; Strike: number; Symbol: string;
  Time: number; UnderlyingType: string; Value: number; Volume: number;
}

interface AlertEntry {
  AlertPrice: number; AlertType: string; BLOCKS: number; DTE: number; Expiry: number;
  NumOfAlerts: number; OI: number; OptionSymbol: string; OptionType: string; SWEEPS: number;
  Spot: number; Strike: number; Symbol: string; Time: number; Volume: number; isBullish: boolean;
}

function timeAgo(ts: number): string {
  const diff = Date.now() - ts;
  const mins = Math.floor(diff / 60000);
  if (mins < 1) return 'now';
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
}

const fmtVal = (n: number) => {
  if (n >= 1000000) return `$${(n / 1000000).toFixed(1)}M`;
  if (n >= 1000) return `$${(n / 1000).toFixed(0)}K`;
  return `$${n.toLocaleString()}`;
};

export function OptionsPage() {
  const [flows, setFlows] = useState<FlowEntry[]>([]);
  const [alerts, setAlerts] = useState<AlertEntry[]>([]);
  const [loading, setLoading] = useState(true);
  const [tab, setTab] = useState<'flow' | 'alerts'>('flow');
  const [typeFilter, setTypeFilter] = useState<string>('all');
  const [blockFilter, setBlockFilter] = useState<string>('all');
  const [minValue, setMinValue] = useState<string>('0');
  const [search, setSearch] = useState('');
  const [lastUpdate, setLastUpdate] = useState<Date | null>(null);

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/options-flow');
        const data = await res.json();
        setFlows((data.flows || []).sort((a: FlowEntry, b: FlowEntry) => b.Time - a.Time));
        setAlerts((data.alerts || []).sort((a: AlertEntry, b: AlertEntry) => (b.Time || 0) - (a.Time || 0)));
        setLastUpdate(new Date());
      } catch {}
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 20000);
    return () => clearInterval(i);
  }, []);

  const totalValue = flows.reduce((s, f) => s + (f.Value || 0), 0);
  const callFlow = flows.filter(f => f.OptionType === 'CALL');
  const putFlow = flows.filter(f => f.OptionType === 'PUT');
  const callValue = callFlow.reduce((s, f) => s + (f.Value || 0), 0);
  const putValue = putFlow.reduce((s, f) => s + (f.Value || 0), 0);
  const sweepCount = flows.filter(f => f.BlockType === 'SWEEP').length;
  const blockCount = flows.filter(f => f.BlockType === 'BLOCK').length;
  const bullishAlerts = alerts.filter(a => a.isBullish).length;
  const bearishAlerts = alerts.filter(a => !a.isBullish).length;
  const callPutRatio = putValue > 0 ? (callValue / putValue).toFixed(2) : 'N/A';

  const minVal = parseInt(minValue);
  let filteredFlows = flows;
  if (typeFilter !== 'all') filteredFlows = filteredFlows.filter(f => f.OptionType === typeFilter);
  if (blockFilter !== 'all') filteredFlows = filteredFlows.filter(f => f.BlockType === blockFilter);
  if (minVal > 0) filteredFlows = filteredFlows.filter(f => f.Value >= minVal);
  if (search) { const q = search.toUpperCase(); filteredFlows = filteredFlows.filter(f => f.Symbol?.includes(q)); }

  let filteredAlerts = alerts;
  if (typeFilter !== 'all') filteredAlerts = filteredAlerts.filter(a => a.OptionType === typeFilter);
  if (search) { const q = search.toUpperCase(); filteredAlerts = filteredAlerts.filter(a => a.Symbol?.includes(q)); }

  const selectStyle: React.CSSProperties = { padding: '7px 12px', background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '6px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', cursor: 'pointer', outline: 'none' };

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '16px' }}>
      SCANNING OPTIONS FLOW...
    </div>
  );

  return (
    <div style={{ padding: '16px 20px', height: '100%', display: 'flex', flexDirection: 'column', overflow: 'hidden' }}>
      {/* Top Bar — Status + Dropdown Filters */}
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '10px', flexWrap: 'wrap' }}>
        <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
        <span style={{ fontSize: '12px', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>FLOW GREEKS LIVE</span>
        {lastUpdate && <span style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{Math.floor((Date.now() - lastUpdate.getTime()) / 1000)}s ago · 20s</span>}
        <div style={{ width: '1px', height: '16px', background: '#1a3a4a' }} />

        <select value={tab} onChange={e => setTab(e.target.value as any)} style={selectStyle}>
          <option value="flow">Live Flow ({flows.length})</option>
          <option value="alerts">Alerts ({alerts.length})</option>
        </select>

        <select value={typeFilter} onChange={e => setTypeFilter(e.target.value)} style={selectStyle}>
          <option value="all">All Types</option>
          <option value="CALL">Calls ({callFlow.length})</option>
          <option value="PUT">Puts ({putFlow.length})</option>
        </select>

        {tab === 'flow' && <>
          <select value={blockFilter} onChange={e => setBlockFilter(e.target.value)} style={selectStyle}>
            <option value="all">All Flow</option>
            <option value="SWEEP">Sweeps ({sweepCount})</option>
            <option value="BLOCK">Blocks ({blockCount})</option>
          </select>

          <select value={minValue} onChange={e => setMinValue(e.target.value)} style={selectStyle}>
            <option value="0">Any Value</option>
            <option value="50000">$50K+</option>
            <option value="100000">$100K+</option>
            <option value="500000">$500K+</option>
            <option value="1000000">$1M+</option>
          </select>
        </>}

        <input value={search} onChange={e => setSearch(e.target.value)} placeholder="Ticker..."
          style={{ ...selectStyle, width: '100px' }} />

        <span style={{ fontSize: '11px', color: '#455a64', fontFamily: 'var(--font-mc-mono)', marginLeft: 'auto' }}>
          {tab === 'flow' ? filteredFlows.length : filteredAlerts.length} results
        </span>
      </div>

      {/* Stats Row */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(6, 1fr)', gap: '8px', marginBottom: '10px' }}>
        {[
          { label: 'TOTAL FLOW', value: fmtVal(totalValue), color: '#4fc3f7' },
          { label: 'CALL FLOW', value: fmtVal(callValue), color: '#66bb6a' },
          { label: 'PUT FLOW', value: fmtVal(putValue), color: '#ef5350' },
          { label: 'C/P RATIO', value: callPutRatio, color: parseFloat(callPutRatio) > 1 ? '#66bb6a' : '#ef5350' },
          { label: 'SWEEPS', value: String(sweepCount), color: '#ff9800' },
          { label: 'ALERTS', value: `${bullishAlerts}↑ ${bearishAlerts}↓`, color: bullishAlerts > bearishAlerts ? '#66bb6a' : '#ef5350' },
        ].map((m, i) => (
          <div key={i} style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '6px', padding: '10px', textAlign: 'center' }}>
            <div style={{ fontSize: '9px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '3px' }}>{m.label}</div>
            <div style={{ fontSize: '18px', fontWeight: 800, color: m.color, fontFamily: 'var(--font-mc-mono)' }}>{m.value}</div>
          </div>
        ))}
      </div>

      {/* Table — scrollable */}
      <div style={{ flex: 1, overflow: 'auto', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', minHeight: 0 }}>
        {tab === 'flow' ? (
          <>
            <div style={{ display: 'grid', gridTemplateColumns: '50px 70px 60px 55px 70px 60px 70px 80px 50px 50px', gap: '4px', padding: '10px 14px', background: '#0d1117', fontSize: '10px', fontWeight: 700, color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px', position: 'sticky', top: 0, zIndex: 1 }}>
              <span>TIME</span><span>SYMBOL</span><span>TYPE</span><span>SIDE</span><span>STRIKE</span><span>EXPIRY</span><span>SPOT</span><span>VALUE</span><span>VOL</span><span>FLOW</span>
            </div>
            {filteredFlows.map((f, i) => {
              const isCall = f.OptionType === 'CALL';
              const isBuy = f.BidAskType === 'A';
              const typeColor = isCall ? '#66bb6a' : '#ef5350';
              const sideColor = isBuy ? '#66bb6a' : '#ef5350';
              const isSweep = f.BlockType === 'SWEEP';
              const isHighValue = f.Value >= 100000;
              const isMillionPlus = f.Value >= 1000000;
              return (
                <div key={i} style={{ display: 'grid', gridTemplateColumns: '50px 70px 60px 55px 70px 60px 70px 80px 50px 50px', gap: '4px', padding: '8px 14px', borderBottom: '1px solid #0d1117', fontSize: '12px', fontFamily: 'var(--font-mc-mono)', background: isMillionPlus ? '#ff980012' : isHighValue ? '#ff980008' : 'transparent' }}>
                  <span style={{ color: '#455a64' }}>{timeAgo(f.Time)}</span>
                  <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{f.Symbol}</span>
                  <span style={{ color: typeColor, fontWeight: 600 }}>{f.OptionType}</span>
                  <span style={{ color: sideColor, fontWeight: 600 }}>{isBuy ? 'BUY' : 'SELL'}</span>
                  <span style={{ color: '#e0e0e0' }}>${f.Strike}</span>
                  <span style={{ color: '#90a4ae' }}>{f.ExpiryStr?.slice(5) || ''}</span>
                  <span style={{ color: '#90a4ae' }}>${f.Spot?.toFixed(2)}</span>
                  <span style={{ color: isMillionPlus ? '#ff9800' : isHighValue ? '#ffd54f' : '#e0e0e0', fontWeight: isHighValue ? 700 : 400 }}>{fmtVal(f.Value)}</span>
                  <span style={{ color: '#90a4ae' }}>{f.Volume}</span>
                  <span style={{ fontSize: '10px', fontWeight: 700, padding: '1px 4px', borderRadius: '3px', background: isSweep ? '#ff980022' : '#4fc3f722', color: isSweep ? '#ff9800' : '#4fc3f7' }}>{isSweep ? 'SWP' : 'BLK'}</span>
                </div>
              );
            })}
            {filteredFlows.length === 0 && <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>No flows match filters</div>}
          </>
        ) : (
          <>
            <div style={{ display: 'grid', gridTemplateColumns: '50px 70px 60px 70px 70px 50px 60px 60px 60px 70px', gap: '4px', padding: '10px 14px', background: '#0d1117', fontSize: '10px', fontWeight: 700, color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px', position: 'sticky', top: 0, zIndex: 1 }}>
              <span>TIME</span><span>SYMBOL</span><span>TYPE</span><span>STRIKE</span><span>SPOT</span><span>DTE</span><span>SWEEPS</span><span>BLOCKS</span><span>VOL</span><span>BIAS</span>
            </div>
            {filteredAlerts.map((a, i) => {
              const isCall = a.OptionType === 'CALL';
              const typeColor = isCall ? '#66bb6a' : '#ef5350';
              const biasColor = a.isBullish ? '#66bb6a' : '#ef5350';
              return (
                <div key={i} style={{ display: 'grid', gridTemplateColumns: '50px 70px 60px 70px 70px 50px 60px 60px 60px 70px', gap: '4px', padding: '8px 14px', borderBottom: '1px solid #0d1117', fontSize: '12px', fontFamily: 'var(--font-mc-mono)' }}>
                  <span style={{ color: '#455a64' }}>{timeAgo(a.Time)}</span>
                  <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{a.Symbol}</span>
                  <span style={{ color: typeColor, fontWeight: 600 }}>{a.OptionType}</span>
                  <span style={{ color: '#e0e0e0' }}>${a.Strike}</span>
                  <span style={{ color: '#90a4ae' }}>${a.Spot?.toFixed(2)}</span>
                  <span style={{ color: a.DTE <= 1 ? '#ef5350' : '#90a4ae', fontWeight: a.DTE <= 1 ? 700 : 400 }}>{a.DTE}d</span>
                  <span style={{ color: '#ff9800' }}>{a.SWEEPS || 0}</span>
                  <span style={{ color: '#4fc3f7' }}>{a.BLOCKS || 0}</span>
                  <span style={{ color: '#e0e0e0' }}>{(a.Volume || 0).toLocaleString()}</span>
                  <span style={{ fontSize: '10px', fontWeight: 700, padding: '1px 6px', borderRadius: '3px', background: `${biasColor}22`, color: biasColor }}>{a.isBullish ? 'BULL' : 'BEAR'}</span>
                </div>
              );
            })}
            {filteredAlerts.length === 0 && <div style={{ padding: '40px', textAlign: 'center', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>No alerts match filters</div>}
          </>
        )}
      </div>
    </div>
  );
}
