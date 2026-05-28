'use client';

import { useEffect, useState, useCallback } from 'react';
import { ExternalLink, RefreshCw, Play, Copy, CheckCircle2, XCircle, Loader2, FolderOpen, Package, ChevronDown, ChevronUp } from 'lucide-react';
import { safeFixed } from '@/lib/fmt';
import { MetricCard } from '@/components/ui/MetricCard';
import { Badge } from '@/components/ui/Badge';
import { PulseDot } from '@/components/ui/PulseDot';
import { Sparkline } from '@/components/ui/Sparkline';
import { RadialGauge } from '@/components/ui/RadialGauge';
import { SignalChart } from '@/components/ui/SignalChart';
import { GlassPanel } from '@/components/ui/GlassPanel';
import { SectionHeader } from '@/components/ui/SectionHeader';

interface FileEntry { name: string; size: number; modified: string; }

interface BacktestHistoryEntry {
  run_uuid: string;
  strategy: string;
  pair: string;
  equity_curve: { t: number; equity: number }[];
  trade_markers: { t: number; side: 'buy' | 'sell'; price: number }[];
  total_profit_pct: number;
  win_rate: number;
  sharpe: number;
}

interface RunRecord {
  run_uuid: string;
  ts: number;
  subcommand: string;
  status: string;
  exit_code?: number;
  elapsed_ms?: number;
}

