'use client';
import dynamic from 'next/dynamic';

const AppShellClient = dynamic(
  () => import('@/components/layout/AppShellClient').then(m => m.default ?? m),
  { ssr: false }
);

export default function Page() {
  return <AppShellClient initialPage="OptionsWatcher" />;
}
