import { NextResponse } from 'next/server';
import { readFileSync } from 'fs';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

function getSecret(name: string): string {
  try {
    return readFileSync(`/home/itsju/.openclaw/secrets/${name}`, 'utf-8').trim();
  } catch { return ''; }
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  const url = new URL(req.url);
  const symbols = url.searchParams.get('symbols')?.split(',').filter(Boolean) || [];
  
  if (symbols.length === 0) {
    return NextResponse.json({ prices: {} });
  }

  const keyId = getSecret('alpaca-key-id');
  const secret = getSecret('alpaca-secret');
  const prices: Record<string, { price: number; change: number; changePct: number }> = {};

  // Split into stock and crypto tickers
  const cryptoTickers = symbols.filter(s => ['BTC', 'ETH', 'SOL', 'XRP', 'DOGE', 'ADA', 'AVAX', 'LINK', 'DOT', 'MATIC'].includes(s.toUpperCase()));
  const stockTickers = symbols.filter(s => !cryptoTickers.includes(s));

  // Fetch stock quotes from Alpaca (batch endpoint)
  if (stockTickers.length > 0 && keyId && secret) {
    try {
      // Alpaca latest quotes - batch up to 50 at a time
      const batches = [];
      for (let i = 0; i < stockTickers.length; i += 50) {
        batches.push(stockTickers.slice(i, i + 50));
      }
      
      for (const batch of batches) {
        const syms = batch.join(',');
        const res = await fetch(
          `https://data.alpaca.markets/v2/stocks/snapshots?symbols=${syms}`,
          {
            headers: {
              'APCA-API-KEY-ID': keyId,
              'APCA-API-SECRET-KEY': secret,
            },
            signal: AbortSignal.timeout(8000),
          }
        );
        
        if (res.ok) {
          const data = await res.json();
          type AlpacaSnap = { latestTrade?: { p?: number }; minuteBar?: { c?: number }; prevDailyBar?: { c?: number } };
          for (const [sym, snap] of Object.entries(data as Record<string, AlpacaSnap>)) {
            const latest = snap?.latestTrade?.p || snap?.minuteBar?.c || 0;
            const prevClose = snap?.prevDailyBar?.c || latest;
            const change = latest - prevClose;
            const changePct = prevClose > 0 ? (change / prevClose) * 100 : 0;
            prices[sym] = {
              price: latest,
              change: Math.round(change * 100) / 100,
              changePct: Math.round(changePct * 100) / 100,
            };
          }
        }
      }
    } catch (e) {
      console.error('[live-quotes] Alpaca error:', e);
    }
  }

  // Fetch crypto from Kraken
  if (cryptoTickers.length > 0) {
    try {
      for (const ticker of cryptoTickers) {
        const pair = ticker === 'BTC' ? 'XBTUSD' : `${ticker}USD`;
        const res = await fetch(
          `https://api.kraken.com/0/public/Ticker?pair=${pair}`,
          { signal: AbortSignal.timeout(5000) }
        );
        if (res.ok) {
          const data = await res.json();
          const key = Object.keys(data.result || {})[0];
          if (key && data.result[key]) {
            const info = data.result[key];
            const last = parseFloat(info.c?.[0] || '0');
            const open = parseFloat(info.o || '0');
            const change = last - open;
            const changePct = open > 0 ? (change / open) * 100 : 0;
            prices[ticker] = {
              price: last,
              change: Math.round(change * 100) / 100,
              changePct: Math.round(changePct * 100) / 100,
            };
          }
        }
      }
    } catch (e) {
      console.error('[live-quotes] Kraken error:', e);
    }
  }

  return NextResponse.json({ 
    prices, 
    count: Object.keys(prices).length,
    timestamp: new Date().toISOString() 
  });
}