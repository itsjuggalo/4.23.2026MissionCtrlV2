import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const TASKS_FILE = join(process.env.HOME || '/home/itsju', '.openclaw/data/agent-tasks.json');

export async function GET(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    if (!existsSync(TASKS_FILE)) {
      return NextResponse.json({ error: 'tasks file missing', agents: {} }, { status: 503 });
    }
    const raw = readFileSync(TASKS_FILE, 'utf-8');
    const data = JSON.parse(raw);
    return NextResponse.json(data);
  } catch (e) {
    return NextResponse.json({ error: String(e), agents: {} }, { status: 500 });
  }
}

