'use client';
import { useState, useEffect } from 'react';
import { PageHeader } from '@/components/shared/PageHeader';
import { ErrorBoundary } from '@/components/shared/ErrorBoundary';
import { KnowledgeGraph } from '@/components/memory/KnowledgeGraph';
import { FileText, Calendar, Tag, Brain, BookOpen, Search, ChevronDown, ChevronRight, GitBranch } from 'lucide-react';

interface MemoryEntry {
  date: string;
  content: string;
  type: 'insight' | 'decision' | 'event' | 'note';
  source: string;
  time?: string;
}

interface GraphNode {
  id: string;
  label: string;
  type: 'file' | 'tag';
  date?: string;
  entryCount?: number;
  tags?: string[];
}

interface GraphLink {
  source: string;
  target: string;
  strength: number;
}

interface MemoryData {
  entries: MemoryEntry[];
  count: number;
  longTermMemory: string | null;
  graph: { nodes: GraphNode[]; links: GraphLink[] };
  timestamp: string;
}

const typeBadge: Record<string, string> = {
  insight: 'bg-blue-500/10 text-blue-400 border border-blue-500/20',
  decision: 'bg-yellow-500/10 text-yellow-400 border border-yellow-500/20',
  event: 'bg-green-500/10 text-green-400 border border-green-500/20',
  note: 'bg-white/5 text-[#666] border border-white/10',
};

const typeIcon: Record<string, string> = {
  insight: '💡',
  decision: '⚖️',
  event: '📌',
  note: '📝',
};

function groupByDate(entries: MemoryEntry[]) {
  const groups: Record<string, MemoryEntry[]> = {};
  for (const e of entries) {
    if (!groups[e.date]) groups[e.date] = [];
    groups[e.date].push(e);
  }
  return groups;
}

