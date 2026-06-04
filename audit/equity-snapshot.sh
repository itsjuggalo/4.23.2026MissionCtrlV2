#!/usr/bin/env bash
# equity-snapshot.sh — record the dashboard's portfolio equity into /api/equity-history.
# Robust replacement for the old inline cron one-liner that failed with "Unexpected end of
# JSON input" when the dashboard was mid-restart (timeouts + JSON guard added).
set -uo pipefail
API="http://localhost:3000"

raw="$(curl -s --max-time 10 "$API/api/portfolio" 2>/dev/null)"
body="$(printf '%s' "$raw" | python3 -c '
import json, sys
try:
    p = json.load(sys.stdin)
except Exception:
    sys.exit(3)   # empty/partial response (dashboard restarting) — skip this tick
print(json.dumps({
    "equity": float(p.get("equity", 0) or 0),
    "cash": float(p.get("cash", 0) or 0),
    "buying_power": float(p.get("buying_power", 0) or 0),
    "daily_pnl": float(p.get("day_pl", 0) or 0),
    "daily_pnl_pct": float(p.get("day_pl_pct", 0) or 0),
    "total_return_pct": float(p.get("pl_pct", 0) or 0),
    "positions": p.get("positions", []),
}))' 2>/dev/null)" || { echo "[$(date)] skip — portfolio API not ready"; exit 0; }

[ -z "$body" ] && { echo "[$(date)] skip — empty portfolio payload"; exit 0; }

curl -s --max-time 10 -X POST "$API/api/equity-history" \
     -H 'Content-Type: application/json' -d "$body" >/dev/null \
  && echo "[$(date)] equity snapshot recorded" \
  || echo "[$(date)] POST failed"
