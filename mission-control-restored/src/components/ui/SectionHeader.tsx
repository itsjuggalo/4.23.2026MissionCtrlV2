interface SectionHeaderProps {
  title: string;
  action?: {
    label: string;
    onClick: () => void;
  };
}

export function SectionHeader({ title, action }: SectionHeaderProps) {
  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
      <span
        style={{
          fontSize: '15px',
          fontWeight: 700,
          fontFamily: "'Inter', -apple-system, BlinkMacSystemFont, sans-serif",
          color: '#e0e0e0',
        }}
      >
        {title}
      </span>
      {action && (
        <button
          onClick={action.onClick}
          style={{
            fontSize: '12px',
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
            color: '#4fc3f7',
            border: '1px solid #4fc3f7',
            borderRadius: '6px',
            padding: '3px 10px',
            background: 'transparent',
            cursor: 'pointer',
          }}
        >
          {action.label}
        </button>
      )}
    </div>
  );
}
