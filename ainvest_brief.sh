#!/usr/bin/env bash
# ainvest_brief.sh — proactive AInvest-copilot brief, 2x/day to Telegram.
#
#   morning  : premarket watchlist read (catalysts, analyst moves, overnight)
#   eod      : end-of-day wrap (what moved, what to watch tomorrow)
#
# Pipeline (clones flow_digest_cron.sh, the proven headless pattern):
#   1. claude -p "/ainvest <brief prompt>"  — SUBSCRIPTION CLI, model sonnet,
#      cwd=$HOME + --allowedTools (the proven offline-resilience fix; running
#      from /tmp or with no tool allowlist = permission-blocked, see memory
#      project-ainvest-copilot-build).
#   2. send   : Telegram DM to Mike via antigravity bot token.
#   3. feed   : write the brief markdown into ~/mc-kb/notes/briefs/ so Boba/Jazzy
#      recall it via the hive-mind (D4 value-add #3). Cheap — no reindex call;
#      the existing mc-kb reindex schedule absorbs new corpus files.
#
# Usage:  ainvest_brief.sh morning|eod        (FORCE=1 to bypass the time gate)
# Runs on the LAPTOP HUB where the Claude subscription is logged in.
set -uo pipefail

MODE="${1:-morning}"
SECRETS="$HOME/.openclaw/secrets"
BRIEF_DIR="$HOME/mc-kb/notes/briefs"
LOG="$HOME/.openclaw/workspace/logs/ainvest_brief.log"
mkdir -p "$BRIEF_DIR" "$(dirname "$LOG")"

# --- harden PATH for cron's minimal env (claude lives under nvm) --------------
NVM_BIN="$(ls -d "$HOME"/.nvm/versions/node/*/bin 2>/dev/null | sort -V | tail -1)"
export PATH="$NVM_BIN:$HOME/.local/bin:/usr/local/bin:/usr/bin:/bin:$PATH"
CLAUDE_BIN="$HOME/.local/bin/claude"
MODEL="${AINVEST_BRIEF_MODEL:-sonnet}"
# read-only analysis surface (same allowlist the antigravity bot uses)
TOOLS="Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"

log() { echo "[$(TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET')] $*" | tee -a "$LOG"; }

# --- weekday gate (skip weekends unless FORCE) --------------------------------
if [[ "${FORCE:-0}" != "1" ]]; then
  DOW=$(TZ='America/New_York' date +%u)
  (( DOW > 5 )) && { log "weekend — skip"; exit 0; }
fi

# --- watchlist (override via $SECRETS/ainvest_watchlist.txt, one symbol/line) --
if [[ -f "$SECRETS/ainvest_watchlist.txt" ]]; then
  WATCH="$(grep -vE '^\s*#|^\s*$' "$SECRETS/ainvest_watchlist.txt" | tr '\n' ' ')"
else
  WATCH="NVDA AAPL TSLA MU LLY HOOD SPY"   # default; from portfolio-watcher set
fi
log "=== $MODE brief start (watchlist: $WATCH) ==="

# --- build the mode-specific prompt -------------------------------------------
if [[ "$MODE" == "morning" ]]; then
  ASK="/ainvest Morning premarket brief for my watchlist: $WATCH. \
For each name flag only what's ACTIONABLE today: earnings/dividends inside 2 days, \
analyst rating changes, overnight catalysts/news, and any premarket gap. \
Lead with the single most important thing across the whole list. \
Skip names with nothing actionable. Verdict-first, ADHD-friendly, <= 25 lines, \
no tables wider than a phone. Do not use mcp__ainvest tools — local sources only."
else
  ASK="/ainvest End-of-day wrap for my watchlist: $WATCH. \
What actually moved today and why (catalyst vs noise), what changed in the setup, \
and the ONE thing to watch at tomorrow's open per name that warrants it. \
Lead with the day's biggest signal. Skip quiet names. Verdict-first, <= 25 lines. \
Do not use mcp__ainvest tools — local sources only."
fi

# --- 1. interpret via Claude Code subscription CLI ----------------------------
RESULT_JSON="$(cd "$HOME" && "$CLAUDE_BIN" -p "$ASK" --model "$MODEL" \
  --output-format json --allowedTools "$TOOLS" 2>>"$LOG")"
if [[ -z "$RESULT_JSON" ]]; then
  log "claude -p returned empty — abort (is the CLI logged in?)"; exit 1
fi
TEXT="$(printf '%s' "$RESULT_JSON" | python3 -c 'import json,sys; print((json.load(sys.stdin).get("result") or "").strip())' 2>>"$LOG")"
COST="$(printf '%s' "$RESULT_JSON" | python3 -c 'import json,sys; print(json.load(sys.stdin).get("total_cost_usd",""))' 2>/dev/null)"
if [[ -z "$TEXT" ]]; then
  log "empty result text — abort"; exit 1
fi
log "brief generated (${#TEXT} chars, \$${COST})"

# --- 2. send to Telegram DM (aime_research bot) -------------------------------
# vault-first token (single source of truth); falls back to the flat secret file
TOKEN="$(/home/itsju/.venv/bin/python /home/itsju/scripts/tg_fleet.py token aime_research 2>/dev/null)"
TOKEN="${TOKEN:-$(cat "$SECRETS/telegram_antigravity_bot_token" 2>/dev/null)}"
CHAT="$(cat "$SECRETS/telegram-chat-id.txt" 2>/dev/null)"
HEADER="$([[ "$MODE" == morning ]] && echo '🌅 *AInvest morning brief*' || echo '🌇 *AInvest EOD wrap*') — $(TZ='America/New_York' date '+%a %b %-d, %-I:%M %p ET')"
if [[ -n "$TOKEN" && -n "$CHAT" ]]; then
  # Telegram caps at 4096 chars/msg; chunk if needed.
  MSG="$HEADER"$'\n\n'"$TEXT"
  python3 - "$TOKEN" "$CHAT" "$MSG" <<'PY' >>"$LOG" 2>&1
import sys, requests
token, chat, msg = sys.argv[1], sys.argv[2], sys.argv[3]
for i in range(0, len(msg), 4000):
    r = requests.post(f"https://api.telegram.org/bot{token}/sendMessage",
                      json={"chat_id": chat, "text": msg[i:i+4000]}, timeout=15)
    if not r.ok:
        print(f"telegram send failed {r.status_code}: {r.text[:200]}")
PY
  log "sent to Telegram DM $CHAT"
else
  log "WARN: telegram token/chat missing — printed only"; echo "$HEADER"$'\n\n'"$TEXT"
fi

# --- 3. hive-mind feed: write brief md into mc-kb corpus -----------------------
DATESTAMP="$(TZ='America/New_York' date '+%Y-%m-%d')"
BRIEF_FILE="$BRIEF_DIR/ainvest-${MODE}-${DATESTAMP}.md"
{
  echo "---"
  echo "name: ainvest-${MODE}-brief-${DATESTAMP}"
  echo "description: AInvest ${MODE} watchlist brief for ${DATESTAMP} (auto-generated)"
  echo "metadata:"
  echo "  type: reference"
  echo "  source: ainvest_brief.sh"
  echo "---"
  echo
  echo "# AInvest ${MODE} brief — ${DATESTAMP} ET"
  echo
  echo "Watchlist: ${WATCH}"
  echo
  echo "$TEXT"
} > "$BRIEF_FILE"
log "hive-mind feed written: $BRIEF_FILE (mc-kb reindex will absorb it)"
log "=== $MODE brief done ==="
