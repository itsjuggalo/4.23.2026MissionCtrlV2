'use client';
import { useEffect, useState } from 'react';

export default function GoTraderPage() {
  const [data, setData] = useState<any>(null);

  useEffect(() => {
    fetch('/api/gotrader').then(r => r.ok ? r.json() : null).then(d => { if (d) setData(d); }).catch(() => {});
  }, []);

  if (!data) return <div style={{ padding: 24, color: '#888' }}>Loading...</div>;

  return (
    <div style={{ padding: 24 }}>
      {/* Header */}
      <div style={{ marginBottom: 24 }}>
        <h1 style={{ fontSize: 32, fontWeight: 700, color: '#f0f0f0', marginBottom: 4 }}>🤖 Go-Trader</h1>
        <p style={{ fontSize: 14, color: '#888' }}>Hybrid Trading Bot — Paper Trading</p>
      </div>

      {/* KPIs */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16, marginBottom: 24 }}>
        <div style={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 8, padding: 16 }}>
          <p style={{ fontSize: 11, color: '#888', textTransform: 'uppercase', marginBottom: 8 }}>Status</p>
          <p style={{ fontSize: 18, fontWeight: 700, color: '#4ade80' }}>🟢 {data.status}</p>
        </div>
        <div style={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 8, padding: 16 }}>
          <p style={{ fontSize: 11, color: '#888', textTransform: 'uppercase', marginBottom: 8 }}>Trades Today</p>
          <p style={{ fontSize: 18, fontWeight: 700, color: '#f0f0f0' }}>
            {data.platforms.hyperliquid.trades_today + data.platforms.robinhood.trades_today + data.platforms.binance_us.trades_today}
          </p>
        </div>
        <div style={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 8, padding: 16 }}>
          <p style={{ fontSize: 11, color: '#888', textTransform: 'uppercase', marginBottom: 8 }}>Total P&L</p>
          <p style={{ fontSize: 18, fontWeight: 700, color: data.total_pnl >= 0 ? '#4ade80' : '#ef4444' }}>
            ${data.total_pnl.toFixed(2)}
          </p>
        </div>
      </div>

      {/* Platforms */}
      <div style={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 8, padding: 24, marginBottom: 24 }}>
        <h2 style={{ fontSize: 18, fontWeight: 700, color: '#fff', marginBottom: 16 }}>📊 Platform Status</h2>
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16 }}>
          {Object.entries(data.platforms).map(([name, info]: any) => (
            <div key={name} style={{ background: '#0a0a0a', borderRadius: 8, padding: 16 }}>
              <h3 style={{ fontWeight: 600, color: '#f0f0f0', marginBottom: 12, textTransform: 'capitalize' }}>{name.replace('_', ' ')}</h3>
              <div style={{ fontSize: 12, color: '#888', lineHeight: 1.8 }}>
                <p>Status: <span style={{ color: '#4ade80' }}>{info.status}</span></p>
                <p>Trades: <span style={{ color: '#fff' }}>{info.trades_today}</span></p>
                <p>P&L: <span style={{ color: info.pnl >= 0 ? '#4ade80' : '#ef4444' }}>${info.pnl.toFixed(2)}</span></p>
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Positions */}
      <div style={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 8, padding: 24 }}>
        <h2 style={{ fontSize: 18, fontWeight: 700, color: '#fff', marginBottom: 16 }}>📈 Active Positions</h2>
        {data.active_positions && data.active_positions.length > 0 ? (
          <table style={{ width: '100%', fontSize: 14 }}>
            <thead style={{ borderBottom: '1px solid #1f1f1f', color: '#888' }}>
              <tr>
                <th style={{ textAlign: 'left', paddingBottom: 8 }}>Symbol</th>
                <th style={{ textAlign: 'right', paddingBottom: 8 }}>Size</th>
                <th style={{ textAlign: 'right', paddingBottom: 8 }}>Entry</th>
                <th style={{ textAlign: 'right', paddingBottom: 8 }}>Current</th>
                <th style={{ textAlign: 'right', paddingBottom: 8 }}>P&L</th>
              </tr>
            </thead>
            <tbody>
              {data.active_positions.map((pos: any) => (
                <tr key={pos.symbol} style={{ borderBottom: '1px solid #0a0a0a' }}>
                  <td style={{ paddingTop: 8, paddingBottom: 8, color: '#fff' }}>{pos.symbol}</td>
                  <td style={{ paddingTop: 8, paddingBottom: 8, textAlign: 'right', color: '#888' }}>{pos.size}</td>
                  <td style={{ paddingTop: 8, paddingBottom: 8, textAlign: 'right', color: '#888' }}>${pos.entry.toFixed(2)}</td>
                  <td style={{ paddingTop: 8, paddingBottom: 8, textAlign: 'right', color: '#888' }}>${pos.current.toFixed(2)}</td>
                  <td style={{ paddingTop: 8, paddingBottom: 8, textAlign: 'right', fontWeight: 600, color: pos.pnl >= 0 ? '#4ade80' : '#ef4444' }}>${pos.pnl.toFixed(2)}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p style={{ color: '#555', textAlign: 'center', paddingTop: 16, paddingBottom: 16 }}>No active positions</p>
        )}
      </div>
    </div>
  );
}
