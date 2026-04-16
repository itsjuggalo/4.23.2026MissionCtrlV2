'use client';

interface TerranLogoProps {
  collapsed?: boolean;
  size?: number;
}

export function TerranLogo({ collapsed = false, size = 38 }: TerranLogoProps) {
  return (
    <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
      <div style={{ position: 'relative', width: size, height: size, flexShrink: 0 }}>
        <svg viewBox="0 0 60 60" style={{ width: '100%', height: '100%', display: 'block' }}>
          <defs>
            {/* Metallic cyan gradient for text/borders */}
            <linearGradient id="mcTextGrad" x1="0%" y1="0%" x2="100%" y2="100%">
              <stop offset="0%" stopColor="#81d4fa" />
              <stop offset="50%" stopColor="#4fc3f7" />
              <stop offset="100%" stopColor="#0288d1" />
            </linearGradient>
            {/* Scan line gradient */}
            <linearGradient id="mcScanGrad" x1="0%" y1="0%" x2="0%" y2="100%">
              <stop offset="0%" stopColor="rgba(79,195,247,0)" />
              <stop offset="50%" stopColor="rgba(79,195,247,0.9)" />
              <stop offset="100%" stopColor="rgba(79,195,247,0)" />
            </linearGradient>
            {/* Hex clip for scan line */}
            <clipPath id="mcClip">
              <polygon points="8,4 52,4 58,30 52,56 8,56 2,30" />
            </clipPath>
            {/* Glow filter for the MC text */}
            <filter id="mcGlow" x="-50%" y="-50%" width="200%" height="200%">
              <feGaussianBlur stdDeviation="1.2" result="blur" />
              <feMerge>
                <feMergeNode in="blur" />
                <feMergeNode in="SourceGraphic" />
              </feMerge>
            </filter>
          </defs>

          {/* Base hex plate */}
          <polygon
            points="8,4 52,4 58,30 52,56 8,56 2,30"
            fill="#0a1929"
            stroke="url(#mcTextGrad)"
            strokeWidth="1.5"
          />

          {/* Corner chevrons — Terran unit plate detail */}
          <polyline points="11,9 7,13 7,17" fill="none" stroke="#4fc3f7" strokeWidth="1" opacity="0.7" />
          <polyline points="49,9 53,13 53,17" fill="none" stroke="#4fc3f7" strokeWidth="1" opacity="0.7" />
          <polyline points="11,51 7,47 7,43" fill="none" stroke="#4fc3f7" strokeWidth="1" opacity="0.7" />
          <polyline points="49,51 53,47 53,43" fill="none" stroke="#4fc3f7" strokeWidth="1" opacity="0.7" />

          {/* MC text — centered, bold */}
          <text
            x="30"
            y="39"
            textAnchor="middle"
            fontFamily="'Orbitron', 'Audiowide', sans-serif"
            fontSize="18"
            fontWeight="900"
            fill="url(#mcTextGrad)"
            filter="url(#mcGlow)"
            letterSpacing="-0.5"
          >
            MC
          </text>

          {/* Scan line sweep */}
          <rect x="0" y="0" width="60" height="3" fill="url(#mcScanGrad)" clipPath="url(#mcClip)">
            <animate attributeName="y" values="-3;60;-3" dur="3.2s" repeatCount="indefinite" />
          </rect>

          {/* Outer pulse ring */}
          <polygon
            points="8,4 52,4 58,30 52,56 8,56 2,30"
            fill="none"
            stroke="#4fc3f7"
            strokeWidth="1"
            opacity="0.4"
          >
            <animate attributeName="opacity" values="0.4;0.1;0.4" dur="2.4s" repeatCount="indefinite" />
          </polygon>
        </svg>
      </div>

      {!collapsed && (
        <div style={{ display: 'flex', flexDirection: 'column', lineHeight: 1, gap: 2 }}>
          <span
            style={{
              fontFamily: "'Orbitron', 'Audiowide', 'JetBrains Mono', monospace",
              fontSize: 11,
              fontWeight: 900,
              color: '#4fc3f7',
              letterSpacing: '2.5px',
              textShadow: '0 0 6px rgba(79,195,247,0.5)',
            }}
          >
            MISSION
          </span>
          <span
            style={{
              fontFamily: "'Orbitron', 'Audiowide', 'JetBrains Mono', monospace",
              fontSize: 11,
              fontWeight: 900,
              color: '#ff9800',
              letterSpacing: '2.5px',
              textShadow: '0 0 6px rgba(255,152,0,0.4)',
            }}
          >
            CTRL
          </span>
        </div>
      )}
    </div>
  );
}
