'use client';
import { useLiveStream } from '@/hooks/useLiveStream';
import { LiveIndicator } from '@/components/ui/LiveIndicator';
import { useEffect, useState } from 'react';

const SUBTITLES: Record<string, string> = {
  'Command Center': 'Power Overwhelming',
  'Performance': 'Operation CWAL',
  'Regime': 'Black Sheep Wall',
  'Activity': 'The Gathering',
  'Dashboard': 'Something For Nothing',
  'TV Chart': 'War Aint What It Used To Be',
  'Scanner': 'Breathe Deep',
  'Wallets': 'Show Me The Money',
  'Trades': 'Whats Mine Is Mine',
  'GoTrader': 'There Is No Cow Level',
  'PowerTrader': 'Medieval Man',
  'Risk': 'Staying Alive',
  'Office': 'Food For Thought',
  'Agents': 'Radio Free Zerg',
  'Memory': 'Ophelia',
  'Signals': 'Modify The Phase Variance',
  'Telegram': 'Noglues',
  'Approvals': 'Game Over Man',
  'Calendar': 'En Taro Adun',
  'Tasks': 'Need A Light?',
  'Projects': 'Spawn More Overlords',
  'Usage': 'Not Enough Minerals',
  'Congress': 'Nuclear Launch Detected',
  'LLM Portfolio': 'My Life For Aiur',
  'Skills': 'Spawn More Overlords',
  'Docs': 'You Must Construct Additional Pylons',
};

interface HeaderProps {
  title: string;
}
export function Header({
 title }: HeaderProps) {
  const live = useLiveStream(true);
  const [time, setTime] = useState('');
  useEffect(() => {
    const update = () => {
      setTime(new Date().toLocaleTimeString('en-US', { hour12: false }));
    };
    update();
    const id = setInterval(update, 1000);
    return () => clearInterval(id);
  }, []);
  const subtitle = SUBTITLES[title] || '';
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
      <div style={{ display: 'flex', alignItems: 'baseline', gap: 12 }}>
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
        {subtitle && (
          <span
            style={{
              fontSize: 12,
              fontFamily: "'JetBrains Mono', 'SF Mono', monospace",
              color: '#4fc3f7',
              fontStyle: 'italic',
              letterSpacing: '0.5px',
            }}
          >
            {subtitle}
          </span>
        )}
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
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