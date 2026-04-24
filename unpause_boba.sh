#!/bin/bash
# Remove cost-watchdog killswitch and re-enable Boba's openclaw cron.

KILLSWITCH="/home/ubuntu/.openclaw/workspace/state/boba_killswitch"
CRON_ID="cfcf6645-d175-478c-bd9f-e97c00a1e690"

if [ -f "$KILLSWITCH" ]; then
  echo "Removing killswitch:"
  cat "$KILLSWITCH"
  rm "$KILLSWITCH"
  echo "[ok] killswitch cleared"
fi

# Try every enable variant
for cmd in "openclaw cron enable $CRON_ID" "openclaw cron resume $CRON_ID" "openclaw cron start $CRON_ID"; do
  if $cmd 2>/dev/null; then
    echo "[ok] Re-enabled via: $cmd"
    exit 0
  fi
done

echo "[warn] openclaw cron re-enable variants all failed — may need manual intervention"
openclaw cron list 2>/dev/null | grep -i boba
