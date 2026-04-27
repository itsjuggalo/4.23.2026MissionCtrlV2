'use client';

import { useState, useEffect, useCallback } from 'react';

interface TelegramSignal {
  id: string;
  channel_id: string;
  channel_name: string;
  timestamp: string;
  raw_text: string;
  symbol: string | null;
  direction: string | null;
  entry: number | null;
  stop_loss: number | null;
  targets: number[];
  leverage: string | null;
  price_change?: string | null;
  score?: number | null;
  status?: string | null;
}

// ── Asset type filters ────────────────────────────────────────────────────────

type AssetTab = 'All' | 'Crypto' | 'Stocks' | 'Forex' | 'Options';

const CRYPTO_SYMBOLS = new Set([
  'BTC', 'ETH', 'SOL', 'DOGE', 'BNB', 'XRP', 'ADA', 'AVAX', 'DOT', 'MATIC',
  'LINK', 'UNI', 'ATOM', 'LTC', 'BCH', 'NEAR', 'APT', 'ARB', 'OP', 'SUI',
  'INJ', 'SEI', 'TIA', 'PEPE', 'WIF', 'FLOKI', 'SHIB', 'SAND', 'MANA',
  'FTM', 'ALGO', 'VET', 'HBAR', 'FIL', 'AAVE', 'CRV', 'GMX', 'RUNE', 'TAO',
  'RENDER', 'MORPHO', 'DYDX', 'ZEC', 'HYPE', 'QNT', 'FET', 'FLOW', 'KAS',
  'IMX', 'CRV', 'ZRO', 'PENDLE', 'ONT', 'LRC', 'JST', 'STG', 'BAT',
]);

function isCrypto(sig: TelegramSignal): boolean {
  if (!sig.symbol) return false;
  const sym = sig.symbol.toUpperCase().replace(/USDT$|USD$/, '');
  return CRYPTO_SYMBOLS.has(sym) || /USDT$/.test(sig.symbol) || sig.channel_id === 'websocket';
}

function isForex(sig: TelegramSignal): boolean {
  if (!sig.symbol) return false;
  return /^[A-Z]{6}$/.test(sig.symbol);
}

function isOptions(sig: TelegramSignal): boolean {
  return sig.direction === 'CALL' || sig.direction === 'PUT';
}

function isStocks(sig: TelegramSignal): boolean {
  if (!sig.symbol) return false;
  return !isCrypto(sig) && !isForex(sig) && !isOptions(sig);
}

// ── Source filters ────────────────────────────────────────────────────────────

type SourceTab = 'All Sources' | 'AI Crypto' | 'Coin Sonar' | 'Firebase' | 'WTrack' | 'WLiq';

function matchesSource(sig: TelegramSignal, src: SourceTab): boolean {
  if (src === 'All Sources') return true;
  const cn = sig.channel_name || '';
  if (src === 'AI Crypto')   return cn.includes('AICrypto') || cn.toLowerCase().includes('ai crypto') || sig.channel_id === 'websocket';
  if (src === 'Coin Sonar')  return cn.toLowerCase().includes('coin sonar');
  if (src === 'Firebase')    return cn.includes('Firebase') || sig.channel_id === 'firebase';
  if (src === 'WTrack')      return cn.includes('WHALETRACKER') || cn.includes('𝐖𝐇𝐀𝐋𝐄𝐓𝐑𝐀𝐂𝐊𝐄𝐑') || cn.toLowerCase().includes('whale volume') || cn.toLowerCase().includes('whale liquidation');
  if (src === 'WLiq')        return cn.toLowerCase().includes('liquidation');
  return true;
}

// ── Direction filters ─────────────────────────────────────────────────────────

type DirTab = 'All Directions' | 'Long Positions' | 'Short Positions';

function matchesDirection(sig: TelegramSignal, dir: DirTab): boolean {
  if (dir === 'All Directions') return true;
  const d = (sig.direction || '').toUpperCase();
  if (dir === 'Long Positions')  return ['LONG', 'BUY', 'CALL'].includes(d);
  if (dir === 'Short Positions') return ['SHORT', 'SELL', 'PUT'].includes(d);
  return true;
}

// ── Combined filter ───────────────────────────────────────────────────────────

function applyFilters(
  signals: TelegramSignal[],
  asset: AssetTab,
  source: SourceTab,
  direction: DirTab,
): TelegramSignal[] {
  return signals.filter(sig => {
    if (asset === 'Crypto'  && !isCrypto(sig))  return false;
    if (asset === 'Forex'   && !isForex(sig))   return false;
    if (asset === 'Options' && !isOptions(sig)) return false;
    if (asset === 'Stocks'  && !isStocks(sig))  return false;
    if (!matchesSource(sig, source))    return false;
    if (!matchesDirection(sig, direction)) return false;
    return true;
  });
}

