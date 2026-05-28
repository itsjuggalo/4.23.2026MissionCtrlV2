'use client';

import { useEffect, useState, useCallback } from 'react';
import { RefreshCw, CheckCircle2, XCircle, Download } from 'lucide-react';
import { safeFixed } from '@/lib/fmt';
import { MetricCard } from '@/components/ui/MetricCard';
import { Badge } from '@/components/ui/Badge';
import { PulseDot } from '@/components/ui/PulseDot';
import { RadialGauge } from '@/components/ui/RadialGauge';
import { Sparkline } from '@/components/ui/Sparkline';
import { SignalChart } from '@/components/ui/SignalChart';
import { GlassPanel } from '@/components/ui/GlassPanel';
import { SectionHeader } from '@/components/ui/SectionHeader';

interface AccountInfo {
  status?: string;
  equity?: string;
  cash?: string;
  buying_power?: string;
  crypto_status?: string;
}
interface Position {
  symbol: string;
  qty: string;
  avg_entry_price: string;
  market_value: string;
  unrealized_pl: string;
}
interface OpenOrder {
  id: string;
  symbol: string;
  side: string;
  type: string;
  qty: string;
  status: string;
  limit_price?: string | null;
  stop_price?: string | null;
}
interface AccountData {
  account: string;
  account_info: AccountInfo;
  positions: Position[];
  open_orders: OpenOrder[];
}
interface Signal {
  id: number; received_at: string; bar_time: string; strategy: string;
  account: string; symbol: string; action: string;
  alert_price: number; stop_price: number; tp2_price: number;
  decision: string; suppression_reason: string | null; rejection_reason: string | null;
  dedupe_key: string;
}
interface WebhookLog {
  id: number; received_at: string; account: string; symbol: string;
  action: string; outcome: string; http_status: number;
  alpaca_order_id: string | null; duration_ms: number | null;
}
interface BotPairState {
  bar_time: string;
  close: number;
  ema20: number;
  rsi_prev: number;
  rsi_now: number;
  atr: number;
  daily_close: number;
  daily_ema50: number;
  htf_bullish: boolean;
  pullback_hit: boolean;
  rsi_cross: boolean;
  would_fire: boolean;
}
interface BotStatus {
  last_poll: string;
  age_seconds?: number;
  stale?: boolean;
  pairs: Record<string, BotPairState>;
  config?: Record<string, unknown>;
  last_fired?: Record<string, string>;
  error?: string;
}
interface PricePoint { t: number; close: number; }
interface SignalMarker { t: number; side: 'buy' | 'sell'; price: number; }
interface ApiResp {
  config: { enabled: boolean; accounts: string[]; webhook_url: string; strategy: string };
  baseline: { win_rate: number; avg_profit_pct: number; sharpe: number; drawdown_pct: number };
  signal_counts: Record<string, number>;
  signal_total: number;
  fill_rate: number;
  frequency_ratio: number;
  drift_score: number;
  signals: Signal[];
  webhook_log: WebhookLog[];
  accounts_data: AccountData[];
  bot_status: BotStatus | null;
  // Phase 3 additive fields — access defensively
  signal_timeseries?: { t: number; n_submitted: number; n_suppressed: number; n_rejected: number }[];
  fill_rate_timeseries?: { t: number; fill_rate: number }[];
  drift_timeseries?: { t: number; drift_score: number }[];
  price_history?: Record<string, PricePoint[]>;
  signal_markers?: Record<string, SignalMarker[]>;
  price_source?: Record<string, string>;
}

type SeverityLabel = 'green' | 'amber' | 'red';

function calcSeverity(v: number, warn: number, critical: number, kill: number, lowerWorse = true): SeverityLabel {
  if (lowerWorse) {
    if (v < kill) return 'red';
    if (v < critical) return 'red';
    if (v < warn) return 'amber';
  } else {
    if (v > kill) return 'red';
    if (v > critical) return 'red';
    if (v > warn) return 'amber';
  }
  return 'green';
}

function decisionSeverity(d: string): 'green' | 'amber' | 'red' | 'cyan' | 'neutral' {
  const map: Record<string, 'green' | 'amber' | 'red' | 'cyan' | 'neutral'> = {
    submitted: 'green',
    dry_run: 'cyan',
    suppressed: 'amber',
    rejected: 'red',
    duplicate: 'neutral',
  };
  return map[d] ?? 'neutral';
}

