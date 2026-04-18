import { NextResponse } from 'next/server';

const BASE = 'https://stock-signal-72772-default-rtdb.firebaseio.com/FlowGreeks';

export async function GET() {
  try {
    const [flowRes, alertsRes] = await Promise.all([
      fetch(`${BASE}/LiveFlowLast100.json`).then(r => r.json()).catch(() => null),
      fetch(`${BASE}/Alerts/today.json`).then(r => r.json()).catch(() => null),
    ]);

    const flows = flowRes ? (Array.isArray(flowRes) ? flowRes : Object.values(flowRes)) : [];
    const alerts = alertsRes ? (Array.isArray(alertsRes) ? alertsRes : Object.values(alertsRes)) : [];

    // Parse alerts — they have nested structure
    const parsedAlerts = alerts.map((a: any) => a?.alert || a).filter((a: any) => a?.Symbol);

    return NextResponse.json({
      flows: flows.filter((f: any) => f?.Symbol),
      alerts: parsedAlerts,
      timestamp: new Date().toISOString(),
    });
  } catch (e) {
    return NextResponse.json({ flows: [], alerts: [], error: String(e).slice(0, 200) });
  }
}
