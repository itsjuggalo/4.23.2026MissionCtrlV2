import { Badge } from '../ui/Badge';
import { activityFeed } from '@/lib/mock-data';
import type { ActivityEntry } from '@/lib/types';

function typeColor(type: ActivityEntry['type']) {
  switch (type) {
    case 'signal': return '#6c5ce7';
    case 'risk': return '#ffa502';
    case 'intel': return '#3498ff';
    case 'execution': return '#00d2a0';
    case 'memory': return '#00cec9';
    default: return '#5c5c72';
  }
}

export function ActivityPage() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 0 }}>
      {activityFeed.map((entry, i) => {
        const dotColor = typeColor(entry.type);
        const isFirst = i === 0;
        return (
          <div
            key={i}
            style={{
              display: 'flex',
              gap: 16,
              padding: '14px 16px',
              background: isFirst ? 'rgba(108,92,231,0.06)' : 'transparent',
              borderBottom: '1px solid #1e1e2a',
            }}
          >
            {/* Left column */}
            <div
              style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                gap: 6,
                minWidth: 70,
              }}
            >
              <span
                style={{
                  fontFamily: "'JetBrains Mono', monospace",
                  fontSize: 11,
                  color: '#5c5c72',
                }}
              >
                {entry.time}
              </span>
              <span
                style={{
                  width: 8,
                  height: 8,
                  borderRadius: '50%',
                  background: dotColor,
                  display: 'inline-block',
                  flexShrink: 0,
                }}
              />
            </div>

            {/* Right content */}
            <div style={{ flex: 1 }}>
              <div
                style={{
                  display: 'flex',
                  alignItems: 'center',
                  gap: 10,
                  marginBottom: 4,
                  flexWrap: 'wrap',
                }}
              >
                <span
                  style={{
                    fontFamily: "'JetBrains Mono', monospace",
                    fontSize: 12,
                    color: '#a29bfe',
                    fontWeight: 600,
                  }}
                >
                  {entry.agent}
                </span>
                <span
                  style={{
                    fontSize: 13,
                    fontFamily: "'Inter', sans-serif",
                    fontWeight: 500,
                    color: '#e8e8ed',
                  }}
                >
                  {entry.action}
                </span>
                <Badge color={dotColor}>{entry.type}</Badge>
              </div>
              <div
                style={{
                  fontSize: 12,
                  fontFamily: "'Inter', sans-serif",
                  color: '#8b8b9e',
                  lineHeight: 1.5,
                }}
              >
                {entry.detail}
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
}
