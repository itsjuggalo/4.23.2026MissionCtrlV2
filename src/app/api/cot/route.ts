import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// CFTC COT via Socrata public API — free, no key
// Financial futures (ES, ZB, 6E, BTC) → gpe5-46if (asset_mgr fields)
// Commodity futures (GC, CL) → 72hh-3qpy (m_money fields)
const FINANCIAL_URL = 'https://publicreporting.cftc.gov/resource/gpe5-46if.json';
const COMMODITY_URL = 'https://publicreporting.cftc.gov/resource/72hh-3qpy.json';

type ContractDef = { name: string; code: string; dataset: 'financial' | 'commodity' };
const CONTRACTS: Record<string, ContractDef> = {
  ES:   { name: 'E-Mini S&P 500', code: '13874A', dataset: 'financial' },
  GC:   { name: 'Gold',           code: '088691', dataset: 'commodity' },
  CL:   { name: 'Crude Oil WTI',  code: '067651', dataset: 'commodity' },
  BTC:  { name: 'Bitcoin',        code: '133741', dataset: 'financial' },
  ZB:   { name: 'US T-Bonds',     code: '020601', dataset: 'financial' },
  '6E': { name: 'Euro FX',        code: '099741', dataset: 'financial' },
};

let _cache: { data: object; ts: number } | null = null;
const CACHE_TTL = 6 * 3600 * 1000; // 6h — COT publishes weekly on Tuesdays

async function fetchContract(code: string, dataset: 'financial' | 'commodity') {
  const base = dataset === 'financial' ? FINANCIAL_URL : COMMODITY_URL;
  const params = new URLSearchParams({
    '$where': `cftc_contract_market_code='${code}'`,
    '$order': 'report_date_as_yyyy_mm_dd DESC',
    '$limit': '1',
  });
  const url = `${base}?${params.toString()}`;
  const res = await fetch(url, { signal: AbortSignal.timeout(10000), cache: 'no-store' });
  if (!res.ok) throw new Error(`CFTC ${res.status}`);
  const rows = await res.json();
  if (!rows.length) return null;
  const r = rows[0];

  // Financial futures use asset_mgr/lev_money fields
  // Commodity futures use m_money fields (managed money = hedge funds)
  let longPos: number, shortPos: number, levLong: number, levShort: number;
  if (dataset === 'financial') {
    longPos  = parseInt(r.asset_mgr_positions_long  || '0');
    shortPos = parseInt(r.asset_mgr_positions_short || '0');
    levLong  = parseInt(r.lev_money_positions_long  || '0');
    levShort = parseInt(r.lev_money_positions_short || '0');
  } else {
    longPos  = parseInt(r.m_money_positions_long_all  || '0');
    shortPos = parseInt(r.m_money_positions_short_all || '0');
    levLong  = longPos;
    levShort = shortPos;
  }
  const net = longPos - shortPos;
  return {
    report_date: r.report_date_as_yyyy_mm_dd?.slice(0, 10),
    open_interest: parseInt(r.open_interest_all || '0'),
    asset_mgr: { long: longPos, short: shortPos, net },
    lev_money:  { long: levLong, short: levShort, net: levLong - levShort },
    change_oi: parseInt(r.change_in_open_interest_all || '0'),
    sentiment: net > 0 ? 'BULLISH' : 'BEARISH',
  };
}

export async function GET() {
  if (_cache && Date.now() - _cache.ts < CACHE_TTL) {
    return NextResponse.json({ ..._cache.data, cached: true });
  }

  try {
    const entries = await Promise.all(
      Object.entries(CONTRACTS).map(async ([sym, { name, code, dataset }]) => {
        try {
          const d = await fetchContract(code, dataset);
          return [sym, { name, ...d }];
        } catch {
          return [sym, { name, error: 'fetch failed' }];
        }
      })
    );
    const payload = {
      contracts: Object.fromEntries(entries),
      source: 'cftc-socrata',
      timestamp: new Date().toISOString(),
      cached: false,
    };
    _cache = { data: payload, ts: Date.now() };
    return NextResponse.json(payload);
  } catch (e: any) {
    if (_cache) return NextResponse.json({ ..._cache.data, cached: true, stale: true });
    return NextResponse.json({ error: e?.message }, { status: 500 });
  }
}
