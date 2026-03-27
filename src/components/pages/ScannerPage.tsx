'use client';

import { useState } from 'react';
import { Badge } from '../ui/Badge';
import { TrendArrow } from '../ui/TrendArrow';
import { SignalBar } from '../ui/SignalBar';
import { useMarketData } from '@/hooks/useMarketData';
import { useScanner } from '@/hooks/useScanner';
import type { Signal } from '@/lib/types';

type TabFilter = 'All signals' | 'Crypto' | 'Stocks';
type TFFilter = 'All' | '15m' | '1H' | '4H' | '1D';

function getStatusColor(status: Signal['status']) {
  return status === 'new' ? '#00d2a0' : status === 'reviewing' ? '#ffa502' : '#5c5c72';
}

function OfflineBanner({ message }: { message: string }) {
  return (
    <div
      style={{
        display: 'flex',
        alignItems: 'flex-start',
        gap: 12,
        padding: '16px 18px',
        background: 'rgba(255, 71, 87, 0.08)',
        border: '1px solid rgba(255, 71, 87, 0.35)',
        borderRadius: 8,
      }}
    >
      <span
        style={{
          width: 8,
          height: 8,
          borderRadius: '50%',
          background: '#ff4757',
          flexShrink: 0,
          marginTop: 4,
        }}
      />
      <div>
        <div
          style={{
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 12,
            fontWeight: 700,
            color: '#ff4757',
            letterSpacing: '0.5px',
            marginBottom: 4,
          }}
        >
          OFFLINE — API connection failed
        </div>
        <div
          style={{
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 11,
            color: 'rgba(255,71,87,0.7)',
            lineHeight: 1.5,
          }}
        >
          {message}
        </div>
      </div>
    </div>
  );
}

