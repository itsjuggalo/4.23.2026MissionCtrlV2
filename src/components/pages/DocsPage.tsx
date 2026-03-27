import { FileText } from 'lucide-react';
import { docs } from '@/lib/mock-data';
import type { Doc } from '@/lib/types';

function typeColor(type: Doc['type']) {
  return type === 'Strategy'
    ? '#6c5ce7'
    : type === 'Policy'
    ? '#ffa502'
    : type === 'Technical'
    ? '#3498ff'
    : '#00d2a0';
}

export function DocsPage() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
      {docs.map((doc, i) => {
        const color = typeColor(doc.type);
        return (
          <div
            key={i}
            style={{
              background: '#111118',
              border: '1px solid #1e1e2a',
              borderRadius: 10,
              padding: '14px 16px',
              display: 'flex',
              alignItems: 'center',
              gap: 14,
              cursor: 'pointer',
              transition: 'border-color 0.15s, background 0.15s',
            }}
            onMouseEnter={(e) => {
              (e.currentTarget as HTMLElement).style.background = '#16161f';
              (e.currentTarget as HTMLElement).style.borderColor = '#2a2a3a';
            }}
            onMouseLeave={(e) => {
              (e.currentTarget as HTMLElement).style.background = '#111118';
              (e.currentTarget as HTMLElement).style.borderColor = '#1e1e2a';
            }}
          >
            {/* Icon */}
            <div
              style={{
                width: 36,
                height: 36,
                borderRadius: 8,
                background: `rgba(${hexToRgb(color)}, 0.12)`,
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                flexShrink: 0,
              }}
            >
              <FileText size={16} color={color} />
            </div>

            {/* Info */}
            <div style={{ flex: 1 }}>
              <div
                style={{
                  fontSize: 14,
                  fontFamily: "'Inter', sans-serif",
                  fontWeight: 500,
                  color: '#e8e8ed',
                  marginBottom: 3,
                }}
              >
                {doc.title}
              </div>
              <div
                style={{
                  fontSize: 11,
                  fontFamily: "'JetBrains Mono', monospace",
                  color: '#5c5c72',
                }}
              >
                {doc.type} · {doc.pages} pages
              </div>
            </div>

            {/* Date */}
            <span
              style={{
                fontSize: 11,
                fontFamily: "'JetBrains Mono', monospace",
                color: '#5c5c72',
                flexShrink: 0,
              }}
            >
              {doc.updated}
            </span>
          </div>
        );
      })}
    </div>
  );
}

function hexToRgb(hex: string) {
  const r = parseInt(hex.slice(1, 3), 16);
  const g = parseInt(hex.slice(3, 5), 16);
  const b = parseInt(hex.slice(5, 7), 16);
  return `${r}, ${g}, ${b}`;
}
