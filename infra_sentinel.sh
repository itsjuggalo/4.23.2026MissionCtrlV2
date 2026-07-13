#!/usr/bin/env bash
# infra_sentinel.sh — silent self-healing watchdog for the laptop's PUBLIC INGRESS
# (built 2026-07-12 after Oracle died 07-10 and nobody noticed for 2 days because the
# only alert channel was a Discord webhook Mike never reads).
#
# Philosophy (Mike's call): NO Telegram/Discord noise. Detect → fix automatically.
#   Tier 1: deterministic self-heals (nginx up, DNS re-push, cert renew, pm2 revive).
#   Tier 2: if a probe still fails after Tier 1, spawn a headless Claude (Opus) fixer
#           session (subscription/OAuth, same pattern as annotation-autofix) to diagnose
#           and repair autonomously.
#   Tier 3: if the fixer has already run twice for the same issue and it STILL fails,
#           queue an intent capsule — it surfaces at the next Claude session start
#           (the "holler" channel) instead of pinging Mike's phone.
#
# Kill switch:  touch ~/.mc-coord/sentinel-OFF
# Ledger:       ~/logs/infra-sentinel.log   State: ~/.mc-coord/sentinel/state.json
# Cron:         */10 * * * *
# HARD RULES for every tier: never touch trading daemons/flow files/credentials;
# never delete router/DNS config; smallest reversible fix only.
set -uo pipefail

STATE_DIR="$HOME/.mc-coord/sentinel"
LOGF="$HOME/logs/infra-sentinel.log"
OFF="$HOME/.mc-coord/sentinel-OFF"
LOCK="$STATE_DIR/.lock"
CLAUDE_BIN="/home/itsju/.local/bin/claude"
OAUTH_TOKEN_FILE="$HOME/.openclaw/secrets/claude_oauth_token"
FIX_TIMEOUT=900
FIXER_COOLDOWN_S=3600          # >=1h between fixer runs per issue
FIXER_MAX_PER_DAY=4

DOMAINS="missionctrl.serveftp.com massagebymike.serveftp.com bridge.serveftp.com bobacattrades.serveftp.com"
# pm2 processes the sentinel may revive (NEVER trading daemons, NEVER claudeclaw)
REVIVABLE="missionctrl aries massage-api"

mkdir -p "$STATE_DIR" "$(dirname "$LOGF")"
log(){ echo "[sentinel] $(TZ=America/New_York date '+%F %I:%M:%S%p ET') $*" >> "$LOGF"; }

[ -f "$OFF" ] && exit 0
exec 9>"$LOCK"; flock -n 9 || exit 0

# ---------- state helpers (per-issue fixer cooldown/counters) ----------
sget(){ jq -r --arg k "$1" '.[$k] // empty' "$STATE_DIR/state.json" 2>/dev/null; }
sset(){ local tmp; tmp=$(mktemp)
  jq --arg k "$1" --arg v "$2" '.[$k]=$v' "$STATE_DIR/state.json" 2>/dev/null > "$tmp" \
    || echo "{\"$1\":\"$2\"}" > "$tmp"
  mv "$tmp" "$STATE_DIR/state.json"; }

# ---------- probes ----------
wan_ip(){ curl -s -m 10 https://api.ipify.org 2>/dev/null; }

probe_local(){ # local nginx serving each vhost? -> echoes failing domains
  local d fails=""
  for d in $DOMAINS; do
    c=$(curl -sk -o /dev/null -w '%{http_code}' -m 8 -H "Host: $d" https://127.0.0.1/ 2>/dev/null)
    case "$c" in 2*|3*) ;; *) fails="$fails $d($c)";; esac
  done
  echo "$fails"
}

probe_dns(){ # any domain not resolving to current WAN IP? -> echoes mismatches
  local ip="$1" d fails=""
  for d in $DOMAINS; do
    r=$(python3 -c "import socket;print(socket.gethostbyname('$d'))" 2>/dev/null)
    [ -n "$r" ] && [ "$r" != "$ip" ] && fails="$fails $d($r)"
  done
  echo "$fails"
}

