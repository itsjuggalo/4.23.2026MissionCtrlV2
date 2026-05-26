#!/usr/bin/env -S npx tsx
/**
 * One-off backfill: for every live_signals row with decision='submitted' that
 * does NOT yet have a matching entry row in live_trades, look up the
 * alpaca_order_id from tv_webhook_log (joined on dedupe_key) and insert an
 * entry leg. SL legs are intentionally NOT backfilled — we'd need to fetch
 * Alpaca's order list to find the child stop_limit, and historical SLs may
 * have already filled or been cancelled.
 */
import Database from 'better-sqlite3';
import path from 'path';

const ROOT = path.resolve(__dirname, '..');
const liveDb = new Database(path.join(ROOT, 'data/live_trades.sqlite'));
const tvDb = new Database(path.join(ROOT, 'data/tv_webhook_log.sqlite'));

interface MissingRow {
  signal_id: number;
  dedupe_key: string;
  account: string;
  symbol: string;
  action: 'buy' | 'sell';
  quantity_requested: number;
  raw_payload: string;
}

const missing = liveDb.prepare(`
  SELECT s.id AS signal_id, s.dedupe_key, s.account, s.symbol, s.action,
         s.quantity_requested, s.raw_payload
  FROM live_signals s
  LEFT JOIN live_trades t
    ON t.signal_id = s.id AND t.leg IN ('entry','manual_close')
  WHERE s.decision = 'submitted' AND t.id IS NULL
  ORDER BY s.id ASC
`).all() as MissingRow[];

console.log(`Found ${missing.length} signal(s) without entry trade rows`);

const lookupOrder = tvDb.prepare(`
  SELECT alpaca_order_id, alpaca_status
  FROM tv_webhook_log
  WHERE dedupe_key = ? AND outcome = 'ok' AND alpaca_order_id IS NOT NULL
  ORDER BY received_at ASC LIMIT 1
`);

const insertTrade = liveDb.prepare(`
  INSERT INTO live_trades (
    signal_id, bracket_group_id, alpaca_order_id, alpaca_client_order_id,
    account, symbol, leg, side, order_type, submitted_at,
    quantity_requested, status, raw_response
  ) VALUES (
    @signal_id, @bracket_group_id, @alpaca_order_id, @alpaca_client_order_id,
    @account, @symbol, @leg, @side, @order_type, @submitted_at,
    @quantity_requested, @status, @raw_response
  )
`);

let inserted = 0;
let skipped = 0;
for (const m of missing) {
  const o = lookupOrder.get(m.dedupe_key) as { alpaca_order_id: string; alpaca_status: string | null } | undefined;
  if (!o) {
    console.log(`  skip signal_id=${m.signal_id} dk=${m.dedupe_key.slice(0,8)} — no matching webhook log row`);
    skipped++;
    continue;
  }
  let isExit = false;
  try {
    const p = JSON.parse(m.raw_payload) as { is_exit?: boolean };
    isExit = !!p.is_exit;
  } catch {}
  try {
    insertTrade.run({
      signal_id: m.signal_id,
      bracket_group_id: m.dedupe_key,
      alpaca_order_id: o.alpaca_order_id,
      alpaca_client_order_id: m.dedupe_key,
      account: m.account,
      symbol: m.symbol,
      leg: isExit ? 'manual_close' : 'entry',
      side: m.action,
      order_type: 'market',
      submitted_at: new Date().toISOString(),
      quantity_requested: m.quantity_requested,
      status: o.alpaca_status,
      raw_response: JSON.stringify({ backfilled: true, source: 'tv_webhook_log' }),
    });
    console.log(`  inserted signal_id=${m.signal_id} oid=${o.alpaca_order_id.slice(0,12)} leg=${isExit ? 'manual_close' : 'entry'}`);
    inserted++;
  } catch (e) {
    const msg = String(e);
    if (msg.includes('UNIQUE')) {
      console.log(`  dup signal_id=${m.signal_id} oid=${o.alpaca_order_id.slice(0,12)} — already in live_trades`);
      skipped++;
    } else {
      console.error(`  ERR signal_id=${m.signal_id}: ${msg.slice(0,200)}`);
    }
  }
}

console.log(`Done — inserted ${inserted}, skipped ${skipped}`);
