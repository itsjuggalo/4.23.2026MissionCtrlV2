'use client';

import { useCallback, useEffect, useState } from 'react';
import { RefreshCw, Repeat, Moon, ShieldAlert, Workflow, type LucideIcon } from 'lucide-react';
import { COLORS, FONTS } from '@/lib/constants';

// ─── Types matching /api/loops ──────────────────────────────────────────────
type Health = 'ok' | 'warn' | 'down';

interface Loop {
  name: string;
  lastRun: string | null;
  health: Health;
  summary: string;
  detail: Record<string, unknown>;
}

interface LoopsResponse {
  loops: Loop[];
  generatedAt: string;
}

const HEALTH_COLOR: Record<Health, string> = {
  ok: COLORS.green,
  warn: COLORS.amber,
  down: COLORS.red,
};

const HEALTH_LABEL: Record<Health, string> = {
  ok: 'OK',
  warn: 'WARN',
  down: 'DOWN',
};

const LOOP_ICON: Record<string, LucideIcon> = {
  'Night Shift': Moon,
  'Background Watchdog': ShieldAlert,
  'Desk Pipeline': Workflow,
};

// ─── Helpers ────────────────────────────────────────────────────────────────
function timeAgo(iso: string | null): string {
  if (!iso) return '—';
  // Bare local 'YYYY-MM-DD HH:MM:SS' is recorded UTC by the loop daemons.
  const normalized = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/.test(iso)
    ? iso.replace(' ', 'T') + 'Z'
    : iso;
  const ms = Date.now() - new Date(normalized).getTime();
  if (Number.isNaN(ms)) return '—';
  if (ms < 0) return 'now';
  const m = Math.floor(ms / 60000);
  if (m < 1) return `${Math.floor(ms / 1000)}s ago`;
  if (m < 60) return `${m}m ago`;
  const h = Math.floor(m / 60);
  if (h < 24) return `${h}h ago`;
  return `${Math.floor(h / 24)}d ago`;
}

function num(v: unknown): number {
  return typeof v === 'number' ? v : Number(v) || 0;
}

// ─── Small presentational pieces ──────────────────────────────────────────────
function Metric({ label, value, color }: { label: string; value: string | number; color?: string }) {
  return (
    <div style={{ minWidth: 70 }}>
      <div style={{ fontSize: 18, fontWeight: 600, color: color ?? COLORS.text, fontFamily: FONTS.mono }}>
        {value}
      </div>
      <div style={{ fontSize: 10, color: COLORS.textDim, fontFamily: FONTS.mono, letterSpacing: 0.5, textTransform: 'uppercase' }}>
        {label}
      </div>
    </div>
  );
}

