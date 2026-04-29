'use client';

import React, { useEffect, useMemo, useState } from 'react';
import { StockDetailDrawer } from '@/components/drawers/StockDetailDrawer';
import { TickerLogo } from '@/components/ui/TickerLogo';
import { FilterModal, FilterState, DEFAULT_FILTERS, loadFilters, matchesFilters, isFiltersDefault } from '@/components/modals/FilterModal';

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


interface NotificationItem {
  key: string;
  ts: number;
  source: string;
  sourceGroup: 'name' | 'vivid';
  category: string;
  message: string;
  symbol: string;
  title: string;
  action: 'BUY' | 'SELL' | 'INFO';
}

interface NotificationsResponse {
  generated_at: string;
  total: number;
  byTab: {
    scalps: NotificationItem[];
    swings: NotificationItem[];
    leaps:  NotificationItem[];
  };
  all: NotificationItem[];
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
  logoUrl?: string | null;
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
  logoUrl?: string | null;
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
  flows: FlowEntry[];
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
  if (!ts || typeof ts !== 'number' || !isFinite(ts)) return '—';
  // ts is in ms (Firebase timestamps); auto-upconvert seconds just in case
  const tsMs = ts < 1e11 ? ts * 1000 : ts;
  const diffMs = Date.now() - tsMs;
  if (diffMs < 0) return 'now';
  const secs = Math.floor(diffMs / 1000);
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
  // Golden Ticket criteria — tight thresholds so only top-tier alerts qualify
  const t = (a.AlertType || '').toLowerCase();
  const prem = a.totalFlowValue || 0;
  const count = (a.SWEEPS || 0) + (a.BLOCKS || 0);
  // Mega flow: $3M+ premium
  if (prem >= 3_000_000) return true;
  // Heavy unusual activity: explicitly unusual AND $1M+
  if (t.includes('unusual') && prem >= 1_000_000) return true;
  // Heavy sweep/block activity: 5+ events AND $1M+ premium
  if (count >= 5 && prem >= 1_000_000) return true;
  return false;
};

