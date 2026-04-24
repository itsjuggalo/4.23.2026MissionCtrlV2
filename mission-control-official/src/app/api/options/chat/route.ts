import { NextRequest, NextResponse } from 'next/server';
import { readFile } from 'fs/promises';
import { exec } from 'child_process';
import { promisify } from 'util';

export const dynamic = 'force-dynamic';
const execAsync = promisify(exec);
const TA_SCRIPT = '/home/ubuntu/.openclaw/workspace/mission-control/scripts/ta_engine.py';

const SYSTEM_PROMPT = `You are an expert options trader, technical analyst, and AI price predictor. You have deep expertise in:

**Options Analysis:**
- Greeks (Delta, Gamma, Theta, Vega, Rho) and position risk
- Black-Scholes pricing, IV, volatility smile/skew
- Strategy selection: long calls/puts, spreads, strangles, straddles, covered calls
- Reading chains: bid/ask, open interest, volume, moneyness, liquidity

**Technical Analysis & Price Prediction:**
- RSI, MACD, Bollinger Bands, moving averages (EMA/SMA)
- Support/resistance levels, trend analysis
- Volume analysis (climax, dry-up, surge signals)
- Pattern recognition (breakouts, reversals, consolidations)

**When asked for a price prediction or price target:**
1. State your directional bias (bullish/bearish/neutral) with confidence level
2. Give specific price targets (T1, T2, T3) with timeframes
3. Reference the TA indicators: "RSI at X means...", "Price above/below EMA20 suggests..."
4. State the invalidation level (when you'd be wrong)
5. Connect it to the options play: "Given this target, the [strike] [call/put] makes sense because..."
6. Be specific — give dollar amounts, percentages, timeframes

**On screenshots:**
- Identify the chain, ticker, expiry, and what strikes look interesting
- Comment on IV relative value (cheap vs expensive)
- Recommend the best strike with reasoning

Be direct. Give a real opinion. Mention risk but don't hide behind it. A trader needs actionable guidance.`;

function formatTA(ta: any): string {
  if (!ta || ta.error) return '';
  const ind = ta.indicators || {};
  const sr = ta.supportResistance || {};
  const vol = ta.volume || {};
  const perf = ta.performance || {};
  const pt = ta.priceTargets || {};
  const info = ta.companyInfo || {};
  const news = ta.news || [];

  const lines = [
    `\n=== LIVE TECHNICAL ANALYSIS: ${ta.ticker} ===`,
    `Current Price: $${ind.current} (${ind.change1d > 0 ? '+' : ''}${ind.change1d}% today)`,
    '',
    '📊 MOVING AVERAGES:',
    `  EMA9: $${ind.ema9}  EMA20: $${ind.ema20}  EMA50: $${ind.ema50}`,
    `  SMA50: $${ind.sma50}  SMA200: $${ind.sma200}`,
    '',
    '📈 MOMENTUM:',
    `  RSI(14): ${ind.rsi14} | RSI(7): ${ind.rsi7}`,
    ind.macd ? `  MACD: ${ind.macd.line} | Signal: ${ind.macd.signal} | Hist: ${ind.macd.histogram}` : '',
    ind.bollinger ? `  Bollinger: Lower $${ind.bollinger.lower} | Mid $${ind.bollinger.mid} | Upper $${ind.bollinger.upper}` : '',
    ind.bb_position_pct !== undefined ? `  BB Position: ${ind.bb_position_pct}% (0=lower band, 100=upper band)` : '',
    '',
    '🎯 TREND:',
    `  Direction: ${ta.trend?.direction} | Strength: ${ta.trend?.strength}`,
    '',
    '🔍 TA SIGNALS:',
    ...(ta.signals || []).map((s: string) => `  • ${s}`),
    '',
    '📍 SUPPORT & RESISTANCE:',
    `  Resistance: ${sr.resistances?.join(', ') || 'N/A'}`,
    `  Support: ${sr.supports?.join(', ') || 'N/A'}`,
    `  52W High: $${sr['52wHigh']}  |  52W Low: $${sr['52wLow']}`,
    '',
    '📦 VOLUME:',
    `  Current: ${vol.current?.toLocaleString()} | 20D Avg: ${vol.avg20?.toLocaleString()} | Ratio: ${vol.ratio}x | Signal: ${vol.signal}`,
    '',
    '📅 PERFORMANCE:',
    `  1D: ${perf['1d']}%  |  5D: ${perf['5d']}%  |  1M: ${perf['1m']}%  |  3M: ${perf['3m']}%`,
    '',
    '🎯 TA PRICE TARGETS:',
    '  Bullish targets:',
    ...(pt.bullish || []).map((t: any) => `    → $${t.price} (+${t.pct}%) — ${t.basis}`),
    '  Bearish targets:',
    ...(pt.bearish || []).map((t: any) => `    → $${t.price} (${t.pct}%) — ${t.basis}`),
  ];

  if (info.analystTargetMean) {
    lines.push('', '🏦 ANALYST CONSENSUS:');
    lines.push(`  Mean Target: $${info.analystTargetMean} | High: $${info.analystTargetHigh} | Low: $${info.analystTargetLow}`);
    if (info.pe) lines.push(`  P/E: ${info.pe} | Beta: ${info.beta} | EPS: $${info.eps}`);
  }

  if (news.length > 0) {
    lines.push('', '📰 RECENT NEWS:');
    news.slice(0, 5).forEach((n: any) => lines.push(`  [${n.published}] ${n.title}`));
  }

  return lines.filter(l => l !== undefined && l !== null).join('\n');
}

