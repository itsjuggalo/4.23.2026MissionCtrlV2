'use client';
import React, { useMemo } from 'react';

/**
 * Rotating StarCraft character avatar - 48px by default.
 * Pool of 15 units across all 3 races. Different random pick per page load.
 * Pass `seed` prop (typically the page name) so each page gets a stable character
 * per load that differs from other pages. Omit `seed` for pure random per render.
 */

interface Props {
  size?: number;
  seed?: string; // e.g. the page title - seeds the randomness so it's stable per page
}

type UnitId =
  | 'marine' | 'scv' | 'ghost' | 'siege-tank' | 'thor'
  | 'zergling' | 'hydralisk' | 'mutalisk' | 'overlord' | 'ultralisk'
  | 'zealot' | 'stalker' | 'dark-templar' | 'high-templar' | 'probe';

const UNITS: UnitId[] = [
  'marine', 'scv', 'ghost', 'siege-tank', 'thor',
  'zergling', 'hydralisk', 'mutalisk', 'overlord', 'ultralisk',
  'zealot', 'stalker', 'dark-templar', 'high-templar', 'probe',
];

function hashSeed(s: string): number {
  let h = 0;
  for (let i = 0; i < s.length; i++) h = ((h << 5) - h + s.charCodeAt(i)) | 0;
  return Math.abs(h);
}

