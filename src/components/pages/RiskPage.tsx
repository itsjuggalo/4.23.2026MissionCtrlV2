import { MetricCard } from '../ui/MetricCard';
import { Card } from '../ui/Card';
import { Badge } from '../ui/Badge';
import { ProgressBar } from '../ui/ProgressBar';
import { riskData } from '@/lib/mock-data';

export function RiskPage() {
  const { exposure, limit, drawdown, sharpe, maxPosition, openPositions, alerts } = riskData;

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Metric cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
        <MetricCard
          label="Exposure"
          value={`${exposure}%`}
          subtitle={`Limit: ${limit}%`}
          color="#ffa502"
        />
        <MetricCard
          label="Drawdown"
          value={`${drawdown}%`}
          subtitle="Max: -5%"
          color="#ff4757"
        />
        <MetricCard
          label="Sharpe Ratio"
          value={String(sharpe)}
          subtitle="30d rolling"
          color="#00d2a0"
        />
        <MetricCard
          label="Open Positions"
          value={String(openPositions)}
          subtitle={`Max: ${maxPosition}`}
          color="#e8e8ed"
        />
      </div>

      {/* Risk exposure card */}
      <Card>
        <div
          style={{
            fontSize: 14,
            fontFamily: "'Inter', sans-serif",
            fontWeight: 600,
            color: '#e8e8ed',
            marginBottom: 16,
          }}
        >
          Risk Exposure
        </div>
        <div
          style={{
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'baseline',
            marginBottom: 10,
          }}
        >
          <span
            style={{
              fontSize: 32,
              fontFamily: "'JetBrains Mono', monospace",
              fontWeight: 700,
              color: '#ffa502',
            }}
          >
            {exposure}%
          </span>
          <span
            style={{
              fontSize: 13,
              fontFamily: "'JetBrains Mono', monospace",
              color: '#5c5c72',
            }}
          >
            {limit}% limit
          </span>
        </div>
        <ProgressBar value={exposure} max={limit} color="#ffa502" height={8} />

        {/* Breakdown */}
        <div
          style={{
            display: 'grid',
            gridTemplateColumns: 'repeat(3, 1fr)',
            gap: 16,
            marginTop: 20,
          }}
        >
          {[
            { label: 'Crypto', pct: 38, color: '#00cec9' },
            { label: 'Equities', pct: 18, color: '#3498ff' },
            { label: 'Cash', pct: 6, color: '#00d2a0' },
          ].map((item) => (
            <div key={item.label}>
              <div
                style={{
                  display: 'flex',
                  justifyContent: 'space-between',
                  marginBottom: 6,
                }}
              >
                <span
                  style={{
                    fontSize: 12,
                    fontFamily: "'Inter', sans-serif",
                    color: '#8b8b9e',
                  }}
                >
                  {item.label}
                </span>
                <span
                  style={{
                    fontSize: 12,
                    fontFamily: "'JetBrains Mono', monospace",
                    color: item.color,
                  }}
                >
                  {item.pct}%
                </span>
              </div>
              <ProgressBar value={item.pct} max={100} color={item.color} height={4} />
            </div>
          ))}
        </div>
      </Card>

      {/* Active alerts */}
      <div>
        <div
          style={{
            fontSize: 14,
            fontFamily: "'Inter', sans-serif",
            fontWeight: 600,
            color: '#e8e8ed',
            marginBottom: 12,
          }}
        >
          Active Alerts
        </div>
        <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
          {alerts.map((alert, i) => {
            const color = alert.level === 'warning' ? '#ffa502' : '#3498ff';
            return (
              <div
                key={i}
                style={{
                  background: '#111118',
                  border: '1px solid #1e1e2a',
                  borderLeft: `3px solid ${color}`,
                  borderRadius: '0 10px 10px 0',
                  padding: '12px 16px',
                  display: 'flex',
                  alignItems: 'center',
                  gap: 12,
                }}
              >
                <Badge color={color}>{alert.level}</Badge>
                <span
                  style={{
                    fontSize: 13,
                    fontFamily: "'Inter', sans-serif",
                    color: '#8b8b9e',
                  }}
                >
                  {alert.message}
                </span>
              </div>
            );
          })}
        </div>
      </div>
    </div>
  );
}
