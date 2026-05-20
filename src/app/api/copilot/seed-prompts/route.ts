/**
 * GET /api/copilot/seed-prompts?vertical=screen&limit=10
 *
 * Returns AInvest's public-square seed prompts segmented by our copilot
 * vertical. Pulled from flow.db.alt_ainvest_seed_prompts (loaded via
 * ~/scripts/load_ainvest_seed_prompts.py from the cookie-probe v3 pull).
 *
 * Used to:
 *   - seed the prompts drawer with vertical-specific suggestions
 *   - feed test fixtures into smoke tests
 *
 * Read-only.
 */
import { NextResponse } from 'next/server';
import fs from 'fs';
import path from 'path';
import os from 'os';
import Database from 'better-sqlite3';

const FLOW_DB = path.join(os.homedir(), 'flow-data', 'flow.db');

const VALID_VERTICALS = new Set([
  'analysis', 'screen', 'charts', 'news', 'crypto',
  'educate', 'explain', 'predict', 'help', 'wiki',
]);

interface SeedPromptRow {
  id: string;
  vertical: string;
  query: string;
  query_type: string | null;
  user_name: string | null;
  like_num_show: number | null;
  share_num_show: number | null;
  collect_num_show: number | null;
  ask_num: number | null;
  day_image_url: string | null;
  night_image_url: string | null;
  trace_id: string | null;
}

function openFlowDb(): Database.Database | null {
  try {
    if (!fs.existsSync(FLOW_DB)) return null;
    const db = new Database(FLOW_DB, { fileMustExist: true });
    db.pragma('journal_mode = WAL');
    db.pragma('busy_timeout = 5000');
    return db;
  } catch { return null; }
}

export async function GET(req: Request) {
  const url = new URL(req.url);
  const verticalParam = (url.searchParams.get('vertical') || '').toLowerCase().trim();
  const limit = Math.max(1, Math.min(100, parseInt(url.searchParams.get('limit') || '10', 10) || 10));
  const sort = url.searchParams.get('sort') || 'engagement'; // engagement | random | recent

  const db = openFlowDb();
  if (!db) {
    return NextResponse.json({ prompts: [], error: 'flow.db not available' }, { status: 200 });
  }
  try {
    // If the table doesn't exist yet (loader hasn't run), return empty cleanly.
    const tableExists = db.prepare(
      "SELECT 1 FROM sqlite_master WHERE type='table' AND name='alt_ainvest_seed_prompts'"
    ).get();
    if (!tableExists) {
      return NextResponse.json({
        prompts: [], total: 0, available_verticals: [],
        note: 'alt_ainvest_seed_prompts table not present — run ~/scripts/load_ainvest_seed_prompts.py',
      });
    }

    // Available verticals (for UI population)
    const available = db.prepare(
      'SELECT vertical, COUNT(*) AS n FROM alt_ainvest_seed_prompts GROUP BY vertical ORDER BY vertical'
    ).all() as Array<{ vertical: string; n: number }>;

    let rows: SeedPromptRow[];
    if (verticalParam && VALID_VERTICALS.has(verticalParam)) {
      const orderBy = sort === 'random'
        ? 'RANDOM()'
        : sort === 'recent'
          ? 'create_time DESC'
          : '(COALESCE(like_num_show,0) + COALESCE(share_num_show,0) + COALESCE(collect_num_show,0)) DESC';
      rows = db.prepare(`
        SELECT id, vertical, query, query_type, user_name,
               like_num_show, share_num_show, collect_num_show, ask_num,
               day_image_url, night_image_url, trace_id
        FROM alt_ainvest_seed_prompts
        WHERE vertical = ?
        ORDER BY ${orderBy}
        LIMIT ?
      `).all(verticalParam, limit) as SeedPromptRow[];
    } else {
      // No vertical filter — return a balanced sample (top-3 per vertical)
      rows = db.prepare(`
        WITH ranked AS (
          SELECT *, ROW_NUMBER() OVER (
            PARTITION BY vertical
            ORDER BY (COALESCE(like_num_show,0) + COALESCE(share_num_show,0) + COALESCE(collect_num_show,0)) DESC
          ) AS rk
          FROM alt_ainvest_seed_prompts
        )
        SELECT id, vertical, query, query_type, user_name,
               like_num_show, share_num_show, collect_num_show, ask_num,
               day_image_url, night_image_url, trace_id
        FROM ranked
        WHERE rk <= 3
        ORDER BY vertical, rk
      `).all() as SeedPromptRow[];
    }

    return NextResponse.json({
      prompts: rows,
      total: rows.length,
      vertical: verticalParam || null,
      available_verticals: available,
      sort,
    });
  } finally {
    db.close();
  }
}
