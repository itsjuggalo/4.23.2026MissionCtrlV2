'use client';
import { useLiveStream } from '@/hooks/useLiveStream';
import { LiveIndicator } from '@/components/ui/LiveIndicator';
import { useViewMode } from '@/lib/useViewMode';
import { useEffect, useState } from 'react';

const SUBTITLES: Record<string, string> = {
  'Command Center': 'Power Overwhelming',
  'Performance': 'Operation CWAL',
  'Regime': 'Black Sheep Wall',
  'Activity': 'The Gathering',
  'Dashboard': 'Something For Nothing',
  'TV Chart': 'War Aint What It Used To Be',
  'Scanner': 'Breathe Deep',
  'Wallets': 'Show Me The Money',
  'Trades': 'Whats Mine Is Mine',
  'Journal': 'Something For Nothing',
  'GoTrader': 'There Is No Cow Level',
  'PowerTrader': 'Medieval Man',
  'Risk': 'Staying Alive',
  'Office': 'Food For Thought',
  'Agents': 'Radio Free Zerg',
  'Memory': 'Ophelia',
  'Signals': 'Modify The Phase Variance',
  'Telegram': 'Noglues',
  'Approvals': 'Game Over Man',
  'Calendar': 'En Taro Adun',
  'Tasks': 'Need A Light?',
  'Projects': 'Spawn More Overlords',
  'Usage': 'Not Enough Minerals',
  'Congress': 'Nuclear Launch Detected',
  'LLM Portfolio': 'My Life For Aiur',
  'Skills': 'Spawn More Overlords',
  'Docs': 'You Must Construct Additional Pylons',
};

interface HeaderProps {
  title: string;
  onMenuClick?: () => void;
}

// Compact account pill — shown centered in the header (Alpaca account info).
function Pill({ label, value, color }: { label: string; value: string; color?: string }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', padding: '1px 10px', borderRadius: 4, background: '#101a26', border: '1px solid #1f2a36', flexShrink: 0 }}>
      <span style={{ fontSize: 8, color: '#8a99a8', textTransform: 'uppercase', letterSpacing: 0.5 }}>{label}</span>
      <span style={{ fontSize: 12, fontWeight: 600, color: color || '#e8edf2' }}>{value}</span>
    </div>
  );
}