function isPredictionQuestion(text: string): boolean {
  const keywords = [
    'price prediction', 'price target', 'where is it going', 'where will it go',
    'how high', 'how low', 'target price', 'predict', 'prediction', 'forecast',
    'price forecast', 'go to', 'reach', 'hit', 'what price', 'upside', 'downside',
    'bullish target', 'bearish target', 'next level', 'next resistance', 'next support',
    'what do you think', 'should i buy', 'should i sell', 'entry', 'exit',
    'technical analysis', 'ta', 'rsi', 'macd', 'support', 'resistance', 'trend',
  ];
  const lower = text.toLowerCase();
  return keywords.some(k => lower.includes(k));
}

function extractTickerFromContext(context: string, messages: any[]): string | null {
  // Try context first
  const ctxMatch = context?.match(/Ticker:\s*([A-Z]{1,6})/);
  if (ctxMatch) return ctxMatch[1];
  // Try last user messages
  for (let i = messages.length - 1; i >= 0; i--) {
    const content = typeof messages[i].content === 'string' ? messages[i].content : '';
    const m = content.match(/\b([A-Z]{1,5})\b/g);
    if (m) {
      const common = ['RSI', 'MACD', 'EMA', 'SMA', 'ATM', 'ITM', 'OTM', 'IV', 'DTE', 'PNL', 'AI', 'TA'];
      const ticker = m.find((t: string) => t.length >= 2 && !common.includes(t));
      if (ticker) return ticker;
    }
  }
  return null;
}

export async function POST(req: NextRequest) {
  try {
    const { messages, context, ticker } = await req.json();
    const lastUserMsg = messages.findLast((m: any) => m.role === 'user');
    const lastText = typeof lastUserMsg?.content === 'string' ? lastUserMsg.content : '';

    let apiKey: string;
    try {
      apiKey = (await readFile('/home/ubuntu/.openclaw/secrets/openai.key', 'utf-8')).trim();
    } catch {
      return NextResponse.json({ error: 'OpenAI key not configured' }, { status: 500 });
    }

    // Auto-fetch TA if prediction/analysis question detected
    let taContext = '';
    const activeTicker = ticker || extractTickerFromContext(context || '', messages);
    
    const hasImage = messages.some((m: any) =>
      Array.isArray(m.content) && m.content.some((c: any) => c.type === 'image_url')
    );

    if (activeTicker && (isPredictionQuestion(lastText) || hasImage)) {
      try {
        const { stdout } = await execAsync(`python3 ${TA_SCRIPT} ${activeTicker}`, { timeout: 25000 });
        const taData = JSON.parse(stdout.trim());
        if (!taData.error) {
          taContext = formatTA(taData);
        }
      } catch (e) {
        console.error('TA fetch failed:', e);
      }
    }

    const systemContent = [
      SYSTEM_PROMPT,
      context ? `\nOptions Context:\n${context}` : '',
      taContext,
    ].filter(Boolean).join('\n');

    const model = hasImage ? 'gpt-4o' : 'gpt-4o-mini';

    const response = await fetch('https://api.openai.com/v1/chat/completions', {
      method: 'POST',
      headers: {
        'Authorization': `Bearer ${apiKey}`,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        model,
        messages: [
          { role: 'system', content: systemContent },
          ...messages.slice(-12),
        ],
        max_tokens: 1000,
        temperature: 0.25,
      }),
    });

    if (!response.ok) {
      const err = await response.json();
      throw new Error(err.error?.message || `OpenAI error ${response.status}`);
    }

    const data = await response.json();
    const reply = data.choices?.[0]?.message?.content || 'No response.';
    const usage = data.usage || {};

    // Log token usage to file
    try {
      const { exec } = await import('child_process');
      const { promisify } = await import('util');
      const execAsync = promisify(exec);
      const inputTok  = usage.prompt_tokens || 0;
      const outputTok = usage.completion_tokens || 0;
      await execAsync(
        `python3 /home/ubuntu/.openclaw/workspace/mission-control/scripts/token_tracker.py 2>/dev/null || true; ` +
        `python3 -c "import sys; sys.path.insert(0,'/home/ubuntu/.openclaw/workspace/mission-control/scripts'); ` +
        `from token_tracker import log_usage; log_usage('${model}', ${inputTok}, ${outputTok}, 'options_chat', 'options_analysis')" 2>/dev/null || true`
      ).catch(() => {});
    } catch {}

    return NextResponse.json({ reply, model, taFetched: !!taContext, tokensUsed: (usage.total_tokens || 0) });
  } catch (err: any) {
    console.error('Chat error:', err);
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}
