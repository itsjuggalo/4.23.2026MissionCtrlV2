#!/usr/bin/env bash
# ainvest_second_opinion.sh — independent AInvest-copilot read on a ticker.
#
# D4 value-add #4, ALERT-ONLY tier (per memory feedback_live_trader_change_protocol:
# wiring this INTO the live decision cycle is trade-changing = staged + Mike-gated.
# This standalone is safe: it only READS and prints/pushes a verdict. It does NOT
# place, size, or gate any trade.
#
# Usage:
#   ainvest_second_opinion.sh NVDA                 # print verdict
#   ainvest_second_opinion.sh NVDA --tg            # also push to Mike's Telegram DM
#   echo '{"symbol":"NVDA","side":"call","thesis":"flow sweep"}' | \
#       ainvest_second_opinion.sh --stdin --tg     # pre-trade confirm on a pick
#
# Intended hook (for Mike to wire when ready, NOT wired here):
#   In a decision cycle, before committing a pick, call this with the pick JSON and
#   treat a "DISAGREE" verdict as a soft veto / size-down signal. Keep it advisory.
set -uo pipefail

SECRETS="$HOME/.openclaw/secrets"
LOG="$HOME/.openclaw/workspace/logs/ainvest_second_opinion.log"
mkdir -p "$(dirname "$LOG")"
NVM_BIN="$(ls -d "$HOME"/.nvm/versions/node/*/bin 2>/dev/null | sort -V | tail -1)"
export PATH="$NVM_BIN:$HOME/.local/bin:/usr/local/bin:/usr/bin:/bin:$PATH"
CLAUDE_BIN="$HOME/.local/bin/claude"
MODEL="${SECOND_OPINION_MODEL:-sonnet}"
TOOLS="Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"

log() { echo "[$(TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET')] $*" >> "$LOG"; }

PUSH_TG=0; USE_STDIN=0; TICKER=""
for a in "$@"; do
  case "$a" in
    --tg) PUSH_TG=1 ;;
    --stdin) USE_STDIN=1 ;;
    -*) ;;                      # ignore other flags
    *) TICKER="$a" ;;
  esac
done

if [[ "$USE_STDIN" == 1 ]]; then
  PICK="$(cat)"
  ASK="/ainvest Independent pre-trade second opinion on this proposed pick (JSON below). \
I already have a thesis — your job is to AGREE or DISAGREE as a skeptic, not to cheerlead. \
Check: does price action / flow / catalyst support the side? what's the strongest reason NOT to take it? \
Give: VERDICT (AGREE / DISAGREE / AGREE-BUT-SIZE-DOWN), one-line why, the level that proves it wrong. \
<= 12 lines. Local sources only, no mcp__ainvest tools.

Pick: $PICK"
  LABEL="pre-trade confirm"
elif [[ -n "$TICKER" ]]; then
  ASK="/ainvest Independent second-opinion read on $TICKER as a skeptic. \
Is there an edge here right now, long or short? What's the strongest reason to stand aside? \
Give VERDICT (BUY-watch / HOLD / AVOID), one-line why, the level that flips it. \
<= 12 lines. Local sources only, no mcp__ainvest tools."
  LABEL="$TICKER"
else
  echo "usage: $0 <TICKER> [--tg] | $0 --stdin [--tg]" >&2; exit 2
fi

log "=== second opinion: $LABEL ==="
RESULT_JSON="$(cd "$HOME" && "$CLAUDE_BIN" -p "$ASK" --model "$MODEL" \
  --output-format json --allowedTools "$TOOLS" 2>>"$LOG")"
TEXT="$(printf '%s' "$RESULT_JSON" | python3 -c 'import json,sys; print((json.load(sys.stdin).get("result") or "").strip())' 2>>"$LOG")"
[[ -z "$TEXT" ]] && { log "empty result — abort"; echo "[second-opinion] empty result" >&2; exit 1; }

echo "$TEXT"

if [[ "$PUSH_TG" == 1 ]]; then
  TOKEN="$(cat "$SECRETS/telegram_antigravity_bot_token" 2>/dev/null)"
  CHAT="$(cat "$SECRETS/telegram-chat-id.txt" 2>/dev/null)"
  if [[ -n "$TOKEN" && -n "$CHAT" ]]; then
    MSG="🧭 *2nd opinion — $LABEL* ($(TZ='America/New_York' date '+%-I:%M %p ET'))"$'\n\n'"$TEXT"
    python3 - "$TOKEN" "$CHAT" "$MSG" <<'PY' >>"$LOG" 2>&1
import sys, requests
token, chat, msg = sys.argv[1:4]
for i in range(0, len(msg), 4000):
    requests.post(f"https://api.telegram.org/bot{token}/sendMessage",
                  json={"chat_id": chat, "text": msg[i:i+4000]}, timeout=15)
PY
    log "pushed to Telegram $CHAT"
  fi
fi
log "=== done: $LABEL ==="
