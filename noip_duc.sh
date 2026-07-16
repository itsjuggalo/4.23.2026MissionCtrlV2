#!/usr/bin/env bash
# noip_duc.sh — free DUC replacement: keep the No-IP serveftp hostnames pinned to the
# home WAN IP (Spectrum residential = dynamic). Created 2026-07-12 when Oracle (openclaw)
# was retired and public ingress moved to laptop + No-IP direct (Mike's call).
#
# Every cron tick: get current WAN IP; if it differs from the last-pushed IP, push all
# hostnames via the No-IP dynupdate API and record the result. Silent when nothing changed.
# Creds: ~/.openclaw/secrets/noip.env (NOIP_USER / NOIP_PASS; also in mc-secrets sqlite).
# Cron: */5 * * * *  (No-IP TTL is 60s; a 5-min lag on an IP change is acceptable.)
set -u

# massagebymike + missionctrl + bobacattrades REMOVED 2026-07-16: they now
# point at Vercel (A 76.76.21.21, Vercel-primary cutover) — pushing the home
# WAN IP to them would blackhole the sites. Only laptop-resident hostnames
# belong here (bridge = TV webhooks + the Vercel fronts' API backhaul).
HOSTS="bridge.serveftp.com claudeclaw.serveftp.com"
STATE="$HOME/.openclaw/state/noip_last_ip.txt"
LOG_TS() { TZ=America/New_York date '+%Y-%m-%d %I:%M:%S %p ET'; }

. "$HOME/.openclaw/secrets/noip.env" 2>/dev/null || { echo "$(LOG_TS)  no noip.env — cannot update"; exit 1; }

IP=$(curl -s -m 10 https://api.ipify.org 2>/dev/null)
case "$IP" in
  *[!0-9.]*|"") exit 0 ;;   # transient lookup failure — try next tick, never push garbage
esac

LAST=$(cat "$STATE" 2>/dev/null || echo "")
[ "$IP" = "$LAST" ] && exit 0

# --- hotspot/CGNAT guard (2026-07-13) ---------------------------------------
# Never repoint DNS to a WAN IP that can't actually serve our ingress: a phone
# hotspot or CGNAT egress (e.g. Verizon 174.211.x observed 07-12) would blackhole
# all 4 domains while the home router keeps serving fine on the old IP.
python3 -c "import ipaddress,sys; sys.exit(0 if ipaddress.ip_address('$IP').is_global else 1)" \
  || { echo "$(LOG_TS)  WAN $IP is not a global IP (CGNAT/private) — holding DNS on ${LAST:-unset}"; exit 0; }

probe443(){ # <ip> -> OK/FAIL/SKIP : is candidate_ip:443 reachable from outside?
  local id
  id=$(curl -s -m 15 -H 'Accept: application/json' \
      "https://check-host.net/check-tcp?host=${1}:443&max_nodes=2" \
      | python3 -c 'import sys,json;print(json.load(sys.stdin).get("request_id",""))' 2>/dev/null)
  [ -z "$id" ] && { echo SKIP; return; }
  sleep 12
  curl -s -m 10 -H 'Accept: application/json' "https://check-host.net/check-result/$id" 2>/dev/null | python3 -c '
import sys,json
try: d=json.load(sys.stdin)
except Exception: print("SKIP"); raise SystemExit
vals=[v for v in d.values() if v]
if not vals: print("SKIP"); raise SystemExit
print("OK" if any(isinstance(v[0],dict) and "time" in v[0] for v in vals) else "FAIL")'
}

SKIPS="$HOME/.openclaw/state/noip_probe_skips.txt"
MAX_SKIPS=6                       # ~30 min at the */5 cron cadence

if [ -n "$LAST" ]; then           # first-ever push (no LAST) skips the probe
  mkdir -p "$(dirname "$SKIPS")"
  V=$(probe443 "$IP")
  if [ "$V" = "FAIL" ]; then
    echo "$(LOG_TS)  WAN $IP does NOT serve :443 externally (hotspot/CGNAT or router down) — holding DNS on $LAST"
    echo 0 > "$SKIPS"
    exit 0
  fi
  if [ "$V" = "SKIP" ]; then
    # Probe service unreachable => the candidate IP is UNVERIFIED. Fail CLOSED.
    # is_global does NOT catch a hotspot egress (174.211.97.237 is a global IP),
    # so probe443 is the only real guard — pushing on SKIP is what blackholed all
    # 5 domains on 07-12. Holding costs a few minutes on a legit IP change; the
    # escape hatch below stops a dead probe service stranding DNS on a stale IP.
    n=$(( $(cat "$SKIPS" 2>/dev/null || echo 0) + 1 ))
    echo "$n" > "$SKIPS"
    if [ "$n" -lt "$MAX_SKIPS" ]; then
      echo "$(LOG_TS)  probe unavailable (skip $n/$MAX_SKIPS) — cannot verify $IP serves :443, holding DNS on $LAST"
      exit 0
    fi
    echo "$(LOG_TS)  probe unavailable $n consecutive ticks — pushing $IP UNVERIFIED (stale-DNS escape hatch)"
  fi
  echo 0 > "$SKIPS"
fi
# ---------------------------------------------------------------------------

mkdir -p "$(dirname "$STATE")"
ok=1
for h in $HOSTS; do
  r=$(curl -s -m 15 -u "$NOIP_USER:$NOIP_PASS" -A "mc-noip-update/1.0 $NOIP_USER" \
      "https://dynupdate.no-ip.com/nic/update?hostname=${h}&myip=${IP}" 2>/dev/null)
  echo "$(LOG_TS)  $h -> $IP : $r"
  case "$r" in good*|nochg*) ;; *) ok=0 ;; esac
done
[ "$ok" = 1 ] && echo "$IP" > "$STATE"
