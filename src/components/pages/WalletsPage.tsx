'use client';

import { useEffect, useState } from 'react';

interface Asset {
  symbol: string;
  amount: number;
  value_usd: number;
  percentage: number;
}

interface ExchangeData {
  exchange: string;
  connected: boolean;
  total_usd: number;
  assets: Array<{
    symbol: string;
    amount: number;
    value_usd: number;
  }>;
  error?: string;
}

interface WalletData {
  success: boolean;
  timestamp: string;
  total_value_usd: number;
  exchanges: {
    coinbase: ExchangeData;
    hyperliquid: ExchangeData;
    robinhood: ExchangeData;
  };
  portfolio: {
    total_assets: number;
    assets: Asset[];
  };
}

export function WalletsPage() {
  const [walletData, setWalletData] = useState<WalletData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchWalletData();
    // Refresh every 30 seconds
    const interval = setInterval(fetchWalletData, 30000);
    return () => clearInterval(interval);
  }, []);

  const fetchWalletData = async () => {
    try {
      const response = await fetch('/api/wallets');
      const data = await response.json();
      
      if (data.success) {
        setWalletData(data);
        setError(null);
      } else {
        setError(data.error || 'Failed to fetch wallet data');
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unknown error');
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="p-8">
        <h1 className="text-2xl font-bold mb-6">Wallets</h1>
        <div className="text-center py-12">
          <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-500 mx-auto"></div>
          <p className="mt-4 text-gray-400">Loading wallet data...</p>
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="p-8">
        <h1 className="text-2xl font-bold mb-6">Wallets</h1>
        <div className="bg-red-900/20 border border-red-500 rounded-lg p-6">
          <p className="text-red-400">Error: {error}</p>
          <button 
            onClick={fetchWalletData}
            className="mt-4 px-4 py-2 bg-red-600 hover:bg-red-700 rounded"
          >
            Retry
          </button>
        </div>
      </div>
    );
  }

  if (!walletData) {
    return null;
  }

  const { coinbase, hyperliquid, robinhood } = walletData.exchanges;
  const hasAnyConnection = coinbase.connected || hyperliquid.connected || robinhood?.connected;

  return (
    <div className="p-8">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Wallets</h1>
        <button 
          onClick={fetchWalletData}
          className="px-4 py-2 bg-blue-600 hover:bg-blue-700 rounded text-sm"
        >
          Refresh
        </button>
      </div>

      {/* Total Portfolio Value */}
      <div className="bg-slate-800 rounded-lg p-6 mb-6">
        <p className="text-gray-400 text-sm mb-2">Total Portfolio Value</p>
        <p className="text-4xl font-bold text-green-400">
          ${walletData.total_value_usd.toLocaleString(undefined, { 
            minimumFractionDigits: 2, 
            maximumFractionDigits: 2 
          })}
        </p>
        <p className="text-gray-500 text-sm mt-2">
          Last updated: {new Date(walletData.timestamp).toLocaleTimeString()}
        </p>
      </div>

      {/* Exchange Status */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-6">
        {/* Coinbase */}
        <div className="bg-slate-800 rounded-lg p-6">
          <div className="flex items-center justify-between mb-4">
            <h2 className="text-xl font-semibold">Coinbase</h2>
            <div className={`px-3 py-1 rounded text-sm ${
              coinbase.connected ? 'bg-green-900/30 text-green-400' : 'bg-red-900/30 text-red-400'
            }`}>
              {coinbase.connected ? '● Connected' : '○ Disconnected'}
            </div>
          </div>
          
          {coinbase.error ? (
            <p className="text-red-400 text-sm">{coinbase.error}</p>
          ) : (
            <>
              <p className="text-2xl font-bold text-white mb-4">
                ${coinbase.total_usd.toLocaleString(undefined, { 
                  minimumFractionDigits: 2, 
                  maximumFractionDigits: 2 
                })}
              </p>
              {coinbase.assets.length > 0 ? (
                <div className="space-y-2">
                  {coinbase.assets.map((asset, idx) => (
                    <div key={idx} className="flex justify-between text-sm">
                      <span className="text-gray-400">{asset.symbol}</span>
                      <span className="text-white">{asset.amount.toFixed(4)}</span>
                      <span className="text-green-400">${asset.value_usd.toFixed(2)}</span>
                    </div>
                  ))}
                </div>
              ) : (
                <p className="text-gray-500 text-sm">No assets</p>
              )}
            </>
          )}
        </div>

        {/* Robinhood */}
        {robinhood && (
          <div className="bg-slate-800 rounded-lg p-6">
            <div className="flex items-center justify-between mb-4">
              <div className="flex items-center gap-2">
                <span className="text-green-500 font-bold text-lg">$</span>
                <h2 className="text-xl font-semibold">Robinhood</h2>
              </div>
              <div className={`px-3 py-1 rounded text-sm ${
                robinhood.connected ? 'bg-green-900/30 text-green-400' : 'bg-red-900/30 text-red-400'
              }`}>
                {robinhood.connected ? '● Connected' : '○ Disconnected'}
              </div>
            </div>
            {robinhood.error ? (
              <p className="text-red-400 text-sm">{robinhood.error}</p>
            ) : (
              <>
                <p className="text-2xl font-bold text-white mb-4">
                  ${robinhood.total_usd.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
                </p>
                {robinhood.assets.length > 0 ? (
                  <div className="space-y-2">
                    {robinhood.assets.map((asset, idx) => (
                      <div key={idx} className="flex justify-between text-sm">
                        <span className="text-gray-400">{asset.symbol}</span>
                        <span className="text-white">{asset.amount.toFixed(4)}</span>
                        <span className="text-green-400">${asset.value_usd.toFixed(2)}</span>
                      </div>
                    ))}
                  </div>
                ) : (
                  <p className="text-gray-500 text-sm">No holdings</p>
                )}
              </>
            )}
          </div>
        )}

        {/* Hyperliquid */}
        <div className="bg-slate-800 rounded-lg p-6">
          <div className="flex items-center justify-between mb-4">
            <h2 className="text-xl font-semibold">Hyperliquid</h2>
            <div className={`px-3 py-1 rounded text-sm ${
              hyperliquid.connected ? 'bg-green-900/30 text-green-400' : 'bg-red-900/30 text-red-400'
            }`}>
              {hyperliquid.connected ? '● Connected' : '○ Disconnected'}
            </div>
          </div>
          
          {hyperliquid.error ? (
            <p className="text-red-400 text-sm">{hyperliquid.error}</p>
          ) : (
            <>
              <p className="text-2xl font-bold text-white mb-4">
                ${hyperliquid.total_usd.toLocaleString(undefined, { 
                  minimumFractionDigits: 2, 
                  maximumFractionDigits: 2 
                })}
              </p>
              {hyperliquid.assets.length > 0 ? (
                <div className="space-y-2">
                  {hyperliquid.assets.map((asset, idx) => (
                    <div key={idx} className="flex justify-between text-sm">
                      <span className="text-gray-400">{asset.symbol}</span>
                      <span className="text-white">{asset.amount.toFixed(4)}</span>
                      <span className="text-green-400">${asset.value_usd.toFixed(2)}</span>
                    </div>
                  ))}
                </div>
              ) : (
                <p className="text-gray-500 text-sm">No assets</p>
              )}
            </>
          )}
        </div>
      </div>

      {/* Portfolio Breakdown */}
      {walletData.portfolio.assets.length > 0 && (
        <div className="bg-slate-800 rounded-lg p-6">
          <h2 className="text-xl font-semibold mb-4">Portfolio Breakdown</h2>
          <div className="space-y-3">
            {walletData.portfolio.assets.map((asset, idx) => (
              <div key={idx} className="flex items-center justify-between">
                <div className="flex-1">
                  <div className="flex justify-between mb-1">
                    <span className="font-medium">{asset.symbol}</span>
                    <span className="text-gray-400">{asset.percentage.toFixed(1)}%</span>
                  </div>
                  <div className="w-full bg-slate-700 rounded-full h-2">
                    <div 
                      className="bg-blue-500 h-2 rounded-full transition-all"
                      style={{ width: `${asset.percentage}%` }}
                    />
                  </div>
                </div>
                <div className="ml-6 text-right">
                  <p className="text-white font-medium">${asset.value_usd.toFixed(2)}</p>
                  <p className="text-gray-400 text-sm">{asset.amount.toFixed(4)}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* No wallets connected state */}
      {!hasAnyConnection && (
        <div className="bg-slate-800 rounded-lg p-12 text-center">
          <p className="text-xl text-gray-300 mb-4">No Wallets Connected</p>
          <p className="text-gray-500 mb-6">
            Configure your API keys in the .env file to connect exchanges
          </p>
          <div className="text-left max-w-md mx-auto bg-slate-900 rounded p-4 text-sm font-mono">
            <p className="text-gray-400"># Add to .env file:</p>
            <p className="text-green-400 mt-2">COINBASE_API_KEY=your_key</p>
            <p className="text-green-400">COINBASE_API_SECRET=your_secret</p>
            <p className="text-green-400 mt-2">HYPERLIQUID_WALLET_ADDRESS=0x...</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default WalletsPage;
