'use client';
import React from 'react';

export default function BattleZerglingRush({ height = 160 }: { height?: number }) {
  const lings = [
    { delay: 0, yOff: 0 },
    { delay: 0.3, yOff: 2 },
    { delay: 0.6, yOff: -2 },
    { delay: 0.9, yOff: 1 },
    { delay: 1.2, yOff: -1 },
    { delay: 1.5, yOff: 0 },
  ];

  return (
    <div style={{ width: '100%', height, background: 'linear-gradient(180deg, #1a0a0a 0%, #0a0a1a 100%)', overflow: 'hidden', position: 'relative', borderRadius: 6 }}>
      <svg viewBox="0 0 800 160" preserveAspectRatio="xMidYMid slice" style={{ width: '100%', height: '100%' }}>
        <defs>
          <filter id="zr-glow"><feGaussianBlur stdDeviation="2.5"/></filter>
          <linearGradient id="zr-ground" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#4a1a1a"/>
            <stop offset="100%" stopColor="#0a0505"/>
          </linearGradient>
          <radialGradient id="zr-creep" cx="50%" cy="100%" r="80%">
            <stop offset="0%" stopColor="#6a1a3a" stopOpacity="0.6"/>
            <stop offset="100%" stopColor="#0a0505" stopOpacity="0"/>
          </radialGradient>
        </defs>
        <rect width="800" height="160" fill="#0a0505"/>
        <rect x="0" y="80" width="800" height="80" fill="url(#zr-creep)"/>
        <rect x="0" y="130" width="800" height="30" fill="url(#zr-ground)"/>
        <line x1="0" y1="130" x2="800" y2="130" stroke="#5a2a2a" strokeWidth="1"/>

        {/* Siege Tank (right) — firing back */}
        <g transform="translate(680,0)">
          {/* treads */}
          <rect x="-42" y="118" width="84" height="12" fill="#2a2a2a" stroke="#555" strokeWidth="1" rx="2"/>
          <circle cx="-32" cy="124" r="4" fill="#1a1a1a" stroke="#666" strokeWidth="0.8"/>
          <circle cx="-16" cy="124" r="4" fill="#1a1a1a" stroke="#666" strokeWidth="0.8"/>
          <circle cx="0" cy="124" r="4" fill="#1a1a1a" stroke="#666" strokeWidth="0.8"/>
          <circle cx="16" cy="124" r="4" fill="#1a1a1a" stroke="#666" strokeWidth="0.8"/>
          <circle cx="32" cy="124" r="4" fill="#1a1a1a" stroke="#666" strokeWidth="0.8"/>
          {/* hull */}
          <rect x="-38" y="98" width="76" height="22" fill="#4a4a2a" stroke="#aa9933" strokeWidth="1.5" rx="3"/>
          <rect x="-32" y="102" width="64" height="4" fill="#aa9933" opacity="0.4"/>
          {/* siege mode outrigger */}
          <rect x="-48" y="112" width="8" height="10" fill="#3a3a1a" stroke="#aa9933" strokeWidth="1"/>
          <rect x="40" y="112" width="8" height="10" fill="#3a3a1a" stroke="#aa9933" strokeWidth="1"/>
          {/* cannon barrel aiming left */}
          <rect x="-80" y="90" width="50" height="10" fill="#2a2a2a" stroke="#888" strokeWidth="1" rx="1"/>
          <rect x="-86" y="88" width="8" height="14" fill="#1a1a1a" stroke="#aa9933" strokeWidth="1"/>
          {/* muzzle flash */}
          <g>
            <circle cx="-88" cy="95" r="0" fill="#ff6600" opacity="0" filter="url(#zr-glow)">
              <animate attributeName="r" values="0;14;0" dur="1.5s" repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;1;0" dur="1.5s" repeatCount="indefinite"/>
            </circle>
            <circle cx="-88" cy="95" r="0" fill="#ffff66" opacity="0">
              <animate attributeName="r" values="0;7;0" dur="1.5s" repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;1;0" dur="1.5s" repeatCount="indefinite"/>
            </circle>
          </g>
        </g>

        {/* Shell arcing through air */}
        <g>
          <circle cx="0" cy="0" r="3" fill="#ffaa33" filter="url(#zr-glow)" opacity="0">
            <animateMotion path="M 595,95 Q 450,30 200,110" dur="1.5s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;1;1;0" dur="1.5s" repeatCount="indefinite"/>
          </circle>
        </g>

        {/* Ground explosion at impact */}
        <g>
          <circle cx="200" cy="115" r="0" fill="#ff6600" filter="url(#zr-glow)" opacity="0">
            <animate attributeName="r" values="0;0;30;0" dur="1.5s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0;1;0" dur="1.5s" repeatCount="indefinite"/>
          </circle>
          <circle cx="200" cy="115" r="0" fill="#ffff66" opacity="0">
            <animate attributeName="r" values="0;0;15;0" dur="1.5s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0;1;0" dur="1.5s" repeatCount="indefinite"/>
          </circle>
        </g>

        {/* ZERGLING SWARM streaming right */}
        {lings.map((l, i) => (
          <g key={i}>
            <animateTransform attributeName="transform" type="translate"
              values={`-40,${l.yOff};560,${l.yOff}`}
              dur="3s" begin={`${l.delay}s`} repeatCount="indefinite"/>
            {/* body */}
            <ellipse cx="0" cy="115" rx="14" ry="9" fill="#6a2a7a" stroke="#bb44dd" strokeWidth="1.2"/>
            {/* back spines */}
            <polygon points="-8,108 -5,102 -2,108" fill="#bb44dd"/>
            <polygon points="-2,108 1,100 4,108" fill="#bb44dd"/>
            <polygon points="4,108 7,103 10,108" fill="#bb44dd"/>
            {/* head */}
            <ellipse cx="12" cy="114" rx="7" ry="6" fill="#8a3a9a" stroke="#bb44dd" strokeWidth="1"/>
            {/* scything claws */}
            <path d="M 16,112 Q 22,108 20,115" fill="none" stroke="#eeccff" strokeWidth="1.8"/>
            <path d="M 16,116 Q 22,120 20,113" fill="none" stroke="#eeccff" strokeWidth="1.8"/>
            {/* glowing eye */}
            <circle cx="14" cy="113" r="1.3" fill="#ffff00">
              <animate attributeName="opacity" values="0.7;1;0.7" dur="0.6s" repeatCount="indefinite"/>
            </circle>
            {/* legs - quick tick */}
            <line x1="-6" y1="122" x2="-8" y2="128" stroke="#4a1a5a" strokeWidth="1.5">
              <animate attributeName="x2" values="-8;-4;-8" dur="0.3s" repeatCount="indefinite"/>
            </line>
            <line x1="2" y1="122" x2="0" y2="128" stroke="#4a1a5a" strokeWidth="1.5">
              <animate attributeName="x2" values="0;4;0" dur="0.3s" repeatCount="indefinite"/>
            </line>
            <line x1="8" y1="122" x2="10" y2="128" stroke="#4a1a5a" strokeWidth="1.5">
              <animate attributeName="x2" values="10;6;10" dur="0.3s" repeatCount="indefinite"/>
            </line>
          </g>
        ))}

        {/* Blood/biomass splatter at tank position — zerglings getting hit */}
        <g>
          <circle cx="600" cy="118" r="0" fill="#aa2244" opacity="0">
            <animate attributeName="r" values="0;6;0" dur="1.5s" begin="0.8s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0.8;0" dur="1.5s" begin="0.8s" repeatCount="indefinite"/>
          </circle>
          <circle cx="620" cy="120" r="0" fill="#661122" opacity="0">
            <animate attributeName="r" values="0;4;0" dur="1.5s" begin="1.1s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0.7;0" dur="1.5s" begin="1.1s" repeatCount="indefinite"/>
          </circle>
        </g>
      </svg>
    </div>
  );
}
