import { NextRequest, NextResponse } from 'next/server';
import { readFile, writeFile } from 'fs/promises';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);

const SIGNALS_FILE = '/home/ubuntu/mission-control/telegram-listener/signals.json';
const WEBHOOK_LOG  = '/home/ubuntu/mission-control/shared/tradingview_webhooks.json';
const SECRET       = process.env.TV_WEBHOOK_SECRET || 'missionctrl2026';

/*
  TradingView Alert Message Format (set this in TradingView alert):

  {
    "secret": "missionctrl2026",
    "ticker": "{{ticker}}",
    "exchange": "{{exchange}}",
    "close": {{close}},
    "open": {{open}},
    "high": {{high}},
    "low": {{low}},
    "volume": {{volume}},
    "time": "{{time}}",
    "interval": "{{interval}}",
    "action": "{{strategy.order.action}}",
    "contracts": {{strategy.order.contracts}},
    "comment": "{{strategy.order.comment}}"
  }
*/

async function loadJson(path: string, fallback: any = []) {
  try {
    return JSON.parse(await readFile(path, 'utf-8'));
  } catch {
    return fallback;
  }
}

export async function POST(req: NextRequest) {
  try {
    const body = await req.json();

    // Verify secret
    if (body.secret !== SECRET) {
      console.error('[TV Webhook] Invalid secret');
      return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
    }

    const {
      ticker = '', exchange = '', close = 0,
      action = '', comment = '', interval = '60',
      time = new Date().toISOString(),
    } = body;

    // Map TradingView action to our direction
    const actionUpper = action.toUpperCase();
    const direction = actionUpper === 'BUY' ? 'BUY'
                    : actionUpper === 'SELL' ? 'SELL'
                    : actionUpper.includes('LONG') ? 'BUY'
                    : actionUpper.includes('SHORT') ? 'SELL'
                    : null;

    if (!direction) {
      return NextResponse.json({ error: `Unknown action: ${action}` }, { status: 400 });
    }

    const price = Number(close);
    const symbol = ticker.replace('USDT', '').replace('USD', '').toUpperCase();

    // Derive basic stop/targets from price (2% stop, 4%/6%/8% targets)
    const isLong = direction === 'BUY';
    const stop    = isLong ? round(price * 0.98, 4) : round(price * 1.02, 4);
    const t1      = isLong ? round(price * 1.04, 4) : round(price * 0.96, 4);
    const t2      = isLong ? round(price * 1.06, 4) : round(price * 0.94, 4);
    const t3      = isLong ? round(price * 1.08, 4) : round(price * 0.92, 4);

    const signalId = `tv_${Date.now()}`;

    const signal = {
      id:           signalId,
      channel_id:   'tradingview',
      channel_name: `TradingView-${exchange || 'TV'}`,
      timestamp:    new Date().toISOString(),
      raw_text:     `${symbol} ${direction} @ ${price} | ${comment} | ${interval}min | from TradingView`,
      symbol,
      direction,
      entry:        price,
      stop_loss:    stop,
      targets:      [t1, t2, t3],
      score:        75,  // TradingView strategy signals start at 75
      status:       'actionable',
      confirmed_by: ['TradingView', 'Pine Script'],
      quality_flags: ['complete-data', 'tradingview-webhook', `interval-${interval}`],
      source_meta: body,
    };

    // Append to signals file
    const signals = await loadJson(SIGNALS_FILE, []);
    signals.push(signal);
    if (signals.length > 500) signals.splice(0, signals.length - 500);
    await writeFile(SIGNALS_FILE, JSON.stringify(signals, null, 2));

    // Log webhook
    const webhookLog = await loadJson(WEBHOOK_LOG, []);
    webhookLog.push({ ...body, _received: new Date().toISOString(), _signal_id: signalId });
    if (webhookLog.length > 200) webhookLog.splice(0, webhookLog.length - 200);
    await writeFile(WEBHOOK_LOG, JSON.stringify(webhookLog, null, 2));

    console.log(`[TV Webhook] ${symbol} ${direction} @ ${price} injected as signal ${signalId}`);

    return NextResponse.json({
      ok: true,
      signal_id: signalId,
      symbol,
      direction,
      price,
      message: `Signal injected → Eric → Analyst → Risk Manager → Executor pipeline`,
    });

  } catch (err: any) {
    console.error('[TV Webhook] Error:', err);
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}

// Health check
export async function GET() {
  return NextResponse.json({
    status: 'ready',
    endpoint: 'POST /api/webhooks/tradingview',
    secret_required: true,
    pipeline: 'TradingView → webhook → signals.json → Eric → Analyst → Risk Manager → Executor → Alpaca',
    alert_format: {
      secret: 'missionctrl2026',
      ticker: '{{ticker}}',
      exchange: '{{exchange}}',
      close: '{{close}}',
      open: '{{open}}',
      high: '{{high}}',
      low: '{{low}}',
      volume: '{{volume}}',
      time: '{{time}}',
      interval: '{{interval}}',
      action: '{{strategy.order.action}}',
      contracts: '{{strategy.order.contracts}}',
      comment: '{{strategy.order.comment}}',
    },
  });
}

function round(n: number, decimals: number) {
  return Math.round(n * Math.pow(10, decimals)) / Math.pow(10, decimals);
}