probe_external(){ # one external HTTPS probe of missionctrl via check-host.net
  # echoes OK / FAIL / SKIP (SKIP = check-host itself unreachable; not our outage)
  local id res
  id=$(curl -s -m 15 -H 'Accept: application/json' \
    'https://check-host.net/check-http?host=https%3A%2F%2Fmissionctrl.serveftp.com%2F&max_nodes=2' \
    | python3 -c 'import sys,json;print(json.load(sys.stdin).get("request_id",""))' 2>/dev/null)
  [ -z "$id" ] && { echo SKIP; return; }
  sleep 15
  res=$(curl -s -m 10 -H 'Accept: application/json' "https://check-host.net/check-result/$id" 2>/dev/null \
    | python3 -c '
import sys,json
try: d=json.load(sys.stdin)
except Exception: print("SKIP"); raise SystemExit
vals=[v for v in d.values() if v]
if not vals: print("SKIP"); raise SystemExit
print("OK" if any(v[0] and v[0][0]==1 for v in vals) else "FAIL")' 2>/dev/null)
  echo "${res:-SKIP}"
}

probe_pm2(){ # revivable pm2 procs not online -> echoes them
  local p fails="" js
  js=$(pm2 jlist 2>/dev/null)
  for p in $REVIVABLE; do
    st=$(echo "$js" | jq -r --arg n "$p" '.[]|select(.name==$n)|.pm2_env.status' 2>/dev/null | head -1)
    [ "$st" = "online" ] || fails="$fails $p($st)"
  done
  echo "$fails"
}

probe_cert(){ # days left on the cert; echoes days or 999 on read failure
  local end
  end=$(sudo openssl x509 -enddate -noout -in /etc/letsencrypt/live/missionctrl.serveftp.com/fullchain.pem 2>/dev/null | cut -d= -f2)
  [ -z "$end" ] && { echo 999; return; }
  echo $(( ( $(date -d "$end" +%s) - $(date +%s) ) / 86400 ))
}

# ---------- Tier 2: headless Claude fixer ----------
spawn_fixer(){ # <issue-key> <diagnostic-summary>
  local key="$1" diag="$2" now last count today
  now=$(date +%s); today=$(date +%F)
  last=$(sget "fixer_last_$key"); count=$(sget "fixer_count_${key}_$today")
  [ -n "$last" ] && [ $((now - last)) -lt $FIXER_COOLDOWN_S ] && { log "fixer($key) on cooldown"; return 1; }
  [ "${count:-0}" -ge $FIXER_MAX_PER_DAY ] && { log "fixer($key) hit daily cap"; return 1; }
  sset "fixer_last_$key" "$now"; sset "fixer_count_${key}_$today" "$(( ${count:-0} + 1 ))"
  log "SPAWNING headless fixer for '$key' (run $(( ${count:-0} + 1 ))/$FIXER_MAX_PER_DAY today)"

  local PROMPT="You are the Mission Control infra self-healing agent (headless, autonomous, NO human watching). A sentinel probe found the laptop's PUBLIC INGRESS degraded. Diagnose and FIX it, then verify.

FAILING PROBE: $diag

ARCHITECTURE (2026-07-12 cutover — Oracle VPS is RETIRED, do not try to reach it):
serveftp domains -> No-IP A records -> home WAN IP (Spectrum dynamic) -> Spectrum router forwards TCP 80/443 -> Windows portproxy (netsh, list in C:\\AIWorkWindows\\scripts\\aries-portproxy-refresh.ps1) -> WSL nginx (/etc/nginx/sites-enabled/mc-public) -> apps (:3000 missionctrl, :3003 massage, :8090 bridge, :1337 aries).
Docs: ~/SYSTEM-MAP.md header note + memory project_noip_local_public_cutover.md.
Helpers: ~/scripts/noip_duc.sh (re-push DNS; force by rm ~/.openclaw/state/noip_last_ip.txt), certbot (renew), 'sudo service nginx start|reload' (no systemd), pm2.

INVESTIGATE in order: local app -> nginx -> portproxy (powershell.exe netsh interface portproxy show v4tov4) -> WAN IP vs DNS (curl api.ipify.org vs getent hosts) -> external (check-host.net API). Fix the FIRST broken layer with the smallest reversible change, then re-verify end-to-end via check-host.net.

HARD LIMITS: NEVER touch trading daemons/code, flow-signal files, credentials/.env, claudeclaw, or Alpaca keys. NEVER delete router port-forwards or No-IP hostnames. Windows-elevation (UAC) and Spectrum-router UI changes are OUT of reach headless — if the break is there, say so in the summary instead of fixing.
Finish with ONE line starting 'SUMMARY:' stating what was broken, what you changed, and the final verified state."

  local OUT rc
  OUT=$(echo "$PROMPT" | timeout "$FIX_TIMEOUT" env -u ANTHROPIC_API_KEY \
    CLAUDE_CODE_OAUTH_TOKEN="$(cat "$OAUTH_TOKEN_FILE" 2>/dev/null)" \
    "$CLAUDE_BIN" -p --model opus --effort high --output-format text --no-session-persistence \
    --allowedTools "Bash,Read,Edit,Write,Glob,Grep" 2>&1); rc=$?
  echo "----- fixer($key) output rc=$rc -----" >> "$LOGF"; echo "$OUT" >> "$LOGF"
  log "fixer($key) done rc=$rc: $(echo "$OUT" | grep -iE '^SUMMARY:' | tail -1)"
  return 0
}

escalate_capsule(){ # <issue-key> <diag>  — Tier 3: surface at next session start
  local key="$1" diag="$2"
  [ -n "$(sget "capsule_$key")" ] && return 0   # only once per issue
  local f; f=$(mktemp)
  printf '%s\n' "@sentinel-$key-$(date +%m%d%H%M)" \
    "do: infra_sentinel found '$key' broken and BOTH deterministic fixes and 2 headless fixer runs failed. Diagnose by hand: $diag. See ~/logs/infra-sentinel.log tail + memory project_noip_local_public_cutover.md. Likely out-of-headless-reach: UAC portproxy or Spectrum router forwards (spectrum.net creds in mc-secrets)." \
    "in: public-ingress chain (nginx/portproxy/router/No-IP)" \
    "why: silent self-heal exhausted; Mike wants no phone pings — this capsule IS the holler." \
    "=: the failing probe passes from check-host.net and sentinel logs a clean cycle" > "$f"
  ~/bin/intent-queue add --source restructure --file "$f" >/dev/null 2>&1 && sset "capsule_$key" "1" \
    && log "ESCALATED '$key' -> intent capsule (next-session pickup)"
  rm -f "$f"
}

clear_issue(){ sset "capsule_$1" ""; }   # healthy again -> re-arm escalation

# ================= main cycle =================
IP=$(wan_ip)

# 1. pm2 revivals (cheap, local)
PM2_FAILS=$(probe_pm2)
if [ -n "${PM2_FAILS// /}" ]; then
  log "pm2 down:$PM2_FAILS — reviving"
  for p in $REVIVABLE; do
    echo "$PM2_FAILS" | grep -q "$p(" && pm2 restart "$p" >/dev/null 2>&1
  done
  sleep 5; PM2_FAILS=$(probe_pm2)
  [ -n "${PM2_FAILS// /}" ] && spawn_fixer pm2 "pm2 processes not online after restart:$PM2_FAILS"
fi

# 2. local nginx/vhosts
LOCAL_FAILS=$(probe_local)
if [ -n "${LOCAL_FAILS// /}" ]; then
  log "local vhost fail:$LOCAL_FAILS — (re)starting nginx"
  sudo nginx -t >/dev/null 2>&1 && { sudo service nginx start >/dev/null 2>&1; sudo service nginx reload >/dev/null 2>&1; }
  sleep 3; LOCAL_FAILS=$(probe_local)
  if [ -n "${LOCAL_FAILS// /}" ]; then
    spawn_fixer nginx "local nginx vhosts failing after restart:$LOCAL_FAILS (nginx -t: $(sudo nginx -t 2>&1 | tail -1))"
  else log "nginx self-heal OK"; fi
fi

# 3. DNS vs WAN IP
if [ -n "$IP" ]; then
  DNS_FAILS=$(probe_dns "$IP")
  if [ -n "${DNS_FAILS// /}" ]; then
    log "DNS mismatch (wan=$IP):$DNS_FAILS — forcing noip_duc push"
    rm -f "$HOME/.openclaw/state/noip_last_ip.txt"
    bash "$HOME/scripts/noip_duc.sh" >> "$HOME/logs/noip-duc.log" 2>&1
    sleep 90; DNS_FAILS=$(probe_dns "$IP")
    [ -n "${DNS_FAILS// /}" ] && spawn_fixer dns "DNS still not matching WAN $IP after forced push:$DNS_FAILS" \
      || log "DNS self-heal OK"
  fi
fi

# 4. cert expiry
DAYS=$(probe_cert)
if [ "$DAYS" -lt 14 ]; then
  log "cert expires in ${DAYS}d — renewing"
  sudo certbot renew -q --no-random-sleep-on-renew >/dev/null 2>&1 && sudo service nginx reload >/dev/null 2>&1
  DAYS=$(probe_cert)
  [ "$DAYS" -lt 14 ] && spawn_fixer cert "cert still expiring in ${DAYS}d after certbot renew"
fi

# 5. external reachability (the outage class that hid for 2 days)
EXT=$(probe_external)
case "$EXT" in
  OK)   clear_issue external; log "cycle OK (ext=OK wan=$IP cert=${DAYS}d)";;
  SKIP) log "cycle done (external probe SKIP — check-host unreachable; local all green)";;
  FAIL)
    log "EXTERNAL FAIL (local green, wan=$IP) — full chain break above the house or portproxy/router"
    if ! spawn_fixer external "https://missionctrl.serveftp.com unreachable from check-host.net nodes while local vhosts + DNS are healthy (wan=$IP). Suspect Windows portproxy (netsh) or Spectrum router forwards or ISP."; then
      # fixer refused (cooldown/cap) — if we've already burned 2+ runs today, escalate
      today=$(date +%F); c=$(sget "fixer_count_external_$today")
      [ "${c:-0}" -ge 2 ] && escalate_capsule external "external HTTPS unreachable; local layers verified green"
    fi
    ;;
esac
exit 0
