'use client';
import React from 'react';

export default function BattleMarineVsZealot({ height = 160 }: { height?: number }) {
  return (
    <div style={{ width: '100%', height, background: 'linear-gradient(180deg, #0a0f1a 0%, #1a0f2a 100%)', overflow: 'hidden', position: 'relative', borderRadius: 6 }}>
      <svg viewBox="0 0 800 160" preserveAspectRatio="xMidYMid slice" style={{ width: '100%', height: '100%' }}>
        <defs>
          <radialGradient id="mvz-starfield" cx="50%" cy="30%" r="70%">
            <stop offset="0%" stopColor="#1a2a4a" stopOpacity="0.6"/>
            <stop offset="100%" stopColor="#0a0f1a" stopOpacity="0"/>
          </radialGradient>
          <filter id="mvz-glow"><feGaussianBlur stdDeviation="2.5"/></filter>
          <linearGradient id="mvz-ground" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#2a1f2a"/>
            <stop offset="100%" stopColor="#0a0610"/>
          </linearGradient>
        </defs>
        <rect width="800" height="160" fill="url(#mvz-starfield)"/>
        {[20,80,140,220,300,380,460,540,620,700,760].map((x,i)=>(
          <circle key={i} cx={x} cy={15+(i*7)%40} r="0.8" fill="#8af" opacity={0.4+(i%3)*0.2}>
            <animate attributeName="opacity" values="0.3;0.9;0.3" dur={`${2+i%3}s`} repeatCount="indefinite"/>
          </circle>
        ))}
        <rect x="0" y="130" width="800" height="30" fill="url(#mvz-ground)"/>
        <line x1="0" y1="130" x2="800" y2="130" stroke="#3a2a4a" strokeWidth="1"/>

        {/* MARINE (left) - stimming and firing */}
        <g transform="translate(140,0)">
          <g>
            <animateTransform attributeName="transform" type="translate" values="0,0;2,-1;0,0;-2,0;0,0" dur="0.4s" repeatCount="indefinite"/>
            <rect x="-18" y="85" width="36" height="38" fill="#1e3a5f" stroke="#4a90e2" strokeWidth="1.5" rx="3"/>
            <rect x="-16" y="88" width="32" height="6" fill="#4a90e2" opacity="0.6"/>
            <ellipse cx="-20" cy="88" rx="8" ry="10" fill="#2a4a7a" stroke="#4a90e2" strokeWidth="1.5"/>
            <ellipse cx="20" cy="88" rx="8" ry="10" fill="#2a4a7a" stroke="#4a90e2" strokeWidth="1.5"/>
            <rect x="-12" y="70" width="24" height="18" fill="#1a2a4a" stroke="#4a90e2" strokeWidth="1.5" rx="3"/>
            <rect x="-8" y="76" width="16" height="4" fill="#66ccff" opacity="0.9">
              <animate attributeName="opacity" values="0.6;1;0.6" dur="1.5s" repeatCount="indefinite"/>
            </rect>
            <rect x="-12" y="120" width="10" height="15" fill="#1e3a5f" stroke="#4a90e2" strokeWidth="1"/>
            <rect x="2" y="120" width="10" height="15" fill="#1e3a5f" stroke="#4a90e2" strokeWidth="1"/>
            <rect x="18" y="95" width="45" height="6" fill="#3a3a3a" stroke="#888" strokeWidth="0.8"/>
            <rect x="60" y="93" width="8" height="10" fill="#222" stroke="#666" strokeWidth="0.8"/>
            <g>
              <polygon points="68,98 82,95 82,101 68,99" fill="#ffcc00" opacity="0">
                <animate attributeName="opacity" values="0;1;0;0;1;0;0" dur="0.8s" repeatCount="indefinite"/>
              </polygon>
              <circle cx="75" cy="98" r="4" fill="#ffffff" opacity="0">
                <animate attributeName="opacity" values="0;1;0;0;1;0;0" dur="0.8s" repeatCount="indefinite"/>
              </circle>
            </g>
            <line x1="82" y1="98" x2="120" y2="98" stroke="#ffee66" strokeWidth="1.5" opacity="0">
              <animate attributeName="opacity" values="0;1;0;0" dur="0.8s" repeatCount="indefinite"/>
              <animate attributeName="x2" values="82;280;280" dur="0.8s" repeatCount="indefinite"/>
            </line>
            <rect x="-20" y="62" width="40" height="4" fill="#1a1a1a" stroke="#4a90e2" strokeWidth="0.5"/>
            <rect x="-19" y="63" width="32" height="2" fill="#66ff66">
              <animate attributeName="width" values="32;30;32;28;32" dur="4s" repeatCount="indefinite"/>
            </rect>
          </g>
        </g>

        {/* ZEALOT (right) - charges in with psi-blades */}
        <g>
          <animateTransform attributeName="transform" type="translate" values="750,0;700,0;660,0;630,0;610,0;610,0;620,0;660,0;720,0;750,0" dur="4s" repeatCount="indefinite"/>
          <rect x="-10" y="118" width="7" height="17" fill="#5a3a0f" stroke="#ffaa33" strokeWidth="1"/>
          <rect x="3" y="118" width="7" height="17" fill="#5a3a0f" stroke="#ffaa33" strokeWidth="1"/>
          <rect x="-16" y="82" width="32" height="38" fill="#3a2a0f" stroke="#ffaa33" strokeWidth="1.5" rx="4"/>
          <polygon points="-10,88 10,88 6,105 -6,105" fill="#ffd700" opacity="0.5"/>
          <path d="M -22,82 Q -26,78 -22,74 L -14,80 Z" fill="#ffaa33" stroke="#8a5a0f" strokeWidth="1"/>
          <path d="M 22,82 Q 26,78 22,74 L 14,80 Z" fill="#ffaa33" stroke="#8a5a0f" strokeWidth="1"/>
          <ellipse cx="0" cy="72" rx="11" ry="13" fill="#2a1f0f" stroke="#ffaa33" strokeWidth="1.5"/>
          <polygon points="-6,62 6,62 4,68 -4,68" fill="#ffd700"/>
          <circle cx="-4" cy="74" r="1.5" fill="#ff3300">
            <animate attributeName="opacity" values="0.7;1;0.7" dur="1s" repeatCount="indefinite"/>
          </circle>
          <circle cx="4" cy="74" r="1.5" fill="#ff3300">
            <animate attributeName="opacity" values="0.7;1;0.7" dur="1s" repeatCount="indefinite"/>
          </circle>
          <g>
            <line x1="-22" y1="95" x2="-55" y2="78" stroke="#aaffff" strokeWidth="3" filter="url(#mvz-glow)" opacity="0.9"/>
            <line x1="-22" y1="95" x2="-55" y2="78" stroke="#ffffff" strokeWidth="1.5"/>
            <circle cx="-22" cy="95" r="4" fill="#aaffff" filter="url(#mvz-glow)" opacity="0.9">
              <animate attributeName="r" values="3;5;3" dur="0.4s" repeatCount="indefinite"/>
            </circle>
          </g>
          <g>
            <line x1="22" y1="95" x2="55" y2="78" stroke="#aaffff" strokeWidth="3" filter="url(#mvz-glow)" opacity="0.9"/>
            <line x1="22" y1="95" x2="55" y2="78" stroke="#ffffff" strokeWidth="1.5"/>
            <circle cx="22" cy="95" r="4" fill="#aaffff" filter="url(#mvz-glow)" opacity="0.9">
              <animate attributeName="r" values="3;5;3" dur="0.4s" repeatCount="indefinite"/>
            </circle>
          </g>
          <rect x="-20" y="58" width="40" height="4" fill="#1a1a1a" stroke="#ffaa33" strokeWidth="0.5"/>
          <rect x="-19" y="59" width="36" height="2" fill="#66ff66">
            <animate attributeName="width" values="36;36;34;36;30;36" dur="4s" repeatCount="indefinite"/>
          </rect>
          <ellipse cx="0" cy="100" rx="28" ry="36" fill="none" stroke="#aaccff" strokeWidth="1" opacity="0.2">
            <animate attributeName="opacity" values="0.1;0.4;0.1" dur="2s" repeatCount="indefinite"/>
          </ellipse>
        </g>

        {/* Impact sparks mid-field */}
        <g>
          <circle cx="400" cy="98" r="0" fill="#ffaa44" opacity="0">
            <animate attributeName="r" values="0;8;0" dur="0.6s" begin="0.2s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;1;0" dur="0.6s" begin="0.2s" repeatCount="indefinite"/>
          </circle>
          <circle cx="400" cy="98" r="0" fill="#ffff88" opacity="0">
            <animate attributeName="r" values="0;4;0" dur="0.6s" begin="0.2s" repeatCount="indefinite"/>
            <animate attributeName="opacity" values="0;1;0" dur="0.6s" begin="0.2s" repeatCount="indefinite"/>
          </circle>
        </g>
      </svg>
    </div>
  );
}
