import { Wallet } from '../types';

export const mockWallets: Wallet[] = [
  { 
    id: '1', 
    name: 'Alpaca Paper Trading', 
    type: 'paper_trading', 
    status: 'active', 
    totalBalance: 100000, 
    availableFunds: 100000, 
    fundsInTrades: 0, 
    currency: 'USD', 
    exchange: 'Alpaca', 
    assets: [] 
  },
  { 
    id: '2', 
    name: 'Binance Paper (Future)', 
    type: 'paper_trading', 
    status: 'inactive', 
    totalBalance: 0, 
    availableFunds: 0, 
    fundsInTrades: 0, 
    currency: 'USDT', 
    exchange: 'Binance', 
    assets: [] 
  },
];
