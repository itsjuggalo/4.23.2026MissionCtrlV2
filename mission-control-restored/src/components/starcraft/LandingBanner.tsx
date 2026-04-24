'use client';
import React, { useState, useEffect } from 'react';
import BattleMarineVsZealot from './BattleMarineVsZealot';
import BattleZerglingRush from './BattleZerglingRush';
import BattleDarkTemplarAmbush from './BattleDarkTemplarAmbush';
import BattleMutaliskFlyby from './BattleMutaliskFlyby';
import BattleReaverScarab from './BattleReaverScarab';

type Battle = 'marine-zealot' | 'zergling-rush' | 'dt-ambush' | 'muta-flyby' | 'reaver-scarab';

interface Props {
  height?: number;
  persistKey?: string; // localStorage key to remember selection
  showSelector?: boolean;
}

const BATTLES: { id: Battle; label: string; desc: string }[] = [
  { id: 'marine-zealot', label: 'MARINE vs ZEALOT', desc: 'Terran vs Protoss 1v1' },
  { id: 'zergling-rush', label: 'ZERGLING RUSH', desc: 'Swarm vs Siege Tank' },
  { id: 'dt-ambush', label: 'DT AMBUSH', desc: 'Dark Templar strike' },
  { id: 'muta-flyby', label: 'MUTALISK FLYBY', desc: 'Squadron on patrol' },
  { id: 'reaver-scarab', label: 'REAVER SCARAB', desc: 'Protoss siege' },
];

export default function LandingBanner({ height = 160, persistKey = 'mc-landing-battle', showSelector = true }: Props) {
  const [selected, setSelected] = useState<Battle>('marine-zealot');

  useEffect(() => {
    try {
      const saved = typeof window !== 'undefined' ? (window as any).__mcBattle : null;
      if (saved && BATTLES.find(b => b.id === saved)) setSelected(saved);
    } catch {}
  }, []);

  const pick = (id: Battle) => {
    setSelected(id);
    try { (window as any).__mcBattle = id; } catch {}
  };

  const renderBattle = () => {
    switch (selected) {
      case 'marine-zealot': return <BattleMarineVsZealot height={height} />;
      case 'zergling-rush': return <BattleZerglingRush height={height} />;
      case 'dt-ambush': return <BattleDarkTemplarAmbush height={height} />;
      case 'muta-flyby': return <BattleMutaliskFlyby height={height} />;
      case 'reaver-scarab': return <BattleReaverScarab height={height} />;
    }
  };

  return (
    <div style={{ width: '100%' }}>
      {renderBattle()}
      {showSelector && (
        <div style={{
          display: 'flex', gap: '6px', marginTop: '6px', flexWrap: 'wrap',
          justifyContent: 'center', padding: '4px',
        }}>
          {BATTLES.map(b => {
            const active = b.id === selected;
            return (
              <button
                key={b.id}
                onClick={() => pick(b.id)}
                title={b.desc}
                style={{
                  padding: '4px 10px',
                  fontSize: '10px',
                  fontFamily: 'var(--font-mc-mono, monospace)',
                  fontWeight: 700,
                  letterSpacing: '0.8px',
                  background: active ? '#1a3a4a' : '#05080c',
                  color: active ? '#66ccff' : '#607d8b',
                  border: `1px solid ${active ? '#4fc3f7' : '#1a2332'}`,
                  borderRadius: '3px',
                  cursor: 'pointer',
                  transition: 'all 0.15s',
                }}
              >
                {b.label}
              </button>
            );
          })}
        </div>
      )}
    </div>
  );
}
