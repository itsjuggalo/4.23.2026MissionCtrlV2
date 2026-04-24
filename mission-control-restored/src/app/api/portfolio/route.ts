import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';

export const dynamic = 'force-dynamic';

const SECRETS = '/home/ubuntu/.openclaw/secrets';

async function readSecret(name: string): Promise<string> {
  try {
    return (await readFile(`${SECRETS}/${name}`, 'utf-8')).trim();
  } catch {
    return '';
  }
}

export async function GET() {
  try {
    const keyId = await readSecret('alpaca-key-id');
    const secret = await readSecret('alpaca-secret');

    if (!keyId || !secret) {
      return NextResponse.json({ balance: 0, error: 'No Alpaca credentials' });
    }

    const res = await fetch('https://paper-api.alpaca.markets/v2/account', {
      headers: {
        'APCA-API-KEY-ID': keyId,
        'APCA-API-SECRET-KEY': secret,
      },
    });

    if (!res.ok) {
      return NextResponse.json({ balance: 0, error: `Alpaca: ${res.status}` });
    }

    const acct = await res.json();

    return NextResponse.json({
      balance: parseFloat(acct.portfolio_value || '0'),
      equity: parseFloat(acct.equity || '0'),
      cash: parseFloat(acct.cash || '0'),
      buying_power: parseFloat(acct.buying_power || '0'),
      pl: parseFloat(acct.unrealized_pl || '0'),
      pl_pct: parseFloat(acct.unrealized_plpc || '0') * 100,
      day_pl: parseFloat(acct.equity) - parseFloat(acct.last_equity || acct.equity),
      day_pl_pct: ((parseFloat(acct.equity) - parseFloat(acct.last_equity || acct.equity)) / parseFloat(acct.last_equity || acct.equity) * 100),
    });
  } catch (err: any) {
    return NextResponse.json({ balance: 0, error: err.message });
  }
}
