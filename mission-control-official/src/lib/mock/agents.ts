import { Agent } from '../types';

export const mockAgents: Agent[] = [
  { id: '1', name: 'Alpha Scanner', role: 'Market Scanner', status: 'active', currentTask: 'Scanning BTC/ETH momentum signals', lastAction: 'Found RSI divergence on BTC 4H', confidence: 87, lastActiveAt: '2 min ago' },
  { id: '2', name: 'Risk Guard', role: 'Risk Engine', status: 'active', currentTask: 'Monitoring open exposure', lastAction: 'Blocked trade: drawdown limit approaching', confidence: 99, lastActiveAt: '30 sec ago' },
  { id: '3', name: 'Strategy Analyst', role: 'Strategy Engine', status: 'idle', currentTask: 'Awaiting scanner input', lastAction: 'Evaluated AAPL breakout — weak signal', confidence: 62, lastActiveAt: '15 min ago' },
  { id: '4', name: 'Execution Bot', role: 'Trade Execution', status: 'paused', currentTask: 'Simulation mode — no live trades', lastAction: 'Simulated LONG ETH @ 3420', confidence: 94, lastActiveAt: '8 min ago' },
  { id: '5', name: 'Intel Aggregator', role: 'Intelligence', status: 'active', currentTask: 'Aggregating market sentiment', lastAction: 'Updated memory: BTC dominance rising', confidence: 78, lastActiveAt: '5 min ago' },
];
