'use client';
import React, { useState, useEffect } from 'react';
import { tickerLogoUrl } from '@/lib/tickerDomains';

type Size = 'sm' | 'md' | 'lg';

const DIMS: Record<Size, { px: number; font: number; initialsLen: number }> = {
  sm: { px: 16, font: 8,  initialsLen: 2 },
  md: { px: 28, font: 10, initialsLen: 3 },
  lg: { px: 40, font: 12, initialsLen: 3 },
};

/**
 * Fallback chain — priority order:
 *  1. Finnhub CDN      — SAME SOURCE the Option Signals app uses
 *  2. FMP              — broad coverage, by ticker
 *  3. Twelve Data      — by domain (backup for mapped tickers)
 *  4. Synth Finance    — by ticker
 *  5. Initials placeholder
 */
function buildChain(symbol: string): string[] {
  const up = symbol.toUpperCase();
  const chain: string[] = [];

  // 1. Finnhub — same CDN Option Signals app uses
  chain.push(`https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/${up}.png`);

  // 2. FMP — by ticker
  chain.push(`https://financialmodelingprep.com/image-stock/${up}.png`);

  // 3. Twelve Data — by domain
  const mappedUrl = tickerLogoUrl(symbol);
  if (mappedUrl) {
    const domain = mappedUrl.replace(/^https:\/\/logo\.clearbit\.com\//, '');
    chain.push(`https://logo.twelvedata.com/${domain}`);
  }

  // 4. Synth Finance
  chain.push(`https://logo.synthfinance.com/ticker/${up}`);

  return chain;
}

export const TickerLogo: React.FC<{
  symbol: string;
  size?: Size;
  logoUrl?: string | null;
}> = ({ symbol, size = 'md' }) => {
  const dim = DIMS[size];
  const [chainIdx, setChainIdx] = useState(0);
  const [chain, setChain] = useState<string[]>(() => buildChain(symbol));

  useEffect(() => {
    setChain(buildChain(symbol));
    setChainIdx(0);
  }, [symbol]);

  const url = chain[chainIdx];
  const exhausted = !url || chainIdx >= chain.length;

  if (exhausted) {
    return (
      <div style={{
        width: dim.px, height: dim.px, borderRadius: '50%',
        background: '#fff', display: 'flex', alignItems: 'center',
        justifyContent: 'center', color: '#1a2332', fontSize: `${dim.font}px`,
        fontWeight: 700, flexShrink: 0, letterSpacing: '-0.3px',
      }}>
        {(symbol || '?').slice(0, dim.initialsLen).toUpperCase()}
      </div>
    );
  }

  return (
    // eslint-disable-next-line @next/next/no-img-element
    <img
      key={url}
      src={url}
      onError={() => setChainIdx((i) => i + 1)}
      alt={symbol}
      referrerPolicy="no-referrer"
      style={{
        width: dim.px, height: dim.px,
        borderRadius: '50%',
        background: '#fff',
        objectFit: 'contain',
        flexShrink: 0,
        padding: '3px',
        boxSizing: 'border-box',
      }}
    />
  );
};
