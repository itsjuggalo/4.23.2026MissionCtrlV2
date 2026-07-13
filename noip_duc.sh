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

HOSTS="missionctrl.serveftp.com bridge.serveftp.com massagebymike.serveftp.com bobacattrades.serveftp.com claudeclaw.serveftp.com"
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

if [ -n "$LAST" ]; then           # first-ever push (no LAST) skips the probe
  V=$(probe443 "$IP")
  if [ "$V" = "FAIL" ]; then
    echo "$(LOG_TS)  WAN $IP does NOT serve :443 externally (hotspot/CGNAT or router down) — holding DNS on $LAST"
    exit 0
  fi
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
