import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';

export const dynamic = 'force-dynamic';

let CACHE: { ts: number; data: any } | null = null;
let INFLIGHT: Promise<any> | null = null;
const TTL = 60_000;
const HISTORY_PATH = '/tmp/mc_macro_history.json';
const UA = 'Mozilla/5.0 (compatible; MissionControl/1.0)';

function timeoutSignal(ms: number): AbortSignal {
  const ctrl = new AbortController();
  const id = setTimeout(() => ctrl.abort(), ms);
  ctrl.signal.addEventListener('abort', () => clearTimeout(id), { once: true });
  return ctrl.signal;
}

async function fetchYahooQuote(symbol: string): Promise<{ price: number; change: number; pct: number } | null> {
  try {
    const url = `https://query1.finance.yahoo.com/v8/finance/chart/${encodeURIComponent(symbol)}?interval=1d&range=5d`;
    const res = await fetch(url, { headers: { 'User-Agent': UA, 'Accept': 'application/json' }, cache: 'no-store', signal: timeoutSignal(2500) });
    if (!res.ok) return null;
    const j = await res.json();
    const result = j?.chart?.result?.[0];
    if (!result) return null;
    const meta = result.meta || {};
    const price = Number(meta.regularMarketPrice ?? 0);
    const prev = Number(meta.chartPreviousClose ?? meta.previousClose ?? price);
    const change = price - prev;
    const pct = prev !== 0 ? (change / prev) * 100 : 0;
    if (!Number.isFinite(price) || price === 0) return null;
    return { price, change, pct };
  } catch { return null; }
}

async function fetchFearGreed(): Promise<any | null> {
  try {
    const res = await fetch('https://production.dataviz.cnn.io/index/fearandgreed/graphdata', {
      headers: { 'User-Agent': UA, 'Accept': 'application/json' },
      cache: 'no-store',
      signal: timeoutSignal(2500),
    });
    if (!res.ok) return null;
    const j = await res.json();
    const fg = j?.fear_and_greed;
    if (!fg) return null;
    return {
      value: Math.round(fg.score),
      label: String(fg.rating || '').toUpperCase(),
      previousClose: Math.round(fg.previous_close || 0),
      oneWeekAgo: Math.round(fg.previous_1_week || 0),
      oneMonthAgo: Math.round(fg.previous_1_month || 0),
      oneYearAgo: Math.round(fg.previous_1_year || 0),
    };
  } catch { return null; }
}

async function fetchSectorReturn(symbol: string, name: string): Promise<any | null> {
  try {
    const url = `https://query1.finance.yahoo.com/v8/finance/chart/${symbol}?interval=1d&range=2mo`;
    const res = await fetch(url, { headers: { 'User-Agent': UA, 'Accept': 'application/json' }, cache: 'no-store', signal: timeoutSignal(2500) });
    if (!res.ok) return null;
    const j = await res.json();
    const result = j?.chart?.result?.[0];
    if (!result) return null;
    const closes: number[] = (result?.indicators?.quote?.[0]?.close || []).filter((x: any) => Number.isFinite(x));
    if (closes.length < 21) return null;
    const last = closes[closes.length - 1];
    const fiveBack = closes[closes.length - 6] ?? last;
    const twentyBack = closes[closes.length - 21] ?? last;
    const r5 = ((last - fiveBack) / fiveBack) * 100;
    const r20 = ((last - twentyBack) / twentyBack) * 100;
    return { symbol, name, price: last, return5d: Math.round(r5 * 100) / 100, return20d: Math.round(r20 * 100) / 100 };
  } catch { return null; }
}

async function fetchSectorRotation(): Promise<any[]> {
  const sectors = [
    { sym: 'XLK', name: 'Technology' }, { sym: 'XLF', name: 'Financials' },
    { sym: 'XLE', name: 'Energy' }, { sym: 'XLY', name: 'Cons. Disc.' },
    { sym: 'XLP', name: 'Cons. Staples' }, { sym: 'XLV', name: 'Health Care' },
    { sym: 'XLI', name: 'Industrials' }, { sym: 'XLB', name: 'Materials' },
    { sym: 'XLU', name: 'Utilities' }, { sym: 'XLRE', name: 'Real Estate' },
    { sym: 'XLC', name: 'Comm. Svcs.' },
  ];
  const results = await Promise.all(sectors.map(s => fetchSectorReturn(s.sym, s.name)));
  return results.filter(Boolean).sort((a: any, b: any) => b.return5d - a.return5d);
}

