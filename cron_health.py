#!/usr/bin/env python3
"""cron_health.py — silent-failure watchdog for Mission Control cron jobs.

Every finding in the 2026-06-04 ops audit had failed SILENTLY for days. This is the
generalized fix: ping Mike's PingPong Telegram when a critical job's log is STALE past its
expected cadence, or its recent tail shows a hard error. One ping per incident (latch),
auto-clears on recovery. Generalization of decipher_watchdog.py.

Cron: */30 * * * *  /usr/bin/python3 ~/05_AUTOMATION/scripts/cron_health.py
"""
import json
import os
import re
import subprocess
import importlib.util
import time
from datetime import datetime, timezone
from zoneinfo import ZoneInfo
from pathlib import Path

HOME = Path.home()
SEC = HOME / ".openclaw" / "secrets"
PING = HOME / "scripts" / "ping_mike.py"
LATCH = HOME / ".openclaw" / "cron_health_latches"
ET = ZoneInfo("America/New_York")
# NYSE holiday set is owned by missionctrl (src/lib/freshness.ts US_MARKET_HOLIDAYS, mirrored here).
HOLIDAYS_SRC = Path("/AIWorkWSL/web/missionctrl/pipeline/gex/common.py")
ERR = re.compile(r"Traceback|ModuleNotFoundError|ImportError|database is locked|"
                 r"OperationalError|NameError|No such file|name resolution|FAILED", re.I)
ERRSCAN_FRESH_MIN = 360   # only error-scan logs touched in the last 6h (ignore ancient errors)

# (name, log path, max_age_min | None, market_hours_only, error_scan)
JOBS = [
    ("decipher-main",    HOME / "logs/decipher.log",                   45,   True,  True),
    ("flow-ingest",      HOME / "logs/flow-ingest.log",                30,   False, True),
    # plaid_sync 08:00 daily (LifeClaw debts). Was "refresh-holdings" on ~/portfolio/refresh.log — that job
    # retired 2026-09-12 and plaid kept the shared log fresh (false green). Repointed overhaul T6 2026-09-25.
    ("plaid-sync",       HOME / "logs/lifeclaw/plaid_sync.log",       1500, False, True),
    ("flow-outcomes",    HOME / "logs/flow-outcomes.log",              None, False, True),
    ("sector-rotation",  HOME / "LapClaw/pipeline/logs/sector_rotation.log",  None, False, True),
    ("catalyst-scanner", HOME / "LapClaw/pipeline/logs/catalyst_scanner.log", None, False, True),
    # md_freshness runs weekly (Sun 05:30 UTC, crontab:424); laptop asleep = silent skip.
    # 8-day threshold = weekly cadence + 1 day grace. Added 2026-08-30 after the Jul 26 silent stop.
    ("md-freshness",   HOME / "05_AUTOMATION/scripts/md_freshness.log", 11520, False, True),
    # watches the watcher: freshness_watchdog fires q15min market hours (6,21,36,51)
    ("freshness-watchdog", HOME / "LapClaw/pipeline/logs/freshness_watchdog.log", 25, True, True),
    # relay sweep q3min (was q10, tightened 2026-08-31) — if ITS log goes stale, cron itself
    # is dead inside WSL and 0x8007274c jams will stop self-healing. 30m = 10 missed runs.
    ("wsl-relay-sweep", HOME / "logs/wsl-relay-sweep.log", 30, False, True),
    # obsidian vault md sync q5min (crontab: obsidian-vault-sync.sh) — 30m = 6 missed runs
    ("obsidian-vault-sync", HOME / "logs/obsidian-vault-sync.log", 30, False, True),
]


def _holidays():
    try:
        spec = importlib.util.spec_from_file_location("mc_gex_common", HOLIDAYS_SRC)
        mod = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(mod)
        return set(mod.US_MARKET_HOLIDAYS)
    except Exception:
        return set()   # fail toward checking: a holiday then reads as open (stale alerts), never blind


def market_open():
    """Deterministic NYSE regular session: ET weekday, 09:30-16:00, not a full-day holiday.
    Replaced the Alpaca paper-trading /v2/clock call (overhaul T6, 2026-09-25): Alpaca execution
    is retired and its paper keys are slated for revocation, which would have left every
    market-hours check below silently blind. Half-days read as open to 16:00 (harmless here)."""
    now = datetime.now(ET)
    try:   # W6 MC-AUD-126: the MissionCtrl market clock (holidays AND early closes) is the one calendar
        import sys
        sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline")
        from market_clock import clock
        if not clock.is_trading_day(now.date()):
            return False
        return clock.session_open(now.date()) <= now < clock.session_close(now.date())
    except Exception:
        pass
    if now.weekday() >= 5 or now.date() in _holidays():
        return False
    mins = now.hour * 60 + now.minute
    return 9 * 60 + 30 <= mins < 16 * 60


def ping(msg):
    try:
        return subprocess.run(["python3", str(PING), msg], timeout=20).returncode == 0
    except Exception:
        return False


# Mirrors FLEET in ~/bin/trading-fleet. The trail/profit-lock/auto-bracket daemons were deleted
# 2026-08-11 with the Alpaca book; watching them latched "absent" on 08-12 and muted this check
# for six weeks (trimmed overhaul T6, 2026-09-25).
# grid-daemon retired 2026-10-20 (remedial W5 / DECISIONS R4: its order path); its trading-fleet cron is commented
# out, so watching it only latched "absent" forever (W6 MC-AUD-126). Nothing left to watch.
FLEET: list[str] = []


