"use client";

import { useEffect, useState, useCallback } from "react";
import { GradientHeader } from "@/components/ui/GradientHeader";
import { Heatmap } from "@/components/ui/Heatmap";
import { Sparkline } from "@/components/ui/Sparkline";

// ─── Types matching /api/desk-cycle ───────────────────────────────────────
interface Macro {
  cycle_id: string;
  ran_at: string;
  regime: string | null;
  vix: number | null;
  vix_pct: number | null;
  sector_tailwinds: { tailwinds?: string[]; headwinds?: string[]; theme?: string } | null;
  fed_posture: string | null;
  rates_summary: string | null;
  crypto_macro: string | null;
  fx_summary: string | null;
  geopol_summary: string | null;
}
interface Lane {
  lane: string;
  verdict: string;
  top_tickers: string[];
  key_observations: string[];
  ran_at: string;
}
interface Dossier {
  id: number;
  candidate_id: number;
  cycle_id: string;
  ticker: string;
  contract: { side?: string; strike?: number; expiry?: string };
  slot_names: string[];
  slot_count: number;
  stages: Record<string, any>;
  band: string | null;
  confidence: number | null;
  thesis: string | null;
  outcome_pnl_pct: number | null;
  ran_at: string;
}
interface Shortlist {
  cycle_id: string;
  rank: number;
  dossier_id: number;
  confidence_band: string;
  confidence_score: number;
  generated_at: string;
}
interface AgentCall {
  id: number;
  cycle_id: string;
  agent_name: string;
  model: string;
  candidate_id: number | null;
  started_at: string;
  completed_at: string;
  input_tokens: number;
  output_tokens: number;
  cost_usd: number;
  error: string | null;
}
interface RDOutput {
  id: number;
  cycle_id: string;
  agent_name: string;
  output_type: string;
  payload: any;
  acted_on: boolean;
  created_at: string;
}
interface CycleHistoryEntry {
  cycle_id: string;
  ran_at: string;
  n_candidates: number;
  n_dossiers: number;
  n_shortlist: number;
  duration_s?: number;
}
interface DeskState {
  generated_at: string;
  stats: Record<string, number>;
  floor1: {
    candidates_by_lane: { lane: string; n: number }[];
    candidates_by_source: { source_agent: string; n: number }[];
    recent_candidates: any[];
  };
  floor2: Macro | null;
  floor3: Lane[];
  floor4: Dossier[];
  floor5: Shortlist[];
  floor6: RDOutput[];
  agent_calls: AgentCall[];
  cycle_history?: CycleHistoryEntry[];
  lane_stage_matrix?: { lane: string; stages: Record<string, 'pass' | 'fail' | 'pending' | 'na'> }[];
}

// ─── Constants ─────────────────────────────────────────────────────────────
const ALL_LANES = [
  "semis", "megatech", "software-cloud", "ai-themes", "comm-services",
  "biotech", "energy", "financials", "insurance", "consumer-disc",
  "consumer-staples", "industrials", "defense", "cybersecurity", "healthcare",
  "REIT", "materials", "utilities", "crypto-tier1", "crypto-defi",
  "small-cap-catalyst",
];
const ALL_SCOUTS = [
  "bluestacks-scout", "firebase-name-scout", "firebase-name2-scout",
  "firebase-vivid-scout", "firebase-vivid2-scout", "options-flow-scout",
  "discord-channel-scout", "news-scout", "earnings-scout",
  "sec-filing-scout", "x-sentiment-scout", "reddit-wsb-scout",
];
const ALL_MACRO_AGENTS = [
  { id: "macro-regime",            short: "Regime",   dna: "Soros" },
  { id: "sector-rotation-watcher", short: "Sector",   dna: "BlackRock" },
  { id: "vix-regime-watcher",      short: "VIX",      dna: "Bridgewater" },
  { id: "rates-watcher",           short: "Rates",    dna: "—" },
  { id: "crypto-macro-watcher",    short: "Crypto",   dna: "Crypto-sniper" },
  { id: "fx-watcher",              short: "FX",       dna: "—" },
  { id: "geopolitical-watcher",    short: "Geo",      dna: "Web" },
];
const CHAIN_STAGES = [
  { slot: "signal_filter",        label: "1. Signal Filter",       owner: "Aladdin" },
  { slot: "direction_classifier", label: "2. Direction",            owner: "DeepSeek" },
  { slot: "fundamentals",         label: "3. Fundamentals",         owner: "Lynch/Fisher" },
  { slot: "chart_vision",         label: "4. Chart Vision",         owner: "Gemini" },
  { slot: "ta_text",              label: "5. TA Text",              owner: "Renaissance" },
  { slot: "insider",              label: "6. Insider Form 4",       owner: "SEC EDGAR" },
  { slot: "catalyst",             label: "7. Catalyst Window",      owner: "—" },
  { slot: "quant",                label: "8. Quant Backtest",       owner: "DeepSeek" },
  { slot: "sentiment_aggregate",  label: "9. Sentiment",            owner: "—" },
  { slot: "self_critique",        label: "10. Self-Critique",       owner: "rotated" },
  { slot: "risk_gate",            label: "11. Risk Gate (VETO)",    owner: "Bridgewater" },
  { slot: "portfolio_fit",        label: "12. Portfolio Fit",       owner: "BlackRock" },
  { slot: "execution",            label: "13. Execution",            owner: "Citadel" },
];
const BAND_COLORS: Record<string, string> = {
  PLATINUM: "#e5e7eb",
  GOLD:     "#facc15",
  SILVER:   "#94a3b8",
  BRONZE:   "#a16207",
  TRASH:    "#dc2626",
};

