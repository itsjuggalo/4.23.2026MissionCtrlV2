import { NextResponse } from 'next/server';
import { readFileSync, existsSync } from 'fs';
import { join } from 'path';
import { proxyToServeftp } from "../../../../lib/proxyToServeftp";

const WORKSPACE = join(process.env.HOME || '/home/itsju', '.openclaw/workspace');

export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const url = new URL(request.url);
    const filePath = url.searchParams.get('path');

    if (!filePath) {
      return NextResponse.json(
        { error: 'Missing path parameter' },
        { status: 400 }
      );
    }

    const fullPath = join(WORKSPACE, filePath);

    // Security: prevent directory traversal
    if (!fullPath.startsWith(WORKSPACE + '/')) {
      return NextResponse.json(
        { error: 'Access denied' },
        { status: 403 }
      );
    }

    if (!existsSync(fullPath)) {
      return NextResponse.json(
        { error: 'File not found' },
        { status: 404 }
      );
    }

    const content = readFileSync(fullPath, 'utf-8');

    return NextResponse.json({
      content,
      path: filePath,
      size: Buffer.byteLength(content, 'utf-8'),
    });
  } catch (error) {
    return NextResponse.json(
      { error: 'Failed to read file' },
      { status: 500 }
    );
  }
}