def check_fleet(mo):
    """The exit-protection daemons (trailing stops, profit locks, auto-bracket) are
    windowed up 9:00-16:40 ET by ~/bin/trading-fleet. A silent no-op there leaves open
    positions unmanaged while looking perfectly healthy — which is exactly what happened
    2026-07-20: cron's PATH has no nvm, pm2's shebang is `#!/usr/bin/env node`, so the
    9:00 start died on `pm2: command not found` and a `| grep '✓|error'` ate the message.
    The log-age checks above are structurally blind to this: a daemon that never STARTS
    never writes a log to go stale. Hence an explicit process check.
    """
    if mo is not True or not FLEET:
        return                      # off-hours down is the designed state; empty fleet = nothing to watch
    # Same PATH trap as the bug being watched for — resolve node ourselves.
    node_bins = sorted((HOME / ".nvm/versions/node").glob("*/bin"))
    env = {**os.environ}
    if node_bins:
        env["PATH"] = f"{node_bins[-1]}:{env.get('PATH','')}"
    try:
        out = subprocess.run(["pm2", "jlist"], capture_output=True, text=True,
                             timeout=30, env=env)
        procs = json.loads(out.stdout or "[]")
    except Exception as e:
        _fleet_ping("fleet-check", f"cannot read pm2 ({type(e).__name__}) — fleet UNVERIFIED")
        return
    down = [p["name"] for p in procs
            if p["name"] in FLEET and p["pm2_env"]["status"] != "online"]
    missing = [n for n in FLEET if n not in {p["name"] for p in procs}]
    if down or missing:
        detail = ", ".join(down + [f"{m} (absent)" for m in missing])
        _fleet_ping("trading-fleet", f"trading-fleet DOWN during market hours: {detail}")
    else:
        (LATCH / "trading-fleet").unlink(missing_ok=True)
        (LATCH / "fleet-check").unlink(missing_ok=True)


def _gate_ok(key, fingerprint, hours=6):
    """Shared change-gate (lib/alert_gate). Fails OPEN — a missing gate must never
    swallow an infra alert."""
    try:
        import sys
        sys.path.insert(0, str(HOME / "scripts"))
        from lib.alert_gate import should_send
        return should_send(key, fingerprint, repeat_after=hours * 3600)
    except Exception:
        return True, "gate unavailable"


def _gate_mark(key, fingerprint):
    try:
        import sys
        sys.path.insert(0, str(HOME / "scripts"))
        from lib.alert_gate import mark_sent
        mark_sent(key, fingerprint)
    except Exception:
        pass


def _fleet_ping(latch_name, msg):
    latch = LATCH / latch_name
    ok, _ = _gate_ok(f"cron_health_{latch_name}", msg)
    if ok and not latch.exists():
        if ping(f"🚨 CRON HEALTH — {msg}"):
            latch.write_text(datetime.now(timezone.utc).isoformat())
            _gate_mark(f"cron_health_{latch_name}", msg)


def problem_kind(problems: list[str]) -> str:
    """Problem text without its numbers: 'stale 47m (>45m)' and 'stale 77m (>45m)' are one episode."""
    return "; ".join(re.sub(r"\d+", "N", p) for p in problems)


def latched_kind(latch: Path):
    """The latched problem kind; a legacy timestamp-only latch counts as 'same' (no re-ping on upgrade)."""
    if not latch.exists():
        return None
    try:
        return json.loads(latch.read_text()).get("kind")
    except (ValueError, AttributeError):
        return "__legacy__"


def main():
    LATCH.mkdir(parents=True, exist_ok=True)
    mo = market_open()
    now = time.time()
    for name, log, max_age, mh, errscan in JOBS:
        latch = LATCH / name
        problems = []
        if not log.exists():
            problems.append("log missing")
        else:
            age_min = (now - log.stat().st_mtime) / 60
            # Staleness — skip for market-hours jobs when the market isn't open.
            if max_age is not None and not (mh and mo is not True):
                if age_min > max_age:
                    problems.append(f"stale {age_min:.0f}m (>{max_age}m)")
            # Error scan — only on recently-active logs (avoid ancient tracebacks).
            if errscan and age_min <= ERRSCAN_FRESH_MIN:
                try:
                    tail = "\n".join(log.read_text(errors="ignore").splitlines()[-40:])
                    m = ERR.search(tail)
                    if m:
                        problems.append(f"recent error: {m.group(0)}")
                except Exception:
                    pass
        if problems:
            # The latch alone gives "one ping per incident" — but a FLAPPING job (stale →
            # fresh → stale every half hour) clears the latch and re-pings each cycle. That
            # was 96 CRON HEALTH messages in 7 days for a handful of jobs, none of which Mike
            # can act on differently the 12th time. The shared gate adds the missing floor:
            # the same problem text on the same job speaks at most once every 6 hours, while
            # a genuinely DIFFERENT failure still gets through immediately.
            desc = "; ".join(problems)
            kind = problem_kind(problems)
            ok, _why = _gate_ok(f"cron_health_{name}", kind)
            # W6 MC-AUD-126: the latch holds the problem KIND, so a changed failure (stale → traceback) speaks
            # again while the same one stays quiet; ages no longer make every run look new to the gate.
            if ok and latched_kind(latch) not in (kind, "__legacy__"):
                if ping(f"⚠️ CRON HEALTH — {name}: {desc}"):
                    latch.write_text(json.dumps({"at": datetime.now(timezone.utc).isoformat(), "kind": kind}))
                    _gate_mark(f"cron_health_{name}", kind)
        else:
            latch.unlink(missing_ok=True)   # recovered → re-arm
    check_fleet(mo)


if __name__ == "__main__":
    main()
