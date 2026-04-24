import fs from 'fs';
import path from 'path';

export interface MemoryEntry {
  date: string;
  content: string;
  type: 'insight' | 'decision' | 'event' | 'note';
  source: string;
  time?: string;
}

const MEMORY_DIR = path.join(process.cwd(), '..', 'memory');

export function getMemoryEntries(): MemoryEntry[] {
  const entries: MemoryEntry[] = [];

  if (!fs.existsSync(MEMORY_DIR)) {
    return entries;
  }

  const files = fs.readdirSync(MEMORY_DIR)
    .filter(f => f.endsWith('.md') && f.match(/^\d{4}-\d{2}-\d{2}/))
    .sort()
    .reverse();

  for (const file of files) {
    const filePath = path.join(MEMORY_DIR, file);
    const content = fs.readFileSync(filePath, 'utf-8');
    const date = file.match(/^(\d{4}-\d{2}-\d{2})/)?.[1] || 'unknown';

    // Parse markdown sections
    const lines = content.split('\n');
    let currentEntry = '';
    let currentType: MemoryEntry['type'] = 'note';

    for (const line of lines) {
      // Detect headers as entry boundaries
      if (line.startsWith('## ') || line.startsWith('### ')) {
        if (currentEntry.trim()) {
          entries.push({
            date,
            content: currentEntry.trim(),
            type: currentType,
            source: file.replace('.md', ''),
          });
        }
        currentEntry = line.replace(/^#+\s*/, '') + '\n';
        
        // Infer type from header
        const header = line.toLowerCase();
        if (header.includes('decision') || header.includes('rejected')) {
          currentType = 'decision';
        } else if (header.includes('insight') || header.includes('learned')) {
          currentType = 'insight';
        } else if (header.includes('event')) {
          currentType = 'event';
        } else {
          currentType = 'note';
        }
      } else if (line.trim()) {
        currentEntry += line + '\n';
      }
    }

    // Flush last entry
    if (currentEntry.trim()) {
      entries.push({
        date,
        content: currentEntry.trim(),
        type: currentType,
        source: file.replace('.md', ''),
      });
    }
  }

  return entries.slice(0, 100); // Latest 100 entries
}
