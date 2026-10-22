#!/usr/bin/env python3
"""poster_watchdog.py — dead-man check for the auto-posters. If a poster's heartbeat
goes stale inside its active window (cron silently failed: ARIES down, yfinance error,
key issue), ping the system_health Telegram lane. Read-only. Cron every 20 min.

Gated via lib/alert_gate.py (2026-09-15 telegram lane charter fix) — fingerprint is the
ET date + sorted set of currently-stale poster names, so a standing failure alerts once per
episode per day (W6); exchange holidays are not weekdays (market clock).
"""
from __future__ import annotations

import argparse
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.heartbeat import age_min, beat_epoch  # noqa: E402
from lib.alert_gate import should_send, mark_sent  # noqa: E402

ET = ZoneInfo("America/New_York")


def trading_day(d) -> bool:
    """NYSE session day from the MissionCtrl market clock (holidays included, W6 MC-AUD-125); Mon-Fri if unavailable."""
    try:
        sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline")
        from market_clock import clock
        return clock.is_trading_day(d)
    except Exception:
        return d.weekday() < 5
ALERT_GATE_KEY = "poster_watchdog"
ALERT_REPEAT_AFTER = 20 * 3600   # with the dated fingerprint: once per episode per day


def main(dry_run: bool = False):
    now = datetime.now(ET)
    h, weekday = now.hour, trading_day(now.date())
    stale = []

    def check_freq(name, max_age, lo, hi, wd_only=False):
        if wd_only and not weekday:
            return
        if not (lo <= h < hi):
            return
        a = age_min(name)
        if a is None:
            stale.append(f"{name} — never ran")
        elif a > max_age:
            stale.append(f"{name} — last ran {a:.0f}m ago (expected <{max_age}m)")

    def check_daily(name, sched_hour, wd_only=True):
        if wd_only and not weekday:
            return
        if h < sched_hour + 1:        # 1h grace after scheduled time
            return
        e = beat_epoch(name)
        if not e or datetime.fromtimestamp(e, ET).date() != now.date():
            stale.append(f"{name} — no run today (due ~{sched_hour}:05 ET)")

    # frequent posters. flow_picks cron = 9:50 / 12:30 / 15:00 (max gap 160m), so the
    # threshold must clear that gap or the 12:00 / 14:40 ticks false-alarm.
    # Retired 2026-10-08 (no cron/pm2, producers dead): crypto_holdings, crypto_spike,
    # boba_cycle, jazzy_cycle, crypto_eod.
    check_freq("flow_picks", 175, 10, 16, wd_only=True)
    # once-daily briefs
    check_daily("morning_command", 8)    # pre-open brief, due ~8:15 ET weekdays
    check_daily("eod_scorecard", 16)

    if stale:
        stamp = now.strftime("%-I:%M %p ET")
        msg = "🔧 CRON HEALTH — poster(s) stale · " + stamp + "\n" + "\n".join("• " + s for s in stale) + \
              "\nCheck ~/02_DATA/skillcron.log (ARIES down, yfinance error, or key issue)."
        # one alert per episode per ET day: same stale set → no 6h re-pings of an unchanged condition (W6 MC-AUD-125)
        fp = now.strftime("%Y-%m-%d") + ":" + "|".join(sorted(s.split(" — ")[0].strip("* ") for s in stale))
        ok, why = should_send(ALERT_GATE_KEY, fp, repeat_after=ALERT_REPEAT_AFTER)
        if dry_run:
            print(f"[poster-watchdog] DRY-RUN would-send={ok} ({why}) fp={fp}\n{msg}", flush=True)
            return
        if not ok:
            print(f"[poster-watchdog] SUPPRESS ({why}) fp={fp}", flush=True)
            return
        # Discord disabled 2026-06-16 (Mike: ops off Discord). Watches the LIVE flow/
        # crypto/boba/jazzy posters → route to Telegram (system_health) instead.
        try:
            import sys as _sys
            _sys.path.insert(0, "/home/itsju/scripts")
            from lib.notify import tg_push
            if tg_push("⚠️ " + msg, "system_health", loud=False, html=False,
                       fallback_token_file="telegram-ping-bot-token"):
                mark_sent(ALERT_GATE_KEY, fp)
        except Exception as _e:
            print(f"[poster-watchdog] telegram alert failed: {_e}", flush=True)
        print(f"[poster-watchdog] ALERT: {len(stale)} stale", flush=True)
    else:
        print("[poster-watchdog] all posters healthy", flush=True)


if __name__ == "__main__":
    ap = argparse.ArgumentParser()
    ap.add_argument("--dry-run", action="store_true", help="print what would be sent, send nothing")
    a = ap.parse_args()
    main(dry_run=a.dry_run)
