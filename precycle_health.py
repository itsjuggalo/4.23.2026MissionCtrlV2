#!/usr/bin/env python3
"""
Precycle Health Check (Step 1 of /silver-platter build plan, 2026-05-11).

Runs every 5 min via cron. Validates that every source Boba's decision_cycle
loaders read is fresh and well-formed BEFORE Boba reads them. Writes a single
status file at ~/.openclaw/data/precycle_health.json that Boba (or any other
consumer) can read for a one-line GREEN/YELLOW/RED verdict.

Companion to the Apr 29 'or ""' defensive loaders: those silently degrade,
this names the broken source out loud. Posts a P1 Discord alert only when
overall=RED to avoid noise.

Source list and per-source max_age_minutes were lifted directly from
/home/ubuntu/scripts/boba_decision_cycle.py constants and load_* functions.
"""
import json, os, sys, time
from datetime import datetime, timezone, timedelta
from pathlib import Path

ET = timezone(timedelta(hours=-4))
NOW = datetime.now(timezone.utc)
NOW_ET = NOW.astimezone(ET)
TODAY_ET = NOW_ET.strftime("%Y-%m-%d")

OUT = Path("/home/ubuntu/.openclaw/data/precycle_health.json")
WEBHOOK_FILE = Path("/home/ubuntu/.openclaw/secrets/discord-webhook-bobatrades")
ALERT_STATE = Path("/home/ubuntu/.openclaw/workspace/state/precycle_alert_state.json")

# Each entry: id, path, max_age_minutes, weekday_only, required.
# max_age_minutes mirrors Boba's actual loader thresholds.
# weekday_only = file is only expected to refresh Mon-Fri (skip stale on Sat/Sun).
SOURCES = [
    {
        "id": "scored_signals_recent",
        "path": "/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json",
        "max_age_minutes": 30,
        "weekday_only": True,
        "required": True,
    },
    {
        # Liveness is judged from the relay's own status file, not the feed file.
        # The feed file only changes when a NEW signal lands (sparse), so its mtime
        # is a poor freshness proxy; the relay rewrites the status file every poll
        # (~60s) and records whether Firebase RTDB was actually reachable.
        "id": "firebase_trade_signals",
        "path": "/home/ubuntu/.openclaw/workspace/directives/firebase_signal_relay_status.json",
        "max_age_minutes": 5,
        "weekday_only": False,
        "required": True,
        "relay_health": True,
    },
    {
        "id": "grok_brief",
        "path": "/home/ubuntu/.openclaw/workspace/directives/grok_brief.json",
        "max_age_minutes": 60,
        "weekday_only": True,
        "required": False,
    },
    {
        "id": "market_briefing",
        "path": "/home/ubuntu/.openclaw/workspace/directives/market_briefing.json",
        "max_age_minutes": 90,
        "weekday_only": False,
        "required": True,
    },
    {
        "id": "market_regime_BTC",
        "path": "/home/ubuntu/.openclaw/workspace/directives/market_regime_BTC.json",
        "max_age_minutes": 60,
        "weekday_only": False,
        "required": True,
    },
    {
        "id": "best_options_today",
        "path": f"/home/ubuntu/.openclaw/data/best-options/{TODAY_ET}.json",
        "max_age_minutes": 30,
        "weekday_only": True,
        "required": False,
    },
    {
        "id": "orion_skill_outputs",
        "path": "/home/ubuntu/.openclaw/workspace/skill_outputs/orion",
        "max_age_minutes": 120,
        "weekday_only": True,
        "required": False,
        "is_directory": True,
    },
    {
        "id": "kronos_forecasts_dir",
        "path": "/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts",
        "max_age_minutes": 240,
        "weekday_only": False,
        "required": False,
        "is_directory": True,
    },
    {
        "id": "boba_lessons",
        "path": "/home/ubuntu/.openclaw/workspace/memory/boba_lessons.md",
        "max_age_minutes": 60 * 24 * 7,
        "weekday_only": False,
        "required": False,
    },
]

# Market hours gate. Outside RTH on weekdays, signal-receiver feeds slow down,
# so we relax 'stale' to a lower severity. is_market_hours_et returns True
# from 4:00 ET (premarket) to 20:00 ET (after-hours) on weekdays.
def is_market_hours_et():
    if NOW_ET.weekday() >= 5:
        return False
    h = NOW_ET.hour
    return 4 <= h < 20


def is_weekday_et():
    return NOW_ET.weekday() < 5


def latest_mtime_in_dir(p: Path):
    if not p.exists() or not p.is_dir():
        return None
    latest = 0
    for child in p.glob("*"):
        try:
            m = child.stat().st_mtime
            if m > latest:
                latest = m
        except FileNotFoundError:
            continue
    return latest if latest else None


