"use client";
import { useEffect, useState } from "react";

export default function MissionMetrics() {
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
  const posList = [...(status?.accounts?.boba?.positions || []), ...(status?.accounts?.jazzy?.positions || [])];
  const winners = posList.filter((p: any) => (p.pnl || 0) > 0).length;
  const losers = posList.filter((p: any) => (p.pnl || 0) < 0).length;
  const posCount = (status?.accounts?.boba?.positions?.length || 0) + (status?.accounts?.jazzy?.positions?.length || 0);

  return (
    <div style={{ display: "flex", flexDirection: "column", borderBottom: "1px solid #1f2a36" }}>
      <div style={{ height: 38, display: "flex", alignItems: "center", padding: "0 16px", gap: 10, background: "#0a1929", fontFamily: "ui-monospace,monospace", color: "#e8edf2" }}>
        <Pill label="Total" value={fmt(totalEq)} />
        <Pill label="P&L" value={`${totalPnL >= 0 ? "+" : ""}$${totalPnL.toFixed(2)}`} color={pnlColor} />
        <Pill label="Boba" value={fmt(bobaEq || undefined)} />
        <Pill label="Jazzy" value={fmt(jazzyEq || undefined)} />
        <Pill label="Pos" value={String(posCount)} />
        <Pill label="W/L" value={winners + "/" + losers} color="#8a99a8" />
      </div>
      <div style={{ height: 28, display: "flex", alignItems: "center", padding: "0 16px", gap: 16, background: "#08111c", fontSize: 11, fontFamily: "ui-monospace,monospace", color: "#e8edf2" }}>
        <Tick label="SPY" v={market?.spy} />
        <Tick label="QQQ" v={market?.qqq} />
        <Tick label="VIX" v={market?.vix} />
        <Tick label="DXY" v={market?.dxy} />
        <Tick label="10Y" v={market?.tnx} />
        <Tick label="BTC" v={market?.btc} />
        <div style={{ marginLeft: "auto", color: market?.market_open ? "#5fff5f" : "#ff9b3f", fontWeight: 600, fontSize: 10 }}>
          {market?.market_open ? "● MARKET OPEN" : "● MARKET CLOSED"}
        </div>
      </div>
    </div>
  );
}

function Pill({ label, value, color }: { label: string; value: string; color?: string }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", padding: "1px 10px", borderRadius: 4, background: "#101a26", border: "1px solid #1f2a36" }}>
      <span style={{ fontSize: 8, color: "#8a99a8", textTransform: "uppercase", letterSpacing: 0.5 }}>{label}</span>
      <span style={{ fontSize: 12, fontWeight: 600, color: color || "#e8edf2" }}>{value}</span>
    </div>
  );
}

function Tick({ label, v }: { label: string; v?: { value: number; chg: number } | null }) {
  if (!v) return <span style={{ color: "#465261" }}>{label} —</span>;
  const color = v.chg >= 0 ? "#5fff5f" : "#ff6b6b";
  return (
    <span>
      <span style={{ color: "#8a99a8", marginRight: 5 }}>{label}</span>
      <span style={{ color: "#e8edf2", marginRight: 3 }}>{v.value.toFixed(2)}</span>
      <span style={{ color }}>{v.chg >= 0 ? "+" : ""}{v.chg.toFixed(2)}%</span>
    </span>
  );
}
