import { Card } from './Card';

interface MetricCardProps {
  label: string;
  value: string;
  subtitle?: string;
  color?: string;
}

export function MetricCard({ label, value, subtitle, color = '#e8e8ed' }: MetricCardProps) {
  return (
    <Card>
      <div
        className="uppercase tracking-widest mb-2"
        style={{
          fontSize: '11px',
          fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          color: '#5c5c72',
          letterSpacing: '1px',
        }}
      >
        {label}
      </div>
      <div
        className="font-bold mb-1"
        style={{
          fontSize: '26px',
          fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          color,
        }}
      >
        {value}
      </div>
      {subtitle && (
        <div
          style={{
            fontSize: '12px',
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
            color: '#8b8b9e',
          }}
        >
          {subtitle}
        </div>
      )}
    </Card>
  );
}
