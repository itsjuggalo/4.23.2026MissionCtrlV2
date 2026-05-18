import { NextRequest } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const SECRETS = join(process.env.HOME || '/home/ubuntu', '.openclaw/secrets');

async function getPortfolioData() {
  try {
    const key = readFileSync(join(SECRETS, 'alpaca-key-id'), 'utf-8').trim();
    const secret = readFileSync(join(SECRETS, 'alpaca-secret'), 'utf-8').trim();
    const res = await fetch('https://paper-api.alpaca.markets/v2/account', {
      headers: { 'APCA-API-KEY-ID': key, 'APCA-API-SECRET-KEY': secret },
    });
    if (res.ok) {
      const acct = await res.json();
      return { equity: parseFloat(acct.equity), cash: parseFloat(acct.cash), buying_power: parseFloat(acct.buying_power) };
    }
  } catch {}
  return null;
}

async function getCryptoPrices() {
  try {
    const res = await fetch('https://api.coinbase.com/v2/prices/BTC-USD/spot');
    const ethRes = await fetch('https://api.coinbase.com/v2/prices/ETH-USD/spot');
    const solRes = await fetch('https://api.coinbase.com/v2/prices/SOL-USD/spot');
    const btc = res.ok ? parseFloat((await res.json()).data.amount) : 0;
    const eth = ethRes.ok ? parseFloat((await ethRes.json()).data.amount) : 0;
    const sol = solRes.ok ? parseFloat((await solRes.json()).data.amount) : 0;
    return { btc, eth, sol };
  } catch { return { btc: 0, eth: 0, sol: 0 }; }
}

async function getLatestSignal() {
  try {
    const stateFile = join(process.env.HOME || '/home/ubuntu', 'mission-control/signal-receiver/data/latest_state.json');
    if (existsSync(stateFile)) {
      const state = JSON.parse(readFileSync(stateFile, 'utf-8'));
      const btc = state.BTCUSD || {};
      return {
        direction: btc.direction || 'NONE',
        last_action: btc.last_action || 'NONE',
        signal_time: btc.last_signal_time || null,
        signal_count: btc.signal_count || 0,
      };
    }
  } catch {}
  return null;
}

async function getRegime() {
  try {
    const regimeFile = join(process.env.HOME || '/home/ubuntu', 'mission-control/signal-receiver/data/market_regime.json');
    if (existsSync(regimeFile)) {
      const data = JSON.parse(readFileSync(regimeFile, 'utf-8'));
      return { regime: data.regime || data.current_regime || 'unknown' };
    }
  } catch {}
  return null;
}

export async function GET(req: NextRequest) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  const encoder = new TextEncoder();
  let closed = false;

  const stream = new ReadableStream({
    async start(controller) {
      const send = (event: string, data: any) => {
        if (closed) return;
        try {
          controller.enqueue(encoder.encode(`event: ${event}\ndata: ${JSON.stringify(data)}\n\n`));
        } catch {}
      };

      // Send initial heartbeat
      send('connected', { ts: Date.now(), msg: 'Live stream connected' });

      // Data push loop — every 10 seconds
      const push = async () => {
        if (closed) return;
        try {
          const [portfolio, crypto, signal, regime] = await Promise.all([
            getPortfolioData(),
            getCryptoPrices(),
            getLatestSignal(),
            getRegime(),
          ]);

          send('update', {
            ts: Date.now(),
            portfolio,
            crypto,
            signal,
            regime,
          });
        } catch {}
      };

      // Push immediately then every 10s
      await push();
      const interval = setInterval(push, 10000);

      // Heartbeat every 30s
      const heartbeat = setInterval(() => {
        if (closed) return;
        send('heartbeat', { ts: Date.now() });
      }, 30000);

      // Cleanup on close
      req.signal.addEventListener('abort', () => {
        closed = true;
        clearInterval(interval);
        clearInterval(heartbeat);
        try { controller.close(); } catch {}
      });
    },
  });

  return new Response(stream, {
    headers: {
      'Content-Type': 'text/event-stream',
      'Cache-Control': 'no-cache, no-transform',
      'Connection': 'keep-alive',
      'X-Accel-Buffering': 'no',
    },
  });
}