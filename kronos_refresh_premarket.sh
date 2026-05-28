#!/bin/bash
# Kronos pre-market refresh — runs daily Mon-Fri before market open
# Called by kronos-refresh.timer (12:00 UTC = 8:00 AM ET)
# Routes through kronos_on_demand.py so finetuned weights are auto-selected.
set -uo pipefail

PYTHON=/home/itsju/02_DATA/mc-kb/.venv/bin/python
ON_DEMAND=/home/itsju/01_ACTIVE/mission-control/agent-team/kronos/kronos_on_demand.py
TICKERS=(SPY QQQ NVDA TSLA AAPL MSFT AMD SMCI META MU AMZN GOOGL COIN BTC)
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_refresh.log

mkdir -p "$(dirname "$LOG")"
echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket starting (tickers=${TICKERS[*]})" | tee -a "$LOG"

for ticker in "${TICKERS[@]}"; do
    echo "[$(date -u +%FT%TZ)] Generating $ticker..." | tee -a "$LOG"
    $PYTHON "$ON_DEMAND" --ticker "$ticker" --no-discord 2>&1 | tail -3 | tee -a "$LOG" || true
    sleep 5
done

echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket done" | tee -a "$LOG"
