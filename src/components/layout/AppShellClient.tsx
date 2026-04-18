'use client';

import { useSearchParams } from 'next/navigation';
import { useEffect, useState } from 'react';
import type { Approval } from '@/lib/types';
const initialApprovals: any[] = []; const signals: any[] = [];
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
import { AlertsPage } from '../pages/AlertsPage';
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
import { CommandCenterPage } from '../pages/CommandCenterPage';
import { PerformancePage } from '../pages/PerformancePage';
import { RegimePage } from '../pages/RegimePage';
import UsagePage from '../pages/UsagePage';
import { CongressPage } from '../pages/CongressPage';
import { LLMPortfolioPage } from '../pages/LLMPortfolioPage';
import { SkillsPage } from "../pages/SkillsPage";
import { TelegramPage } from '@/components/pages/TelegramPage';
import { OptionsPage } from '@/components/pages/OptionsPage';
import { SessionViewerPage } from '@/components/pages/SessionViewerPage';
import { PsychChatWidget } from '../ui/PsychChatWidget';

type PageName =
  | 'Dashboard'
  | 'Signals'
  | 'Telegram'
  | 'Scanner'
  | 'Tasks'
  | 'Sessions'
  | 'Options'
  | 'Agents'
  | 'Approvals'
  | 'Calendar'
  | 'Projects'
  | 'Memory'
  | 'Memory Graph'
  | 'Office'
  | 'Alerts'
  | 'Docs'
  | 'Wallets'
  | 'Trades'
  | 'Activity'
  | 'Risk'
  | 'TV Chart'
  | 'PowerTrader'
  | 'Command Center'
  | 'Performance'
  | 'Regime'
  | 'Congress'
  | 'LLM Portfolio'
  | 'Usage'
  | 'Skills'
  | 'Skills'
  | 'Landing';

export function AppShellClient() {
  const searchParams = useSearchParams();
  const [activePage, setActivePage] = useState<PageName>('Command Center');
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
        'Dashboard', 'Signals', 'Telegram', 'Scanner', 'Tasks', 'Sessions', 'Options', 'Agents', 
        'Approvals', 'Calendar', 'Projects', 'Memory', 'Memory Graph', 
        'Office', 'Docs', 'Wallets', 'Trades', 'Activity', 'Risk', 'TV Chart', 'PowerTrader',
        'Command Center', 'Performance', 'Regime', 'Usage', 'Landing', 'Congress', 'LLM Portfolio', 'Skills'
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
<TelegramPage />;
      case 'Telegram':
        return <TelegramPage />;
      case 'Scanner':
        return <ScannerPage />;
      case 'Tasks', 'Sessions':
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
      case 'Alerts':
        return <AlertsPage />;
      case 'Docs':
        return <DocsPage />;
      case 'Wallets':
        return <WalletsPage />;
      case 'Trades':
        return <TradesPage />;
      case 'Activity':
        return <ActivityPage />;
      case 'TV Chart':
        return <ChartPage />;
      case 'PowerTrader':
        return <PowerTraderPage />;
      case 'Command Center':
        return <CommandCenterPage />;
      case 'Performance':
        return <PerformancePage />;
      case 'Regime':
        return <RegimePage />;
      case 'Risk':
        return <RiskPage />;
      case 'Usage':
        return <UsagePage />;
      case 'Congress':
        return <CongressPage />;
      case 'LLM Portfolio':
        return <LLMPortfolioPage />;
      case "Skills":
        return <SkillsPage />;
      default:
        return <DashboardPage />;
    }
  }

  return (
    <div className="flex h-screen bg-slate-950 text-slate-100">
      <Sidebar activePage={activePage} onNavigate={(page) => { setActivePage(page as any); window.history.replaceState(null, '', '/?page=' + (page as string).toLowerCase().replace(/\s+/g, '-')); }} isCollapsed={isCollapsed} onToggle={() => setIsCollapsed(!isCollapsed)} newSignalsCount={newSignalsCount} pendingApprovalsCount={pendingApprovalsCount} />
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
