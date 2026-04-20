import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';

export async function GET() {
  const path = '/home/ubuntu/.openclaw/workspace/directives/kronos_forecast.json';
  
  if (!existsSync(path)) {
    return NextResponse.json({ error: 'No forecast available yet' }, { status: 404 });
  }
  
  try {
    const data = JSON.parse(readFileSync(path, 'utf-8'));
    return NextResponse.json(data);
  } catch (e) {
    return NextResponse.json({ error: 'Failed to read forecast' }, { status: 500 });
  }
}
