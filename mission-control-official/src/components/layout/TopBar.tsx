'use client';
import { usePathname } from 'next/navigation';

const routeLabels: Record<string, string> = {
  '/dashboard': 'Dashboard',
  '/scanner': 'Scanner',
  '/tasks': 'Tasks',
  '/agents': 'Agents',
  '/approvals': 'Approvals',
  '/activity': 'Activity',
  '/calendar': 'Calendar',
  '/projects': 'Projects',
  '/memory': 'Memory',
  '/docs': 'Docs',
  '/wallets': 'Wallets',
  '/risk': 'Risk',
  '/optimization': 'Optimization',
};

export function TopBar() {
  const pathname = usePathname();
  const label = routeLabels[pathname] ?? 'Mission Control';
  const now = new Date();
  const timeStr = now.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', timeZone: 'UTC' }) + ' UTC';

  return (
    <header className="h-12 flex items-center justify-between px-6 border-b border-[#1f1f1f] bg-[#0a0a0a] flex-shrink-0">
      <span className="text-sm font-medium text-[#888]">{label}</span>
      <div className="flex items-center gap-3">
        <span className="text-xs text-[#555]">{timeStr}</span>
        <span className="px-2 py-0.5 text-xs font-medium bg-yellow-500/10 text-yellow-400 border border-yellow-500/20 rounded">SIM</span>
        <div className="flex items-center gap-1.5">
          <span className="w-2 h-2 rounded-full bg-green-400" />
          <span className="text-xs text-[#888]">Online</span>
        </div>
      </div>
    </header>
  );
}
