'use client';

import React, { useEffect, useMemo, useState } from 'react';

interface StockData {
  ticker: string;
  name: string;
  industry: string;
  exchange: string;
  ipoDate: string;
  website: string;
  description: string;
  regularPrice: number | null;
  regularChange: number | null;
  regularChangePct: number | null;
  postPrice: number | null;
  postChange: number | null;
  postChangePct: number | null;
  open: number | null;
  high: number | null;
  low: number | null;
  prevClose: number | null;
  volume: number | null;
  avgVol: number | null;
  marketCap: number | null;
  pe: number | null;
  eps: number | null;
  wk52High: number | null;
  wk52Low: number | null;
  bookValue: number | null;
  rating: string;
  targetPrice: number | null;
  support: number | null;
  resistance: number | null;
  stopLoss: number | null;
  earnings: { date: string; est: number | null; act: number | null }[];
  nextEarnings: string | null;
}

interface Candles { points: { t: number; c: number }[]; source: string; }

type TF = '1D' | '5D' | '1M' | '3M' | '6M' | '1Y' | '5Y' | 'YTD' | 'MAX';
const TFS: TF[] = ['1D', '5D', '1M', '3M', '6M', '1Y', '5Y', 'YTD', 'MAX'];

const fmtPrice = (n: number | null) => n == null ? '—' : n.toFixed(2);
const fmtMoney = (n: number | null) => {
  if (n == null) return '—';
  if (n >= 1e12) return `${(n / 1e12).toFixed(2)}T`;
  if (n >= 1e9)  return `${(n / 1e9).toFixed(2)}B`;
  if (n >= 1e6)  return `${(n / 1e6).toFixed(2)}M`;
  if (n >= 1e3)  return `${(n / 1e3).toFixed(2)}K`;
  return n.toFixed(0);
};
const fmtPct = (n: number | null) => n == null ? '—' : `${n >= 0 ? '' : ''}${n.toFixed(2)}%`;

