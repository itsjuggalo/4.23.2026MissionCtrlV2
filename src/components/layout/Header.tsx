'use client';

import { useEffect, useState } from 'react';

interface HeaderProps {
  title: string;
}

export function Header({ title }: HeaderProps) {
  const [time, setTime] = useState('');

  useEffect(() => {
    const update = () => {
      setTime(new Date().toLocaleTimeString('en-US', { hour12: false }));
    };
    update();
    const id = setInterval(update, 1000);
    return () => clearInterval(id);
  }, []);

  return (
    <div
      style={{
        height: 52,
        background: '#0f0f17',
        borderBottom: '1px solid #1e1e2a',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        padding: '0 20px',
        flexShrink: 0,
      }}
    >
      <span
        style={{
          fontSize: 16,
          fontWeight: 600,
          fontFamily: "'Inter', -apple-system, sans-serif",
          color: '#e8e8ed',
        }}
      >
        {title}
      </span>

      <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
        {/* Pulsing green dot */}
        <span
          style={{
            display: 'inline-block',
            width: 8,
            height: 8,
            borderRadius: '50%',
            background: '#00d2a0',
            boxShadow: '0 0 6px #00d2a0',
            animation: 'pulse 2s infinite',
          }}
        />
        <span
          style={{
            fontSize: 12,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
            color: '#00d2a0',
            fontWeight: 600,
            letterSpacing: '1px',
          }}
        >
          LIVE
        </span>
        <span
          style={{
            fontSize: 13,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
            color: '#8b8b9e',
          }}
        >
          {time}
        </span>
      </div>

      <style>{`
        @keyframes pulse {
          0%, 100% { opacity: 1; box-shadow: 0 0 6px #00d2a0; }
          50% { opacity: 0.5; box-shadow: 0 0 12px #00d2a0; }
        }
      `}</style>
    </div>
  );
}