// Each unit gets a tiny inline SVG. Designed at 48x48 viewBox.
const Unit: React.FC<{ id: UnitId }> = ({ id }) => {
  switch (id) {
    case 'marine': return (
      <g>
        <rect x="14" y="22" width="20" height="18" fill="#1e3a5f" stroke="#4a90e2" strokeWidth="1.2" rx="2"/>
        <ellipse cx="12" cy="24" rx="4" ry="5" fill="#2a4a7a" stroke="#4a90e2" strokeWidth="1"/>
        <ellipse cx="36" cy="24" rx="4" ry="5" fill="#2a4a7a" stroke="#4a90e2" strokeWidth="1"/>
        <rect x="16" y="10" width="16" height="12" fill="#1a2a4a" stroke="#4a90e2" strokeWidth="1.2" rx="2"/>
        <rect x="19" y="14" width="10" height="3" fill="#66ccff"><animate attributeName="opacity" values="0.6;1;0.6" dur="1.5s" repeatCount="indefinite"/></rect>
      </g>
    );
    case 'scv': return (
      <g>
        <rect x="12" y="20" width="24" height="18" fill="#ffaa33" stroke="#ff8800" strokeWidth="1.2" rx="3"/>
        <rect x="17" y="10" width="14" height="12" fill="#2a3a5a" stroke="#66aaff" strokeWidth="1" rx="2"/>
        <rect x="20" y="13" width="8" height="3" fill="#88ccff"><animate attributeName="opacity" values="0.5;0.9;0.5" dur="2s" repeatCount="indefinite"/></rect>
        <polygon points="36,25 44,28 36,31" fill="#888" stroke="#ccc" strokeWidth="0.8"/>
      </g>
    );
    case 'ghost': return (
      <g>
        <rect x="18" y="22" width="12" height="18" fill="#3a3a3a" stroke="#888" strokeWidth="1"/>
        <rect x="16" y="10" width="16" height="13" fill="#222" stroke="#aaa" strokeWidth="1" rx="2"/>
        <rect x="20" y="14" width="8" height="3" fill="#ff3333"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.8s" repeatCount="indefinite"/></rect>
        <rect x="30" y="26" width="14" height="3" fill="#444" stroke="#666" strokeWidth="0.6"/>
      </g>
    );
    case 'siege-tank': return (
      <g>
        <rect x="8" y="30" width="32" height="8" fill="#2a2a2a" stroke="#555" strokeWidth="1" rx="1"/>
        <circle cx="14" cy="36" r="3" fill="#1a1a1a" stroke="#666" strokeWidth="0.6"/>
        <circle cx="24" cy="36" r="3" fill="#1a1a1a" stroke="#666" strokeWidth="0.6"/>
        <circle cx="34" cy="36" r="3" fill="#1a1a1a" stroke="#666" strokeWidth="0.6"/>
        <rect x="10" y="20" width="28" height="10" fill="#4a4a2a" stroke="#aa9933" strokeWidth="1.2" rx="2"/>
        <rect x="30" y="16" width="16" height="4" fill="#2a2a2a" stroke="#888" strokeWidth="0.8"/>
      </g>
    );
    case 'thor': return (
      <g>
        <rect x="12" y="24" width="24" height="18" fill="#3a4a6a" stroke="#66aaff" strokeWidth="1.2" rx="2"/>
        <rect x="8" y="14" width="8" height="14" fill="#3a4a6a" stroke="#66aaff" strokeWidth="1"/>
        <rect x="32" y="14" width="8" height="14" fill="#3a4a6a" stroke="#66aaff" strokeWidth="1"/>
        <rect x="16" y="8" width="16" height="14" fill="#2a3a5a" stroke="#66aaff" strokeWidth="1.2" rx="2"/>
        <rect x="20" y="13" width="8" height="3" fill="#ff3333"><animate attributeName="opacity" values="0.6;1;0.6" dur="1s" repeatCount="indefinite"/></rect>
      </g>
    );
    case 'zergling': return (
      <g>
        <ellipse cx="24" cy="32" rx="14" ry="8" fill="#6a2a7a" stroke="#bb44dd" strokeWidth="1.2"/>
        <polygon points="14,26 17,18 20,26" fill="#bb44dd"/>
        <polygon points="20,26 23,17 26,26" fill="#bb44dd"/>
        <polygon points="26,26 29,18 32,26" fill="#bb44dd"/>
        <ellipse cx="36" cy="30" rx="6" ry="5" fill="#8a3a9a" stroke="#bb44dd" strokeWidth="1"/>
        <circle cx="38" cy="29" r="1.3" fill="#ffff00"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.6s" repeatCount="indefinite"/></circle>
      </g>
    );
    case 'hydralisk': return (
      <g>
        <ellipse cx="24" cy="34" rx="15" ry="7" fill="#4a2a5a" stroke="#9944bb" strokeWidth="1.2"/>
        <rect x="20" y="14" width="8" height="20" fill="#5a2a6a" stroke="#9944bb" strokeWidth="1.2" rx="2"/>
        <ellipse cx="24" cy="12" rx="6" ry="5" fill="#7a3a8a" stroke="#9944bb" strokeWidth="1"/>
        <polygon points="12,22 18,24 18,28" fill="#ddaacc"/>
        <polygon points="36,22 30,24 30,28" fill="#ddaacc"/>
        <circle cx="22" cy="12" r="1" fill="#ffaa44"/>
        <circle cx="26" cy="12" r="1" fill="#ffaa44"/>
      </g>
    );
    case 'mutalisk': return (
      <g transform="translate(0,4)">
        <ellipse cx="24" cy="24" rx="15" ry="6" fill="#7a2a4a" stroke="#cc4466" strokeWidth="1.2"/>
        <ellipse cx="38" cy="24" rx="7" ry="5" fill="#8a3355" stroke="#cc4466" strokeWidth="1"/>
        <circle cx="42" cy="23" r="1.3" fill="#ffff00"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.8s" repeatCount="indefinite"/></circle>
        <g><animateTransform attributeName="transform" type="scale" values="1,1;1,0.4;1,1" dur="0.4s" repeatCount="indefinite"/>
          <path d="M 18,20 Q 14,8 4,12 Q 12,16 18,20 Z" fill="#6a2244" stroke="#cc4466" strokeWidth="1"/>
          <path d="M 30,20 Q 34,8 44,12 Q 36,16 30,20 Z" fill="#6a2244" stroke="#cc4466" strokeWidth="1"/>
        </g>
      </g>
    );
    case 'overlord': return (
      <g>
        <ellipse cx="24" cy="26" rx="18" ry="12" fill="#5a2a4a" stroke="#aa4477" strokeWidth="1.2"/>
        <ellipse cx="24" cy="23" rx="14" ry="7" fill="#7a3a5a" opacity="0.7"/>
        <polygon points="14,38 18,42 16,34" fill="#aa4477"/>
        <polygon points="24,40 26,44 22,34" fill="#aa4477"/>
        <polygon points="32,38 34,42 30,34" fill="#aa4477"/>
        <circle cx="20" cy="25" r="1.5" fill="#ffff88"/>
        <circle cx="28" cy="25" r="1.5" fill="#ffff88"/>
      </g>
    );
    case 'ultralisk': return (
      <g>
        <ellipse cx="24" cy="30" rx="18" ry="11" fill="#4a2a3a" stroke="#aa4466" strokeWidth="1.4"/>
        <polygon points="8,26 4,18 14,24" fill="#ddaacc" stroke="#aa4466" strokeWidth="1"/>
        <polygon points="8,34 4,42 14,36" fill="#ddaacc" stroke="#aa4466" strokeWidth="1"/>
        <ellipse cx="38" cy="30" rx="7" ry="6" fill="#6a3a4a" stroke="#aa4466" strokeWidth="1"/>
        <polygon points="44,28 48,24 46,32" fill="#eeccdd"/>
        <circle cx="40" cy="29" r="1.2" fill="#ff3333"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.7s" repeatCount="indefinite"/></circle>
      </g>
    );
    case 'zealot': return (
      <g>
        <rect x="16" y="22" width="16" height="18" fill="#3a2a0f" stroke="#ffaa33" strokeWidth="1.2" rx="2"/>
        <polygon points="18,27 30,27 27,34 21,34" fill="#ffd700" opacity="0.6"/>
        <ellipse cx="24" cy="14" rx="7" ry="7" fill="#2a1f0f" stroke="#ffaa33" strokeWidth="1.2"/>
        <polygon points="20,7 28,7 27,12 21,12" fill="#ffd700"/>
        <line x1="12" y1="28" x2="4" y2="18" stroke="#aaffff" strokeWidth="2.4"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.4s" repeatCount="indefinite"/></line>
        <line x1="36" y1="28" x2="44" y2="18" stroke="#aaffff" strokeWidth="2.4"><animate attributeName="opacity" values="0.7;1;0.7" dur="0.4s" repeatCount="indefinite"/></line>
      </g>
    );
    case 'stalker': return (
      <g>
        <polygon points="10,38 16,20 20,14 28,14 32,20 38,38 24,32" fill="#3a2a6a" stroke="#aa77ff" strokeWidth="1.3"/>
        <polygon points="18,18 30,18 26,22 22,22" fill="#aa77ff" opacity="0.7"/>
        <circle cx="24" cy="20" r="1.6" fill="#ffffff"><animate attributeName="opacity" values="0.6;1;0.6" dur="1s" repeatCount="indefinite"/></circle>
        <line x1="14" y1="30" x2="10" y2="42" stroke="#3a2a6a" strokeWidth="1.8"/>
        <line x1="34" y1="30" x2="38" y2="42" stroke="#3a2a6a" strokeWidth="1.8"/>
      </g>
    );
    case 'dark-templar': return (
      <g>
        <path d="M 18,12 Q 24,4 30,12 L 32,36 L 28,40 L 20,40 L 16,36 Z" fill="#4a1a6a" stroke="#cc66ff" strokeWidth="1.3"/>
        <path d="M 18,10 Q 24,2 30,10 L 28,16 L 20,16 Z" fill="#3a1054" stroke="#cc66ff" strokeWidth="1"/>
        <circle cx="21" cy="14" r="1.2" fill="#ffffff"/>
        <circle cx="27" cy="14" r="1.2" fill="#ffffff"/>
        <line x1="30" y1="20" x2="42" y2="8" stroke="#cc66ff" strokeWidth="2.6"><animate attributeName="opacity" values="0.6;1;0.6" dur="1s" repeatCount="indefinite"/></line>
      </g>
    );
    case 'high-templar': return (
      <g>
        <path d="M 16,14 Q 24,6 32,14 L 34,38 L 24,42 L 14,38 Z" fill="#6a4a2a" stroke="#ffcc66" strokeWidth="1.3"/>
        <polygon points="20,10 28,10 26,16 22,16" fill="#ffd700"/>
        <circle cx="21" cy="18" r="1.2" fill="#ffffaa"/>
        <circle cx="27" cy="18" r="1.2" fill="#ffffaa"/>
        <circle cx="24" cy="6" r="3" fill="#66ccff" opacity="0.7"><animate attributeName="r" values="2;4;2" dur="1.5s" repeatCount="indefinite"/></circle>
      </g>
    );
    case 'probe': return (
      <g>
        <polygon points="24,8 34,18 32,32 16,32 14,18" fill="#ffaa33" stroke="#ffcc66" strokeWidth="1.3"/>
        <circle cx="24" cy="22" r="6" fill="#4fc3f7" stroke="#88ddff" strokeWidth="1"/>
        <circle cx="24" cy="22" r="3" fill="#ffffff"><animate attributeName="opacity" values="0.7;1;0.7" dur="1.2s" repeatCount="indefinite"/></circle>
        <line x1="14" y1="32" x2="8" y2="40" stroke="#ffcc66" strokeWidth="1.5"/>
        <line x1="34" y1="32" x2="40" y2="40" stroke="#ffcc66" strokeWidth="1.5"/>
      </g>
    );
  }
};

