#!/bin/bash
# Mission Control Daily Report — runs at 11:55 PM UTC (7:55 PM ET)
# Crontab: 55 23 * * * /home/ubuntu/mission-control/daily-reports/run_daily_report.sh >> /home/ubuntu/mission-control/daily-reports/logs/cron.log 2>&1

cd "$(dirname "$0")"
mkdir -p logs

TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
echo ""
echo "[$TIMESTAMP] Running Daily Report"

python3 daily_report.py

echo "[$TIMESTAMP] Done"
