'use client';
import React from 'react';

// ---- types ----

export interface TradeFrame {
  symbol: string;
  direction?: 'long' | 'short';
  entry?: number;
  stop?: number;
  target?: number;
  size_hint?: string;
  conviction?: 'low' | 'medium' | 'high';
  rationale?: string;
}

export interface BacktestRow {
  setup: string;
  n_trades?: number;
  win_rate?: number;
  avg_win?: number;
  avg_loss?: number;
  max_dd?: number;
  sharpe?: number;
  period?: string;
}

export interface ChartCardData {
  symbol: string;
  period?: string;
  interval?: string;
  note?: string;
  levels?: Array<{ label: string; price: number }>;
}

// ---- rendering helpers ----

function fmtPct(v: unknown): string {
  if (typeof v !== 'number' || !isFinite(v)) return '—';
  return (v * 100).toFixed(1) + '%';
}
function fmtN(v: unknown, decimals = 2): string {
  if (typeof v !== 'number' || !isFinite(v)) return '—';
  return v.toLocaleString('en-US', { minimumFractionDigits: 0, maximumFractionDigits: decimals });
}

// ---- TradeFrameCard ----

export function TradeFrameCard({ data }: { data: TradeFrame }) {
  const dir = data.direction || 'long';
  const dirColor = dir === 'long' ? '#00d2a0' : '#ef5350';
  const convColor = data.conviction === 'high' ? '#66bb6a'
    : data.conviction === 'low' ? '#ef9a9a'
    : '#ffb74d';
  const rrr = (data.entry && data.target && data.stop)
    ? Math.abs((data.target - data.entry) / (data.entry - data.stop)).toFixed(1)
    : null;
  return (
    <div style={{ marginTop: 10, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 10, marginBottom: 10 }}>
        <span style={{ fontFamily: "'Orbitron', monospace", fontSize: 16, fontWeight: 900, letterSpacing: 1, color: '#e0e0e0' }}>{data.symbol}</span>
        <span style={{ fontSize: 11, fontWeight: 700, color: dirColor, textTransform: 'uppercase', letterSpacing: 1 }}>{dir}</span>
        {data.conviction && (
          <span style={{ fontSize: 10, padding: '2px 8px', borderRadius: 100, background: 'rgba(255,255,255,0.04)', border: `1px solid ${convColor}55`, color: convColor, fontWeight: 700, textTransform: 'uppercase' }}>
            {data.conviction}
          </span>
        )}
        <span style={{ marginLeft: 'auto', fontSize: 10, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>TRADE FRAME</span>
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 10, fontFamily: "'JetBrains Mono', monospace" }}>
        <Cell label="ENTRY" value={data.entry ? fmtN(data.entry) : '—'} />
        <Cell label="STOP" value={data.stop ? fmtN(data.stop) : '—'} color="#ef5350" />
        <Cell label="TARGET" value={data.target ? fmtN(data.target) : '—'} color="#00d2a0" />
        <Cell label="R:R" value={rrr || '—'} />
      </div>
      {(data.size_hint || data.rationale) && (
        <div style={{ marginTop: 10, fontSize: 11, color: '#8b8b9e' }}>
          {data.size_hint && <span style={{ marginRight: 12 }}><span style={{ color: '#607d8b' }}>size:</span> {data.size_hint}</span>}
          {data.rationale && <span><span style={{ color: '#607d8b' }}>why:</span> {data.rationale}</span>}
        </div>
      )}
    </div>
  );
}

function Cell({ label, value, color }: { label: string; value: string; color?: string }) {
  return (
    <div>
      <div style={{ fontSize: 9, color: '#455a64', letterSpacing: 1, marginBottom: 3 }}>{label}</div>
      <div style={{ fontSize: 14, fontWeight: 700, color: color || '#e0e0e0' }}>{value}</div>
    </div>
  );
}

// ---- BacktestCard ----

