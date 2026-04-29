import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import os from 'os';

export const dynamic = 'force-dynamic';

const CACHE_DIR = '/tmp/mc_insider_cache';
const CACHE_TTL_MS = 30 * 60 * 1000; // 30 min
const SEC_UA = 'MissionControl Trading Dashboard contact@itsjuggalo.com';

async function ensureCacheDir() {
  try { await fs.mkdir(CACHE_DIR, { recursive: true }); } catch {}
}
async function readCache(key: string): Promise<any | null> {
  try {
    const raw = await fs.readFile(path.join(CACHE_DIR, `${key}.json`), 'utf-8');
    const j = JSON.parse(raw);
    if (Date.now() - j.ts < CACHE_TTL_MS) return j.data;
  } catch {}
  return null;
}
async function writeCache(key: string, data: any): Promise<void> {
  try {
    await ensureCacheDir();
    await fs.writeFile(path.join(CACHE_DIR, `${key}.json`), JSON.stringify({ ts: Date.now(), data }));
  } catch {}
}

let TICKER_CIK_MAP: Record<string, string> | null = null;
async function loadTickerMap(): Promise<Record<string, string>> {
  if (TICKER_CIK_MAP) return TICKER_CIK_MAP;
  const cached = await readCache('ticker_cik_map');
  if (cached) { TICKER_CIK_MAP = cached; return cached; }
  try {
    const res = await fetch('https://www.sec.gov/files/company_tickers.json', {
      headers: { 'User-Agent': SEC_UA }
    });
    if (!res.ok) return {};
    const j = await res.json();
    const map: Record<string, string> = {};
    for (const k of Object.keys(j)) {
      const row = j[k];
      if (row?.ticker && row?.cik_str) {
        map[row.ticker.toUpperCase()] = String(row.cik_str).padStart(10, '0');
      }
    }
    TICKER_CIK_MAP = map;
    await writeCache('ticker_cik_map', map);
    return map;
  } catch {
    return {};
  }
}

async function fetchSecForm4(ticker: string): Promise<any> {
  const cached = await readCache(`sec_${ticker}`);
  if (cached) return cached;
  try {
    const map = await loadTickerMap();
    const cik = map[ticker.toUpperCase()];
    if (!cik) return { transactions: [], net90d: 0, count90d: 0, source: 'sec_no_cik' };
    const subRes = await fetch(`https://data.sec.gov/submissions/CIK${cik}.json`, {
      headers: { 'User-Agent': SEC_UA }
    });
    if (!subRes.ok) return { transactions: [], net90d: 0, count90d: 0, source: 'sec_sub_fail' };
    const subs = await subRes.json();
    const recent = subs?.filings?.recent || {};
    const forms: string[] = recent.form || [];
    const dates: string[] = recent.filingDate || [];
    const accNums: string[] = recent.accessionNumber || [];
    const ninetyDaysAgo = Date.now() - 90 * 86400000;
    const form4Filings: any[] = [];
    for (let i = 0; i < forms.length && form4Filings.length < 15; i++) {
      if (forms[i] !== '4') continue;
      const d = new Date(dates[i]).getTime();
      if (d < ninetyDaysAgo) break;
      form4Filings.push({ date: dates[i], accNum: accNums[i] });
    }
    let net90d = 0;
    const transactions: any[] = [];
    // Fetch first 8 most recent Form 4 details (don't hammer SEC)
    for (const f of form4Filings.slice(0, 8)) {
      try {
        const accClean = f.accNum.replace(/-/g, '');
        // Real Form 4 always lives at /form4.xml (not primary_doc.xml)
        // First try direct, fall back to looking up via index.json
        const dataDir = `https://www.sec.gov/Archives/edgar/data/${parseInt(cik, 10)}/${accClean}`;
        let xmlText = '';
        const directRes = await fetch(`${dataDir}/form4.xml`, { headers: { 'User-Agent': SEC_UA } });
        if (directRes.ok) {
          xmlText = await directRes.text();
        } else {
          // fallback: look up via index
          const idxRes = await fetch(`${dataDir}/index.json`, { headers: { 'User-Agent': SEC_UA } });
          if (!idxRes.ok) continue;
          const idxJ = await idxRes.json();
          const items = idxJ?.directory?.item || [];
          const xmlItem = items.find((x: any) => x.name?.endsWith('.xml'));
          if (!xmlItem?.name) continue;
          const fallbackRes = await fetch(`${dataDir}/${xmlItem.name}`, { headers: { 'User-Agent': SEC_UA } });
          if (!fallbackRes.ok) continue;
          xmlText = await fallbackRes.text();
        }
        if (!xmlText) continue;
        // Parse Form 4 fields. Each Form 4 has 1+ transactions; we extract the FIRST nonDerivativeTransaction
        // (most filings have just one). Multi-transaction filings get net contribution from primary tx.
        const nameMatch = xmlText.match(/<rptOwnerName>([^<]+)<\/rptOwnerName>/);
        const titleMatch = xmlText.match(/<officerTitle>([^<]+)<\/officerTitle>/);
        const isDirector = /<isDirector>\s*(?:true|1)\s*<\/isDirector>/i.test(xmlText);
        const is10pct = /<isTenPercentOwner>\s*(?:true|1)\s*<\/isTenPercentOwner>/i.test(xmlText);
        // Extract first nonDerivative transaction block, then parse its fields
        const txBlockMatch = xmlText.match(/<nonDerivativeTransaction>([\s\S]*?)<\/nonDerivativeTransaction>/);
        const txBlock = txBlockMatch?.[1] || xmlText; // fall back to whole doc if no nonDerivative
        const codeMatch = txBlock.match(/<transactionCode>([^<]+)<\/transactionCode>/);
        const sharesMatch = txBlock.match(/<transactionShares>\s*<value>([\d.,]+)<\/value>/);
        const priceMatch = txBlock.match(/<transactionPricePerShare>\s*<value>([\d.,]*)<\/value>/);
        const code = codeMatch?.[1]?.trim() || '?';
        const shares = parseFloat((sharesMatch?.[1] || '0').replace(/,/g, ''));
        const price = parseFloat((priceMatch?.[1] || '0').replace(/,/g, ''));
        const value = shares * price;
        // Code P = open-market PURCHASE (cash buy = bullish signal)
        // Code S = open-market SALE (cash sell = bearish signal)
        // Codes A/M/F/D = awards, exercises, vested grants - compensation, not signal
        const isOpenBuy = code === 'P';
        const isOpenSell = code === 'S';
        const isGrant = code === 'A' || code === 'M' || code === 'F' || code === 'D';
        if (isOpenBuy && value > 0) net90d += value;
        else if (isOpenSell && value > 0) net90d -= value;
        const txTypeLabel = isOpenBuy ? 'BUY' : isOpenSell ? 'SELL' : isGrant ? 'GRANT' : 'OTHER';
        const role = titleMatch?.[1] || (isDirector ? 'Director' : is10pct ? '10% Owner' : '');
        transactions.push({
          name: nameMatch?.[1] || 'Unknown',
          role,
          date: f.date,
          code,
          shares,
          price,
          value,
          type: txTypeLabel,
        });
      } catch {}
    }
    const result = {
      transactions,
      net90d,
      count90d: form4Filings.length,
      source: 'sec_edgar',
    };
    await writeCache(`sec_${ticker}`, result);
    return result;
  } catch (e) {
    return { transactions: [], net90d: 0, count90d: 0, source: 'sec_err', error: String(e) };
  }
}


