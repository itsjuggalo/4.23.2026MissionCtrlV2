#!/usr/bin/env bash
# breakout_cron.sh — S&P 500 breakout + breakdown scan (rising volume), to Telegram.
#
# Pipeline:
#   1. scan : breakout_scanner.py SCAN_MODE=both -> breakouts + breakdowns JSON
#   2. dedupe: same-day cooldown (separate up:/dn: buckets); re-alert only if RVOL
#             jumped +0.5 — keeps signal, not spam (ADD-friendly).
#   3. enrich: ONE claude -p "/ainvest" call adds an actionable line per fresh name
#             (lean / entry trigger / stop / catalyst). Best-effort — on any failure
#             falls back to the deterministic list so the alert never drops.
#   4. send : ONE Telegram message (breakouts then breakdowns, capped). Not two pings.
#   5. feed : append to ~/mc-kb/notes/briefs/ for Boba/Jazzy hive-mind.
#
# Caps (ADD): top 5 breakouts + top 3 breakdowns per message.
# Gate: Mon-Fri 09:30-16:00 ET (cron at 12:30 + 15:50). FORCE=1 bypasses. Laptop hub.
set -uo pipefail

SECRETS="$HOME/.openclaw/secrets"
STATE="$HOME/.openclaw/data/breakout_seen.json"
BRIEF_DIR="$HOME/mc-kb/notes/briefs"
LOG="$HOME/.openclaw/workspace/logs/breakout_scan.log"
mkdir -p "$(dirname "$STATE")" "$BRIEF_DIR" "$(dirname "$LOG")"
NVM_BIN="$(ls -d "$HOME"/.nvm/versions/node/*/bin 2>/dev/null | sort -V | tail -1)"
export PATH="$NVM_BIN:$HOME/.local/bin:/usr/local/bin:/usr/bin:/bin:$PATH"
CLAUDE_BIN="$HOME/.local/bin/claude"
ENRICH="${BREAKOUT_ENRICH:-1}"    # 1 = add LLM action lines; 0 = deterministic only

log() { echo "[$(TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET')] $*" | tee -a "$LOG"; }

