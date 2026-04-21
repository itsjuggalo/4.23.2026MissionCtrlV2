'use client';
import GridLayout from 'react-grid-layout';
import 'react-grid-layout/css/styles.css';
import { useState, useEffect, useRef } from 'react';

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

type LivePrices = Record<string, { price: number; change: number; changePct: number }>;
type SelectedItem = { type: 'flow'; data: FlowEntry } | { type: 'alert'; data: AlertEntry } | null;

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

const fmtTime = (ts: number) => {
  if (!ts) return '';
  return new Date(ts).toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', hour12: true });
};

const fmtPrice = (n: number) => {
  if (!n) return '$0';
  if (n >= 1000) return `$${n.toFixed(2)}`;
  return `$${n.toFixed(2)}`;
};

function premiumColor(value: number, unusual: boolean): string {
  const v = unusual ? value * 2 : value;
  if (v >= 5000000) return '#e040fb';
  if (v >= 1000000) return '#ff9800';
  if (v >= 500000) return '#ffd600';
  if (v >= 250000) return '#66bb6a';
  if (v >= 100000) return '#00bcd4';
  if (v >= 50000) return '#448aff';
  return '#7c4dff';
}

function premiumLabel(value: number): string {
  if (value >= 5000000) return 'MONSTER';
  if (value >= 1000000) return 'WHALE';
  if (value >= 500000) return 'LARGE';
  if (value >= 250000) return 'INSTITUTIONAL';
  if (value >= 100000) return 'NOTABLE';
  if (value >= 50000) return 'NORMAL';
  return 'SMALL';
}

function volumeColor(vol: number): string {
  if (vol >= 10000) return '#e040fb';
  if (vol >= 5000) return '#ff9800';
  if (vol >= 2000) return '#ffd600';
  if (vol >= 500) return '#66bb6a';
  if (vol >= 100) return '#00bcd4';
  if (vol >= 50) return '#448aff';
  return '#7c4dff';
}

function pricePostfix(ba: string): string {
  if (ba === 'A') return '=A';
  if (ba === 'AA') return '>A';
  if (ba === 'B') return '=B';
  if (ba === 'AB') return '>B';
  return ba || '';
}

function isAsk(ba: string): boolean { return ba === 'A' || ba === 'AA'; }
function flagUnusual(f: FlowEntry): boolean { return f.Volume > f.OI && f.OI >= 0; }
function flagHuge(f: FlowEntry): boolean { return f.BlockType === 'SWEEP' && isAsk(f.BidAskType) && f.Value >= 1000000; }
function flagUnusualHuge(f: FlowEntry): boolean { return flagUnusual(f) && f.BlockType === 'SWEEP' && isAsk(f.BidAskType) && f.Value >= 500000; }

function getSentiment(f: FlowEntry): 'BULLISH' | 'BEARISH' {
  const ask = isAsk(f.BidAskType);
  if (f.OptionType === 'CALL' && ask) return 'BULLISH';
  if (f.OptionType === 'PUT' && !ask) return 'BULLISH';
  return 'BEARISH';
}

function sentColor(s: string): string { return s === 'BULLISH' ? '#66bb6a' : '#ef5350'; }

function spotVsCurrent(spot: number, current: number | undefined): { text: string; color: string } | null {
  if (!current || !spot || spot <= 0) return null;
  const diff = current - spot;
  const pct = (diff / spot) * 100;
  const sign = diff >= 0 ? '+' : '';
  return {
    text: `${sign}${pct.toFixed(1)}%`,
    color: diff >= 0 ? '#66bb6a' : '#ef5350',
  };
}

function FlowColHeaders() {
  return (
    <div style={{ display: 'grid', gridTemplateColumns: '12px 36px 60px 92px 52px 120px 32px 92px 108px', gap: '6px', padding: '4px 14px', background: '#0a1422', borderBottom: '1px solid #1a3a4a', alignItems: 'center', maxWidth: '700px', margin: '0 auto', width: '100%', boxSizing: 'border-box' }}>
      {['', 'TIME', 'TICKER', 'CONTRACT', 'EXP', 'VOL/OI', 'SIDE', 'PREMIUM', 'TYPE'].map((h, i) => (
        <span key={i} style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', letterSpacing: '0.8px', fontFamily: 'var(--font-mc-mono)', fontWeight: 700, textAlign: i >= 7 ? 'right' : 'left' }}>{h}</span>
      ))}
    </div>
  );
}

