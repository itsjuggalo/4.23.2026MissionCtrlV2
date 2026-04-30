import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';

const TASKS_FILE = join(process.env.HOME || '/home/ubuntu', '.openclaw/data/agent-tasks.json');

export async function GET() {
  try {
    if (!existsSync(TASKS_FILE)) {
      return NextResponse.json({ error: 'tasks file missing', agents: {} });
    }
    const raw = readFileSync(TASKS_FILE, 'utf-8');
    const data = JSON.parse(raw);
    return NextResponse.json(data);
  } catch (e) {
    return NextResponse.json({ error: String(e), agents: {} }, { status: 500 });
  }
}

export const dynamic = 'force-dynamic';
