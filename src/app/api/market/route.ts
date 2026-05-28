import { NextResponse } from "next/server";
import { readFileSync } from "fs";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const revalidate = 0;

// In-process cache: serves last good value if all fetches fail
const _cache: Record<string, { value: number; chg: number; ts: number }> = {};

function getSecret(name: string): string {
  const envKey = name.toUpperCase().replace(/-/g, "_");
  if (process.env[envKey]) return process.env[envKey]!.trim();
  try { return readFileSync(`/home/itsju/.openclaw/secrets/${name}`, "utf-8").trim(); }
  catch { return ""; }
}

const YAHOO_HOSTS = ["query1.finance.yahoo.com", "query2.finance.yahoo.com"];

async function fetchYahooQuote(symbol: string) {
  const tryHost = async (host: string) => {
    try {
      const r = await fetch(
        `https://${host}/v8/finance/chart/${encodeURIComponent(symbol)}?interval=1d&range=5d`,
        { cache: "no-store", headers: { "User-Agent": "Mozilla/5.0" }, signal: AbortSignal.timeout(4000) }
      );
      if (!r.ok) return null;
      const d = await r.json();
      const result = d?.chart?.result?.[0];
      if (!result) return null;
      const last = result.meta?.regularMarketPrice;
      const prev = result.meta?.previousClose || result.meta?.chartPreviousClose;
      if (!last || !prev) return null;
      return { value: last, chg: ((last - prev) / prev) * 100 };
    } catch { return null; }
  };
  const results = await Promise.all(YAHOO_HOSTS.map(tryHost));
  return results.find(r => r !== null) ?? null;
}
async function fetchAlpacaQuote(symbol: string, key: string, sec: string) {
  if (!key || !sec) return null;
  try {
    const r = await fetch(`https://data.alpaca.markets/v2/stocks/${symbol}/snapshot`, {
      headers: { "APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec },
      cache: "no-store",
      signal: AbortSignal.timeout(5000),
    });
    if (!r.ok) return null;
    const d = await r.json();
    const last = d.latestTrade?.p || d.latestQuote?.bp || 0;
    const prev = d.prevDailyBar?.c || last;
    if (!last || !prev) return null;
    return { value: last, chg: ((last - prev) / prev) * 100 };
  } catch { return null; }
}
async function fetchQuote(symbol: string, key: string, sec: string) {
  // Run Yahoo and Alpaca in parallel; prefer Yahoo result
  const [yh, alp] = await Promise.all([fetchYahooQuote(symbol), fetchAlpacaQuote(symbol, key, sec)]);
  const result = yh ?? alp;
  if (result) { _cache[symbol] = { ...result, ts: Date.now() }; return result; }
  // Serve last good value (up to 4h stale) rather than null
  const cached = _cache[symbol];
  if (cached && Date.now() - cached.ts < 4 * 60 * 60 * 1000) return { value: cached.value, chg: cached.chg, stale: true };
  return null;
}

async function fetchBTC() {
  try {
    const r = await fetch("https://api.coinpaprika.com/v1/tickers/btc-bitcoin", { cache: "no-store", signal: AbortSignal.timeout(6000) });
    if (!r.ok) return null;
    const d = await r.json();
    return { value: d.quotes?.USD?.price || 0, chg: d.quotes?.USD?.percent_change_24h || 0 };
  } catch { return null; }
}

function isMarketOpen() {
  const et = new Date(new Date().toLocaleString("en-US", { timeZone: "America/New_York" }));
  const day = et.getDay();
  if (day === 0 || day === 6) return false;
  const m = et.getHours() * 60 + et.getMinutes();
  return m >= 570 && m < 960;
}

export async function GET(request: Request) {
  try {
    const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
    const key = getSecret("alpaca-boba-key-id");
    const sec = getSecret("alpaca-boba-secret");
    const [spy, qqq, vix, dxy, tnx, btc] = await Promise.all([
      fetchQuote("SPY", key, sec),
      fetchQuote("QQQ", key, sec),
      fetchQuote("^VIX", key, sec),
      fetchQuote("DX-Y.NYB", key, sec),
      fetchQuote("^TNX", key, sec),
      fetchBTC(),
    ]);
    return NextResponse.json({
      timestamp: new Date().toISOString(),
      spy, qqq, vix, dxy, tnx, btc,
      market_open: isMarketOpen(),
    });
  } catch (e: unknown) {
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}