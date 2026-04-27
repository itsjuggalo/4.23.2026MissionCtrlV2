'use client';
import React from 'react';

export default function BattleDarkTemplarAmbush({ height = 160 }: { height?: number }) {
  return (
    <div style={{ width: '100%', height, background: 'linear-gradient(180deg, #0a0a1a 0%, #1a0a1a 100%)', overflow: 'hidden', position: 'relative', borderRadius: 6 }}>
      <svg viewBox="0 0 800 160" preserveAspectRatio="xMidYMid slice" style={{ width: '100%', height: '100%' }}>
        <defs>
          <filter id="dt-glow"><feGaussianBlur stdDeviation="2.5"/></filter>
          <filter id="dt-strong"><feGaussianBlur stdDeviation="5"/></filter>
          <linearGradient id="dt-ground" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#2a1a2a"/>
            <stop offset="100%" stopColor="#050505"/>
          </linearGradient>
          <radialGradient id="dt-ambient" cx="50%" cy="40%" r="70%">
            <stop offset="0%" stopColor="#3a1a4a" stopOpacity="0.3"/>
            <stop offset="100%" stopColor="#050505" stopOpacity="0"/>
          </radialGradient>
        </defs>
        <rect width="800" height="160" fill="#050505"/>
        <rect width="800" height="160" fill="url(#dt-ambient)"/>
        {/* sparse dim stars */}
        {[40,120,200,280,360,440,520,600,680,760].map((x,i)=>(
          <circle key={i} cx={x} cy={20+(i*11)%30} r="0.6" fill="#aaaaff" opacity={0.2+(i%3)*0.15}/>
        ))}
        <rect x="0" y="130" width="800" height="30" fill="url(#dt-ground)"/>
        <line x1="0" y1="130" x2="800" y2="130" stroke="#3a2a3a" strokeWidth="1"/>

        {/* SCV walking patrol — unaware */}
        <g transform="translate(240,0)">
          {/* main chassis */}
          <rect x="-18" y="94" width="36" height="28" fill="#ffaa33" stroke="#ff8800" strokeWidth="1.5" rx="4"/>
          <rect x="-14" y="98" width="28" height="6" fill="#ffcc66" opacity="0.5"/>
          {/* cockpit */}
          <rect x="-10" y="80" width="20" height="16" fill="#2a3a5a" stroke="#66aaff" strokeWidth="1.2" rx="3"/>
          <rect x="-6" y="84" width="12" height="5" fill="#88ccff" opacity="0.8">
            <animate attributeName="opacity" values="0.5;0.9;0.5" dur="2s" repeatCount="indefinite"/>
          </rect>
          {/* arm/drill */}
          <rect x="14" y="100" width="22" height="6" fill="#aa7722" stroke="#ff8800" strokeWidth="1"/>
          <polygon points="36,97 50,103 36,109" fill="#888" stroke="#ccc" strokeWidth="1"/>
          {/* legs - walking bob */}
          <g>
            <animateTransform attributeName="transform" type="translate" values="0,0;0,1;0,0;0,1;0,0" dur="1s" repeatCount="indefinite"/>
            <rect x="-14" y="120" width="10" height="12" fill="#aa7722" stroke="#ff8800" strokeWidth="1"/>
            <rect x="4" y="120" width="10" height="12" fill="#aa7722" stroke="#ff8800" strokeWidth="1"/>
          </g>
          {/* hit effect — SCV gets slashed at t=2s */}
          <g opacity="0">
            <animate attributeName="opacity" values="0;0;0;1;1;0;0" dur="5s" repeatCount="indefinite"/>
            <line x1="-20" y1="85" x2="20" y2="125" stroke="#ffffff" strokeWidth="2" opacity="0.9"/>
            <circle cx="0" cy="105" r="8" fill="#ff6600" filter="url(#dt-glow)"/>
            <circle cx="0" cy="105" r="4" fill="#ffff00"/>
          </g>
        </g>

        {/* DARK TEMPLAR — phases in, slashes, vanishes */}
        <g>
          {/* Phase 1: barely visible shimmer approaching */}
          <g opacity="0">
            <animate attributeName="opacity" values="0;0.15;0.25;0.4;0;0" dur="5s" repeatCount="indefinite"/>
            <animateTransform attributeName="transform" type="translate" values="500,0;420,0;340,0;290,0;290,0;290,0" dur="5s" repeatCount="indefinite"/>
            {/* body outline */}
            <path d="M -12,75 L -14,95 L -10,118 L 10,118 L 14,95 L 12,75 L 8,70 L -8,70 Z"
              fill="#6a2a8a" stroke="#cc66ff" strokeWidth="1" opacity="0.5"/>
            {/* hood */}
            <path d="M -12,70 Q 0,55 12,70 L 8,82 L -8,82 Z" fill="#4a1a6a" stroke="#cc66ff" strokeWidth="1"/>
            {/* glowing eyes */}
            <circle cx="-3" cy="74" r="1.2" fill="#ffffff" filter="url(#dt-glow)"/>
            <circle cx="3" cy="74" r="1.2" fill="#ffffff" filter="url(#dt-glow)"/>
          </g>

          {/* Phase 2: warp blade slash — only appears at t=2s */}
          <g opacity="0">
            <animate attributeName="opacity" values="0;0;0;1;0;0;0" dur="5s" repeatCount="indefinite"/>
            <animateTransform attributeName="transform" type="translate" values="290,0" dur="5s" repeatCount="indefinite"/>
            {/* warp blade arc - lightning curve */}
            <path d="M 10,70 Q 30,90 40,115" stroke="#cc66ff" strokeWidth="4" fill="none" filter="url(#dt-strong)" opacity="0.9"/>
            <path d="M 10,70 Q 30,90 40,115" stroke="#ffffff" strokeWidth="1.5" fill="none"/>
            {/* impact burst */}
            <circle cx="40" cy="115" r="10" fill="#cc66ff" filter="url(#dt-strong)" opacity="0.8"/>
            <circle cx="40" cy="115" r="4" fill="#ffffff"/>
          </g>

          {/* Phase 3: vanish puff */}
          <g opacity="0">
            <animate attributeName="opacity" values="0;0;0;0;1;0;0" dur="5s" repeatCount="indefinite"/>
            <circle cx="290" cy="95" r="15" fill="none" stroke="#aa44cc" strokeWidth="2" opacity="0.7" filter="url(#dt-glow)"/>
            <circle cx="290" cy="95" r="8" fill="none" stroke="#ffffff" strokeWidth="1" opacity="0.9"/>
          </g>
        </g>

        {/* Ambient psionic particles drifting */}
        {[150, 350, 550].map((x, i) => (
          <circle key={i} cx={x} cy="50" r="1" fill="#cc66ff" opacity="0.5">
            <animate attributeName="cy" values="50;40;50" dur={`${3+i}s`} repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0.2;0.7;0.2" dur={`${3+i}s`} repeatCount="indefinite"/>
          </circle>
        ))}

        {/* Cinematic vignette */}
        <rect x="0" y="0" width="800" height="12" fill="#000"/>
        <rect x="0" y="148" width="800" height="12" fill="#000"/>
      </svg>
    </div>
  );
}