def check_source(src):
    p = Path(src["path"])
    is_dir = src.get("is_directory", False)
    record = {
        "id": src["id"],
        "path": src["path"],
        "exists": p.exists(),
        "is_directory": is_dir,
        "size_bytes": None,
        "age_minutes": None,
        "max_age_minutes": src["max_age_minutes"],
        "well_formed": None,
        "required": src["required"],
        "weekday_only": src["weekday_only"],
        "status": "GREEN",
        "issue": None,
    }

    skip_stale = src["weekday_only"] and not is_weekday_et()

    if not p.exists():
        if skip_stale:
            record["status"] = "GREEN"
            record["issue"] = "missing but weekend, ignored"
        else:
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = "missing"
        return record

    if is_dir:
        mtime = latest_mtime_in_dir(p)
        if mtime is None:
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = "directory empty"
            return record
        record["size_bytes"] = sum(c.stat().st_size for c in p.glob("*") if c.is_file())
    else:
        try:
            stat = p.stat()
            mtime = stat.st_mtime
            record["size_bytes"] = stat.st_size
            if stat.st_size == 0:
                record["status"] = "RED" if src["required"] else "YELLOW"
                record["issue"] = "empty file"
                return record
        except FileNotFoundError:
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = "missing"
            return record

    age_min = (NOW.timestamp() - mtime) / 60.0
    record["age_minutes"] = round(age_min, 2)

    if not is_dir and src["path"].endswith(".json"):
        try:
            json.loads(p.read_text())
            record["well_formed"] = True
        except Exception as e:
            record["well_formed"] = False
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = f"invalid JSON: {type(e).__name__}"
            return record
    elif not is_dir and src["path"].endswith(".md"):
        try:
            text = p.read_text()
            record["well_formed"] = bool(text.strip())
            if not record["well_formed"]:
                record["status"] = "YELLOW"
                record["issue"] = "MD empty"
                return record
        except Exception as e:
            record["well_formed"] = False
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = f"unreadable MD: {type(e).__name__}"
            return record

    if age_min > src["max_age_minutes"]:
        if skip_stale:
            record["status"] = "GREEN"
            record["issue"] = f"stale {int(age_min)}min but weekend, ignored"
        else:
            record["status"] = "RED" if src["required"] else "YELLOW"
            record["issue"] = f"stale {int(age_min)}min (max {src['max_age_minutes']})"

    # Relay-status sources: a fresh file is not enough — the relay can be polling
    # on schedule while every RTDB call 401s. Surface that explicitly (MIS-107).
    if src.get("relay_health") and record["status"] != "RED":
        try:
            st = json.loads(p.read_text())
            if not st.get("last_poll_ok"):
                fails = st.get("consecutive_failures", 0)
                record["status"] = "RED" if src["required"] else "YELLOW"
                record["issue"] = f"relay RTDB unreachable ({fails} consecutive failed polls)"
        except Exception:
            pass

    return record


def overall_status(records):
    if any(r["status"] == "RED" for r in records):
        return "RED"
    if any(r["status"] == "YELLOW" for r in records):
        return "YELLOW"
    return "GREEN"


def post_discord_alert(report):
    if not WEBHOOK_FILE.exists():
        return False
    webhook = WEBHOOK_FILE.read_text().strip()
    if not webhook:
        return False
    red = [r for r in report["sources"] if r["status"] == "RED"]
    summary = ", ".join(f"{r['id']} ({r['issue']})" for r in red)
    payload = {
        "username": "precycle-health",
        "content": f"**RED** precycle health at {report['checked_at_et']}\nFailing sources: {summary}\nFull report: `cat ~/.openclaw/data/precycle_health.json`",
    }
    try:
        import urllib.request
        req = urllib.request.Request(
            webhook,
            data=json.dumps(payload).encode(),
            # Discord/Cloudflare 403s the default Python-urllib UA
            headers={"Content-Type": "application/json",
                     "User-Agent": "precycle-health/1.0"},
            method="POST",
        )
        urllib.request.urlopen(req, timeout=10)
        return True
    except Exception:
        return False


def should_alert(overall):
    """Only alert on RED, and dedupe so we don't spam the same RED state every 5 min.
    Re-fires if 30+ min has passed since last alert OR state transitioned GREEN/YELLOW -> RED."""
    if overall != "RED":
        if ALERT_STATE.exists():
            try:
                state = json.loads(ALERT_STATE.read_text())
                state["last_overall"] = overall
                state["last_alert_ts"] = state.get("last_alert_ts")
                ALERT_STATE.write_text(json.dumps(state))
            except Exception:
                pass
        return False
    state = {"last_overall": "GREEN", "last_alert_ts": 0}
    if ALERT_STATE.exists():
        try:
            state = json.loads(ALERT_STATE.read_text())
        except Exception:
            pass
    now_ts = int(time.time())
    fire = (state.get("last_overall") != "RED") or ((now_ts - int(state.get("last_alert_ts", 0))) > 30 * 60)
    if fire:
        ALERT_STATE.parent.mkdir(parents=True, exist_ok=True)
        ALERT_STATE.write_text(json.dumps({"last_overall": "RED", "last_alert_ts": now_ts}))
    return fire


def main():
    OUT.parent.mkdir(parents=True, exist_ok=True)
    records = [check_source(s) for s in SOURCES]
    overall = overall_status(records)
    counts = {
        "red": sum(1 for r in records if r["status"] == "RED"),
        "yellow": sum(1 for r in records if r["status"] == "YELLOW"),
        "green": sum(1 for r in records if r["status"] == "GREEN"),
    }
    report = {
        "checked_at_utc": NOW.isoformat(),
        "checked_at_et": NOW_ET.strftime("%Y-%m-%d %H:%M:%S ET"),
        "is_market_hours_et": is_market_hours_et(),
        "is_weekday_et": is_weekday_et(),
        "overall": overall,
        "counts": counts,
        "sources": records,
    }
    OUT.write_text(json.dumps(report, indent=2))

    alerted = False
    if should_alert(overall):
        alerted = post_discord_alert(report)
    print(f"[precycle-health] {report['checked_at_et']} overall={overall} red={counts['red']} yellow={counts['yellow']} alerted={alerted}", flush=True)
    return 0 if overall != "RED" else 1


if __name__ == "__main__":
    sys.exit(main())
