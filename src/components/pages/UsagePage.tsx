"use client";

import { useState, useEffect, useCallback } from "react";
import {
  BarChart,
  Bar,
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
  Cell,
} from "recharts";

interface BalanceInfo {
  budget: number;
  spent: number;
  remaining: number;
  pct_used: number;
}

interface UsageData {
  balances: Record<string, BalanceInfo>;
  spendBySource: { source: string; cost: number }[];
  hourlyData: Record<string, unknown>[];
  dailyData: Record<string, unknown>[];
  recent: {
    timestamp: string;
    source: string;
    provider: string;
    model: string;
    input_tokens: number;
    output_tokens: number;
    cost_usd: number;
  }[];
  totalEntries: number;
}

const PROVIDER_CONFIG: Record<string, { label: string; color: string; icon: string }> = {
  anthropic: { label: "Anthropic", color: "#4fc3f7", icon: "◆" },
  openai: { label: "OpenAI", color: "#66bb6a", icon: "◈" },
  deepseek: { label: "DeepSeek", color: "#ce93d8", icon: "◇" },
  xai: { label: "Grok / xAI", color: "#ff9800", icon: "◉" },
};

const SOURCE_COLORS = ["#4fc3f7", "#ff9800", "#66bb6a", "#ce93d8", "#ef5350", "#81d4fa", "#ffcc80"];