// ─── Per-loop card ─────────────────────────────────────────────────────────
function LoopCard({ loop }: { loop: Loop }) {
  const dot = HEALTH_COLOR[loop.health];
  const Icon = LOOP_ICON[loop.name] ?? Repeat;
  const detail = loop.detail ?? {};

  // Surface a few key metrics per loop without overfitting the layout.
  const metrics: { label: string; value: string | number; color?: string }[] = [];
  if (loop.name === 'Night Shift') {
    const queued = num(detail.queuedImprovements);
    const heal = (detail.heal24h ?? {}) as Record<string, unknown>;
    metrics.push({ label: 'Queued', value: queued, color: queued > 0 ? COLORS.accent : COLORS.textDim });
    metrics.push({ label: 'Restarts 24h', value: num(heal.restarts) });
    metrics.push({ label: 'Failed 24h', value: num(heal.restartFailed), color: num(heal.restartFailed) > 0 ? COLORS.red : undefined });
    metrics.push({ label: 'Flapping', value: num(heal.flapping), color: num(heal.flapping) > 0 ? COLORS.amber : undefined });
  } else if (loop.name === 'Background Watchdog') {
    metrics.push({ label: 'Running', value: num(detail.running), color: COLORS.accent });
    metrics.push({ label: 'Complete', value: num(detail.complete) });
    metrics.push({ label: 'Ghost', value: num(detail.ghost), color: num(detail.ghost) > 0 ? COLORS.red : undefined });
  } else if (loop.name === 'Desk Pipeline') {
    const byClass = (detail.latestPerClass ?? []) as Array<Record<string, unknown>>;
    metrics.push({ label: 'Asset Classes', value: byClass.length });
    metrics.push({ label: 'In Progress', value: num(detail.inProgressCount) });
    metrics.push({ label: 'Stalled >2h', value: num(detail.stalled), color: num(detail.stalled) > 0 ? COLORS.amber : undefined });
  }

  // Night Shift target rotation rows.
  const targets = (detail.targets ?? []) as Array<Record<string, unknown>>;
  // Desk per-asset-class rows.
  const byClass = (detail.latestPerClass ?? []) as Array<Record<string, unknown>>;

  return (
    <div
      style={{
        background: COLORS.bgCard,
        border: `1px solid ${COLORS.border}`,
        borderRadius: 8,
        padding: 16,
        display: 'flex',
        flexDirection: 'column',
        gap: 12,
      }}
    >
      {/* Header row */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
        <Icon size={16} color={COLORS.accent} />
        <span style={{ fontSize: 14, fontWeight: 600, color: COLORS.text }}>{loop.name}</span>
        <span
          title={`Health: ${HEALTH_LABEL[loop.health]}`}
          style={{
            display: 'inline-flex',
            alignItems: 'center',
            gap: 6,
            marginLeft: 'auto',
            fontSize: 10,
            fontFamily: FONTS.mono,
            letterSpacing: 1,
            color: dot,
          }}
        >
          <span
            style={{
              width: 9,
              height: 9,
              borderRadius: '50%',
              background: dot,
              boxShadow: `0 0 6px ${dot}99`,
              display: 'inline-block',
            }}
          />
          {HEALTH_LABEL[loop.health]}
        </span>
      </div>

      {/* Summary + last run */}
      <div style={{ display: 'flex', alignItems: 'baseline', justifyContent: 'space-between', gap: 8 }}>
        <span style={{ fontSize: 12, color: COLORS.textMuted, fontFamily: FONTS.mono }}>{loop.summary}</span>
        <span style={{ fontSize: 11, color: COLORS.textDim, fontFamily: FONTS.mono, whiteSpace: 'nowrap' }}>
          last run {timeAgo(loop.lastRun)}
        </span>
      </div>

      {/* Metrics */}
      <div style={{ display: 'flex', gap: 18, flexWrap: 'wrap' }}>
        {metrics.map((m) => (
          <Metric key={m.label} label={m.label} value={m.value} color={m.color} />
        ))}
      </div>

      {/* Night Shift target rotation */}
      {targets.length > 0 && (
        <div style={{ borderTop: `1px solid ${COLORS.borderLight}`, paddingTop: 10 }}>
          <div style={{ fontSize: 10, color: COLORS.textDim, fontFamily: FONTS.mono, letterSpacing: 1, marginBottom: 6 }}>
            TARGETS
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
            {targets.map((t) => {
              const dryStreak = num(t.dryStreak);
              const dryCap = num(t.dryCap);
              const enabled = t.enabled === true;
              const dry = dryStreak >= dryCap;
              return (
                <div
                  key={String(t.name)}
                  style={{ display: 'flex', alignItems: 'center', gap: 8, fontSize: 11, fontFamily: FONTS.mono }}
                >
                  <span style={{ flex: 1, color: enabled ? COLORS.text : COLORS.textDim }}>
                    {String(t.name)}
                  </span>
                  <span style={{ color: dry ? COLORS.amber : COLORS.textMuted }}>
                    dry {dryStreak}/{dryCap}
                  </span>
                  <span style={{ width: 56, textAlign: 'right', color: COLORS.textDim }}>
                    {timeAgo((t.lastRunAt as string | null) ?? null)}
                  </span>
                </div>
              );
            })}
          </div>
        </div>
      )}

      {/* Desk per-asset-class latest cycle */}
      {byClass.length > 0 && (
        <div style={{ borderTop: `1px solid ${COLORS.borderLight}`, paddingTop: 10 }}>
          <div style={{ fontSize: 10, color: COLORS.textDim, fontFamily: FONTS.mono, letterSpacing: 1, marginBottom: 6 }}>
            LATEST CYCLE / ASSET CLASS
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
            {byClass.map((c) => {
              const status = String(c.status ?? '—');
              const ok = status === 'complete' || status.startsWith('complete') || status.startsWith('macro');
              return (
                <div
                  key={String(c.assetClass)}
                  style={{ display: 'flex', alignItems: 'center', gap: 8, fontSize: 11, fontFamily: FONTS.mono }}
                >
                  <span style={{ flex: 1, color: COLORS.text }}>{String(c.assetClass)}</span>
                  <span style={{ color: ok ? COLORS.green : COLORS.amber }}>{status}</span>
                  <span style={{ width: 56, textAlign: 'right', color: COLORS.textDim }}>
                    {timeAgo((c.startedAt as string | null) ?? null)}
                  </span>
                </div>
              );
            })}
          </div>
        </div>
      )}
    </div>
  );
}

// ─── Page component ────────────────────────────────────────────────────────
export function LoopsPage() {
  const [data, setData] = useState<LoopsResponse | null>(null);
  const [err, setErr] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch('/api/loops', { cache: 'no-store' });
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      const j = (await r.json()) as LoopsResponse;
      setData(j);
      setErr(null);
    } catch (e: unknown) {
      setErr(e instanceof Error ? e.message : String(e));
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchData();
    const t = setInterval(fetchData, 30_000);
    return () => clearInterval(t);
  }, [fetchData]);

  const loops = data?.loops ?? [];
  const queuedTotal = loops.reduce((acc, l) => {
    const d = l.detail ?? {};
    return acc + (l.name === 'Night Shift' ? num(d.queuedImprovements) : 0);
  }, 0);

  return (
    <div style={{ padding: 20, background: COLORS.bg, minHeight: '100%', color: COLORS.text }}>
      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 16 }}>
        <Repeat size={18} color={COLORS.accent} />
        <span style={{ fontSize: 16, fontWeight: 700, color: COLORS.text, letterSpacing: 1, fontFamily: FONTS.mono }}>
          AUTONOMOUS LOOPS
        </span>
        <span style={{ fontSize: 11, color: COLORS.textDim, fontFamily: FONTS.mono }}>
          read-only · refreshed every 30s
        </span>
        <div style={{ marginLeft: 'auto', display: 'flex', alignItems: 'center', gap: 12 }}>
          {queuedTotal > 0 && (
            <span style={{ fontSize: 11, color: COLORS.accent, fontFamily: FONTS.mono }}>
              {queuedTotal} improvement{queuedTotal === 1 ? '' : 's'} queued for review
            </span>
          )}
          {data && (
            <span style={{ fontSize: 11, color: COLORS.textDim, fontFamily: FONTS.mono }}>
              {timeAgo(data.generatedAt)}
            </span>
          )}
          <button
            onClick={fetchData}
            title="Refresh"
            style={{
              background: COLORS.border,
              border: 'none',
              borderRadius: 4,
              padding: '4px 8px',
              cursor: 'pointer',
              color: COLORS.text,
              display: 'flex',
              alignItems: 'center',
            }}
          >
            <RefreshCw size={13} />
          </button>
        </div>
      </div>

      {err && (
        <div
          style={{
            background: '#1a0000',
            border: `1px solid ${COLORS.red}44`,
            color: COLORS.red,
            padding: '10px 16px',
            borderRadius: 6,
            marginBottom: 12,
            fontSize: 13,
            fontFamily: FONTS.mono,
          }}
        >
          API unavailable — data may be stale ({err})
        </div>
      )}

      {loading && !data ? (
        <div style={{ color: COLORS.textMuted, fontFamily: FONTS.mono, fontSize: 13 }}>Loading loops…</div>
      ) : (
        <div
          style={{
            display: 'grid',
            gap: 14,
            gridTemplateColumns: 'repeat(auto-fill, minmax(320px, 1fr))',
          }}
        >
          {loops.map((loop) => (
            <LoopCard key={loop.name} loop={loop} />
          ))}
        </div>
      )}
    </div>
  );
}

export default LoopsPage;
