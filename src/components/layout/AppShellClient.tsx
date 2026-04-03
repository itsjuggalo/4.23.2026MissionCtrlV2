'use client';

import { useSearchParams } from 'next/navigation';
import { useEffect, useState } from 'react';
import type { Approval } from '@/lib/types';
import { approvals as initialApprovals, signals } from '@/lib/mock-data';
import { Sidebar } from './Sidebar';
import { Header } from './Header';
import { DashboardPage } from '../pages/DashboardPage';
import { ScannerPage } from '../pages/ScannerPage';
import { TasksPage } from '../pages/TasksPage';
import { AgentsPage } from '../pages/AgentsPage';
import { ApprovalsPage } from '../pages/ApprovalsPage';
import { CalendarPage } from '../pages/CalendarPage';
import { ProjectsPage } from '../pages/ProjectsPage';
import { MemoryPage } from '../pages/MemoryPage';
import { DocsPage } from '../pages/DocsPage';
import { WalletsPage } from '../pages/WalletsPage';
import { TradesPage } from '../pages/TradesPage';
import { ActivityPage } from '../pages/ActivityPage';
import { RiskPage } from '../pages/RiskPage';
import { SignalsPage } from '../pages/SignalsPage';
import { TelegramSignalsPage } from '../pages/TelegramSignalsPage';
import { MemoryGraphPage } from '../pages/MemoryGraphPage';
import { OfficePage } from '../pages/OfficePage';
import { ChartPage } from '../pages/ChartPage';
import { PowerTraderPage } from '../pages/PowerTraderPage';
import { PsychChatWidget } from '../ui/PsychChatWidget';

type PageName =
  | 'Dashboard'
  | 'Signals'
  | 'Telegram'
  | 'Scanner'
  | 'Tasks'
  | 'Agents'
  | 'Approvals'
  | 'Calendar'
  | 'Projects'
  | 'Memory'
  | 'Memory Graph'
  | 'Office'
  | 'Docs'
  | 'Wallets'
  | 'Trades'
  | 'Activity'
  | 'Risk'
  | 'Chart'
  | 'PowerTrader';

export function AppShellClient() {
  const searchParams = useSearchParams();
  const [activePage, setActivePage] = useState<PageName>('Dashboard');
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [approvals, setApprovals] = useState<Approval[]>(initialApprovals);

  const newSignalsCount = signals.filter((s) => s.status === 'new').length;
  const pendingApprovalsCount = approvals.filter((a) => a.status === 'pending').length;

  // Handle query parameter for page navigation
  useEffect(() => {
    const page = searchParams.get('page');
    if (page) {
      const pageName = (page.charAt(0).toUpperCase() + page.slice(1).toLowerCase()) as PageName;
      const validPages: PageName[] = [
        'Dashboard', 'Signals', 'Telegram', 'Scanner', 'Tasks', 'Agents', 
        'Approvals', 'Calendar', 'Projects', 'Memory', 'Memory Graph', 
        'Office', 'Docs', 'Wallets', 'Trades', 'Activity', 'Risk', 'Chart', 'PowerTrader'
      ];
      if (validPages.includes(pageName)) {
        setActivePage(pageName);
      }
    }
  }, [searchParams]);

  function handleApprovalUpdate(id: number, status: 'approved' | 'rejected') {
    setApprovals((prev) =>
      prev.map((a) => (a.id === id ? { ...a, status } : a))
    );
  }

  function renderPage() {
    switch (activePage) {
      case 'Dashboard':
        return <DashboardPage />;
      case 'Signals':
        return <SignalsPage />;
      case 'Telegram':
        return <TelegramSignalsPage />;
      case 'Scanner':
        return <ScannerPage />;
      case 'Tasks':
        return <TasksPage />;
      case 'Agents':
        return <AgentsPage />;
      case 'Approvals':
        return <ApprovalsPage approvals={approvals} onUpdate={handleApprovalUpdate} />;
      case 'Calendar':
        return <CalendarPage />;
      case 'Projects':
        return <ProjectsPage />;
      case 'Memory':
        return <MemoryPage />;
      case 'Memory Graph':
        return <MemoryGraphPage />;
      case 'Office':
        return <OfficePage />;
      case 'Docs':
        return <DocsPage />;
      case 'Wallets':
        return <WalletsPage />;
      case 'Trades':
        return <TradesPage />;
      case 'Activity':
        return <ActivityPage />;
      case 'Chart':
        return <ChartPage />;
      case 'PowerTrader':
        return <PowerTraderPage />;
      case 'Risk':
        return <RiskPage />;
      default:
        return <DashboardPage />;
    }
  }

  return (
    <div className="flex h-screen bg-slate-950 text-slate-100">
      <Sidebar activePage={activePage} onNavigate={setActivePage} isCollapsed={isCollapsed} onToggle={() => setIsCollapsed(!isCollapsed)} newSignalsCount={newSignalsCount} pendingApprovalsCount={pendingApprovalsCount} />
      <div className="flex-1 flex flex-col overflow-hidden">
        <Header title={activePage} />
        <main className="flex-1 overflow-auto">
          {renderPage()}
        </main>
      </div>
      <PsychChatWidget />
    </div>
  );
}
