import { NextRequest, NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';

const DATA_DIR = '/home/itsju/mission-control/signal-receiver/data';
const DIRECTIVES = '/home/itsju/.openclaw/workspace/directives';

async function safeRead(path: string) {
  try {
    return JSON.parse(await readFile(path, 'utf-8'));
  } catch {
    return null;
  }
}

export async function GET(req: NextRequest) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  const { searchParams } = new URL(req.url);
  const type = searchParams.get('type') || 'params';

  try {
    if (type === 'params') {
      const data = await safeRead(`${DATA_DIR}/optimal_params.json`);
      return NextResponse.json(data || { status: 'no_data', message: 'Run optimizer first' });
    }

    if (type === 'configs') {
      const configs: any = {};
      for (const tf of ['1H', '4H', '1D', '5m', '15m', '30m']) {
        const cfg = await safeRead(`${DIRECTIVES}/supertrend_config_BTC_${tf}.json`);
        if (cfg) configs[tf] = cfg;
      }
      return NextResponse.json(configs);
    }

    return NextResponse.json({ error: 'Unknown type. Use: params, configs' }, { status: 400 });
  } catch (e: any) {
    return NextResponse.json({ error: e.message }, { status: 500 });
  }
}