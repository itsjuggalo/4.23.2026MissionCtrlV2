import { create } from 'zustand';

// ============================================================================
// Mission Control Zustand Store
// Centralized state — fetch once, share everywhere, no duplicate API calls
// ============================================================================

interface Position {
  symbol: string;
  qty: string;
  avg_entry_price: string;
  current_price: string;
  unrealized_pl: string;
  unrealized_plpc: string;
  unrealized_intraday_pl: string;
  change_today: string;
  market_value: string;
}

interface PortfolioState {
  equity: number;
  cash: number;
  buying_power: number;
  last_equity: number;
  positions: Position[];
  daily_pnl: number;
  daily_pnl_pct: number;
  total_return: number;
}

interface RegimeState {
  overall_regime: string;
  direction_bias: string;
  overall_recommendation: string;
  timeframes: Record<string, any>;
  timestamp: string;
}

interface SignalState {
  direction: string;
  entry_price: number;
  signal_count: number;
  last_signal_time: string;
  pnl_history: any[];
}

interface ActivityEntry {
  time: string;
  agent: string;
  action: string;
  detail: string;
  type: string;
}

interface MissionControlStore {
  // Data
  portfolio: PortfolioState;
  regime: RegimeState;
  btcSignal: SignalState;
  activities: ActivityEntry[];
  agents: any[];
  stats: any;
  crypto: any;
  report: any;
  params: any;

  // Meta
  lastFetch: Record<string, number>;
  isLoading: boolean;
  error: string | null;

  // Actions
  fetchPortfolio: () => Promise<void>;
  fetchRegime: () => Promise<void>;
  fetchSignals: () => Promise<void>;
  fetchActivities: () => Promise<void>;
  fetchAgents: () => Promise<void>;
  fetchStats: () => Promise<void>;
  fetchCrypto: () => Promise<void>;
  fetchReport: () => Promise<void>;
  fetchParams: () => Promise<void>;
  fetchAll: () => Promise<void>;

  // Helpers
  shouldFetch: (key: string, intervalMs: number) => boolean;
}

const DEFAULT_PORTFOLIO: PortfolioState = {
  equity: 0, cash: 0, buying_power: 0, last_equity: 0,
  positions: [], daily_pnl: 0, daily_pnl_pct: 0, total_return: 0,
};

const DEFAULT_REGIME: RegimeState = {
  overall_regime: 'UNKNOWN', direction_bias: '', overall_recommendation: '',
  timeframes: {}, timestamp: '',
};

const DEFAULT_SIGNAL: SignalState = {
  direction: 'N/A', entry_price: 0, signal_count: 0,
  last_signal_time: '', pnl_history: [],
};

