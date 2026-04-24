#!/usr/bin/env bash
# Mission Control Watchdog
# Checks port 3033 every 60s, auto-rebuilds + restarts if down
set -euo pipefail

MC_DIR="/home/ubuntu/.openclaw/workspace/mission-control"
LOG="$MC_DIR/logs/watchdog.log"
LOCK="/tmp/mc-watchdog.lock"

mkdir -p "$MC_DIR/logs"

log() { echo "[$(date '+%Y-%m-%d %H:%M:%S')] $*" | tee -a "$LOG"; }

# Prevent concurrent runs
if [ -f "$LOCK" ]; then
  log "Already running (lock exists). Skipping."
  exit 0
fi
touch "$LOCK"
trap "rm -f $LOCK" EXIT

HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" --max-time 5 http://localhost:3033/ 2>/dev/null || echo "000")

if [[ "$HTTP_CODE" == "200" || "$HTTP_CODE" == "307" || "$HTTP_CODE" == "301" ]]; then
  exit 0
fi

log "⚠️  Mission Control down (HTTP $HTTP_CODE) — rebuilding..."

cd "$MC_DIR"

if timeout 180 npm run build >> "$LOG" 2>&1; then
  log "✅ Build succeeded. Restarting..."
  pm2 restart mission-control --update-env >> "$LOG" 2>&1
  log "✅ Mission Control restarted."
else
  log "❌ Build FAILED. Not restarting to avoid serving broken build."
  exit 1
fi
