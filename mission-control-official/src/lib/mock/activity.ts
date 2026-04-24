import { ActivityEvent } from '../types';

export const mockActivity: ActivityEvent[] = [
  { id: '1', type: 'scanner', message: 'BTC/USDT 4H: Strong RSI + EMA signal detected', timestamp: '2026-03-23T04:10:00Z', severity: 'success' },
  { id: '2', type: 'agent', message: 'Risk Guard: Daily drawdown approaching limit (1.8% / 2.0%)', timestamp: '2026-03-23T04:08:00Z', severity: 'warning' },
  { id: '3', type: 'execution', message: '[SIM] Executed LONG ETH/USDT @ 3421.80 — 0.5 ETH', timestamp: '2026-03-23T04:06:00Z', severity: 'info' },
  { id: '4', type: 'decision', message: 'SOL/USDT momentum trade sent to Review queue', timestamp: '2026-03-23T03:46:00Z', severity: 'info' },
  { id: '5', type: 'risk_rejection', message: 'AAPL long rejected: confidence below threshold (45% < 60%)', timestamp: '2026-03-23T03:51:00Z', severity: 'error' },
  { id: '6', type: 'memory', message: 'Intel Aggregator: Stored insight — BTC dominance rising, alt rotation expected', timestamp: '2026-03-23T03:40:00Z', severity: 'info' },
  { id: '7', type: 'scanner', message: 'NVDA Daily: Bollinger Band upper touch detected', timestamp: '2026-03-23T03:30:00Z', severity: 'info' },
];