export default function UsagePage() {
  const [data, setData] = useState<UsageData | null>(null);
  const [_costData, setCostData] = useState<Record<string, unknown> | null>(null);
  const [_dbStats, setDbStats] = useState<Record<string, unknown> | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [lastUpdate, setLastUpdate] = useState<string>("");
  const [view, setView] = useState<"24h" | "7d">("24h");

  const fetchData = useCallback(async () => {
    try {
      const res = await fetch("/api/usage");
      if (!res.ok) throw new Error("Failed to fetch");
      const json = await res.json();
      setData(json);
      setError(null);
      setLastUpdate(new Date().toLocaleTimeString());
    } catch (e) {
      setError("Failed to load usage data");
      console.error(e);
    }
  }, []);

  useEffect(() => {
    fetchData();
    const interval = setInterval(fetchData, 60000);
    return () => clearInterval(interval);
  }, [fetchData]);

  useEffect(() => {
    async function fetchExtras() {
      try {
        const [costRes, dbRes] = await Promise.all([
          fetch('/api/cost-tracking').then(r => r.ok ? r.json() : null).catch(() => null),
          fetch('/api/db-status').then(r => r.ok ? r.json() : null).catch(() => null),
        ]);
        if (costRes) setCostData(costRes);
        if (dbRes) setDbStats(dbRes);
      } catch {}
    }
    fetchExtras();
    const i = setInterval(fetchExtras, 60000);
    return () => clearInterval(i);
  }, []);

  return (
    <div style={{ padding: "24px 32px", maxWidth: 1400, margin: "0 auto" }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ {error}</div>}

      {/* Header */}
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 24 }}>
        <div>
          <h1
            style={{
              fontSize: 22,
              fontWeight: 600,
              color: "#e0e0e0",
              margin: 0,
              fontFamily: "var(--font-mc-mono, monospace)",
              letterSpacing: "0.5px",
            }}
          >
            API Usage
          </h1>
          <p style={{ fontSize: 13, color: "#607d8b", margin: "4px 0 0", fontFamily: "var(--font-mc-mono, monospace)" }}>
            Token spend tracker · Updated {lastUpdate}
          </p>
        </div>
        <div
          style={{
            display: "flex",
            alignItems: "center",
            gap: 8,
            fontSize: 12,
            color: "#4fc3f7",
            fontFamily: "var(--font-mc-mono, monospace)",
          }}
        >
          <span style={{ width: 8, height: 8, borderRadius: "50%", background: "#66bb6a", display: "inline-block" }} />
          AUTO-REFRESH 60s
        </div>
      </div>

      {/* Provider Balance Cards */}
      <div style={{ display: "grid", gridTemplateColumns: "repeat(4, 1fr)", gap: 16, marginBottom: 28 }}>
        {Object.entries(PROVIDER_CONFIG).map(([key, cfg]) => {
          const info = data?.balances?.[key] || { budget: 0, spent: 0, remaining: 0, pct_used: 0 };
          return (
            <div
              key={key}
              style={{
                background: "#0a1929",
                border: "1px solid #1a3a4a",
                borderRadius: 8,
                padding: "18px 20px",
              }}
            >
              <div style={{ display: "flex", alignItems: "center", gap: 8, marginBottom: 14 }}>
                <span style={{ fontSize: 16, color: cfg.color }}>{cfg.icon}</span>
                <span
                  style={{
                    fontSize: 13,
                    fontWeight: 600,
                    color: cfg.color,
                    fontFamily: "var(--font-mc-mono, monospace)",
                    letterSpacing: "0.5px",
                  }}
                >
                  {cfg.label.toUpperCase()}
                </span>
              </div>

              <div style={{ display: "flex", justifyContent: "space-between", marginBottom: 12 }}>
                <div>
                  <div style={{ fontSize: 11, color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>
                    SPENT
                  </div>
                  <div
                    style={{
                      fontSize: 20,
                      fontWeight: 600,
                      color: "#ef5350",
                      fontFamily: "var(--font-mc-mono, monospace)",
                    }}
                  >
                    ${info.spent.toFixed(2)}
                  </div>
                </div>
                <div style={{ textAlign: "right" }}>
                  <div style={{ fontSize: 11, color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>
                    REMAINING
                  </div>
                  <div
                    style={{
                      fontSize: 20,
                      fontWeight: 600,
                      color: "#66bb6a",
                      fontFamily: "var(--font-mc-mono, monospace)",
                    }}
                  >
                    ${info.remaining.toFixed(2)}
                  </div>
                </div>
              </div>

              {/* Progress bar */}
              <div style={{ background: "#0d1117", borderRadius: 4, height: 6, overflow: "hidden" }}>
                <div
                  style={{
                    width: `${Math.min(info.pct_used, 100)}%`,
                    height: "100%",
                    borderRadius: 4,
                    background:
                      info.pct_used > 80 ? "#ef5350" : info.pct_used > 50 ? "#ff9800" : cfg.color,
                    transition: "width 0.5s ease",
                  }}
                />
              </div>
              <div
                style={{
                  fontSize: 10,
                  color: "#455a64",
                  marginTop: 4,
                  textAlign: "right",
                  fontFamily: "var(--font-mc-mono, monospace)",
                }}
              >
                {info.pct_used.toFixed(1)}% of ${info.budget}
              </div>
            </div>
          );
        })}
      </div>

      {/* Charts Row */}
      <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: 16, marginBottom: 28 }}>
        {/* Spend by Source */}
        <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
          <h2
            style={{
              fontSize: 13,
              fontWeight: 600,
              color: "#4fc3f7",
              margin: "0 0 16px",
              fontFamily: "var(--font-mc-mono, monospace)",
              letterSpacing: "0.5px",
            }}
          >
            SPEND BY SOURCE
          </h2>
          {data?.spendBySource && data.spendBySource.length > 0 ? (
            <ResponsiveContainer width="100%" height={220}>
              <BarChart data={data.spendBySource} layout="vertical" margin={{ left: 20, right: 20 }}>
                <CartesianGrid strokeDasharray="3 3" stroke="#1a3a4a" horizontal={false} />
                <XAxis type="number" tick={{ fill: "#607d8b", fontSize: 11 }} tickFormatter={(v: number) => `$${v.toFixed(2)}`} />
                <YAxis
                  type="category"
                  dataKey="source"
                  tick={{ fill: "#e0e0e0", fontSize: 11, fontFamily: "monospace" }}
                  width={90}
                />
                <Tooltip
                  contentStyle={{ background: "#0d1117", border: "1px solid #1a3a4a", borderRadius: 6, fontSize: 12 }}
                  labelStyle={{ color: "#e0e0e0" }}
                  formatter={(v) => [`$${Number(v).toFixed(4)}`, "Cost"]}
                />
                <Bar dataKey="cost" radius={[0, 4, 4, 0]}>
                  {data.spendBySource.map((_, i) => (
                    <Cell key={i} fill={SOURCE_COLORS[i % SOURCE_COLORS.length]} />
                  ))}
                </Bar>
              </BarChart>
            </ResponsiveContainer>
          ) : (
            <div style={{ height: 220, display: "flex", alignItems: "center", justifyContent: "center", color: "#455a64", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)" }}>
              No usage data yet
            </div>
          )}
        </div>

        {/* Usage Over Time */}
        <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
          <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 16 }}>
            <h2
              style={{
                fontSize: 13,
                fontWeight: 600,
                color: "#4fc3f7",
                margin: 0,
                fontFamily: "var(--font-mc-mono, monospace)",
                letterSpacing: "0.5px",
              }}
            >
              USAGE OVER TIME
            </h2>
            <div style={{ display: "flex", gap: 4 }}>
              {(["24h", "7d"] as const).map((v) => (
                <button
                  key={v}
                  onClick={() => setView(v)}
                  style={{
                    padding: "3px 10px",
                    fontSize: 11,
                    fontFamily: "var(--font-mc-mono, monospace)",
                    border: `1px solid ${view === v ? "#4fc3f7" : "#1a3a4a"}`,
                    borderRadius: 4,
                    background: view === v ? "rgba(79,195,247,0.15)" : "transparent",
                    color: view === v ? "#4fc3f7" : "#607d8b",
                    cursor: "pointer",
                  }}
                >
                  {v}
                </button>
              ))}
            </div>
          </div>
          {(() => {
            const chartData = view === "24h" ? data?.hourlyData : data?.dailyData;
            const xKey = view === "24h" ? "hour" : "day";
            if (!chartData || chartData.length === 0) {
              return (
                <div style={{ height: 220, display: "flex", alignItems: "center", justifyContent: "center", color: "#455a64", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)" }}>
                  No usage data yet
                </div>
              );
            }
            return (
              <ResponsiveContainer width="100%" height={220}>
                <LineChart data={chartData} margin={{ left: 10, right: 10 }}>
                  <CartesianGrid strokeDasharray="3 3" stroke="#1a3a4a" />
                  <XAxis dataKey={xKey} tick={{ fill: "#607d8b", fontSize: 10 }} interval="preserveStartEnd" />
                  <YAxis tick={{ fill: "#607d8b", fontSize: 11 }} tickFormatter={(v: number) => `$${v.toFixed(2)}`} />
                  <Tooltip
                    contentStyle={{ background: "#0d1117", border: "1px solid #1a3a4a", borderRadius: 6, fontSize: 12 }}
                    formatter={(v) => [`$${Number(v).toFixed(4)}`, ""]}
                  />
                  {Object.entries(PROVIDER_CONFIG).map(([key, cfg]) => (
                    <Line
                      key={key}
                      type="monotone"
                      dataKey={key}
                      stroke={cfg.color}
                      strokeWidth={2}
                      dot={false}
                      connectNulls
                    />
                  ))}
                </LineChart>
              </ResponsiveContainer>
            );
          })()}
        </div>
      </div>

      {/* Recent Activity Table */}
      <div style={{ background: "#0a1929", border: "1px solid #1a3a4a", borderRadius: 8, padding: 20 }}>
        <h2
          style={{
            fontSize: 13,
            fontWeight: 600,
            color: "#4fc3f7",
            margin: "0 0 16px",
            fontFamily: "var(--font-mc-mono, monospace)",
            letterSpacing: "0.5px",
          }}
        >
          RECENT API CALLS
        </h2>
        {data?.recent && data.recent.length > 0 ? (
          <div style={{ overflowX: "auto" }}>
            <table style={{ width: "100%", borderCollapse: "collapse", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)" }}>
              <thead>
                <tr style={{ borderBottom: "1px solid #1a3a4a" }}>
                  {["TIME", "SOURCE", "PROVIDER", "MODEL", "IN", "OUT", "COST"].map((h) => (
                    <th
                      key={h}
                      style={{
                        textAlign: "left",
                        padding: "8px 12px",
                        color: "#607d8b",
                        fontWeight: 500,
                        fontSize: 11,
                      }}
                    >
                      {h}
                    </th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {data.recent.map((r, i) => {
                  const provCfg = PROVIDER_CONFIG[r.provider];
                  return (
                    <tr key={i} style={{ borderBottom: "1px solid rgba(26,58,74,0.5)" }}>
                      <td style={{ padding: "8px 12px", color: "#455a64" }}>
                        {new Date(r.timestamp).toLocaleTimeString()}
                      </td>
                      <td style={{ padding: "8px 12px", color: "#e0e0e0" }}>{r.source}</td>
                      <td style={{ padding: "8px 12px", color: provCfg?.color || "#e0e0e0" }}>
                        {r.provider}
                      </td>
                      <td style={{ padding: "8px 12px", color: "#607d8b" }}>{r.model}</td>
                      <td style={{ padding: "8px 12px", color: "#e0e0e0" }}>
                        {r.input_tokens.toLocaleString()}
                      </td>
                      <td style={{ padding: "8px 12px", color: "#e0e0e0" }}>
                        {r.output_tokens.toLocaleString()}
                      </td>
                      <td style={{ padding: "8px 12px", color: "#ff9800", fontWeight: 500 }}>
                        ${r.cost_usd.toFixed(4)}
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        ) : (
          <div style={{ padding: 32, textAlign: "center", color: "#455a64", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)" }}>
            No API calls logged yet — usage will appear here as bots make requests
          </div>
        )}
      </div>
    </div>
  );
}
