type Trend = 'bullish' | 'bearish' | 'neutral';

interface TrendArrowProps {
  trend: Trend;
}

export function TrendArrow({ trend }: TrendArrowProps) {
  const config = {
    bullish: { symbol: '↑', color: '#66bb6a' },
    bearish: { symbol: '↓', color: '#ef5350' },
    neutral: { symbol: '→', color: '#ff9800' },
  };

  const { symbol, color } = config[trend];

  return (
    <span style={{ color, fontWeight: 600, fontSize: '14px' }}>{symbol}</span>
  );
}
