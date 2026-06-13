#!/usr/bin/env bash
# breakout_cron.sh — run the large-cap breakout scanner, push fresh hits to Telegram.
#
# Pipeline:
#   1. scan : breakout_scanner.py  -> JSON of S&P 500 breakouts on rising volume
#   2. dedupe: skip tickers already alerted today (cooldown state file) unless RVOL
#             jumped materially — keeps the feed signal, not spam.
#   3. send : Telegram DM to Mike (antigravity bot), verdict-first compact list.
#   4. feed : append the scan to ~/mc-kb/notes/briefs/ for Boba/Jazzy hive-mind.
#
# Market-hours gate: Mon-Fri, only fires when called (cron at 12:30 + 15:50 ET).
# FORCE=1 bypasses the weekday/hours gate. Runs on the LAPTOP HUB.
set -uo pipefail

SECRETS="$HOME/.openclaw/secrets"
STATE="$HOME/.openclaw/data/breakout_seen.json"     # {date, sent:{TICKER:rvol}}
BRIEF_DIR="$HOME/mc-kb/notes/briefs"
LOG="$HOME/.openclaw/workspace/logs/breakout_scan.log"
mkdir -p "$(dirname "$STATE")" "$BRIEF_DIR" "$(dirname "$LOG")"

log() { echo "[$(TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET')] $*" | tee -a "$LOG"; }

# --- market-hours gate (ET) ---------------------------------------------------
if [[ "${FORCE:-0}" != "1" ]]; then
  DOW=$(TZ='America/New_York' date +%u); HHMM=$(TZ='America/New_York' date +%H%M)
  (( DOW > 5 )) && { log "weekend — skip"; exit 0; }
  if (( 10#$HHMM < 930 || 10#$HHMM > 1600 )); then log "outside 09:30-16:00 ET — skip"; exit 0; fi
fi

log "=== breakout scan start ==="
SCAN_JSON="$(python3 "$HOME/scripts/breakout_scanner.py" 2>>"$LOG")"
[[ -z "$SCAN_JSON" ]] && { log "scanner empty — abort"; exit 1; }

# --- dedupe + format via python (cooldown: re-alert only if RVOL +0.5 higher) -
read -r -d '' PYCODE <<'PY' || true
import json, os, sys
from datetime import datetime
import zoneinfo
scan = json.loads(os.environ["SCAN_JSON"])
state_path = os.environ["STATE"]
today = datetime.now(zoneinfo.ZoneInfo("America/New_York")).strftime("%Y-%m-%d")
try:
    st = json.load(open(state_path))
    if st.get("date") != today:
        st = {"date": today, "sent": {}}
except Exception:
    st = {"date": today, "sent": {}}
sent = st["sent"]
fresh = []
for h in scan.get("hits", []):
    sym, rvol = h["symbol"], h["rvol"]
    prev = sent.get(sym)
    if prev is None or rvol >= prev + 0.5:     # new, or volume materially hotter
        fresh.append(h); sent[sym] = rvol
st["sent"] = sent
json.dump(st, open(state_path, "w"))

if not fresh:
    print("NOFRESH"); sys.exit(0)

lines = []
for h in fresh:
    tags = []
    if h["near_52w_high"]: tags.append("ATH")
    if h["has_flow"]:      tags.append("🟢FLOW")
    tag = ("  " + " ".join(tags)) if tags else ""
    lines.append(f"• {h['symbol']}  ${h['close']}  +{h['pct_above_20d_high']}% over 20d-high  "
                 f"RVOL {h['rvol']}x{tag}")
total = scan.get("count", len(fresh))
print("MSG\t" + f"({len(fresh)} fresh of {total} breakouts • S&P 500 • rising volume)\n" + "\n".join(lines))
PY

OUT="$(SCAN_JSON="$SCAN_JSON" STATE="$STATE" python3 -c "$PYCODE" 2>>"$LOG")"
if [[ "$OUT" == "NOFRESH" || -z "$OUT" ]]; then
  log "no fresh breakouts (all on cooldown) — nothing sent"; exit 0
fi
BODY="${OUT#MSG$'\t'}"

# --- send to Telegram ---------------------------------------------------------
TOKEN="$(cat "$SECRETS/telegram_antigravity_bot_token" 2>/dev/null)"
CHAT="$(cat "$SECRETS/telegram-chat-id.txt" 2>/dev/null)"
HEADER="🚀 *Breakout scan* — $(TZ='America/New_York' date '+%a %b %-d, %-I:%M %p ET')"
if [[ -n "$TOKEN" && -n "$CHAT" ]]; then
  python3 - "$TOKEN" "$CHAT" "$HEADER"$'\n\n'"$BODY" <<'PY' >>"$LOG" 2>&1
import sys, requests
token, chat, msg = sys.argv[1:4]
for i in range(0, len(msg), 4000):
    requests.post(f"https://api.telegram.org/bot{token}/sendMessage",
                  json={"chat_id": chat, "text": msg[i:i+4000]}, timeout=15)
PY
  log "sent breakout alert to $CHAT"
else
  log "WARN telegram creds missing — printed only"; echo "$HEADER"$'\n\n'"$BODY"
fi

# --- hive-mind feed -----------------------------------------------------------
DS="$(TZ='America/New_York' date '+%Y-%m-%d_%H%M')"
F="$BRIEF_DIR/breakouts-${DS}.md"
{
  echo "---"; echo "name: breakouts-${DS}"
  echo "description: S&P 500 breakout + rising-volume scan ${DS} ET (auto)"
  echo "metadata:"; echo "  type: reference"; echo "  source: breakout_scanner.py"; echo "---"
  echo; echo "# Breakout scan — ${DS} ET"; echo; echo "$BODY"
} > "$F"
log "hive-mind feed written: $F"
log "=== breakout scan done ==="
