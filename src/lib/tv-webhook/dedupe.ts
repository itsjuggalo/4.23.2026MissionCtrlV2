import crypto from 'crypto';
import { getTvDb } from './db';

export function dedupeKey(account: string, symbol: string, action: string, barTime: string, strategy: string): string {
  const h = crypto.createHash('sha256');
  h.update(`${account}|${symbol}|${action}|${barTime}|${strategy}`);
  return h.digest('hex').slice(0, 32);
}

/** Returns true if this dedupe key is new (inserted), false if it was already present. */
export function tryClaim(key: string, account: string, symbol: string): boolean {
  const stmt = getTvDb().prepare(
    `INSERT OR IGNORE INTO tv_dedupe (dedupe_key, created_at, account, symbol) VALUES (?, ?, ?, ?)`
  );
  const res = stmt.run(key, new Date().toISOString(), account, symbol);
  return res.changes === 1;
}
