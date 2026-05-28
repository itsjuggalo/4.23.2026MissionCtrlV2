#!/bin/bash
# Kronos daily maintenance retrainer
# Runs Mon-Fri at 06:00 ET via kronos-train-daily.timer
# 1. Fetches fresh Alpaca bars (updates the training CSV)
# 2. Warm-starts from yesterday's finetuned weights, trains 3+2 epochs (~2h)
# 3. Overwrites finetuned weights in place — ready before 8 AM ET forecast refresh
set -uo pipefail

PYTHON=/home/itsju/02_DATA/mc-kb/.venv/bin/python
PREP=/home/itsju/05_AUTOMATION/scripts/kronos_finetune_prep.py
TRAIN_DIR=/home/itsju/04_RESEARCH/Kronos/finetune_csv
CONFIG=configs/config_us_stocks_1h_daily.yaml
FINETUNED_DIR=/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_train_daily.log
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
echo "[$START_TS] ===== kronos_train_daily starting =====" | tee -a "$LOG"

# Skip if initial full training hasn't completed yet (weights not ready)
if [ ! -f "$FINETUNED_DIR/basemodel/best_model/model.safetensors" ]; then
    echo "[$(date -u +%FT%TZ)] Finetuned weights not ready yet — skipping daily run." | tee -a "$LOG"
    notify_discord "⏭️ Kronos Daily Skipped" "Initial full training not yet complete — weights not ready. Daily retrain skipped." 16776960
    exit 0
fi

# Step 1: Fetch fresh data
echo "[$(date -u +%FT%TZ)] Fetching fresh Alpaca bars..." | tee -a "$LOG"
$PYTHON "$PREP" >> "$LOG" 2>&1
if [ $? -ne 0 ]; then
    echo "[$(date -u +%FT%TZ)] Data fetch failed — aborting. Stale weights kept." | tee -a "$LOG"
    notify_discord "❌ Kronos Daily Failed" "Data fetch from Alpaca failed at $START_TS. Stale weights kept. Check: \`logs/kronos_train_daily.log\`" 15158332
    exit 1
fi

# Step 2: Train with daily config (warm-start from finetuned weights)
echo "[$(date -u +%FT%TZ)] Starting daily fine-tune (3 tokenizer + 2 basemodel epochs)..." | tee -a "$LOG"
cd "$TRAIN_DIR"
$PYTHON train_sequential.py --config "$CONFIG" >> "$LOG" 2>&1

ELAPSED=$(( $(date +%s) - $(date -d "$START_TS" +%s 2>/dev/null || date +%s) ))
ELAPSED_MIN=$(( ELAPSED / 60 ))
if [ $? -eq 0 ]; then
    END_TS=$(date -u +%FT%TZ)
    echo "[$END_TS] Daily fine-tune complete. Weights updated." | tee -a "$LOG"
    notify_discord "✅ Kronos Daily Retrain Done" "3 tokenizer + 2 basemodel epochs complete in ~${ELAPSED_MIN}min. Finetuned weights updated. 8 AM forecast refresh will use fresh model." 3066993
else
    echo "[$(date -u +%FT%TZ)] Daily fine-tune exited non-zero — check log. Yesterday's weights still in place." | tee -a "$LOG"
    notify_discord "❌ Kronos Daily Failed" "Training exited non-zero at $(date -u +%FT%TZ). Yesterday's weights still in place. Check: \`logs/kronos_train_daily.log\`" 15158332
    exit 1
fi

echo "[$(date -u +%FT%TZ)] ===== kronos_train_daily done =====" | tee -a "$LOG"
