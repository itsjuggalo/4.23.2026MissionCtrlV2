import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const SIGNALS_FILE = path.join(
  process.env.HOME || '/home/itsju',
  'mission-control/telegram-listener/signals.json'
);

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  const { searchParams } = new URL(request.url);
  const limit = parseInt(searchParams.get('limit') ?? '200', 10);

  try {
    const raw = await readFile(SIGNALS_FILE, 'utf-8');
    const signals = JSON.parse(raw) as Array<{ timestamp: string }>;
    const sorted = signals.sort(
      (a, b) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime()
    );
    return NextResponse.json(sorted.slice(0, limit));
  } catch {
    return NextResponse.json([]);
  }
}