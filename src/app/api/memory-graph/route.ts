import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import Database from 'better-sqlite3';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const revalidate = 0;

const WORKSPACE = '/home/itsju/.openclaw/workspace';
const MEMORY_DB = '/home/itsju/claudeclaw-os/store/claudeclaw.db';
const MANUAL_FILE = '/home/itsju/.openclaw/data/manual_memories.json';

const MAX_FILES = 300;
const MAX_MEMORIES = 500;

interface MemoryRow {
  id: number; chat_id: string | null; source: string | null; raw_text: string | null;
  summary: string | null; topics: string | null; importance: string | null;
  salience: number | null; created_at: number | string; agent_id: string | null; pinned: number | null;
}

type ImpBucket = 'low' | 'medium' | 'high' | 'critical';

function bucketImportance(v: number): ImpBucket {
  if (v >= 0.8) return 'critical';
  if (v >= 0.6) return 'high';
  if (v >= 0.4) return 'medium';
  return 'low';
}

function safeJsonArray(s: string): string[] {
  try {
    const parsed = JSON.parse(s);
    return Array.isArray(parsed) ? parsed.map(String) : [];
  } catch { return []; }
}

function loadMemoriesFromDb(): { rows: any[]; total: number } {
  let db: Database.Database | null = null;
  try {
    db = new Database(MEMORY_DB, { readonly: true, fileMustExist: true });
    const totalRow = db.prepare(
      'SELECT COUNT(*) AS n FROM memories WHERE superseded_by IS NULL'
    ).get() as { n: number };
    const total = totalRow?.n ?? 0;

    const rows = db.prepare(
      `SELECT id, chat_id, source, raw_text, summary, topics, importance,
              salience, created_at, agent_id, pinned
       FROM memories
       WHERE superseded_by IS NULL
       ORDER BY created_at DESC
       LIMIT ?`
    ).all(MAX_MEMORIES) as MemoryRow[];

    const mapped = rows.map(r => {
      const tsMs = Number(r.created_at) > 1e12
        ? Number(r.created_at)
        : Number(r.created_at) * 1000;
      const created = new Date(tsMs);
      const title = (r.summary || r.raw_text || 'Memory')
        .toString()
        .split('\n')[0]
        .slice(0, 120);
      return {
        id: String(r.id),
        title,
        content: String(r.raw_text || ''),
        source: String(r.source || 'unknown'),
        tags: safeJsonArray(r.topics || '[]'),
        importance: bucketImportance(Number(r.importance ?? 0.5)),
        timestamp: created.toISOString(),
        date: created.toLocaleDateString('en-US', { month: 'short', day: 'numeric' }),
        pinned: !!r.pinned,
        agent_id: String(r.agent_id || 'main'),
        chat_id: String(r.chat_id || ''),
      };
    });

    return { rows: mapped, total };
  } catch {
    return { rows: [], total: 0 };
  } finally {
    try { db?.close(); } catch { /* ignore */ }
  }
}

async function loadManualMemories(): Promise<any[]> {
  try {
    const data = await fs.readFile(MANUAL_FILE, 'utf-8');
    const parsed = JSON.parse(data);
    return Array.isArray(parsed) ? parsed : [];
  } catch { return []; }
}

async function scanMarkdownFiles(dir: string, acc: any[], depth = 0): Promise<void> {
  if (depth > 3 || acc.length >= MAX_FILES) return;
  try {
    const entries = await fs.readdir(dir, { withFileTypes: true });
    for (const entry of entries) {
      if (acc.length >= MAX_FILES) return;
      const fullPath = path.join(dir, entry.name);
      if (entry.isFile() && (entry.name.endsWith('.md') || entry.name.endsWith('.json'))) {
        try {
          const content = await fs.readFile(fullPath, 'utf-8');
          acc.push({
            id: entry.name.replace(/[^a-zA-Z0-9]/g, '_'),
            name: entry.name,
            path: fullPath,
            type: entry.name.endsWith('.json') ? 'data' : 'document',
            content: content.slice(0, 500),
            links: [],
            size: content.length,
          });
        } catch { /* skip */ }
      } else if (entry.isDirectory() && !entry.name.startsWith('.') && entry.name !== 'node_modules') {
        await scanMarkdownFiles(fullPath, acc, depth + 1);
      }
    }
  } catch { /* dir not found */ }
}

export async function GET() {
  try {
    const files: any[] = [];
    await scanMarkdownFiles(WORKSPACE, files);

    const nodes = files.map((f) => ({
      id: f.id,
      name: f.name,
      type: f.type,
      group: f.type,
      importance: 'medium' as const,
      links: f.links || [],
    }));

    const edges: Array<{ source: string; target: string }> = [];
    for (const file of files) {
      for (const other of files) {
        if (file.id !== other.id) {
          const searchName = other.name.toLowerCase().replace('.md', '').replace('.json', '');
          if (searchName.length > 3 && file.content.toLowerCase().includes(searchName)) {
            edges.push({ source: file.id, target: other.id });
          }
        }
      }
    }

    const { rows: dbMemories, total: dbTotal } = loadMemoriesFromDb();
    const manualMemories = await loadManualMemories();
    const memories = [...manualMemories, ...dbMemories].slice(0, MAX_MEMORIES);
    const totalMemories = dbTotal + manualMemories.length;

    const sourceMap: Record<string, number> = {};
    for (const m of memories) {
      const src = String(m.source || 'unknown');
      sourceMap[src] = (sourceMap[src] || 0) + 1;
    }
    const critical = memories.filter((m: any) => m.importance === 'critical').length;
    const high = memories.filter((m: any) => m.importance === 'high').length;

    return NextResponse.json({
      success: true,
      workspace: WORKSPACE,
      truncated: files.length >= MAX_FILES || memories.length < totalMemories,
      nodes,
      edges,
      files: files.map(({ content: _content, ...rest }) => rest),
      memories,
      stats: {
        total: totalMemories,
        critical,
        high,
        bySource: sourceMap,
        fileNodes: nodes.length,
      },
      timestamp: new Date().toISOString(),
    }, { headers: { 'Cache-Control': 'no-store' } });

  } catch {
    return NextResponse.json({
      success: false,
      workspace: '',
      nodes: [],
      edges: [],
      files: [],
      memories: [],
      stats: { total: 0, critical: 0, high: 0, bySource: {}, fileNodes: 0 },
    }, { status: 500 });
  }
}

export async function POST(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    const body = await req.json();
    const memories = await loadManualMemories();

    const newMem = {
      id: 'manual-' + Math.random().toString(36).slice(2, 14),
      title: body.title || 'Manual note',
      content: body.content || '',
      source: 'manual',
      tags: body.tags || ['manual'],
      importance: body.importance || 'medium',
      timestamp: new Date().toISOString(),
      date: new Date().toLocaleDateString('en-US', { month: 'short', day: 'numeric' }),
    };

    memories.unshift(newMem);
    await fs.mkdir(path.dirname(MANUAL_FILE), { recursive: true });
    await fs.writeFile(MANUAL_FILE, JSON.stringify(memories, null, 2));

    return NextResponse.json({ success: true, memory: newMem });
  } catch {
    return NextResponse.json({ success: false }, { status: 500 });
  }
}
