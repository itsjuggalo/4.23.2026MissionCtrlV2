import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import path from 'path';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const BIAS_FILE = path.join(
  process.env.HOME || '/home/itsju',
  'mission-control/btc-bias/btc-bias.json'
);

export async function GET() {
  try {
    const raw = await readFile(BIAS_FILE, 'utf-8');
    const data = JSON.parse(raw);
    return NextResponse.json(data);
  } catch {
    return NextResponse.json(
      {
        loading: true,
        bias: null,
        score: null,
        max_score: 13,
        timestamp: null,
        next_update: null,
        signals: {},
      },
      { status: 200 }
    );
  }
}