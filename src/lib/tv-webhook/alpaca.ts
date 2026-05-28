import fs from 'fs';
import path from 'path';
import { isCrypto } from './crypto-allowlist';
import { insertTrade } from '@/lib/live-monitoring/db';
import type { TvAlert } from './schema';

const SECRETS = path.join(process.env.HOME || '/home/itsju', '.openclaw/secrets');

const PAPER_BASE = 'https://paper-api.alpaca.markets';
const LIVE_BASE = 'https://api.alpaca.markets';

interface Creds { keyId: string; secret: string; }

const credsCache = new Map<string, Creds>();

function loadCreds(account: string): Creds {
  const c = credsCache.get(account);
  if (c) return c;
  const keyPath = path.join(SECRETS, `alpaca-${account}-key-id`);
  const secPath = path.join(SECRETS, `alpaca-${account}-secret`);
  if (!fs.existsSync(keyPath) || !fs.existsSync(secPath)) {
    throw new Error(`Alpaca creds missing for account=${account}`);
  }
  const v: Creds = {
    keyId: fs.readFileSync(keyPath, 'utf-8').trim(),
    secret: fs.readFileSync(secPath, 'utf-8').trim(),
  };
  credsCache.set(account, v);
  return v;
}

function baseUrl(): string {
  if (process.env.TV_WEBHOOK_LIVE === 'true' && process.env.TV_WEBHOOK_LIVE_ACK === 'I_UNDERSTAND') {
    return LIVE_BASE;
  }
  return PAPER_BASE;
}

export interface AlpacaSubmitResult {
  ok: boolean;
  status: number;
  body: unknown;
  order_id?: string;
  order_status?: string;
  network_error?: string;
}

/**
 * Crypto-bracket emulation: poll the entry order until fill (or timeout),
 * then submit the TP + SL child orders. Fire-and-forget — runs after the
 * webhook response is already returned. Returns a list of child order IDs
 * (or empty if anything went sideways).
 */
