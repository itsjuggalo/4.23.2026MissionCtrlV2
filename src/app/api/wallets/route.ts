import { NextResponse } from 'next/server';
import { cookies } from 'next/headers';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { execSync } from 'child_process';
import { proxyToServeftp } from '../../../lib/proxyToServeftp';

const SECRETS = join(process.env.HOME || '/home/itsju', '.openclaw/secrets');
const HL_STATE = join(process.env.HOME || '/home/itsju', 'go-trader/platforms/hyperliquid/state.json');

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
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

  // === 2. COINBASE (from saved CSV holdings, not the live API) ===
  try {
    const result = execSync(
      'PATH=/home/itsju/.local/bin:/usr/local/bin:/usr/bin:/bin /home/itsju/.local/bin/uv run /home/itsju/scripts/coinbase-from-csv.py',
      { timeout: 60000, encoding: 'utf-8' }
    );
    const cb = JSON.parse(result.trim());
    if (cb.error) {
      wallets.push({ name: 'Coinbase', type: 'Exchange (CSV)', badge: 'CSV', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: cb.error.slice(0, 100) });
    } else {
      const holdings = cb.holdings || [];
      const topNotes = holdings.filter((h: any) => h.value_usd > 1).slice(0, 6).map((h: any) => `${h.currency}: $${h.value_usd.toFixed(0)}`);
      const fundedCount = holdings.filter((h: any) => h.value_usd > 0.01).length;
      wallets.push({
        name: 'Coinbase',
        type: 'Exchange (CSV)',
        badge: 'CSV',
        balance: cb.total_usd || 0,
        cash: 0,
        buying_power: 0,
        status: 'live',
        positions: holdings.map((h: any) => ({
          symbol: h.currency,
          quantity: h.balance,
          price: h.price_usd,
          equity: h.value_usd,
          type: 'crypto',
        })),
        notes: `${fundedCount} assets · ${topNotes.join(' | ') || 'no holdings'}`,
        as_of: cb.as_of,
      });
    }
  } catch (e) {
    wallets.push({ name: 'Coinbase', type: 'Exchange (CSV)', badge: 'CSV', balance: 0, cash: 0, buying_power: 0, status: 'error', notes: String(e).slice(0, 100) });
  }

  // === 3. ROBINHOOD (split: stocks + crypto) ===
  try {
    const result = execSync(
      'PATH=/home/itsju/.local/bin:/usr/local/bin:/usr/bin:/bin /home/itsju/.local/bin/uv run /home/itsju/scripts/robinhood-full-portfolio.py',
      { timeout: 60000, encoding: 'utf-8' }
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
        positions: (rhData.stocks || []).map((s: any) => ({
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
        positions: (rhData.crypto || []).map((c: any) => ({
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
