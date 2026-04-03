import type {
  Agent,
  Signal,
  Approval,
  TaskBoard,
  ActivityEntry,
  ScheduleItem,
  RecurringJob,
  Project,
  MemoryEntry,
  Doc,
  Wallet,
  RiskData,
  ActiveTrade,
} from './types';

export const agents: Agent[] = [
  { id: 1, name: 'Eric', role: 'Signal Filter', status: 'active', task: 'Running RSI scan on BTC/USDT', lastAction: 'Signal detected: BTC oversold on 4H', confidence: 0.92, uptime: '99.7%' },
  { id: 2, name: 'The Analyst', role: 'Technical Analysis', status: 'active', task: 'Monitoring portfolio exposure', lastAction: 'Adjusted stop-loss on ETH position', confidence: 0.88, uptime: '99.9%' },
  { id: 3, name: 'Execution Specialist', role: 'Trade Execution', status: 'idle', task: 'Awaiting approved trades', lastAction: 'Executed AAPL limit order', confidence: 0.95, uptime: '98.2%' },
  { id: 4, name: 'Macro Strategist', role: 'Macro Analysis', status: 'active', task: 'Parsing Fed minutes', lastAction: 'Updated macro outlook model', confidence: 0.84, uptime: '97.5%' },
  { id: 5, name: 'Risk Manager', role: 'Risk Control', status: 'idle', task: 'Indexing daily journal', lastAction: 'Stored 3 new trade insights', confidence: 0.91, uptime: '99.1%' },
];

export const signals: Signal[] = [
  { id: 1, symbol: 'BTC/USDT', asset: 'Crypto', timeframe: '4H', price: 67842.50, trend: 'bullish', strength: 94, source: 'RSI Scanner', time: '2m ago', status: 'new', reasoning: 'RSI crossed above 30 from oversold territory. Volume confirmation with 2.3x average. MACD histogram turning positive.' },
  { id: 2, symbol: 'ETH/USDT', asset: 'Crypto', timeframe: '1H', price: 3521.80, trend: 'bullish', strength: 87, source: 'MACD Signal', time: '5m ago', status: 'new', reasoning: 'MACD line crossed above signal line. Bullish divergence confirmed on 1H timeframe. Supporting volume increase.' },
  { id: 3, symbol: 'AAPL', asset: 'Stock', timeframe: '1D', price: 198.45, trend: 'neutral', strength: 62, source: 'EMA/SMA Trend', time: '12m ago', status: 'reviewing', reasoning: '50 EMA approaching 200 SMA. Potential golden cross forming. Wait for confirmation before entry.' },
  { id: 4, symbol: 'SOL/USDT', asset: 'Crypto', timeframe: '15m', price: 142.30, trend: 'bullish', strength: 91, source: 'Breakout Scanner', time: '1m ago', status: 'new', reasoning: 'Price broke above descending wedge resistance at $141.50. Volume spike 3.1x average. Strong momentum.' },
  { id: 5, symbol: 'NVDA', asset: 'Stock', timeframe: '4H', price: 875.20, trend: 'bullish', strength: 78, source: 'Momentum Scanner', time: '18m ago', status: 'reviewing', reasoning: 'Strong momentum following earnings beat. RSI at 68, not yet overbought. Sector rotation favoring tech.' },
  { id: 6, symbol: 'TSLA', asset: 'Stock', timeframe: '1D', price: 245.60, trend: 'bearish', strength: 72, source: 'Bollinger Bands', time: '22m ago', status: 'dismissed', reasoning: 'Price touched upper Bollinger Band with declining volume. Potential reversal signal. Watch for confirmation.' },
  { id: 7, symbol: 'AVAX/USDT', asset: 'Crypto', timeframe: '1H', price: 38.75, trend: 'bullish', strength: 83, source: 'Volume Spike', time: '8m ago', status: 'new', reasoning: 'Unusual volume spike detected - 4.2x 20-period average. Price holding above VWAP. Accumulation pattern.' },
  { id: 8, symbol: 'MSFT', asset: 'Stock', timeframe: '1D', price: 415.80, trend: 'neutral', strength: 55, source: 'RSI Scanner', time: '30m ago', status: 'reviewing', reasoning: 'RSI at midline (50). Price consolidating near all-time highs. Await directional break.' },
];

