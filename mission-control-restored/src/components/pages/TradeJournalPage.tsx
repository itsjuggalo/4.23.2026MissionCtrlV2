'use client';
import React, { useEffect, useState } from 'react';

interface JournalEntry {
  id: string;
  source: 'boba-options' | 'auto-trader-btc' | 'manual';
  timestamp: string;
  symbol: string;
  full_symbol?: string;
  side: string;
  qty: number;
  strike?: number;
  expiry?: string;
  confidence?: string;
  profit_target_pct?: number;
  stop_loss_pct?: number;
  reasoning: string;
  cycle_summary?: string;
  passed_on?: { ticker: string; reason: string }[];
  executed: boolean;
  order_id?: string;
  error?: string;
}

interface Cycle {
  cycle_time: string;
  cycle_summary: string;
  picks_proposed: number;
  picks_executed_count: number;
  passed_on: { ticker: string; reason: string }[];
}

interface Stats {
  total_decisions: number;
  boba_options: number;
  boba_executed: number;
  boba_high_conviction: number;
  auto_trader_btc: number;
  confidence_breakdown: Record<string, number>;
}

const confColor = (c?: string) => ({
  high: '#66bb6a', medium: '#ffaa33', low: '#ef5350', unspecified: '#607d8b',
} as any)[c || 'unspecified'] || '#607d8b';

const sideColor = (s: string) => {
  if (s.includes('put')) return '#ef5350';
  if (s.includes('call')) return '#66bb6a';
  if (s.includes('long') || s.includes('buy')) return '#66bb6a';
  if (s.includes('short') || s.includes('sell')) return '#ef5350';
  return '#607d8b';
};

const fmtTime = (iso: string) => {
  const d = new Date(iso);
  return d.toLocaleString('en-US', {
    month: 'short', day: 'numeric',
    hour: 'numeric', minute: '2-digit', hour12: false,
  });
};

