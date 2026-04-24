// ═══════════════════════════════════════════════════════════════
// Options Page — MOBILE VERSION
// Preserved exact layout with ~720px centered column, single-stack cards.
// Use this as the blueprint when we build the mobile version of Mission Control.
// ═══════════════════════════════════════════════════════════════
'use client';

import React, { useEffect, useMemo, useState } from 'react';

// ──────────────────────────────────────────────────────────
// Types
// ──────────────────────────────────────────────────────────

interface AnalystSignal {
  id: string;
  source: string;
  sourceGroup: 'name' | 'vivid';
  tab: 'scalps' | 'swings' | 'leaps';
  symbol: string;
  shortName: string;
  strike: string | number;
  expiry: number | null;
  isPut: boolean;
  isWeekly: boolean;
  isFree: boolean;
  risk: string;
  category: string;
  buyTarget: number | null;
  earlyTarget: number | null;
  stopLoss: number | null;
  reduceLoss: number | null;
  sellTarget: number | null;
  sellTarget2: number | null;
  sellTarget3: number | null;
  status: string;
  exitTime: number | null;
  isClosed: boolean;
  ts: number;
  logoUrl: string | null;
  logoFallback: string;
  expiryStr: string;
  contractLabel: string;
  ribbonType: 'open' | 'profit' | 'stopped' | 'riding';
  ribbonLabel: string;
}

interface AnalystResponse {
  generated_at: string;
  stats: {
    openTotal: number;
    closedTotal: number;
    recentClosed: number;
    winRate30d: number;
    scalpsOpen: number;
    swingsOpen: number;
    leapsOpen: number;
    sourceOpenCounts: { name: number; vivid: number };
  };
  byTab: {
    scalps: { open: AnalystSignal[]; closed: AnalystSignal[] };
    swings: { open: AnalystSignal[]; closed: AnalystSignal[] };
    leaps:  { open: AnalystSignal[]; closed: AnalystSignal[] };
  };
}

interface FlowEntry {
  Symbol: string;
  OptionSymbol: string;
  Strike: number;
  OptionType: 'Call' | 'Put';
  ExpiryStr: string;
  Price: number;
  Value: number;
  Volume: number;
  OI: number;
  BidAskType: string;
  BlockType: 'SWEEP' | 'BLOCK' | string;
  Time: number;
}

interface AlertEntry {
  AlertType: string;
  Symbol: string;
  OptionSymbol: string;
  Strike: number;
  OptionType: 'Call' | 'Put';
  ExpiryStr: string;
  AlertPrice: number;
  totalFlowValue: number;
  SWEEPS: number;
  BLOCKS: number;
  Volume: number;
  OI: number;
  DTE: number;
  isBullish: boolean;
  Updated: number;
  _history?: {
    firstPrice: number;
    lastPrice: number;
    maxPrice: number;
    gainPct: number;
    maxGainPct: number;
    numUpdates: number;
    firstSeen: number;
    lastSeen: number;
  };
}

interface FlowResponse {
  alerts: AlertEntry[];
  flow: FlowEntry[];
}

type PrimaryTab = 'scalps' | 'swings' | 'leaps' | 'flowAlerts' | 'optionFlow';
type SourceFilter = 'all' | 'name' | 'vivid';
type AlertCategory = 'all' | 'unusual' | 'huge' | 'weekly' | 'repeaters' | 'etf';

// ──────────────────────────────────────────────────────────
// Helpers
// ──────────────────────────────────────────────────────────

const fmtMoney = (n: number | null | undefined): string => {
  if (n == null) return '—';
  if (n >= 1_000_000) return `$${(n / 1_000_000).toFixed(1)}M`;
  if (n >= 1_000) return `$${(n / 1_000).toFixed(0)}K`;
  return `$${n.toFixed(2)}`;
};

const fmtCount = (n: number): string => {
  if (n >= 1000) return `${(n / 1000).toFixed(1)}K`;
  return String(n);
};

const ago = (ts: number): string => {
  if (!ts) return '';
  const secs = Math.floor(Date.now() / 1000) - ts;
  if (secs < 60) return `${secs}s`;
  const mins = Math.floor(secs / 60);
  if (mins < 60) return `${mins}m`;
  const hrs = Math.floor(mins / 60);
  if (hrs < 24) return `${hrs}h`;
  return `${Math.floor(hrs / 24)}d`;
};