// ── Helpers ───────────────────────────────────────────────────────────────────

function relativeTime(iso: string): string {
  const diff = Math.floor((Date.now() - new Date(iso).getTime()) / 1000);
  if (diff < 60)    return `${diff}s ago`;
  if (diff < 3600)  return `${Math.floor(diff / 60)}m ago`;
  if (diff < 86400) return `${Math.floor(diff / 3600)}h ago`;
  return `${Math.floor(diff / 86400)}d ago`;
}

function directionStyle(dir: string | null): { bg: string; color: string } {
  if (!dir) return { bg: '#1a3a4a', color: '#455a64' };
  const d = dir.toUpperCase();
  if (['LONG', 'BUY', 'CALL'].includes(d))  return { bg: '#0d2b1a', color: '#00e07a' };
  if (['SHORT', 'SELL', 'PUT'].includes(d)) return { bg: '#2b0d0d', color: '#ff4d4d' };
  return { bg: '#1a3a4a', color: '#455a64' };
}

function sourceLabel(sig: TelegramSignal): string {
  const cn = sig.channel_name || '';
  if (sig.channel_id === 'websocket') return 'AI Crypto';
  if (sig.channel_id === 'firebase')  return 'Firebase';
  if (cn.toLowerCase().includes('coin sonar')) return 'Coin Sonar';
  if (cn.includes('𝐖𝐇𝐀𝐋𝐄𝐓𝐑𝐀𝐂𝐊𝐄𝐑') || cn.toLowerCase().includes('whale volume')) return 'WTracker';
  if (cn.toLowerCase().includes('liquidation')) return 'WLiq';
  if (cn.toLowerCase().includes('binance')) return 'Binance';
  if (cn.toLowerCase().includes('ai crypto') || cn.includes('AICrypto')) return 'AI Crypto';
  return cn.slice(0, 14);
}

function SkeletonCard() {
  return (
    <div style={{ background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 12, padding: 20, animation: 'pulse 1.5s ease-in-out infinite' }}>
      {[80, 120, 60, 100].map((w, i) => (
        <div key={i} style={{ height: 14, width: `${w}%`, background: '#1a3a4a', borderRadius: 4, marginBottom: i < 3 ? 12 : 0 }} />
      ))}
    </div>
  );
}

// ── Tab row component ─────────────────────────────────────────────────────────

function TabRow<T extends string>({
  tabs, active, onChange, counts,
}: {
  tabs: T[];
  active: T;
  onChange: (t: T) => void;
  counts?: Partial<Record<T, number>>;
}) {
  return (
    <div style={{ display: 'flex', gap: 4, flexWrap: 'wrap' }}>
      {tabs.map(tab => (
        <button
          key={tab}
          onClick={() => onChange(tab)}
          style={{
            padding: '6px 14px', fontSize: 12, borderRadius: 6, cursor: 'pointer',
            fontFamily: "'Inter', sans-serif", border: 'none',
            background: active === tab ? '#4fc3f7' : '#0d1117',
            color: active === tab ? '#fff' : '#455a64',
            borderBottom: active === tab ? '2px solid #81d4fa' : '2px solid transparent',
            transition: 'all 0.15s',
          }}
        >
          {tab}
          {counts && counts[tab] != null && (
            <span style={{ marginLeft: 5, fontSize: 10, opacity: 0.7 }}>({counts[tab]})</span>
          )}
        </button>
      ))}
    </div>
  );
}

// ── Main page ─────────────────────────────────────────────────────────────────

