import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

const WORKSPACE = '/home/ubuntu/.openclaw/workspace';
const MEMORY_FILE = '/home/ubuntu/mission-control-restored/memory/memories.json';

async function scanMarkdownFiles(dir: string, depth = 0): Promise<any[]> {
  if (depth > 3) return [];
  const files: any[] = [];
  try {
    const entries = await fs.readdir(dir, { withFileTypes: true });
    for (const entry of entries) {
      const fullPath = path.join(dir, entry.name);
      if (entry.isFile() && (entry.name.endsWith('.md') || entry.name.endsWith('.json'))) {
        try {
          const content = await fs.readFile(fullPath, 'utf-8');
          files.push({
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
        const sub = await scanMarkdownFiles(fullPath, depth + 1);
        files.push(...sub);
      }
    }
  } catch { /* dir not found */ }
  return files;
}

export async function GET() {
  try {
    const files = await scanMarkdownFiles(WORKSPACE);

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

    let memories: any[] = [];
    try {
      const data = await fs.readFile(MEMORY_FILE, 'utf-8');
      memories = JSON.parse(data);
    } catch { memories = []; }

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
      nodes,
      edges,
      files,
      memories,
      stats: { total: memories.length + nodes.length, critical, high, bySource: sourceMap },
      timestamp: new Date().toISOString(),
    }, { headers: { 'Cache-Control': 'no-store' } });

  } catch (error) {
    return NextResponse.json({
      success: false,
      workspace: '',
      nodes: [],
      edges: [],
      files: [],
      memories: [],
      stats: { total: 0, critical: 0, high: 0, bySource: {} },
    }, { status: 500 });
  }
}

export async function POST(req: Request) {
  const __proxied = await proxyToServeftp(req); if (__proxied) return __proxied;
  try {
    const body = await req.json();
    let memories: any[] = [];
    try {
      memories = JSON.parse(await fs.readFile(MEMORY_FILE, 'utf-8'));
    } catch { /* empty */ }

    const newMem = {
      id: Math.random().toString(36).slice(2, 14),
      title: body.title || 'Manual note',
      content: body.content || '',
      source: 'manual',
      tags: body.tags || ['manual'],
      importance: body.importance || 'medium',
      timestamp: new Date().toISOString(),
      date: new Date().toLocaleDateString('en-US', { month: 'short', day: 'numeric' }),
    };

    memories.unshift(newMem);
    await fs.mkdir(path.dirname(MEMORY_FILE), { recursive: true });
    await fs.writeFile(MEMORY_FILE, JSON.stringify(memories, null, 2));

    return NextResponse.json({ success: true, memory: newMem });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 500 });
  }
}