const premColor = (v: number): string => {
  if (v >= 2_000_000) return '#e040fb';
  if (v >= 1_000_000) return '#ff9800';
  return '#90a4ae';
};

const categorizeAlert = (a: AlertEntry): AlertCategory | null => {
  const t = (a.AlertType || '').toLowerCase();
  if (t.includes('etf')) return 'etf';
  if (t.includes('weekly')) return 'weekly';
  if (t.includes('repeat')) return 'repeaters';
  if (t.includes('unusual')) return 'unusual';
  if (t.includes('high_flow') || t.includes('huge')) return 'huge';
  return null;
};

const isAlertQualifying = (a: AlertEntry): boolean => {
  const t = (a.AlertType || '').toLowerCase();
  if (t.includes('unusual')) return true;
  if (a.totalFlowValue >= 1_000_000) return true;
  if ((a.SWEEPS + a.BLOCKS) >= 3 && a.totalFlowValue >= 500_000) return true;
  return false;
};

// ──────────────────────────────────────────────────────────
// Fire badge SVG
// ──────────────────────────────────────────────────────────
const FireBadge: React.FC = () => (
  <span style={{
    display: 'inline-flex', alignItems: 'center', gap: '3px',
    padding: '2px 7px', borderRadius: '10px',
    background: 'linear-gradient(90deg, #ff6b00 0%, #ffd600 100%)',
    color: '#1a0f00', fontSize: '9px', fontWeight: 700, letterSpacing: '0.5px',
    textTransform: 'uppercase', boxShadow: '0 0 8px #ff9800aa',
    flexShrink: 0,
  }}>
    <svg width="10" height="10" viewBox="0 0 24 24" fill="currentColor">
      <path d="M13.5 0.67s.74 2.65.74 4.8c0 2.06-1.35 3.73-3.41 3.73-2.07 0-3.63-1.67-3.63-3.73l.03-.36C5.21 7.51 4 10.62 4 14c0 4.42 3.58 8 8 8s8-3.58 8-8C20 8.61 17.41 3.8 13.5 0.67zM11.71 19c-1.78 0-3.22-1.4-3.22-3.14 0-1.62 1.05-2.76 2.81-3.12 1.77-.36 3.6-1.21 4.62-2.58.39 1.29.59 2.65.59 4.04 0 2.65-2.15 4.8-4.8 4.8z"/>
    </svg>
  </span>
);

// ──────────────────────────────────────────────────────────
// Logo with clearbit + fallback to 2-letter monogram
// ──────────────────────────────────────────────────────────
const TickerLogo: React.FC<{ symbol: string; logoUrl: string | null; size?: number }> = ({ symbol, logoUrl, size = 36 }) => {
  const [errored, setErrored] = useState(false);
  if (!logoUrl || errored) {
    return (
      <div style={{
        width: size, height: size, borderRadius: '50%',
        background: '#1a2332', display: 'flex', alignItems: 'center', justifyContent: 'center',
        color: '#90a4ae', fontSize: size / 3, fontWeight: 600, flexShrink: 0,
      }}>
        {(symbol || '?').slice(0, 3).toUpperCase()}
      </div>
    );
  }
  return (
    <img
      src={logoUrl}
      onError={() => setErrored(true)}
      alt={symbol}
      style={{
        width: size, height: size, borderRadius: '50%',
        background: '#fff', objectFit: 'contain', flexShrink: 0,
      }}
    />
  );
};

