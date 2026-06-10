#!/bin/bash
# Kronos daily-retrain watchdog.
# Fired by kronos-watchdog.timer twice (15:00 + 20:00 UTC) after the 10:00 UTC daily start.
# Runtime is contention-driven: ~2h design, ~2-4h expected on a quiet 6 AM machine, but it
# CAN balloon (one observed run took ~17h under midday load). So the watchdog does NOT assume
# the run is "done by now" — while a trainer process is alive it stays quiet, however long.
# It is a pure EXCEPTION HANDLER for the cases the training script can't report itself:
#   process alive, progressing   -> stay quiet
#   process alive, no progress    -> ⚠️ notify (possible stall), do NOT kill
#   no process + completed/failed -> stay quiet (the train script already pinged ✅/❌/skip)
#   no process + SILENT death:
#       lasted < EARLY_MIN  -> 🔁 auto-restart ONCE PER DAY + ping
#       lasted >= EARLY_MIN -> ⚠️ notify only (too far in to redo cheaply; Mike decides)
set -uo pipefail

LOG=/home/itsju/05_AUTOMATION/scripts/logs/kronos_train_daily.log
PING=/home/itsju/scripts/ping_mike.py
TRAINER_PAT="train_sequential.py --config"   # matches the real invocation, not incidental refs
WRAPPER_PAT="kronos_train_daily.sh"          # the wrapper script (alive during the data-fetch phase too)
SERVICE=kronos-train-daily.service
STAMP_DIR=/home/itsju/.cache/kronos-watchdog   # per-day "already restarted" marker (H1)
EARLY_MIN=30        # a run that LASTED < this before dying is "early" -> cheap to restart
STALL_MIN=150       # process alive but no new log line in > this -> likely wedged. Best-effort:
                    # the trainer only logs every ~100 steps (~80min gaps seen under contention),
                    # so 150 sits ~2x above that. Stall is NOTIFY-ONLY, never auto-kills.

ping() { /usr/bin/python3 "$PING" "$1" >/dev/null 2>&1 || true; }
now=$(date +%s)

[ -f "$LOG" ] || { ping "⚠️ Kronos watchdog: log missing ($LOG) — can't verify the daily run."; exit 0; }

# Last "starting" marker (line number + UTC timestamp)
start_line=$(grep -n "kronos_train_daily starting" "$LOG" | tail -1)
if [ -z "$start_line" ]; then
    ping "⚠️ Kronos watchdog: no 'starting' marker in log — daily may never have run."
    exit 0
fi
start_lineno=${start_line%%:*}
start_ts=$(echo "$start_line" | grep -oE '\[[0-9T:Z-]+\]' | head -1 | tr -d '[]')
start_epoch=$(date -d "$start_ts" +%s 2>/dev/null || echo 0)
# H2: if we couldn't parse the start time, lasted_min math is garbage — never auto-restart on a
# bogus value (29M-min "late" misclassification). Flag the parse failure and treat as unknown.
START_PARSE_OK=1
[ "$start_epoch" -gt 0 ] 2>/dev/null || START_PARSE_OK=0

# Slice the log to everything since the last start marker
run=$(mktemp /tmp/kronos_wd_run.XXXXXX)
trap 'rm -f "$run"' EXIT
tail -n +"$start_lineno" "$LOG" > "$run" 2>/dev/null

# Is the most recent run from today (UTC)? If not, the catch-up timer owns it.
start_day=${start_ts%%T*}
today=$(date -u +%F)
if [ "$start_day" != "$today" ]; then
    if pgrep -f "$TRAINER_PAT" >/dev/null; then
        exit 0   # a fresh catch-up run is already underway — leave it
    fi
    ping "⚠️ Kronos watchdog: today's daily retrain hasn't started (last run was $start_day). Persistent timer catches up on next wake — check if the laptop was off at 06:00 ET."
    exit 0
fi

# Anchor to the train script's OWN exact log lines (not loose substrings a library could emit).
completed=$(grep -cE "kronos_train_daily done" "$run")
skipped=$(grep -cE "skipping daily run" "$run")
failed=$(grep -cE "exited non-zero — check log|Data fetch failed — aborting" "$run")
# "Alive" = the trainer OR its wrapper script is running. Checking the wrapper too covers the
# brief data-fetch window at the start of a run (trainer not spawned yet, job still in progress)
# so it isn't misread as a silent death.
proc_pid=$(pgrep -f "$TRAINER_PAT" | head -1)
[ -n "$proc_pid" ] || proc_pid=$(pgrep -f "$WRAPPER_PAT" | head -1)

last_log_epoch=$(stat -c %Y "$LOG" 2>/dev/null || echo "$now")
idle_min=$(( (now - last_log_epoch) / 60 ))      # time since last log write (stall test)
lasted_min=$(( (last_log_epoch - start_epoch) / 60 ))  # how long the run actually ran (death test)
# Prefer the richer "Epoch X/Y, Step N/M" form; fall back to bare "Step N/M" if that's all there is.
laststep=$(grep -oE "Epoch [0-9]+/[0-9]+, Step [0-9]+/[0-9]+|Step [0-9]+/[0-9]+" "$run" | tail -1)

# Happy paths stay QUIET — the training script already sent its own ✅/❌/skip ping.
# The watchdog is a pure exception handler for SILENT death + stalls.
if [ "$completed" -gt 0 ]; then exit 0; fi   # completed cleanly (script pinged ✅)
if [ "$skipped"   -gt 0 ]; then exit 0; fi   # benign skip (script pinged)
if [ "$failed"    -gt 0 ]; then exit 0; fi   # clean failure (script pinged ❌); don't restart

if [ -n "$proc_pid" ]; then
    if [ "$idle_min" -gt "$STALL_MIN" ]; then
        ping "⚠️ Kronos watchdog: trainer (pid $proc_pid) ALIVE but no log progress in ${idle_min}min — possible stall at ${laststep:-unknown}. NOT killing; check it."
    fi
    exit 0   # otherwise still legitimately training on a slow day
fi

# Not completed, not a clean failure/skip, no process => SILENT DEATH
stamp="$STAMP_DIR/restarted-$today"
if [ "$START_PARSE_OK" -eq 0 ]; then
    # H2: start time unparseable -> can't tell early vs late -> fail safe (no restart), alert.
    ping "⚠️ Kronos watchdog: daily run is gone with no completion marker, but its start timestamp ('$start_ts') wouldn't parse — can't classify early vs late, so NOT auto-restarting. Check logs/kronos_train_daily.log."
elif [ "$lasted_min" -lt "$EARLY_MIN" ]; then
    if [ -f "$stamp" ]; then
        # H1: already used today's one auto-restart -> don't thrash; escalate instead.
        ping "⚠️ Kronos watchdog: daily run died early AGAIN (~${lasted_min}min, ${laststep:-no steps}) after an auto-restart was already used today — NOT restarting a 2nd time. Investigate logs/kronos_train_daily.log."
    elif mkdir -p "$STAMP_DIR" && systemctl --user start "$SERVICE"; then
        touch "$stamp"   # mark today's restart as spent (only after a successful start)
        ping "🔁 Kronos watchdog: daily run died early (ran ~${lasted_min}min, ${laststep:-no steps}) — auto-restarted once. Watching."
    else
        ping "❌ Kronos watchdog: daily run died early AND restart FAILED. Manual: systemctl --user start $SERVICE"
    fi
else
    ping "⚠️ Kronos watchdog: daily run died silently after ~${lasted_min}min at ${laststep:-unknown} — NOT auto-restarted (too far in to redo cheaply). Decide: restart or run stale until tomorrow."
fi
exit 0
