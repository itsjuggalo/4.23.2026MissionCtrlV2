import type { NextRequest } from 'next/server';
export async function GET(request: NextRequest) {
  const { searchParams } = new URL(request.url);
  const ids = searchParams.get('ids') ?? '';
  const vs_currencies = searchParams.get('vs_currencies') ?? 'usd';
  const include_24hr_change = searchParams.get('include_24hr_change') ?? 'true';
  const url = `https://api.coingecko.com/api/v3/simple/price?ids=${ids}&vs_currencies=${vs_currencies}&include_24hr_change=${include_24hr_change}`;
  let res: Response;
  try {
    res = await fetch(url, { signal: AbortSignal.timeout(8000) });
  } catch (err) {
    return Response.json({}, { status: 200 });
  }
  if (res.status !== 200) {
    return Response.json({}, { status: 200 });
  }
  const data = await res.json();
  return Response.json(data, { status: 200 });
}
