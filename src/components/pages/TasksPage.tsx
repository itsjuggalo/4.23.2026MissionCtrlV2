'use client';
import { useEffect, useState, useMemo } from 'react';

// ============================================================================
// TERRAN COMMAND CONSOLE — Tasks Pipeline
// ============================================================================

interface TaskItem {
  id: string;
  ticker: string;
  action: 'BUY' | 'SELL' | 'SCAN' | 'HOLD';
  price?: number;
  source: string;
  agent: AgentKey;
  priority: 'critical' | 'high' | 'medium' | 'low';
  stage: StageKey;
  timestamp: string;
  detail?: string;
}

type StageKey = 'backlog' | 'progress' | 'review' | 'approved';
type AgentKey = 'BOBA' | 'JAZZYHAZZY' | 'ORION' | 'COMMANDER';

interface AgentStatus {
  key: AgentKey;
  name: string;
  role: string;
  state: 'ACTIVE' | 'IDLE' | 'SCANNING' | 'STANDBY';
  color: string;
}

const AGENTS: AgentStatus[] = [
  { key: 'BOBA', name: 'BOBA', role: 'ORCHESTRATOR', state: 'ACTIVE', color: '#4fc3f7' },
  { key: 'JAZZYHAZZY', name: 'JAZZYHAZZY', role: 'RESEARCH', state: 'IDLE', color: '#66bb6a' },
  { key: 'ORION', name: 'ORION', role: 'SCANNER', state: 'SCANNING', color: '#ff9800' },
  { key: 'COMMANDER', name: 'COMMANDER', role: 'YOU', state: 'STANDBY', color: '#81d4fa' },
];

const STAGES: { key: StageKey; label: string; color: string; icon: string }[] = [
  { key: 'backlog',  label: 'BACKLOG',     color: '#607d8b', icon: '◇' },
  { key: 'progress', label: 'IN PROGRESS', color: '#4fc3f7', icon: '◈' },
  { key: 'review',   label: 'REVIEW',      color: '#ff9800', icon: '◉' },
  { key: 'approved', label: 'APPROVED',    color: '#66bb6a', icon: '▣' },
];

const PRIORITY_COLOR: Record<string, string> = {
  critical: '#ef5350',
  high: '#ff9800',
  medium: '#4fc3f7',
  low: '#607d8b',
};

interface ActivityEntry {
  time: string;
  agent: AgentKey;
  action: string;
  detail: string;
  type: 'signal' | 'move' | 'approve' | 'reject' | 'system';
}

// ----------------------------------------------------------------------------
// SHARED STYLES — Terran chrome
// ----------------------------------------------------------------------------

const mono = "'JetBrains Mono','SF Mono',monospace";
const display = "'Orbitron','Audiowide','JetBrains Mono',sans-serif";

const hudBg = {
  background: 'linear-gradient(180deg, #0a1929 0%, #0d1117 100%)',
  border: '1px solid #1a3a4a',
};

// Chevron-clipped box (Terran style cut corners)
const chevronClip = 'polygon(8px 0, 100% 0, 100% calc(100% - 8px), calc(100% - 8px) 100%, 0 100%, 0 8px)';

// Scan line keyframes injected globally
const scanKeyframes = `
@keyframes terran-scan {
  0%   { transform: translateY(-100%); opacity: 0; }
  50%  { opacity: 1; }
  100% { transform: translateY(100%); opacity: 0; }
}
@keyframes terran-pulse {
  0%, 100% { opacity: 1; box-shadow: 0 0 0 0 rgba(79,195,247,0.4); }
  50%      { opacity: 0.7; box-shadow: 0 0 8px 2px rgba(79,195,247,0); }
}
@keyframes terran-blink {
  0%, 100% { opacity: 1; }
  50%      { opacity: 0.3; }
}
@keyframes terran-flow {
  0%   { transform: translateX(-100%); }
  100% { transform: translateX(100%); }
}
@keyframes terran-glow {
  0%, 100% { filter: drop-shadow(0 0 2px currentColor); }
  50%      { filter: drop-shadow(0 0 8px currentColor); }
}
`;

