#!/usr/bin/env bash
# tunnel_8091_selfheal.sh — keep the mc-kb hive-mind reverse tunnel (laptop:8091 ->
# Oracle:8091) actually alive, not just process-alive.
#
# Failure class (2026-06-09): two forwarders (autossh + a stray manual ssh) competed
# for the remote bind; both ended up connected with NO listener on Oracle:8091 —
# boot-check only catches this at reboot, so the hive-mind was silently dark.
#
# Probe FROM ORACLE (the consumer side). Only when the probe fails: kill every local
# 8091 forwarder (they're provably useless at that point) and relaunch the canonical
# @reboot autossh. One healthy forwarder is never touched.
#
# Cron: */15 * * * *  (see "tunnel 8091 self-heal" crontab entry)
set -u
LOG="$HOME/logs/tunnel_8091_selfheal.log"
ts() { TZ=America/New_York date '+%Y-%m-%d %I:%M:%S %p ET'; }

probe() {
  ssh -o BatchMode=yes -o ConnectTimeout=10 openclaw \
    'curl -s -m 8 http://localhost:8091/health' 2>/dev/null | grep -q '"status": *"ok"'
}

if probe; then
  exit 0   # healthy — stay silent, touch nothing
fi

# SSH itself might be down (Oracle unreachable) — killing local forwarders then would
# be pointless churn. Only heal when SSH works but the tunnel endpoint is dead.
if ! ssh -o BatchMode=yes -o ConnectTimeout=10 openclaw true 2>/dev/null; then
  echo "$(ts) probe failed but Oracle SSH unreachable — not healing (network issue)" >> "$LOG"
  exit 0
fi

echo "$(ts) tunnel DEAD (ssh ok, 8091 probe failed) — healing" >> "$LOG"
pkill -f -- '-R 127.0.0.1:8091:127.0.0.1:8091' 2>/dev/null
sleep 2
# Clear any zombie remote bind so the fresh forwarder can take the port.
ssh -o BatchMode=yes -o ConnectTimeout=10 openclaw \
  'fuser -k 8091/tcp 2>/dev/null; true' >> "$LOG" 2>&1
autossh -M 0 -fN -o ServerAliveInterval=30 -o ServerAliveCountMax=3 \
  -R 127.0.0.1:8091:127.0.0.1:8091 openclaw >> "$LOG" 2>&1
sleep 5
if probe; then
  echo "$(ts) HEALED — Oracle reads 8091 ok" >> "$LOG"
else
  echo "$(ts) HEAL FAILED — manual attention needed (see mc-kb-server pm2 + Oracle sshd)" >> "$LOG"
fi