function FlowRow({ f, onClick, livePrice }: { f: FlowEntry; onClick: () => void; livePrice?: { price: number; change: number; changePct: number } }) {
  const isSweep = f.BlockType === 'SWEEP';
  const unusual = flagUnusual(f);
  const highConviction = unusual && f.BlockType === 'SWEEP' && isAsk(f.BidAskType) && f.Value >= 100000;
  const unusualHuge = flagUnusualHuge(f);
  const huge = flagHuge(f);
  const valColor = premiumColor(f.Value, unusual);
  const volColor = volumeColor(f.Volume);
  const sentiment = getSentiment(f);
  const sColor = sentColor(sentiment);
  const postfix = pricePostfix(f.BidAskType);
  const fv = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(1) + 'M' : n >= 1000 ? '$' + (n/1000).toFixed(0) + 'K' : '$' + n;
  const expStr = f.ExpiryStr?.slice(5) || '';

  return (
    <div onClick={onClick} style={{
      display: 'grid', gridTemplateColumns: '12px 36px 60px 92px 52px 120px 32px 92px 108px',
      gap: '6px', padding: '8px 14px', borderBottom: '1px solid #0d1117', cursor: 'pointer',
      alignItems: 'center',
      background: unusualHuge ? '#e040fb08' : huge ? '#ffd60008' : highConviction ? '#66bb6a06' : 'transparent',
      borderLeft: unusualHuge ? '3px solid #e040fb' : unusual ? '3px solid #ffd600' : '3px solid transparent',
      maxWidth: '700px', margin: '0 auto', width: '100%', boxSizing: 'border-box',
    }}
      onMouseEnter={e => (e.currentTarget.style.background = '#1a3a4a18')}
      onMouseLeave={e => (e.currentTarget.style.background = unusualHuge ? '#e040fb08' : huge ? '#ffd60008' : 'transparent')}>
      <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: sColor, boxShadow: '0 0 4px ' + sColor, display: 'inline-block' }} />
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(f.Time)}</span>
      <span style={{ fontSize: 'var(--mc-font-sm)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{f.Symbol}</span>
      <span style={{ fontSize: 'var(--mc-font-xs)', color: sColor, fontFamily: 'var(--font-mc-mono)' }}>{f.OptionType?.slice(0, 1)} ${f.Strike}</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#ffffff', fontFamily: 'var(--font-mc-mono)' }}>{expStr}</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: unusual ? '#ffd600' : '#ffffff', fontFamily: 'var(--font-mc-mono)' }}>{f.Volume || 0}/{f.OI || 0}</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{postfix}</span>
      <span style={{ fontSize: 'var(--mc-font-sm)', color: valColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)', textAlign: 'right' }}>{fv(f.Value)}</span>
      <div style={{ display: 'flex', gap: '3px', justifyContent: 'flex-end', alignItems: 'center' }}>
        {highConviction && <span style={{ fontSize: 'var(--mc-font-badge)' }}>🔥</span>}
        {unusual && <span style={{ display: 'inline-flex', alignItems: 'center', padding: '1px 6px', borderRadius: '3px', background: '#ffd60022', border: '1px solid #ffd60055', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', color: '#ffd600', fontWeight: 700, lineHeight: 1.2, whiteSpace: 'nowrap' }}>U</span>}
        <span style={{ display: 'inline-flex', alignItems: 'baseline', gap: '3px', padding: '1px 6px', borderRadius: '3px', background: f.BlockType === 'SWEEP' ? '#ff980022' : '#4fc3f722', border: f.BlockType === 'SWEEP' ? '1px solid #ff980055' : '1px solid #4fc3f755', fontFamily: 'var(--font-mc-mono)', fontWeight: 700, color: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7', lineHeight: 1.2, whiteSpace: 'nowrap' }}><span style={{ fontSize: 'var(--mc-font-badge)', opacity: 0.75 }}>{f.BlockType === 'SWEEP' ? 'SWP' : 'BLK'}</span></span>
      </div>
    </div>
  );
}



function AlertRow({ a, onClick, livePrice }: { a: AlertEntry; onClick: () => void; livePrice?: { price: number; change: number; changePct: number } }) {
  const sColor = a.isBullish ? '#66bb6a' : '#ef5350';
  const fv = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(1) + 'M' : n >= 1000 ? '$' + (n/1000).toFixed(0) + 'K' : '$' + n;
  return (
    <div onClick={onClick} style={{
      display: 'grid', gridTemplateColumns: '12px 36px 60px 92px 52px 120px 32px 92px 108px',
      gap: '6px', padding: '8px 14px', borderBottom: '1px solid #0d1117', cursor: 'pointer', alignItems: 'center',
      maxWidth: '700px', margin: '0 auto', width: '100%', boxSizing: 'border-box',
    }}
      onMouseEnter={e => (e.currentTarget.style.background = '#1a3a4a18')}
      onMouseLeave={e => (e.currentTarget.style.background = 'transparent')}>
      <span style={{ width: '8px', height: '8px', borderRadius: '50%', background: sColor, boxShadow: '0 0 4px ' + sColor, display: 'inline-block' }} />
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#455a64', fontFamily: 'var(--font-mc-mono)' }}>{timeAgo(a.Time || Date.now())}</span>
      <span style={{ fontSize: 'var(--mc-font-sm)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)' }}>{a.Symbol}</span>
      <span style={{ fontSize: 'var(--mc-font-xs)', color: sColor, fontFamily: 'var(--font-mc-mono)' }}>{a.OptionType?.slice(0, 1)} ${a.Strike}</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: a.DTE <= 2 ? '#ff9800' : '#ffffff', fontFamily: 'var(--font-mc-mono)' }}>{a.DTE}d</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#ffffff', fontFamily: 'var(--font-mc-mono)' }}>{a.Volume || 0}/{a.OI || 0}</span>
      <span style={{ fontSize: 'var(--mc-font-label)', color: '#ce93d8', fontFamily: 'var(--font-mc-mono)' }}>{(a.NumOfAlerts || 0) > 1 ? '×' + a.NumOfAlerts : ''}</span>
      <span style={{ fontSize: 'var(--mc-font-sm)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)', textAlign: 'right' }}>{a.AlertPrice ? '$' + a.AlertPrice.toFixed(2) : (a.isBullish ? 'BULL' : 'BEAR')}</span>
      <div style={{ display: 'flex', gap: '3px', justifyContent: 'flex-end', alignItems: 'center' }}>
        {(a.SWEEPS || 0) > 0 && <span style={{ display: 'inline-flex', alignItems: 'baseline', gap: '3px', padding: '1px 6px', borderRadius: '3px', background: '#ff980022', border: '1px solid #ff980055', fontFamily: 'var(--font-mc-mono)', fontWeight: 700, color: '#ff9800', lineHeight: 1.2, whiteSpace: 'nowrap' }}><span style={{ fontSize: 'var(--mc-font-badge)' }}>{a.SWEEPS}</span><span style={{ fontSize: 'var(--mc-font-label)', opacity: 0.75 }}>SWP</span></span>}
        {(a.BLOCKS || 0) > 0 && <span style={{ display: 'inline-flex', alignItems: 'baseline', gap: '3px', padding: '1px 6px', borderRadius: '3px', background: '#4fc3f722', border: '1px solid #4fc3f755', fontFamily: 'var(--font-mc-mono)', fontWeight: 700, color: '#4fc3f7', lineHeight: 1.2, whiteSpace: 'nowrap' }}><span style={{ fontSize: 'var(--mc-font-badge)' }}>{a.BLOCKS}</span><span style={{ fontSize: 'var(--mc-font-label)', opacity: 0.75 }}>BLK</span></span>}
      </div>
    </div>
  );
}



function Block({ title, count, color, children, golden, editMode }: { title: string; count: number; color: string; children: React.ReactNode; golden?: boolean; editMode?: boolean }) {
  return (
    <div style={{ background: '#0a1929', border: editMode ? '1px dashed #4fc3f7aa' : (golden ? '1px solid #ffd60055' : '1px solid #1a3a4a'), borderRadius: '8px', overflow: 'hidden', boxShadow: golden ? '0 0 12px #ffd60015' : 'none', display: 'flex', flexDirection: 'column', height: '100%', width: '100%' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px 14px', background: '#0d1117', borderBottom: '1px solid #1a3a4a' }}>
        <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color, fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px' }}>{title}</span>
        <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
          <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, padding: '1px 8px', borderRadius: '10px', background: `${color}18`, color, fontFamily: 'var(--font-mc-mono)' }}>{count}</span>
          <span className="mc-drag-handle" style={{ cursor: editMode ? 'grab' : 'default', color: editMode ? '#4fc3f7' : '#455a64', fontSize: '14px', fontFamily: 'var(--font-mc-mono)', padding: '0 4px', userSelect: 'none', opacity: editMode ? 1 : 0.4 }} title={editMode ? 'Drag to reposition' : 'Enable EDIT LAYOUT to move'}>⋮⋮</span>
        </div>
      </div>
          <FlowColHeaders />
      <div style={{ overflow: 'auto', maxHeight: '340px', flex: 1 }}>{children}</div>
    </div>
  );
}

function DetailPanel({ item, onClose, livePrice }: { item: SelectedItem; onClose: () => void; livePrice?: { price: number; change: number; changePct: number } }) {
  if (!item) return null;
  const isFlow = item.type === 'flow';
  const f = isFlow ? item.data as FlowEntry : null;
  const a = !isFlow ? item.data as AlertEntry : null;
  const sentiment = f ? getSentiment(f) : (a?.isBullish ? 'BULLISH' : 'BEARISH');
  const sc = sentColor(sentiment);
  const spot = f?.Spot || a?.Spot || 0;
  const currentPrice = livePrice?.price || 0;
  const priceDiff = currentPrice && spot ? currentPrice - spot : 0;
  const pricePct = spot > 0 && currentPrice ? ((currentPrice - spot) / spot * 100) : 0;

  const rows: { label: string; value: string; color?: string }[] = isFlow && f ? [
    { label: 'Ticker', value: f.Symbol, color: sc },
    { label: 'Sentiment', value: sentiment, color: sc },
    { label: 'Type', value: f.OptionType, color: sc },
    { label: 'Strike', value: `$${f.Strike}`, color: sc },
    { label: 'Expiry', value: f.ExpiryStr || '' },
    { label: 'Spot @ Alert', value: fmtPrice(f.Spot), color: '#ff9800' },
    { label: 'Current Price', value: currentPrice ? fmtPrice(currentPrice) : 'Loading...', color: currentPrice ? (priceDiff >= 0 ? '#66bb6a' : '#ef5350') : '#607d8b' },
    { label: 'Move Since Alert', value: currentPrice ? `${priceDiff >= 0 ? '+' : ''}$${priceDiff.toFixed(2)} (${pricePct >= 0 ? '+' : ''}${pricePct.toFixed(2)}%)` : '—', color: priceDiff >= 0 ? '#66bb6a' : '#ef5350' },
    { label: 'Contract $', value: `$${f.Price?.toFixed(2)}` },
    { label: 'Price Side', value: `${pricePostfix(f.BidAskType)} (${isAsk(f.BidAskType) ? 'ASK' : 'BID'})`, color: isAsk(f.BidAskType) ? '#66bb6a' : '#ef5350' },
    { label: 'Premium $$', value: fmtVal(f.Value), color: premiumColor(f.Value, flagUnusual(f)) },
    { label: 'Premium Tier', value: premiumLabel(f.Value), color: premiumColor(f.Value, flagUnusual(f)) },
    { label: 'Volume', value: f.Volume?.toLocaleString() || '0', color: volumeColor(f.Volume) },
    { label: 'Open Interest', value: f.OI?.toLocaleString() || '0' },
    { label: 'Vol/OI', value: f.OI > 0 ? (f.Volume / f.OI).toFixed(1) + 'x' : 'N/A', color: f.Volume > f.OI ? '#ffd600' : '#607d8b' },
    { label: 'Flow Type', value: f.BlockType, color: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7' },
    { label: 'Unusual', value: flagUnusual(f) ? 'YES — Vol > OI' : 'No', color: flagUnusual(f) ? '#ffd600' : '#607d8b' },
    { label: 'Unusual Huge', value: flagUnusualHuge(f) ? 'YES — $500K+ Unusual Sweep' : 'No', color: flagUnusualHuge(f) ? '#e040fb' : '#607d8b' },
    { label: 'Huge Flow', value: flagHuge(f) ? 'YES — $1M+ ASK Sweep' : 'No', color: flagHuge(f) ? '#ffd600' : '#607d8b' },
    { label: 'Underlying', value: f.UnderlyingType || 'STOCK' },
    { label: 'Time', value: fmtTime(f.Time) },
  ] : a ? [
    { label: 'Ticker', value: a.Symbol, color: sc },
    { label: 'Bias', value: a.isBullish ? 'BULLISH' : 'BEARISH', color: sc },
    { label: 'Type', value: a.OptionType, color: sc },
    { label: 'Strike', value: `$${a.Strike}`, color: sc },
    { label: 'Spot @ Alert', value: fmtPrice(a.Spot), color: '#ff9800' },
    { label: 'Current Price', value: currentPrice ? fmtPrice(currentPrice) : 'Loading...', color: currentPrice ? (priceDiff >= 0 ? '#66bb6a' : '#ef5350') : '#607d8b' },
    { label: 'Move Since Alert', value: currentPrice ? `${priceDiff >= 0 ? '+' : ''}$${priceDiff.toFixed(2)} (${pricePct >= 0 ? '+' : ''}${pricePct.toFixed(2)}%)` : '—', color: priceDiff >= 0 ? '#66bb6a' : '#ef5350' },
    { label: 'Alert Price', value: a.AlertPrice ? `$${a.AlertPrice.toFixed(2)}` : '—' },
    { label: 'DTE', value: `${a.DTE} days`, color: a.DTE <= 2 ? '#ff9800' : '#e0e0e0' },
    { label: 'Sweeps', value: String(a.SWEEPS || 0), color: '#ff9800' },
    { label: 'Blocks', value: String(a.BLOCKS || 0), color: '#4fc3f7' },
    { label: 'Volume', value: a.Volume?.toLocaleString() || '0', color: volumeColor(a.Volume) },
    { label: 'Open Interest', value: a.OI?.toLocaleString() || '0' },
    { label: 'Repeat Count', value: String(a.NumOfAlerts || 1), color: (a.NumOfAlerts || 0) > 1 ? '#ce93d8' : '#607d8b' },
    { label: 'Alert Type', value: a.AlertType || 'Standard' },
    { label: 'Time', value: fmtTime(a.Time) },
  ] : [];

  return (
    <div style={{ width: '300px', flexShrink: 0, background: '#0a1929', borderLeft: '1px solid #1a3a4a', height: '100%', overflow: 'auto', display: 'flex', flexDirection: 'column' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '12px 14px', background: '#0d1117', borderBottom: `2px solid ${sc}` }}>
        <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: sc, fontFamily: 'var(--font-mc-mono)' }}>
          {isFlow ? f?.Symbol : a?.Symbol} — {sentiment}
        </span>
        <span onClick={onClose} style={{ cursor: 'pointer', color: '#607d8b', fontSize: 'var(--mc-font-xl)', lineHeight: 1 }}>×</span>
      </div>
      {/* Premium hero + price comparison */}
      {isFlow && f && (
        <div style={{ padding: '10px 14px', background: `${premiumColor(f.Value, flagUnusual(f))}10`, borderBottom: '1px solid #1a3a4a', textAlign: 'center' }}>
          <div style={{ fontSize: 'var(--mc-font-hero)', fontWeight: 800, color: premiumColor(f.Value, flagUnusual(f)), fontFamily: 'var(--font-mc-mono)', textShadow: f.Value >= 1000000 ? `0 0 12px ${premiumColor(f.Value, flagUnusual(f))}66` : 'none' }}>{fmtVal(f.Value)}</div>
          <div style={{ fontSize: 'var(--mc-font-xl)', color: premiumColor(f.Value, flagUnusual(f)), fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginTop: '2px' }}>{premiumLabel(f.Value)}{flagUnusual(f) ? ' • UNUSUAL' : ''}</div>
          <div style={{ fontSize: 'var(--mc-font-xl)', color: sc, marginTop: '4px' }}>{f.OptionType} on {isAsk(f.BidAskType) ? 'ASK' : 'BID'} → {sentiment}</div>
          {currentPrice > 0 && (
            <div style={{ display: 'flex', justifyContent: 'center', gap: '12px', marginTop: '6px', fontSize: 'var(--mc-font-xl)', fontFamily: 'var(--font-mc-mono)' }}>
              <span style={{ color: '#ff9800' }}>Alert: {fmtPrice(f.Spot)}</span>
              <span style={{ color: '#4fc3f7' }}>Now: {fmtPrice(currentPrice)}</span>
              <span style={{ color: priceDiff >= 0 ? '#66bb6a' : '#ef5350', fontWeight: 700 }}>{pricePct >= 0 ? '+' : ''}{pricePct.toFixed(2)}%</span>
            </div>
          )}
        </div>
      )}
      <div style={{ padding: '4px 0' }}>
        {rows.map((r, i) => (
          <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '9px 14px', borderBottom: '1px solid #0d111708' }}>
            <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{r.label}</span>
            <span style={{ fontSize: 'var(--mc-font-xl)', color: r.color || '#e0e0e0', fontWeight: 600, fontFamily: 'var(--font-mc-mono)' }}>{r.value}</span>
          </div>
        ))}
      </div>
      <div style={{ margin: '8px 14px', padding: '8px 10px', background: '#0d1117', borderRadius: '6px', border: '1px solid #1a3a4a' }}>
        <div style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px', marginBottom: '4px' }}>SENTIMENT MAP</div>
        <div style={{ fontSize: 'var(--mc-font-xl)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>CALL on ASK → Bullish</div>
        <div style={{ fontSize: 'var(--mc-font-xl)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>CALL on BID → Bearish</div>
        <div style={{ fontSize: 'var(--mc-font-xl)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>PUT on ASK → Bearish</div>
        <div style={{ fontSize: 'var(--mc-font-xl)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>PUT on BID → Bullish</div>
      </div>
    </div>
  );
}


function SentimentPopup({ f, onClose }: { f: FlowEntry; onClose: () => void }) {
  const sentiment = getSentiment(f);
  const sc = sentColor(sentiment);
  const unusual = flagUnusual(f);
  const huge = flagHuge(f);
  const highConviction = unusual && f.BlockType === 'SWEEP' && isAsk(f.BidAskType) && f.Value >= 100000;
  const pc = premiumColor(f.Value, unusual);
  const fv = (n: number) => n >= 1000000 ? '$' + (n/1000000).toFixed(1) + 'M' : n >= 1000 ? '$' + (n/1000).toFixed(0) + 'K' : '$' + n;
  const postfix = pricePostfix(f.BidAskType);
  const volOiRatio = f.OI > 0 ? (f.Volume / f.OI).toFixed(2) + 'x' : 'N/A';

  const cells = [
    { l: 'SENTIMENT', v: sentiment, c: sc },
    { l: 'DIRECTION', v: f.OptionType + ' on ' + (isAsk(f.BidAskType) ? 'ASK' : 'BID'), c: sc },
    { l: 'PREMIUM', v: fv(f.Value), c: pc },
    { l: 'SPOT @ ALERT', v: '$' + f.Spot?.toFixed(2), c: '#ff9800' },
    { l: 'VOLUME / OI', v: f.Volume + ' / ' + f.OI, c: unusual ? '#ffd600' : '#607d8b' },
    { l: 'VOL/OI RATIO', v: volOiRatio, c: unusual ? '#ffd600' : '#607d8b' },
    { l: 'PRICE SIDE', v: postfix + ' (' + (isAsk(f.BidAskType) ? 'ASK' : 'BID') + ')', c: '#e0e0e0' },
    { l: 'FLOW TYPE', v: f.BlockType, c: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7' },
  ];

  return (
    <div onClick={onClose} style={{ position: 'fixed', top: 0, left: 0, right: 0, bottom: 0, background: 'rgba(0,0,0,0.6)', display: 'flex', alignItems: 'center', justifyContent: 'center', zIndex: 9999 }}>
      <div onClick={e => e.stopPropagation()} style={{ background: '#0d1929', border: '1px solid #4fc3f7', borderRadius: '12px', padding: '20px 24px', width: '440px', maxHeight: '90vh', overflowY: 'auto', fontFamily: 'var(--font-mc-mono)' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px', paddingBottom: '12px', borderBottom: '1px solid #1a3a4a' }}>
          <span style={{ fontSize: 'var(--mc-font-lg)', fontWeight: 700, color: sc }}>{f.Symbol} {f.OptionType?.slice(0,1)} ${f.Strike} <span style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b' }}>{f.ExpiryStr}</span></span>
          <button onClick={onClose} style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', cursor: 'pointer', background: 'none', border: 'none' }}>x</button>
        </div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px', marginBottom: '14px' }}>
          {cells.map((c, i) => (
            <div key={i} style={{ background: '#0a1929', borderRadius: '6px', padding: '10px 12px' }}>
              <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', letterSpacing: '0.5px', marginBottom: '4px' }}>{c.l}</div>
              <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 600, color: c.c }}>{c.v}</div>
            </div>
          ))}
        </div>
        <div style={{ display: 'flex', gap: '6px', flexWrap: 'wrap', marginBottom: '14px' }}>
          {unusual && <span style={{ fontSize: 'var(--mc-font-label)', padding: '3px 8px', borderRadius: '3px', background: '#ffd60022', color: '#ffd600', fontWeight: 700 }}>UNUSUAL</span>}
          <span style={{ fontSize: 'var(--mc-font-label)', padding: '3px 8px', borderRadius: '3px', background: f.BlockType === 'SWEEP' ? '#ff980022' : '#4fc3f722', color: f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7', fontWeight: 700 }}>{f.BlockType}</span>
          <span style={{ fontSize: 'var(--mc-font-label)', padding: '3px 8px', borderRadius: '3px', background: sc + '22', color: sc, fontWeight: 700 }}>{sentiment}</span>
          {highConviction && <span style={{ fontSize: 'var(--mc-font-label)', padding: '3px 8px', borderRadius: '3px', background: '#e040fb22', color: '#e040fb', fontWeight: 700 }}>HIGH CONVICTION 🔥</span>}
        </div>
        {highConviction && (
          <div style={{ padding: '12px', background: '#0a1929', borderRadius: '6px', marginBottom: '14px', borderLeft: '3px solid #ffd600' }}>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', letterSpacing: '1px', marginBottom: '6px' }}>WHY THIS IS FLAGGED</div>
            <div style={{ fontSize: 'var(--mc-font-label)', color: '#b0bec5', lineHeight: '1.6' }}>
              Unusual volume (Vol {f.Volume} &gt; OI {f.OI}) = <span style={{ color: '#ffd600' }}>new positions</span>.
              {f.BlockType} across exchanges = <span style={{ color: '#ff9800' }}>urgency</span>.
              Bought at <span style={{ color: '#66bb6a' }}>ASK</span> = bullish conviction.
              Premium <span style={{ color: pc }}>{fv(f.Value)}</span> = institutional.
            </div>
          </div>
        )}
        <div style={{ paddingTop: '12px', borderTop: '1px solid #1a3a4a' }}>
          <div style={{ fontSize: 'var(--mc-font-label)', color: '#607d8b', letterSpacing: '1px', marginBottom: '6px' }}>SENTIMENT REFERENCE</div>
          {[
            { e: 'CALL on ASK', s: 'BULLISH', c: '#66bb6a' },
            { e: 'CALL on BID', s: 'BEARISH', c: '#ef5350' },
            { e: 'PUT on ASK', s: 'BEARISH', c: '#ef5350' },
            { e: 'PUT on BID', s: 'BULLISH', c: '#66bb6a' },
          ].map((r, i) => (
            <div key={i} style={{ display: 'flex', justifyContent: 'space-between', padding: '4px 0', fontSize: 'var(--mc-font-label)' }}>
              <span style={{ color: '#90a4ae' }}>{r.e}</span>
              <span style={{ color: r.c, fontWeight: 700 }}>= {r.s}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

const DEFAULT_LAYOUT = [
  { i: 'calls',         x: 0,  y: 0,  w: 8, h: 8 },
  { i: 'puts',          x: 8,  y: 0,  w: 8, h: 8 },
  { i: 'sweeps',        x: 16, y: 0,  w: 8, h: 8 },
  { i: 'blocks',        x: 0,  y: 8,  w: 8, h: 8 },
  { i: 'alerts',        x: 8,  y: 8,  w: 8, h: 8 },
  { i: 'liveflows',     x: 16, y: 8,  w: 8, h: 8 },
  { i: 'unusualflow',   x: 0,  y: 16, w: 8, h: 8 },
  { i: 'hugeflow',      x: 8,  y: 16, w: 8, h: 8 },
  { i: 'weeklyflow',    x: 16, y: 16, w: 8, h: 8 },
  { i: 'repeatingflow', x: 0,  y: 24, w: 8, h: 8 },
  { i: 'etfflow',       x: 8,  y: 24, w: 8, h: 8 },
  { i: 'unusualhuge',   x: 16, y: 24, w: 8, h: 8 },
];

const LAYOUT_STORAGE_KEY = 'mc-options-layout-v1';

export function OptionsPage() {
  const [layout, setLayout] = useState<any[]>(DEFAULT_LAYOUT);
  const [editMode, setEditMode] = useState(false);
  const [layoutDirty, setLayoutDirty] = useState(false);
  const [gridWidth, setGridWidth] = useState(1400);

  useEffect(() => {
    try {
      const saved = localStorage.getItem(LAYOUT_STORAGE_KEY);
      if (saved) setLayout(JSON.parse(saved));
    } catch {}
  }, []);

  useEffect(() => {
    const updateWidth = () => {
      if (typeof window !== 'undefined') {
        setGridWidth(Math.max(900, window.innerWidth - 40));
      }
    };
    updateWidth();
    window.addEventListener('resize', updateWidth);
    return () => window.removeEventListener('resize', updateWidth);
  }, []);

  const handleLayoutChange = (newLayout: any[]) => {
    if (editMode) {
      setLayout(newLayout);
      setLayoutDirty(true);
    }
  };

  const handleSaveLayout = () => {
    try {
      localStorage.setItem(LAYOUT_STORAGE_KEY, JSON.stringify(layout));
      setEditMode(false);
      setLayoutDirty(false);
    } catch (e) { console.error('Save layout failed', e); }
  };

  const handleResetLayout = () => {
    if (!confirm('Reset block layout to default?')) return;
    setLayout(DEFAULT_LAYOUT);
    try { localStorage.removeItem(LAYOUT_STORAGE_KEY); } catch {}
    setLayoutDirty(false);
  };

  const [flows, setFlows] = useState<FlowEntry[]>([]);
  const [alerts, setAlerts] = useState<AlertEntry[]>([]);
  const [livePrices, setLivePrices] = useState<LivePrices>({});
  const [loading, setLoading] = useState(true);
  const [selected, setSelected] = useState<SelectedItem>(null);
  const [popup, setPopup] = useState<FlowEntry | null>(null);
  const [lastUpdate, setLastUpdate] = useState<Date | null>(null);
  const priceCache = useRef<{ ts: number; data: LivePrices }>({ ts: 0, data: {} });

  useEffect(() => {
    async function fetchData() {
      try {
        const res = await fetch('/api/options-flow');
        const data = await res.json();
        const f = (data.flows || []).sort((a: FlowEntry, b: FlowEntry) => b.Time - a.Time);
        const a = (data.alerts || []).sort((a: AlertEntry, b: AlertEntry) => (b.Time || 0) - (a.Time || 0));
        setFlows(f);
        setAlerts(a);
        setLastUpdate(new Date());

        // Fetch live prices — cache for 30 seconds
        const now = Date.now();
        if (now - priceCache.current.ts > 30000) {
          const allSymbols = new Set<string>();
          f.forEach((fl: FlowEntry) => fl.Symbol && allSymbols.add(fl.Symbol));
          a.forEach((al: AlertEntry) => al.Symbol && allSymbols.add(al.Symbol));
          const syms = Array.from(allSymbols).slice(0, 100).join(',');
          if (syms) {
            try {
              const pRes = await fetch(`/api/live-quotes?symbols=${syms}`);
              const pData = await pRes.json();
              if (pData.prices) {
                priceCache.current = { ts: now, data: pData.prices };
                setLivePrices(pData.prices);
              }
            } catch {}
          }
        }
      } catch {}
      setLoading(false);
    }
    fetchData();
    const i = setInterval(fetchData, 20000);
    return () => clearInterval(i);
  }, []);

  const calls = flows.filter(f => f.OptionType === 'CALL');
  const puts = flows.filter(f => f.OptionType === 'PUT');
  const sweeps = flows.filter(f => f.BlockType === 'SWEEP');
  const blocks = flows.filter(f => f.BlockType === 'BLOCK');
  const unusualFlow = flows.filter(f => flagUnusual(f));
  const hugeFlow = flows.filter(f => flagHuge(f));
  const unusualHugeFlow = flows.filter(f => flagUnusualHuge(f));
  const now = Date.now();
  const weekMs = 7 * 24 * 3600 * 1000;
  const weeklyFlow = flows.filter(f => { const e = f.Expiry * 1000; return e > now && e < now + weekMs; });
  const repeatingAlerts = alerts.filter(a => (a.NumOfAlerts || 0) > 1);
  const etfFlow = flows.filter(f => f.UnderlyingType === 'ETF');
  const totalValue = flows.reduce((s, f) => s + (f.Value || 0), 0);
  const bullCount = flows.filter(f => getSentiment(f) === 'BULLISH').length;
  const bearCount = flows.length - bullCount;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '40vh', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-xl)' }}>SCANNING OPTIONS FLOW...</div>
  );

  const noItems = <div style={{ padding: '20px', textAlign: 'center', color: '#455a64', fontSize: 'var(--mc-font-xl)', fontFamily: 'var(--font-mc-mono)' }}>No data</div>;
  const selectedTicker = selected?.type === 'flow' ? (selected.data as FlowEntry).Symbol : selected?.type === 'alert' ? (selected.data as AlertEntry).Symbol : '';
  const selectedLive = selectedTicker ? livePrices[selectedTicker] : undefined;

  return (
    <div style={{ display: 'flex', height: '100%', overflow: 'hidden' }}>
      <div style={{ flex: 1, padding: '16px 20px', overflow: 'auto', minWidth: 0 }}>
        {/* Status */}
        <div style={{ display: 'flex', alignItems: 'center', gap: '10px', marginBottom: '10px', flexWrap: 'wrap' }}>
          <span style={{ width: '10px', height: '10px', borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 6px #66bb6a88' }} />
          <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>OPTIONS FLOW</span>
          {lastUpdate && <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{Math.floor((Date.now() - lastUpdate.getTime()) / 1000)}s ago</span>}
          <div style={{ marginLeft: 'auto', display: 'flex', gap: '12px' }}>
            <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>TOTAL: <span style={{ color: '#4fc3f7', fontWeight: 700 }}>{fmtVal(totalValue)}</span></span>
            <span style={{ fontSize: 'var(--mc-font-xl)', fontFamily: 'var(--font-mc-mono)' }}><span style={{ color: '#66bb6a' }}>↑{bullCount}</span> <span style={{ color: '#ef5350' }}>↓{bearCount}</span></span>
            <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>PRICES: <span style={{ color: Object.keys(livePrices).length > 0 ? '#66bb6a' : '#ef5350', fontWeight: 700 }}>{Object.keys(livePrices).length}</span></span>
          </div>
        </div>

        {/* Legends */}
        <div style={{ display: 'flex', gap: '6px', marginBottom: '6px', flexWrap: 'wrap' }}>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', padding: '2px 0' }}>$$:</span>
          {[{ l: '<$50K', c: '#7c4dff' }, { l: '$50-100K', c: '#448aff' }, { l: '$100-250K', c: '#00bcd4' }, { l: '$250-500K', c: '#66bb6a' }, { l: '$500K-1M', c: '#ffd600' }, { l: '$1-5M', c: '#ff9800' }, { l: '$5M+', c: '#e040fb' }].map((x, i) => (
            <span key={i} style={{ fontSize: 'var(--mc-font-xl)', color: x.c, fontFamily: 'var(--font-mc-mono)', fontWeight: 600, padding: '2px 5px', background: `${x.c}10`, borderRadius: '3px', border: `1px solid ${x.c}25` }}>{x.l}</span>
          ))}
        </div>
        <div style={{ display: 'flex', gap: '10px', marginBottom: '12px', flexWrap: 'wrap', alignItems: 'center' }}>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>=A at ask · &gt;A above ask · =B at bid · &gt;B above bid</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#1a3a4a' }}>|</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, padding: '1px 6px', borderRadius: '3px', background: '#ffd60022', color: '#ffd600', border: '1px solid #ffd60033', fontFamily: 'var(--font-mc-mono)' }}>U = Unusual</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>● Bull</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>● Bear</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#ffd600', fontFamily: 'var(--font-mc-mono)' }}>● Unusual</span>
        </div>
      {/* SENTIMENT GUIDE */}
      <div style={{ display: 'flex', gap: '16px', padding: '6px 14px', marginBottom: '6px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', flexWrap: 'wrap', alignItems: 'center' }}>
        <span style={{ color: '#607d8b', fontWeight: 700 }}>SENTIMENT:</span>
        <span><span style={{ color: '#66bb6a' }}>■</span> CALL on ASK = BULLISH</span>
        <span><span style={{ color: '#ef5350' }}>■</span> CALL on BID = BEARISH</span>
        <span><span style={{ color: '#ef5350' }}>■</span> PUT on ASK = BEARISH</span>
        <span><span style={{ color: '#66bb6a' }}>■</span> PUT on BID = BULLISH</span>
        <span style={{ color: '#455a64' }}>|</span>
        <span style={{ color: '#ffd600' }}>🔥 = High Conviction (Unusual + Sweep + ASK + $100K+)</span>
      </div>

        <div style={{ display: 'flex', justifyContent: 'flex-end', gap: '8px', marginBottom: '10px' }}>
          {editMode && <button onClick={handleSaveLayout} style={{ padding: '6px 14px', background: layoutDirty ? '#66bb6a22' : '#0d1117', border: '1px solid ' + (layoutDirty ? '#66bb6a' : '#1a3a4a'), borderRadius: '6px', color: layoutDirty ? '#66bb6a' : '#607d8b', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', fontWeight: 700, cursor: 'pointer' }}>💾 SAVE</button>}
          {editMode && <button onClick={handleResetLayout} style={{ padding: '6px 14px', background: '#0d1117', border: '1px solid #ef5350', borderRadius: '6px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', fontWeight: 700, cursor: 'pointer' }}>↻ RESET</button>}
          <button onClick={() => setEditMode(m => !m)} style={{ padding: '6px 14px', background: editMode ? '#4fc3f722' : '#0d1117', border: '1px solid ' + (editMode ? '#4fc3f7' : '#1a3a4a'), borderRadius: '6px', color: editMode ? '#4fc3f7' : '#90a4ae', fontFamily: 'var(--font-mc-mono)', fontSize: 'var(--mc-font-badge)', fontWeight: 700, cursor: 'pointer' }}>{editMode ? '✓ DONE' : '✎ EDIT LAYOUT'}</button>
        </div>

        <GridLayout
          className="mc-options-grid"
          layout={layout}
          cols={24}
          rowHeight={50}
          width={gridWidth}
          margin={[10, 10]}
          containerPadding={[0, 0]}
          draggableHandle=".mc-drag-handle"
          isDraggable={editMode}
          isResizable={editMode}
          onLayoutChange={handleLayoutChange}
          compactType={null}
          preventCollision={true}
        >
          <div key="calls"><Block editMode={editMode} title="CALLS" count={calls.length} color="#66bb6a">
            {calls.length === 0 ? noItems : calls.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="puts"><Block editMode={editMode} title="PUTS" count={puts.length} color="#ef5350">
            {puts.length === 0 ? noItems : puts.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="sweeps"><Block editMode={editMode} title="SWEEPS" count={sweeps.length} color="#ff9800">
            {sweeps.length === 0 ? noItems : sweeps.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="blocks"><Block editMode={editMode} title="BLOCKS" count={blocks.length} color="#4fc3f7">
            {blocks.length === 0 ? noItems : blocks.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="alerts"><Block editMode={editMode} title="ALERTS" count={alerts.length} color="#ce93d8">
            {alerts.length === 0 ? noItems : alerts.slice(0, 50).map((a, i) => <AlertRow key={i} a={a} livePrice={livePrices[a.Symbol]} onClick={() => setSelected({ type: 'alert', data: a })} />)}
          </Block></div>
          <div key="liveflows"><Block editMode={editMode} title="LIVE FLOWS" count={flows.length} color="#4fc3f7">
            {flows.length === 0 ? noItems : flows.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="unusualflow"><Block golden editMode={editMode} title="UNUSUAL FLOW" count={unusualFlow.length} color="#ffd600">
            {unusualFlow.length === 0 ? noItems : unusualFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="hugeflow"><Block golden editMode={editMode} title="HUGE FLOW ($1M+)" count={hugeFlow.length} color="#ff9800">
            {hugeFlow.length === 0 ? noItems : hugeFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="weeklyflow"><Block golden editMode={editMode} title="WEEKLY FLOW" count={weeklyFlow.length} color="#4fc3f7">
            {weeklyFlow.length === 0 ? noItems : weeklyFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="repeatingflow"><Block golden editMode={editMode} title="REPEATING FLOW" count={repeatingAlerts.length} color="#ce93d8">
            {repeatingAlerts.length === 0 ? noItems : repeatingAlerts.slice(0, 50).map((a, i) => <AlertRow key={i} a={a} livePrice={livePrices[a.Symbol]} onClick={() => setSelected({ type: 'alert', data: a })} />)}
          </Block></div>
          <div key="etfflow"><Block golden editMode={editMode} title="ETF FLOW" count={etfFlow.length} color="#66bb6a">
            {etfFlow.length === 0 ? noItems : etfFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
          <div key="unusualhuge"><Block golden editMode={editMode} title="UNUSUAL HUGE ($500K+)" count={unusualHugeFlow.length} color="#e040fb">
            {unusualHugeFlow.length === 0 ? noItems : unusualHugeFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block></div>
        </GridLayout>
      </div>

      {popup && <SentimentPopup f={popup} onClose={() => setPopup(null)} />}
      {selected && <DetailPanel item={selected} onClose={() => setSelected(null)} livePrice={selectedLive} />}
    </div>
  );
}
