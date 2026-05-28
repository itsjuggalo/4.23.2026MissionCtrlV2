import { NextResponse } from 'next/server';
import { proxyToServeftp } from '../../../lib/proxyToServeftp';

const FEEDS = [
  { url: 'https://feeds.reuters.com/reuters/businessNews', source: 'Reuters' },
  { url: 'https://feeds.marketwatch.com/marketwatch/topstories/', source: 'MarketWatch' },
  { url: 'https://search.cnbc.com/rs/search/combinedcms/view.xml?partnerId=wrss01&id=10000664', source: 'CNBC' },
  { url: 'https://finance.yahoo.com/rss/topstories', source: 'Yahoo Finance' },
];

function decodeHtml(str: string): string {
  return str
    .replace(/&#x([0-9a-fA-F]+);/g, (_, h) => String.fromCodePoint(parseInt(h, 16)))
    .replace(/&#(\d+);/g, (_, d) => String.fromCodePoint(parseInt(d, 10)))
    .replace(/&amp;/g, '&').replace(/&lt;/g, '<').replace(/&gt;/g, '>')
    .replace(/&quot;/g, '"').replace(/&apos;/g, "'").replace(/&nbsp;/g, ' ');
}

function extractTag(xml: string, tag: string): string {
  // Handle CDATA and plain
  const cdata = new RegExp(`<${tag}[^>]*>\\s*<!\\[CDATA\\[([\\s\\S]*?)\\]\\]>\\s*</${tag}>`, 'i').exec(xml);
  if (cdata) return cdata[1].trim();
  const plain = new RegExp(`<${tag}[^>]*>([\\s\\S]*?)</${tag}>`, 'i').exec(xml);
  if (plain) return plain[1].replace(/<[^>]+>/g, '').trim();
  return '';
}

function extractLink(itemXml: string): string {
  // <link> in RSS can be text or self-closing; also check <guid isPermaLink="true">
  const m = /<link>([^<]+)<\/link>/i.exec(itemXml) ||
            /<link\s+href="([^"]+)"/i.exec(itemXml) ||
            /<guid[^>]*isPermaLink="true"[^>]*>([^<]+)<\/guid>/i.exec(itemXml) ||
            /<guid[^>]*>([^<]+)<\/guid>/i.exec(itemXml);
  if (m) return m[1].trim();
  // Yahoo puts link as CDATA-less text between <link/> and next tag
  const afterLink = /<link \/>([\s\S]*?)<(?:title|description|pubDate)/i.exec(itemXml);
  if (afterLink) return afterLink[1].trim();
  return '';
}

interface NewsItem {
  time: string;
  headline: string;
  source: string;
  url: string;
  ts: number;
}

type ClientNewsItem = Omit<NewsItem, 'ts'>;

function parseRSS(xml: string, defaultSource: string): NewsItem[] {
  const items: NewsItem[] = [];
  const blocks = xml.match(/<item[\s>]([\s\S]*?)<\/item>/gi) || [];

  for (const block of blocks.slice(0, 10)) {
    const headline = extractTag(block, 'title');
    const url = extractLink(block);
    const pubDate = extractTag(block, 'pubDate');
    const srcTag = extractTag(block, 'source') || defaultSource;

    const cleanHeadline = decodeHtml(headline);
    if (!cleanHeadline || cleanHeadline.length < 4) continue;

    let ts = 0;
    let time = '--:--';
    if (pubDate) {
      const d = new Date(pubDate);
      if (!isNaN(d.getTime())) {
        ts = d.getTime();
        time = d.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', hour12: false, timeZone: 'America/New_York' });
      }
    }

    items.push({ time, headline: cleanHeadline, source: srcTag, url, ts });
  }

  return items;
}

// In-process cache — survives across requests in the same worker lifetime
let cache: { news: ClientNewsItem[]; updated: string } | null = null;
let cacheAt = 0;
const CACHE_MS = 5 * 60 * 1000;

export async function GET(req: Request) {
  const proxied = await proxyToServeftp(req);
  if (proxied) return proxied;

  try {
  if (cache && Date.now() - cacheAt < CACHE_MS) {
    return NextResponse.json(cache, { headers: { 'Cache-Control': 'public, max-age=300' } });
  }

  const results = await Promise.allSettled(
    FEEDS.map(async ({ url, source }) => {
      const res = await fetch(url, {
        signal: AbortSignal.timeout(8000),
        headers: { 'User-Agent': 'MissionControl/1.0 (market news aggregator)' },
        next: { revalidate: 0 },
      });
      if (!res.ok) throw new Error(`${source} HTTP ${res.status}`);
      const xml = await res.text();
      return parseRSS(xml, source);
    }),
  );

  const all: NewsItem[] = [];
  for (const r of results) {
    if (r.status === 'fulfilled') all.push(...r.value);
    else console.warn('[market-news]', r.reason?.message);
  }

  all.sort((a, b) => b.ts - a.ts);
  // Deduplicate by headline similarity (exact match)
  const seen = new Set<string>();
  const deduped = all.filter(n => {
    const key = n.headline.toLowerCase().slice(0, 60);
    if (seen.has(key)) return false;
    seen.add(key);
    return true;
  });

  // Strip the internal `ts` field before sending to client
  const news: ClientNewsItem[] = deduped.slice(0, 30).map(item => ({
    time: item.time,
    headline: item.headline,
    source: item.source,
    url: item.url,
  }));
  cache = { news, updated: new Date().toISOString() };
  cacheAt = Date.now();

  return NextResponse.json(cache, { headers: { 'Cache-Control': 'public, max-age=300' } });
  } catch (e) {
    return NextResponse.json({ error: String(e).slice(0, 200) }, { status: 500 });
  }
}
