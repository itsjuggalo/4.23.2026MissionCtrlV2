"use client";

import { useState, useEffect, useCallback } from "react";

interface LLMTrade {
  date: string;
  side: string;
  symbol: string;
  company: string;
  price: number;
  quantity: number;
  value: number;
}

interface ModelData {
  name: string;
  model: string;
  color: string;
  total_trades: number;
  holdings_count: number;
  buy_volume: number;
  sell_volume: number;
  current_holdings: Record<string, number>;
  recent_trades: LLMTrade[];
}

interface LeaderboardEntry {
  name: string;
  model: string;
  color: string;
  total_trades: number;
  holdings_count: number;
  buy_volume: number;
  sell_volume: number;
}

interface PortfolioData {
  last_updated: string;
  leaderboard: LeaderboardEntry[];
  models: Record<string, ModelData>;
}

// Known portfolio values from AInvest (updated by scraper)
const KNOWN_VALUES: Record<string, { value: number; return_pct: number }> = {
  AIME:     { value: 21767, return_pct: 117.67 },
  DEEPSEEK: { value: 15538, return_pct: 55.38 },
  QWEN:     { value: 11707, return_pct: 17.08 },
  CLAUDE:   { value: 10852, return_pct: 8.53 },
  GEMINI:   { value: 10417, return_pct: 4.17 },
  GPT:      { value: 9543, return_pct: -4.56 },
};

const MEDAL = ["", "", ""];

