"use client";
import { Bell, Settings, ChevronLeft, ChevronRight,
  LayoutDashboard, BarChart3, TrendingUp, Activity, Radar, Bot, Brain, Briefcase,
  ShieldAlert, Building2, MessageSquare, ClipboardCheck, Calendar, FolderKanban,
  ListTodo, FileText, BookOpen, LineChart, Search, Zap, Target,
  Eye, Send, Network, History, BookMarked, Database, Users, AlertTriangle, Rocket,
  Monitor, Smartphone, Workflow, Cpu, BotMessageSquare, Webhook, Repeat,
} from "lucide-react";
import BestOptionsWidget from '@/components/widgets/BestOptionsWidget';
import { useViewMode } from '@/lib/useViewMode';

export type PageName =
  "Landing" | "Command Center" | "Performance" | "Regime" | "Activity"
  | "Signals" | "Flow History" | "TV Chart" | "Trades" | "PowerTrader"
  | "GoTrader" | "Agents" | "Risk" | "Office" | "Memory"
  | "Memory Graph" | "Telegram" | "Approvals" | "Calendar" | "Tasks"
  | "Projects" | "Alerts" | "Usage" | "Congress" | "LLM Portfolio"
  | "Journal" | "Docs" | "Skills" | "Dashboard" | "Scanner" | "Sessions" | "Options" | "OptionsWatcher" | "Flow Database" | "Desk" | "ITB" | "Freqtrade" | "Live Strategy" | "Kronos Lab" | "Loops";

interface SidebarProps {
  activePage: PageName;
  onNavigate: (page: PageName) => void;
  isCollapsed: boolean;
  onToggle: () => void;
  newSignalsCount: number;
  pendingApprovalsCount: number;
}

type Item = { name: PageName; icon: React.ElementType; badge?: number };

