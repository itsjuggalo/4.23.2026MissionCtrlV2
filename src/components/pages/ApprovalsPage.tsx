import { Badge } from '../ui/Badge';
import type { Approval } from '@/lib/types';

interface ApprovalsPageProps {
  approvals: Approval[];
  onUpdate: (id: number, status: 'approved' | 'rejected') => void;
}

function borderColor(status: Approval['status']) {
  return status === 'pending' ? '#ff9800' : status === 'approved' ? '#66bb6a' : '#ef5350';
}

function statusBadgeColor(status: Approval['status']) {
  return status === 'pending' ? '#ff9800' : status === 'approved' ? '#66bb6a' : '#ef5350';
}

export function ApprovalsPage({ approvals, onUpdate }: ApprovalsPageProps) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 14 }}>
      {approvals.map((approval) => {
        const border = borderColor(approval.status);
        return (
          <div
            key={approval.id}
            style={{
              background: '#111118',
              border: '1px solid #1a3a4a',
              borderLeft: `3px solid ${border}`,
              borderRadius: '0 10px 10px 0',
              padding: '16px',
              display: 'flex',
              gap: 16,
            }}
          >
            {/* Main content */}
            <div style={{ flex: 1 }}>
              {/* Symbol row */}
              <div style={{ display: 'flex', alignItems: 'center', gap: 10, marginBottom: 12 }}>
                <span
                  style={{
                    fontFamily: "'JetBrains Mono', monospace",
                    fontWeight: 700,
                    fontSize: 18,
                    color: '#e0e0e0',
                  }}
                >
                  {approval.symbol}
                </span>
                <Badge color={approval.type === 'Long' ? '#66bb6a' : '#ef5350'}>
                  {approval.type}
                </Badge>
                <Badge color={statusBadgeColor(approval.status)}>
                  {approval.status}
                </Badge>
              </div>

              {/* Price row */}
              <div style={{ display: 'flex', gap: 20, marginBottom: 12, flexWrap: 'wrap' }}>
                <div>
                  <span
                    style={{
                      fontSize: 11,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#607d8b',
                    }}
                  >
                    Entry{' '}
                  </span>
                  <span
                    style={{
                      fontSize: 13,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#e0e0e0',
                    }}
                  >
                    ${approval.entry.toLocaleString()}
                  </span>
                </div>
                <div>
                  <span
                    style={{
                      fontSize: 11,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#607d8b',
                    }}
                  >
                    Target{' '}
                  </span>
                  <span
                    style={{
                      fontSize: 13,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#66bb6a',
                    }}
                  >
                    ${approval.target.toLocaleString()}
                  </span>
                </div>
                <div>
                  <span
                    style={{
                      fontSize: 11,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#607d8b',
                    }}
                  >
                    Stop{' '}
                  </span>
                  <span
                    style={{
                      fontSize: 13,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#ef5350',
                    }}
                  >
                    ${approval.stop.toLocaleString()}
                  </span>
                </div>
                <div>
                  <span
                    style={{
                      fontSize: 11,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#607d8b',
                    }}
                  >
                    Risk{' '}
                  </span>
                  <span
                    style={{
                      fontSize: 13,
                      fontFamily: "'JetBrains Mono', monospace",
                      color: '#ff9800',
                    }}
                  >
                    {approval.risk}
                  </span>
                </div>
              </div>

              {/* Reasoning */}
              <p
                style={{
                  fontSize: 13,
                  fontFamily: "'Inter', sans-serif",
                  color: '#455a64',
                  lineHeight: 1.6,
                  marginBottom: 10,
                }}
              >
                {approval.reasoning}
              </p>

              {/* Agent + time */}
              <div style={{ display: 'flex', gap: 12, alignItems: 'center' }}>
                <span
                  style={{
                    fontSize: 11,
                    fontFamily: "'JetBrains Mono', monospace",
                    color: '#607d8b',
                  }}
                >
                  {approval.agent}
                </span>
                <span
                  style={{
                    fontSize: 11,
                    fontFamily: "'JetBrains Mono', monospace",
                    color: '#607d8b',
                  }}
                >
                  {approval.time}
                </span>
              </div>
            </div>

            {/* Action buttons */}
            {approval.status === 'pending' && (
              <div
                style={{
                  display: 'flex',
                  flexDirection: 'column',
                  gap: 8,
                  justifyContent: 'center',
                  flexShrink: 0,
                }}
              >
                <button
                  onClick={() => onUpdate(approval.id, 'approved')}
                  style={{
                    padding: '8px 20px',
                    fontSize: 12,
                    fontFamily: "'JetBrains Mono', monospace",
                    background: 'rgba(0, 210, 160, 0.1)',
                    border: '1px solid #66bb6a',
                    color: '#66bb6a',
                    borderRadius: 6,
                    cursor: 'pointer',
                    fontWeight: 600,
                  }}
                >
                  Approve
                </button>
                <button
                  onClick={() => onUpdate(approval.id, 'rejected')}
                  style={{
                    padding: '8px 20px',
                    fontSize: 12,
                    fontFamily: "'JetBrains Mono', monospace",
                    background: 'rgba(255, 71, 87, 0.1)',
                    border: '1px solid #ef5350',
                    color: '#ef5350',
                    borderRadius: 6,
                    cursor: 'pointer',
                    fontWeight: 600,
                  }}
                >
                  Reject
                </button>
              </div>
            )}
          </div>
        );
      })}
    </div>
  );
}
