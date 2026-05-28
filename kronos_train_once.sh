#!/bin/bash
# Runs Kronos fine-tune training once. Skips if sentinel exists (already completed).
SENTINEL=/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h/.training_14ticker_complete
LOG=/home/itsju/04_RESEARCH/Kronos/finetune_csv/train_us_stocks_1h.log

if [ -f "$SENTINEL" ]; then
    echo "[$(date -u +%FT%TZ)] Training already complete, skipping." >> "$LOG"
    exit 0
fi

echo "[$(date -u +%FT%TZ)] kronos_train_once starting..." >> "$LOG"
cd /home/itsju/04_RESEARCH/Kronos/finetune_csv
/home/itsju/02_DATA/mc-kb/.venv/bin/python train_sequential.py \
    --config configs/config_us_stocks_1h.yaml >> "$LOG" 2>&1

if [ $? -eq 0 ]; then
    touch "$SENTINEL"
    echo "[$(date -u +%FT%TZ)] Training complete. Sentinel written." >> "$LOG"
else
    echo "[$(date -u +%FT%TZ)] Training exited non-zero — will retry on next boot." >> "$LOG"
fi