// ─── Small helpers ─────────────────────────────────────────────────────────
function timeAgo(iso: string): string {
  if (!iso) return "—";
  const ms = Date.now() - new Date(iso).getTime();
  if (ms < 0) return "now";
  const m = Math.floor(ms / 60000);
  if (m < 1) return `${Math.floor(ms / 1000)}s ago`;
  if (m < 60) return `${m}m ago`;
  const h = Math.floor(m / 60);
  if (h < 24) return `${h}h ago`;
  return `${Math.floor(h / 24)}d ago`;
}

function verdictColor(verdict: string | null): string {
  if (!verdict) return "var(--color-mc-text-dim)";
  if (verdict === "STRONG_BULL" || verdict === "BULL") return "var(--color-mc-green)";
  if (verdict === "STRONG_BEAR" || verdict === "BEAR") return "var(--color-mc-red)";
  return "var(--color-mc-text-dim)";
}

function stageStateToSeverity(state: string | undefined): 'green' | 'amber' | 'red' | 'neutral' {
  if (state === 'pass') return 'green';
  if (state === 'fail') return 'red';
  if (state === 'pending') return 'amber';
  return 'neutral';
}

// ─── Page component ────────────────────────────────────────────────────────
export function DeskPage() {
  const [data, setData] = useState<DeskState | null>(null);
  const [err, setErr] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);
  const [selectedDossierIdx, setSelectedDossierIdx] = useState(0);
  const [assetClassFilter, setAssetClassFilter] = useState<"all" | "stocks" | "options-flow" | "crypto">("all");
  const [selectedCycleIdx, setSelectedCycleIdx] = useState<number | null>(null);

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch("/api/desk-cycle", { cache: "no-store" });
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      const j = await r.json();
      if (j.error) throw new Error(j.error);
      setData(j);
      setErr(null);
    } catch (e: unknown) {
      setErr(e instanceof Error ? e.message : String(e));
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchData();
    const t = setInterval(fetchData, 30_000);
    return () => clearInterval(t);
  }, [fetchData]);

  if (loading) return <PageWrap><div style={{ color: "var(--color-mc-text-muted)" }}>Loading desk state…</div></PageWrap>;
  if (!data)   return <PageWrap><div style={{ color: err ? "var(--color-mc-red)" : "var(--color-mc-text-muted)" }}>{err ? `desk-cycle error: ${err}` : "No data."}</div></PageWrap>;

  const filteredFloor4 = assetClassFilter === "all"
    ? data.floor4
    : data.floor4.filter((d: any) => (d.asset_class ?? "stocks") === assetClassFilter);
  const safeIdx = Math.min(Math.max(0, selectedDossierIdx), Math.max(0, filteredFloor4.length - 1));
  const topDossier = filteredFloor4[safeIdx];
  const candByLane = Object.fromEntries(data.floor1.candidates_by_lane.map(r => [r.lane, r.n]));
  const candBySrc  = Object.fromEntries(data.floor1.candidates_by_source.map(r => [r.source_agent, r.n]));
  const lanesByName = Object.fromEntries(data.floor3.map(l => [l.lane, l]));

  const cycleHistory = data.cycle_history ?? [];
  const maxDossiers = Math.max(...cycleHistory.map(c => c.n_dossiers), 1);
  const selectedCycle = selectedCycleIdx !== null ? cycleHistory[selectedCycleIdx] ?? null : null;
  const laneStageMatrix = data.lane_stage_matrix ?? null;

  function laneStageValue(rowIdx: number, colIdx: number) {
    const lane = ALL_LANES[rowIdx];
    const stage = CHAIN_STAGES[colIdx];
    if (laneStageMatrix) {
      const laneRow = laneStageMatrix.find(r => r.lane === lane);
      const state = laneRow?.stages[stage.slot];
      const sev = stageStateToSeverity(state);
      return { score: sev === 'green' ? 1 : sev === 'amber' ? 0.5 : sev === 'red' ? 0 : -1, label: state ? state.slice(0, 4) : '—', severity: sev };
    }
    const dossier = (data?.floor4 ?? []).find((d: any) => (d.lane ?? null) === lane);
    const stageVal = dossier?.stages?.[stage.slot];
    if (stageVal !== undefined) {
      const hasVeto = !!stageVal?.veto;
      return { score: hasVeto ? 0 : 1, label: hasVeto ? 'VETO' : 'pass', severity: (hasVeto ? 'red' : 'green') as 'red' | 'green' };
    }
    const laneData = lanesByName[lane];
    if (laneData) return { score: 0.5, label: '—', severity: 'neutral' as const };
    return { score: -1, label: '—', severity: 'neutral' as const };
  }

  return (
    <PageWrap>
      {err && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Top bar with GradientHeader */}
      <GradientHeader
        title="Six-Floor Sovereign Wealth Desk"
        subtitle="Live pipeline state · refreshed every 30s"
      >
        <StatBadge label="Candidates" v={data.stats.total_candidates} />
        <StatBadge label="Lanes" v={data.stats.total_lane_findings} />
        <StatBadge label="Dossiers" v={data.stats.total_dossiers} />
        <StatBadge label="Shortlist" v={data.stats.total_shortlist} />
        <StatBadge label="Agents" v={data.stats.total_agent_calls} />
        <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>
          {timeAgo(data.generated_at)}
        </div>
      </GradientHeader>

      {/* Cycle history mini-timeline */}
      {cycleHistory.length > 0 && (
        <div style={{ marginBottom: 14 }}>
          <div style={{ fontSize: 10, color: "var(--color-mc-text-muted)", fontFamily: "var(--font-mc-mono)", marginBottom: 6, letterSpacing: 1 }}>
            CYCLE HISTORY (last {cycleHistory.length}) — click bar for summary
          </div>
          <div style={{ display: "flex", gap: 3, alignItems: "flex-end", height: 40 }}>
            {cycleHistory.map((c, i) => {
              const barH = Math.max(4, Math.round((c.n_dossiers / maxDossiers) * 36));
              const isSelected = selectedCycleIdx === i;
              const isLatest = i === cycleHistory.length - 1;
              return (
                <button
                  key={c.cycle_id}
                  onClick={() => setSelectedCycleIdx(isSelected ? null : i)}
                  title={`${c.ran_at ? new Date(c.ran_at).toLocaleString() : '—'} · ${c.n_dossiers} dossiers · ${c.n_shortlist} shortlist · summary only — full replay coming in v2`}
                  style={{
                    width: 10, height: barH, borderRadius: 2,
                    background: isSelected
                      ? "var(--color-mc-accent)"
                      : isLatest
                      ? "color-mix(in srgb, var(--color-mc-accent) 60%, transparent)"
                      : "var(--color-mc-bg-surface)",
                    border: `1px solid ${isSelected ? "var(--color-mc-accent)" : "var(--color-mc-border)"}`,
                    cursor: "pointer", flexShrink: 0, transition: "background 0.15s",
                  }}
                  aria-label={`Cycle ${i + 1}: ${c.n_dossiers} dossiers, ran ${timeAgo(c.ran_at)}`}
                />
              );
            })}
          </div>
          {selectedCycle && (
            <div style={{
              marginTop: 8, padding: 12,
              background: "var(--color-mc-bg-card)", border: "1px solid var(--color-mc-accent)",
              borderRadius: 6, fontSize: 11, fontFamily: "var(--font-mc-mono)", color: "var(--color-mc-text)",
            }}>
              <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 6 }}>
                <span style={{ color: "var(--color-mc-accent)", fontWeight: 600 }}>
                  Cycle summary — full per-cycle replay coming in v2
                </span>
                <button onClick={() => setSelectedCycleIdx(null)} style={{ background: "transparent", border: "none", color: "var(--color-mc-text-muted)", cursor: "pointer", fontSize: 12 }}>✕</button>
              </div>
              <div style={{ display: "flex", gap: 20 }}>
                <Kv label="ran_at" value={selectedCycle.ran_at ? new Date(selectedCycle.ran_at).toLocaleString() : '—'} />
                <Kv label="candidates" value={String(selectedCycle.n_candidates)} />
                <Kv label="dossiers" value={String(selectedCycle.n_dossiers)} />
                <Kv label="shortlist" value={String(selectedCycle.n_shortlist)} />
                {selectedCycle.duration_s !== undefined && <Kv label="duration" value={`${selectedCycle.duration_s.toFixed(1)}s`} />}
              </div>
            </div>
          )}
        </div>
      )}

      {/* Asset-class filter chips with Badge */}
      <div style={{ display: "flex", gap: 6, marginBottom: 12 }}>
        {(["all", "stocks", "options-flow", "crypto"] as const).map(cls => {
          const isActive = assetClassFilter === cls;
          const count = cls === "all"
            ? data.floor4.length
            : data.floor4.filter((d: any) => (d.asset_class ?? "stocks") === cls).length;
          return (
            <button
              key={cls}
              onClick={() => { setAssetClassFilter(cls); setSelectedDossierIdx(0); }}
              style={{
                padding: "5px 12px", fontSize: 11, borderRadius: 4,
                background: isActive ? "color-mix(in srgb, var(--color-mc-accent) 20%, transparent)" : "var(--color-mc-bg-card)",
                border: `1px solid ${isActive ? "var(--color-mc-accent)" : "var(--color-mc-border)"}`,
                color: isActive ? "var(--color-mc-accent)" : "var(--color-mc-text-muted)",
                cursor: "pointer", fontWeight: isActive ? 600 : 400,
                textTransform: "uppercase", letterSpacing: 0.5, fontFamily: "var(--font-mc-mono)",
              }}
            >
              {cls} ({count})
            </button>
          );
        })}
      </div>

      <div style={{ display: "grid", gap: 14, gridTemplateColumns: "minmax(0,3fr) minmax(0,2fr)" }}>
        {/* LEFT column */}
        <div style={{ display: "flex", flexDirection: "column", gap: 14 }}>

          {/* Floor 1 — Scout Tower */}
          <FloorCard label="FLOOR 1" title="Scout Tower" sub="12 scouts ingest live signal streams in parallel">
            <div style={{ display: "grid", gridTemplateColumns: "repeat(4, 1fr)", gap: 6 }}>
              {ALL_SCOUTS.map(s => {
                const n = candBySrc[s] ?? 0;
                // cycle_history doesn't yet carry per-scout timeseries; sparkline data will populate once backend delivers it
                const sparkData: number[] = [];
                return (
                  <div key={s} style={{
                    background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)",
                    borderRadius: 6, padding: "6px 10px", opacity: n > 0 ? 1 : 0.45,
                  }}>
                    <div style={{ fontSize: 11, color: "var(--color-mc-text)", fontWeight: 500 }}>
                      {s.replace("-scout", "")}
                    </div>
                    <div style={{ fontSize: 14, color: n > 0 ? "var(--color-mc-green)" : "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>
                      {n} cand
                    </div>
                    {sparkData.length > 0 && <Sparkline data={sparkData} height={20} />}
                  </div>
                );
              })}
            </div>
          </FloorCard>

          {/* Floor 2 — Macro Room */}
          <FloorCard label="FLOOR 2" title="Macro Room" sub="7 macro agents · cached 30 min · shared across cycle">
            <div style={{ display: "flex", gap: 12 }}>
              <div style={{ flex: 1 }}>
                <div style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6, padding: 12, height: "100%" }}>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>REGIME</div>
                  <div style={{ fontSize: 28, color: data.floor2?.regime === "RISK_ON" ? "var(--color-mc-green)" : "var(--color-mc-amber)", fontWeight: 600 }}>
                    {data.floor2?.regime ?? "—"}
                  </div>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", marginTop: 8, fontFamily: "var(--font-mc-mono)" }}>FED POSTURE</div>
                  <div style={{ fontSize: 14, color: "var(--color-mc-text)" }}>{data.floor2?.fed_posture ?? "—"}</div>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", marginTop: 8, fontFamily: "var(--font-mc-mono)" }}>VIX</div>
                  <div style={{ fontSize: 14, color: "var(--color-mc-text)" }}>
                    {data.floor2?.vix ?? "—"} {data.floor2?.vix_pct != null && <span style={{ color: "var(--color-mc-text-dim)" }}>({data.floor2.vix_pct}th pct)</span>}
                  </div>
                </div>
              </div>
              <div style={{ flex: 2 }}>
                <div style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6, padding: 12, height: "100%" }}>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>SECTOR TAILWINDS</div>
                  <div style={{ fontSize: 13, color: "var(--color-mc-green)", margin: "4px 0" }}>
                    {data.floor2?.sector_tailwinds?.tailwinds?.join("  ·  ") || "—"}
                  </div>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", marginTop: 6, fontFamily: "var(--font-mc-mono)" }}>SECTOR HEADWINDS</div>
                  <div style={{ fontSize: 13, color: "var(--color-mc-red)", margin: "4px 0" }}>
                    {data.floor2?.sector_tailwinds?.headwinds?.join("  ·  ") || "—"}
                  </div>
                  {data.floor2?.sector_tailwinds?.theme && (
                    <div style={{ fontSize: 12, color: "var(--color-mc-text-muted)", marginTop: 8, lineHeight: 1.5 }}>
                      "{data.floor2.sector_tailwinds.theme}"
                    </div>
                  )}
                </div>
              </div>
              <div style={{ flex: 1 }}>
                <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: 6 }}>
                  {ALL_MACRO_AGENTS.map(a => (
                    <div key={a.id} style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 4, padding: "4px 6px" }}>
                      <div style={{ fontSize: 10, color: "var(--color-mc-text-muted)", fontFamily: "var(--font-mc-mono)" }}>{a.short}</div>
                      <div style={{ fontSize: 9, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{a.dna}</div>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </FloorCard>

          {/* Floor 3 — Heatmap OR card grid */}
          <FloorCard label="FLOOR 3" title="Lane Research" sub="15 sector specialists — lane × stage heatmap">
            {(laneStageMatrix || data.floor3.length > 0) ? (
              <div style={{ overflowX: "auto" }}>
                <Heatmap
                  rows={ALL_LANES}
                  cols={CHAIN_STAGES.map(s => s.slot.slice(0, 6))}
                  value={laneStageValue}
                  onCellClick={(ri, ci) => {
                    const lane = ALL_LANES[ri];
                    const stage = CHAIN_STAGES[ci];
                    const laneData = lanesByName[lane];
                    if (laneData) {
                      const obs = laneData.key_observations?.slice(0, 3).join('; ') ?? '—';
                      window.alert(`${lane} × ${stage.label}\nVerdict: ${laneData.verdict ?? '—'}\n${obs}`);
                    }
                  }}
                />
              </div>
            ) : (
              <div style={{ display: "grid", gridTemplateColumns: "repeat(5, 1fr)", gap: 6 }}>
                {ALL_LANES.map(l => {
                  const lane = lanesByName[l];
                  const candCount = candByLane[l] ?? 0;
                  const verdict = lane?.verdict ?? null;
                  return (
                    <div key={l} style={{
                      background: "var(--color-mc-bg-surface)",
                      border: `1px solid ${verdict ? verdictColor(verdict) : "var(--color-mc-border)"}`,
                      borderRadius: 6, padding: "8px 10px",
                      opacity: candCount > 0 || verdict ? 1 : 0.55,
                    }}>
                      <div style={{ fontSize: 11, fontWeight: 600, color: "var(--color-mc-text)", marginBottom: 2 }}>{l}</div>
                      <div style={{ fontSize: 13, color: verdictColor(verdict), fontWeight: 600 }}>{verdict ?? "—"}</div>
                      {lane && lane.top_tickers.length > 0 && (
                        <div style={{ fontSize: 10, color: "var(--color-mc-text-muted)", marginTop: 4 }}>{lane.top_tickers.slice(0, 3).join(" · ")}</div>
                      )}
                      <div style={{ fontSize: 10, color: "var(--color-mc-text-dim)", marginTop: 4 }}>{candCount} cand</div>
                    </div>
                  );
                })}
              </div>
            )}
          </FloorCard>

          {/* Floor 4 */}
          {topDossier && (
            <FloorCard
              label="FLOOR 4"
              title={`Per-Candidate Chain · dossier ${safeIdx + 1}/${filteredFloor4.length} (#${topDossier.id})${assetClassFilter !== "all" ? ` · ${assetClassFilter}` : ""}`}
              sub={`${topDossier.ticker} ${topDossier.contract?.side ?? ""} $${topDossier.contract?.strike ?? ""} ${topDossier.contract?.expiry ?? ""}`}
            >
              {filteredFloor4.length > 1 && (
                <div style={{ display: "flex", gap: 4, marginBottom: 12, flexWrap: "wrap" }}>
                  {filteredFloor4.map((d, i) => {
                    const isActive = i === safeIdx;
                    const bandColor = BAND_COLORS[d.band ?? "BRONZE"];
                    return (
                      <button key={d.id} onClick={() => setSelectedDossierIdx(i)} style={{
                        padding: "4px 10px", fontSize: 11, borderRadius: 4,
                        background: isActive ? bandColor + "33" : "var(--color-mc-bg-card)",
                        border: `1px solid ${isActive ? bandColor : "var(--color-mc-border)"}`,
                        color: isActive ? bandColor : "var(--color-mc-text-muted)",
                        cursor: "pointer", fontWeight: isActive ? 600 : 400, fontFamily: "var(--font-mc-mono)",
                      }}>
                        {d.ticker} {d.band ?? "—"}/{d.confidence ?? "?"}
                      </button>
                    );
                  })}
                </div>
              )}
              <div style={{ display: "flex", gap: 14 }}>
                <div style={{ flex: 1 }}>
                  <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                    <span style={{
                      fontSize: 12, fontWeight: 700, padding: "3px 10px", borderRadius: 4,
                      border: "1px solid", fontFamily: "var(--font-mc-mono)", letterSpacing: 1,
                      background: BAND_COLORS[topDossier.band ?? "BRONZE"] + "26",
                      color: BAND_COLORS[topDossier.band ?? "BRONZE"],
                      borderColor: BAND_COLORS[topDossier.band ?? "BRONZE"],
                    }}>
                      {topDossier.band ?? "—"} · {topDossier.confidence ?? "?"}
                    </span>
                    <span style={{ fontSize: 11, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{topDossier.slot_count} stages filled</span>
                  </div>
                  <div style={{ marginTop: 14 }}>
                    {CHAIN_STAGES.map(st => {
                      const filled = topDossier.stages?.[st.slot];
                      const veto = !!(filled?.veto);
                      return (
                        <div key={st.slot} style={{ display: "flex", gap: 8, padding: "3px 0", alignItems: "center", color: filled ? "var(--color-mc-text)" : "var(--color-mc-text-dim)" }}>
                          <span style={{ width: 16, color: filled ? "var(--color-mc-green)" : "var(--color-mc-border)" }}>{filled ? "✓" : "·"}</span>
                          <span style={{ flex: 1, fontSize: 12 }}>{st.label}</span>
                          <span style={{ fontSize: 10, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{st.owner}</span>
                          {veto && <span style={{ fontSize: 10, color: "var(--color-mc-red)", marginLeft: 6, fontFamily: "var(--font-mc-mono)" }}>VETO</span>}
                        </div>
                      );
                    })}
                  </div>
                </div>
                <div style={{ flex: 1 }}>
                  <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", textTransform: "uppercase", letterSpacing: 1, marginBottom: 6, fontFamily: "var(--font-mc-mono)" }}>Curator Thesis</div>
                  <div style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6, padding: 10, fontSize: 12, color: "var(--color-mc-text)", lineHeight: 1.5 }}>
                    {topDossier.thesis ?? "(no thesis)"}
                  </div>
                  {topDossier.stages?.execution?.recommended_structure && (
                    <>
                      <div style={{ fontSize: 11, color: "var(--color-mc-text-dim)", textTransform: "uppercase", letterSpacing: 1, margin: "12px 0 6px", fontFamily: "var(--font-mc-mono)" }}>Execution recommendation</div>
                      <div style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6, padding: 10, fontSize: 12, color: "var(--color-mc-text)" }}>
                        <div>{topDossier.stages.execution.recommended_structure?.type ?? "—"}</div>
                        {topDossier.stages.execution.recommended_structure?.debit_mid_estimate && (
                          <div style={{ color: "var(--color-mc-text-muted)", marginTop: 4 }}>
                            debit ~${topDossier.stages.execution.recommended_structure.debit_mid_estimate} · R/R {topDossier.stages.execution.recommended_structure?.risk_reward_at_mid?.toFixed?.(1) ?? topDossier.stages.execution.recommended_structure?.risk_reward_at_mid ?? "—"}x
                          </div>
                        )}
                      </div>
                    </>
                  )}
                </div>
              </div>
            </FloorCard>
          )}
        </div>

        {/* RIGHT column */}
        <div style={{ display: "flex", flexDirection: "column", gap: 14 }}>
          {/* Floor 5 */}
          <FloorCard label="FLOOR 5" title="Publish · Premium Shortlist" sub="Ranked dossiers pushed to Oracle for Boba/Jazzy">
            {data.floor5.length === 0 ? (
              <div style={{ fontSize: 12, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>No shortlist entries yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 6 }}>
                {data.floor5.map(s => {
                  const dossier = data.floor4.find(d => d.id === s.dossier_id);
                  return (
                    <div key={`${s.cycle_id}-${s.rank}`} style={{ display: "flex", alignItems: "center", gap: 10, padding: "8px 10px", background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6 }}>
                      <span style={{ fontSize: 11, fontFamily: "var(--font-mc-mono)", width: 24, color: "var(--color-mc-text-muted)" }}>#{s.rank}</span>
                      <span style={{ fontSize: 13, color: "var(--color-mc-text)", flex: 1 }}>
                        {dossier?.ticker ?? `dossier ${s.dossier_id}`}
                        {dossier?.contract?.side && <span style={{ color: "var(--color-mc-text-dim)", marginLeft: 6, fontFamily: "var(--font-mc-mono)" }}>{dossier.contract.side} ${dossier.contract.strike}</span>}
                      </span>
                      <span style={{ fontSize: 10, fontWeight: 600, padding: "2px 7px", borderRadius: 3, fontFamily: "var(--font-mc-mono)", background: BAND_COLORS[s.confidence_band] + "26", color: BAND_COLORS[s.confidence_band] }}>
                        {s.confidence_band} · {s.confidence_score}
                      </span>
                      <span style={{ fontSize: 10, color: "var(--color-mc-text-dim)", width: 56, textAlign: "right", fontFamily: "var(--font-mc-mono)" }}>{timeAgo(s.generated_at)}</span>
                    </div>
                  );
                })}
              </div>
            )}
          </FloorCard>

          {/* Floor 6 */}
          <FloorCard label="FLOOR 6" title="R&D + Reporting" sub="Daily reports → Discord · thesis decay · R&D">
            {data.floor6.length === 0 ? (
              <div style={{ fontSize: 12, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>No R&D outputs yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 8 }}>
                {data.floor6.map(r => (
                  <div key={r.id} style={{ background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 6, padding: 10 }}>
                    <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                      <span style={{ fontSize: 12, fontWeight: 500, color: "var(--color-mc-text)" }}>{r.agent_name}</span>
                      <span style={{ fontSize: 10, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{timeAgo(r.created_at)}</span>
                    </div>
                    {r.payload?.headline && <div style={{ fontSize: 11, color: "var(--color-mc-text-muted)", marginTop: 4, lineHeight: 1.45 }}>{r.payload.headline}</div>}
                    <div style={{ fontSize: 10, color: "var(--color-mc-text-dim)", marginTop: 4, fontFamily: "var(--font-mc-mono)" }}>type: {r.output_type} {r.acted_on && <span style={{ color: "var(--color-mc-green)", marginLeft: 6 }}>· acted</span>}</div>
                  </div>
                ))}
              </div>
            )}
          </FloorCard>

          {/* Activity feed */}
          <FloorCard label="ACTIVITY" title="External LLM Agent Calls" sub="Live token usage + model dispatch trail">
            {data.agent_calls.length === 0 ? (
              <div style={{ fontSize: 12, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>No agent calls yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 4, maxHeight: 320, overflowY: "auto" }}>
                {data.agent_calls.map(c => (
                  <div key={c.id} style={{ display: "flex", alignItems: "center", gap: 8, padding: "5px 8px", background: "var(--color-mc-bg-surface)", border: "1px solid var(--color-mc-border)", borderRadius: 4 }}>
                    <span style={{ width: 52, fontSize: 10, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{timeAgo(c.completed_at)}</span>
                    <span style={{ flex: 1, fontSize: 11, color: c.error ? "var(--color-mc-red)" : "var(--color-mc-text)" }}>{c.agent_name}</span>
                    <span style={{ width: 110, fontSize: 10, color: "var(--color-mc-text-dim)", fontFamily: "var(--font-mc-mono)" }}>{c.model}</span>
                    <span style={{ width: 60, fontSize: 10, color: "var(--color-mc-text-dim)", textAlign: "right", fontFamily: "var(--font-mc-mono)" }}>{c.input_tokens}/{c.output_tokens}</span>
                  </div>
                ))}
              </div>
            )}
          </FloorCard>
        </div>
      </div>
    </PageWrap>
  );
}


// ─── Layout helpers ────────────────────────────────────────────────────────
function PageWrap({ children }: { children: React.ReactNode }) {
  return (
    <div style={{ background: "var(--color-mc-bg)", minHeight: "100vh", padding: "20px 24px", fontFamily: "var(--font-mc-sans)" }}>
      {children}
    </div>
  );
}
function FloorCard({ label, title, sub, children }: { label: string; title: string; sub?: string; children: React.ReactNode }) {
  return (
    <div style={{ background: "var(--color-mc-bg-card)", border: "1px solid var(--color-mc-border)", borderRadius: 10, padding: 16 }}>
      <div style={{ display: "flex", alignItems: "baseline", gap: 12, marginBottom: 12 }}>
        <span style={{ fontSize: 10, color: "var(--color-mc-text-dim)", fontWeight: 700, letterSpacing: 2, fontFamily: "var(--font-mc-mono)" }}>{label}</span>
        <span style={{ fontSize: 14, color: "var(--color-mc-text)", fontWeight: 600 }}>{title}</span>
        {sub && <span style={{ fontSize: 11, color: "var(--color-mc-text-dim)", marginLeft: "auto", fontFamily: "var(--font-mc-mono)" }}>{sub}</span>}
      </div>
      {children}
    </div>
  );
}
function StatBadge({ label, v }: { label: string; v: number }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "flex-end" }}>
      <div style={{ fontSize: 18, color: "var(--color-mc-text)", fontWeight: 600, fontFamily: "var(--font-mc-mono)" }}>{v}</div>
      <div style={{ fontSize: 9, color: "var(--color-mc-text-dim)", textTransform: "uppercase", letterSpacing: 1.5, fontFamily: "var(--font-mc-mono)" }}>{label}</div>
    </div>
  );
}
function Kv({ label, value }: { label: string; value: string }) {
  return (
    <div>
      <div style={{ fontSize: 9, color: "var(--color-mc-text-dim)", textTransform: "uppercase", fontFamily: "var(--font-mc-mono)" }}>{label}</div>
      <div style={{ fontSize: 12, color: "var(--color-mc-text)", fontFamily: "var(--font-mc-mono)" }}>{value}</div>
    </div>
  );
}

export default DeskPage;
