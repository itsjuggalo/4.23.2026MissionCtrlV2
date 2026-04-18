'use client';

import { useState, useEffect, useCallback } from 'react';
import { MetricCard } from '@/components/ui/MetricCard';
import { Badge } from '@/components/ui/Badge';
import { COLORS, FONTS } from '@/lib/constants';

// ─── Firebase ─────────────────────────────────────────────────────────────────

const FIREBASE_URLS = {
  shortOptions: 'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/ShortTermOptions.json',
  longOptions:  'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/LongTermOptions.json',
  shortStocks:  'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/ShortTermStocks.json',
  longStocks:   'https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2/LongTermStocks.json',
};

const POLL_INTERVAL_MS = 60_000;

interface FirebaseSignal {
  symbol?:       string;
  strike?:       number | string;
  isPut?:        number;
  category?:     string;
  isWeekly?:     number;
  free?:         number;
  expiry?:       number;
  buyTarget?:    number | string;
  stopLoss?:     number | string;
  reduceLoss?:   number | string;
  earlyTarget?:  number | string;
  sellTarget?:   number | string;
  sellTarget2?:  number | string;
  sellTarget3?:  number | string;
  sellTarget4?:  number | string;
  status?:       string;
  notes?:        string;
  quote?: {
    shortName?:    string;
    lastPrice?:    number;
    totalVolume?:  number;
    openInterest?: number;
  };
  [key: string]: unknown;
}

// Normalised signal with derived fields
interface Signal {
  id:        string;
  raw:       FirebaseSignal;
  isOption:  boolean;
  isCall:    boolean;       // true = CALL, false = PUT
  isBuy:     boolean;       // true = BUY/LONG, false = SELL/SHORT
  expiryUnix: number | null;
  expiryDate: Date | null;
  expCategory: 'weekly' | 'monthly' | 'leaps' | null;
}

function classify(id: string, raw: FirebaseSignal, isBuy: boolean, isOption: boolean): Signal {
  const isCall      = !raw.isPut || raw.isPut === 0;
  const expiryUnix  = raw.expiry ?? null;
  const expiryDate  = expiryUnix ? new Date(expiryUnix * 1000) : null;

  let expCategory: Signal['expCategory'] = null;
  if (expiryDate) {
    const daysOut = (expiryDate.getTime() - Date.now()) / 86400000;
    // Skip signals expired more than 1 day ago
    if (daysOut < -1) expCategory = 'expired' as any;
    expCategory = daysOut <= 7 ? 'weekly' : daysOut <= 60 ? 'monthly' : 'leaps';
  }

  return { id, raw, isOption, isCall, isBuy, expiryUnix, expiryDate, expCategory };
}

function useFirebaseSignals() {
  const [allSignals, setAllSignals] = useState<Signal[]>([]);
  const [loading,    setLoading]    = useState(true);
  const [error,      setError]      = useState<string | null>(null);
  const [lastUpdated,setLastUpdated]= useState<Date | null>(null);

  const fetchAll = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const [shortOpts, longOpts, shortStocks, longStocks] = await Promise.all([
        fetch(FIREBASE_URLS.shortOptions).then(r => r.json()),
        fetch(FIREBASE_URLS.longOptions).then(r => r.json()),
        fetch(FIREBASE_URLS.shortStocks).then(r => r.json()),
        fetch(FIREBASE_URLS.longStocks).then(r => r.json()),
      ]);

      const build = (
        obj: Record<string, FirebaseSignal> | null,
        isBuy: boolean,
        isOption: boolean
      ): Signal[] =>
        obj && typeof obj === 'object'
          ? Object.entries(obj).map(([id, raw]) => classify(id, raw, isBuy, isOption))
          : [];

      setAllSignals([
        ...build(shortOpts,   false, true),   // SELL options
        ...build(longOpts,    true,  true),    // BUY options
        ...build(shortStocks, false, false),   // SELL stocks
        ...build(longStocks,  true,  false),   // BUY stocks
      ]);
      setLastUpdated(new Date());
    } catch (e) {
      setError(e instanceof Error ? e.message : 'Fetch failed');
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchAll();
    const t = setInterval(fetchAll, POLL_INTERVAL_MS);
    return () => clearInterval(t);
  }, [fetchAll]);

  return { allSignals, loading, error, lastUpdated, refresh: fetchAll };
}

// ─── Helpers ──────────────────────────────────────────────────────────────────

