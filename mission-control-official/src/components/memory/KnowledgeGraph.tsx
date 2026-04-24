'use client';
import { useEffect, useRef, useState } from 'react';
import * as d3 from 'd3';

interface GraphNode {
  id: string;
  label: string;
  type: 'file' | 'tag';
  date?: string;
  entryCount?: number;
  tags?: string[];
  // d3 simulation adds these:
  x?: number;
  y?: number;
  vx?: number;
  vy?: number;
  fx?: number | null;
  fy?: number | null;
}

interface GraphLink {
  source: string | GraphNode;
  target: string | GraphNode;
  strength: number;
}

interface Props {
  nodes: GraphNode[];
  links: GraphLink[];
  onNodeClick?: (node: GraphNode) => void;
}

const TAG_COLORS: Record<string, string> = {
  BTC: '#f7931a',
  LLY: '#00d2a0',
  Risk: '#ff4757',
  Macro: '#a29bfe',
  Signals: '#74b9ff',
  Strategy: '#fd79a8',
  'P&L': '#55efc4',
  NVDA: '#6c5ce7',
  Agents: '#ffeaa7',
  Discord: '#7289da',
};

export function KnowledgeGraph({ nodes, links, onNodeClick }: Props) {
  const svgRef = useRef<SVGSVGElement>(null);
  const [tooltip, setTooltip] = useState<{ x: number; y: number; node: GraphNode } | null>(null);
  const [selectedNode, setSelectedNode] = useState<string | null>(null);

  useEffect(() => {
    if (!svgRef.current || nodes.length === 0) return;

    const svg = d3.select(svgRef.current);
    svg.selectAll('*').remove();

    const width = svgRef.current.clientWidth || 800;
    const height = svgRef.current.clientHeight || 500;

    // Zoom/pan container
    const g = svg.append('g');
    svg.call(
      d3.zoom<SVGSVGElement, unknown>()
        .scaleExtent([0.2, 4])
        .on('zoom', (event) => g.attr('transform', event.transform))
    );

    // Deep copy nodes/links for simulation
    const simNodes: GraphNode[] = nodes.map(n => ({ ...n }));
    const nodeById = new Map(simNodes.map(n => [n.id, n]));
    const simLinks = links
      .map(l => ({
        source: nodeById.get(typeof l.source === 'string' ? l.source : l.source.id) as GraphNode,
        target: nodeById.get(typeof l.target === 'string' ? l.target : l.target.id) as GraphNode,
        strength: l.strength,
      }))
      .filter(l => l.source && l.target);

    const simulation = d3.forceSimulation(simNodes)
      .force('link', d3.forceLink(simLinks).id((d: any) => d.id).distance(d => (d as any).source?.type === 'tag' ? 60 : 100).strength(0.4))
      .force('charge', d3.forceManyBody().strength(-200))
      .force('center', d3.forceCenter(width / 2, height / 2))
      .force('collision', d3.forceCollide(28));

    // Links
    const link = g.append('g').selectAll('line')
      .data(simLinks)
      .join('line')
      .attr('stroke', '#1e1e2a')
      .attr('stroke-width', d => Math.min(d.strength + 0.5, 3))
      .attr('stroke-opacity', 0.6);

    // Nodes
    const nodeGroup = g.append('g').selectAll('g')
      .data(simNodes)
      .join('g')
      .attr('cursor', 'pointer')
      .call(
        d3.drag<SVGGElement, GraphNode>()
          .on('start', function(event, d) {
            if (!event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x; d.fy = d.y;
          })
          .on('drag', function(event, d) { d.fx = event.x; d.fy = event.y; })
          .on('end', function(event, d) {
            if (!event.active) simulation.alphaTarget(0);
            d.fx = null; d.fy = null;
          }) as any
      )
      .on('click', (event, d) => {
        event.stopPropagation();
        setSelectedNode(prev => prev === d.id ? null : d.id);
        onNodeClick?.(d);
      })
      .on('mousemove', (event, d) => {
        const rect = svgRef.current!.getBoundingClientRect();
        setTooltip({ x: event.clientX - rect.left + 12, y: event.clientY - rect.top - 10, node: d });
      })
      .on('mouseleave', () => setTooltip(null));

    // Circles
    nodeGroup.append('circle')
      .attr('r', d => d.type === 'tag' ? 14 : Math.min(8 + (d.entryCount || 1) * 1.5, 18))
      .attr('fill', d => {
        if (d.type === 'tag') return TAG_COLORS[d.label] || '#6c5ce7';
        return '#1e1e2a';
      })
      .attr('stroke', d => {
        if (d.type === 'tag') return TAG_COLORS[d.label] || '#6c5ce7';
        return '#3a3a4a';
      })
      .attr('stroke-width', 1.5)
      .attr('fill-opacity', d => d.type === 'tag' ? 0.85 : 1);

    // Labels
    nodeGroup.append('text')
      .text(d => d.label.length > 14 ? d.label.slice(0, 14) + '…' : d.label)
      .attr('text-anchor', 'middle')
      .attr('dy', d => d.type === 'tag' ? '0.35em' : '-16px')
      .attr('fill', d => d.type === 'tag' ? '#fff' : '#8b8b9e')
      .attr('font-size', d => d.type === 'tag' ? '9px' : '8px')
      .attr('font-family', 'JetBrains Mono, monospace')
      .attr('pointer-events', 'none');

    simulation.on('tick', () => {
      link
        .attr('x1', d => (d.source as GraphNode).x!)
        .attr('y1', d => (d.source as GraphNode).y!)
        .attr('x2', d => (d.target as GraphNode).x!)
        .attr('y2', d => (d.target as GraphNode).y!);
      nodeGroup.attr('transform', d => `translate(${d.x},${d.y})`);
    });

    // Click background to deselect
    svg.on('click', () => setSelectedNode(null));

    return () => { simulation.stop(); };
  }, [nodes, links]);

  return (
    <div className="relative w-full" style={{ height: 500 }}>
      <svg
        ref={svgRef}
        width="100%"
        height="100%"
        className="bg-[#070710] rounded-lg border border-[#1e1e2a]"
      />

      {/* Legend */}
      <div className="absolute top-3 left-3 bg-[#0a0a14]/90 border border-[#1e1e2a] rounded p-2 text-[10px] space-y-1">
        <div className="text-[#555] uppercase tracking-wider mb-1 font-semibold">Topics</div>
        {Object.entries(TAG_COLORS).slice(0, 6).map(([tag, color]) => (
          <div key={tag} className="flex items-center gap-1.5">
            <span className="w-2 h-2 rounded-full flex-shrink-0" style={{ background: color }} />
            <span style={{ color }}>{tag}</span>
          </div>
        ))}
      </div>

      <div className="absolute top-3 right-3 bg-[#0a0a14]/90 border border-[#1e1e2a] rounded p-2 text-[10px] text-[#555]">
        <div>{nodes.filter(n => n.type === 'file').length} files · {nodes.filter(n => n.type === 'tag').length} topics</div>
        <div className="mt-0.5">Scroll to zoom · drag to pan</div>
      </div>

      {/* Tooltip */}
      {tooltip && (
        <div
          className="absolute pointer-events-none bg-[#111] border border-[#2a2a3a] rounded px-2.5 py-2 text-xs z-10 max-w-[200px]"
          style={{ left: tooltip.x, top: tooltip.y }}
        >
          <div className="font-semibold text-[#f0f0f0] mb-1">{tooltip.node.label}</div>
          {tooltip.node.type === 'file' && (
            <>
              <div className="text-[#555]">{tooltip.node.date}</div>
              <div className="text-[#555]">{tooltip.node.entryCount} section{tooltip.node.entryCount !== 1 ? 's' : ''}</div>
              {tooltip.node.tags && tooltip.node.tags.length > 0 && (
                <div className="text-[#777] mt-1">{tooltip.node.tags.join(', ')}</div>
              )}
            </>
          )}
          {tooltip.node.type === 'tag' && (
            <div className="text-[#555]">Topic cluster</div>
          )}
        </div>
      )}
    </div>
  );
}