export const useMissionControl = create<MissionControlStore>((set, get) => ({
  portfolio: DEFAULT_PORTFOLIO,
  regime: DEFAULT_REGIME,
  btcSignal: DEFAULT_SIGNAL,
  activities: [],
  agents: [],
  stats: null,
  crypto: null,
  report: null,
  params: null,

  lastFetch: {},
  isLoading: false,
  error: null,

  shouldFetch: (key: string, intervalMs: number) => {
    const last = get().lastFetch[key] || 0;
    return Date.now() - last > intervalMs;
  },

  fetchPortfolio: async () => {
    if (!get().shouldFetch('portfolio', 10000)) return;
    try {
      const res = await fetch('/api/portfolio');
      const data = await res.json();
      if (data) {
        const equity = parseFloat(data.equity || data.balance || '0');
        const lastEq = parseFloat(data.last_equity || '0');
        const cash = parseFloat(data.cash || '0');
        const bp = parseFloat(data.buying_power || '0');
        const dailyPnl = equity - lastEq;
        const dailyPct = lastEq ? (dailyPnl / lastEq * 100) : 0;
        const totalReturn = ((equity - 100000) / 100000 * 100);

        set({
          portfolio: {
            equity, cash, buying_power: bp, last_equity: lastEq,
            positions: data.positions || [],
            daily_pnl: dailyPnl, daily_pnl_pct: dailyPct,
            total_return: totalReturn,
          },
          lastFetch: { ...get().lastFetch, portfolio: Date.now() },
        });
      }
    } catch (e) {
      console.error('[store] Portfolio fetch error:', e);
    }
  },

  fetchRegime: async () => {
    if (!get().shouldFetch('regime', 30000)) return;
    try {
      const res = await fetch('/api/regime');
      const data = await res.json();
      if (data) {
        set({
          regime: {
            overall_regime: data.overall_regime || data.regime || 'UNKNOWN',
            direction_bias: data.direction_bias || data.bias || '',
            overall_recommendation: data.overall_recommendation || '',
            timeframes: data.timeframes || {},
            timestamp: data.timestamp || '',
          },
          lastFetch: { ...get().lastFetch, regime: Date.now() },
        });
      }
    } catch (e) {
      console.error('[store] Regime fetch error:', e);
    }
  },

  fetchSignals: async () => {
    if (!get().shouldFetch('signals', 15000)) return;
    try {
      const res = await fetch('/api/signals/latest');
      const data = await res.json();
      if (data?.BTCUSD) {
        set({
          btcSignal: {
            direction: data.BTCUSD.direction || 'N/A',
            entry_price: data.BTCUSD.entry_price || 0,
            signal_count: data.BTCUSD.signal_count || 0,
            last_signal_time: data.BTCUSD.last_signal_time || '',
            pnl_history: data.BTCUSD.pnl_history || [],
          },
          lastFetch: { ...get().lastFetch, signals: Date.now() },
        });
      }
    } catch (e) {
      console.error('[store] Signals fetch error:', e);
    }
  },

  fetchActivities: async () => {
    if (!get().shouldFetch('activities', 15000)) return;
    try {
      const res = await fetch('/api/activity');
      const data = await res.json();
      const items = Array.isArray(data) ? data : data?.entries || [];
      set({
        activities: items,
        lastFetch: { ...get().lastFetch, activities: Date.now() },
      });
    } catch (e) {
      console.error('[store] Activities fetch error:', e);
    }
  },

  fetchAgents: async () => {
    if (!get().shouldFetch('agents', 10000)) return;
    try {
      const res = await fetch('/api/agents');
      const data = await res.json();
      set({
        agents: Array.isArray(data) ? data : data?.agents || [],
        lastFetch: { ...get().lastFetch, agents: Date.now() },
      });
    } catch (e) {
      console.error('[store] Agents fetch error:', e);
    }
  },

  fetchStats: async () => {
    if (!get().shouldFetch('stats', 30000)) return;
    try {
      const res = await fetch('/api/openclaw-stats');
      const data = await res.json();
      set({
        stats: data,
        lastFetch: { ...get().lastFetch, stats: Date.now() },
      });
    } catch (e) {
      console.error('[store] Stats fetch error:', e);
    }
  },

  fetchCrypto: async () => {
    if (!get().shouldFetch('crypto', 30000)) return;
    try {
      const res = await fetch('/api/crypto');
      const data = await res.json();
      set({
        crypto: data,
        lastFetch: { ...get().lastFetch, crypto: Date.now() },
      });
    } catch (e) {
      console.error('[store] Crypto fetch error:', e);
    }
  },

  fetchReport: async () => {
    if (!get().shouldFetch('report', 60000)) return;
    try {
      const res = await fetch('/api/daily-report');
      const data = await res.json();
      set({
        report: data,
        lastFetch: { ...get().lastFetch, report: Date.now() },
      });
    } catch (e) {
      console.error('[store] Report fetch error:', e);
    }
  },

  fetchParams: async () => {
    if (!get().shouldFetch('params', 300000)) return;
    try {
      const res = await fetch('/api/supertrend-params');
      const data = await res.json();
      set({
        params: data,
        lastFetch: { ...get().lastFetch, params: Date.now() },
      });
    } catch (e) {
      console.error('[store] Params fetch error:', e);
    }
  },

  fetchAll: async () => {
    set({ isLoading: true });
    const state = get();
    await Promise.all([
      state.fetchPortfolio(),
      state.fetchRegime(),
      state.fetchSignals(),
      state.fetchActivities(),
      state.fetchAgents(),
      state.fetchStats(),
      state.fetchCrypto(),
      state.fetchReport(),
      state.fetchParams(),
    ]);
    set({ isLoading: false });
  },
}));
