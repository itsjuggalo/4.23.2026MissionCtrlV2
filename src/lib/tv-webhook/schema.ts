// Hand-rolled validator — no zod dependency.
// Spec: docs/tv-webhook-spec.md §3

export interface TvAlert {
  source: 'tradingview' | 'alpaca-bot' | 'freqtrade';
  strategy: string;
  action: 'buy' | 'sell';
  symbol: string;
  price: number;
  quantity: number;
  stop_loss: number;
  take_profit: number;
  bar_time: string;
  comment?: string;
  account?: 'boba' | 'jazzy';
  discord?: { content?: string; embed?: unknown };
  alpaca?: {
    side?: string;
    order_class?: string;
    type?: string;
    time_in_force?: string;
    limit_price?: number;
  };
  dry_run?: boolean;
  // Position-close intent. When true, the price/sl/tp sanity check is skipped
  // (no meaningful tp/sl for an exit) and Alpaca-side handling cancels any
  // outstanding SL child before market-closing the position.
  is_exit?: boolean;
}

export type ValidationResult =
  | { ok: true; value: TvAlert }
  | { ok: false; reason: string; detail: string };

const STRATEGY_RE = /^[A-Za-z0-9_\-.]+$/;
const SYMBOL_RE = /^[A-Z0-9/]+$/;

function num(v: unknown): v is number {
  return typeof v === 'number' && Number.isFinite(v);
}

export function validateAlert(body: unknown): ValidationResult {
  if (!body || typeof body !== 'object') return { ok: false, reason: 'schema', detail: 'body must be an object' };
  const b = body as Record<string, unknown>;

  if (b.source !== 'tradingview' && b.source !== 'alpaca-bot' && b.source !== 'freqtrade') {
    return { ok: false, reason: 'schema', detail: 'source must be tradingview|alpaca-bot|freqtrade' };
  }

  const strategy = b.strategy;
  if (typeof strategy !== 'string' || strategy.length < 1 || strategy.length > 80 || !STRATEGY_RE.test(strategy))
    return { ok: false, reason: 'schema', detail: 'strategy invalid' };

  if (b.action !== 'buy' && b.action !== 'sell')
    return { ok: false, reason: 'schema', detail: 'action must be buy|sell' };

  const symbolRaw = b.symbol;
  if (typeof symbolRaw !== 'string' || symbolRaw.length < 1 || symbolRaw.length > 15)
    return { ok: false, reason: 'schema', detail: 'symbol length' };
  const symbol = symbolRaw.toUpperCase();
  if (!SYMBOL_RE.test(symbol))
    return { ok: false, reason: 'schema', detail: 'symbol charset' };

  if (!num(b.price) || (b.price as number) <= 0) return { ok: false, reason: 'schema', detail: 'price' };
  if (!num(b.quantity) || (b.quantity as number) <= 0) return { ok: false, reason: 'schema', detail: 'quantity' };
  if (!num(b.stop_loss) || (b.stop_loss as number) <= 0) return { ok: false, reason: 'schema', detail: 'stop_loss' };
  if (!num(b.take_profit) || (b.take_profit as number) <= 0) return { ok: false, reason: 'schema', detail: 'take_profit' };

  const price = b.price as number;
  const sl = b.stop_loss as number;
  const tp = b.take_profit as number;
  const isExit = b.is_exit === true;
  if (!isExit) {
    if (b.action === 'buy' && (sl >= price || tp <= price))
      return { ok: false, reason: 'schema', detail: 'buy requires stop_loss<price<take_profit' };
    if (b.action === 'sell' && (sl <= price || tp >= price))
      return { ok: false, reason: 'schema', detail: 'sell requires take_profit<price<stop_loss' };
  }

  if (typeof b.bar_time !== 'string') return { ok: false, reason: 'schema', detail: 'bar_time' };
  const barT = Date.parse(b.bar_time);
  if (!Number.isFinite(barT)) return { ok: false, reason: 'schema', detail: 'bar_time not ISO' };
  const skewMs = barT - Date.now();
  if (skewMs > 5 * 60 * 1000) return { ok: false, reason: 'schema', detail: 'bar_time >5min in future' };
  if (skewMs < -24 * 3600 * 1000) return { ok: false, reason: 'schema', detail: 'bar_time >24h old' };

  // Optional fields
  if (b.comment !== undefined && (typeof b.comment !== 'string' || b.comment.length > 200))
    return { ok: false, reason: 'schema', detail: 'comment' };
  if (b.account !== undefined && b.account !== 'boba' && b.account !== 'jazzy')
    return { ok: false, reason: 'schema', detail: 'account' };
  if (b.dry_run !== undefined && typeof b.dry_run !== 'boolean')
    return { ok: false, reason: 'schema', detail: 'dry_run' };
  if (b.is_exit !== undefined && typeof b.is_exit !== 'boolean')
    return { ok: false, reason: 'schema', detail: 'is_exit' };

  return {
    ok: true,
    value: {
      source: b.source as TvAlert['source'],
      strategy,
      action: b.action,
      symbol,
      price,
      quantity: b.quantity as number,
      stop_loss: sl,
      take_profit: tp,
      bar_time: b.bar_time,
      comment: b.comment as string | undefined,
      account: b.account as 'boba' | 'jazzy' | undefined,
      discord: b.discord as TvAlert['discord'],
      alpaca: b.alpaca as TvAlert['alpaca'],
      dry_run: b.dry_run as boolean | undefined,
      is_exit: isExit || undefined,
    },
  };
}