export function LLMPortfolioPage() {
  const [data, setData] = useState<PortfolioData | null>(null);
  const [selectedModel, setSelectedModel] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  const fetchData = useCallback(async () => {
    try {
      const res = await fetch("/api/llm-portfolio");
      if (res.ok) setData(await res.json());
    } catch (e) { console.error(e); }
    finally { setLoading(false); }
  }, []);

  useEffect(() => { fetchData(); const i = setInterval(fetchData, 120000); return () => clearInterval(i); }, [fetchData]);

  const models = data?.models || {};
  const modelKeys = ["AIME", "DEEPSEEK", "QWEN", "CLAUDE", "GEMINI", "GPT"];
  const active = selectedModel && models[selectedModel] ? models[selectedModel] : null;

  return (
    <div style={{ padding: "24px 32px", maxWidth: 1400, margin: "0 auto" }}>
      <div style={{ marginBottom: 24 }}>
        <h1 style={{ fontSize: 22, fontWeight: 600, color: "#e0e0e0", margin: 0, fontFamily: "var(--font-mc-mono, monospace)" }}>LLM Portfolios</h1>
        <p style={{ fontSize: 13, color: "#607d8b", margin: "4px 0 0", fontFamily: "var(--font-mc-mono, monospace)" }}>
          AI model trading competition · Updated {data?.last_updated ? new Date(data.last_updated).toLocaleString() : "Never"}
        </p>
      </div>

      {/* Leaderboard Cards */}
      <div style={{ display: "grid", gridTemplateColumns: "repeat(3, 1fr)", gap: 12, marginBottom: 28 }}>
        {modelKeys.map((key, i) => {
          const m = models[key];
          const kv = KNOWN_VALUES[key] || { value: 10000, return_pct: 0 };
          const isSelected = selectedModel === key;
          return (
            <div key={key} onClick={() => setSelectedModel(isSelected ? null : key)} style={{
              background: isSelected ? "rgba(79,195,247,0.08)" : "#0a1929",
              border: `1px solid ${isSelected ? (m?.color || "#4fc3f7") : "#1a3a4a"}`,
              borderRadius: 8, padding: 18, cursor: "pointer", transition: "border 0.2s"
            }}>
              <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 12 }}>
                <div style={{ display: "flex", alignItems: "center", gap: 8 }}>
                  <span style={{ fontSize: 16 }}>{i < 3 ? MEDAL[i] : `${i + 1}`}</span>
                  <span style={{ fontSize: 15, fontWeight: 700, color: m?.color || "#e0e0e0", fontFamily: "var(--font-mc-mono, monospace)" }}>{key}</span>
                </div>
                {i === 0 && <span style={{ fontSize: 10, padding: "2px 8px", borderRadius: 4, background: "rgba(255,152,0,0.15)", color: "#ff9800", fontFamily: "var(--font-mc-mono, monospace)" }}>LEADER</span>}
                {i === modelKeys.length - 1 && <span style={{ fontSize: 10, padding: "2px 8px", borderRadius: 4, background: "rgba(239,83,80,0.15)", color: "#ef5350", fontFamily: "var(--font-mc-mono, monospace)" }}>LAST</span>}
              </div>
              <div style={{ fontSize: 11, color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)", marginBottom: 8 }}>{m?.model || key}</div>
              <div style={{ display: "flex", justifyContent: "space-between", alignItems: "baseline" }}>
                <span style={{ fontSize: 22, fontWeight: 700, color: "#e0e0e0", fontFamily: "var(--font-mc-mono, monospace)" }}>
                  ${kv.value.toLocaleString()}
                </span>
                <span style={{
                  fontSize: 14, fontWeight: 600, fontFamily: "var(--font-mc-mono, monospace)",
                  color: kv.return_pct >= 0 ? "#66bb6a" : "#ef5350"
                }}>
                  {kv.return_pct >= 0 ? "+" : ""}{kv.return_pct.toFixed(2)}%
                </span>
              </div>
              <div style={{ display: "flex", gap: 16, marginTop: 10, fontSize: 11, fontFamily: "var(--font-mc-mono, monospace)" }}>
                <span style={{ color: "#607d8b" }}>{m?.total_trades || 0} trades</span>
                <span style={{ color: "#607d8b" }}>{m?.holdings_count || 0} holdings</span>
              </div>
            </div>
          );
        })}
      </div>

      {/* Selected Model Detail */}
      {active && (
        <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: 16, marginBottom: 28 }}>
          {/* Current Holdings */}
          <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
            <h2 style={{ fontSize: 13, fontWeight: 600, color: active.color || "#4fc3f7", margin: "0 0 16px", fontFamily: "var(--font-mc-mono, monospace)" }}>
              {selectedModel} HOLDINGS ({active.holdings_count})
            </h2>
            <div style={{ maxHeight: 300, overflowY: "auto" }}>
              {Object.entries(active.current_holdings || {}).sort((a, b) => b[1] - a[1]).map(([sym, qty]) => (
                <div key={sym} style={{
                  display: "flex", justifyContent: "space-between", padding: "8px 0",
                  borderBottom: "1px solid rgba(26,58,74,0.3)", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)"
                }}>
                  <span style={{ color: "#e0e0e0", fontWeight: 600 }}>{sym}</span>
                  <span style={{ color: "#607d8b" }}>{qty} shares</span>
                </div>
              ))}
              {Object.keys(active.current_holdings || {}).length === 0 && (
                <div style={{ color: "#455a64", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)" }}>No current holdings</div>
              )}
            </div>
          </div>

          {/* Recent Trades */}
          <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
            <h2 style={{ fontSize: 13, fontWeight: 600, color: active.color || "#4fc3f7", margin: "0 0 16px", fontFamily: "var(--font-mc-mono, monospace)" }}>
              {selectedModel} RECENT TRADES
            </h2>
            <div style={{ maxHeight: 300, overflowY: "auto" }}>
              {(active.recent_trades || []).map((t, i) => (
                <div key={i} style={{
                  display: "flex", justifyContent: "space-between", alignItems: "center", padding: "8px 0",
                  borderBottom: "1px solid rgba(26,58,74,0.3)", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)"
                }}>
                  <div>
                    <span style={{
                      padding: "1px 6px", borderRadius: 3, fontSize: 10, fontWeight: 600, marginRight: 8,
                      background: t.side === "buy" ? "rgba(102,187,106,0.15)" : "rgba(239,83,80,0.15)",
                      color: t.side === "buy" ? "#66bb6a" : "#ef5350", textTransform: "uppercase"
                    }}>{t.side}</span>
                    <span style={{ color: "#e0e0e0", fontWeight: 600 }}>{t.symbol}</span>
                  </div>
                  <div style={{ textAlign: "right" }}>
                    <div style={{ color: "#e0e0e0" }}>${t.price.toFixed(2)} x {t.quantity}</div>
                    <div style={{ color: "#455a64", fontSize: 10 }}>{t.date}</div>
                  </div>
                </div>
              ))}
              {(!active.recent_trades || active.recent_trades.length === 0) && (
                <div style={{ color: "#455a64", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)" }}>No recent trades</div>
              )}
            </div>
          </div>
        </div>
      )}

      {/* All Models Quick View */}
      {!selectedModel && (
        <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
          <h2 style={{ fontSize: 13, fontWeight: 600, color: "#4fc3f7", margin: "0 0 16px", fontFamily: "var(--font-mc-mono, monospace)" }}>LATEST TRADES ACROSS ALL MODELS</h2>
          {loading ? (
            <div style={{ padding: 40, textAlign: "center", color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>Loading...</div>
          ) : (
            <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)" }}>
              <thead>
                <tr style={{ borderBottom: "1px solid #1a3a4a" }}>
                  {["Model", "Side", "Symbol", "Price", "Qty", "Value", "Date"].map(h => (
                    <th key={h} style={{ textAlign: "left", padding: "8px 12px", color: "#607d8b", fontWeight: 500, fontSize: 11 }}>{h}</th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {modelKeys.flatMap(key => {
                  const m = models[key];
                  if (!m?.recent_trades) return [];
                  return m.recent_trades.slice(0, 3).map((t, i) => ({...t, modelKey: key, modelColor: m.color}));
                }).sort((a, b) => b.date.localeCompare(a.date)).slice(0, 20).map((t, i) => (
                  <tr key={i} style={{ borderBottom: "1px solid rgba(26,58,74,0.3)" }}>
                    <td style={{ padding: "8px 12px", color: t.modelColor, fontWeight: 600 }}>{t.modelKey}</td>
                    <td style={{ padding: "8px 12px" }}>
                      <span style={{ padding: "1px 6px", borderRadius: 3, fontSize: 10, fontWeight: 600,
                        background: t.side === "buy" ? "rgba(102,187,106,0.15)" : "rgba(239,83,80,0.15)",
                        color: t.side === "buy" ? "#66bb6a" : "#ef5350", textTransform: "uppercase" }}>{t.side}</span>
                    </td>
                    <td style={{ padding: "8px 12px", color: "#e0e0e0", fontWeight: 600 }}>{t.symbol}</td>
                    <td style={{ padding: "8px 12px", color: "#e0e0e0" }}>${t.price.toFixed(2)}</td>
                    <td style={{ padding: "8px 12px", color: "#607d8b" }}>{t.quantity}</td>
                    <td style={{ padding: "8px 12px", color: "#ff9800" }}>${t.value.toFixed(2)}</td>
                    <td style={{ padding: "8px 12px", color: "#455a64" }}>{t.date}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
          {!loading && Object.keys(models).length === 0 && (
            <div style={{ padding: 40, textAlign: "center", color: "#455a64", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)" }}>
              No data yet. Run: python3 ~/mission-control-restored/bots/llm_portfolio_scraper.py
            </div>
          )}
        </div>
      )}
    </div>
  );
}
