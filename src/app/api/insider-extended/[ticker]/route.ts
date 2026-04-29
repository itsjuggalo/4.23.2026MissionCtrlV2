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
        const idxUrl = `https://www.sec.gov/Archives/edgar/data/${parseInt(cik, 10)}/${accClean}/${f.accNum}-index.json`;
        const idx = await fetch(idxUrl, { headers: { 'User-Agent': SEC_UA } });
        if (!idx.ok) continue;
        const idxJ = await idx.json();
        const items = idxJ?.directory?.item || [];
        const xml = items.find((x: any) => x.name?.endsWith('.xml') && !x.name.includes('primary_doc'));
        const xmlName = xml?.name || items.find((x: any) => x.name?.endsWith('.xml'))?.name;
        if (!xmlName) continue;
        const xmlUrl = `https://www.sec.gov/Archives/edgar/data/${parseInt(cik, 10)}/${accClean}/${xmlName}`;
        const xmlRes = await fetch(xmlUrl, { headers: { 'User-Agent': SEC_UA } });
        if (!xmlRes.ok) continue;
        const xmlText = await xmlRes.text();
        const nameMatch = xmlText.match(/<rptOwnerName>([^<]+)<\/rptOwnerName>/);
        const titleMatch = xmlText.match(/<officerTitle>([^<]+)<\/officerTitle>/);
        const isDirector = /<isDirector>[\s1true]+<\/isDirector>/i.test(xmlText);
        const is10pct = /<isTenPercentOwner>[\s1true]+<\/isTenPercentOwner>/i.test(xmlText);
        const codeMatch = xmlText.match(/<transactionCode>([^<]+)<\/transactionCode>/);
        const sharesMatch = xmlText.match(/<transactionShares>[\s\S]*?<value>([\d.]+)<\/value>/);
        const priceMatch = xmlText.match(/<transactionPricePerShare>[\s\S]*?<value>([\d.]+)<\/value>/);
        const code = codeMatch?.[1]?.trim() || '?';
        const shares = parseFloat(sharesMatch?.[1] || '0');
        const price = parseFloat(priceMatch?.[1] || '0');
        const value = shares * price;
        const isBuy = code === 'P' || code === 'A' || code === 'M';
        const isSell = code === 'S' || code === 'D' || code === 'F';
        if (isBuy) net90d += value;
        else if (isSell) net90d -= value;
        const role = titleMatch?.[1] || (isDirector ? 'Director' : is10pct ? '10% Owner' : '');
        transactions.push({
          name: nameMatch?.[1] || 'Unknown',
          role,
          date: f.date,
          code,
          shares,
          price,
          value,
          type: isBuy ? 'BUY' : isSell ? 'SELL' : 'OTHER',
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

async function loadQuiverKey(): Promise<string> {
  try {
    const k = await fs.readFile(path.join(os.homedir(), '.openclaw/secrets/quiver_api_key'), 'utf-8');
    return k.trim();
  } catch {
    return '';
  }
}

async function fetchQuiverCongress(ticker: string): Promise<any> {
  const cached = await readCache(`quiver_${ticker}`);
  if (cached) return cached;
  const token = await loadQuiverKey();
  if (!token) return { count: 0, trades: [], source: 'quiver_no_key' };
  try {
    const res = await fetch(`https://api.quiverquant.com/beta/live/congresstrading/${ticker.toUpperCase()}`, {
      headers: { 'Authorization': `Bearer ${token}`, 'Accept': 'application/json' },
    });
    if (!res.ok) return { count: 0, trades: [], source: `quiver_http_${res.status}` };
    const j = await res.json();
    const arr = Array.isArray(j) ? j : (j.data || []);
    const ninetyDaysAgo = Date.now() - 90 * 86400000;
    const filtered = arr.filter((t: any) => {
      const d = new Date(t.TransactionDate || t.transactionDate || t.Date || t.date || 0).getTime();
      return d > ninetyDaysAgo;
    });
    const trades = filtered.map((t: any) => ({
      name: t.Representative || t.Senator || t.Name || t.name || 'Unknown',
      party: t.Party || t.party || '',
      chamber: t.House ? 'House' : t.Senate ? 'Senate' : (t.Chamber || ''),
      date: t.TransactionDate || t.Date || '',
      reported: t.ReportDate || t.reportDate || '',
      type: String(t.Transaction || t.type || '').toLowerCase().includes('purchase') ? 'BUY' : 'SELL',
      amount: t.Range || t.Amount || t.amount || '',
    })).sort((a: any, b: any) => new Date(b.date).getTime() - new Date(a.date).getTime()).slice(0, 10);
    const result = { count: trades.length, trades, source: 'quiver' };
    await writeCache(`quiver_${ticker}`, result);
    return result;
  } catch (e) {
    return { count: 0, trades: [], source: 'quiver_err', error: String(e) };
  }
}

export async function GET(_req: Request, { params }: { params: Promise<{ ticker: string }> }) {
  const { ticker } = await params;
  const tk = ticker.toUpperCase();
  const [insider, congress] = await Promise.all([fetchSecForm4(tk), fetchQuiverCongress(tk)]);
  return NextResponse.json({ ticker: tk, insider, congress });
}