// ----------------------------------------------------------------------------
// MAIN PAGE
// ----------------------------------------------------------------------------

export function TasksPage() {
  const [tasks, setTasks] = useState<TaskItem[]>([]);
  const [activity, setActivity] = useState<ActivityEntry[]>([]);
  const [agentFilter, setAgentFilter] = useState<AgentKey | null>(null);
  const [now, setNow] = useState(new Date());
  const [throughput, setThroughput] = useState({ hourly: 0, total: 0 });

  // Live clock for HUD
  useEffect(() => {
    const t = setInterval(() => setNow(new Date()), 1000);
    return () => clearInterval(t);
  }, []);

  // Fetch data and build pipeline
  useEffect(() => {
    async function fetchAll() {
      try {
        const [report, regime, signalsLatest, signalsHist] = await Promise.all([
          fetch('/api/daily-report').then(r => r.json()).catch(() => null),
          fetch('/api/regime').then(r => r.json()).catch(() => null),
          fetch('/api/signals/latest').then(r => r.json()).catch(() => ({})),
          fetch('/api/signals/history?ticker=BTCUSD&limit=30').then(r => r.json()).catch(() => []),
        ]);

        const builtTasks: TaskItem[] = [];
        const builtActivity: ActivityEntry[] = [];

        // --- Signal history -> Backlog (new) + Approved (acted-on) ---
        const history = Array.isArray(signalsHist) ? signalsHist : [];
        history.slice(0, 20).forEach((sig: Record<string, unknown>, i: number) => {
          const action = String(sig.action || sig.side || 'SCAN').toUpperCase() as TaskItem['action'];
          const ticker = String(sig.ticker || sig.symbol || 'UNKNOWN').toUpperCase();
          const price = Number(sig.price || 0);
          const ts = String(sig.timestamp || new Date().toISOString());
          const age = Date.now() - new Date(ts).getTime();
          const isRecent = age < 1000 * 60 * 15; // 15 min

          builtTasks.push({
            id: `sig-${i}-${ticker}-${ts}`,
            ticker,
            action,
            price,
            source: String(sig.source || sig.strategy || 'signal-receiver'),
            agent: i % 3 === 0 ? 'BOBA' : i % 3 === 1 ? 'ORION' : 'JAZZYHAZZY',
            priority: action === 'BUY' && price > 50000 ? 'high' : 'medium',
            stage: isRecent ? 'backlog' : i < 3 ? 'progress' : i < 6 ? 'review' : 'approved',
            timestamp: ts,
            detail: `${action} ${ticker} @ $${price.toFixed(2)}`,
          });

          if (i < 10) {
            builtActivity.push({
              time: ts,
              agent: i % 3 === 0 ? 'BOBA' : i % 3 === 1 ? 'ORION' : 'JAZZYHAZZY',
              action: action === 'BUY' ? 'Signal received' : action === 'SELL' ? 'Exit signal' : 'Scan complete',
              detail: `${ticker} @ $${price.toFixed(2)}`,
              type: 'signal',
            });
          }
        });

        // --- Positions -> In Progress ---
        Object.entries(signalsLatest || {}).forEach(([ticker, data]) => {
          const d = data as Record<string, unknown>;
          if (d.direction) {
            builtTasks.push({
              id: `pos-${ticker}`,
              ticker,
              action: String(d.direction).toUpperCase() === 'LONG' ? 'BUY' : 'SELL',
              price: Number(d.entry_price || 0),
              source: 'position',
              agent: 'BOBA',
              priority: 'high',
              stage: 'progress',
              timestamp: String(d.last_signal_time || new Date().toISOString()),
              detail: `ACTIVE ${d.direction} @ $${Number(d.entry_price || 0).toFixed(2)}`,
            });
          }
        });

        // --- Regime status -> System task for Commander if unstable ---
        if (regime?.overall_regime) {
          const isUnstable =
            regime.overall_regime.includes('VOLATILE') || regime.overall_regime.includes('CHOP');
          builtTasks.push({
            id: 'regime-status',
            ticker: 'BTC',
            action: 'SCAN',
            source: 'regime-detector',
            agent: 'ORION',
            priority: isUnstable ? 'critical' : 'low',
            stage: isUnstable ? 'review' : 'approved',
            timestamp: regime.timestamp || new Date().toISOString(),
            detail: `Regime: ${regime.overall_regime.replace(/_/g, ' ')} · Bias: ${regime.direction_bias}`,
          });
        }

        // --- Throughput ---
        const signalsTotal = report?.signals?.total || 0;
        setThroughput({ hourly: Math.round(signalsTotal / 8), total: signalsTotal });

        setTasks(builtTasks);
        setActivity(builtActivity.reverse());
      } catch (e) {
        console.error('[tasks] fetch error', e);
      }
    }

    fetchAll();
    const i = setInterval(fetchAll, 30000);
    return () => clearInterval(i);
  }, []);

  // Filtered tasks
  const visibleTasks = useMemo(
    () => (agentFilter ? tasks.filter(t => t.agent === agentFilter) : tasks),
    [tasks, agentFilter]
  );

  const tasksByStage = useMemo(() => {
    const buckets: Record<StageKey, TaskItem[]> = {
      backlog: [],
      progress: [],
      review: [],
      approved: [],
    };
    visibleTasks.forEach(t => {
      if (buckets[t.stage]) buckets[t.stage].push(t);
    });
    return buckets;
  }, [visibleTasks]);

  const timeStr = now.toISOString().slice(11, 19);
  const dateStr = now.toISOString().slice(0, 10);

  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        gap: 12,
        fontFamily: mono,
        minHeight: '100%',
      }}
    >
      <style dangerouslySetInnerHTML={{ __html: scanKeyframes }} />

      {/* ========== HUD STATUS BAR ========== */}
      <HUDBar
        timeStr={timeStr}
        dateStr={dateStr}
        throughput={throughput}
        taskCount={tasks.length}
        agentFilter={agentFilter}
        onClearFilter={() => setAgentFilter(null)}
      />

      {/* ========== MAIN 3-COLUMN GRID ========== */}
      <div
        style={{
          display: 'grid',
          gridTemplateColumns: '180px 1fr 240px',
          gap: 12,
          alignItems: 'stretch',
        }}
      >
        {/* LEFT: agent roster */}
        <AgentRoster
          agents={AGENTS}
          taskCounts={tasks.reduce((acc, t) => {
            acc[t.agent] = (acc[t.agent] || 0) + 1;
            return acc;
          }, {} as Record<AgentKey, number>)}
          selected={agentFilter}
          onSelect={setAgentFilter}
        />

        {/* CENTER: pipeline */}
        <Pipeline tasksByStage={tasksByStage} />

        {/* RIGHT: activity feed */}
        <ActivityFeed entries={activity} />
      </div>
    </div>
  );
}

