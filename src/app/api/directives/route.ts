import { NextResponse } from 'next/server';
import { readFileSync } from 'fs';
import { join } from 'path';

const DIR = join(process.env.HOME || '/home/ubuntu', '.openclaw/workspace/directives');

export async function GET(req: Request) {
  const { searchParams } = new URL(req.url);
  const file = searchParams.get('file') || '';
  const allowed = [
    'market_news.md', 'earnings_calendar.md', 'watchlist_quotes.md',
    'watchlist_deep_intel.md', 'watchlist_news_filings.md', 'market_briefing.md',
    'dashboard_data.json'
  ];
  if (!allowed.includes(file)) {
    return NextResponse.json({ error: 'Invalid file' }, { status: 400 });
  }
  try {
    const raw = readFileSync(join(DIR, file), 'utf-8');
    if (file.endsWith('.json')) return NextResponse.json(JSON.parse(raw));
    return NextResponse.json({ file, content: raw });
  } catch {
    return NextResponse.json({ error: 'File not found' }, { status: 404 });
  }
}
