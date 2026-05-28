import { NextResponse } from 'next/server';
import Database from 'better-sqlite3';
import fs from 'fs';
import path from 'path';
import { dbRead } from '@/lib/dashboard-db';
import { readPulseTimeseries } from '@/lib/live-strategy-pulse-source';

// Simple TTL-based LRU cache (avoids lru-cache package type issues)
// key=pair, TTL=5min, max 50 entries
interface OhlcEntry { bars: Array<{ t: number; close: number }>; expiresAt: number }
const ohlcCache = new Map<string, OhlcEntry>();
const OHLC_TTL_MS = 5 * 60 * 1000;
const OHLC_MAX_ENTRIES = 50;

function ohlcCacheGet(key: string): OhlcEntry | undefined {
  const entry = ohlcCache.get(key);
  if (!entry) return undefined;
  if (Date.now() > entry.expiresAt) { ohlcCache.delete(key); return undefined; }
  return entry;
}

function ohlcCacheSet(key: string, bars: Array<{ t: number; close: number }>): void {
  if (ohlcCache.size >= OHLC_MAX_ENTRIES) {
    // Evict oldest
    const firstKey = ohlcCache.keys().next().value;
    if (firstKey) ohlcCache.delete(firstKey);
  }
  ohlcCache.set(key, { bars, expiresAt: Date.now() + OHLC_TTL_MS });
}

export const runtime = 'nodejs';
export const dynamic = 'force-dynamic';

const LIVE_DB_PATH = path.join(process.cwd(), 'data/live_trades.sqlite');
const TV_DB_PATH = path.join(process.cwd(), 'data/tv_webhook_log.sqlite');
const BOT_DIAG_PATH = path.join(process.cwd(), 'data/alpaca_bot_status.json');
const OHLC_CACHE_DIR = path.join(process.cwd(), 'data/ohlc_cache');
const SECRETS = path.join(process.env.HOME || '/home/itsju', '.openclaw/secrets');

const PAPER_BASE = 'https://paper-api.alpaca.markets';

const BASELINE = {
  win_rate: 0.683,
  avg_profit_pct: 2.15,
  trades_per_month: 60 / 7.5,
  sharpe: 3.06,
  drawdown_pct: 0.39,
};

const MAX_PAIRS = parseInt(process.env.MISSIONCTRL_LS_MAX_PAIRS ?? '20', 10);
const MAX_BARS = 200;
const PAYLOAD_BUDGET_BYTES = 2 * 1024 * 1024; // 2 MB

function loadOhlcForPair(pair: string): { bars: Array<{ t: number; close: number }>; source: string } {
  const cached = ohlcCacheGet(pair);
  if (cached) return { bars: cached.bars, source: 'lru' };

  const safeName = pair.replace('/', '_');
  const cachePath = path.join(OHLC_CACHE_DIR, `${safeName}-1h.json`);

  if (!fs.existsSync(cachePath)) {
    return { bars: [], source: 'unavailable' };
  }

  const stat = fs.statSync(cachePath);
  const ageMs = Date.now() - stat.mtimeMs;
  if (ageMs > 2 * 60 * 60 * 1000) { // > 2h stale
    return { bars: [], source: 'unavailable' };
  }

  try {
    const raw = fs.readFileSync(cachePath, 'utf-8');
    const bars = JSON.parse(raw) as Array<{ t: number; close: number }>;
    const sliced = bars.slice(-MAX_BARS);
    ohlcCacheSet(pair, sliced);
    return { bars: sliced, source: 'cache' };
  } catch {
    return { bars: [], source: 'unavailable' };
  }
}

function loadCreds(account: string): { keyId: string; secret: string } | null {
  try {
    return {
      keyId: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-key-id`), 'utf-8').trim(),
      secret: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-secret`), 'utf-8').trim(),
    };
  } catch { return null; }
}

