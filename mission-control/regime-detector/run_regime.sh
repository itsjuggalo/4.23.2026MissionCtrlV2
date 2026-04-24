#!/bin/bash
# Market Regime Detector — Zero Token Cron
# Runs every 4 hours, posts to Discord, saves for agents
# Crontab: 0 */4 * * * /home/ubuntu/mission-control/regime-detector/run_regime.sh >> /home/ubuntu/mission-control/regime-detector/logs/cron.log 2>&1

cd "$(dirname "$0")"
mkdir -p logs

TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
echo ""
echo "[$TIMESTAMP] Running Regime Detection"

python3 regime_detector.py BTC USD

echo "[$TIMESTAMP] Done"
