#!/bin/bash
# Kronos prewarm — serial, 8 min per ticker, top tickers only
# Total runtime: ~64 min if all tickers actually run; cron kicks every 60 min
export PATH=/usr/local/bin:/usr/bin:/bin
KRONOS=/home/ubuntu/mission-control/agent-team/kronos/kronos_on_demand.py
DIR=/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts
LOG=/tmp/kronos_prewarm.log
TICKERS="SPY QQQ NVDA TSLA AMD MU AAPL META"
echo "[$(TZ=America/New_York date '+%Y-%m-%d %H:%M:%S ET')] prewarm start (8 tickers serial)" >> "$LOG"
for t in $TICKERS; do
  echo "  [$t] starting at $(date '+%H:%M:%S')" >> "$LOG"
  timeout 600 python3 "$KRONOS" --ticker "$t" --no-discord >> "$LOG" 2>&1
  echo "  [$t] done at $(date '+%H:%M:%S')" >> "$LOG"
  newest=$(ls -t "$DIR/${t}_"*.json 2>/dev/null | head -1)
  [ -n "$newest" ] && ln -sfn "$newest" "$DIR/latest_${t}.json"
done
echo "[$(TZ=America/New_York date '+%Y-%m-%d %H:%M:%S ET')] prewarm done" >> "$LOG"