export const StockDetailDrawer: React.FC<{ ticker: string | null; onClose: () => void }> = ({ ticker, onClose }) => {
  const [data, setData] = useState<StockData | null>(null);
  const [chartMode, setChartMode] = useState<'candle' | 'line'>('candle');
  const [taMode, setTaMode] = useState<'basic' | 'advanced'>('basic');
  const [candles, setCandles] = useState<Candles | null>(null);
  const [tf, setTf] = useState<TF>('1D');
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (!ticker) { setData(null); setCandles(null); return; }
    setLoading(true);
    let cancelled = false;
    fetch(`/api/stock/${ticker}`)
      .then(r => r.ok ? r.json() : Promise.reject(new Error(`HTTP ${r.status}`)))
      .then(d => { if (!cancelled) { setData(d); setLoading(false); } })
      .catch(() => { if (!cancelled) setLoading(false); });
    return () => { cancelled = true; };
  }, [ticker]);

  useEffect(() => {
    if (!ticker) return;
    let cancelled = false;
    const load = () => {
      fetch(`/api/stock/${ticker}/candles?tf=${tf}`)
        .then(r => r.ok ? r.json() : Promise.reject(new Error(`HTTP ${r.status}`)))
        .then(c => { if (!cancelled) setCandles(c); })
        .catch(() => {});
    };
    load();
    // Poll every 60s for 1D; longer TFs don't need polling
    const id = tf === '1D' ? setInterval(load, 60_000) : null;
    return () => { cancelled = true; if (id) clearInterval(id); };
  }, [ticker, tf]);

  useEffect(() => {
    if (!ticker) return;
    const onKey = (e: KeyboardEvent) => { if (e.key === 'Escape') onClose(); };
    document.addEventListener('keydown', onKey);
    return () => document.removeEventListener('keydown', onKey);
  }, [ticker, onClose]);

  if (!ticker) return null;

  return (
    <>
      <div onClick={onClose} style={{
        position: 'fixed', inset: 0, background: '#000000aa', zIndex: 999,
        animation: 'stockFade 0.15s ease-out',
      }}/>
      <div style={{
        position: 'fixed', top: 0, right: 0, bottom: 0,
        width: '560px', background: '#000', borderLeft: '1px solid #1a2332',
        boxShadow: '-8px 0 32px rgba(0,0,0,0.6)', zIndex: 1000, overflowY: 'auto',
        fontFamily: 'ui-monospace, "SF Mono", Menlo, monospace',
        color: '#e4e4e4', fontSize: '13px',
        animation: 'stockSlide 0.2s ease-out',
      }}>
        <style>{`
          @keyframes stockFade { from { opacity: 0; } to { opacity: 1; } }
          @keyframes stockSlide { from { transform: translateX(100%); } to { transform: translateX(0); } }
        `}</style>

        {/* Header */}
        <div style={{
          padding: '14px 16px', display: 'flex', alignItems: 'center',
          justifyContent: 'space-between', position: 'sticky', top: 0,
          background: '#000', zIndex: 2, borderBottom: '1px solid #0a1220',
        }}>
          <button onClick={onClose} style={{
            background: 'none', border: 'none', color: '#66bb6a',
            cursor: 'pointer', fontSize: '14px', padding: 0,
          }}>← Live Flows</button>
          <span style={{ color: '#fff', fontSize: '18px', fontWeight: 700, letterSpacing: '0.5px' }}>{ticker}</span>
          <span style={{ color: '#66bb6a', fontSize: '20px', cursor: 'pointer' }}>☆</span>
        </div>

        {loading && !data && <div style={{ padding: '40px 20px', textAlign: 'center', color: '#607d8b' }}>Loading {ticker}...</div>}

        {data && (
          <div style={{ padding: '16px' }}>
            {/* Company name */}
            <div style={{ color: '#fff', fontSize: '15px', marginBottom: '10px' }}>{data.name}</div>

            {/* Dual price header */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '16px', marginBottom: '14px' }}>
              <div>
                <div style={{ display: 'flex', alignItems: 'baseline', gap: '8px' }}>
                  <span style={{ fontSize: '28px', fontWeight: 700, color: '#fff' }}>{fmtPrice(data.regularPrice)}</span>
                  <span style={{ fontSize: '12px', fontWeight: 600,
                    color: (data.regularChangePct ?? 0) >= 0 ? '#66bb6a' : '#ef5350' }}>
                    {(data.regularChangePct ?? 0) >= 0 ? '' : ''}{fmtPct(data.regularChangePct)}
                  </span>
                </div>
                <div style={{ color: '#90a4ae', fontSize: '11px', marginTop: '2px' }}>At Close</div>
              </div>
              {data.postPrice != null && (
                <div>
                  <div style={{ display: 'flex', alignItems: 'baseline', gap: '8px' }}>
                    <span style={{ fontSize: '28px', fontWeight: 700, color: '#fff' }}>{fmtPrice(data.postPrice)}</span>
                    <span style={{ fontSize: '12px', fontWeight: 600,
                      color: (data.postChangePct ?? 0) >= 0 ? '#66bb6a' : '#ef5350' }}>
                      {fmtPct(data.postChangePct)}
                    </span>
                  </div>
                  <div style={{ color: '#90a4ae', fontSize: '11px', marginTop: '2px' }}>After Hours</div>
                </div>
              )}
            </div>

            {/* Price chart */}
            <PriceChart candles={candles} bullish={(data.regularChangePct ?? 0) >= 0} mode={chartMode} tf={tf} />

            {/* Timeframe selector */}
            <div style={{ display: 'flex', gap: '4px', marginBottom: '18px', justifyContent: 'space-between' }}>
              {TFS.map(t => (
                <button key={t} onClick={() => setTf(t)} style={{
                  flex: 1, padding: '5px 0', fontSize: '11px', cursor: 'pointer',
                  background: tf === t ? '#66bb6a' : 'transparent',
                  color: tf === t ? '#000' : '#66bb6a',
                  border: tf === t ? '1px solid #66bb6a' : '1px solid transparent',
                  borderRadius: '3px', fontWeight: 600, fontFamily: 'inherit',
                }}>{t}</button>
              ))}
            </div>


            {/* Stats */}
            
            {/* CHART_MODE_BTN_INJECT */}
      {candles && candles.points.length > 3 && (
        <div style={{ display: 'flex', justifyContent: 'flex-end', margin: '4px 0 0' }}>
          <button onClick={() => setChartMode(m => m === 'candle' ? 'line' : 'candle')}
            title={`Switch to ${chartMode === 'candle' ? 'line' : 'candle'} chart`}
            style={{
              display: 'flex', alignItems: 'center', gap: '5px',
              padding: '3px 8px', fontSize: '9px', fontWeight: 700, letterSpacing: '1px',
              background: '#1a3a4a', color: '#4fc3f7',
              border: '1px solid #4fc3f744', borderRadius: '4px',
              cursor: 'pointer', fontFamily: 'inherit',
            }}>
            {chartMode === 'candle' ? '📊 CANDLE' : '📈 LINE'}
          </button>
        </div>
      )}
      
      {/* TA_INJECT Technical Analysis */}
      {ticker && data && candles && (
        <div style={{ margin: '16px 0', padding: '12px', background: '#0d1420', border: '1px solid #1a2332', borderRadius: '6px' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '10px' }}>
            <div style={{ fontSize: '11px', fontWeight: 700, color: '#e0e0e0', letterSpacing: '2px' }}>TECHNICAL ANALYSIS</div>
            <div style={{ display: 'flex', gap: '2px', background: '#0a1115', padding: '2px', borderRadius: '4px', border: '1px solid #1a2332' }}>
              <button onClick={() => setTaMode('basic')} style={{
                padding: '3px 10px', fontSize: '9px', fontWeight: 700, letterSpacing: '1px',
                background: taMode === 'basic' ? '#1a3a4a' : 'transparent',
                color: taMode === 'basic' ? '#4fc3f7' : '#607d8b',
                border: 'none', borderRadius: '3px', cursor: 'pointer', fontFamily: 'inherit',
              }}>BASIC</button>
              <button onClick={() => setTaMode('advanced')} style={{
                padding: '3px 10px', fontSize: '9px', fontWeight: 700, letterSpacing: '1px',
                background: taMode === 'advanced' ? '#1a3a4a' : 'transparent',
                color: taMode === 'advanced' ? '#4fc3f7' : '#607d8b',
                border: 'none', borderRadius: '3px', cursor: 'pointer', fontFamily: 'inherit',
              }}>ADVANCED</button>
            </div>
          </div>
          <TechnicalAnalysis candles={candles} mode={taMode} regularPrice={data.regularPrice} />
        </div>
      )}

      <SectionTitle>Stats</SectionTitle>
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', columnGap: '20px', rowGap: '8px', marginBottom: '20px' }}>
              <StatPair label="Open"       value={fmtPrice(data.open)} />
              <StatPair label="Volume"     value={fmtMoney(data.volume)} />
              <StatPair label="High"       value={fmtPrice(data.high)} />
              <StatPair label="Avg Vol"    value={fmtMoney(data.avgVol)} />
              <StatPair label="Low"        value={fmtPrice(data.low)} />
              <StatPair label="Mkt Cap"    value={fmtMoney(data.marketCap)} />
              <StatPair label="Prev Close" value={fmtPrice(data.prevClose)} />
              <StatPair label="PE Ratio"   value={data.pe != null ? data.pe.toFixed(2) : '—'} />
              <StatPair label="52wk High"  value={fmtPrice(data.wk52High)} />
              <StatPair label="Book Value" value={data.bookValue != null ? data.bookValue.toFixed(2) : '—'} />
              <StatPair label="52wk Low"   value={fmtPrice(data.wk52Low)} />
              <StatPair label="EPS"        value={data.eps != null ? data.eps.toFixed(2) : '—'} />
            </div>

            {/* Earnings scatter */}
            {data.earnings.length > 0 && (
              <>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: '6px' }}>
                  <SectionTitle inline>Earnings</SectionTitle>
                  {data.nextEarnings && (
                    <span style={{ color: '#90a4ae', fontSize: '11px' }}>
                      Next in: <span style={{ color: '#fff' }}>{nextInLabel(data.nextEarnings)}</span>
                    </span>
                  )}
                </div>
                <EarningsChart data={data.earnings} />
              </>
            )}

            {/* About */}
            {(data.description || data.industry) && (
              <>
                <SectionTitle>About Company</SectionTitle>
                {data.description && (
                  <div style={{ color: '#b0bec5', fontSize: '12px', lineHeight: 1.55, marginBottom: '8px' }}>
                    {data.description}
                  </div>
                )}
                <div style={{ color: '#90a4ae', fontSize: '11px', lineHeight: 1.6 }}>
                  {data.exchange  && <div><span style={{ color: '#607d8b' }}>Exchange:</span> {data.exchange}</div>}
                  {data.industry  && <div><span style={{ color: '#607d8b' }}>Industry:</span> {data.industry}</div>}
                  {data.ipoDate   && <div><span style={{ color: '#607d8b' }}>IPO:</span> {data.ipoDate}</div>}
                  {data.website && (
                    <div style={{ marginTop: '4px' }}>
                      <a href={data.website} target="_blank" rel="noreferrer" style={{ color: '#4fc3f7' }}>
                        {data.website.replace(/^https?:\/\//, '').replace(/\/$/, '')}
                      </a>
                    </div>
                  )}
                </div>
              </>
            )}
          </div>
        )}
      </div>
    </>
  );
};

