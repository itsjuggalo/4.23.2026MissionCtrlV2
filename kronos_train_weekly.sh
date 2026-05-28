#!/bin/bash
# Kronos weekly full retrain — cold start from HuggingFace pretrained weights
# Runs Sunday at 02:00 ET via kronos-train-weekly.timer
# 1. Fetches fresh Alpaca bars
# 2. Full 10 tokenizer + 8 basemodel epochs (~6-7h), finishes ~9 AM Sunday
# 3. Monday's daily warm-start builds on these fresh weekly weights
set -uo pipefail

PYTHON=/home/itsju/02_DATA/mc-kb/.venv/bin/python
PREP=/home/itsju/05_AUTOMATION/scripts/kronos_finetune_prep.py
TRAIN_DIR=/home/itsju/04_RESEARCH/Kronos/finetune_csv
CONFIG=configs/config_us_stocks_1h.yaml
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_train_weekly.log
WEBHOOK_FILE=/home/itsju/.openclaw/secrets/discord-webhook-kronos.txt

notify_discord() {
    local title="$1" msg="$2" color="$3"
    local webhook; webhook=$(cat "$WEBHOOK_FILE" 2>/dev/null) || return
    curl -s -X POST "$webhook" \
        -H "Content-Type: application/json" \
        -d "{\"embeds\":[{\"title\":\"$title\",\"description\":\"$msg\",\"color\":$color}]}" \
        > /dev/null
}

mkdir -p "$(dirname "$LOG")"
START_TS=$(date -u +%FT%TZ)
echo "[$START_TS] ===== kronos_train_weekly starting =====" | tee -a "$LOG"

# Don't run if another training job is already in progress
if systemctl --user is-active --quiet kronos-training.service || \
   systemctl --user is-active --quiet kronos-train-daily.service; then
    echo "[$(date -u +%FT%TZ)] Another Kronos training job is active — skipping weekly run." | tee -a "$LOG"
    notify_discord "⏭️ Kronos Weekly Skipped" "Another training job was already active at $START_TS. Weekly retrain skipped." 16776960
    exit 0
fi

# Step 1: Fetch fresh data
echo "[$(date -u +%FT%TZ)] Fetching fresh Alpaca bars..." | tee -a "$LOG"
$PYTHON "$PREP" >> "$LOG" 2>&1
if [ $? -ne 0 ]; then
    echo "[$(date -u +%FT%TZ)] Data fetch failed — aborting." | tee -a "$LOG"
    notify_discord "❌ Kronos Weekly Failed" "Data fetch from Alpaca failed at $START_TS. Retrain aborted. Check: \`logs/kronos_train_weekly.log\`" 15158332
    exit 1
fi

# Step 2: Full cold-start retrain (10 tokenizer + 8 basemodel epochs)
echo "[$(date -u +%FT%TZ)] Starting weekly full retrain..." | tee -a "$LOG"
cd "$TRAIN_DIR"
$PYTHON train_sequential.py --config "$CONFIG" >> "$LOG" 2>&1
TRAIN_EXIT=$?

ELAPSED_MIN=$(( ($(date +%s) - $(date -d "${START_TS/T/ }" +%s 2>/dev/null || echo 0)) / 60 ))
if [ $TRAIN_EXIT -eq 0 ]; then
    echo "[$(date -u +%FT%TZ)] Weekly retrain complete. Weights updated." | tee -a "$LOG"
    notify_discord "✅ Kronos Weekly Retrain Done" "Full cold-start retrain complete in ~${ELAPSED_MIN}min (10 tokenizer + 8 basemodel epochs). Fresh weights ready for Monday. Mon–Fri daily runs will warm-start from these." 3066993
else
    echo "[$(date -u +%FT%TZ)] Weekly retrain exited non-zero — check log." | tee -a "$LOG"
    notify_discord "❌ Kronos Weekly Failed" "Training exited non-zero at $(date -u +%FT%TZ). Last good weights still in place. Check: \`logs/kronos_train_weekly.log\`" 15158332
    exit 1
fi

echo "[$(date -u +%FT%TZ)] ===== kronos_train_weekly done =====" | tee -a "$LOG"
