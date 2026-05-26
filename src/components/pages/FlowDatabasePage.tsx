"use client";

import { useState, useEffect, useCallback } from "react";

// ─── Types matching the prod /db/* endpoint shapes ───────────────────────────
interface Stats {
  flow_alerts: number;
  trade_signals: number;
  notifications: number;
  auto_trader_orders: number;
  flow_alerts_latest?: string | null;
  trade_signals_latest?: string | null;
  notifications_latest?: string | null;
  auto_trader_orders_last_real_order?: string | null;
}

interface FlowAlert {
  id: string;
  captured_at: string;
  source: string;
  option_symbol: string;
  ticker: string;
  option_type: string | null;
  strike: number | null;
  expiry_ts: number | null;
  alert_type: string | null;
  flow_value: number | null;
  flow_count: number | null;
  spot: number | null;
  is_bullish: number | null;
}

interface TradeSignal {
  id: string;
  captured_at: string;
  source: string;
  path: string;
  ticker: string | null;
  strike: string | null;
  is_put: number;
  category: string;
  buy_target: number | null;
  sell_target: number | null;
  stop_loss: number | null;
  expiry_ts: number | null;
  risk: string | null;
  is_free: number;
}

interface Notification {
  id: string;
  captured_at: string;
  source: string;
  path: string | null;
  package: string | null;
  ticker: string | null;
  title: string | null;
  message: string | null;
  category: string | null;
}

interface AutoTraderOrder {
  signal_id: string;
  account: string;
  ticker: string;
  action: string;
  qty: number;
  placed_at: string;
  alpaca_order_id: string | null;
  status: string;
  error: string | null;
}

type TableName = "flow-alerts" | "trade-signals" | "notifications" | "auto-trader-orders";

// ─── Helpers ─────────────────────────────────────────────────────────────────
function fmtMoney(n: number | null | undefined): string {
  if (n == null) return "—";
  const abs = Math.abs(n);
  if (abs >= 1e9) return `$${(n / 1e9).toFixed(2)}B`;
  if (abs >= 1e6) return `$${(n / 1e6).toFixed(2)}M`;
  if (abs >= 1e3) return `$${(n / 1e3).toFixed(1)}K`;
  return `$${n.toFixed(0)}`;
}

function fmtNum(n: number | null | undefined, digits = 2): string {
  if (n == null) return "—";
  return n.toFixed(digits);
}

function fmtTime(iso: string | null | undefined): string {
  if (!iso) return "—";
  try {
    const d = new Date(iso);
    return d.toLocaleString(undefined, {
      month: "short", day: "numeric", hour: "2-digit", minute: "2-digit",
    });
  } catch {
    return iso.slice(0, 16);
  }
}

function fmtExpiry(ts: number | null | undefined): string {
  if (!ts) return "—";
  try {
    return new Date(ts * 1000).toLocaleDateString(undefined, { month: "short", day: "numeric" });
  } catch {
    return "—";
  }
}

// ─── Stat card ───────────────────────────────────────────────────────────────
function StatCard({ label, value, sub }: { label: string; value: string | number; sub?: string }) {
  return (
    <div style={{
      flex: 1, minWidth: 180, padding: "14px 16px",
      background: "rgba(95, 163, 255, 0.06)",
      border: "1px solid rgba(95, 163, 255, 0.15)",
      borderRadius: 8,
    }}>
      <div style={{ fontSize: 11, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.5, marginBottom: 4 }}>{label}</div>
      <div style={{ fontSize: 22, fontWeight: 700, color: "#fff" }}>{value}</div>
      {sub && <div style={{ fontSize: 11, color: "#5fa3ff", marginTop: 4 }}>{sub}</div>}
    </div>
  );
}

