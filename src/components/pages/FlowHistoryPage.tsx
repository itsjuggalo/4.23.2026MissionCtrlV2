"use client";
// MC_FLOW_GUARD
if (typeof window !== "undefined") { window.addEventListener("unhandledrejection", (e) => { console.warn("[FlowHistory]", e.reason); e.preventDefault(); }); }

import { useState, useEffect, useCallback, useMemo } from "react";
import { StockDetailDrawer } from "@/components/drawers/StockDetailDrawer";

interface Contract {
  option_symbol: string;
  ticker: string;
  strike: number;
  option_type: "CALL" | "PUT";
  expiry: string;
  dte: number;
  volume: number;
  oi: number;
  sweeps: number;
  blocks: number;
  premium: number;
  alert_price: number;
  spot: number;
  is_bullish: boolean;
  tier: "T1_HUGE" | "T2_UNUSUAL_HUGE" | "T3_UNUSUAL" | "NORMAL";
  alert_count: number;
  first_seen?: string;
  last_seen?: string;
  first_seen_ms?: number;
  last_updated_ms?: number;
  alert_type?: string;
}

interface ApiResp {
  date: string;
  last_run_human: string;
  total_contracts: number;
  tier_counts: Record<string, number>;
  highest_premium: number;
  contracts: Contract[];
}

const TIER_COLORS: Record<string, { bg: string; border: string; text: string; label: string }> = {
  T1_HUGE: { bg: "rgba(255,214,0,0.10)", border: "rgba(255,214,0,0.45)", text: "#ffd600", label: "T1 $1M+" },
  T2_UNUSUAL_HUGE: { bg: "rgba(255,167,38,0.10)", border: "rgba(255,167,38,0.40)", text: "#ffa726", label: "T2 $500K+" },
  T3_UNUSUAL: { bg: "rgba(79,195,247,0.08)", border: "rgba(79,195,247,0.30)", text: "#4fc3f7", label: "T3 Unusual" },
  NORMAL: { bg: "rgba(96,125,139,0.08)", border: "rgba(96,125,139,0.30)", text: "#90a4ae", label: "Normal" },
};

function fmtMoney(n: number): string {
  if (!n) return "$0";
  if (n >= 1e9) return `$${(n / 1e9).toFixed(2)}B`;
  if (n >= 1e6) return `$${(n / 1e6).toFixed(2)}M`;
  if (n >= 1e3) return `$${(n / 1e3).toFixed(0)}K`;
  return `$${Math.round(n)}`;
}
function fmtNum(n: number): string {
  if (!n) return "0";
  if (n >= 1e6) return `${(n / 1e6).toFixed(1)}M`;
  if (n >= 1e3) return `${(n / 1e3).toFixed(1)}K`;
  return String(n);
}

function timeAgo(ms: number, nowMs: number): string {
  if (!ms) return "—";
  const diffSec = Math.floor((nowMs - ms) / 1000);
  if (diffSec < 0) return "future";
  if (diffSec < 60) return `${diffSec}s ago`;
  const diffMin = Math.floor(diffSec / 60);
  if (diffMin < 60) return `${diffMin}m ago`;
  const diffHr = diffMin / 60;
  if (diffHr < 24) return `${diffHr.toFixed(1)}h ago`;
  return `${Math.floor(diffHr / 24)}d ago`;
}

function fmtTimeET(ms: number): string {
  if (!ms) return "—";
  return new Intl.DateTimeFormat("en-US", {
    timeZone: "America/New_York",
    hour: "numeric", minute: "2-digit", hour12: true,
  }).format(new Date(ms));
}

function ageColor(ms: number, nowMs: number): string {
  if (!ms) return "#607d8b";
  const diffMin = (nowMs - ms) / 60000;
  if (diffMin < 15) return "#66bb6a";   // green: fresh < 15m
  if (diffMin < 60) return "#ffd600";   // yellow: < 1h
  if (diffMin < 240) return "#ffa726";  // orange: < 4h
  return "#90a4ae";                     // gray: stale
}
function todayET(): string {
  return new Intl.DateTimeFormat("en-CA", {
    timeZone: "America/New_York", year: "numeric", month: "2-digit", day: "2-digit",
  }).format(new Date());
}

