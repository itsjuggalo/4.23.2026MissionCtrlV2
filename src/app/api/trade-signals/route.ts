import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const BASE = 'https://stock-signal-72772-default-rtdb.firebaseio.com';

let _cache: { data: any; ts: number } | null = null;
let _inflight: Promise<any> | null = null;
const CACHE_TTL = 10_000;

async function fetchJSON(path: string) {
  try {
    const r = await fetch(`${BASE}/${path}`, { cache: 'no-store', signal: AbortSignal.timeout(5000) });
    if (!r.ok) return null;
    return await r.json();
  } catch { return null; }
}

async function fetchTradeSignals() {
  const [
    nameShort, nameLong, nameStocks, nameClosed,
    name2Short, name2Long,
    vividShort, vividClosed,
    flowGreeks2Alerts, flowGreeks2Bulls
  ] = await Promise.all([
      fetchJSON('Name/ShortTermOptions.json'),
      fetchJSON('Name/LongTermOptions.json'),
      fetchJSON('Name/ShortTermStocks.json'),
      fetchJSON('Name/ClosedOptions.json?limitToLast=10&orderBy="$key"'),
      fetchJSON('Name2/ShortTermOptions.json'),
      fetchJSON('Name2/LongTermOptions.json'),
      fetchJSON('Vivid/ShortTermOptions.json'),
      fetchJSON('Vivid/ClosedOptions.json?limitToLast=5&orderBy="$key"'),
      fetchJSON('FlowGreeks2/Alerts/today.json'),
      fetchJSON('FlowGreeks2/BullBears.json'),
    ]);

    const toArr = (obj: any) => obj ? Object.entries(obj).map(([id, v]: any) => ({ id, ...v })) : [];

    return {
      name: {
        shortTerm: toArr(nameShort),
        longTerm: toArr(nameLong),
        stocks: toArr(nameStocks),
        recentClosed: toArr(nameClosed),
      },
      name2: {
        shortTerm: toArr(name2Short),
        longTerm: toArr(name2Long),
      },
      vivid: {
        shortTerm: toArr(vividShort),
        recentClosed: toArr(vividClosed),
      },
      flowGreeks2: {
        alerts: toArr(flowGreeks2Alerts),
        bullBears: flowGreeks2Bulls,
      },
      summary: {
        nameActiveCount: Object.keys(nameShort || {}).length + Object.keys(nameLong || {}).length,
        name2ActiveCount: Object.keys(name2Short || {}).length + Object.keys(name2Long || {}).length,
        vividActiveCount: Object.keys(vividShort || {}).length,
        totalActive: Object.keys(nameShort || {}).length + Object.keys(nameLong || {}).length + Object.keys(name2Short || {}).length + Object.keys(name2Long || {}).length + Object.keys(vividShort || {}).length,
      },
      sources: ['Name', 'Name2', 'Vivid', 'FlowGreeks2'],
      timestamp: new Date().toISOString(),
    };
}

export async function GET() {
  try {
    if (_cache && Date.now() - _cache.ts < CACHE_TTL) {
      return NextResponse.json(_cache.data);
    }

    if (!_inflight) {
      _inflight = fetchTradeSignals()
        .then(data => { _cache = { data, ts: Date.now() }; return data; })
        .finally(() => { _inflight = null; });
    }

    const data = await _inflight;
    return NextResponse.json(data);
  } catch (e: unknown) {
    if (_cache) return NextResponse.json({ ..._cache.data, stale: true });
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}
