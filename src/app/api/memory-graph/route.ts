import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';

export async function GET() {
  try {
    const memFile = path.join('/home/ubuntu/mission-control/memory', 'memories.json');
    let memories: any[] = [];
    try {
      const data = await fs.readFile(memFile, 'utf-8');
      memories = JSON.parse(data);
    } catch {
      memories = [];
    }

    const sourceMap: Record<string, number> = {};
    for (const m of memories) {
      const src = String(m.source || 'unknown');
      sourceMap[src] = (sourceMap[src] || 0) + 1;
    }

    const critical = memories.filter((m) => m.importance === 'critical').length;
    const high     = memories.filter((m) => m.importance === 'high').length;

    return NextResponse.json({
      success: true,
      memories,
      stats: { total: memories.length, critical, high, bySource: sourceMap },
      timestamp: new Date().toISOString(),
    }, { headers: { 'Cache-Control': 'no-store' } });

  } catch (error) {
    return NextResponse.json({ success: false, memories: [], stats: {} }, { status: 500 });
  }
}

export async function POST(req: Request) {
  try {
    const body     = await req.json();
    const memFile  = path.join('/home/ubuntu/mission-control/memory', 'memories.json');
    let memories: any[] = [];
    try {
      memories = JSON.parse(await fs.readFile(memFile, 'utf-8'));
    } catch { /* empty */ }

    const newMem = {
      id:         Math.random().toString(36).slice(2, 14),
      title:      body.title || 'Manual note',
      content:    body.content || '',
      source:     'manual',
      tags:       body.tags || ['manual'],
      importance: body.importance || 'medium',
      timestamp:  new Date().toISOString(),
      date:       new Date().toLocaleDateString('en-US', { month: 'short', day: 'numeric' }),
    };

    memories.unshift(newMem);
    await fs.mkdir('/home/ubuntu/mission-control/memory', { recursive: true });
    await fs.writeFile(memFile, JSON.stringify(memories, null, 2));

    return NextResponse.json({ success: true, memory: newMem });
  } catch (error) {
    return NextResponse.json({ success: false }, { status: 500 });
  }
}
