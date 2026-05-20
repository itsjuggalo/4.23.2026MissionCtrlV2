import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';

export const dynamic = 'force-dynamic';

const DATA_DIR = '/home/itsju/mission-control/signal-receiver/data';

export async function GET() {
  try {
    const data = JSON.parse(await readFile(`${DATA_DIR}/latest_state.json`, 'utf-8'));
    return NextResponse.json(data);
  } catch {
    return NextResponse.json({});
  }
}