// ──────────────────────────────────────────────────────────
// Signal Card (Scalps/Swings/Leaps)
// ──────────────────────────────────────────────────────────
const SignalCard: React.FC<{ sig: AnalystSignal; isPast?: boolean }> = ({ sig, isPast = false }) => {
  const ribbonColors: Record<string, { bg: string; fg: string }> = {
    open:    { bg: '#66bb6a', fg: '#0a1a0f' },
    profit:  { bg: '#66bb6a', fg: '#0a1a0f' },
    riding:  { bg: '#ffd600', fg: '#1a1400' },
    stopped: { bg: '#ef5350', fg: '#1a0a0a' },
  };
  const rc = ribbonColors[sig.ribbonType] || ribbonColors.open;

  const riskChipStyle = (risk: string) => {
    const r = (risk || '').toUpperCase();
    if (r === 'VH') return { bg: '#ef535022', border: '#ef535055', color: '#ef5350' };
    if (r === 'HI') return { bg: '#ff980022', border: '#ff980055', color: '#ff9800' };
    return { bg: '#ffd60022', border: '#ffd60055', color: '#ffd600' };
  };
  const rChip = riskChipStyle(sig.risk);

  const chipBase: React.CSSProperties = {
    padding: '1px 7px', borderRadius: '10px', fontSize: '9px',
    letterSpacing: '0.4px', fontWeight: 500,
  };

  return (
    <div style={{
      padding: '12px 14px', borderRadius: '8px', marginBottom: '10px',
      background: isPast ? '#0a0f15' : '#07101a',
      border: '1px solid #1a2332', position: 'relative', overflow: 'hidden',
      opacity: isPast ? 0.88 : 1,
    }}>
      {/* Ribbon */}
      <div style={{
        position: 'absolute', top: '10px', right: '-30px',
        padding: '2px 32px', fontSize: '9px', fontWeight: 700,
        letterSpacing: '0.8px', transform: 'rotate(35deg)',
        textTransform: 'uppercase', background: rc.bg, color: rc.fg,
      }}>{sig.ribbonLabel}</div>

      {/* Top: logo + ticker + time */}
      <div style={{ display: 'flex', gap: '12px', marginRight: '65px', alignItems: 'flex-start' }}>
        <TickerLogo symbol={sig.symbol} logoUrl={sig.logoUrl} />
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{
            color: sig.isPut ? '#ef5350' : '#66bb6a',
            fontSize: '15px', fontWeight: 500,
          }}>{sig.contractLabel}</div>
          <div style={{ color: '#607d8b', fontSize: '11px', marginTop: '1px' }}>
            {sig.shortName || sig.symbol}
            {sig.category && ` · ${sig.category}`}
          </div>
          {/* Chip row */}
          <div style={{ display: 'flex', gap: '5px', marginTop: '6px', alignItems: 'center', flexWrap: 'wrap' }}>
            <span style={{ ...chipBase, background: '#1a2332', color: '#90a4ae' }}>{sig.source}</span>
            {sig.risk && (
              <span style={{ ...chipBase, background: rChip.bg, border: `1px solid ${rChip.border}`, color: rChip.color }}>
                {sig.risk} risk
              </span>
            )}
            <span style={{
              ...chipBase,
              background: sig.isFree ? '#66bb6a22' : '#e040fb22',
              border: `1px solid ${sig.isFree ? '#66bb6a55' : '#e040fb55'}`,
              color: sig.isFree ? '#66bb6a' : '#e040fb',
            }}>{sig.isFree ? 'Free' : 'Premium'}</span>
          </div>
        </div>
        <div style={{ color: '#607d8b', fontSize: '10px', whiteSpace: 'nowrap', marginTop: '3px' }}>
          {ago(sig.ts)} ago
        </div>
      </div>

      {/* Targets grid */}
      <div style={{
        display: 'grid', gridTemplateColumns: '1fr 1fr 1fr',
        gap: '12px', marginTop: '10px', paddingTop: '10px',
        borderTop: '1px solid #1a2332',
      }}>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '2px' }}>
            Buy Target
          </div>
          <div style={{ color: '#ffffff', fontSize: '13px', fontWeight: 500 }}>
            {sig.buyTarget != null ? `$${sig.buyTarget.toFixed(2)}` : '—'}
          </div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '2px' }}>
            Stop Loss
          </div>
          <div style={{ color: '#ef5350', fontSize: '13px', fontWeight: 500 }}>
            {sig.stopLoss != null ? `$${sig.stopLoss.toFixed(2)}` : '—'}
          </div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '2px' }}>
            Early Target
          </div>
          <div style={{ color: '#66bb6a', fontSize: '13px', fontWeight: 500 }}>
            {sig.earlyTarget != null ? `$${sig.earlyTarget.toFixed(2)}` : '—'}
          </div>
        </div>
      </div>

      {/* Sell targets row */}
      <div style={{
        display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)',
        gap: '8px', marginTop: '10px',
      }}>
        {[
          { label: 'Sell 1', val: sig.sellTarget },
          { label: 'Sell 2', val: sig.sellTarget2 },
          { label: 'Sell 3', val: sig.sellTarget3 },
        ].map((t, i) => (
          <div key={i} style={{
            padding: '5px 8px', borderRadius: '4px',
            background: t.val != null ? '#0a1422' : '#07101a',
            border: `1px solid ${t.val != null ? '#1a2332' : '#0a1422'}`,
            textAlign: 'center',
          }}>
            <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase' }}>{t.label}</div>
            <div style={{ color: t.val != null ? '#ffffff' : '#394352', fontSize: '12px', fontWeight: 500, marginTop: '1px' }}>
              {t.val != null ? `$${t.val.toFixed(2)}` : '—'}
            </div>
          </div>
        ))}
      </div>

      {/* Status line */}
      {sig.status && (
        <div style={{
          marginTop: '10px', paddingTop: '8px',
          borderTop: '1px solid #1a2332',
          color: '#90a4ae', fontSize: '11px', fontStyle: 'italic',
        }}>
          Status: <span style={{ color: '#e4e4e4', fontStyle: 'normal', fontWeight: 500 }}>{sig.status}</span>
        </div>
      )}
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Alert Card (Flow Alerts tab)
// ──────────────────────────────────────────────────────────
const AlertCard: React.FC<{ a: AlertEntry }> = ({ a }) => {
  const qualifying = isAlertQualifying(a);
  const bull = a.isBullish;
  const strike = String(a.Strike).replace(/\.0+$/, '');
  const cp = a.OptionType?.charAt(0);
  const exp = a.ExpiryStr?.slice(5) || a.ExpiryStr || '';
  const contractName = `${a.Symbol} ${strike}${cp} ${exp}`;
  const h = a._history;

  return (
    <div style={{
      padding: '12px 14px', borderRadius: '8px', marginBottom: '8px',
      background: qualifying ? '#ffd60014' : '#05080c',
      border: `1px solid ${qualifying ? '#ffd600' : '#1a2332'}`,
      boxShadow: qualifying ? '0 0 8px #ffd60022' : undefined,
    }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: '12px' }}>
        <span style={{ color: '#607d8b', fontSize: '11px', minWidth: '42px' }}>{ago(a.Updated)}</span>
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '7px', marginBottom: '3px' }}>
            <span style={{ color: bull ? '#66bb6a' : '#ef5350', fontWeight: 500, fontSize: '14px' }}>
              {contractName}
            </span>
            {qualifying && <FireBadge />}
          </div>
          <div style={{ display: 'flex', alignItems: 'baseline', gap: '6px' }}>
            <span style={{ color: '#607d8b', fontSize: '11px' }}>Flow Premium =</span>
            <span style={{ fontWeight: 500, fontSize: '15px', color: premColor(a.totalFlowValue) }}>
              {fmtMoney(a.totalFlowValue)}
            </span>
          </div>
        </div>
      </div>
      <div style={{
        display: 'grid', gridTemplateColumns: 'auto auto auto auto',
        gap: '16px', marginTop: '10px', paddingTop: '10px',
        borderTop: '1px solid #1a2332', fontSize: '11px', whiteSpace: 'nowrap',
      }}>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', marginBottom: '3px' }}>Sweeps / Blocks</div>
          <div style={{ color: '#ffffff' }}>{a.SWEEPS} / {a.BLOCKS}</div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', marginBottom: '3px' }}>Size / OI</div>
          <div style={{ color: '#ffffff' }}>{fmtCount(a.Volume)} / {fmtCount(a.OI)}</div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', marginBottom: '3px' }}>Alert → Last / High</div>
          <div style={{ color: '#ffffff' }}>
            ${a.AlertPrice?.toFixed(2) || '—'}
            {h && ` → $${h.lastPrice.toFixed(2)} / $${h.maxPrice.toFixed(2)}`}
          </div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', marginBottom: '3px' }}>Gain / Max</div>
          <div>
            {h ? (
              <>
                <span style={{ color: h.gainPct >= 0 ? '#66bb6a' : '#ef5350' }}>
                  {h.gainPct >= 0 ? '+' : ''}{h.gainPct.toFixed(2)}%
                </span>
                <span style={{ color: '#ffffff' }}> / </span>
                <span style={{ color: '#66bb6a' }}>+{h.maxGainPct.toFixed(2)}%</span>
              </>
            ) : <span style={{ color: '#394352' }}>—</span>}
          </div>
        </div>
      </div>
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Flow Tape Row (Option Flow tab - dense, like app screenshot 4)
// ──────────────────────────────────────────────────────────
const FlowTapeRow: React.FC<{ f: FlowEntry }> = ({ f }) => {
  const isBull = f.BidAskType?.toUpperCase().includes('A') && f.OptionType === 'Call';
  const isBear = f.BidAskType?.toUpperCase().includes('A') && f.OptionType === 'Put';
  const color = isBull ? '#66bb6a' : isBear ? '#ef5350' : '#ffd600';
  const highlight = f.Value >= 1_000_000;
  const time = new Date(f.Time * 1000).toLocaleTimeString('en-US', { hour12: false });
  const pillBg = f.BlockType === 'SWEEP' ? '#ff980022' : '#4fc3f722';
  const pillBorder = f.BlockType === 'SWEEP' ? '#ff9800' : '#4fc3f7';

  return (
    <div style={{
      display: 'grid',
      gridTemplateColumns: '62px 52px 62px 48px 34px 78px 48px 60px',
      gap: '8px', padding: '5px 12px', fontSize: '11px', alignItems: 'center',
      borderBottom: '1px solid #0a1220',
      background: highlight ? '#ffd60010' : 'transparent',
      borderLeft: highlight ? '2px solid #ffd600' : '2px solid transparent',
      color,
    }}>
      <span>{time}</span>
      <span style={{ fontWeight: 500 }}>{f.Symbol}</span>
      <span>{f.ExpiryStr?.slice(2) || ''}</span>
      <span>{f.Strike}</span>
      <span>{f.OptionType === 'Call' ? 'CAL' : 'PUT'}</span>
      <span>{f.Price?.toFixed(2)}{f.BidAskType}</span>
      <span style={{
        padding: '1px 6px', borderRadius: '3px', fontSize: '9px',
        background: pillBg, border: `1px solid ${pillBorder}`, color: pillBorder,
        textAlign: 'center',
      }}>{f.BlockType === 'SWEEP' ? 'SWP' : 'BLK'}</span>
      <span style={{ textAlign: 'right' }}>{fmtMoney(f.Value)}</span>
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Tab buttons
// ──────────────────────────────────────────────────────────
const PrimaryTabButton: React.FC<{
  label: string; count?: number; active: boolean; onClick: () => void;
}> = ({ label, count, active, onClick }) => (
  <div onClick={onClick} style={{
    padding: '8px 12px', fontSize: '12px', cursor: 'pointer',
    color: active ? '#66bb6a' : '#607d8b',
    fontWeight: active ? 500 : 400, letterSpacing: '0.3px',
    position: 'relative', whiteSpace: 'nowrap',
  }}>
    {label}
    {count != null && (
      <span style={{ color: '#607d8b', fontSize: '10px', marginLeft: '4px' }}>({count})</span>
    )}
    {active && <div style={{
      position: 'absolute', bottom: '-1px', left: 0, right: 0,
      height: '2px', background: '#66bb6a',
    }} />}
  </div>
);

const SubTabButton: React.FC<{
  label: string; count?: number; active: boolean; onClick: () => void;
}> = ({ label, count, active, onClick }) => (
  <div onClick={onClick} style={{
    padding: '5px 12px', fontSize: '11px', cursor: 'pointer',
    color: active ? '#66bb6a' : '#90a4ae',
    fontWeight: active ? 500 : 400, letterSpacing: '0.3px',
    position: 'relative', whiteSpace: 'nowrap',
  }}>
    {label}
    {count != null && (
      <span style={{ opacity: 0.7, fontSize: '10px', marginLeft: '3px' }}>({count})</span>
    )}
    {active && <div style={{
      position: 'absolute', bottom: '-9px', left: 0, right: 0,
      height: '2px', background: '#66bb6a',
    }} />}
  </div>
);

// ──────────────────────────────────────────────────────────
// Main component
// ──────────────────────────────────────────────────────────
export function OptionsPageMobile() {
  const [activeTab, setActiveTab] = useState<PrimaryTab>('swings');
  const [sourceFilter, setSourceFilter] = useState<SourceFilter>('all');
  const [alertCat, setAlertCat] = useState<AlertCategory>('all');

  const [analystData, setAnalystData] = useState<AnalystResponse | null>(null);
  const [flowData, setFlowData] = useState<FlowResponse | null>(null);
  const [loading, setLoading] = useState(true);

  // Data fetching — analyst signals
  useEffect(() => {
    let cancelled = false;
    const pull = async () => {
      try {
        const r = await fetch('/api/analyst-signals');
        const d = await r.json();
        if (!cancelled) setAnalystData(d);
      } catch {}
    };
    pull();
    const id = setInterval(pull, 15000);
    return () => { cancelled = true; clearInterval(id); };
  }, []);

  // Data fetching — flow + alerts
  useEffect(() => {
    let cancelled = false;
    const pull = async () => {
      try {
        const r = await fetch('/api/options-flow');
        const d = await r.json();
        if (!cancelled) {
          setFlowData(d);
          setLoading(false);
        }
      } catch {}
    };
    pull();
    const id = setInterval(pull, 10000);
    return () => { cancelled = true; clearInterval(id); };
  }, []);

  // Derived: filter signals by source group
  const filteredSignals = useMemo(() => {
    if (!analystData) return { open: [], closed: [] };
    const tabData = analystData.byTab[activeTab as 'scalps' | 'swings' | 'leaps'];
    if (!tabData) return { open: [], closed: [] };
    const filterFn = (s: AnalystSignal) =>
      sourceFilter === 'all' ? true : s.sourceGroup === sourceFilter;
    return {
      open: (tabData.open || []).filter(filterFn),
      closed: (tabData.closed || []).filter(filterFn),
    };
  }, [analystData, activeTab, sourceFilter]);

  // Derived: filter alerts by category
  const filteredAlerts = useMemo(() => {
    if (!flowData?.alerts) return [];
    if (alertCat === 'all') return flowData.alerts;
    return flowData.alerts.filter(a => categorizeAlert(a) === alertCat);
  }, [flowData, alertCat]);

  const alertCatCounts = useMemo(() => {
    const counts: Record<AlertCategory, number> = { all: 0, unusual: 0, huge: 0, weekly: 0, repeaters: 0, etf: 0 };
    (flowData?.alerts || []).forEach(a => {
      counts.all++;
      const c = categorizeAlert(a);
      if (c) counts[c]++;
    });
    return counts;
  }, [flowData]);

  const summaryStrip = () => {
    if (activeTab === 'scalps' || activeTab === 'swings' || activeTab === 'leaps') {
      const s = analystData?.stats;
      return [
        { label: 'Open', value: `${filteredSignals.open.length}` },
        { label: 'Win Rate 30d', value: s ? `${s.winRate30d}%` : '—', color: '#66bb6a' },
        { label: 'Source: Name', value: `${s?.sourceOpenCounts?.name ?? 0}` },
        { label: 'Source: Vivid', value: `${s?.sourceOpenCounts?.vivid ?? 0}` },
      ];
    }
    if (activeTab === 'flowAlerts') {
      const total = (flowData?.alerts || []).reduce((sum, a) => sum + (a.totalFlowValue || 0), 0);
      const bulls = (flowData?.alerts || []).filter(a => a.isBullish).length;
      const bears = (flowData?.alerts || []).length - bulls;
      const biggest = (flowData?.alerts || []).reduce((m, a) => a.totalFlowValue > (m?.totalFlowValue || 0) ? a : m, null as AlertEntry | null);
      return [
        { label: 'Total Flow', value: fmtMoney(total) },
        { label: 'Bull / Bear', value: `${bulls} / ${bears}` },
        { label: 'Biggest', value: biggest ? `${biggest.Symbol} ${fmtMoney(biggest.totalFlowValue)}` : '—', color: '#e040fb' },
        { label: 'Alerts', value: String((flowData?.alerts || []).length) },
      ];
    }
    // Option Flow tab
    const total = (flowData?.flow || []).reduce((sum, f) => sum + (f.Value || 0), 0);
    const sweeps = (flowData?.flow || []).filter(f => f.BlockType === 'SWEEP').length;
    const blocks = (flowData?.flow || []).filter(f => f.BlockType === 'BLOCK').length;
    return [
      { label: 'Total Flow', value: fmtMoney(total) },
      { label: 'Sweeps', value: String(sweeps), color: '#ff9800' },
      { label: 'Blocks', value: String(blocks), color: '#4fc3f7' },
      { label: 'Rows', value: String((flowData?.flow || []).length) },
    ];
  };

  // Header + tabs
  const counts = {
    scalps: analystData?.stats?.scalpsOpen ?? 0,
    swings: analystData?.stats?.swingsOpen ?? 0,
    leaps: analystData?.stats?.leapsOpen ?? 0,
    flowAlerts: flowData?.alerts?.length ?? 0,
    optionFlow: flowData?.flow?.length ?? 0,
  };

  return (
    <div style={{
      fontFamily: 'ui-monospace, "SF Mono", Menlo, monospace',
      fontSize: '13px', color: '#e4e4e4', background: '#000',
      minHeight: '100vh',
    }}>
      <div style={{ maxWidth: '720px', margin: '0 auto' }}>

        {/* Header */}
        <div style={{ padding: '14px 18px 10px', borderBottom: '1px solid #0d1117', textAlign: 'center' }}>
          <div style={{ color: '#66bb6a', fontSize: '18px', fontWeight: 500, letterSpacing: '0.5px' }}>
            Mission Control · Options
          </div>
        </div>

        {/* Primary tabs */}
        <div style={{
          display: 'flex', justifyContent: 'space-around',
          padding: '8px 4px 0', borderBottom: '1px solid #0d1117',
        }}>
          <PrimaryTabButton label="Scalps" count={counts.scalps} active={activeTab === 'scalps'} onClick={() => setActiveTab('scalps')} />
          <PrimaryTabButton label="Swings" count={counts.swings} active={activeTab === 'swings'} onClick={() => setActiveTab('swings')} />
          <PrimaryTabButton label="Leaps" count={counts.leaps} active={activeTab === 'leaps'} onClick={() => setActiveTab('leaps')} />
          <PrimaryTabButton label="Flow Alerts" count={counts.flowAlerts} active={activeTab === 'flowAlerts'} onClick={() => setActiveTab('flowAlerts')} />
          <PrimaryTabButton label="Option Flow" count={counts.optionFlow} active={activeTab === 'optionFlow'} onClick={() => setActiveTab('optionFlow')} />
        </div>

        {/* Sub-tabs: signal source filter OR alert category */}
        {(activeTab === 'scalps' || activeTab === 'swings' || activeTab === 'leaps') && (
          <div style={{ display: 'flex', gap: '4px', padding: '10px 14px', borderBottom: '1px solid #0d1117' }}>
            <SubTabButton label="All" count={(analystData?.stats?.sourceOpenCounts?.name || 0) + (analystData?.stats?.sourceOpenCounts?.vivid || 0)} active={sourceFilter === 'all'} onClick={() => setSourceFilter('all')} />
            <SubTabButton label="Name" count={analystData?.stats?.sourceOpenCounts?.name} active={sourceFilter === 'name'} onClick={() => setSourceFilter('name')} />
            <SubTabButton label="Vivid" count={analystData?.stats?.sourceOpenCounts?.vivid} active={sourceFilter === 'vivid'} onClick={() => setSourceFilter('vivid')} />
          </div>
        )}

        {activeTab === 'flowAlerts' && (
          <div style={{ display: 'flex', gap: '4px', padding: '10px 14px', borderBottom: '1px solid #0d1117', overflowX: 'auto' }}>
            <SubTabButton label="All" count={alertCatCounts.all} active={alertCat === 'all'} onClick={() => setAlertCat('all')} />
            <SubTabButton label="Unusual" count={alertCatCounts.unusual} active={alertCat === 'unusual'} onClick={() => setAlertCat('unusual')} />
            <SubTabButton label="Huge" count={alertCatCounts.huge} active={alertCat === 'huge'} onClick={() => setAlertCat('huge')} />
            <SubTabButton label="Weekly" count={alertCatCounts.weekly} active={alertCat === 'weekly'} onClick={() => setAlertCat('weekly')} />
            <SubTabButton label="Repeaters" count={alertCatCounts.repeaters} active={alertCat === 'repeaters'} onClick={() => setAlertCat('repeaters')} />
            <SubTabButton label="ETF" count={alertCatCounts.etf} active={alertCat === 'etf'} onClick={() => setAlertCat('etf')} />
          </div>
        )}

        {/* Summary strip */}
        <div style={{
          display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)',
          gap: '8px', padding: '10px 14px',
          borderBottom: '1px solid #0d1117', background: '#05080c',
        }}>
          {summaryStrip().map((s, i) => (
            <div key={i} style={{ textAlign: 'center' }}>
              <div style={{ color: '#607d8b', fontSize: '9px', textTransform: 'uppercase', letterSpacing: '0.4px' }}>{s.label}</div>
              <div style={{ fontSize: '13px', fontWeight: 500, marginTop: '2px', color: s.color || '#ffffff' }}>{s.value}</div>
            </div>
          ))}
        </div>

        {/* Content */}
        <div style={{ padding: '10px 14px 30px' }}>
          {loading && !analystData && !flowData && (
            <div style={{ color: '#607d8b', textAlign: 'center', padding: '40px 0', fontSize: '12px' }}>Loading...</div>
          )}

          {/* Signal tabs */}
          {(activeTab === 'scalps' || activeTab === 'swings' || activeTab === 'leaps') && analystData && (
            <>
              {filteredSignals.open.length === 0 && (
                <div style={{ color: '#607d8b', textAlign: 'center', padding: '30px 0', fontSize: '13px' }}>
                  No Signals at the moment.
                </div>
              )}
              {filteredSignals.open.length > 0 && (
                <>
                  <div style={{ color: '#607d8b', fontSize: '10px', letterSpacing: '0.6px', textTransform: 'uppercase', marginBottom: '8px' }}>
                    Open · {filteredSignals.open.length}
                  </div>
                  {filteredSignals.open.map(sig => <SignalCard key={sig.id} sig={sig} />)}
                </>
              )}
              {filteredSignals.closed.length > 0 && (
                <>
                  <div style={{
                    color: '#607d8b', fontSize: '10px', letterSpacing: '0.6px',
                    textTransform: 'uppercase', marginTop: '18px', marginBottom: '8px',
                    paddingTop: '14px', borderTop: '2px solid #1a2332',
                  }}>Past Performance · {filteredSignals.closed.length} recent</div>
                  {filteredSignals.closed.slice(0, 30).map(sig => <SignalCard key={sig.id} sig={sig} isPast />)}
                </>
              )}
            </>
          )}

          {/* Flow Alerts tab */}
          {activeTab === 'flowAlerts' && flowData && (
            <>
              {filteredAlerts.length === 0 && (
                <div style={{ color: '#607d8b', textAlign: 'center', padding: '30px 0', fontSize: '13px' }}>
                  No alerts in this category.
                </div>
              )}
              {filteredAlerts.map((a, i) => <AlertCard key={a.OptionSymbol + '_' + i} a={a} />)}
            </>
          )}

          {/* Option Flow tab */}
          {activeTab === 'optionFlow' && flowData && (
            <div style={{ background: '#05080c', borderRadius: '6px', border: '1px solid #1a2332' }}>
              <div style={{
                display: 'grid',
                gridTemplateColumns: '62px 52px 62px 48px 34px 78px 48px 60px',
                gap: '8px', padding: '6px 12px',
                color: '#607d8b', fontSize: '9px', fontWeight: 500,
                textTransform: 'uppercase', letterSpacing: '0.4px',
                borderBottom: '1px solid #1a2332',
              }}>
                <span>Time</span>
                <span>Symbol</span>
                <span>Exp</span>
                <span>Strike</span>
                <span>C/P</span>
                <span>Price</span>
                <span>Type</span>
                <span style={{ textAlign: 'right' }}>Value</span>
              </div>
              {(flowData.flow || []).slice(0, 300).map((f, i) => <FlowTapeRow key={f.OptionSymbol + '_' + i} f={f} />)}
            </div>
          )}
        </div>

      </div>
    </div>
  );
}
