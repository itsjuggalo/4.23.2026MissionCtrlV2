#!/usr/bin/env bash
# mc-fix-agent.sh
# Reads latest audit report, applies quick fixes, then invokes Claude Code
# to repair code-level issues. Verifies via /api/health and alerts Discord.

set -euo pipefail

AUDIT_FILE="$HOME/scripts/audit/latest_audit.json"
FIX_LOG="$HOME/scripts/audit/fix_log.txt"
LOCK_FILE="$HOME/scripts/audit/.fix-agent.lock"

# Prevent concurrent fix runs
exec 9>"$LOCK_FILE"
flock -n 9 || {
  echo "[mc-fix-agent] $(date -u +%Y-%m-%dT%H:%M:%SZ) Already running — skipping." | tee -a "$FIX_LOG"
  exit 0
}
SRC="/home/itsju/01_ACTIVE/sites/missioncontrol/MissionCtrlV2/src"
BASE_URL="http://localhost:3000"
DISCORD_SECRET="$HOME/.openclaw/secrets/discord_bobatrades_webhook"

log() { echo "[mc-fix-agent] $(date -u +%Y-%m-%dT%H:%M:%SZ) $*" | tee -a "$FIX_LOG"; }
discord() {
  local msg="$1"
  local webhook; webhook=$(cat "$DISCORD_SECRET" 2>/dev/null || echo "")
  [ -z "$webhook" ] && return 0
  # Use jq to build JSON so special chars in $msg can't break the payload
  local payload; payload=$(jq -n --arg content "$msg" '{"content": $content}')
  curl -s -X POST "$webhook" \
    -H "Content-Type: application/json" \
    -d "$payload" > /dev/null 2>&1 || true
}

if [ ! -f "$AUDIT_FILE" ]; then
  log "No audit file found at $AUDIT_FILE — skipping."
  exit 0
fi

ISSUE_COUNT=$(jq -r '.issues | length' "$AUDIT_FILE" 2>/dev/null || echo "0")
if [ "$ISSUE_COUNT" -eq 0 ]; then
  log "No issues in audit report — nothing to fix."
  exit 0
fi

log "Found $ISSUE_COUNT issue(s). Starting repair sequence..."
discord "⚠️ MC Auto-Heal: detected $ISSUE_COUNT issue(s) — running repairs..."

# ── Phase 1: Quick fixes ────────────────────────────────────────────────────

# Restart any crashed/stopped PM2 processes (use jlist JSON to avoid column-parse fragility)
PM2_JSON=$(pm2 jlist 2>/dev/null || echo "[]")
CRASHED=$(echo "$PM2_JSON" \
  | jq -r 'if type == "array" then .[] | select(.pm2_env.status == "errored" or .pm2_env.status == "stopped") | .name else empty end' \
  2>/dev/null | grep -v '^$' || true)
if [ -n "$CRASHED" ]; then
  log "Restarting crashed PM2 processes: $CRASHED"
  echo "$CRASHED" | xargs -I{} pm2 restart {} 2>/dev/null || true
fi

# Clear OHLC cache if stale pairs are listed
STALE_PAIRS=$(jq -r '.issues[] | select(.endpoint == "/api/health") | .detail' "$AUDIT_FILE" 2>/dev/null || echo "")
if echo "$STALE_PAIRS" | grep -q "stale"; then
  OHLC_DIR="/home/itsju/01_ACTIVE/sites/missioncontrol/MissionCtrlV2/data/ohlc_cache"
  if [ -d "$OHLC_DIR" ]; then
    log "Clearing stale OHLC cache..."
    find "$OHLC_DIR" -name "*.json" -mmin +120 -delete 2>/dev/null || true
  fi
fi

