'use client';
import React, { useEffect, useState } from 'react';

export type FilterState = {
  types: { call: boolean; put: boolean };
  sides: { ask: boolean; bid: boolean; other: boolean };
  flowKinds: { sweep: boolean; block: boolean };
  instruments: { stock: boolean; etf: boolean };
  minPremium: number;
  minDTE: number | null;
  maxDTE: number | null;
};

export const DEFAULT_FILTERS: FilterState = {
  types: { call: true, put: true },
  sides: { ask: true, bid: true, other: true },
  flowKinds: { sweep: true, block: true },
  instruments: { stock: true, etf: true },
  minPremium: 0,
  minDTE: null,
  maxDTE: null,
};

const PREMIUM_OPTIONS = [
  { v: 0, l: 'Any' },
  { v: 50000, l: '$50K+' },
  { v: 100000, l: '$100K+' },
  { v: 250000, l: '$250K+' },
  { v: 500000, l: '$500K+' },
  { v: 1000000, l: '$1M+' },
  { v: 5000000, l: '$5M+' },
];

export function isFiltersDefault(f: FilterState): boolean {
  return JSON.stringify(f) === JSON.stringify(DEFAULT_FILTERS);
}

export function loadFilters(storageKey: string): FilterState {
  if (typeof window === 'undefined') return DEFAULT_FILTERS;
  try {
    const raw = localStorage.getItem(storageKey);
    if (!raw) return DEFAULT_FILTERS;
    const parsed = JSON.parse(raw);
    return { ...DEFAULT_FILTERS, ...parsed };
  } catch {
    return DEFAULT_FILTERS;
  }
}

export function saveFilters(storageKey: string, f: FilterState) {
  if (typeof window === 'undefined') return;
  try { localStorage.setItem(storageKey, JSON.stringify(f)); } catch {}
}

const Checkbox: React.FC<{ label: string; checked: boolean; onChange: (v: boolean) => void }> = ({ label, checked, onChange }) => (
  <label style={{ display: 'flex', alignItems: 'center', gap: '8px', cursor: 'pointer', fontSize: '13px', color: '#e0e0e0', userSelect: 'none' }}>
    <input
      type="checkbox"
      checked={checked}
      onChange={e => onChange(e.target.checked)}
      style={{ width: '16px', height: '16px', accentColor: '#66bb6a', cursor: 'pointer' }}
    />
    {label}
  </label>
);

const SectionLabel: React.FC<{ children: React.ReactNode }> = ({ children }) => (
  <div style={{ fontSize: '10px', fontWeight: 600, color: '#607d8b', textTransform: 'uppercase', letterSpacing: '0.6px', marginBottom: '8px' }}>
    {children}
  </div>
);