// ──────────────────────────────────────────────────────────
// Fire badge SVG
// ──────────────────────────────────────────────────────────
const FilterIconButton: React.FC<{ active: boolean; onClick: () => void }> = ({ active, onClick }) => (
  <button
    onClick={onClick}
    title="Filters"
    style={{
      position: 'relative', display: 'inline-flex', alignItems: 'center', justifyContent: 'center',
      width: '32px', height: '32px', borderRadius: '4px',
      background: active ? '#66bb6a22' : 'transparent',
      border: `1px solid ${active ? '#66bb6a55' : '#1a3a4a'}`,
      cursor: 'pointer', padding: 0, color: active ? '#66bb6a' : '#90a4ae',
    }}
  >
    <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" />
    </svg>
    {active && (
      <span style={{
        position: 'absolute', top: '-3px', right: '-3px', width: '8px', height: '8px',
        borderRadius: '50%', background: '#66bb6a', border: '1.5px solid #0a1929',
      }} />
    )}
  </button>
);

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
      padding: '18px 22px', borderRadius: '10px', marginBottom: '12px',
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
        <TickerLogo symbol={sig.symbol} size="lg" logoUrl={sig.logoUrl} />
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{
            color: sig.isPut ? '#ef5350' : '#66bb6a',
            fontSize: '24px', fontWeight: 700,
          }}>{sig.contractLabel}</div>
          <div style={{ color: '#607d8b', fontSize: '15px', marginTop: '4px' }}>
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
          <div style={{ color: '#607d8b', fontSize: '13px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '6px' }}>
            Buy Target
          </div>
          <div style={{ color: '#ffffff', fontSize: '21px', fontWeight: 700 }}>
            {sig.buyTarget != null ? `$${sig.buyTarget.toFixed(2)}` : '—'}
          </div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '13px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '6px' }}>
            Stop Loss
          </div>
          <div style={{ color: '#ef5350', fontSize: '21px', fontWeight: 700 }}>
            {sig.stopLoss != null ? `$${sig.stopLoss.toFixed(2)}` : '—'}
          </div>
        </div>
        <div>
          <div style={{ color: '#607d8b', fontSize: '13px', textTransform: 'uppercase', letterSpacing: '0.4px', marginBottom: '6px' }}>
            Early Target
          </div>
          <div style={{ color: '#66bb6a', fontSize: '21px', fontWeight: 700 }}>
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
            padding: '10px 12px', borderRadius: '6px',
            background: t.val != null ? '#0a1422' : '#07101a',
            border: `1px solid ${t.val != null ? '#1a2332' : '#0a1422'}`,
            textAlign: 'center',
          }}>
            <div style={{ color: '#607d8b', fontSize: '13px', textTransform: 'uppercase', letterSpacing: '0.4px' }}>{t.label}</div>
            <div style={{ color: t.val != null ? '#ffffff' : '#394352', fontSize: '19px', fontWeight: 700, marginTop: '4px' }}>
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
const AlertCard: React.FC<{ a: AlertEntry; onSymbolClick?: (s: string) => void }> = ({ a, onSymbolClick }) => {
  const qualifying = isAlertQualifying(a);
  const bull = a.isBullish;
  const strike = String(a.Strike).replace(/\.0+$/, '');
  const cp = a.OptionType?.charAt(0);
  const exp = a.ExpiryStr?.slice(5) || a.ExpiryStr || '';
  const contractName = `${a.Symbol} ${strike}${cp} ${exp}`;
  const h = a._history;

  return (
    <div style={{
      padding: '16px 20px', borderRadius: '10px', marginBottom: '10px',
      background: qualifying ? '#ffd60014' : '#05080c',
      border: `1px solid ${qualifying ? '#ffd600' : '#1a2332'}`,
      boxShadow: qualifying ? '0 0 8px #ffd60022' : undefined,
    }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: '12px' }}>
        <span style={{ color: '#607d8b', fontSize: '11px', minWidth: '42px' }}>{ago(a.Updated)}</span>
        <TickerLogo symbol={a.Symbol} size="md" logoUrl={a.logoUrl} />
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '7px', marginBottom: '3px' }}>
            <span onClick={(e) => { e.stopPropagation(); onSymbolClick?.(a.Symbol); }} style={{ color: bull ? '#66bb6a' : '#ef5350', fontWeight: 700, fontSize: '22px', cursor: onSymbolClick ? 'pointer' : 'default' }}>
              {contractName}
            </span>
            {qualifying && <FireBadge />}
          </div>
          <div style={{ display: 'flex', alignItems: 'baseline', gap: '6px' }}>
            <span style={{ color: '#607d8b', fontSize: '11px' }}>Flow Premium =</span>
            <span style={{ fontWeight: 700, fontSize: '24px', color: premColor(a.totalFlowValue) }}>
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
const FlowTapeRow: React.FC<{ f: FlowEntry; onSymbolClick?: (s: string) => void }> = ({ f, onSymbolClick }) => {
  // Sentiment per Help Center: CALL+ASK=bull, CALL+BID=bear, PUT+ASK=bear, PUT+BID=bull
  // Case-insensitive on BOTH OptionType and BidAskType (API returns CALL/PUT uppercase)
  const optType = (f.OptionType || '').toUpperCase();
  const bidAsk = (f.BidAskType || '').toUpperCase();
  const isAskSide = bidAsk.includes('A');
  const isBidSide = bidAsk.includes('B');
  const isCall = optType === 'CALL';
  const isPut = optType === 'PUT';
  const isBullish =
    (isCall && isAskSide) || (isPut && isBidSide);
  const isBearish =
    (isCall && isBidSide) || (isPut && isAskSide);
  const color = isBullish ? '#66bb6a' : isBearish ? '#ef5350' : '#90a4ae';

  // GOLDEN row border: Flow Premium >= $1M (Mission Ctrl addition)
  const isBigMoney = f.Value >= 1_000_000;

  // YELLOW pill border: Volume > OI (Help Center unusual-flow rule)
  const isUnusual = f.Volume > f.OI;

  const time = new Date(f.Time * 1000).toLocaleTimeString('en-US', { hour12: false });

  // Pill color matches sentiment (green for bull, red for bear, grey for unknown)
  const pillFg = color;
  const pillBg = isBullish ? '#66bb6a18' : isBearish ? '#ef535018' : '#90a4ae18';
  // Yellow border overrides sentiment color when unusual
  const pillBorder = isUnusual ? '#ffd600' : color;

  return (
    <div style={{
      display: 'grid',
      gridTemplateColumns: '1.2fr 1fr 1.4fr 0.8fr 0.5fr 1.4fr 0.7fr 1fr',
      gap: '12px', padding: '8px 16px', fontSize: '15px', alignItems: 'center',
      borderBottom: '1px solid #0a1220',
      background: isBigMoney ? '#ffd60015' : 'transparent',
      borderLeft: isBigMoney ? '3px solid #ffd600' : '3px solid transparent',
      color,
    }}>
      <span>{time}</span>
      <span onClick={(e) => { e.stopPropagation(); onSymbolClick?.(f.Symbol); }} style={{ fontWeight: 500, cursor: onSymbolClick ? 'pointer' : 'default', textDecoration: onSymbolClick ? 'underline' : 'none', textDecorationColor: '#ffffff22', display: 'flex', alignItems: 'center', gap: '6px' }}><TickerLogo symbol={f.Symbol} size="sm" logoUrl={f.logoUrl} />{f.Symbol}</span>
      <span>{f.ExpiryStr?.slice(2) || ''}</span>
      <span>{f.Strike}</span>
      <span>{isCall ? 'CAL' : 'PUT'}</span>
      <span>{f.Price?.toFixed(2)}{f.BidAskType}</span>
      <span style={{
        padding: '3px 10px', borderRadius: '4px', fontSize: '11px', fontWeight: 600,
        background: pillBg,
        border: `${isUnusual ? '2px' : '1px'} solid ${pillBorder}`,
        color: pillFg,
        textAlign: 'center',
        boxShadow: isUnusual ? '0 0 4px #ffd60066' : 'none',
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
export function OptionsPage() {
  const [activeTab, setActiveTab] = useState<PrimaryTab>('swings');
  const [filterModalOpen, setFilterModalOpen] = useState(false);
  const [alertFilters, setAlertFilters] = useState<FilterState>(DEFAULT_FILTERS);
  const [flowFilters, setFlowFilters] = useState<FilterState>(DEFAULT_FILTERS);
  useEffect(() => {
    setAlertFilters(loadFilters('mc:filters:alerts'));
    setFlowFilters(loadFilters('mc:filters:flow'));
  }, []);
  const [sourceFilter, setSourceFilter] = useState<SourceFilter>('all');
  const [alertCat, setAlertCat] = useState<AlertCategory>('all');

  const [analystData, setAnalystData] = useState<AnalystResponse | null>(null);
  const [flowData, setFlowData] = useState<FlowResponse | null>(null);
  const [notificationsData, setNotificationsData] = useState<NotificationsResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

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
  // Data fetching — notifications (live from Firebase via /api/notifications)
  useEffect(() => {
    let cancelled = false;
    const pull = async () => {
      try {
        const r = await fetch('/api/notifications');
        const d = await r.json();
        if (!cancelled) setNotificationsData(d);
      } catch {}
    };
    pull();
    const id = setInterval(pull, 15000);
    return () => { cancelled = true; clearInterval(id); };
  }, []);

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

  const notificationsForActiveTab = useMemo<NotificationItem[]>(() => {
    if (!notificationsData?.byTab) return [];
    if (activeTab === 'scalps') return notificationsData.byTab.scalps || [];
    if (activeTab === 'swings') return notificationsData.byTab.swings || [];
    if (activeTab === 'leaps')  return notificationsData.byTab.leaps  || [];
    return [];
  }, [notificationsData, activeTab]);

  // Derived: filter alerts by category + filter modal state
  const filteredAlerts = useMemo(() => {
    if (!flowData?.alerts) return [];
    if (alertCat === 'all') return flowData.alerts.filter(a => matchesFilters(a, alertFilters));
    return flowData.alerts.filter(a => categorizeAlert(a) === alertCat && matchesFilters(a, alertFilters));
  }, [flowData, alertCat, alertFilters]);

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
    const total = (flowData?.flows || []).reduce((sum, f) => sum + (f.Value || 0), 0);
    const sweeps = (flowData?.flows || []).filter(f => f.BlockType === 'SWEEP').length;
    const blocks = (flowData?.flows || []).filter(f => f.BlockType === 'BLOCK').length;
    return [
      { label: 'Total Flow', value: fmtMoney(total) },
      { label: 'Sweeps', value: String(sweeps), color: '#ff9800' },
      { label: 'Blocks', value: String(blocks), color: '#4fc3f7' },
      { label: 'Rows', value: String((flowData?.flows || []).length) },
    ];
  };

  // Header + tabs
  const counts = {
    scalps: analystData?.stats?.scalpsOpen ?? 0,
    swings: analystData?.stats?.swingsOpen ?? 0,
    leaps: analystData?.stats?.leapsOpen ?? 0,
    flowAlerts: flowData?.alerts?.length ?? 0,
    optionFlow: flowData?.flows?.length ?? 0,
  };

  return (
    <div style={{
      fontFamily: 'ui-monospace, "SF Mono", Menlo, monospace',
      fontSize: '13px', color: '#e4e4e4', background: '#000',
      minHeight: '100vh',
    }}>
      <div style={{ width: '100%', margin: '0', padding: '0 16px' }}>

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
            <SubTabButton label="FLoWz1" count={analystData?.stats?.sourceOpenCounts?.name} active={sourceFilter === 'name'} onClick={() => setSourceFilter('name')} />
            <SubTabButton label="FLoWz2" count={analystData?.stats?.sourceOpenCounts?.vivid} active={sourceFilter === 'vivid'} onClick={() => setSourceFilter('vivid')} />
            <SubTabButton label="Notifications" count={notificationsForActiveTab.length} active={sourceFilter === 'notifications'} onClick={() => setSourceFilter('notifications')} />
          </div>
        )}

        {activeTab === 'flowAlerts' && (
          <div style={{ display: 'flex', gap: '4px', padding: '10px 14px', borderBottom: '1px solid #0d1117', overflowX: 'auto' }}>
            <SubTabButton label="All" count={alertCatCounts.all} active={alertCat === 'all'} onClick={() => setAlertCat('all')} />
            <SubTabButton label="Weekly Alerts" count={alertCatCounts.weekly} active={alertCat === 'weekly'} onClick={() => setAlertCat('weekly')} />
            <SubTabButton label="Repeaters" count={alertCatCounts.repeaters} active={alertCat === 'repeaters'} onClick={() => setAlertCat('repeaters')} />
            <SubTabButton label="Unusual Flow" count={alertCatCounts.unusual} active={alertCat === 'unusual'} onClick={() => setAlertCat('unusual')} />
            <SubTabButton label="Huge Flow" count={alertCatCounts.huge} active={alertCat === 'huge'} onClick={() => setAlertCat('huge')} />
            <SubTabButton label="ETF Flow" count={alertCatCounts.etf} active={alertCat === 'etf'} onClick={() => setAlertCat('etf')} />
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
              {sourceFilter === 'notifications' ? (
                <NotificationsList items={notificationsForActiveTab} />
              ) : (
                <>
                  {filteredSignals.open.length > 0 && (
                    <>
                      <div style={{ color: '#607d8b', fontSize: '10px', letterSpacing: '0.6px', textTransform: 'uppercase', marginBottom: '8px' }}>
                        Open · {filteredSignals.open.length}
                      </div>
                      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px', alignItems: 'start' }}>
                        {filteredSignals.open.map(sig => <SignalCard key={sig.id} sig={sig} />)}
                      </div>
                    </>
                  )}
                  {filteredSignals.closed.length > 0 && (
                    <>
                      <div style={{
                        color: '#607d8b', fontSize: '10px', letterSpacing: '0.6px',
                        textTransform: 'uppercase', marginTop: '18px', marginBottom: '8px',
                        paddingTop: '14px', borderTop: '2px solid #1a2332',
                      }}>Past Performance · {filteredSignals.closed.length} recent</div>
                      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px', alignItems: 'start' }}>
                        {filteredSignals.closed.slice(0, 30).map(sig => <SignalCard key={sig.id} sig={sig} isPast />)}
                      </div>
                    </>
                  )}
                </>
              )}
            </>
          )}

          {/* Flow Alerts tab */}
          {activeTab === 'flowAlerts' && flowData && (
          <>
            <div style={{ display: 'flex', justifyContent: 'flex-end', marginBottom: '10px' }}>
              <FilterIconButton active={!isFiltersDefault(alertFilters)} onClick={() => setFilterModalOpen(true)} />
            </div>
            <>
              {filteredAlerts.length === 0 && (
                <div style={{ color: '#607d8b', textAlign: 'center', padding: '30px 0', fontSize: '13px' }}>
                  No alerts in this category.
                </div>
              )}
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '8px', alignItems: 'start' }}>
                {filteredAlerts.map((a, i) => <AlertCard key={a.OptionSymbol + '_' + i} a={a} onSymbolClick={setDrawerTicker} />)}
              </div>
            </>
          </>
          )}

          {/* Option Flow tab */}
        {activeTab === 'optionFlow' && flowData && (
          <>
            <div style={{ display: 'flex', justifyContent: 'flex-end', marginBottom: '10px' }}>
              <FilterIconButton active={!isFiltersDefault(flowFilters)} onClick={() => setFilterModalOpen(true)} />
            </div>
            <div style={{ background: '#05080c', borderRadius: '6px', border: '1px solid #1a2332' }}>
              <div style={{
                display: 'grid',
                gridTemplateColumns: '1.2fr 1fr 1.4fr 0.8fr 0.5fr 1.4fr 0.7fr 1fr',
                gap: '12px', padding: '10px 16px',
                color: '#607d8b', fontSize: '12px', fontWeight: 600,
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
              {(flowData.flows || []).filter(f => matchesFilters(f, flowFilters)).slice(0, 300).map((f, i) => <FlowTapeRow key={f.OptionSymbol + '_' + i} f={f} onSymbolClick={setDrawerTicker} />)}
            </div>
          </>
          )}
        </div>

      </div>
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
      <FilterModal
        open={filterModalOpen}
        onClose={() => setFilterModalOpen(false)}
        storageKey={activeTab === 'flowAlerts' ? 'mc:filters:alerts' : 'mc:filters:flow'}
        initial={activeTab === 'flowAlerts' ? alertFilters : flowFilters}
        onApply={(f) => {
          if (activeTab === 'flowAlerts') setAlertFilters(f);
          else setFlowFilters(f);
        }}
      />
    </div>
  );
}


// ──────────────────────────────────────────────────────────
// Notifications List
// ──────────────────────────────────────────────────────────

function NotificationsList({ items }: { items: NotificationItem[] }) {
  if (!items || items.length === 0) {
    return (
      <div style={{ padding: '40px 20px', textAlign: 'center', color: '#5c5c72', fontFamily: 'var(--font-mc-mono)' }}>
        No notifications yet.
      </div>
    );
  }
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: '8px', padding: '8px 0' }}>
      {items.map(n => {
        const dt = new Date(n.ts * 1000);
        const dateStr = dt.toLocaleDateString('en-US', { month: '2-digit', day: '2-digit', year: '2-digit' });
        const timeStr = dt.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', hour12: true, timeZone: 'America/New_York' });
        const actionColor = n.action === 'BUY' ? '#00d2a0' : n.action === 'SELL' ? '#ff4757' : '#8b8b9e';
        return (
          <div key={`${n.ts}-${n.title}`} style={{
            background: '#111118',
            border: '1px solid #1e1e2a',
            borderRadius: '6px',
            padding: '12px 16px',
            display: 'grid',
            gridTemplateColumns: 'auto 1fr auto',
            gap: '12px',
            alignItems: 'start',
          }}>
            <div style={{ width: '6px', borderRadius: '3px', background: actionColor, alignSelf: 'stretch' }} />
            <div>
              <div style={{ display: 'flex', gap: '8px', alignItems: 'center', marginBottom: '4px' }}>
                <span style={{ color: '#e8e8ed', fontWeight: 600, fontSize: '14px', fontFamily: 'var(--font-mc-mono)' }}>{n.title}</span>
                <span style={{
                  fontSize: '10px', padding: '2px 6px', borderRadius: '3px',
                  background: actionColor + '20', color: actionColor,
                  fontFamily: 'var(--font-mc-mono)', fontWeight: 600, letterSpacing: '0.5px',
                }}>{n.action}</span>
                <span style={{ fontSize: '10px', color: '#5c5c72', fontFamily: 'var(--font-mc-mono)' }}>{n.source}</span>
              </div>
              <div style={{ color: '#a8a8b8', fontSize: '13px', whiteSpace: 'pre-wrap', lineHeight: 1.4 }}>
                {n.message}
              </div>
            </div>
            <div style={{ textAlign: 'right', fontSize: '11px', color: '#5c5c72', fontFamily: 'var(--font-mc-mono)' }}>
              <div>{dateStr}</div>
              <div>{timeStr}</div>
            </div>
          </div>
        );
      })}
    </div>
  );
}
