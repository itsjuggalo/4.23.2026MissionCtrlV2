#!/bin/bash
# SuperTrend Daily Optimization — Zero Token Cron Script
# Runs backtester grid, saves best params for agents
# Add to crontab: 0 6 * * * /home/ubuntu/mission-control/supertrend-engine/daily_optimize.sh >> /home/ubuntu/mission-control/supertrend-engine/logs/cron.log 2>&1

cd "$(dirname "$0")"
mkdir -p logs

TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
echo ""
echo "[$TIMESTAMP] Daily SuperTrend Optimization Starting"

# Run BTC 1H (primary)
python3 optimizer.py BTC USD 1H all

# Run BTC 4H (swing)
python3 optimizer.py BTC USD 4H all

# Optional: Run ETH
# python3 optimizer.py ETH USD 1H all

TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
echo "[$TIMESTAMP] Daily Optimization Complete"

# Post summary to Discord
BEST_1H=$(python3 -c "
import json, os
f = os.path.expanduser('~/.openclaw/workspace/directives/supertrend_config_BTC_1H.json')
if os.path.exists(f):
    d = json.load(open(f))
    print(f\"BTC 1H Best: ATR={d['recommended_atr_period']} Mult={d['recommended_multiplier']} WR={d['expected_win_rate']}% PF={d['expected_profit_factor']} Return={d['backtest_return_pct']}%\")
else:
    print('No 1H results')
" 2>/dev/null)

BEST_4H=$(python3 -c "
import json, os
f = os.path.expanduser('~/.openclaw/workspace/directives/supertrend_config_BTC_4H.json')
if os.path.exists(f):
    d = json.load(open(f))
    print(f\"BTC 4H Best: ATR={d['recommended_atr_period']} Mult={d['recommended_multiplier']} WR={d['expected_win_rate']}% PF={d['expected_profit_factor']} Return={d['backtest_return_pct']}%\")
else:
    print('No 4H results')
" 2>/dev/null)

WEBHOOK=$(cat ~/.openclaw/secrets/discord_tv_signals_webhook 2>/dev/null)
if [ -n "$WEBHOOK" ]; then
    curl -s -X POST "$WEBHOOK" \
        -H "Content-Type: application/json" \
        -H "User-Agent: SignalReceiver/1.0" \
        -d "{\"embeds\":[{\"title\":\"📊 Daily SuperTrend Optimization\",\"description\":\"$BEST_1H\n$BEST_4H\",\"color\":4886754,\"footer\":{\"text\":\"Auto-optimization | $TIMESTAMP\"}}]}" \
        > /dev/null
fi
