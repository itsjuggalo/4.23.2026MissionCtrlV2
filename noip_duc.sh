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

HOSTS="missionctrl.serveftp.com bridge.serveftp.com massagebymike.serveftp.com bobacattrades.serveftp.com"
STATE="$HOME/.openclaw/state/noip_last_ip.txt"
LOG_TS() { TZ=America/New_York date '+%Y-%m-%d %I:%M:%S %p ET'; }

. "$HOME/.openclaw/secrets/noip.env" 2>/dev/null || { echo "$(LOG_TS)  no noip.env — cannot update"; exit 1; }

IP=$(curl -s -m 10 https://api.ipify.org 2>/dev/null)
case "$IP" in
  *[!0-9.]*|"") exit 0 ;;   # transient lookup failure — try next tick, never push garbage
esac

LAST=$(cat "$STATE" 2>/dev/null || echo "")
[ "$IP" = "$LAST" ] && exit 0

mkdir -p "$(dirname "$STATE")"
ok=1
for h in $HOSTS; do
  r=$(curl -s -m 15 -u "$NOIP_USER:$NOIP_PASS" -A "mc-noip-update/1.0 $NOIP_USER" \
      "https://dynupdate.no-ip.com/nic/update?hostname=${h}&myip=${IP}" 2>/dev/null)
  echo "$(LOG_TS)  $h -> $IP : $r"
  case "$r" in good*|nochg*) ;; *) ok=0 ;; esac
done
[ "$ok" = 1 ] && echo "$IP" > "$STATE"
