'use client';

import { useEffect, useState, useCallback } from 'react';
import { ExternalLink, RefreshCw, Play, Copy, CheckCircle2, XCircle, Loader2, FolderOpen, Package } from 'lucide-react';
import { MetricCard } from '@/components/ui/MetricCard';
import { PulseDot } from '@/components/ui/PulseDot';
import { Badge } from '@/components/ui/Badge';
import { Heatmap } from '@/components/ui/Heatmap';
import { GlassPanel } from '@/components/ui/GlassPanel';
import { SectionHeader } from '@/components/ui/SectionHeader';
import { ComposedChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer, Cell } from 'recharts';

interface Status {
  repo: string;
  repo_exists: boolean;
  venv_exists: boolean;
  venv_python: string;
  commit: string | null;
  configs: string[];
  outputs: { name: string; size: number; modified: string }[];
  deps: Record<string, boolean>;
  scripts: string[];
  service_cmd: string;
  // Phase 3 additive
  runs?: RunRecord[];
  pipeline_health?: Record<string, { p50_ms?: number; last_ok_ts?: string; last_fail_ts?: string }>;
}

interface RunRecord {
  run_uuid: string;
  ts: number;
  script: string;
  status: string;
  exit_code?: number;
  elapsed_ms?: number;
}

interface RunResult {
  success: boolean;
  exit_code?: number;
  stdout?: string;
  stderr?: string;
  error?: string;
  elapsed_ms?: number;
  cmd?: string;
  args?: string[];
}

const SCRIPT_DESCS: Record<string, string> = {
  download: 'Fetch historical klines from Binance / Yahoo into inputs/',
  merge: 'Combine multi-source data into a unified table',
  features: 'Generate technical-indicator + custom features (TA-lib)',
  labels: 'Compute future-price-movement targets (highlow / topbot)',
  train: 'Train classification / regression models',
  predict: 'Apply trained models to data → predictions',
  predict_rolling: 'Walk-forward rolling prediction (slow)',
  signals: 'Aggregate predictions into buy/sell signals',
  simulate: 'Backtest signals → P&L curve',
  output: 'Notify / execute (Telegram, exchange) based on signals',
};

const PIPELINE_ORDER = ['download', 'merge', 'features', 'labels', 'train', 'predict', 'predict_rolling', 'signals', 'simulate', 'output'];

function fmtBytes(n: number) {
  if (n < 1024) return `${n} B`;
  if (n < 1024 * 1024) return `${(n / 1024).toFixed(1)} KB`;
  if (n < 1024 * 1024 * 1024) return `${(n / (1024 * 1024)).toFixed(1)} MB`;
  return `${(n / (1024 * 1024 * 1024)).toFixed(2)} GB`;
}

function runStatusSeverity(status: string): 'green' | 'amber' | 'red' | 'neutral' {
  if (status === 'ok') return 'green';
  if (status === 'fail' || status === 'killed') return 'red';
  if (status === 'running' || status === 'pending') return 'amber';
  return 'neutral';
}

function timeAgo(iso: string | number): string {
  const ts = typeof iso === 'number' ? iso : Date.parse(iso);
  if (isNaN(ts)) return '—';
  const ms = Date.now() - ts;
  if (ms < 0) return 'now';
  const m = Math.floor(ms / 60000);
  if (m < 1) return `${Math.floor(ms / 1000)}s ago`;
  if (m < 60) return `${m}m ago`;
  const h = Math.floor(m / 60);
  if (h < 24) return `${h}h ago`;
  return `${Math.floor(h / 24)}d ago`;
}

