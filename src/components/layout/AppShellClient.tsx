'use client';

import { useSearchParams } from 'next/navigation';
import { useEffect, useState } from 'react';
import type { Approval } from '@/lib/types';
const initialApprovals: any[] = []; const signals: any[] = [];
import { Sidebar } from './Sidebar';
import { useViewMode } from '@/lib/useViewMode';
import PageErrorBoundary from "./PageErrorBoundary";
import MissionMetrics from "./MissionMetrics";
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
import { TradesPage } from '../pages/TradesPage';
import TradeJournalPage from '../pages/TradeJournalPage';
import { ActivityPage } from '../pages/ActivityPage';
import { RiskPage } from '../pages/RiskPage';
import { SignalsPage } from '../pages/SignalsPage';
import { MemoryGraphPage } from '../pages/MemoryGraphPage';
import { OfficePage } from '../pages/OfficePage';
import { DeskPage } from '../pages/DeskPage';
import { ChartPage } from '../pages/ChartPage';
import { PowerTraderPage } from '../pages/PowerTraderPage';
import { CommandCenterPage } from '../pages/CommandCenterPage';
import { PerformancePage } from '../pages/PerformancePage';
import { RegimePage } from '../pages/RegimePage';
import UsagePage from '../pages/UsagePage';
import { CongressPage } from '../pages/CongressPage';
import { FlowHistoryPage } from '../pages/FlowHistoryPage';
import { FlowDatabasePage } from '../pages/FlowDatabasePage';
import { LLMPortfolioPage } from '../pages/LLMPortfolioPage';
import { SkillsPage } from "../pages/SkillsPage";
import { TelegramPage } from '@/components/pages/TelegramPage';
import { OptionsPage } from '@/components/pages/OptionsPage';
import { OptionsWatcherPage } from '@/components/pages/OptionsWatcherPage';
import { OptionsPageMobile } from '@/components/pages/OptionsPageMobile';
import { SessionViewerPage } from '@/components/pages/SessionViewerPage';
import { ITBPage } from '../pages/ITBPage';
import { FreqtradePage } from '../pages/FreqtradePage';
import { LiveStrategyPage } from '../pages/LiveStrategyPage';
import { KronosLabPage } from '../pages/KronosLabPage';
import { LoopsPage } from '../pages/LoopsPage';
import { AriesPage } from '../pages/AriesPage';
import { PsychChatWidget } from '../ui/PsychChatWidget';

type PageName =
  | 'Dashboard'
  | 'Signals'
  | 'Telegram'
  | 'Scanner'
  | 'Tasks'
  | 'Sessions'
  | 'Options'
  | 'OptionsWatcher'
  | 'Flow History'
  | 'Flow Database'
  | 'Agents'
  | 'Approvals'
  | 'Calendar'
  | 'Projects'
  | 'Memory'
  | 'Memory Graph'
  | 'Office'
  | 'Desk'
  | 'Alerts'
  | 'Docs'
  | 'Trades'
  | 'Journal'
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
  | 'ITB'
  | 'Freqtrade'
  | 'Live Strategy'
  | 'Kronos Lab'
  | 'GoTrader'
  | 'Loops'
  | 'ARIES'
  | 'Landing';

// Centralized list of valid pages — referenced by both the initial-state
// resolver and the searchParams useEffect so they can't drift.
const VALID_PAGES: PageName[] = [
  'Dashboard', 'Signals', 'Telegram', 'Scanner', 'Tasks', 'Sessions', 'Options', 'OptionsWatcher', 'Agents',
  'Approvals', 'Calendar', 'Projects', 'Memory', 'Memory Graph',
  'Office', 'Desk', 'Docs', 'Trades', 'Journal', 'Activity', 'Risk', 'TV Chart', 'PowerTrader',
  'Command Center', 'Performance', 'Regime', 'Usage', 'Landing', 'Congress', 'LLM Portfolio', 'Skills',
  'Flow History', 'Flow Database', 'ITB', 'Freqtrade', 'Live Strategy', 'Kronos Lab', 'GoTrader', 'Loops', 'ARIES',
];

function resolvePageFromParam(page: string | null): PageName {
  if (!page) return 'Command Center';
  // OptionsWatcher is the only multi-cap page id — handle it explicitly so
  // the lowercased URL form ('optionswatcher') resolves correctly.
  if (page.toLowerCase() === 'optionswatcher') return 'OptionsWatcher';
  if (page.toLowerCase() === 'itb') return 'ITB';
  if (page.toLowerCase() === 'live-strategy') return 'Live Strategy';
  if (page.toLowerCase() === 'kronos-lab') return 'Kronos Lab';
  if (page.toLowerCase() === 'flow-history') return 'Flow History';
  if (page.toLowerCase() === 'flow-database') return 'Flow Database';
  if (page.toLowerCase() === 'memory-graph') return 'Memory Graph';
  if (page.toLowerCase() === 'llm-portfolio') return 'LLM Portfolio';
  if (page.toLowerCase() === 'command-center') return 'Command Center';
  if (page.toLowerCase() === 'aries') return 'ARIES';
  const pn = (page.charAt(0).toUpperCase() + page.slice(1).toLowerCase()) as PageName;
  return VALID_PAGES.includes(pn) ? pn : 'Command Center';
}

