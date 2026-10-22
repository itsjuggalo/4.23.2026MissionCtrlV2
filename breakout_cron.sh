#!/usr/bin/env bash
# breakout_cron.sh — S&P 500 breakout + breakdown scan (rising volume), to Telegram.
#
# Pipeline:
#   1. scan : breakout_scanner.py SCAN_MODE=both -> breakouts + breakdowns JSON
#   2. dedupe: same-day cooldown (separate up:/dn: buckets); re-alert only if RVOL
#             jumped +0.5 — keeps signal, not spam (ADD-friendly). The cooldown is staged
#             in $STATE.pending and committed only after tg_fleet acknowledges the send,
#             so a failed send is retried next run (audit W5 MC-AUD-081, 2026-10-21).
#   3. enrich: ONE claude -p "/ainvest" call adds a line per fresh name (lean / catalyst).
#             No price levels from the model (DECISIONS R32: levels only when computed
#             from data); any entry/stop/target clause it still writes is stripped by
#             lib/llm_level_strip.py. Best-effort — on any failure falls back to the
#             deterministic list so the alert never drops.
#   4. send : ONE Telegram message (breakouts then breakdowns, capped) via tg_fleet lane
#             aime_research (same AntiGravity bot; ledger + lint; no token in argv).
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
CLAUDE_BIN="$HOME/bin/llm-route"   # 2026-09-28 Codex route (revert: touch ~/.config/llm-route/USE_CLAUDE)
ENRICH="${BREAKOUT_ENRICH:-1}"    # 1 = add LLM action lines; 0 = deterministic only

log() { echo "[$(TZ='America/New_York' date '+%Y-%m-%d %H:%M:%S ET')] $*" | tee -a "$LOG"; }

