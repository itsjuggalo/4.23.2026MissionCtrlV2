import { Card } from './Card';
import { Sparkline } from './Sparkline';

type Severity = 'green' | 'amber' | 'red' | 'cyan' | 'neutral';
type TrendDirection = 'up' | 'down' | 'flat';

interface MetricCardProps {
  label: string;
  value: string;
  subtitle?: string;
  /** @deprecated Use severity instead */
  color?: string;
  severity?: Severity;
  trend?: TrendDirection;
  sparklineData?: number[];
}

const severityColor: Record<Severity, string> = {
  green: 'var(--color-mc-green)',
  amber: 'var(--color-mc-amber)',
  red: 'var(--color-mc-red)',
  cyan: 'var(--color-mc-accent)',
  neutral: 'var(--color-mc-text)',
};

const trendSymbol: Record<TrendDirection, string> = {
  up: '▲',
  down: '▼',
  flat: '—',
};

const trendColor: Record<TrendDirection, string> = {
  up: 'var(--color-mc-green)',
  down: 'var(--color-mc-red)',
  flat: 'var(--color-mc-text-muted)',
};

export function MetricCard({
  label,
  value,
  subtitle,
  color,
  severity = 'neutral',
  trend,
  sparklineData,
}: MetricCardProps) {
  // Fallback: if legacy hex color prop is provided use inline style, otherwise use token
  const resolvedColor = color ?? severityColor[severity];
  const sparkColor = color ?? (
    severity === 'green' ? 'var(--color-mc-green)'
    : severity === 'red' ? 'var(--color-mc-red)'
    : severity === 'amber' ? 'var(--color-mc-amber)'
    : 'var(--color-mc-accent)'
  );

  return (
    <Card>
      <div
        style={{
          fontSize: '11px',
          fontFamily: 'var(--font-mc-mono, "JetBrains Mono", "SF Mono", "Fira Code", monospace)',
          color: 'var(--color-mc-text-muted)',
          textTransform: 'uppercase',
          letterSpacing: '1px',
          marginBottom: '8px',
        }}
      >
        {label}
      </div>
      <div
        style={{
          fontSize: '26px',
          fontFamily: 'var(--font-mc-mono, "JetBrains Mono", "SF Mono", "Fira Code", monospace)',
          fontWeight: 700,
          color: resolvedColor,
          marginBottom: '4px',
        }}
      >
        {value}
        {trend && (
          <span style={{ marginLeft: '8px', fontSize: '14px', color: trendColor[trend] }}>
            {trendSymbol[trend]}
          </span>
        )}
      </div>
      {sparklineData && sparklineData.length > 0 && (
        <div style={{ marginTop: '8px' }}>
          <Sparkline data={sparklineData} height={32} color={sparkColor} />
        </div>
      )}
      {subtitle && (
        <div
          style={{
            fontSize: '12px',
            fontFamily: 'var(--font-mc-mono, "JetBrains Mono", "SF Mono", "Fira Code", monospace)',
            color: 'var(--color-mc-text-dim)',
          }}
        >
          {subtitle}
        </div>
      )}
    </Card>
  );
}
