"use client";
import { useEffect, useState } from "react";
import { usePathname } from "next/navigation";

export default function AppShell({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const [status, setStatus] = useState<any>(null);
  const [market, setMarket] = useState<any>(null);

  useEffect(() => {
    const refresh = async () => {
      try {
        const [s, m] = await Promise.all([
          fetch("/api/status", { cache: "no-store" }).then(r => r.json()),
          fetch("/api/market", { cache: "no-store" }).then(r => r.json()),
        ]);
        setStatus(s); setMarket(m);
      } catch {}
    };
    refresh();
    const i = setInterval(refresh, 30000);
    return () => clearInterval(i);
  }, []);

  const fmt = (n?: number) => typeof n === "number" ? `$${n.toFixed(2)}` : "—";
  const bobaEq = status?.accounts?.boba?.equity || 0;
  const jazzyEq = status?.accounts?.jazzy?.equity || 0;
  const totalEq = bobaEq + jazzyEq;
  const totalPnL = (bobaEq - 2000) + (jazzyEq - 2000);
  const pnlColor = totalPnL >= 0 ? "#5fff5f" : "#ff6b6b";
  const posCount = (status?.accounts?.boba?.positions?.length || 0) + (status?.accounts?.jazzy?.positions?.length || 0);

  if (pathname === "/" || pathname === "/landing") return <>{children}</>;

  return (
    <div style={{ minHeight: "100vh", background: "#0d1117", color: "#e8edf2", fontFamily: "ui-monospace,monospace" }}>
      <header style={{ height: 44, display: "flex", alignItems: "center", padding: "0 16px", gap: 12, background: "#0a1929", borderBottom: "1px solid #1f2a36", position: "sticky", top: 0, zIndex: 50 }}>
        <div style={{ fontSize: 14, fontWeight: 700, color: "#5fa3ff", marginRight: 16 }}>MISSION CTRL</div>
        <Pill label="Total" value={fmt(totalEq)} />
        <Pill label="P&L" value={`${totalPnL >= 0 ? "+" : ""}$${totalPnL.toFixed(2)}`} color={pnlColor} />
        <Pill label="Boba" value={fmt(bobaEq || undefined)} />
        <Pill label="Jazzy" value={fmt(jazzyEq || undefined)} />
        <Pill label="Pos" value={String(posCount)} />
        <div style={{ marginLeft: "auto", fontSize: 11, color: "#8a99a8" }}>
          {status?.timestamp ? new Date(status.timestamp).toLocaleTimeString("en-US", { timeZone: "America/New_York", hour12: true }) + " ET" : "..."}
        </div>
      </header>
      <div style={{ height: 32, display: "flex", alignItems: "center", padding: "0 16px", gap: 18, background: "#08111c", borderBottom: "1px solid #1f2a36", fontSize: 11, position: "sticky", top: 44, zIndex: 49 }}>
        <Tick label="SPY" v={market?.spy} />
        <Tick label="QQQ" v={market?.qqq} />
        <Tick label="VIX" v={market?.vix} />
        <Tick label="DXY" v={market?.dxy} />
        <Tick label="10Y" v={market?.tnx} />
        <Tick label="BTC" v={market?.btc} />
        <div style={{ marginLeft: "auto", color: market?.market_open ? "#5fff5f" : "#ff9b3f", fontWeight: 600 }}>
          {market?.market_open ? "● MARKET OPEN" : "● MARKET CLOSED"}
        </div>
      </div>
      <main>{children}</main>
    </div>
  );
}

function Pill({ label, value, color }: { label: string; value: string; color?: string }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", padding: "2px 10px", borderRadius: 4, background: "#101a26", border: "1px solid #1f2a36" }}>
      <span style={{ fontSize: 9, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.5 }}>{label}</span>
      <span style={{ fontSize: 13, fontWeight: 600, color: color || "#e8edf2" }}>{value}</span>
    </div>
  );
}

function Tick({ label, v }: { label: string; v?: { value: number; chg: number } | null }) {
  if (!v) return <span style={{ color: "#465261" }}>{label} —</span>;
  const color = v.chg >= 0 ? "#5fff5f" : "#ff6b6b";
  return (
    <span>
      <span style={{ color: "#8a99a8", marginRight: 6 }}>{label}</span>
      <span style={{ color: "#e8edf2", marginRight: 4 }}>{v.value.toFixed(2)}</span>
      <span style={{ color }}>{v.chg >= 0 ? "+" : ""}{v.chg.toFixed(2)}%</span>
    </span>
  );
}