export default function TradeJournalPage() {
  const [entries, setEntries] = useState<JournalEntry[]>([]);
  const [cycles, setCycles] = useState<Cycle[]>([]);
  const [stats, setStats] = useState<Stats | null>(null);
  const [sourceFilter, setSourceFilter] = useState<'all' | 'boba-options' | 'auto-trader-btc'>('all');
  const [expandedId, setExpandedId] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  const load = async () => {
    setLoading(true);
    try {
      const q = sourceFilter === 'all' ? '' : `?source=${sourceFilter}`;
      const r = await fetch(`/api/boba-journal${q}`);
      const j = await r.json();
      setEntries(j.entries || []);
      setCycles(j.recentCycles || []);
      setStats(j.stats || null);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => { load(); }, [sourceFilter]);

  return (
    <div style={{ padding: '20px 24px', maxWidth: 1400, margin: '0 auto', fontFamily: 'var(--font-mc-mono, monospace)' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: 20 }}>
        <div>
          <div style={{ fontSize: 24, fontWeight: 800, color: '#e0e0e0', letterSpacing: '1.5px' }}>TRADE JOURNAL</div>
          <div style={{ fontSize: 11, color: '#607d8b', marginTop: 4, letterSpacing: '1px' }}>
            BOBA'S DECISION LOG · Every trade with full reasoning from the decision cycle
          </div>
        </div>
        <button onClick={load} style={{
          padding: '8px 16px', background: '#05080c', color: '#4fc3f7',
          border: '1px solid #1a3a4a', borderRadius: 4, cursor: 'pointer',
          fontFamily: 'inherit', fontSize: 11, fontWeight: 700, letterSpacing: '1px',
        }}>↻ REFRESH</button>
      </div>

      {/* Stats row */}
      {stats && (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12, marginBottom: 20 }}>
          <StatCard label="TOTAL DECISIONS" value={String(stats.total_decisions)} color="#4fc3f7"/>
          <StatCard label="BOBA OPTIONS" value={`${stats.boba_executed} / ${stats.boba_options}`} sub="executed / proposed" color="#ce93d8"/>
          <StatCard label="HIGH CONVICTION" value={String(stats.boba_high_conviction)} color="#66bb6a"/>
          <StatCard label="BTC AUTO-TRADES" value={String(stats.auto_trader_btc)} color="#ffaa33"/>
        </div>
      )}

      {/* Confidence breakdown */}
      {stats && Object.keys(stats.confidence_breakdown).length > 0 && (
        <div style={{ background: '#0a1420', border: '1px solid #1a3a4a', borderRadius: 6, padding: '12px 18px', marginBottom: 20 }}>
          <div style={{ fontSize: 11, color: '#607d8b', letterSpacing: '1px', marginBottom: 8 }}>CONVICTION DISTRIBUTION</div>
          <div style={{ display: 'flex', gap: 16, flexWrap: 'wrap' }}>
            {Object.entries(stats.confidence_breakdown).map(([conf, n]) => (
              <div key={conf} style={{ display: 'flex', gap: 8, alignItems: 'center' }}>
                <div style={{ width: 10, height: 10, borderRadius: '50%', background: confColor(conf) }}/>
                <span style={{ fontSize: 13, color: '#e0e0e0', textTransform: 'uppercase' }}>{conf}</span>
                <span style={{ fontSize: 13, color: '#607d8b' }}>{n}</span>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* Source filter tabs */}
      <div style={{ display: 'flex', gap: 4, marginBottom: 14 }}>
        {(['all', 'boba-options', 'auto-trader-btc'] as const).map(v => (
          <button key={v} onClick={() => setSourceFilter(v)} style={{
            padding: '6px 14px', fontSize: 11, fontWeight: 700, letterSpacing: '1px',
            background: sourceFilter === v ? '#1a3a4a' : '#05080c',
            color: sourceFilter === v ? '#66ccff' : '#607d8b',
            border: `1px solid ${sourceFilter === v ? '#4fc3f7' : '#1a2332'}`,
            borderRadius: 3, cursor: 'pointer', fontFamily: 'inherit',
          }}>{v.replace('-', ' ').toUpperCase()}</button>
        ))}
      </div>

      {/* Entries */}
      {loading && <div style={{ color: '#607d8b', textAlign: 'center', padding: 40 }}>Loading...</div>}
      {!loading && entries.length === 0 && (
        <div style={{ color: '#607d8b', textAlign: 'center', padding: 40, border: '1px dashed #1a3a4a', borderRadius: 6 }}>
          No entries. Check ~/.openclaw/workspace/skill_outputs/boba_decisions_validated.json exists.
        </div>
      )}
      <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
        {entries.map(e => (
          <EntryCard
            key={e.id}
            e={e}
            expanded={expandedId === e.id}
            onToggle={() => setExpandedId(expandedId === e.id ? null : e.id)}
          />
        ))}
      </div>

      {/* Recent cycles summary */}
      {cycles.length > 0 && (
        <div style={{ marginTop: 30 }}>
          <div style={{ fontSize: 13, color: '#607d8b', letterSpacing: '1.5px', marginBottom: 12 }}>
            RECENT DECISION CYCLES · last 20
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
            {cycles.map((c, i) => (
              <div key={i} style={{ background: '#0a1420', border: '1px solid #1a2332', borderRadius: 6, padding: '12px 16px' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 6 }}>
                  <span style={{ fontSize: 11, color: '#607d8b' }}>{fmtTime(c.cycle_time)}</span>
                  <span style={{ fontSize: 11, color: '#ce93d8' }}>
                    {c.picks_executed_count}/{c.picks_proposed} executed · {c.passed_on.length} passed
                  </span>
                </div>
                <div style={{ fontSize: 13, color: '#e0e0e0', lineHeight: 1.5 }}>{c.cycle_summary}</div>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

const StatCard: React.FC<{ label: string; value: string; sub?: string; color: string }> = ({ label, value, sub, color }) => (
  <div style={{ background: '#0a1420', border: '1px solid #1a3a4a', borderLeft: `3px solid ${color}`, borderRadius: 6, padding: '14px 18px' }}>
    <div style={{ fontSize: 10, color: '#607d8b', letterSpacing: '1.5px' }}>{label}</div>
    <div style={{ fontSize: 24, fontWeight: 800, color, marginTop: 4, fontFamily: 'inherit' }}>{value}</div>
    {sub && <div style={{ fontSize: 9, color: '#607d8b', marginTop: 2 }}>{sub}</div>}
  </div>
);

const EntryCard: React.FC<{ e: JournalEntry; expanded: boolean; onToggle: () => void }> = ({ e, expanded, onToggle }) => {
  // Parse reasoning into structured bullets if it has • separators
  const reasonParts = e.reasoning.split(/[•·]/).map(s => s.trim()).filter(Boolean);
  const isStructured = reasonParts.length > 1;

  const sourceColor = e.source === 'boba-options' ? '#ce93d8' : e.source === 'auto-trader-btc' ? '#ffaa33' : '#607d8b';
  const sourceLabel = e.source === 'boba-options' ? 'BOBA' : e.source === 'auto-trader-btc' ? 'AUTO-BTC' : 'MANUAL';

  return (
    <div style={{
      background: '#0a1420',
      border: '1px solid #1a3a4a',
      borderLeft: `3px solid ${e.executed ? confColor(e.confidence) : '#ef5350'}`,
      borderRadius: 6,
      padding: '14px 18px',
      cursor: 'pointer',
    }} onClick={onToggle}>
      <div style={{ display: 'grid', gridTemplateColumns: '110px 70px 80px 70px 1fr auto', gap: 12, alignItems: 'center' }}>
        <div style={{ fontSize: 11, color: '#607d8b' }}>{fmtTime(e.timestamp)}</div>
        <div style={{ fontSize: 9, color: sourceColor, fontWeight: 700, letterSpacing: '0.5px', padding: '2px 6px', background: '#05080c', border: `1px solid ${sourceColor}44`, borderRadius: 2, textAlign: 'center' }}>{sourceLabel}</div>
        <div style={{ fontSize: 16, fontWeight: 800, color: '#4fc3f7' }}>{e.symbol}</div>
        <div style={{ fontSize: 11, fontWeight: 700, color: sideColor(e.side), letterSpacing: '0.5px', textTransform: 'uppercase' }}>
          {e.side}
          {e.strike && <span style={{ color: '#607d8b' }}> ${e.strike}</span>}
        </div>
        <div style={{ fontSize: 12, color: '#aaa', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
          {isStructured ? reasonParts[0] : e.reasoning.slice(0, 120)}
        </div>
        <div style={{ display: 'flex', gap: 8, alignItems: 'center' }}>
          {e.confidence && (
            <span style={{ fontSize: 10, color: confColor(e.confidence), textTransform: 'uppercase', fontWeight: 700, letterSpacing: '0.5px' }}>
              {e.confidence}
            </span>
          )}
          {!e.executed && <span style={{ fontSize: 10, color: '#ef5350', fontWeight: 700 }}>FAILED</span>}
        </div>
      </div>

      {expanded && (
        <div style={{ marginTop: 14, paddingTop: 14, borderTop: '1px solid #1a2332' }} onClick={ev => ev.stopPropagation()}>
          {/* Full option symbol and contract details */}
          {(e.full_symbol || e.expiry || e.qty > 0) && (
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12, fontSize: 12, color: '#aaa', marginBottom: 14 }}>
              {e.full_symbol && <div><span style={{ color: '#607d8b' }}>SYMBOL</span>: {e.full_symbol}</div>}
              {e.expiry && <div><span style={{ color: '#607d8b' }}>EXPIRY</span>: {e.expiry}</div>}
              {e.qty > 0 && <div><span style={{ color: '#607d8b' }}>QTY</span>: {e.qty}</div>}
              {e.profit_target_pct != null && (
                <div><span style={{ color: '#607d8b' }}>TP/SL</span>: +{e.profit_target_pct}% / -{e.stop_loss_pct}%</div>
              )}
            </div>
          )}

          {/* Reasoning — structured if bullets detected */}
          <div style={{ fontSize: 11, color: '#607d8b', letterSpacing: '1px', marginBottom: 8 }}>REASONING</div>
          {isStructured ? (
            <ul style={{ margin: 0, padding: '0 0 0 20px', color: '#e0e0e0', fontSize: 13, lineHeight: 1.6 }}>
              {reasonParts.map((p, i) => <li key={i} style={{ marginBottom: 4 }}>{p}</li>)}
            </ul>
          ) : (
            <div style={{ color: '#e0e0e0', fontSize: 13, lineHeight: 1.6, whiteSpace: 'pre-wrap' }}>{e.reasoning}</div>
          )}

          {/* Cycle context */}
          {e.cycle_summary && (
            <div style={{ marginTop: 14 }}>
              <div style={{ fontSize: 11, color: '#607d8b', letterSpacing: '1px', marginBottom: 6 }}>CYCLE CONTEXT</div>
              <div style={{ color: '#aaa', fontSize: 12, fontStyle: 'italic', lineHeight: 1.5 }}>{e.cycle_summary}</div>
            </div>
          )}

          {/* Passed-on picks */}
          {e.passed_on && e.passed_on.length > 0 && (
            <div style={{ marginTop: 14 }}>
              <div style={{ fontSize: 11, color: '#607d8b', letterSpacing: '1px', marginBottom: 6 }}>PASSED ON THIS CYCLE</div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: 4 }}>
                {e.passed_on.map((p, i) => (
                  <div key={i} style={{ fontSize: 12, color: '#aaa' }}>
                    <span style={{ color: '#607d8b', fontWeight: 700 }}>{p.ticker}</span>: {p.reason}
                  </div>
                ))}
              </div>
            </div>
          )}

          {e.error && (
            <div style={{ marginTop: 12, padding: '8px 12px', background: '#ef535022', border: '1px solid #ef5350', borderRadius: 4, fontSize: 12, color: '#ef5350' }}>
              ⚠ {e.error}
            </div>
          )}

          {e.order_id && (
            <div style={{ marginTop: 10, fontSize: 10, color: '#607d8b', fontFamily: 'monospace' }}>
              order_id: {e.order_id}
            </div>
          )}
        </div>
      )}
    </div>
  );
};
