'use client';
import dynamic from 'next/dynamic';

const Office3D = dynamic(() => import('@/components/Office3D/Office3D'), {
  ssr: false,
  loading: () => (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100vh', background: '#0a1929', color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)', fontSize: '18px' }}>
      Loading 3D Office...
    </div>
  ),
});

export function OfficePage() {
  return <Office3D />;
}
