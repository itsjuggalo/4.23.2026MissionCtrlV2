import { NextResponse } from 'next/server';
export const dynamic = 'force-dynamic';

export async function GET() {
  try {
    const keyId = process.env.ALPACA_KEY_ID;
    const secret = process.env.ALPACA_SECRET;

    if (!keyId || !secret) {
      throw new Error('Alpaca credentials not configured');
    }

    const response = await fetch(
      'https://data.alpaca.markets/v1beta1/news?symbols=BTC/USD,ETH/USD,COIN,MSTR&limit=10',
      {
        headers: {
          'APCA-API-KEY-ID': keyId,
          'APCA-API-SECRET-KEY': secret,
        },
        next: { revalidate: 300 },
      }
    );

    if (!response.ok) {
      throw new Error(`Alpaca news API error: ${response.status}`);
    }

    const data = await response.json();
    const rawNews = data.news || [];

    const news = rawNews.map((item: any) => ({
      id: item.id,
      title: item.headline,
      source: item.source,
      url: item.url,
      published: new Date(item.created_at).getTime() / 1000,
      summary: item.summary,
      symbols: item.symbols,
    }));

    return NextResponse.json({
      news,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    console.error('Error fetching crypto news:', error);
    return NextResponse.json(
      { error: 'Failed to fetch crypto news', news: [] },
      { status: 500 }
    );
  }
}
