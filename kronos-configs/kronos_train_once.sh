#!/bin/bash
# Runs Kronos fine-tune training once. Skips if sentinel exists (already completed).
SENTINEL=/home/itsju/04_RESEARCH/Kronos/finetune_csv/finetuned/us_stocks_1h/.training_14ticker_complete
LOG=/home/itsju/04_RESEARCH/Kronos/finetune_csv/train_us_stocks_1h.log
WEBHOOK_FILE=/home/itsju/.openclaw/secrets/discord-webhook-kronos.txt

notify_discord() {
    local title="$1" msg="$2" color="$3"
    local webhook; webhook=$(cat "$WEBHOOK_FILE" 2>/dev/null) || return
    curl -s -X POST "$webhook" \
        -H "Content-Type: application/json" \
        -d "{\"embeds\":[{\"title\":\"$title\",\"description\":\"$msg\",\"color\":$color}]}" \
        > /dev/null
}

if [ -f "$SENTINEL" ]; then
    echo "[$(date -u +%FT%TZ)] Training already complete, skipping." >> "$LOG"
    exit 0
fi

START_TS=$(date -u +%FT%TZ)
echo "[$START_TS] kronos_train_once starting..." >> "$LOG"
cd /home/itsju/04_RESEARCH/Kronos/finetune_csv
/home/itsju/02_DATA/mc-kb/.venv/bin/python train_sequential.py \
    --config configs/config_us_stocks_1h.yaml >> "$LOG" 2>&1
TRAIN_EXIT=$?

ELAPSED_MIN=$(( ($(date +%s) - $(date -d "${START_TS/T/ }" +%s 2>/dev/null || echo 0)) / 60 ))
if [ $TRAIN_EXIT -eq 0 ]; then
    touch "$SENTINEL"
    echo "[$(date -u +%FT%TZ)] Training complete. Sentinel written." >> "$LOG"
    notify_discord "✅ Kronos Initial Training Done" "Full 14-ticker fine-tune complete in ~${ELAPSED_MIN}min (10 tokenizer + 8 basemodel epochs). Finetuned weights are now live. Daily + weekly retrains will use these as their base." 3066993
else
    echo "[$(date -u +%FT%TZ)] Training exited non-zero — will retry on next boot." >> "$LOG"
    notify_discord "❌ Kronos Initial Training Failed" "Training exited non-zero after ~${ELAPSED_MIN}min. Will retry on next WSL boot. Check: \`train_us_stocks_1h.log\`" 15158332
fi
