#!/bin/bash
# heartbeat-check.sh — Zero-token replacement for OpenClaw heartbeat
# Runs every 30 minutes via cron, sends Telegram alerts only when needed

TG_TOKEN=$(cat /home/ubuntu/.openclaw/secrets/telegram-bot-token.txt 2>/dev/null)
TG_CHAT=$(cat /home/ubuntu/.openclaw/secrets/telegram-chat-id.txt 2>/dev/null)
LOG="/tmp/heartbeat-check.log"

send_alert() {
    local msg="$1"
    echo "$(date '+%Y-%m-%d %H:%M:%S') — $msg" >> "$LOG"
    if [ -n "$TG_TOKEN" ] && [ -n "$TG_CHAT" ]; then
        curl -s -X POST "https://api.telegram.org/bot${TG_TOKEN}/sendMessage" \
            -d chat_id="${TG_CHAT}" \
            -d text="$msg" \
            -d parse_mode="HTML" > /dev/null 2>&1
    fi
}

# === 1. PM2 Process Health ===
DOWN_PROCS=$(pm2 jlist 2>/dev/null | python3 -c "
import sys, json
procs = json.load(sys.stdin)
down = [p['name'] for p in procs if p['pm2_env']['status'] != 'online']
if down: print(', '.join(down))
" 2>/dev/null)

if [ -n "$DOWN_PROCS" ]; then
    send_alert "🔴 PM2 processes down: $DOWN_PROCS"
fi

# === 2. Skill Scheduler Health ===
SCHED_STATUS=$(pm2 jlist 2>/dev/null | python3 -c "
import sys, json
procs = json.load(sys.stdin)
for p in procs:
    if p['name'] == 'skill-scheduler':
        print(p['pm2_env']['status'])
        break
else:
    print('missing')
" 2>/dev/null)

if [ "$SCHED_STATUS" != "online" ]; then
    send_alert "⚠️ skill-scheduler is $SCHED_STATUS — restarting"
    pm2 restart skill-scheduler 2>/dev/null
fi

# === 3. Dashboard Health ===
HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" --max-time 10 http://localhost:3033)
if [ "$HTTP_CODE" != "200" ]; then
    send_alert "🔴 Dashboard down (HTTP $HTTP_CODE) — restarting"
    cd /home/ubuntu/mission-control-restored
    pm2 restart mission-control 2>/dev/null
fi

# === 4. Scraper Health ===
SCRAPER_STATUS=$(cat /home/ubuntu/mission-control-restored/Option-Signals-Scraper/data/_scraper_status.json 2>/dev/null | python3 -c "
import sys, json
from datetime import datetime, timedelta
d = json.load(sys.stdin)
last = datetime.fromisoformat(d.get('last_run', '2000-01-01T00:00:00'))
if datetime.now() - last > timedelta(minutes=15):
    print('stale')
else:
    print('ok')
" 2>/dev/null)

if [ "$SCRAPER_STATUS" = "stale" ]; then
    send_alert "⚠️ Option Signals scraper stale — last run >15min ago"
fi

# === 5. Portfolio P&L Check ===
python3 << 'PYCHECK' 2>/dev/null
import json, os

pf = "/home/ubuntu/.openclaw/workspace/skill_outputs/boba/portfolio-manager.json"
if os.path.exists(pf):
    with open(pf) as f:
        data = json.load(f)
    pnl_pct = data.get("pnl_percent", 0)
    if abs(pnl_pct) > 3:
        print(f"ALERT:portfolio_pnl:{pnl_pct}")
PYCHECK

PNL_ALERT=$(python3 << 'PYCHECK2' 2>/dev/null
import json, os
pf = "/home/ubuntu/.openclaw/workspace/skill_outputs/boba/portfolio-manager.json"
if os.path.exists(pf):
    with open(pf) as f:
        data = json.load(f)
    pnl_pct = data.get("pnl_percent", 0)
    if abs(pnl_pct) > 3:
        print(f"📊 Portfolio P&L alert: {pnl_pct:+.1f}%")
PYCHECK2
)

if [ -n "$PNL_ALERT" ]; then
    send_alert "$PNL_ALERT"
fi

# === 6. Fear & Greed Check ===
FG_ALERT=$(python3 << 'FGCHECK' 2>/dev/null
import json, os
sf = "/home/ubuntu/.openclaw/workspace/skill_outputs/shared/sentiment-pulse.json"
if os.path.exists(sf):
    with open(sf) as f:
        data = json.load(f)
    fg = data.get("fear_greed", 50)
    if fg < 20:
        print(f"😱 Extreme Fear: Fear & Greed Index at {fg}")
    elif fg > 80:
        print(f"🤑 Extreme Greed: Fear & Greed Index at {fg}")
FGCHECK
)

if [ -n "$FG_ALERT" ]; then
    send_alert "$FG_ALERT"
fi

# === 7. Crash Loop Detection ===
RESTARTS=$(pm2 jlist 2>/dev/null | python3 -c "
import sys, json
procs = json.load(sys.stdin)
high = [(p['name'], p['pm2_env']['restart_time']) for p in procs if p['pm2_env']['restart_time'] > 20]
if high:
    print(', '.join(f\"{n}({r})\" for n, r in high))
" 2>/dev/null)

if [ -n "$RESTARTS" ]; then
    send_alert "🔴 Crash loop detected: $RESTARTS"
fi

# Silent success — no output means everything is fine
