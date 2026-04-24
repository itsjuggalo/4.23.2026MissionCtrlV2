import { NextResponse } from 'next/server';
import { getActiveAlerts, createAlert, acknowledgeAlert } from '@/lib/db';

export async function GET(request: Request) {
  try {
    const url = new URL(request.url);
    const limit = parseInt(url.searchParams.get('limit') || '50');
    const alerts = getActiveAlerts(limit);

    return NextResponse.json({ alerts, count: alerts.length });
  } catch (error) {
    return NextResponse.json({ error: String(error), alerts: [] }, { status: 500 });
  }
}

export async function POST(request: Request) {
  try {
    const data = await request.json();

    if (data.action === 'acknowledge' && data.id) {
      acknowledgeAlert(data.id);
      return NextResponse.json({ success: true, action: 'acknowledged' });
    }

    createAlert(
      data.severity || 'info',
      data.category || 'system',
      data.title || 'Alert',
      data.detail || '',
      data.value || ''
    );
    return NextResponse.json({ success: true, action: 'created' });
  } catch (error) {
    return NextResponse.json({ success: false, error: String(error) }, { status: 500 });
  }
}
