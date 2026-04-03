'use client';

import {
  LayoutDashboard,
  Radar,
  ListTodo,
  Bot,
  CheckCircle,
  Calendar,
  FolderKanban,
  Brain,
  FileText,
  Wallet,
  Activity,
  ShieldAlert,
  Zap,
  Send,
  GitBranch,
  Building2,
  TrendingUp,
  Cpu,
  Target,
  BarChart2,
  Globe,
  LineChart,
  Bell,
  Settings,
  Users,
} from 'lucide-react';

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
  | 'PowerTrader'
  | 'Command Center'
  | 'Performance'
  | 'Regime';

interface SidebarProps {
  activePage: PageName;
  onNavigate: (page: PageName) => void;
  isCollapsed: boolean;
  onToggle: () => void;
  newSignalsCount: number;
  pendingApprovalsCount: number;
}

// COMMAND section — mission ops
const commandItems: { name: PageName; icon: React.ElementType }[] = [
  { name: 'Command Center', icon: Target },
  { name: 'Performance', icon: BarChart2 },
  { name: 'Regime', icon: Globe },
  { name: 'Activity', icon: Bell },
];

// TRADING section
const tradingItems: { name: PageName; icon: React.ElementType }[] = [
  { name: 'Dashboard', icon: LayoutDashboard },
  { name: 'Chart', icon: LineChart },
  { name: 'Scanner', icon: Radar },
  { name: 'Wallets', icon: Wallet },
  { name: 'Trades', icon: TrendingUp },
  { name: 'Risk', icon: ShieldAlert },
  { name: 'PowerTrader', icon: Cpu },
];

// SYSTEM section
const systemItems: { name: PageName; icon: React.ElementType }[] = [
  { name: 'Office', icon: Users },
  { name: 'Agents', icon: Bot },
  { name: 'Memory', icon: Brain },
  { name: 'Memory Graph', icon: GitBranch },
  { name: 'Signals', icon: Zap },
  { name: 'Telegram', icon: Send },
  { name: 'Tasks', icon: ListTodo },
  { name: 'Approvals', icon: CheckCircle },
  { name: 'Calendar', icon: Calendar },
  { name: 'Projects', icon: FolderKanban },
  { name: 'Docs', icon: FileText },
];

// Keep for compatibility
const navItems = tradingItems;