export default function PageAvatar({ size = 48, seed }: Props) {
  const unit = useMemo<UnitId>(() => {
    // Combine page seed + a session-stable random so different page loads rotate
    const sessionSalt = (typeof window !== 'undefined' && (window as any).__mcAvatarSalt) ||
      (typeof window !== 'undefined' ? ((window as any).__mcAvatarSalt = Math.floor(Math.random() * 100000)) : 0);
    const base = seed ? hashSeed(seed) : 0;
    const idx = (base + sessionSalt) % UNITS.length;
    return UNITS[idx];
  }, [seed]);

  return (
    <div style={{ display: 'inline-flex', alignItems: 'center', justifyContent: 'center', width: size, height: size, flexShrink: 0 }}>
      <svg viewBox="0 0 48 48" width={size} height={size} style={{ display: 'block' }}>
        <defs>
          <radialGradient id={`pa-bg-${unit}`} cx="50%" cy="50%" r="60%">
            <stop offset="0%" stopColor="#1a2a4a" stopOpacity="0.8"/>
            <stop offset="100%" stopColor="#05080c" stopOpacity="1"/>
          </radialGradient>
        </defs>
        <circle cx="24" cy="24" r="23" fill={`url(#pa-bg-${unit})`} stroke="#1a3a4a" strokeWidth="1"/>
        <Unit id={unit} />
      </svg>
    </div>
  );
}
