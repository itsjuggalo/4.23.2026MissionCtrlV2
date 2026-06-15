#!/bin/bash
# Hermes — watches Kronos cache freshness, alerts if stale
export PATH=/usr/local/bin:/usr/bin:/bin
WEBHOOK=$(cat /home/ubuntu/.openclaw/secrets/discord_webhook_autofix)
CACHE_DIR=/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts
NOW=$(date +%s)
STALE_LIMIT=1800  # 30 min
STALE_LIST=""
FRESH_COUNT=0
STALE_COUNT=0
if [ ! -d "$CACHE_DIR" ]; then
  curl -s -X POST -H "Content-Type: application/json" "$WEBHOOK" -d '{"username":"Hermes","content":"⚠️ Kronos cache dir missing"}' >/dev/null
  exit 1
fi
for f in "$CACHE_DIR"/latest_*.json; do
  [ -f "$f" ] || continue
  mtime=$(stat -L -c %Y "$f")
  age=$((NOW - mtime))
  ticker=$(basename "$f" .json | sed 's/latest_//')
  if [ "$age" -gt "$STALE_LIMIT" ]; then
    STALE_LIST="$STALE_LIST $ticker(${age}s)"
    STALE_COUNT=$((STALE_COUNT + 1))
  else
    FRESH_COUNT=$((FRESH_COUNT + 1))
  fi
done
if [ "$STALE_COUNT" -gt 0 ]; then
  # Visual card first (as Hermes); fall back to the text embed on any failure.
  if ! /home/itsju/.venv/bin/python3 /home/itsju/05_AUTOMATION/scripts/hermes/kronos_stale_card.py; then
    curl -s -X POST -H "Content-Type: application/json" "$WEBHOOK" -d "{\"username\":\"Hermes\",\"embeds\":[{\"title\":\"⚠️ Kronos cache stale\",\"description\":\"$STALE_COUNT stale, $FRESH_COUNT fresh\\nStale:$STALE_LIST\",\"color\":15105570}]}" >/dev/null
  fi
fi
echo "[$(TZ=America/New_York date '+%H:%M ET')] hermes: $FRESH_COUNT fresh, $STALE_COUNT stale" >> /tmp/hermes.log
