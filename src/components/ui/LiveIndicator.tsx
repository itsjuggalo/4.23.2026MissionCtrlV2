'use client';

export function LiveIndicator({ connected, lastUpdate }: { connected: boolean; lastUpdate: number | null }) {
  // eslint-disable-next-line react-hooks/purity
  const ago = lastUpdate ? Math.floor((Date.now() - lastUpdate) / 1000) : null;
  return (
    <div style={{ display: 'flex', alignItems: 'center', gap: '8px', padding: '6px 14px', background: connected ? '#66bb6a11' : '#ef535011', border: `1px solid ${connected ? '#66bb6a33' : '#ef535033'}`, borderRadius: '6px' }}>
      <span style={{
        width: '8px', height: '8px', borderRadius: '50%',
        background: connected ? '#66bb6a' : '#ef5350',
        boxShadow: connected ? '0 0 8px #66bb6a88' : '0 0 8px #ef535088',
        animation: connected ? 'livePulse 2s ease-in-out infinite' : 'none',
      }} />
      <style>{`@keyframes livePulse { 0%,100% { opacity:1; box-shadow: 0 0 4px #66bb6a44; } 50% { opacity:0.6; box-shadow: 0 0 12px #66bb6a88; } }`}</style>
      <span style={{ fontSize: '11px', fontWeight: 700, color: connected ? '#66bb6a' : '#ef5350', fontFamily: 'var(--font-mc-mono)', letterSpacing: '1px' }}>
        {connected ? 'LIVE' : 'RECONNECTING'}
      </span>
      {ago !== null && ago < 120 && (
        <span style={{ fontSize: '10px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)' }}>
          {ago}s ago
        </span>
      )}
    </div>
  );
}
