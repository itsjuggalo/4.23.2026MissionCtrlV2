'use client';
import dynamic from 'next/dynamic';

const AppShellClient = dynamic(
  () => import('@/components/layout/AppShellClient').then(m => ({ default: m.AppShellClient })),
  { ssr: false }
);

export default function OptionsWatcherClient() {
  return <AppShellClient />;
}