function LongTermMemory({ content }: { content: string }) {
  const [expanded, setExpanded] = useState(true);

  // Parse top-level ## sections
  const sections = content.split(/^##\s+/m).filter(s => s.trim());
  const intro = sections[0]?.startsWith('#') ? sections[0] : null;
  const namedSections = intro ? sections.slice(1) : sections;

  return (
    <div className="bg-[#0d0d0d] border border-amber-500/20 rounded-lg mb-6">
      <button
        onClick={() => setExpanded(!expanded)}
        className="w-full flex items-center gap-3 p-4 text-left hover:bg-amber-500/5 transition-colors rounded-lg"
      >
        <Brain className="w-4 h-4 text-amber-400 flex-shrink-0" />
        <span className="text-sm font-semibold text-amber-400">Long-Term Memory (MEMORY.md)</span>
        <span className="ml-auto text-xs text-[#555]">{namedSections.length} sections</span>
        {expanded ? <ChevronDown className="w-4 h-4 text-[#555]" /> : <ChevronRight className="w-4 h-4 text-[#555]" />}
      </button>

      {expanded && (
        <div className="px-4 pb-4 space-y-3 border-t border-amber-500/10">
          {namedSections.slice(0, 20).map((section, i) => {
            const lines = section.split('\n');
            const title = lines[0].trim();
            const body = lines.slice(1).join('\n').trim();
            if (!body) return null;
            return (
              <div key={i} className="bg-[#111] border border-[#1f1f1f] rounded p-3 mt-3">
                <div className="flex items-center gap-2 mb-2">
                  <span className="text-xs font-semibold text-amber-400/80">{title}</span>
                </div>
                <pre className="text-xs text-[#aaa] whitespace-pre-wrap font-sans leading-relaxed line-clamp-6">
                  {body.slice(0, 600)}{body.length > 600 ? '…' : ''}
                </pre>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}

function MemoryStats({ entries, longTermMemory }: { entries: MemoryEntry[]; longTermMemory: string | null }) {
  const byType = entries.reduce((acc, e) => {
    acc[e.type] = (acc[e.type] || 0) + 1;
    return acc;
  }, {} as Record<string, number>);

  const uniqueDates = new Set(entries.map(e => e.date)).size;
  const uniqueSources = new Set(entries.map(e => e.source)).size;

  return (
    <div className="grid grid-cols-5 gap-3 mb-6">
      {[
        { label: 'Total Entries', value: entries.length, color: 'text-[#f0f0f0]' },
        { label: 'Insights', value: byType.insight || 0, color: 'text-blue-400' },
        { label: 'Decisions', value: byType.decision || 0, color: 'text-yellow-400' },
        { label: 'Days Logged', value: uniqueDates, color: 'text-green-400' },
        { label: 'Source Files', value: uniqueSources, color: 'text-purple-400' },
      ].map(stat => (
        <div key={stat.label} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-3 text-center">
          <div className={`text-2xl font-bold ${stat.color}`}>{stat.value}</div>
          <div className="text-xs text-[#555] mt-0.5">{stat.label}</div>
        </div>
      ))}
    </div>
  );
}

function MemoryList({ entries, search }: { entries: MemoryEntry[]; search: string }) {
  const filtered = entries.filter(e =>
    !search ||
    e.content.toLowerCase().includes(search.toLowerCase()) ||
    e.source.toLowerCase().includes(search.toLowerCase())
  );

  const grouped = groupByDate(filtered);
  const dates = Object.keys(grouped).sort((a, b) => b.localeCompare(a));

  if (dates.length === 0) {
    return (
      <div className="text-center py-16">
        <Brain className="w-8 h-8 text-[#333] mx-auto mb-3" />
        <p className="text-sm text-[#555]">
          {search ? 'No entries match your search.' : 'No daily memory entries found.'}
        </p>
      </div>
    );
  }

  return (
    <div className="space-y-8">
      {dates.map(date => (
        <div key={date}>
          <div className="flex items-center gap-2 mb-3 sticky top-0 bg-[#0a0a0a] py-1 z-10">
            <Calendar className="w-3.5 h-3.5 text-[#444]" />
            <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider">{date}</h2>
            <span className="text-xs text-[#333]">· {grouped[date].length} entries</span>
          </div>

          <div className="space-y-2">
            {grouped[date].map((entry, i) => (
              <div
                key={i}
                className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 hover:border-[#2a2a2a] transition-colors"
              >
                <div className="flex items-center gap-2 mb-2 flex-wrap">
                  <span className="text-base">{typeIcon[entry.type] || '📝'}</span>
                  <span className={`inline-flex items-center px-1.5 py-0.5 rounded text-[10px] font-medium ${typeBadge[entry.type] || typeBadge.note}`}>
                    {entry.type}
                  </span>
                  <span className="text-[10px] text-[#444] flex items-center gap-1">
                    <Tag className="w-2.5 h-2.5" />
                    {entry.source}
                  </span>
                  {entry.time && (
                    <span className="ml-auto text-[10px] text-[#333]">{entry.time} UTC</span>
                  )}
                </div>
                <pre className="text-xs text-[#bbb] whitespace-pre-wrap font-sans leading-relaxed">
                  {entry.content}
                </pre>
              </div>
            ))}
          </div>
        </div>
      ))}
    </div>
  );
}

function MemoryPageInner() {
  const [data, setData] = useState<MemoryData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [search, setSearch] = useState('');
  const [activeTab, setActiveTab] = useState<'all' | 'insights' | 'decisions' | 'events'>('all');
  const [graphExpanded, setGraphExpanded] = useState(true);
  const [selectedNode, setSelectedNode] = useState<GraphNode | null>(null);

  useEffect(() => {
    fetch('/api/memory')
      .then(res => {
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        return res.json();
      })
      .then(d => { setData(d); setLoading(false); })
      .catch(err => { setError(err.message); setLoading(false); });
  }, []);

  if (loading) {
    return (
      <div className="flex items-center justify-center py-20">
        <div className="text-center">
          <Brain className="w-8 h-8 text-[#333] mx-auto mb-3 animate-pulse" />
          <p className="text-sm text-[#555]">Loading memory files...</p>
        </div>
      </div>
    );
  }

  if (error || !data) {
    return (
      <div className="bg-red-500/10 border border-red-500/20 rounded-lg p-4">
        <p className="text-sm text-red-400">Failed to load memory: {error}</p>
        <p className="text-xs text-red-400/60 mt-1">Check /api/memory endpoint</p>
      </div>
    );
  }

  const tabTypeMap: Record<string, string> = { insights: 'insight', decisions: 'decision', events: 'event' };
  const filtered = activeTab === 'all'
    ? data.entries
    : data.entries.filter(e => e.type === tabTypeMap[activeTab]);

  return (
    <div>
      {/* Long-term memory */}
      {data.longTermMemory && <LongTermMemory content={data.longTermMemory} />}

      {/* Knowledge Graph */}
      {data.graph && data.graph.nodes.length > 0 && (
        <div className="bg-[#0d0d0d] border border-[#1e1e2a] rounded-lg mb-6">
          <button
            onClick={() => setGraphExpanded(g => !g)}
            className="w-full flex items-center gap-3 p-4 text-left hover:bg-white/5 transition-colors rounded-lg"
          >
            <GitBranch className="w-4 h-4 text-purple-400 flex-shrink-0" />
            <span className="text-sm font-semibold text-purple-400">Knowledge Graph</span>
            <span className="ml-2 text-xs text-[#555]">
              {data.graph.nodes.filter(n => n.type === 'file').length} files · {data.graph.nodes.filter(n => n.type === 'tag').length} topic clusters · {data.graph.links.length} connections
            </span>
            <span className="ml-auto text-xs text-[#444]">{graphExpanded ? '▲' : '▼'}</span>
          </button>
          {graphExpanded && (
            <div className="px-4 pb-4 border-t border-[#1e1e2a] pt-3">
              <ErrorBoundary name="Knowledge Graph">
                <KnowledgeGraph
                  nodes={data.graph.nodes}
                  links={data.graph.links}
                  onNodeClick={node => setSelectedNode(node)}
                />
              </ErrorBoundary>
              {selectedNode && (
                <div className="mt-3 bg-[#111] border border-[#2a2a3a] rounded p-3 text-xs">
                  <div className="font-semibold text-[#f0f0f0] mb-1">{selectedNode.label}</div>
                  {selectedNode.type === 'file' && selectedNode.tags && (
                    <div className="text-[#777]">Topics: {selectedNode.tags.join(', ')}</div>
                  )}
                  {selectedNode.type === 'tag' && (
                    <div className="text-[#777]">
                      Connected to {data.graph.links.filter(l => l.source === selectedNode.id || l.target === selectedNode.id).length} files
                    </div>
                  )}
                </div>
              )}
            </div>
          )}
        </div>
      )}

      {/* Stats */}
      <MemoryStats entries={data.entries} longTermMemory={data.longTermMemory} />

      {/* Filter + Search bar */}
      <div className="flex items-center gap-3 mb-6 flex-wrap">
        <div className="relative flex-1 min-w-[200px] max-w-sm">
          <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 w-3.5 h-3.5 text-[#444]" />
          <input
            value={search}
            onChange={e => setSearch(e.target.value)}
            placeholder="Search memory..."
            className="w-full pl-8 pr-3 py-2 text-sm bg-[#111] border border-[#1f1f1f] rounded text-[#f0f0f0] placeholder-[#444] focus:outline-none focus:border-blue-500/40"
          />
        </div>
        <div className="flex gap-1">
          {(['all', 'insights', 'decisions', 'events'] as const).map(tab => (
            <button
              key={tab}
              onClick={() => setActiveTab(tab)}
              className={`px-3 py-1.5 text-xs rounded transition-colors capitalize ${
                activeTab === tab
                  ? 'bg-amber-500/10 text-amber-400 border border-amber-500/20'
                  : 'text-[#555] hover:text-[#f0f0f0] hover:bg-[#161616]'
              }`}
            >
              {tab}
            </button>
          ))}
        </div>
        <span className="text-xs text-[#444] ml-auto">
          {data.count} entries · updated {new Date(data.timestamp).toLocaleTimeString()}
        </span>
      </div>

      {/* Daily logs */}
      <div>
        <div className="flex items-center gap-2 mb-4">
          <BookOpen className="w-4 h-4 text-[#555]" />
          <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider">Daily Logs (memory/*.md)</h2>
        </div>
        <MemoryList entries={filtered} search={search} />
      </div>
    </div>
  );
}

export default function MemoryPage() {
  return (
    <div>
      <PageHeader title="Memory" subtitle="Knowledge base from MEMORY.md + daily logs — Obsidian-style" />
      <ErrorBoundary name="Memory">
        <MemoryPageInner />
      </ErrorBoundary>
    </div>
  );
}
