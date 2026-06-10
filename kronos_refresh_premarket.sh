#!/bin/bash
# Kronos pre-market refresh — runs daily Mon-Fri before market open
# Cron fires 8:00 AM ET (system TZ is America/New_York).
# Routes through kronos_on_demand.py so finetuned weights are auto-selected.
set -uo pipefail

PYTHON="${KRONOS_PYTHON:-/home/itsju/04_RESEARCH/Kronos/kronos-env/bin/python}"
ON_DEMAND=/home/itsju/mission-control/agent-team/kronos/kronos_on_demand.py
TICKERS=(SPY QQQ NVDA TSLA AAPL MSFT AMD SMCI META MU AMZN GOOGL COIN BTC)
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_refresh.log

mkdir -p "$(dirname "$LOG")"
echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket starting (tickers=${TICKERS[*]})" | tee -a "$LOG"

# Disk pre-flight — skip if < 50GB free
source /home/itsju/scripts/hf_guard.sh
if ! hf_check_space >> "$LOG" 2>&1; then
    echo "[$(date -u +%FT%TZ)] WARN: disk pre-flight failed — skipping refresh to protect WSL stability" | tee -a "$LOG"
    exit 0
fi

for ticker in "${TICKERS[@]}"; do
    echo "[$(date -u +%FT%TZ)] Generating $ticker..." | tee -a "$LOG"
    $PYTHON "$ON_DEMAND" --ticker "$ticker" --no-discord 2>&1 | tail -3 | tee -a "$LOG" || true
    sleep 5
done

echo "[$(date -u +%FT%TZ)] kronos_refresh_premarket done" | tee -a "$LOG"
