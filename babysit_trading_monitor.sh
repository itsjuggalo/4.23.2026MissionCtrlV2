#!/usr/bin/env bash
# babysit_trading_monitor.sh — event source for Claude Code's Monitor tool.
#
# WHY THIS SHAPE: a /loop that wakes every 30 min pays a full context load per tick
# just to discover nothing changed. This is edge-triggered instead — it polls cheaply
# in bash (zero tokens) and prints a line ONLY when the health state CHANGES, so a
# quiet fleet is literally free and Claude is only interrupted when something moved.
#
# Each stdout line = one Monitor event. Keep them rare and actionable.
# Read-only throughout: it shells the read-only checker and never remediates.
#
# Usage (via Monitor tool):  bash ~/scripts/babysit_trading_monitor.sh
# Standalone smoke test:     BABYSIT_ONCE=1 bash ~/scripts/babysit_trading_monitor.sh

CHECK="$HOME/scripts/babysit_trading_crons.py"
INTERVAL="${BABYSIT_INTERVAL:-60}"   # local sqlite/pm2 reads; 60s is cheap and prompt
last=""

emit() { printf '%s\n' "$*"; }       # one line == one notification

while :; do
  # || true so a transient failure never kills the monitor (a dead monitor is
  # indistinguishable from a healthy fleet — that silence is the dangerous case).
  fp="$(timeout 60 python3 "$CHECK" --fingerprint 2>/dev/null || echo CHECKER_FAILED)"

  if [ "$fp" != "$last" ]; then
    ts="$(TZ=America/New_York date '+%Y-%m-%d %H:%M %Z')"
    case "$fp" in
      GREEN)
        # Only announce recovery — never announce "still fine", and stay silent on
        # the very first tick if we started green (no incident to close out).
        [ -n "$last" ] && emit "✅ RECOVERED $ts — trading fleet back to green (was: $last)"
        ;;
      CHECKER_FAILED)
        # Coverage rule: the watcher failing IS an event. Silence must never be
        # the way we find out the babysitter died.
        emit "🚨 BABYSIT CHECKER FAILED $ts — $CHECK did not return a fingerprint (crash/timeout). Trading fleet is UNWATCHED until this clears."
        ;;
      *)
        detail="$(timeout 60 python3 "$CHECK" 2>/dev/null | grep -E '^\s*!!' | sed 's/^ *//' | tr '\n' ' | ' || true)"
        emit "🚨 TRADING FLEET PROBLEM $ts [$fp] — ${detail:-see: python3 $CHECK}"
        ;;
    esac
    last="$fp"
  fi

  [ -n "$BABYSIT_ONCE" ] && break
  sleep "$INTERVAL"
done
