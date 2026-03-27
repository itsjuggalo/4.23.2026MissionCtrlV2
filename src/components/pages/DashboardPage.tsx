'use client';

import { MetricCard } from '../ui/MetricCard';
import { Card } from '../ui/Card';
import { Badge } from '../ui/Badge';
import { SectionHeader } from '../ui/SectionHeader';
import { ProgressBar } from '../ui/ProgressBar';
import { BTCBiasWidget } from '../ui/BTCBiasWidget';
import { activeTrades as mockTrades, activityFeed, riskData } from '@/lib/mock-data';
import { useMarketData } from '@/hooks/useMarketData';

function OfflineBanner({ message }: { message: string }) {
  return (
    <div
      style={{
        display: 'flex',
        alignItems: 'flex-start',
        gap: 12,
        padding: '12px 14px',
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
          marginTop: 3,
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
            marginBottom: 3,
          }}
        >
          OFFLINE — API connection failed
        </div>
        <div
          style={{
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 11,
            color: 'rgba(255,71,87,0.7)',
          }}
        >
          {message}
        </div>
      </div>
    </div>
  );
}

function LiveBadge({ isLoading }: { isLoading: boolean }) {
  if (isLoading) {
    return (
      <span
        style={{
          fontFamily: "'JetBrains Mono', monospace",
          fontSize: 10,
          color: '#ffa502',
          display: 'flex',
          alignItems: 'center',
          gap: 4,
        }}
      >
        <span style={{ display: 'inline-block', width: 6, height: 6, borderRadius: '50%', background: '#ffa502', animation: 'dash-spin 1s linear infinite' }} />
        LOADING
      </span>
    );
  }
  return (
    <span
      style={{
        fontFamily: "'JetBrains Mono', monospace",
        fontSize: 10,
        color: '#00d2a0',
        display: 'flex',
        alignItems: 'center',
        gap: 4,
      }}
    >
      <span style={{ display: 'inline-block', width: 6, height: 6, borderRadius: '50%', background: '#00d2a0', boxShadow: '0 0 4px #00d2a0' }} />
      LIVE
    </span>
  );
}

