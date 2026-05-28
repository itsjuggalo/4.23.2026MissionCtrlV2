import { NextResponse } from "next/server";
import { readFileSync } from "fs";
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const revalidate = 0;

// Stale-while-revalidate: serve last good value if Alpaca is unreachable (up to 5 min)
const _cache: Record<string, { value: unknown; ts: number }> = {};
const CACHE_TTL = 5 * 60 * 1000;

function getSecret(name: string): string {
  const envKey = name.toUpperCase().replace(/-/g, "_");
  if (process.env[envKey]) return process.env[envKey]!.trim();
  try { return readFileSync(`/home/itsju/.openclaw/secrets/${name}`, "utf-8").trim(); }
  catch { return ""; }
}

async function alpaca(account: string) {
  const key = getSecret(`alpaca-${account}-key-id`);
  const sec = getSecret(`alpaca-${account}-secret`);
  if (!key || !sec) return { error: "no creds" };
  const base = "https://paper-api.alpaca.markets";
  const h = { "APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec };
  const sig = () => AbortSignal.timeout(8000);
  try {
    const today = new Date();
    const todayET = new Date(today.toLocaleString("en-US", { timeZone: "America/New_York" }));
    const etTzAbbr = new Intl.DateTimeFormat("en-US", { timeZone: "America/New_York", timeZoneName: "short" })
      .formatToParts(today).find(p => p.type === "timeZoneName")?.value ?? "EST";
    const etOffset = etTzAbbr === "EDT" ? "-04:00" : "-05:00";
    const since = `${todayET.getFullYear()}-${String(todayET.getMonth()+1).padStart(2,"0")}-${String(todayET.getDate()).padStart(2,"0")}T00:00:00${etOffset}`;
    const [acctRes, posRes, ordersRes] = await Promise.all([
      fetch(`${base}/v2/account`, { headers: h, signal: sig() }),
      fetch(`${base}/v2/positions`, { headers: h, signal: sig() }),
      fetch(`${base}/v2/orders?status=all&limit=20&direction=desc&after=${since}`, { headers: h, signal: sig() }),
    ]);
    // Surface auth failures distinctly so auto-heal can skip Claude repair
    const authFail = [acctRes, posRes, ordersRes].find(r => r.status === 401 || r.status === 403);
    if (authFail) return { error: "auth_failed", code: authFail.status };
    const [acct, pos, orders] = await Promise.all([acctRes.json(), posRes.json(), ordersRes.json()]);
    if (acct && (acct.message || acct.code)) {
      return { error: `alpaca: ${acct.message || acct.code}` };
    }
    return {
      equity: parseFloat(acct.equity || "0"),
      cash: parseFloat(acct.cash || "0"),
      buying_power: parseFloat(acct.buying_power || "0"),
      positions: Array.isArray(pos) ? pos.map((p: any) => ({
        symbol: p.symbol, qty: p.qty,
        avg_entry: parseFloat(p.avg_entry_price),
        current: parseFloat(p.current_price),
        pnl: parseFloat(p.unrealized_pl),
        pnl_pct: parseFloat(p.unrealized_plpc) * 100,
      })) : [],
      orders_today: Array.isArray(orders) ? orders.length : 0,
      recent_orders: Array.isArray(orders) ? orders.slice(0, 8).map((o: any) => ({
        time: (o.submitted_at || "").substring(11, 19),
        side: o.side, symbol: o.symbol, qty: o.qty, status: o.status,
      })) : [],
    };
  } catch (e: unknown) {
    return { error: e instanceof Error ? e.message : String(e) };
  }
}

async function alpacaCached(account: string) {
  const result = await alpaca(account);
  if (!('error' in result)) {
    _cache[account] = { value: result, ts: Date.now() };
    return result;
  }
  // Auth failures and missing creds must surface — permanent config failures, not transient errors
  const err = (result as { error: string }).error;
  if (err === "auth_failed" || err === "no creds") return result;
  // For other transient errors (timeout, network) serve stale rather than breaking the UI
  const cached = _cache[account];
  if (cached && Date.now() - cached.ts < CACHE_TTL) {
    return { ...(cached.value as object), stale: true };
  }
  return result;
}

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  const [boba, jazzy] = await Promise.all([alpacaCached("boba"), alpacaCached("jazzy")]);
  return NextResponse.json({
    timestamp: new Date().toISOString(),
    accounts: { boba, jazzy },
  });
}