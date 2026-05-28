"use client";
import { useEffect, useState } from "react";

type AcctData = {
  equity?: number; cash?: number; buying_power?: number;
  positions?: Array<{ symbol: string; qty: number; avg_entry: number; current: number; pnl: number; pnl_pct: number }>;
  orders_today?: number;
  recent_orders?: Array<{ time: string; side: string; symbol: string; qty: number; status: string }>;
  error?: string;
};
type Status = { timestamp: string; accounts: { boba: AcctData; jazzy: AcctData } };

export default function Dashboard() {
  const [s, setS] = useState<Status | null>(null);
  const [active, setActive] = useState<"boba" | "jazzy" | "both">("both");

  useEffect(() => {
    const r = async () => {
      try { const x = await fetch("/api/status", { cache: "no-store" }).then(r => r.ok ? r.json() : Promise.reject()); setS(x); } catch {}
    };
    r();
    const i = setInterval(r, 15000);
    return () => clearInterval(i);
  }, []);

  if (!s) return <div style={{ padding: 24, color: "#8a99a8" }}>Loading...</div>;

  const boba = s.accounts?.boba || {};
  const jazzy = s.accounts?.jazzy || {};
  const allPositions = active === "both"
    ? [...(boba.positions || []).map(p => ({ ...p, account: "boba" })), ...(jazzy.positions || []).map(p => ({ ...p, account: "jazzy" }))]
    : (active === "boba" ? boba.positions : jazzy.positions)?.map(p => ({ ...p, account: active })) || [];
  const allOrders = active === "both"
    ? [...(boba.recent_orders || []).map(o => ({ ...o, account: "boba" })), ...(jazzy.recent_orders || []).map(o => ({ ...o, account: "jazzy" }))]
    : (active === "boba" ? boba.recent_orders : jazzy.recent_orders)?.map(o => ({ ...o, account: active })) || [];

  return (
    <div style={{ padding: 16, color: "#e8edf2", fontFamily: "ui-monospace,monospace", display: "flex", flexDirection: "column", gap: 12 }}>
      {/* Account selector */}
      <div style={{ display: "flex", gap: 8, alignItems: "center" }}>
        <span style={{ fontSize: 11, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.5, marginRight: 6 }}>Account:</span>
        {(["both", "boba", "jazzy"] as const).map(a => (
          <button key={a} onClick={() => setActive(a)} style={{
            padding: "4px 12px", fontSize: 12, fontFamily: "inherit", cursor: "pointer", borderRadius: 4,
            border: "1px solid " + (active === a ? "#5fa3ff" : "#1f2a36"),
            background: active === a ? "#1f3a5c" : "#101a26",
            color: active === a ? "#fff" : "#8a99a8",
          }}>{a.toUpperCase()}</button>
        ))}
      </div>

      {/* Top row: 3 stat cards */}
      <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr 1fr", gap: 12 }}>
        <AccountCard name="Boba" data={boba} />
        <AccountCard name="Jazzy" data={jazzy} />
        <CombinedCard b={boba} j={jazzy} />
      </div>

      {/* Mid row: positions left, orders right */}
      <div style={{ display: "grid", gridTemplateColumns: "2fr 1fr", gap: 12 }}>
        <Panel title={`Open Positions (${allPositions.length})`}>
          {allPositions.length === 0 ? <Empty>No open positions</Empty> : (
            <table style={{ width: "100%", fontSize: 12, borderCollapse: "collapse" }}>
              <thead>
                <tr style={{ color: "#8a99a8", textAlign: "left" }}>
                  <Th>Acct</Th><Th>Symbol</Th><Th right>Qty</Th><Th right>Avg</Th><Th right>Last</Th><Th right>P&L $</Th><Th right>P&L %</Th>
                </tr>
              </thead>
              <tbody>
                {allPositions.map((p, i) => (
                  <tr key={i} style={{ borderTop: "1px solid #1f2a36" }}>
                    <Td><AcctTag a={p.account} /></Td>
                    <Td bold>{p.symbol}</Td>
                    <Td right>{p.qty}</Td>
                    <Td right mono>${p.avg_entry?.toFixed(2)}</Td>
                    <Td right mono>${p.current?.toFixed(2)}</Td>
                    <Td right mono color={p.pnl >= 0 ? "#5fff5f" : "#ff6b6b"}>{p.pnl >= 0 ? "+" : ""}${p.pnl?.toFixed(2)}</Td>
                    <Td right mono color={p.pnl_pct >= 0 ? "#5fff5f" : "#ff6b6b"}>{p.pnl_pct >= 0 ? "+" : ""}{p.pnl_pct?.toFixed(2)}%</Td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </Panel>
        <Panel title={`Today (${allOrders.length} orders)`}>
          {allOrders.length === 0 ? <Empty>No orders today</Empty> : (
            <div style={{ display: "flex", flexDirection: "column", gap: 4 }}>
              {allOrders.slice(0, 12).map((o, i) => (
                <div key={i} style={{ display: "flex", alignItems: "center", gap: 8, padding: "4px 0", fontSize: 11, borderBottom: "1px solid #1f2a36" }}>
                  <AcctTag a={o.account} />
                  <StatusPill status={o.status} />
                  <span style={{ color: o.side === "buy" ? "#5fff5f" : "#ff9b3f", fontWeight: 600 }}>{o.side?.toUpperCase()}</span>
                  <span style={{ fontWeight: 600 }}>{o.symbol}</span>
                  <span style={{ color: "#8a99a8" }}>x{o.qty}</span>
                  <span style={{ marginLeft: "auto", color: "#465261", fontSize: 10 }}>{o.time}</span>
                </div>
              ))}
            </div>
          )}
        </Panel>
      </div>

      {/* Errors row if any */}
      {(boba.error || jazzy.error) && (
        <Panel title="Connection issues">
          {boba.error && <div style={{ color: "#ff6b6b", fontSize: 12, padding: 4 }}>Boba: {boba.error}</div>}
          {jazzy.error && <div style={{ color: "#ff6b6b", fontSize: 12, padding: 4 }}>Jazzy: {jazzy.error}</div>}
        </Panel>
      )}
    </div>
  );
}

function Panel({ title, children }: any) {
  return (
    <div style={{ background: "#0a1929", border: "1px solid #1f2a36", borderRadius: 6, overflow: "hidden" }}>
      <div style={{ padding: "8px 12px", fontSize: 11, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.7, borderBottom: "1px solid #1f2a36", background: "#08111c" }}>{title}</div>
      <div style={{ padding: 8 }}>{children}</div>
    </div>
  );
}

function AccountCard({ name, data }: { name: string; data: AcctData }) {
  const eq = data.equity || 0;
  const pnl = eq - 2000;
  const color = pnl >= 0 ? "#5fff5f" : "#ff6b6b";
  return (
    <Panel title={name}>
      {data.error ? (
        <div style={{ color: "#ff6b6b", fontSize: 12, padding: 8 }}>{data.error}</div>
      ) : (
        <div style={{ display: "flex", flexDirection: "column", gap: 6, padding: 4 }}>
          <Row label="Equity" value={`$${eq.toFixed(2)}`} large />
          <Row label="P&L vs $2000" value={`${pnl >= 0 ? "+" : ""}$${pnl.toFixed(2)}`} color={color} />
          <Row label="Cash" value={`$${(data.cash || 0).toFixed(2)}`} />
          <Row label="Buying Power" value={`$${(data.buying_power || 0).toFixed(2)}`} />
          <Row label="Positions" value={String(data.positions?.length || 0)} />
        </div>
      )}
    </Panel>
  );
}

function CombinedCard({ b, j }: { b: AcctData; j: AcctData }) {
  const totalEq = (b.equity || 0) + (j.equity || 0);
  const totalPnL = totalEq - 4000;
  const color = totalPnL >= 0 ? "#5fff5f" : "#ff6b6b";
  const totalPos = (b.positions?.length || 0) + (j.positions?.length || 0);
  const totalOrders = (b.orders_today || 0) + (j.orders_today || 0);
  return (
    <Panel title="Combined">
      <div style={{ display: "flex", flexDirection: "column", gap: 6, padding: 4 }}>
        <Row label="Total Equity" value={`$${totalEq.toFixed(2)}`} large />
        <Row label="Total P&L" value={`${totalPnL >= 0 ? "+" : ""}$${totalPnL.toFixed(2)}`} color={color} />
        <Row label="Open Positions" value={String(totalPos)} />
        <Row label="Orders Today" value={String(totalOrders)} />
      </div>
    </Panel>
  );
}

function Row({ label, value, color, large }: { label: string; value: string; color?: string; large?: boolean }) {
  return (
    <div style={{ display: "flex", alignItems: "baseline", justifyContent: "space-between", padding: "2px 6px" }}>
      <span style={{ fontSize: 10, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.4 }}>{label}</span>
      <span style={{ fontSize: large ? 18 : 12, fontWeight: 600, color: color || "#e8edf2", fontFamily: "ui-monospace,monospace" }}>{value}</span>
    </div>
  );
}

function Empty({ children }: any) {
  return <div style={{ padding: 16, fontSize: 12, color: "#465261", textAlign: "center" }}>{children}</div>;
}
function Th({ children, right }: any) {
  return <th style={{ padding: "6px 8px", fontWeight: 500, fontSize: 10, textTransform: "uppercase", letterSpacing: 0.4, textAlign: right ? "right" : "left", color: "#8a99a8" }}>{children}</th>;
}
function Td({ children, right, bold, mono, color }: any) {
  return <td style={{ padding: "6px 8px", textAlign: right ? "right" : "left", fontWeight: bold ? 600 : 400, fontFamily: mono ? "ui-monospace,monospace" : "inherit", color: color || "#e8edf2" }}>{children}</td>;
}
function AcctTag({ a }: { a: string }) {
  const c = a === "boba" ? "#ff9b3f" : "#5fa3ff";
  return <span style={{ fontSize: 9, color: c, padding: "1px 5px", border: `1px solid ${c}40`, borderRadius: 3, textTransform: "uppercase", fontWeight: 600 }}>{a?.[0]}</span>;
}
function StatusPill({ status }: { status: string }) {
  const map: Record<string, { bg: string; fg: string }> = {
    filled:    { bg: "#1a3a1a", fg: "#5fff5f" },
    partially_filled: { bg: "#3a3a1a", fg: "#ffd35f" },
    new:       { bg: "#1a2a3a", fg: "#5fa3ff" },
    accepted:  { bg: "#1a2a3a", fg: "#5fa3ff" },
    canceled:  { bg: "#3a1a1a", fg: "#ff6b6b" },
    rejected:  { bg: "#3a1a1a", fg: "#ff6b6b" },
    expired:   { bg: "#2a2a2a", fg: "#8a99a8" },
  };
  const c = map[status?.toLowerCase()] || { bg: "#2a2a2a", fg: "#8a99a8" };
  return <span style={{ fontSize: 9, padding: "1px 5px", borderRadius: 3, background: c.bg, color: c.fg, fontWeight: 600, textTransform: "uppercase", letterSpacing: 0.3 }}>{status}</span>;
}
