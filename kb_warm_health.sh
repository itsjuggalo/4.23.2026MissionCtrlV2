#!/usr/bin/env bash
# kb_warm_health.sh — guard the warm multi-KB server (:8095) that claudeclaw's
# crown-jewel KBs (ClayTrader / Erik Dalton / Vibe) hit for ~1s answers. If it
# dies, claudeclaw silently falls back to the ~40-54s cold query.py spawn — slow
# but not broken, so nobody notices. This makes a dead server LOUD and self-heals.
#
# Behavior: probe /health; if unhealthy, auto-restart the PM2 app once, re-probe,
# then alert (Discord + Telegram). Edge-triggered via a state file so a sustained
# outage doesn't spam, and recovery is announced once. Safe to run from cron.
# Added 2026-06-15 (DB-overhaul "keep all databases helpful" thrust).
set -uo pipefail

URL="http://127.0.0.1:8095/health"
APP="kb-server"
SECRETS="$HOME/.openclaw/secrets"
WEBHOOK_FILE="$SECRETS/discord_pipeline_alerts_webhook"
STATE="/tmp/kb_warm_health.state"   # holds "down" while in a known-bad streak
LOG="$HOME/logs/kb_warm_health.log"
mkdir -p "$HOME/logs"

ts() { TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET'; }
log() { echo "$(ts) | $*" >> "$LOG"; }

alert() {
  local msg="$1"
  if [[ -f "$WEBHOOK_FILE" ]]; then
    local wh; wh=$(cat "$WEBHOOK_FILE")
    curl -s -m 10 -X POST "$wh" -H 'Content-Type: application/json' \
      -H 'User-Agent: kb-warm-health/1.0' \
      -d "{\"content\": $(printf '%s' "$msg" | python3 -c 'import json,sys; print(json.dumps(sys.stdin.read()))')}" >/dev/null 2>&1
  fi
  "$HOME/bin/tg-send-msg" "$msg" >/dev/null 2>&1 || true
}

# probe: healthy iff HTTP 200 AND status=ok AND model_loaded=true
probe() {
  local body; body=$(curl -s -m 6 "$URL" 2>/dev/null) || return 1
  printf '%s' "$body" | python3 -c '
import json,sys
try:
    d=json.load(sys.stdin)
    sys.exit(0 if d.get("status")=="ok" and d.get("model_loaded") else 1)
except Exception:
    sys.exit(1)
' 2>/dev/null
}

if probe; then
  # healthy now — if we were previously down, announce recovery once
  if [[ -f "$STATE" ]]; then
    rm -f "$STATE"
    log "RECOVERED"
    alert ":green_circle: **KB warm-server (:8095) recovered** — crown-jewel KBs back on the ~1s fast path."
  fi
  exit 0
fi

# unhealthy — try one self-heal before alerting
log "DOWN — probe failed; attempting pm2 restart $APP"
pm2 restart "$APP" --update-env >/dev/null 2>&1
sleep 6

if probe; then
  log "self-healed via pm2 restart"
  # only shout if this is a fresh incident (avoid noise on a flapping server)
  if [[ ! -f "$STATE" ]]; then
    alert ":yellow_circle: **KB warm-server (:8095) had died — auto-restarted, now OK.** (claudeclaw was on the slow query.py fallback meanwhile.)"
  fi
  rm -f "$STATE"
  exit 0
fi

# still down after restart — sustained outage; alert once per incident
if [[ ! -f "$STATE" ]]; then
  echo "down" > "$STATE"
  log "STILL DOWN after restart — alerting"
  alert ":red_circle: **KB warm-server (:8095) DOWN and restart failed.** claudeclaw KBs are on the ~50s cold fallback. Check: pm2 logs $APP --lines 50"
else
  log "STILL DOWN (already alerted this incident)"
fi
exit 1
