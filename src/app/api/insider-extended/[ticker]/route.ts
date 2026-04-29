import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';

export const dynamic = 'force-dynamic';

const FINNHUB_KEY = 'd70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0';
const CACHE_PATH = '/tmp/mc_insider_cache';
const CACHE_TTL_MS = 10 * 60 * 1000; // 10 min

async function readCache(key: string): Promise<any | null> {
  try {
    const raw = await fs.readFile(`${CACHE_PATH}_${key}.json`, 'utf-8');
    const j = JSON.parse(raw);
    if (Date.now() - j.ts < CACHE_TTL_MS) return j.data;
  } catch {}
  return null;
}

async function writeCache(key: string, data: any): Promise<void> {
  try {
    await fs.writeFile(`${CACHE_PATH}_${key}.json`, JSON.stringify({ ts: Date.now(), data }));
  } catch {}
}

async function fetchFinnhubInsider(ticker: string): Promise<any> {
  const cached = await readCache(`insider_${ticker}`);
  if (cached) return cached;
  try {
    const to = new Date();
    const from = new Date(Date.now() - 90 * 86400000);
    const fromStr = from.toISOString().slice(0, 10);
    const toStr = to.toISOString().slice(0, 10);
    const url = `https://finnhub.io/api/v1/stock/insider-transactions?symbol=${ticker}&from=${fromStr}&to=${toStr}&token=${FINNHUB_KEY}`;
    const res = await fetch(url, { next: { revalidate: 300 } });
    if (!res.ok) return { transactions: [], net90d: 0 };
    const j = await res.json();
    const txs = (j.data || []).slice(0, 25);
    let net90d = 0;
    for (const tx of txs) {
      const value = (tx.share || 0) * (tx.transactionPrice || 0);
      if (tx.transactionCode === 'P' || tx.transactionCode === 'A') net90d += value;
      else if (tx.transactionCode === 'S' || tx.transactionCode === 'D') net90d -= value;
    }
    const result = {
      transactions: txs.map((t: any) => ({
        name: t.name,
        share: t.share,
        change: t.change,
        price: t.transactionPrice,
        value: (t.share || 0) * (t.transactionPrice || 0),
        date: t.transactionDate,
        code: t.transactionCode,
        type: t.transactionCode === 'P' || t.transactionCode === 'A' ? 'BUY' : t.transactionCode === 'S' || t.transactionCode === 'D' ? 'SELL' : 'OTHER',
      })),
      net90d,
    };
    await writeCache(`insider_${ticker}`, result);
    return result;
  } catch (e) {
    return { transactions: [], net90d: 0, error: String(e) };
  }
}

async function fetchHouseTrades(ticker: string): Promise<any[]> {
  const cached = await readCache(`house_${ticker}`);
  if (cached) return cached;
  try {
    const url = `https://housestockwatcher.com/api/transactions/symbol/${ticker}`;
    const res = await fetch(url, { next: { revalidate: 600 } });
    if (!res.ok) return [];
    const j = await res.json();
    const txs = Array.isArray(j) ? j.slice(0, 15) : [];
    await writeCache(`house_${ticker}`, txs);
    return txs;
  } catch {
    return [];
  }
}

async function fetchSenateTrades(ticker: string): Promise<any[]> {
  const cached = await readCache(`senate_${ticker}`);
  if (cached) return cached;
  try {
    const url = `https://senatestockwatcher.com/api/v1/transactions/symbol/${ticker}`;
    const res = await fetch(url, { next: { revalidate: 600 } });
    if (!res.ok) return [];
    const j = await res.json();
    const txs = Array.isArray(j) ? j.slice(0, 15) : [];
    await writeCache(`senate_${ticker}`, txs);
    return txs;
  } catch {
    return [];
  }
}

export async function GET(_req: Request, { params }: { params: Promise<{ ticker: string }> }) {
  const { ticker } = await params;
  const tk = ticker.toUpperCase();
  const [insider, house, senate] = await Promise.all([
    fetchFinnhubInsider(tk),
    fetchHouseTrades(tk),
    fetchSenateTrades(tk),
  ]);
  const ninety = Date.now() - 90 * 86400000;
  const congressTxs = [
    ...house.map((t: any) => ({ ...t, chamber: 'House' })),
    ...senate.map((t: any) => ({ ...t, chamber: 'Senate' })),
  ]
    .filter((t: any) => {
      const d = new Date(t.transaction_date || t.date || 0).getTime();
      return d > ninety;
    })
    .sort((a: any, b: any) => new Date(b.transaction_date || b.date || 0).getTime() - new Date(a.transaction_date || a.date || 0).getTime())
    .slice(0, 10);
  return NextResponse.json({
    ticker: tk,
    insider,
    congress: {
      count: congressTxs.length,
      trades: congressTxs.map((t: any) => ({
        name: t.representative || t.senator || t.name || 'Unknown',
        party: t.party || '',
        chamber: t.chamber,
        date: t.transaction_date || t.date,
        type: (t.type || t.transaction_type || '').toLowerCase().includes('purchase') ? 'BUY' : 'SELL',
        amount: t.amount || t.range || '',
      })),
    },
  });
}