// ============ CONGRESS DATA via Quiver /beta/live/congresstrading (FREE, no auth) ============
// Returns the full firehose (~1000 recent trades, ~430KB). We cache it server-side
// for 30 min and filter by ticker per request - one bulk download serves all symbols.
let CONGRESS_BULK_CACHE: { ts: number; data: any[] } | null = null;
async function loadCongressBulk(): Promise<any[]> {
  if (CONGRESS_BULK_CACHE && Date.now() - CONGRESS_BULK_CACHE.ts < CACHE_TTL_MS) {
    return CONGRESS_BULK_CACHE.data;
  }
  // Try disk cache
  const diskCached = await readCache('quiver_bulk');
  if (diskCached) {
    CONGRESS_BULK_CACHE = { ts: Date.now(), data: diskCached };
    return diskCached;
  }
  try {
    const res = await fetch('https://api.quiverquant.com/beta/live/congresstrading', {
      headers: { 'Accept': 'application/json', 'User-Agent': 'Mozilla/5.0' },
    });
    if (!res.ok) return [];
    const arr = await res.json();
    if (!Array.isArray(arr)) return [];
    CONGRESS_BULK_CACHE = { ts: Date.now(), data: arr };
    await writeCache('quiver_bulk', arr);
    return arr;
  } catch {
    return [];
  }
}

async function fetchCongressForTicker(ticker: string): Promise<any> {
  const all = await loadCongressBulk();
  const tk = ticker.toUpperCase();
  const ninetyDaysAgo = Date.now() - 90 * 86400000;
  const filtered = all.filter((t: any) => {
    if ((t.Ticker || '').toUpperCase() !== tk) return false;
    const d = new Date(t.TransactionDate || 0).getTime();
    return d > ninetyDaysAgo;
  });
  const trades = filtered.map((t: any) => ({
    name: t.Representative || 'Unknown',
    party: t.Party || '',
    chamber: t.House === 'Senate' ? 'Senate' : 'House',
    date: t.TransactionDate || '',
    reported: t.ReportDate || '',
    type: String(t.Transaction || '').toLowerCase().includes('purchase') ? 'BUY' :
          String(t.Transaction || '').toLowerCase().includes('sale') ? 'SELL' : 'OTHER',
    amount: t.Range || '',
    excessReturn: t.ExcessReturn != null ? Number(t.ExcessReturn) : null,
  })).sort((a: any, b: any) => new Date(b.date).getTime() - new Date(a.date).getTime());
  // Quick aggregate: net direction (buy count - sell count)
  let buyCount = 0, sellCount = 0;
  for (const t of trades) {
    if (t.type === 'BUY') buyCount++;
    else if (t.type === 'SELL') sellCount++;
  }
  return {
    count: trades.length,
    buyCount,
    sellCount,
    netDirection: buyCount - sellCount,
    trades: trades.slice(0, 10),
    source: 'quiver_bulk_free',
  };
}

export async function GET(_req: Request, { params }: { params: Promise<{ ticker: string }> }) {
  const { ticker } = await params;
  const tk = ticker.toUpperCase();
  const [insider, congress] = await Promise.all([
    fetchSecForm4(tk),
    fetchCongressForTicker(tk),
  ]);
  return NextResponse.json({ ticker: tk, insider, congress });
}
