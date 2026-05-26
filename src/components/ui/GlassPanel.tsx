/**
 * GlassPanel — glassmorphism container.
 *
 * Backdrop blur is applied only when the browser supports it
 * (`@supports (backdrop-filter: blur(4px))`). When
 * `prefers-reduced-transparency` is active the blur layer is
 * omitted and a solid background is used instead.
 *
 * The gradient top stripe (mc-accent → transparent) is purely
 * decorative and does not affect text contrast.
 */

interface GlassPanelProps {
  children: React.ReactNode;
  className?: string;
  style?: React.CSSProperties;
}

export function GlassPanel({ children, className = '', style }: GlassPanelProps) {
  return (
    <div
      className={`glass-panel ${className}`}
      style={style}
    >
      {/* Gradient accent stripe at the top */}
      <div className="glass-panel-stripe" aria-hidden="true" />
      <div className="glass-panel-content">{children}</div>
    </div>
  );
}
