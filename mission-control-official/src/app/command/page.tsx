'use client';
import React, { useEffect, useState } from 'react';
import AgentCard from '@/components/agents/AgentCard';
import MissionProgress from '@/components/agents/MissionProgress';

export default function CommandCenter() {
  const [agents, setAgents] = useState<any>(null);
  const [mission, setMission] = useState<any>(null);
  const [alerts, setAlerts] = useState<any>(null);

  useEffect(() => {
    const fetchData = async () => {
      const [agentsRes, missionRes, alertsRes] = await Promise.all([
        fetch('/api/agents/status'),
        fetch('/api/mission'),
        fetch('/api/alerts')
      ]);
      
      setAgents(await agentsRes.json());
      setMission(await missionRes.json());
      setAlerts(await alertsRes.json());
    };

    fetchData();
    const interval = setInterval(fetchData, 5000); // Refresh every 5s
    return () => clearInterval(interval);
  }, []);

  if (!agents || !mission || !alerts) {
    return (
      <div className="flex items-center justify-center min-h-screen">
        <p className="text-[#888]">Loading command center...</p>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-black p-6">
      <h1 className="text-3xl font-bold text-white mb-6">🎯 Command Center</h1>

      <MissionProgress {...mission} />

      <div className="grid grid-cols-3 gap-6 mb-6">
        <AgentCard {...agents.boba} />
        <AgentCard {...agents.jazzyhazzy} />
        <AgentCard {...agents.orion} />
      </div>

      <div className="bg-[#1a1a1a] border border-[#333] rounded-lg p-6">
        <h2 className="text-xl font-bold text-white mb-4">📡 Live Pipeline</h2>
        
        {alerts.boba.length === 0 ? (
          <p className="text-[#888] text-center py-8">
            No collaborative trades yet. First Orion → JazzyHazzy → Boba workflow will appear here.
          </p>
        ) : (
          <div className="space-y-2">
            {alerts.boba.slice(0, 10).reverse().map((alert: any, i: number) => (
              <div key={i} className="bg-[#0a0a0a] rounded p-3 flex items-center justify-between">
                <div>
                  <span className="text-xs text-[#666]">
                    {new Date(alert.timestamp).toLocaleTimeString()}
                  </span>
                  <span className="text-sm text-white ml-3">
                    Boba → {alert.action} {alert.ticker} @ ${alert.price}
                  </span>
                </div>
                <div className="text-xs text-[#888]">{alert.reason}</div>
              </div>
            ))}
          </div>
        )}
      </div>

      <div className="mt-6 bg-[#1a1a1a] border border-amber-500/30 rounded-lg p-4">
        <h3 className="text-amber-500 font-bold mb-2">⚠️ Next Major Event</h3>
        <p className="text-white">CPI Release - Tomorrow 8:30 AM EST</p>
        <p className="text-sm text-[#888]">High volatility expected. LLY decision pending.</p>
      </div>
    </div>
  );
}
