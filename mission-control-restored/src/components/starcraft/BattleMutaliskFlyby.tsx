'use client';
import React from 'react';

export default function BattleMutaliskFlyby({ height = 160 }: { height?: number }) {
  const mutas = [
    { delay: 0, yBase: 35, size: 1.0 },
    { delay: 0.7, yBase: 50, size: 0.9 },
    { delay: 1.4, yBase: 30, size: 1.1 },
    { delay: 2.1, yBase: 55, size: 0.95 },
  ];
  return (
    <div style={{ width: '100%', height, background: 'linear-gradient(180deg, #0a1022 0%, #1a0a2a 100%)', overflow: 'hidden', position: 'relative', borderRadius: 6 }}>
      <svg viewBox="0 0 800 160" preserveAspectRatio="xMidYMid slice" style={{ width: '100%', height: '100%' }}>
        <defs>
          <filter id="mu-glow"><feGaussianBlur stdDeviation="2"/></filter>
          <radialGradient id="mu-sky" cx="50%" cy="20%" r="80%">
            <stop offset="0%" stopColor="#2a1a5a" stopOpacity="0.5"/>
            <stop offset="100%" stopColor="#0a1022" stopOpacity="0"/>
          </radialGradient>
          <linearGradient id="mu-ground" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#3a1a2a"/>
            <stop offset="100%" stopColor="#0a0510"/>
          </linearGradient>
        </defs>
        <rect width="800" height="160" fill="#0a1022"/>
        <rect width="800" height="160" fill="url(#mu-sky)"/>
        {/* stars/nebula dots */}
        {[25,75,135,200,270,340,420,490,560,630,700,765].map((x,i)=>(
          <circle key={i} cx={x} cy={8+(i*9)%55} r="0.7" fill="#aaccff" opacity={0.3+(i%3)*0.2}>
            <animate attributeName="opacity" values="0.2;0.8;0.2" dur={`${2+i%4}s`} repeatCount="indefinite"/>
          </circle>
        ))}
        <rect x="0" y="130" width="800" height="30" fill="url(#mu-ground)"/>
        <line x1="0" y1="130" x2="800" y2="130" stroke="#3a1a2a" strokeWidth="1"/>

        {/* Ground targets — small marines that get hit */}
        {[320, 480].map((x, i) => (
          <g key={i} transform={`translate(${x},0)`}>
            <rect x="-6" y="114" width="12" height="14" fill="#2a4a7a" stroke="#4a90e2" strokeWidth="1" rx="1"/>
            <rect x="-4" y="108" width="8" height="8" fill="#1a2a4a" stroke="#4a90e2" strokeWidth="0.8" rx="1"/>
            <rect x="-2" y="110" width="4" height="2" fill="#66ccff" opacity="0.9"/>
            {/* impact spark */}
            <circle cx="0" cy="116" r="0" fill="#ff4444" filter="url(#mu-glow)" opacity="0">
              <animate attributeName="r" values="0;8;0" dur="3s" begin={`${1.5+i*0.4}s`} repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;1;0" dur="3s" begin={`${1.5+i*0.4}s`} repeatCount="indefinite"/>
            </circle>
          </g>
        ))}

        {/* MUTALISK SQUADRON */}
        {mutas.map((m, i) => (
          <g key={i}>
            <animateTransform attributeName="transform" type="translate"
              values={`-80,${m.yBase};880,${m.yBase+10}`}
              dur="6s" begin={`${m.delay}s`} repeatCount="indefinite"/>
            <g transform={`scale(${m.size})`}>
              {/* body */}
              <ellipse cx="0" cy="0" rx="18" ry="7" fill="#7a2a4a" stroke="#cc4466" strokeWidth="1.2"/>
              <ellipse cx="-3" cy="-1" rx="10" ry="4" fill="#aa3355" opacity="0.6"/>
              {/* tail */}
              <path d="M -18,0 Q -28,-2 -34,1 Q -28,2 -18,0" fill="#7a2a4a" stroke="#cc4466" strokeWidth="1"/>
              <polygon points="-34,1 -38,-2 -38,3" fill="#aa3355" stroke="#cc4466" strokeWidth="0.8"/>
              {/* head */}
              <ellipse cx="18" cy="0" rx="9" ry="6" fill="#8a3355" stroke="#cc4466" strokeWidth="1.2"/>
              <circle cx="22" cy="-1" r="1.5" fill="#ffff00">
                <animate attributeName="opacity" values="0.7;1;0.7" dur="0.8s" repeatCount="indefinite"/>
              </circle>
              {/* wings - flapping */}
              <g>
                <animateTransform attributeName="transform" type="scale"
                  values="1,1;1,0.4;1,1;1,0.4;1,1" dur="0.4s" repeatCount="indefinite"/>
                <path d="M -6,-4 Q -10,-18 -22,-14 Q -14,-8 -6,-4 Z" fill="#6a2244" stroke="#cc4466" strokeWidth="1"/>
                <path d="M 6,-4 Q 10,-18 22,-14 Q 14,-8 6,-4 Z" fill="#6a2244" stroke="#cc4466" strokeWidth="1"/>
              </g>
              {/* glaive wurm spine */}
              <polygon points="14,3 22,6 14,7" fill="#ddaacc" opacity="0.8"/>
            </g>
          </g>
        ))}

        {/* Glaive wurms firing down — bouncing projectiles */}
        {[0, 1, 2].map(i => (
          <g key={i}>
            <circle cx="0" cy="0" r="2" fill="#ffaaee" filter="url(#mu-glow)" opacity="0">
              <animateMotion
                path={`M ${200+i*120},40 Q ${220+i*120},90 ${250+i*120},118`}
                dur="0.9s" begin={`${1.0+i*0.6}s`} repeatCount="indefinite"/>
              <animate attributeName="opacity" values="0;1;1;0" dur="0.9s" begin={`${1.0+i*0.6}s`} repeatCount="indefinite"/>
            </circle>
          </g>
        ))}
      </svg>
    </div>
  );
}
