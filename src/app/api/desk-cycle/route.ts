import { NextResponse } from 'next/server';
import Database from 'better-sqlite3';

export const dynamic = 'force-dynamic';
export const revalidate = 0;

const PIPELINE_DB = '/home/itsju/LapClaw/pipeline/desk_pipeline.sqlite';

type AnyRow = Record<string, unknown>;

function safeJsonParse<T = unknown>(s: unknown, fallback: T): T {
  if (typeof s !== 'string') return fallback;
  try { return JSON.parse(s) as T; } catch { return fallback; }
}

export async function GET() {
  let db: Database.Database | null = null;
  try {
    db = new Database(PIPELINE_DB, { readonly: true, fileMustExist: true });

    // ─── Floor 1: raw_candidates grouped by lane + source_agent ──────────
    const candidatesByLane = db.prepare(
      `SELECT lane, COUNT(*) AS n FROM raw_candidates GROUP BY lane ORDER BY n DESC`
    ).all() as AnyRow[];

    const candidatesBySourceAgent = db.prepare(
      `SELECT source_agent, COUNT(*) AS n FROM raw_candidates GROUP BY source_agent ORDER BY n DESC`
    ).all() as AnyRow[];

    const recentCandidates = db.prepare(
      `SELECT id, cycle_id, ticker, side, strike, expiry, lane, source_agent, created_at
       FROM raw_candidates ORDER BY id DESC LIMIT 20`
    ).all() as AnyRow[];

    // ─── Floor 2: latest macro_context ────────────────────────────────────
    const macroRow = db.prepare(
      `SELECT cycle_id, ran_at, regime, vix, vix_pct, sector_tailwinds_json, fed_posture,
              rates_summary, crypto_macro, fx_summary, geopol_summary
       FROM macro_context ORDER BY ran_at DESC LIMIT 1`
    ).get() as AnyRow | undefined;
    const macro = macroRow ? {
      cycle_id: macroRow.cycle_id,
      ran_at: macroRow.ran_at,
      regime: macroRow.regime,
      vix: macroRow.vix,
      vix_pct: macroRow.vix_pct,
      sector_tailwinds: safeJsonParse(macroRow.sector_tailwinds_json, null),
      fed_posture: macroRow.fed_posture,
      rates_summary: macroRow.rates_summary,
      crypto_macro: macroRow.crypto_macro,
      fx_summary: macroRow.fx_summary,
      geopol_summary: macroRow.geopol_summary,
    } : null;

    // ─── Floor 3: lane_findings (latest per lane) ─────────────────────────
    const lanes = db.prepare(
      `SELECT lane, verdict, top_tickers, key_observations, ran_at
       FROM lane_findings ORDER BY ran_at DESC LIMIT 30`
    ).all() as AnyRow[];
    const lanesShaped = lanes.map(r => ({
      lane: r.lane,
      verdict: r.verdict,
      top_tickers: safeJsonParse<string[]>(r.top_tickers, []),
      key_observations: safeJsonParse<string[]>(r.key_observations, []),
      ran_at: r.ran_at,
    }));

    // ─── Floor 4: dossiers (with band + slot count) ───────────────────────
    const dossierRows = db.prepare(
      `SELECT id, candidate_id, cycle_id, ticker, contract_json, stages_json,
              final_confidence, final_band, curator_thesis, outcome_pnl_pct, ran_at
       FROM dossiers ORDER BY ran_at DESC LIMIT 25`
    ).all() as AnyRow[];
    const dossiers = dossierRows.map(r => {
      const stages = safeJsonParse<Record<string, unknown>>(r.stages_json, {});
      return {
        id: r.id,
        candidate_id: r.candidate_id,
        cycle_id: r.cycle_id,
        ticker: r.ticker,
        contract: safeJsonParse(r.contract_json, {}),
        slot_names: Object.keys(stages),
        slot_count: Object.keys(stages).length,
        stages,
        band: r.final_band,
        confidence: r.final_confidence,
        thesis: r.curator_thesis,
        outcome_pnl_pct: r.outcome_pnl_pct,
        ran_at: r.ran_at,
      };
    });

    // ─── Floor 5: premium_shortlist (latest cycle) ────────────────────────
    const shortlistRows = db.prepare(
      `SELECT cycle_id, rank, dossier_id, confidence_band, confidence_score, generated_at
       FROM premium_shortlist ORDER BY generated_at DESC LIMIT 20`
    ).all() as AnyRow[];

    // ─── agent_call_log (recent activity feed) ───────────────────────────
    const agentCalls = db.prepare(
      `SELECT id, cycle_id, agent_name, model, candidate_id, started_at, completed_at,
              input_tokens, output_tokens, cost_usd, error
       FROM agent_call_log ORDER BY id DESC LIMIT 40`
    ).all() as AnyRow[];

    // ─── Floor 6: rd_outputs (latest reports) ────────────────────────────
    const rdRows = db.prepare(
      `SELECT id, cycle_id, agent_name, output_type, payload, acted_on, created_at
       FROM rd_outputs ORDER BY created_at DESC LIMIT 10`
    ).all() as AnyRow[];
    const rdOutputs = rdRows.map(r => ({
      id: r.id,
      cycle_id: r.cycle_id,
      agent_name: r.agent_name,
      output_type: r.output_type,
      payload: safeJsonParse(r.payload, {}),
      acted_on: !!r.acted_on,
      created_at: r.created_at,
    }));

    // ─── Attribution health ───────────────────────────────────────────────
    const totalDossiersAllTime = (db.prepare('SELECT COUNT(*) AS n FROM dossiers').get() as AnyRow).n as number;
    const scoredDossiers = (db.prepare(
      'SELECT COUNT(*) AS n FROM dossiers WHERE outcome_pnl_pct IS NOT NULL'
    ).get() as AnyRow).n as number;
    const unscoredStale = (db.prepare(
      "SELECT COUNT(*) AS n FROM dossiers WHERE outcome_pnl_pct IS NULL AND ran_at < datetime('now', '-2 days')"
    ).get() as AnyRow).n as number;
    const lastAttributionRun = (db.prepare(
      "SELECT payload, created_at FROM rd_outputs WHERE output_type = 'attribution_health' ORDER BY created_at DESC LIMIT 1"
    ).get() as AnyRow | undefined);

    // ─── Oracle push health (last 10 cycles) ─────────────────────────────
    const oraclePushHealth = db.prepare(
      `SELECT cycle_id, status, oracle_push_status, completed_at
       FROM cycle_metadata
       WHERE oracle_push_status IS NOT NULL
       ORDER BY completed_at DESC LIMIT 10`
    ).all() as AnyRow[];

    // ─── Aggregate stats ──────────────────────────────────────────────────
    const stats = {
      total_candidates: (db.prepare('SELECT COUNT(*) AS n FROM raw_candidates').get() as AnyRow).n,
      total_lane_findings: (db.prepare('SELECT COUNT(*) AS n FROM lane_findings').get() as AnyRow).n,
      total_dossiers: dossierRows.length,
      total_shortlist: shortlistRows.length,
      total_agent_calls: agentCalls.length,
      total_rd_outputs: rdRows.length,
      attribution_health: {
        total_dossiers: totalDossiersAllTime,
        scored: scoredDossiers,
        unscored_stale: unscoredStale,
        score_rate_pct: totalDossiersAllTime > 0
          ? Math.round((scoredDossiers / (totalDossiersAllTime as number)) * 100)
          : 0,
        last_run_at: lastAttributionRun?.created_at ?? null,
        last_run_summary: safeJsonParse(lastAttributionRun?.payload, null),
      },
    };

    // ─── 3b: cycle_history (last 30) — summary-only per R1.H2 ────────────
    let cycleHistory: AnyRow[] = [];
    try {
      cycleHistory = db.prepare(
        `SELECT mc.cycle_id, mc.ran_at,
                (SELECT COUNT(*) FROM raw_candidates rc WHERE rc.cycle_id = mc.cycle_id) AS n_candidates,
                (SELECT COUNT(*) FROM dossiers d WHERE d.cycle_id = mc.cycle_id) AS n_dossiers,
                (SELECT COUNT(*) FROM premium_shortlist ps WHERE ps.cycle_id = mc.cycle_id) AS n_shortlist
         FROM macro_context mc
         ORDER BY mc.ran_at DESC LIMIT 30`
      ).all() as AnyRow[];
    } catch {
      cycleHistory = [];
    }

    // ─── 3b: lane_stage_matrix (latest cycle only — R1.H2) ────────────────
    const laneStageMatrix = lanesShaped.map(lane => {
      const verdict = (lane.verdict as string | undefined)?.toLowerCase() ?? 'na';
      const stageSlot: 'pass' | 'fail' | 'pending' | 'na' =
        verdict === 'pass' ? 'pass' :
        verdict === 'fail' ? 'fail' :
        verdict === 'pending' ? 'pending' : 'na';
      return {
        lane: lane.lane,
        stages: { lane_analysis: stageSlot },
      };
    });

    return NextResponse.json({
      generated_at: new Date().toISOString(),
      stats,
      floor1: {
        candidates_by_lane: candidatesByLane,
        candidates_by_source: candidatesBySourceAgent,
        recent_candidates: recentCandidates,
      },
      floor2: macro,
      floor3: lanesShaped,
      floor4: dossiers,
      floor5: shortlistRows,
      floor6: rdOutputs,
      agent_calls: agentCalls,
      // 3b new fields
      cycle_history: cycleHistory,
      lane_stage_matrix: laneStageMatrix,
      oracle_push_health: oraclePushHealth,
    });
  } catch (err: unknown) {
    const msg = err instanceof Error ? err.message : String(err);
    return NextResponse.json(
      { error: `desk-cycle read failed: ${msg}` },
      { status: 500 }
    );
  } finally {
    if (db) db.close();
  }
}
