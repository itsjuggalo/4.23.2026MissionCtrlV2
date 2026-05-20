import { NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';

const DATA_DIR = '/home/itsju/mission-control/signal-receiver/data';

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
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
