"use client";

import { useState, useEffect, useCallback } from "react";
import { StockDetailDrawer } from "@/components/drawers/StockDetailDrawer";

interface Trade {
  id: string;
  ticker: string;
  name: string;
  party: string;
  state: string;
  trade_type: string;
  size: string;
  trade_date: string;
  filing_date: string;
  reporting_gap: string;
  suspicious: string | null;
}

interface Politician {
  name: string;
  party: string;
  state: string;
  trades: number;
  buys: number;
  sells: number;
  tickers: string[];
}

interface CongressData {
  last_updated: string;
  total_trades: number;
  politicians: Politician[];
  suspicious: Trade[];
  trades: Trade[];
}

const PARTY_COLORS: Record<string, string> = {
  Democrat: "#4fc3f7",
  Republican: "#ef5350",
  Independent: "#ff9800",
};

export function CongressPage() {
  const [data, setData] = useState<CongressData | null>(null);
  const [filter, setFilter] = useState<"all" | "buy" | "sell">("all");
  const [partyFilter, setPartyFilter] = useState<string>("all");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [drawerTicker, setDrawerTicker] = useState<string | null>(null);

  const fetchData = useCallback(async () => {
    try {
      const params = new URLSearchParams();
      if (filter !== "all") params.set("type", filter);
      if (partyFilter !== "all") params.set("party", partyFilter);
      const res = await fetch(`/api/congress?${params}`);
      if (res.ok) { setData(await res.json()); setError(false); }
    } catch (e) { console.error(e); setError(true); }
    finally { setLoading(false); }
  }, [filter, partyFilter]);

  useEffect(() => { setLoading(true); fetchData(); const i = setInterval(fetchData, 120000); return () => clearInterval(i); }, [fetchData]);

  return (
    <div style={{ padding: "24px 32px", maxWidth: 1400, margin: "0 auto" }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 24 }}>
        <div>
          <h1 style={{ fontSize: 22, fontWeight: 600, color: "#e0e0e0", margin: 0, fontFamily: "var(--font-mc-mono, monospace)" }}>Congress Trading</h1>
          <p style={{ fontSize: 13, color: "#607d8b", margin: "4px 0 0", fontFamily: "var(--font-mc-mono, monospace)" }}>
            Track politician stock trades · {data?.total_trades || 0} trades · Updated {data?.last_updated ? new Date(data.last_updated).toLocaleString() : "Never"}
          </p>
        </div>
      </div>

      {/* Suspicious Trades Alert */}
      {data?.suspicious && data.suspicious.length > 0 && (
        <div style={{ background: "rgba(239,83,80,0.08)", border: "1px solid rgba(239,83,80,0.3)", borderRadius: 8, padding: 16, marginBottom: 24 }}>
          <h2 style={{ fontSize: 14, fontWeight: 600, color: "#ef5350", margin: "0 0 12px", fontFamily: "var(--font-mc-mono, monospace)" }}>
            SUSPICIOUS TRADES ({data.suspicious.length})
          </h2>
          <div style={{ display: "flex", gap: 12, overflowX: "auto", paddingBottom: 8 }}>
            {data.suspicious.slice(0, 6).map((t, i) => (
              <div key={i} onClick={() => setDrawerTicker(t.ticker)} style={{ minWidth: 220, background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 14, flexShrink: 0, cursor: "pointer" }}>
                <div style={{ display: "flex", justifyContent: "space-between", marginBottom: 8 }}>
                  <span style={{ fontSize: 14, fontWeight: 700, color: "#e0e0e0", fontFamily: "var(--font-mc-mono, monospace)" }}>{t.ticker}</span>
                  <span style={{ fontSize: 10, padding: "2px 8px", borderRadius: 4, background: t.trade_type === "buy" ? "rgba(102,187,106,0.15)" : "rgba(239,83,80,0.15)", color: t.trade_type === "buy" ? "#66bb6a" : "#ef5350", fontFamily: "var(--font-mc-mono, monospace)", fontWeight: 600, textTransform: "uppercase" }}>{t.trade_type}</span>
                </div>
                <div style={{ fontSize: 12, color: PARTY_COLORS[t.party] || "#e0e0e0", fontFamily: "var(--font-mc-mono, monospace)", marginBottom: 4 }}>{t.name}</div>
                <div style={{ fontSize: 11, color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>{t.size} · {t.filing_date}</div>
                <div style={{ fontSize: 10, color: "#ff9800", fontFamily: "var(--font-mc-mono, monospace)", marginTop: 6 }}>{t.suspicious}</div>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* Top Politicians */}
      {data?.politicians && data.politicians.length > 0 && (
        <div style={{ marginBottom: 24 }}>
          <h2 style={{ fontSize: 13, fontWeight: 600, color: "#4fc3f7", margin: "0 0 12px", fontFamily: "var(--font-mc-mono, monospace)", letterSpacing: "0.5px" }}>TOP POLITICIANS</h2>
          <div style={{ display: "flex", gap: 12, overflowX: "auto", paddingBottom: 8 }}>
            {data.politicians.slice(0, 8).map((p, i) => (
              <div key={i} style={{ minWidth: 180, background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 14, flexShrink: 0 }}>
                <div style={{ fontSize: 13, fontWeight: 600, color: "#e0e0e0", fontFamily: "var(--font-mc-mono, monospace)", marginBottom: 4 }}>{p.name}</div>
                <div style={{ fontSize: 11, color: PARTY_COLORS[p.party] || "#607d8b", fontFamily: "var(--font-mc-mono, monospace)", marginBottom: 8 }}>{p.party} · {p.state}</div>
                <div style={{ display: "flex", gap: 12, fontSize: 11, fontFamily: "var(--font-mc-mono, monospace)" }}>
                  <span style={{ color: "#66bb6a" }}>{p.buys} buys</span>
                  <span style={{ color: "#ef5350" }}>{p.sells} sells</span>
                </div>
                <div style={{ fontSize: 10, color: "#455a64", fontFamily: "var(--font-mc-mono, monospace)", marginTop: 6 }}>{p.tickers.slice(0, 5).join(", ")}{p.tickers.length > 5 ? ` +${p.tickers.length - 5}` : ""}</div>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* Filters */}
      <div style={{ display: "flex", gap: 8, marginBottom: 16 }}>
        {(["all", "buy", "sell"] as const).map(f => (
          <button key={f} onClick={() => setFilter(f)} style={{
            padding: "6px 16px", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)",
            border: `1px solid ${filter === f ? "#4fc3f7" : "#1a3a4a"}`, borderRadius: 6,
            background: filter === f ? "rgba(79,195,247,0.15)" : "#0a1929",
            color: filter === f ? "#4fc3f7" : "#607d8b", cursor: "pointer", textTransform: "capitalize"
          }}>{f}</button>
        ))}
        <div style={{ flex: 1 }} />
        {["all", "Democrat", "Republican"].map(p => (
          <button key={p} onClick={() => setPartyFilter(p)} style={{
            padding: "6px 16px", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)",
            border: `1px solid ${partyFilter === p ? (PARTY_COLORS[p] || "#4fc3f7") : "#1a3a4a"}`, borderRadius: 6,
            background: partyFilter === p ? `${PARTY_COLORS[p] || "#4fc3f7"}22` : "#0a1929",
            color: partyFilter === p ? (PARTY_COLORS[p] || "#4fc3f7") : "#607d8b", cursor: "pointer"
          }}>{p === "all" ? "All Parties" : p}</button>
        ))}
      </div>

      {/* Trade Table */}
      <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, overflow: "hidden" }}>
        {loading ? (
          <div style={{ padding: 60, textAlign: "center", color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>Loading congress trades...</div>
        ) : !data?.trades?.length ? (
          <div style={{ padding: 60, textAlign: "center", color: "#455a64", fontFamily: "var(--font-mc-mono, monospace)", fontSize: 13 }}>
            No trades found. Run: python3 ~/mission-control-restored/bots/congress_scraper.py
          </div>
        ) : (
          <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)" }}>
            <thead>
              <tr style={{ borderBottom: "1px solid #1a3a4a" }}>
                {["Ticker", "Politician", "Party", "Type", "Size", "Trade Date", "Filed", "Gap", "Flag"].map(h => (
                  <th key={h} style={{ textAlign: "left", padding: "10px 12px", color: "#607d8b", fontWeight: 500, fontSize: 11 }}>{h}</th>
                ))}
              </tr>
            </thead>
            <tbody>
              {data.trades.slice(0, 100).map((t, i) => (
                <tr key={i} style={{ borderBottom: "1px solid rgba(26,58,74,0.3)" }}
                  onMouseEnter={e => { e.currentTarget.style.background = "rgba(79,195,247,0.03)"; }}
                  onMouseLeave={e => { e.currentTarget.style.background = "transparent"; }}>
                  <td onClick={() => setDrawerTicker(t.ticker)} style={{ padding: "10px 12px", fontWeight: 700, color: "#e0e0e0", cursor: "pointer" }}>{t.ticker}</td>
                  <td style={{ padding: "10px 12px", color: "#e0e0e0" }}>{t.name}</td>
                  <td style={{ padding: "10px 12px", color: PARTY_COLORS[t.party] || "#607d8b" }}>{t.party?.charAt(0)}</td>
                  <td style={{ padding: "10px 12px" }}>
                    <span style={{ padding: "2px 8px", borderRadius: 4, fontSize: 10, fontWeight: 600, textTransform: "uppercase",
                      background: t.trade_type === "buy" ? "rgba(102,187,106,0.15)" : "rgba(239,83,80,0.15)",
                      color: t.trade_type === "buy" ? "#66bb6a" : "#ef5350" }}>{t.trade_type}</span>
                  </td>
                  <td style={{ padding: "10px 12px", color: "#ff9800" }}>{t.size}</td>
                  <td style={{ padding: "10px 12px", color: "#607d8b" }}>{t.trade_date}</td>
                  <td style={{ padding: "10px 12px", color: "#607d8b" }}>{t.filing_date}</td>
                  <td style={{ padding: "10px 12px", color: "#455a64" }}>{t.reporting_gap}</td>
                  <td style={{ padding: "10px 12px" }}>
                    {t.suspicious && <span style={{ fontSize: 10, padding: "2px 6px", borderRadius: 4, background: "rgba(255,152,0,0.15)", color: "#ff9800" }}>{t.suspicious}</span>}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
      <StockDetailDrawer ticker={drawerTicker} onClose={() => setDrawerTicker(null)} />
    </div>
  );
}
