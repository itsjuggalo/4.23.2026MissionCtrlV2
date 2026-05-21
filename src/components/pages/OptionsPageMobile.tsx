// ═══════════════════════════════════════════════════════════════
// Options Page — MOBILE VERSION
//
// Rebuilt 2026-05-20 to mirror the Option Signals Android app
// pixel-for-pixel (per ~/Pictures/options-app-screens/).
//
// Self-contained: AppShellClient routes here on mobile and hides
// its Header / MissionMetrics / PsychChatWidget — this component
// owns the full screen. Uses the existing analyst-signals,
// options-flow, and options-chain endpoints — no API changes.
// ═══════════════════════════════════════════════════════════════
'use client';

import React, { useEffect, useMemo, useRef, useState } from 'react';
import {
  Menu, Search, Crosshair, TrendingUp, PiggyBank, Radio, MoreHorizontal,
  Bell, Filter, ChevronRight, Layers, X, Check, Bird, BarChart3, LineChart,
} from 'lucide-react';

// ──────────────────────────────────────────────────────────
// Color tokens — match Option Signals app exactly
// ──────────────────────────────────────────────────────────
const OPT = {
  bg:        '#000000',
  card:      '#15171c',
  cardElev:  '#1a1d24',
  border:    '#1f2329',
  borderDim: '#2a2f37',
  green:     '#10C77A',
  greenDim:  '#10C77A33',
  red:       '#F2435F',
  redDim:    '#F2435F33',
  cyan:      '#4FC3F7',
  amber:     '#FFB300',
  pink:      '#E040FB',
  yellow:    '#FFD600',
  text:      '#FFFFFF',
  textMuted: '#8A99A8',
  textDim:   '#455A64',
} as const;

// ──────────────────────────────────────────────────────────
// Types — match /api/analyst-signals + /api/options-flow shapes
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
    openTotal: number; closedTotal: number; recentClosed: number; winRate30d: number;
    scalpsOpen: number; swingsOpen: number; leapsOpen: number;
    sourceOpenCounts: { name: number; vivid: number };
  };
  byTab: {
    scalps: { open: AnalystSignal[]; closed: AnalystSignal[] };
    swings: { open: AnalystSignal[]; closed: AnalystSignal[] };
    leaps:  { open: AnalystSignal[]; closed: AnalystSignal[] };
  };
}

interface FlowEntry {
  Symbol: string; OptionSymbol: string; Strike: number;
  OptionType: 'Call' | 'Put'; ExpiryStr: string;
  Price: number; Value: number; Volume: number; OI: number;
  BidAskType: string; BlockType: 'SWEEP' | 'BLOCK' | string; Time: number;
}

interface AlertEntry {
  AlertType: string; Symbol: string; OptionSymbol: string;
  Strike: number; OptionType: 'Call' | 'Put'; ExpiryStr: string;
  AlertPrice: number; totalFlowValue: number;
  SWEEPS: number; BLOCKS: number; Volume: number; OI: number;
  DTE: number; isBullish: boolean; Updated: number;
  _history?: {
    firstPrice: number; lastPrice: number; maxPrice: number;
    gainPct: number; maxGainPct: number;
    numUpdates: number; firstSeen: number; lastSeen: number;
  };
}

interface FlowResponse { alerts: AlertEntry[]; flow: FlowEntry[]; }

interface ChainContract {
  symbol: string; strike: number; option_type: string;
  last: number; change: number; volume: number; open_interest: number;
  bid: number; ask: number;
  greeks?: { delta: number; gamma: number; theta: number; vega: number; rho: number; mid_iv: number; };
}

type PrimaryTab = 'scalps' | 'swings' | 'leaps' | 'flowAlerts' | 'chain' | 'more';
type SubTab = 'signals' | 'notifications';
type AlertCategory = 'weekly' | 'repeaters' | 'unusual' | 'huge' | 'etf';

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
const fmtDate = (ts: number): string => {
  if (!ts) return '';
  const d = new Date(ts * 1000);
  const mm = String(d.getMonth() + 1).padStart(2, '0');
  const dd = String(d.getDate()).padStart(2, '0');
  const yy = String(d.getFullYear()).slice(-2);
  return `${mm}/${dd}/${yy}`;
};
const fmtTime = (ts: number): string => {
  if (!ts) return '—';
  return new Date(ts).toLocaleTimeString('en-US', { hour: 'numeric', minute: '2-digit', hour12: true });
};

// Compute Est.Gain as (sellTarget - buyTarget) / buyTarget, fall back to earlyTarget.
function estGainPct(s: AnalystSignal): number | null {
  if (s.buyTarget == null) return null;
  const tgt = s.sellTarget ?? s.earlyTarget;
  if (tgt == null) return null;
  return ((tgt - s.buyTarget) / s.buyTarget) * 100;
}

// Did a sell-target trigger? Heuristic: signal is closed with profit ribbon
// and tier <= idx of triggered targets. For now we just visually-mark targets
// when the ribbon shows the signal as taken profits.
function targetHit(s: AnalystSignal, idx: 1 | 2 | 3): boolean {
  if (!s.isClosed) return false;
  if (s.ribbonType === 'profit') return idx === 1;
  if (s.ribbonType === 'riding') return idx <= 2;
  return false;
}

// ──────────────────────────────────────────────────────────
// Ticker logo (Clearbit + 3-letter monogram fallback)
// ──────────────────────────────────────────────────────────
const TickerLogo: React.FC<{ symbol: string; logoUrl: string | null; size?: number }> = ({ symbol, logoUrl, size = 40 }) => {
  const [errored, setErrored] = useState(false);
  if (!logoUrl || errored) {
    return (
      <div style={{
        width: size, height: size, borderRadius: '50%', background: OPT.cardElev,
        display: 'flex', alignItems: 'center', justifyContent: 'center',
        color: OPT.textMuted, fontSize: size / 3.2, fontWeight: 600, flexShrink: 0,
      }}>{(symbol || '?').slice(0, 3).toUpperCase()}</div>
    );
  }
  return (
    <img src={logoUrl} onError={() => setErrored(true)} alt={symbol}
      style={{ width: size, height: size, borderRadius: '50%', background: '#fff', objectFit: 'contain', flexShrink: 0 }} />
  );
};

// ──────────────────────────────────────────────────────────
// Reasoning pill (rounded chip with icon + label)
// ──────────────────────────────────────────────────────────
const ReasoningPill: React.FC<{ icon: React.ReactNode; label: string; color?: string }> = ({ icon, label, color = OPT.green }) => (
  <div style={{
    display: 'inline-flex', alignItems: 'center', gap: 6,
    padding: '5px 10px', borderRadius: 18,
    background: 'transparent', border: `1px solid ${OPT.border}`,
    color, fontSize: 12, fontWeight: 500, whiteSpace: 'nowrap',
  }}>{icon}{label}</div>
);

