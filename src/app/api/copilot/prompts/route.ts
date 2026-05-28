/**
 * /api/copilot/prompts — starter prompts harvested from AInvest's prompt-square.
 *
 * Returns top prompts per category, sorted by `like_num_show`. The corpus
 * lives at ~/aime_share_dump/all.json (2,261 prompts as of 2026-05-20).
 *
 * Query params:
 *   ?per_category=5  (default 5)
 *   ?categories=analysis,screen,Prediction,charts,news,Crypto  (default whitelist)
 */
import { NextResponse } from 'next/server';
import fs from 'fs';
import path from 'path';
import os from 'os';

const HARVEST_PATH = path.join(os.homedir(), '04_RESEARCH', 'aime_share_dump', 'all.json');

// Whitelist of categories worth surfacing as "starter prompts" — trading-actionable.
const DEFAULT_CATEGORIES = ['analysis', 'screen', 'Prediction', 'charts', 'news', 'Crypto'];

interface RawPrompt {
  id?: string;
  query?: string;
  prompt_type?: string;
  like_num_show?: number;
  share_num_show?: number;
  collect_num_show?: number;
  ask_num?: number;
  user_name?: string;
  createTime?: string;
}

interface OutPrompt {
  id: string;
  query: string;
  category: string;
  likes: number;
  shares: number;
  asks: number;
  user_name: string | null;
}

let cache: { byCategory: Record<string, OutPrompt[]>; loadedAt: number } | null = null;
const CACHE_TTL_MS = 5 * 60 * 1000; // 5min — file is updated infrequently

function loadHarvest(): Record<string, OutPrompt[]> {
  if (cache && Date.now() - cache.loadedAt < CACHE_TTL_MS) return cache.byCategory;
  try {
    const raw = fs.readFileSync(HARVEST_PATH, 'utf-8');
    const list = JSON.parse(raw) as RawPrompt[];
    const byCategory: Record<string, OutPrompt[]> = {};
    for (const p of list) {
      const cat = (p.prompt_type || 'other').trim();
      const query = (p.query || '').trim();
      if (!query || query.length < 4) continue;
      if (!byCategory[cat]) byCategory[cat] = [];
      byCategory[cat].push({
        id: String(p.id || query.slice(0, 24)),
        query,
        category: cat,
        likes: Number(p.like_num_show || 0),
        shares: Number(p.share_num_show || 0),
        asks: Number(p.ask_num || 0),
        user_name: p.user_name || null,
      });
    }
    // Sort each bucket by likes desc, then shares
    for (const cat of Object.keys(byCategory)) {
      byCategory[cat].sort((a, b) => (b.likes - a.likes) || (b.shares - a.shares));
    }
    cache = { byCategory, loadedAt: Date.now() };
    return byCategory;
  } catch {
    return {};
  }
}

export async function GET(req: Request) {
  const url = new URL(req.url);
  const perCategory = Math.max(1, Math.min(20, parseInt(url.searchParams.get('per_category') || '5', 10) || 5));
  const catsParam = url.searchParams.get('categories');
  const categories = catsParam ? catsParam.split(',').map((c) => c.trim()).filter(Boolean) : DEFAULT_CATEGORIES;

  const byCategory = loadHarvest();
  if (Object.keys(byCategory).length === 0) {
    return NextResponse.json({
      prompts: {},
      error: `Harvest not found at ${HARVEST_PATH}`,
    });
  }

  const out: Record<string, OutPrompt[]> = {};
  for (const cat of categories) {
    const bucket = byCategory[cat] || byCategory[cat.toLowerCase()] || [];
    if (bucket.length === 0) continue;
    out[cat] = bucket.slice(0, perCategory);
  }
  return NextResponse.json({
    prompts: out,
    total_in_harvest: Object.values(byCategory).reduce((s, v) => s + v.length, 0),
    categories_available: Object.keys(byCategory).sort(),
  });
}
