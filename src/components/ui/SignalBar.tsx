import { ProgressBar } from './ProgressBar';

interface SignalBarProps {
  strength: number;
}

export function SignalBar({ strength }: SignalBarProps) {
  const color =
    strength >= 80 ? '#66bb6a' : strength >= 60 ? '#ff9800' : '#607d8b';

  return (
    <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
      <div style={{ width: 50 }}>
        <ProgressBar value={strength} max={100} color={color} height={4} />
      </div>
      <span
        style={{
          fontSize: '12px',
          fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          color,
          minWidth: 24,
        }}
      >
        {strength}
      </span>
    </div>
  );
}
