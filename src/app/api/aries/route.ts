import { NextResponse } from 'next/server';
import { getDb } from '@/lib/db';
import { proxyToServeftp } from '@/lib/proxyToServeftp';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

interface CountRow { count: number }
interface AvgRow { avg: number | null }
interface LastRow { created_at: string }

// ARIES — Agent Resource Intelligence & Execution Status.
// Aggregates the existing health producers (agent_metrics, activities, alerts,
// skill_usage, sessions) into one composite system-health snapshot for the
// dashboard. Pure read; degrades gracefully when a table is empty.
export async function GET(request: Request) {
  // On Vercel this proxies to SpaceCoast/openclaw (where the real DB lives);
  // on the boxes it returns null and we serve the local DB below.
  const proxied = await proxyToServeftp(request);
  if (proxied) return proxied;

  try {
    const db = getDb();

    // ---- Agents: trust score from activity patterns + recorded metrics ----
    const agentNames = ['Boba', 'JazzyHazzy', 'Orion', 'Discord Relay', 'Option Signals Scraper'];
    const agents = agentNames.map((agent) => {
      const recent = (db.prepare(
        `SELECT COUNT(*) as count FROM activities WHERE agent LIKE ? AND created_at >= datetime('now','-1 day')`
      ).get(`%${agent}%`) as CountRow | undefined)?.count || 0;
      const errors = (db.prepare(
        `SELECT COUNT(*) as count FROM activities WHERE agent LIKE ? AND severity = 'error' AND created_at >= datetime('now','-7 days')`
      ).get(`%${agent}%`) as CountRow | undefined)?.count || 0;
      const total = (db.prepare(
        `SELECT COUNT(*) as count FROM activities WHERE agent LIKE ?`
      ).get(`%${agent}%`) as CountRow | undefined)?.count || 0;
      const last = (db.prepare(
        `SELECT created_at FROM activities WHERE agent LIKE ? ORDER BY created_at DESC LIMIT 1`
      ).get(`%${agent}%`) as LastRow | undefined)?.created_at || null;

      let score = 50;
      if (recent > 0) score += 15;
      if (recent > 10) score += 10;
      if (errors === 0) score += 15;
      if (errors > 5) score -= 20;
      if (total > 100) score += 10;
      score = Math.max(0, Math.min(100, score));

      return {
        name: agent,
        trust_score: score,
        grade: score >= 80 ? 'A' : score >= 60 ? 'B' : score >= 40 ? 'C' : 'D',
        recent_24h: recent,
        errors_7d: errors,
        total_activities: total,
        last_active: last,
        status: recent > 0 ? 'online' : (total > 0 ? 'idle' : 'offline'),
      };
    });

    // ---- System vitals ----
    const activity24h = (db.prepare(
      `SELECT COUNT(*) as count FROM activities WHERE created_at >= datetime('now','-1 day')`
    ).get() as CountRow | undefined)?.count || 0;
    const errors24h = (db.prepare(
      `SELECT COUNT(*) as count FROM activities WHERE severity = 'error' AND created_at >= datetime('now','-1 day')`
    ).get() as CountRow | undefined)?.count || 0;

    let skillSuccess = 100, skillRuns = 0;
    try {
      skillRuns = (db.prepare(
        `SELECT COUNT(*) as count FROM skill_usage WHERE used_at >= datetime('now','-7 days')`
      ).get() as CountRow | undefined)?.count || 0;
      const ok = (db.prepare(
        `SELECT COUNT(*) as count FROM skill_usage WHERE success = 1 AND used_at >= datetime('now','-7 days')`
      ).get() as CountRow | undefined)?.count || 0;
      skillSuccess = skillRuns > 0 ? Math.round((ok / skillRuns) * 100) : 100;
    } catch { /* table may not exist on older DBs */ }

    let cost7d = 0;
    try {
      cost7d = (db.prepare(
        `SELECT SUM(cost_dollars) as avg FROM sessions WHERE started_at >= datetime('now','-7 days')`
      ).get() as AvgRow | undefined)?.avg || 0;
    } catch { /* ignore */ }

    // ---- Active alerts ----
    const alertsRaw = db.prepare(
      `SELECT severity, category, title, detail, created_at FROM alerts WHERE acknowledged = 0 ORDER BY created_at DESC LIMIT 20`
    ).all() as Array<{ severity: string; category: string; title: string; detail: string; created_at: string }>;
    const criticalAlerts = alertsRaw.filter((a) => a.severity === 'critical').length;
    const warningAlerts = alertsRaw.filter((a) => a.severity === 'warning').length;

    // ---- Composite health score ----
    const avgTrust = agents.length ? agents.reduce((s, a) => s + a.trust_score, 0) / agents.length : 50;
    let health = avgTrust;
    health -= criticalAlerts * 12;
    health -= warningAlerts * 4;
    health -= Math.min(errors24h * 3, 20);
    health = Math.round(Math.max(0, Math.min(100, health)));
    const healthLabel = health >= 85 ? 'HEALTHY' : health >= 60 ? 'DEGRADED' : health >= 35 ? 'AT RISK' : 'CRITICAL';

    // ---- Recommendations ----
    const recommendations: string[] = [];
    if (criticalAlerts > 0) recommendations.push(`${criticalAlerts} unacknowledged CRITICAL alert(s) — triage now.`);
    if (errors24h > 5) recommendations.push(`${errors24h} agent errors in 24h — check the noisiest agent.`);
    const stale = agents.filter((a) => a.status === 'offline');
    if (stale.length) recommendations.push(`No activity ever recorded for: ${stale.map((a) => a.name).join(', ')}.`);
    if (skillRuns > 0 && skillSuccess < 80) recommendations.push(`Skill success rate ${skillSuccess}% (last 7d) — investigate failing skills.`);
    if (!recommendations.length) recommendations.push('All systems nominal.');

    return NextResponse.json({
      timestamp: new Date().toISOString(),
      health_score: health,
      health_label: healthLabel,
      agents,
      vitals: {
        activity_24h: activity24h,
        errors_24h: errors24h,
        skill_success_pct: skillSuccess,
        skill_runs_7d: skillRuns,
        cost_7d: Math.round((cost7d || 0) * 100) / 100,
        active_alerts: alertsRaw.length,
        critical_alerts: criticalAlerts,
        warning_alerts: warningAlerts,
      },
      alerts: alertsRaw,
      recommendations,
    });
  } catch (error) {
    return NextResponse.json(
      { error: String(error).slice(0, 200), health_score: 0, health_label: 'UNKNOWN', agents: [], vitals: {}, alerts: [], recommendations: [] },
      { status: 500 }
    );
  }
}