if [[ "${FORCE:-0}" != "1" ]]; then
  DOW=$(TZ='America/New_York' date +%u); HHMM=$(TZ='America/New_York' date +%H%M)
  (( DOW > 5 )) && { log "weekend — skip"; exit 0; }
  if (( 10#$HHMM < 930 || 10#$HHMM > 1600 )); then log "outside 09:30-16:00 ET — skip"; exit 0; fi
fi

log "=== breakout/breakdown scan start ==="
SCAN_JSON="$(SCAN_MODE=both python3 "$HOME/scripts/breakout_scanner.py" 2>>"$LOG")"
[[ -z "$SCAN_JSON" ]] && { log "scanner empty — abort"; exit 1; }

# --- dedupe + deterministic body; also drop fresh-hit JSON for the enricher -----
FRESH_JSON="/tmp/breakout_fresh.$$.json"
read -r -d '' PYCODE <<'PY' || true
import json, os, sys
from datetime import datetime
import zoneinfo
scan = json.loads(os.environ["SCAN_JSON"])
state_path, fresh_path = os.environ["STATE"], os.environ["FRESH_JSON"]
today = datetime.now(zoneinfo.ZoneInfo("America/New_York")).strftime("%Y-%m-%d")
try:
    st = json.load(open(state_path))
    if st.get("date") != today: st = {"date": today, "sent": {}}
except Exception:
    st = {"date": today, "sent": {}}
sent = st["sent"]

def take(hits, prefix, cap):
    fresh = []
    for h in hits:
        k = f"{prefix}:{h['symbol']}"
        prev = sent.get(k)
        if prev is None or h["rvol"] >= prev + 0.5:
            fresh.append(h); sent[k] = h["rvol"]
        if len(fresh) >= cap: break
    return fresh

ups = take(scan.get("breakouts", []), "up", 5)
dns = take(scan.get("breakdowns", []), "dn", 3)
st["sent"] = sent
json.dump(st, open(state_path, "w"))
json.dump({"breakouts": ups, "breakdowns": dns}, open(fresh_path, "w"))

if not ups and not dns:
    print("NOFRESH"); sys.exit(0)

def line(h, up):
    tags = []
    if h["extreme_label"]: tags.append(h["extreme_label"])
    if h["has_flow"]: tags.append("🟢FLOW")
    t = ("  " + " ".join(tags)) if tags else ""
    if up:
        return f"• {h['symbol']}  ${h['close']}  +{h['pct_vs_level']}% over 20d-high  RVOL {h['rvol']}x{t}"
    return f"• {h['symbol']}  ${h['close']}  {h['pct_vs_level']}% under 20d-low  RVOL {h['rvol']}x{t}"

out = []
if ups:
    out.append(f"📈 BREAKOUTS ({len(ups)})")
    out += [line(h, True) for h in ups]
if dns:
    if ups: out.append("")
    out.append(f"📉 BREAKDOWNS ({len(dns)})")
    out += [line(h, False) for h in dns]
print("MSG\t" + "\n".join(out))
PY

OUT="$(SCAN_JSON="$SCAN_JSON" STATE="$STATE" FRESH_JSON="$FRESH_JSON" python3 -c "$PYCODE" 2>>"$LOG")"
if [[ "$OUT" == "NOFRESH" || -z "$OUT" ]]; then
  log "no fresh moves (all on cooldown) — nothing sent"; rm -f "$FRESH_JSON"; exit 0
fi
DET_BODY="${OUT#MSG$'\t'}"
BODY="$DET_BODY"

# --- enrich with one LLM pass (best-effort; deterministic fallback) ------------
if [[ "$ENRICH" == "1" && -s "$FRESH_JSON" ]]; then
  ASK="/ainvest These are today's S&P 500 breakouts (close > 20-day high on rising volume) \
and breakdowns (close < 20-day low on rising volume). For EACH name give ONE phone-friendly \
line: ticker — lean (long / short / avoid), entry-or-trigger level, stop, and the catalyst in \
<= 8 words if known. Lead with the single highest-conviction name across both lists. \
Group under '📈 BREAKOUTS' and '📉 BREAKDOWNS'. <= 20 lines total, no preamble, no tables. \
Local data only, no mcp__ainvest tools.

Data: $(cat "$FRESH_JSON")"
  ENRICHED="$(cd "$HOME" && timeout 200 "$CLAUDE_BIN" -p "$ASK" --model sonnet \
    --output-format json --allowedTools "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite" 2>>"$LOG" \
    | python3 -c 'import json,sys;
try: print((json.load(sys.stdin).get("result") or "").strip())
except Exception: print("")' 2>>"$LOG")"
  if [[ -n "$ENRICHED" && "${#ENRICHED}" -gt 40 ]]; then
    BODY="$ENRICHED"; log "enriched via /ainvest (${#ENRICHED} chars)"
  else
    log "enrich empty/failed — using deterministic body"
  fi
fi
rm -f "$FRESH_JSON"

# --- send ONE Telegram message ------------------------------------------------
TOKEN="$(cat "$SECRETS/telegram_antigravity_bot_token" 2>/dev/null)"
CHAT="$(cat "$SECRETS/telegram-chat-id.txt" 2>/dev/null)"
HEADER="🚀 *Breakout scan* — S&P 500 · rising volume · $(TZ='America/New_York' date '+%a %-I:%M %p ET')"
if [[ -n "$TOKEN" && -n "$CHAT" ]]; then
  python3 - "$TOKEN" "$CHAT" "$HEADER"$'\n\n'"$BODY" <<'PY' >>"$LOG" 2>&1
import sys, requests
token, chat, msg = sys.argv[1:4]
for i in range(0, len(msg), 4000):
    requests.post(f"https://api.telegram.org/bot{token}/sendMessage",
                  json={"chat_id": chat, "text": msg[i:i+4000]}, timeout=15)
PY
  log "sent scan alert to $CHAT"
else
  log "WARN telegram creds missing — printed only"; echo "$HEADER"$'\n\n'"$BODY"
fi

# --- hive-mind feed -----------------------------------------------------------
DS="$(TZ='America/New_York' date '+%Y-%m-%d_%H%M')"
F="$BRIEF_DIR/breakouts-${DS}.md"
{
  echo "---"; echo "name: breakouts-${DS}"
  echo "description: S&P 500 breakout/breakdown scan ${DS} ET (auto)"
  echo "metadata:"; echo "  type: reference"; echo "  source: breakout_scanner.py"; echo "---"
  echo; echo "# Breakout/breakdown scan — ${DS} ET"; echo; echo "$BODY"
} > "$F"
log "hive-mind feed written: $F"
log "=== scan done ==="
