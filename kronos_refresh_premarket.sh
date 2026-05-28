#!/bin/bash
# Kronos pre-market refresh — runs daily Mon-Fri before market open
# Called by kronos-refresh.timer (12:00 UTC = 8:00 AM ET)
set -euo pipefail

PYTHON=/home/itsju/02_DATA/mc-kb/.venv/bin/python
SCRIPT=/home/itsju/05_AUTOMATION/scripts/kronos_forecast_v2.py
MODEL=${KRONOS_REFRESH_MODEL:-mini}
TICKERS=(BTC SPY QQQ NVDA TSLA)
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_refresh.log

mkdir -p "$(dirname "$LOG")"
echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket starting (model=$MODEL, tickers=${TICKERS[*]})" | tee -a "$LOG"

for ticker in "${TICKERS[@]}"; do
    echo "[$(date -u +%FT%TZ)] Generating $ticker..." | tee -a "$LOG"
    $PYTHON "$SCRIPT" --ticker "$ticker" --model "$MODEL" --no-discord 2>&1 | tail -5 | tee -a "$LOG" || true
    sleep 5
done

echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket done" | tee -a "$LOG"
