"use client";
import { useEffect, useState } from "react";
import { safeFixed } from "@/lib/fmt";

// Market ticker strip shown above the header. The Alpaca account row that
// used to sit here now lives on the header line itself (see Header.tsx).
export default function MissionMetrics() {
  const [market, setMarket] = useState<any>(null);
  useEffect(() => {
    const refresh = async () => {
      try {
        const m = await fetch("/api/market", { cache: "no-store" }).then(r => r.ok ? r.json() : null);
        setMarket(m);
      } catch {}
    };
    refresh();
    const i = setInterval(refresh, 30000);
    return () => clearInterval(i);
  }, []);

  return (
    <div style={{ borderBottom: "1px solid #1f2a36" }}>
      <div style={{ height: 28, display: "flex", alignItems: "center", padding: "0 16px", gap: 16, background: "#08111c", fontSize: 11, fontFamily: "ui-monospace,monospace", color: "#e8edf2", overflowX: "auto" }}>
        <Tick label="SPY" v={market?.spy} />
        <Tick label="QQQ" v={market?.qqq} />
        <Tick label="VIX" v={market?.vix} />
        <Tick label="DXY" v={market?.dxy} />
        <Tick label="10Y" v={market?.tnx} />
        <Tick label="BTC" v={market?.btc} />
        <div style={{ marginLeft: "auto", color: market?.market_open ? "#5fff5f" : "#ff9b3f", fontWeight: 600, fontSize: 10, flexShrink: 0, whiteSpace: "nowrap", paddingLeft: 16 }}>
          {market?.market_open ? "● MARKET OPEN" : "● MARKET CLOSED"}
        </div>
      </div>
    </div>
  );
}

function Tick({ label, v }: { label: string; v?: { value: number; chg: number } | null }) {
  if (!v) return <span style={{ color: "#465261", flexShrink: 0, whiteSpace: "nowrap" }}>{label} —</span>;
  const color = v.chg >= 0 ? "#5fff5f" : "#ff6b6b";
  return (
    <span style={{ flexShrink: 0, whiteSpace: "nowrap" }}>
      <span style={{ color: "#8a99a8", marginRight: 5 }}>{label}</span>
      <span style={{ color: "#e8edf2", marginRight: 3 }}>{safeFixed(v.value, 2)}</span>
      <span style={{ color }}>{v.chg >= 0 ? "+" : ""}{safeFixed(v.chg, 2)}%</span>
    </span>
  );
}
