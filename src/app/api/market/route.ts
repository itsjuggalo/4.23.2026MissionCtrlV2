import { NextResponse } from "next/server";
import { readFileSync } from "fs";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = "force-dynamic";
export const revalidate = 0;

function getSecret(name: string): string {
  const envKey = name.toUpperCase().replace(/-/g, "_");
  if (process.env[envKey]) return process.env[envKey]!.trim();
  try { return readFileSync(`/home/ubuntu/.openclaw/secrets/${name}`, "utf-8").trim(); }
  catch { return ""; }
}

async function fetchYahooQuote(symbol: string) {
  try {
    const r = await fetch(`https://query1.finance.yahoo.com/v8/finance/chart/${symbol}?interval=1d&range=5d`, {
      cache: "no-store",
      headers: { "User-Agent": "Mozilla/5.0" },
    });
    if (!r.ok) return null;
    const d = await r.json();
    const result = d?.chart?.result?.[0];
    if (!result) return null;
    const last = result.meta?.regularMarketPrice;
    const prev = result.meta?.previousClose || result.meta?.chartPreviousClose;
    if (!last || !prev) return null;
    return { value: last, chg: ((last - prev) / prev) * 100 };
  } catch { return null; }
}
async function fetchAlpacaQuote(symbol: string, key: string, sec: string) {
  if (!key || !sec) return null;
  try {
    const r = await fetch(`https://data.alpaca.markets/v2/stocks/${symbol}/snapshots`, {
      headers: { "APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec },
      cache: "no-store",
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
  const yh = await fetchYahooQuote(symbol);
  if (yh) return yh;
  return fetchAlpacaQuote(symbol, key, sec);
}

async function fetchBTC() {
  try {
    const r = await fetch("https://api.coinpaprika.com/v1/tickers/btc-bitcoin", { cache: "no-store" });
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
}