interface Status {
  repo: string;
  repo_exists: boolean;
  venv_exists: boolean;
  ft_installed: boolean;
  venv_python: string;
  commit: string | null;
  version: string | null;
  userdir: string;
  userdir_exists: boolean;
  local_config_exists: boolean;
  strategies: FileEntry[];
  data_files: FileEntry[];
  backtest_results: FileEntry[];
  subcommands: string[];
  // Phase 3 additive
  runs?: RunRecord[];
  backtest_history?: BacktestHistoryEntry[];
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

const SUBCMD_DESCS: Record<string, string> = {
  'list-strategies': 'List discovered strategies in user_data/strategies',
  'list-exchanges': 'List exchanges supported by ccxt',
  'list-markets': 'List markets for the configured exchange',
  'list-pairs': 'List active pairs (from config whitelist)',
  'list-timeframes': 'List available timeframes',
  'list-data': 'Inventory of downloaded candles',
  'download-data': 'Download OHLCV candles for whitelist pairs',
  'backtesting': 'Backtest a strategy over historical data',
  'show-config': 'Print the loaded config',
  'install-ui': 'Download FreqUI into the venv (web dashboard at :8080)',
};

const SUBCMD_ARGS: Record<string, string> = {
  'download-data': '--exchange binanceus --pairs BTC/USDT --timeframes 1h --timerange 20240101-',
  'backtesting': '--strategy SampleStrategy --timerange 20240601-',
};

function fmtBytes(n: number) {
  if (n < 1024) return `${n} B`;
  if (n < 1024 * 1024) return `${(n / 1024).toFixed(1)} KB`;
  if (n < 1024 * 1024 * 1024) return `${(n / (1024 * 1024)).toFixed(1)} MB`;
  return `${(n / (1024 * 1024 * 1024)).toFixed(2)} GB`;
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

function fileTypeSeverity(name: string): 'green' | 'cyan' | 'amber' | 'neutral' {
  if (name.endsWith('.py')) return 'cyan';
  if (name.endsWith('.json')) return 'green';
  if (name.endsWith('.zip')) return 'amber';
  return 'neutral';
}

export function FreqtradePage() {
  const [status, setStatus] = useState<Status | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [running, setRunning] = useState<string | null>(null);
  const [result, setResult] = useState<RunResult | null>(null);
  const [resultSub, setResultSub] = useState<string | null>(null);
  const [extraArgs, setExtraArgs] = useState<string>('');
  const [copied, setCopied] = useState<string | null>(null);
  const [expandedBacktest, setExpandedBacktest] = useState<string | null>(null);

  const fetchStatus = useCallback(async () => {
    setLoading(true);
    try {
      const r = await fetch('/api/freqtrade');
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      const data: Status = await r.json();
      setStatus(data);
      setError(false);
    } catch (e) {
      console.error('freqtrade status failed', e);
      setError(true);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => { fetchStatus(); }, [fetchStatus]);

  async function runSub(sub: string) {
    setRunning(sub);
    setResultSub(sub);
    setResult(null);
    const args = (SUBCMD_ARGS[sub] || extraArgs).split(/\s+/).filter(Boolean);
    try {
      const r = await fetch('/api/freqtrade', {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({ action: 'run', subcommand: sub, args }),
      });
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
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

  const runs = status?.runs ?? [];
  const backtestHistory = status?.backtest_history ?? [];
  const tradeCmd = `cd /home/itsju/LapClaw/freqtrade && .venv/bin/freqtrade trade -c config.json --userdir user_data --strategy SampleStrategy`;
  const freqUiUrl = 'http://localhost:8080';

  // Helper: last run for a subcommand
  function lastRunFor(sub: string) {
    return [...runs].filter(r => r.subcommand === sub).sort((a, b) => b.ts - a.ts)[0];
  }

  return (
    <div style={{ padding: 20, color: 'var(--color-mc-text)', fontFamily: 'var(--font-mc-sans)', maxWidth: 1400, margin: '0 auto' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'flex-start', justifyContent: 'space-between', marginBottom: 18, flexWrap: 'wrap', gap: 12 }}>
        <div>
          <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 4 }}>
            <h1 style={{ fontSize: 22, fontWeight: 700, color: 'var(--color-mc-text)', margin: 0 }}>Freqtrade</h1>
            <Badge severity="cyan">freqtrade/freqtrade</Badge>
            {status?.version && <span style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}>{status.version.split('\n').find(l => l.toLowerCase().includes('freqtrade version'))?.replace(/.*Version:\s*/i, '') ?? ''}</span>}
          </div>
          <div style={{ fontSize: 13, color: 'var(--color-mc-text-muted)' }}>
            Open-source Python crypto trading bot. CLI-driven: download-data → backtesting → trade (dry-run / live).
            Built-in REST API + FreqUI web dashboard on port 8080.
          </div>
        </div>
        <div style={{ display: 'flex', gap: 8 }}>
          <a href="https://github.com/freqtrade/freqtrade" target="_blank" rel="noopener"
             style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, textDecoration: 'none', border: '1px solid var(--color-mc-border)' }}>
            <ExternalLink size={14} /> Repo
          </a>
          <a href={freqUiUrl} target="_blank" rel="noopener"
             style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, textDecoration: 'none', border: '1px solid var(--color-mc-border)' }}>
            <ExternalLink size={14} /> FreqUI :8080
          </a>
          <button onClick={fetchStatus} disabled={loading}
            style={{ display: 'flex', alignItems: 'center', gap: 6, padding: '6px 12px', borderRadius: 6, background: 'var(--color-mc-bg-card)', color: 'var(--color-mc-text)', fontSize: 12, border: '1px solid var(--color-mc-border)', cursor: 'pointer' }}>
            <RefreshCw size={14} className={loading ? 'animate-spin' : ''} /> Refresh
          </button>
        </div>
      </div>

      {/* Status cards — MetricCard with PulseDot */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(260px, 1fr))', gap: 12, marginBottom: 18 }}>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <FolderOpen size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>REPO</span>
            <PulseDot status={status?.repo_exists ? 'active' : 'offline'} />
          </div>
          <Kv k="path" v={status?.repo ?? '—'} mono small />
          <Kv k="exists" v={status?.repo_exists ? 'yes' : 'no'} ok={status?.repo_exists} />
          <Kv k="commit" v={status?.commit ?? '—'} mono small />
        </div>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <Package size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>INSTALL</span>
            <PulseDot status={status?.ft_installed ? 'active' : 'offline'} />
          </div>
          <Kv k="venv" v={status?.venv_exists ? 'yes' : 'no'} ok={status?.venv_exists} />
          <Kv k="freqtrade" v={status?.ft_installed ? 'yes' : 'no'} ok={status?.ft_installed} />
          <Kv k="config.json" v={status?.local_config_exists ? 'yes' : 'no'} ok={status?.local_config_exists} />
        </div>
        <div className="rounded-[10px] border border-mc-border bg-mc-bg-card p-4">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <FolderOpen size={14} style={{ color: 'var(--color-mc-accent)' }} />
            <span style={{ fontSize: 11, color: 'var(--color-mc-accent)', fontWeight: 600, fontFamily: 'var(--font-mc-mono)', letterSpacing: 0.5 }}>USER DATA</span>
          </div>
          <Kv k="strategies" v={String(status?.strategies.length ?? 0)} />
          <Kv k="data files" v={String(status?.data_files.length ?? 0)} />
          <Kv k="backtest runs" v={String(status?.backtest_results.length ?? 0)} />
        </div>
      </div>

