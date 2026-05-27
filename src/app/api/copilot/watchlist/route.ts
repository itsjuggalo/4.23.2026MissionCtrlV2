/**
 * /api/copilot/watchlist — implicit pinned tickers surfaced from chat.
 *
 * Stored at ~/.openclaw/data/copilot_watchlist.json. Each pin keeps a last-seen
 * timestamp and the chat snippet that triggered it. Front-end shows chips
 * above the conversation and the user can dismiss with X.
 */
import { NextResponse } from 'next/server';
import fs from 'fs';
import os from 'os';
import path from 'path';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const STORE_PATH = path.join(os.homedir(), '.openclaw', 'data', 'copilot_watchlist.json');
const MAX_PINS = 12;

interface Pin {
  symbol: string;
  pinned_at: string; // ISO
  source_snippet: string;
  hits: number;
}

function readStore(): Pin[] {
  try {
    if (!fs.existsSync(STORE_PATH)) return [];
    const raw = fs.readFileSync(STORE_PATH, 'utf-8');
    const data = JSON.parse(raw);
    if (!Array.isArray(data?.pins)) return [];
    return data.pins;
  } catch { return []; }
}

function writeStore(pins: Pin[]): void {
  fs.mkdirSync(path.dirname(STORE_PATH), { recursive: true });
  fs.writeFileSync(STORE_PATH, JSON.stringify({ pins, updated_at: new Date().toISOString() }, null, 2));
}

// Same stopword set the alt-signals lib uses — extracted here for the route.
const TICKER_STOPWORDS = new Set([
  'I','A','THE','TO','AND','OR','BUT','IT','IS','AT','BY','ON','IN','OF','FOR','WITH','AS','BE',
  'AM','PM','ET','PT','CT','EST','PDT','US','USA','UK','EU','USD','EUR','GBP','CEO','CFO','CTO',
  'COO','IPO','ETF','API','SEC','FED','NYSE','NASDAQ','AI','ML','GPT','LLM','Q1','Q2','Q3','Q4',
  'FY','YOY','YTD','WTI','BS','ROI','ROE','EPS','P','E','PE','ER','OK','NO','YES','ALL','ANY',
  'OUT','OFF','UP','DOWN','NEW','OLD','NOW','THEN','HERE','THERE','TBA','TBD','WIP','CC','DM',
  'AMA','DD','PR','TLDR','FWIW','IIRC','IMO','IMHO','STONK','STONKS','BULL','BEAR','WSB','YOLO',
  'FOMO','HODL','FUD','IV','OTM','ITM','ATM','OEM','CPI','PPI','GDP','JOLTS','NFP','FOMC','ECB',
  'BOJ','PCE','ATH','ATL','OPEX','EOD','EOW','EOM','AH','TYPE','SHARE','PLAY','PORT','BAG','MOON',
  'CALL','PUT','OG','EV','WEEK','MONTH','YEAR',
]);

const TICKER_RE = /\$?\b([A-Z]{2,5})\b/g;

export function extractTickers(text: string, max = 6): { symbol: string; with_dollar: boolean }[] {
  if (!text) return [];
  const found: { symbol: string; with_dollar: boolean }[] = [];
  const seen = new Set<string>();
  let m: RegExpExecArray | null;
  while ((m = TICKER_RE.exec(text)) !== null) {
    const s = m[1];
    if (TICKER_STOPWORDS.has(s)) continue;
    if (seen.has(s)) continue;
    seen.add(s);
    const matched = m[0];
    found.push({ symbol: s, with_dollar: matched.startsWith('$') });
    if (found.length >= max) break;
  }
  return found;
}

// GET — list current pins
export async function GET() {
  const pins = readStore();
  return NextResponse.json({ pins, max: MAX_PINS, path: STORE_PATH });
}

// POST — add or refresh pins from a chat message
// body: { text: string }
export async function POST(req: Request) {
  let body: { text?: string; symbols?: string[] };
  try { body = await req.json(); } catch { body = {}; }
  const text = String(body.text || '');
  const extracted = body.symbols
    ? body.symbols.map((s) => ({ symbol: String(s).toUpperCase(), with_dollar: true }))
    : extractTickers(text);

  // Heuristic: require either $ prefix OR strong context ("stock", "ticker",
  // "calls", "puts", "price", "chart") to avoid pinning every random ALL-CAPS word.
  const ctxRe = /(stock|ticker|share|call|put|option|price|chart|target|entry|stop|long|short|buy|sell)/i;
  const hasCtx = ctxRe.test(text);
  const accepted = extracted.filter((t) => t.with_dollar || hasCtx);
  if (accepted.length === 0) {
    return NextResponse.json({ pinned: [], note: 'no symbols matched heuristic' });
  }

  const existing = readStore();
  const now = new Date().toISOString();
  const byKey = new Map<string, Pin>();
  for (const p of existing) byKey.set(p.symbol, p);

  const snippet = text.replace(/\s+/g, ' ').trim().slice(0, 140);

  for (const { symbol } of accepted) {
    const prev = byKey.get(symbol);
    byKey.set(symbol, {
      symbol,
      pinned_at: now,
      source_snippet: snippet,
      hits: (prev?.hits || 0) + 1,
    });
  }

  // Most-recent first, cap at MAX_PINS
  const merged = Array.from(byKey.values())
    .sort((a, b) => (b.pinned_at > a.pinned_at ? 1 : b.pinned_at < a.pinned_at ? -1 : 0))
    .slice(0, MAX_PINS);
  writeStore(merged);

  return NextResponse.json({ pinned: accepted.map((a) => a.symbol), pins: merged });
}

// DELETE — remove one or all
// body: { symbol?: string }
export async function DELETE(req: Request) {
  let body: { symbol?: string };
  try { body = await req.json(); } catch { body = {}; }
  if (!body.symbol) {
    writeStore([]);
    return NextResponse.json({ cleared: true });
  }
  const sym = body.symbol.toUpperCase();
  const next = readStore().filter((p) => p.symbol !== sym);
  writeStore(next);
  return NextResponse.json({ removed: sym, pins: next });
}