function formatExpiry(d: Date | null): string {
  if (!d) return '—';
  return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: '2-digit' });
}

function formatPrice(val?: number | string): string {
  if (val === undefined || val === null || val === '') return '—';
  const n = Number(val);
  return isNaN(n) ? String(val) : `$${n.toFixed(2)}`;
}

function daysUntil(d: Date | null): string {
  if (!d) return '';
  const days = Math.ceil((d.getTime() - Date.now()) / 86400000);
  if (days < 0)  return `${Math.abs(days)}d ago`;
  if (days === 0) return 'today';
  return `${days}d`;
}

// ─── Toggle Button ────────────────────────────────────────────────────────────

function ToggleGroup<T extends string>({
  options, value, onChange, accentColor,
}: {
  options: T[];
  value: T;
  onChange: (v: T) => void;
  accentColor?: string;
}) {
  const accent = accentColor || COLORS.accent;
  return (
    <div style={{ display: 'flex', background: COLORS.bgSurface, borderRadius: 8, padding: 3, gap: 2 }}>
      {options.map(opt => {
        const active = value === opt;
        return (
          <button
            key={opt}
            onClick={() => onChange(opt)}
            style={{
              padding: '5px 14px',
              borderRadius: 6,
              border: 'none',
              cursor: 'pointer',
              fontFamily: FONTS.sans,
              fontSize: 12,
              fontWeight: active ? 600 : 400,
              background: active ? accent : 'transparent',
              color: active ? '#fff' : COLORS.textMuted,
              transition: 'all 0.15s',
            }}
          >
            {opt}
          </button>
        );
      })}
    </div>
  );
}

// ─── Signal Card ──────────────────────────────────────────────────────────────

