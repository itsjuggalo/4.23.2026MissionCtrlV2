import { NextResponse } from 'next/server';
import { readdirSync, statSync, readFileSync } from 'fs';
import { join, relative, extname, basename } from 'path';

const WORKSPACE = join(process.env.HOME || '/home/ubuntu', '.openclaw/workspace');

const SCAN_DIRS = [
  { path: WORKSPACE, label: 'Root' },
  { path: join(WORKSPACE, 'memory'), label: 'memory' },
  { path: join(WORKSPACE, 'directives'), label: 'directives' },
  { path: join(WORKSPACE, 'context'), label: 'context' },
  { path: join(WORKSPACE, 'skills'), label: 'skills' },
  { path: join(WORKSPACE, 'second-brain'), label: 'second-brain' },
  { path: join(WORKSPACE, 'mission-control'), label: 'mission-control' },
];

const VALID_EXTENSIONS = ['.md', '.json', '.txt', '.py', '.sh'];

interface DocFile {
  name: string;
  path: string;
  category: string;
  size: number;
  modified: string;
}

function scanDir(dirPath: string, category: string, depth: number = 0): DocFile[] {
  const files: DocFile[] = [];

  try {
    const entries = readdirSync(dirPath);

    for (const entry of entries) {
      if (entry.startsWith('.') || entry === 'node_modules' || entry === '__pycache__') continue;

      const fullPath = join(dirPath, entry);

      try {
        const stat = statSync(fullPath);

        if (stat.isFile() && VALID_EXTENSIONS.includes(extname(entry).toLowerCase())) {
          const relativePath = relative(WORKSPACE, fullPath);
          files.push({
            name: entry,
            path: relativePath,
            category,
            size: stat.size,
            modified: stat.mtime.toISOString(),
          });
        } else if (stat.isDirectory() && depth < 2) {
          // Scan subdirectories up to 2 levels deep
          const subCategory = depth === 0 ? entry : `${category}/${entry}`;
          // Only scan subdirs that aren't already in SCAN_DIRS
          const alreadyScanned = SCAN_DIRS.some(d => d.path === fullPath);
          if (!alreadyScanned) {
            files.push(...scanDir(fullPath, subCategory, depth + 1));
          }
        }
      } catch {
        // Skip files we can't stat
      }
    }
  } catch {
    // Directory doesn't exist
  }

  return files;
}

export async function GET() {
  try {
    const allFiles: DocFile[] = [];

    for (const dir of SCAN_DIRS) {
      const files = scanDir(dir.path, dir.label);
      allFiles.push(...files);
    }

    // Also scan any other top-level subdirectories we haven't covered
    try {
      const topLevel = readdirSync(WORKSPACE);
      const coveredLabels = SCAN_DIRS.map(d => basename(d.path));

      for (const entry of topLevel) {
        if (entry.startsWith('.') || coveredLabels.includes(entry)) continue;
        const fullPath = join(WORKSPACE, entry);
        try {
          const stat = statSync(fullPath);
          if (stat.isDirectory()) {
            allFiles.push(...scanDir(fullPath, entry));
          }
        } catch {}
      }
    } catch {}

    // Deduplicate by path
    const seen = new Set<string>();
    const unique = allFiles.filter(f => {
      if (seen.has(f.path)) return false;
      seen.add(f.path);
      return true;
    });

    // Sort by modified date (newest first) within each category
    unique.sort((a, b) => new Date(b.modified).getTime() - new Date(a.modified).getTime());

    // Group by category
    const grouped: Record<string, DocFile[]> = {};
    for (const file of unique) {
      if (!grouped[file.category]) {
        grouped[file.category] = [];
      }
      grouped[file.category].push(file);
    }

    return NextResponse.json({
      docs: grouped,
      total: unique.length,
      scanned_at: new Date().toISOString(),
    });
  } catch (error) {
    return NextResponse.json(
      { error: 'Failed to scan documents', docs: {} },
      { status: 500 }
    );
  }
}
