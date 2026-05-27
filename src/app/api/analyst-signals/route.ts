import { NextResponse } from 'next/server';
import fs from 'fs';
import { tickerLogoUrl } from '@/lib/tickerDomains';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const MERGED_PATH = '/home/itsju/mission-control-restored/Option-Signals-Scraper/data/analyst_signals_merged.json';

interface RawSignal {
  id: string;
  key: string;
  source: string;
  sourceGroup: 'name' | 'vivid';
  categoryNode: string;
  tab: 'scalps' | 'swings' | 'leaps';
  symbol: string;
  shortName: string;
  strike: string | number;
  expiry: number | null;
  isPut: boolean;
  isWeekly: boolean;
  isFree: boolean;
  risk: string;
  category: string;
  buyTarget: number | null;
  earlyTarget: number | null;
  stopLoss: number | null;
  reduceLoss: number | null;
  sellTarget: number | null;
  sellTarget2: number | null;
  sellTarget3: number | null;
  status: string;
  exitTime: number | null;
  isClosed: boolean;
  discordMessageId: string | null;
  discordThreadId: string | null;
  ts: number;
}

interface EnrichedSignal extends RawSignal {
  logoUrl: string | null;
  logoFallback: string;
  expiryStr: string;
  contractLabel: string;
  ribbonType: 'open' | 'profit' | 'stopped' | 'riding';
  ribbonLabel: string;
}

// Clearbit logo lookup by ticker → domain heuristic.
// For tickers we don't know the domain for, fall back to {ticker}.com which often works.
const TICKER_DOMAINS: Record<string, string> = {
  AAPL: 'apple.com', MSFT: 'microsoft.com', GOOG: 'google.com', GOOGL: 'google.com',
  AMZN: 'amazon.com', META: 'meta.com', TSLA: 'tesla.com', NVDA: 'nvidia.com',
  NFLX: 'netflix.com', AMD: 'amd.com', INTC: 'intel.com', ORCL: 'oracle.com',
  CRM: 'salesforce.com', ADBE: 'adobe.com', DIS: 'disney.com', UBER: 'uber.com',
  LYFT: 'lyft.com', F: 'ford.com', GM: 'gm.com', BA: 'boeing.com',
  JPM: 'jpmorgan.com', BAC: 'bankofamerica.com', GS: 'goldmansachs.com', WFC: 'wellsfargo.com',
  C: 'citigroup.com', V: 'visa.com', MA: 'mastercard.com', PYPL: 'paypal.com',
  COIN: 'coinbase.com', HOOD: 'robinhood.com', SQ: 'block.xyz',
  SPY: 'ssga.com', QQQ: 'invesco.com', IWM: 'ishares.com', DIA: 'ssga.com',
  XLF: 'ssga.com', XLE: 'ssga.com', XLK: 'ssga.com', GLD: 'ssga.com', SLV: 'ishares.com',
  TLT: 'ishares.com', VIX: 'cboe.com',
  MU: 'micron.com', LLY: 'lilly.com', UNH: 'unitedhealthgroup.com', AVGO: 'broadcom.com',
  ANET: 'arista.com', MRVL: 'marvell.com', SMH: 'vaneck.com', SOXX: 'ishares.com',
  CAR: 'avisbudgetgroup.com', LITE: 'lumentum.com', LULU: 'lululemon.com',
  NVO: 'novonordisk.com', BEN: 'franklintempleton.com', JD: 'jd.com',
  CRWV: 'coreweave.com', TSLA_: 'tesla.com',
};

function getLogoUrl(symbol: string): string | null {
  if (!symbol) return null;
  const domain = TICKER_DOMAINS[symbol.toUpperCase()];
  if (domain) return `https://logo.clearbit.com/${domain}`;
  // Heuristic fallback for unknown tickers
  return `https://logo.clearbit.com/${symbol.toLowerCase()}.com`;
}

function formatExpiry(ts: number | null): string {
  if (!ts) return '';
  const d = new Date(ts * 1000);
  // e.g. "1/15/27"
  const m = d.getUTCMonth() + 1;
  const day = d.getUTCDate();
  const y = String(d.getUTCFullYear()).slice(-2);
  return `${m}/${day}/${y}`;
}

function buildContractLabel(sig: RawSignal): string {
  const strike = String(sig.strike || '').replace(/\.?0+$/, '') || String(sig.strike);
  const cp = sig.isPut ? 'P' : 'C';
  const exp = formatExpiry(sig.expiry);
  return `${sig.symbol} ${strike}${cp} ${exp}`.trim();
}

