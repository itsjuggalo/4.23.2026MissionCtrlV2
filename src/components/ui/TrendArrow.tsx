type Trend = 'bullish' | 'bearish' | 'neutral';

interface TrendArrowProps {
  trend: Trend;
}

export function TrendArrow({ trend }: TrendArrowProps) {
  const config = {
    bullish: { symbol: '↑', color: '#00d2a0' },
    bearish: { symbol: '↓', color: '#ff4757' },
    neutral: { symbol: '→', color: '#ffa502' },
  };

  const { symbol, color } = config[trend];

  return (
    <span style={{ color, fontWeight: 600, fontSize: '14px' }}>{symbol}</span>
  );
}