export function ScannerPage() {
  const [tab, setTab] = useState<TabFilter>('All signals');
  const [tf, setTf] = useState<TFFilter>('All');
  const [expanded, setExpanded] = useState<number | null>(null);

  const marketData = useMarketData();
  const scanner = useScanner(marketData);

  const sorted = [...scanner.signals].sort((a, b) => b.strength - a.strength);

  const filtered = sorted.filter((s) => {
    if (tab === 'Crypto' && s.asset !== 'Crypto') return false;
    if (tab === 'Stocks' && s.asset !== 'Stock') return false;
    if (tf !== 'All' && s.timeframe !== tf) return false;
    return true;
  });

  const tabs: TabFilter[] = ['All signals', 'Crypto', 'Stocks'];
  const tfs: TFFilter[] = ['All', '15m', '1H', '4H', '1D'];

  // Determine which errors are relevant to the active tab
  const relevantError =
    tab === 'Crypto' ? scanner.cryptoError :
    tab === 'Stocks' ? scanner.stocksError :
    (scanner.cryptoError && scanner.stocksError)
      ? `Crypto: ${scanner.cryptoError} / Stocks: ${scanner.stocksError}`
      : scanner.cryptoError
        ? `Crypto: ${scanner.cryptoError}`
        : scanner.stocksError
          ? `Stocks: ${scanner.stocksError}`
          : null;

  const hasSignals = filtered.length > 0;
  const isLoading = scanner.isLoading;

  // Status indicator for the toolbar
  function StatusIndicator() {
    if (isLoading) {
      return (
        <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
          <span style={{ display: 'inline-block', width: 8, height: 8, borderRadius: '50%', background: '#ffa502', animation: 'scanner-spin 1s linear infinite' }} />
          <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#ffa502' }}>LOADING</span>
        </div>
      );
    }
    if (relevantError && !hasSignals) {
      return (
        <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
          <span style={{ width: 8, height: 8, borderRadius: '50%', background: '#ff4757', display: 'inline-block' }} />
          <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#ff4757' }}>OFFLINE</span>
        </div>
      );
    }
    return (
      <div style={{ display: 'flex', alignItems: 'center', gap: 6 }}>
        <span style={{ width: 8, height: 8, borderRadius: '50%', background: '#00d2a0', boxShadow: '0 0 6px #00d2a0', display: 'inline-block', animation: 'scanner-pulse 2s infinite' }} />
        <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#00d2a0' }}>LIVE DATA</span>
      </div>
    );
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Filters row */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', gap: 12 }}>
        <div style={{ display: 'flex', gap: 4 }}>
          {tabs.map((t) => (
            <button
              key={t}
              onClick={() => setTab(t)}
              style={{
                padding: '6px 14px',
                fontSize: 13,
                fontFamily: "'Inter', sans-serif",
                border: tab === t ? '1px solid #6c5ce7' : '1px solid #1e1e2a',
                background: tab === t ? 'rgba(108,92,231,0.1)' : 'transparent',
                color: tab === t ? '#a29bfe' : '#8b8b9e',
                borderRadius: 6,
                cursor: 'pointer',
                transition: 'all 0.15s',
              }}
            >
              {t}
            </button>
          ))}
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 16 }}>
          <StatusIndicator />
          <select
            value={tf}
            onChange={(e) => setTf(e.target.value as TFFilter)}
            style={{
              padding: '6px 10px',
              fontSize: 12,
              fontFamily: "'JetBrains Mono', monospace",
              background: '#111118',
              border: '1px solid #1e1e2a',
              color: '#e8e8ed',
              borderRadius: 6,
              cursor: 'pointer',
            }}
          >
            {tfs.map((t) => (
              <option key={t} value={t}>{t}</option>
            ))}
          </select>
        </div>
      </div>

      {/* Loading state */}
      {isLoading && !hasSignals && (
        <div
          style={{
            display: 'flex',
            alignItems: 'center',
            gap: 12,
            padding: '24px 18px',
            background: '#111118',
            border: '1px solid #1e1e2a',
            borderRadius: 10,
            color: '#5c5c72',
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 12,
          }}
        >
          <span style={{ animation: 'scanner-spin 1s linear infinite', display: 'inline-block', fontSize: 16 }}>◌</span>
          Connecting to market data feeds...
        </div>
      )}

      {/* Error state — shown when the tab has no signals due to API failure */}
      {!isLoading && relevantError && !hasSignals && (
        <OfflineBanner message={relevantError} />
      )}

      {/* Partial error notice above a table that still has some data */}
      {!isLoading && relevantError && hasSignals && (
        <OfflineBanner message={relevantError} />
      )}

      {/* Signal table */}
      {hasSignals && (
        <div
          style={{
            background: '#111118',
            border: '1px solid #1e1e2a',
            borderRadius: 10,
            overflow: 'hidden',
          }}
        >
          {/* Header row */}
          <div
            style={{
              display: 'grid',
              gridTemplateColumns: '130px 80px 60px 120px 60px 120px 140px 80px 90px',
              padding: '10px 16px',
              borderBottom: '1px solid #1e1e2a',
              gap: 8,
            }}
          >
            {['SYMBOL', 'ASSET', 'TF', 'PRICE', 'TREND', 'STRENGTH', 'SOURCE', 'TIME', 'STATUS'].map((h) => (
              <span
                key={h}
                style={{ fontSize: 10, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', textTransform: 'uppercase', letterSpacing: '0.8px' }}
              >
                {h}
              </span>
            ))}
          </div>

          {filtered.map((signal) => {
            const isExpanded = expanded === signal.id;
            return (
              <div key={signal.id}>
                <div
                  onClick={() => setExpanded(isExpanded ? null : signal.id)}
                  style={{
                    display: 'grid',
                    gridTemplateColumns: '130px 80px 60px 120px 60px 120px 140px 80px 90px',
                    padding: '12px 16px',
                    borderBottom: '1px solid #1e1e2a',
                    gap: 8,
                    cursor: 'pointer',
                    background: isExpanded ? 'rgba(108,92,231,0.04)' : 'transparent',
                    transition: 'background 0.15s',
                    alignItems: 'center',
                  }}
                  onMouseEnter={(e) => {
                    if (!isExpanded) (e.currentTarget as HTMLElement).style.background = '#16161f';
                  }}
                  onMouseLeave={(e) => {
                    (e.currentTarget as HTMLElement).style.background = isExpanded ? 'rgba(108,92,231,0.04)' : 'transparent';
                  }}
                >
                  <span style={{ fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, fontSize: 13, color: '#e8e8ed' }}>
                    {signal.symbol}
                  </span>
                  <span>
                    <Badge color={signal.asset === 'Crypto' ? '#00cec9' : '#3498ff'}>{signal.asset}</Badge>
                  </span>
                  <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 12, color: '#8b8b9e' }}>
                    {signal.timeframe}
                  </span>
                  <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 13, color: '#e8e8ed' }}>
                    ${signal.price.toLocaleString()}
                  </span>
                  <TrendArrow trend={signal.trend} />
                  <SignalBar strength={signal.strength} />
                  <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#8b8b9e' }}>
                    {signal.source}
                  </span>
                  <span style={{ fontSize: 11, color: '#5c5c72' }}>{signal.time}</span>
                  <Badge color={getStatusColor(signal.status)}>{signal.status}</Badge>
                </div>

                {isExpanded && (
                  <div
                    style={{
                      padding: '14px 16px 16px 16px',
                      borderBottom: '1px solid #1e1e2a',
                      background: 'rgba(108,92,231,0.03)',
                    }}
                  >
                    <div
                      style={{
                        fontSize: 11,
                        fontFamily: "'JetBrains Mono', monospace",
                        color: '#5c5c72',
                        textTransform: 'uppercase',
                        letterSpacing: '0.8px',
                        marginBottom: 6,
                      }}
                    >
                      Signal Reasoning
                    </div>
                    <p style={{ fontSize: 13, fontFamily: "'Inter', sans-serif", color: '#8b8b9e', lineHeight: 1.6, marginBottom: 14 }}>
                      {signal.reasoning}
                    </p>
                    <div style={{ display: 'flex', gap: 10 }}>
                      <button style={{ padding: '6px 16px', fontSize: 12, fontFamily: "'JetBrains Mono', monospace", background: 'transparent', border: '1px solid #00d2a0', color: '#00d2a0', borderRadius: 6, cursor: 'pointer' }}>
                        Send to tasks
                      </button>
                      <button style={{ padding: '6px 16px', fontSize: 12, fontFamily: "'JetBrains Mono', monospace", background: 'transparent', border: '1px solid #2a2a3a', color: '#8b8b9e', borderRadius: 6, cursor: 'pointer' }}>
                        Dismiss
                      </button>
                    </div>
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}

      {/* Active scanners */}
      <div style={{ border: '1px dashed #1e1e2a', borderRadius: 10, padding: 16 }}>
        <div style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', marginBottom: 12, textTransform: 'uppercase', letterSpacing: '0.8px' }}>
          Active Scanners
        </div>
        <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8, marginBottom: 12 }}>
          {['RSI', 'MACD', 'EMA/SMA', 'Bollinger', 'Volume', 'Breakout', 'Momentum'].map((s) => (
            <Badge key={s} color="#6c5ce7">{s}</Badge>
          ))}
        </div>
        <div style={{ fontSize: 11, fontFamily: "'Inter', sans-serif", color: '#5c5c72' }}>
          Modular architecture — add TradingView webhooks, external APIs, custom quant scanners
        </div>
      </div>

      <style>{`
        @keyframes scanner-pulse {
          0%, 100% { opacity: 1; box-shadow: 0 0 6px #00d2a0; }
          50% { opacity: 0.6; box-shadow: 0 0 12px #00d2a0; }
        }
        @keyframes scanner-spin {
          from { transform: rotate(0deg); }
          to { transform: rotate(360deg); }
        }
      `}</style>
    </div>
  );
}