// ──────────────────────────────────────────────────────────
// Stat pair (label / value column)
// ──────────────────────────────────────────────────────────
const StatPair: React.FC<{ label: string; value: React.ReactNode; valueColor?: string; bold?: boolean }> = ({
  label, value, valueColor = OPT.text, bold = true,
}) => (
  <div style={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
    <span style={{ color: OPT.textMuted, fontSize: 11, fontWeight: 400 }}>{label}</span>
    <span style={{ color: valueColor, fontSize: 15, fontWeight: bold ? 600 : 400, fontVariantNumeric: 'tabular-nums' }}>{value}</span>
  </div>
);

// ──────────────────────────────────────────────────────────
// Open Signal Card — Scalps / Swings / Leaps Analyst tab
// ──────────────────────────────────────────────────────────
const OpenSignalCard: React.FC<{ sig: AnalystSignal; onTap?: () => void }> = ({ sig, onTap }) => {
  const est = estGainPct(sig);
  const estIsGain = est != null && est >= 0;
  const targets = [sig.sellTarget, sig.sellTarget2, sig.sellTarget3];
  const reasoning: { icon: React.ReactNode; label: string; color?: string }[] = [];
  if (sig.category) reasoning.push({ icon: <Bird size={12} />, label: sig.category, color: OPT.green });
  if (sig.risk)     reasoning.push({ icon: <BarChart3 size={12} />, label: `${sig.risk} risk`, color: sig.risk === 'VH' ? OPT.red : sig.risk === 'HI' ? OPT.amber : OPT.yellow });
  if (sig.isWeekly) reasoning.push({ icon: <LineChart size={12} />, label: 'Weekly', color: OPT.cyan });

  return (
    <div onClick={onTap} style={{
      padding: 16, marginBottom: 12, borderRadius: 12,
      background: OPT.card, border: `1px solid ${OPT.border}`,
      cursor: onTap ? 'pointer' : 'default', position: 'relative',
    }}>
      {/* Header: logo + ticker + date */}
      <div style={{ display: 'flex', alignItems: 'flex-start', gap: 12, marginBottom: 14 }}>
        <TickerLogo symbol={sig.symbol} logoUrl={sig.logoUrl} size={40} />
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{ color: OPT.text, fontSize: 17, fontWeight: 700, letterSpacing: 0.2 }}>{sig.contractLabel}</div>
          <div style={{ color: OPT.textMuted, fontSize: 13, marginTop: 2 }}>{sig.shortName || sig.symbol}</div>
        </div>
        <div style={{ color: OPT.textMuted, fontSize: 12, whiteSpace: 'nowrap', paddingTop: 3 }}>{fmtDate(sig.ts)}</div>
      </div>

      {/* Buy/Stop/Est.Gain + Sell Target 1/2/3 — 2-col grid */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px 18px', marginBottom: 12 }}>
        {/* LEFT COLUMN: Buy / Stop / Est.Gain */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          <Row label="Buy Target" value={sig.buyTarget != null ? sig.buyTarget.toFixed(2) : '—'} />
          <Row label="Stop Loss"  value={sig.stopLoss  != null ? sig.stopLoss.toFixed(2)  : '—'} />
          <Row label="Est.Gain"   valueNode={
            est != null
              ? <span style={{
                  display: 'inline-block', padding: '3px 12px', borderRadius: 14,
                  background: estIsGain ? OPT.green : OPT.red, color: '#0a0f15',
                  fontSize: 14, fontWeight: 700,
                }}>{estIsGain ? '' : ''}{est.toFixed(1)}%</span>
              : <span style={{ color: OPT.textDim }}>—</span>
          } />
        </div>
        {/* RIGHT COLUMN: Sell 1/2/3 */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          {targets.map((t, i) => {
            const hit = targetHit(sig, (i + 1) as 1 | 2 | 3);
            return (
              <Row key={i} label={`Sell Target ${i + 1}`}
                valueNode={t != null
                  ? <span style={{ color: hit ? OPT.green : OPT.text, fontWeight: 600, fontVariantNumeric: 'tabular-nums' }}>
                      {t.toFixed(2)} {hit && <Check size={14} strokeWidth={3} style={{ display: 'inline-block', verticalAlign: -2, color: OPT.green }} />}
                    </span>
                  : <span style={{ color: OPT.textDim }}>—</span>} />
            );
          })}
        </div>
      </div>

      {/* Status line */}
      {sig.status && (
        <div style={{ color: OPT.textMuted, fontSize: 13, fontStyle: 'italic', marginBottom: 12, lineHeight: 1.45 }}>
          Status: <span style={{ color: OPT.text, fontStyle: 'normal' }}>{sig.status}</span>
        </div>
      )}

      {/* Reasoning pills */}
      {reasoning.length > 0 && (
        <>
          <div style={{ height: 1, background: OPT.border, margin: '12px 0' }} />
          <div style={{ display: 'flex', gap: 8, flexWrap: 'wrap' }}>
            <span style={{ color: OPT.textMuted, fontSize: 13, alignSelf: 'center' }}>Reasoning:</span>
            {reasoning.map((r, i) => <ReasoningPill key={i} {...r} />)}
          </div>
        </>
      )}

      {/* Chevron in the right edge */}
      {onTap && <ChevronRight size={20} style={{ position: 'absolute', right: 12, top: '50%', transform: 'translateY(-50%)', color: OPT.textDim }} />}
    </div>
  );
};

// Helper sub-component for the 2-col stat rows
const Row: React.FC<{ label: string; value?: string; valueNode?: React.ReactNode }> = ({ label, value, valueNode }) => (
  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', gap: 12 }}>
    <span style={{ color: OPT.textMuted, fontSize: 13 }}>{label}</span>
    <span style={{ color: OPT.text, fontSize: 15, fontWeight: 600, fontVariantNumeric: 'tabular-nums' }}>{valueNode ?? value}</span>
  </div>
);

// ──────────────────────────────────────────────────────────
// Closed Signal Card — Past Performance section
// ──────────────────────────────────────────────────────────
const ClosedSignalCard: React.FC<{ sig: AnalystSignal; onTap?: () => void }> = ({ sig, onTap }) => {
  const ribbon: Record<string, { bg: string; fg: string }> = {
    profit:  { bg: OPT.green, fg: '#0a1a0f' },
    stopped: { bg: OPT.red,   fg: '#1a0a0a' },
    riding:  { bg: OPT.yellow, fg: '#1a1400' },
    open:    { bg: OPT.green, fg: '#0a1a0f' },
  };
  const r = ribbon[sig.ribbonType] || ribbon.open;
  const est = estGainPct(sig);

  return (
    <div onClick={onTap} style={{
      padding: 16, marginBottom: 12, borderRadius: 12, position: 'relative',
      background: OPT.card, border: `1px solid ${OPT.border}`, overflow: 'hidden',
      cursor: onTap ? 'pointer' : 'default',
    }}>
      {/* Diagonal corner ribbon (top-left, like the app) */}
      <div style={{
        position: 'absolute', top: 12, left: -34, width: 110,
        transform: 'rotate(-35deg)', textAlign: 'center',
        background: r.bg, color: r.fg, fontSize: 10, fontWeight: 700,
        letterSpacing: 0.8, padding: '3px 0', textTransform: 'uppercase',
      }}>Closed</div>

      {/* Header: logo + ticker + date — pad-left to clear ribbon */}
      <div style={{ display: 'flex', alignItems: 'flex-start', gap: 12, paddingLeft: 24, marginBottom: 14 }}>
        <TickerLogo symbol={sig.symbol} logoUrl={sig.logoUrl} size={40} />
        <div style={{ flex: 1, minWidth: 0 }}>
          <div style={{ color: OPT.text, fontSize: 17, fontWeight: 700 }}>{sig.contractLabel}</div>
          <div style={{ color: OPT.textMuted, fontSize: 13, marginTop: 2 }}>{sig.shortName || sig.symbol}</div>
        </div>
        <div style={{ color: OPT.textMuted, fontSize: 12, whiteSpace: 'nowrap', paddingTop: 3 }}>{fmtDate(sig.ts)}</div>
      </div>

      {/* 2-col grid: Entry/EntryDate/Max.Gain | 1st/2nd/3rd Exit */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px 18px' }}>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          <Row label="Entry"      value={sig.buyTarget != null ? sig.buyTarget.toFixed(2) : '—'} />
          <Row label="Entry Date" value={fmtDate(sig.ts)} />
          <Row label="Max. Gain"  valueNode={
            est != null
              ? <span style={{
                  display: 'inline-block', padding: '3px 12px', borderRadius: 14,
                  background: est >= 0 ? OPT.green : OPT.red, color: '#0a0f15',
                  fontSize: 14, fontWeight: 700,
                }}>{est.toFixed(1)}%</span>
              : <span style={{ color: OPT.textDim }}>—</span>
          } />
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          {[sig.sellTarget, sig.sellTarget2, sig.sellTarget3].map((t, i) => {
            const hit = targetHit(sig, (i + 1) as 1 | 2 | 3);
            return <Row key={i} label={`${i + 1}${['st','nd','rd'][i]} Exit`}
              valueNode={t != null
                ? <span style={{ color: hit ? OPT.green : OPT.text, fontWeight: 600 }}>{t.toFixed(2)}</span>
                : <span style={{ color: OPT.textDim }}>—</span>} />;
          })}
        </div>
      </div>

      {/* Status line */}
      {sig.status && (
        <div style={{ color: OPT.textMuted, fontSize: 13, fontStyle: 'italic', marginTop: 12, lineHeight: 1.45 }}>
          Status: <span style={{ color: OPT.text, fontStyle: 'normal' }}>{sig.status}</span>
        </div>
      )}
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Notification Card — Notifications sub-tab
// ──────────────────────────────────────────────────────────
const NotificationCard: React.FC<{ sig: AnalystSignal }> = ({ sig }) => {
  const action = sig.isClosed ? 'SELL' : 'BUY';
  const headline = `${sig.contractLabel}: ${action}`;
  const body = sig.isClosed
    ? `Take trailing stop at ${(sig.sellTarget ?? 0).toFixed(2)} to exit trade!`
    : `Buy below ${(sig.buyTarget ?? 0).toFixed(2)}, Sell above ${(sig.sellTarget ?? 0).toFixed(2)}. ${sig.tab[0].toUpperCase() + sig.tab.slice(1, -1)}, ${(sig.risk || '').replace('VH', 'Very High').replace('HI', 'High').replace('MD', 'Moderate')} risk`;
  return (
    <div style={{
      padding: 14, marginBottom: 10, borderRadius: 12, position: 'relative',
      background: OPT.card, border: `1px solid ${OPT.border}`,
      display: 'flex', gap: 12, alignItems: 'flex-start',
    }}>
      <TickerLogo symbol={sig.symbol} logoUrl={sig.logoUrl} size={48} />
      <div style={{ flex: 1, minWidth: 0, paddingRight: 28 }}>
        <div style={{ color: OPT.textMuted, fontSize: 12, marginBottom: 4, textAlign: 'right' }}>{fmtDate(sig.ts)}</div>
        <div style={{ color: OPT.text, fontSize: 16, fontWeight: 600, marginBottom: 6 }}>{headline}</div>
        <div style={{ color: OPT.text, fontSize: 14, lineHeight: 1.4 }}>{body}</div>
      </div>
      <ChevronRight size={20} style={{ position: 'absolute', right: 12, top: '50%', transform: 'translateY(-50%)', color: OPT.textDim }} />
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Flow Alert Card — Flow Alerts sub-tab (2-col grid)
// ──────────────────────────────────────────────────────────
const FlowAlertCard: React.FC<{ a: AlertEntry }> = ({ a }) => {
  const strike = String(a.Strike).replace(/\.0+$/, '');
  const cp = a.OptionType?.charAt(0);
  const exp = a.ExpiryStr?.slice(5) || a.ExpiryStr || '';
  const contractName = `${a.Symbol} ${strike}${cp} ${exp}`;
  const h = a._history;

  return (
    <div style={{
      padding: 14, marginBottom: 10, borderRadius: 12,
      background: OPT.card, border: `1px solid ${OPT.border}`,
    }}>
      {/* Header: contract + time */}
      <div style={{ display: 'flex', alignItems: 'baseline', justifyContent: 'space-between', marginBottom: 12 }}>
        <span style={{ color: OPT.text, fontSize: 16, fontWeight: 700 }}>{contractName}</span>
        <span style={{ color: OPT.textMuted, fontSize: 12 }}>{fmtTime(a.Updated * 1000)}</span>
      </div>
      {/* 2-col grid of 4 stat pairs */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '10px 18px' }}>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Flow Premium:</span>
          <span style={{ color: OPT.text, fontSize: 15, fontWeight: 700 }}>{fmtMoney(a.totalFlowValue)}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Size/OI:</span>
          <span style={{ color: OPT.text, fontSize: 15 }}>{fmtCount(a.Volume)}/ {fmtCount(a.OI)}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Sweeps/Blocks:</span>
          <span style={{ color: OPT.text, fontSize: 15 }}>{a.SWEEPS}/{a.BLOCKS}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Alerted Price:</span>
          <span style={{ color: OPT.text, fontSize: 15 }}>${a.AlertPrice?.toFixed(2) || '—'}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Last Price:</span>
          <span style={{ color: OPT.text, fontSize: 15 }}>${h?.lastPrice.toFixed(2) || '—'}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Gain %:</span>
          <span style={{ color: h && h.gainPct >= 0 ? OPT.green : OPT.red, fontSize: 15, fontWeight: 600 }}>
            {h ? `${h.gainPct >= 0 ? '' : ''}${h.gainPct.toFixed(2)}%` : '—'}
          </span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Highest after:</span>
          <span style={{ color: OPT.text, fontSize: 15 }}>${h?.maxPrice.toFixed(2) || '—'}</span>
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
          <span style={{ color: OPT.textMuted, fontSize: 12 }}>Max Gain %:</span>
          <span style={{ color: OPT.green, fontSize: 15, fontWeight: 600 }}>
            {h ? `+${h.maxGainPct.toFixed(2)}%` : '—'}
          </span>
        </div>
      </div>
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Option Flow Tape — Option Flow sub-tab (dense rows)
// ──────────────────────────────────────────────────────────
const FlowTapeRow: React.FC<{ f: FlowEntry }> = ({ f }) => {
  const isBull = f.BidAskType?.toUpperCase().includes('A') && f.OptionType === 'Call';
  const isBear = f.BidAskType?.toUpperCase().includes('A') && f.OptionType === 'Put';
  const color = isBull ? OPT.green : isBear ? OPT.red : OPT.yellow;
  const highlight = f.Value >= 1_000_000;
  const time = new Date(f.Time * 1000).toLocaleTimeString('en-US', { hour12: false });
  const pillBg = f.BlockType === 'SWEEP' ? `${OPT.amber}22` : `${OPT.cyan}22`;
  const pillCol = f.BlockType === 'SWEEP' ? OPT.amber : OPT.cyan;
  return (
    <div style={{
      display: 'grid', gridTemplateColumns: '58px 50px 56px 44px 30px 70px 44px 60px',
      gap: 6, padding: '6px 10px', fontSize: 11, alignItems: 'center',
      borderBottom: `1px solid ${OPT.borderDim}`,
      background: highlight ? `${OPT.yellow}10` : 'transparent',
      borderLeft: highlight ? `2px solid ${OPT.yellow}` : '2px solid transparent',
      color, fontVariantNumeric: 'tabular-nums',
    }}>
      <span>{time}</span>
      <span style={{ fontWeight: 600 }}>{f.Symbol}</span>
      <span>{f.ExpiryStr?.slice(2) || ''}</span>
      <span>{f.Strike}</span>
      <span>{f.OptionType === 'Call' ? 'C' : 'P'}</span>
      <span>{f.Price?.toFixed(2)}{f.BidAskType}</span>
      <span style={{ padding: '1px 5px', borderRadius: 3, fontSize: 9, background: pillBg, color: pillCol, textAlign: 'center' }}>
        {f.BlockType === 'SWEEP' ? 'SWP' : 'BLK'}
      </span>
      <span style={{ textAlign: 'right' }}>{fmtMoney(f.Value)}</span>
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Chain View — OptionsWatcher tab (single-column compact chain)
// ──────────────────────────────────────────────────────────
const ChainView: React.FC = () => {
  const [ticker, setTicker] = useState('SPY');
  const [search, setSearch] = useState('SPY');
  const [expirations, setExpirations] = useState<string[]>([]);
  const [selectedExp, setSelectedExp] = useState('');
  const [calls, setCalls] = useState<ChainContract[]>([]);
  const [puts, setPuts] = useState<ChainContract[]>([]);
  const [spot, setSpot] = useState<number>(0);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    let cancelled = false;
    (async () => {
      try {
        const r = await fetch(`/api/options-chain?symbol=${ticker}`);
        if (!r.ok) return;
        const d = await r.json();
        if (cancelled) return;
        setExpirations(d.expirations || []);
        setSpot(d.spot || d.quote?.last || 0);
        if (d.expirations?.length && !selectedExp) setSelectedExp(d.expirations[0]);
      } catch {}
    })();
    return () => { cancelled = true; };
  }, [ticker]);

  useEffect(() => {
    if (!ticker || !selectedExp) return;
    let cancelled = false;
    setLoading(true);
    (async () => {
      try {
        const r = await fetch(`/api/options-chain?symbol=${ticker}&expiration=${selectedExp}&greeks=true`);
        if (!r.ok) { setLoading(false); return; }
        const d = await r.json();
        if (cancelled) return;
        setCalls(d.calls || []);
        setPuts(d.puts || []);
        if (d.spot || d.quote?.last) setSpot(d.spot || d.quote?.last);
      } catch {}
      setLoading(false);
    })();
    return () => { cancelled = true; };
  }, [ticker, selectedExp]);

  // Pair calls + puts by strike, sort closest to ATM at top
  const rows = useMemo(() => {
    const strikes = new Set<number>();
    calls.forEach(c => strikes.add(c.strike));
    puts.forEach(p => strikes.add(p.strike));
    const sorted = Array.from(strikes).sort((a, b) => Math.abs(a - spot) - Math.abs(b - spot)).slice(0, 25);
    sorted.sort((a, b) => a - b);
    return sorted.map(k => ({
      strike: k,
      call: calls.find(c => c.strike === k),
      put: puts.find(p => p.strike === k),
    }));
  }, [calls, puts, spot]);

  return (
    <div style={{ padding: '16px 14px 100px' }}>
      {/* Ticker input + spot */}
      <div style={{ display: 'flex', gap: 8, marginBottom: 12, alignItems: 'center' }}>
        <input
          value={search}
          onChange={e => setSearch(e.target.value.toUpperCase())}
          onKeyDown={e => { if (e.key === 'Enter') { setTicker(search); setSelectedExp(''); } }}
          placeholder="Ticker"
          style={{
            flex: 1, padding: '10px 14px', borderRadius: 10,
            background: OPT.card, border: `1px solid ${OPT.border}`,
            color: OPT.text, fontSize: 15, fontFamily: 'inherit', outline: 'none',
          }}
        />
        <div style={{
          padding: '8px 14px', borderRadius: 10, background: OPT.card,
          border: `1px solid ${OPT.border}`, color: OPT.green, fontWeight: 700,
          fontVariantNumeric: 'tabular-nums', fontSize: 16, minWidth: 90, textAlign: 'right',
        }}>${spot.toFixed(2)}</div>
      </div>

      {/* Expiration tabs (horizontal scroll) */}
      <div style={{ display: 'flex', gap: 6, overflowX: 'auto', marginBottom: 12, paddingBottom: 4, scrollbarWidth: 'none' }}>
        {expirations.slice(0, 12).map(exp => (
          <button key={exp} onClick={() => setSelectedExp(exp)} style={{
            padding: '7px 14px', borderRadius: 18, fontSize: 12, fontWeight: 500,
            background: selectedExp === exp ? OPT.green : 'transparent',
            color: selectedExp === exp ? '#0a0f15' : OPT.textMuted,
            border: `1px solid ${selectedExp === exp ? OPT.green : OPT.border}`,
            whiteSpace: 'nowrap', cursor: 'pointer', flexShrink: 0,
          }}>{exp.slice(5)}</button>
        ))}
      </div>

      {/* Chain rows: strike with call+put bid/ask/IV */}
      {loading && (
        <div style={{ textAlign: 'center', color: OPT.textMuted, padding: '40px 0', fontSize: 13 }}>Loading…</div>
      )}
      {!loading && rows.length === 0 && (
        <div style={{ textAlign: 'center', color: OPT.textMuted, padding: '40px 0', fontSize: 13 }}>No chain data yet — search a ticker above.</div>
      )}
      {!loading && rows.map(row => {
        const isATM = Math.abs(row.strike - spot) < (spot * 0.005);
        return (
          <div key={row.strike} style={{
            display: 'grid', gridTemplateColumns: '1fr 60px 1fr', alignItems: 'center', gap: 8,
            padding: '8px 10px', marginBottom: 6, borderRadius: 8,
            background: isATM ? `${OPT.cyan}10` : OPT.card,
            border: `1px solid ${isATM ? OPT.cyan + '55' : OPT.border}`,
          }}>
            {/* CALL side */}
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 4, fontSize: 12 }}>
              <div style={{ display: 'flex', flexDirection: 'column' }}>
                <span style={{ color: OPT.green, fontWeight: 600, fontVariantNumeric: 'tabular-nums', fontSize: 13 }}>{row.call?.last?.toFixed(2) || '—'}</span>
                <span style={{ color: OPT.textMuted, fontSize: 10 }}>IV {row.call?.greeks?.mid_iv ? ((row.call.greeks.mid_iv ?? 0) * 100).toFixed(0) + '%' : '—'}</span>
              </div>
              <div style={{ textAlign: 'right' }}>
                <div style={{ color: OPT.textMuted, fontSize: 10, fontVariantNumeric: 'tabular-nums' }}>{fmtCount(row.call?.volume || 0)}vol</div>
                <div style={{ color: OPT.textMuted, fontSize: 10, fontVariantNumeric: 'tabular-nums' }}>{fmtCount(row.call?.open_interest || 0)}oi</div>
              </div>
            </div>
            {/* STRIKE */}
            <div style={{ textAlign: 'center', color: isATM ? OPT.cyan : OPT.text, fontWeight: 700, fontVariantNumeric: 'tabular-nums', fontSize: 14 }}>{row.strike}</div>
            {/* PUT side */}
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 4, fontSize: 12 }}>
              <div style={{ textAlign: 'left' }}>
                <div style={{ color: OPT.textMuted, fontSize: 10, fontVariantNumeric: 'tabular-nums' }}>{fmtCount(row.put?.volume || 0)}vol</div>
                <div style={{ color: OPT.textMuted, fontSize: 10, fontVariantNumeric: 'tabular-nums' }}>{fmtCount(row.put?.open_interest || 0)}oi</div>
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-end' }}>
                <span style={{ color: OPT.red, fontWeight: 600, fontVariantNumeric: 'tabular-nums', fontSize: 13 }}>{row.put?.last?.toFixed(2) || '—'}</span>
                <span style={{ color: OPT.textMuted, fontSize: 10 }}>IV {row.put?.greeks?.mid_iv ? ((row.put.greeks.mid_iv ?? 0) * 100).toFixed(0) + '%' : '—'}</span>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Top Bar (hamburger + green title + search)
// ──────────────────────────────────────────────────────────
const TopBar: React.FC<{ title: string; onMenuClick?: () => void; rightExtras?: React.ReactNode }> = ({ title, onMenuClick, rightExtras }) => (
  <div style={{
    display: 'flex', alignItems: 'center', justifyContent: 'space-between',
    padding: '14px 16px 10px', background: OPT.bg,
    borderBottom: `1px solid ${OPT.borderDim}`,
  }}>
    <button onClick={onMenuClick} aria-label="Open menu" style={{
      background: 'transparent', border: 'none', color: OPT.green, cursor: 'pointer',
      padding: 4, display: 'flex', alignItems: 'center',
    }}>
      <Menu size={26} strokeWidth={2.2} />
    </button>
    <div style={{ color: OPT.green, fontSize: 22, fontWeight: 500, letterSpacing: 0.3, flex: 1, textAlign: 'center' }}>{title}</div>
    <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
      {rightExtras}
      <button aria-label="Search" style={{ background: 'transparent', border: 'none', color: OPT.green, cursor: 'pointer', padding: 4, display: 'flex', alignItems: 'center' }}>
        <Search size={22} strokeWidth={2.2} />
      </button>
    </div>
  </div>
);

// ──────────────────────────────────────────────────────────
// Sub-tab strip (green underline indicator)
// ──────────────────────────────────────────────────────────
const SubTabStrip: React.FC<{ tabs: { id: string; label: string; count?: number }[]; active: string; onChange: (id: string) => void }> = ({ tabs, active, onChange }) => (
  <div style={{ display: 'flex', borderBottom: `1px solid ${OPT.borderDim}`, background: OPT.bg, overflowX: 'auto', scrollbarWidth: 'none' }}>
    {tabs.map(t => (
      <button key={t.id} onClick={() => onChange(t.id)} style={{
        flex: 1, padding: '12px 14px', background: 'transparent', border: 'none',
        color: active === t.id ? OPT.green : OPT.textMuted,
        fontSize: 14, fontWeight: active === t.id ? 600 : 400,
        position: 'relative', cursor: 'pointer', whiteSpace: 'nowrap',
        display: 'inline-flex', alignItems: 'center', justifyContent: 'center', gap: 6,
      }}>
        {t.label}
        {t.count != null && <span style={{ fontSize: 12, opacity: 0.85 }}>({t.count})</span>}
        {active === t.id && <div style={{
          position: 'absolute', bottom: -1, left: '20%', right: '20%',
          height: 2.5, background: OPT.green, borderRadius: 2,
        }} />}
      </button>
    ))}
  </div>
);

// ──────────────────────────────────────────────────────────
// Bottom Tab Bar — Scalps / Swings / Leaps / Flow / Chain / More
// ──────────────────────────────────────────────────────────
const BottomTabBar: React.FC<{ active: PrimaryTab; onChange: (t: PrimaryTab) => void }> = ({ active, onChange }) => {
  const tabs: { id: PrimaryTab; icon: React.ReactNode; label: string }[] = [
    { id: 'scalps',     icon: <Crosshair size={22} />, label: 'Scalps' },
    { id: 'swings',     icon: <TrendingUp size={22} />, label: 'Swings' },
    { id: 'leaps',      icon: <PiggyBank size={22} />, label: 'Leaps' },
    { id: 'flowAlerts', icon: <Radio size={22} />, label: 'Flow Alerts' },
    { id: 'chain',      icon: <Layers size={22} />, label: 'Chain' },
    { id: 'more',       icon: <MoreHorizontal size={22} />, label: 'More' },
  ];
  return (
    <div className="opt-bottom-tab-bar" style={{
      position: 'fixed', bottom: 0, left: 0, right: 0, zIndex: 100,
      display: 'flex', justifyContent: 'space-around',
      padding: '8px 4px 10px',
      background: OPT.bg, borderTop: `1px solid ${OPT.borderDim}`,
    }}>
      {tabs.map(t => {
        const isActive = active === t.id;
        return (
          <button key={t.id} onClick={() => onChange(t.id)} style={{
            background: 'transparent', border: 'none', cursor: 'pointer',
            padding: '4px 6px', display: 'flex', flexDirection: 'column',
            alignItems: 'center', gap: 2, color: isActive ? OPT.green : OPT.textMuted, minWidth: 0,
          }}>
            {t.icon}
            <span style={{ fontSize: 10, fontWeight: isActive ? 600 : 400 }}>{t.label}</span>
          </button>
        );
      })}
    </div>
  );
};

// ──────────────────────────────────────────────────────────
// Detail Drawer (bottom sheet) — opens when signal card tapped
// ──────────────────────────────────────────────────────────
const DetailDrawer: React.FC<{ sig: AnalystSignal | null; onClose: () => void }> = ({ sig, onClose }) => {
  if (!sig) return null;
  const est = estGainPct(sig);
  return (
    <>
      <div onClick={onClose} style={{
        position: 'fixed', inset: 0, background: 'rgba(0,0,0,0.65)', zIndex: 200,
      }} />
      <div style={{
        position: 'fixed', left: 0, right: 0, bottom: 0, zIndex: 201,
        height: '85vh', background: OPT.bg, borderRadius: '16px 16px 0 0',
        border: `1px solid ${OPT.borderDim}`, borderBottom: 'none',
        display: 'flex', flexDirection: 'column', overflow: 'hidden',
        animation: 'optSheetUp 0.25s ease-out',
      }}>
        <style>{`@keyframes optSheetUp { from { transform: translateY(100%); } to { transform: translateY(0); } }`}</style>
        {/* Drag handle */}
        <div style={{ display: 'flex', justifyContent: 'center', padding: '8px 0 4px', flexShrink: 0 }}>
          <div style={{ width: 48, height: 4, borderRadius: 2, background: OPT.borderDim }} />
        </div>
        {/* Close button */}
        <button onClick={onClose} aria-label="Close" style={{
          position: 'absolute', top: 16, right: 16, background: 'transparent',
          border: 'none', color: OPT.textMuted, cursor: 'pointer', padding: 4,
        }}><X size={22} /></button>
        {/* Header */}
        <div style={{ padding: '8px 16px 12px', flexShrink: 0 }}>
          <div style={{ color: OPT.green, fontSize: 18, fontWeight: 700 }}>{sig.contractLabel}</div>
          <div style={{ color: OPT.textMuted, fontSize: 13, marginTop: 2 }}>{sig.shortName || sig.symbol}</div>
        </div>
        {/* Scrollable content */}
        <div style={{ flex: 1, overflowY: 'auto', padding: '0 16px 24px' }}>
          {/* Trend module */}
          <div style={{ background: OPT.card, border: `1px solid ${OPT.border}`, borderRadius: 12, padding: 14, marginBottom: 14 }}>
            <div style={{
              color: sig.isPut ? OPT.red : OPT.green, fontSize: 16, fontWeight: 600, marginBottom: 12,
              display: 'flex', alignItems: 'center', gap: 6,
            }}>
              {sig.isPut ? '▼' : '▲'} Trend: {sig.isPut ? 'Bearish' : 'Bullish'}
            </div>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 10 }}>
              <div style={{ padding: 10, background: OPT.cardElev, borderRadius: 8 }}>
                <div style={{ color: OPT.textMuted, fontSize: 10, marginBottom: 4 }}>Buy Target</div>
                <div style={{ color: OPT.green, fontSize: 15, fontWeight: 700 }}>{sig.buyTarget?.toFixed(2) || '—'}</div>
              </div>
              <div style={{ padding: 10, background: OPT.cardElev, borderRadius: 8 }}>
                <div style={{ color: OPT.textMuted, fontSize: 10, marginBottom: 4 }}>Stop Loss</div>
                <div style={{ color: OPT.red, fontSize: 15, fontWeight: 700 }}>{sig.stopLoss?.toFixed(2) || '—'}</div>
              </div>
              <div style={{ padding: 10, background: OPT.cardElev, borderRadius: 8 }}>
                <div style={{ color: OPT.textMuted, fontSize: 10, marginBottom: 4 }}>Est. Gain</div>
                <div style={{ color: est != null && est >= 0 ? OPT.green : OPT.red, fontSize: 15, fontWeight: 700 }}>
                  {est != null ? `${est.toFixed(1)}%` : '—'}
                </div>
              </div>
            </div>
          </div>

          {/* Targets module */}
          <div style={{ background: OPT.card, border: `1px solid ${OPT.border}`, borderRadius: 12, padding: 14, marginBottom: 14 }}>
            <div style={{ color: OPT.text, fontSize: 14, fontWeight: 600, marginBottom: 10 }}>Sell Targets</div>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 8 }}>
              {[sig.sellTarget, sig.sellTarget2, sig.sellTarget3].map((t, i) => (
                <div key={i} style={{
                  padding: 10, borderRadius: 8, textAlign: 'center',
                  background: t != null ? OPT.cardElev : 'transparent',
                  border: t != null ? `1px solid ${OPT.border}` : `1px dashed ${OPT.borderDim}`,
                }}>
                  <div style={{ color: OPT.textMuted, fontSize: 10, marginBottom: 4, textTransform: 'uppercase' }}>Target {i + 1}</div>
                  <div style={{ color: t != null ? OPT.text : OPT.textDim, fontSize: 15, fontWeight: 700 }}>{t != null ? t.toFixed(2) : '—'}</div>
                </div>
              ))}
            </div>
          </div>

          {/* Status */}
          {sig.status && (
            <div style={{ background: OPT.card, border: `1px solid ${OPT.border}`, borderRadius: 12, padding: 14, marginBottom: 14 }}>
              <div style={{ color: OPT.textMuted, fontSize: 12, marginBottom: 4 }}>Status</div>
              <div style={{ color: OPT.text, fontSize: 14, lineHeight: 1.5 }}>{sig.status}</div>
            </div>
          )}

          {/* Meta */}
          <div style={{ background: OPT.card, border: `1px solid ${OPT.border}`, borderRadius: 12, padding: 14, marginBottom: 14 }}>
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '10px 16px' }}>
              <StatPair label="Source" value={sig.source} bold={false} />
              <StatPair label="Category" value={sig.category || '—'} bold={false} />
              <StatPair label="Risk" value={sig.risk || '—'} bold={false}
                valueColor={sig.risk === 'VH' ? OPT.red : sig.risk === 'HI' ? OPT.amber : OPT.text} />
              <StatPair label="Type" value={sig.isPut ? 'Put' : 'Call'}
                valueColor={sig.isPut ? OPT.red : OPT.green} />
              <StatPair label="Expiry" value={sig.expiryStr || '—'} />
              <StatPair label="Strike" value={String(sig.strike)} />
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

// ──────────────────────────────────────────────────────────
// MAIN COMPONENT
// ──────────────────────────────────────────────────────────
interface Props {
  onMenuClick?: () => void;
  initialTab?: PrimaryTab;
}

export function OptionsPageMobile({ onMenuClick, initialTab = 'swings' }: Props) {
  const [activeTab, setActiveTab] = useState<PrimaryTab>(initialTab);
  const [subTab, setSubTab] = useState<SubTab>('signals');
  const [alertCat, setAlertCat] = useState<AlertCategory>('weekly');
  const [analystData, setAnalystData] = useState<AnalystResponse | null>(null);
  const [flowData, setFlowData] = useState<FlowResponse | null>(null);
  const [selectedSig, setSelectedSig] = useState<AnalystSignal | null>(null);

  useEffect(() => { setActiveTab(initialTab); }, [initialTab]);

  // Analyst signals polling
  useEffect(() => {
    let cancelled = false;
    const pull = async () => {
      try {
        const r = await fetch('/api/analyst-signals');
        if (!r.ok) return;
        const d = await r.json();
        if (!cancelled) setAnalystData(d);
      } catch {}
    };
    pull();
    const id = setInterval(pull, 15000);
    return () => { cancelled = true; clearInterval(id); };
  }, []);

  // Flow polling
  useEffect(() => {
    let cancelled = false;
    const pull = async () => {
      try {
        const r = await fetch('/api/options-flow');
        if (!r.ok) return;
        const d = await r.json();
        if (!cancelled) setFlowData(d);
      } catch {}
    };
    pull();
    const id = setInterval(pull, 10000);
    return () => { cancelled = true; clearInterval(id); };
  }, []);

  const titleMap: Record<PrimaryTab, string> = {
    scalps: 'Scalps', swings: 'Swings', leaps: 'Leaps',
    flowAlerts: 'Flow & Alerts', chain: 'Chain', more: 'More',
  };

  // Pick the byTab.{scalps,swings,leaps} segment for signal tabs
  const tabData = useMemo(() => {
    if (activeTab !== 'scalps' && activeTab !== 'swings' && activeTab !== 'leaps') return null;
    return analystData?.byTab[activeTab];
  }, [analystData, activeTab]);

  // Notifications view = everything in the active tab, sorted by ts desc, mixed open + closed
  const notifications = useMemo(() => {
    if (!tabData) return [];
    return [...tabData.open, ...tabData.closed].sort((a, b) => b.ts - a.ts).slice(0, 50);
  }, [tabData]);

  // Filter alerts by category
  const filteredAlerts = useMemo(() => {
    if (!flowData?.alerts) return [];
    const f = (a: AlertEntry) => {
      const t = (a.AlertType || '').toLowerCase();
      if (alertCat === 'etf')       return t.includes('etf');
      if (alertCat === 'weekly')    return t.includes('weekly');
      if (alertCat === 'repeaters') return t.includes('repeat');
      if (alertCat === 'unusual')   return t.includes('unusual');
      if (alertCat === 'huge')      return t.includes('high_flow') || t.includes('huge');
      return false;
    };
    return flowData.alerts.filter(f);
  }, [flowData, alertCat]);

  const alertCatCounts = useMemo(() => {
    const c = { weekly: 0, repeaters: 0, unusual: 0, huge: 0, etf: 0 };
    (flowData?.alerts || []).forEach(a => {
      const t = (a.AlertType || '').toLowerCase();
      if (t.includes('weekly'))   c.weekly++;
      if (t.includes('repeat'))   c.repeaters++;
      if (t.includes('unusual'))  c.unusual++;
      if (t.includes('high_flow') || t.includes('huge')) c.huge++;
      if (t.includes('etf'))      c.etf++;
    });
    return c;
  }, [flowData]);

  // Right-side extras for the top bar — bell + filter only on Flow Alerts
  const rightExtras = activeTab === 'flowAlerts' ? (
    <>
      <button aria-label="Notifications" style={{ background: 'transparent', border: 'none', color: OPT.green, cursor: 'pointer', padding: 4, display: 'flex', alignItems: 'center' }}>
        <Bell size={22} strokeWidth={2.2} />
      </button>
      <button aria-label="Filter" style={{ background: 'transparent', border: 'none', color: OPT.green, cursor: 'pointer', padding: 4, display: 'flex', alignItems: 'center' }}>
        <Filter size={22} strokeWidth={2.2} />
      </button>
    </>
  ) : undefined;

  return (
    <div style={{
      position: 'fixed', inset: 0, background: OPT.bg, color: OPT.text,
      display: 'flex', flexDirection: 'column', overflow: 'hidden',
      fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    }}>
      <TopBar title={titleMap[activeTab]} onMenuClick={onMenuClick} rightExtras={rightExtras} />

      {/* Sub-tab strip — content depends on primary tab */}
      {(activeTab === 'scalps' || activeTab === 'swings' || activeTab === 'leaps') && (
        <SubTabStrip
          tabs={[{ id: 'signals', label: 'Analyst & AI Signals' }, { id: 'notifications', label: 'Notifications' }]}
          active={subTab}
          onChange={(id) => setSubTab(id as SubTab)}
        />
      )}
      {activeTab === 'flowAlerts' && (
        <>
          <SubTabStrip
            tabs={[{ id: 'flowalerts', label: 'Flow Alerts' }, { id: 'optionflow', label: 'Option Flow' }]}
            active={subTab === 'signals' ? 'flowalerts' : 'optionflow'}
            onChange={(id) => setSubTab(id === 'flowalerts' ? 'signals' : 'notifications')}
          />
          {subTab === 'signals' && (
            <div style={{ display: 'flex', gap: 4, padding: '10px 14px', borderBottom: `1px solid ${OPT.borderDim}`, overflowX: 'auto', scrollbarWidth: 'none' }}>
              {([['weekly', 'Weekly Alerts'], ['repeaters', 'Repeaters'], ['unusual', 'Unusual'], ['huge', 'Huge Flow'], ['etf', 'ETF Flow']] as const).map(([id, label]) => {
                const isActive = alertCat === id;
                return (
                  <button key={id} onClick={() => setAlertCat(id)} style={{
                    padding: '6px 10px', background: 'transparent', border: 'none',
                    color: isActive ? OPT.green : OPT.textMuted,
                    fontSize: 13, fontWeight: isActive ? 600 : 400, whiteSpace: 'nowrap',
                    position: 'relative', cursor: 'pointer', display: 'inline-flex', alignItems: 'center', gap: 4,
                  }}>
                    {label} ({alertCatCounts[id]}) <Bell size={11} />
                    {isActive && <div style={{ position: 'absolute', bottom: -2, left: 6, right: 6, height: 2, background: OPT.green, borderRadius: 2 }} />}
                  </button>
                );
              })}
            </div>
          )}
        </>
      )}

      {/* Scrollable content */}
      <div style={{ flex: 1, overflowY: 'auto', paddingBottom: 80 }}>
        {(activeTab === 'scalps' || activeTab === 'swings' || activeTab === 'leaps') && tabData && (
          subTab === 'signals'
            ? <SignalsPane open={tabData.open} closed={tabData.closed} onTapSig={setSelectedSig} />
            : <NotificationsPane sigs={notifications} />
        )}
        {activeTab === 'flowAlerts' && subTab === 'signals' && (
          <div style={{ padding: '12px 14px' }}>
            {filteredAlerts.length === 0 && (
              <div style={{ color: OPT.textMuted, textAlign: 'center', padding: '40px 0', fontSize: 13 }}>No alerts in this category.</div>
            )}
            {filteredAlerts.map((a, i) => <FlowAlertCard key={a.OptionSymbol + '_' + i} a={a} />)}
          </div>
        )}
        {activeTab === 'flowAlerts' && subTab === 'notifications' && (
          <div style={{ padding: '4px 0' }}>
            <div style={{ display: 'grid', gridTemplateColumns: '58px 50px 56px 44px 30px 70px 44px 60px', gap: 6, padding: '8px 10px', borderBottom: `1px solid ${OPT.borderDim}`, color: OPT.textMuted, fontSize: 9, fontWeight: 600, textTransform: 'uppercase', letterSpacing: 0.5 }}>
              <span>Time</span><span>Sym</span><span>Exp</span><span>Str</span><span>C/P</span><span>Price</span><span>Type</span><span style={{ textAlign: 'right' }}>Value</span>
            </div>
            {(flowData?.flow || []).slice(0, 300).map((f, i) => <FlowTapeRow key={f.OptionSymbol + '_' + i} f={f} />)}
          </div>
        )}
        {activeTab === 'chain' && <ChainView />}
        {activeTab === 'more' && (
          <div style={{ padding: '24px 16px', color: OPT.textMuted, fontSize: 14, lineHeight: 1.6 }}>
            <div style={{ color: OPT.text, fontSize: 18, fontWeight: 700, marginBottom: 16 }}>More</div>
            <div style={{ padding: '14px 0', borderBottom: `1px solid ${OPT.borderDim}` }}>About</div>
            <div style={{ padding: '14px 0', borderBottom: `1px solid ${OPT.borderDim}` }}>Notification Settings</div>
            <div style={{ padding: '14px 0', borderBottom: `1px solid ${OPT.borderDim}` }}>Theme: <span style={{ color: OPT.green }}>Dark (OLED)</span></div>
            <div style={{ padding: '14px 0', borderBottom: `1px solid ${OPT.borderDim}` }}>View Mode: <span style={{ color: OPT.green }}>Mobile</span></div>
            <div style={{ marginTop: 24, fontSize: 12, color: OPT.textDim }}>Mission Control · Options Mobile · 2026</div>
          </div>
        )}
      </div>

      <BottomTabBar active={activeTab} onChange={(t) => { setActiveTab(t); setSubTab('signals'); }} />

      <DetailDrawer sig={selectedSig} onClose={() => setSelectedSig(null)} />
    </div>
  );
}

// ──────────────────────────────────────────────────────────
// Signals pane — Open + Past Performance sections
// ──────────────────────────────────────────────────────────
const SignalsPane: React.FC<{ open: AnalystSignal[]; closed: AnalystSignal[]; onTapSig: (s: AnalystSignal) => void }> = ({ open, closed, onTapSig }) => (
  <div style={{ padding: '14px 14px 0' }}>
    {/* Open section */}
    <div style={{ color: OPT.text, fontSize: 14, fontWeight: 600, marginBottom: 10, letterSpacing: 0.2 }}>Open</div>
    {open.length === 0 && (
      <div style={{ color: OPT.textMuted, textAlign: 'center', padding: '28px 0', fontSize: 15 }}>No Signals at the moment.</div>
    )}
    {open.map(s => <OpenSignalCard key={s.id} sig={s} onTap={() => onTapSig(s)} />)}

    {/* Past Performance */}
    {closed.length > 0 && (
      <>
        <div style={{ color: OPT.text, fontSize: 14, fontWeight: 600, margin: '18px 0 10px', paddingTop: 14, borderTop: `1px solid ${OPT.borderDim}` }}>
          Past Performance
        </div>
        {closed.slice(0, 30).map(s => <ClosedSignalCard key={s.id} sig={s} onTap={() => onTapSig(s)} />)}
      </>
    )}
  </div>
);

// ──────────────────────────────────────────────────────────
// Notifications pane
// ──────────────────────────────────────────────────────────
const NotificationsPane: React.FC<{ sigs: AnalystSignal[] }> = ({ sigs }) => (
  <div style={{ padding: '12px 14px' }}>
    {sigs.length === 0 && (
      <div style={{ color: OPT.textMuted, textAlign: 'center', padding: '40px 0', fontSize: 14 }}>No notifications yet.</div>
    )}
    {sigs.map(s => <NotificationCard key={s.id} sig={s} />)}
  </div>
);