// ============================================================================
// COMPONENTS
// ============================================================================

function HUDBar({
  timeStr,
  dateStr,
  throughput,
  taskCount,
  agentFilter,
  onClearFilter,
}: {
  timeStr: string;
  dateStr: string;
  throughput: { hourly: number; total: number };
  taskCount: number;
  agentFilter: AgentKey | null;
  onClearFilter: () => void;
}) {
  return (
    <div
      style={{
        ...hudBg,
        clipPath: chevronClip,
        padding: '10px 18px',
        display: 'flex',
        alignItems: 'center',
        gap: 24,
        position: 'relative',
        overflow: 'hidden',
      }}
    >
      {/* Flowing scan line background */}
      <div
        style={{
          position: 'absolute',
          inset: 0,
          background:
            'linear-gradient(90deg, transparent 0%, rgba(79,195,247,0.08) 50%, transparent 100%)',
          animation: 'terran-flow 4s linear infinite',
          pointerEvents: 'none',
        }}
      />

      {/* Left: title + breadcrumb */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 10, zIndex: 1 }}>
        <span style={{ fontFamily: display, fontSize: 12, fontWeight: 900, color: '#4fc3f7', letterSpacing: 2 }}>
          MISSION CTRL
        </span>
        <span style={{ color: '#455a64', fontSize: 10 }}>▸</span>
        <span
          style={{
            fontFamily: display,
            fontSize: 12,
            fontWeight: 900,
            color: '#ff9800',
            letterSpacing: 2,
            textShadow: '0 0 8px rgba(255,152,0,0.4)',
          }}
        >
          TASKS
        </span>
      </div>

      <div style={{ flex: 1 }} />

      {/* Metrics */}
      <HUDMetric label="PIPELINE" value={String(taskCount)} color="#4fc3f7" />
      <HUDMetric label="SIGNALS 24H" value={String(throughput.total)} color="#66bb6a" />
      <HUDMetric label="THROUGHPUT" value={`${throughput.hourly}/hr`} color="#ff9800" />

      {agentFilter && (
        <button
          onClick={onClearFilter}
          style={{
            padding: '4px 12px',
            background: 'rgba(239,83,80,0.15)',
            border: '1px solid #ef5350',
            color: '#ef5350',
            fontFamily: mono,
            fontSize: 10,
            fontWeight: 700,
            letterSpacing: 1,
            cursor: 'pointer',
            clipPath: chevronClip,
          }}
        >
          ✕ FILTER: {agentFilter}
        </button>
      )}

      {/* Live clock */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 8, zIndex: 1 }}>
        <span
          style={{
            width: 8,
            height: 8,
            borderRadius: '50%',
            background: '#66bb6a',
            boxShadow: '0 0 8px #66bb6a',
            animation: 'terran-blink 1.4s infinite',
          }}
        />
        <span style={{ fontFamily: mono, fontSize: 11, color: '#66bb6a', fontWeight: 700 }}>LIVE</span>
        <span style={{ fontFamily: mono, fontSize: 11, color: '#607d8b' }}>
          {dateStr} {timeStr}Z
        </span>
      </div>
    </div>
  );
}