export function ITBPage() {
  const [status, setStatus] = useState<Status | null>(null);
  const [loading, setLoading] = useState(true);
  const [config, setConfig] = useState<string>('');
  const [running, setRunning] = useState<string | null>(null);
  const [result, setResult] = useState<RunResult | null>(null);
  const [resultScript, setResultScript] = useState<string | null>(null);
  const [copied, setCopied] = useState<string | null>(null);

  const fetchStatus = useCallback(async () => {
    setLoading(true);
    try {
      const r = await fetch('/api/itb');
      const data: Status = await r.json();
      setStatus(data);
      if (data.configs?.length && !config) setConfig(data.configs[0]);
    } catch (e) {
      console.error('itb status failed', e);
    } finally {
      setLoading(false);
    }
  }, [config]);

  useEffect(() => { fetchStatus(); }, [fetchStatus]);

  async function runScript(script: string) {
    if (!config) return;
    setRunning(script);
    setResultScript(script);
    setResult(null);
    try {
      const r = await fetch('/api/itb', {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({ action: 'run', script, config }),
      });
      const data: RunResult = await r.json();
      setResult(data);
    } catch (e) {
      setResult({ success: false, error: String(e) });
    } finally {
      setRunning(null);
    }
  }

  async function copy(text: string, id: string) {
    await navigator.clipboard.writeText(text);
    setCopied(id);
    setTimeout(() => setCopied(null), 1200);
  }

  const installedCount = status ? Object.values(status.deps).filter(Boolean).length : 0;
  const depTotal = status ? Object.keys(status.deps).length : 0;

  // Run history data
  const runs = status?.runs ?? [];
  const runHistoryChartData = runs.map(r => ({
    script: r.script,
    elapsed_ms: r.elapsed_ms ?? 0,
    status: r.status,
    ts: r.ts,
  })).slice(-30);

  // Heatmap: pipeline scripts × a single "last-run" column, colored by status
  const pipelineHealth = status?.pipeline_health ?? {};
  function pipelineHeatmapValue(rowIdx: number, _colIdx: number) {
    const script = PIPELINE_ORDER[rowIdx];
    const health = pipelineHealth[script];
    // Find the most recent run for this script
    const lastRun = [...runs].filter(r => r.script === script).sort((a, b) => b.ts - a.ts)[0];
    if (lastRun) {
      const sev = runStatusSeverity(lastRun.status);
      const label = lastRun.status === 'ok' ? 'ok' : lastRun.status.slice(0, 4);
      return { score: sev === 'green' ? 1 : sev === 'red' ? 0 : 0.5, label, severity: sev as any };
    }
    if (health?.last_ok_ts) {
      return { score: 1, label: 'ok', severity: 'green' as any };
    }
    return { score: -1, label: '—', severity: 'neutral' as any };
  }

  return (
    <div style={{ padding: 20, color: 'var(--color-mc-text)', fontFamily: 'var(--font-mc-sans)', maxWidth: 1400, margin: '0 auto' }}>
      {/* ── Header ────────────────────────────────────────────────────────── */}
      <div style={{ display: 'flex', alignItems: 'flex-start', justifyContent: 'space-between', marginBottom: 18, flexWrap: 'wrap', gap: 12 }}>
        <div>
          <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 4 }}>
            <h1 style={{ fontSize: 22, fontWeight: 700, color: 'var(--color-mc-text)', margin: 0 }}>Intelligent Trading Bot</h1>
            <Badge severity="cyan">asavinov/intelligent-trading-bot</Badge>
          </div>
          <div style={{ fontSize: 13, color: 'var(--color-mc-text-muted)' }}>
            ML-powered crypto trading bot. Pipeline: download → merge → features → labels → train → predict → signals → output.
            Plus an online streaming service for live mode.
          </div>
        </div>
        <div style={{ display: 'flex', gap: 8 }}>
          <a href="https://github.com/asavinov/intelligent-trading-bot" target="_blank" rel="noopener"
             style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, textDecoration: 'none', border: '1px solid var(--color-mc-border)' }}>
            <ExternalLink size={14} /> Repo
          </a>
          <button onClick={fetchStatus} disabled={loading}
            style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, border: '1px solid var(--color-mc-border)', cursor: 'pointer' }}>
            <RefreshCw size={14} className={loading ? 'animate-spin' : ''} /> Refresh
          </button>
        </div>
      </div>

      {/* ── Status cards row — MetricCard + PulseDot ─────────────────────── */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(260px, 1fr))', gap: 12, marginBottom: 18 }}>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <FolderOpen size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>REPO</span>
            <PulseDot status={status?.repo_exists ? 'active' : 'offline'} />
          </div>
          <Kv k="path" v={status?.repo ?? '—'} mono />
          <Kv k="exists" v={status?.repo_exists ? 'yes' : 'no'} ok={status?.repo_exists} />
          <Kv k="commit" v={status?.commit ?? '—'} mono small />
        </div>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <Package size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>PYTHON VENV</span>
            <PulseDot status={status?.venv_exists ? 'active' : 'offline'} />
          </div>
          <Kv k="installed" v={status?.venv_exists ? 'yes' : 'no'} ok={status?.venv_exists} />
          <Kv k="path" v={status?.venv_python ?? '—'} mono small />
          <Kv k="deps" v={status ? `${installedCount} / ${depTotal} importable` : '—'} ok={installedCount === depTotal && depTotal > 0} />
        </div>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <FolderOpen size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>CONFIGS</span>
          </div>
          <Kv k="count" v={status ? String(status.configs.length) : '—'} />
          {status?.configs.slice(0, 3).map(c => <Kv key={c} k="•" v={c} mono small />)}
        </div>
      </div>

      {/* ── Dep grid — token-class colors ─────────────────────────────────── */}
      {status?.venv_exists && (
        <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 12, marginBottom: 18 }}>
          <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>DEPENDENCIES</div>
          <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8 }}>
            {Object.entries(status.deps).map(([pkg, ok]) => (
              <div key={pkg} style={{
                display: 'flex', alignItems: 'center', gap: 6, padding: '4px 10px', borderRadius: 4,
                background: ok
                  ? 'color-mix(in srgb, var(--color-mc-green) 12%, transparent)'
                  : 'color-mix(in srgb, var(--color-mc-red) 12%, transparent)',
                color: ok ? 'var(--color-mc-green)' : 'var(--color-mc-red)',
                fontSize: 12, fontFamily: 'var(--font-mc-mono)',
              }}>
                {ok ? <CheckCircle2 size={12} /> : <XCircle size={12} />}
                {pkg}
              </div>
            ))}
          </div>
        </div>
      )}

      {/* ── Pipeline — Heatmap row for last-run health + run buttons ────── */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 18 }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 12, flexWrap: 'wrap' }}>
          <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>PIPELINE</div>
          <div style={{ marginLeft: 'auto', display: 'flex', alignItems: 'center', gap: 8 }}>
            <span style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}>config:</span>
            <select value={config} onChange={e => setConfig(e.target.value)}
              style={{ padding: '4px 8px', background: 'var(--color-mc-bg-surface)', color: 'var(--color-mc-text)', border: '1px solid var(--color-mc-border)', borderRadius: 4, fontSize: 12, fontFamily: 'var(--font-mc-mono)' }}>
              {status?.configs.map(c => <option key={c} value={c}>{c}</option>)}
            </select>
          </div>
        </div>

        {/* Heatmap: pipeline scripts last-run health (single column) */}
        {(runs.length > 0 || Object.keys(pipelineHealth).length > 0) && (
          <div style={{ marginBottom: 12 }}>
            <div style={{ fontSize: 10, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)', marginBottom: 4, letterSpacing: 1 }}>LAST-RUN HEALTH</div>
            <Heatmap
              rows={PIPELINE_ORDER}
              cols={['last run']}
              value={pipelineHeatmapValue}
              onCellClick={(ri) => {
                const script = PIPELINE_ORDER[ri];
                if (!running) runScript(script);
              }}
            />
            <div style={{ fontSize: 10, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)', marginTop: 4 }}>
              Click a cell to run the script
            </div>
          </div>
        )}

        {/* Run buttons */}
        <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8 }}>
          {PIPELINE_ORDER.map((script, i) => {
            const isRunning = running === script;
            const blocked = !status?.venv_exists || !config;
            // Find last run for this script
            const lastRun = [...runs].filter(r => r.script === script).sort((a, b) => b.ts - a.ts)[0];
            return (
              <button key={script} onClick={() => runScript(script)} disabled={blocked || !!running}
                title={SCRIPT_DESCS[script]}
                style={{
                  display: 'flex', flexDirection: 'column', alignItems: 'flex-start', gap: 2, padding: '8px 12px',
                  borderRadius: 6, background: isRunning
                    ? 'color-mix(in srgb, var(--color-mc-accent) 18%, transparent)'
                    : 'var(--color-mc-bg-surface)',
                  color: blocked ? 'var(--color-mc-text-dim)' : 'var(--color-mc-text)',
                  border: '1px solid ' + (isRunning ? 'var(--color-mc-accent)' : 'var(--color-mc-border)'),
                  fontSize: 12, fontFamily: 'var(--font-mc-mono)', cursor: blocked || running ? 'not-allowed' : 'pointer',
                  opacity: blocked ? 0.5 : 1,
                }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
                  <span style={{ color: 'var(--color-mc-text-dim)', fontSize: 10 }}>{i + 1}</span>
                  {isRunning ? <Loader2 size={12} className="animate-spin" /> : <Play size={11} />}
                  {script}
                </div>
                {lastRun && (
                  <div style={{ fontSize: 9, color: runStatusSeverity(lastRun.status) === 'green' ? 'var(--color-mc-green)' : runStatusSeverity(lastRun.status) === 'red' ? 'var(--color-mc-red)' : 'var(--color-mc-amber)' }}>
                    {timeAgo(lastRun.ts)} · {lastRun.status}
                  </div>
                )}
              </button>
            );
          })}
        </div>

        <div style={{ marginTop: 10, fontSize: 11, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>
          Runs <code style={{ color: 'var(--color-mc-accent)' }}>python -m scripts.&lt;name&gt; -c configs/{config || '<config>'}</code> with a 5-minute timeout.
          Long-running training will hit the limit — run those in a terminal.
        </div>
      </div>

      {/* ── Run History (new) ────────────────────────────────────────────── */}
      {runs.length > 0 && (
        <div style={{ marginBottom: 18 }}>
          <div style={{ marginBottom: 8 }}>
            <SectionHeader title="Run History" />
          </div>
          <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14 }}>
            <div style={{ height: 120 }}>
              <ResponsiveContainer width="100%" height={120}>
                <ComposedChart data={runHistoryChartData} margin={{ top: 4, right: 8, bottom: 4, left: 8 }}>
                  <XAxis
                    dataKey="script"
                    tick={{ fontSize: 9, fill: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}
                    axisLine={{ stroke: 'var(--color-mc-border)' }}
                    tickLine={false}
                  />
                  <YAxis
                    tick={{ fontSize: 9, fill: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}
                    axisLine={{ stroke: 'var(--color-mc-border)' }}
                    tickLine={false}
                    width={40}
                    tickFormatter={(v: number) => v > 1000 ? `${(v / 1000).toFixed(0)}s` : `${v}ms`}
                  />
                  <Tooltip
                    contentStyle={{
                      background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)',
                      borderRadius: 4, fontSize: 10, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-text)',
                    }}
                    formatter={(value: any, _name: any, props: any) => [
                      `${((value as number) / 1000).toFixed(2)}s`,
                      `${props.payload?.script} (${props.payload?.status})`
                    ]}
                  />
                  <Bar dataKey="elapsed_ms" radius={[2, 2, 0, 0]}>
                    {runHistoryChartData.map((entry, index) => (
                      <Cell
                        key={`cell-${index}`}
                        fill={
                          entry.status === 'ok' ? 'var(--color-mc-green)'
                          : entry.status === 'fail' || entry.status === 'killed' ? 'var(--color-mc-red)'
                          : 'var(--color-mc-amber)'
                        }
                      />
                    ))}
                  </Bar>
                </ComposedChart>
              </ResponsiveContainer>
            </div>
          </div>
        </div>
      )}

      {/* ── Output console — GlassPanel ────────────────────────────────── */}
      {(running || result) && (
        <GlassPanel style={{ marginBottom: 18 }}>
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 8 }}>
            <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>
              OUTPUT {resultScript ? `— scripts.${resultScript}` : ''}
            </div>
            {result && (
              <div style={{ display: 'flex', alignItems: 'center', gap: 8, fontSize: 11 }}>
                <Badge severity={result.success ? 'green' : 'red'}>{result.success ? 'OK' : 'FAILED'}</Badge>
                <span style={{ color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>exit {result.exit_code ?? '—'}</span>
                <span style={{ color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>{result.elapsed_ms ? `${(result.elapsed_ms / 1000).toFixed(1)}s` : ''}</span>
              </div>
            )}
          </div>
          {running && !result && (
            <div style={{ color: 'var(--color-mc-text-muted)', fontSize: 12, padding: 8, fontFamily: 'var(--font-mc-mono)' }}>
              <Loader2 size={12} className="animate-spin" style={{ display: 'inline', marginRight: 6, verticalAlign: 'middle' }} />
              Running… (this may take a while)
            </div>
          )}
          {result?.error && (
            <pre style={{ color: 'var(--color-mc-red)', fontSize: 11, fontFamily: 'var(--font-mc-mono)', whiteSpace: 'pre-wrap', wordBreak: 'break-all' }}>
              {result.error}
            </pre>
          )}
          {result?.stdout && (
            <details open style={{ marginBottom: 8 }}>
              <summary style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>stdout ({result.stdout.length} chars)</summary>
              <pre style={{ background: 'var(--color-mc-bg-surface)', padding: 10, borderRadius: 4, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-text-muted)', whiteSpace: 'pre-wrap', wordBreak: 'break-all', maxHeight: 400, overflow: 'auto' }}>
                {result.stdout}
              </pre>
            </details>
          )}
          {result?.stderr && (
            <details open={!result.success}>
              <summary style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>stderr ({result.stderr.length} chars)</summary>
              <pre style={{ background: 'var(--color-mc-bg-surface)', padding: 10, borderRadius: 4, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-red)', whiteSpace: 'pre-wrap', wordBreak: 'break-all', maxHeight: 400, overflow: 'auto' }}>
                {result.stderr}
              </pre>
            </details>
          )}
        </GlassPanel>
      )}

      {/* ── Online service ─────────────────────────────────────────────────── */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 18 }}>
        <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>ONLINE STREAMING SERVICE</div>
        <div style={{ fontSize: 12, color: 'var(--color-mc-text-muted)', marginBottom: 10 }}>
          The bot's live mode runs as a long-lived process. Don't launch it from this dashboard — run it under PM2 or in a terminal:
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 8, padding: '8px 10px', background: 'var(--color-mc-bg-surface)', borderRadius: 4, border: '1px solid var(--color-mc-border)' }}>
          <code style={{ flex: 1, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-text)', wordBreak: 'break-all' }}>
            cd /home/itsju/LapClaw/intelligent-trading-bot && .venv/bin/python -m service.server -c configs/{config || '<config>'}
          </code>
          <button onClick={() => copy(`cd /home/itsju/LapClaw/intelligent-trading-bot && .venv/bin/python -m service.server -c configs/${config}`, 'service')}
            style={{ background: 'transparent', border: 'none', color: 'var(--color-mc-accent)', cursor: 'pointer', padding: 4 }}>
            {copied === 'service' ? <CheckCircle2 size={14} /> : <Copy size={14} />}
          </button>
        </div>
      </div>

      {/* ── Outputs ───────────────────────────────────────────────────────── */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14 }}>
        <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>OUTPUTS</div>
        {!status?.outputs?.length ? (
          <div style={{ fontSize: 12, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>No files in outputs/ yet — run the pipeline first.</div>
        ) : (
          <table style={{ width: '100%', fontSize: 12, fontFamily: 'var(--font-mc-mono)' }}>
            <thead>
              <tr style={{ color: 'var(--color-mc-text-dim)', textAlign: 'left' }}>
                <th style={{ padding: '4px 8px', fontWeight: 500 }}>file</th>
                <th style={{ padding: '4px 8px', fontWeight: 500 }}>size</th>
                <th style={{ padding: '4px 8px', fontWeight: 500 }}>modified</th>
              </tr>
            </thead>
            <tbody>
              {status.outputs.map(f => (
                <tr key={f.name} style={{ borderTop: '1px solid var(--color-mc-border)' }}>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text)' }}>{f.name}</td>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text-muted)' }}>{fmtBytes(f.size)}</td>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text-muted)' }}>{new Date(f.modified).toLocaleString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}

function Kv({ k, v, mono, small, ok }: { k: string; v: string; mono?: boolean; small?: boolean; ok?: boolean }) {
  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', gap: 8, padding: '3px 0', fontSize: small ? 11 : 12 }}>
      <span style={{ color: 'var(--color-mc-text-dim)', flexShrink: 0, fontFamily: 'var(--font-mc-mono)' }}>{k}</span>
      <span style={{
        color: ok === true ? 'var(--color-mc-green)' : ok === false ? 'var(--color-mc-red)' : 'var(--color-mc-text)',
        fontFamily: mono ? 'var(--font-mc-mono)' : undefined,
        textAlign: 'right', wordBreak: 'break-all',
      }}>{v}</span>
    </div>
  );
}

export default ITBPage;
