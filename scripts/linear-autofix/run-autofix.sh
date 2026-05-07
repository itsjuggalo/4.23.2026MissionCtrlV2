#!/bin/bash
set -e
cd /home/ubuntu/mission-control-restored
LOG=/home/ubuntu/scripts/linear-autofix/autofix.log
STAMP=$(TZ=America/New_York date '+%Y-%m-%d %H:%M:%S ET')
echo "[$STAMP] start" >> "$LOG"
claude --dangerously-skip-permissions -p "Use the linear MCP to list issues in team MissionCtrl with state Todo or Backlog created in the last 30 minutes that have a Sentry stack trace in the description. For each one: read the stack trace, locate the file in this repo, fix the bug in place (preserve features), commit with message 'fix: MIS-N <short>', push to origin main, and update the Linear issue state to In Review with a comment linking the commit. If no matching issues, print NO_NEW_ISSUES and exit." >> "$LOG" 2>&1
echo "[$STAMP] done" >> "$LOG"