function HUDMetric({ label, value, color }: { label: string; value: string; color: string }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-end', zIndex: 1 }}>
      <span style={{ fontFamily: mono, fontSize: 9, color: '#455a64', letterSpacing: 1.5, fontWeight: 600 }}>
        {label}
      </span>
      <span style={{ fontFamily: display, fontSize: 14, color, fontWeight: 900, letterSpacing: 1 }}>
        {value}
      </span>
    </div>
  );
}

function AgentRoster({
  agents,
  taskCounts,
  selected,
  onSelect,
}: {
  agents: AgentStatus[];
  taskCounts: Record<AgentKey, number>;
  selected: AgentKey | null;
  onSelect: (a: AgentKey | null) => void;
}) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
      <SectionHeader label="AGENTS" />
      {agents.map(agent => (
        <AgentCard
          key={agent.key}
          agent={agent}
          taskCount={taskCounts[agent.key] || 0}
          selected={selected === agent.key}
          onClick={() => onSelect(selected === agent.key ? null : agent.key)}
        />
      ))}
    </div>
  );
}

function AgentCard({
  agent,
  taskCount,
  selected,
  onClick,
}: {
  agent: AgentStatus;
  taskCount: number;
  selected: boolean;
  onClick: () => void;
}) {
  const isProcessing = agent.state === 'ACTIVE' || agent.state === 'SCANNING';
  return (
    <div
      onClick={onClick}
      style={{
        ...hudBg,
        clipPath: chevronClip,
        padding: '10px 12px',
        cursor: 'pointer',
        position: 'relative',
        overflow: 'hidden',
        border: `1px solid ${selected ? agent.color : '#1a3a4a'}`,
        transition: 'border 0.2s',
      }}
    >
      {/* Scan line overlay on active */}
      {isProcessing && (
        <div
          style={{
            position: 'absolute',
            inset: 0,
            background: `linear-gradient(180deg, transparent 0%, ${agent.color}22 50%, transparent 100%)`,
            animation: 'terran-scan 2s linear infinite',
            pointerEvents: 'none',
          }}
        />
      )}

      <div style={{ display: 'flex', alignItems: 'center', gap: 6, marginBottom: 6 }}>
        <span
          style={{
            width: 6,
            height: 6,
            borderRadius: '50%',
            background: agent.color,
            boxShadow: `0 0 6px ${agent.color}`,
            animation: isProcessing ? 'terran-blink 1.2s infinite' : 'none',
            flexShrink: 0,
          }}
        />
        <span style={{ fontFamily: display, fontSize: 11, fontWeight: 900, color: agent.color, letterSpacing: 1 }}>
          {agent.name}
        </span>
      </div>
      <div style={{ fontFamily: mono, fontSize: 9, color: '#607d8b', letterSpacing: 1, marginBottom: 6 }}>
        {agent.role}
      </div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <span
          style={{
            fontFamily: mono,
            fontSize: 9,
            color: agent.color,
            letterSpacing: 1,
            padding: '1px 6px',
            background: `${agent.color}22`,
            border: `1px solid ${agent.color}55`,
          }}
        >
          {agent.state}
        </span>
        <span style={{ fontFamily: display, fontSize: 14, color: '#e0e0e0', fontWeight: 900 }}>
          {taskCount}
        </span>
      </div>
    </div>
  );
}

