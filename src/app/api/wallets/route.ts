import { NextResponse } from 'next/server';
import { cookies } from 'next/headers';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';

export async function GET() {
  // Check auth cookie — only if WALLET_PASSWORD is configured
  const walletPassword = process.env.WALLET_PASSWORD;
  if (walletPassword) {
    const cookieStore = await cookies();
    const auth = cookieStore.get('wallet_auth');
    if (!auth || auth.value !== '1') {
      return NextResponse.json(
        { error: 'Unauthorized — wallet access requires authentication' },
        { status: 401 }
      );
    }
  }

  try {
    // Read wallet data from secrets or config
    const walletsPath = join(
      process.env.HOME || '/home/ubuntu',
      '.openclaw/workspace/wallets.json'
    );

    if (existsSync(walletsPath)) {
      const data = JSON.parse(readFileSync(walletsPath, 'utf-8'));
      return NextResponse.json(data);
    }

    // Fallback: return Alpaca portfolio as wallet
    const keyPath = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets/alpaca-key-id');
    const secretPath = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets/alpaca-secret');

    if (existsSync(keyPath) && existsSync(secretPath)) {
      const key = readFileSync(keyPath, 'utf-8').trim();
      const secret = readFileSync(secretPath, 'utf-8').trim();

      const res = await fetch('https://paper-api.alpaca.markets/v2/account', {
        headers: {
          'APCA-API-KEY-ID': key,
          'APCA-API-SECRET-KEY': secret,
        },
      });

      if (res.ok) {
        const acct = await res.json();
        return NextResponse.json([
          {
            name: 'Alpaca Paper Trading',
            type: 'Brokerage',
            balance: parseFloat(acct.equity || '0'),
            cash: parseFloat(acct.cash || '0'),
            buying_power: parseFloat(acct.buying_power || '0'),
          },
        ]);
      }
    }

    return NextResponse.json([]);
  } catch (error) {
    return NextResponse.json(
      { error: 'Failed to load wallet data' },
      { status: 500 }
    );
  }
}