export const FilterModal: React.FC<{
  open: boolean;
  onClose: () => void;
  storageKey: string;
  onApply: (f: FilterState) => void;
  initial: FilterState;
}> = ({ open, onClose, storageKey, onApply, initial }) => {
  const [draft, setDraft] = useState<FilterState>(initial);

  useEffect(() => {
    // eslint-disable-next-line react-hooks/set-state-in-effect
    if (open) setDraft(initial);
  }, [open, initial]);

  useEffect(() => {
    const onEsc = (e: KeyboardEvent) => { if (e.key === 'Escape') onClose(); };
    if (open) window.addEventListener('keydown', onEsc);
    return () => window.removeEventListener('keydown', onEsc);
  }, [open, onClose]);

  if (!open) return null;

  const apply = () => {
    saveFilters(storageKey, draft);
    onApply(draft);
    onClose();
  };
  const reset = () => setDraft(DEFAULT_FILTERS);
  const discard = () => { onClose(); };

  return (
    <div
      onClick={discard}
      style={{
        position: 'fixed', inset: 0, background: 'rgba(0,0,0,0.55)',
        zIndex: 1000, display: 'flex', alignItems: 'center', justifyContent: 'center',
      }}
    >
      <div
        onClick={e => e.stopPropagation()}
        style={{
          width: '480px', maxWidth: '92vw', maxHeight: '88vh', overflowY: 'auto',
          background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: '8px',
          padding: '20px 22px', color: '#e0e0e0',
        }}
      >
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '18px', paddingBottom: '12px', borderBottom: '1px solid #1a3a4a' }}>
          <div style={{ fontSize: '15px', fontWeight: 600 }}>Filters</div>
          <button
            onClick={discard}
            style={{ background: 'transparent', border: 'none', color: '#607d8b', fontSize: '22px', cursor: 'pointer', padding: 0, lineHeight: 1 }}
            aria-label="Close"
          >×</button>
        </div>

        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '18px', marginBottom: '14px' }}>
          <div>
            <SectionLabel>Option Type</SectionLabel>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
              <Checkbox label="Calls" checked={draft.types.call} onChange={v => setDraft(d => ({ ...d, types: { ...d.types, call: v } }))} />
              <Checkbox label="Puts" checked={draft.types.put} onChange={v => setDraft(d => ({ ...d, types: { ...d.types, put: v } }))} />
            </div>
          </div>

          <div>
            <SectionLabel>Execution Side</SectionLabel>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
              <Checkbox label="At Ask" checked={draft.sides.ask} onChange={v => setDraft(d => ({ ...d, sides: { ...d.sides, ask: v } }))} />
              <Checkbox label="At Bid" checked={draft.sides.bid} onChange={v => setDraft(d => ({ ...d, sides: { ...d.sides, bid: v } }))} />
              <Checkbox label="Other" checked={draft.sides.other} onChange={v => setDraft(d => ({ ...d, sides: { ...d.sides, other: v } }))} />
            </div>
          </div>

          <div>
            <SectionLabel>Flow Type</SectionLabel>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
              <Checkbox label="Sweeps" checked={draft.flowKinds.sweep} onChange={v => setDraft(d => ({ ...d, flowKinds: { ...d.flowKinds, sweep: v } }))} />
              <Checkbox label="Blocks" checked={draft.flowKinds.block} onChange={v => setDraft(d => ({ ...d, flowKinds: { ...d.flowKinds, block: v } }))} />
            </div>
          </div>

          <div>
            <SectionLabel>Instrument</SectionLabel>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
              <Checkbox label="Stocks" checked={draft.instruments.stock} onChange={v => setDraft(d => ({ ...d, instruments: { ...d.instruments, stock: v } }))} />
              <Checkbox label="ETFs" checked={draft.instruments.etf} onChange={v => setDraft(d => ({ ...d, instruments: { ...d.instruments, etf: v } }))} />
            </div>
          </div>
        </div>

        <div style={{ marginBottom: '14px' }}>
          <SectionLabel>Min Premium</SectionLabel>
          <select
            value={draft.minPremium}
            onChange={e => setDraft(d => ({ ...d, minPremium: Number(e.target.value) }))}
            style={{ width: '100%', padding: '7px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontSize: '13px', cursor: 'pointer' }}
          >
            {PREMIUM_OPTIONS.map(o => <option key={o.v} value={o.v}>{o.l}</option>)}
          </select>
        </div>

        <div style={{ marginBottom: '18px' }}>
          <SectionLabel>Days to Expiration (DTE)</SectionLabel>
          <div style={{ display: 'flex', gap: '10px' }}>
            <input
              type="number" min={0} max={1095}
              value={draft.minDTE ?? ''}
              placeholder="Min"
              onChange={e => setDraft(d => ({ ...d, minDTE: e.target.value === '' ? null : Number(e.target.value) }))}
              style={{ flex: 1, padding: '7px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontSize: '13px' }}
            />
            <input
              type="number" min={0} max={1095}
              value={draft.maxDTE ?? ''}
              placeholder="Max"
              onChange={e => setDraft(d => ({ ...d, maxDTE: e.target.value === '' ? null : Number(e.target.value) }))}
              style={{ flex: 1, padding: '7px 10px', background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#e0e0e0', fontSize: '13px' }}
            />
          </div>
        </div>

        <div style={{ display: 'flex', gap: '8px', justifyContent: 'flex-end', paddingTop: '12px', borderTop: '1px solid #1a3a4a' }}>
          <button
            onClick={reset}
            style={{ padding: '7px 14px', background: 'transparent', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#90a4ae', fontSize: '12px', cursor: 'pointer' }}
          >Reset</button>
          <button
            onClick={discard}
            style={{ padding: '7px 14px', background: 'transparent', border: '1px solid #1a3a4a', borderRadius: '4px', color: '#90a4ae', fontSize: '12px', cursor: 'pointer' }}
          >Discard</button>
          <button
            onClick={apply}
            style={{ padding: '7px 18px', background: '#66bb6a', border: '1px solid #66bb6a', borderRadius: '4px', color: '#0a1a0f', fontSize: '12px', fontWeight: 600, cursor: 'pointer' }}
          >Apply</button>
        </div>
      </div>
    </div>
  );
};

/**
 * Predicate: does this alert/flow pass the filters?
 * Works for both AlertEntry and FlowEntry — they share enough fields.
 */
export function matchesFilters(item: any, f: FilterState): boolean {
  // === Type filter (Call/Put) ===
  // Normalize OptionType. Data has 'CALL' or 'PUT' (uppercase) on alerts.
  const ot = String(item.OptionType || '').toUpperCase();
  const isCall = ot === 'CALL' || ot === 'C';
  const isPut = ot === 'PUT' || ot === 'P';
  if (isCall && !f.types.call) return false;
  if (isPut && !f.types.put) return false;
  // If neither matched (no OptionType present), and user has only one selected, hide.
  if (!isCall && !isPut) {
    if (!f.types.call && !f.types.put) return false;
  }

  // === Execution Side (flow tape has BidAskType, alerts don't) ===
  const bat = String(item.BidAskType || '').toUpperCase();
  if (bat) {
    const isAsk = bat === 'A' || bat === 'ASK';
    const isBid = bat === 'B' || bat === 'BID';
    const isOther = !isAsk && !isBid;
    if (isAsk && !f.sides.ask) return false;
    if (isBid && !f.sides.bid) return false;
    if (isOther && !f.sides.other) return false;
  }
  // If item has no BidAskType (alerts), don't filter on this axis

  // === Flow Kind (Sweep/Block) ===
  const bt = String(item.BlockType || '').toUpperCase();
  if (bt === 'SWEEP' && !f.flowKinds.sweep) return false;
  if (bt === 'BLOCK' && !f.flowKinds.block) return false;
  // For alerts (no BlockType), use SWEEPS/BLOCKS counts as proxy
  if (!bt && (typeof item.SWEEPS === 'number' || typeof item.BLOCKS === 'number')) {
    const hasSweeps = (item.SWEEPS || 0) > 0;
    const hasBlocks = (item.BLOCKS || 0) > 0;
    // If only sweeps filter is off and alert is sweep-only, hide
    if (hasSweeps && !hasBlocks && !f.flowKinds.sweep) return false;
    if (hasBlocks && !hasSweeps && !f.flowKinds.block) return false;
    // If both types disabled, always hide
    if (!f.flowKinds.sweep && !f.flowKinds.block) return false;
  }

  // === Instrument (UnderlyingType: mixed case 'STOCK'/'stock'/'ETF') ===
  const ut = String(item.UnderlyingType || '').toUpperCase();
  if (ut === 'STOCK' && !f.instruments.stock) return false;
  if (ut === 'ETF' && !f.instruments.etf) return false;

  // === Min Premium ===
  const premium = Number(item.totalFlowValue ?? item.Value ?? 0);
  if (f.minPremium > 0 && premium < f.minPremium) return false;

  // === DTE range ===
  const dte = Number(item.DTE ?? 0);
  if (f.minDTE != null && dte < f.minDTE) return false;
  if (f.maxDTE != null && dte > f.maxDTE) return false;

  return true;
}
