#!/bin/bash
export PATH=/home/ubuntu/.local/bin:/home/ubuntu/.npm-global/bin:/usr/local/bin:/usr/bin:/bin
set -e
REPO=/home/ubuntu/mission-control-restored
LOG=/home/ubuntu/scripts/linear-autofix/autofix.log
WEBHOOK=$(cat /home/ubuntu/.openclaw/secrets/discord_webhook_autofix)
STAMP=$(TZ=America/New_York date '+%Y-%m-%d %H:%M:%S ET')
cd "$REPO"
HEAD_BEFORE=$(git rev-parse HEAD)
echo "[$STAMP] start (head=$HEAD_BEFORE)" >> "$LOG"
/home/ubuntu/.local/bin/claude --dangerously-skip-permissions -p "Use the linear MCP to list issues in team MissionCtrl with state Todo or Backlog created in the last 30 minutes. For each one with a Sentry stack trace or attachment: read the trace, locate the file in this repo, fix the bug in place (preserve features), commit with 'fix: MIS-N <short>', push to origin main, and update the issue state to In Review with a comment linking the commit. If none match, print NO_NEW_ISSUES." >> "$LOG" 2>&1
HEAD_AFTER=$(git rev-parse HEAD)
if [ "$HEAD_BEFORE" != "$HEAD_AFTER" ]; then
  COMMIT_MSG=$(git log -1 --pretty=%s)
  COMMIT_URL="https://github.com/itsjuggalo/4.23.2026MissionCtrlV2/commit/$HEAD_AFTER"
  curl -s -H "Content-Type: application/json" -X POST -d "{\"username\":\"Autofix Bot\",\"embeds\":[{\"title\":\"Claude shipped a fix\",\"description\":\"\`\`\`$COMMIT_MSG\`\`\`\",\"url\":\"$COMMIT_URL\",\"color\":3066993,\"timestamp\":\"$(date -u +%Y-%m-%dT%H:%M:%SZ)\"}]}" "$WEBHOOK" > /dev/null
fi
echo "[$STAMP] done (head=$HEAD_AFTER)" >> "$LOG"