export function Header({
 title, onMenuClick }: HeaderProps) {
  const live = useLiveStream(true);
  const [viewMode] = useViewMode();
  const isMobile = viewMode === 'mobile';
  const [time, setTime] = useState('');
  const [status, setStatus] = useState<any>(null);
  useEffect(() => {
    const update = () => {
      setTime(new Date().toLocaleTimeString("en-US", { hour12: true, timeZone: "America/New_York", timeZoneName: "short" }));
    };
    update();
    const id = setInterval(update, 1000);
    return () => clearInterval(id);
  }, []);

  // Alpaca account info — fetched here so it can live on the header line.
  useEffect(() => {
    const refresh = async () => {
      try {
        const s = await fetch('/api/status', { cache: 'no-store' }).then(r => r.json());
        setStatus(s);
      } catch {}
    };
    refresh();
    const i = setInterval(refresh, 30000);
    return () => clearInterval(i);
  }, []);

  const subtitle = SUBTITLES[title] || '';

  const fmt = (n?: number) => typeof n === 'number' ? `$${n.toFixed(2)}` : '—';
  const bobaEq = status?.accounts?.boba?.equity || 0;
  const jazzyEq = status?.accounts?.jazzy?.equity || 0;
  const totalEq = bobaEq + jazzyEq;
  const totalPnL = (bobaEq - 2000) + (jazzyEq - 2000);
  const pnlColor = totalPnL >= 0 ? '#5fff5f' : '#ff6b6b';
  const posList = [...(status?.accounts?.boba?.positions || []), ...(status?.accounts?.jazzy?.positions || [])];
  const winners = posList.filter((p: any) => (p.pnl || 0) > 0).length;
  const losers = posList.filter((p: any) => (p.pnl || 0) < 0).length;
  const posCount = (status?.accounts?.boba?.positions?.length || 0) + (status?.accounts?.jazzy?.positions?.length || 0);

  return (
    <div
      style={{
        height: 52,
        background: '#0d1117',
        borderBottom: '1px solid #1a3a4a',
        display: 'flex',
        alignItems: 'center',
        gap: 12,
        padding: '0 20px',
        flexShrink: 0,
      }}
    >
      {/* Left zone — page title + subtitle */}
      <div style={{ flex: 1, display: 'flex', alignItems: 'center', gap: 12, minWidth: 0 }}>
        {onMenuClick && (
          <button
            onClick={onMenuClick}
            aria-label="Open menu"
            style={{ background: 'transparent', border: 'none', color: '#e0e0e0', cursor: 'pointer', padding: 4, display: 'flex', alignItems: 'center' }}
          >
            <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
              <line x1="3" y1="6" x2="21" y2="6" />
              <line x1="3" y1="12" x2="21" y2="12" />
              <line x1="3" y1="18" x2="21" y2="18" />
            </svg>
          </button>
        )}
        <span
          style={{
            fontSize: 16,
            fontWeight: 600,
            fontFamily: "'Inter', -apple-system, sans-serif",
            color: '#e0e0e0',
            whiteSpace: 'nowrap',
          }}
        >
          {title}
        </span>
        {subtitle && (
          <span
            style={{
              fontSize: 12,
              fontFamily: "'JetBrains Mono', 'SF Mono', monospace",
              color: '#4fc3f7',
              fontStyle: 'italic',
              letterSpacing: '0.5px',
              whiteSpace: 'nowrap',
              overflow: 'hidden',
              textOverflow: 'ellipsis',
            }}
          >
            {subtitle}
          </span>
        )}
      </div>

      {/* Center zone — Alpaca account info. Mobile collapses to Total + P&L
          only; the remaining detail (Boba/Jazzy/Pos/W/L) is hidden so the
          header fits on a 390px iPhone without horizontal scroll. */}
      <div style={{ display: 'flex', alignItems: 'center', gap: isMobile ? 6 : 8, flexShrink: 0, fontFamily: 'ui-monospace,monospace', overflowX: 'auto' }}>
        <Pill label="Total" value={fmt(totalEq)} />
        <Pill label="P&L" value={`${totalPnL >= 0 ? '+' : ''}$${totalPnL.toFixed(2)}`} color={pnlColor} />
        {!isMobile && (
          <>
            <Pill label="Boba" value={fmt(bobaEq || undefined)} />
            <Pill label="Jazzy" value={fmt(jazzyEq || undefined)} />
            <Pill label="Pos" value={String(posCount)} />
            <Pill label="W/L" value={winners + '/' + losers} color="#8a99a8" />
          </>
        )}
      </div>

      {/* Right zone — live indicator + clock. Mobile drops the clock and
          shows just a compact LIVE dot. */}
      <div style={{ flex: isMobile ? 0 : 1, display: 'flex', alignItems: 'center', justifyContent: 'flex-end', gap: isMobile ? 4 : 10 }}>
        <span
          style={{
            display: 'inline-block',
            width: 8,
            height: 8,
            borderRadius: '50%',
            background: '#66bb6a',
            boxShadow: '0 0 6px #66bb6a',
            animation: 'pulse 2s infinite',
          }}
        />
        {!isMobile && (
          <>
            <span
              style={{
                fontSize: 12,
                fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
                color: '#66bb6a',
                fontWeight: 600,
                letterSpacing: '1px',
              }}
            >
              LIVE
            </span>
            <span
              style={{
                fontSize: 13,
                fontFamily: "'JetBrains Mono', 'SF Mono', 'Fira Code', monospace",
                color: '#455a64',
              }}
            >
              {time}
            </span>
          </>
        )}
      </div>
      <style>{`
        @keyframes pulse {
          0%, 100% { opacity: 1; box-shadow: 0 0 6px #66bb6a; }
          50% { opacity: 0.5; box-shadow: 0 0 12px #66bb6a; }
        }
      `}</style>
    </div>
  );
}
