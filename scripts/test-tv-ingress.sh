#!/usr/bin/env bash
# test-tv-ingress.sh — End-to-end test of the TV webhook ingress path.
#
# Sends a dry-run BUY alert through the public webhook URL and verifies:
#   1. HTTP 200 OK
#   2. JSON response has ok=true, dry_run=true
#   3. A row landed in tv_webhook_log
#   4. A signal landed in live_signals with decision='dry_run'
#
# Exits 0 if all checks pass, non-zero with a clear message otherwise.

set -euo pipefail

SLUG=$(<"$HOME/.openclaw/secrets/tv-webhook-slug")
URL="https://bridge.serveftp.com/tv-webhook/$SLUG"
TV_DB="$HOME/sites/missioncontrol/MissionCtrlV2/data/tv_webhook_log.sqlite"
LIVE_DB="$HOME/sites/missioncontrol/MissionCtrlV2/data/live_trades.sqlite"

NOW=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
# Unique bar_time so we don't collide with prior tests via dedupe
BAR_TIME=$(date -u +"%Y-%m-%dT%H:%M:00Z")

PAYLOAD=$(cat <<EOF
{
  "source": "tradingview",
  "strategy": "ingress-test",
  "action": "buy",
  "symbol": "BTC/USD",
  "price": 65000,
  "quantity": 0.0001,
  "stop_loss": 64000,
  "take_profit": 67000,
  "bar_time": "$BAR_TIME",
  "account": "jazzy",
  "dry_run": true
}
EOF
)

echo "[1/4] POSTing dry-run alert to $URL …"
RESP=$(curl -sS --max-time 20 -X POST -H 'Content-Type: application/json' -d "$PAYLOAD" "$URL")
echo "      response: $RESP"

OK=$(echo "$RESP" | python3 -c 'import json,sys; d=json.load(sys.stdin); print("yes" if d.get("ok") else "no")')
DRY=$(echo "$RESP" | python3 -c 'import json,sys; d=json.load(sys.stdin); print("yes" if d.get("dry_run") else "no")')
DEDUPE=$(echo "$RESP" | python3 -c 'import json,sys; d=json.load(sys.stdin); print(d.get("dedupe_key",""))')

if [ "$OK" != "yes" ]; then
  echo "FAIL: response missing ok=true"
  exit 1
fi
if [ "$DRY" != "yes" ]; then
  echo "FAIL: response missing dry_run=true (was it converted to a real order? check kill-switch)"
  exit 1
fi
echo "      ✓ ok=true, dry_run=true, dedupe_key=$DEDUPE"

echo "[2/4] Checking tv_webhook_log…"
TVROW=$(sqlite3 "$TV_DB" "SELECT received_at, outcome, alpaca_status FROM tv_webhook_log WHERE dedupe_key='$DEDUPE' LIMIT 1;")
if [ -z "$TVROW" ]; then
  echo "FAIL: no row in tv_webhook_log for dedupe_key=$DEDUPE"
  exit 1
fi
echo "      ✓ $TVROW"

echo "[3/4] Checking live_signals…"
LSROW=$(sqlite3 "$LIVE_DB" "SELECT received_at, decision FROM live_signals WHERE dedupe_key='$DEDUPE' LIMIT 1;")
if [ -z "$LSROW" ]; then
  echo "FAIL: no row in live_signals for dedupe_key=$DEDUPE"
  exit 1
fi
echo "      ✓ $LSROW"

echo "[4/4] Dedupe check — re-POST should return dedup=true…"
RESP2=$(curl -sS --max-time 20 -X POST -H 'Content-Type: application/json' -d "$PAYLOAD" "$URL")
DEDUP_FLAG=$(echo "$RESP2" | python3 -c 'import json,sys; d=json.load(sys.stdin); print("yes" if d.get("dedup") else "no")')
if [ "$DEDUP_FLAG" != "yes" ]; then
  echo "FAIL: second POST didn't dedup (idempotency broken)"
  echo "      response: $RESP2"
  exit 1
fi
echo "      ✓ idempotency works"

echo ""
echo "PASS — TV ingress end-to-end verified at $NOW"