function computeRiskStance(args: { vix: number | null; fg: number | null; yieldSpread: number | null }): { label: string; color: string; score: number } {
  const parts: number[] = [];
  if (args.vix != null) {
    if (args.vix < 15) parts.push(1);
    else if (args.vix < 20) parts.push(0.5);
    else if (args.vix < 25) parts.push(0);
    else if (args.vix < 30) parts.push(-0.5);
    else parts.push(-1);
  }
  if (args.fg != null) parts.push((args.fg - 50) / 50);
  if (args.yieldSpread != null) {
    if (args.yieldSpread > 0.5) parts.push(0.5);
    else if (args.yieldSpread > 0) parts.push(0.2);
    else if (args.yieldSpread > -0.5) parts.push(-0.5);
    else parts.push(-1);
  }
  const score = parts.length ? parts.reduce((a, b) => a + b, 0) / parts.length : 0;
  let label: string, color: string;
  if (score > 0.4) { label = 'RISK ON'; color = '#66bb6a'; }
  else if (score > 0.1) { label = 'MILD RISK ON'; color = '#9ccc65'; }
  else if (score > -0.1) { label = 'NEUTRAL'; color = '#607d8b'; }
  else if (score > -0.4) { label = 'CAUTIOUS'; color = '#ff9800'; }
  else { label = 'RISK OFF'; color = '#ef5350'; }
  return { label, color, score: Math.round(score * 100) / 100 };
}

function computePlaybook(stance: any, vix: number | null, fg: number | null): { edges: string[]; avoids: string[]; notes: string[] } {
  const label = stance.label;
  const edges: string[] = [];
  const avoids: string[] = [];
  const notes: string[] = [];

  if (label === 'RISK ON') {
    edges.push('Trend-following longs (breakouts, pullback entries)');
    edges.push('Momentum names (high RS, names making 52W highs)');
    edges.push('Cyclicals: XLF financials, XLI industrials, XLE energy');
    edges.push('Calls on strength — buy ITM/ATM calls into momentum');
    edges.push('High-beta single names with volume confirmation');
    avoids.push("Mean-reversion shorts — don't fade strength");
    avoids.push('Defensive longs (XLU/XLP) — they lag in risk-on');
    avoids.push('Naked puts on indexes — premium too low to bother');
    avoids.push('Heavy hedging — costs are high relative to drawdown risk');
    if (vix != null && vix < 13) notes.push('VIX <13: complacency zone. Reduce add-on size, watch for vol expansion.');
    if (fg != null && fg > 75) notes.push('F&G > 75: extreme greed. Sentiment-driven extension — trim into strength.');
  } else if (label === 'MILD RISK ON') {
    edges.push('Trend continuation in established leaders');
    edges.push('Sector rotation plays (rotate from leaders into laggards catching up)');
    edges.push('Selective breakouts with confirmed volume');
    edges.push('Vol selling on pullbacks (covered calls, cash-secured puts)');
    avoids.push('Contrarian shorts — trend is your friend');
    avoids.push('Fade-the-rip mentality — let winners run');
    avoids.push('All-in directional bets — pace yourself');
  } else if (label === 'NEUTRAL') {
    edges.push('Range trading — buy support, sell resistance');
    edges.push('Pair trades (long leader, short laggard)');
    edges.push('Sector rotation when momentum shifts');
    edges.push('Iron condors / strangles — collect range premium');
    avoids.push('Directional momentum chasing — no clear trend');
    avoids.push('Naked options — vol can cut both ways');
    avoids.push('Aggressive size — mixed signals = mixed conviction');
    notes.push("Cash is a position. Don't force trades.");
  } else if (label === 'CAUTIOUS') {
    edges.push('Defensive sectors: XLU utilities, XLP staples, XLV healthcare');
    edges.push('Short-term mean-reversion longs at oversold levels');
    edges.push('Vol selling on spikes (premium is rich)');
    edges.push('Protective puts on long positions');
    edges.push('Cash + short-term treasuries (BIL, SHV)');
    avoids.push('Trend-following longs — momentum is broken');
    avoids.push('Growth/cyclical longs — they get hit hardest');
    avoids.push('Complacent positioning — reduce gross exposure');
    avoids.push('Adding to losers — discipline > hope');
  } else {
    edges.push('Long puts on weakness (deep ITM index puts)');
    edges.push('Short cyclicals/high-beta on relief rallies');
    edges.push('Gold (GLD), long-duration treasuries (TLT) for flight-to-safety');
    edges.push('VIX calls / VIXY for tail hedge');
    edges.push('Cash: capital preservation > returns');
    avoids.push('Catching falling knives — wait for confirmation of bottom');
    avoids.push('All-in longs — fight the urge to "buy the dip"');
    avoids.push('Ignoring stop losses — discipline saves accounts');
    avoids.push('Selling vol — premium can explode on you');
    notes.push('Capital preservation mode. Edge is in NOT trading.');
  }

  if (vix != null && vix > 25) notes.push(`VIX ${vix.toFixed(1)}: elevated. Widen stops, reduce size, check correlation among holdings.`);
  if (vix != null && vix > 30) notes.push('VIX >30: panic zone. Historically a buy zone — but only with conviction and reduced size.');

  return { edges, avoids, notes };
}

