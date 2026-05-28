'use client';

import { useState, useEffect, useCallback } from 'react';
import { ProgressBar } from './ProgressBar';
import { COLORS, FONTS } from '@/lib/constants';

interface SignalEntry {
  score: number;
  error?: boolean | string;
  [key: string]: unknown;
}

interface BiasData {
  loading?: boolean;
  timestamp: string | null;
  score: number | null;
  max_score: number;
  bias: string | null;
  next_update: string | null;
  signals: {
    fear_greed?:      SignalEntry & { value?: string; index?: number };
    funding_rate?:    SignalEntry & { value?: string };
    moving_averages?: SignalEntry & { price?: number; sma20?: number; sma50?: number; sma200?: number; above_count?: number };
    structure_4h?:    SignalEntry & { trend?: string };
    btc_dominance?:   SignalEntry & { value?: string };
    volume_flow?:     SignalEntry & { vs_average?: string };
    dxy?:             SignalEntry & { value?: number; trend?: string };
  };
}

function biasColor(bias: string | null): string {
  if (!bias) return COLORS.textMuted;
  const b = bias.toUpperCase();
  if (b.includes('BULL')) return COLORS.green;
  if (b.includes('BEAR')) return COLORS.red;
  return COLORS.amber;
}

function scoreColor(score: number): string {
  if (score > 0) return COLORS.green;
  if (score < 0) return COLORS.red;
  return COLORS.textMuted;
}

function scoreBg(score: number): string {
  if (score > 0) return 'rgba(0,210,160,0.12)';
  if (score < 0) return 'rgba(255,71,87,0.12)';
  return 'rgba(139,139,158,0.08)';
}

function relTime(iso: string | null): string {
  if (!iso) return '—';
  const diff = Math.floor((Date.now() - new Date(iso).getTime()) / 1000);
  if (diff < 60)   return `${diff}s ago`;
  if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
  return `${Math.floor(diff / 3600)}h ago`;
}

function countdown(iso: string | null): string {
  if (!iso) return '—';
  const diff = Math.floor((new Date(iso).getTime() - Date.now()) / 1000);
  if (diff <= 0) return 'due now';
  const h = Math.floor(diff / 3600);
  const m = Math.floor((diff % 3600) / 60);
  return h > 0 ? `${h}h ${m}m` : `${m}m`;
}

const SIGNAL_META: Record<string, { label: string; getValue: (s: SignalEntry) => string }> = {
  fear_greed:      { label: 'Fear & Greed',      getValue: s => `${s['value'] as string ?? 'N/A'} (${s['index'] as number ?? '—'})` },
  funding_rate:    { label: 'Funding Rate',       getValue: s => (s['value'] as string) ?? 'N/A' },
  moving_averages: { label: 'Moving Averages',    getValue: s => {
    if (!s['price']) return 'N/A';
    return `$${Number(s['price']).toLocaleString()} | above ${(s['above_count'] as number) ?? 0}/3 SMAs`;
  }},
  structure_4h:    { label: '4H Structure',       getValue: s => (s['trend'] as string) ?? 'N/A' },
  btc_dominance:   { label: 'BTC Dominance',      getValue: s => (s['value'] as string) ?? 'N/A' },
  volume_flow:     { label: 'Volume vs 30d Avg',  getValue: s => (s['vs_average'] as string) ?? 'N/A' },
  dxy:             { label: 'DXY (USD Index)',     getValue: s => {
    return s['value'] != null ? `${s['value']} (${(s['trend'] as string) ?? '—'})` : 'N/A';
  }},
};

const SIGNAL_ORDER = [
  'fear_greed', 'funding_rate', 'moving_averages',
  'structure_4h', 'btc_dominance', 'volume_flow', 'dxy',
];

