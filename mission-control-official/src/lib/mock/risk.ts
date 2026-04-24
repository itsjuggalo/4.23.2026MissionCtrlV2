import { RiskRule } from '../types';

export const mockRiskRules: RiskRule[] = [
  { id: '1', name: 'Max Risk Per Trade', description: 'Maximum capital at risk per single trade', status: 'ok', currentValue: '0.8%', limit: '1.0%' },
  { id: '2', name: 'Daily Drawdown Limit', description: 'Maximum allowed drawdown in a single day', status: 'warning', currentValue: '1.8%', limit: '2.0%' },
  { id: '3', name: 'Max Open Trades', description: 'Maximum simultaneous open positions', status: 'ok', currentValue: '2', limit: '5' },
  { id: '4', name: 'Stop Loss Required', description: 'Every trade must have a stop loss set', status: 'ok', currentValue: 'Enforced', limit: 'Always' },
  { id: '5', name: 'Minimum R/R Ratio', description: 'Minimum reward-to-risk ratio allowed', status: 'ok', currentValue: '2.4:1', limit: '2.0:1' },
  { id: '6', name: 'Single Asset Exposure', description: 'Max portfolio % in one asset', status: 'ok', currentValue: '11%', limit: '20%' },
];
