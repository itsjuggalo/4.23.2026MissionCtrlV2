interface BadgeProps {
  children: React.ReactNode;
  color: string;
}

function hexToRgba(hex: string, alpha: number): string {
  const r = parseInt(hex.slice(1, 3), 16);
  const g = parseInt(hex.slice(3, 5), 16);
  const b = parseInt(hex.slice(5, 7), 16);
  return `rgba(${r}, ${g}, ${b}, ${alpha})`;
}

export function Badge({ children, color }: BadgeProps) {
  return (
    <span
      style={{
        fontSize: '11px',
        fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
        padding: '2px 8px',
        borderRadius: '4px',
        background: hexToRgba(color, 0.1),
        color,
        fontWeight: 500,
        letterSpacing: '0.3px',
        display: 'inline-block',
        whiteSpace: 'nowrap',
      }}
    >
      {children}
    </span>
  );
}