export async function emulateCryptoOcoChildren(
  account: string, alert: TvAlert, parentOrderId: string, dedupeKey: string,
  signalId: number | null = null,
  pollMaxMs = 20_000,
): Promise<{ tp_order_id?: string; sl_order_id?: string; note?: string }> {
  // Debug trace — prod stderr goes to a socket we can't tail
  const dbg = (msg: string) => {
    try { require('fs').appendFileSync('/tmp/oco-debug.log', `[${new Date().toISOString()}] ${msg}\n`); } catch {}
  };
  dbg(`enter parent=${parentOrderId} account=${account} symbol=${alert.symbol} qty=${alert.quantity}`);
  const creds = loadCreds(account);
  const headers = {
    'APCA-API-KEY-ID': creds.keyId,
    'APCA-API-SECRET-KEY': creds.secret,
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  };

  // Poll for fill (paper fills are usually instant; cap at 20s)
  let filledQty: number | null = null;
  const deadline = Date.now() + pollMaxMs;
  let polls = 0;
  while (Date.now() < deadline) {
    polls++;
    try {
      const r = await fetch(`${baseUrl()}/v2/orders/${parentOrderId}`, { headers });
      if (r.ok) {
        const o = await r.json() as { status?: string; filled_qty?: string };
        dbg(`poll ${polls}: status=${o.status} filled_qty=${o.filled_qty}`);
        if (o.status === 'filled' || o.status === 'partially_filled') {
          filledQty = Number(o.filled_qty || 0);
          if (filledQty > 0) break;
        }
        if (o.status === 'canceled' || o.status === 'rejected' || o.status === 'expired') {
          dbg(`parent ${o.status}, skipping children`);
          return { note: `parent ${o.status}, skip children` };
        }
      } else {
        dbg(`poll ${polls}: http ${r.status}`);
      }
    } catch (e) {
      dbg(`poll ${polls} threw: ${String(e).slice(0, 200)}`);
    }
    await new Promise(r => setTimeout(r, 500));
  }
  if (!filledQty) {
    dbg(`gave up after ${polls} polls, filledQty=${filledQty}`);
    return { note: 'parent not filled within poll window, skip children' };
  }
  dbg(`filled qty=${filledQty}, placing children`);

  // Alpaca crypto can only have ONE outstanding exit order at a time because
  // each order reserves the full position balance. We prioritize the SL leg
  // (capital protection) and leave the take-profit to the Pine strategy's
  // natural SELL alert on ROI ladder / HTF break.
  //
  // ~0.25% fee gets taken out of the asset on a crypto buy, so the available
  // balance is slightly less than filled_qty — buffer by 0.5% to avoid an
  // "insufficient balance" reject.
  const sellQty = Math.floor(filledQty * 0.995 * 1e8) / 1e8;
  const exitSide = alert.action === 'buy' ? 'sell' : 'buy';
  // Crypto doesn't support plain `stop`; uses `stop_limit`. Set limit 0.5%
  // beyond the stop trigger so the engine has room to fill on a fast move.
  const slLimit = alert.action === 'buy'
    ? alert.stop_loss * 0.995    // selling on stop-down: limit BELOW stop
    : alert.stop_loss * 1.005;   // covering on stop-up: limit ABOVE stop
  const slBody = {
    symbol: alert.symbol,
    qty: String(sellQty),
    side: exitSide,
    type: 'stop_limit',
    time_in_force: 'gtc',
    stop_price: String(alert.stop_loss),
    limit_price: slLimit.toFixed(2),
    client_order_id: dedupeKey.slice(0, 28) + '-sl',
  };
  dbg(`SL child: qty=${sellQty} stop=${alert.stop_loss} limit=${slLimit.toFixed(2)}`);

  const out: { sl_order_id?: string; note?: string } = {};
  try {
    const r = await fetch(`${baseUrl()}/v2/orders`, { method: 'POST', headers, body: JSON.stringify(slBody) });
    const s = await r.json();
    if (r.ok) {
      const slId = (s as { id?: string; status?: string }).id;
      out.sl_order_id = slId;
      out.note = 'TP skipped — Alpaca crypto allows only one exit reservation; Pine handles TP via SELL alert';
      if (signalId != null && slId) {
        try {
          insertTrade({
            signal_id: signalId,
            bracket_group_id: dedupeKey,
            alpaca_order_id: slId,
            alpaca_client_order_id: slBody.client_order_id,
            account,
            symbol: alert.symbol,
            leg: 'sl',
            side: exitSide,
            order_type: 'stop_limit',
            quantity_requested: sellQty,
            limit_price: Number(slBody.limit_price),
            stop_price: Number(slBody.stop_price),
            status: (s as { status?: string }).status ?? 'accepted',
            raw_response: JSON.stringify(s),
          });
        } catch (e) {
          dbg(`SL trade insert failed: ${String(e).slice(0, 200)}`);
        }
      }
    } else {
      out.note = `sl_failed:${r.status}:${JSON.stringify(s).slice(0, 200)}`;
    }
  } catch (e) { out.note = `sl_threw:${String(e).slice(0, 100)}`; }

  return out;
}

/**
 * Crypto exit path. Cancels every open order for the symbol on this account
 * (typically the live SL stop_limit from the entry's OCO emulation) and then
 * submits a market order to close the position. Skips the OCO emulator since
 * an exit doesn't need protective children.
 */