function Pipeline({ tasksByStage }: { tasksByStage: Record<StageKey, TaskItem[]> }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
      <SectionHeader label="PIPELINE" />
      <div
        style={{
          display: 'grid',
          gridTemplateColumns: 'repeat(4, 1fr)',
          gap: 8,
          flex: 1,
        }}
      >
        {STAGES.map(stage => (
          <PipelineStage key={stage.key} stage={stage} tasks={tasksByStage[stage.key]} />
        ))}
      </div>
    </div>
  );
}

function PipelineStage({
  stage,
  tasks,
}: {
  stage: { key: StageKey; label: string; color: string; icon: string };
  tasks: TaskItem[];
}) {
  return (
    <div
      style={{
        ...hudBg,
        clipPath: chevronClip,
        padding: '8px',
        display: 'flex',
        flexDirection: 'column',
        minHeight: 400,
      }}
    >
      {/* Stage header */}
      <div
        style={{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'space-between',
          padding: '6px 8px',
          marginBottom: 8,
          borderBottom: `1px solid ${stage.color}44`,
          background: `linear-gradient(90deg, ${stage.color}11 0%, transparent 100%)`,
        }}
      >
        <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
          <span style={{ color: stage.color, fontSize: 14 }}>{stage.icon}</span>
          <span
            style={{
              fontFamily: display,
              fontSize: 10,
              fontWeight: 900,
              color: stage.color,
              letterSpacing: 1.5,
            }}
          >
            {stage.label}
          </span>
        </div>
        <span style={{ fontFamily: display, fontSize: 12, color: '#e0e0e0', fontWeight: 900 }}>
          {tasks.length}
        </span>
      </div>

      {/* Task cards */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: 6, overflow: 'auto', flex: 1 }}>
        {tasks.length === 0 ? (
          <div
            style={{
              padding: 20,
              textAlign: 'center',
              fontFamily: mono,
              fontSize: 10,
              color: '#455a64',
              letterSpacing: 1,
            }}
          >
            — EMPTY —
          </div>
        ) : (
          tasks.slice(0, 10).map(task => <TaskCard key={task.id} task={task} stageColor={stage.color} />)
        )}
      </div>
    </div>
  );
}

