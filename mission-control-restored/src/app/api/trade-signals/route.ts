import { NextResponse } from 'next/server';

const BASE = 'https://stock-signal-72772-default-rtdb.firebaseio.com';

async function fetchJSON(path: string) {
  try {
    const r = await fetch(`${BASE}/${path}`, { next: { revalidate: 30 } });
    if (!r.ok) return null;
    return r.json();
  } catch { return null; }
}

export async function GET() {
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

  return NextResponse.json({
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
  });
}