      {/* Commands */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 18 }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 12, flexWrap: 'wrap' }}>
          <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>COMMANDS</div>
          <div style={{ marginLeft: 'auto', display: 'flex', alignItems: 'center', gap: 8 }}>
            <span style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}>extra args:</span>
            <input value={extraArgs} onChange={e => setExtraArgs(e.target.value)} placeholder="optional --flag value"
              style={{ padding: '4px 8px', background: 'var(--color-mc-bg-surface)', color: 'var(--color-mc-text)', border: '1px solid var(--color-mc-border)', borderRadius: 4, fontSize: 12, fontFamily: 'var(--font-mc-mono)', minWidth: 260 }} />
          </div>
        </div>

        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: 6 }}>
          {(status?.subcommands ?? []).map(sub => {
            const isRunning = running === sub;
            const blocked = !status?.ft_installed;
            const lastRun = lastRunFor(sub);
            return (
              <button key={sub} onClick={() => runSub(sub)} disabled={blocked || !!running}
                title={SUBCMD_DESCS[sub]}
                style={{
                  display: 'flex', flexDirection: 'column', alignItems: 'flex-start', gap: 2, padding: '8px 10px',
                  borderRadius: 6,
                  background: isRunning ? 'color-mix(in srgb, var(--color-mc-accent) 18%, transparent)' : 'var(--color-mc-bg-surface)',
                  color: blocked ? 'var(--color-mc-text-dim)' : 'var(--color-mc-text)',
                  border: '1px solid ' + (isRunning ? 'var(--color-mc-accent)' : 'var(--color-mc-border)'),
                  fontSize: 12, fontFamily: 'var(--font-mc-mono)', cursor: blocked || running ? 'not-allowed' : 'pointer',
                  opacity: blocked ? 0.5 : 1, textAlign: 'left',
                }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 6, width: '100%' }}>
                  {isRunning ? <Loader2 size={12} className="animate-spin" /> : <Play size={11} />}
                  <span style={{ flex: 1 }}>{sub}</span>
                  {SUBCMD_ARGS[sub] && <span style={{ color: 'var(--color-mc-text-dim)', fontSize: 10 }}>defaults</span>}
                </div>
                {lastRun && (
                  <div style={{ fontSize: 9, color: lastRun.status === 'ok' ? 'var(--color-mc-green)' : lastRun.status === 'fail' ? 'var(--color-mc-red)' : 'var(--color-mc-amber)' }}>
                    {timeAgo(lastRun.ts)} · {lastRun.status}
                  </div>
                )}
              </button>
            );
          })}
        </div>

        <div style={{ marginTop: 10, fontSize: 11, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>
          5-minute timeout per command. Uses <code style={{ color: 'var(--color-mc-accent)' }}>config.json</code> + <code style={{ color: 'var(--color-mc-accent)' }}>user_data/</code>. `download-data` and `backtesting` ship with sensible defaults.
        </div>
      </div>

      {/* Output console — GlassPanel */}
      {(running || result) && (
        <GlassPanel style={{ marginBottom: 18 }}>
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 8 }}>
            <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>
              OUTPUT {resultSub ? `— ${resultSub}` : ''}
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
          {result?.error && <pre style={{ color: 'var(--color-mc-red)', fontSize: 11, fontFamily: 'var(--font-mc-mono)', whiteSpace: 'pre-wrap', wordBreak: 'break-all' }}>{result.error}</pre>}
          {result?.stdout && (
            <details open style={{ marginBottom: 8 }}>
              <summary style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>stdout ({result.stdout.length} chars)</summary>
              <pre style={{ background: 'var(--color-mc-bg-surface)', padding: 10, borderRadius: 4, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-text-muted)', whiteSpace: 'pre-wrap', wordBreak: 'break-all', maxHeight: 400, overflow: 'auto' }}>{result.stdout}</pre>
            </details>
          )}
          {result?.stderr && (
            <details open={!result.success}>
              <summary style={{ fontSize: 11, color: 'var(--color-mc-text-muted)', cursor: 'pointer', marginBottom: 4, fontFamily: 'var(--font-mc-mono)' }}>stderr ({result.stderr.length} chars)</summary>
              <pre style={{ background: 'var(--color-mc-bg-surface)', padding: 10, borderRadius: 4, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-red)', whiteSpace: 'pre-wrap', wordBreak: 'break-all', maxHeight: 400, overflow: 'auto' }}>{result.stderr}</pre>
            </details>
          )}
        </GlassPanel>
      )}

      {/* Backtest Gallery (new) */}
      {backtestHistory.length > 0 && (
        <div style={{ marginBottom: 18 }}>
          <div style={{ marginBottom: 10 }}>
            <SectionHeader title="Backtest Gallery" />
          </div>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(320px, 1fr))', gap: 12 }}>
            {backtestHistory.map(bt => {
              const isExpanded = expandedBacktest === bt.run_uuid;
              const equitySpark = bt.equity_curve?.map(p => p.equity) ?? [];
              const profitSev: 'green' | 'red' | 'neutral' = bt.total_profit_pct > 0 ? 'green' : bt.total_profit_pct < 0 ? 'red' : 'neutral';
              const winRateSev: 'green' | 'amber' | 'red' = bt.win_rate >= 0.6 ? 'green' : bt.win_rate >= 0.45 ? 'amber' : 'red';

              return (
                <div key={bt.run_uuid} style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, overflow: 'hidden' }}>
                  {/* Card header */}
                  <button
                    onClick={() => setExpandedBacktest(isExpanded ? null : bt.run_uuid)}
                    style={{ width: '100%', padding: '12px 14px', background: 'transparent', border: 'none', cursor: 'pointer', textAlign: 'left' }}
                  >
                    <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 8 }}>
                      <Badge severity="cyan">{bt.strategy}</Badge>
                      <Badge severity="neutral">{bt.pair}</Badge>
                      {isExpanded ? <ChevronUp size={14} style={{ marginLeft: 'auto', color: 'var(--color-mc-text-muted)' }} /> : <ChevronDown size={14} style={{ marginLeft: 'auto', color: 'var(--color-mc-text-muted)' }} />}
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
                      <RadialGauge value={Math.round(bt.win_rate * 100)} max={100} severity={winRateSev} />
                      <div style={{ flex: 1 }}>
                        <div style={{ fontSize: 22, fontWeight: 700, color: bt.total_profit_pct >= 0 ? 'var(--color-mc-green)' : 'var(--color-mc-red)', fontFamily: 'var(--font-mc-mono)' }}>
                          {(bt.total_profit_pct ?? 0) >= 0 ? '+' : ''}{safeFixed(bt.total_profit_pct, 1)}%
                        </div>
                        <div style={{ fontSize: 10, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}>
                          profit · sharpe {bt.sharpe?.toFixed(2) ?? '—'}
                        </div>
                        {equitySpark.length > 0 && (
                          <div style={{ marginTop: 4 }}>
                            <Sparkline data={equitySpark} height={28} fill color={bt.total_profit_pct >= 0 ? 'var(--color-mc-green)' : 'var(--color-mc-red)'} />
                          </div>
                        )}
                      </div>
                    </div>
                  </button>

                  {/* Expanded: full SignalChart */}
                  {isExpanded && bt.equity_curve?.length > 0 && (
                    <div style={{ borderTop: '1px solid var(--color-mc-border)', padding: '12px 14px' }}>
                      <div style={{ fontSize: 10, color: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)', marginBottom: 6, letterSpacing: 1 }}>
                        TRADE MARKERS ON EQUITY CURVE
                      </div>
                      <SignalChart
                        priceSeries={bt.equity_curve.map(p => ({ t: p.t, close: p.equity }))}
                        signals={bt.trade_markers ?? []}
                        height={200}
                      />
                    </div>
                  )}
                </div>
              );
            })}
          </div>
        </div>
      )}

      {/* Live trade */}
      <div style={{ background: 'var(--color-mc-bg-card)', border: '1px solid var(--color-mc-border)', borderRadius: 8, padding: 14, marginBottom: 18 }}>
        <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>LIVE TRADER (DRY-RUN BY DEFAULT)</div>
        <div style={{ fontSize: 12, color: 'var(--color-mc-text-muted)', marginBottom: 10 }}>
          Don't launch from this dashboard — long-lived process. Run under PM2 or in a terminal. Then open FreqUI at <a href={freqUiUrl} target="_blank" rel="noopener" style={{ color: 'var(--color-mc-accent)' }}>localhost:8080</a> (user: freqtrader, pass: freqtrader).
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 8, padding: '8px 10px', background: 'var(--color-mc-bg-surface)', borderRadius: 4, border: '1px solid var(--color-mc-border)' }}>
          <code style={{ flex: 1, fontSize: 11, fontFamily: 'var(--font-mc-mono)', color: 'var(--color-mc-text)', wordBreak: 'break-all' }}>{tradeCmd}</code>
          <button onClick={() => copy(tradeCmd, 'trade')}
            style={{ background: 'transparent', border: 'none', color: 'var(--color-mc-accent)', cursor: 'pointer', padding: 4 }}>
            {copied === 'trade' ? <CheckCircle2 size={14} /> : <Copy size={14} />}
          </button>
        </div>
      </div>

      {/* Strategies — GlassPanel with Badge for file types */}
      <FileTableGlass title="Strategies" files={status?.strategies ?? []} empty="No strategies in user_data/strategies — drop in a .py file or run install-ui for samples." />

      {/* Downloaded Data */}
      <FileTableGlass title="Downloaded Data" files={status?.data_files ?? []} empty="No candles yet — run `download-data` to fetch some." />

      {/* Backtest Results */}
      <FileTableGlass title="Backtest Results" files={status?.backtest_results ?? []} empty="No backtests yet — run `backtesting` with --strategy SampleStrategy." />
    </div>
  );
}