// -- Subcomponents --

const SectionTitle: React.FC<{ children: React.ReactNode; inline?: boolean }> = ({ children, inline }) => (
  <div style={{
    color: '#fff', fontSize: '16px', fontWeight: 600, marginTop: inline ? 0 : '16px',
    marginBottom: inline ? 0 : '10px',
  }}>{children}</div>
);

const StatPair: React.FC<{ label: string; value: string; color?: string }> = ({ label, value, color }) => (
  <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '13px' }}>
    <span style={{ color: '#90a4ae' }}>{label}</span>
    <span style={{ color: color || '#fff', fontWeight: 500 }}>{value}</span>
  </div>
);

const PriceChart: React.FC<{ candles: Candles | null; bullish: boolean; mode?: 'candle' | 'line'; tf?: string }> = ({ candles, bullish, mode = 'line', tf = '1M' }) => {
  // CANDLE_MODE_INJECT
  if (mode === 'candle' && candles && candles.points.length > 3) {
    const pts = candles.points;
    const groupSize = Math.max(1, Math.floor(pts.length / 50));
    const ohlc: {o:number;h:number;l:number;c:number;t:number}[] = [];
    for (let i = 0; i < pts.length; i += groupSize) {
      const chunk = pts.slice(i, i + groupSize);
      if (chunk.length === 0) continue;
      const cl = chunk.map(pt => pt.c);
      ohlc.push({ o: cl[0], c: cl[cl.length - 1], h: Math.max(...cl), l: Math.min(...cl), t: chunk[0].t });
    }
    const allCloses = pts.map(pt => pt.c);
    const recent = allCloses.slice(-60);
    const support = Math.min(...recent);
    const resistance = Math.max(...recent);
    const currentPrice = allCloses[allCloses.length - 1];
    const ma = (period: number) => {
      if (allCloses.length < period) return null;
      const out: (number | null)[] = [];
      for (let i = 0; i < allCloses.length; i++) {
        if (i < period - 1) { out.push(null); continue; }
        const sl = allCloses.slice(i - period + 1, i + 1);
        out.push(sl.reduce((a,b) => a+b, 0) / period);
      }
      return out;
    };
    const ma50arr = ma(Math.min(50, Math.floor(allCloses.length / 2)));
    const ma200arr = ma(Math.min(200, Math.floor(allCloses.length / 1.2)));
    const maLast = (arr: (number | null)[] | null): number | null => {
      if (!arr) return null;
      for (let i = arr.length - 1; i >= 0; i--) if (arr[i] != null) return arr[i]!;
      return null;
    };
    const ma50Val = maLast(ma50arr);
    const ma200Val = maLast(ma200arr);
    const allVals = [...ohlc.flatMap(c => [c.h, c.l]), support, resistance, currentPrice];
    if (ma50Val != null) allVals.push(ma50Val);
    if (ma200Val != null) allVals.push(ma200Val);
    const min = Math.min(...allVals);
    const max = Math.max(...allVals);
    const range = max - min || 1;
    const W = 720, H = 340, PAD = 4, AXIS_H = 18;
    const CHART_W = 600;
    const cw = (CHART_W - PAD*2) / ohlc.length;
    const scaleY = (v: number) => (H - AXIS_H) - ((v - min) / range) * ((H - AXIS_H) - 14) - 7;
    const maToPath = (arr: (number | null)[] | null): string => {
      if (!arr) return '';
      const step = (CHART_W - PAD*2) / arr.length;
      const parts: string[] = [];
      for (let i = 0; i < arr.length; i++) {
        const v = arr[i];
        if (v == null) continue;
        const x = PAD + i * step;
        const y = scaleY(v);
        parts.push(parts.length === 0 ? `M${x.toFixed(1)} ${y.toFixed(1)}` : `L${x.toFixed(1)} ${y.toFixed(1)}`);
      }
      return parts.join(' ');
    };
    type Pill = { y: number; color: string; text: string; w: number; bold?: boolean };
    const pills: Pill[] = [];
    pills.push({ y: scaleY(currentPrice), color: '#e0e0e0', text: `$${currentPrice.toFixed(2)}`, w: 54, bold: true });
    pills.push({ y: scaleY(resistance), color: '#ff9800', text: `RESIST $${resistance.toFixed(2)}`, w: 100 });
    pills.push({ y: scaleY(support), color: '#66bb6a', text: `SUPPORT $${support.toFixed(2)}`, w: 100 });
    if (ma50Val != null) pills.push({ y: scaleY(ma50Val), color: '#4fc3f7', text: `50MA ${ma50Val.toFixed(2)}`, w: 78 });
    if (ma200Val != null) pills.push({ y: scaleY(ma200Val), color: '#ce93d8', text: `200MA ${ma200Val.toFixed(2)}`, w: 86 });
    pills.sort((a, b) => a.y - b.y);
    const MIN_GAP = 14;
    for (let i = 1; i < pills.length; i++) {
      if (pills[i].y - pills[i-1].y < MIN_GAP) pills[i].y = pills[i-1].y + MIN_GAP;
    }
    return (
      <svg viewBox={`0 0 ${W} ${H}`} preserveAspectRatio="none" style={{ width: '100%', height: '340px', overflow: 'visible' }}>
        <defs>
          <filter id="maGlow" x="-20%" y="-20%" width="140%" height="140%">
            <feGaussianBlur stdDeviation="3.5" result="blur" />
            <feMerge><feMergeNode in="blur"/><feMergeNode in="SourceGraphic"/></feMerge>
          </filter>
          <linearGradient id="supportGrad" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#66bb6a" stopOpacity="0.14" />
            <stop offset="100%" stopColor="#66bb6a" stopOpacity="0" />
          </linearGradient>
          <linearGradient id="resistanceGrad" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#ff9800" stopOpacity="0" />
            <stop offset="100%" stopColor="#ff9800" stopOpacity="0.14" />
          </linearGradient>
          <clipPath id="chartClip">
            <rect x="0" y="0" width={CHART_W} height={H - AXIS_H} />
          </clipPath>
        </defs>
        {[0.2, 0.4, 0.6, 0.8].map((pct, i) => {
              const gy = 7 + pct * ((H - AXIS_H) - 14);
              const priceAtGy = (typeof max === 'number' && typeof min === 'number') ? (max - pct * (max - min)) : null;
              return (
                <g key={i}>
                  <line x1={PAD} x2={CHART_W - PAD} y1={gy} y2={gy} stroke="#2a3442" strokeWidth="0.6" strokeDasharray="2 4" opacity="0.7" />
                  {priceAtGy != null && (
                    <text x={PAD - 3} y={gy + 3} textAnchor="end" fontSize="8" fill="#8a9aab" fontFamily="var(--font-mc-mono)">${priceAtGy.toFixed(2)}</text>
                  )}
                </g>
              );
            })}
        <rect x={PAD} y={scaleY(resistance)} width={CHART_W - PAD*2} height={10} fill="url(#resistanceGrad)" />
        <rect x={PAD} y={scaleY(support) - 10} width={CHART_W - PAD*2} height={10} fill="url(#supportGrad)" />
        <line x1={PAD} x2={CHART_W - PAD} y1={scaleY(support)} y2={scaleY(support)} stroke="#66bb6a" strokeWidth="1" strokeDasharray="4 3" opacity="0.9" />
        <line x1={PAD} x2={CHART_W - PAD} y1={scaleY(resistance)} y2={scaleY(resistance)} stroke="#ff9800" strokeWidth="1" strokeDasharray="4 3" opacity="0.9" />
        <line x1={PAD} x2={CHART_W - PAD} y1={scaleY(currentPrice)} y2={scaleY(currentPrice)} stroke="#e0e0e0" strokeWidth="0.5" strokeDasharray="1 3" opacity="0.35" />
        <g clipPath="url(#chartClip)">
          {ohlc.map((c, i) => {
            const x = PAD + i * cw + cw / 2;
            const up = c.c >= c.o;
            const color = up ? '#66bb6a' : '#ef5350';
            const bodyTop = scaleY(Math.max(c.o, c.c));
            const bodyBot = scaleY(Math.min(c.o, c.c));
            const bodyH = Math.max(2, bodyBot - bodyTop);
            const bodyW = Math.max(2, Math.min(cw * 0.7, 9));
            return (
              <g key={i}>
                <line x1={x} x2={x} y1={scaleY(c.h)} y2={scaleY(c.l)} stroke={color} strokeWidth="1" />
                <rect x={x - bodyW/2} y={bodyTop} width={bodyW} height={bodyH} fill={color} />
              </g>
            );
          })}
          {ma50arr && (
            <>
              <path d={maToPath(ma50arr)} fill="none" stroke="#4fc3f7" strokeWidth="2" opacity="1" filter="url(#maGlow)" />
            </>
          )}
          {ma200arr && (
            <>
              <path d={maToPath(ma200arr)} fill="none" stroke="#ce93d8" strokeWidth="2" opacity="1" filter="url(#maGlow)" />
            </>
          )}
        </g>
        {/* Y-axis price ticks */}
        {[0.1, 0.3, 0.5, 0.7, 0.9].map((pct, i) => {
          const price = max - pct * range;
          const y = 7 + pct * ((H - AXIS_H) - 14);
          return (
            <text key={`yt${i}`} x={PAD + 3} y={y - 2} textAnchor="start" fontSize="9" fill="#e0e0e0" fontFamily="var(--font-mc-mono)" opacity="1" fontWeight="600">
              {price >= 1000 ? price.toFixed(0) : price.toFixed(2)}
            </text>
          );
        })}
        {/* X-axis date labels — tf-aware format */}
        {(() => {
          const tickCount = 6;
          const toMs = (t: any): number | null => {
            if (t == null) return null;
            if (typeof t === 'number') return t < 1e12 ? t * 1000 : t;
            const v = new Date(t).getTime(); return isNaN(v) ? null : v;
          };
          const fmtForTf = (d: Date): string => {
            const mo = d.getMonth()+1, da = d.getDate(), yr = String(d.getFullYear()).slice(2);
            const h = d.getHours(), mn = d.getMinutes();
            const hh12 = ((h + 11) % 12) + 1;
            const ampm = h < 12 ? 'a' : 'p';
            if (tf === '1D') return `${hh12}:${mn.toString().padStart(2,'0')}${ampm}`;
            if (tf === '5D') return `${mo}/${da} ${hh12}${ampm}`;
            if (tf === '1M' || tf === '3M' || tf === '6M' || tf === 'YTD') return `${mo}/${da}`;
            return `${mo}/${yr}`;
          };
          return Array.from({length: tickCount}).map((_, idx) => {
            const dataIdx = Math.floor((ohlc.length - 1) * idx / (tickCount - 1));
            const c: any = ohlc[dataIdx];
            const x = PAD + dataIdx * cw + cw / 2;
            const ms = toMs(c?.t);
            const label = ms != null ? fmtForTf(new Date(ms)) : '';
            return (
              <text key={`xt${idx}`} x={x} y={H - 5} textAnchor="middle" fontSize="9" fill="#e0e0e0" fontFamily="var(--font-mc-mono)" opacity="1" fontWeight="600">
                {label}
              </text>
            );
          });
        })()}
        <line x1={CHART_W} x2={CHART_W} y1="0" y2={H - AXIS_H} stroke="#1a2332" strokeWidth="0.5" opacity="0.5" />
        {pills.map((pl, i) => (
          <g key={i} transform={`translate(${CHART_W + 3}, ${pl.y - 6.5})`}>
            <rect width={pl.w} height="13" rx="2" fill={pl.color} opacity="0.95" />
            <text x={pl.w/2} y="9.5" textAnchor="middle" fontSize="8" fontWeight={pl.bold ? "800" : "700"} fill="#0a1115">{pl.text}</text>
          </g>
        ))}
      </svg>
    );
  }

  const stroke = bullish ? '#66bb6a' : '#ef5350';
  if (!candles || candles.points.length < 2) {
    return (
      <div style={{ height: '120px', display: 'flex', alignItems: 'center',
        justifyContent: 'center', color: '#607d8b', fontSize: '12px',
        border: '1px solid #0a1220', borderRadius: '4px', marginBottom: '10px' }}>
        {candles === null ? 'Loading chart…' : 'No data'}
      </div>
    );
  }
  const pts = candles.points;
  const w = 408, h = 120, padY = 6;
  const prices = pts.map(p => p.c);
  const pMin = Math.min(...prices), pMax = Math.max(...prices);
  const range = pMax - pMin || 1;
  const poly = pts.map((p, i) => {
    const x = (i / (pts.length - 1)) * w;
    const y = padY + (h - padY * 2) * (1 - (p.c - pMin) / range);
    return `${x.toFixed(1)},${y.toFixed(1)}`;
  }).join(' ');
  return (
    <div style={{ marginBottom: '10px' }}>
      <svg width="100%" viewBox={`0 0 ${w} ${h}`} preserveAspectRatio="none" style={{ display: 'block' }}>
        <polyline points={poly} fill="none" stroke={stroke} strokeWidth="1.5" />
      </svg>
    </div>
  );
};

