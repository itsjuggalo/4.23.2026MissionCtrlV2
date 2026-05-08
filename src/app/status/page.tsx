"use client";
import { useEffect, useState } from "react";

type Account = {
  equity?: number; cash?: number; buying_power?: number;
  positions?: any[]; orders_today?: number; recent_orders?: any[];
  error?: string;
};

export default function Status() {
  const [data, setData] = useState<any>(null);
  const [updated, setUpdated] = useState<string>("");
  const [err, setErr] = useState<string>("");

  const refresh = async () => {
    try {
      const r = await fetch("/api/status", { cache: "no-store" });
      const d = await r.json();
      setData(d);
      setUpdated(new Date().toLocaleTimeString("en-US", { timeZone: "America/New_York", hour12: true }));
      setErr("");
    } catch (e: any) {
      setErr(e.message);
    }
  };

  useEffect(() => {
    refresh();
    const i = setInterval(refresh, 30_000);
    return () => clearInterval(i);
  }, []);

  if (!data) return <main style={{padding:32, fontFamily:"ui-monospace,monospace", color:"#eee", background:"#0b0b0d", minHeight:"100vh"}}>Loading{err && ` — ${err}`}…</main>;
  const fmt = (n?: number) => (typeof n === "number" ? `$${n.toFixed(2)}` : "—");

  const card = (name: string, a: Account) => (
    <div key={name} style={{flex:1, minWidth:340, padding:20, border:"1px solid #2a2a30", borderRadius:8, background:"#16161a"}}>
      <h2 style={{margin:0, fontSize:18, color:"#f0f0f0"}}>{name === "boba" ? "🦙 Boba" : "🎶 Jazzy"}</h2>
      {a.error ? <p style={{color:"#f56"}}>Error: {a.error}</p> : (
        <>
          <div style={{display:"grid", gridTemplateColumns:"1fr 1fr 1fr", gap:8, marginTop:12, fontSize:13}}>
            <div><div style={{color:"#888"}}>Equity</div><div style={{fontSize:18, fontWeight:600}}>{fmt(a.equity)}</div></div>
            <div><div style={{color:"#888"}}>Cash</div><div style={{fontSize:18, fontWeight:600}}>{fmt(a.cash)}</div></div>
            <div><div style={{color:"#888"}}>BP</div><div style={{fontSize:18, fontWeight:600}}>{fmt(a.buying_power)}</div></div>
          </div>
          <h3 style={{marginTop:16, marginBottom:8, fontSize:14, color:"#aaa"}}>Open positions ({(a.positions||[]).length})</h3>
          {(a.positions||[]).length === 0 ? <div style={{color:"#666", fontSize:13}}>none</div> : (
            <table style={{width:"100%", fontSize:12, borderCollapse:"collapse"}}>
              <thead><tr style={{color:"#888"}}><th style={{textAlign:"left"}}>Symbol</th><th>Qty</th><th>P/L%</th><th>P/L $</th></tr></thead>
              <tbody>{(a.positions||[]).map((p: any) => (
                <tr key={p.symbol}><td style={{padding:"3px 0"}}>{p.symbol}</td><td style={{textAlign:"center"}}>{p.qty}</td>
                <td style={{textAlign:"right", color: p.pnl_pct >= 0 ? "#4caf50" : "#f56"}}>{p.pnl_pct.toFixed(2)}%</td>
                <td style={{textAlign:"right", color: p.pnl >= 0 ? "#4caf50" : "#f56"}}>${p.pnl.toFixed(2)}</td></tr>
              ))}</tbody>
            </table>
          )}
          <h3 style={{marginTop:16, marginBottom:8, fontSize:14, color:"#aaa"}}>Today's orders ({a.orders_today})</h3>
          {(a.recent_orders||[]).length === 0 ? <div style={{color:"#666", fontSize:13}}>none today</div> : (
            <div style={{fontFamily:"ui-monospace,monospace", fontSize:11, lineHeight:1.5}}>
              {(a.recent_orders||[]).map((o: any, i: number) => (
                <div key={i} style={{color: o.status==="filled" ? "#4caf50" : "#888"}}>
                  {o.time} {o.side.padEnd(4)} {o.symbol.padEnd(22)} qty={o.qty} {o.status}
                </div>
              ))}
            </div>
          )}
        </>
      )}
    </div>
  );

  return (
    <main style={{padding:32, fontFamily:"ui-sans-serif,system-ui,sans-serif", color:"#eee", background:"#0b0b0d", minHeight:"100vh"}}>
      <header style={{display:"flex", justifyContent:"space-between", alignItems:"center", marginBottom:24}}>
        <div>
          <h1 style={{margin:0, fontSize:24}}>Mission Control · Status</h1>
          <div style={{color:"#888", fontSize:12, marginTop:4}}>Updated {updated} ET · auto-refresh every 30s</div>
        </div>
        <button onClick={refresh} style={{padding:"8px 14px", background:"#2a2a30", color:"#eee", border:"1px solid #444", borderRadius:6, cursor:"pointer"}}>↻ Refresh</button>
      </header>
      <div style={{display:"flex", gap:16, flexWrap:"wrap"}}>
        {card("boba", data.accounts?.boba || {})}
        {card("jazzy", data.accounts?.jazzy || {})}
      </div>
    </main>
  );
}
