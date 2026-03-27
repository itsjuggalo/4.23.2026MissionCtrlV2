import { NextRequest, NextResponse } from 'next/server';
import crypto from 'crypto';

interface Asset {
  symbol: string;
  amount: number;
  value_usd: number;
}

interface WalletBalance {
  address?: string;
  account_id?: string;
  balance_usd: number;
  assets: Asset[];
  error?: string;
}

interface ExchangeData {
  exchange: string;
  connected: boolean;
  total_usd: number;
  assets: Asset[];
  error?: string;
  wallets?: WalletBalance[];
}

interface WalletResponse {
  success: boolean;
  timestamp: string;
  total_value_usd: number;
  exchanges: {
    coinbase: ExchangeData;
    hyperliquid: ExchangeData;
  };
  portfolio: {
    total_assets: number;
    assets: Array<{
      symbol: string;
      amount: number;
      value_usd: number;
      percentage: number;
    }>;
  };
}

// Fetch Hyperliquid balances for a single wallet (public API - no auth needed)
async function getHyperliquidBalance(address: string): Promise<{ assets: Asset[]; total_usd: number }> {
  const assets: Asset[] = [];
  let totalValue = 0;

  try {
    // Hyperliquid Info API - public endpoint for wallet balances
    const response = await fetch('https://api.hyperliquid.xyz/info', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        type: 'spotBalances',
        user: address,
      }),
    });

    if (!response.ok) {
      throw new Error(`Hyperliquid API returned ${response.status}`);
    }

    const data = await response.json();

    if (Array.isArray(data)) {
      for (const coin of data) {
        if (coin.total && parseFloat(coin.total) > 0) {
          const symbol = coin.coin || 'Unknown';
          const amount = parseFloat(coin.total);

          // Fetch real price from Hyperliquid
          let price = 1;
          try {
            const priceRes = await fetch('https://api.hyperliquid.xyz/info', {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify({
                type: 'lastPrice',
                coin: symbol,
              }),
            });
            if (priceRes.ok) {
              const priceData = await priceRes.json();
              price = parseFloat(priceData) || 1;
            }
          } catch (e) {
            // Use fallback price
          }

          const value = amount * price;
          assets.push({ symbol, amount, value_usd: value });
          totalValue += value;
        }
      }
    }
  } catch (error) {
    throw error;
  }

  return { assets, total_usd: totalValue };
}

