import { ScanResult } from '../types';

export const mockScanResults: ScanResult[] = [
  { id: '1', symbol: 'BTC/USDT', asset_class: 'crypto', timeframe: '4H', price: 67420.50, trend: 'bullish', signalStrength: 'strong', scannerType: 'RSI + EMA Alignment', timestamp: '2026-03-23T04:10:00Z', status: 'new', reasoning: 'RSI crossing above 50 with price above EMA 20/50. Volume spike confirms momentum. Potential long setup.' },
  { id: '2', symbol: 'ETH/USDT', asset_class: 'crypto', timeframe: '1H', price: 3421.80, trend: 'bullish', signalStrength: 'moderate', scannerType: 'Breakout', timestamp: '2026-03-23T04:05:00Z', status: 'reviewed', reasoning: 'Price broke above 3400 resistance with above-average volume.' },
  { id: '3', symbol: 'AAPL', asset_class: 'stock', timeframe: 'Daily', price: 189.42, trend: 'neutral', signalStrength: 'weak', scannerType: 'MACD', timestamp: '2026-03-23T03:50:00Z', status: 'reviewed', reasoning: 'MACD crossover but below average volume. Conflicting signals on daily vs weekly. Skipping.' },
  { id: '4', symbol: 'SOL/USDT', asset_class: 'crypto', timeframe: '4H', price: 178.90, trend: 'bullish', signalStrength: 'strong', scannerType: 'Momentum', timestamp: '2026-03-23T03:45:00Z', status: 'sent_to_pipeline', reasoning: 'Strong uptrend, momentum sustained above 50 EMA. Volume confirms. R/R setup favorable.' },
  { id: '5', symbol: 'NVDA', asset_class: 'stock', timeframe: 'Daily', price: 876.30, trend: 'bearish', signalStrength: 'moderate', scannerType: 'Bollinger Bands', timestamp: '2026-03-23T03:30:00Z', status: 'new', reasoning: 'Price approaching upper Bollinger Band with declining volume. Potential mean reversion short.' },
  { id: '6', symbol: 'BNB/USDT', asset_class: 'crypto', timeframe: '1H', price: 412.20, trend: 'neutral', signalStrength: 'weak', scannerType: 'Volume Spike', timestamp: '2026-03-23T03:20:00Z', status: 'reviewed', reasoning: 'Volume spike detected but direction unclear. Waiting for confirmation.' },
];
