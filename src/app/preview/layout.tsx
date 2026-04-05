'use client';

import { useState } from 'react';
import { Sidebar } from '@/components/layout/Sidebar';
import { Header } from '@/components/layout/Header';
import type { Approval } from '@/lib/types';
import { approvals as initialApprovals, signals } from '@/lib/mock-data';

type PageName = 'Dashboard' | 'Signals' | 'Telegram' | 'Scanner' | 'Tasks' | 'Agents' |
  'Approvals' | 'Calendar' | 'Projects' | 'Memory' | 'Memory Graph' | 'Office' | 'Docs' |
  'Wallets' | 'Trades' | 'Activity' | 'Risk' | 'Chart' | 'PowerTrader' | 'Command Center' |
  'Performance' | 'Regime';

export default function PreviewLayout({ children }: { children: React.ReactNode }) {
  const [activePage, setActivePage] = useState<PageName>('Dashboard');
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [approvals] = useState<Approval[]>(initialApprovals);

  const newSignalsCount = signals.filter((s) => s.status === 'new').length;
  const pendingApprovalsCount = approvals.filter((a) => a.status === 'pending').length;

  return (
    <div className="flex h-screen bg-slate-950 text-slate-100">
      <Sidebar
        activePage={activePage}
        onNavigate={(page) => setActivePage(page as PageName)}
        isCollapsed={isCollapsed}
        onToggle={() => setIsCollapsed(!isCollapsed)}
        newSignalsCount={newSignalsCount}
        pendingApprovalsCount={pendingApprovalsCount}
      />
      <div className="flex-1 flex flex-col overflow-hidden">
        <Header title="Preview" />
        <main className="flex-1 overflow-auto">
          {children}
        </main>
      </div>
    </div>
  );
}