function FileTableGlass({ title, files, empty }: { title: string; files: FileEntry[]; empty: string }) {
  return (
    <GlassPanel style={{ marginBottom: 12 }}>
      <div style={{ fontSize: 12, color: 'var(--color-mc-accent)', fontWeight: 600, marginBottom: 8, letterSpacing: 0.5, fontFamily: 'var(--font-mc-mono)' }}>{title.toUpperCase()}</div>
      {!files.length ? (
        <div style={{ fontSize: 12, color: 'var(--color-mc-text-dim)', fontFamily: 'var(--font-mc-mono)' }}>{empty}</div>
      ) : (
        <table style={{ width: '100%', fontSize: 12, fontFamily: 'var(--font-mc-mono)' }}>
          <thead>
            <tr style={{ color: 'var(--color-mc-text-dim)', textAlign: 'left' }}>
              <th style={{ padding: '4px 8px', fontWeight: 500 }}>file</th>
              <th style={{ padding: '4px 8px', fontWeight: 500 }}>type</th>
              <th style={{ padding: '4px 8px', fontWeight: 500 }}>size</th>
              <th style={{ padding: '4px 8px', fontWeight: 500 }}>modified</th>
            </tr>
          </thead>
          <tbody>
            {files.map(f => {
              const ext = f.name.split('.').pop() ?? '';
              return (
                <tr key={f.name} style={{ borderTop: '1px solid var(--color-mc-border)' }}>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text)' }}>{f.name}</td>
                  <td style={{ padding: '4px 8px' }}><Badge severity={fileTypeSeverity(f.name)}>.{ext}</Badge></td>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text-muted)' }}>{fmtBytes(f.size)}</td>
                  <td style={{ padding: '4px 8px', color: 'var(--color-mc-text-muted)' }}>{new Date(f.modified).toLocaleString()}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}
    </GlassPanel>
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

export default FreqtradePage;