export const approvals: Approval[] = [
  { id: 1, symbol: 'BTC/USDT', type: 'Long', entry: 67500, target: 71000, stop: 66200, risk: '1.2%', reasoning: 'Oversold bounce with volume confirmation. Risk/reward 2.7:1. Aligns with macro thesis.', agent: 'Eric', time: '3m ago', status: 'pending' },
  { id: 2, symbol: 'SOL/USDT', type: 'Long', entry: 142.00, target: 155.00, stop: 138.50, risk: '0.8%', reasoning: 'Breakout trade. Strong momentum. Multiple timeframe alignment.', agent: 'Eric', time: '5m ago', status: 'pending' },
  { id: 3, symbol: 'AAPL', type: 'Long', entry: 197.50, target: 210.00, stop: 193.00, risk: '1.5%', reasoning: 'Golden cross forming. Earnings catalyst upcoming. Sector strength.', agent: 'Macro Strategist', time: '15m ago', status: 'approved' },
  { id: 4, symbol: 'TSLA', type: 'Short', entry: 248.00, target: 230.00, stop: 255.00, risk: '2.0%', reasoning: 'Bollinger Band reversal. Declining momentum. Overextended rally.', agent: 'The Analyst', time: '25m ago', status: 'rejected' },
];

export const taskBoard: TaskBoard = {
  backlog: [
    { id: 'T-007', title: 'Analyze DXY correlation', priority: 'medium', agent: 'Macro Strategist' },
    { id: 'T-008', title: 'Backtest momentum strategy', priority: 'low', agent: 'Unassigned' },
  ],
  inProgress: [
    { id: 'T-003', title: 'BTC 4H RSI analysis', priority: 'high', agent: 'Eric' },
    { id: 'T-004', title: 'Portfolio rebalance calc', priority: 'high', agent: 'Risk Manager' },
  ],
  review: [
    { id: 'T-005', title: 'SOL breakout trade plan', priority: 'high', agent: 'Eric' },
  ],
  done: [
    { id: 'T-001', title: 'AAPL golden cross alert', priority: 'medium', agent: 'Execution Specialist' },
    { id: 'T-002', title: 'Fed minutes parsing', priority: 'high', agent: 'Macro Strategist' },
  ],
};

export const activityFeed: ActivityEntry[] = [
  { time: '23:45:00', agent: 'BobaCat', action: 'EOD check complete', detail: 'LLY +0.13% from entry — stop intact, CPI tomorrow 8:30 AM EST', type: 'system' },
  { time: '23:30:00', agent: 'BobaCat', action: 'Discord updated', detail: '8 channels populated: announcements, executions, risk, lessons, trade-reviews, psych, macro-calendar, mission-control', type: 'system' },
  { time: '19:47:00', agent: 'BobaCat', action: 'EOD summary created', detail: 'LLY intraday high $957 faded on Novo Nordisk cross-trial data — closed $933.68', type: 'system' },
  { time: '12:00:00', agent: 'BobaCat', action: 'Morning brief delivered', detail: 'Stock of Day: LLY (FDA oral obesity pill). BTC: hold $66K-$68K ahead of CPI', type: 'signal' },
  { time: '09:35:00', agent: 'Execution Specialist', action: 'Position opened', detail: 'LLY LONG entry $932.48 — 10 shares. Catalyst: FDA Foundayo approval', type: 'execution' },
  { time: '09:30:00', agent: 'Risk Manager', action: 'Risk check passed', detail: 'LLY position approved — 9.3% account, max loss $484 (0.48%), R/R 1:2.5', type: 'risk' },
  { time: '08:30:00', agent: 'Macro Strategist', action: 'Alert issued', detail: 'CPI tomorrow April 3 — avoid BTC ±30 min around 8:30 AM EST. Volatility 2-4%', type: 'intel' },
  { time: '00:00:00', agent: 'System', action: 'Session start', detail: 'April 2, 2026 — all agents operational', type: 'system' },
];