# ── Phase 1b: Auth-failure fast-path (skip Claude, just alert) ──────────────
# Alpaca 401/403 = key rotation needed, Claude can't fix that
AUTH_ISSUES=$(jq -r '.issues[] | select(.detail | test("auth_failed|401|403|Unauthorized|Forbidden")) | .endpoint' "$AUDIT_FILE" 2>/dev/null || echo "")
if [ -n "$AUTH_ISSUES" ]; then
  log "Auth failure detected on: $AUTH_ISSUES — skipping Claude repair, alerting only."
  discord "🔑 MC Auth Alert: Alpaca key may be invalid on $AUTH_ISSUES — check ~/.openclaw/secrets/"
  # Strip auth issues from count so remaining issues still trigger Claude below
  ISSUE_COUNT=$(jq -r '[.issues[] | select(.detail | test("auth_failed|401|403|Unauthorized|Forbidden") | not)] | length' "$AUDIT_FILE" 2>/dev/null || echo "0")
  if [ "$ISSUE_COUNT" -eq 0 ]; then exit 0; fi
fi

# ── Phase 2: Claude Code repair ─────────────────────────────────────────────

AUDIT_JSON=$(cat "$AUDIT_FILE")
ISSUE_LIST=$(jq -r '.issues[] | "  - \(.type | ascii_upcase) \(.endpoint): \(.detail)"' "$AUDIT_FILE" 2>/dev/null)

PROMPT="You are the Mission Control autonomous repair agent.
Dashboard: Next.js 16 running at http://localhost:3000
Source tree: $SRC
Working directory: /home/itsju/01_ACTIVE/sites/missioncontrol/MissionCtrlV2

AUDIT REPORT ($(date -u)):
$ISSUE_LIST

Full JSON:
$AUDIT_JSON

REPAIR STEPS:
1. For each issue, read the relevant API route source: $SRC/app/api/<endpoint-name>/route.ts
2. Diagnose: stale cache, broken upstream (Firebase/Alpaca/serveftp), bad SQL, null fetch, etc.
3. Apply fix: edit source code, restart service, or clear cache as appropriate
4. For market data nulls (/api/market): check the fetch calls to external price APIs, fix any broken URL/key/timeout issues
5. For live-signals staleness: check if the upstream data pipeline is running (check PM2 status and logs)
6. After all fixes: run: curl -s http://localhost:3000/api/health
7. If health ok=true: post Discord success message and exit
8. Discord webhook URL: $(cat "$DISCORD_SECRET" 2>/dev/null || echo "NOT_SET")
9. Discord post format: POST JSON {\"content\": \"✅ MC Auto-Heal fixed: <bullet list of what was fixed>\"}

CONSTRAINTS:
- Only touch files in $SRC
- Do not modify package.json or next.config.ts
- If a fix requires restarting Next.js: run 'pm2 restart mission-control' or equivalent
- After each fix, verify with a curl to the affected endpoint before moving on
- Be surgical: one targeted fix per issue"

log "Invoking Claude Code for code-level repairs..."
echo "$PROMPT" | claude -p \
  --allowed-tools "Bash,Read,Edit,Write" \
  2>&1 | tee -a "$FIX_LOG"

# ── Phase 3: Verify ─────────────────────────────────────────────────────────

log "Verifying repairs via /api/health (waiting 8s for service to stabilise)..."
sleep 8
HEALTH="false"
for _try in 1 2 3; do
  HEALTH=$(curl -s --max-time 10 "$BASE_URL/api/health" 2>/dev/null || echo '{"ok":false}')
  HEALTH_OK=$(echo "$HEALTH" | jq -r '.ok' 2>/dev/null || echo "false")
  [ "$HEALTH_OK" = "true" ] && break
  sleep 5
done

if [ "$HEALTH_OK" = "true" ]; then
  log "Health check PASSED — all repairs successful."
  discord "✅ MC Auto-Heal complete: $ISSUE_COUNT issue(s) repaired. Health: OK"
else
  log "Health check FAILED after repairs — manual review needed."
  discord "🔴 MC Auto-Heal: repaired but health still failing. Check: http://localhost:3000/api/health"
fi

# Append to fix history
jq -n \
  --arg ts "$(date -u +%s)" \
  --arg iso "$(date -u +%Y-%m-%dT%H:%M:%SZ)" \
  --argjson audit "$AUDIT_JSON" \
  --arg health_ok "$HEALTH_OK" \
  '{fixed_at: $ts, iso: $iso, health_ok: $health_ok, audit: $audit}' \
  >> "$HOME/scripts/audit/fix_history.jsonl" 2>/dev/null || true

log "Done."
