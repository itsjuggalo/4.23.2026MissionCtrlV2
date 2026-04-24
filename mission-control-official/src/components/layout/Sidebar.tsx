'use client';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import {
  LayoutDashboard, TrendingUp, Users, Wallet, Settings, Activity,
  Zap, Shield, Brain, FileText, Calendar, Kanban, Search,
  CheckSquare, BarChart2, AlertTriangle, BookOpen, Lightbulb, Target, LineChart,
} from 'lucide-react';

const navGroups = [
  {
    label: 'COMMAND',
    items: [
      { href: '/command', icon: Target, label: 'Command Center' },
      { href: '/dashboard', icon: LayoutDashboard, label: 'Dashboard' },
      { href: '/performance', icon: BarChart2, label: 'Performance' },
      { href: '/regime', icon: Activity, label: 'Macro Regime' },
    ],
  },
  {
    label: 'TRADING',
    items: [
      { href: '/trading', icon: LineChart, label: 'TradingView' },
      { href: '/positions', icon: TrendingUp, label: 'Positions' },
      { href: '/options', icon: BarChart2, label: 'Options' },
      { href: '/scanner', icon: Search, label: 'Scanner' },
      { href: '/approvals', icon: CheckSquare, label: 'Approvals' },
      { href: '/alerts', icon: AlertTriangle, label: 'Live Alerts' },
      { href: '/risk', icon: Shield, label: 'Risk' },
      { href: '/wallets', icon: Wallet, label: 'Wallets' },
    ],
  },
  {
    label: 'TEAM',
    items: [
      { href: '/office', icon: Users, label: 'Office' },
      { href: '/agents', icon: Zap, label: 'Agents' },
      { href: '/tasks', icon: CheckSquare, label: 'Tasks' },
      { href: '/activity', icon: Activity, label: 'Activity' },
    ],
  },
  {
    label: 'KNOWLEDGE',
    items: [
      { href: '/memory', icon: Brain, label: 'Memory' },
      { href: '/calendar', icon: Calendar, label: 'Calendar' },
      { href: '/projects', icon: Kanban, label: 'Projects' },
      { href: '/docs', icon: BookOpen, label: 'Docs' },
      { href: '/optimization', icon: Lightbulb, label: 'Optimization' },
    ],
  },
];

export default function Sidebar() {
  const pathname = usePathname();

  return (
    <aside className="w-56 border-r border-[#1f1f1f] bg-[#0a0a0a] flex flex-col h-screen sticky top-0">
      <div className="p-4 border-b border-[#1f1f1f]">
        <Link href="/command" className="flex items-center gap-2">
          <div className="text-xl">🎯</div>
          <div>
            <h1 className="font-bold text-white text-sm">Mission Control</h1>
            <p className="text-[10px] text-[#555]">Trading Operations</p>
          </div>
        </Link>
      </div>

      <nav className="flex-1 overflow-y-auto p-3 space-y-4">
        {navGroups.map((group) => (
          <div key={group.label}>
            <h3 className="text-[10px] font-semibold text-[#444] mb-1 px-2 tracking-widest">{group.label}</h3>
            <ul className="space-y-0.5">
              {group.items.map((item) => {
                const isActive = pathname === item.href;
                return (
                  <li key={item.href}>
                    <Link
                      href={item.href}
                      className={`flex items-center gap-2.5 px-2 py-1.5 rounded text-sm transition-colors ${
                        isActive
                          ? 'bg-amber-500/10 text-amber-400'
                          : 'text-[#666] hover:text-[#f0f0f0] hover:bg-[#161616]'
                      }`}
                    >
                      <item.icon className="w-3.5 h-3.5 flex-shrink-0" />
                      <span className="text-xs font-medium">{item.label}</span>
                    </Link>
                  </li>
                );
              })}
            </ul>
          </div>
        ))}
      </nav>

      <div className="p-3 border-t border-[#1f1f1f]">
        <div className="bg-amber-500/10 border border-amber-500/20 rounded p-2.5 text-xs">
          <div className="text-amber-400 font-bold mb-0.5">Phase 1 — Prove ROI</div>
          <div className="text-[#f0f0f0]">$99,997 → $110,000</div>
          <div className="text-[#555] text-[10px] mt-1">0.003% complete · LLY open</div>
        </div>
      </div>
    </aside>
  );
}
