export interface Agent {
  id: number;
  name: string;
  role: string;
  status: 'active' | 'idle' | 'offline';
  task: string;
  lastAction: string;
  confidence: number;
  uptime: string;
}

export interface Signal {
  id: number;
  symbol: string;
  asset: 'Crypto' | 'Stock';
  timeframe: string;
  price: number;
  trend: 'bullish' | 'bearish' | 'neutral';
  strength: number;
  source: string;
  time: string;
  status: 'new' | 'reviewing' | 'dismissed';
  reasoning: string;
}

export interface Approval {
  id: number;
  symbol: string;
  type: 'Long' | 'Short';
  entry: number;
  target: number;
  stop: number;
  risk: string;
  reasoning: string;
  agent: string;
  time: string;
  status: 'pending' | 'approved' | 'rejected';
}

export interface Task {
  id: string;
  title: string;
  priority: 'high' | 'medium' | 'low';
  agent: string;
}

export interface TaskBoard {
  backlog: Task[];
  inProgress: Task[];
  review: Task[];
  done: Task[];
}

export interface ActivityEntry {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: 'signal' | 'risk' | 'intel' | 'execution' | 'memory' | 'system';
}

export interface ScheduleItem {
  time: string;
  name: string;
  status: 'completed' | 'active' | 'upcoming';
  type: 'scan' | 'review' | 'monitor' | 'report';
}

export interface RecurringJob {
  name: string;
  interval: string;
  status: 'running' | 'stopped';
}

export interface Project {
  name: string;
  progress: number;
  status: 'active' | 'building';
  tasks: number;
  completed: number;
}

export interface MemoryEntry {
  date: string;
  title: string;
  content: string;
  tags: string[];
}

export interface Doc {
  title: string;
  type: 'Strategy' | 'Policy' | 'Technical' | 'Research';
  updated: string;
  pages: number;
}

export interface Wallet {
  name: string;
  type: 'Crypto' | 'Equities' | 'Stables';
  balance: number;
  change: number;
  positions: number;
}

export interface RiskAlert {
  level: 'warning' | 'info';
  message: string;
}

export interface RiskData {
  exposure: number;
  limit: number;
  drawdown: number;
  sharpe: number;
  maxPosition: number;
  openPositions: number;
  alerts: RiskAlert[];
}

export interface ActiveTrade {
  symbol: string;
  side: 'LONG' | 'SHORT';
  entry: number;
  current: number;
  pnl: string;
}
