export async function GET() {
  try {
    const apiKey = process.env.ALPACA_API_KEY;
    const baseUrl = process.env.ALPACA_BASE_URL || 'https://paper-api.alpaca.markets';

    const res = await fetch(`${baseUrl}/v2/account`, {
      headers: { Authorization: `Bearer ${apiKey}` },
    });

    if (!res.ok) {
      return Response.json({ balance: 100000, error: 'Alpaca API error' }, { status: 200 });
    }

    const account = await res.json();
    return Response.json({
      balance: parseFloat(account.portfolio_value || account.cash || 100000),
      pl: parseFloat(account.unrealized_pl || 0),
      cash: parseFloat(account.cash || 0),
      buying_power: parseFloat(account.buying_power || 0),
    });
  } catch (err) {
    console.error('Portfolio API error:', err);
    return Response.json({ balance: 100000 }, { status: 200 });
  }
}