// ─── Filter row ──────────────────────────────────────────────────────────────
function FilterRow({
  ticker, setTicker, limit, setLimit, account, setAccount, showAccount, onRefresh, loading,
}: {
  ticker: string; setTicker: (s: string) => void;
  limit: number; setLimit: (n: number) => void;
  account: string; setAccount: (s: string) => void;
  showAccount: boolean;
  onRefresh: () => void;
  loading: boolean;
}) {
  const inputStyle = {
    background: "#0a1117",
    border: "1px solid #1a2530",
    borderRadius: 4,
    color: "#cfd6dd",
    padding: "6px 10px",
    fontSize: 13,
    fontFamily: "inherit",
  };
  return (
    <div style={{ display: "flex", alignItems: "center", gap: 10, padding: "10px 16px", borderBottom: "1px solid #1a2530" }}>
      <label style={{ fontSize: 11, color: "#8a99a8" }}>Ticker</label>
      <input
        style={{ ...inputStyle, width: 90 }}
        value={ticker}
        onChange={(e) => setTicker(e.target.value.toUpperCase())}
        placeholder="ALL"
      />
      {showAccount && (
        <>
          <label style={{ fontSize: 11, color: "#8a99a8", marginLeft: 6 }}>Account</label>
          <select style={inputStyle} value={account} onChange={(e) => setAccount(e.target.value)}>
            <option value="">all</option>
            <option value="boba">boba</option>
            <option value="jazzy">jazzy</option>
          </select>
        </>
      )}
      <label style={{ fontSize: 11, color: "#8a99a8", marginLeft: 6 }}>Limit</label>
      <select style={inputStyle} value={limit} onChange={(e) => setLimit(Number(e.target.value))}>
        <option value={50}>50</option>
        <option value={100}>100</option>
        <option value={250}>250</option>
        <option value={500}>500</option>
        <option value={1000}>1000</option>
      </select>
      <button
        onClick={onRefresh}
        disabled={loading}
        style={{
          marginLeft: "auto",
          background: "#5fa3ff",
          color: "#000",
          border: "none",
          borderRadius: 4,
          padding: "6px 14px",
          fontSize: 12,
          fontWeight: 600,
          cursor: loading ? "wait" : "pointer",
          opacity: loading ? 0.6 : 1,
        }}
      >
        {loading ? "Loading…" : "Refresh"}
      </button>
    </div>
  );
}

// ─── Main page ───────────────────────────────────────────────────────────────
export function FlowDatabasePage() {
  const [stats, setStats] = useState<Stats | null>(null);
  const [tab, setTab] = useState<TableName>("flow-alerts");
  const [rows, setRows] = useState<any[]>([]);
  const [ticker, setTicker] = useState("");
  const [limit, setLimit] = useState(100);
  const [account, setAccount] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const fetchStats = useCallback(async () => {
    try {
      const r = await fetch("/api/flow-database?table=stats");
      if (!r.ok) throw new Error(`stats ${r.status}`);
      setStats(await r.json());
    } catch (e: any) {
      // Surface but don't block the page
      console.warn("[FlowDatabase] stats fetch failed:", e?.message || e);
    }
  }, []);

  const fetchRows = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const params = new URLSearchParams({ table: tab, limit: String(limit) });
      if (ticker.trim()) params.set("ticker", ticker.trim());
      if (account && tab === "auto-trader-orders") params.set("account", account);
      const r = await fetch(`/api/flow-database?${params.toString()}`);
      if (!r.ok) {
        const txt = await r.text();
        throw new Error(`HTTP ${r.status}: ${txt.slice(0, 200)}`);
      }
      const j = await r.json();
      setRows(j.rows || []);
    } catch (e: any) {
      setError(String(e?.message || e));
      setRows([]);
    } finally {
      setLoading(false);
    }
  }, [tab, limit, ticker, account]);

  useEffect(() => {
    fetchStats();
    const iv = setInterval(fetchStats, 30_000);
    return () => clearInterval(iv);
  }, [fetchStats]);

  useEffect(() => {
    fetchRows();
  }, [fetchRows]);

  // ─── Render ────────────────────────────────────────────────────────────────
  return (
    <div style={{ height: "100%", display: "flex", flexDirection: "column", color: "#cfd6dd", background: "#0d1117" }}>
      {/* Stats cards */}
      <div style={{ display: "flex", gap: 10, padding: "14px 16px", flexWrap: "wrap" }}>
        <StatCard label="Flow Alerts" value={stats?.flow_alerts ?? "…"} sub={fmtTime(stats?.flow_alerts_latest)} />
        <StatCard label="Trade Signals" value={stats?.trade_signals ?? "…"} sub={fmtTime(stats?.trade_signals_latest)} />
        <StatCard label="Notifications" value={stats?.notifications ?? "…"} sub={fmtTime(stats?.notifications_latest)} />
        <StatCard
          label="Auto-Trader Orders"
          value={stats?.auto_trader_orders ?? "…"}
          sub={stats?.auto_trader_orders_last_real_order ? `Last real: ${fmtTime(stats.auto_trader_orders_last_real_order)}` : "seed only"}
        />
      </div>

      {/* Tabs */}
      <div style={{ display: "flex", gap: 4, padding: "0 16px", borderBottom: "1px solid #1a2530" }}>
        {(["flow-alerts", "trade-signals", "notifications", "auto-trader-orders"] as TableName[]).map((t) => {
          const active = tab === t;
          const label =
            t === "flow-alerts" ? "Flow Alerts" :
            t === "trade-signals" ? "Trade Signals" :
            t === "notifications" ? "Notifications" :
            "Auto-Trader Orders";
          return (
            <button
              key={t}
              onClick={() => setTab(t)}
              style={{
                background: "transparent",
                border: "none",
                borderBottom: active ? "2px solid #5fa3ff" : "2px solid transparent",
                color: active ? "#fff" : "#8a99a8",
                padding: "10px 14px",
                fontSize: 13,
                fontWeight: active ? 600 : 400,
                cursor: "pointer",
                fontFamily: "inherit",
              }}
            >
              {label}
            </button>
          );
        })}
      </div>

      <FilterRow
        ticker={ticker} setTicker={setTicker}
        limit={limit} setLimit={setLimit}
        account={account} setAccount={setAccount}
        showAccount={tab === "auto-trader-orders"}
        onRefresh={fetchRows}
        loading={loading}
      />

      {/* Error banner */}
      {error && (
        <div style={{ padding: "10px 16px", background: "rgba(255, 87, 87, 0.1)", borderBottom: "1px solid rgba(255,87,87,0.3)", color: "#ff8a8a", fontSize: 12 }}>
          {error}
        </div>
      )}

      {/* Table */}
      <div style={{ flex: 1, overflow: "auto", padding: "0 16px 16px" }}>
        {tab === "flow-alerts" && <FlowAlertsTable rows={rows as FlowAlert[]} />}
        {tab === "trade-signals" && <TradeSignalsTable rows={rows as TradeSignal[]} />}
        {tab === "notifications" && <NotificationsTable rows={rows as Notification[]} />}
        {tab === "auto-trader-orders" && <AutoTraderOrdersTable rows={rows as AutoTraderOrder[]} />}
        {!loading && rows.length === 0 && !error && (
          <div style={{ padding: "40px 16px", textAlign: "center", color: "#5a6470", fontSize: 13 }}>No rows match the filter.</div>
        )}
      </div>

      <div style={{ padding: "6px 16px", borderTop: "1px solid #1a2530", fontSize: 11, color: "#5a6470", display: "flex", justifyContent: "space-between" }}>
        <span>Source: prod options_flow.sqlite via bridge.serveftp.com</span>
        <span>{rows.length} rows · {loading ? "fetching…" : "ready"}</span>
      </div>
    </div>
  );
}

