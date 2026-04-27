type StatusType = 'active' | 'idle' | 'offline' | string;

interface StatusDotProps {
  status: StatusType;
}

export function StatusDot({ status }: StatusDotProps) {
  const color =
    status === 'active' ? '#66bb6a' : status === 'idle' ? '#ff9800' : '#607d8b';
  const glow = status === 'active' ? `0 0 6px #66bb6a` : 'none';

  return (
    <span
      style={{
        display: 'inline-block',
        width: 7,
        height: 7,
        borderRadius: '50%',
        background: color,
        boxShadow: glow,
        flexShrink: 0,
      }}
    />
  );
}
