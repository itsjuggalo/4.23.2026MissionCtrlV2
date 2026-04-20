'use client';
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
  if (v >= 1000000) return '#ffd600';
  if (v >= 500000) return '#ff9800';
  if (v >= 250000) return '#4fc3f7';
  if (v >= 100000) return '#e0e0e0';
  if (v >= 50000) return '#90a4ae';
  return '#607d8b';
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
  if (vol >= 5000) return '#ffd600';
  if (vol >= 2000) return '#ff9800';
  if (vol >= 500) return '#4fc3f7';
  if (vol >= 100) return '#e0e0e0';
  if (vol >= 50) return '#90a4ae';
  return '#607d8b';
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
  const priceMove = livePrice ? spotVsCurrent(f.Spot, livePrice.price) : null;

  return (
    <div onClick={onClick} style={{
      display: 'flex', justifyContent: 'space-between', alignItems: 'center',
      padding: '10px 14px', borderBottom: '1px solid #0d1117', cursor: 'pointer',
      background: unusualHuge ? '#e040fb08' : huge ? '#ffd60008' : 'transparent',
      borderLeft: unusualHuge ? '3px solid #e040fb' : unusual ? '3px solid #ffd600' : '3px solid transparent',
    }}
      onMouseEnter={e => (e.currentTarget.style.background = '#1a3a4a33')}
      onMouseLeave={e => (e.currentTarget.style.background = unusualHuge ? '#e040fb08' : huge ? '#ffd60008' : 'transparent')}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '5px', minWidth: 0 }}>
        <span style={{ width: '10px', height: '10px', borderRadius: '50%', background: sColor, flexShrink: 0, boxShadow: `0 0 4px ${sColor}88` }} />
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', width: '26px', flexShrink: 0 }}>{timeAgo(f.Time)}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)', width: '42px', flexShrink: 0 }}>{f.Symbol}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: sColor, fontWeight: 600, width: '12px', flexShrink: 0 }}>{f.OptionType?.slice(0, 1)}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: sColor, fontFamily: 'var(--font-mc-mono)' }}>${f.Strike}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{f.ExpiryStr?.slice(5)}</span>
      </div>

      {/* SENTIMENT GUIDE */}
      <div style={{ display: 'flex', gap: '16px', padding: '6px 14px', marginBottom: '6px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', fontSize: 'var(--mc-font-label)', fontFamily: 'var(--font-mc-mono)', flexWrap: 'wrap', alignItems: 'center' }}>
        <span style={{ color: '#607d8b', fontWeight: 700 }}>SENTIMENT:</span>
        <span><span style={{ color: '#66bb6a' }}>■</span> CALL on ASK = BULLISH</span>
        <span><span style={{ color: '#ef5350' }}>■</span> CALL on BID = BEARISH</span>
        <span><span style={{ color: '#ef5350' }}>■</span> PUT on ASK = BEARISH</span>
        <span><span style={{ color: '#66bb6a' }}>■</span> PUT on BID = BULLISH</span>
        <span style={{ color: '#455a64' }}>|</span>
        <span style={{ color: '#ffd600' }}>🔥 = Unusual Sweep on ASK (high conviction buy)</span>
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: '4px' }}>
        {/* Spot @ alert */}
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{fmtPrice(f.Spot)}</span>
        {/* Move since alert */}
        {priceMove && <span style={{ fontSize: 'var(--mc-font-sm)', color: priceMove.color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{priceMove.text}</span>}
        {/* Contract price + postfix */}
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{postfix}</span>
        {/* Premium */}
        <span style={{ fontSize: 'var(--mc-font-xl)', color: valColor, fontWeight: f.Value >= 250000 ? 700 : 400, fontFamily: 'var(--font-mc-mono)', minWidth: '40px', textAlign: 'right', textShadow: f.Value >= 5000000 ? '0 0 8px #e040fb66' : f.Value >= 1000000 ? '0 0 6px #ffd60044' : 'none' }}>{fmtVal(f.Value)}</span>
        {/* Volume */}
        <span style={{ fontSize: 'var(--mc-font-xl)', color: volColor, fontFamily: 'var(--font-mc-mono)', minWidth: '28px', textAlign: 'right' }}>{f.Volume >= 1000 ? `${(f.Volume/1000).toFixed(1)}K` : f.Volume}</span>
        {unusual && <span style={{ fontSize: 'var(--mc-font-xs)', fontWeight: 700, padding: '0px 3px', borderRadius: '2px', background: '#ffd60022', color: '#ffd600', border: '1px solid #ffd60044' }}>U</span>}
        <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, padding: '1px 3px', borderRadius: '3px', background: isSweep ? '#ff980022' : '#4fc3f722', color: isSweep ? '#ff9800' : '#4fc3f7' }}>{isSweep ? 'SWP' : 'BLK'}</span>
      </div>
    </div>
  );
}