// ─── Per-table renderers ─────────────────────────────────────────────────────
const th: React.CSSProperties = { textAlign: "left", padding: "8px 10px", borderBottom: "1px solid #1a2530", fontSize: 11, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.5, fontWeight: 600, position: "sticky", top: 0, background: "#0d1117" };
const td: React.CSSProperties = { padding: "8px 10px", borderBottom: "1px solid #131c25", fontSize: 12, color: "#cfd6dd" };

function FlowAlertsTable({ rows }: { rows: FlowAlert[] }) {
  return (
    <table style={{ width: "100%", borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th style={th}>Time</th><th style={th}>Source</th><th style={th}>Ticker</th>
          <th style={th}>Type</th><th style={th}>Strike</th><th style={th}>Exp</th>
          <th style={th}>Alert</th><th style={th}>Flow $</th><th style={th}>Count</th>
          <th style={th}>Spot</th><th style={th}>Dir</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((r) => (
          <tr key={r.id}>
            <td style={td}>{fmtTime(r.captured_at)}</td>
            <td style={td}>{r.source}</td>
            <td style={{ ...td, color: "#fff", fontWeight: 600 }}>{r.ticker}</td>
            <td style={{ ...td, color: r.option_type === "PUT" ? "#ff8a8a" : "#66bb6a" }}>{r.option_type || "—"}</td>
            <td style={td}>{r.strike != null ? `$${r.strike}` : "—"}</td>
            <td style={td}>{fmtExpiry(r.expiry_ts)}</td>
            <td style={td}>{r.alert_type}</td>
            <td style={{ ...td, color: "#5fa3ff", fontWeight: 600 }}>{fmtMoney(r.flow_value)}</td>
            <td style={td}>{r.flow_count}</td>
            <td style={td}>{r.spot != null ? `$${fmtNum(r.spot)}` : "—"}</td>
            <td style={{ ...td, color: r.is_bullish === 1 ? "#66bb6a" : r.is_bullish === 0 ? "#ff8a8a" : "#8a99a8" }}>
              {r.is_bullish === 1 ? "BULL" : r.is_bullish === 0 ? "BEAR" : "?"}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function TradeSignalsTable({ rows }: { rows: TradeSignal[] }) {
  return (
    <table style={{ width: "100%", borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th style={th}>Time</th><th style={th}>Source</th><th style={th}>Path</th>
          <th style={th}>Ticker</th><th style={th}>Side</th><th style={th}>Strike</th>
          <th style={th}>Buy</th><th style={th}>Sell</th><th style={th}>SL</th>
          <th style={th}>Exp</th><th style={th}>Cat</th><th style={th}>Risk</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((r) => (
          <tr key={r.id}>
            <td style={td}>{fmtTime(r.captured_at)}</td>
            <td style={td}>{r.source}</td>
            <td style={td}>{r.path}</td>
            <td style={{ ...td, color: "#fff", fontWeight: 600 }}>{r.ticker || "—"}</td>
            <td style={{ ...td, color: r.is_put === 1 ? "#ff8a8a" : "#66bb6a" }}>{r.is_put === 1 ? "PUT" : "CALL"}</td>
            <td style={td}>{r.strike || "—"}</td>
            <td style={td}>{r.buy_target != null ? `$${fmtNum(r.buy_target)}` : "—"}</td>
            <td style={td}>{r.sell_target != null ? `$${fmtNum(r.sell_target)}` : "—"}</td>
            <td style={td}>{r.stop_loss != null ? `$${fmtNum(r.stop_loss)}` : "—"}</td>
            <td style={td}>{fmtExpiry(r.expiry_ts)}</td>
            <td style={td}>{r.category}</td>
            <td style={td}>{r.risk}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function NotificationsTable({ rows }: { rows: Notification[] }) {
  return (
    <table style={{ width: "100%", borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th style={th}>Time</th><th style={th}>Source</th><th style={th}>Path</th>
          <th style={th}>Ticker</th><th style={th}>Title</th><th style={th}>Message</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((r) => (
          <tr key={r.id}>
            <td style={td}>{fmtTime(r.captured_at)}</td>
            <td style={td}>{r.source}</td>
            <td style={td}>{r.path}</td>
            <td style={{ ...td, color: "#fff", fontWeight: 600 }}>{r.ticker || "—"}</td>
            <td style={td}>{r.title || ""}</td>
            <td style={{ ...td, color: "#a8b5c2", maxWidth: 400, overflow: "hidden", textOverflow: "ellipsis", whiteSpace: "nowrap" }} title={r.message || ""}>{r.message || ""}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function AutoTraderOrdersTable({ rows }: { rows: AutoTraderOrder[] }) {
  return (
    <table style={{ width: "100%", borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th style={th}>Placed</th><th style={th}>Account</th><th style={th}>Ticker</th>
          <th style={th}>Action</th><th style={th}>Qty</th><th style={th}>Status</th>
          <th style={th}>Order ID</th><th style={th}>Error</th>
        </tr>
      </thead>
      <tbody>
        {rows.map((r, i) => (
          <tr key={`${r.signal_id}-${r.account}-${r.action}-${i}`}>
            <td style={td}>{fmtTime(r.placed_at)}</td>
            <td style={td}>{r.account}</td>
            <td style={{ ...td, color: "#fff", fontWeight: 600 }}>{r.ticker}</td>
            <td style={{ ...td, color: r.action === "BUY" ? "#66bb6a" : "#ff8a8a" }}>{r.action}</td>
            <td style={td}>{r.qty}</td>
            <td style={{
              ...td,
              color:
                r.status === "submitted" ? "#66bb6a" :
                r.status === "failed"    ? "#ff8a8a" :
                r.status === "skipped"   ? "#90a4ae" :
                r.status === "seeded"    ? "#5a6470" : "#cfd6dd",
            }}>{r.status}</td>
            <td style={{ ...td, fontFamily: "ui-monospace, monospace", fontSize: 10 }}>{r.alpaca_order_id ? r.alpaca_order_id.slice(0, 8) + "…" : "—"}</td>
            <td style={{ ...td, color: "#ff8a8a", fontSize: 11 }}>{r.error || ""}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default FlowDatabasePage;
