import { NextResponse } from 'next/server';

export async function GET() {
  try {
    const [btcRes, ethRes, solRes, dogeRes] = await Promise.all([
      fetch('https://api.coinbase.com/v2/prices/BTC-USD/spot').then(r => r.json()).catch(() => null),
      fetch('https://api.coinbase.com/v2/prices/ETH-USD/spot').then(r => r.json()).catch(() => null),
      fetch('https://api.coinbase.com/v2/prices/SOL-USD/spot').then(r => r.json()).catch(() => null),
      fetch('https://api.coinbase.com/v2/prices/DOGE-USD/spot').then(r => r.json()).catch(() => null),
    ]);

    return NextResponse.json({
      BTC: { price: parseFloat(btcRes?.data?.amount || '0'), symbol: 'BTC' },
      ETH: { price: parseFloat(ethRes?.data?.amount || '0'), symbol: 'ETH' },
      SOL: { price: parseFloat(solRes?.data?.amount || '0'), symbol: 'SOL' },
      DOGE: { price: parseFloat(dogeRes?.data?.amount || '0'), symbol: 'DOGE' },
      timestamp: new Date().toISOString(),
    });
  } catch {
    return NextResponse.json({});
  }
}
