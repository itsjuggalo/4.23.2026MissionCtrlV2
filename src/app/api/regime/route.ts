import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';

export const dynamic = 'force-dynamic';

const DATA_DIR = '/home/ubuntu/mission-control/signal-receiver/data';

export async function GET() {
  try {
    const data = JSON.parse(await readFile(`${DATA_DIR}/market_regime.json`, 'utf-8'));
    return NextResponse.json(data);
  } catch {
    return NextResponse.json({
      overall_regime: 'UNKNOWN',
      direction_bias: 'UNKNOWN',
      overall_recommendation: 'No regime data yet — run regime_detector.py',
      timeframes: {}
    });
  }
}
