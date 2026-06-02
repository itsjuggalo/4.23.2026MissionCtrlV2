#!/bin/bash
# wsl-recover.sh — One-command WSL Mission Control recovery after crash
# Run this after: wsl --shutdown + wsl re-entry, or after any PM2 wipeout
# Usage: bash ~/scripts/wsl-recover.sh [--skip-tailscale]

set -e
echo "=== WSL Recovery $(date) ==="

# 1. Tailscale (skip if flag set or already up)
if [[ "$1" != "--skip-tailscale" ]]; then
  echo "[1/4] Starting tailscaled..."
  sudo tailscaled --state=/var/lib/tailscale/tailscaled.state &>/tmp/tailscaled.log &
  sleep 3
  tailscale up --accept-dns=false --hostname=g59-wsl 2>/dev/null && echo "  tailscale: UP" || echo "  tailscale: already up or skipped"
else
  echo "[1/4] Tailscale: skipped"
fi

# 2. PM2 resurrect
echo "[2/4] Resurrecting PM2 processes..."
pm2 resurrect
pm2 list --no-color | grep -c online | xargs -I{} echo "  {} processes online"

# 3. Verify critical services
echo "[3/4] Verifying critical ports..."
for name_port in "missionctrl:3000" "aries:1337" "aries-quant:1338" "claudeclaw:3141"; do
  name="${name_port%%:*}"
  port="${name_port##*:}"
  if curl -s -o /dev/null -w "%{http_code}" "http://localhost:$port/api/health" 2>/dev/null | grep -q "200\|404"; then
    echo "  :$port ($name) OK"
  else
    echo "  :$port ($name) — not responding, attempting pm2 restart $name..."
    pm2 restart "$name" 2>/dev/null || true
  fi
done

# 4. HF_HOME sanity check
echo "[4/4] HF_HOME check..."
if [[ -z "$HF_HOME" ]]; then
  echo "  WARNING: HF_HOME not set — source ~/.bashrc first or models will fill WSL disk"
else
  echo "  HF_HOME=$HF_HOME (OK)"
fi

echo ""
echo "=== Recovery complete. Run 'pm2 list' to verify. ==="
echo "    Dashboard: http://localhost:3000"
echo "    ARIES:     http://localhost:1337"
echo "    ClaudeClaw: http://localhost:3141"