export function AppShellClient() {
  const searchParams = useSearchParams();
  // Initialize activePage from URL on the very first render (not after a
  // useEffect tick) so the mobile-Options branch below can fire on first
  // paint — otherwise there's a flash of desktop chrome before hydration.
  const [activePage, setActivePage] = useState<PageName>(() => resolvePageFromParam(searchParams.get('page')));
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [approvals, setApprovals] = useState<Approval[]>(initialApprovals);
  const [mobileOpen, setMobileOpen] = useState(false);

  // Explicit view-mode preference (Sidebar toggle, persisted to localStorage).
  // The off-canvas drawer behaviour kicks in whenever the user picks "mobile",
  // regardless of the actual viewport width. First-visit default is auto-
  // detected from window.innerWidth inside the hook.
  const [viewMode] = useViewMode();
  const isMobile = viewMode === 'mobile';

  const newSignalsCount = signals.filter((s) => s.status === 'new').length;
  const pendingApprovalsCount = approvals.filter((a) => a.status === 'pending').length;

  // Handle query parameter for page navigation. Initial value is already set
  // by useState's resolver above; this hook just keeps activePage in sync
  // when the URL changes after first render (e.g. on back/forward navigation).
  useEffect(() => {
    setActivePage(resolvePageFromParam(searchParams.get('page')));
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
        return <TelegramPage />;
      case 'Scanner':
        return <ScannerPage />;
      case 'Options':
        return <OptionsPage />;
      case 'OptionsWatcher':
        return <OptionsWatcherPage />;
      case 'Tasks':
        return <TasksPage />;
      case 'Sessions':
        return <SessionViewerPage />;
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
      case 'Desk':
        return <DeskPage />;
      case 'Alerts':
        return <AlertsPage />;
      case 'Docs':
        return <DocsPage />;
      case 'Trades':
        return <TradesPage />;
      case 'Journal':
        return <TradeJournalPage />;
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
      case 'Flow History':
        return <FlowHistoryPage />;
      case 'Flow Database':
        return <FlowDatabasePage />;
      case 'LLM Portfolio':
        return <LLMPortfolioPage />;
      case "Skills":
        return <SkillsPage />;
      case 'ITB':
        return <ITBPage />;
      case 'Freqtrade':
        return <FreqtradePage />;
      case 'Live Strategy':
        return <LiveStrategyPage />;
      case 'Kronos Lab':
        return <KronosLabPage />;
      case 'Loops':
        return <LoopsPage />;
      case 'ARIES':
        return <AriesPage />;
      case 'GoTrader':
        return null;
      default:
        return <DashboardPage />;
    }
  }

  const handleNavigate = (page: PageName) => {
    if (page === 'Landing') { window.location.href = '/landing'; return; }
    if (page === 'GoTrader') { window.location.href = '/gotrader'; return; }
    setActivePage(page);
    window.history.replaceState(null, '', '/?page=' + (page as string).toLowerCase().replace(/\s+/g, '-'));
    setMobileOpen(false);
  };

  const sidebar = (
    <Sidebar
      activePage={activePage}
      onNavigate={handleNavigate}
      isCollapsed={isMobile ? false : isCollapsed}
      onToggle={() => (isMobile ? setMobileOpen(false) : setIsCollapsed(!isCollapsed))}
      newSignalsCount={newSignalsCount}
      pendingApprovalsCount={pendingApprovalsCount}
    />
  );

  // Mobile standalone branch: when on Options/OptionsWatcher, render the
  // Option Signals app-style mobile page full-screen (no Header, no
  // MissionMetrics, no PsychChatWidget). The sidebar still works via the
  // off-canvas drawer triggered by the hamburger button in OptionsPageMobile.
  if (isMobile && (activePage === 'Options' || activePage === 'OptionsWatcher')) {
    return (
      <>
        {mobileOpen && (
          <div
            onClick={() => setMobileOpen(false)}
            style={{ position: 'fixed', inset: 0, background: 'rgba(0,0,0,0.6)', zIndex: 200 }}
          />
        )}
        <div
          style={{
            position: 'fixed', top: 0, left: 0, bottom: 0, zIndex: 201, display: 'flex',
            transform: mobileOpen ? 'translateX(0)' : 'translateX(-100%)',
            transition: 'transform 0.2s ease',
          }}
        >
          {sidebar}
        </div>
        <OptionsPageMobile
          onMenuClick={() => setMobileOpen(true)}
          initialTab={activePage === 'OptionsWatcher' ? 'chain' : 'swings'}
        />
      </>
    );
  }

  return (
    <div className="flex flex-col h-screen bg-slate-950 text-slate-100">
      <MissionMetrics />
      <div className="flex flex-1 overflow-hidden">
        {isMobile ? (
          <>
            {mobileOpen && (
              <div
                onClick={() => setMobileOpen(false)}
                style={{ position: 'fixed', inset: 0, background: 'rgba(0,0,0,0.6)', zIndex: 200 }}
              />
            )}
            <div
              style={{
                position: 'fixed', top: 0, left: 0, bottom: 0, zIndex: 201, display: 'flex',
                transform: mobileOpen ? 'translateX(0)' : 'translateX(-100%)',
                transition: 'transform 0.2s ease',
              }}
            >
              {sidebar}
            </div>
          </>
        ) : sidebar}
        <div className="flex-1 flex flex-col overflow-hidden">
          <Header title={activePage} onMenuClick={isMobile ? () => setMobileOpen(true) : undefined} />
          <main className="flex-1 overflow-auto">
            <PageErrorBoundary pageName={activePage}>{renderPage()}</PageErrorBoundary>
          </main>
        </div>
      </div>
      <PsychChatWidget />
    </div>
  );
}