export function BTCBiasWidget() {
  const [data, setData] = useState<BiasData | null>(null);
  const [loading, setLoading] = useState(true);
  const [, setTick] = useState(0);

  const fetch_ = useCallback(async () => {
    try {
      const res = await fetch('/api/btc-bias');
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const d = await res.json();
      setData(d);
    } catch { /* silent */ }
    finally { setLoading(false); }
  }, []);

  useEffect(() => {
    fetch_();
    const interval = setInterval(fetch_, 5 * 60 * 1000);
    return () => clearInterval(interval);
  }, [fetch_]);

  // Tick every 30s to update countdowns
  useEffect(() => {
    const t = setInterval(() => setTick(n => n + 1), 30_000);
    return () => clearInterval(t);
  }, []);

  if (loading) {
    return (
      <div style={{
        background: COLORS.bgCard,
        border: `1px solid ${COLORS.border}`,
        borderRadius: 12,
        padding: 20,
      }}>
        <div style={{ fontSize: 12, fontFamily: FONTS.mono, color: COLORS.textMuted, marginBottom: 12 }}>
          BTC DIRECTIONAL BIAS
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
          {[1,2,3,4].map(i => (
            <div key={i} style={{
              height: 14, background: COLORS.bgSurface, borderRadius: 4,
              width: `${[70,50,90,60][i-1]}%`,
            }} />
          ))}
        </div>
      </div>
    );
  }

  if (!data || data.loading) {
    return (
      <div style={{
        background: COLORS.bgCard, border: `1px solid ${COLORS.border}`,
        borderRadius: 12, padding: 20,
      }}>
        <div style={{ fontSize: 12, fontFamily: FONTS.mono, color: COLORS.textMuted, marginBottom: 8 }}>
          BTC DIRECTIONAL BIAS
        </div>
        <div style={{ fontSize: 12, color: COLORS.textDim, fontFamily: FONTS.mono }}>
          Waiting for first scorer run…
        </div>
      </div>
    );
  }

  const score    = data.score ?? 0;
  const maxScore = data.max_score ?? 13;
  const bColor   = biasColor(data.bias);
  // Normalize score to 0–100 for progress bar: map [-13,+13] → [0,100]
  const barPct   = ((score + maxScore) / (maxScore * 2)) * 100;

  return (
    <div style={{
      background: COLORS.bgCard,
      border: `1px solid ${COLORS.border}`,
      borderRadius: 12,
      padding: 20,
      display: 'flex',
      flexDirection: 'column',
      gap: 16,
    }}>
      {/* Header row */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <span style={{
          fontSize: 11, fontFamily: FONTS.mono, fontWeight: 700,
          color: COLORS.textMuted, letterSpacing: '1px', textTransform: 'uppercase',
        }}>
          BTC Directional Bias
        </span>
        <span style={{ fontSize: 11, fontFamily: FONTS.mono, color: COLORS.textDim }}>
          {relTime(data.timestamp)}
        </span>
      </div>

      {/* Verdict */}
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 12 }}>
        <span style={{
          fontSize: 26, fontWeight: 800, fontFamily: FONTS.mono,
          color: bColor, letterSpacing: '1px',
        }}>
          {data.bias ?? '—'}
        </span>
        <span style={{
          fontSize: 13, fontFamily: FONTS.mono,
          color: scoreColor(score),
          fontWeight: 700,
        }}>
          {score > 0 ? '+' : ''}{score} / {maxScore}
        </span>
      </div>

      {/* Score bar */}
      <div>
        <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
          <span style={{ fontSize: 10, fontFamily: FONTS.mono, color: COLORS.red }}>BEARISH</span>
          <span style={{ fontSize: 10, fontFamily: FONTS.mono, color: COLORS.textDim }}>NEUTRAL</span>
          <span style={{ fontSize: 10, fontFamily: FONTS.mono, color: COLORS.green }}>BULLISH</span>
        </div>
        <ProgressBar value={barPct} max={100} color={bColor} height={6} />
      </div>

      {/* Signal rows */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: 6 }}>
        {SIGNAL_ORDER.map(key => {
          const sig = data.signals[key as keyof typeof data.signals];
          if (!sig) return null;
          const meta = SIGNAL_META[key];
          const displayVal = meta.getValue(sig);
          const sc = sig.score ?? 0;

          return (
            <div key={key} style={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'space-between',
              padding: '6px 10px',
              background: COLORS.bgSurface,
              borderRadius: 8,
              gap: 8,
            }}>
              <span style={{
                fontSize: 11, fontFamily: FONTS.sans,
                color: COLORS.textMuted,
                minWidth: 120,
                flexShrink: 0,
              }}>
                {meta.label}
              </span>
              <span style={{
                fontSize: 11, fontFamily: FONTS.mono,
                color: COLORS.text,
                flex: 1,
                overflow: 'hidden',
                textOverflow: 'ellipsis',
                whiteSpace: 'nowrap',
                textAlign: 'right',
              }}>
                {displayVal}
              </span>
              <span style={{
                fontSize: 11, fontFamily: FONTS.mono, fontWeight: 700,
                color: scoreColor(sc),
                background: scoreBg(sc),
                padding: '2px 7px',
                borderRadius: 5,
                minWidth: 32,
                textAlign: 'center',
                flexShrink: 0,
              }}>
                {sc > 0 ? '+' : ''}{sc}
              </span>
            </div>
          );
        })}
      </div>

      {/* Footer */}
      <div style={{
        display: 'flex', justifyContent: 'space-between',
        fontSize: 10, fontFamily: FONTS.mono, color: COLORS.textDim,
        borderTop: `1px solid ${COLORS.border}`, paddingTop: 10,
      }}>
        <span>Next update in {countdown(data.next_update)}</span>
        <span>Auto-refresh every 5 min</span>
      </div>
    </div>
  );
}
