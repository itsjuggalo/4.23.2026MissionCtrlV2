interface ProgressBarProps {
  value: number;
  max?: number;
  color?: string;
  height?: number;
}

export function ProgressBar({ value, max = 100, color = '#6c5ce7', height = 4 }: ProgressBarProps) {
  const pct = Math.min(100, (value / max) * 100);

  return (
    <div
      style={{
        width: '100%',
        height,
        background: 'rgba(26,26,36,0.8)',
        borderRadius: height / 2,
        overflow: 'hidden',
      }}
    >
      <div
        style={{
          width: `${pct}%`,
          height: '100%',
          background: color,
          borderRadius: height / 2,
          transition: 'width 0.3s ease',
        }}
      />
    </div>
  );
}
