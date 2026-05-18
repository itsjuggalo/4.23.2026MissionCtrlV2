import {NextResponse, NextRequest } from 'next/server';
import { getWebhookHistory, logWebhookEvent } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const url = new URL(request.url);
    const limit = parseInt(url.searchParams.get('limit') || '50');
    const events = getWebhookHistory(limit);

    return NextResponse.json({
      events,
      count: events.length,
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error), events: [] },
      { status: 500 }
    );
  }
}

export async function POST(request: Request) {
  try {
    const data = await request.json();
    logWebhookEvent(
      data.source || 'unknown',
      data.event_type || 'unknown',
      JSON.stringify(data.payload || {}),
      data.status || 'received',
      data.response_code || 200
    );

    return NextResponse.json({ success: true });
  } catch (error) {
    return NextResponse.json(
      { success: false, error: String(error) },
      { status: 500 }
    );
  }
}
