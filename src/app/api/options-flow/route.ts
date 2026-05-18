import { NextResponse } from 'next/server';
import { tickerLogoUrl } from '@/lib/tickerDomains';
import fs from 'fs';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const DB = 'https://stock-signal-72772-default-rtdb.firebaseio.com';
const HISTORY_PATH = path.join(
  process.env.HOME || '/home/ubuntu',
  'mission-control-restored/Option-Signals-Scraper/data/flow_alerts_history.json'
);

function loadHistory(): Record<string, any> {
  try {
    if (!fs.existsSync(HISTORY_PATH)) return {};
    return JSON.parse(fs.readFileSync(HISTORY_PATH, 'utf8'));
  } catch {
    return {};
  }
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;

  try {
    const [flowRes, alerts1Res, alerts2Res] = await Promise.all([
      fetch(`${DB}/FlowGreeks/LiveFlowLast100.json`).then(r => r.json()).catch(() => null),
      fetch(`${DB}/FlowGreeks/Alerts/today.json`).then(r => r.json()).catch(() => null),
      fetch(`${DB}/FlowGreeks2/Alerts/today.json`).then(r => r.json()).catch(() => null),
    ]);

    const flows = flowRes
      ? (Array.isArray(flowRes) ? flowRes : Object.values(flowRes))
      : [];

    const extract = (raw: any) =>
      !raw ? [] : (Array.isArray(raw) ? raw : Object.values(raw))
        .map((a: any) => a?.alert || a)
        .filter((a: any) => a?.Symbol && a?.OptionSymbol);

    const merged = new Map<string, any>();
    for (const a of [...extract(alerts1Res), ...extract(alerts2Res)]) {
      const key = a.OptionSymbol;
      const existing = merged.get(key);
      if (!existing || (a.Updated || 0) > (existing.Updated || 0)) {
        merged.set(key, a);
      }
    }

    // Attach history data (first_price / last_price / max_price) to each alert
    const history = loadHistory();
    const alertsWithHistory = Array.from(merged.values()).map((a: any) => {
      const h = history[a.OptionSymbol];
      if (!h) return { ...a, logoUrl: tickerLogoUrl(a.Symbol) };
      const firstPrice = h.first_price;
      const lastPrice = h.last_price;
      const maxPrice = h.max_price;
      const gainPct = firstPrice > 0 ? ((lastPrice - firstPrice) / firstPrice) * 100 : 0;
      const maxGainPct = firstPrice > 0 ? ((maxPrice - firstPrice) / firstPrice) * 100 : 0;
      return {
        ...a,
        logoUrl: tickerLogoUrl(a.Symbol),
        _history: {
          firstPrice,
          lastPrice,
          maxPrice,
          gainPct: Math.round(gainPct * 100) / 100,
          maxGainPct: Math.round(maxGainPct * 100) / 100,
          numUpdates: h.num_updates,
          firstSeen: h.first_seen,
          lastSeen: h.last_seen,
        },
      };
    });

    return NextResponse.json({
      flows: flows.filter((f: any) => f?.Symbol).map((f: any) => ({ ...f, logoUrl: tickerLogoUrl(f.Symbol) })),
      alerts: alertsWithHistory,
      timestamp: new Date().toISOString(),
    });
  } catch (e) {
    return NextResponse.json({ flows: [], alerts: [], error: String(e).slice(0, 200) });
  }
}