#!/bin/bash
HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" --max-time 10 http://localhost:3033)

if [ "$HTTP_CODE" != "200" ]; then
    echo "$(date) — Gateway down (HTTP $HTTP_CODE), restarting..." >> /tmp/gateway-watchdog.log
    cd /home/ubuntu/mission-control-restored
    pm2 restart mission-control 2>/dev/null || PORT=3033 pm2 start npm --name "mission-control" --max-memory-restart 300M -- start
    echo "$(date) — Restart attempted" >> /tmp/gateway-watchdog.log
fi
