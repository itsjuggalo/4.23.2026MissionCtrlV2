import dynamic from 'next/dynamic';

// Server-component wrapper that mounts AppShellClient client-side only
const AppShellClient = dynamic(
  () => import('@/components/layout/AppShellClient'),
  { ssr: false }
);

export default function Page() {
  return <AppShellClient initialPage="OptionsWatcher" />;
}
