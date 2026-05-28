import { NextResponse } from 'next/server';
import { promises as fs } from 'fs';
import path from 'path';
import { exec } from 'child_process';
import { promisify } from 'util';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const execAsync = promisify(exec);

const SKILLS_DIR = '/home/itsju/.openclaw/workspace/skills';

const AGENT_MAP: Record<string, string> = {
  'alpaca-trading': 'boba',
  'auto-trading-strategy': 'boba',
  'algo-builder': 'boba',
  'btc-analysis': 'orion',
  'stock-analysis': 'orion',
  'trading-analysis': 'orion',
  'catalyst-scanner': 'jazzyhazzy',
  'announcement-search': 'jazzyhazzy',
  'calendar-research': 'jazzyhazzy',
  'ai-readiness': 'jazzyhazzy',
};

const CATEGORY_MAP: Record<string, string> = {
  'alpaca-trading': 'Trading',
  'auto-trading-strategy': 'Trading',
  'algo-builder': 'Trading',
  'btc-analysis': 'Analysis',
  'stock-analysis': 'Analysis',
  'trading-analysis': 'Analysis',
  'catalyst-scanner': 'Research',
  'announcement-search': 'Research',
  'calendar-research': 'Research',
  'ai-readiness': 'Research',
  'audit-xls': 'Tools',
  '3-statement-model': 'Reference',
};

function classifyAgent(name: string): string {
  if (AGENT_MAP[name]) return AGENT_MAP[name];
  if (name.includes('Invest') || name.includes('Marks') || name.includes('Dalio') ||
      name.includes('Soros') || name.includes('Lynch') || name.includes('Fisher') ||
      name.includes('Douglas') || name.includes('Kiyosaki') || name.includes('Templeton') ||
      name.includes('Vanguard') || name.includes('BlackRock') || name.includes('model')) return 'reference';
  return 'shared';
}

function classifyCategory(name: string): string {
  if (CATEGORY_MAP[name]) return CATEGORY_MAP[name];
  const agent = classifyAgent(name);
  if (agent === 'reference') return 'Reference';
  if (agent === 'boba') return 'Trading';
  if (agent === 'jazzyhazzy') return 'Research';
  if (agent === 'orion') return 'Analysis';
  return 'General';
}

export async function GET() {
  try {
    const entries = await fs.readdir(SKILLS_DIR, { withFileTypes: true });
    const skills = [];

    for (const entry of entries) {
      if (!entry.isDirectory()) continue;
      if (entry.name.startsWith('_') || entry.name.startsWith('.')) continue;

      const skillDir = path.join(SKILLS_DIR, entry.name);
      let description = '';

      // Try to read SKILL.md for description
      try {
        const skillMd = await fs.readFile(path.join(skillDir, 'SKILL.md'), 'utf8');
        // Extract description from frontmatter or first paragraph
        const descMatch = skillMd.match(/description:\s*>?\s*\n?\s*(.+?)(?:\n---|\n\n|\n#)/);
        if (descMatch) {
          description = descMatch[1].replace(/\n\s*/g, ' ').trim().slice(0, 200);
        } else {
          // First non-empty line after frontmatter
          const lines = skillMd.split('\n').filter(l => l.trim() && !l.startsWith('---') && !l.startsWith('#') && !l.startsWith('name:'));
          description = (lines[0] || '').trim().slice(0, 200);
        }
      } catch {
        // Try README.md
        try {
          const readme = await fs.readFile(path.join(skillDir, 'README.md'), 'utf8');
          const lines = readme.split('\n').filter(l => l.trim() && !l.startsWith('#'));
          description = (lines[0] || '').trim().slice(0, 200);
        } catch {
          description = '';
        }
      }

      // Check for scripts directory
      let hasScripts = false;
      try {
        await fs.access(path.join(skillDir, 'scripts'));
        hasScripts = true;
      } catch {
        hasScripts = false;
      }

      skills.push({
        name: entry.name,
        agent: classifyAgent(entry.name),
        category: classifyCategory(entry.name),
        description,
        hasScripts,
      });
    }

    // Check skill-scheduler PM2 status
    let schedulerStatus = 'unknown';
    try {
      const { stdout } = await execAsync('pm2 jlist 2>/dev/null');
      const processes = JSON.parse(stdout);
      const scheduler = processes.find((p: any) => p.name === 'skill-scheduler');
      schedulerStatus = scheduler?.pm2_env?.status || 'unknown';
    } catch {
      schedulerStatus = 'unknown';
    }

    return NextResponse.json({
      skills: skills.sort((a, b) => a.name.localeCompare(b.name)),
      schedulerStatus,
      total: skills.length,
    });
  } catch (error) {
    return NextResponse.json({ skills: [], schedulerStatus: 'unknown', error: String(error).slice(0, 200) }, { status: 500 });
  }
}