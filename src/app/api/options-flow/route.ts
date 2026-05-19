import { NextResponse } from 'next/server';
import { tickerLogoUrl } from '@/lib/tickerDomains';
import fs from 'fs';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const DB = 'https://stock-signal-72772-default-rtdb.firebaseio.com';
const FLOW_API = process.env.FLOW_API_URL || 'http://127.0.0.1:8500';
const HISTORY_PATH = path.join(
  process.env.HOME || '/home/itsju',
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

// Option Flow tape for one ET day, pulled from flow.db via flow-api and
// reshaped into the FlowEntry shape the Options page expects.
async function flowsForDate(date: string): Promise<any[]> {
  try {
    const r = await fetch(
      `${FLOW_API}/flow_tape?date=${encodeURIComponent(date)}&limit=500`,
      { cache: 'no-store' },
    );
    if (!r.ok) return [];
    const rows = await r.json();
    if (!Array.isArray(rows)) return [];
    return rows.map((row: any) => ({
      Symbol: row.symbol,
      OptionSymbol: `${row.symbol}|${row.strike}|${row.option_type}|${row.expiry}|${row.event_time}`,
      Strike: row.strike,
      OptionType: row.option_type,
      ExpiryStr: row.expiry || '',
      Price: row.price,
      Value: row.premium,
      Volume: row.volume,
      OI: row.open_interest,
      BidAskType: row.bid_ask || '',
      BlockType: row.block_type || '',
      Time: row.event_time ? Math.floor(row.event_time / 1000) : 0,
      logoUrl: tickerLogoUrl(row.symbol),
    }));
  } catch {
    return [];
  }
}

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;

  // ?week=YYYY-MM-DD (Monday, ET) -> Mon-Fri tape from flow.db.
  // ?date=YYYY-MM-DD (ET)         -> single-day tape (kept for back-compat).
  // No week/date                  -> live last-100 from Firebase.
  const url = new URL(req.url);
  const date = url.searchParams.get('date');
  const week = url.searchParams.get('week');

  try {
    // Flow Alerts are always "today", live from Firebase.
    // availableDates: ET days that actually have flow.db data (for the picker).
    const [alerts1Res, alerts2Res, availableDates] = await Promise.all([
      fetch(`${DB}/FlowGreeks/Alerts/today.json`).then(r => r.json()).catch(() => null),
      fetch(`${DB}/FlowGreeks2/Alerts/today.json`).then(r => r.json()).catch(() => null),
      fetch(`${FLOW_API}/flow_dates`, { cache: 'no-store' })
        .then(r => r.ok ? r.json() : []).catch(() => []),
    ]);

    // Option Flow tape: flow.db when a week or date is requested, otherwise
    // the Firebase live last-100 feed.
    let flows: any[];
    if (week) {
      // Fan out to 5 weekdays starting at the requested Monday. Each
      // flow-api call is already capped at 500 rows; merge + sort desc.
      const days: string[] = [];
      const base = new Date(week + 'T12:00:00Z');
      for (let i = 0; i < 5; i++) {
        const d = new Date(base);
        d.setUTCDate(base.getUTCDate() + i);
        days.push(d.toISOString().slice(0, 10));
      }
      const perDay = await Promise.all(days.map(flowsForDate));
      flows = perDay.flat().sort((a, b) => (b.Time || 0) - (a.Time || 0));
    } else if (date) {
      flows = await flowsForDate(date);
    } else {
      const flowRes = await fetch(`${DB}/FlowGreeks/LiveFlowLast100.json`)
        .then(r => r.json()).catch(() => null);
      const rawFlows = flowRes
        ? (Array.isArray(flowRes) ? flowRes : Object.values(flowRes))
        : [];
      flows = rawFlows
        .filter((f: any) => f?.Symbol)
        .map((f: any) => ({ ...f, logoUrl: tickerLogoUrl(f.Symbol) }));
    }

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
      flows,
      alerts: alertsWithHistory,
      flowDate: date || null,
      availableDates,
      timestamp: new Date().toISOString(),
    });
  } catch (e) {
    return NextResponse.json({ flows: [], alerts: [], error: String(e).slice(0, 200) });
  }
}
