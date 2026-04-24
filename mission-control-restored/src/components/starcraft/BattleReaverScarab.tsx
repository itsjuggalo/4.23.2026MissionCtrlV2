'use client';
import React from 'react';

export default function BattleReaverScarab({ height = 160 }: { height?: number }) {
  return (
    <div style={{ width: '100%', height, background: 'linear-gradient(180deg, #1a1206 0%, #0a0a2a 100%)', overflow: 'hidden', position: 'relative', borderRadius: 6 }}>
      <svg viewBox="0 0 800 160" preserveAspectRatio="xMidYMid slice" style={{ width: '100%', height: '100%' }}>
        <defs>
          <filter id="rs-glow"><feGaussianBlur stdDeviation="2.5"/></filter>
          <filter id="rs-strong"><feGaussianBlur stdDeviation="5"/></filter>
          <linearGradient id="rs-ground" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#4a3a1a"/>
            <stop offset="100%" stopColor="#0a0605"/>
          </linearGradient>
          <radialGradient id="rs-sun" cx="80%" cy="40%" r="40%">
            <stop offset="0%" stopColor="#ffaa33" stopOpacity="0.3"/>
            <stop offset="100%" stopColor="#0a0605" stopOpacity="0"/>
          </radialGradient>
        </defs>
        <rect width="800" height="160" fill="#0a0605"/>
        <rect width="800" height="160" fill="url(#rs-sun)"/>
        <rect x="0" y="130" width="800" height="30" fill="url(#rs-ground)"/>
        <line x1="0" y1="130" x2="800" y2="130" stroke="#5a4a1a" strokeWidth="1"/>

        {/* Targets on the right — small zerglings/marines to destroy */}
        {[540, 600, 660, 720].map((x, i) => (
          <g key={i} transform={`translate(${x},0)`}>
            <ellipse cx="0" cy="118" rx="8" ry="5" fill="#6a2a7a" stroke="#bb44dd" strokeWidth="1"/>
            <ellipse cx="6" cy="117" rx="4" ry="3" fill="#8a3a9a" stroke="#bb44dd" strokeWidth="0.8"/>
            <circle cx="7" cy="116" r="0.8" fill="#ffff00"/>
            {/* explosion when scarab hits */}
            <circle cx="0" cy="115" r="0" fill="#ff6600" filter="url(#rs-glow)" opacity="0">
              <animate attributeName="r" values="0;0;0;15;0" dur="3.5s" begin={`${1.8+i*0.15}s`} repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;0;0;1;0" dur="3.5s" begin={`${1.8+i*0.15}s`} repeatCount="indefinite"/>
            </circle>
          </g>
        ))}

        {/* REAVER — rolls in from left */}
        <g>
          <animateTransform attributeName="transform" type="translate"
            values="-80,0;140,0;140,0;140,0" dur="3.5s" repeatCount="indefinite"/>
          {/* main body - shell */}
          <ellipse cx="0" cy="106" rx="38" ry="22" fill="#ffaa33" stroke="#cc8822" strokeWidth="2"/>
          <ellipse cx="0" cy="101" rx="30" ry="15" fill="#ffcc55" opacity="0.5"/>
          {/* spines on back */}
          <polygon points="-20,88 -16,80 -12,88" fill="#cc8822" stroke="#996611" strokeWidth="0.8"/>
          <polygon points="-6,85 -2,75 2,85" fill="#cc8822" stroke="#996611" strokeWidth="0.8"/>
          <polygon points="8,85 12,76 16,85" fill="#cc8822" stroke="#996611" strokeWidth="0.8"/>
          <polygon points="20,88 24,81 28,88" fill="#cc8822" stroke="#996611" strokeWidth="0.8"/>
          {/* central glowing core */}
          <circle cx="0" cy="100" r="6" fill="#ffff88" filter="url(#rs-glow)">
            <animate attributeName="r" values="5;8;5" dur="1.2s" repeatCount="indefinite"/>
          </circle>
          <circle cx="0" cy="100" r="3" fill="#ffffff"/>
          {/* front sensor */}
          <ellipse cx="28" cy="106" rx="6" ry="4" fill="#ff3300" filter="url(#rs-glow)">
            <animate attributeName="opacity" values="0.7;1;0.7" dur="1s" repeatCount="indefinite"/>
          </ellipse>
          {/* rolling tracks / mechanical underside */}
          <g>
            <circle cx="-25" cy="125" r="5" fill="#664411" stroke="#cc8822" strokeWidth="1">
              <animateTransform attributeName="transform" type="rotate" from="0" to="360" dur="0.8s" repeatCount="indefinite"/>
            </circle>
            <circle cx="-10" cy="125" r="5" fill="#664411" stroke="#cc8822" strokeWidth="1"/>
            <circle cx="10" cy="125" r="5" fill="#664411" stroke="#cc8822" strokeWidth="1"/>
            <circle cx="25" cy="125" r="5" fill="#664411" stroke="#cc8822" strokeWidth="1"/>
          </g>
          {/* launch flash during scarab launch */}
          <circle cx="30" cy="100" r="0" fill="#ffff88" filter="url(#rs-strong)" opacity="0">
            <animate attributeName="r" values="0;0;0;12;0" dur="3.5s" begin="1.4s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0;0;1;0" dur="3.5s" begin="1.4s" repeatCount="indefinite"/>
          </circle>
        </g>

        {/* SCARABS — 4 launched in sequence, arc to targets */}
        {[0, 1, 2, 3].map(i => (
          <g key={i}>
            <circle cx="0" cy="0" r="3" fill="#ffff66" filter="url(#rs-glow)" opacity="0">
              <animateMotion
                path={`M 175,95 Q ${300+i*40},40 ${540+i*60},113`}
                dur="0.7s" begin={`${1.5+i*0.15}s`} repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;1;1;0" dur="0.7s" begin={`${1.5+i*0.15}s`} repeatCount="indefinite"/>
            </circle>
            {/* trail */}
            <circle cx="0" cy="0" r="1.5" fill="#ffaa33" opacity="0">
              <animateMotion
                path={`M 175,95 Q ${300+i*40},40 ${540+i*60},113`}
                dur="0.7s" begin={`${1.55+i*0.15}s`} repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;0.6;0" dur="0.7s" begin={`${1.55+i*0.15}s`} repeatCount="indefinite"/>
            </circle>
          </g>
        ))}

        {/* Dust kicked up by reaver treads */}
        {[0, 1, 2].map(i => (
          <circle key={i} cx="0" cy="0" r="1.5" fill="#aa8844" opacity="0">
            <animateMotion
              path={`M 120,128 Q ${100-i*15},120 ${80-i*20},125`}
              dur="1.2s" begin={`${0.8+i*0.2}s`} repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;0.6;0" dur="1.2s" begin={`${0.8+i*0.2}s`} repeatCount="indefinite"/>
          </circle>
        ))}
      </svg>
    </div>
  );
}
