'use client';
import { Suspense } from 'react';
import { AppShellClient } from '../../components/layout/AppShellClient';

export default function OptionsPageRoute() {
  return (
    <Suspense fallback={<div style={{ background: '#0d1117', height: '100vh' }} />}>
      <AppShellClient initialPage="Options" />
    </Suspense>
  );
}
