'use client';

import { ComposedChart, Line, ReferenceDot, XAxis, YAxis, Tooltip, ResponsiveContainer } from 'recharts';

interface PricePoint {
  t: number; // unix ms
  close: number;
}

interface Signal {
  t: number; // unix ms
  side: 'buy' | 'sell';
  price: number;
}

interface SignalChartProps {
  priceSeries: PricePoint[];
  signals: Signal[];
  height?: number;
}

function formatTime(t: number): string {
  const d = new Date(t);
  return `${d.getMonth() + 1}/${d.getDate()} ${d.getHours().toString().padStart(2, '0')}:00`;
}

export function SignalChart({ priceSeries, signals, height = 220 }: SignalChartProps) {
  if (!priceSeries || priceSeries.length === 0) {
    return (
      <div
        style={{
          height,
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
          background: 'var(--color-mc-bg-surface)',
          border: '1px solid var(--color-mc-border)',
          borderRadius: '6px',
          color: 'var(--color-mc-text-muted)',
          fontSize: '12px',
          fontFamily: 'var(--font-mc-mono)',
        }}
      >
        No price data available
      </div>
    );
  }

  // Build a map of t→signal for quick lookup
  const signalMap = new Map<number, Signal>();
  for (const sig of signals) {
    signalMap.set(sig.t, sig);
  }

  return (
    <div>
      <div style={{ height, width: '100%' }}>
        <ResponsiveContainer width="100%" height={height}>
          <ComposedChart data={priceSeries} margin={{ top: 8, right: 8, bottom: 8, left: 8 }}>
            <XAxis
              dataKey="t"
              tickFormatter={formatTime}
              tick={{ fontSize: 9, fill: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}
              axisLine={{ stroke: 'var(--color-mc-border)' }}
              tickLine={false}
              interval="preserveStartEnd"
            />
            <YAxis
              dataKey="close"
              tick={{ fontSize: 9, fill: 'var(--color-mc-text-muted)', fontFamily: 'var(--font-mc-mono)' }}
              axisLine={{ stroke: 'var(--color-mc-border)' }}
              tickLine={false}
              width={50}
              tickFormatter={(v: number) => v.toLocaleString(undefined, { maximumFractionDigits: 2 })}
            />
            <Tooltip
              contentStyle={{
                background: 'var(--color-mc-bg-card)',
                border: '1px solid var(--color-mc-border)',
                borderRadius: '4px',
                fontSize: '10px',
                fontFamily: 'var(--font-mc-mono)',
                color: 'var(--color-mc-text)',
              }}
              labelFormatter={(label) => (typeof label === 'number' ? formatTime(label) : String(label))}
              formatter={(value) => {
                const v = typeof value === 'number' ? value : Number(value);
                return [v.toLocaleString(undefined, { maximumFractionDigits: 4 }), 'Price'];
              }}
            />
            <Line
              type="monotone"
              dataKey="close"
              stroke="var(--color-mc-accent)"
              strokeWidth={1.5}
              dot={false}
              isAnimationActive={false}
            />
            {/* Buy signals — green upward triangles */}
            {signals
              .filter((s) => s.side === 'buy')
              .map((s) => (
                <ReferenceDot
                  key={`buy-${s.t}`}
                  x={s.t}
                  y={s.price}
                  r={5}
                  fill="var(--color-mc-green)"
                  stroke="var(--color-mc-bg)"
                  strokeWidth={1}
                  label={{
                    value: '▲',
                    position: 'bottom',
                    style: {
                      fontSize: '10px',
                      fill: 'var(--color-mc-green)',
                      fontFamily: 'var(--font-mc-mono)',
                    },
                  }}
                />
              ))}
            {/* Sell signals — red downward triangles */}
            {signals
              .filter((s) => s.side === 'sell')
              .map((s) => (
                <ReferenceDot
                  key={`sell-${s.t}`}
                  x={s.t}
                  y={s.price}
                  r={5}
                  fill="var(--color-mc-red)"
                  stroke="var(--color-mc-bg)"
                  strokeWidth={1}
                  label={{
                    value: '▼',
                    position: 'top',
                    style: {
                      fontSize: '10px',
                      fill: 'var(--color-mc-red)',
                      fontFamily: 'var(--font-mc-mono)',
                    },
                  }}
                />
              ))}
          </ComposedChart>
        </ResponsiveContainer>
      </div>

      {/* Collapsible signal log table */}
      {signals.length > 0 && (
        <details style={{ marginTop: '8px' }}>
          <summary
            style={{
              fontSize: '11px',
              color: 'var(--color-mc-text-muted)',
              cursor: 'pointer',
              userSelect: 'none',
              fontFamily: 'var(--font-mc-mono)',
            }}
          >
            Signal log ({signals.length} signals)
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
                  {['Time', 'Side', 'Price'].map((h) => (
                    <th
                      key={h}
                      style={{
                        textAlign: 'left',
                        padding: '2px 6px',
                        color: 'var(--color-mc-text-muted)',
                        borderBottom: '1px solid var(--color-mc-border)',
                      }}
                    >
                      {h}
                    </th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {[...signals]
                  .sort((a, b) => b.t - a.t)
                  .map((s) => (
                    <tr key={`${s.t}-${s.side}`}>
                      <td style={{ padding: '2px 6px', color: 'var(--color-mc-text-muted)' }}>
                        {formatTime(s.t)}
                      </td>
                      <td
                        style={{
                          padding: '2px 6px',
                          color:
                            s.side === 'buy'
                              ? 'var(--color-mc-green)'
                              : 'var(--color-mc-red)',
                          fontWeight: 700,
                        }}
                      >
                        {s.side === 'buy' ? '▲ BUY' : '▼ SELL'}
                      </td>
                      <td style={{ padding: '2px 6px' }}>
                        {s.price.toLocaleString(undefined, { maximumFractionDigits: 4 })}
                      </td>
                    </tr>
                  ))}
              </tbody>
            </table>
          </div>
        </details>
      )}
    </div>
  );
}
