import { NextResponse } from 'next/server';
import fs from 'fs';
import path from 'path';
import os from 'os';
import Database from 'better-sqlite3';

const FLOW_DB = path.join(os.homedir(), 'flow-data', 'flow.db');

function openFlowDb(): Database.Database | null {
  try {
    if (!fs.existsSync(FLOW_DB)) return null;
    const db = new Database(FLOW_DB, { fileMustExist: true });
    db.pragma('journal_mode = WAL');
    db.pragma('busy_timeout = 5000');
    return db;
  } catch { return null; }
}

// List recent threads (id, title, updated_at, msg_count, mode)
export async function GET(req: Request) {
  const url = new URL(req.url);
  const limit = Math.max(1, Math.min(100, parseInt(url.searchParams.get('limit') || '30', 10) || 30));

  const db = openFlowDb();
  if (!db) {
    return NextResponse.json({ threads: [], error: 'flow.db not available' }, { status: 200 });
  }
  try {
    const rows = db.prepare(`
      SELECT thread_id, title, mode, model_last, msg_count, created_at, updated_at
      FROM copilot_threads
      ORDER BY updated_at DESC
      LIMIT ?
    `).all(limit);
    return NextResponse.json({ threads: rows });
  } finally {
    db.close();
  }
}
