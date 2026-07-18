#!/bin/bash
export PATH=/home/ubuntu/.local/bin:/usr/local/bin:/usr/bin:/bin
WEBHOOK=$(cat /home/ubuntu/.openclaw/secrets/discord_webhook_autofix)
TODAY=$(TZ=America/New_York date '+%Y-%m-%d')
NOW=$(TZ=America/New_York date '+%H:%M ET')

# Boba cycle log analysis
BOBA_RUNS=$(grep -c "fresh signals" /tmp/boba_cycle.log 2>/dev/null || echo 0)
BOBA_NOSIG=$(grep -c "No fresh signals" /tmp/boba_cycle.log 2>/dev/null | tail -1)
BOBA_PICKED=$(grep -c "ENTER_NOW\|submit_order" /tmp/boba_cycle.log 2>/dev/null || echo 0)

# Jazzy cycle log analysis
JAZZY_RUNS=$(grep -c "fresh signals" /tmp/jazzy_cycle.log 2>/dev/null || echo 0)
JAZZY_PICKED=$(grep -c "ENTER_NOW\|submit_order" /tmp/jazzy_cycle.log 2>/dev/null || echo 0)

# Today's actual orders on each account
BOBA_KEY=$(cat /home/ubuntu/.openclaw/secrets/alpaca-boba-key-id)
BOBA_SEC=$(cat /home/ubuntu/.openclaw/secrets/alpaca-boba-secret)
JAZZY_KEY=$(cat /home/ubuntu/.openclaw/secrets/alpaca-jazzy-key-id)
JAZZY_SEC=$(cat /home/ubuntu/.openclaw/secrets/alpaca-jazzy-secret)
SINCE=$(TZ=America/New_York date '+%Y-%m-%dT00:00:00-05:00')

BOBA_ORDERS=$(curl -s -H "APCA-API-KEY-ID: $BOBA_KEY" -H "APCA-API-SECRET-KEY: $BOBA_SEC" "https://paper-api.alpaca.markets/v2/orders?status=all&limit=20&after=$SINCE" | python3 -c "import sys,json; d=json.load(sys.stdin); print(len(d) if isinstance(d,list) else 0)" 2>/dev/null)
JAZZY_ORDERS=$(curl -s -H "APCA-API-KEY-ID: $JAZZY_KEY" -H "APCA-API-SECRET-KEY: $JAZZY_SEC" "https://paper-api.alpaca.markets/v2/orders?status=all&limit=20&after=$SINCE" | python3 -c "import sys,json; d=json.load(sys.stdin); print(len(d) if isinstance(d,list) else 0)" 2>/dev/null)

# Sidecar freshness
SIDECAR=/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json
if [ -f "$SIDECAR" ]; then
  SIDECAR_AGE=$(( ($(date +%s) - $(stat -L -c %Y "$SIDECAR")) / 60 ))
  SIDECAR_CNT=$(python3 -c "import json; d=json.load(open('$SIDECAR')); print(len(d))" 2>/dev/null)
else
  SIDECAR_AGE="?"; SIDECAR_CNT="?"
fi

COLOR=3066993  # green
[ "$BOBA_ORDERS" = "0" ] && COLOR=15105570  # orange — boba quiet

curl -s -H "Content-Type: application/json" -X POST "$WEBHOOK" -d @- <<JSON
{"username":"Morning Check","embeds":[{"title":"Boba+Jazzy AM Status — $TODAY","description":"Run at $NOW","color":$COLOR,"fields":[
{"name":"Boba","value":"runs: $BOBA_RUNS\nno-fresh: $BOBA_NOSIG\npicked: $BOBA_PICKED\norders today: **$BOBA_ORDERS**","inline":true},
{"name":"Jazzy","value":"runs: $JAZZY_RUNS\npicked: $JAZZY_PICKED\norders today: **$JAZZY_ORDERS**","inline":true},
{"name":"Sidecar","value":"entries: $SIDECAR_CNT\nage: ${SIDECAR_AGE}min","inline":true}
]}]}
JSON
echo "morning check fired at $NOW"