type SortKey = "premium" | "volume" | "ticker" | "dte" | "sweeps" | "first_fired" | "last_updated";
type TierFilter = "all" | "T1_HUGE" | "T2_UNUSUAL_HUGE" | "T3_UNUSUAL";
type DirFilter = "all" | "bullish" | "bearish";

export function FlowHistoryPage() {
  const [data, setData] = useState<ApiResp | null>(null);
  const [date, setDate] = useState<string>(todayET());
  const [tierFilter, setTierFilter] = useState<TierFilter>("all");
  const [dirFilter, setDirFilter] = useState<DirFilter>("all");
  const [tickerFilter, setTickerFilter] = useState<string>("");
  const [sortKey, setSortKey] = useState<SortKey>("premium");
  const [sortDesc, setSortDesc] = useState<boolean>(true);
  const [hideStale, setHideStale] = useState<boolean>(false);
  const [nowMs, setNowMs] = useState<number>(Date.now());
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [availableDates, setAvailableDates] = useState<string[]>([]);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchData = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const params = new URLSearchParams();
      params.set("date", date);
      params.set("limit", "500");
      const res = await fetch(`/api/best-options-history?${params.toString()}`);
      if (res.status === 404) {
        const body = await res.json();
        setData(null);
        const avail = (body.available_dates || []).sort().reverse();
        setAvailableDates(avail);
        const latest = avail[0];
        if (latest && latest !== date) {
          setDate(latest);
          return;
        }
        setError(`No data for ${date}`);
      } else if (res.ok) {
        const body: ApiResp = await res.json();
        setData(body);
      } else {
        setError(`HTTP ${res.status}`);
      }
    } catch (e: unknown) {
      setError(e instanceof Error ? e.message : String(e));
    } finally {
      setLoading(false);
    }
  }, [date]);

  useEffect(() => {
    fetchData();
    const i = setInterval(fetchData, 60000);
    return () => clearInterval(i);
  }, [fetchData]);

  // Tick "ago" labels every 30s without refetching the snapshot
  useEffect(() => {
    const t = setInterval(() => setNowMs(Date.now()), 30000);
    return () => clearInterval(t);
  }, []);

  const filtered = useMemo(() => {
    if (!data) return [];
    let rows = data.contracts;
    if (tierFilter !== "all") rows = rows.filter((c) => c.tier === tierFilter);
    if (dirFilter === "bullish") rows = rows.filter((c) => c.is_bullish);
    if (dirFilter === "bearish") rows = rows.filter((c) => !c.is_bullish);
    if (tickerFilter.trim()) {
      const q = tickerFilter.trim().toUpperCase();
      rows = rows.filter((c) => c.ticker.toUpperCase().includes(q));
    }
    rows = [...rows].sort((a, b) => {
      let cmp = 0;
      switch (sortKey) {
        case "premium": cmp = a.premium - b.premium; break;
        case "volume": cmp = a.volume - b.volume; break;
        case "ticker": cmp = a.ticker.localeCompare(b.ticker); break;
        case "dte": cmp = a.dte - b.dte; break;
        case "sweeps": cmp = a.sweeps - b.sweeps; break;
      }
      return sortDesc ? -cmp : cmp;
    });
    return rows;
  }, [data, tierFilter, dirFilter, tickerFilter, sortKey, sortDesc]);

  const topTickers = useMemo(() => {
    if (!data) return [];
    const agg: Record<string, { ticker: string; total_premium: number; contract_count: number; bull_premium: number; bear_premium: number }> = {};
    for (const c of data.contracts) {
      if (!agg[c.ticker]) agg[c.ticker] = { ticker: c.ticker, total_premium: 0, contract_count: 0, bull_premium: 0, bear_premium: 0 };
      agg[c.ticker].total_premium += c.premium;
      agg[c.ticker].contract_count += 1;
      if (c.is_bullish) agg[c.ticker].bull_premium += c.premium;
      else agg[c.ticker].bear_premium += c.premium;
    }
    return Object.values(agg).sort((a, b) => b.total_premium - a.total_premium).slice(0, 8);
  }, [data]);

  const handleSort = (key: SortKey) => {
    if (key === sortKey) setSortDesc(!sortDesc);
    else { setSortKey(key); setSortDesc(true); }
  };

  const tierCounts = data?.tier_counts || {};
  const totalPremium = data ? data.contracts.reduce((sum, c) => sum + c.premium, 0) : 0;

  return (
    <div style={{ padding: "20px 24px 40px", maxWidth: 1600, margin: "0 auto", fontFamily: "var(--font-mc-mono, monospace)" }}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "flex-end", marginBottom: 20, flexWrap: "wrap", gap: 16 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 600, color: "#e0e0e0", margin: 0 }}>Flow History</h1>
          <p style={{ fontSize: 12, color: "#607d8b", margin: "4px 0 0" }}>
            Daily archive · Deduped per contract (peak premium kept) · Browse historical days · Same data Boba sees
          </p>
        </div>
        <div style={{ display: "flex", gap: 8, alignItems: "center" }}>
          <input type="date" value={date} onChange={(e) => setDate(e.target.value)}
            style={{ background: "#0d1f2a", border: "1px solid #1e3a4a", color: "#e0e0e0", padding: "6px 10px", borderRadius: 4, fontSize: 12, fontFamily: "inherit" }} />
          <button onClick={fetchData} disabled={loading}
            style={{ background: "rgba(79,195,247,0.10)", border: "1px solid rgba(79,195,247,0.4)", color: "#4fc3f7", padding: "6px 14px", borderRadius: 4, fontSize: 12, fontFamily: "inherit", cursor: loading ? "wait" : "pointer" }}>
            {loading ? "..." : "↻"}
          </button>
        </div>
      </div>

      <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(180px, 1fr))", gap: 12, marginBottom: 20 }}>
        <StatTile label="Total Contracts" value={data?.total_contracts?.toString() ?? "—"} sub={data?.last_run_human ? `Last: ${data.last_run_human}` : ""} />
        <StatTile label="Aggregate Premium" value={fmtMoney(totalPremium)} sub={`${data?.contracts.length || 0} unique`} accent="#ffd600" />
        <StatTile label="T1 $1M+" value={(tierCounts.T1_HUGE || 0).toString()} sub="SWEEP+A/AA+Vol>OI" accent="#ffd600" />
        <StatTile label="T2 $500K+" value={(tierCounts.T2_UNUSUAL_HUGE || 0).toString()} sub="SWEEP+A/AA+Vol>OI" accent="#ffa726" />
        <StatTile label="T3 Unusual" value={(tierCounts.T3_UNUSUAL || 0).toString()} sub="Vol>OI only" accent="#4fc3f7" />
        <StatTile label="Highest Premium" value={fmtMoney(data?.highest_premium || 0)} sub={data?.contracts[0] ? `${data.contracts[0].ticker} $${data.contracts[0].strike} ${data.contracts[0].option_type}` : ""} accent="#66bb6a" />
      </div>

      {topTickers.length > 0 && (
        <div style={{ background: "rgba(13,31,42,0.4)", border: "1px solid #1a3a4a", borderRadius: 8, padding: 14, marginBottom: 20 }}>
          <div style={{ fontSize: 11, color: "#607d8b", marginBottom: 10, letterSpacing: "0.5px", fontWeight: 600 }}>TOP TICKERS BY AGGREGATE PREMIUM</div>
          <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(160px, 1fr))", gap: 10 }}>
            {topTickers.map((t) => {
              const bullPct = t.total_premium > 0 ? (t.bull_premium / t.total_premium) * 100 : 0;
              return (
                <div key={t.ticker} onClick={() => setDrawerTicker(t.ticker)} style={{ background: "#0d1f2a", border: "1px solid #1a3a4a", borderRadius: 6, padding: "8px 10px", cursor: "pointer" }}>
                  <div style={{ display: "flex", justifyContent: "space-between", marginBottom: 4 }}>
                    <span style={{ color: "#e0e0e0", fontWeight: 600, fontSize: 13 }}>{t.ticker}</span>
                    <span style={{ color: "#90a4ae", fontSize: 10 }}>{t.contract_count} contracts</span>
                  </div>
                  <div style={{ color: "#ffd600", fontSize: 13, fontWeight: 600, marginBottom: 4 }}>{fmtMoney(t.total_premium)}</div>
                  <div style={{ display: "flex", height: 4, borderRadius: 2, overflow: "hidden", background: "#1a3a4a" }}>
                    <div style={{ width: `${bullPct}%`, background: "#66bb6a" }} />
                    <div style={{ width: `${100 - bullPct}%`, background: "#ef5350" }} />
                  </div>
                  <div style={{ display: "flex", justifyContent: "space-between", marginTop: 2, fontSize: 9 }}>
                    <span style={{ color: "#66bb6a" }}>BULL {bullPct.toFixed(0)}%</span>
                    <span style={{ color: "#ef5350" }}>BEAR {(100 - bullPct).toFixed(0)}%</span>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      )}

      <div style={{ display: "flex", gap: 8, marginBottom: 12, flexWrap: "wrap", alignItems: "center" }}>
        <FilterSelect label="Tier" value={tierFilter} options={[
          { v: "all", l: "All Tiers" }, { v: "T1_HUGE", l: "T1 $1M+" }, { v: "T2_UNUSUAL_HUGE", l: "T2 $500K+" }, { v: "T3_UNUSUAL", l: "T3 Unusual" },
        ]} onChange={(v) => setTierFilter(v as TierFilter)} />
        <FilterSelect label="Direction" value={dirFilter} options={[
          { v: "all", l: "Both" }, { v: "bullish", l: "Bullish" }, { v: "bearish", l: "Bearish" },
        ]} onChange={(v) => setDirFilter(v as DirFilter)} />
        <input type="text" placeholder="Filter ticker..." value={tickerFilter}
          onChange={(e) => setTickerFilter(e.target.value.toUpperCase())}
          style={{ background: "#0d1f2a", border: "1px solid #1e3a4a", color: "#e0e0e0", padding: "5px 10px", borderRadius: 4, fontSize: 12, fontFamily: "inherit", width: 140 }} />
        <label style={{ display: "flex", alignItems: "center", gap: 6, color: "#90a4ae", fontSize: 11, cursor: "pointer", userSelect: "none" }}>
          <input type="checkbox" checked={hideStale} onChange={(e) => setHideStale(e.target.checked)}
            style={{ accentColor: "#4fc3f7", cursor: "pointer" }} />
          Hide stale (&gt;4h)
        </label>
        <span style={{ color: "#607d8b", fontSize: 11, marginLeft: "auto" }}>
          Showing {filtered.length} of {data?.total_contracts ?? 0}
        </span>
      </div>

      {error && (
        <div style={{ background: "rgba(239,83,80,0.08)", border: "1px solid rgba(239,83,80,0.3)", borderRadius: 6, padding: 12, marginBottom: 16, color: "#ef5350", fontSize: 12 }}>
          {error}
          {availableDates.length > 0 && (
            <div style={{ marginTop: 8, color: "#90a4ae" }}>
              Available: {availableDates.slice(-10).map((d) => (
                <button key={d} onClick={() => setDate(d)} style={{ background: "transparent", border: "1px solid #1a3a4a", color: "#4fc3f7", padding: "2px 6px", margin: "0 4px 4px 0", borderRadius: 3, fontSize: 10, cursor: "pointer", fontFamily: "inherit" }}>{d}</button>
              ))}
            </div>
          )}
        </div>
      )}

      <div style={{ background: "#0d1f2a", border: "1px solid #1a3a4a", borderRadius: 8, overflow: "hidden" }}>
        <div style={{ overflowX: "auto", maxHeight: "calc(100vh - 380px)", overflowY: "auto" }}>
          <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 12, tableLayout: "auto" }}>
            <thead style={{ position: "sticky", top: 0, zIndex: 10 }}>
              <tr style={{ background: "#13293b", color: "#b0bec5", fontSize: 10, letterSpacing: "0.5px", boxShadow: "0 1px 0 #1a3a4a" }}>
                <Th label="TIER" />
                <Th label="DIR" />
                <Th label="TICKER" sortable onClick={() => handleSort("ticker")} active={sortKey === "ticker"} desc={sortDesc} />
                <Th label="STRIKE" align="right" />
                <Th label="TYPE" />
                <Th label="EXPIRY" />
                <Th label="DTE" sortable onClick={() => handleSort("dte")} active={sortKey === "dte"} desc={sortDesc} align="right" />
                <Th label="PREMIUM" sortable onClick={() => handleSort("premium")} active={sortKey === "premium"} desc={sortDesc} align="right" />
                <Th label="VOL" sortable onClick={() => handleSort("volume")} active={sortKey === "volume"} desc={sortDesc} align="right" />
                <Th label="OI" align="right" />
                <Th label="SW" sortable onClick={() => handleSort("sweeps")} active={sortKey === "sweeps"} desc={sortDesc} align="right" />
                <Th label="BL" align="right" />
                <Th label="ALERT" align="right" />
                <Th label="FIRST FIRED" sortable onClick={() => handleSort("first_fired")} active={sortKey === "first_fired"} desc={sortDesc} align="right" />
                <Th label="LAST UPDATE" sortable onClick={() => handleSort("last_updated")} active={sortKey === "last_updated"} desc={sortDesc} align="right" />
              </tr>
            </thead>
            <tbody>
              {filtered.map((c) => {
                const tier = TIER_COLORS[c.tier] || TIER_COLORS.NORMAL;
                return (
                  <tr key={c.option_symbol} style={{
                    borderTop: "1px solid #1a3a4a",
                    opacity: (() => {
                      const ms = c.last_updated_ms || c.first_seen_ms || 0;
                      if (!ms) return 0.6;
                      const diffMin = (nowMs - ms) / 60000;
                      if (diffMin > 240) return 0.55;  // >4h: dimmed
                      if (diffMin > 60) return 0.85;   // >1h: slight dim
                      return 1;
                    })(),
                  }}>
                    <td style={{ padding: "8px 10px" }}>
                      <span style={{ display: "inline-block", padding: "2px 6px", background: tier.bg, border: `1px solid ${tier.border}`, color: tier.text, borderRadius: 3, fontSize: 9, fontWeight: 700, letterSpacing: "0.3px" }}>{tier.label}</span>
                    </td>
                    <td style={{ padding: "8px 10px" }}>
                      <span style={{ color: c.is_bullish ? "#66bb6a" : "#ef5350", fontWeight: 700, fontSize: 10 }}>{c.is_bullish ? "BULL" : "BEAR"}</span>
                    </td>
                    <td onClick={() => setDrawerTicker(c.ticker)} style={{ padding: "7px 10px", color: "#e0e0e0", fontWeight: 700, fontSize: 13, cursor: "pointer" }}>{c.ticker}</td>
                    <td style={{ padding: "7px 10px", color: "#cfd8dc", textAlign: "right", fontWeight: 500 }}>${c.strike}</td>
                    <td style={{ padding: "7px 10px", color: c.option_type === "CALL" ? "#66bb6a" : "#ef5350", fontWeight: 600 }}>{c.option_type}</td>
                    <td style={{ padding: "7px 10px", color: "#90a4ae" }}>{c.expiry}</td>
                    <td style={{ padding: "7px 10px", color: "#90a4ae", textAlign: "right" }}>{c.dte}d</td>
                    <td style={{ padding: "7px 10px", color: "#ffd600", fontWeight: 600, textAlign: "right" }}>{fmtMoney(c.premium)}</td>
                    <td style={{ padding: "7px 10px", color: "#b0bec5", textAlign: "right", fontWeight: 500 }}>{fmtNum(c.volume)}</td>
                    <td style={{ padding: "7px 10px", color: "#90a4ae", textAlign: "right" }}>{fmtNum(c.oi)}</td>
                    <td style={{ padding: "7px 10px", color: c.sweeps > 0 ? "#4fc3f7" : "#607d8b", textAlign: "right" }}>{c.sweeps}</td>
                    <td style={{ padding: "7px 10px", color: c.blocks > 0 ? "#ab47bc" : "#607d8b", textAlign: "right" }}>{c.blocks}</td>
                    <td style={{ padding: "7px 10px", color: "#90a4ae", textAlign: "right" }}>${c.alert_price?.toFixed(2) ?? "—"}</td>
                    <td style={{ padding: "7px 10px", textAlign: "right", whiteSpace: "nowrap" }}>
                      <div style={{ color: ageColor(c.first_seen_ms || 0, nowMs), fontWeight: 600 }}>
                        {timeAgo(c.first_seen_ms || 0, nowMs)}
                      </div>
                      <div style={{ color: "#607d8b", fontSize: 10 }}>{fmtTimeET(c.first_seen_ms || 0)}</div>
                    </td>
                    <td style={{ padding: "7px 10px", textAlign: "right", whiteSpace: "nowrap" }}>
                      <div style={{ color: ageColor(c.last_updated_ms || 0, nowMs), fontWeight: 600 }}>
                        {timeAgo(c.last_updated_ms || 0, nowMs)}
                      </div>
                      <div style={{ color: "#607d8b", fontSize: 10 }}>{fmtTimeET(c.last_updated_ms || 0)}</div>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
          {filtered.length === 0 && !loading && !error && (
            <div style={{ padding: 32, textAlign: "center", color: "#607d8b", fontSize: 12 }}>No contracts match your filters</div>
          )}
        </div>
      </div>
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}

function StatTile({ label, value, sub, accent }: { label: string; value: string; sub?: string; accent?: string }) {
  return (
    <div style={{ background: "#0d1f2a", border: "1px solid #1a3a4a", borderRadius: 6, padding: "12px 14px" }}>
      <div style={{ fontSize: 10, color: "#607d8b", letterSpacing: "0.5px", fontWeight: 600, marginBottom: 4 }}>{label}</div>
      <div style={{ fontSize: 20, color: accent || "#e0e0e0", fontWeight: 600, marginBottom: 2 }}>{value}</div>
      {sub && <div style={{ fontSize: 10, color: "#607d8b" }}>{sub}</div>}
    </div>
  );
}

function FilterSelect({ label, value, options, onChange }: { label: string; value: string; options: { v: string; l: string }[]; onChange: (v: string) => void }) {
  return (
    <div style={{ display: "flex", alignItems: "center", gap: 6 }}>
      <span style={{ color: "#607d8b", fontSize: 11 }}>{label}:</span>
      <select value={value} onChange={(e) => onChange(e.target.value)}
        style={{ background: "#0d1f2a", border: "1px solid #1e3a4a", color: "#e0e0e0", padding: "5px 10px", borderRadius: 4, fontSize: 11, fontFamily: "inherit", cursor: "pointer" }}>
        {options.map((o) => <option key={o.v} value={o.v}>{o.l}</option>)}
      </select>
    </div>
  );
}

function Th({ label, align, sortable, onClick, active, desc }: { label: string; align?: "right"; sortable?: boolean; onClick?: () => void; active?: boolean; desc?: boolean }) {
  return (
    <th onClick={onClick}
      style={{
        padding: "11px 10px",
        textAlign: align || "left",
        fontWeight: 700,
        cursor: sortable ? "pointer" : "default",
        color: active ? "#4fc3f7" : "#b0bec5",
        userSelect: "none",
        whiteSpace: "nowrap",
        background: "#13293b",
        borderBottom: "1px solid #1a3a4a",
        position: "sticky",
        top: 0,
      }}>
      {label}{sortable && active ? (desc ? " ↓" : " ↑") : ""}
    </th>
  );
}
