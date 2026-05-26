/**
 * validate-exec-params.ts — per-subcommand typed allowlists for exec endpoints.
 *
 * Rules (R2.M1):
 * - show-config, hyperopt, trade, webserver are NOT in the allowlist.
 * - Reserved flags are constructed server-side only.
 * - Any value containing --, /, or shell metacharacters fails validation.
 */

const PAIR_REGEX = /^[A-Z0-9]{2,10}\/(USDT|USDC|USD|BTC|ETH)$/;
const STRATEGY_REGEX = /^[A-Za-z][A-Za-z0-9_]{0,63}$/;
const TIMERANGE_REGEX = /^\d{8}-\d{8}$/;
const TIMEFRAME_ENUM = ['5m', '15m', '1h', '4h', '1d'] as const;
const DAYS_MIN = 1;
const DAYS_MAX = 365;

// ITB pipeline scripts — must match the enum in the route
const ITB_SCRIPTS = [
  'download', 'merge', 'features', 'labels',
  'train', 'predict', 'predict_rolling', 'signals', 'simulate', 'output',
] as const;
export type ItbScript = typeof ITB_SCRIPTS[number];

// Freqtrade allowed subcommands — show-config, hyperopt, trade, webserver are excluded
const FT_ALLOWED_SUBCOMMANDS = [
  'backtesting', 'download-data', 'list-strategies', 'list-pairs', 'list-data',
  'list-exchanges', 'list-markets', 'list-timeframes', 'install-ui',
] as const;
export type FtSubcommand = typeof FT_ALLOWED_SUBCOMMANDS[number];

export interface ValidatedItbParams {
  script: ItbScript;
  config: string;
}

export interface ValidatedFtBacktestingParams {
  subcommand: 'backtesting';
  strategy: string;
  pair?: string;
  timerange?: string;
  timeframe?: typeof TIMEFRAME_ENUM[number];
}

export interface ValidatedFtDownloadDataParams {
  subcommand: 'download-data';
  pairs: string[];
  timeframes?: Array<typeof TIMEFRAME_ENUM[number]>;
  days?: number;
}

export interface ValidatedFtNoParams {
  subcommand: 'list-strategies' | 'list-pairs' | 'list-data' | 'list-exchanges' | 'list-markets' | 'list-timeframes' | 'install-ui';
}

export type ValidatedFtParams = ValidatedFtBacktestingParams | ValidatedFtDownloadDataParams | ValidatedFtNoParams;

function rejectDangerousValue(value: string, field: string): void {
  if (value.includes('--') || value.includes('/') || value.includes('\\') || /[;|&`$<>]/.test(value)) {
    throw new Error(`Validation failed: ${field} contains disallowed characters`);
  }
}

export function validateItbParams(body: Record<string, unknown>): ValidatedItbParams {
  const script = body.script as string;
  const config = body.config as string;

  if (!script || !ITB_SCRIPTS.includes(script as ItbScript)) {
    throw new Error(`Invalid script: must be one of ${ITB_SCRIPTS.join(', ')}`);
  }
  if (!config || !/^[\w.-]+\.jsonc?$/.test(config)) {
    throw new Error('Invalid config: must be a *.json or *.jsonc filename');
  }
  rejectDangerousValue(script, 'script');
  rejectDangerousValue(config, 'config');

  return { script: script as ItbScript, config };
}

export function validateFtParams(body: Record<string, unknown>): ValidatedFtParams {
  const subcommand = body.subcommand as string;

  if (!subcommand || !FT_ALLOWED_SUBCOMMANDS.includes(subcommand as FtSubcommand)) {
    throw new Error(`Invalid subcommand: must be one of ${FT_ALLOWED_SUBCOMMANDS.join(', ')}. Note: show-config, hyperopt, trade, and webserver are not permitted.`);
  }

  if (subcommand === 'backtesting') {
    const params = (body.params ?? {}) as Record<string, unknown>;
    const strategy = params.strategy as string | undefined;
    if (!strategy || !STRATEGY_REGEX.test(strategy)) {
      throw new Error('Invalid strategy: must match /^[A-Za-z][A-Za-z0-9_]{0,63}$/');
    }
    rejectDangerousValue(strategy, 'strategy');

    const pair = params.pair as string | undefined;
    if (pair !== undefined) {
      if (!PAIR_REGEX.test(pair)) {
        throw new Error(`Invalid pair: must match pattern like BTC/USDT. Got: ${pair}`);
      }
    }

    const timerange = params.timerange as string | undefined;
    if (timerange !== undefined && !TIMERANGE_REGEX.test(timerange)) {
      throw new Error('Invalid timerange: must be YYYYMMDD-YYYYMMDD');
    }

    const timeframe = params.timeframe as string | undefined;
    if (timeframe !== undefined && !TIMEFRAME_ENUM.includes(timeframe as typeof TIMEFRAME_ENUM[number])) {
      throw new Error(`Invalid timeframe: must be one of ${TIMEFRAME_ENUM.join(', ')}`);
    }

    return {
      subcommand: 'backtesting',
      strategy,
      pair,
      timerange,
      timeframe: timeframe as typeof TIMEFRAME_ENUM[number] | undefined,
    };
  }

  if (subcommand === 'download-data') {
    const params = (body.params ?? {}) as Record<string, unknown>;
    const pairs = params.pairs as unknown[] | undefined;
    if (!Array.isArray(pairs) || pairs.length === 0) {
      throw new Error('download-data requires pairs array');
    }
    const validatedPairs: string[] = [];
    for (const p of pairs) {
      if (typeof p !== 'string' || !PAIR_REGEX.test(p)) {
        throw new Error(`Invalid pair in pairs array: ${p}`);
      }
      validatedPairs.push(p);
    }

    const timeframes = params.timeframes as unknown[] | undefined;
    const validatedTimeframes: Array<typeof TIMEFRAME_ENUM[number]> = [];
    if (Array.isArray(timeframes)) {
      for (const tf of timeframes) {
        if (typeof tf !== 'string' || !TIMEFRAME_ENUM.includes(tf as typeof TIMEFRAME_ENUM[number])) {
          throw new Error(`Invalid timeframe: ${tf}`);
        }
        validatedTimeframes.push(tf as typeof TIMEFRAME_ENUM[number]);
      }
    }

    const days = params.days as number | undefined;
    if (days !== undefined) {
      if (!Number.isInteger(days) || days < DAYS_MIN || days > DAYS_MAX) {
        throw new Error(`Invalid days: must be integer ${DAYS_MIN}–${DAYS_MAX}`);
      }
    }

    return {
      subcommand: 'download-data',
      pairs: validatedPairs,
      timeframes: validatedTimeframes.length > 0 ? validatedTimeframes : undefined,
      days,
    };
  }

  // No-param subcommands
  return { subcommand: subcommand as ValidatedFtNoParams['subcommand'] };
}

/**
 * Re-validate pairs from bot_status (Backfill button path).
 * A compromised bot can't smuggle path-like values.
 */
export function validatePairsFromBotStatus(rawPairs: unknown[]): string[] {
  const valid: string[] = [];
  for (const p of rawPairs) {
    if (typeof p === 'string' && PAIR_REGEX.test(p)) {
      valid.push(p);
    }
  }
  return valid;
}
