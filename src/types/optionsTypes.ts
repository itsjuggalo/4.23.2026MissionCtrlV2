// Shared types for OptionsPage (desktop) and OptionsPageMobile

export interface AnalystSignal {
  id: string;
  source: string;
  sourceGroup: 'name' | 'vivid';
  tab: 'scalps' | 'swings' | 'leaps';
  symbol: string;
  shortName: string;
  strike: string | number;
  expiry: number | null;
  isPut: boolean;
  isWeekly: boolean;
  isFree: boolean;
  risk: string;
  category: string;
  buyTarget: number | null;
  earlyTarget: number | null;
  stopLoss: number | null;
  reduceLoss: number | null;
  sellTarget: number | null;
  sellTarget2: number | null;
  sellTarget3: number | null;
  status: string;
  exitTime: number | null;
  isClosed: boolean;
  ts: number;
  logoUrl: string | null;
  logoFallback: string;
  expiryStr: string;
  contractLabel: string;
  ribbonType: 'open' | 'profit' | 'stopped' | 'riding';
  ribbonLabel: string;
}

export interface AnalystResponse {
  generated_at: string;
  stats: {
    openTotal: number;
    closedTotal: number;
    recentClosed: number;
    winRate30d: number;
    scalpsOpen: number;
    swingsOpen: number;
    leapsOpen: number;
    sourceOpenCounts: { name: number; vivid: number };
  };
  byTab: {
    scalps: { open: AnalystSignal[]; closed: AnalystSignal[] };
    swings: { open: AnalystSignal[]; closed: AnalystSignal[] };
    leaps:  { open: AnalystSignal[]; closed: AnalystSignal[] };
  };
}

export interface FlowEntry {
  Symbol: string;
  OptionSymbol: string;
  Strike: number;
  OptionType: 'Call' | 'Put';
  ExpiryStr: string;
  Price: number;
  Value: number;
  Volume: number;
  OI: number;
  BidAskType: string;
  BlockType: 'SWEEP' | 'BLOCK' | string;
  Time: number;
  logoUrl?: string | null;
}

export interface AlertEntry {
  AlertType: string;
  Symbol: string;
  OptionSymbol: string;
  Strike: number;
  OptionType: 'Call' | 'Put';
  ExpiryStr: string;
  AlertPrice: number;
  totalFlowValue: number;
  SWEEPS: number;
  BLOCKS: number;
  Volume: number;
  OI: number;
  DTE: number;
  isBullish: boolean;
  Updated: number;
  logoUrl?: string | null;
  _history?: {
    firstPrice: number;
    lastPrice: number;
    maxPrice: number;
    gainPct: number;
    maxGainPct: number;
    numUpdates: number;
    firstSeen: number;
    lastSeen: number;
  };
}

// API returns `flows` (not `flow`) — both pages use this shape
export interface FlowResponse {
  alerts: AlertEntry[];
  flows: FlowEntry[];
  availableDates?: string[];
}
