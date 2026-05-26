'use client';

import { useRef, useEffect, useState, KeyboardEvent } from 'react';

type Severity = 'green' | 'amber' | 'red' | 'cyan' | 'neutral';

interface CellValue {
  score: number;
  label: string;
  severity: Severity;
}

interface HeatmapProps {
  rows: string[];
  cols: string[];
  value: (rowIdx: number, colIdx: number) => CellValue;
  onCellClick?: (rowIdx: number, colIdx: number, cell: CellValue) => void;
}

const severityBg: Record<Severity, string> = {
  green: 'color-mix(in srgb, var(--color-mc-green) 25%, var(--color-mc-bg-surface))',
  amber: 'color-mix(in srgb, var(--color-mc-amber) 25%, var(--color-mc-bg-surface))',
  red: 'color-mix(in srgb, var(--color-mc-red) 25%, var(--color-mc-bg-surface))',
  cyan: 'color-mix(in srgb, var(--color-mc-accent) 25%, var(--color-mc-bg-surface))',
  neutral: 'var(--color-mc-bg-surface)',
};

const severityBorder: Record<Severity, string> = {
  green: 'var(--color-mc-green)',
  amber: 'var(--color-mc-amber)',
  red: 'var(--color-mc-red)',
  cyan: 'var(--color-mc-accent)',
  neutral: 'var(--color-mc-border)',
};

const severityText: Record<Severity, string> = {
  green: 'var(--color-mc-green)',
  amber: 'var(--color-mc-amber)',
  red: 'var(--color-mc-red)',
  cyan: 'var(--color-mc-accent)',
  neutral: 'var(--color-mc-text-muted)',
};

