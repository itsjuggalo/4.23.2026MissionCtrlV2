'use client';
import { useState, useEffect, useCallback } from 'react';

interface TraderStatus {
  status?: string;
  mode?: string;
  coins?: string[];
  buying_power?: number;
  account_value?: number;
  total_pnl?: number;
  open_positions?: number;
  last_update?: string;
  dca_levels?: Record<string, number>;
  holdings?: Record<string, { qty: number; avg_cost: number; current_price: number; pnl: number }>;
}

interface Trade {
  ts?: number;
  timestamp?: string;
  side?: string;
  symbol?: string;
  coin?: string;
  qty?: number;
  price?: number;
  cost?: number;
  pnl?: number;
  pnl_pct?: number;
  order_id?: string;
  dca_level?: number;
  type?: string;
}

interface PnlData {
  total_realized?: number;
  total_unrealized?: number;
  by_coin?: Record<string, { realized: number; unrealized: number; trades: number }>;
}

interface PowerTraderData {
  success: boolean;
  status: TraderStatus;
  trades: Trade[];
  pnl: PnlData;
  running: boolean;
  hub_data_path: string;
}

const COINS = ['BTC', 'ETH', 'XRP', 'BNB', 'DOGE'];

export function PowerTraderPage() {
  const [data, setData]       = useState<PowerTraderData | null>(null);
  const [loading, setLoading] = useState(true);
  const [tab, setTab]         = useState<'overview' | 'trades' | 'holdings' | 'settings'>('overview');

  const fetchData = useCallback(async () => {
    try {
      const res  = await fetch('/api/powertrader', { cache: 'no-store' });
      const json = await res.json();
      setData(json);
      setLoading(false);
    } catch {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    fetchData();
    const t = setInterval(fetchData, 5000);
    return () => clearInterval(t);
  }, [fetchData]);

  const fmt = {
    currency: (v: number | null | undefined) => v != null ? `$${v.toFixed(2)}` : '—',
    pct:      (v: number | null | undefined) => v != null ? `${v >= 0 ? '+' : ''}${v.toFixed(2)}%` : '—',
    qty:      (v: number | null | undefined) => v != null ? v.toFixed(6) : '—',
    time:     (v: number | string | null | undefined) => {
      if (!v) return '—';
      const d = typeof v === 'number' ? new Date(v * 1000) : new Date(v);
      return d.toLocaleString('en-US', { month: 'short', day: 'numeric', hour: '2-digit', minute: '2-digit' });
    },
  };

  const pnlColor = (v: number | null | undefined) => (v ?? 0) >= 0 ? '#66bb6a' : '#ef5350';

  const status  = data?.status || {};
  const trades  = data?.trades || [];
  const pnl     = data?.pnl || {};
  const running = data?.running || false;

  if (loading) return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '60vh', color: '#607d8b', fontFamily: 'monospace' }}>
      Loading PowerTrader...
    </div>
  );

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 16 }}>

      {/* Header */}
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <div>
          <h1 style={{ color: '#e0e0e0', fontFamily: 'Inter, sans-serif', fontWeight: 700, fontSize: 24, margin: 0 }}>
            PowerTrader AI
          </h1>
          <p style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 12, margin: '4px 0 0' }}>
            Robinhood live trading engine by garagesteve1155
          </p>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
          {/* Status indicator */}
          <div style={{
            display: 'flex', alignItems: 'center', gap: 8,
            padding: '8px 16px', borderRadius: 8,
            background: running ? '#66bb6a22' : '#ef535022',
            border: `1px solid ${running ? '#66bb6a44' : '#ef535044'}`,
          }}>
            <div style={{
              width: 8, height: 8, borderRadius: '50%',
              background: running ? '#66bb6a' : '#ef5350',
              boxShadow: `0 0 6px ${running ? '#66bb6a' : '#ef5350'}`,
            }} />
            <span style={{ color: running ? '#66bb6a' : '#ef5350', fontFamily: 'monospace', fontSize: 12, fontWeight: 600 }}>
              {running ? 'RUNNING' : 'STOPPED'}
            </span>
          </div>
          {/* Mode badge */}
          <div style={{
            padding: '8px 16px', borderRadius: 8,
            background: '#4fc3f722', border: '1px solid #4fc3f744',
            color: '#a78bfa', fontFamily: 'monospace', fontSize: 12, fontWeight: 600,
          }}>
            {status.mode || 'PAPER'}
          </div>
        </div>
      </div>

      {/* Stats cards */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 12 }}>
        {[
          { label: 'Account Value',    value: fmt.currency(status.account_value),  color: '#e0e0e0' },
          { label: 'Buying Power',     value: fmt.currency(status.buying_power),   color: '#4fc3f7' },
          { label: 'Total P&L',        value: fmt.currency(status.total_pnl),      color: pnlColor(status.total_pnl) },
          { label: 'Open Positions',   value: String(status.open_positions ?? 0),  color: '#ff9800' },
        ].map(card => (
          <div key={card.label} style={{
            background: '#111118', border: '1px solid #1a3a4a',
            borderRadius: 10, padding: '14px 16px',
          }}>
            <div style={{ fontSize: 11, color: '#607d8b', fontFamily: 'monospace', textTransform: 'uppercase', letterSpacing: '0.5px' }}>
              {card.label}
            </div>
            <div style={{ fontSize: 22, fontWeight: 700, color: card.color, marginTop: 6, fontFamily: 'monospace' }}>
              {card.value}
            </div>
          </div>
        ))}
      </div>

      {/* Coin signal tiles */}
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)', gap: 10 }}>
        {(status.coins || COINS).map(coin => {
          const holding = status.holdings?.[coin];
          const coinPnl = pnl.by_coin?.[coin];
          return (
            <div key={coin} style={{
              background: '#111118', border: '1px solid #1a3a4a',
              borderRadius: 10, padding: '12px 14px',
            }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 8 }}>
                <span style={{ color: '#e0e0e0', fontFamily: 'monospace', fontWeight: 700, fontSize: 14 }}>{coin}</span>
                {holding && (
                  <span style={{ fontSize: 10, color: pnlColor(holding.pnl), fontFamily: 'monospace' }}>
                    {fmt.currency(holding.pnl)}
                  </span>
                )}
              </div>
              {holding ? (
                <>
                  <div style={{ fontSize: 11, color: '#607d8b', fontFamily: 'monospace' }}>
                    Qty: {fmt.qty(holding.qty)}
                  </div>
                  <div style={{ fontSize: 11, color: '#607d8b', fontFamily: 'monospace' }}>
                    Avg: {fmt.currency(holding.avg_cost)}
                  </div>
                  <div style={{ fontSize: 11, color: '#455a64', fontFamily: 'monospace' }}>
                    Now: {fmt.currency(holding.current_price)}
                  </div>
                </>
              ) : (
                <div style={{ fontSize: 11, color: '#3c3c52', fontFamily: 'monospace' }}>No position</div>
              )}
              {coinPnl && (
                <div style={{ marginTop: 6, paddingTop: 6, borderTop: '1px solid #1a3a4a', fontSize: 10, color: '#607d8b', fontFamily: 'monospace' }}>
                  Realized: <span style={{ color: pnlColor(coinPnl.realized) }}>{fmt.currency(coinPnl.realized)}</span>
                  {' · '}{coinPnl.trades} trades
                </div>
              )}
            </div>
          );
        })}
      </div>

      {/* Tabs */}
      <div style={{ display: 'flex', gap: 4, borderBottom: '1px solid #1a3a4a', paddingBottom: 0 }}>
        {(['overview', 'trades', 'holdings', 'settings'] as const).map(t => (
          <button key={t} onClick={() => setTab(t)} style={{
            padding: '8px 18px', border: 'none', cursor: 'pointer',
            fontFamily: 'monospace', fontSize: 12, fontWeight: tab === t ? 600 : 400,
            background: 'transparent',
            color: tab === t ? '#a78bfa' : '#607d8b',
            borderBottom: tab === t ? '2px solid #4fc3f7' : '2px solid transparent',
            textTransform: 'capitalize',
          }}>
            {t}
          </button>
        ))}
      </div>

      {/* Overview tab */}
      {tab === 'overview' && (
        <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
          {/* P&L summary */}
          <div style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
            <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
              P&L Summary
            </div>
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 16 }}>
              <div>
                <div style={{ color: '#607d8b', fontSize: 11, fontFamily: 'monospace' }}>Realized</div>
                <div style={{ color: pnlColor(pnl.total_realized), fontSize: 20, fontWeight: 700, fontFamily: 'monospace' }}>
                  {fmt.currency(pnl.total_realized)}
                </div>
              </div>
              <div>
                <div style={{ color: '#607d8b', fontSize: 11, fontFamily: 'monospace' }}>Unrealized</div>
                <div style={{ color: pnlColor(pnl.total_unrealized), fontSize: 20, fontWeight: 700, fontFamily: 'monospace' }}>
                  {fmt.currency(pnl.total_unrealized)}
                </div>
              </div>
            </div>
          </div>

          {/* Recent trades preview */}
          <div style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
            <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
              Recent Trades
            </div>
            {trades.length === 0 ? (
              <div style={{ color: '#3c3c52', fontFamily: 'monospace', fontSize: 12, textAlign: 'center', padding: '20px 0' }}>
                No trades yet — waiting for PowerTrader to execute
              </div>
            ) : (
              <div style={{ display: 'flex', flexDirection: 'column', gap: 6 }}>
                {trades.slice(0, 5).map((trade, i) => (
                  <div key={i} style={{
                    display: 'flex', alignItems: 'center', justifyContent: 'space-between',
                    padding: '8px 10px', background: '#0d1117', borderRadius: 6,
                  }}>
                    <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
                      <span style={{
                        padding: '2px 8px', borderRadius: 4, fontSize: 10, fontWeight: 700, fontFamily: 'monospace',
                        background: trade.side === 'buy' ? '#66bb6a22' : '#ef535022',
                        color: trade.side === 'buy' ? '#66bb6a' : '#ef5350',
                      }}>
                        {(trade.side || '').toUpperCase()}
                      </span>
                      <span style={{ color: '#e0e0e0', fontFamily: 'monospace', fontSize: 12, fontWeight: 600 }}>
                        {trade.coin || trade.symbol}
                      </span>
                      <span style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11 }}>
                        {fmt.qty(trade.qty)} @ {fmt.currency(trade.price)}
                      </span>
                    </div>
                    <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
                      {trade.pnl != null && (
                        <span style={{ color: pnlColor(trade.pnl), fontFamily: 'monospace', fontSize: 11 }}>
                          {fmt.currency(trade.pnl)}
                        </span>
                      )}
                      <span style={{ color: '#3c3c52', fontFamily: 'monospace', fontSize: 10 }}>
                        {fmt.time(trade.ts || trade.timestamp)}
                      </span>
                    </div>
                  </div>
                ))}
              </div>
            )}
          </div>

          {/* Setup instructions if not running */}
          {!running && (
            <div style={{
              background: '#1a1a0a', border: '1px solid #ff980044',
              borderRadius: 10, padding: '16px',
            }}>
              <div style={{ color: '#ff9800', fontFamily: 'monospace', fontSize: 12, fontWeight: 600, marginBottom: 8 }}>
                ⚠️ PowerTrader not running
              </div>
              <div style={{ color: '#455a64', fontFamily: 'monospace', fontSize: 11, lineHeight: 1.8 }}>
                To start PowerTrader, add your Robinhood API keys and run in PuTTY:<br />
                <code style={{ color: '#a78bfa' }}>cd /home/ubuntu/mission-control/powertrader-ai</code><br />
                <code style={{ color: '#a78bfa' }}>pm2 start pt_trader.py --name powertrader --interpreter python3</code>
              </div>
            </div>
          )}
        </div>
      )}

      {/* Trades tab */}
      {tab === 'trades' && (
        <div style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
          <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
            Trade History ({trades.length})
          </div>
          {trades.length === 0 ? (
            <div style={{ color: '#3c3c52', fontFamily: 'monospace', fontSize: 12, textAlign: 'center', padding: '30px 0' }}>
              No trades yet
            </div>
          ) : (
            <div style={{ maxHeight: 500, overflowY: 'auto' }}>
              <table style={{ width: '100%', borderCollapse: 'collapse', fontFamily: 'monospace', fontSize: 12 }}>
                <thead>
                  <tr style={{ color: '#607d8b', fontSize: 10, textTransform: 'uppercase', letterSpacing: '0.5px' }}>
                    {['Time','Side','Coin','Qty','Price','Cost','P&L','DCA Level'].map(h => (
                      <th key={h} style={{ textAlign: 'left', padding: '0 12px 8px 0', borderBottom: '1px solid #1a3a4a' }}>{h}</th>
                    ))}
                  </tr>
                </thead>
                <tbody>
                  {trades.map((trade, i) => (
                    <tr key={i} style={{ borderBottom: '1px solid #1a3a4a22' }}>
                      <td style={{ padding: '8px 12px 8px 0', color: '#3c3c52' }}>{fmt.time(trade.ts || trade.timestamp)}</td>
                      <td style={{ padding: '8px 12px 8px 0' }}>
                        <span style={{ color: trade.side === 'buy' ? '#66bb6a' : '#ef5350', fontWeight: 600 }}>
                          {(trade.side || '').toUpperCase()}
                        </span>
                      </td>
                      <td style={{ padding: '8px 12px 8px 0', color: '#e0e0e0', fontWeight: 600 }}>{trade.coin || trade.symbol}</td>
                      <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.qty(trade.qty)}</td>
                      <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.currency(trade.price)}</td>
                      <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.currency(trade.cost)}</td>
                      <td style={{ padding: '8px 12px 8px 0', color: pnlColor(trade.pnl) }}>{trade.pnl != null ? fmt.currency(trade.pnl) : '—'}</td>
                      <td style={{ padding: '8px 12px 8px 0', color: '#607d8b' }}>{trade.dca_level ?? '—'}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      )}

      {/* Holdings tab */}
      {tab === 'holdings' && (
        <div style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
          <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
            Current Holdings
          </div>
          {!status.holdings || Object.keys(status.holdings).length === 0 ? (
            <div style={{ color: '#3c3c52', fontFamily: 'monospace', fontSize: 12, textAlign: 'center', padding: '30px 0' }}>
              No holdings data available
            </div>
          ) : (
            <table style={{ width: '100%', borderCollapse: 'collapse', fontFamily: 'monospace', fontSize: 12 }}>
              <thead>
                <tr style={{ color: '#607d8b', fontSize: 10, textTransform: 'uppercase', letterSpacing: '0.5px' }}>
                  {['Coin','Qty','Avg Cost','Current Price','Value','P&L'].map(h => (
                    <th key={h} style={{ textAlign: 'left', padding: '0 12px 8px 0', borderBottom: '1px solid #1a3a4a' }}>{h}</th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {Object.entries(status.holdings).map(([coin, h]) => (
                  <tr key={coin} style={{ borderBottom: '1px solid #1a3a4a22' }}>
                    <td style={{ padding: '8px 12px 8px 0', color: '#e0e0e0', fontWeight: 700 }}>{coin}</td>
                    <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.qty(h.qty)}</td>
                    <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.currency(h.avg_cost)}</td>
                    <td style={{ padding: '8px 12px 8px 0', color: '#455a64' }}>{fmt.currency(h.current_price)}</td>
                    <td style={{ padding: '8px 12px 8px 0', color: '#e0e0e0' }}>{fmt.currency(h.qty * h.current_price)}</td>
                    <td style={{ padding: '8px 12px 8px 0', color: pnlColor(h.pnl) }}>{fmt.currency(h.pnl)}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      )}

      {/* Settings tab */}
      {tab === 'settings' && (
        <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
          <div style={{ background: '#111118', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
            <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
              PowerTrader Configuration
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', gap: 8, fontFamily: 'monospace', fontSize: 12 }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 0', borderBottom: '1px solid #1a3a4a' }}>
                <span style={{ color: '#607d8b' }}>Trader Script</span>
                <span style={{ color: '#a78bfa' }}>powertrader-ai/pt_trader.py</span>
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 0', borderBottom: '1px solid #1a3a4a' }}>
                <span style={{ color: '#607d8b' }}>Thinker Script</span>
                <span style={{ color: '#a78bfa' }}>powertrader-ai/pt_thinker.py</span>
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 0', borderBottom: '1px solid #1a3a4a' }}>
                <span style={{ color: '#607d8b' }}>Hub Data Dir</span>
                <span style={{ color: '#a78bfa' }}>powertrader-ai/hub_data/</span>
              </div>
              <div style={{ display: 'flex', justifyContent: 'space-between', padding: '8px 0', borderBottom: '1px solid #1a3a4a' }}>
                <span style={{ color: '#607d8b' }}>Robinhood Keys</span>
                <span style={{ color: running ? '#66bb6a' : '#ef5350' }}>{running ? '✅ Configured' : '❌ Not configured'}</span>
              </div>
            </div>
          </div>

          <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 10, padding: '16px' }}>
            <div style={{ color: '#607d8b', fontFamily: 'monospace', fontSize: 11, textTransform: 'uppercase', letterSpacing: '0.5px', marginBottom: 12 }}>
              Start Commands (PuTTY)
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', gap: 8 }}>
              {[
                { label: 'Start Trader',  cmd: 'pm2 start /home/ubuntu/mission-control/powertrader-ai/pt_trader.py --name powertrader --interpreter python3' },
                { label: 'Start Thinker', cmd: 'pm2 start /home/ubuntu/mission-control/powertrader-ai/pt_thinker.py --name pt-thinker --interpreter python3' },
                { label: 'Start Trainer', cmd: 'pm2 start /home/ubuntu/mission-control/powertrader-ai/pt_trainer.py --name pt-trainer --interpreter python3' },
                { label: 'Stop All',      cmd: 'pm2 stop powertrader pt-thinker pt-trainer' },
              ].map(item => (
                <div key={item.label} style={{ padding: '8px 12px', background: '#111118', borderRadius: 6 }}>
                  <div style={{ color: '#607d8b', fontSize: 10, marginBottom: 4 }}>{item.label}</div>
                  <code style={{ color: '#a78bfa', fontSize: 11, wordBreak: 'break-all' }}>{item.cmd}</code>
                </div>
              ))}
            </div>
          </div>
        </div>
      )}

    </div>
  );
}
