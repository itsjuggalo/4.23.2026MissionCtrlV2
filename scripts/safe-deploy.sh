#!/usr/bin/env bash
# Safe Deploy — build must succeed before restarting mission-control
# Usage: bash safe-deploy.sh "your commit message"
set -euo pipefail

MC_DIR="/home/ubuntu/mission-control"
MSG="${1:-chore: update}"

echo "🔨 Building..."
cd "$MC_DIR"

if timeout 180 npm run build; then
  echo "✅ Build succeeded. Restarting mission-control..."
  pm2 restart mission-control --update-env
  echo "✅ Mission Control live."
  cd "$MC_DIR"
  git add -A && git commit -m "$MSG" 2>/dev/null && echo "✅ Committed: $MSG" || echo "ℹ️  Nothing to commit."
else
  echo "❌ Build FAILED. Mission Control NOT restarted. Fix the errors above."
  exit 1
fi