function classifyRibbon(sig: RawSignal): { type: 'open' | 'profit' | 'stopped' | 'riding'; label: string } {
  if (!sig.isClosed) {
    // Still open — check status for "riding" hint
    const s = (sig.status || '').toLowerCase();
    if (s.includes('riding') || s.includes('booked profit')) return { type: 'riding', label: 'Riding' };
    return { type: 'open', label: 'Open' };
  }
  // Closed
  const s = (sig.status || '').toLowerCase();
  if (s.includes('stopped')) return { type: 'stopped', label: 'Stopped' };
  if (s.includes('booked full profit') || s.includes('full profits')) return { type: 'profit', label: 'Profit' };
  if (s.includes('profit')) return { type: 'profit', label: 'Profit' };
  return { type: 'stopped', label: 'Closed' };
}

function enrich(sig: RawSignal): EnrichedSignal {
  const ribbon = classifyRibbon(sig);
  return {
    ...sig,
    logoUrl: tickerLogoUrl(sig.symbol),
    logoFallback: (sig.symbol || '?').slice(0, 2).toUpperCase(),
    expiryStr: formatExpiry(sig.expiry),
    contractLabel: buildContractLabel(sig),
    ribbonType: ribbon.type,
    ribbonLabel: ribbon.label,
  };
}

function computeStats(open: EnrichedSignal[], closed: EnrichedSignal[]) {
  const thirtyDaysAgo = Date.now() / 1000 - 30 * 86400;
  const recentClosed = closed.filter(s => s.ts >= thirtyDaysAgo);

  const profitable = recentClosed.filter(s => {
    const st = (s.status || '').toLowerCase();
    return st.includes('booked') || st.includes('profit');
  });

  const winRate = recentClosed.length > 0
    ? Math.round((profitable.length / recentClosed.length) * 100)
    : 0;

  return {
    openTotal: open.length,
    closedTotal: closed.length,
    recentClosed: recentClosed.length,
    winRate30d: winRate,
    scalpsOpen: open.filter(s => s.tab === 'scalps').length,
    swingsOpen: open.filter(s => s.tab === 'swings').length,
    leapsOpen: open.filter(s => s.tab === 'leaps').length,
    sourceOpenCounts: {
      name: open.filter(s => s.sourceGroup === 'name').length,
      vivid: open.filter(s => s.sourceGroup === 'vivid').length,
    },
  };
}

export async function GET(request: Request) {
  try {
    const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
    let raw: string;
    if (fs.existsSync(MERGED_PATH)) {
      raw = fs.readFileSync(MERGED_PATH, 'utf-8');
    } else {
      const remoteUrl = process.env.MERGED_SIGNALS_URL || 'https://missionctrl.serveftp.com/raw/analyst-signals-merged';
      const resp = await fetch(remoteUrl, { cache: 'no-store', signal: AbortSignal.timeout(10000) });
      if (!resp.ok) {
        return NextResponse.json({
          error: 'Remote signals fetch failed: ' + resp.status,
          generated_at: null,
          open: [], closed: [], stats: null,
        }, { status: 200 });
      }
      raw = await resp.text();
    }
    const parsed = JSON.parse(raw);

    // Auto-close stale signals: anything with expiry in the past or no exitTime+old buy date
    const nowSec = Date.now() / 1000;
    const STALE_THRESHOLD_SEC = 60 * 86400;  // 60 days old with no exit = treat as closed
    const rawOpen: RawSignal[] = parsed.open || [];
    const rawClosed: RawSignal[] = parsed.closed || [];
    const movedToClosed: RawSignal[] = [];
    const stillOpen: RawSignal[] = [];
    for (const sig of rawOpen) {
      const expired = sig.expiry && sig.expiry < nowSec;
      const ancient = sig.ts && (nowSec - sig.ts) > STALE_THRESHOLD_SEC;
      if (expired || ancient) {
        movedToClosed.push({ ...sig, isClosed: true, status: sig.status || 'Expired (auto-closed)' });
      } else {
        stillOpen.push(sig);
      }
    }
    const openSignals: EnrichedSignal[] = stillOpen.map(enrich);
    const closedSignals: EnrichedSignal[] = [...movedToClosed, ...rawClosed].map(enrich);

    const stats = computeStats(openSignals, closedSignals);

    // Bucket by tab for convenience
    const byTab = {
      scalps: {
        open: openSignals.filter(s => s.tab === 'scalps'),
        closed: closedSignals.filter(s => s.tab === 'scalps').slice(0, 50),
      },
      swings: {
        open: openSignals.filter(s => s.tab === 'swings'),
        closed: closedSignals.filter(s => s.tab === 'swings').slice(0, 50),
      },
      leaps: {
        open: openSignals.filter(s => s.tab === 'leaps'),
        closed: closedSignals.filter(s => s.tab === 'leaps').slice(0, 50),
      },
    };

    return NextResponse.json({
      generated_at: parsed.generated_at,
      counts: parsed.counts,
      totals: parsed.totals,
      stats,
      byTab,
      // For debugging / full access
      openAll: openSignals,
      closedRecent: closedSignals.slice(0, 100),
    });
  } catch (err: any) {
    return NextResponse.json({
      error: err?.message || 'unknown error',
      open: [], closed: [], stats: null,
    }, { status: 500 });
  }
}