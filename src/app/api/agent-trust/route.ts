import { NextResponse } from 'next/server';
import { getDb } from '@/lib/db';
import { proxyToServeftp } from "../../../lib/proxyToServeftp";

interface CountRow { count: number }
interface LastActiveRow { created_at: string }

// Agent trust scoring — grades each agent on reliability, accuracy, speed
export async function GET(request: Request) {
  const __proxied = await proxyToServeftp(request); if (__proxied) return __proxied;
  try {
    const db = getDb();

    // Score each agent from activity patterns
    const agents = ['Boba', 'JazzyHazzy', 'Orion', 'Discord Relay', 'Option Signals Scraper'];
    const scores: any[] = [];

    for (const agent of agents) {
      // Count activities in last 24h
      const recent = db.prepare(`
        SELECT COUNT(*) as count FROM activities
        WHERE agent LIKE ? AND created_at >= datetime('now', '-1 day')
      `).get(`%${agent}%`) as CountRow | undefined;

      // Count errors
      const errors = db.prepare(`
        SELECT COUNT(*) as count FROM activities
        WHERE agent LIKE ? AND severity = 'error' AND created_at >= datetime('now', '-7 days')
      `).get(`%${agent}%`) as CountRow | undefined;

      // Count total all time
      const total = db.prepare(`
        SELECT COUNT(*) as count FROM activities WHERE agent LIKE ?
      `).get(`%${agent}%`) as CountRow | undefined;

      // Get last activity time
      const lastActive = db.prepare(`
        SELECT created_at FROM activities WHERE agent LIKE ? ORDER BY created_at DESC LIMIT 1
      `).get(`%${agent}%`) as LastActiveRow | undefined;

      // Get trust metrics if any
      const metrics = db.prepare(`
        SELECT metric_type, AVG(metric_value) as avg_val, COUNT(*) as count
        FROM agent_metrics WHERE agent = ?
        GROUP BY metric_type
      `).all(agent);

      // Calculate trust score (0-100)
      let trustScore = 50; // baseline
      const recentCount = recent?.count || 0;
      const errorCount = errors?.count || 0;
      const totalCount = total?.count || 0;

      if (recentCount > 0) trustScore += 15; // active in last 24h
      if (recentCount > 10) trustScore += 10; // very active
      if (errorCount === 0) trustScore += 15; // no errors in 7 days
      if (errorCount > 5) trustScore -= 20; // too many errors
      if (totalCount > 100) trustScore += 10; // veteran agent

      trustScore = Math.max(0, Math.min(100, trustScore));

      scores.push({
        agent,
        trust_score: trustScore,
        recent_24h: recentCount,
        errors_7d: errorCount,
        total_activities: totalCount,
        last_active: lastActive?.created_at || null,
        metrics,
        grade: trustScore >= 80 ? 'A' : trustScore >= 60 ? 'B' : trustScore >= 40 ? 'C' : 'D',
      });
    }

    // Sort by trust score descending
    scores.sort((a, b) => b.trust_score - a.trust_score);

    return NextResponse.json({
      agents: scores,
      timestamp: new Date().toISOString(),
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error).slice(0, 200), agents: [] },
      { status: 500 }
    );
  }
}

// POST - record a trust metric for an agent
export async function POST(request: Request) {
  try {
    const data = await request.json();
    const db = getDb();

    db.prepare(`
      INSERT INTO agent_metrics (agent, metric_type, metric_value, detail)
      VALUES (?, ?, ?, ?)
    `).run(
      data.agent || 'unknown',
      data.metric_type || 'general',
      data.value || 0,
      data.detail || ''
    );

    return NextResponse.json({ success: true });
  } catch (error) {
    return NextResponse.json({ success: false, error: String(error).slice(0, 200) }, { status: 500 });
  }
}
