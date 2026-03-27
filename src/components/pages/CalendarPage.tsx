import { Badge } from '../ui/Badge';
import { StatusDot } from '../ui/StatusDot';
import { schedule, recurringJobs } from '@/lib/mock-data';
import type { ScheduleItem } from '@/lib/types';

function statusIcon(status: ScheduleItem['status']) {
  if (status === 'completed') return <span style={{ color: '#00d2a0', fontSize: 14 }}>✓</span>;
  if (status === 'active') return <span style={{ color: '#6c5ce7', fontSize: 14 }}>▶</span>;
  return <span style={{ color: '#5c5c72', fontSize: 14 }}>○</span>;
}

function statusColor(status: ScheduleItem['status']) {
  return status === 'completed' ? '#00d2a0' : status === 'active' ? '#6c5ce7' : '#5c5c72';
}

function typeColor(type: ScheduleItem['type']) {
  return type === 'scan' ? '#6c5ce7' : type === 'review' ? '#3498ff' : type === 'monitor' ? '#ffa502' : '#00d2a0';
}

export function CalendarPage() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Title */}
      <h2
        style={{
          fontSize: 16,
          fontFamily: "'Inter', sans-serif",
          fontWeight: 600,
          color: '#e8e8ed',
          margin: 0,
        }}
      >
        March 23, 2026 — Daily schedule
      </h2>

      {/* Schedule */}
      <div
        style={{
          background: '#111118',
          border: '1px solid #1e1e2a',
          borderRadius: 10,
          overflow: 'hidden',
        }}
      >
        {schedule.map((item, i) => {
          const isActive = item.status === 'active';
          return (
            <div
              key={i}
              style={{
                display: 'flex',
                alignItems: 'center',
                gap: 14,
                padding: '12px 16px',
                borderBottom: i < schedule.length - 1 ? '1px solid #1e1e2a' : 'none',
                background: isActive ? 'rgba(108,92,231,0.06)' : 'transparent',
                borderLeft: isActive ? '2px solid #6c5ce7' : '2px solid transparent',
              }}
            >
              <span
                style={{
                  fontFamily: "'JetBrains Mono', monospace",
                  fontSize: 12,
                  color: '#5c5c72',
                  minWidth: 50,
                }}
              >
                {item.time}
              </span>
              <span style={{ width: 20, textAlign: 'center' }}>
                {statusIcon(item.status)}
              </span>
              <span
                style={{
                  flex: 1,
                  fontSize: 13,
                  fontFamily: "'Inter', sans-serif",
                  color: isActive ? '#e8e8ed' : '#8b8b9e',
                  fontWeight: isActive ? 500 : 400,
                }}
              >
                {item.name}
              </span>
              <div style={{ display: 'flex', gap: 6 }}>
                <Badge color={statusColor(item.status)}>{item.status}</Badge>
                <Badge color={typeColor(item.type)}>{item.type}</Badge>
              </div>
            </div>
          );
        })}
      </div>

      {/* Recurring jobs */}
      <div
        style={{
          background: '#111118',
          border: '1px solid #1e1e2a',
          borderRadius: 10,
          padding: 16,
        }}
      >
        <div
          style={{
            fontSize: 14,
            fontFamily: "'Inter', sans-serif",
            fontWeight: 600,
            color: '#e8e8ed',
            marginBottom: 14,
          }}
        >
          Recurring Jobs
        </div>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 10 }}>
          {recurringJobs.map((job, i) => (
            <div
              key={i}
              style={{
                display: 'flex',
                alignItems: 'center',
                gap: 10,
                padding: '10px 12px',
                background: '#0f0f17',
                borderRadius: 8,
                border: '1px solid #1e1e2a',
              }}
            >
              <StatusDot status="active" />
              <div style={{ flex: 1 }}>
                <div
                  style={{
                    fontSize: 13,
                    fontFamily: "'Inter', sans-serif",
                    color: '#e8e8ed',
                    fontWeight: 500,
                    marginBottom: 2,
                  }}
                >
                  {job.name}
                </div>
                <div
                  style={{
                    fontSize: 11,
                    fontFamily: "'JetBrains Mono', monospace",
                    color: '#5c5c72',
                  }}
                >
                  {job.interval}
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
