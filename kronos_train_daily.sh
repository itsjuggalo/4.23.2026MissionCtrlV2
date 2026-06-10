#!/bin/bash
# Kronos daily maintenance retrainer
# Runs Mon-Fri at 02:00 ET via kronos-train-daily.timer (quiet overnight window)
# 1. Fetches fresh Alpaca bars (updates the training CSV) — the "new information"
# 2. Warm-starts from yesterday's finetuned weights, trains 3+2 epochs (~2-4h on a quiet box)
# 3. Overwrites finetuned weights in place — ready before the 08:00 ET forecast refresh
# Guarded by kronos-watchdog.timer (03:00/06:00/07:30 ET); log rotated by kronos-logrotate.timer (01:30 ET)
set -uo pipefail

# Lock HF_HOME to WSL ext4 (NEVER /mnt/c — that caused the 2026-05-31 crash)
export HF_HOME="${HF_HOME:-$HOME/.cache/huggingface}"

# Run pre-flight: VRAM check + VRAM hog eviction + disk/HF safety gates
bash "$HOME/bin/kronos-preflight.sh" || exit 1

PYTHON=/home/itsju/02_DATA/mc-kb/.venv/bin/python
export PYTHONUNBUFFERED=1   # flush log lines immediately so the watchdog's mtime check is faithful
PREP=/home/itsju/05_AUTOMATION/scripts/kronos_finetune_prep.py
TRAIN_DIR=/home/itsju/04_RESEARCH/Kronos/finetune_csv
CONFIG=configs/config_us_stocks_1h_daily.yaml
FINETUNED_DIR=/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h
LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_train_daily.log
WEBHOOK_FILE=/home/itsju/.openclaw/secrets/discord-webhook-kronos.txt
PING=/home/itsju/scripts/ping_mike.py

notify_discord() {
    local title="$1" msg="$2" color="$3"
    local webhook; webhook=$(cat "$WEBHOOK_FILE" 2>/dev/null) || return
    curl -s -X POST "$webhook" \
        -H "Content-Type: application/json" \
        -d "{\"embeds\":[{\"title\":\"$title\",\"description\":\"$msg\",\"color\":$color}]}" \
        > /dev/null
}

notify_telegram() {
    /usr/bin/python3 "$PING" "$1" >/dev/null 2>&1 || true
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
    notify_telegram "❌ Kronos daily retrain FAILED — Alpaca data fetch error. Stale weights kept. Check logs/kronos_train_daily.log"
    exit 1
fi

# Step 2: Train with daily config (warm-start from finetuned weights)
echo "[$(date -u +%FT%TZ)] Starting daily fine-tune (3 tokenizer + 2 basemodel epochs)..." | tee -a "$LOG"
cd "$TRAIN_DIR"
$PYTHON train_sequential.py --config "$CONFIG" >> "$LOG" 2>&1
TRAIN_EXIT=$?

ELAPSED_MIN=$(( ($(date +%s) - $(date -d "${START_TS/T/ }" +%s 2>/dev/null || echo 0)) / 60 ))
if [ $TRAIN_EXIT -eq 0 ]; then
    echo "[$(date -u +%FT%TZ)] Daily fine-tune complete. Weights updated." | tee -a "$LOG"
    VAL_LOSS=$(grep -oE "Best validation loss: [0-9.]+" "$LOG" | tail -1 | grep -oE "[0-9.]+$")
    notify_discord "✅ Kronos Daily Retrain Done" "3 tokenizer + 2 basemodel epochs complete in ~${ELAPSED_MIN}min. Best val loss: ${VAL_LOSS:-n/a}. Finetuned weights updated. 8 AM forecast refresh will use fresh model." 3066993
    notify_telegram "✅ Kronos daily retrain DONE in ~${ELAPSED_MIN}min. Best val loss: ${VAL_LOSS:-n/a}. Weights updated; 8 AM forecast refresh will use the fresh model."
else
    echo "[$(date -u +%FT%TZ)] Daily fine-tune exited non-zero — check log. Yesterday's weights still in place." | tee -a "$LOG"
    notify_discord "❌ Kronos Daily Failed" "Training exited non-zero at $(date -u +%FT%TZ). Yesterday's weights still in place. Check: \`logs/kronos_train_daily.log\`" 15158332
    notify_telegram "❌ Kronos daily retrain FAILED — training exited non-zero after ~${ELAPSED_MIN}min. Yesterday's weights kept. Check logs/kronos_train_daily.log"
    exit 1
fi

echo "[$(date -u +%FT%TZ)] ===== kronos_train_daily done =====" | tee -a "$LOG"