export const schedule: ScheduleItem[] = [
  { time: '06:00', name: 'Pre-market scan', status: 'completed', type: 'scan' },
  { time: '06:30', name: 'Overnight positions review', status: 'completed', type: 'review' },
  { time: '09:30', name: 'Market open monitoring', status: 'completed', type: 'monitor' },
  { time: '12:00', name: 'Midday review & rebalance', status: 'active', type: 'review' },
  { time: '14:00', name: 'Afternoon scan cycle', status: 'active', type: 'scan' },
  { time: '16:00', name: 'Market close analysis', status: 'upcoming', type: 'review' },
  { time: '18:00', name: 'Evening summary & journal', status: 'upcoming', type: 'report' },
  { time: '20:00', name: 'Overnight strategy prep', status: 'upcoming', type: 'scan' },
];

export const recurringJobs: RecurringJob[] = [
  { name: 'Scanner heartbeat', interval: 'Every 30s', status: 'running' },
  { name: 'Risk monitor', interval: 'Every 1m', status: 'running' },
  { name: 'Portfolio sync', interval: 'Every 5m', status: 'running' },
  { name: 'Memory index', interval: 'Every 1h', status: 'running' },
];

export const projects: Project[] = [
  { name: 'Mission Control', progress: 72, status: 'active', tasks: 24, completed: 17 },
  { name: 'Strategy Engine', progress: 45, status: 'active', tasks: 18, completed: 8 },
  { name: 'Risk Engine', progress: 88, status: 'active', tasks: 12, completed: 11 },
  { name: 'Execution System', progress: 60, status: 'active', tasks: 15, completed: 9 },
  { name: 'Intelligence System', progress: 35, status: 'building', tasks: 20, completed: 7 },
];

export const memories: MemoryEntry[] = [
  { date: 'Mar 23', title: 'BTC post-Fed rally pattern', content: 'Historically, BTC rallies 8-12% within 2 weeks of dovish Fed signals. Current setup mirrors Dec 2023.', tags: ['btc', 'macro', 'pattern'] },
  { date: 'Mar 22', title: 'SOL breakout levels', content: 'Key resistance at $155, support at $135. Volume profile shows accumulation zone $138-142.', tags: ['sol', 'levels'] },
  { date: 'Mar 21', title: 'Portfolio heat map insight', content: 'Crypto exposure > 60% triggers drawdown risk. Optimal allocation: 55% crypto, 35% equities, 10% cash.', tags: ['risk', 'allocation'] },
  { date: 'Mar 20', title: 'NVDA earnings correlation', content: 'NVDA earnings beats correlate with 3-day sector momentum in semis. Use as leading indicator.', tags: ['nvda', 'earnings', 'correlation'] },
];

export const docs: Doc[] = [
  { title: 'Q1 Trading Playbook', type: 'Strategy', updated: 'Mar 20', pages: 12 },
  { title: 'Risk Management Framework', type: 'Policy', updated: 'Mar 18', pages: 8 },
  { title: 'Scanner Configuration Guide', type: 'Technical', updated: 'Mar 22', pages: 5 },
  { title: 'Weekly Market Report #12', type: 'Research', updated: 'Mar 23', pages: 6 },
  { title: 'Backtesting Results: Momentum v2', type: 'Research', updated: 'Mar 19', pages: 15 },
];

export const wallets: Wallet[] = [
  { name: 'Main Trading', type: 'Crypto', balance: 142580.50, change: 3.2, positions: 5 },
  { name: 'Brokerage', type: 'Equities', balance: 89340.20, change: 1.1, positions: 8 },
  { name: 'Reserve', type: 'Stables', balance: 50000.00, change: 0.0, positions: 1 },
];

export const riskData: RiskData = {
  exposure: 9.3,
  limit: 75,
  drawdown: 0.01,
  sharpe: 0,
  maxPosition: 15,
  openPositions: 1,
  alerts: [
    { level: 'warning', message: 'CPI release April 3 @ 8:30 AM EST — binary event. No new positions tonight.' },
    { level: 'warning', message: 'Novo Nordisk competitive data weakened LLY thesis — monitor closely' },
    { level: 'info', message: 'LLY stop $885 intact — max loss $484 (0.48% of account)' },
  ],
};

export const activeTrades: ActiveTrade[] = [
  { symbol: 'LLY', side: 'LONG', entry: 932.48, current: 933.68, pnl: '+0.13%' },
];
