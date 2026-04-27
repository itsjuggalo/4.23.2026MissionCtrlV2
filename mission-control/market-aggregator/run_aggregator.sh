#!/bin/bash
# Market Data Aggregator — scrapes free sources for agent briefings
# Crontab: 0 * * * * /home/ubuntu/mission-control/market-aggregator/run_aggregator.sh >> /home/ubuntu/mission-control/market-aggregator/logs/cron.log 2>&1
cd "$(dirname "$0")"
mkdir -p logs
python3 market_aggregator.py
