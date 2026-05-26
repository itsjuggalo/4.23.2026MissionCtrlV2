/**
 * GradientHeader — section/page header with a cyan→navy gradient accent stripe.
 * Uses only mc-* tokens, no hardcoded hex.
 */

interface GradientHeaderProps {
  title: string;
  subtitle?: string;
  children?: React.ReactNode;
  className?: string;
}

export function GradientHeader({ title, subtitle, children, className = '' }: GradientHeaderProps) {
  return (
    <div
      className={className}
      style={{
        position: 'relative',
        paddingBottom: '12px',
        marginBottom: '16px',
      }}
    >
      {/* Cyan→navy gradient accent stripe */}
      <div
        aria-hidden="true"
        style={{
          position: 'absolute',
          bottom: 0,
          left: 0,
          right: 0,
          height: '2px',
          background:
            'linear-gradient(90deg, var(--color-mc-accent) 0%, var(--color-mc-bg) 100%)',
          borderRadius: '1px',
        }}
      />
      <div style={{ display: 'flex', alignItems: 'baseline', justifyContent: 'space-between', gap: '12px' }}>
        <div>
          <h2
            style={{
              margin: 0,
              fontSize: '18px',
              fontWeight: 700,
              fontFamily: 'var(--font-mc-sans)',
              color: 'var(--color-mc-text)',
              letterSpacing: '-0.2px',
            }}
          >
            {title}
          </h2>
          {subtitle && (
            <p
              style={{
                margin: '2px 0 0',
                fontSize: '11px',
                color: 'var(--color-mc-text-muted)',
                fontFamily: 'var(--font-mc-mono)',
              }}
            >
              {subtitle}
            </p>
          )}
        </div>
        {children && (
          <div style={{ display: 'flex', alignItems: 'center', gap: '8px', flexShrink: 0 }}>
            {children}
          </div>
        )}
      </div>
    </div>
  );
}