async function fetchAlpaca(account: string, pathSuffix: string): Promise<unknown> {
  const creds = loadCreds(account);
  if (!creds) return { error: 'no creds' };
  try {
    const r = await fetch(`${PAPER_BASE}${pathSuffix}`, {
      headers: { 'APCA-API-KEY-ID': creds.keyId, 'APCA-API-SECRET-KEY': creds.secret },
      signal: AbortSignal.timeout(8000),
    });
    return await r.json();
  } catch (e) { return { error: String(e) }; }
}

export async function GET() {
  const enabled = process.env.TV_WEBHOOK_ENABLED === 'true';
  const accounts = (process.env.TV_WEBHOOK_ACCOUNTS ?? 'boba,jazzy').split(',');

  // ── live_signals ────────────────────────────────────────────────────────
  let signals: Record<string, unknown>[] = [];
  let signalCounts: Record<string, number> = {};
  if (fs.existsSync(LIVE_DB_PATH)) {
    const db = new Database(LIVE_DB_PATH, { readonly: true });
    try {
      const since = new Date(Date.now() - 30 * 86400 * 1000).toISOString();
      signals = db.prepare(`
        SELECT id, received_at, bar_time, strategy, account, symbol, action,
               alert_price, stop_price, tp2_price, quantity_requested,
               decision, suppression_reason, rejection_reason, dedupe_key
        FROM live_signals
        WHERE received_at >= ?
        ORDER BY id DESC LIMIT 50
      `).all(since) as Record<string, unknown>[];

      const counts = db.prepare(`
        SELECT decision, COUNT(*) n FROM live_signals
        WHERE received_at >= ? GROUP BY decision
      `).all(since) as { decision: string; n: number }[];
      signalCounts = Object.fromEntries(counts.map(c => [c.decision, c.n]));
    } finally { db.close(); }
  }

  // ── webhook log ─────────────────────────────────────────────────────────
  let webhookLog: Record<string, unknown>[] = [];
  if (fs.existsSync(TV_DB_PATH)) {
    const db = new Database(TV_DB_PATH, { readonly: true });
    try {
      webhookLog = db.prepare(`
        SELECT id, received_at, account, symbol, action, outcome, http_status,
               alpaca_order_id, alpaca_status, duration_ms
        FROM tv_webhook_log ORDER BY id DESC LIMIT 20
      `).all() as Record<string, unknown>[];
    } finally { db.close(); }
  }

  // ── alpaca account + positions (parallel) ───────────────────────────────
  const acctPromises = accounts.map(async (a) => {
    const [acct, pos, ords] = await Promise.all([
      fetchAlpaca(a, '/v2/account'),
      fetchAlpaca(a, '/v2/positions'),
      fetchAlpaca(a, '/v2/orders?status=open&limit=20'),
    ]);
    return { account: a, account_info: acct, positions: pos, open_orders: ords };
  });
  const accountData = await Promise.all(acctPromises);

  // ── drift score ─────────────────────────────────────────────────────────
  const submitted = signalCounts.submitted ?? 0;
  const rejected = signalCounts.rejected ?? 0;
  const total = Object.values(signalCounts).reduce((a, b) => a + b, 0);
  const fillRate = submitted + rejected ? submitted / (submitted + rejected) : 1;
  const tradesPerDay = submitted / 30;
  const expectedPerDay = BASELINE.trades_per_month / 30;
  const freqRatio = expectedPerDay ? tradesPerDay / expectedPerDay : 0;

  let drift = 0;
  if (fillRate < 0.95) drift += 3;
  if (fillRate < 0.85) drift += 2;
  if (freqRatio < 0.3 || freqRatio > 2.5) drift += 2;

  // ── bot diagnostics ─────────────────────────────────────────────────────
  let botStatus: Record<string, unknown> | null = null;
  if (fs.existsSync(BOT_DIAG_PATH)) {
    try {
      const raw = fs.readFileSync(BOT_DIAG_PATH, 'utf-8');
      botStatus = JSON.parse(raw);
      const lp = (botStatus as { last_poll?: string }).last_poll;
      if (lp) {
        const ageSec = Math.floor((Date.now() - Date.parse(lp)) / 1000);
        (botStatus as Record<string, unknown>).age_seconds = ageSec;
        (botStatus as Record<string, unknown>).stale = ageSec > 180;
      }
    } catch {}
  }

  // ── 3b: timeseries from dashboard_history.sqlite (read-only) ────────────
  let fill_rate_timeseries: Array<{ t: number; fill_rate: number }> = [];
  let drift_timeseries: Array<{ t: number; drift_score: number }> = [];
  let signal_timeseries: Array<{ t: number; signal_total: number }> = [];

  dbRead(db => {
    const ts = readPulseTimeseries(db);
    fill_rate_timeseries = ts.fill_rate_timeseries;
    drift_timeseries = ts.drift_timeseries;
    signal_timeseries = ts.signal_timeseries;
  });

  // ── 3b: per-pair price_history + signal_markers ─────────────────────────
  const pairs = (() => {
    try {
      const bs = botStatus as Record<string, unknown> | null;
      if (Array.isArray(bs?.pairs)) return (bs!.pairs as unknown[]).filter((p): p is string => typeof p === 'string');
      return [];
    } catch { return []; }
  })();

  // Signal markers derived from recent_signals snapped to nearest hour
  const signalsByPair: Record<string, Array<{ t: number; side: 'buy' | 'sell'; price: number }>> = {};
  for (const sig of signals) {
    const pair = sig.symbol as string | undefined;
    if (!pair) continue;
    const action = (sig.action as string ?? '').toLowerCase();
    const side: 'buy' | 'sell' = action.includes('buy') ? 'buy' : 'sell';
    const ts = sig.received_at ? Math.floor(Date.parse(sig.received_at as string) / 3_600_000) * 3_600_000 : null;
    const price = Number(sig.alert_price ?? 0);
    if (ts && price) {
      if (!signalsByPair[pair]) signalsByPair[pair] = [];
      signalsByPair[pair].push({ t: ts, side, price });
    }
  }

  // Load OHLC with pair cap and payload budget (R3.M3)
  const cappedPairs = pairs.slice(0, MAX_PAIRS);
  const overCapPairs = pairs.slice(MAX_PAIRS);

  // Concurrent file reads capped at 10 (R3.M3)
  const CONCURRENCY = 10;
  const priceHistory: Array<{
    pair: string;
    price_history: Array<{ t: number; close: number }>;
    signal_markers: Array<{ t: number; side: 'buy' | 'sell'; price: number }>;
    price_source: string;
  }> = [];

  let payloadBytes = 0;
  let truncated = false;

  for (let i = 0; i < cappedPairs.length && !truncated; i += CONCURRENCY) {
    const batch = cappedPairs.slice(i, i + CONCURRENCY);
    const results = await Promise.all(batch.map(async (pair) => {
      const { bars, source } = loadOhlcForPair(pair);
      return { pair, bars, source };
    }));

    for (const { pair, bars, source } of results) {
      if (truncated) break;
      const entry = {
        pair,
        price_history: bars,
        signal_markers: signalsByPair[pair] ?? [],
        price_source: source,
      };
      const entrySize = JSON.stringify(entry).length;
      payloadBytes += entrySize;
      if (payloadBytes > PAYLOAD_BUDGET_BYTES) {
        truncated = true;
        break;
      }
      priceHistory.push(entry);
    }
  }

  // Over-cap pairs (pair_source: 'capped')
  for (const pair of overCapPairs) {
    priceHistory.push({
      pair,
      price_history: [],
      signal_markers: [],
      price_source: 'capped',
    });
  }

  return NextResponse.json({
    config: {
      enabled,
      accounts,
      webhook_url: 'https://bridge.serveftp.com/tv-webhook/<slug>',
      strategy: 'PullbackTrend_1h_swing',
    },
    baseline: BASELINE,
    signal_counts: signalCounts,
    signal_total: total,
    fill_rate: fillRate,
    frequency_ratio: freqRatio,
    drift_score: drift,
    signals,
    webhook_log: webhookLog,
    accounts_data: accountData,
    bot_status: botStatus,
    // 3b new fields
    fill_rate_timeseries,
    drift_timeseries,
    signal_timeseries,
    price_history: priceHistory,
    payload_truncated: truncated,
  });
}
