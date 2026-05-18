import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';

const SECRETS = '/home/ubuntu/.openclaw/secrets';

async function readSecret(name: string): Promise<string> {
  try {
    return (await readFile(`${SECRETS}/${name}`, 'utf-8')).trim();
  } catch {
    return '';
  }
}

async function fetchAccount(keyId: string, secret: string, accountTag: string) {
  if (!keyId || !secret) return null;
  try {
    const [acctRes, posRes] = await Promise.all([
      fetch('https://paper-api.alpaca.markets/v2/account', {
        headers: { 'APCA-API-KEY-ID': keyId, 'APCA-API-SECRET-KEY': secret },
      }),
      fetch('https://paper-api.alpaca.markets/v2/positions', {
        headers: { 'APCA-API-KEY-ID': keyId, 'APCA-API-SECRET-KEY': secret },
      }),
    ]);
    if (!acctRes.ok) return null;
    const acct = await acctRes.json();
    const positions = posRes.ok ? await posRes.json() : [];
    return {
      tag: accountTag,
      balance: parseFloat(acct.portfolio_value || '0'),
      equity: parseFloat(acct.equity || '0'),
      cash: parseFloat(acct.cash || '0'),
      buying_power: parseFloat(acct.buying_power || '0'),
      pl: parseFloat(acct.unrealized_pl || '0'),
      pl_pct: parseFloat(acct.unrealized_plpc || '0') * 100,
      day_pl: parseFloat(acct.equity) - parseFloat(acct.last_equity || acct.equity),
      day_pl_pct: ((parseFloat(acct.equity) - parseFloat(acct.last_equity || acct.equity)) / parseFloat(acct.last_equity || acct.equity) * 100),
      positions: Array.isArray(positions) ? positions.map((p: any) => ({ ...p, account: accountTag })) : [],
    };
  } catch {
    return null;
  }
}

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    // R2 — primary active account
    const r2KeyId = await readSecret('alpaca-key-id');
    const r2Secret = await readSecret('alpaca-secret');
    const r2 = await fetchAccount(r2KeyId, r2Secret, 'R2');

    // R1 — on hold, optional (only fetches if keys exist on disk)
    const r1KeyId = await readSecret('alpaca-r1-key-id');
    const r1Secret = await readSecret('alpaca-r1-secret');
    const r1 = await fetchAccount(r1KeyId, r1Secret, 'R1');

    // Merge positions from both, with badge per row via .account field
    const allPositions = [...(r1?.positions || []), ...(r2?.positions || [])];

    if (!r2 && !r1) return NextResponse.json({ balance: 0, error: 'No Alpaca credentials' });
    const primary = r2 || r1;
    return NextResponse.json({
      ...primary,
      positions: allPositions,
      accounts: { r1: r1 ? { balance: r1.balance, equity: r1.equity, positions: r1.positions.length } : null,
                  r2: r2 ? { balance: r2.balance, equity: r2.equity, positions: r2.positions.length } : null },
    });
  } catch (err: any) {
    return NextResponse.json({ balance: 0, error: err.message });
  }
}