"use client";

import { useEffect, useState, useCallback } from "react";

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
}

// ─── Constants ─────────────────────────────────────────────────────────────
const ALL_LANES = [
  "semis", "megatech", "ai-themes", "biotech", "energy", "financials",
  "consumer", "industrials", "healthcare", "REIT", "materials", "utilities",
  "crypto-tier1", "crypto-defi", "small-cap-catalyst",
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
const VERDICT_COLORS: Record<string, string> = {
  STRONG_BULL: "#22c55e",
  BULL:        "#86efac",
  NEUTRAL:     "#64748b",
  BEAR:        "#fca5a5",
  STRONG_BEAR: "#dc2626",
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


// ─── Page component ────────────────────────────────────────────────────────
export function DeskPage() {
  const [data, setData] = useState<DeskState | null>(null);
  const [err, setErr] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  const fetchData = useCallback(async () => {
    try {
      const r = await fetch("/api/desk-cycle", { cache: "no-store" });
      if (!r.ok) throw new Error(`HTTP ${r.status}`);
      const j = await r.json();
      if (j.error) throw new Error(j.error);
      setData(j);
      setErr(null);
    } catch (e: any) {
      setErr(e?.message ?? String(e));
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchData();
    const t = setInterval(fetchData, 30_000);
    return () => clearInterval(t);
  }, [fetchData]);

  if (loading) return <PageWrap><div style={{ color: "#94a3b8" }}>Loading desk state…</div></PageWrap>;
  if (err)     return <PageWrap><div style={{ color: "#fca5a5" }}>desk-cycle error: {err}</div></PageWrap>;
  if (!data)   return <PageWrap><div style={{ color: "#94a3b8" }}>No data.</div></PageWrap>;

  const topDossier = data.floor4[0];
  const candByLane = Object.fromEntries(data.floor1.candidates_by_lane.map(r => [r.lane, r.n]));
  const candBySrc  = Object.fromEntries(data.floor1.candidates_by_source.map(r => [r.source_agent, r.n]));
  const lanesByName = Object.fromEntries(data.floor3.map(l => [l.lane, l]));

  return (
    <PageWrap>
      {/* Top bar */}
      <div style={topBarStyle}>
        <div>
          <div style={{ fontSize: 11, color: "#64748b", textTransform: "uppercase", letterSpacing: 1.5 }}>
            Six-Floor Sovereign Wealth Desk
          </div>
          <h1 style={{ fontSize: 20, margin: "4px 0 0", color: "#e6edf3" }}>
            Live pipeline state · refreshed every 30s
          </h1>
        </div>
        <div style={{ display: "flex", gap: 18, alignItems: "center" }}>
          <Stat label="Candidates" v={data.stats.total_candidates} />
          <Stat label="Lanes" v={data.stats.total_lane_findings} />
          <Stat label="Dossiers" v={data.stats.total_dossiers} />
          <Stat label="Shortlist" v={data.stats.total_shortlist} />
          <Stat label="Agent calls" v={data.stats.total_agent_calls} />
          <div style={{ fontSize: 11, color: "#475569" }}>
            updated {timeAgo(data.generated_at)}
          </div>
        </div>
      </div>

      <div style={{ display: "grid", gap: 14, gridTemplateColumns: "minmax(0,3fr) minmax(0,2fr)" }}>
        {/* LEFT column — Floors 1 / 2 / 3 */}
        <div style={{ display: "flex", flexDirection: "column", gap: 14 }}>
          {/* Floor 1 */}
          <FloorCard label="FLOOR 1" title="Scout Tower" sub="12 scouts ingest live signal streams in parallel">
            <div style={scoutGridStyle}>
              {ALL_SCOUTS.map(s => {
                const n = candBySrc[s] ?? 0;
                return (
                  <div key={s} style={{ ...agentChipStyle, opacity: n > 0 ? 1 : 0.45 }}>
                    <div style={{ fontSize: 11, color: "#cbd5e1", fontWeight: 500 }}>
                      {s.replace("-scout","")}
                    </div>
                    <div style={{ fontSize: 14, color: n > 0 ? "#22c55e" : "#475569", fontFamily: "ui-monospace" }}>
                      {n} cand
                    </div>
                  </div>
                );
              })}
            </div>
          </FloorCard>

          {/* Floor 2 */}
          <FloorCard label="FLOOR 2" title="Macro Room" sub="7 macro agents · cached 30 min · shared across cycle">
            <div style={{ display: "flex", gap: 12 }}>
              <div style={{ flex: 1 }}>
                <div style={macroBlock}>
                  <div style={{ fontSize: 11, color: "#64748b" }}>REGIME</div>
                  <div style={{ fontSize: 28, color: data.floor2?.regime === "RISK_ON" ? "#22c55e" : "#f59e0b", fontWeight: 600 }}>
                    {data.floor2?.regime ?? "—"}
                  </div>
                  <div style={{ fontSize: 11, color: "#64748b", marginTop: 8 }}>FED POSTURE</div>
                  <div style={{ fontSize: 14, color: "#cbd5e1" }}>{data.floor2?.fed_posture ?? "—"}</div>
                  <div style={{ fontSize: 11, color: "#64748b", marginTop: 8 }}>VIX</div>
                  <div style={{ fontSize: 14, color: "#cbd5e1" }}>
                    {data.floor2?.vix ?? "—"} {data.floor2?.vix_pct != null && <span style={{ color: "#64748b" }}>({data.floor2.vix_pct}th pct)</span>}
                  </div>
                </div>
              </div>
              <div style={{ flex: 2 }}>
                <div style={macroBlock}>
                  <div style={{ fontSize: 11, color: "#64748b" }}>SECTOR TAILWINDS</div>
                  <div style={{ fontSize: 13, color: "#86efac", margin: "4px 0" }}>
                    {data.floor2?.sector_tailwinds?.tailwinds?.join("  ·  ") || "—"}
                  </div>
                  <div style={{ fontSize: 11, color: "#64748b", marginTop: 6 }}>SECTOR HEADWINDS</div>
                  <div style={{ fontSize: 13, color: "#fca5a5", margin: "4px 0" }}>
                    {data.floor2?.sector_tailwinds?.headwinds?.join("  ·  ") || "—"}
                  </div>
                  {data.floor2?.sector_tailwinds?.theme && (
                    <div style={{ fontSize: 12, color: "#94a3b8", marginTop: 8, lineHeight: 1.5 }}>
                      "{data.floor2.sector_tailwinds.theme}"
                    </div>
                  )}
                </div>
              </div>
              <div style={{ flex: 1 }}>
                <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: 6 }}>
                  {ALL_MACRO_AGENTS.map(a => (
                    <div key={a.id} style={agentChipMini}>
                      <div style={{ fontSize: 10, color: "#94a3b8" }}>{a.short}</div>
                      <div style={{ fontSize: 9, color: "#475569" }}>{a.dna}</div>
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </FloorCard>

          {/* Floor 3 */}
          <FloorCard label="FLOOR 3" title="Lane Research" sub="15 sector specialists ingest macro context + candidates">
            <div style={laneGridStyle}>
              {ALL_LANES.map(l => {
                const lane = lanesByName[l];
                const candCount = candByLane[l] ?? 0;
                const verdict = lane?.verdict ?? null;
                return (
                  <div key={l} style={{
                    ...laneCardStyle,
                    borderColor: verdict ? VERDICT_COLORS[verdict] ?? "#334155" : "#1e293b",
                    opacity: candCount > 0 || verdict ? 1 : 0.55,
                  }}>
                    <div style={{ fontSize: 11, fontWeight: 600, color: "#e2e8f0", marginBottom: 2 }}>{l}</div>
                    <div style={{ fontSize: 13, color: verdict ? VERDICT_COLORS[verdict] : "#475569", fontWeight: 600 }}>
                      {verdict ?? "—"}
                    </div>
                    {lane && lane.top_tickers.length > 0 && (
                      <div style={{ fontSize: 10, color: "#94a3b8", marginTop: 4 }}>
                        {lane.top_tickers.slice(0,3).join(" · ")}
                      </div>
                    )}
                    <div style={{ fontSize: 10, color: "#475569", marginTop: 4 }}>
                      {candCount} cand
                    </div>
                  </div>
                );
              })}
            </div>
          </FloorCard>

          {/* Floor 4 — featured dossier */}
          {topDossier && (
            <FloorCard
              label="FLOOR 4"
              title={`Per-Candidate Chain · top dossier #${topDossier.id}`}
              sub={`${topDossier.ticker} ${topDossier.contract?.side ?? ""} $${topDossier.contract?.strike ?? ""} ${topDossier.contract?.expiry ?? ""}`}
            >
              <div style={{ display: "flex", gap: 14 }}>
                <div style={{ flex: 1 }}>
                  <div style={dossierHeader}>
                    <span style={{
                      ...bandPill,
                      background: BAND_COLORS[topDossier.band ?? "BRONZE"] + "26",
                      color: BAND_COLORS[topDossier.band ?? "BRONZE"],
                      borderColor: BAND_COLORS[topDossier.band ?? "BRONZE"],
                    }}>
                      {topDossier.band ?? "—"} · {topDossier.confidence ?? "?"}
                    </span>
                    <span style={{ fontSize: 11, color: "#64748b" }}>
                      {topDossier.slot_count} stages filled
                    </span>
                  </div>
                  <div style={{ marginTop: 14 }}>
                    {CHAIN_STAGES.map(st => {
                      const filled = topDossier.stages?.[st.slot];
                      const veto = !!(filled?.veto);
                      return (
                        <div key={st.slot} style={{
                          ...stageRowStyle,
                          color: filled ? "#cbd5e1" : "#475569",
                        }}>
                          <span style={{ width: 16, color: filled ? "#22c55e" : "#334155" }}>
                            {filled ? "✓" : "·"}
                          </span>
                          <span style={{ flex: 1, fontSize: 12 }}>{st.label}</span>
                          <span style={{ fontSize: 10, color: "#475569" }}>{st.owner}</span>
                          {veto && <span style={{ fontSize: 10, color: "#dc2626", marginLeft: 6 }}>VETO</span>}
                        </div>
                      );
                    })}
                  </div>
                </div>
                <div style={{ flex: 1 }}>
                  <div style={{ fontSize: 11, color: "#64748b", textTransform: "uppercase", letterSpacing: 1, marginBottom: 6 }}>
                    Curator Thesis
                  </div>
                  <div style={thesisBlock}>{topDossier.thesis ?? "(no thesis)"}</div>

                  {topDossier.stages?.execution?.recommended_structure && (
                    <>
                      <div style={{ fontSize: 11, color: "#64748b", textTransform: "uppercase", letterSpacing: 1, margin: "12px 0 6px" }}>
                        Execution recommendation
                      </div>
                      <div style={execBlock}>
                        <div>{topDossier.stages.execution.recommended_structure?.type ?? "—"}</div>
                        {topDossier.stages.execution.recommended_structure?.debit_mid_estimate && (
                          <div style={{ color: "#94a3b8", marginTop: 4 }}>
                            debit ~${topDossier.stages.execution.recommended_structure.debit_mid_estimate} ·
                            R/R {topDossier.stages.execution.recommended_structure?.risk_reward_at_mid?.toFixed?.(1) ?? topDossier.stages.execution.recommended_structure?.risk_reward_at_mid ?? "—"}x
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

        {/* RIGHT column — Floor 5 / 6 + activity feed */}
        <div style={{ display: "flex", flexDirection: "column", gap: 14 }}>
          {/* Floor 5 — premium shortlist */}
          <FloorCard label="FLOOR 5" title="Publish · Premium Shortlist" sub="Ranked dossiers pushed to Oracle for Boba/Jazzy">
            {data.floor5.length === 0 ? (
              <div style={{ fontSize: 12, color: "#64748b" }}>No shortlist entries yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 6 }}>
                {data.floor5.map(s => {
                  const dossier = data.floor4.find(d => d.id === s.dossier_id);
                  return (
                    <div key={`${s.cycle_id}-${s.rank}`} style={shortlistRow}>
                      <span style={{ ...rankPill, color: "#94a3b8" }}>#{s.rank}</span>
                      <span style={{ fontSize: 13, color: "#e6edf3", flex: 1 }}>
                        {dossier?.ticker ?? `dossier ${s.dossier_id}`}
                        {dossier?.contract?.side && (
                          <span style={{ color: "#64748b", marginLeft: 6 }}>
                            {dossier.contract.side} ${dossier.contract.strike}
                          </span>
                        )}
                      </span>
                      <span style={{
                        ...bandPillSm,
                        background: BAND_COLORS[s.confidence_band] + "26",
                        color: BAND_COLORS[s.confidence_band],
                      }}>
                        {s.confidence_band} · {s.confidence_score}
                      </span>
                      <span style={{ fontSize: 10, color: "#475569", width: 56, textAlign: "right" }}>
                        {timeAgo(s.generated_at)}
                      </span>
                    </div>
                  );
                })}
              </div>
            )}
          </FloorCard>

          {/* Floor 6 — R&D + Reporting */}
          <FloorCard label="FLOOR 6" title="R&D + Reporting" sub="Daily reports → Discord · thesis decay · R&D">
            {data.floor6.length === 0 ? (
              <div style={{ fontSize: 12, color: "#64748b" }}>No R&D outputs yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 8 }}>
                {data.floor6.map(r => (
                  <div key={r.id} style={rdRow}>
                    <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                      <span style={{ fontSize: 12, fontWeight: 500, color: "#e2e8f0" }}>{r.agent_name}</span>
                      <span style={{ fontSize: 10, color: "#475569" }}>{timeAgo(r.created_at)}</span>
                    </div>
                    {r.payload?.headline && (
                      <div style={{ fontSize: 11, color: "#94a3b8", marginTop: 4, lineHeight: 1.45 }}>
                        {r.payload.headline}
                      </div>
                    )}
                    <div style={{ fontSize: 10, color: "#475569", marginTop: 4 }}>
                      type: {r.output_type} {r.acted_on && <span style={{ color: "#22c55e", marginLeft: 6 }}>· acted</span>}
                    </div>
                  </div>
                ))}
              </div>
            )}
          </FloorCard>

          {/* Activity feed */}
          <FloorCard label="ACTIVITY" title="External LLM Agent Calls" sub="Live token usage + model dispatch trail">
            {data.agent_calls.length === 0 ? (
              <div style={{ fontSize: 12, color: "#64748b" }}>No agent calls yet.</div>
            ) : (
              <div style={{ display: "flex", flexDirection: "column", gap: 4, maxHeight: 320, overflowY: "auto" }}>
                {data.agent_calls.map(c => (
                  <div key={c.id} style={callRow}>
                    <span style={{ width: 52, fontSize: 10, color: "#64748b" }}>{timeAgo(c.completed_at)}</span>
                    <span style={{ flex: 1, fontSize: 11, color: c.error ? "#fca5a5" : "#cbd5e1" }}>
                      {c.agent_name}
                    </span>
                    <span style={{ width: 110, fontSize: 10, color: "#64748b" }}>{c.model}</span>
                    <span style={{ width: 60, fontSize: 10, color: "#475569", textAlign: "right" }}>
                      {c.input_tokens}/{c.output_tokens}
                    </span>
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
    <div style={{
      background: "#0d1117", minHeight: "100vh", padding: "20px 24px",
      fontFamily: "system-ui, -apple-system, sans-serif",
    }}>
      {children}
    </div>
  );
}
function FloorCard({ label, title, sub, children }: { label: string; title: string; sub?: string; children: React.ReactNode }) {
  return (
    <div style={floorCardStyle}>
      <div style={{ display: "flex", alignItems: "baseline", gap: 12, marginBottom: 12 }}>
        <span style={{ fontSize: 10, color: "#475569", fontWeight: 700, letterSpacing: 2 }}>{label}</span>
        <span style={{ fontSize: 14, color: "#e6edf3", fontWeight: 600 }}>{title}</span>
        {sub && <span style={{ fontSize: 11, color: "#64748b", marginLeft: "auto" }}>{sub}</span>}
      </div>
      {children}
    </div>
  );
}
function Stat({ label, v }: { label: string; v: number }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "flex-end" }}>
      <div style={{ fontSize: 18, color: "#e6edf3", fontWeight: 600, fontFamily: "ui-monospace" }}>{v}</div>
      <div style={{ fontSize: 9, color: "#475569", textTransform: "uppercase", letterSpacing: 1.5 }}>{label}</div>
    </div>
  );
}

// ─── Inline styles ────────────────────────────────────────────────────────
const topBarStyle: React.CSSProperties = {
  display: "flex", justifyContent: "space-between", alignItems: "center",
  paddingBottom: 14, marginBottom: 14, borderBottom: "1px solid #1e293b",
};
const floorCardStyle: React.CSSProperties = {
  background: "#0f172a", border: "1px solid #1e293b", borderRadius: 10, padding: 16,
};
const scoutGridStyle: React.CSSProperties = {
  display: "grid", gridTemplateColumns: "repeat(4, 1fr)", gap: 6,
};
const agentChipStyle: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: "6px 10px",
};
const agentChipMini: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 4, padding: "4px 6px",
};
const macroBlock: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: 12, height: "100%",
};
const laneGridStyle: React.CSSProperties = {
  display: "grid", gridTemplateColumns: "repeat(5, 1fr)", gap: 6,
};
const laneCardStyle: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: "8px 10px", transition: "opacity 0.2s",
};
const dossierHeader: React.CSSProperties = {
  display: "flex", justifyContent: "space-between", alignItems: "center",
};
const bandPill: React.CSSProperties = {
  fontSize: 12, fontWeight: 700, padding: "3px 10px", borderRadius: 4,
  border: "1px solid", fontFamily: "ui-monospace", letterSpacing: 1,
};
const bandPillSm: React.CSSProperties = {
  fontSize: 10, fontWeight: 600, padding: "2px 7px", borderRadius: 3,
  fontFamily: "ui-monospace",
};
const rankPill: React.CSSProperties = {
  fontSize: 11, fontFamily: "ui-monospace", width: 24,
};
const stageRowStyle: React.CSSProperties = {
  display: "flex", gap: 8, padding: "3px 0", alignItems: "center",
};
const thesisBlock: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: 10,
  fontSize: 12, color: "#cbd5e1", lineHeight: 1.5,
};
const execBlock: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: 10,
  fontSize: 12, color: "#e6edf3",
};
const shortlistRow: React.CSSProperties = {
  display: "flex", alignItems: "center", gap: 10, padding: "8px 10px",
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6,
};
const rdRow: React.CSSProperties = {
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 6, padding: 10,
};
const callRow: React.CSSProperties = {
  display: "flex", alignItems: "center", gap: 8, padding: "5px 8px",
  background: "#0b1220", border: "1px solid #1e293b", borderRadius: 4,
};
