'use client';
import { useEffect, useState } from 'react';
import useSWR from 'swr';
import { PageHeader } from '@/components/shared/PageHeader';
import { MetricCard } from '@/components/shared/MetricCard';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { AlertTriangle, CheckCircle, TrendingUp, TrendingDown } from 'lucide-react';

const fetcher = (url: string) => fetch(url).then(res => res.json());

export default function DashboardPage() {
  // Live data hooks with auto-refresh
  const { data: cryptoData } = useSWR('/api/crypto/prices', fetcher, {
    refreshInterval: 30000, // 30 seconds
  });
  
  const { data: agentsData } = useSWR('/api/agents/status', fetcher, {
    refreshInterval: 10000, // 10 seconds
  });
  
  const { data: newsData } = useSWR('/api/news/crypto', fetcher, {
    refreshInterval: 300000, // 5 minutes
  });
  
  const { data: calendarData } = useSWR('/api/calendar/events', fetcher, {
    refreshInterval: 60000, // 1 minute
  });

  const { data: usageData } = useSWR('/api/usage', fetcher, {
    refreshInterval: 60000, // 1 minute
  });

  const btc = cryptoData?.btc;
  const agents = agentsData?.agents || [];
  const news = newsData?.news || [];
  const onlineAgents = agents.filter((a: any) => a.status === 'online').length;
  


  return (
    <div>
      <PageHeader
        title="Mission Control"
        subtitle="Live Trading Operations Dashboard"
      />

      {/* System Status */}
      <div className="flex items-center gap-2 px-4 py-2 rounded-lg mb-6 border bg-green-500/5 border-green-500/20 text-green-400">
        <CheckCircle className="w-4 h-4" />
        <span className="text-sm font-medium">
          All Systems Operational
        </span>
        <span className="ml-auto text-xs opacity-60">
          {onlineAgents} agents online · Live Data
        </span>
      </div>

      {/* Top Metrics */}
      <div className="grid grid-cols-4 gap-4 mb-6">
        <MetricCard
          label="Bitcoin (BTC)"
          value={btc ? `$${btc.price.toLocaleString()}` : 'Loading...'}
          subLabel="CoinGecko Live"
          change={btc?.change24h}
        />
        <MetricCard
          label="Active Agents"
          value={`${onlineAgents} / ${agents.length}`}
          subLabel="PM2 Status"
        />
        <MetricCard
          label="Crypto News"
          value={news.length}
          subLabel="Last 5min"
        />
        <MetricCard
          label="Calendar Events"
          value={calendarData?.calendarEvents?.length || 0}
          subLabel="Upcoming"
        />
      </div>

      {/* Token Usage Bar */}
      {usageData && (
        <div className={`flex items-center gap-4 px-4 py-2.5 rounded-lg border text-xs ${
          usageData.daily?.over_budget
            ? 'bg-red-500/5 border-red-500/20'
            : usageData.daily?.budget_used_pct > 80
            ? 'bg-yellow-500/5 border-yellow-500/20'
            : 'bg-[#111] border-[#1f1f1f]'
        }`}>
          <span className="text-[#555] uppercase tracking-wider font-semibold">AI Spend</span>
          <span className="text-[#f0f0f0] font-mono">
            Today: <span className={usageData.daily?.over_budget ? 'text-red-400' : 'text-green-400'}>
              ${(usageData.daily?.total_cost_usd || 0).toFixed(4)}
            </span>
            <span className="text-[#444] mx-1">/</span>
            <span className="text-[#888]">${usageData.daily?.daily_budget || 2.00}</span>
          </span>
          <span className="text-[#555]">•</span>
          <span className="text-[#f0f0f0] font-mono">
            Month: <span className={usageData.monthly?.over_budget ? 'text-red-400' : 'text-[#888]'}>
              ${(usageData.monthly?.total_cost_usd || 0).toFixed(4)}
            </span>
            <span className="text-[#444] mx-1">/</span>
            <span className="text-[#888]">${usageData.monthly?.monthly_budget || 30.00}</span>
          </span>
          <span className="text-[#555]">•</span>
          <span className="text-[#555]">{usageData.daily?.calls || 0} calls today</span>
          {/* Mini bar */}
          <div className="flex-1 max-w-32 bg-[#1f1f1f] rounded-full h-1.5 overflow-hidden">
            <div
              className={`h-full rounded-full transition-all ${
                usageData.daily?.budget_used_pct > 100 ? 'bg-red-400' :
                usageData.daily?.budget_used_pct > 80  ? 'bg-yellow-400' : 'bg-green-400'
              }`}
              style={{ width: `${Math.min(usageData.daily?.budget_used_pct || 0, 100)}%` }}
            />
          </div>
          <span className="text-[#555] font-mono">{(usageData.daily?.budget_used_pct || 0).toFixed(1)}%</span>
          <span className={`ml-auto text-[10px] font-semibold ${usageData.budget_ok ? 'text-green-400' : 'text-red-400'}`}>
            {usageData.budget_ok ? '✓ WITHIN BUDGET' : '⚠ OVER BUDGET'}
          </span>
        </div>
      )}

      <div className="grid grid-cols-3 gap-6">
        {/* Column 1: Market Data */}
        <div className="space-y-6">
          {/* Top Gainers */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <div className="flex items-center gap-2 mb-3">
              <TrendingUp className="w-4 h-4 text-green-400" />
              <h2 className="text-sm font-semibold text-[#f0f0f0]">Top Gainers (24h)</h2>
            </div>
            {!cryptoData ? (
              <p className="text-xs text-[#555]">Loading...</p>
            ) : (
              <div className="space-y-2">
                {cryptoData.gainers.map((coin: any) => (
                  <div key={coin.symbol} className="flex items-center justify-between py-1.5">
                    <div>
                      <span className="text-sm font-medium text-[#f0f0f0]">{coin.symbol}</span>
                      <span className="text-xs text-[#555] ml-2">{coin.name}</span>
                    </div>
                    <span className="text-sm font-medium text-green-400">
                      +{coin.change24h.toFixed(2)}%
                    </span>
                  </div>
                ))}
              </div>
            )}
          </div>

          {/* Top Losers */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <div className="flex items-center gap-2 mb-3">
              <TrendingDown className="w-4 h-4 text-red-400" />
              <h2 className="text-sm font-semibold text-[#f0f0f0]">Top Losers (24h)</h2>
            </div>
            {!cryptoData ? (
              <p className="text-xs text-[#555]">Loading...</p>
            ) : (
              <div className="space-y-2">
                {cryptoData.losers.map((coin: any) => (
                  <div key={coin.symbol} className="flex items-center justify-between py-1.5">
                    <div>
                      <span className="text-sm font-medium text-[#f0f0f0]">{coin.symbol}</span>
                      <span className="text-xs text-[#555] ml-2">{coin.name}</span>
                    </div>
                    <span className="text-sm font-medium text-red-400">
                      {coin.change24h.toFixed(2)}%
                    </span>
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>

        {/* Column 2: Agent Status */}
        <div className="space-y-6">
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <h2 className="text-sm font-semibold text-[#f0f0f0] mb-3">Agent Status (PM2)</h2>
            <div className="space-y-2 max-h-[600px] overflow-y-auto">
              {agents.map((agent: any) => (
                <div
                  key={agent.name}
                  className="flex items-center gap-3 p-2 bg-[#0a0a0a] rounded border border-[#1f1f1f]"
                >
                  <span className={`w-2 h-2 rounded-full flex-shrink-0 ${
                    agent.status === 'online' ? 'bg-green-400' :
                    agent.status === 'stopped' ? 'bg-red-400' :
                    'bg-yellow-400'
                  }`} />
                  <div className="flex-1 min-w-0">
                    <p className="text-sm font-medium text-[#f0f0f0] truncate">{agent.name}</p>
                    <div className="flex items-center gap-3 text-xs text-[#555] mt-0.5">
                      <span>{agent.role}</span>
                      {agent.uptime && agent.uptime !== '—' && <span>⏱ {agent.uptime}</span>}
                      {agent.memory > 0 && <span>📦 {agent.memory}MB</span>}
                    </div>
                  </div>
                  <StatusBadge variant={agent.status === 'online' ? 'success' : agent.status === 'idle' ? 'warning' : 'error'}>
                    {agent.status}
                  </StatusBadge>
                </div>
              ))}
            </div>
          </div>
        </div>

        {/* Column 3: News & Calendar */}
        <div className="space-y-6">
          {/* Crypto News */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <h2 className="text-sm font-semibold text-[#f0f0f0] mb-3">Crypto News</h2>
            <div className="space-y-3 max-h-[300px] overflow-y-auto">
              {news.map((item: any) => (
                <a
                  key={item.id}
                  href={item.url}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="block p-2 hover:bg-[#1a1a1a] rounded transition-colors"
                >
                  <p className="text-sm text-[#f0f0f0] line-clamp-2 mb-1">{item.title}</p>
                  <div className="flex items-center gap-2 text-xs text-[#555]">
                    <span>{item.source}</span>
                    <span>·</span>
                    <span>{new Date(item.published * 1000).toLocaleTimeString()}</span>
                  </div>
                </a>
              ))}
            </div>
          </div>

          {/* Calendar Events */}
          <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <h2 className="text-sm font-semibold text-[#f0f0f0] mb-3">Upcoming Events</h2>
            <div className="space-y-2">
              {calendarData?.calendarEvents?.slice(0, 5).map((event: any, i: number) => (
                <div key={i} className="p-2 bg-[#0a0a0a] rounded border border-[#1f1f1f]">
                  <div className="flex items-start justify-between gap-2">
                    <div className="flex-1 min-w-0">
                      <p className="text-sm font-medium text-[#f0f0f0] truncate">{event.title}</p>
                      <p className="text-xs text-[#555] mt-0.5">
                        {event.date} {event.time} {event.timezone}
                      </p>
                    </div>
                    <StatusBadge variant={
                      event.impact === 'HIGH' ? 'error' :
                      event.impact === 'MEDIUM' ? 'warning' :
                      'info'
                    }>
                      {event.type}
                    </StatusBadge>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
