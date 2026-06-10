#!/usr/bin/env bash
# tunnel_watchdog.sh — mid-uptime guard for the laptop→Oracle reverse tunnels.
#
# Why: 2026-06-09 the serveftp tunnel (-R 3300) went zombie mid-uptime — autossh
# process alive, remote bind dead — and the public mirror served nothing for hours.
# Same mode hit 8091 (hive-mind) that morning. wsl-boot-check only probes at boot.
#
# What it does, every cron tick:
#   1. One ssh to Oracle: for each tunnel port (3300, 8091) check the remote bind
#      (ss) AND an HTTP probe through it.
#   2. Bind DEAD  -> kill local autossh/ssh procs for that forward, relaunch the
#      canonical tunnel (with ExitOnForwardFailure so future zombies self-heal),
#      re-verify, Discord-alert the outcome (30-min suppression per port).
#   3. Bind LISTEN but HTTP failing -> the LAPTOP service (:3000 / :8091) is the
#      problem, not the tunnel: alert only, never touch services (heal-alert-only rule).
#   4. Oracle unreachable -> alert only (suppressed), no thrashing.
#
# Cron: */5 * * * * /bin/bash /home/itsju/scripts/tunnel_watchdog.sh >> /home/itsju/logs/tunnel-watchdog.log 2>&1
set -u

WEBHOOK_FILE="$HOME/.openclaw/secrets/discord_daemon_health_webhook"
SUPPRESS_S=1800

ts() { TZ=America/New_York date '+%Y-%m-%d %I:%M:%S %p ET'; }

alert() { # alert <port> <message>
  local port="$1" msg="$2"
  local stamp="/tmp/tunnel_watchdog_alert_${port}.epoch"
  local now last
  now=$(date +%s); last=$(cat "$stamp" 2>/dev/null || echo 0)
  [ $(( now - last )) -lt "$SUPPRESS_S" ] && { echo "$(ts)  [${port}] alert suppressed (<30m): $msg"; return 0; }
  local wh; wh="$(cat "$WEBHOOK_FILE" 2>/dev/null)"
  if [ -n "$wh" ]; then
    if curl -sf -m 10 -A "missionctrl-tunnel-watchdog/1.0" -H 'Content-Type: application/json' \
        -d "{\"content\":\"🔌 **tunnel watchdog** [$port] — ${msg} ($(ts))\"}" "$wh" >/dev/null; then
      echo "$now" > "$stamp"
    else
      echo "$(ts)  [${port}] discord post FAILED: $msg"
    fi
  else
    echo "$(ts)  [${port}] no daemon-health webhook file: $msg"
  fi
}

relaunch() { # relaunch <port>
  local port="$1"
  case "$port" in
    3300) pkill -f -- '-R 3300:localhost:3000' 2>/dev/null
          sleep 1
          autossh -M 0 -fN -o ServerAliveInterval=30 -o ServerAliveCountMax=3 \
                  -o ExitOnForwardFailure=yes -R 3300:localhost:3000 openclaw ;;
    8091) pkill -f -- '-R 127.0.0.1:8091:127.0.0.1:8091' 2>/dev/null
          sleep 1
          autossh -M 0 -fN -o ServerAliveInterval=30 -o ServerAliveCountMax=3 \
                  -o ExitOnForwardFailure=yes -R 127.0.0.1:8091:127.0.0.1:8091 openclaw ;;
  esac
}

probe() { # probe -> lines "port BINDSTATE httpcode"
  ssh -o BatchMode=yes -o ConnectTimeout=10 openclaw '
    for p in 3300 8091; do
      if ss -ltn 2>/dev/null | grep -q ":${p} "; then s=LISTEN; else s=DEAD; fi
      if [ "$p" = 3300 ]; then u="http://127.0.0.1:3300/"; else u="http://127.0.0.1:8091/health"; fi
      c=$(curl -s -o /dev/null -w "%{http_code}" -m 6 "$u" 2>/dev/null || echo ERR)
      echo "$p $s $c"
    done' 2>/dev/null
}

main() {
  local out; out="$(probe)"
  if [ -z "$out" ]; then
    alert oracle "Oracle unreachable over ssh — cannot verify tunnels (no action taken)"
    return 0
  fi
  while read -r port bind code; do
    [ -z "${port:-}" ] && continue
    local ok=false
    case "$code" in 2*|3*) ok=true ;; esac
    if [ "$bind" = "LISTEN" ] && $ok; then
      continue                                   # healthy — stay quiet
    elif [ "$bind" = "DEAD" ]; then
      echo "$(ts)  [${port}] remote bind DEAD — relaunching tunnel"
      relaunch "$port"
      sleep 5
      local re; re="$(probe | awk -v p="$port" '$1==p {print $2" "$3}')"
      if echo "$re" | grep -q "^LISTEN" ; then
        alert "$port" "remote bind was DEAD — tunnel relaunched OK (now: $re)"
        echo "$(ts)  [${port}] relaunch OK ($re)"
      else
        alert "$port" "remote bind DEAD and relaunch FAILED (now: ${re:-no-data}) — needs hands"
        echo "$(ts)  [${port}] relaunch FAILED ($re)"
      fi
    else
      # bind alive, HTTP failing -> laptop-side service problem; alert-only by rule
      alert "$port" "tunnel bind alive but HTTP=$code through it — laptop service for $port likely down (alert-only, no restart)"
      echo "$(ts)  [${port}] bind LISTEN but HTTP=$code — service-side issue, alert only"
    fi
  done <<< "$out"
}

main
