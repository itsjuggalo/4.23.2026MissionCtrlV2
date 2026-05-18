import {NextResponse, NextRequest } from 'next/server';
import { readFileSync } from 'fs';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

function getSecret(name: string): string {
  // Prefer env var (Vercel); fall back to local filesystem (openclaw box)
  const envKey = name.toUpperCase().replace(/-/g, '_');
  if (process.env[envKey]) return process.env[envKey]!.trim();
  try { return readFileSync(`/home/ubuntu/.openclaw/secrets/${name}`, 'utf-8').trim(); }
  catch { return ''; }
}

// Cache to avoid hammering Tradier
let chainCache: { key: string; data: any; ts: number } = { key: '', data: null, ts: 0 };

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  const url = new URL(req.url);
  const symbol = (url.searchParams.get('symbol') || 'SPY').toUpperCase();
  const expiration = url.searchParams.get('expiration') || '';
  const greeks = url.searchParams.get('greeks') !== 'false';

  const token = getSecret('tradier-sandbox-key');
  if (!token) {
    return NextResponse.json({ error: 'Tradier API key not configured. Save key to ~/.openclaw/secrets/tradier-sandbox-key' }, { status: 500 });
  }

  const baseUrl = 'https://sandbox.tradier.com/v1/markets';

  // If no expiration, get expirations list first
  if (!expiration) {
    try {
      const expRes = await fetch(`${baseUrl}/options/expirations?symbol=${symbol}&includeAllRoots=true`, {
        headers: { 'Authorization': `Bearer ${token}`, 'Accept': 'application/json' },
        signal: AbortSignal.timeout(10000),
      });
      if (!expRes.ok) return NextResponse.json({ error: `Tradier error: ${expRes.status}` }, { status: expRes.status });
      const expData = await expRes.json();
      const expirations = expData?.expirations?.date || [];

      // Also get a quote for the underlying
      const quoteRes = await fetch(`${baseUrl}/quotes?symbols=${symbol}&greeks=false`, {
        headers: { 'Authorization': `Bearer ${token}`, 'Accept': 'application/json' },
        signal: AbortSignal.timeout(8000),
      });
      let quote = null;
      if (quoteRes.ok) {
        const qd = await quoteRes.json();
        const q = qd?.quotes?.quote;
        if (q) quote = Array.isArray(q) ? q[0] : q;
      }

      return NextResponse.json({ symbol, expirations, quote, chain: null });
    } catch (e: any) {
      return NextResponse.json({ error: e.message }, { status: 500 });
    }
  }

  // Check cache (30 second TTL)
  const cacheKey = `${symbol}-${expiration}`;
  if (chainCache.key === cacheKey && Date.now() - chainCache.ts < 30000) {
    return NextResponse.json(chainCache.data);
  }

  try {
    // Fetch chain + quote in parallel
    const [chainRes, quoteRes] = await Promise.all([
      fetch(`${baseUrl}/options/chains?symbol=${symbol}&expiration=${expiration}&greeks=${greeks}`, {
        headers: { 'Authorization': `Bearer ${token}`, 'Accept': 'application/json' },
        signal: AbortSignal.timeout(10000),
      }),
      fetch(`${baseUrl}/quotes?symbols=${symbol}&greeks=false`, {
        headers: { 'Authorization': `Bearer ${token}`, 'Accept': 'application/json' },
        signal: AbortSignal.timeout(8000),
      }),
    ]);

    if (!chainRes.ok) return NextResponse.json({ error: `Tradier chain error: ${chainRes.status}` }, { status: chainRes.status });

    const chainData = await chainRes.json();
    let quote = null;
    if (quoteRes.ok) {
      const qd = await quoteRes.json();
      const q = qd?.quotes?.quote;
      if (q) quote = Array.isArray(q) ? q[0] : q;
    }

    const options = chainData?.options?.option || [];

    // Split into calls and puts, organize by strike
    const calls: any[] = [];
    const puts: any[] = [];
    const strikes = new Set<number>();

    for (const opt of options) {
      strikes.add(opt.strike);
      if (opt.option_type === 'call') calls.push(opt);
      else puts.push(opt);
    }

    // Calculate max pain
    const strikeArr = Array.from(strikes).sort((a, b) => a - b);
    let maxPain = 0;
    let minPainValue = Infinity;

    for (const testStrike of strikeArr) {
      let totalPain = 0;
      for (const opt of options) {
        const oi = opt.open_interest || 0;
        if (oi === 0) continue;
        if (opt.option_type === 'call') {
          totalPain += Math.max(0, testStrike - opt.strike) * oi * 100;
        } else {
          totalPain += Math.max(0, opt.strike - testStrike) * oi * 100;
        }
      }
      if (totalPain < minPainValue) {
        minPainValue = totalPain;
        maxPain = testStrike;
      }
    }

    // Put/Call ratio
    const totalCallOI = calls.reduce((s, c) => s + (c.open_interest || 0), 0);
    const totalPutOI = puts.reduce((s, p) => s + (p.open_interest || 0), 0);
    const putCallRatio = totalCallOI > 0 ? (totalPutOI / totalCallOI).toFixed(2) : 'N/A';

    // Total volume
    const totalCallVol = calls.reduce((s, c) => s + (c.volume || 0), 0);
    const totalPutVol = puts.reduce((s, p) => s + (p.volume || 0), 0);

    const result = {
      symbol,
      expiration,
      quote,
      calls: calls.sort((a, b) => a.strike - b.strike),
      puts: puts.sort((a, b) => a.strike - b.strike),
      strikes: strikeArr,
      maxPain,
      putCallRatio,
      totalCallOI,
      totalPutOI,
      totalCallVol,
      totalPutVol,
      optionCount: options.length,
      timestamp: new Date().toISOString(),
    };

    // Cache it
    chainCache = { key: cacheKey, data: result, ts: Date.now() };

    return NextResponse.json(result);
  } catch (e: any) {
    return NextResponse.json({ error: e.message }, { status: 500 });
  }
}