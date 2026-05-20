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

type Ctx = { params: Promise<{ id: string }> };

export async function GET(_req: Request, ctx: Ctx) {
  const { id } = await ctx.params;
  if (!id) return NextResponse.json({ error: 'thread id required' }, { status: 400 });

  const db = openFlowDb();
  if (!db) return NextResponse.json({ error: 'flow.db not available' }, { status: 500 });

  try {
    // Idempotent column ensure — protects older flow.db files.
    try { db.exec(`ALTER TABLE copilot_threads ADD COLUMN vertical TEXT`); }
    catch { /* already exists */ }

    const row = db.prepare(`
      SELECT thread_id, title, mode, model_last, msg_count, created_at, updated_at, vertical, messages_json
      FROM copilot_threads
      WHERE thread_id = ?
    `).get(id) as Record<string, unknown> | undefined;

    if (!row) return NextResponse.json({ error: 'thread not found' }, { status: 404 });

    let messages: unknown = [];
    try { messages = JSON.parse(String(row.messages_json || '[]')); } catch { /* leave empty */ }

    return NextResponse.json({
      thread_id: row.thread_id,
      title: row.title,
      mode: row.mode,
      model_last: row.model_last,
      msg_count: row.msg_count,
      created_at: row.created_at,
      updated_at: row.updated_at,
      vertical: row.vertical,
      messages,
    });
  } finally {
    db.close();
  }
}

export async function DELETE(_req: Request, ctx: Ctx) {
  const { id } = await ctx.params;
  if (!id) return NextResponse.json({ error: 'thread id required' }, { status: 400 });

  const db = openFlowDb();
  if (!db) return NextResponse.json({ error: 'flow.db not available' }, { status: 500 });

  try {
    const result = db.prepare('DELETE FROM copilot_threads WHERE thread_id = ?').run(id);
    return NextResponse.json({ deleted: result.changes });
  } finally {
    db.close();
  }
}
