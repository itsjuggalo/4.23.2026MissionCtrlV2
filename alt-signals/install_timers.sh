#!/bin/bash
# Install alt-signals systemd --user units.
#
# Each ingester runs on its natural cadence. The morning_digest runs once
# daily at 11:30 UTC (~7:30 ET pre-market open).
set -euo pipefail

UNIT_DIR="$HOME/.config/systemd/user"
SCRIPTS_DIR="$HOME/scripts/alt-signals"
PYTHON="/usr/bin/python3"

mkdir -p "$UNIT_DIR"

# (key, script, OnCalendar, description)
INGESTERS=(
  "alt-sec-8k|sec_8k.py|*:0/10|SEC 8-K live feed"
  "alt-finra-si|finra_short_interest.py|*-*-* 22:05:00|FINRA short interest daily"
  "alt-cot|cme_cot.py|Fri *-*-* 21:30:00|CFTC COT weekly"
  "alt-vix-ts|vix_term_structure.py|*-*-* 21:00:00|VIX term structure daily"
  "alt-dix-gex|dix_gex.py|*-*-* 22:10:00|DIX/GEX daily"
  "alt-ainvest|ainvest_prompts.py|*:30:00|AInvest prompt-square hourly"
  "alt-wsb|wsb_scan.py|*:15:00|WSB ticker scan hourly"
  "alt-hn-algo|hn_algo.py|0,6,12,18:00:00|HN + r/algotrading 4x daily"
  "alt-morning-digest|morning_digest.py|*-*-* 07:00:00|Alt-signals morning digest"
)

write_unit() {
  local key="$1"
  local script="$2"
  local on_calendar="$3"
  local desc="$4"

  cat > "$UNIT_DIR/$key.service" <<EOF
[Unit]
Description=$desc

[Service]
Type=oneshot
WorkingDirectory=$SCRIPTS_DIR
ExecStart=$PYTHON $SCRIPTS_DIR/$script
Nice=10
IOSchedulingClass=best-effort
IOSchedulingPriority=5
TimeoutStartSec=300
EOF

  cat > "$UNIT_DIR/$key.timer" <<EOF
[Unit]
Description=$desc (timer)

[Timer]
OnCalendar=$on_calendar
Persistent=true
RandomizedDelaySec=30

[Install]
WantedBy=timers.target
EOF
}

for entry in "${INGESTERS[@]}"; do
  IFS='|' read -r key script cal desc <<< "$entry"
  write_unit "$key" "$script" "$cal" "$desc"
  echo "wrote: $key (cal=$cal)"
done

# Reload + enable
systemctl --user daemon-reload
echo
echo "Enabling timers..."
for entry in "${INGESTERS[@]}"; do
  IFS='|' read -r key _ _ _ <<< "$entry"
  systemctl --user enable --now "$key.timer"
done

echo
echo "=== Timer status ==="
systemctl --user list-timers --no-pager | grep alt- || true