export function TelegramSignalsPage() {
  const [signals,   setSignals]   = useState<TelegramSignal[]>([]);
  const [loading,   setLoading]   = useState(true);
  const [lastUpdated, setLastUpdated] = useState<Date | null>(null);
  const [assetTab,  setAssetTab]  = useState<AssetTab>('All');
  const [sourceTab, setSourceTab] = useState<SourceTab>('All Sources');
  const [dirTab,    setDirTab]    = useState<DirTab>('All Directions');
  const [expanded,  setExpanded]  = useState<Set<string>>(new Set());
  const [, setTick] = useState(0);

  const fetchSignals = useCallback(async () => {
    try {
      const res = await fetch('/api/telegram-signals?limit=200');
      const data = await res.json();
      setSignals(data);
      setLastUpdated(new Date());
    } catch { /* silent */ }
    finally { setLoading(false); }
  }, []);

  useEffect(() => {
    fetchSignals();
    const interval = setInterval(fetchSignals, 30_000);
    return () => clearInterval(interval);
  }, [fetchSignals]);

  useEffect(() => {
    const t = setInterval(() => setTick(n => n + 1), 10_000);
    return () => clearInterval(t);
  }, []);

  const toggleExpand = (id: string) =>
    setExpanded(prev => { const n = new Set(prev); n.has(id) ? n.delete(id) : n.add(id); return n; });

  const filtered = applyFilters(signals, assetTab, sourceTab, dirTab);

  // Count helpers for tab badges
  const assetTabs: AssetTab[] = ['All', 'Crypto', 'Stocks', 'Forex', 'Options'];
  const sourceTabs: SourceTab[] = ['All Sources', 'AI Crypto', 'Coin Sonar', 'Firebase', 'WTrack', 'WLiq'];
  const dirTabs: DirTab[] = ['All Directions', 'Long Positions', 'Short Positions'];

  const lastStr = lastUpdated ? relativeTime(lastUpdated.toISOString()) : '—';

  return (
    <div style={{ fontFamily: "'Inter', -apple-system, sans-serif", color: '#e0e0e0' }}>

      {/* Status bar */}
      <div style={{
        display: 'flex', alignItems: 'center', justifyContent: 'space-between',
        background: '#0d1117', border: '1px solid #1a3a4a', borderRadius: 10,
        padding: '12px 20px', marginBottom: 16, flexWrap: 'wrap', gap: 10,
      }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
          <span style={{ width: 8, height: 8, borderRadius: '50%', background: '#00e07a', boxShadow: '0 0 6px #00e07a', display: 'inline-block' }} />
          <span style={{ fontSize: 13, fontWeight: 600 }}>
            Monitoring 7 Telegram + Firebase + AICryptoSignals
          </span>
          <span style={{ background: 'rgba(108,92,231,0.15)', color: '#81d4fa', fontSize: 11, fontFamily: "'JetBrains Mono', monospace", padding: '2px 8px', borderRadius: 6 }}>
            {filtered.length} / {signals.length}
          </span>
        </div>
        <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace" }}>
          Last updated: {lastStr}
        </span>
      </div>

      {/* Filter row 1 — asset type */}
      <div style={{ marginBottom: 8 }}>
        <TabRow tabs={assetTabs} active={assetTab} onChange={setAssetTab} />
      </div>

      {/* Filter row 2 — source */}
      <div style={{ marginBottom: 8 }}>
        <TabRow tabs={sourceTabs} active={sourceTab} onChange={setSourceTab} />
      </div>

      {/* Filter row 3 — direction */}
      <div style={{ marginBottom: 20 }}>
        <TabRow tabs={dirTabs} active={dirTab} onChange={setDirTab} />
      </div>

      {/* Loading */}
      {loading && (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(360px, 1fr))', gap: 16 }}>
          {[1, 2, 3, 4].map(i => <SkeletonCard key={i} />)}
        </div>
      )}

      {/* Empty state */}
      {!loading && filtered.length === 0 && (
        <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', padding: '80px 20px', color: '#607d8b', gap: 14 }}>
          <svg width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="#607d8b" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round">
            <line x1="22" y1="2" x2="11" y2="13" /><polygon points="22 2 15 22 11 13 2 9 22 2" />
          </svg>
          <div style={{ fontSize: 16, fontWeight: 500 }}>No signals match the current filters</div>
        </div>
      )}

      {/* Signal grid */}
      {!loading && filtered.length > 0 && (
        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(360px, 1fr))', gap: 16 }}>
          {filtered.map(sig => {
            const dirStyle = directionStyle(sig.direction);
            const isExp    = expanded.has(sig.id);
            const sym      = sig.symbol || '???';
            const srcLabel = sourceLabel(sig);

            return (
              <div key={sig.id} style={{
                background: '#0d1117', border: '1px solid #1a3a4a',
                borderRadius: 12, padding: 18, display: 'flex', flexDirection: 'column', gap: 12,
              }}>
                {/* Header */}
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', gap: 6 }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 6, flexWrap: 'wrap', minWidth: 0 }}>
                    <span style={{
                      fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace",
                      background: '#1a3a4a', padding: '1px 6px', borderRadius: 4, flexShrink: 0,
                    }}>
                      {srcLabel}
                    </span>
                    <span style={{ fontSize: 11, color: '#455a64', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                      {sig.channel_name}
                    </span>
                  </div>
                  <span style={{ fontSize: 11, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", flexShrink: 0 }}>
                    {relativeTime(sig.timestamp)}
                  </span>
                </div>

                {/* Symbol + direction + leverage */}
                <div style={{ display: 'flex', alignItems: 'center', gap: 10, flexWrap: 'wrap' }}>
                  <span style={{ fontSize: 22, fontWeight: 700, color: '#81d4fa', fontFamily: "'JetBrains Mono', monospace", letterSpacing: '0.5px' }}>
                    {sym}
                  </span>
                  {sig.direction && (
                    <span style={{ ...dirStyle, fontSize: 11, fontWeight: 700, fontFamily: "'JetBrains Mono', monospace", padding: '3px 10px', borderRadius: 6, letterSpacing: '0.5px' }}>
                      {sig.direction}
                    </span>
                  )}
                  {sig.leverage && (
                    <span style={{ background: '#2d2200', color: '#ffd32a', fontSize: 11, fontWeight: 700, fontFamily: "'JetBrains Mono', monospace", padding: '3px 10px', borderRadius: 6 }}>
                      {sig.leverage}
                    </span>
                  )}
                  {sig.score != null && (
                    <span style={{ background: 'rgba(108,92,231,0.12)', color: '#81d4fa', fontSize: 10, fontFamily: "'JetBrains Mono', monospace", padding: '2px 7px', borderRadius: 4, marginLeft: 'auto' }}>
                      {sig.score}/100
                    </span>
                  )}
                </div>

                {/* Prices */}
                <div style={{ display: 'flex', flexDirection: 'column', gap: 5 }}>
                  {sig.entry !== null && (
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 13 }}>
                      <span style={{ color: '#455a64' }}>Entry</span>
                      <span style={{ color: '#e0e0e0', fontFamily: "'JetBrains Mono', monospace", fontWeight: 600 }}>
                        ${sig.entry.toLocaleString()}
                      </span>
                    </div>
                  )}
                  {sig.price_change && (
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 13 }}>
                      <span style={{ color: '#455a64' }}>Price Δ</span>
                      <span style={{
                        fontFamily: "'JetBrains Mono', monospace", fontWeight: 600,
                        color: sig.price_change.startsWith('-') ? '#ff6b6b' : '#00e07a',
                      }}>
                        {sig.price_change}
                      </span>
                    </div>
                  )}
                  {sig.stop_loss !== null && (
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: 13 }}>
                      <span style={{ color: '#455a64' }}>Stop Loss</span>
                      <span style={{ color: '#ff6b6b', fontFamily: "'JetBrains Mono', monospace", fontWeight: 600 }}>
                        ${sig.stop_loss.toLocaleString()}
                      </span>
                    </div>
                  )}
                </div>

                {/* Targets */}
                {sig.targets.length > 0 && (
                  <div>
                    <div style={{ fontSize: 10, color: '#455a64', marginBottom: 5, textTransform: 'uppercase', letterSpacing: '0.5px' }}>Targets</div>
                    <div style={{ display: 'flex', flexWrap: 'wrap', gap: 5 }}>
                      {sig.targets.map((t, i) => (
                        <span key={i} style={{ background: '#0d2b1a', color: '#00e07a', fontSize: 11, fontFamily: "'JetBrains Mono', monospace", fontWeight: 600, padding: '2px 8px', borderRadius: 5, border: '1px solid rgba(0,224,122,0.15)' }}>
                          T{i + 1}: ${t.toLocaleString()}
                        </span>
                      ))}
                    </div>
                  </div>
                )}

                {/* Raw message toggle */}
                <div>
                  <button
                    onClick={() => toggleExpand(sig.id)}
                    style={{ background: 'transparent', border: 'none', color: '#607d8b', fontSize: 11, cursor: 'pointer', padding: '3px 0', fontFamily: "'Inter', sans-serif", display: 'flex', alignItems: 'center', gap: 4 }}
                  >
                    <svg width="11" height="11" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"
                      style={{ transform: isExp ? 'rotate(90deg)' : 'rotate(0)', transition: 'transform 0.15s' }}>
                      <polyline points="9 18 15 12 9 6" />
                    </svg>
                    Raw Message
                  </button>
                  {isExp && (
                    <div style={{ marginTop: 6, background: '#050508', border: '1px solid #1a3a4a', borderRadius: 6, padding: 10, fontSize: 11, fontFamily: "'JetBrains Mono', monospace", color: '#455a64', whiteSpace: 'pre-wrap', wordBreak: 'break-word', lineHeight: 1.6, maxHeight: 180, overflowY: 'auto' }}>
                      {sig.raw_text}
                    </div>
                  )}
                </div>
              </div>
            );
          })}
        </div>
      )}

      <style>{`@keyframes pulse { 0%, 100% { opacity: 1; } 50% { opacity: 0.4; } }`}</style>
    </div>
  );
}
