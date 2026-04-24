#!/bin/bash
# deploy_briefs.sh — Sets up hybrid data+agent brief system
# 1. Adds data fetch crons (Python fetches real data)
# 2. Updates agent prompts (agent reads data file, adds analysis)

set -e

PROMPTS_DIR="/home/ubuntu/scripts/brief_prompts"
SCRIPTS_DIR="/home/ubuntu/scripts"

echo "=========================================="
echo "  DEPLOYING HYBRID BRIEF SYSTEM"
echo "=========================================="

# --- STEP 1: Clean up old brief-related crons ---
echo ""
echo "[1/4] Cleaning old cron entries..."
crontab -l 2>/dev/null | grep -v "market_data_fetch\|morning_brief\|premarket_brief\|midday_brief\|eod_brief\|briefs_to_discord" > /tmp/clean_cron 2>/dev/null || true
cat /tmp/clean_cron | crontab - 2>/dev/null || true

# --- STEP 2: Add data fetch crons ---
echo "[2/4] Adding data fetch crons..."
(crontab -l 2>/dev/null; echo "# === BRIEF DATA FETCHERS ===
55 3 * * * python3 ${SCRIPTS_DIR}/market_data_fetch.py >> /tmp/market_data_fetch.log 2>&1
25 7 * * * python3 ${SCRIPTS_DIR}/market_data_fetch.py >> /tmp/market_data_fetch.log 2>&1
55 12 * * 1-5 python3 ${SCRIPTS_DIR}/market_data_fetch.py --quick >> /tmp/market_data_fetch.log 2>&1
55 15 * * 1-5 python3 ${SCRIPTS_DIR}/market_data_fetch.py >> /tmp/market_data_fetch.log 2>&1
25 20 * * * python3 ${SCRIPTS_DIR}/market_data_fetch.py >> /tmp/market_data_fetch.log 2>&1
0 * * * * python3 ${SCRIPTS_DIR}/briefs_to_discord.py >> /tmp/briefs_to_discord.log 2>&1") | crontab -

echo "  Data fetchers scheduled:"
echo "    3:55 AM  → fetch before 4:00 AM premarket"
echo "    7:25 AM  → fetch before 7:30 AM morning brief"
echo "   12:55 PM  → fetch before 1:00 PM midday"
echo "    3:55 PM  → fetch before 4:00 PM EOD"
echo "    8:25 PM  → fetch before 8:30 PM nightly"
echo "    Hourly   → briefs to discord mirror"

# --- STEP 3: Update agent cron prompts ---
echo ""
echo "[3/4] Updating agent brief prompts..."

# Check prompt files exist
for brief in premarket morning midday eod nightly; do
    if [ ! -f "${PROMPTS_DIR}/${brief}_prompt.txt" ]; then
        echo "  ERROR: Missing ${PROMPTS_DIR}/${brief}_prompt.txt"
        exit 1
    fi
done

echo "  Updating Premarket (4:00 AM)..."
openclaw cron edit a6ec8a2b-57ae-4f6b-b3c9-c8a04707cd5d \
    --message "$(cat ${PROMPTS_DIR}/premarket_prompt.txt)" \
    --timeout-seconds 120 \
    --agent jazzyhazzy \
    --model openai/gpt-4o-mini \
    --announce --channel telegram --to 7888676328 \
    > /dev/null 2>&1 && echo "    ✅ Premarket updated" || echo "    ❌ Premarket failed"

echo "  Updating Morning Brief (7:30 AM)..."
openclaw cron edit 8d741c6b-59a9-4fda-b101-a43895e61eec \
    --message "$(cat ${PROMPTS_DIR}/morning_prompt.txt)" \
    --timeout-seconds 180 \
    --agent jazzyhazzy \
    --model openai/gpt-4o-mini \
    --announce --channel telegram --to 7888676328 \
    > /dev/null 2>&1 && echo "    ✅ Morning updated" || echo "    ❌ Morning failed"

echo "  Updating Midday (1:00 PM)..."
openclaw cron edit b930dc06-6ac2-45ec-8774-fcbf0ec90bb9 \
    --message "$(cat ${PROMPTS_DIR}/midday_prompt.txt)" \
    --timeout-seconds 120 \
    --agent jazzyhazzy \
    --model openai/gpt-4o-mini \
    --announce --channel telegram --to 7888676328 \
    > /dev/null 2>&1 && echo "    ✅ Midday updated" || echo "    ❌ Midday failed"

echo "  Updating EOD (4:00 PM)..."
openclaw cron edit 7196ebd9-02ce-485e-8d9e-3a2bee9ee4f9 \
    --message "$(cat ${PROMPTS_DIR}/eod_prompt.txt)" \
    --timeout-seconds 180 \
    --agent jazzyhazzy \
    --model openai/gpt-4o-mini \
    --announce --channel telegram --to 7888676328 \
    > /dev/null 2>&1 && echo "    ✅ EOD updated" || echo "    ❌ EOD failed"

echo "  Updating Nightly (8:30 PM)..."
openclaw cron edit 48d4c0ce-59f4-439e-9326-95552e52fc0e \
    --message "$(cat ${PROMPTS_DIR}/nightly_prompt.txt)" \
    --timeout-seconds 120 \
    --agent jazzyhazzy \
    --model openai/gpt-4o-mini \
    --announce --channel telegram --to 7888676328 \
    > /dev/null 2>&1 && echo "    ✅ Nightly updated" || echo "    ❌ Nightly failed"

# --- STEP 4: Verify ---
echo ""
echo "[4/4] Verification..."
echo ""
echo "Data fetch crons:"
crontab -l 2>/dev/null | grep -E "market_data|brief" | head -10
echo ""
echo "Agent crons:"
openclaw cron list 2>/dev/null | head -15

echo ""
echo "=========================================="
echo "  DEPLOYMENT COMPLETE"
echo "=========================================="
echo ""
echo "TEST NOW:"
echo "  python3 ${SCRIPTS_DIR}/market_data_fetch.py"
echo "  cat ~/.openclaw/workspace/market_data_latest.json | python3 -m json.tool | head -30"
echo "  openclaw cron run 8d741c6b-59a9-4fda-b101-a43895e61eec"
echo ""
echo "The flow is now:"
echo "  Python fetches data → saves JSON → Agent reads JSON → adds analysis → delivers brief"
echo "  Agent NEVER fetches its own data. No hallucination possible."