function TaskCard({ task, stageColor }: { task: TaskItem; stageColor: string }) {
  const priColor = PRIORITY_COLOR[task.priority];
  const actionColor =
    task.action === 'BUY' ? '#66bb6a' :
    task.action === 'SELL' ? '#ef5350' :
    task.action === 'SCAN' ? '#ff9800' : '#607d8b';

  return (
    <div
      style={{
        background: '#0d1117',
        border: '1px solid #1a3a4a',
        borderLeft: `3px solid ${priColor}`,
        padding: '8px 10px',
        position: 'relative',
        clipPath: 'polygon(0 0, calc(100% - 4px) 0, 100% 4px, 100% 100%, 4px 100%, 0 calc(100% - 4px))',
      }}
    >
      {/* Top row: agent + timestamp */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 4 }}>
        <span
          style={{
            fontFamily: mono,
            fontSize: 8,
            color: '#607d8b',
            letterSpacing: 1,
            padding: '1px 4px',
            background: 'rgba(96,125,139,0.12)',
          }}
        >
          {task.agent.slice(0, 4)}
        </span>
        <span style={{ fontFamily: mono, fontSize: 8, color: '#455a64' }}>
          {formatAge(task.timestamp)}
        </span>
      </div>

      {/* Main row: ticker + action */}
      <div style={{ display: 'flex', alignItems: 'center', gap: 6, marginBottom: 4 }}>
        <span style={{ fontFamily: display, fontSize: 13, fontWeight: 900, color: '#e0e0e0', letterSpacing: 0.5 }}>
          {task.ticker}
        </span>
        <span
          style={{
            fontFamily: mono,
            fontSize: 9,
            fontWeight: 700,
            color: actionColor,
            background: `${actionColor}22`,
            padding: '1px 5px',
            letterSpacing: 1,
          }}
        >
          {task.action}
        </span>
      </div>

      {/* Detail */}
      <div style={{ fontFamily: mono, fontSize: 10, color: '#607d8b', lineHeight: 1.3 }}>
        {task.detail || task.source}
      </div>

      {/* Priority dot */}
      {task.priority === 'critical' && (
        <span
          style={{
            position: 'absolute',
            top: 6,
            right: 6,
            width: 6,
            height: 6,
            borderRadius: '50%',
            background: priColor,
            boxShadow: `0 0 6px ${priColor}`,
            animation: 'terran-blink 0.8s infinite',
          }}
        />
      )}
    </div>
  );
}

function ActivityFeed({ entries }: { entries: ActivityEntry[] }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
      <SectionHeader label="COMMS" />
      <div
        style={{
          ...hudBg,
          clipPath: chevronClip,
          padding: '10px 12px',
          flex: 1,
          overflow: 'auto',
          maxHeight: 600,
        }}
      >
        {entries.length === 0 ? (
          <div
            style={{
              padding: 20,
              textAlign: 'center',
              fontFamily: mono,
              fontSize: 10,
              color: '#455a64',
              letterSpacing: 1,
            }}
          >
            — STANDBY —
          </div>
        ) : (
          entries.map((e, i) => (
            <div key={i} style={{ marginBottom: 10, fontFamily: mono, fontSize: 10 }}>
              <div style={{ display: 'flex', gap: 6, alignItems: 'baseline', marginBottom: 2 }}>
                <span style={{ color: '#455a64', fontSize: 9 }}>
                  [{formatAge(e.time)}]
                </span>
                <span style={{ color: agentColor(e.agent), fontWeight: 700, fontSize: 9, letterSpacing: 0.5 }}>
                  {e.agent.slice(0, 6)}
                </span>
              </div>
              <div style={{ color: '#e0e0e0', marginLeft: 0 }}>▸ {e.action}</div>
              <div style={{ color: '#607d8b', marginLeft: 10, fontSize: 9 }}>{e.detail}</div>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

function SectionHeader({ label }: { label: string }) {
  return (
    <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
      <div style={{ width: 8, height: 1, background: '#4fc3f7' }} />
      <span
        style={{
          fontFamily: display,
          fontSize: 9,
          fontWeight: 900,
          color: '#4fc3f7',
          letterSpacing: 3,
          textShadow: '0 0 4px rgba(79,195,247,0.4)',
        }}
      >
        {label}
      </span>
      <div style={{ flex: 1, height: 1, background: 'linear-gradient(90deg, #4fc3f7, transparent)' }} />
    </div>
  );
}

// ============================================================================
// HELPERS
// ============================================================================

function agentColor(a: AgentKey): string {
  const x = AGENTS.find(x => x.key === a);
  return x?.color || '#e0e0e0';
}

function formatAge(iso: string): string {
  try {
    const d = new Date(iso).getTime();
    const diff = Math.floor((Date.now() - d) / 1000);
    if (diff < 60) return `${diff}s`;
    if (diff < 3600) return `${Math.floor(diff / 60)}m`;
    if (diff < 86400) return `${Math.floor(diff / 3600)}h`;
    return `${Math.floor(diff / 86400)}d`;
  } catch {
    return '—';
  }
}
