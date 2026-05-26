type Severity = 'green' | 'amber' | 'red' | 'cyan' | 'neutral';

interface BadgeProps {
  children: React.ReactNode;
  /** @deprecated Use severity instead. Kept for one release to avoid breaking existing callers. */
  color?: string;
  severity?: Severity;
}

function hexToRgba(hex: string, alpha: number): string {
  if (!hex || !hex.startsWith('#') || hex.length < 7) return `rgba(0,0,0,${alpha})`;
  const r = parseInt(hex.slice(1, 3), 16);
  const g = parseInt(hex.slice(3, 5), 16);
  const b = parseInt(hex.slice(5, 7), 16);
  return `rgba(${r}, ${g}, ${b}, ${alpha})`;
}

const severityColor: Record<Severity, string> = {
  green: 'var(--color-mc-green)',
  amber: 'var(--color-mc-amber)',
  red: 'var(--color-mc-red)',
  cyan: 'var(--color-mc-accent)',
  neutral: 'var(--color-mc-text-muted)',
};

export function Badge({ children, color, severity = 'neutral' }: BadgeProps) {
  // Legacy hex color prop takes precedence over severity (for backward compat)
  const resolvedColor = color ?? severityColor[severity];

  return (
    <span
      style={{
        fontSize: '11px',
        fontFamily: 'var(--font-mc-mono, "JetBrains Mono", "SF Mono", "Fira Code", monospace)',
        padding: '2px 8px',
        borderRadius: '4px',
        background: color
          ? hexToRgba(color, 0.1)
          : `color-mix(in srgb, ${resolvedColor} 15%, transparent)`,
        color: resolvedColor,
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