export function Sidebar({
  activePage,
  onNavigate,
  isCollapsed,
  onToggle,
  newSignalsCount,
  pendingApprovalsCount,
}: SidebarProps) {
  const width = isCollapsed ? 56 : 200;

  return (
    <div
      style={{
        width,
        minWidth: width,
        height: '100vh',
        background: '#0f0f17',
        borderRight: '1px solid #1e1e2a',
        display: 'flex',
        flexDirection: 'column',
        transition: 'width 0.2s ease, min-width 0.2s ease',
        overflow: 'hidden',
        position: 'sticky',
        top: 0,
        flexShrink: 0,
      }}
    >
      {/* Logo */}
      <button
        onClick={onToggle}
        style={{
          display: 'flex',
          alignItems: 'center',
          gap: 10,
          padding: isCollapsed ? '16px 10px' : '16px 14px',
          cursor: 'pointer',
          background: 'transparent',
          border: 'none',
          borderBottom: '1px solid #1e1e2a',
          width: '100%',
          textAlign: 'left',
          flexShrink: 0,
        }}
      >
        <div
          style={{
            width: 32,
            height: 32,
            borderRadius: 8,
            background: 'linear-gradient(135deg, #6c5ce7, #a29bfe)',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            fontFamily: "'JetBrains Mono', monospace",
            fontWeight: 700,
            fontSize: 16,
            color: '#fff',
            flexShrink: 0,
          }}
        >
          M
        </div>
        {!isCollapsed && (
          <span
            style={{
              fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
              fontSize: 11,
              fontWeight: 700,
              color: '#e8e8ed',
              letterSpacing: '1px',
              whiteSpace: 'nowrap',
            }}
          >
            MISSION CTRL
          </span>
        )}
      </button>

      {/* Nav items */}
      <nav style={{ flex: 1, padding: '8px 0', overflowY: 'auto' }}>
        {/* COMMAND section */}
        {!isCollapsed && (
          <div style={{ padding: '6px 14px 2px', fontSize: 9, fontFamily: "'JetBrains Mono', monospace", color: '#3d3d52', letterSpacing: '1.5px', fontWeight: 700 }}>COMMAND</div>
        )}
        {commandItems.map(({ name, icon: Icon }) => {
          const isActive = activePage === name;
          return (
            <button
              key={name}
              onClick={() => onNavigate(name)}
              style={{
                display: 'flex', alignItems: 'center', gap: 10,
                padding: isCollapsed ? '9px 10px' : '9px 14px',
                width: '100%', cursor: 'pointer', background: isActive ? 'rgba(108,92,231,0.12)' : 'transparent',
                border: 'none', borderLeft: isActive ? '2px solid #6c5ce7' : '2px solid transparent',
                color: isActive ? '#a29bfe' : '#8b8b9e', transition: 'background 0.15s, color 0.15s',
              }}
            >
              <Icon size={16} style={{ flexShrink: 0 }} />
              {!isCollapsed && <span style={{ fontSize: 13, fontFamily: "'Inter', -apple-system, sans-serif", whiteSpace: 'nowrap' }}>{name}</span>}
            </button>
          );
        })}
        {!isCollapsed && (
          <div style={{ padding: '8px 14px 2px', fontSize: 9, fontFamily: "'JetBrains Mono', monospace", color: '#3d3d52', letterSpacing: '1.5px', fontWeight: 700, marginTop: 4 }}>TRADING</div>
        )}
        {tradingItems.map(({ name, icon: Icon }) => {
          const isActive = activePage === name;
          const badge =
            name === 'Scanner' && newSignalsCount > 0
              ? newSignalsCount
              : name === 'Approvals' && pendingApprovalsCount > 0
              ? pendingApprovalsCount
              : null;

          return (
            <button
              key={name}
              onClick={() => onNavigate(name)}
              title={isCollapsed ? name : undefined}
              style={{
                display: 'flex',
                alignItems: 'center',
                gap: 10,
                width: '100%',
                padding: isCollapsed ? '9px 0' : '9px 14px',
                justifyContent: isCollapsed ? 'center' : 'flex-start',
                background: isActive ? 'rgba(108, 92, 231, 0.08)' : 'transparent',
                border: 'none',
                borderRadius: 0,
                cursor: 'pointer',
                color: isActive ? '#a29bfe' : '#8b8b9e',
                position: 'relative',
                transition: 'background 0.15s, color 0.15s',
              }}
            >
              <Icon size={16} style={{ flexShrink: 0 }} />
              {!isCollapsed && (
                <span
                  style={{
                    fontSize: 13,
                    fontFamily: "'Inter', -apple-system, sans-serif",
                    whiteSpace: 'nowrap',
                    flex: 1,
                    textAlign: 'left',
                  }}
                >
                  {name}
                </span>
              )}
              {badge !== null && !isCollapsed && (
                <span
                  style={{
                    background: '#6c5ce7',
                    color: '#fff',
                    fontSize: 10,
                    fontFamily: "'JetBrains Mono', monospace",
                    fontWeight: 700,
                    borderRadius: '10px',
                    padding: '1px 6px',
                    minWidth: 18,
                    textAlign: 'center',
                  }}
                >
                  {badge}
                </span>
              )}
              {badge !== null && isCollapsed && (
                <span
                  style={{
                    position: 'absolute',
                    top: 6,
                    right: 8,
                    background: '#6c5ce7',
                    color: '#fff',
                    fontSize: 9,
                    fontFamily: "'JetBrains Mono', monospace",
                    fontWeight: 700,
                    borderRadius: '50%',
                    width: 14,
                    height: 14,
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center',
                  }}
                >
                  {badge}
                </span>
              )}
            </button>
          );
        })}

        {/* SYSTEM section */}
        {!isCollapsed && (
          <div style={{ padding: '8px 14px 2px', fontSize: 9, fontFamily: "'JetBrains Mono', monospace", color: '#3d3d52', letterSpacing: '1.5px', fontWeight: 700, marginTop: 4 }}>SYSTEM</div>
        )}
        {systemItems.map(({ name, icon: Icon }) => {
          const isActive = activePage === name;
          const badge = name === 'Scanner' && newSignalsCount > 0 ? newSignalsCount : name === 'Approvals' && pendingApprovalsCount > 0 ? pendingApprovalsCount : null;
          return (
            <button key={name} onClick={() => onNavigate(name)} title={isCollapsed ? name : undefined}
              style={{ display: 'flex', alignItems: 'center', gap: 10, width: '100%', padding: isCollapsed ? '9px 0' : '9px 14px',
                justifyContent: isCollapsed ? 'center' : 'flex-start', background: isActive ? 'rgba(108,92,231,0.08)' : 'transparent',
                border: 'none', cursor: 'pointer', color: isActive ? '#a29bfe' : '#8b8b9e', transition: 'background 0.15s, color 0.15s', position: 'relative' }}
            >
              <Icon size={16} style={{ flexShrink: 0 }} />
              {!isCollapsed && <span style={{ fontSize: 13, fontFamily: "'Inter', -apple-system, sans-serif", whiteSpace: 'nowrap', flex: 1, textAlign: 'left' }}>{name}</span>}
              {badge !== null && !isCollapsed && <span style={{ background: '#6c5ce7', color: '#fff', fontSize: 10, fontWeight: 700, borderRadius: '10px', padding: '1px 6px' }}>{badge}</span>}
            </button>
          );
        })}
      </nav>

      {/* Footer — Phase 1 Progress */}
      {!isCollapsed && (
        <div
          style={{
            padding: '12px 14px',
            borderTop: '1px solid #1e1e2a',
            fontSize: 11,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          }}
        >
          <div style={{ color: '#ffa502', fontWeight: 700, marginBottom: 3 }}>Phase 1 — Prove ROI</div>
          <div style={{ color: '#e8e8ed', marginBottom: 4 }}>$100K → $110K</div>
          <div style={{ background: '#1e1e2a', borderRadius: 4, height: 4, overflow: 'hidden' }}>
            <div style={{ background: '#6c5ce7', width: '3%', height: '100%', borderRadius: 4 }} />
          </div>
          <div style={{ color: '#5c5c72', marginTop: 4 }}>3% complete</div>
        </div>
      )}
    </div>
  );
}
