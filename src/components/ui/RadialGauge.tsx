'use client';

import { RadialBarChart, RadialBar, ResponsiveContainer } from 'recharts';

type Severity = 'green' | 'amber' | 'red' | 'cyan' | 'neutral';

interface RadialGaugeProps {
  value: number;
  max: number;
  severity?: Severity;
}

const severityColor: Record<Severity, string> = {
  green: 'var(--color-mc-green)',
  amber: 'var(--color-mc-amber)',
  red: 'var(--color-mc-red)',
  cyan: 'var(--color-mc-accent)',
  neutral: 'var(--color-mc-text-muted)',
};

function inferSeverity(value: number, max: number): Severity {
  const pct = value / max;
  if (pct >= 0.7) return 'green';
  if (pct >= 0.4) return 'amber';
  return 'red';
}

export function RadialGauge({ value, max, severity }: RadialGaugeProps) {
  const resolvedSeverity = severity ?? inferSeverity(value, max);
  const color = severityColor[resolvedSeverity];
  const pct = Math.min(Math.max(value / max, 0), 1);
  const label = `${value.toFixed(1)} of ${max}`;
  const ariaLabel = `Gauge: ${label}, ${resolvedSeverity}`;

  const chartData = [
    {
      name: 'value',
      value: pct * 100,
      fill: color,
    },
  ];

  return (
    <div
      role="img"
      aria-label={ariaLabel}
      style={{ position: 'relative', width: 80, height: 80 }}
    >
      <ResponsiveContainer width={80} height={80}>
        <RadialBarChart
          cx="50%"
          cy="50%"
          innerRadius="60%"
          outerRadius="90%"
          startAngle={210}
          endAngle={-30}
          data={chartData}
          barSize={8}
        >
          <RadialBar
            dataKey="value"
            cornerRadius={4}
            background={{ fill: 'var(--color-mc-bg-surface)' }}
          />
        </RadialBarChart>
      </ResponsiveContainer>
      {/* Center label */}
      <div
        style={{
          position: 'absolute',
          inset: 0,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          justifyContent: 'center',
          pointerEvents: 'none',
        }}
      >
        <span
          style={{
            fontSize: '13px',
            fontWeight: 700,
            color,
            fontFamily: 'var(--font-mc-mono)',
            lineHeight: 1,
          }}
        >
          {value.toFixed(1)}
        </span>
        <span
          style={{
            fontSize: '9px',
            color: 'var(--color-mc-text-muted)',
            fontFamily: 'var(--font-mc-mono)',
          }}
        >
          /{max}
        </span>
      </div>
    </div>
  );
}