async function submitCryptoExit(
  account: string, alert: TvAlert, dedupeKey: string,
): Promise<AlpacaSubmitResult> {
  const creds = loadCreds(account);
  const headers = {
    'APCA-API-KEY-ID': creds.keyId,
    'APCA-API-SECRET-KEY': creds.secret,
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  };

  // Cancel any open orders for this symbol so the close doesn't collide with
  // a residual SL stop_limit (Alpaca crypto reserves the position balance per
  // outstanding exit order).
  try {
    const listR = await fetch(`${baseUrl()}/v2/orders?status=open&symbols=${encodeURIComponent(alert.symbol)}&limit=50`, { headers });
    if (listR.ok) {
      const list = await listR.json() as Array<{ id: string; client_order_id?: string }>;
      await Promise.all(list.map(o =>
        fetch(`${baseUrl()}/v2/orders/${o.id}`, { method: 'DELETE', headers }).catch(() => {})
      ));
    }
  } catch { /* best-effort cancel */ }

  const body: Record<string, unknown> = {
    symbol: alert.symbol,
    qty: String(alert.quantity),
    side: alert.action,
    type: 'market',
    time_in_force: alert.alpaca?.time_in_force ?? 'gtc',
    client_order_id: dedupeKey,
  };

  try {
    const res = await fetch(`${baseUrl()}/v2/orders`, {
      method: 'POST', headers, body: JSON.stringify(body),
    });
    const text = await res.text();
    let parsed: unknown;
    try { parsed = JSON.parse(text); } catch { parsed = { raw: text }; }
    if (res.status === 422 && JSON.stringify(parsed).includes('client_order_id')) {
      return { ok: true, status: 200, body: parsed, order_status: 'dedup_at_alpaca' };
    }
    if (res.ok) {
      const p = parsed as { id?: string; status?: string };
      return { ok: true, status: res.status, body: parsed, order_id: p.id, order_status: p.status };
    }
    return { ok: false, status: res.status, body: parsed };
  } catch (e) {
    return { ok: false, status: 0, body: null, network_error: String(e) };
  }
}

export async function submitBracketOrAlt(account: string, alert: TvAlert, dedupeKey: string): Promise<AlpacaSubmitResult> {
  const creds = loadCreds(account);
  const headers = {
    'APCA-API-KEY-ID': creds.keyId,
    'APCA-API-SECRET-KEY': creds.secret,
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  };

  const isCryptoSym = isCrypto(alert.symbol);

  if (alert.is_exit && isCryptoSym) {
    return submitCryptoExit(account, alert, dedupeKey);
  }

  const tif = alert.alpaca?.time_in_force ?? (isCryptoSym ? 'gtc' : 'day');
  const orderType = alert.alpaca?.type ?? 'market';

  // Crypto: Alpaca paper doesn't support order_class=bracket for crypto.
  // Submit entry-only. After response is returned to the caller, fire-and-forget
  // a follow-up that polls for fill and submits TP + SL children (OCO-emulated).
  const body: Record<string, unknown> = isCryptoSym
    ? {
        symbol: alert.symbol,
        qty: String(alert.quantity),
        side: alert.action,
        type: orderType,
        time_in_force: tif,
        client_order_id: dedupeKey,
      }
    : {
        symbol: alert.symbol,
        qty: String(alert.quantity),
        side: alert.action,
        type: orderType,
        time_in_force: tif,
        order_class: 'bracket',
        take_profit: { limit_price: String(alert.take_profit) },
        stop_loss: { stop_price: String(alert.stop_loss) },
        client_order_id: dedupeKey,
      };
  if (alert.alpaca?.limit_price && orderType === 'limit') {
    body.limit_price = String(alert.alpaca.limit_price);
  }

  try {
    const res = await fetch(`${baseUrl()}/v2/orders`, {
      method: 'POST',
      headers,
      body: JSON.stringify(body),
    });
    let parsed: unknown;
    const text = await res.text();
    try { parsed = JSON.parse(text); } catch { parsed = { raw: text }; }

    // 422 with "client_order_id has already been taken" = dedupe success
    if (res.status === 422 && JSON.stringify(parsed).includes('client_order_id')) {
      return { ok: true, status: 200, body: parsed, order_status: 'dedup_at_alpaca' };
    }

    if (res.ok) {
      const p = parsed as { id?: string; status?: string };
      // OCO emulation is now spawned by the route (after live_trades entry row
      // is written, so the SL child can be tied to the same signal_id).
      return { ok: true, status: res.status, body: parsed, order_id: p.id, order_status: p.status };
    }
    return { ok: false, status: res.status, body: parsed };
  } catch (e) {
    return { ok: false, status: 0, body: null, network_error: String(e) };
  }
}
