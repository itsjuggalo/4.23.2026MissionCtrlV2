'use client';
import dynamic from 'next/dynamic';

const AppShellClient = dynamic(
  () => import('@/components/layout/AppShellClient'),
  { ssr: false }
);

export default function OptionsWatcherClient() {
  return <AppShellClient initialPage="OptionsWatcher" />;
}