function PriceField({ label, value, color = COLORS.textMuted }: { label: string; value: string; color?: string }) {
  return (
    <div>
      <div style={{ fontFamily: FONTS.mono, fontSize: 10, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px' }}>
        {label}
      </div>
      <div style={{ fontFamily: FONTS.mono, fontSize: 12, color }}>{value}</div>
    </div>
  );
}

function SignalCard({ sig }: { sig: Signal }) {
  const [expanded, setExpanded] = useState(false);
  const { raw, isCall, isBuy, expiryDate } = sig;

  const typeColor = isCall ? COLORS.green : COLORS.red;
  const dirColor  = isBuy  ? COLORS.green : COLORS.red;
  const days      = daysUntil(expiryDate);
  const daysNum   = expiryDate ? Math.ceil((expiryDate.getTime() - Date.now()) / 86400000) : 999;
  const daysColor = daysNum <= 3 ? COLORS.red : daysNum <= 7 ? COLORS.amber : COLORS.textMuted;

  return (
    <div
      onClick={() => setExpanded(e => !e)}
      style={{
        background: COLORS.bgCard,
        border: `1px solid ${COLORS.border}`,
        borderLeft: `3px solid ${typeColor}`,
        borderRadius: 8,
        padding: '12px 14px',
        cursor: 'pointer',
        transition: 'border-color 0.15s',
      }}
    >
      {/* Header row */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 8, flexWrap: 'wrap', marginBottom: 10 }}>
        <span style={{ fontFamily: FONTS.mono, fontWeight: 700, fontSize: 15, color: COLORS.text }}>
          {raw.symbol || sig.id}
        </span>
        {sig.isOption && raw.strike != null && (
          <span style={{ fontFamily: FONTS.mono, fontSize: 13, color: COLORS.textMuted }}>
            ${raw.strike}
          </span>
        )}

        {/* Type badge */}
        {sig.isOption && (
          <Badge color={typeColor}>{isCall ? 'CALL' : 'PUT'}</Badge>
        )}

        {/* Direction badge */}
        <Badge color={dirColor}>{isBuy ? 'BUY' : 'SELL'}</Badge>

        {/* Style badge */}
        {raw.category && (
          <Badge color={COLORS.accent}>{raw.category}</Badge>
        )}
        {raw.isWeekly === 1 && (
          <Badge color={COLORS.cyan}>WEEKLY</Badge>
        )}

        {/* Expiry on the right */}
        {expiryDate && (
          <span style={{ marginLeft: 'auto', display: 'flex', alignItems: 'center', gap: 6 }}>
            <span style={{ fontFamily: FONTS.mono, fontSize: 11, color: COLORS.textMuted }}>
              {formatExpiry(expiryDate)}
            </span>
            <span style={{ fontFamily: FONTS.mono, fontSize: 11, color: daysColor, fontWeight: 600 }}>
              {days}
            </span>
          </span>
        )}
      </div>

      {/* Price fields */}
      <div style={{ display: 'flex', gap: 20, flexWrap: 'wrap', marginBottom: raw.status || raw.notes ? 8 : 0 }}>
        {raw.buyTarget != null && (
          <PriceField label="Entry"  value={formatPrice(raw.buyTarget)} color={COLORS.text} />
        )}
        {(raw.stopLoss != null || raw.reduceLoss != null) && (
          <PriceField label="Stop"   value={formatPrice(raw.stopLoss ?? raw.reduceLoss)} color={COLORS.red} />
        )}
        {raw.earlyTarget != null && (
          <PriceField label="T1"     value={formatPrice(raw.earlyTarget)} color={COLORS.green} />
        )}
        {raw.sellTarget != null && (
          <PriceField label="T2"     value={formatPrice(raw.sellTarget)}  color={COLORS.green} />
        )}
        {raw.sellTarget2 != null && (
          <PriceField label="T3"     value={formatPrice(raw.sellTarget2)} color={COLORS.green} />
        )}
        {raw.sellTarget3 != null && (
          <PriceField label="T4"     value={formatPrice(raw.sellTarget3)} color={COLORS.green} />
        )}
        {raw.sellTarget4 != null && (
          <PriceField label="T5"     value={formatPrice(raw.sellTarget4)} color={COLORS.green} />
        )}
      </div>

      {/* Status / notes */}
      {(raw.status || raw.notes) && (
        <div style={{ fontFamily: FONTS.sans, fontSize: 11, color: COLORS.textMuted, marginTop: 4 }}>
          {raw.status}{raw.notes ? ` · ${raw.notes}` : ''}
        </div>
      )}

      {/* Expanded quote */}
      {expanded && raw.quote && (
        <div style={{ marginTop: 10, paddingTop: 10, borderTop: `1px solid ${COLORS.border}`, display: 'flex', gap: 20, flexWrap: 'wrap' }}>
          {raw.quote.shortName   && <PriceField label="Name"   value={raw.quote.shortName} />}
          {raw.quote.lastPrice   != null && <PriceField label="Last"   value={formatPrice(raw.quote.lastPrice)}  color={COLORS.text} />}
          {raw.quote.totalVolume != null && <PriceField label="Volume" value={raw.quote.totalVolume.toLocaleString()}  color={COLORS.text} />}
          {raw.quote.openInterest!= null && <PriceField label="OI"     value={raw.quote.openInterest.toLocaleString()} color={COLORS.text} />}
        </div>
      )}
    </div>
  );
}

// ─── Expiration Section ───────────────────────────────────────────────────────

function ExpirySection({
  label, signals, accent,
}: {
  label: string;
  signals: Signal[];
  accent: string;
}) {
  if (signals.length === 0) return null;
  const sorted = [...signals].sort((a, b) => (a.expiryUnix ?? 0) - (b.expiryUnix ?? 0));

  return (
    <div style={{ marginBottom: 24 }}>
      {/* Section header */}
      <div style={{
        display: 'flex', alignItems: 'center', gap: 10,
        marginBottom: 10, paddingBottom: 8,
        borderBottom: `1px solid ${COLORS.border}`,
      }}>
        <span style={{
          fontFamily: FONTS.mono, fontWeight: 700, fontSize: 11,
          color: accent, letterSpacing: '1.5px', textTransform: 'uppercase',
        }}>
          {label}
        </span>
        <span style={{
          background: `${accent}22`, color: accent,
          fontFamily: FONTS.mono, fontSize: 10, fontWeight: 700,
          borderRadius: 10, padding: '1px 8px',
        }}>
          {signals.length}
        </span>
      </div>
      <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
        {sorted.map(sig => <SignalCard key={sig.id} sig={sig} />)}
      </div>
    </div>
  );
}

// ─── Main Page ────────────────────────────────────────────────────────────────

type MainTab      = 'Options' | 'Stocks';
type OptionType   = 'All' | 'Calls' | 'Puts';
type DirectionFilter = 'All' | 'Buy (Long)' | 'Sell (Short)';

export function SignalsPage() {
  const { allSignals, loading, error, lastUpdated, refresh } = useFirebaseSignals();

  const [mainTab,   setMainTab]   = useState<MainTab>('Options');
  const [optType,   setOptType]   = useState<OptionType>('All');
  const [direction, setDirection] = useState<DirectionFilter>('All');

  // Separate options from stocks
  const optionSignals = allSignals.filter(s => s.isOption);
  const stockSignals  = allSignals.filter(s => !s.isOption);

  // Apply filters
  function applyFilters(signals: Signal[]): Signal[] {
    return signals.filter(sig => {
      if (optType === 'Calls' && !sig.isCall)  return false;
      if (optType === 'Puts'  &&  sig.isCall)  return false;
      if (direction === 'Buy (Long)'   && !sig.isBuy) return false;
      if (direction === 'Sell (Short)' &&  sig.isBuy) return false;
      return true;
    });
  }

  const filteredOptions = applyFilters(optionSignals);
  const filteredStocks  = applyFilters(stockSignals);

  // Group options by expiry window
  const weekly  = filteredOptions.filter(s => s.expCategory === 'weekly');
  const monthly = filteredOptions.filter(s => s.expCategory === 'monthly');
  const leaps   = filteredOptions.filter(s => s.expCategory === 'leaps');
  const noExpiry= filteredOptions.filter(s => !s.expCategory && (s as any).expCategory !== 'expired');

  // Sort stocks by expiry (soonest first) or just by id
  const sortedStocks = [...filteredStocks].sort((a, b) =>
    (a.expiryUnix ?? 9999999999) - (b.expiryUnix ?? 9999999999)
  );

  function updatedAgo(): string {
    if (!lastUpdated) return '';
    const diff = Math.floor((Date.now() - lastUpdated.getTime()) / 60000);
    return diff < 1 ? 'just now' : `${diff}m ago`;
  }

  const statusColor = error ? COLORS.red : loading ? COLORS.amber : COLORS.green;
  const statusLabel = error ? 'ERROR' : loading ? 'LOADING' : 'LIVE';

  // Counts for header cards
  const totalOptions = optionSignals.length;
  const callCount    = optionSignals.filter(s =>  s.isCall).length;
  const putCount     = optionSignals.filter(s => !s.isCall).length;
  const weeklyCount  = optionSignals.filter(s => s.expCategory === 'weekly').length;

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>

      {/* Status bar */}
      <div style={{
        display: 'flex', alignItems: 'center', gap: 12,
        padding: '10px 16px',
        background: `${statusColor}0d`,
        border: `1px solid ${statusColor}33`,
        borderRadius: 8,
      }}>
        <span style={{ width: 8, height: 8, borderRadius: '50%', background: statusColor, boxShadow: `0 0 6px ${statusColor}`, display: 'inline-block', flexShrink: 0 }} />
        <span style={{ fontFamily: FONTS.mono, fontSize: 12, color: statusColor, fontWeight: 600, letterSpacing: '0.5px' }}>
          {statusLabel}
        </span>
        {lastUpdated && (
          <span style={{ fontFamily: FONTS.mono, fontSize: 11, color: COLORS.textDim }}>
            Updated {updatedAgo()}
          </span>
        )}
        <button
          onClick={refresh}
          style={{ marginLeft: 'auto', background: 'transparent', border: `1px solid ${COLORS.border}`, borderRadius: 4, padding: '3px 10px', cursor: 'pointer', color: COLORS.textMuted, fontFamily: FONTS.mono, fontSize: 11 }}
        >
          Refresh
        </button>
      </div>

      {/* Metric cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
        <MetricCard label="Total Options" value={String(totalOptions)}  subtitle="All active signals"  color={COLORS.accent} />
        <MetricCard label="Calls"         value={String(callCount)}     subtitle="Call options"        color={COLORS.green}  />
        <MetricCard label="Puts"          value={String(putCount)}      subtitle="Put options"         color={COLORS.red}    />
        <MetricCard label="Expiring Soon" value={String(weeklyCount)}   subtitle="Within 7 days"      color={COLORS.amber}  />
      </div>

      {/* Main tab: Options / Stocks */}
      <div style={{ display: 'flex', gap: 4 }}>
        {(['Options', 'Stocks'] as MainTab[]).map(tab => (
          <button
            key={tab}
            onClick={() => setMainTab(tab)}
            style={{
              padding: '7px 18px', borderRadius: 6, border: 'none', cursor: 'pointer',
              fontFamily: FONTS.sans, fontSize: 13, fontWeight: mainTab === tab ? 600 : 400,
              background: mainTab === tab ? 'rgba(108,92,231,0.14)' : 'transparent',
              color: mainTab === tab ? COLORS.accentLight : COLORS.textMuted,
              borderBottom: mainTab === tab ? `2px solid ${COLORS.accent}` : '2px solid transparent',
              transition: 'all 0.15s',
            }}
          >
            {tab}
            <span style={{
              marginLeft: 6, fontFamily: FONTS.mono, fontSize: 10, fontWeight: 700,
              background: mainTab === tab ? COLORS.accent : COLORS.bgSurface,
              color: mainTab === tab ? '#fff' : COLORS.textMuted,
              borderRadius: 8, padding: '1px 6px',
            }}>
              {tab === 'Options' ? filteredOptions.length : filteredStocks.length}
            </span>
          </button>
        ))}
      </div>

      {/* Filter toggles */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 16, flexWrap: 'wrap' }}>
        {mainTab === 'Options' && (
          <>
            <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
              <span style={{ fontFamily: FONTS.mono, fontSize: 11, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px' }}>
                Type
              </span>
              <ToggleGroup<OptionType>
                options={['All', 'Calls', 'Puts']}
                value={optType}
                onChange={setOptType}
                accentColor={COLORS.accent}
              />
            </div>
            <div style={{ width: 1, height: 28, background: COLORS.border }} />
          </>
        )}
        <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
          <span style={{ fontFamily: FONTS.mono, fontSize: 11, color: COLORS.textDim, textTransform: 'uppercase', letterSpacing: '0.5px' }}>
            Direction
          </span>
          <ToggleGroup<DirectionFilter>
            options={['All', 'Buy (Long)', 'Sell (Short)']}
            value={direction}
            onChange={setDirection}
            accentColor={direction === 'Sell (Short)' ? COLORS.red : COLORS.green}
          />
        </div>
      </div>

      {/* Content */}
      {loading && allSignals.length === 0 && (
        <div style={{ fontFamily: FONTS.mono, fontSize: 13, color: COLORS.textDim, padding: '20px 0' }}>Loading signals…</div>
      )}
      {error && allSignals.length === 0 && (
        <div style={{ fontFamily: FONTS.mono, fontSize: 13, color: COLORS.red, padding: '20px 0' }}>{error}</div>
      )}

      {/* OPTIONS view — grouped by expiry */}
      {mainTab === 'Options' && !loading && (
        filteredOptions.length === 0
          ? <div style={{ fontFamily: FONTS.mono, fontSize: 13, color: COLORS.textDim, padding: '20px 0' }}>No signals match the current filters.</div>
          : <>
              <ExpirySection label="⚡ Weekly — Expires within 7 days" signals={weekly}  accent={COLORS.red}   />
              <ExpirySection label="📅 Monthly — 8–60 days"            signals={monthly} accent={COLORS.amber} />
              <ExpirySection label="🏔️ LEAPS — 60+ days"               signals={leaps}   accent={COLORS.blue}  />
              <ExpirySection label="📌 No Expiry"                       signals={noExpiry}accent={COLORS.textMuted} />
            </>
      )}

      {/* STOCKS view — flat list */}
      {mainTab === 'Stocks' && !loading && (
        sortedStocks.length === 0
          ? <div style={{ fontFamily: FONTS.mono, fontSize: 13, color: COLORS.textDim, padding: '20px 0' }}>No stock signals match the current filters.</div>
          : <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
              {sortedStocks.map(sig => <SignalCard key={sig.id} sig={sig} />)}
            </div>
      )}

      {/* Footer */}
      <div style={{
        padding: '10px 14px', background: COLORS.bgSurfaceAlt, border: `1px solid ${COLORS.border}`,
        borderRadius: 8, fontFamily: FONTS.mono, fontSize: 11, color: COLORS.textDim,
        display: 'flex', flexDirection: 'column', gap: 4,
      }}>
        <div>Firebase: stock-signal-72772-default-rtdb.firebaseio.com/Vivid2 · Polling every {POLL_INTERVAL_MS / 1000}s</div>
        <div>AI Crypto Signals (wss://ws.aicryptosignals.pro:8766) — active</div>
      </div>
    </div>
  );
}
