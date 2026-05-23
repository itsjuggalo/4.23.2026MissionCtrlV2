#!/usr/bin/env node
/**
 * daily-reconciliation.ts — once-per-day audit comparing what the webhook
 * said it submitted to Alpaca vs. what Alpaca actually shows on the books.
 *
 * For each account:
 *   - Pull live_signals with decision='submitted' for the target UTC date
 *   - Pull Alpaca orders for the same window (any status)
 *   - Match by client_order_id (= our dedupe_key)
 *   - Report: matched, ghost_signals (submitted in DB but no Alpaca order),
 *             orphan_orders (Alpaca order with no DB signal — manual/other bot)
 *
 * Writes report to data/reconciliation/YYYY-MM-DD.json and pings Discord.
 *
 * Run via:
 *   npx tsx scripts/daily-reconciliation.ts            # yesterday UTC
 *   npx tsx scripts/daily-reconciliation.ts 2026-05-22 # specific date
 */
import Database from 'better-sqlite3';
import fs from 'fs';
import path from 'path';

const ROOT = path.dirname(__dirname);
const LIVE_DB = path.join(ROOT, 'data/live_trades.sqlite');
const REPORT_DIR = path.join(ROOT, 'data/reconciliation');
const SECRETS = path.join(process.env.HOME || '/home/itsju', '.openclaw/secrets');
const PAPER_BASE = 'https://paper-api.alpaca.markets';
const ACCOUNTS = (process.env.TV_WEBHOOK_ACCOUNTS ?? 'boba,jazzy').split(',').map(s => s.trim());

interface LiveSignal {
  id: number;
  received_at: string;
  account: string;
  symbol: string;
  action: string;
  alert_price: number;
  quantity_requested: number;
  dedupe_key: string;
  decision: string;
  strategy: string;
}

interface AlpacaOrder {
  id: string;
  client_order_id: string;
  symbol: string;
  side: string;
  qty: string;
  filled_qty: string;
  filled_avg_price: string | null;
  status: string;
  submitted_at: string;
  filled_at: string | null;
}

interface AccountReport {
  account: string;
  signals_submitted: number;
  alpaca_orders_total: number;
  matched: number;
  ghost_signals: { dedupe_key: string; symbol: string; action: string; received_at: string }[];
  orphan_orders: { id: string; client_order_id: string; symbol: string; side: string; status: string }[];
  match_rate: number;
  notes: string[];
}

function loadCreds(account: string): { keyId: string; secret: string } | null {
  try {
    return {
      keyId: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-key-id`), 'utf-8').trim(),
      secret: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-secret`), 'utf-8').trim(),
    };
  } catch { return null; }
}

async function fetchAlpacaOrders(account: string, after: string, until: string): Promise<AlpacaOrder[]> {
  const creds = loadCreds(account);
  if (!creds) return [];
  const url = `${PAPER_BASE}/v2/orders?status=all&after=${encodeURIComponent(after)}&until=${encodeURIComponent(until)}&limit=500&direction=asc`;
  try {
    const r = await fetch(url, {
      headers: { 'APCA-API-KEY-ID': creds.keyId, 'APCA-API-SECRET-KEY': creds.secret },
    });
    if (!r.ok) return [];
    return await r.json() as AlpacaOrder[];
  } catch { return []; }
}

function loadSignalsForDate(account: string, date: string): LiveSignal[] {
  const db = new Database(LIVE_DB, { readonly: true });
  try {
    const start = `${date}T00:00:00.000Z`;
    const end = `${date}T23:59:59.999Z`;
    return db.prepare(`
      SELECT id, received_at, account, symbol, action, alert_price,
             quantity_requested, dedupe_key, decision, strategy
      FROM live_signals
      WHERE account = ? AND received_at BETWEEN ? AND ?
        AND decision = 'submitted'
      ORDER BY received_at ASC
    `).all(account, start, end) as LiveSignal[];
  } finally { db.close(); }
}

async function postDiscord(content: string, color: 'green' | 'red' | 'yellow' | 'grey'): Promise<void> {
  const colors = { green: 0x22c55e, red: 0xef4444, yellow: 0xf59e0b, grey: 0x6b7280 };
  let url: string | null = null;
  try {
    url = fs.readFileSync(path.join(SECRETS, 'discord_bobatrades_webhook'), 'utf-8').trim();
  } catch { return; }
  if (!url) return;
  try {
    await fetch(url, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        content,
        embeds: [{ color: colors[color], description: content }],
      }),
    });
  } catch { /* best-effort */ }
}

