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

mkdir -p "$(dirname "$LOG")"
echo "[$(date -u +%FT%TZ)] ===== kronos_train_weekly starting =====" | tee -a "$LOG"

# Don't run if another training job is already in progress
if systemctl --user is-active --quiet kronos-training.service || \
   systemctl --user is-active --quiet kronos-train-daily.service; then
    echo "[$(date -u +%FT%TZ)] Another Kronos training job is active — skipping weekly run." | tee -a "$LOG"
    exit 0
fi

# Step 1: Fetch fresh data
echo "[$(date -u +%FT%TZ)] Fetching fresh Alpaca bars..." | tee -a "$LOG"
$PYTHON "$PREP" >> "$LOG" 2>&1
if [ $? -ne 0 ]; then
    echo "[$(date -u +%FT%TZ)] Data fetch failed — aborting." | tee -a "$LOG"
    exit 1
fi

# Step 2: Full cold-start retrain (10 tokenizer + 8 basemodel epochs)
echo "[$(date -u +%FT%TZ)] Starting weekly full retrain..." | tee -a "$LOG"
cd "$TRAIN_DIR"
$PYTHON train_sequential.py --config "$CONFIG" >> "$LOG" 2>&1

if [ $? -eq 0 ]; then
    echo "[$(date -u +%FT%TZ)] Weekly retrain complete. Weights updated." | tee -a "$LOG"
else
    echo "[$(date -u +%FT%TZ)] Weekly retrain exited non-zero — check log." | tee -a "$LOG"
    exit 1
fi

echo "[$(date -u +%FT%TZ)] ===== kronos_train_weekly done =====" | tee -a "$LOG"
