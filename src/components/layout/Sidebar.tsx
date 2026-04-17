'use client';

import { useState, useEffect } from 'react';
import { BookOpen,
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
import { TerranLogo } from '../ui/TerranLogo';

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
  | 'TV Chart'
  | 'PowerTrader'
  | 'GoTrader'
  | 'Command Center'
  | 'Performance'
  | 'Regime'
  | 'Congress'
  | 'LLM Portfolio'
  | 'Skills'
  | 'Usage'
  | 'Landing';

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
  { name: 'Landing', icon: Zap },
  { name: 'Command Center', icon: Target },
  { name: 'Performance', icon: BarChart2 },
  { name: 'Regime', icon: Globe },
  { name: 'Activity', icon: Bell },
];

// TRADING section
const tradingItems: { name: PageName; icon: React.ElementType }[] = [
  { name: 'Dashboard', icon: LayoutDashboard },
  { name: 'TV Chart', icon: LineChart },
  { name: 'Scanner', icon: Radar },
  { name: 'Wallets', icon: Wallet },
  { name: 'Trades', icon: TrendingUp },
  { name: 'GoTrader', icon: Bot },
  { name: 'Risk', icon: ShieldAlert },
  { name: 'PowerTrader', icon: Cpu },
];

// SYSTEM section
const systemItems: { name: PageName; icon: React.ElementType }[] = [
  { name: 'Office', icon: Users },
  { name: 'Agents', icon: Bot },
  { name: 'Memory', icon: Brain },
  { name: 'Signals', icon: Zap },
  { name: 'Telegram', icon: Send },
  { name: 'Tasks', icon: ListTodo },
  { name: 'Approvals', icon: CheckCircle },
  { name: 'Calendar', icon: Calendar },
  { name: 'Projects', icon: FolderKanban },
  { name: 'Usage', icon: BarChart2 },
  { name: 'Congress', icon: Users },
  { name: 'LLM Portfolio', icon: Cpu },
  { name: 'Skills', icon: BookOpen },
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
  const [balance, setBalance] = useState<number>(100000);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchBalance = async () => {
      try {
        const res = await fetch('/api/portfolio');
        const data = await res.json();
        if (data.balance) setBalance(data.balance);
      } catch (err) {
        console.error('Portfolio fetch failed:', err);
      }
    };

    fetchBalance();
    const interval = setInterval(fetchBalance, 5000); // Refresh every 5s
    return () => clearInterval(interval);
  }, []);

  const percent = Math.min(((balance - 100000) / 10000) * 100, 100);

  return (
    <div
      style={{
        width,
        minWidth: width,
        height: '100vh',
        background: '#0d1117',
        borderRight: '1px solid #1a3a4a',
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
          borderBottom: '1px solid #1a3a4a',
          width: '100%',
          textAlign: 'left',
          flexShrink: 0,
        }}
      >
        <TerranLogo collapsed={isCollapsed} />
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
              onClick={() => name === 'Landing' ? (window.location.href = '/landing') : onNavigate(name)}
              style={{
                display: 'flex', alignItems: 'center', gap: 10,
                padding: isCollapsed ? '9px 10px' : '9px 14px',
                width: '100%', cursor: 'pointer', background: isActive ? 'rgba(108,92,231,0.12)' : 'transparent',
                border: 'none', borderLeft: isActive ? '2px solid #4fc3f7' : '2px solid transparent',
                color: isActive ? '#81d4fa' : '#455a64', transition: 'background 0.15s, color 0.15s',
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
              onClick={() => name === 'Landing' ? (window.location.href = '/landing') : onNavigate(name)}
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
                color: isActive ? '#81d4fa' : '#455a64',
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
                    background: '#4fc3f7',
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
                    background: '#4fc3f7',
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
            <button key={name} onClick={() => name === 'Landing' ? (window.location.href = '/landing') : onNavigate(name)} title={isCollapsed ? name : undefined}
              style={{ display: 'flex', alignItems: 'center', gap: 10, width: '100%', padding: isCollapsed ? '9px 0' : '9px 14px',
                justifyContent: isCollapsed ? 'center' : 'flex-start', background: isActive ? 'rgba(108,92,231,0.08)' : 'transparent',
                border: 'none', cursor: 'pointer', color: isActive ? '#81d4fa' : '#455a64', transition: 'background 0.15s, color 0.15s', position: 'relative' }}
            >
              <Icon size={16} style={{ flexShrink: 0 }} />
              {!isCollapsed && <span style={{ fontSize: 13, fontFamily: "'Inter', -apple-system, sans-serif", whiteSpace: 'nowrap', flex: 1, textAlign: 'left' }}>{name}</span>}
              {badge !== null && !isCollapsed && <span style={{ background: '#4fc3f7', color: '#fff', fontSize: 10, fontWeight: 700, borderRadius: '10px', padding: '1px 6px' }}>{badge}</span>}
            </button>
          );
        })}
      </nav>


      {/* Footer — Phase 1 Progress */}
      {!isCollapsed && (
        <div
          style={{
            padding: '12px 14px',
            borderTop: '1px solid #1a3a4a',
            fontSize: 11,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          }}
        >
          <div style={{ color: '#ff9800', fontWeight: 700, marginBottom: 3 }}>Phase 1 — Prove ROI</div>
          <div style={{ color: '#e0e0e0', marginBottom: 4 }}>${(balance / 1000).toFixed(0)}K → $110K</div>
          <div style={{ background: '#1a3a4a', borderRadius: 4, height: 4, overflow: 'hidden' }}>
            <div style={{ background: '#4fc3f7', width: `${percent}%`, height: '100%', borderRadius: 4 }} />
          </div>
          <div style={{ color: '#607d8b', marginTop: 4 }}>{percent.toFixed(1)}% complete</div>
        </div>
      )}
    </div>
  );
}
