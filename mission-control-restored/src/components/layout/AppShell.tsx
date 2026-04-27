'use client';

import { Suspense } from 'react';
import { AppShellClient } from './AppShellClient';

export function AppShell() {
  return (
    <Suspense fallback={<div>Loading...</div>}>
      <AppShellClient />
    </Suspense>
  );
}
