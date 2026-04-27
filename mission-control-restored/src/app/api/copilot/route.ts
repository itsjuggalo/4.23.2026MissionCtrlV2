import { NextResponse } from 'next/server';
import fs from 'fs';
import path from 'path';
import os from 'os';

function readSecret(name: string): string {
  try {
    const p = path.join(os.homedir(), '.openclaw', 'secrets', name);
    if (fs.existsSync(p)) return fs.readFileSync(p, 'utf-8').trim();
  } catch { /* noop */ }
  return process.env[name.toUpperCase()] || '';
}

function safeReadJSON(filepath: string): unknown {
  try {
    if (!fs.existsSync(filepath)) return null;
    return JSON.parse(fs.readFileSync(filepath, 'utf-8'));
  } catch { return null; }
}

async function buildDashboardContext(): Promise<string> {
  const home = os.homedir();
  const mcData = path.join(home, 'mission-control-restored', 'data');
  const srData = path.join(home, 'mission-control', 'signal-receiver', 'data');
  const ctx: Record<string, unknown> = {};

  const portfolio = safeReadJSON(path.join(mcData, 'portfolio.json'));
  if (portfolio) ctx.portfolio = portfolio;

  const latestState = safeReadJSON(path.join(srData, 'latest_state.json'));
  if (latestState) ctx.current_positions = latestState;

  const regime = safeReadJSON(path.join(srData, 'market_regime.json'));
  if (regime) ctx.regime = regime;

  const params = safeReadJSON(path.join(srData, 'optimal_params.json'));
  if (params) ctx.optimal_params = params;

  const dailyReport = safeReadJSON(path.join(mcData, 'daily_report.json'));
  if (dailyReport) ctx.daily_report = dailyReport;

  const congress = safeReadJSON(path.join(mcData, 'congress_trades.json')) as Record<string, unknown> | null;
  if (congress) {
    ctx.congress_summary = {
      total_trades: congress.total_trades,
      last_updated: congress.last_updated,
      top_politicians: (congress.politicians as unknown[] | undefined)?.slice(0, 5),
      suspicious_count: (congress.suspicious as unknown[] | undefined)?.length || 0,
    };
  }

  const llm = safeReadJSON(path.join(mcData, 'llm_portfolio.json')) as Record<string, unknown> | null;
  if (llm) ctx.llm_leaderboard = llm.leaderboard;

  const usage = safeReadJSON(path.join(mcData, 'api_usage.json')) as Record<string, unknown> | null;
  if (usage) {
    ctx.api_usage_summary = { last_updated: usage.last_updated, totals_by_provider: usage.totals_by_provider };
  }

  const calendar = safeReadJSON(path.join(mcData, 'calendar_events.json')) as Record<string, unknown> | null;
  if (calendar?.events && Array.isArray(calendar.events)) {
    const now = new Date();
    const week = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000);
    const upcoming = (calendar.events as Array<Record<string, unknown>>).filter((e) => {
      const d = new Date(String(e.date));
      return d >= now && d <= week;
    });
    ctx.upcoming_events = upcoming.slice(0, 15);
  }

  const str = JSON.stringify(ctx, null, 2);
  return str.length > 40000 ? str.slice(0, 40000) + '\n... (truncated)' : str;
}

const MODEL_SONNET = 'claude-sonnet-4-6';
const MODEL_HAIKU = 'claude-haiku-4-5-20251001';

function pickAutoModel(message: string): string {
  const msg = message.trim();
  if (msg.length < 80) return MODEL_HAIKU;
  if (/analyz|compar|explain|strateg|backtest|why|should I|recommend|deep|detail|forecast|outlook/i.test(msg)) return MODEL_SONNET;
  return MODEL_HAIKU;
}

const BASE_SYSTEM = `You are the Mission Control copilot — an AI trading assistant for Commander Mike. He runs a multi-agent AI trading system on Oracle Cloud:

- Agents: Boba (Claude Sonnet, orchestrator), JazzyHazzy (GPT-4o-mini, research/news), Orion (Gemini Flash, scanner/technicals)
- Alpaca paper account: ~$137K equity (from $100K start)
- BTCUSD systematic strategy: SuperTrend on Coinbase 1H via TradingView webhooks
- Dashboard: Next.js on port 3033 with live signals, regime detection, congress trading, LLM portfolio tracking

Be direct, concise, and tactical. Use numbers. No fluff.`;

