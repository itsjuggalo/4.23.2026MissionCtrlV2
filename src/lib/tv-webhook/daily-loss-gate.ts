/**
 * Daily-loss circuit breaker. Blocks new webhook submissions when an account
 * has drawn down more than DAILY_LOSS_CAP_PCT from its start-of-UTC-day equity.
 * Baseline is captured on the first call of each UTC day per account, lazily.
 *
 * Per docs/strategy-risk-spec.md — 2% daily, 5% weekly, 10% monthly. This
 * implements the daily layer; weekly/monthly TBD.
 */
import fs from 'fs';
import path from 'path';

const SECRETS = path.join(process.env.HOME || '/home/itsju', '.openclaw/secrets');
const BASELINE_PATH = path.join(process.cwd(), 'data/daily_equity_baseline.json');
const PAPER_BASE = 'https://paper-api.alpaca.markets';

export const DAILY_LOSS_CAP_PCT = 0.02;  // -2% triggers gate

interface Baseline { date: string; equity: number; captured_at: string; }
interface Store { [account: string]: Baseline }

function utcDate(d: Date = new Date()): string {
  return d.toISOString().slice(0, 10);
}

function readStore(): Store {
  try {
    return JSON.parse(fs.readFileSync(BASELINE_PATH, 'utf-8'));
  } catch { return {}; }
}

function writeStore(s: Store): void {
  fs.mkdirSync(path.dirname(BASELINE_PATH), { recursive: true });
  fs.writeFileSync(BASELINE_PATH, JSON.stringify(s, null, 2));
}

function loadCreds(account: string): { keyId: string; secret: string } | null {
  try {
    return {
      keyId: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-key-id`), 'utf-8').trim(),
      secret: fs.readFileSync(path.join(SECRETS, `alpaca-${account}-secret`), 'utf-8').trim(),
    };
  } catch { return null; }
}

async function fetchEquity(account: string): Promise<number | null> {
  const creds = loadCreds(account);
  if (!creds) return null;
  try {
    const r = await fetch(`${PAPER_BASE}/v2/account`, {
      headers: { 'APCA-API-KEY-ID': creds.keyId, 'APCA-API-SECRET-KEY': creds.secret },
      signal: AbortSignal.timeout(8000),
    });
    if (!r.ok) return null;
    const j = await r.json() as { equity?: string; portfolio_value?: string };
    const eq = Number(j.equity ?? j.portfolio_value ?? 0);
    return Number.isFinite(eq) && eq > 0 ? eq : null;
  } catch { return null; }
}

export interface GateResult {
  blocked: boolean;
  reason?: string;
  baseline?: number;
  current?: number;
  drawdown_pct?: number;
  baseline_date?: string;
}

export async function checkDailyLossGate(account: string): Promise<GateResult> {
  const today = utcDate();
  const current = await fetchEquity(account);
  if (current === null) {
    // Fail open: if Alpaca is unreachable, don't block — the submit will fail anyway
    return { blocked: false, reason: 'equity_fetch_failed' };
  }

  const store = readStore();
  let baseline = store[account];
  if (!baseline || baseline.date !== today) {
    baseline = { date: today, equity: current, captured_at: new Date().toISOString() };
    store[account] = baseline;
    writeStore(store);
    return { blocked: false, baseline: current, current, drawdown_pct: 0, baseline_date: today };
  }

  const drawdown = (baseline.equity - current) / baseline.equity;
  if (drawdown > DAILY_LOSS_CAP_PCT) {
    return {
      blocked: true,
      reason: 'daily_loss_cap',
      baseline: baseline.equity,
      current,
      drawdown_pct: drawdown,
      baseline_date: baseline.date,
    };
  }
  return {
    blocked: false,
    baseline: baseline.equity,
    current,
    drawdown_pct: drawdown,
    baseline_date: baseline.date,
  };
}
