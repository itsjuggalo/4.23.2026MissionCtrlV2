import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';

export async function GET() {
  try {
    const paramsFile = path.join('/home/ubuntu/mission-control/shared', 'supertrend_params.json');
    let params = {};
    try {
      params = JSON.parse(await fs.readFile(paramsFile, 'utf-8'));
    } catch {
      params = {};
    }
    return NextResponse.json({ success: true, params }, { headers: { 'Cache-Control': 'no-store' } });
  } catch {
    return NextResponse.json({ success: false, params: {} }, { status: 500 });
  }
}

export async function POST(req: Request) {
  try {
    const body       = await req.json();
    const paramsFile = path.join('/home/ubuntu/mission-control/shared', 'supertrend_params.json');
    let params: any  = {};
    try {
      params = JSON.parse(await fs.readFile(paramsFile, 'utf-8'));
    } catch { /* empty */ }

    const symbol = body.symbol?.toUpperCase();
    if (symbol && body.atr_period && body.multiplier) {
      params[symbol] = {
        ...params[symbol],
        atr_period:   Number(body.atr_period),
        multiplier:   Number(body.multiplier),
        manual_override: true,
        updated_at:   new Date().toISOString(),
      };
      await fs.writeFile(paramsFile, JSON.stringify(params, null, 2));
    }

    return NextResponse.json({ success: true, params });
  } catch {
    return NextResponse.json({ success: false }, { status: 500 });
  }
}
