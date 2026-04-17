import { NextResponse } from 'next/server';
import { cookies } from 'next/headers';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { execSync } from 'child_process';
import * as jose from 'jose';

const SECRETS = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets');

export async function GET() {
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

  const wallets: any[] = [];

  // === 1. ALPACA PAPER ===
  try {
    const key = readFileSync(join(SECRETS, 'alpaca-key-id'), 'utf-8').trim();
    const secret = readFileSync(join(SECRETS, 'alpaca-secret'), 'utf-8').trim();
    const res = await fetch('https://paper-api.alpaca.markets/v2/account', {
      headers: { 'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': secret },
    });
    if (res.ok) {
      const acct = await res.json();
      wallets.push({
        name: 'Alpaca Paper Trading',
        type: 'Brokerage (Paper)',
        badge: 'PAPER',
        balance: parseFloat(acct.equity || '0'),
        cash: parseFloat(acct.cash || '0'),
        buying_power: parseFloat(acct.buying_power || '0'),
        status: 'live',
        notes: 'Phase 1: $100K → $110K goal',
      });
    }
  } catch (e) {
    wallets.push({ name: 'Alpaca Paper Trading', type: 'Brokerage (Paper)', badge: 'PAPER', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: `Error: ${String(e).slice(0, 80)}` });
  }

  // === 2. COINBASE (JWT auth) ===
  try {
    const cbKeyPath = join(SECRETS, 'coinbase-api-key.txt');
    const cbPemPath = join(SECRETS, 'coinbase-private.pem');
    if (existsSync(cbKeyPath) && existsSync(cbPemPath)) {
      const apiKey = readFileSync(cbKeyPath, 'utf-8').trim();
      const pemRaw = readFileSync(cbPemPath, 'utf-8').trim();
      const uri = 'GET api.coinbase.com/api/v3/brokerage/accounts';
      const privateKey = await jose.importPKCS8(pemRaw, 'ES256');
      const now = Math.floor(Date.now() / 1000);
      const jwt = await new jose.SignJWT({ sub: apiKey, iss: 'cdp', uri })
        .setProtectedHeader({ alg: 'ES256', kid: apiKey, nonce: String(now), typ: 'JWT' })
        .setIssuedAt(now).setExpirationTime(now + 120).setNotBefore(now)
        .sign(privateKey);

      const cbRes = await fetch('https://api.coinbase.com/api/v3/brokerage/accounts', {
        headers: { Authorization: `Bearer ${jwt}` },
      });

      if (cbRes.ok) {
        const cbData = await cbRes.json();
        const accounts = cbData.accounts || [];
        let usdValue = 0;
        const holdings: string[] = [];

        for (const acct of accounts) {
          const bal = parseFloat(acct.available_balance?.value || '0');
          const hold = parseFloat(acct.hold?.value || '0');
          const total = bal + hold;
          if (total > 0.01) {
            const currency = acct.currency || 'USD';
            // Get USD price
            let price = 1;
            if (currency !== 'USD' && currency !== 'USDC' && currency !== 'USDT') {
              try {
                const pRes = await fetch(`https://api.coinbase.com/v2/prices/${currency}-USD/spot`);
                if (pRes.ok) { const pd = await pRes.json(); price = parseFloat(pd.data?.amount || '0'); }
              } catch {}
            }
            const valUsd = total * price;
            usdValue += valUsd;
            holdings.push(`${currency}: $${valUsd.toFixed(2)}`);
          }
        }

        wallets.push({
          name: 'Coinbase',
          type: 'Exchange (Live)',
          badge: 'LIVE',
          balance: usdValue,
          cash: 0,
          buying_power: 0,
          status: 'live',
          notes: holdings.slice(0, 5).join(' | ') || 'No holdings',
        });
      } else {
        wallets.push({ name: 'Coinbase', type: 'Exchange (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: `API ${cbRes.status}` });
      }
    }
  } catch (e) {
    wallets.push({ name: 'Coinbase', type: 'Exchange (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: `Error: ${String(e).slice(0, 80)}` });
  }

  // === 3. ROBINHOOD (call Python script) ===
  try {
    const rhKey = process.env.ROBINHOOD_API_KEY || '';
    if (rhKey) {
      const result = execSync(
        `ROBINHOOD_API_KEY="${rhKey}" python3 /home/ubuntu/scripts/robinhood-holdings.py`,
        { timeout: 15000, encoding: 'utf-8' }
      );
      const rhData = JSON.parse(result);
      if (rhData.error) {
        wallets.push({ name: 'Robinhood', type: 'Brokerage (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: rhData.error.slice(0, 80) });
      } else {
        const holdings = (rhData.results || []).map((h: any) =>
          `${h.asset_code}: ${parseFloat(h.total_quantity).toFixed(6)} ($${h.value_usd})`
        ).slice(0, 5).join(' | ');

        wallets.push({
          name: 'Robinhood',
          type: 'Brokerage (Live)',
          badge: 'LIVE',
          balance: rhData.total_usd || 0,
          cash: 0,
          buying_power: 0,
          status: 'live',
          notes: holdings || 'No holdings',
        });
      }
    }
  } catch (e) {
    wallets.push({ name: 'Robinhood', type: 'Brokerage (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: `Error: ${String(e).slice(0, 80)}` });
  }

  // === 4. HYPERLIQUID (not funded yet) ===
  wallets.push({
    name: 'Hyperliquid',
    type: 'DEX (Paper)',
    badge: 'PAPER',
    balance: 0,
    cash: 0,
    buying_power: 0,
    status: 'inactive',
    notes: 'Not yet funded — paper mode only',
  });

  return NextResponse.json(wallets);
}