function computeSizing(stance: any, vix: number | null): any {
  const label = stance.label;
  const baseR = 1.0;
  let regimeMult = 1.0, maxConcurrent = 5, optionsPct = 20;
  if (label === 'RISK ON') { regimeMult = 1.5; maxConcurrent = 8; optionsPct = 30; }
  else if (label === 'MILD RISK ON') { regimeMult = 1.2; maxConcurrent = 6; optionsPct = 25; }
  else if (label === 'NEUTRAL') { regimeMult = 1.0; maxConcurrent = 5; optionsPct = 20; }
  else if (label === 'CAUTIOUS') { regimeMult = 0.7; maxConcurrent = 4; optionsPct = 15; }
  else if (label === 'RISK OFF') { regimeMult = 0.4; maxConcurrent = 3; optionsPct = 10; }

  let vixMult = 1.0, vixNote = '';
  if (vix != null) {
    if (vix < 13) { vixMult = 0.85; vixNote = 'VIX<13 complacency penalty'; }
    else if (vix < 20) { vixMult = 1.0; vixNote = 'VIX in normal range'; }
    else if (vix < 25) { vixMult = 0.85; vixNote = 'VIX elevated'; }
    else if (vix < 30) { vixMult = 0.7; vixNote = 'VIX high'; }
    else { vixMult = 0.5; vixNote = 'VIX panic'; }
  }

  const finalR = Math.round(baseR * regimeMult * vixMult * 100) / 100;
  return {
    rPerTrade: finalR, rBaseline: baseR,
    regimeMultiplier: regimeMult, vixMultiplier: vixMult,
    maxConcurrent, optionsPct,
    reasoning: `${label} (${regimeMult}x) × ${vixNote} (${vixMult}x) = ${finalR}% per trade`,
  };
}

function generateVerdict(args: { stance: any; vix: any; fg: any; yields: any; sectors: any[]; history: any[] }): string {
  const { stance, vix, fg, yields, sectors, history } = args;
  const parts: string[] = [];
  parts.push(`**${stance.label}**`);
  if (vix?.level != null) {
    if (vix.pct < -3) parts.push(`Vol compressing (VIX ${vix.level.toFixed(1)}, ${vix.pct.toFixed(1)}%)`);
    else if (vix.pct > 3) parts.push(`Vol expanding (VIX ${vix.level.toFixed(1)}, +${vix.pct.toFixed(1)}%)`);
    else parts.push(`VIX ${vix.level.toFixed(1)}`);
  }
  if (fg?.label) parts.push(`sentiment ${fg.label.toLowerCase()}`);
  if (yields?.spread != null) {
    if (yields.spread < 0) parts.push('curve INVERTED (recession warning)');
    else if (yields.spread < 0.3) parts.push('curve flat');
    else parts.push('curve normal');
  }
  if (sectors && sectors.length > 0) {
    const leader = sectors[0];
    const laggard = sectors[sectors.length - 1];
    parts.push(`${leader.symbol} leading (+${leader.return5d.toFixed(1)}% 5d), ${laggard.symbol} lagging (${laggard.return5d.toFixed(1)}% 5d)`);
  }
  if (history && history.length >= 2) {
    let lastChange = -1;
    for (let i = history.length - 2; i >= 0; i--) {
      if (history[i].stance !== stance.label) { lastChange = (history.length - 1) - i; break; }
    }
    if (lastChange === -1) parts.push(`stable for ${history.length} days`);
    else if (lastChange === 1) parts.push('regime changed today — high reversal risk');
    else if (lastChange < 5) parts.push(`${lastChange} days into new regime — early innings`);
    else if (lastChange < 14) parts.push(`${lastChange} days into regime — settled`);
    else parts.push(`${lastChange} days into regime — mature, watch for reversion`);
  }
  return parts.join('. ') + '.';
}

