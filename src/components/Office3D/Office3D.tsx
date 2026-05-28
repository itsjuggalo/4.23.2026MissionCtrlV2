'use client';

import { Canvas } from '@react-three/fiber';
import { OrbitControls, Sky, Environment } from '@react-three/drei';
import { Suspense, useState, useEffect } from 'react';
import { Vector3 } from 'three';
import { AGENTS } from './agentsConfig';
import type { AgentState } from './agentsConfig';
import AgentDesk from './AgentDesk';
import Floor from './Floor';
import Walls from './Walls';
import Lights from './Lights';
import CoffeeMachine from './CoffeeMachine';
import PlantPot from './PlantPot';
import WallClock from './WallClock';
import Whiteboard from './Whiteboard';
import FileCabinet from './FileCabinet';
import MovingAvatar from './MovingAvatar';

export default function Office3D() {
  const [selectedAgent, setSelectedAgent] = useState<string | null>(null);
  const [_interactionModal, setInteractionModal] = useState<string | null>(null);
  const [avatarPositions, setAvatarPositions] = useState<Map<string, any>>(new Map());

  // Fetch real agent status from our API
  const [agentStates, setAgentStates] = useState<Record<string, AgentState>>({
    boba: { id: 'boba', status: 'idle', model: 'Sonnet 4-6', tokensPerHour: 0, tasksInQueue: 0, uptime: 0 },
    jazzyhazzy: { id: 'jazzyhazzy', status: 'idle', model: 'GPT-4o-mini', tokensPerHour: 0, tasksInQueue: 0, uptime: 0 },
    orion: { id: 'orion', status: 'idle', model: 'Gemini 2.5', tokensPerHour: 0, tasksInQueue: 0, uptime: 0 },
    groot: { id: 'groot', status: 'idle', model: 'Grok', tokensPerHour: 0, tasksInQueue: 0, uptime: 0 },
    deepsheet: { id: 'deepsheet', status: 'idle', model: 'DeepSeek', tokensPerHour: 0, tasksInQueue: 0, uptime: 0 },
  });

  useEffect(() => {
    async function fetchAgentStatus() {
      try {
        const trustRes = await fetch('/api/agent-trust').then(r => r.ok ? r.json() : { agents: [] }).catch(() => ({ agents: [] }));
        const agents = trustRes.agents || [];

        const newStates: Record<string, AgentState> = { ...agentStates };

        for (const a of agents) {
          const name = (a.agent || '').toLowerCase();
          let id = '';
          if (name.includes('boba')) id = 'boba';
          else if (name.includes('jazzy')) id = 'jazzyhazzy';
          else if (name.includes('orion')) id = 'orion';
          else if (name.includes('grok') || name.includes('groot')) id = 'groot';
          else if (name.includes('deep')) id = 'deepsheet';
          else continue;

          const metrics: Record<string, number> = {};
          (a.metrics || []).forEach((m: any) => { metrics[m.metric_type] = m.avg_val; });

          const activity = metrics.activity || 0;
          const uptime = metrics.uptime || 0;
          let status: 'idle' | 'working' | 'thinking' | 'error' = 'idle';
          if (activity > 50) status = 'working';
          else if (activity > 20) status = 'thinking';
          if (uptime < 50) status = 'error';

          newStates[id] = {
            ...newStates[id],
            status,
            uptime: Math.round(uptime),
            tokensPerHour: Math.round(metrics.speed || 0) * 100,
          };
        }

        setAgentStates(newStates);
      } catch {}
    }

    fetchAgentStatus();
    const i = setInterval(fetchAgentStatus, 30000);
    return () => clearInterval(i);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const handleAvatarPositionUpdate = (id: string, position: any) => {
    setAvatarPositions(prev => new Map(prev).set(id, position));
  };

  const obstacles = [
    ...AGENTS.map(agent => ({
      position: new Vector3(agent.position[0], 0, agent.position[2]),
      radius: 1.5
    })),
    { position: new Vector3(-8, 0, -5), radius: 0.8 },
    { position: new Vector3(0, 0, -8), radius: 1.5 },
    { position: new Vector3(8, 0, -5), radius: 0.6 },
    { position: new Vector3(-7, 0, 6), radius: 0.5 },
    { position: new Vector3(7, 0, 6), radius: 0.5 },
  ];

  return (
    <div style={{ position: 'fixed', inset: 0, background: '#0a1929', height: '100vh', width: '100vw' }}>
      <Canvas
        camera={{ position: [0, 8, 12], fov: 60 }}
        shadows
        gl={{ antialias: true, alpha: false }}
        style={{ width: '100%', height: '100%' }}
      >
        <Suspense fallback={
          <mesh>
            <boxGeometry args={[2, 2, 2]} />
            <meshStandardMaterial color="#4fc3f7" />
          </mesh>
        }>
          <Lights />
          <Sky sunPosition={[100, 20, 100]} />
          <Environment preset="sunset" />
          <Floor />
          <Walls />

          {AGENTS.map((agent) => (
            <AgentDesk
              key={agent.id}
              agent={agent}
              state={agentStates[agent.id]}
              onClick={() => setSelectedAgent(agent.id)}
              isSelected={selectedAgent === agent.id}
            />
          ))}

          {AGENTS.map((agent) => (
            <MovingAvatar
              key={`avatar-${agent.id}`}
              agent={agent}
              state={agentStates[agent.id]}
              officeBounds={{ minX: -8, maxX: 8, minZ: -7, maxZ: 7 }}
              obstacles={obstacles}
              otherAvatarPositions={avatarPositions}
              onPositionUpdate={handleAvatarPositionUpdate}
            />
          ))}

          <FileCabinet position={[-8, 0, -5]} onClick={() => setInteractionModal('memory')} />
          <Whiteboard position={[0, 0, -8]} rotation={[0, 0, 0]} onClick={() => setInteractionModal('roadmap')} />
          <CoffeeMachine position={[8, 0.8, -5]} onClick={() => setInteractionModal('energy')} />
          <PlantPot position={[-7, 0, 6]} size="large" />
          <PlantPot position={[7, 0, 6]} size="medium" />
          <WallClock position={[0, 2.5, -8.4]} rotation={[0, 0, 0]} />

          <OrbitControls
            enableDamping
            dampingFactor={0.05}
            minDistance={5}
            maxDistance={30}
            maxPolarAngle={Math.PI / 2.2}
          />
        </Suspense>
      </Canvas>

      {/* Agent Panel */}
      {selectedAgent && (
        <div style={{ position: 'absolute', top: 0, right: 0, width: '360px', height: '100%', background: 'rgba(10,25,41,0.95)', borderLeft: '1px solid #1a3a4a', padding: '24px', overflowY: 'auto', zIndex: 50 }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '20px' }}>
            <h2 style={{ fontSize: '20px', fontWeight: 800, color: '#4fc3f7', fontFamily: 'var(--font-mc-mono)' }}>
              {AGENTS.find(a => a.id === selectedAgent)?.emoji} {AGENTS.find(a => a.id === selectedAgent)?.name}
            </h2>
            <button onClick={() => setSelectedAgent(null)} style={{ background: 'none', border: 'none', color: '#607d8b', fontSize: '24px', cursor: 'pointer' }}>x</button>
          </div>
          <div style={{ fontSize: '14px', color: '#90a4ae', fontFamily: 'var(--font-mc-mono)', marginBottom: '16px' }}>
            {AGENTS.find(a => a.id === selectedAgent)?.role}
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
            <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>STATUS</div>
              <div style={{ fontSize: '18px', fontWeight: 700, color: agentStates[selectedAgent]?.status === 'working' ? '#66bb6a' : agentStates[selectedAgent]?.status === 'error' ? '#ef5350' : agentStates[selectedAgent]?.status === 'thinking' ? '#4fc3f7' : '#607d8b', fontFamily: 'var(--font-mc-mono)', textTransform: 'uppercase' }}>
                {agentStates[selectedAgent]?.status}
              </div>
            </div>
            <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>MODEL</div>
              <div style={{ fontSize: '16px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                {agentStates[selectedAgent]?.model}
              </div>
            </div>
            <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
              <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>UPTIME</div>
              <div style={{ fontSize: '16px', fontWeight: 700, color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                {agentStates[selectedAgent]?.uptime}%
              </div>
            </div>
            {agentStates[selectedAgent]?.currentTask && (
              <div style={{ padding: '12px 16px', background: '#0d1117', borderRadius: '8px' }}>
                <div style={{ fontSize: '11px', color: '#607d8b', fontFamily: 'var(--font-mc-mono)', marginBottom: '4px' }}>CURRENT TASK</div>
                <div style={{ fontSize: '13px', color: '#e0e0e0', fontFamily: 'var(--font-mc-mono)' }}>
                  {agentStates[selectedAgent]?.currentTask}
                </div>
              </div>
            )}
          </div>
        </div>
      )}

      {/* Controls */}
      <div style={{ position: 'absolute', top: '16px', left: '16px', background: 'rgba(10,25,41,0.85)', color: '#e0e0e0', padding: '16px', borderRadius: '8px', border: '1px solid #1a3a4a', fontFamily: 'var(--font-mc-mono)', fontSize: '12px', zIndex: 40 }}>
        <button onClick={() => window.history.back()} style={{ display: 'block', width: '100%', padding: '6px 12px', marginBottom: '10px', background: '#ef535022', border: '1px solid #ef535044', borderRadius: '4px', color: '#ef5350', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', fontWeight: 700, cursor: 'pointer' }}>← BACK TO DASHBOARD</button>
        <h2 style={{ fontSize: '16px', fontWeight: 800, color: '#4fc3f7', marginBottom: '8px' }}>THE OFFICE</h2>
        <p style={{ color: '#607d8b', marginBottom: '4px' }}>Mouse: Rotate view</p>
        <p style={{ color: '#607d8b', marginBottom: '4px' }}>Scroll: Zoom</p>
        <p style={{ color: '#607d8b' }}>Click desk: Select agent</p>
      </div>

      {/* Status Legend */}
      <div style={{ position: 'absolute', bottom: '16px', right: '16px', background: 'rgba(10,25,41,0.85)', padding: '16px', borderRadius: '8px', border: '1px solid #1a3a4a', fontFamily: 'var(--font-mc-mono)', fontSize: '11px', zIndex: 40 }}>
        <div style={{ fontWeight: 700, color: '#e0e0e0', marginBottom: '8px' }}>STATUS</div>
        {[
          { color: '#66bb6a', label: 'Working' },
          { color: '#4fc3f7', label: 'Thinking' },
          { color: '#607d8b', label: 'Idle' },
          { color: '#ef5350', label: 'Error' },
        ].map((s, i) => (
          <div key={i} style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '4px' }}>
            <div style={{ width: '10px', height: '10px', borderRadius: '50%', background: s.color }} />
            <span style={{ color: '#90a4ae' }}>{s.label}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
