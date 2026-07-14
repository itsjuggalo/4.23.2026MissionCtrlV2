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

DOMAINS="missionctrl.serveftp.com massagebymike.serveftp.com bridge.serveftp.com bobacattrades.serveftp.com claudeclaw.serveftp.com"
# extra DNS-tracked hostnames with no nginx vhost (none currently; env-overridable for tests)
DNS_ONLY_DOMAINS="${SENTINEL_DNS_ONLY:-}"
MASSAGE_PORT="${SENTINEL_MASSAGE_PORT:-3003}"   # overridable for simulated-failure tests
# pm2 processes the sentinel may revive (NEVER trading daemons, NEVER claudeclaw)
REVIVABLE="missionctrl aries massage-api bobacat-gallery mc-kb-server"

# cron runs a bare shell with no nvm PATH — resolve pm2 explicitly (the 07-12 night
# false-positive: bare `pm2` not found made probe_pm2 report everything down each cycle)
PM2=$(command -v pm2 || ls -d "$HOME"/.nvm/versions/node/*/bin/pm2 2>/dev/null | tail -1)
# pm2's shebang is `#!/usr/bin/env node` — node must be on PATH too under cron
[ -n "$PM2" ] && export PATH="$(dirname "$PM2"):$PATH"

# thresholds (env-overridable so simulated-failure tests can trip them)
DISK_PCT_MAX=${SENTINEL_DISK_PCT_MAX:-90}      # % used on / before escalating
RAM_AVAIL_MIN_MB=${SENTINEL_RAM_MIN_MB:-1024}  # MemAvailable floor
CRASHLOOP_DELTA=${SENTINEL_CRASHLOOP_DELTA:-5} # pm2 restarts per 10-min cycle = looping

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
  local d p fails=""
  for d in $DOMAINS; do
    # bridge's / rebuilds a gallery page from the OneDrive mount (6-10s) — probe its
    # cheap /health instead (added to bobacat_server.py 2026-07-13)
    p="/"; [ "$d" = "bridge.serveftp.com" ] && p="/health"
    c=$(curl -sk -o /dev/null -w '%{http_code}' -m 8 -H "Host: $d" "https://127.0.0.1$p" 2>/dev/null)
    case "$c" in 2*|3*) ;; *) fails="$fails $d($c)";; esac
  done
  echo "$fails"
}

resolve_public(){ # $1=domain -> prints public A record; rc 0=resolved 1=unresolvable 2=inconclusive
  # Resolves over DoH so the LOCAL resolver stack is bypassed entirely. See probe_dns.
  python3 - "$1" <<'PY' 2>/dev/null
import sys, json, urllib.request
d = sys.argv[1]
for url, hdrs in (
    ("https://dns.google/resolve?name=%s&type=A" % d, {}),
    ("https://cloudflare-dns.com/dns-query?name=%s&type=A" % d,
     {"accept": "application/dns-json"}),
):
    try:
        with urllib.request.urlopen(urllib.request.Request(url, headers=hdrs), timeout=8) as r:
            j = json.load(r)
    except Exception:
        continue  # this resolver is unreachable — try the next one
    ips = [a["data"] for a in (j.get("Answer") or []) if a.get("type") == 1]
    if ips:
        print(ips[0]); sys.exit(0)
    sys.exit(1)   # NXDOMAIN / NOERROR-but-no-A: a real answer, and it says "not there"
sys.exit(2)       # every resolver unreachable -> we simply don't know; not an expiry
PY
}

probe_dns(){ # any domain not resolving to current WAN IP? -> echoes mismatches
  # also tracks NXDOMAIN streaks per domain (free No-IP hostnames die if the 30-day
  # confirmation email isn't clicked) — 3 consecutive cycles unresolvable -> capsule
  #
  # Resolve via PUBLIC DNS (resolve_public), never socket.gethostbyname()/getent: nsswitch
  # is "files dns", and the 07-12 "local hairpin fix" pins all 5 domains to 127.0.0.1 in the
  # Windows hosts file (mirrored into /etc/hosts) because Spectrum's router has no NAT
  # loopback. The old local lookup therefore always saw 127.0.0.1 != WAN and reported a
  # mismatch no DNS push could ever clear — a false positive that re-pushed No-IP every
  # 10 min and spawned a fixer. The hairpin entries are intentional: do NOT remove them.
  local ip="$1" d r rc nx fails=""
  for d in $DOMAINS $DNS_ONLY_DOMAINS; do
    r=$(resolve_public "$d"); rc=$?
    if [ "$rc" -eq 2 ]; then
      log "DNS probe inconclusive for $d (public resolvers unreachable) — not counting as NXDOMAIN"
      continue
    fi
    if [ "$rc" -ne 0 ] || [ -z "$r" ]; then
      nx=$(sget "nxdomain_$d"); nx=$(( ${nx:-0} + 1 )); sset "nxdomain_$d" "$nx"
      if [ "$nx" -ge 3 ]; then
        log "DNS NXDOMAIN x$nx for $d — likely expired No-IP hostname (30-day confirm missed)"
        escalate_capsule "noipexpiry-${d%%.*}" "$d has not resolved for $nx sentinel cycles — the free No-IP hostname likely expired (monthly confirmation email not clicked). Log into noip.com (creds mc-secrets global/NOIP_*) and confirm/re-create the hostname, then rm ~/.openclaw/state/noip_last_ip.txt and run ~/scripts/noip_duc.sh."
      fi
      continue
    fi
    sset "nxdomain_$d" 0; clear_issue "noipexpiry-${d%%.*}"
    [ "$r" != "$ip" ] && fails="$fails $d($r)"
  done
  echo "$fails"
}

probe_massage_flow(){ # deeper than the vhost 200: booking page + intake API must answer
  local a b
  a=$(curl -sL -o /dev/null -w '%{http_code}' -m 10 "http://127.0.0.1:$MASSAGE_PORT/booking" 2>/dev/null)
  b=$(curl -s  -o /dev/null -w '%{http_code}' -m 10 "http://127.0.0.1:$MASSAGE_PORT/api/health" 2>/dev/null)
  case "$a:$b" in 2*:2*) echo OK;; *) echo "booking=$a health=$b";; esac
}

TS_EXPECTED="$STATE_DIR/tailscale-serve.expected"
probe_ts_drift(){ # Mike-private access map drift; detect-only (baseline = expected file)
  command -v tailscale >/dev/null 2>&1 || { echo OK; return; }
  local cur; cur=$(tailscale serve status 2>/dev/null | grep -E 'ts\.net|proxy' | tr -s ' ' | sort)
  [ -s "$TS_EXPECTED" ] || { echo "$cur" > "$TS_EXPECTED"; echo OK; return; }  # first run = snapshot
  [ "$cur" = "$(cat "$TS_EXPECTED")" ] && echo OK || echo DRIFT
}

probe_external(){ # one external HTTPS probe of missionctrl via check-host.net
  # echoes OK / FAIL / SKIP (SKIP = check-host itself unreachable; not our outage)
  local id res
  id=$(curl -s -m 15 -H 'Accept: application/json' \
    'https://check-host.net/check-http?host=https%3A%2F%2Fmissionctrl.serveftp.com%2F&max_nodes=5' \
    | python3 -c 'import sys,json;print(json.load(sys.stdin).get("request_id",""))' 2>/dev/null)
  [ -z "$id" ] && { echo SKIP; return; }
  # 1-2 nodes timing out is normal residential-Spectrum noise, so sample 5 and treat
  # "any node served it" as reachable; a 2-node sample false-fired whenever both drew slow nodes.
  sleep 20
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

probe_pm2(){ # revivable pm2 procs not online -> echoes them ("" also when pm2/jlist unavailable)
  local p fails="" js
  [ -x "$PM2" ] || { log "probe_pm2 SKIP: pm2 binary not found"; return; }
  js=$("$PM2" jlist 2>/dev/null)
  # empty/invalid jlist = pm2 daemon unreachable, NOT "everything down" — skip, don't false-fire
  echo "$js" | jq -e 'type=="array" and length>0' >/dev/null 2>&1 || { log "probe_pm2 SKIP: pm2 jlist empty/invalid"; return; }
  for p in $REVIVABLE; do
    st=$(echo "$js" | jq -r --arg n "$p" '.[]|select(.name==$n)|.pm2_env.status' 2>/dev/null | head -1)
    [ "$st" = "online" ] || fails="$fails $p($st)"
  done
  echo "$fails"
}

probe_kb(){ # mc-kb hive-mind :8091 /health (pm2 can show online while HTTP hangs)
  curl -s -o /dev/null -w '%{http_code}' -m 8 http://127.0.0.1:8091/health 2>/dev/null
}

probe_crashloop(){ # pm2 procs whose restart count jumped >= CRASHLOOP_DELTA since last cycle
  local js out=""
  [ -x "$PM2" ] || return
  js=$("$PM2" jlist 2>/dev/null)
  echo "$js" | jq -e 'type=="array" and length>0' >/dev/null 2>&1 || return
  local pairs; pairs=$(echo "$js" | jq -r '.[]|"\(.name) \(.pm2_env.restart_time // 0)"' 2>/dev/null)
  while read -r name count; do
    [ -z "$name" ] && continue
    prev=$(sget "restarts_$name")
    sset "restarts_$name" "$count"
    [ -n "$prev" ] && [ $((count - prev)) -ge "$CRASHLOOP_DELTA" ] && out="$out $name(+$((count-prev)))"
  done <<< "$pairs"
  echo "$out"
}

probe_disk(){ df --output=pcent / 2>/dev/null | tail -1 | tr -dc '0-9'; }
probe_ram(){ awk '/MemAvailable/{print int($2/1024)}' /proc/meminfo 2>/dev/null; }

# ---------- Tier B probes: trading-adjacent, DETECT-ONLY (live-trader protocol: ----------
# ---------- NEVER touch daemons or the merged flow-signal files — capsule only) ----------
FLOW_DIR="${SENTINEL_FLOW_DIR:-$HOME/trading/signals/option-scraper/data}"
HB_DIR="${SENTINEL_HB_DIR:-$HOME/.openclaw/state/heartbeats}"

et_minute_of_day(){ # minutes since ET midnight (overridable for simulated-failure tests)
  [ -n "${SENTINEL_FAKE_NOWMIN:-}" ] && { echo "$SENTINEL_FAKE_NOWMIN"; return; }
  echo $(( 10#$(TZ=America/New_York date +%H) * 60 + 10#$(TZ=America/New_York date +%M) ))
}

probe_flow_stale(){ # market hours Mon-Fri: newest *_alerts_today.json too old?
  local dow nowmin open close newest age
  dow=$(TZ=America/New_York date +%u); [ "$dow" -ge 6 ] && { echo OK; return; }
  nowmin=$(et_minute_of_day)
  open=${SENTINEL_MARKET_OPEN_MIN:-615}   # 10:15 ET (scrapers warmed up)
  close=${SENTINEL_MARKET_CLOSE_MIN:-960} # 16:00 ET
  { [ "$nowmin" -lt "$open" ] || [ "$nowmin" -gt "$close" ]; } && { echo OK; return; }
  newest=$(stat -c %Y "$FLOW_DIR"/*_alerts_today.json 2>/dev/null | sort -n | tail -1)
  [ -z "$newest" ] && { echo "no-flow-files"; return; }
  age=$(( ( $(date +%s) - newest ) / 60 ))
  [ "$age" -gt "${SENTINEL_FLOW_STALE_MIN:-90}" ] && echo "stale ${age}min" || echo OK
}

probe_cycles(){ # boba/jazzy heartbeat must be newer than the last due cycle (+20min grace)
  local dow nowmin midnight agent times m last hb out=""
  dow=$(TZ=America/New_York date +%u); [ "$dow" -ge 6 ] && return
  nowmin=$(et_minute_of_day)
  midnight=$(TZ=America/New_York date -d "$(TZ=America/New_York date +%F) 00:00" +%s)
  for agent in boba jazzy; do
    times="585 660 750 840 930"; [ "$agent" = "jazzy" ] && times="586 661 751 841 931"  # 9:45..15:30 ET, jazzy +1m
    last=""
    for m in $times; do [ "$nowmin" -ge $(( m + ${SENTINEL_CYCLE_GRACE_MIN:-20} )) ] && last=$m; done
    [ -z "$last" ] && continue
    hb=$(stat -c %Y "$HB_DIR/${agent}_cycle" 2>/dev/null || echo 0)
    [ "$hb" -lt $(( midnight + last * 60 )) ] && out="$out ${agent}(due-$(printf '%02d%02d' $((last/60)) $((last%60)))ET)"
  done
  echo "$out"
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
    "do: infra_sentinel flagged '$key' and automated healing could not (or must not) fix it. Diagnose by hand: $diag. See ~/logs/infra-sentinel.log tail + memory reference_infra_sentinel.md / project_noip_local_public_cutover.md. Ingress issues may be out-of-headless-reach (UAC portproxy, Spectrum router — spectrum.net creds in mc-secrets)." \
    "in: laptop infra (ingress/pm2/kb/disk/ram)" \
    "why: silent self-heal exhausted or action needs Mike's approval; no phone pings — this capsule IS the holler." \
    "=: the failing sentinel probe passes and the log shows a clean cycle" > "$f"
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
    echo "$PM2_FAILS" | grep -q "$p(" && "$PM2" restart "$p" >/dev/null 2>&1
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
    [ -n "${DNS_FAILS// /}" ] && spawn_fixer dns "DNS still not matching WAN $IP after forced push:$DNS_FAILS (NOTE: noip_duc.sh has a hotspot/CGNAT guard — it refuses to push an IP that doesn't serve :443 externally; check ~/logs/noip-duc.log before overriding)" \
      || log "DNS self-heal OK"
  fi
fi

# 4. cert expiry
DAYS=$(probe_cert)
if [ "$DAYS" -lt 14 ]; then
  log "cert expires in ${DAYS}d — renewing"
  sudo certbot renew -q --no-random-sleep-on-renew >/dev/null 2>&1 && sudo service nginx reload >/dev/null 2>&1
  DAYS=$(probe_cert)
  [ "$DAYS" -lt 14 ] && spawn_fixer cert "cert still expiring in ${DAYS}d after certbot renew; letsencrypt.log tail: $(sudo tail -5 /var/log/letsencrypt/letsencrypt.log 2>/dev/null | tr '\n' ' | ')"
fi

# 4b. mc-kb hive-mind :8091 — pm2 "online" can mask a hung HTTP loop
KB=$(probe_kb)
case "$KB" in
  2*) clear_issue kb;;
  *)
    log "mc-kb :8091 /health=$KB — restarting mc-kb-server"
    [ -x "$PM2" ] && "$PM2" restart mc-kb-server >/dev/null 2>&1
    # mc-kb loads LanceDB embeddings at boot (~30-60s) — poll, don't one-shot
    for i in 1 2 3 4 5 6; do sleep 10; KB=$(probe_kb); case "$KB" in 2*) break;; esac; done
    case "$KB" in
      2*) log "mc-kb self-heal OK";;
      *) spawn_fixer kb "mc-kb :8091 /health still $KB after pm2 restart mc-kb-server" \
           || escalate_capsule kb "mc-kb hive-mind :8091 unhealthy (/health=$KB) after restart + fixer attempts — Boba/Jazzy lose memory recall each cycle";;
    esac;;
esac

# 4b2. massage booking-flow deep probe (vhost 200 can hide a broken booking page/API)
MF=$(probe_massage_flow)
if [ "$MF" != "OK" ]; then
  log "massage booking-flow degraded ($MF) — restarting massage-api"
  [ -x "$PM2" ] && "$PM2" restart massage-api >/dev/null 2>&1
  sleep 10; MF=$(probe_massage_flow)
  if [ "$MF" = "OK" ]; then log "massage-flow self-heal OK"
  else spawn_fixer massageflow "massage booking flow still degraded after pm2 restart massage-api: $MF (probe: GET :3003/booking + :3003/api/health)" \
       || escalate_capsule massageflow "massage booking flow degraded ($MF) after restart + fixer attempts — clients can't book"; fi
else clear_issue massageflow; fi

# 4b3. Tailscale serve drift (Mike-private phone access) — detect-only
TS=$(probe_ts_drift)
if [ "$TS" = "DRIFT" ]; then
  log "tailscale serve map DRIFTED from baseline"
  escalate_capsule tsdrift "tailscale serve map differs from baseline $TS_EXPECTED — phone access routes may be broken. Compare: tailscale serve status vs the expected file. If the change was deliberate, refresh baseline: tailscale serve status | grep -E 'ts.net|proxy' | tr -s ' ' | sort > $TS_EXPECTED"
else clear_issue tsdrift; fi

# 4c. pm2 crash-loop detector — DETECT ONLY for non-revivables (trading daemons are
# hands-off per the live-trader protocol); a looping proc burns CPU + spams logs silently
LOOPING=$(probe_crashloop)
if [ -n "${LOOPING// /}" ]; then
  log "CRASH-LOOP detected:$LOOPING"
  for name in $LOOPING; do
    n=${name%%(*}
    today=$(date +%F)
    [ -n "$(sget "loopcap_${n}_$today")" ] && continue   # one capsule per proc per day
    sset "loopcap_${n}_$today" 1
    f=$(mktemp)
    printf '%s\n' "@sentinel-crashloop-$n-$(date +%m%d)" \
      "do: pm2 process '$n' is CRASH-LOOPING ($name restarts in one 10-min sentinel cycle). Diagnose via pm2 logs $n --lines 100 + pm2 describe $n. Sentinel does NOT auto-restart it (may be a trading daemon — live-trader protocol). Fix the root cause or stop it deliberately." \
      "in: pm2 fleet (laptop)" \
      "why: silent crash-loops burn CPU and mask real failures; Mike wants no phone pings — capsule is the holler." \
      "=: pm2 shows '$n' stable (restart counter flat across 2+ sentinel cycles) or deliberately stopped" > "$f"
    ~/bin/intent-queue add --source restructure --file "$f" >/dev/null 2>&1 && log "ESCALATED crash-loop '$n' -> intent capsule"
    rm -f "$f"
  done
fi

# 4d. disk / RAM pressure — detect + capsule only (no deletes, no session kills;
# feedback_no_interfere_working_chats + never-delete-without-approval)
DISK=$(probe_disk)
if [ -n "$DISK" ] && [ "$DISK" -ge "$DISK_PCT_MAX" ]; then
  log "DISK pressure: / at ${DISK}% (threshold ${DISK_PCT_MAX}%)"
  escalate_capsule disk "root filesystem at ${DISK}% used — reclaim candidates: pm2 flush, ~/logs rotation, wsl vhdx compaction (memory reference_wsl_vhdx_compaction), chat archives. NO deletes without Mike."
else clear_issue disk; fi
RAM=$(probe_ram)
if [ -n "$RAM" ] && [ "$RAM" -lt "$RAM_AVAIL_MIN_MB" ]; then
  log "RAM pressure: MemAvailable=${RAM}MB (floor ${RAM_AVAIL_MIN_MB}MB)"
  escalate_capsule ram "MemAvailable ${RAM}MB below ${RAM_AVAIL_MIN_MB}MB floor — check vmmem/ComfyUI/browser bloat (memory reference_vmmem_wsa_ram). NEVER kill live Claude sessions (feedback_no_interfere_working_chats)."
else clear_issue ram; fi

# 4e. Tier B: flow-signal staleness — DETECT-ONLY, one capsule per day (holiday-tolerant)
FLOW=$(probe_flow_stale)
if [ "$FLOW" != "OK" ]; then
  log "FLOW-SIGNAL degraded: $FLOW"
  escalate_capsule "flowstale-$(date +%m%d)" "merged flow-signal stream degraded during market hours ($FLOW) — newest $FLOW_DIR/*_alerts_today.json too old; scrapers may be down. READ-ONLY diagnosis (pm2 describe option-signals/option-relay + their logs); NEVER touch the merged stream files (Boba/Jazzy/best3 consume them). If today is a market holiday, drop this capsule."
fi

# 4f. Tier B: decision-cycle heartbeats — DETECT-ONLY (trade-changing layer = Mike's go)
CYC=$(probe_cycles)
if [ -n "${CYC// /}" ]; then
  log "DECISION-CYCLE heartbeat missed:$CYC"
  escalate_capsule "cycmiss-$(date +%m%d)" "decision cycle(s) missed their success-heartbeat:$CYC. Heartbeats: $HB_DIR/{boba,jazzy}_cycle (touched only on clean cron exit); logs ~/02_DATA/{boba,jazzy}_cycle.log. DETECT-ONLY per live-trader protocol — diagnose, then Mike decides any fix. If market holiday, drop this capsule."
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
