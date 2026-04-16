'use client';

interface SouthParkAgentProps {
  name: string;
  role: string;
  color: string;
  status: 'online' | 'idle' | 'offline';
  activity?: string;
  size?: number;
}

export function SouthParkAgent({ name, role, color, status, activity, size = 80 }: SouthParkAgentProps) {
  const isOnline = status === 'online';
  const isIdle = status === 'idle';
  const statusColor = isOnline ? '#2ed573' : isIdle ? '#ff9800' : '#636e72';

  const s = size;
  const headSize = s * 0.5;
  const bodyH = s * 0.35;
  const bodyW = s * 0.4;

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 6 }}>
      {/* Character */}
      <div
        style={{
          position: 'relative',
          width: s,
          height: s * 1.1,
          animation: isOnline ? 'sp-bounce 2s ease-in-out infinite' : 'none',
        }}
      >
        <style>{`
          @keyframes sp-bounce {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-4px); }
          }
          @keyframes sp-pulse {
            0%, 100% { opacity: 1; }
            50% { opacity: 0.4; }
          }
        `}</style>

        {/* Body */}
        <div style={{
          position: 'absolute',
          bottom: 0,
          left: '50%',
          transform: 'translateX(-50%)',
          width: bodyW,
          height: bodyH,
          background: color,
          border: '2px solid #000',
          borderRadius: '4px 4px 0 0',
        }} />

        {/* Head */}
        <div style={{
          position: 'absolute',
          top: s * 0.05,
          left: '50%',
          transform: 'translateX(-50%)',
          width: headSize,
          height: headSize,
          background: '#f5c18a',
          border: '2.5px solid #000',
          borderRadius: '50%',
        }}>
          {/* Eyes */}
          <div style={{ position: 'absolute', top: '35%', left: '20%', width: 5, height: 5, background: '#000', borderRadius: '50%' }} />
          <div style={{ position: 'absolute', top: '35%', right: '20%', width: 5, height: 5, background: '#000', borderRadius: '50%' }} />
          {/* Mouth */}
          <div style={{ position: 'absolute', bottom: '22%', left: '30%', width: '40%', height: 2, background: '#000', borderRadius: 2 }} />
        </div>

        {/* Status dot */}
        <div style={{
          position: 'absolute',
          top: 2,
          right: 2,
          width: 10,
          height: 10,
          borderRadius: '50%',
          background: statusColor,
          border: '2px solid #0a0a10',
          animation: isOnline ? 'sp-pulse 2s ease-in-out infinite' : 'none',
        }} />
      </div>

      {/* Name badge */}
      <div style={{
        padding: '2px 8px',
        background: `${color}25`,
        border: `1px solid ${color}60`,
        borderRadius: 10,
        fontSize: 11,
        fontWeight: 700,
        color: color,
        fontFamily: "'JetBrains Mono', monospace",
        whiteSpace: 'nowrap',
      }}>
        {name}
      </div>

      {/* Role */}
      <div style={{ fontSize: 10, color: '#455a64', textAlign: 'center', maxWidth: 90, lineHeight: 1.3 }}>
        {role}
      </div>

      {/* Activity */}
      {activity && (
        <div style={{ fontSize: 9, color: '#607d8b', textAlign: 'center', maxWidth: 100, lineHeight: 1.3, fontStyle: 'italic' }}>
          {activity}
        </div>
      )}
    </div>
  );
}

export default SouthParkAgent;
