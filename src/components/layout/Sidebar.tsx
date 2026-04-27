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
  | 'Options'
  | 'OptionsWatcher'
  | 'Sessions'
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
  | 'Journal'
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
  { name: 'Options', icon: BarChart2 },
  { name: 'OptionsWatcher', icon: BarChart2 },
  { name: 'Wallets', icon: Wallet },
  { name: 'Trades', icon: TrendingUp },
  { name: 'Journal', icon: BookOpen },
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
  { name: 'Sessions', icon: Activity },
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
  const [balance, setBalance] = useState<number>(500000);
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

  // Best Options of the Day — top call + top put by Value from unusual flows
  const [bestCall, setBestCall] = useState<any>(null);
  const [bestPut, setBestPut] = useState<any>(null);
  useEffect(() => {
    const fetchFlows = async () => {
      try {
        const res = await fetch('/api/options-flow');
        const d = await res.json();
        const flows = d?.flows || [];
        // Aggregate by Symbol+Strike+Expiry+OptionType so multiple sweeps on same contract roll up
        const agg: Record<string, any> = {};
        for (const f of flows) {
          const key = `${f.Symbol}|${f.Strike}|${f.Expiry}|${f.OptionType}`;
          if (!agg[key]) {
            agg[key] = { Symbol: f.Symbol, Strike: f.Strike, Expiry: f.Expiry, ExpiryStr: f.ExpiryStr, OptionType: f.OptionType, Value: 0, Volume: 0, count: 0 };
          }
          agg[key].Value += Number(f.Value || 0);
          agg[key].Volume += Number(f.Volume || 0);
          agg[key].count += 1;
        }
        const rolled = Object.values(agg);
        const calls = rolled.filter((f: any) => String(f.OptionType || '').toLowerCase() === 'call').sort((a: any, b: any) => b.Value - a.Value);
        const puts  = rolled.filter((f: any) => String(f.OptionType || '').toLowerCase() === 'put').sort((a: any, b: any) => b.Value - a.Value);
        setBestCall(calls[0] || null);
        setBestPut(puts[0] || null);
      } catch (err) {
        console.error('Options flow fetch failed:', err);
      }
    };
    fetchFlows();
    const iv = setInterval(fetchFlows, 30000);
    return () => clearInterval(iv);
  }, []);

  // Helpers for Best Options display
  const fmtExpiry = (o: any): string => {
    if (!o) return '';
    if (o.ExpiryStr) return String(o.ExpiryStr).slice(5).replace('-', '/'); // "2026-08-20" -> "08/20"
    if (o.Expiry) {
      const ts = Number(o.Expiry);
      if (!ts) return '';
      const d = new Date(ts > 1e12 ? ts : ts * 1000);
      return `${String(d.getMonth() + 1).padStart(2, '0')}/${String(d.getDate()).padStart(2, '0')}`;
    }
    return '';
  };
  const fmtValue = (v: number): string => {
    if (!v) return '$0';
    if (v >= 1e6) return `$${(v / 1e6).toFixed(2)}M`;
    if (v >= 1e3) return `$${Math.round(v / 1e3)}K`;
    return `$${Math.round(v)}`;
  };
  const fmtVol = (v: number): string => {
    if (!v) return '0';
    if (v >= 1e6) return `${(v / 1e6).toFixed(1)}M`;
    if (v >= 1e3) return `${(v / 1e3).toFixed(1)}K`;
    return String(v);
  };

  const percent = Math.min(((balance - 500000) / 500000) * 100, 100);

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


      {/* Footer — Best Options of the Day */}
      {!isCollapsed && (
        <div
          style={{
            padding: '12px 14px',
            borderTop: '1px solid #1a3a4a',
            fontSize: 11,
            fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
          }}
        >
          <div style={{ color: '#ffd600', fontWeight: 700, marginBottom: 8, fontSize: 11, letterSpacing: '0.5px' }}>BEST OPTIONS OF THE DAY</div>
          {bestCall ? (
            <div style={{ marginBottom: 8 }}>
              <div style={{ display: 'flex', alignItems: 'baseline', gap: 6, marginBottom: 2 }}>
                <span style={{ color: '#66bb6a', fontWeight: 700, fontSize: 10, letterSpacing: '0.5px' }}>CALL</span>
                <span style={{ color: '#e0e0e0', fontSize: 11, fontWeight: 600 }}>{bestCall.Symbol || '?'} ${bestCall.Strike || '?'}C</span>
                <span style={{ color: '#90a4ae', fontSize: 10 }}>{fmtExpiry(bestCall)}</span>
              </div>
              <div style={{ color: '#4fc3f7', fontSize: 10 }}>{fmtValue(bestCall.Value || 0)} · {fmtVol(bestCall.Volume || 0)} vol</div>
            </div>
          ) : (
            <div style={{ color: '#607d8b', fontSize: 10, marginBottom: 8 }}>CALL: scanning...</div>
          )}
          {bestPut ? (
            <div>
              <div style={{ display: 'flex', alignItems: 'baseline', gap: 6, marginBottom: 2 }}>
                <span style={{ color: '#ef5350', fontWeight: 700, fontSize: 10, letterSpacing: '0.5px' }}>PUT</span>
                <span style={{ color: '#e0e0e0', fontSize: 11, fontWeight: 600 }}>{bestPut.Symbol || '?'} ${bestPut.Strike || '?'}P</span>
                <span style={{ color: '#90a4ae', fontSize: 10 }}>{fmtExpiry(bestPut)}</span>
              </div>
              <div style={{ color: '#4fc3f7', fontSize: 10 }}>{fmtValue(bestPut.Value || 0)} · {fmtVol(bestPut.Volume || 0)} vol</div>
            </div>
          ) : (
            <div style={{ color: '#607d8b', fontSize: 10 }}>PUT: scanning...</div>
          )}
        </div>
      )}
    </div>
  );
}
