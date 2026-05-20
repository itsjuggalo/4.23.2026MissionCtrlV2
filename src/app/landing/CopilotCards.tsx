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

export interface ScreenerResult {
  symbol: string;
  note?: string;
  score?: number;
}

export interface ScreenerData {
  criteria: string;
  universe?: string;
  results?: ScreenerResult[];
  excluded?: string;
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
    <div style={{ marginTop: 12, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
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
    <div style={{ marginTop: 12, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
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
    <div style={{ marginTop: 12, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
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

// ---- ScreenerCard ----

export function ScreenerCard({ data }: { data: ScreenerData }) {
  const results = data.results || [];
  return (
    <div style={{ marginTop: 12, padding: '14px 16px', background: 'rgba(13,17,23,0.55)', border: '1px solid #1a3a4a', borderRadius: 12 }}>
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 10, marginBottom: 10, flexWrap: 'wrap' }}>
        <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>CRITERIA</span>
        <span style={{ fontSize: 12, fontWeight: 600, color: '#e0e0e0', fontFamily: "'JetBrains Mono', monospace" }}>{data.criteria}</span>
        <span style={{ marginLeft: 'auto', fontSize: 10, color: '#455a64', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1 }}>SCREENER</span>
      </div>
      {data.universe && (
        <div style={{ fontSize: 11, color: '#8b8b9e', marginBottom: 10 }}>
          <span style={{ color: '#607d8b' }}>universe:</span> {data.universe}
        </div>
      )}
      {results.length > 0 ? (
        <div style={{ display: 'grid', gridTemplateColumns: 'auto 1fr auto', rowGap: 8, columnGap: 12, fontFamily: "'JetBrains Mono', monospace", fontSize: 12 }}>
          {results.map((r, i) => (
            <React.Fragment key={i}>
              <a href={`/chart?symbol=${encodeURIComponent(r.symbol)}`} style={{ fontWeight: 700, color: '#e0e0e0', textDecoration: 'none', borderBottom: '1px dotted #1a3a4a' }}>{r.symbol}</a>
              <span style={{ color: '#8b8b9e', fontFamily: "'Inter', sans-serif", fontSize: 12 }}>{r.note || ''}</span>
              <span style={{ color: typeof r.score === 'number' && r.score >= 80 ? '#00d2a0' : '#81d4fa', fontWeight: 700, textAlign: 'right' }}>
                {typeof r.score === 'number' ? r.score : '—'}
              </span>
            </React.Fragment>
          ))}
        </div>
      ) : (
        <div style={{ fontSize: 12, color: '#607d8b' }}>no matches</div>
      )}
      {data.excluded && (
        <div style={{ marginTop: 10, fontSize: 11, color: '#8b8b9e' }}>
          <span style={{ color: '#607d8b' }}>excluded:</span> {data.excluded}
        </div>
      )}
    </div>
  );
}

// =====================================================================
//  Markdown renderer — no external deps, just what the model actually emits
// =====================================================================
//
//  Block-level supported:  # / ## / ### headers, > blockquote, ``` fenced code,
//                          ---/*** horizontal rule, - / * bullets, 1. numbered,
//                          | tables |, blank-line-separated paragraphs.
//  Inline:                 **bold**, *italic*, _italic_, `code`, [text](url).
//
//  Designed to render exactly what the copilot system prompt asks the model to
//  emit. NOT a full CommonMark implementation — kept tight on purpose.

interface MdBlock {
  kind: 'h1' | 'h2' | 'h3' | 'p' | 'ul' | 'ol' | 'quote' | 'code' | 'hr' | 'table';
  lines?: string[];
  lang?: string;
  // for table
  headers?: string[];
  align?: ('left' | 'center' | 'right')[];
  rows?: string[][];
}

function splitMarkdownBlocks(text: string): MdBlock[] {
  const lines = text.replace(/\r\n/g, '\n').split('\n');
  const blocks: MdBlock[] = [];
  let i = 0;
  while (i < lines.length) {
    const line = lines[i];
    const trimmed = line.trim();

    // Blank line → skip
    if (!trimmed) { i++; continue; }

    // Headers
    if (/^###\s+/.test(trimmed)) { blocks.push({ kind: 'h3', lines: [trimmed.replace(/^###\s+/, '')] }); i++; continue; }
    if (/^##\s+/.test(trimmed))  { blocks.push({ kind: 'h2', lines: [trimmed.replace(/^##\s+/, '')] }); i++; continue; }
    if (/^#\s+/.test(trimmed))   { blocks.push({ kind: 'h1', lines: [trimmed.replace(/^#\s+/, '')] }); i++; continue; }

    // Horizontal rule
    if (/^(---|\*\*\*|___)\s*$/.test(trimmed)) { blocks.push({ kind: 'hr' }); i++; continue; }

    // Fenced code
    const fence = trimmed.match(/^```([a-zA-Z0-9_-]*)\s*$/);
    if (fence) {
      const lang = fence[1] || '';
      const body: string[] = [];
      i++;
      while (i < lines.length && !/^```\s*$/.test(lines[i].trim())) {
        body.push(lines[i]);
        i++;
      }
      i++; // skip closing fence
      blocks.push({ kind: 'code', lang, lines: body });
      continue;
    }

    // Blockquote (collect consecutive `>` lines)
    if (/^>\s?/.test(trimmed)) {
      const body: string[] = [];
      while (i < lines.length && /^>\s?/.test(lines[i].trim())) {
        body.push(lines[i].trim().replace(/^>\s?/, ''));
        i++;
      }
      blocks.push({ kind: 'quote', lines: body });
      continue;
    }

    // Bullet list
    if (/^[-*]\s+/.test(trimmed)) {
      const items: string[] = [];
      while (i < lines.length && /^[-*]\s+/.test(lines[i].trim())) {
        items.push(lines[i].trim().replace(/^[-*]\s+/, ''));
        i++;
      }
      blocks.push({ kind: 'ul', lines: items });
      continue;
    }

    // Numbered list
    if (/^\d+\.\s+/.test(trimmed)) {
      const items: string[] = [];
      while (i < lines.length && /^\d+\.\s+/.test(lines[i].trim())) {
        items.push(lines[i].trim().replace(/^\d+\.\s+/, ''));
        i++;
      }
      blocks.push({ kind: 'ol', lines: items });
      continue;
    }

    // Markdown table — pipe line followed by separator line `|---|---|`
    if (/^\|.*\|\s*$/.test(line) && i + 1 < lines.length && /^\|[\s:|-]+\|\s*$/.test(lines[i + 1])) {
      const headerCells = splitTableRow(line);
      const sepCells = splitTableRow(lines[i + 1]);
      const align: ('left' | 'center' | 'right')[] = sepCells.map((s) => {
        const left = s.startsWith(':');
        const right = s.endsWith(':');
        if (left && right) return 'center';
        if (right) return 'right';
        return 'left';
      });
      const rows: string[][] = [];
      i += 2;
      while (i < lines.length && /^\|.*\|\s*$/.test(lines[i])) {
        rows.push(splitTableRow(lines[i]));
        i++;
      }
      blocks.push({ kind: 'table', headers: headerCells, align, rows });
      continue;
    }

    // Paragraph — collect until blank line or a block-starting token
    const body: string[] = [line];
    i++;
    while (i < lines.length) {
      const next = lines[i];
      const nt = next.trim();
      if (!nt) break;
      if (/^(#{1,3})\s+/.test(nt) || /^```/.test(nt) || /^>\s?/.test(nt) || /^[-*]\s+/.test(nt) || /^\d+\.\s+/.test(nt) || /^(---|\*\*\*)\s*$/.test(nt) || /^\|.*\|\s*$/.test(next)) break;
      body.push(next);
      i++;
    }
    blocks.push({ kind: 'p', lines: body });
  }
  return blocks;
}

function splitTableRow(line: string): string[] {
  const inner = line.trim().replace(/^\|/, '').replace(/\|\s*$/, '');
  return inner.split('|').map((c) => c.trim());
}

/**
 * Render inline markdown: **bold**, *italic*, _italic_, `code`, [text](url).
 * Returns an array of React nodes.
 */
function renderInline(text: string): React.ReactNode[] {
  const nodes: React.ReactNode[] = [];
  // Token regex order: inline-code first (it disables further parsing inside),
  // then links, then bold, then italic.
  const TOKEN = /(`[^`\n]+`)|(\[[^\]\n]+\]\([^)\s]+\))|(\*\*[^*\n]+\*\*)|(\*[^*\n]+\*|_[^_\n]+_)/g;
  let last = 0;
  let m: RegExpExecArray | null;
  let key = 0;
  while ((m = TOKEN.exec(text)) !== null) {
    if (m.index > last) {
      nodes.push(text.slice(last, m.index));
    }
    const tok = m[0];
    if (tok.startsWith('`')) {
      nodes.push(
        <code key={key++} style={{
          padding: '1.5px 6px',
          fontFamily: "'JetBrains Mono', monospace",
          fontSize: '0.88em',
          background: 'rgba(79,195,247,0.10)',
          border: '1px solid rgba(79,195,247,0.20)',
          borderRadius: 4,
          color: '#81d4fa',
        }}>{tok.slice(1, -1)}</code>
      );
    } else if (tok.startsWith('[')) {
      const lm = tok.match(/^\[([^\]]+)\]\(([^)]+)\)$/);
      if (lm) {
        nodes.push(
          <a key={key++} href={lm[2]} target="_blank" rel="noopener noreferrer"
             style={{ color: '#4fc3f7', textDecoration: 'underline', textUnderlineOffset: 2 }}>
            {lm[1]}
          </a>
        );
      } else {
        nodes.push(tok);
      }
    } else if (tok.startsWith('**')) {
      nodes.push(<strong key={key++} style={{ color: '#fafafa', fontWeight: 700 }}>{tok.slice(2, -2)}</strong>);
    } else {
      // *italic* or _italic_
      nodes.push(<em key={key++} style={{ color: '#cdd6dc' }}>{tok.slice(1, -1)}</em>);
    }
    last = m.index + tok.length;
  }
  if (last < text.length) nodes.push(text.slice(last));
  return nodes;
}

/** Render a block (already parsed by splitMarkdownBlocks). */
function renderBlock(b: MdBlock, key: number): React.ReactNode {
  switch (b.kind) {
    case 'h1':
      return (
        <div key={key} style={{
          marginTop: 16, marginBottom: 8,
          fontSize: 19, fontWeight: 800, color: '#fafafa',
          letterSpacing: 0.2, fontFamily: "'Inter', sans-serif",
          paddingBottom: 6, borderBottom: '1px solid #1a3a4a',
        }}>{renderInline(b.lines![0])}</div>
      );
    case 'h2':
      return (
        <div key={key} style={{
          marginTop: 14, marginBottom: 6,
          fontSize: 16, fontWeight: 800, color: '#e0e0e0',
          letterSpacing: 0.2, fontFamily: "'Inter', sans-serif",
        }}>{renderInline(b.lines![0])}</div>
      );
    case 'h3':
      return (
        <div key={key} style={{
          marginTop: 12, marginBottom: 4,
          fontSize: 13, fontWeight: 700, color: '#81d4fa',
          letterSpacing: 0.5, fontFamily: "'JetBrains Mono', monospace",
          textTransform: 'uppercase',
        }}>{renderInline(b.lines![0])}</div>
      );
    case 'hr':
      return <hr key={key} style={{ margin: '14px 0', border: 0, borderTop: '1px solid #1a3a4a' }} />;
    case 'quote':
      return (
        <blockquote key={key} style={{
          margin: '10px 0', padding: '6px 14px',
          borderLeft: '3px solid #4fc3f7',
          background: 'rgba(79,195,247,0.05)',
          color: '#cdd6dc', fontStyle: 'italic',
          borderRadius: '0 8px 8px 0',
        }}>
          {b.lines!.map((ln, i) => (
            <div key={i}>{renderInline(ln)}</div>
          ))}
        </blockquote>
      );
    case 'code': {
      const codeText = (b.lines || []).join('\n');
      return (
        <div key={key} style={{
          margin: '10px 0',
          background: 'rgba(0,0,0,0.35)',
          border: '1px solid #1a3a4a',
          borderRadius: 8,
          overflow: 'hidden',
        }}>
          {b.lang && (
            <div style={{
              padding: '4px 10px',
              fontSize: 10, color: '#607d8b',
              fontFamily: "'JetBrains Mono', monospace",
              letterSpacing: 1, textTransform: 'uppercase',
              background: 'rgba(255,255,255,0.02)',
              borderBottom: '1px solid #1a3a4a',
            }}>{b.lang}</div>
          )}
          <pre style={{
            margin: 0, padding: '10px 12px',
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 12, color: '#cdd6dc',
            whiteSpace: 'pre-wrap', overflowX: 'auto',
            lineHeight: 1.55,
          }}>{codeText}</pre>
        </div>
      );
    }
    case 'ul':
      return (
        <ul key={key} style={{
          margin: '6px 0 6px 4px', padding: 0,
          listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 4,
        }}>
          {b.lines!.map((ln, i) => (
            <li key={i} style={{ display: 'flex', gap: 8, lineHeight: 1.55 }}>
              <span style={{ color: '#4fc3f7', flex: '0 0 auto', marginTop: 2 }}>▸</span>
              <span>{renderInline(ln)}</span>
            </li>
          ))}
        </ul>
      );
    case 'ol':
      return (
        <ol key={key} style={{
          margin: '6px 0 6px 4px', padding: 0,
          listStyle: 'none', display: 'flex', flexDirection: 'column', gap: 4,
          counterReset: 'mc-ol',
        }}>
          {b.lines!.map((ln, i) => (
            <li key={i} style={{ display: 'flex', gap: 10, lineHeight: 1.55 }}>
              <span style={{
                color: '#81d4fa', flex: '0 0 auto',
                fontFamily: "'JetBrains Mono', monospace",
                fontSize: 12, fontWeight: 700, minWidth: 18, textAlign: 'right',
              }}>{i + 1}.</span>
              <span>{renderInline(ln)}</span>
            </li>
          ))}
        </ol>
      );
    case 'table':
      return (
        <div key={key} style={{ margin: '10px 0', overflowX: 'auto' }}>
          <table style={{
            borderCollapse: 'collapse', fontSize: 12, width: '100%',
            background: 'rgba(13,17,23,0.45)', border: '1px solid #1a3a4a', borderRadius: 8,
          }}>
            <thead>
              <tr>
                {b.headers!.map((h, i) => (
                  <th key={i} style={{
                    padding: '8px 10px',
                    textAlign: (b.align?.[i] || 'left'),
                    fontFamily: "'JetBrains Mono', monospace",
                    fontSize: 10, color: '#607d8b', letterSpacing: 1,
                    textTransform: 'uppercase',
                    borderBottom: '1px solid #1a3a4a',
                  }}>{renderInline(h)}</th>
                ))}
              </tr>
            </thead>
            <tbody>
              {b.rows!.map((r, ri) => (
                <tr key={ri} style={{ background: ri % 2 ? 'rgba(255,255,255,0.015)' : 'transparent' }}>
                  {r.map((c, ci) => (
                    <td key={ci} style={{
                      padding: '7px 10px',
                      textAlign: (b.align?.[ci] || 'left'),
                      color: '#cdd6dc',
                      borderTop: ri === 0 ? 'none' : '1px solid rgba(26,58,74,0.6)',
                    }}>{renderInline(c)}</td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      );
    case 'p':
    default:
      return (
        <p key={key} style={{ margin: '6px 0', lineHeight: 1.65 }}>
          {b.lines!.map((ln, i) => (
            <React.Fragment key={i}>
              {i > 0 && <br />}
              {renderInline(ln)}
            </React.Fragment>
          ))}
        </p>
      );
  }
}

export function Markdown({ text }: { text: string }) {
  const blocks = React.useMemo(() => splitMarkdownBlocks(text), [text]);
  return <>{blocks.map((b, i) => renderBlock(b, i))}</>;
}

// =====================================================================
//  Assistant message renderer — splits prose ↔ cards, then renders prose
//  through the Markdown component above.
// =====================================================================

interface Segment {
  type: 'text' | 'trade-frame' | 'backtest' | 'chart' | 'screener' | 'invalid-card';
  text?: string;
  data?: TradeFrame | BacktestRow | ChartCardData | ScreenerData | null;
  raw?: string;
}

const CARD_LANGS = new Set(['trade-frame', 'backtest', 'chart', 'screener']);

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
    <div style={{
      fontFamily: "'Inter', sans-serif",
      fontSize: 14,
      color: '#e0e0e0',
      lineHeight: 1.65,
    }}>
      {segments.map((seg, i) => {
        if (seg.type === 'text') {
          if (!seg.text || !seg.text.trim()) return null;
          return <Markdown key={i} text={seg.text} />;
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
        if (seg.type === 'screener' && seg.data) {
          return <ScreenerCard key={i} data={seg.data as ScreenerData} />;
        }
        // invalid-card — fall back to a code block
        return (
          <pre key={i} style={{ marginTop: 10, padding: 10, background: 'rgba(255,82,82,0.08)', border: '1px solid #ef5350', borderRadius: 8, fontSize: 11, color: '#ef9a9a', whiteSpace: 'pre-wrap' }}>
            {seg.text}
          </pre>
        );
      })}
    </div>
  );
}
