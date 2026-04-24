import { NextRequest, NextResponse } from 'next/server';
import { readFile } from 'fs/promises';

export const dynamic = 'force-dynamic';

const SIGNALS_FILE = '/home/ubuntu/mission-control/telegram-listener/signals.json';

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const limit = parseInt(searchParams.get('limit') || '50');
  const status = searchParams.get('status'); // 'approved' | 'rejected' | 'pending' | null (all)
  const minScore = parseInt(searchParams.get('minScore') || '0');
  const source = searchParams.get('source'); // filter by channel name

  try {
    const raw = await readFile(SIGNALS_FILE, 'utf-8');
    let signals: any[] = JSON.parse(raw);

    // Sort newest first
    signals.sort((a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime());

    // Filters
    if (status) signals = signals.filter(s => s.status === status);
    if (minScore > 0) signals = signals.filter(s => (s.score || 0) >= minScore);
    if (source) signals = signals.filter(s => s.channel_name?.toLowerCase().includes(source.toLowerCase()));

    const sliced = signals.slice(0, Math.min(limit, 200));

    // Stats
    const all = JSON.parse(raw);
    const stats = {
      total: all.length,
      approved: all.filter((s: any) => s.status === 'approved').length,
      rejected: all.filter((s: any) => s.status === 'rejected').length,
      pending: all.filter((s: any) => s.status === 'pending').length,
      sources: Array.from(new Set<string>(all.map((s: any) => s.channel_name).filter(Boolean))),
      highScore: all.filter((s: any) => (s.score || 0) >= 70).length,
    };

    return NextResponse.json({
      signals: sliced,
      stats,
      timestamp: new Date().toISOString(),
    });
  } catch (err: any) {
    return NextResponse.json({ error: err.message, signals: [], stats: {} }, { status: 500 });
  }
}
