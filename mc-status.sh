#!/bin/bash
echo "=== $(date -u) UTC | $(TZ=America/New_York date '+%I:%M %p ET') ==="
echo ""
echo "--- Last Boba cycle ---"
tail -20 /tmp/boba_cycle.log 2>/dev/null | grep -E "Cycle|picks|Flow Channel|Prompt size|ERROR|fresh|HOLD|EXIT" | tail -10
echo ""
echo "--- Agent log tails ---"
echo "Orion:    $(tail -1 /tmp/orion_flow_brief.log 2>/dev/null | head -c 100)"
echo "Grok:     $(tail -1 /tmp/grok_brief.log 2>/dev/null | head -c 100)"
echo "DeepSeek: $(tail -1 /tmp/deepseek_observer.log 2>/dev/null | head -c 100)"
echo "Kronos:   $(tail -1 /tmp/kronos_lurker.log 2>/dev/null | head -c 100)"
echo ""
echo "--- PM2 critical ---"
pm2 list | grep -E "mission-control|firebase|signal-rec|flow-monitor|trail-daemon|option-signals" | awk -F'│' '{printf "%-25s %s\n", $3, $7}'
echo ""
echo "--- Daily budget ---"
cat ~/.openclaw/workspace/state/daily_picks_state.json 2>/dev/null | python3 -m json.tool 2>/dev/null | head -8
