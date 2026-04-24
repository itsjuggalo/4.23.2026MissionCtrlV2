import { NextResponse } from 'next/server';
export const dynamic = 'force-dynamic';
import { readFile } from 'fs/promises';
import { join } from 'path';

const WORKSPACE_PATH = '/home/ubuntu/.openclaw/workspace';

export async function GET(
  request: Request,
  { params }: { params: Promise<{ path: string[] }> }
) {
  try {
    const { path: pathSegments } = await params;
    const filePath = join(WORKSPACE_PATH, ...pathSegments);
    
    // Security check: ensure path is within workspace
    if (!filePath.startsWith(WORKSPACE_PATH)) {
      return NextResponse.json({ error: 'Invalid path' }, { status: 403 });
    }
    
    const content = await readFile(filePath, 'utf-8');
    
    return NextResponse.json({ content });
  } catch (error) {
    console.error('Error reading file:', error);
    return NextResponse.json({ error: 'File not found' }, { status: 404 });
  }
}
