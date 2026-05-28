import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// SEC EDGAR — free, no key. Rate limit: 10 req/sec.
// Docs: https://www.sec.gov/edgar/sec-api-documentation
const EDGAR_UA = 'MissionControl/1.0 itsjuggalo@gmail.com';
const EDGAR_HEADERS = { 'User-Agent': EDGAR_UA, Accept: 'application/json' };

async function getCik(ticker: string): Promise<string | null> {
  // EDGAR's ticker-to-CIK map
  const res = await fetch('https://www.sec.gov/files/company_tickers.json', {
    headers: EDGAR_HEADERS,
    signal: AbortSignal.timeout(8000),
    cache: 'no-store',
  });
  if (!res.ok) return null;
  const map: Record<string, { cik_str: number; ticker: string; title: string }> = await res.json();
  const upper = ticker.toUpperCase();
  const entry = Object.values(map).find(e => e.ticker === upper);
  if (!entry) return null;
  return String(entry.cik_str).padStart(10, '0');
}

async function getFilings(cik: string, type: string, count: number) {
  const res = await fetch(
    `https://data.sec.gov/submissions/CIK${cik}.json`,
    { headers: EDGAR_HEADERS, signal: AbortSignal.timeout(8000), cache: 'no-store' }
  );
  if (!res.ok) return [];
  const data = await res.json();
  const recent = data?.filings?.recent;
  if (!recent) return [];

  const { form, filingDate, accessionNumber, primaryDocument } = recent;
  const results: object[] = [];
  for (let i = 0; i < form.length && results.length < count; i++) {
    if (type === 'all' || form[i] === type || form[i].startsWith(type)) {
      const acc = (accessionNumber[i] as string).replace(/-/g, '');
      results.push({
        form: form[i],
        date: filingDate[i],
        accession: accessionNumber[i],
        url: `https://www.sec.gov/Archives/edgar/full-index/${filingDate[i].slice(0,4)}/${acc.slice(0,18)}/${primaryDocument[i]}`,
        viewer: `https://www.sec.gov/cgi-bin/browse-edgar?action=getcompany&CIK=${cik}&type=${encodeURIComponent(form[i])}&dateb=&owner=include&count=10`,
      });
    }
  }
  return results;
}

export async function GET(req: Request) {
  const url = new URL(req.url);
  const ticker = url.searchParams.get('ticker') || '';
  const type = url.searchParams.get('type') || '10-K';   // 10-K, 10-Q, 8-K, 4, 13F-HR, all
  const count = Math.min(parseInt(url.searchParams.get('count') || '10'), 40);

  if (!ticker) return NextResponse.json({ error: 'ticker required' }, { status: 400 });

  try {
    const cik = await getCik(ticker);
    if (!cik) return NextResponse.json({ error: `ticker ${ticker} not found in EDGAR` }, { status: 404 });

    const filings = await getFilings(cik, type, count);
    return NextResponse.json({
      ticker: ticker.toUpperCase(),
      cik,
      type,
      filings,
      source: 'sec-edgar',
      timestamp: new Date().toISOString(),
    });
  } catch (e: any) {
    return NextResponse.json({ error: e?.message || 'EDGAR fetch failed' }, { status: 500 });
  }
}