export function BacktestCard({ data }: { data: BacktestRow }) {
  const winColor = (data.win_rate || 0) >= 0.55 ? '#00d2a0' : (data.win_rate || 0) >= 0.45 ? '#ffb74d' : '#ef5350';
  return (
    <div style={{ marginTop: 10, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 8, marginBottom: 10 }}>
        <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>SETUP</span>
        <span style={{ fontSize: 13, fontWeight: 700, color: '#e0e0e0' }}>{data.setup}</span>
        <span style={{ marginLeft: 'auto', fontSize: 10, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>BACKTEST</span>
      </div>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 10, fontFamily: "'JetBrains Mono', monospace" }}>
        <Cell label="N" value={fmtN(data.n_trades)} />
        <Cell label="WIN" value={fmtPct(data.win_rate)} color={winColor} />
        <Cell label="SHARPE" value={fmtN(data.sharpe)} />
        <Cell label="AVG WIN" value={fmtPct(data.avg_win)} color="#00d2a0" />
        <Cell label="AVG LOSS" value={fmtPct(data.avg_loss)} color="#ef5350" />
        <Cell label="MAX DD" value={fmtPct(data.max_dd)} color="#ef5350" />
      </div>
      {data.period && (
        <div style={{ marginTop: 10, fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>
          period: {data.period}
        </div>
      )}
    </div>
  );
}

// ---- ChartCard (simple — links into the detail drawer) ----

export function ChartCard({ data }: { data: ChartCardData }) {
  return (
    <div style={{ marginTop: 10, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 10, marginBottom: 8 }}>
        <span style={{ fontFamily: "'Orbitron', monospace", fontSize: 14, fontWeight: 900, letterSpacing: 1, color: '#e0e0e0' }}>{data.symbol}</span>
        {data.period && <span style={{ fontSize: 11, color: '#81d4fa' }}>{data.period}</span>}
        {data.interval && <span style={{ fontSize: 11, color: '#81d4fa' }}>{data.interval}</span>}
        <span style={{ marginLeft: 'auto', fontSize: 10, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>CHART</span>
      </div>
      {data.note && (
        <div style={{ fontSize: 12, color: '#8b8b9e', marginBottom: 8 }}>{data.note}</div>
      )}
      {data.levels && data.levels.length > 0 && (
        <div style={{ display: 'flex', flexWrap: 'wrap', gap: 6 }}>
          {data.levels.map((l, i) => (
            <span key={i} style={{ padding: '3px 9px', background: 'rgba(79,195,247,0.08)', border: '1px solid #1a3a4a', borderRadius: 100, fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#81d4fa' }}>
              {l.label}: {fmtN(l.price, 2)}
            </span>
          ))}
        </div>
      )}
      <div style={{ marginTop: 10, fontSize: 11 }}>
        <a href={`/chart?symbol=${encodeURIComponent(data.symbol)}`} style={{ color: '#4fc3f7', textDecoration: 'none' }}>
          Open in TV Chart →
        </a>
      </div>
    </div>
  );
}

// ---- bubble renderer that splits text into prose + cards ----

interface Segment {
  type: 'text' | 'trade-frame' | 'backtest' | 'chart' | 'invalid-card';
  text?: string;
  data?: TradeFrame | BacktestRow | ChartCardData | null;
  raw?: string;
}

const CARD_LANGS = new Set(['trade-frame', 'backtest', 'chart']);

/**
 * Parse an assistant message into a sequence of text/card segments.
 * Detects fenced code blocks whose language is one of the card types.
 */
export function parseAssistantSegments(content: string): Segment[] {
  if (!content) return [{ type: 'text', text: '' }];
  const segments: Segment[] = [];
  const fenceRe = /```([a-z-]+)\s*\n([\s\S]*?)```/gi;
  let cursor = 0;
  let m: RegExpExecArray | null;
  while ((m = fenceRe.exec(content)) !== null) {
    const lang = m[1].toLowerCase();
    if (!CARD_LANGS.has(lang)) continue;
    if (m.index > cursor) {
      segments.push({ type: 'text', text: content.slice(cursor, m.index) });
    }
    try {
      const data = JSON.parse(m[2].trim());
      segments.push({ type: lang as Segment['type'], data, raw: m[2] });
    } catch {
      segments.push({ type: 'invalid-card', text: `\`\`\`${lang}\n${m[2]}\`\`\``, raw: m[2] });
    }
    cursor = m.index + m[0].length;
  }
  if (cursor < content.length) {
    segments.push({ type: 'text', text: content.slice(cursor) });
  }
  return segments;
}

/** Renders a parsed assistant message: prose + inline card components. */
export function AssistantContent({ content }: { content: string }) {
  const segments = React.useMemo(() => parseAssistantSegments(content), [content]);
  return (
    <>
      {segments.map((seg, i) => {
        if (seg.type === 'text') {
          if (!seg.text) return null;
          return (
            <div key={i} style={{ whiteSpace: 'pre-wrap', lineHeight: 1.65 }}>
              {seg.text}
            </div>
          );
        }
        if (seg.type === 'trade-frame' && seg.data) {
          return <TradeFrameCard key={i} data={seg.data as TradeFrame} />;
        }
        if (seg.type === 'backtest' && seg.data) {
          return <BacktestCard key={i} data={seg.data as BacktestRow} />;
        }
        if (seg.type === 'chart' && seg.data) {
          return <ChartCard key={i} data={seg.data as ChartCardData} />;
        }
        // invalid-card — fall back to a code block
        return (
          <pre key={i} style={{ marginTop: 10, padding: 10, background: 'rgba(255,82,82,0.08)', border: '1px solid #ef5350', borderRadius: 8, fontSize: 11, color: '#ef9a9a', whiteSpace: 'pre-wrap' }}>
            {seg.text}
          </pre>
        );
      })}
    </>
  );
}