function AlertRow({ a, onClick, livePrice }: { a: AlertEntry; onClick: () => void; livePrice?: { price: number; change: number; changePct: number } }) {
  const sColor = a.isBullish ? '#66bb6a' : '#ef5350';
  const highConviction = a.SWEEPS > 0 && a.isBullish && a.Value >= 100000;
  const priceMove = livePrice ? spotVsCurrent(a.Spot, livePrice.price) : null;
  return (
    <div onClick={onClick} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px 14px', borderBottom: '1px solid #0d1117', cursor: 'pointer' }}
      onMouseEnter={e => (e.currentTarget.style.background = '#1a3a4a33')}
      onMouseLeave={e => (e.currentTarget.style.background = 'transparent')}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '5px', minWidth: 0 }}>
        <span style={{ width: '10px', height: '10px', borderRadius: '50%', background: sColor, flexShrink: 0, boxShadow: `0 0 4px ${sColor}88` }} />
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#455a64', fontFamily: 'var(--font-mc-mono)', width: '26px', flexShrink: 0 }}>{timeAgo(a.Time)}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: sColor, fontWeight: 700, fontFamily: 'var(--font-mc-mono)', width: '42px', flexShrink: 0 }}>{a.Symbol}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: sColor, fontWeight: 600 }}>{a.OptionType?.slice(0, 1)} ${a.Strike}</span>
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: '4px' }}>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>{fmtPrice(a.Spot)}</span>
        {priceMove && <span style={{ fontSize: 'var(--mc-font-sm)', color: priceMove.color, fontFamily: 'var(--font-mc-mono)', fontWeight: 600 }}>{priceMove.text}</span>}
        {(a.NumOfAlerts || 0) > 1 && <span style={{ fontSize: 'var(--mc-font-xl)', color: '#ce93d8', fontFamily: 'var(--font-mc-mono)' }}>×{a.NumOfAlerts}</span>}
        <span style={{ fontSize: 'var(--mc-font-xl)', color: a.DTE <= 2 ? '#ff9800' : '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>{a.DTE}d</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', color: volumeColor(a.Volume), fontFamily: 'var(--font-mc-mono)' }}>{a.Volume >= 1000 ? `${(a.Volume/1000).toFixed(1)}K` : a.Volume}</span>
        <span style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 700, padding: '1px 5px', borderRadius: '3px', background: `${sColor}22`, color: sColor }}>{a.isBullish ? 'BULL' : 'BEAR'}</span>
      </div>
    </div>
  );
}

