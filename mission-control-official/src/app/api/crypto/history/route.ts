import { NextResponse } from 'next/server';
export const dynamic = 'force-dynamic';

export async function GET(request: Request) {
  try {
    const { searchParams } = new URL(request.url);
    const days = searchParams.get('days') || '1';
    
    const response = await fetch(
      `https://api.coingecko.com/api/v3/coins/bitcoin/market_chart?vs_currency=usd&days=${days}`,
      { next: { revalidate: 60 } }
    );
    
    if (!response.ok) {
      throw new Error('CoinGecko API error');
    }
    
    const data = await response.json();
    
    // Format for charting library
    const prices = data.prices.map(([timestamp, price]: [number, number]) => ({
      time: Math.floor(timestamp / 1000),
      value: price,
    }));
    
    return NextResponse.json({
      prices,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    console.error('Error fetching BTC history:', error);
    return NextResponse.json(
      { error: 'Failed to fetch BTC history' },
      { status: 500 }
    );
  }
}
