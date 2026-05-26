/**
 * PulseDot — extends StatusDot with an optional pulse animation.
 *
 * The mcPulse @keyframes is defined globally in globals.css under a
 * `@media (prefers-reduced-motion: no-preference)` guard, so when the
 * user has reduced motion enabled the animation simply doesn't run —
 * the dot renders as a static colored circle.
 */

type StatusType = 'active' | 'idle' | 'offline' | string;

interface PulseDotProps {
  status: StatusType;
  pulse?: boolean;
}

export function PulseDot({ status, pulse = false }: PulseDotProps) {
  const isActive = status === 'active';
  const isIdle = status === 'idle';

  const color = isActive
    ? 'var(--color-mc-green)'
    : isIdle
    ? 'var(--color-mc-amber)'
    : 'var(--color-mc-text-muted)';

  const glow = isActive ? `0 0 6px var(--color-mc-green)` : 'none';

  return (
    <span
      style={{
        display: 'inline-block',
        width: 8,
        height: 8,
        borderRadius: '50%',
        background: color,
        boxShadow: glow,
        flexShrink: 0,
        /* mcPulse is defined in globals.css under prefers-reduced-motion guard.
           When pulse=false or when the user prefers reduced motion, animation is none. */
        animation: pulse ? 'mcPulse 2s ease-in-out infinite' : 'none',
      }}
    />
  );
}
