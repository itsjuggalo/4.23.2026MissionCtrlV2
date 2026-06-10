#!/usr/bin/env bash
# run_aime_flow_desk.sh — cron wrapper for the AIME Flow Desk.
#   --digest : 30-min AIME flow read  (cron: :00/:30 market hours)
#   --t0     : instant T0/T1 reaction (cron: every 5 min market hours)
# AIME uses the ainvest cookie (not the Anthropic API); ANTHROPIC_API_KEY unset for safety.
set -uo pipefail

MODE="${1:---digest}"
SCRIPT="/home/itsju/05_AUTOMATION/scripts/aime_flow_desk.py"
LOG_DIR="/home/itsju/05_AUTOMATION/logs"
LOCK="/tmp/aime_flow_desk_${MODE#--}.lock"
mkdir -p "$LOG_DIR"
LOG="${LOG_DIR}/aime_flow_desk_$(date +%Y%m%d).log"

exec 9>"$LOCK"
flock -n 9 || { echo "[$(date -Is)] skip ${MODE}: still running" >>"$LOG"; exit 0; }

unset ANTHROPIC_API_KEY
echo "[$(date -Is)] aime_flow_desk ${MODE} start" >>"$LOG"
timeout 150 /usr/bin/python3 "$SCRIPT" "$MODE" --post >>"$LOG" 2>&1
echo "[$(date -Is)] aime_flow_desk ${MODE} exit=$?" >>"$LOG"