const SUPPORT_SYSTEM = `You are the Mission Control support assistant. You help Commander Mike with questions about how to use Mission Control, troubleshoot issues, configure settings, and understand what each feature does.

Mission Control is a Next.js trading dashboard running on Oracle Cloud Ubuntu. It has these pages:
- Dashboard: portfolio overview, positions, regime, strategy params
- TV Chart: TradingView embed with signal panel
- Tasks: pipeline kanban showing trade ideas flowing through stages
- Signals: live signal feed from TradingView webhooks
- Agents: Boba (orchestrator), JazzyHazzy (research), Orion (scanner)
- Congress: congressional trading activity tracker
- LLM Portfolio: AI model portfolio leaderboard (AIME, DeepSeek, Qwen, Claude, Gemini, GPT)
- Calendar: earnings, economic events, dividends, IPOs
- Risk: exposure and risk metrics
- Wallets: crypto wallet balances

Be warm, patient, and thorough. Explain things clearly. If you don't know something specific about the system, say so honestly.`;

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const message = String(body.message || '').trim();
    const mode = String(body.mode || 'auto').toLowerCase();

    if (!message) {
      return NextResponse.json({ error: 'Message is required' }, { status: 400 });
    }

    // Model selection
    let model = MODEL_SONNET;
    if (mode === 'fast') model = MODEL_HAIKU;
    else if (mode === 'auto') model = pickAutoModel(message);
    // expert, copilot, support all use Sonnet

    // System prompt
    let systemPrompt = BASE_SYSTEM;
    if (mode === 'support') {
      systemPrompt = SUPPORT_SYSTEM;
    } else if (mode === 'copilot') {
      const context = await buildDashboardContext();
      systemPrompt += `\n\n=== LIVE DASHBOARD CONTEXT ===\n${context}\n=== END CONTEXT ===\n\nWhen answering, reference this live data directly. Cite specific numbers, positions, and states.`;
    }

    const apiKey = readSecret('anthropic_api_key');
    if (!apiKey) {
      return NextResponse.json({ error: 'Anthropic API key not found at ~/.openclaw/secrets/anthropic_api_key' }, { status: 500 });
    }

    const r = await fetch('https://api.anthropic.com/v1/messages', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'x-api-key': apiKey,
        'anthropic-version': '2023-06-01',
      },
      body: JSON.stringify({
        model,
        max_tokens: 1024,
        system: systemPrompt,
        messages: [{ role: 'user', content: message }],
      }),
    });

    const data = await r.json();

    if (!r.ok) {
      return NextResponse.json({ error: data?.error?.message || `API error ${r.status}` }, { status: 500 });
    }

    const text = data.content?.[0]?.text || '';

    // Usage logging
    try {
      const logPath = path.join(os.homedir(), 'mission-control-restored', 'data', 'api_usage.json');
      let log: Record<string, unknown> = {};
      if (fs.existsSync(logPath)) log = JSON.parse(fs.readFileSync(logPath, 'utf-8'));
      const entries = (log.entries as unknown[] | undefined) || [];
      entries.push({
        timestamp: new Date().toISOString(),
        source: 'copilot',
        provider: 'anthropic',
        model,
        input_tokens: data.usage?.input_tokens || 0,
        output_tokens: data.usage?.output_tokens || 0,
        mode,
      });
      log.entries = entries;
      log.last_updated = new Date().toISOString();
      fs.writeFileSync(logPath, JSON.stringify(log, null, 2));
    } catch { /* don't fail on logging */ }

    return NextResponse.json({
      response: text,
      model,
      mode,
      tokens: { input: data.usage?.input_tokens || 0, output: data.usage?.output_tokens || 0 },
    });
  } catch (err) {
    return NextResponse.json({ error: err instanceof Error ? err.message : String(err) }, { status: 500 });
  }
}
