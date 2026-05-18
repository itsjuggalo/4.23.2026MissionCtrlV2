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

async function alpaca(account: string) {
  const key = getSecret(`alpaca-${account}-key-id`);
  const sec = getSecret(`alpaca-${account}-secret`);
  if (!key || !sec) return { error: "no creds" };
  const base = "https://paper-api.alpaca.markets";
  const h = { "APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec };
  try {
    const today = new Date();
    const todayET = new Date(today.toLocaleString("en-US", { timeZone: "America/New_York" }));
    const since = `${todayET.getFullYear()}-${String(todayET.getMonth()+1).padStart(2,"0")}-${String(todayET.getDate()).padStart(2,"0")}T00:00:00-05:00`;
    const [acct, pos, orders] = await Promise.all([
      fetch(`${base}/v2/account`, { headers: h }).then(r=>r.json()),
      fetch(`${base}/v2/positions`, { headers: h }).then(r=>r.json()),
      fetch(`${base}/v2/orders?status=all&limit=20&direction=desc&after=${since}`, { headers: h }).then(r=>r.json()),
    ]);
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
  } catch (e: any) {
    return { error: e.message };
  }
}

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  const [boba, jazzy] = await Promise.all([alpaca("boba"), alpaca("jazzy")]);
  return NextResponse.json({
    timestamp: new Date().toISOString(),
    accounts: { boba, jazzy },
  });
}