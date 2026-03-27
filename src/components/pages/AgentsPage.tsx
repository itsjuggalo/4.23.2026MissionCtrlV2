import React, { useState, useEffect } from 'react';

interface Agent {
  id: string;
  name: string;
  tier: number;
  tierName: string;
  dna: string;
  status: 'online' | 'offline' | 'error';
  specialty: string;
  description: string;
  stats?: {
    [key: string]: any;
  };
  uptime?: string;
  lastActive?: string;
}

const TIER_INFO = {
  1: { name: 'Intelligence', color: 'bg-purple-500', description: 'Market signal detection and macro analysis' },
  2: { name: 'Analysis', color: 'bg-blue-500', description: 'Technical analysis and risk assessment' },
  3: { name: 'Execution', color: 'bg-green-500', description: 'Trade execution and portfolio management' },
  4: { name: 'Review', color: 'bg-yellow-500', description: 'Performance review and optimization' },
  5: { name: 'Support', color: 'bg-gray-500', description: 'Communications and system monitoring' }
};

export function AgentsPage() {
  const [agents, setAgents] = useState<Agent[]>([]);
  const [loading, setLoading] = useState(true);
  const [selectedTier, setSelectedTier] = useState<number | null>(null);

  useEffect(() => {
    fetchAgents();
    const interval = setInterval(fetchAgents, 10000); // Refresh every 10 seconds
    return () => clearInterval(interval);
  }, []);

  const fetchAgents = async () => {
    try {
      const response = await fetch('/api/agents');
      const data = await response.json();
      
      if (data.success) {
        setAgents(data.agents);
      }
      setLoading(false);
    } catch (error) {
      console.error('Error fetching agents:', error);
      setLoading(false);
    }
  };

  const getAgentsByTier = (tier: number) => {
    return agents.filter(agent => agent.tier === tier);
  };

  const getStatusColor = (status: string) => {
    switch (status) {
      case 'online': return 'bg-green-500';
      case 'offline': return 'bg-gray-500';
      case 'error': return 'bg-red-500';
      default: return 'bg-gray-500';
    }
  };

  const filteredAgents = selectedTier ? getAgentsByTier(selectedTier) : agents;

  if (loading) {
    return (
      <div className="flex items-center justify-center h-screen">
        <div className="text-white text-xl">Loading agents...</div>
      </div>
    );
  }

  return (
    <div className="p-6 space-y-6">
      {/* Header */}
      <div>
        <h1 className="text-3xl font-bold text-white">Trading Team</h1>
        <p className="text-gray-400 mt-1">13 specialized AI agents working together</p>
      </div>

      {/* Stats Overview */}
      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        <div className="bg-slate-800 rounded-lg p-4">
          <div className="text-gray-400 text-sm">Total Agents</div>
          <div className="text-white text-2xl font-bold mt-1">{agents.length}</div>
        </div>
        
        <div className="bg-slate-800 rounded-lg p-4">
          <div className="text-gray-400 text-sm">Online</div>
          <div className="text-green-400 text-2xl font-bold mt-1">
            {agents.filter(a => a.status === 'online').length}
          </div>
        </div>
        
        <div className="bg-slate-800 rounded-lg p-4">
          <div className="text-gray-400 text-sm">Offline</div>
          <div className="text-gray-400 text-2xl font-bold mt-1">
            {agents.filter(a => a.status === 'offline').length}
          </div>
        </div>
        
        <div className="bg-slate-800 rounded-lg p-4">
          <div className="text-gray-400 text-sm">Errors</div>
          <div className="text-red-400 text-2xl font-bold mt-1">
            {agents.filter(a => a.status === 'error').length}
          </div>
        </div>
      </div>

      {/* Tier Filter */}
      <div className="flex space-x-2 overflow-x-auto pb-2">
        <button
          onClick={() => setSelectedTier(null)}
          className={`px-4 py-2 rounded-lg whitespace-nowrap ${!selectedTier ? 'bg-blue-500 text-white' : 'bg-slate-800 text-gray-400'}`}
        >
          All Tiers
        </button>
        {Object.entries(TIER_INFO).map(([tier, info]) => (
          <button
            key={tier}
            onClick={() => setSelectedTier(Number(tier))}
            className={`px-4 py-2 rounded-lg whitespace-nowrap ${selectedTier === Number(tier) ? info.color + ' text-white' : 'bg-slate-800 text-gray-400'}`}
          >
            Tier {tier}: {info.name}
          </button>
        ))}
      </div>

      {/* Agents by Tier */}
      {[1, 2, 3, 4, 5].map(tier => {
        const tierAgents = getAgentsByTier(tier);
        if (selectedTier && selectedTier !== tier) return null;
        if (tierAgents.length === 0) return null;

        const tierInfo = TIER_INFO[tier as keyof typeof TIER_INFO];

        return (
          <div key={tier} className="space-y-4">
            {/* Tier Header */}
            <div className="flex items-center space-x-4">
              <div className={`w-2 h-12 ${tierInfo.color} rounded-full`}></div>
              <div>
                <h2 className="text-2xl font-bold text-white">
                  Tier {tier}: {tierInfo.name}
                </h2>
                <p className="text-gray-400 text-sm">{tierInfo.description}</p>
              </div>
            </div>

            {/* Agent Cards */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
              {tierAgents.map(agent => (
                <div key={agent.id} className="bg-slate-800 rounded-lg p-6 hover:bg-slate-700 transition-colors">
                  {/* Agent Header */}
                  <div className="flex items-start justify-between mb-4">
                    <div>
                      <h3 className="text-xl font-bold text-white">{agent.name}</h3>
                      <p className="text-gray-400 text-sm">{agent.dna}</p>
                    </div>
                    <div className="flex items-center space-x-2">
                      <div className={`w-3 h-3 ${getStatusColor(agent.status)} rounded-full animate-pulse`}></div>
                      <span className="text-xs text-gray-400">{agent.status}</span>
                    </div>
                  </div>

                  {/* Specialty */}
                  <div className="mb-4">
                    <div className="text-xs text-gray-500 uppercase mb-1">Specialty</div>
                    <div className="text-white text-sm font-semibold">{agent.specialty}</div>
                  </div>

                  {/* Description */}
                  <p className="text-gray-400 text-sm mb-4">{agent.description}</p>

                  {/* Stats */}
                  {agent.stats && Object.keys(agent.stats).length > 0 && (
                    <div className="border-t border-gray-700 pt-4 space-y-2">
                      {Object.entries(agent.stats).slice(0, 4).map(([key, value]) => (
                        <div key={key} className="flex justify-between text-sm">
                          <span className="text-gray-500">{key}:</span>
                          <span className="text-white font-semibold">{value}</span>
                        </div>
                      ))}
                    </div>
                  )}

                  {/* Uptime */}
                  {agent.uptime && (
                    <div className="mt-4 text-xs text-gray-500">
                      Uptime: {agent.uptime}
                    </div>
                  )}
                </div>
              ))}
            </div>
          </div>
        );
      })}

      {/* No agents message */}
      {filteredAgents.length === 0 && (
        <div className="text-center text-gray-400 py-12">
          No agents found in this tier.
        </div>
      )}
    </div>
  );
}
