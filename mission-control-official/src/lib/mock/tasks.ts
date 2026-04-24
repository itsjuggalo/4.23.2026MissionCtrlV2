import { Task } from '../types';

export const mockTasks: Task[] = [
  { id: '1', title: 'Long BTC/USDT — RSI+EMA Setup', symbol: 'BTC/USDT', direction: 'long', status: 'in_progress', confidence: 87, assignedAgent: 'Strategy Analyst', createdAt: '2026-03-23T04:10:00Z', reasoning: 'RSI crossing above 50, price above EMA 20/50, volume confirmed.' },
  { id: '2', title: 'Long SOL/USDT — Momentum', symbol: 'SOL/USDT', direction: 'long', status: 'review', confidence: 83, assignedAgent: 'Strategy Analyst', createdAt: '2026-03-23T03:45:00Z', reasoning: 'Strong momentum with trend confirmation.' },
  { id: '3', title: 'Short NVDA — BB Reversion', symbol: 'NVDA', direction: 'short', status: 'backlog', confidence: 61, assignedAgent: 'Unassigned', createdAt: '2026-03-23T03:30:00Z', reasoning: 'Upper Bollinger Band touch, declining volume.' },
  { id: '4', title: 'Long ETH/USDT — Breakout', symbol: 'ETH/USDT', direction: 'long', status: 'approved', confidence: 79, assignedAgent: 'Execution Bot', createdAt: '2026-03-23T04:05:00Z', reasoning: 'Confirmed breakout above 3400 resistance.' },
  { id: '5', title: 'Long AAPL — MACD Cross', symbol: 'AAPL', direction: 'long', status: 'rejected', confidence: 45, assignedAgent: 'Strategy Analyst', createdAt: '2026-03-23T03:50:00Z', reasoning: 'Below average volume, conflicting signals on weekly timeframe. Rejected by Risk Engine.' },
];
