// Technical analysis indicator calculations

/** Calculate Exponential Moving Average (EMA) for a series of prices */
export function calculateEMA(prices: number[], period: number): number[] {
  if (prices.length < period) return [];
  const k = 2 / (period + 1);
  const result: number[] = new Array(prices.length).fill(NaN);

  // Seed with SMA for first period
  let sum = 0;
  for (let i = 0; i < period; i++) sum += prices[i];
  result[period - 1] = sum / period;

  for (let i = period; i < prices.length; i++) {
    result[i] = prices[i] * k + result[i - 1] * (1 - k);
  }
  return result;
}

/** Calculate RSI(14) — returns a value 0–100 */
export function calculateRSI(prices: number[], period = 14): number {
  if (prices.length < period + 1) return 50;

  const changes: number[] = [];
  for (let i = 1; i < prices.length; i++) {
    changes.push(prices[i] - prices[i - 1]);
  }

  const recent = changes.slice(-period);
  let avgGain = 0;
  let avgLoss = 0;

  for (const c of recent) {
    if (c > 0) avgGain += c;
    else avgLoss += Math.abs(c);
  }
  avgGain /= period;
  avgLoss /= period;

  if (avgLoss === 0) return 100;
  const rs = avgGain / avgLoss;
  return 100 - 100 / (1 + rs);
}

/** Calculate MACD(12,26,9) */
export function calculateMACD(
  prices: number[],
  fast = 12,
  slow = 26,
  signalPeriod = 9
): { macd: number; signal: number; histogram: number } {
  const emaFast = calculateEMA(prices, fast);
  const emaSlow = calculateEMA(prices, slow);

  const macdLine: number[] = [];
  for (let i = 0; i < prices.length; i++) {
    if (!isNaN(emaFast[i]) && !isNaN(emaSlow[i])) {
      macdLine.push(emaFast[i] - emaSlow[i]);
    }
  }

  if (macdLine.length < signalPeriod) {
    return { macd: 0, signal: 0, histogram: 0 };
  }

  const signalLine = calculateEMA(macdLine, signalPeriod);
  const lastMacd = macdLine[macdLine.length - 1];
  const lastSignal = signalLine[signalLine.length - 1];

  return {
    macd: lastMacd,
    signal: lastSignal,
    histogram: lastMacd - lastSignal,
  };
}

/** Calculate Bollinger Bands(20, 2) */
export function calculateBollinger(
  prices: number[],
  period = 20,
  multiplier = 2
): { upper: number; middle: number; lower: number } {
  if (prices.length < period) {
    const last = prices[prices.length - 1] ?? 0;
    return { upper: last, middle: last, lower: last };
  }

  const recent = prices.slice(-period);
  const middle = recent.reduce((a, b) => a + b, 0) / period;
  const variance = recent.reduce((sum, p) => sum + Math.pow(p - middle, 2), 0) / period;
  const stdDev = Math.sqrt(variance);

  return {
    upper: middle + multiplier * stdDev,
    middle,
    lower: middle - multiplier * stdDev,
  };
}

/**
 * Generate a synthetic price history of `bars` candles ending at `currentPrice`.
 * Uses `change24h` (%) to bias the trend direction.
 */
export function generatePriceHistory(
  currentPrice: number,
  change24h: number,
  bars = 200
): number[] {
  // Per-bar trend to reproduce the 24h move spread across all bars
  const perBarTrend = change24h / 100 / bars;
  // Moderate noise
  const volatility = 0.003;

  const history: number[] = new Array(bars);
  history[bars - 1] = currentPrice;

  // Build backwards so the series ends at currentPrice
  for (let i = bars - 2; i >= 0; i--) {
    const noise = (Math.random() - 0.5) * 2 * volatility;
    history[i] = history[i + 1] / (1 + perBarTrend + noise);
  }

  return history;
}
