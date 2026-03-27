type StatusType = 'active' | 'idle' | 'offline' | string;

interface StatusDotProps {
  status: StatusType;
}

export function StatusDot({ status }: StatusDotProps) {
  const color =
    status === 'active' ? '#00d2a0' : status === 'idle' ? '#ffa502' : '#5c5c72';
  const glow = status === 'active' ? `0 0 6px #00d2a0` : 'none';

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