const EarningsChart: React.FC<{ data: { date: string; est: number | null; act: number | null }[] }> = ({ data }) => {
  // Use last 10 quarters, oldest-left to newest-right
  const recent = data.slice(0, 10).reverse();
  const allVals = recent.flatMap(d => [d.est, d.act]).filter((v): v is number => v != null);
  if (allVals.length === 0) return null;
  const min = Math.min(...allVals), max = Math.max(...allVals);
  const range = max - min || 1;
  const pad = range * 0.15;
  const yMin = min - pad, yMax = max + pad;

  const w = 408, h = 180;
  const chartH = 150, labelH = 30;
  const leftPad = 30, rightPad = 10;
  const chartW = w - leftPad - rightPad;

  const xFor = (i: number) => leftPad + (recent.length === 1 ? chartW / 2 : (i / (recent.length - 1)) * chartW);
  const yFor = (v: number) => ((yMax - v) / (yMax - yMin)) * chartH;

  const quarterLabel = (dateStr: string) => {
    const d = new Date(dateStr);
    if (isNaN(d.getTime())) return dateStr.slice(0, 7);
    const q = Math.floor(d.getMonth() / 3) + 1;
    return `${q}Q ${String(d.getFullYear()).slice(2)}`;
  };

  // Y-axis tick labels (5 steps)
  const ticks = 5;
  const tickVals = Array.from({ length: ticks + 1 }, (_, i) => yMin + (yMax - yMin) * (1 - i / ticks));

  return (
    <div style={{ marginBottom: '20px' }}>
      <div style={{ display: 'flex', gap: '14px', fontSize: '11px', color: '#90a4ae', marginBottom: '4px' }}>
        <span><span style={{ color: '#2e7d32', fontSize: '14px' }}>■</span> Est</span>
        <span><span style={{ color: '#66bb6a', fontSize: '14px' }}>■</span> Act</span>
      </div>
      <svg width="100%" viewBox={`0 0 ${w} ${h}`} preserveAspectRatio="none" style={{ display: 'block' }}>
        {tickVals.map((v, i) => (
          <g key={i}>
            <text x={leftPad - 5} y={yFor(v) + 3} fontSize="10" fill="#607d8b" textAnchor="end" fontFamily="inherit">{v.toFixed(2)}</text>
            <line x1={leftPad} y1={yFor(v)} x2={w - rightPad} y2={yFor(v)} stroke="#0a1220" strokeWidth="0.5"/>
          </g>
        ))}
        {recent.map((d, i) => {
          const x = xFor(i);
          return (
            <g key={i}>
              {d.est != null && <circle cx={x - 5} cy={yFor(d.est)} r="5" fill="#2e7d32" />}
              {d.act != null && <circle cx={x + 5} cy={yFor(d.act)} r="5" fill="#66bb6a" />}
              <text x={x} y={chartH + 18} fontSize="10" fill="#90a4ae" textAnchor="middle" fontFamily="inherit">{quarterLabel(d.date)}</text>
            </g>
          );
        })}
      </svg>
    </div>
  );
};