// Fetch Coinbase balances using OAuth API
async function getCoinbaseBalance(): Promise<{ assets: Asset[]; total_usd: number }> {
  const assets: Asset[] = [];
  let totalValue = 0;

  const apiKey = process.env.COINBASE_API_KEY;
  const apiSecret = process.env.COINBASE_API_SECRET;

  if (!apiKey || !apiSecret) {
    throw new Error('Coinbase API credentials not configured');
  }

  try {
    // Build request for Coinbase API v2
    const method = 'GET';
    const requestPath = '/v2/accounts';
    const body = '';
    const timestamp = Math.floor(Date.now() / 1000).toString();
    const message = timestamp + method + requestPath + body;

    // Create HMAC SHA256 signature
    const signature = crypto
      .createHmac('sha256', apiSecret)
      .update(message)
      .digest('hex');

    const response = await fetch(`https://api.coinbase.com${requestPath}`, {
      method,
      headers: {
        'CB-ACCESS-KEY': apiKey,
        'CB-ACCESS-SIGN': signature,
        'CB-ACCESS-TIMESTAMP': timestamp,
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(
        `Coinbase API returned ${response.status}: ${
          errorData.errors?.[0]?.message || 'Check API key/secret format'
        }`
      );
    }

    const data = await response.json();

    if (data.data && Array.isArray(data.data)) {
      for (const account of data.data) {
        const symbol = account.currency?.code || 'Unknown';
        const amount = parseFloat(account.balance?.amount || 0);

        if (amount > 0) {
          // For Coinbase, we'd need to fetch prices separately
          // For now, assume USD or convert via exchange rate
          const valueUsd = amount;

          assets.push({
            symbol,
            amount,
            value_usd: valueUsd,
          });
          totalValue += valueUsd;
        }
      }
    }
  } catch (error) {
    throw error;
  }

  return { assets, total_usd: totalValue };
}

export async function GET(request: NextRequest): Promise<NextResponse<WalletResponse>> {
  try {
    // Hyperliquid: Support multiple wallets
    const wallet1 = process.env.HYPERLIQUID_WALLET_ADDRESS_1;
    const wallet2 = process.env.HYPERLIQUID_WALLET_ADDRESS_2;
    const fallbackWallet = process.env.HYPERLIQUID_WALLET_ADDRESS || '0xcb37ed9a607c305E181422B028A92BC747D9CE86';

    const hyperliquidWallets = [
      wallet1 || fallbackWallet,
      wallet2,
    ].filter((w): w is string => Boolean(w));

    let hyperliquidData: ExchangeData = {
      exchange: 'hyperliquid',
      connected: false,
      total_usd: 0,
      assets: [],
      wallets: [],
    };

    // Fetch Hyperliquid data (should work with public API)
    try {
      const walletBalances = await Promise.all(
        hyperliquidWallets.map(async (address) => {
          try {
            const { assets, total_usd } = await getHyperliquidBalance(address);
            return { address, assets, balance_usd: total_usd };
          } catch (error) {
            return {
              address,
              assets: [],
              balance_usd: 0,
              error: error instanceof Error ? error.message : 'Failed to fetch',
            };
          }
        })
      );

      // Combine all assets from all wallets
      const allAssets: Asset[] = [];
      let totalValue = 0;

      for (const wallet of walletBalances) {
        for (const asset of wallet.assets) {
          const existing = allAssets.find((a) => a.symbol === asset.symbol);
          if (existing) {
            existing.amount += asset.amount;
            existing.value_usd += asset.value_usd;
          } else {
            allAssets.push({ ...asset });
          }
          totalValue += asset.value_usd;
        }
      }

      if (allAssets.length > 0 || walletBalances.some((w) => w.balance_usd > 0)) {
        hyperliquidData = {
          exchange: 'hyperliquid',
          connected: true,
          total_usd: totalValue,
          assets: allAssets,
          wallets: walletBalances.map((w) => ({
            address: w.address,
            balance_usd: w.balance_usd,
            assets: w.assets,
            error: w.error,
          })),
        };
      }
    } catch (error) {
      hyperliquidData.error =
        error instanceof Error ? error.message : 'Failed to fetch Hyperliquid data';
    }

    // Coinbase integration (optional - continue if it fails)
    let coinbaseData: ExchangeData = {
      exchange: 'coinbase',
      connected: false,
      total_usd: 0,
      assets: [],
    };

    try {
      const { assets, total_usd } = await getCoinbaseBalance();
      coinbaseData = {
        exchange: 'coinbase',
        connected: true,
        total_usd,
        assets,
      };
    } catch (error) {
      // Coinbase is optional - don't fail the entire request
      coinbaseData.error = error instanceof Error ? error.message : 'Failed to fetch Coinbase data';
    }

    // Aggregate portfolio
    const allAssets = [...hyperliquidData.assets, ...coinbaseData.assets];
    const portfolioTotal = hyperliquidData.total_usd + coinbaseData.total_usd;

    const portfolioAssets = allAssets.map((asset) => ({
      symbol: asset.symbol,
      amount: asset.amount,
      value_usd: asset.value_usd,
      percentage: portfolioTotal > 0 ? (asset.value_usd / portfolioTotal) * 100 : 0,
    }));

    return NextResponse.json<WalletResponse>({
      success: true,
      timestamp: new Date().toISOString(),
      total_value_usd: portfolioTotal,
      exchanges: {
        coinbase: coinbaseData,
        hyperliquid: hyperliquidData,
      },
      portfolio: {
        total_assets: portfolioAssets.length,
        assets: portfolioAssets,
      },
    });
  } catch (error) {
    return NextResponse.json(
      {
        success: false,
        timestamp: new Date().toISOString(),
        total_value_usd: 0,
        exchanges: {
          coinbase: {
            exchange: 'coinbase',
            connected: false,
            total_usd: 0,
            assets: [],
            error: 'Server error',
          },
          hyperliquid: {
            exchange: 'hyperliquid',
            connected: false,
            total_usd: 0,
            assets: [],
            error: error instanceof Error ? error.message : 'Unknown error',
          },
        },
        portfolio: {
          total_assets: 0,
          assets: [],
        },
      },
      { status: 500 }
    );
  }
}
