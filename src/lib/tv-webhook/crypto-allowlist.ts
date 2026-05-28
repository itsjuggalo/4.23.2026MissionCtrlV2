// Alpaca paper crypto allowlist. Maintain manually against
// https://docs.alpaca.markets/docs/crypto-trading
export const ALPACA_CRYPTO_ALLOWLIST = new Set([
  'BTC/USD', 'ETH/USD', 'LTC/USD', 'BCH/USD', 'AVAX/USD', 'DOGE/USD',
  'LINK/USD', 'SHIB/USD', 'USDC/USD', 'USDT/USD', 'AAVE/USD', 'BAT/USD',
  'CRV/USD', 'DOT/USD', 'GRT/USD', 'MKR/USD', 'PEPE/USD', 'SUSHI/USD',
  'UNI/USD', 'XTZ/USD', 'YFI/USD',
]);

// Normalize TradingView ticker forms. TV typically sends "BTCUSD" or
// "BINANCE:BTCUSDT"; Alpaca wants "BTC/USD".
export function normalizeSymbol(raw: string): string {
  const s = raw.toUpperCase().replace(/^[A-Z]+:/, '');
  if (s.includes('/')) return s.replace(/USDT$/, 'USD');
  // BTCUSDT -> BTC/USD ; BTCUSD -> BTC/USD ; SOLUSDT -> SOL/USD
  const m = s.match(/^([A-Z0-9]+?)(USDT|USD|USDC)$/);
  if (m) {
    const quote = m[2] === 'USDT' ? 'USD' : m[2];
    return `${m[1]}/${quote}`;
  }
  return s;
}

export function isCrypto(symbol: string): boolean {
  return /\/(USD|USDT|USDC)$/.test(symbol);
}
