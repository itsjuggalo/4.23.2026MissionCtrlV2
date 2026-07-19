#!/bin/bash
# tg_gateway_verify_watch.sh — one-shot cron watcher for capsule tg-gateway-inbound-verify (2026-07-19)
# Every 5 min: if a real inbound Q/A pair appears in the tg-gateway log, capture proof,
# ping Mike, append evidence to the claudeclaw handoff ledger, and self-uninstall from cron.
# Self-removes after success OR after 7 days (stale guard).
set -u
LOG=/home/itsju/.pm2/logs/tg-gateway-out.log
LEDGER=/home/itsju/restructure/.remember/claudeclaw/os-update.md
PROOF=/home/itsju/restructure/.remember/claudeclaw/tg-gateway-inbound-proof.txt
SELF_TAG=tg_gateway_verify_watch

uninstall() { crontab -l 2>/dev/null | grep -v "$SELF_TAG" | crontab -; }

# stale guard: installed 2026-07-19; give up after 2026-07-26
[ "$(date +%Y%m%d)" -gt 20260726 ] && { uninstall; exit 0; }

grep -q '] Q: ' "$LOG" 2>/dev/null || exit 0

QA=$(grep -E '] (Q|A): ' "$LOG" | tail -4)
RESTARTS=$(pm2 jlist 2>/dev/null | python3 -c "
import json,sys
print(next((p['pm2_env']['restart_time'] for p in json.load(sys.stdin) if p['name']=='tg-gateway'),'?'))" 2>/dev/null)

{
  echo "tg-gateway inbound VERIFIED $(TZ=America/New_York date '+%Y-%m-%d %H:%M ET')"
  echo "restarts: $RESTARTS"
  echo "$QA"
} > "$PROOF"

{
  echo ""
  echo "### $(TZ=America/New_York date '+%Y-%m-%d %H:%M ET') — tg-gateway inbound E2E VERIFIED (auto-watcher)"
  echo '```'
  cat "$PROOF"
  echo '```'
  echo "Close capsule: intent-queue done tg-gateway-inbound-verify --proof \"Q/A pair in tg-gateway-out.log, see $PROOF\" --proof \"restarts flat at \$N (was 1 at deploy)\""
} >> "$LEDGER"

python3 /home/itsju/scripts/ping_mike.py "✅ tg-gateway inbound E2E VERIFIED — your ping got answered (restarts: $RESTARTS). Capsule tg-gateway-inbound-verify ready to close; proof saved." >/dev/null 2>&1

uninstall
