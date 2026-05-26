'use client';

import {
  LineChart,
  Line,
  ResponsiveContainer,
  Area,
  AreaChart,
} from 'recharts';

interface SparklineProps {
  data: number[];
  color?: string;
  height?: number;
  fill?: boolean;
}

export function Sparkline({
  data,
  color = 'var(--color-mc-accent)',
  height = 32,
  fill = false,
}: SparklineProps) {
  if (!data || data.length === 0) {
    return (
      <div
        role="img"
        aria-label="No sparkline data"
        style={{ height, display: 'flex', alignItems: 'center' }}
      />
    );
  }

  const min = Math.min(...data);
  const max = Math.max(...data);
  const latest = data[data.length - 1];
  const trend =
    data.length > 1
      ? latest > data[0]
        ? 'up'
        : latest < data[0]
        ? 'down'
        : 'flat'
      : 'flat';
  const ariaLabel = `Sparkline: latest value ${latest.toFixed(2)}, range ${min.toFixed(2)}–${max.toFixed(2)}, trend ${trend}`;

  const chartData = data.map((v, i) => ({ i, v }));

  if (fill) {
    return (
      <div role="img" aria-label={ariaLabel} style={{ height, width: '100%' }}>
        <ResponsiveContainer width="100%" height={height}>
          <AreaChart data={chartData} margin={{ top: 2, right: 2, bottom: 2, left: 2 }}>
            <defs>
              <linearGradient id="sparkFill" x1="0" y1="0" x2="0" y2="1">
                <stop offset="5%" stopColor={color} stopOpacity={0.3} />
                <stop offset="95%" stopColor={color} stopOpacity={0} />
              </linearGradient>
            </defs>
            <Area
              type="monotone"
              dataKey="v"
              stroke={color}
              strokeWidth={1.5}
              fill="url(#sparkFill)"
              dot={false}
              isAnimationActive={false}
            />
          </AreaChart>
        </ResponsiveContainer>
      </div>
    );
  }

  return (
    <div role="img" aria-label={ariaLabel} style={{ height, width: '100%' }}>
      <ResponsiveContainer width="100%" height={height}>
        <LineChart data={chartData} margin={{ top: 2, right: 2, bottom: 2, left: 2 }}>
          <Line
            type="monotone"
            dataKey="v"
            stroke={color}
            strokeWidth={1.5}
            dot={false}
            isAnimationActive={false}
          />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
}
