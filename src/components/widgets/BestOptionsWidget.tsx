'use client';
import { useEffect, useState } from 'react';

function fmtMoney(v: number): string {
  if (!isFinite(v)) return '$?';
  if (Math.abs(v) >= 1e6) return '$' + (v / 1e6).toFixed(2) + 'M';
  if (Math.abs(v) >= 1e3) return '$' + (v / 1e3).toFixed(0) + 'K';
  return '$' + v.toFixed(0);
}
function fmtVol(v: number): string {
  if (!isFinite(v)) return '?';
  if (Math.abs(v) >= 1e6) return (v / 1e6).toFixed(1) + 'M';
  if (Math.abs(v) >= 1e3) return (v / 1e3).toFixed(1) + 'K';
  return String(Math.round(v));
}
function fmtExpiry(o: any): string {
  const e = o?.Expiry || o?.expiry || o?.expire || '';
  if (!e) return '';
  try {
    const d = new Date(e);
    if (!isNaN(d.getTime())) {
      const mm = String(d.getMonth() + 1).padStart(2, '0');
      const dd = String(d.getDate()).padStart(2, '0');
      const yy = String(d.getFullYear()).slice(-2);
      return `${mm}/${dd}/${yy}`;
    }
  } catch (_) {}
  return String(e).slice(0, 10);
}

export default function BestOptionsWidget() {
  const [bestCall, setBestCall] = useState<any>(null);
  const [bestPut, setBestPut] = useState<any>(null);

  useEffect(() => {
    let cancelled = false;
    async function load() {
      try {
        const r = await fetch('/api/options-flow', { cache: 'no-store' });
        if (!r.ok) return;
        const d = await r.json();
        const rows: any[] = Array.isArray(d) ? d : (d.flows || d.rolled || d.data || d.results || []);
        const norm = (f: any) => String(f.OptionType || f.optionType || f.type || '').toLowerCase();
        const val = (f: any) => Number(f.Value || f.value || f.premium || 0);
        const calls = rows.filter(f => norm(f) === 'call').sort((a, b) => val(b) - val(a));
        const puts = rows.filter(f => norm(f) === 'put').sort((a, b) => val(b) - val(a));
        if (!cancelled) {
          setBestCall(calls[0] || null);
          setBestPut(puts[0] || null);
        }
      } catch (_) {}
    }
    load();
    const isOpen = (() => { const et = new Date(new Date().toLocaleString('en-US', { timeZone: 'America/New_York' })); const day = et.getDay(); if (day === 0 || day === 6) return false; const m = et.getHours() * 60 + et.getMinutes(); return m >= 570 && m < 960; })();
    const t = setInterval(load, isOpen ? 20000 : 60000);
    return () => { cancelled = true; clearInterval(t); };
  }, []);

  const renderRow = (o: any, label: 'CALL' | 'PUT', color: string) => (
    <div style={{ marginBottom: label === 'CALL' ? 8 : 0 }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 6, marginBottom: 2 }}>
        <span style={{ color, fontWeight: 700, fontSize: 10, letterSpacing: '0.5px' }}>{label}</span>
        <span style={{ color: '#e0e0e0', fontSize: 11, fontWeight: 600 }}>{o.Symbol || o.symbol || '?'} ${o.Strike || o.strike || '?'}{label === 'CALL' ? 'C' : 'P'}</span>
        <span style={{ color: '#90a4ae', fontSize: 10 }}>{fmtExpiry(o)}</span>
      </div>
      <div style={{ color: '#4fc3f7', fontSize: 10 }}>{fmtMoney(Number(o.Value || o.value || 0))} . {fmtVol(Number(o.Volume || o.volume || 0))} vol</div>
    </div>
  );

  return (
    <div style={{ padding: '10px 16px', borderTop: '1px solid #1a2530' }}>
      <div style={{ color: '#ffd600', fontWeight: 700, marginBottom: 8, fontSize: 11, letterSpacing: '0.5px' }}>BEST OPTIONS OF THE DAY</div>
      {bestCall ? renderRow(bestCall, 'CALL', '#66bb6a') : <div style={{ color: '#607d8b', fontSize: 10, marginBottom: 8 }}>CALL: scanning...</div>}
      {bestPut ? renderRow(bestPut, 'PUT', '#ef5350') : <div style={{ color: '#607d8b', fontSize: 10 }}>PUT: scanning...</div>}
    </div>
  );
}