function Block({ title, count, color, children }: { title: string; count: number; color: string; children: React.ReactNode }) {
  return (
    <div style={{ background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '8px', overflow: 'hidden', display: 'flex', flexDirection: 'column' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px 14px', background: '#0d1117', borderBottom: '1px solid #1a3a4a' }}>
        <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, color, fontFamily: 'var(--font-mc-mono)', letterSpacing: '0.5px' }}>{title}</span>
        <span style={{ fontSize: 'var(--mc-font-xl)', fontWeight: 700, padding: '1px 8px', borderRadius: '10px', background: `${color}18`, color, fontFamily: 'var(--font-mc-mono)' }}>{count}</span>
      </div>
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

export function OptionsPage() {
  const [flows, setFlows] = useState<FlowEntry[]>([]);
  const [alerts, setAlerts] = useState<AlertEntry[]>([]);
  const [livePrices, setLivePrices] = useState<LivePrices>({});
  const [loading, setLoading] = useState(true);
  const [selected, setSelected] = useState<SelectedItem>(null);
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
          {[{ l: '<$50K', c: '#607d8b' }, { l: '$50-100K', c: '#90a4ae' }, { l: '$100-250K', c: '#e0e0e0' }, { l: '$250-500K', c: '#4fc3f7' }, { l: '$500K-1M', c: '#ff9800' }, { l: '$1-5M', c: '#ffd600' }, { l: '$5M+', c: '#e040fb' }].map((x, i) => (
            <span key={i} style={{ fontSize: 'var(--mc-font-xl)', color: x.c, fontFamily: 'var(--font-mc-mono)', fontWeight: 600, padding: '2px 5px', background: `${x.c}10`, borderRadius: '3px', border: `1px solid ${x.c}25` }}>{x.l}</span>
          ))}
        </div>
        <div style={{ display: 'flex', gap: '10px', marginBottom: '12px', flexWrap: 'wrap', alignItems: 'center' }}>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)' }}>=A at ask · &gt;A above ask · =B at bid · &gt;B above bid</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#1a3a4a' }}>|</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#66bb6a', fontFamily: 'var(--font-mc-mono)' }}>● Bull</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#ef5350', fontFamily: 'var(--font-mc-mono)' }}>● Bear</span>
          <span style={{ fontSize: 'var(--mc-font-xl)', color: '#ffd600', fontFamily: 'var(--font-mc-mono)' }}>● Unusual</span>
        </div>

        {/* TOP 3x2 */}
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '10px', marginBottom: '16px' }}>
          <Block title="CALLS" count={calls.length} color="#66bb6a">
            {calls.length === 0 ? noItems : calls.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="PUTS" count={puts.length} color="#ef5350">
            {puts.length === 0 ? noItems : puts.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="SWEEPS" count={sweeps.length} color="#ff9800">
            {sweeps.length === 0 ? noItems : sweeps.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="BLOCKS" count={blocks.length} color="#4fc3f7">
            {blocks.length === 0 ? noItems : blocks.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="ALERTS" count={alerts.length} color="#ce93d8">
            {alerts.length === 0 ? noItems : alerts.slice(0, 50).map((a, i) => <AlertRow key={i} a={a} livePrice={livePrices[a.Symbol]} onClick={() => setSelected({ type: 'alert', data: a })} />)}
          </Block>
          <Block title="LIVE FLOWS" count={flows.length} color="#4fc3f7">
            {flows.length === 0 ? noItems : flows.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
        </div>

        {/* GOLDEN TICKETS */}
        <div style={{ textAlign: 'center', margin: '8px 0 16px 0', position: 'relative' }}>
          <div style={{ position: 'absolute', top: '50%', left: 0, right: 0, height: '1px', background: 'linear-gradient(90deg, transparent, #ffd60044, #ffd600, #ffd60044, transparent)' }} />
          <span style={{ position: 'relative', padding: '0 24px', background: '#060e1a', fontSize: 'var(--mc-font-hero)', fontWeight: 800, fontFamily: 'var(--font-mc-mono)', letterSpacing: '3px', color: '#ffd600', textShadow: '0 0 20px #ffd60066, 0 0 40px #ffd60033' }}>GOLDEN TICKETS</span>
        </div>

        {/* BOTTOM 3x2 */}
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '10px' }}>
          <Block title="UNUSUAL FLOW" count={unusualFlow.length} color="#ffd600">
            {unusualFlow.length === 0 ? noItems : unusualFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="HUGE FLOW ($1M+)" count={hugeFlow.length} color="#ff9800">
            {hugeFlow.length === 0 ? noItems : hugeFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="WEEKLY FLOW" count={weeklyFlow.length} color="#4fc3f7">
            {weeklyFlow.length === 0 ? noItems : weeklyFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="REPEATING FLOW" count={repeatingAlerts.length} color="#ce93d8">
            {repeatingAlerts.length === 0 ? noItems : repeatingAlerts.slice(0, 50).map((a, i) => <AlertRow key={i} a={a} livePrice={livePrices[a.Symbol]} onClick={() => setSelected({ type: 'alert', data: a })} />)}
          </Block>
          <Block title="ETF FLOW" count={etfFlow.length} color="#66bb6a">
            {etfFlow.length === 0 ? noItems : etfFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
          <Block title="UNUSUAL HUGE ($500K+)" count={unusualHugeFlow.length} color="#e040fb">
            {unusualHugeFlow.length === 0 ? noItems : unusualHugeFlow.slice(0, 50).map((f, i) => <FlowRow key={i} f={f} livePrice={livePrices[f.Symbol]} onClick={() => setSelected({ type: 'flow', data: f })} />)}
          </Block>
        </div>
      </div>

      {selected && <DetailPanel item={selected} onClose={() => setSelected(null)} livePrice={selectedLive} />}
    </div>
  );
}