function nextInLabel(dateStr: string): string {
  const d = new Date(dateStr);
  if (isNaN(d.getTime())) return dateStr;
  const days = Math.round((d.getTime() - Date.now()) / 86400000);
  const mm = d.toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
  if (days < 0)  return mm;
  if (days === 0) return `Today (${mm})`;
  if (days === 1) return `1 Day (${mm})`;
  return `${days} Days (${mm})`;
}


function TechnicalAnalysis({ candles, mode, regularPrice }: {
  candles: Candles | null;
  mode: 'basic' | 'advanced';
  regularPrice: number | null;
}) {
  if (!candles || candles.points.length < 20) {
    return <div style={{ color: '#607d8b', fontSize: '11px', textAlign: 'center', padding: '12px' }}>Insufficient data for analysis</div>;
  }
  const closes = candles.points.map(p => p.c);
  const n = closes.length;
  const price = regularPrice ?? closes[n-1];

  const simpleMa = (arr: number[], period: number): number | null => {
    if (arr.length < period) return null;
    const slice = arr.slice(-period);
    return slice.reduce((a,b) => a+b, 0) / period;
  };
  const ma50 = simpleMa(closes, Math.min(50, Math.floor(n/2)));
  const ma200 = simpleMa(closes, Math.min(200, Math.floor(n/1.2)));

  const recent = closes.slice(-60);
  const support = Math.min(...recent);
  const resistance = Math.max(...recent);

  let rsi: number | null = null;
  if (n >= 15) {
    let gains = 0, losses = 0;
    for (let i = n-14; i < n; i++) {
      const diff = closes[i] - closes[i-1];
      if (diff > 0) gains += diff; else losses += Math.abs(diff);
    }
    const avgGain = gains / 14, avgLoss = losses / 14;
    const rs = avgLoss === 0 ? 100 : avgGain / avgLoss;
    rsi = 100 - (100 / (1 + rs));
  }

  let trend: 'UPTREND' | 'DOWNTREND' | 'RANGE' | '—' = '—';
  if (ma50 && ma200) {
    const diff = ((ma50 - ma200) / ma200) * 100;
    if (diff > 2) trend = 'UPTREND';
    else if (diff < -2) trend = 'DOWNTREND';
    else trend = 'RANGE';
  }

  let rating: 'BUY' | 'SELL' | 'HOLD' = 'HOLD';
  if (ma50 && ma200) {
    if (price > ma50 && ma50 > ma200) rating = 'BUY';
    else if (price < ma50 && ma50 < ma200) rating = 'SELL';
  }
  const ratingColor = rating === 'BUY' ? '#66bb6a' : rating === 'SELL' ? '#ef5350' : '#ff9800';
  const targetPrice = resistance * 1.02;
  const stopLoss = support * 0.98;

  let macdHist: number | null = null;
  let bbPos: string = '—';
  let atr: number | null = null;
  let volTrend: string = '—';
  let pattern: string = '—';
  let rr: number | null = null;
  let score: number = 0;
  let action: 'STRONG BUY' | 'BUY' | 'HOLD' | 'SELL' | 'STRONG SELL' = 'HOLD';

  if (mode === 'advanced') {
    const ema = (arr: number[], period: number): number[] => {
      const k = 2 / (period + 1);
      const out: number[] = [];
      let prev = arr[0];
      for (let i = 0; i < arr.length; i++) {
        const val = i === 0 ? arr[0] : arr[i] * k + prev * (1 - k);
        out.push(val);
        prev = val;
      }
      return out;
    };
    if (n >= 35) {
      const ema12 = ema(closes, 12);
      const ema26 = ema(closes, 26);
      const macdArr = ema12.map((v, i) => v - ema26[i]);
      const signalArr = ema(macdArr.slice(26), 9);
      const macdLine = macdArr[n-1];
      const macdSignal = signalArr[signalArr.length-1];
      macdHist = macdLine - macdSignal;
    }
    if (n >= 20) {
      const last20 = closes.slice(-20);
      const bbMid = last20.reduce((a,b) => a+b, 0) / 20;
      const variance = last20.reduce((a,b) => a + (b - bbMid) ** 2, 0) / 20;
      const std = Math.sqrt(variance);
      const bbUpper = bbMid + 2 * std;
      const bbLower = bbMid - 2 * std;
      if (price > bbUpper) bbPos = 'ABOVE UPPER';
      else if (price < bbLower) bbPos = 'BELOW LOWER';
      else if (price > bbMid) bbPos = 'UPPER HALF';
      else bbPos = 'LOWER HALF';
    }
    if (n >= 15) {
      let sum = 0;
      for (let i = n-14; i < n; i++) {
        sum += Math.abs(closes[i] - closes[i-1]);
      }
      atr = sum / 14;
    }
    if (n >= 40) {
      const recentVol = closes.slice(-20).reduce((a,b,i,arr) => i === 0 ? 0 : a + Math.abs(b - arr[i-1]), 0);
      const oldVol = closes.slice(-40, -20).reduce((a,b,i,arr) => i === 0 ? 0 : a + Math.abs(b - arr[i-1]), 0);
      if (recentVol > oldVol * 1.3) volTrend = 'RISING';
      else if (recentVol < oldVol * 0.7) volTrend = 'FALLING';
      else volTrend = 'STABLE';
    }
    if (n >= 3) {
      const a = closes[n-3], b = closes[n-2], c = closes[n-1];
      const chg1 = (b - a) / a;
      const chg2 = (c - b) / b;
      if (chg1 < -0.02 && chg2 > 0.02) pattern = 'BULLISH REVERSAL';
      else if (chg1 > 0.02 && chg2 < -0.02) pattern = 'BEARISH REVERSAL';
      else if (Math.abs(chg1) < 0.005 && Math.abs(chg2) < 0.005) pattern = 'DOJI/INDECISION';
      else if (chg1 > 0.01 && chg2 > 0.01) pattern = 'BULLISH MOMENTUM';
      else if (chg1 < -0.01 && chg2 < -0.01) pattern = 'BEARISH MOMENTUM';
      else pattern = 'NEUTRAL';
    }
    if (price > stopLoss) {
      rr = (targetPrice - price) / (price - stopLoss);
    }
    let bullCount = 0, bearCount = 0, totalChecks = 0;
    if (ma50 && ma200) {
      totalChecks++;
      if (price > ma50 && ma50 > ma200) bullCount++;
      else if (price < ma50 && ma50 < ma200) bearCount++;
    }
    if (rsi != null) {
      totalChecks++;
      if (rsi < 30) bullCount++;
      else if (rsi > 70) bearCount++;
    }
    if (macdHist != null) {
      totalChecks++;
      if (macdHist > 0) bullCount++;
      else bearCount++;
    }
    if (bbPos === 'BELOW LOWER') { totalChecks++; bullCount++; }
    else if (bbPos === 'ABOVE UPPER') { totalChecks++; bearCount++; }
    if (pattern.includes('BULLISH')) { totalChecks++; bullCount++; }
    else if (pattern.includes('BEARISH')) { totalChecks++; bearCount++; }
    score = totalChecks > 0 ? Math.round((bullCount / totalChecks) * 100) : 50;
    if (score >= 75) action = 'STRONG BUY';
    else if (score >= 55) action = 'BUY';
    else if (score >= 45) action = 'HOLD';
    else if (score >= 25) action = 'SELL';
    else action = 'STRONG SELL';
  }

  const row = (label: string, value: string, color?: string) => (
    <div style={{ display: 'flex', justifyContent: 'space-between', padding: '4px 0' }}>
      <span style={{ color: '#607d8b', fontSize: '10px' }}>{label}</span>
      <span style={{ color: color || '#e0e0e0', fontSize: '10px', fontWeight: 600 }}>{value}</span>
    </div>
  );

  return (
    <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '12px' }}>
      <div>
        {row('Rating', rating, ratingColor)}
        {row('Target Price', `$${targetPrice.toFixed(2)}`)}
        {row('Support', `$${support.toFixed(2)}`, '#66bb6a')}
        {row('Stop Loss', `$${stopLoss.toFixed(2)}`, '#ef5350')}
        {row('Resistance', `$${resistance.toFixed(2)}`, '#ff9800')}
        {row('50-MA', ma50 ? `$${ma50.toFixed(2)}` : '—')}
        {row('200-MA', ma200 ? `$${ma200.toFixed(2)}` : '—')}
        {row('RSI(14)', rsi != null ? rsi.toFixed(1) : '—', rsi != null ? (rsi > 70 ? '#ef5350' : rsi < 30 ? '#66bb6a' : '#e0e0e0') : '#607d8b')}
        {row('Trend', trend, trend === 'UPTREND' ? '#66bb6a' : trend === 'DOWNTREND' ? '#ef5350' : trend === 'RANGE' ? '#ff9800' : '#607d8b')}
      </div>
      {mode === 'advanced' ? (
        <div>
          {row('MACD Hist', macdHist != null ? macdHist.toFixed(3) : '—', macdHist != null ? (macdHist >= 0 ? '#66bb6a' : '#ef5350') : '#607d8b')}
          {row('BB Position', bbPos, bbPos === 'BELOW LOWER' ? '#66bb6a' : bbPos === 'ABOVE UPPER' ? '#ef5350' : '#e0e0e0')}
          {row('ATR(14)', atr != null ? `$${atr.toFixed(2)}` : '—')}
          {row('Volume Trend', volTrend, volTrend === 'RISING' ? '#66bb6a' : volTrend === 'FALLING' ? '#ef5350' : '#607d8b')}
          {row('Pattern', pattern, pattern.includes('BULLISH') ? '#66bb6a' : pattern.includes('BEARISH') ? '#ef5350' : '#e0e0e0')}
          {row('Risk/Reward', rr != null ? `${rr.toFixed(2)}:1` : '—', rr != null && rr >= 2 ? '#66bb6a' : rr != null && rr < 1 ? '#ef5350' : '#e0e0e0')}
          {row('Signal Score', `${score}/100`, score >= 60 ? '#66bb6a' : score <= 40 ? '#ef5350' : '#ff9800')}
          <div style={{ marginTop: '8px', padding: '6px 8px', background: action.includes('BUY') ? '#0d2a0d' : action.includes('SELL') ? '#2a0d0d' : '#1a2a2a', border: `1px solid ${action.includes('BUY') ? '#66bb6a44' : action.includes('SELL') ? '#ef535044' : '#ff980044'}`, borderRadius: '4px', textAlign: 'center' }}>
            <div style={{ fontSize: '9px', color: '#607d8b', letterSpacing: '1.5px', marginBottom: '2px' }}>ACTION</div>
            <div style={{ fontSize: '13px', fontWeight: 800, color: action.includes('BUY') ? '#66bb6a' : action.includes('SELL') ? '#ef5350' : '#ff9800', letterSpacing: '1px' }}>{action}</div>
          </div>
        </div>
      ) : (
        (() => {
          const toRes = resistance > 0 ? ((resistance - price) / price) * 100 : 0;
          const toSup = support > 0 ? ((support - price) / price) * 100 : 0;
          const toMa50 = ma50 && ma50 > 0 ? ((ma50 - price) / price) * 100 : null;
          const toMa200 = ma200 && ma200 > 0 ? ((ma200 - price) / price) * 100 : null;
          const basicRow = (label: string, value: string, color?: string) => (
            <div style={{ display: 'flex', justifyContent: 'space-between', padding: '3px 0', fontSize: '10px' }}>
              <span style={{ color: '#607d8b' }}>{label}</span>
              <span style={{ color: color || '#e0e0e0', fontWeight: 600 }}>{value}</span>
            </div>
          );
          const ratingBg = rating === 'BUY' ? '#0d2a0d' : rating === 'SELL' ? '#2a0d0d' : '#1a2a2a';
          const ratingBorder = rating === 'BUY' ? '#66bb6a44' : rating === 'SELL' ? '#ef535044' : '#ff980044';
          return (
            <div style={{ display: 'flex', flexDirection: 'column', gap: '8px' }}>
              <div style={{ padding: '8px 10px', background: ratingBg, border: `1px solid ${ratingBorder}`, borderRadius: '4px', textAlign: 'center' }}>
                <div style={{ fontSize: '9px', color: '#607d8b', letterSpacing: '1.5px', marginBottom: '2px' }}>SIGNAL</div>
                <div style={{ fontSize: '16px', fontWeight: 800, color: ratingColor, letterSpacing: '1px' }}>{rating}</div>
                <div style={{ fontSize: '9px', color: '#607d8b', marginTop: '2px' }}>Trend: <span style={{ color: trend === 'UPTREND' ? '#66bb6a' : trend === 'DOWNTREND' ? '#ef5350' : '#ff9800' }}>{trend}</span></div>
              </div>
              <div style={{ padding: '8px 10px', background: '#0a1115', border: '1px solid #1a2332', borderRadius: '4px' }}>
                <div style={{ fontSize: '9px', color: '#607d8b', letterSpacing: '1.5px', marginBottom: '4px' }}>DISTANCE FROM</div>
                {basicRow('To Resistance', `${toRes >= 0 ? '+' : ''}${toRes.toFixed(1)}%`, toRes >= 0 ? '#ff9800' : '#ef5350')}
                {basicRow('To Support', `${toSup >= 0 ? '+' : ''}${toSup.toFixed(1)}%`, toSup <= 0 ? '#66bb6a' : '#ef5350')}
                {toMa50 != null && basicRow('To 50-MA', `${toMa50 >= 0 ? '+' : ''}${toMa50.toFixed(1)}%`, toMa50 >= 0 ? '#4fc3f7' : '#ef5350')}
                {toMa200 != null && basicRow('To 200-MA', `${toMa200 >= 0 ? '+' : ''}${toMa200.toFixed(1)}%`, toMa200 >= 0 ? '#ce93d8' : '#ef5350')}
              </div>
            </div>
          );
        })()
      )}
    </div>
  );
}