if [[ "${FORCE:-0}" != "1" ]]; then
  DOW=$(TZ='America/New_York' date +%u); HHMM=$(TZ='America/New_York' date +%H%M)
  (( DOW > 5 )) && { log "weekend — skip"; exit 0; }
  if (( 10#$HHMM < 930 || 10#$HHMM > 1600 )); then log "outside 09:30-16:00 ET — skip"; exit 0; fi
fi

# DRY_RUN=1 (tests): render the message only — temp state, no LLM, no Telegram, no hive-mind note.
# BREAKOUT_SCAN_JSON_FILE replays a saved scan instead of fetching.
if [[ "${DRY_RUN:-0}" == "1" ]]; then
  STATE="$(mktemp)"; ENRICH=0; LOG=/dev/null
fi
log "=== breakout/breakdown scan start ==="
if [[ -n "${BREAKOUT_SCAN_JSON_FILE:-}" ]]; then
  SCAN_JSON="$(cat "$BREAKOUT_SCAN_JSON_FILE")"
else
  SCAN_JSON="$(SCAN_MODE=both python3 "$HOME/scripts/breakout_scanner.py" 2>>"$LOG")"
fi
[[ -z "$SCAN_JSON" ]] && { log "scanner empty — abort"; exit 1; }

# --- dedupe + deterministic body; also drop fresh-hit JSON for the enricher -----
FRESH_JSON="/tmp/breakout_fresh.$$.json"
read -r -d '' PYCODE <<'PY' || true
import json, os, sys
from datetime import datetime
import zoneinfo
scan = json.loads(os.environ["SCAN_JSON"])
state_path, fresh_path = os.environ["STATE"], os.environ["FRESH_JSON"]
pending_path = state_path + ".pending"
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
json.dump(st, open(pending_path, "w"))   # committed by the shell only after an acknowledged send
json.dump({"breakouts": ups, "breakdowns": dns}, open(fresh_path, "w"))

if not ups and not dns:
    print("NOFRESH"); sys.exit(0)

def line(h, up):
    tags = []
    if h["extreme_label"]: tags.append(h["extreme_label"])
    # W8 MC-AUD-013: flow is green only when it points the move's way; otherwise say what it is
    fd = h.get("flow_dir") or ("unknown" if h["has_flow"] else "")
    if fd: tags.append({"aligned": "🟢FLOW", "mixed": "FLOW mixed", "adverse": "🔴FLOW against"}.get(fd, "FLOW (dir ?)"))
    t = ("  " + " ".join(tags)) if tags else ""
    if up:
        return f"• {h['symbol']}  ${h['close']}  +{h['pct_vs_level']}% over 20d-high  RVOL {h['rvol']}x{t}"
    return f"• {h['symbol']}  ${h['close']}  {h['pct_vs_level']}% under 20d-low  RVOL {h['rvol']}x{t}"

out = []
b = scan.get("bars") or {}
if b:
    out.append(f"Bars {b.get('bar_date', '?')} · {b.get('session', '?')} · {b.get('source', '?')} · {b.get('adjustment', '')}")
fo = scan.get("flow_overlay") or {}
if fo.get("stale"):
    out.append(f"Flow overlay STALE (newest {fo.get('newest') or 'none'}) — no FLOW tags possible")
out.append("52W = within 3% of the 52-week high/low, not an all-time high")
out.append("")
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
  log "no fresh moves (all on cooldown) — nothing sent"; rm -f "$FRESH_JSON" "$STATE.pending"; exit 0
fi
DET_BODY="${OUT#MSG$'\t'}"
BODY="$DET_BODY"
PROV="${DET_BODY%%$'\n\n'*}"   # provenance lines (bars/session/source, flow overlay, 52W note) — kept on the enriched body too

# --- enrich with one LLM pass (best-effort; deterministic fallback) ------------
if [[ "$ENRICH" == "1" && -s "$FRESH_JSON" ]]; then
  ASK="/ainvest These are today's S&P 500 breakouts (close > 20-day high on rising volume) \
and breakdowns (close < 20-day low on rising volume). For EACH name give ONE phone-friendly \
line: ticker — lean (long / short / avoid) and the catalyst in <= 8 words if known. \
Give NO price levels: no entry, trigger, stop, target or take-profit numbers. Lead with the single highest-conviction name across both lists. \
Group under '📈 BREAKOUTS' and '📉 BREAKDOWNS'. <= 20 lines total, no preamble, no tables. \
Local data only, no mcp__ainvest tools.

Data: $(cat "$FRESH_JSON")"
  # --strict-mcp-config: load ZERO MCP servers. The prompt above already says
  # "Local data only, no mcp__ainvest tools", so they were pure startup overhead.
  # Do NOT use --bare: it skips keychain reads -> "Not logged in" on subscription auth.
  ENRICHED="$(cd "$HOME" && timeout 200 "$CLAUDE_BIN" -p "$ASK" --model sonnet \
    --strict-mcp-config \
    --output-format json --allowedTools "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite" 2>>"$LOG" \
    | python3 -c 'import json,sys;
try: print((json.load(sys.stdin).get("result") or "").strip())
except Exception: print("")' 2>>"$LOG" \
    | python3 "$HOME/scripts/lib/llm_level_strip.py" 2>>"$LOG")"   # R32: no model-invented levels
  if [[ -n "$ENRICHED" && "${#ENRICHED}" -gt 40 ]]; then
    BODY="$PROV"$'\n\n'"$ENRICHED"; log "enriched via /ainvest (${#ENRICHED} chars)"
  else
    log "enrich empty/failed — using deterministic body"
  fi
fi
rm -f "$FRESH_JSON"

# --- send ONE Telegram message ------------------------------------------------
if [[ "${DRY_RUN:-0}" == "1" ]]; then
  echo "🚀 *Breakout scan* — S&P 500 · rising volume · DRY RUN"$'\n\n'"$BODY"; rm -f "$STATE" "$STATE.pending"; exit 0
fi
HEADER="🚀 *Breakout scan* — S&P 500 · rising volume · $(TZ='America/New_York' date '+%a %-I:%M %p ET')"
if "$HOME/.venv/bin/python" "$HOME/scripts/tg_fleet.py" send aime_research "$HEADER"$'\n\n'"$BODY" >>"$LOG" 2>&1; then
  mv -f "$STATE.pending" "$STATE"
  log "sent scan alert (tg_fleet aime_research) — cooldown committed"
else
  rm -f "$STATE.pending"
  log "ERROR send not acknowledged — cooldown NOT advanced, retried next run"; echo "$HEADER"$'\n\n'"$BODY"
  SEND_FAILED=1
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
[[ "${SEND_FAILED:-0}" == "1" ]] && exit 1
exit 0