function outcomeSeverity(o: string): 'green' | 'amber' | 'red' | 'cyan' | 'neutral' {
  if (o?.toLowerCase().includes('ok') || o?.toLowerCase().includes('success')) return 'green';
  if (o?.toLowerCase().includes('fail') || o?.toLowerCase().includes('error')) return 'red';
  return 'neutral';
}

export function LiveStrategyPage() {
  const [data, setData] = useState<ApiResp | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [backfilling, setBackfilling] = useState(false);

  const load = useCallback(async () => {
    setLoading(true);
    try {
      const r = await fetch('/api/live-strategy', { cache: 'no-store' });
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      setData(await r.json());
      setError(false);
    } catch (e) { console.error(e); setError(true); }
    finally { setLoading(false); }
  }, []);

  useEffect(() => { load(); const t = setInterval(load, 15000); return () => clearInterval(t); }, [load]);

  async function handleBackfill() {
    if (!data?.bot_status?.pairs) return;
    const pairs = Object.keys(data.bot_status.pairs);
    if (!pairs.length) return;
    setBackfilling(true);
    try {
      await fetch('/api/freqtrade', {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
          action: 'run',
          subcommand: 'download-data',
          idempotency_key: crypto.randomUUID(),
          args: ['--pairs', ...pairs, '--timeframes', '1h', '--timerange', '20240101-'],
        }),
      });
    } catch (e) { console.error('backfill failed', e); }
    finally { setBackfilling(false); }
  }

  if (!data) {
    return (
      <div style={{ padding: 20, color: 'var(--color-mc-text)' }}>Loading…</div>
    );
  }

  if (!data.config || !data.accounts_data || !data.signals || !data.webhook_log) {
    return (
      <div style={{ padding: 20, color: 'var(--color-mc-red)', fontFamily: 'var(--font-mc-mono)', fontSize: 13 }}>
        API returned incomplete data — retrying in 15s…
      </div>
    );
  }

  const frSeverity = calcSeverity(data.fill_rate, 0.95, 0.85, 0.50, true);
  const dsSeverity = calcSeverity(data.drift_score, 5, 7, 9, false);
  // Drift gauge: invert so higher drift_score = worse (red). We show 10-drift_score as "remaining headroom".
  const driftGaugeSeverity = dsSeverity === 'green' ? 'green' : dsSeverity === 'amber' ? 'amber' : 'red';

  const signalSparkline = (data.signal_timeseries ?? []).map(p => p.n_submitted);
  const fillSparkline = (data.fill_rate_timeseries ?? []).map(p => p.fill_rate * 100);
  const driftSparkline = (data.drift_timeseries ?? []).map(p => p.drift_score);

  return (
    <div style={{ padding: 20, color: 'var(--color-mc-text)', fontFamily: 'var(--font-mc-sans)', maxWidth: 1500, margin: '0 auto' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'flex-start', justifyContent: 'space-between', marginBottom: 18, flexWrap: 'wrap', gap: 12 }}>
        <div style={{ flex: 1, minWidth: 0 }}>
          <h1 style={{ fontSize: 22, fontWeight: 700, color: 'var(--color-mc-text)', margin: 0, marginBottom: 8 }}>
            Live Strategy — {data.config?.strategy ?? '—'}
          </h1>
          {/* Webhook status pill with PulseDot */}
          <div style={{ display: 'flex', alignItems: 'center', gap: 10, flexWrap: 'wrap', marginBottom: 6 }}>
            <div style={{
              display: 'inline-flex', alignItems: 'center', gap: 8,
              padding: '4px 12px', borderRadius: 999,
              background: data.config.enabled
                ? 'color-mix(in srgb, var(--color-mc-green) 15%, transparent)'
                : 'color-mix(in srgb, var(--color-mc-amber) 15%, transparent)',
              border: `1px solid ${data.config.enabled ? 'var(--color-mc-green)' : 'var(--color-mc-amber)'}`,
              color: data.config.enabled ? 'var(--color-mc-green)' : 'var(--color-mc-amber)',
              fontSize: 12, fontWeight: 600,
            }}>
              <PulseDot status={data.config.enabled ? 'active' : 'idle'} pulse={data.config.enabled} />
              WEBHOOK {data.config.enabled ? 'LIVE — TRADES WILL EXECUTE' : 'OFF — fail-closed kill-switch'}
            </div>
            <div style={{ fontSize: 11, color: 'var(--color-mc-text-dim)' }}>
              accounts: {(data.config?.accounts ?? []).join(', ')}
            </div>
          </div>
          <div style={{ fontSize: 11, color: 'var(--color-mc-text-dim)', wordBreak: 'break-all' }}>
            URL: <code style={{ color: 'var(--color-mc-accent)' }}>{data.config.webhook_url}</code>
          </div>
        </div>
        <button onClick={load} disabled={loading}
          style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, border: '1px solid var(--color-mc-border)', cursor: 'pointer', flexShrink: 0 }}>
          <RefreshCw size={14} className={loading ? 'animate-spin' : ''} /> Refresh
        </button>
      </div>

      {/* KPI MetricCards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: 12, marginBottom: 18 }}>
        <MetricCard
          label="Total signals (30d)"
          value={String(data.signal_total ?? 0)}
          subtitle={Object.entries(data.signal_counts ?? {}).map(([k, v]) => `${k}: ${v}`).join(' · ')}
          severity="cyan"
          sparklineData={signalSparkline}
        />
        <MetricCard
          label="Fill rate"
          value={`${safeFixed((data.fill_rate ?? 0) * 100, 1)}%`}
          severity={frSeverity}
          sparklineData={fillSparkline}
        />
        <MetricCard
          label="Frequency ratio"
          value={`${safeFixed(data.frequency_ratio, 2)}×`}
          subtitle={`vs ${data.baseline?.sharpe ?? '—'}-Sharpe baseline`}
          severity="neutral"
        />
        {/* Drift card: RadialGauge + sparkline */}
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div className="uppercase tracking-widest mb-2 text-mc-text-muted" style={{ fontSize: '11px', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>
            Drift Score
          </div>
          <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
            <RadialGauge value={data.drift_score} max={10} severity={driftGaugeSeverity} />
            <div style={{ flex: 1 }}>
              {driftSparkline.length > 0 && <Sparkline data={driftSparkline} height={32} color={driftGaugeSeverity === 'red' ? 'var(--color-mc-red)' : driftGaugeSeverity === 'amber' ? 'var(--color-mc-amber)' : 'var(--color-mc-green)'} />}
            </div>
          </div>
        </div>
      </div>

      {/* Account panels in GlassPanel */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(380px, 1fr))', gap: 12, marginBottom: 18 }}>
        {data.accounts_data.map(a => {
          const ai = a.account_info;
          const ok = ai?.status === 'ACTIVE';
          return (
            <GlassPanel key={a.account}>
              <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 10 }}>
                <div style={{ fontSize: 14, fontWeight: 600, color: 'var(--color-mc-text)', textTransform: 'capitalize' }}>{a.account}</div>
                <div style={{ display: 'flex', alignItems: 'center', gap: 6, fontSize: 11, color: ok ? 'var(--color-mc-green)' : 'var(--color-mc-red)' }}>
                  {ok ? <CheckCircle2 size={12} /> : <XCircle size={12} />} {ai?.status ?? 'no creds'}
                </div>
              </div>
              {ai?.equity && (
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 8, marginBottom: 10 }}>
                  <MetricBox label="equity" value={`$${Number(ai.equity).toFixed(0)}`} />
                  <MetricBox label="cash" value={`$${Number(ai.cash || 0).toFixed(0)}`} />
                  <MetricBox label="bp" value={`$${Number(ai.buying_power || 0).toFixed(0)}`} />
                </div>
              )}
              {Array.isArray(a.positions) && a.positions.length > 0 && (
                <details open style={{ marginBottom: 8 }}>
                  <summary style={{ fontSize: 11, color: 'var(--color-mc-accent)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>POSITIONS ({a.positions.length})</summary>
                  <table style={{ width: '100%', fontSize: 11, fontFamily: 'var(--font-mc-mono)' }}>
                    <tbody>
                      {a.positions.map(p => (
                        <tr key={p.symbol} style={{ borderTop: '1px solid var(--color-mc-border)' }}>
                          <td style={{ padding: '3px 6px', color: 'var(--color-mc-text)' }}>{p.symbol}</td>
                          <td style={{ padding: '3px 6px', color: 'var(--color-mc-text-muted)' }}>{p.qty}</td>
                          <td style={{ padding: '3px 6px', color: 'var(--color-mc-text-muted)' }}>${Number(p.market_value).toFixed(2)}</td>
                          <td style={{ padding: '3px 6px', color: Number(p.unrealized_pl) >= 0 ? 'var(--color-mc-green)' : 'var(--color-mc-red)' }}>
                            {Number(p.unrealized_pl) >= 0 ? '+' : ''}${Number(p.unrealized_pl).toFixed(2)}
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </details>
              )}
              {Array.isArray(a.open_orders) && a.open_orders.length > 0 && (
                <details>
                  <summary style={{ fontSize: 11, color: 'var(--color-mc-accent)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>OPEN ORDERS ({a.open_orders.length})</summary>
                  <table style={{ width: '100%', fontSize: 11, fontFamily: 'var(--font-mc-mono)' }}>
                    <tbody>
                      {a.open_orders.slice(0, 10).map(o => (
                        <tr key={o.id} style={{ borderTop: '1px solid var(--color-mc-border)' }}>
                          <td style={{ padding: '3px 6px' }}>{o.symbol}</td>
                          <td style={{ padding: '3px 6px', color: o.side === 'buy' ? 'var(--color-mc-green)' : 'var(--color-mc-red)' }}>{o.side}</td>
                          <td style={{ padding: '3px 6px' }}>{o.type}</td>
                          <td style={{ padding: '3px 6px' }}>{o.qty}</td>
                          <td style={{ padding: '3px 6px', color: 'var(--color-mc-text-muted)' }}>{o.limit_price || o.stop_price || ''}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </details>
              )}
            </GlassPanel>
          );
        })}
      </div>

      {/* Alpaca-native bot status panel */}
      {data.bot_status && (
        <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 12 }}>
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 10 }}>
            <div style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, letterSpacing: 1, fontFamily: 'var(--font-mc-mono)' }}>
              ALPACA-NATIVE BOT (PullbackTrend_1h_alpaca)
            </div>
            <div style={{ fontSize: 11, color: data.bot_status.stale ? 'var(--color-mc-red)' : 'var(--color-mc-green)', fontFamily: 'var(--font-mc-mono)' }}>
              {data.bot_status.stale ? '⚠ STALE' : '● live'} · last poll {data.bot_status.age_seconds ?? '?'}s ago
              <span style={{ color: 'var(--color-mc-text-dim)' }}> ({fmtDateTime(data.bot_status.last_poll)})</span>
            </div>
          </div>
          {data.bot_status.error && (
            <div style={{ color: 'var(--color-mc-red)', fontSize: 11, fontFamily: 'var(--font-mc-mono)', marginBottom: 8 }}>
              error: {data.bot_status.error}
            </div>
          )}
          <table style={{ width: '100%', fontSize: 11, fontFamily: 'var(--font-mc-mono)' }}>
            <thead>
              <tr style={{ color: 'var(--color-mc-text-dim)', textAlign: 'left' }}>
                {['symbol','bar','close','ema20','rsi','atr','htf↑','pullback','rsi×50','fires?'].map(h =>
                  <th key={h} style={{ padding: '4px 6px', fontWeight: 500 }}>{h}</th>
                )}
              </tr>
            </thead>
            <tbody>
              {Object.entries(data.bot_status.pairs ?? {}).map(([sym, p]) => (
                <tr key={sym} style={{ borderTop: '1px solid var(--color-mc-border)' }}>
                  <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>{sym}</td>
                  <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{p.bar_time.slice(11, 16)}Z</td>
                  <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>${safeFixed(p.close, 2)}</td>
                  <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>${safeFixed(p.ema20, 2)}</td>
                  <td style={{ padding: '4px 6px', color: p.rsi_now > 70 ? 'var(--color-mc-red)' : p.rsi_now < 30 ? 'var(--color-mc-green)' : 'var(--color-mc-text)' }}>
                    {safeFixed(p.rsi_prev, 1)}→{safeFixed(p.rsi_now, 1)}
                  </td>
                  <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{safeFixed(p.atr, 2)}</td>
                  <td style={{ padding: '4px 6px', color: p.htf_bullish ? 'var(--color-mc-green)' : 'var(--color-mc-red)' }}>{p.htf_bullish ? '✓' : '✗'}</td>
                  <td style={{ padding: '4px 6px', color: p.pullback_hit ? 'var(--color-mc-green)' : 'var(--color-mc-text-dim)' }}>{p.pullback_hit ? '✓' : '·'}</td>
                  <td style={{ padding: '4px 6px', color: p.rsi_cross ? 'var(--color-mc-green)' : 'var(--color-mc-text-dim)' }}>{p.rsi_cross ? '✓' : '·'}</td>
                  <td style={{ padding: '4px 6px', color: p.would_fire ? 'var(--color-mc-green)' : 'var(--color-mc-text-dim)', fontWeight: p.would_fire ? 700 : 400 }}>{p.would_fire ? 'YES' : 'no'}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <div style={{ marginTop: 8, fontSize: 10, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>
            Native Alpaca crypto data feed · polls every 60s · headless (no TradingView required)
          </div>
        </div>
      )}

      {/* Per-pair SignalChart section */}
      {data.bot_status && Object.keys(data.bot_status.pairs ?? {}).length > 0 && (
        <div style={{ marginBottom: 18 }}>
          <div style={{ marginBottom: 12 }}>
            <SectionHeader title="Per-Pair Price + Signal Charts" />
          </div>
          {Object.keys(data.bot_status.pairs ?? {}).map(pair => {
            const priceSeries = (data.price_history ?? {})[pair] ?? [];
            const signals = (data.signal_markers ?? {})[pair] ?? [];
            const priceSource = (data.price_source ?? {})[pair];
            const unavailable = priceSource === 'unavailable' || (!priceSeries.length && priceSource !== 'unavailable');

            return (
              <div key={pair} style={{ marginBottom: 16 }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
                  <Badge severity="cyan">{pair}</Badge>
                  {priceSource && priceSource !== 'unavailable' && <Badge severity="neutral">{priceSource}</Badge>}
                </div>
                {unavailable ? (
                  <div style={{
                    display: 'flex', alignItems: 'center', justifyContent: 'space-between', flexWrap: 'wrap', gap: 12,
                    padding: '14px 16px', background: 'var(--color-mc-bg-surface)', border: '1px solid var(--color-mc-border)',
                    borderRadius: 6, fontSize: 12, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)',
                  }}>
                    <span>price data unavailable — run <code style={{ color: 'var(--color-mc-accent)' }}>freqtrade download-data</code> to backfill</span>
                    <button
                      onClick={handleBackfill}
                      disabled={backfilling}
                      style={{
                        display: 'flex', alignItems: 'center', gap: 6,
                        padding: '5px 12px', borderRadius: 5,
                        background: 'color-mix(in srgb, var(--color-mc-accent) 15%, transparent)',
                        border: '1px solid var(--color-mc-accent)',
                        color: 'var(--color-mc-accent)',
                        fontSize: 11, cursor: backfilling ? 'wait' : 'pointer', fontFamily: 'var(--font-mc-mono)',
                      }}
                    >
                      <Download size={12} /> {backfilling ? 'Backfilling…' : 'Backfill prices'}
                    </button>
                  </div>
                ) : (
                  <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 12 }}>
                    <SignalChart priceSeries={priceSeries} signals={signals} height={220} />
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}

      {/* Recent signals */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 12 }}>
        <div style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 1, fontFamily: 'var(--font-mc-mono)' }}>
          RECENT SIGNALS (latest 50)
        </div>
        {data.signals.length === 0 ? (
          <div style={{ fontSize: 12, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>no rows</div>
        ) : (
          <div style={{ overflowX: 'auto' }}>
            <table style={{ width: '100%', fontSize: 11, fontFamily: 'var(--font-mc-mono)' }}>
              <thead>
                <tr style={{ color: 'var(--color-mc-text-dim)', textAlign: 'left' }}>
                  {['received','bar_time','acct','symbol','side','price','SL','TP','decision','reason'].map(h =>
                    <th key={h} style={{ padding: '4px 6px', fontWeight: 500 }}>{h}</th>
                  )}
                </tr>
              </thead>
              <tbody>
                {data.signals.map((s, i) => (
                  <tr key={s.id} style={{ borderTop: '1px solid var(--color-mc-border)', animation: i === 0 ? 'mcPulse 1.5s ease-in-out 1' : 'none' }}>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{fmtDateTime(s.received_at)}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{fmtDateTime(s.bar_time)}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>{s.account}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>{s.symbol}</td>
                    <td style={{ padding: '4px 6px', color: s.action === 'buy' ? 'var(--color-mc-green)' : 'var(--color-mc-red)' }}>{s.action}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>${Number(s.alert_price).toFixed(0)}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>${Number(s.stop_price).toFixed(0)}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>${Number(s.tp2_price).toFixed(0)}</td>
                    <td style={{ padding: '4px 6px' }}><Badge severity={decisionSeverity(s.decision)}>{s.decision}</Badge></td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-dim)' }}>{s.suppression_reason || s.rejection_reason || ''}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>

      {/* Recent webhook log */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 12 }}>
        <div style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 1, fontFamily: 'var(--font-mc-mono)' }}>
          RECENT WEBHOOK LOG (latest 20)
        </div>
        {data.webhook_log.length === 0 ? (
          <div style={{ fontSize: 12, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>no rows</div>
        ) : (
          <div style={{ overflowX: 'auto' }}>
            <table style={{ width: '100%', fontSize: 11, fontFamily: 'var(--font-mc-mono)' }}>
              <thead>
                <tr style={{ color: 'var(--color-mc-text-dim)', textAlign: 'left' }}>
                  {['received','acct','symbol','side','outcome','status','order_id','ms'].map(h =>
                    <th key={h} style={{ padding: '4px 6px', fontWeight: 500 }}>{h}</th>
                  )}
                </tr>
              </thead>
              <tbody>
                {data.webhook_log.map((w, i) => (
                  <tr key={w.id} style={{ borderTop: '1px solid var(--color-mc-border)', animation: i === 0 ? 'mcPulse 1.5s ease-in-out 1' : 'none' }}>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{fmtDateTime(w.received_at)}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>{w.account || '—'}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text)' }}>{w.symbol || '—'}</td>
                    <td style={{ padding: '4px 6px', color: w.action === 'buy' ? 'var(--color-mc-green)' : w.action === 'sell' ? 'var(--color-mc-red)' : 'var(--color-mc-text)' }}>{w.action || '—'}</td>
                    <td style={{ padding: '4px 6px' }}><Badge severity={outcomeSeverity(w.outcome)}>{w.outcome}</Badge></td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{w.http_status}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-dim)' }}>{w.alpaca_order_id ? w.alpaca_order_id.slice(0, 8) + '…' : '—'}</td>
                    <td style={{ padding: '4px 6px', color: 'var(--color-mc-text-muted)' }}>{w.duration_ms ?? '—'}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}

function fmtDateTime(iso: string): string {
  if (!iso) return '—';
  try {
    const d = new Date(iso);
    if (isNaN(d.getTime())) return iso;
    const yyyy = d.getFullYear();
    const mm = String(d.getMonth() + 1).padStart(2, '0');
    const dd = String(d.getDate()).padStart(2, '0');
    const hh = String(d.getHours()).padStart(2, '0');
    const mi = String(d.getMinutes()).padStart(2, '0');
    const ss = String(d.getSeconds()).padStart(2, '0');
    return `${yyyy}-${mm}-${dd} ${hh}:${mi}:${ss}`;
  } catch { return iso; }
}

function MetricBox({ label, value }: { label: string; value: string }) {
  return (
    <div>
      <div style={{ fontSize: 9, color: 'var(--color-mc-text-dim)', textTransform: 'uppercase', fontFamily: 'var(--font-mc-mono)' }}>{label}</div>
      <div style={{ fontSize: 14, color: 'var(--color-mc-text)', fontFamily: 'var(--font-mc-mono)' }}>{value}</div>
    </div>
  );
}

export default LiveStrategyPage;