export function Heatmap({ rows, cols, value, onCellClick }: HeatmapProps) {
  const gridRef = useRef<HTMLDivElement>(null);

  // On md+ (≥768px) the data table starts collapsed; on smaller screens it starts open.
  // Default to open (SSR-safe: small screen is the safer default for data accessibility).
  const [tableOpen, setTableOpen] = useState(true);
  useEffect(() => {
    const mq = window.matchMedia('(min-width: 768px)');
    setTableOpen(!mq.matches);
    const handler = (e: MediaQueryListEvent) => setTableOpen(!e.matches);
    mq.addEventListener('change', handler);
    return () => mq.removeEventListener('change', handler);
  }, []);

  function handleKeyDown(e: KeyboardEvent<HTMLButtonElement>, rowIdx: number, colIdx: number) {
    let nextRow = rowIdx;
    let nextCol = colIdx;

    if (e.key === 'ArrowRight') {
      nextCol = Math.min(colIdx + 1, cols.length - 1);
    } else if (e.key === 'ArrowLeft') {
      nextCol = Math.max(colIdx - 1, 0);
    } else if (e.key === 'ArrowDown') {
      nextRow = Math.min(rowIdx + 1, rows.length - 1);
    } else if (e.key === 'ArrowUp') {
      nextRow = Math.max(rowIdx - 1, 0);
    } else {
      return;
    }

    e.preventDefault();
    const selector = `[data-heatmap-cell="${nextRow}-${nextCol}"]`;
    const target = gridRef.current?.querySelector<HTMLElement>(selector);
    target?.focus();
  }

  // Pre-compute all cell values for the data table
  const cellMatrix: CellValue[][] = rows.map((_, ri) =>
    cols.map((_, ci) => value(ri, ci))
  );

  return (
    <div>
      {/* Heatmap grid */}
      <div
        ref={gridRef}
        style={{
          display: 'grid',
          gridTemplateColumns: `auto repeat(${cols.length}, 1fr)`,
          gap: '2px',
          fontSize: '11px',
          fontFamily: 'var(--font-mc-mono)',
        }}
        aria-label="Heatmap"
      >
        {/* Header row */}
        <div style={{ color: 'var(--color-mc-text-dim)' }} />
        {cols.map((col) => (
          <div
            key={col}
            style={{
              textAlign: 'center',
              color: 'var(--color-mc-text-muted)',
              paddingBottom: '4px',
              fontSize: '10px',
              overflow: 'hidden',
              textOverflow: 'ellipsis',
              whiteSpace: 'nowrap',
            }}
            title={col}
          >
            {col}
          </div>
        ))}

        {/* Data rows */}
        {rows.map((row, ri) => (
          <>
            {/* Row label */}
            <div
              key={`label-${ri}`}
              style={{
                color: 'var(--color-mc-text-muted)',
                display: 'flex',
                alignItems: 'center',
                paddingRight: '6px',
                whiteSpace: 'nowrap',
                fontSize: '10px',
              }}
            >
              {row}
            </div>

            {/* Cells */}
            {cols.map((col, ci) => {
              const cell = cellMatrix[ri][ci];
              return (
                <button
                  key={`cell-${ri}-${ci}`}
                  tabIndex={0}
                  data-heatmap-cell={`${ri}-${ci}`}
                  aria-label={`${row} × ${col}: ${cell.severity}, ${cell.label}`}
                  onClick={() => onCellClick?.(ri, ci, cell)}
                  onKeyDown={(e) => handleKeyDown(e, ri, ci)}
                  title={`${row} × ${col}: ${cell.label} (${cell.severity})`}
                  style={{
                    background: severityBg[cell.severity],
                    border: `1px solid ${severityBorder[cell.severity]}`,
                    borderRadius: '3px',
                    color: severityText[cell.severity],
                    cursor: 'pointer',
                    fontSize: '10px',
                    fontFamily: 'var(--font-mc-mono)',
                    padding: '3px 2px',
                    textAlign: 'center',
                    minHeight: '24px',
                    overflow: 'hidden',
                    textOverflow: 'ellipsis',
                    whiteSpace: 'nowrap',
                    outline: 'none',
                    transition: 'box-shadow 0.1s',
                  }}
                  onFocus={(e) => {
                    (e.currentTarget as HTMLElement).style.boxShadow =
                      '0 0 0 2px var(--color-mc-accent)';
                  }}
                  onBlur={(e) => {
                    (e.currentTarget as HTMLElement).style.boxShadow = 'none';
                  }}
                >
                  {cell.label}
                </button>
              );
            })}
          </>
        ))}
      </div>

      {/* Collapsible plain-text data table — open by default on small screens, collapsed on md+ */}
      <details
        style={{ marginTop: '8px' }}
        open={tableOpen}
        onToggle={(e) => setTableOpen((e.target as HTMLDetailsElement).open)}
      >
        <summary
          style={{
            fontSize: '11px',
            color: 'var(--color-mc-text-muted)',
            cursor: 'pointer',
            userSelect: 'none',
            fontFamily: 'var(--font-mc-mono)',
          }}
        >
          Data table (plain text)
        </summary>
        <div style={{ overflowX: 'auto', marginTop: '4px' }}>
          <table
            style={{
              width: '100%',
              borderCollapse: 'collapse',
              fontSize: '10px',
              fontFamily: 'var(--font-mc-mono)',
              color: 'var(--color-mc-text)',
            }}
          >
            <thead>
              <tr>
                <th style={{ textAlign: 'left', padding: '2px 6px', color: 'var(--color-mc-text-muted)', borderBottom: '1px solid var(--color-mc-border)' }}>
                  Row
                </th>
                {cols.map((col) => (
                  <th
                    key={col}
                    style={{
                      textAlign: 'center',
                      padding: '2px 4px',
                      color: 'var(--color-mc-text-muted)',
                      borderBottom: '1px solid var(--color-mc-border)',
                    }}
                  >
                    {col}
                  </th>
                ))}
              </tr>
            </thead>
            <tbody>
              {rows.map((row, ri) => (
                <tr key={row}>
                  <td style={{ padding: '2px 6px', color: 'var(--color-mc-text-muted)' }}>{row}</td>
                  {cols.map((col, ci) => {
                    const cell = cellMatrix[ri][ci];
                    return (
                      <td
                        key={col}
                        style={{
                          textAlign: 'center',
                          padding: '2px 4px',
                          color: severityText[cell.severity],
                        }}
                        title={`${cell.severity}: ${cell.label}`}
                      >
                        {cell.label}
                      </td>
                    );
                  })}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </details>
    </div>
  );
}
