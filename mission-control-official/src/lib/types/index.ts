export type AgentStatus = 'active' | 'idle' | 'error' | 'paused';
export type SignalStrength = 'strong' | 'moderate' | 'weak';
export type TradeDirection = 'long' | 'short';
export type TaskStatus = 'backlog' | 'in_progress' | 'review' | 'approved' | 'rejected';
export type WalletType = 'crypto_exchange' | 'stock_broker' | 'paper_trading';
export type WalletStatus = 'active' | 'inactive' | 'error';
export type RiskStatus = 'ok' | 'warning' | 'blocked';

export interface Agent {
  id: string;
  name: string;
  role: string;
  status: AgentStatus;
  currentTask: string;
  lastAction: string;
  confidence: number;
  lastActiveAt: string;
}

export interface ScanResult {
  id: string;
  symbol: string;
  asset_class: 'crypto' | 'stock';
  timeframe: string;
  price: number;
  trend: 'bullish' | 'bearish' | 'neutral';
  signalStrength: SignalStrength;
  scannerType: string;
  timestamp: string;
  status: 'new' | 'reviewed' | 'sent_to_pipeline';
  reasoning?: string;
}

export interface Task {
  id: string;
  title: string;
  symbol: string;
  direction: TradeDirection;
  status: TaskStatus;
  confidence: number;
  assignedAgent: string;
  createdAt: string;
  reasoning: string;
}

export interface Wallet {
  id: string;
  name: string;
  type: WalletType;
  status: WalletStatus;
  totalBalance: number;
  availableFunds: number;
  fundsInTrades: number;
  currency: string;
  assets: { symbol: string; amount: number; value: number; }[];
  exchange?: string;
}

export interface RiskRule {
  id: string;
  name: string;
  description: string;
  status: RiskStatus;
  currentValue: string;
  limit: string;
}

export interface ActivityEvent {
  id: string;
  type: 'scanner' | 'agent' | 'decision' | 'memory' | 'execution' | 'risk_rejection';
  message: string;
  timestamp: string;
  severity: 'info' | 'warning' | 'success' | 'error';
}

export interface SimPosition {
  id: string;
  symbol: string;
  direction: TradeDirection;
  entryPrice: number;
  currentPrice: number;
  quantity: number;
  notionalValue: number;
  stopLoss: number;
  takeProfit: number;
  riskAmount: number;
  riskPct: number;
  unrealizedPnL: number;
  unrealizedPnLPct: number;
  rrRatio: number;
  status: 'open' | 'closed' | 'stopped_out' | 'target_hit';
  openedAt: string;
  closedAt?: string;
  closePrice?: number;
  realizedPnL?: number;
  walletId: string;
  scanSignalId?: string;
  rejectionReason?: string;
}

export interface RiskValidationResult {
  passed: boolean;
  rejectionReason?: string;
  checks: {
    name: string;
    passed: boolean;
    message: string;
  }[];
}

export interface TradeProposal {
  id: string;
  symbol: string;
  direction: TradeDirection;
  entryPrice: number;
  stopLoss: number;
  takeProfit: number;
  quantity: number;
  walletId: string;
  confidence: number;
  signalId?: string;
  reasoning: string;
  proposedAt: string;
  status: 'pending' | 'approved' | 'rejected' | 'executed';
  rejectionReason?: string;
}

export interface SimState {
  positions: SimPosition[];
  closedPositions: SimPosition[];
  proposals: TradeProposal[];
  walletBalances: Record<string, number>;
  dailyPnL: number;
  totalPnL: number;
  totalTrades: number;
  winningTrades: number;
  events: ActivityEvent[];
}