export function Sidebar({ activePage, onNavigate, isCollapsed, onToggle, newSignalsCount, pendingApprovalsCount }: SidebarProps) {
  const [viewMode, setViewMode] = useViewMode();
  const sections: { label: string; items: Item[] }[] = [
    { label: "OVERVIEW", items: [
      { name: "Landing", icon: Zap },
      { name: "Dashboard", icon: LayoutDashboard },
      { name: "Command Center", icon: Briefcase },
      { name: "Performance", icon: BarChart3 },
      { name: "Regime", icon: TrendingUp },
      { name: "Activity", icon: Activity },
    ]},
    { label: "SIGNALS", items: [
      { name: "Signals", icon: Radar, badge: newSignalsCount },
      { name: "Scanner", icon: Search },
      { name: "Flow History", icon: History },
      { name: "Flow Database", icon: Database },
    ]},
    { label: "EXECUTION", items: [
      { name: "PowerTrader", icon: Rocket },
      { name: "GoTrader", icon: Target },
      { name: "TV Chart", icon: LineChart },
      { name: "Trades", icon: Briefcase },
      { name: "Options", icon: Target },
      { name: "OptionsWatcher", icon: Eye },
      { name: "ITB", icon: Cpu },
      { name: "Freqtrade", icon: BotMessageSquare },
      { name: "Live Strategy", icon: Webhook },
      { name: "Kronos Lab", icon: Brain },
    ]},
    { label: "AGENTS", items: [
      { name: "Agents", icon: Bot },
      { name: "Risk", icon: ShieldAlert },
      { name: "Office", icon: Building2 },
      { name: "Desk", icon: Workflow },
      { name: "Telegram", icon: Send },
    ]},
    { label: "KNOWLEDGE", items: [
      { name: "Memory", icon: Brain },
      { name: "Memory Graph", icon: Network },
      { name: "Docs", icon: BookOpen },
      { name: "Skills", icon: Database },
    ]},
    { label: "ADMIN", items: [
      { name: "Loops", icon: Repeat },
      { name: "Tasks", icon: ListTodo },
      { name: "Projects", icon: FolderKanban },
      { name: "Sessions", icon: MessageSquare },
      { name: "Approvals", icon: ClipboardCheck, badge: pendingApprovalsCount },
      { name: "Calendar", icon: Calendar },
      { name: "Alerts", icon: AlertTriangle },
      { name: "Journal", icon: BookMarked },
      { name: "LLM Portfolio", icon: Users },
      { name: "Congress", icon: FileText },
      { name: "Usage", icon: Settings },
    ]},
  ];

  const w = isCollapsed ? 64 : 220;
  return (
    <aside style={{
      width: w, minWidth: w, background: "#0a1117", color: "#cfd6dd",
      borderRight: "1px solid #1a2530", display: "flex", flexDirection: "column",
      fontFamily: "ui-sans-serif, system-ui, sans-serif", fontSize: 13,
      transition: "width 0.15s ease",
    }}>
      {/* Logo */}
      <div style={{ padding: "14px 16px", borderBottom: "1px solid #1a2530", display: "flex", alignItems: "center", justifyContent: "space-between" }}>
        {!isCollapsed && (
          <div style={{ fontSize: 16, fontWeight: 700 }}>
            <span style={{ color: "#fff" }}>Mission</span>
            <span style={{ color: "#5fa3ff" }}>CTRL</span>
          </div>
        )}
        <button onClick={onToggle} style={{ background: "transparent", border: "none", color: "#8a99a8", cursor: "pointer", padding: 4 }}>
          {isCollapsed ? <ChevronRight size={16}/> : <ChevronLeft size={16}/>}
        </button>
      </div>

      {/* Sections */}
      <div style={{ flex: 1, overflowY: "auto", padding: "8px 0" }}>
        {sections.map(sec => (
          <div key={sec.label} style={{ marginBottom: 8 }}>
            {!isCollapsed && (
              <div style={{ padding: "8px 16px 4px", fontSize: 10, color: "#5a6470", letterSpacing: 1, fontWeight: 600 }}>{sec.label}</div>
            )}
            {sec.items.map(it => {
              const active = activePage === it.name;
              const Icon = it.icon as React.ComponentType<{ size?: number; style?: React.CSSProperties }>;
              return (
                <button key={it.name} onClick={() => onNavigate(it.name)} title={it.name} style={{
                  display: "flex", alignItems: "center", gap: 10,
                  width: "100%", padding: "8px 16px", background: "transparent",
                  border: "none", borderLeft: active ? "3px solid #5fa3ff" : "3px solid transparent",
                  cursor: "pointer", textAlign: "left", color: active ? "#fff" : "#8a99a8",
                  fontFamily: "inherit", fontSize: 13, fontWeight: active ? 500 : 400,
                  backgroundColor: active ? "rgba(95, 163, 255, 0.12)" : "transparent",
                  justifyContent: isCollapsed ? "center" : "flex-start",
                }}
                onMouseEnter={e => { if (!active) { (e.currentTarget as HTMLElement).style.color = "#5fa3ff"; (e.currentTarget as HTMLElement).style.backgroundColor = "rgba(95, 163, 255, 0.06)"; } }}
                onMouseLeave={e => { if (!active) { (e.currentTarget as HTMLElement).style.color = "#8a99a8"; (e.currentTarget as HTMLElement).style.backgroundColor = "transparent"; } }}>
                  <Icon size={16} style={{ color: active ? "#5fa3ff" : undefined, flexShrink: 0 }}/>
                  {!isCollapsed && <span style={{ flex: 1 }}>{it.name}</span>}
                  {!isCollapsed && it.badge && it.badge > 0 ? (
                    <span style={{ background: "#5fa3ff", color: "#000", fontSize: 10, padding: "1px 6px", borderRadius: 9, fontWeight: 700 }}>{it.badge}</span>
                  ) : null}
                </button>
              );
            })}
          </div>
        ))}
      </div>

      {/* Bottom utility */}
      <div style={{ borderTop: "1px solid #1a2530", padding: "8px 0" }}>
        {([
          { name: "Alerts" as PageName, icon: Bell },
        ]).map(it => {
          const active = activePage === it.name;
          const Icon = it.icon;
          return (
            <button key={it.name} onClick={() => onNavigate(it.name)} style={{
              display: "flex", alignItems: "center", gap: 10,
              width: "100%", padding: "8px 16px", background: "transparent",
              border: "none", borderLeft: active ? "3px solid #5fa3ff" : "3px solid transparent",
              cursor: "pointer", textAlign: "left", color: active ? "#fff" : "#8a99a8",
              fontFamily: "inherit", fontSize: 13,
              backgroundColor: active ? "rgba(95, 163, 255, 0.12)" : "transparent",
              justifyContent: isCollapsed ? "center" : "flex-start",
            }}
            onMouseEnter={e => { if (!active) { (e.currentTarget as HTMLElement).style.color = "#5fa3ff"; (e.currentTarget as HTMLElement).style.backgroundColor = "rgba(95, 163, 255, 0.06)"; } }}
            onMouseLeave={e => { if (!active) { (e.currentTarget as HTMLElement).style.color = "#8a99a8"; (e.currentTarget as HTMLElement).style.backgroundColor = "transparent"; } }}>
              <Icon size={16} style={{ color: active ? "#5fa3ff" : undefined }}/>
              {!isCollapsed && <span>{it.name}</span>}
            </button>
          );
        })}
        {!isCollapsed && <BestOptionsWidget />}

        {/* View mode toggle: swap between desktop & mobile-friendly layouts.
            Visible whether the sidebar is collapsed or expanded; collapsed
            shows only the active icon as a button. */}
        <div style={{ padding: isCollapsed ? "10px 8px" : "8px 12px", marginTop: 4, borderTop: "1px solid #1a2530" }}>
          {!isCollapsed && (
            <div style={{ fontSize: 10, color: "#5a6470", letterSpacing: 1, fontWeight: 600, marginBottom: 6 }}>
              VIEW
            </div>
          )}
          <div style={{
            display: "flex",
            background: "rgba(255,255,255,0.03)",
            border: "1px solid #1a2530",
            borderRadius: 8,
            padding: 2,
            gap: 2,
            flexDirection: isCollapsed ? "column" : "row",
          }}>
            {([
              { value: 'desktop' as const, label: 'Desktop', Icon: Monitor },
              { value: 'mobile' as const, label: 'Mobile', Icon: Smartphone },
            ]).map(opt => {
              const active = viewMode === opt.value;
              const Icon = opt.Icon;
              return (
                <button
                  key={opt.value}
                  onClick={() => setViewMode(opt.value)}
                  title={`${opt.label} view`}
                  style={{
                    flex: 1,
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    gap: 6,
                    padding: isCollapsed ? "6px 0" : "6px 8px",
                    background: active ? "rgba(95,163,255,0.18)" : "transparent",
                    border: "none",
                    borderRadius: 6,
                    cursor: "pointer",
                    color: active ? "#5fa3ff" : "#6b7785",
                    fontSize: 11,
                    fontWeight: active ? 700 : 500,
                    fontFamily: "inherit",
                    transition: "background 0.12s, color 0.12s",
                  }}
                  onMouseEnter={e => { if (!active) (e.currentTarget as HTMLElement).style.color = "#9aaab9"; }}
                  onMouseLeave={e => { if (!active) (e.currentTarget as HTMLElement).style.color = "#6b7785"; }}
                >
                  <Icon size={14} />
                  {!isCollapsed && <span>{opt.label}</span>}
                </button>
              );
            })}
          </div>
        </div>

        {!isCollapsed && (
          <div style={{ padding: "10px 16px", display: "flex", alignItems: "center", gap: 10, marginTop: 4 }}>
            <div style={{ width: 28, height: 28, borderRadius: 14, background: "linear-gradient(135deg, #5fa3ff, #4fc3f7)", display: "flex", alignItems: "center", justifyContent: "center", color: "#000", fontWeight: 700, fontSize: 11, boxShadow: "0 0 10px rgba(95,163,255,0.6), 0 0 20px rgba(95,163,255,0.3)", animation: "mcLogoPulse 2.5s ease-in-out infinite" }}>MC</div><style>{`@keyframes mcLogoPulse{0%,100%{box-shadow:0 0 10px rgba(95,163,255,0.6),0 0 20px rgba(95,163,255,0.3)}50%{box-shadow:0 0 18px rgba(95,163,255,0.95),0 0 36px rgba(95,163,255,0.55)}}`}</style>
            <div style={{ flex: 1, fontSize: 11 }}>
              <div style={{ color: "#fff", fontWeight: 500 }}>Mission Ctrl</div>
              <div style={{ color: "#5a6470" }}>v3.0.4</div>
            </div>
          </div>
        )}
      </div>
    </aside>
  );
}

export default Sidebar;