function formatETDate(d: Date): string {
  return new Intl.DateTimeFormat('en-CA', { timeZone: 'America/New_York', year: 'numeric', month: '2-digit', day: '2-digit' }).format(d);
}

async function loadHistory(): Promise<any[]> {
  try {
    const raw = await fs.readFile(HISTORY_PATH, 'utf-8');
    const arr = JSON.parse(raw);
    return Array.isArray(arr) ? arr : [];
  } catch { return []; }
}

async function _saveHistorySnapshot(snapshot: any): Promise<any[]> {
  try {
    const history = await loadHistory();
    const today = formatETDate(new Date());
    const idx = history.findIndex(h => h.date === today);
    const entry = { date: today, ...snapshot };
    if (idx >= 0) history[idx] = entry;
    else history.push(entry);
    const trimmed = history.slice(-30);
    await fs.writeFile(HISTORY_PATH, JSON.stringify(trimmed));
    return trimmed;
  } catch { return []; }
}

async function computeMacroRegime() {
  const hardDeadline = new Promise<never>((_, reject) =>
    setTimeout(() => reject(new Error('macro-regime hard timeout')), 5000)
  );

  // Load history and external data in parallel
  const [[fg, vixQ, tnxQ, irxQ, sectors], existingHistory] = await Promise.all([
    Promise.race([
      Promise.all([
        fetchFearGreed(),
        fetchYahooQuote('^VIX'),
        fetchYahooQuote('^TNX'),
        fetchYahooQuote('^IRX'),
        fetchSectorRotation(),
      ]),
      hardDeadline,
    ]),
    loadHistory(),
  ]);

  const tenY = tnxQ ? Math.round(tnxQ.price * 100) / 100 : null;
  const twoY = irxQ ? Math.round(irxQ.price * 100) / 100 : null;
  const yieldSpread = tenY != null && twoY != null ? Math.round((tenY - twoY) * 100) / 100 : null;

  const stance = computeRiskStance({ vix: vixQ?.price ?? null, fg: fg?.value ?? null, yieldSpread });

  // Update history in-memory and write to file in background
  const today = formatETDate(new Date());
  const newEntry = { date: today, score: stance.score, stance: stance.label, color: stance.color, vix: vixQ?.price ?? null, fg: fg?.value ?? null, spread: yieldSpread };
  const idx = existingHistory.findIndex((h: any) => h.date === today);
  if (idx >= 0) existingHistory[idx] = newEntry; else existingHistory.push(newEntry);
  const history = existingHistory.slice(-30);
  fs.writeFile(HISTORY_PATH, JSON.stringify(history)).catch(() => {});

  const vix = vixQ ? { level: Math.round(vixQ.price * 100) / 100, change: Math.round(vixQ.change * 100) / 100, pct: Math.round(vixQ.pct * 100) / 100 } : null;
  const yields = { tenY, twoY, spread: yieldSpread };
  const playbook = computePlaybook(stance, vixQ?.price ?? null, fg?.value ?? null);
  const sizing = computeSizing(stance, vixQ?.price ?? null);
  const verdict = generateVerdict({ stance, vix, fg, yields, sectors, history });

  return { ts: Date.now(), stance, vix, fearGreed: fg, yields, sectors, history, playbook, sizing, verdict };
}

export async function GET() {
  try {
    if (CACHE && Date.now() - CACHE.ts < TTL) {
      return NextResponse.json(CACHE.data);
    }

    if (!INFLIGHT) {
      INFLIGHT = computeMacroRegime()
        .then(out => { CACHE = { ts: Date.now(), data: out }; return out; })
        .finally(() => { INFLIGHT = null; });
    }

    const data = await INFLIGHT;
    return NextResponse.json(data);
  } catch (e: unknown) {
    if (CACHE) return NextResponse.json({ ...CACHE.data, stale: true });
    return NextResponse.json({ error: (e instanceof Error ? e.message : String(e)).slice(0, 200) }, { status: 500 });
  }
}