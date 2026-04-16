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
        background: '#0d1117',
        borderBottom: '1px solid #1a3a4a',
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
          color: '#e0e0e0',
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
            background: '#66bb6a',
            boxShadow: '0 0 6px #66bb6a',
            animation: 'pulse 2s infinite',
          }}
        />
        <span
          style={{
            fontSize: 12,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
            color: '#66bb6a',
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
            color: '#455a64',
          }}
        >
          {time}
        </span>
      </div>

      <style>{`
        @keyframes pulse {
          0%, 100% { opacity: 1; box-shadow: 0 0 6px #66bb6a; }
          50% { opacity: 0.5; box-shadow: 0 0 12px #66bb6a; }
        }
      `}</style>
    </div>
  );
}
