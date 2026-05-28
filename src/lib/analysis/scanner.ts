import {
  calculateRSI,
  calculateMACD,
  calculateEMA,
  calculateBollinger,
  generatePriceHistory,
} from './indicators';
import type { Signal } from '@/lib/types';

interface PriceInput {
  symbol: string;
  asset: 'Crypto' | 'Stock';
  price: number;
  change24h: number;
}

/** Determine signal trend based on indicator confluence */
function getTrend(
  rsi: number,
  macdHistogram: number,
  price: number,
  ema50: number,
  ema200: number
): Signal['trend'] {
  let bullishVotes = 0;
  let bearishVotes = 0;

  if (rsi < 45) bullishVotes++;
  else if (rsi > 60) bearishVotes++;

  if (macdHistogram > 0) bullishVotes++;
  else if (macdHistogram < 0) bearishVotes++;

  if (price > ema50) bullishVotes++;
  else bearishVotes++;

  if (ema50 > ema200) bullishVotes++;
  else bearishVotes++;

  if (bullishVotes >= 3) return 'bullish';
  if (bearishVotes >= 3) return 'bearish';
  return 'neutral';
}

/** Compute a 0–100 signal strength from indicator values */
function getStrength(
  rsi: number,
  macdHistogram: number,
  price: number,
  boll: { upper: number; middle: number; lower: number },
  change24h: number
): number {
  let score = 50;

  // RSI contribution (extremes = stronger signal)
  if (rsi < 30) score += 20;
  else if (rsi < 40) score += 10;
  else if (rsi > 70) score += 20;
  else if (rsi > 60) score += 8;

  // MACD contribution
  const macdPct = Math.abs(macdHistogram) / price;
  score += Math.min(macdPct * 5000, 15);

  // Price relative to Bollinger Bands
  const bandWidth = boll.upper - boll.lower;
  if (bandWidth > 0) {
    const pctB = (price - boll.lower) / bandWidth;
    if (pctB < 0.2 || pctB > 0.8) score += 10;
  }

  // Absolute 24h momentum
  score += Math.min(Math.abs(change24h) * 0.5, 10);

  return Math.round(Math.min(Math.max(score, 30), 99));
}

/** Build signal reasoning text from indicators */
function buildReasoning(
  rsi: number,
  macd: { macd: number; signal: number; histogram: number },
  ema50: number,
  ema200: number,
  price: number,
  boll: { upper: number; middle: number; lower: number },
  _trend: Signal['trend']
): string {
  const parts: string[] = [];

  const rsiRound = Math.round(rsi);
  if (rsi < 30) parts.push(`RSI at ${rsiRound} — oversold territory, bounce potential.`);
  else if (rsi > 70) parts.push(`RSI at ${rsiRound} — overbought, watch for reversal.`);
  else parts.push(`RSI at ${rsiRound} — neutral momentum zone.`);

  if (macd.histogram > 0) parts.push('MACD histogram positive — bullish momentum building.');
  else parts.push('MACD histogram negative — bearish momentum present.');

  const emaDiff = ((ema50 - ema200) / ema200) * 100;
  if (Math.abs(emaDiff) < 0.5) parts.push('EMA50/EMA200 convergence — potential crossover forming.');
  else if (ema50 > ema200) parts.push(`EMA50 above EMA200 by ${Math.abs(emaDiff).toFixed(2)}% — uptrend confirmed.`);
  else parts.push(`EMA50 below EMA200 by ${Math.abs(emaDiff).toFixed(2)}% — downtrend present.`);

  const bandWidth = boll.upper - boll.lower;
  if (bandWidth > 0) {
    const pctB = ((price - boll.lower) / bandWidth) * 100;
    if (pctB < 20) parts.push('Price near lower Bollinger Band — potential mean reversion upward.');
    else if (pctB > 80) parts.push('Price near upper Bollinger Band — extended, possible pullback.');
    else parts.push(`Price at ${Math.round(pctB)}% within Bollinger Bands — consolidating.`);
  }

  return parts.join(' ');
}

const TIMEFRAMES: Signal['timeframe'][] = ['15m', '1H', '4H', '1D'];
const SOURCES = ['RSI Scanner', 'MACD Signal', 'EMA/SMA Trend', 'Bollinger Bands', 'Momentum Scanner', 'Volume Spike', 'Breakout Scanner'];

/** Generate a live scanner signal from a real price input */
export function generateSignal(input: PriceInput, index: number): Signal {
  const history = generatePriceHistory(input.price, input.change24h, 200);

  const rsi = calculateRSI(history, 14);
  const macd = calculateMACD(history, 12, 26, 9);
  const ema50Arr = calculateEMA(history, 50);
  const ema200Arr = calculateEMA(history, 200);
  const boll = calculateBollinger(history, 20, 2);

  const ema50 = ema50Arr[ema50Arr.length - 1] ?? input.price;
  const ema200 = ema200Arr[ema200Arr.length - 1] ?? input.price;

  const trend = getTrend(rsi, macd.histogram, input.price, ema50, ema200);
  const strength = getStrength(rsi, macd.histogram, input.price, boll, input.change24h);
  const reasoning = buildReasoning(rsi, macd, ema50, ema200, input.price, boll, trend);

  return {
    id: index + 1,
    symbol: input.symbol,
    asset: input.asset,
    timeframe: TIMEFRAMES[index % TIMEFRAMES.length],
    price: input.price,
    trend,
    strength,
    source: SOURCES[index % SOURCES.length],
    time: 'live',
    status: 'new',
    reasoning,
  };
}

/** Generate signals for all provided price inputs */
export function generateSignals(inputs: PriceInput[]): Signal[] {
  return inputs
    .map((input, i) => generateSignal(input, i))
    .sort((a, b) => b.strength - a.strength);
}