export function DashboardPage() {
  const marketData = useMarketData();

  // Derive errors that affect the active trades section
  const tradesError = marketData.cryptoError && marketData.stocksError
    ? `Crypto: ${marketData.cryptoError} / Stocks: ${marketData.stocksError}`
    : marketData.cryptoError
      ? `Crypto: ${marketData.cryptoError}`
      : marketData.stocksError
        ? `Stocks: ${marketData.stocksError}`
        : null;

  // Build live active trades; only show a trade if its price is available
  const liveTrades = mockTrades
    .map((trade) => {
      const liveAsset = marketData.prices[trade.symbol];
      if (!liveAsset) return null;
      const pnlRaw = liveAsset?.price ? ((liveAsset.price - trade.entry) / trade.entry) * 100 : 0;
      const pnlSign = pnlRaw >= 0 ? '+' : '';
      return {
        ...trade,
        current: liveAsset.price,
        pnl: `${pnlSign}${pnlRaw.toFixed(2)}%`,
      };
    })
    .filter(Boolean) as typeof mockTrades;

  // Determine if we have any live prices at all for trades
  const hasAnyPrices = liveTrades.length > 0;
  const isLoading = marketData.isLoading;

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 20 }}>
      {/* Status bar */}
      <div
        style={{
          display: 'flex',
          alignItems: 'center',
          gap: 10,
          padding: '10px 16px',
          background: 'rgba(0, 210, 160, 0.05)',
          border: '1px solid rgba(0, 210, 160, 0.2)',
          borderRadius: 8,
        }}
      >
        <span
          style={{
            width: 8,
            height: 8,
            borderRadius: '50%',
            background: '#00d2a0',
            boxShadow: '0 0 6px #00d2a0',
            display: 'inline-block',
            animation: 'pulse 2s infinite',
          }}
        />
        <span
          style={{
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 12,
            color: '#00d2a0',
            fontWeight: 600,
            letterSpacing: '0.5px',
          }}
        >
          ALL SYSTEMS OPERATIONAL
        </span>
        <span
          style={{
            fontFamily: "'JetBrains Mono', monospace",
            fontSize: 12,
            color: '#5c5c72',
            marginLeft: 8,
          }}
        >
          Latency: 12ms
        </span>
      </div>

      {/* Metric cards row */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
        <MetricCard label="Active Agents" value="3/5" subtitle="All agents healthy" color="#00d2a0" />
        <MetricCard label="Pending Approvals" value="2" subtitle="2 high priority" color="#ffa502" />
        <MetricCard label="New Signals" value="4" subtitle="Last scan: 2m ago" color="#6c5ce7" />
        <MetricCard label="Portfolio Value" value="$282k" subtitle="+$4.2k today" color="#00d2a0" />
      </div>

      {/* 2-column grid */}
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 16 }}>
        {/* Active trades */}
        <Card>
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 16 }}>
            <SectionHeader title="Active Trades" />
            {!isLoading && !tradesError && <LiveBadge isLoading={false} />}
            {isLoading && <LiveBadge isLoading={true} />}
          </div>

          {isLoading && !hasAnyPrices && (
            <div
              style={{
                display: 'flex',
                alignItems: 'center',
                gap: 10,
                padding: '20px 0',
                color: '#5c5c72',
                fontFamily: "'JetBrains Mono', monospace",
                fontSize: 12,
              }}
            >
              <span style={{ animation: 'dash-spin 1s linear infinite', display: 'inline-block' }}>◌</span>
              Fetching live prices...
            </div>
          )}

          {!isLoading && tradesError && !hasAnyPrices && (
            <OfflineBanner message={tradesError} />
          )}

          {!isLoading && tradesError && hasAnyPrices && (
            <div style={{ marginBottom: 12 }}>
              <OfflineBanner message={tradesError} />
            </div>
          )}

          {hasAnyPrices && (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
              {liveTrades.map((trade) => (
                <div
                  key={trade.symbol}
                  style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'space-between',
                    padding: '10px 12px',
                    background: '#0f0f17',
                    borderRadius: 8,
                    border: '1px solid #1e1e2a',
                  }}
                >
                  <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
                    <span
                      style={{
                        fontFamily: "'JetBrains Mono', monospace",
                        fontWeight: 700,
                        fontSize: 13,
                        color: '#e8e8ed',
                      }}
                    >
                      {trade.symbol}
                    </span>
                    <Badge color={trade.side === 'LONG' ? '#00d2a0' : '#ff4757'}>
                      {trade.side}
                    </Badge>
                  </div>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 16 }}>
                    <span
                      style={{
                        fontFamily: "'JetBrains Mono', monospace",
                        fontSize: 13,
                        color: '#e8e8ed',
                      }}
                    >
                      ${trade.current.toLocaleString()}
                    </span>
                    <span
                      style={{
                        fontFamily: "'JetBrains Mono', monospace",
                        fontSize: 13,
                        color: trade.pnl.startsWith('+') ? '#00d2a0' : '#ff4757',
                        fontWeight: 600,
                      }}
                    >
                      {trade.pnl}
                    </span>
                  </div>
                </div>
              ))}
            </div>
          )}
        </Card>

        {/* Recent activity */}
        <Card>
          <SectionHeader title="Recent Activity" />
          <div style={{ marginTop: 16, display: 'flex', flexDirection: 'column', gap: 8 }}>
            {activityFeed.slice(0, 5).map((entry, i) => (
              <div
                key={i}
                style={{
                  display: 'flex',
                  gap: 10,
                  padding: '8px 0',
                  borderBottom: i < 4 ? '1px solid #1e1e2a' : 'none',
                }}
              >
                <span
                  style={{
                    fontFamily: "'JetBrains Mono', monospace",
                    fontSize: 11,
                    color: '#5c5c72',
                    minWidth: 60,
                  }}
                >
                  {entry.time}
                </span>
                <div>
                  <div style={{ fontSize: 13, color: '#e8e8ed', fontWeight: 500 }}>
                    {entry.action}
                  </div>
                  <div
                    style={{
                      fontSize: 11,
                      color: '#8b8b9e',
                      marginTop: 2,
                      overflow: 'hidden',
                      textOverflow: 'ellipsis',
                      whiteSpace: 'nowrap',
                      maxWidth: 240,
                    }}
                  >
                    {entry.detail}
                  </div>
                </div>
              </div>
            ))}
          </div>
        </Card>
      </div>

      {/* Bottom row */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: 16 }}>
        <Card>
          <div style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', textTransform: 'uppercase', letterSpacing: '1px', marginBottom: 12 }}>
            Risk Exposure
          </div>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: 8 }}>
            <span style={{ fontSize: 26, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: '#ffa502' }}>
              {riskData.exposure}%
            </span>
            <span style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72' }}>
              / {riskData.limit}% limit
            </span>
          </div>
          <ProgressBar value={riskData.exposure} max={riskData.limit} color="#ffa502" height={6} />
        </Card>

        <Card>
          <div style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', textTransform: 'uppercase', letterSpacing: '1px', marginBottom: 8 }}>
            Sharpe Ratio
          </div>
          <div style={{ fontSize: 26, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: '#00d2a0', marginBottom: 4 }}>
            {riskData.sharpe}
          </div>
          <div style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#8b8b9e' }}>
            30-day rolling
          </div>
        </Card>

        <Card>
          <div style={{ fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#5c5c72', textTransform: 'uppercase', letterSpacing: '1px', marginBottom: 8 }}>
            {"Today's Drawdown"}
          </div>
          <div style={{ fontSize: 26, fontFamily: "'JetBrains Mono', monospace", fontWeight: 700, color: '#ff4757', marginBottom: 4 }}>
            {riskData.drawdown}%
          </div>
          <div style={{ fontSize: 12, fontFamily: "'JetBrains Mono', monospace", color: '#8b8b9e' }}>
            Max allowed: -5%
          </div>
        </Card>
      </div>

      {/* BTC Directional Bias */}
      <BTCBiasWidget />

      <style>{`
        @keyframes pulse {
          0%, 100% { opacity: 1; box-shadow: 0 0 6px #00d2a0; }
          50% { opacity: 0.5; box-shadow: 0 0 12px #00d2a0; }
        }
        @keyframes dash-spin {
          from { transform: rotate(0deg); }
          to { transform: rotate(360deg); }
        }
      `}</style>
    </div>
  );
}
