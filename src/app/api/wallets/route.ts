import { NextResponse } from 'next/server';
import { cookies } from 'next/headers';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { execSync } from 'child_process';
import * as jose from 'jose';

const SECRETS = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets');
const HL_STATE = join(process.env.HOME || '/home/ubuntu', 'go-trader/platforms/hyperliquid/state.json');

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
    wallets.push({ name: 'Alpaca Paper', type: 'Brokerage (Paper)', badge: 'PAPER', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 80) });
  }

  // === 2. COINBASE (JWT) ===
  try {
    const cbKeyPath = join(SECRETS, 'coinbase-api-key.txt');
    const cbPemPath = join(SECRETS, 'coinbase-private-pkcs8.pem');
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
          const bal = parseFloat(acct.available_balance?.value || '0') + parseFloat(acct.hold?.value || '0');
          if (bal > 0.01) {
            const cur = acct.currency || 'USD';
            let price = 1;
            if (!['USD','USDC','USDT'].includes(cur)) {
              try {
                const pRes = await fetch(`https://api.coinbase.com/v2/prices/${cur}-USD/spot`);
                if (pRes.ok) { const pd = await pRes.json(); price = parseFloat(pd.data?.amount || '0'); }
              } catch {}
            }
            const valUsd = bal * price;
            usdValue += valUsd;
            if (valUsd > 1) holdings.push(`${cur}: $${valUsd.toFixed(2)}`);
          }
        }
        wallets.push({ name: 'Coinbase', type: 'Exchange (Live)', badge: 'LIVE', balance: usdValue, cash: 0, buying_power: 0, status: 'live', notes: holdings. join(' | ') || 'No holdings' });
      } else {
        wallets.push({ name: 'Coinbase', type: 'Exchange (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: `API ${cbRes.status}` });
      }
    }
  } catch (e) {
    wallets.push({ name: 'Coinbase', type: 'Exchange (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 80) });
  }

  // === 3. ROBINHOOD (split: stocks + crypto) ===
  try {
    const result = execSync(
      'python3 /home/ubuntu/scripts/robinhood-full-portfolio.py',
      { timeout: 45000, encoding: 'utf-8' }
    );
    const rhData = JSON.parse(result.trim());
    if (rhData.error) {
      wallets.push({ name: 'Robinhood', type: 'Brokerage (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: rhData.error.slice(0, 80) });
    } else {
      // Stocks card
      wallets.push({
        name: 'Robinhood — Stocks',
        type: 'Brokerage (Live)',
        badge: 'LIVE',
        accent: 'cyan',
        balance: rhData.stock_total || 0,
        cash: rhData.cash || 0,
        buying_power: rhData.cash || 0,
        status: 'live',
        positions: (rhData.stocks || []).filter((s: any) => s.equity > 0.5).map((s: any) => ({
          symbol: s.symbol,
          quantity: s.quantity,
          avg_cost: s.avg_cost,
          price: s.price,
          equity: s.equity,
          pct_change: s.pct_change,
          type: 'stock',
        })),
        notes: `${(rhData.stocks || []).length} positions`,
      });
      // Crypto card
      wallets.push({
        name: 'Robinhood — Crypto',
        type: 'Brokerage (Live)',
        badge: 'LIVE',
        accent: 'purple',
        balance: rhData.crypto_total || 0,
        cash: 0,
        buying_power: 0,
        status: 'live',
        positions: (rhData.crypto || []).filter((c: any) => c.equity > 0.5).map((c: any) => ({
          symbol: c.symbol,
          quantity: c.quantity,
          price: c.price,
          equity: c.equity,
          type: 'crypto',
        })),
        notes: `${(rhData.crypto || []).filter((c: any) => c.equity > 0.5).length} assets`,
      });
    }
  } catch (e) {
    wallets.push({ name: 'Robinhood', type: 'Brokerage (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 80) });
  }

  // === 4. HYPERLIQUID (go-trader state file) ===
  try {
    if (existsSync(HL_STATE)) {
      const state = JSON.parse(readFileSync(HL_STATE, 'utf-8'));
      const strategies = state.strategies || {};

      // Get current prices for position valuation
      let btcPrice = 0, ethPrice = 0, solPrice = 0;
      try {
        const priceRes = await fetch('https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,solana&vs_currencies=usd', {
          headers: { 'User-Agent': 'MissionControl/1.0' },
        });
        if (priceRes.ok) {
          const prices = await priceRes.json();
          btcPrice = prices.bitcoin?.usd || 0;
          ethPrice = prices.ethereum?.usd || 0;
          solPrice = prices.solana?.usd || 0;
        }
      } catch {}

      const priceMap: Record<string, number> = { BTC: btcPrice, ETH: ethPrice, SOL: solPrice };

      let totalValue = 0;
      let totalCash = 0;
      let totalInitial = 0;
      let activeStrategies = 0;
      let openPositions = 0;
      const positionSummary: string[] = [];

      for (const [id, strat] of Object.entries(strategies) as any[]) {
        const cash = strat.cash || 0;
        const initial = strat.initial_capital || 500;
        totalCash += cash;
        totalInitial += initial;

        let posValue = 0;
        const positions = strat.positions || {};
        for (const [sym, pos] of Object.entries(positions) as any[]) {
          const qty = pos.quantity || 0;
          const price = priceMap[sym] || 0;
          posValue += qty * price;
          if (qty > 0) openPositions++;
        }

        const stratValue = cash + posValue;
        totalValue += stratValue;
        if (Object.keys(positions).length > 0) activeStrategies++;
      }

      const stratCount = Object.keys(strategies).length;
      const pnlPct = totalInitial > 0 ? ((totalValue - totalInitial) / totalInitial * 100) : 0;

      wallets.push({
        name: 'Hyperliquid (go-trader)',
        type: 'DEX Perps (Live)',
        badge: 'LIVE',
        balance: totalValue,
        cash: totalCash,
        buying_power: totalCash,
        status: 'live',
        notes: `${stratCount} strategies | ${activeStrategies} active | ${openPositions} positions | ${pnlPct >= 0 ? '+' : ''}${pnlPct.toFixed(1)}% P/L`,
      });
    }
  } catch (e) {
    wallets.push({ name: 'Hyperliquid', type: 'DEX Perps (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 80) });
  }


  // === 5. HYPERLIQUID PERSONAL WALLET (live API) ===
  try {
    const hlAddrPath = join(SECRETS, 'hyperliquid-address.txt');
    if (existsSync(hlAddrPath)) {
      const hlAddress = readFileSync(hlAddrPath, 'utf-8').trim();
      const hlRes = await fetch('https://api.hyperliquid.xyz/info', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ type: 'clearinghouseState', user: hlAddress }),
      });
      if (hlRes.ok) {
        const hlData = await hlRes.json();
        const marginSummary = hlData.marginSummary || {};
        const accountValue = parseFloat(marginSummary.accountValue || '0');
        const totalMargin = parseFloat(marginSummary.totalMarginUsed || '0');
        const positions = hlData.assetPositions || [];
        const posNotes = positions
          .map((p: any) => {
            const pos = p.position || {};
            const coin = pos.coin || '?';
            const size = pos.szi || '0';
            const upnl = parseFloat(pos.unrealizedPnl || '0');
            return `${coin}: ${size} (uPnL: $${upnl.toFixed(2)})`;
          })
          .slice(0, 5)
          .join(' | ');

        wallets.push({
          name: 'Hyperliquid (Personal)',
          type: 'DEX Perps (Live)',
          badge: 'LIVE',
          balance: accountValue,
          cash: accountValue - totalMargin,
          buying_power: accountValue - totalMargin,
          status: 'live',
          notes: positions.length > 0 ? posNotes : 'No open positions',
        });
      }
    }
  } catch (e) {
    wallets.push({ name: 'Hyperliquid (Personal)', type: 'DEX Perps (Live)', badge: 'LIVE', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 80) });
  }

  return NextResponse.json(wallets);
}
