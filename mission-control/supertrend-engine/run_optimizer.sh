#!/bin/bash
# SuperTrend Optimizer — Run Script
# Usage:
#   ./run_optimizer.sh                     # Default: BTCUSD 1H both modes
#   ./run_optimizer.sh ETH USD 4H          # Custom
#   ./run_optimizer.sh BTC USD 1H long     # Long-only

cd "$(dirname "$0")"

SYMBOL="${1:-BTC}"
CURRENCY="${2:-USD}"
TIMEFRAME="${3:-1H}"
MODE="${4:-all}"

echo "============================================"
echo "SuperTrend Grid Optimizer"
echo "  ${SYMBOL}/${CURRENCY} ${TIMEFRAME} mode=${MODE}"
echo "============================================"

python3 optimizer.py "$SYMBOL" "$CURRENCY" "$TIMEFRAME" "$MODE"