async function reconcileAccount(account: string, date: string): Promise<AccountReport> {
  const signals = loadSignalsForDate(account, date);
  const after = `${date}T00:00:00Z`;
  const until = `${date}T23:59:59Z`;
  const orders = await fetchAlpacaOrders(account, after, until);

  const sigByKey = new Map<string, LiveSignal>();
  for (const s of signals) sigByKey.set(s.dedupe_key, s);

  const ordByCoid = new Map<string, AlpacaOrder>();
  for (const o of orders) {
    if (o.client_order_id) ordByCoid.set(o.client_order_id, o);
  }

  let matched = 0;
  const ghostSignals: AccountReport['ghost_signals'] = [];
  for (const s of signals) {
    // dedupe_key may have been truncated for SL child ('-sl' suffix); check exact match only
    if (ordByCoid.has(s.dedupe_key)) {
      matched++;
    } else {
      ghostSignals.push({
        dedupe_key: s.dedupe_key,
        symbol: s.symbol,
        action: s.action,
        received_at: s.received_at,
      });
    }
  }

  const orphanOrders: AccountReport['orphan_orders'] = [];
  for (const o of orders) {
    if (!o.client_order_id) {
      // No coid — definitely not ours
      orphanOrders.push({
        id: o.id, client_order_id: '', symbol: o.symbol,
        side: o.side, status: o.status,
      });
      continue;
    }
    // Strip our SL child suffix to compare against parent dedupe_key
    const parentCoid = o.client_order_id.replace(/-sl$/, '');
    if (!sigByKey.has(parentCoid) && !sigByKey.has(o.client_order_id)) {
      orphanOrders.push({
        id: o.id, client_order_id: o.client_order_id, symbol: o.symbol,
        side: o.side, status: o.status,
      });
    }
  }

  const matchRate = signals.length ? matched / signals.length : 1;
  const notes: string[] = [];
  if (matchRate < 0.95 && signals.length > 0) {
    notes.push(`match_rate ${(matchRate * 100).toFixed(1)}% < 95%`);
  }
  if (ghostSignals.length > 0) {
    notes.push(`${ghostSignals.length} ghost signal(s) — DB says submitted, no Alpaca order found`);
  }
  if (orphanOrders.length > 5) {
    notes.push(`${orphanOrders.length} orphan order(s) — Alpaca activity outside the webhook (other bots/manual)`);
  }

  return {
    account,
    signals_submitted: signals.length,
    alpaca_orders_total: orders.length,
    matched,
    ghost_signals: ghostSignals,
    orphan_orders: orphanOrders,
    match_rate: matchRate,
    notes,
  };
}

async function main() {
  const arg = process.argv[2];
  let date: string;
  if (arg && /^\d{4}-\d{2}-\d{2}$/.test(arg)) {
    date = arg;
  } else {
    const y = new Date(Date.now() - 86400 * 1000);
    date = y.toISOString().slice(0, 10);
  }
  console.log(`Reconciling ${date} UTC for accounts: ${ACCOUNTS.join(', ')}`);

  const reports: AccountReport[] = [];
  for (const acct of ACCOUNTS) {
    const r = await reconcileAccount(acct, date);
    reports.push(r);
    console.log(`\n[${acct}] submitted=${r.signals_submitted} alpaca_orders=${r.alpaca_orders_total} matched=${r.matched} match_rate=${(r.match_rate * 100).toFixed(1)}%`);
    if (r.notes.length) console.log(`  notes: ${r.notes.join('; ')}`);
    if (r.ghost_signals.length) console.log(`  ghost: ${r.ghost_signals.map(g => `${g.symbol}:${g.action}@${g.received_at}`).join(', ')}`);
  }

  fs.mkdirSync(REPORT_DIR, { recursive: true });
  const reportPath = path.join(REPORT_DIR, `${date}.json`);
  fs.writeFileSync(reportPath, JSON.stringify({
    date,
    generated_at: new Date().toISOString(),
    accounts: reports,
  }, null, 2));
  console.log(`\nReport: ${reportPath}`);

  // Discord summary
  const totalSig = reports.reduce((a, r) => a + r.signals_submitted, 0);
  const totalMatched = reports.reduce((a, r) => a + r.matched, 0);
  const totalGhosts = reports.reduce((a, r) => a + r.ghost_signals.length, 0);
  const anyDrift = reports.some(r => r.notes.length > 0);
  const color = anyDrift ? 'yellow' : 'green';
  const summary =
    `[RECON ${date}] sig=${totalSig} matched=${totalMatched} ghosts=${totalGhosts} ` +
    reports.map(r => `${r.account}:${(r.match_rate * 100).toFixed(0)}%`).join(' ');
  await postDiscord(summary, color);
}

main().catch(e => { console.error(e); process.exit(1); });
