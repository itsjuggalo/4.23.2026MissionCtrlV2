import { NextResponse } from 'next/server';
export const dynamic = 'force-dynamic';

export async function GET() {
  try {
    // Fetch BTC and top 100 coins from CoinGecko
    const response = await fetch(
      'https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=24h',
      { next: { revalidate: 30 } }
    );
    
    if (!response.ok) {
      throw new Error('CoinGecko API error');
    }
    
    const coins = await response.json();
    
    // Find BTC
    const btc = coins.find((c: any) => c.id === 'bitcoin');
    
    // Get top 5 gainers and losers (excluding stablecoins)
    const nonStables = coins.filter((c: any) => 
      !['tether', 'usd-coin', 'dai', 'true-usd', 'paxos-standard'].includes(c.id)
    );
    
    const gainers = [...nonStables]
      .sort((a, b) => b.price_change_percentage_24h - a.price_change_percentage_24h)
      .slice(0, 5)
      .map(c => ({
        symbol: c.symbol.toUpperCase(),
        name: c.name,
        price: c.current_price,
        change24h: c.price_change_percentage_24h,
      }));
    
    const losers = [...nonStables]
      .sort((a, b) => a.price_change_percentage_24h - b.price_change_percentage_24h)
      .slice(0, 5)
      .map(c => ({
        symbol: c.symbol.toUpperCase(),
        name: c.name,
        price: c.current_price,
        change24h: c.price_change_percentage_24h,
      }));
    
    return NextResponse.json({
      btc: {
        price: btc?.current_price || 0,
        change24h: btc?.price_change_percentage_24h || 0,
      },
      gainers,
      losers,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    console.error('Error fetching crypto prices:', error);
    return NextResponse.json(
      { error: 'Failed to fetch crypto prices' },
      { status: 500 }
    );
  }
}
