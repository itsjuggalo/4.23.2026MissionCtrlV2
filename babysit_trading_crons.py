#!/usr/bin/env python3
"""babysit_trading_crons.py — READ-ONLY health snapshot of the trading cron fleet.

Complements ~/05_AUTOMATION/scripts/cron_health.py (which pings Telegram for 9 jobs).
This one covers the jobs that watchdog does NOT — most importantly the desk cycle —
and emits a compact JSON/text verdict for a Claude `/loop` to reason about.

HARD RULE: this script only READS. It never restarts a daemon, never edits a cron,
never touches the merged flow-signal stream. Remediation is Mike's call.

Usage:  python3 ~/scripts/babysit_trading_crons.py [--json]
Exit:   0 = all green, 1 = at least one problem (so a caller can branch on it)
"""
import argparse
import json
import os
import re
import sqlite3
import subprocess
import sys
import time
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

HOME = Path.home()
ET = ZoneInfo("America/New_York")
ERR = re.compile(r"Traceback|ModuleNotFoundError|ImportError|database is locked|"
                 r"OperationalError|NameError|No such file|name resolution|FAILED|"
                 r"insufficient|rejected|401|403|429", re.I)
# Evidence that a LATER run finished without exploding. A log that keeps getting
# benign appends (e.g. trade-brief printing "[skip] Outside market hours" every
# minute) stays mtime-fresh forever, so the age<=180 guard never expires an old
# traceback and the job alarms permanently — the exact way a watchdog gets ignored.
# If one of these appears AFTER the last error line, the job has since recovered.
HEALED = re.compile(r"\[skip\]|Written →|wrote |completed|^OK\b|✅", re.I)
DB = Path("/AIWorkWSL/web/missionctrl/pipeline/desk_pipeline.sqlite")

# name, log path, max age in MINUTES during its active window, market-hours-only, [window]
# NOTE: run_desk_cycle.sh / run_desk_flow.sh redirect to /dev/null — they have NO log.
# Their health is read from cycle_metadata in the DB instead (see check_desk_cycle).
#
# `window` = (first_run_HHMM, window_end_HHMM) ET, taken from the job's OWN crontab entry
# when that is narrower than market hours. Without it a job whose first tick is 10:09 gets
# flagged stale every morning from 9:30 — a daily false alarm, and a watchdog that cries
# wolf on schedule is one Mike learns to swipe away. MUST be HHMM, not hour: an hour-level
# window still false-alarms 10:00-10:09 (learned the hard way 07-20). Check `crontab -l`.
JOBS = [
    # cron: 9,39 10-15 → first tick 10:09, last 15:39; legitimately quiet before 10:09
    ("flow-winner",     "/AIWorkWSL/web/missionctrl/firebase-signals/flow_winner_learner.log", 60, True, (1009, 1600)),
    ("trade-brief",     str(HOME / "02_DATA/trade-brief.log"),                          15,   True),   # cron: */5 9-16
    ("flowrank",        str(HOME / "logs/flowrank.log"),                                None, True),
    ("morning-note",    "/AIWorkWSL/web/missionctrl/pipeline/logs/morning_note.log",    None, True),
    ("decipher-main",   str(HOME / "logs/decipher.log"),                                45,   True),
    ("decipher-manage", str(HOME / "logs/decipher_manage.log"),                         15,   True),
    ("outcome-attrib",  "/home/itsju/web/missionctrl/pipeline/logs/outcome_attribution.log", None, False),
]


def market_open():
    """True/False during/outside RTH on a weekday; None if we can't tell."""
    now = datetime.now(ET)
    if now.weekday() > 4:
        return False
    mins = now.hour * 60 + now.minute
    return 9 * 60 + 30 <= mins <= 16 * 60


def check_logs(mo):
    out = []
    now = time.time()
    _n = datetime.now(ET)
    hhmm_et = _n.hour * 100 + _n.minute
    for job in JOBS:
        name, path, max_age, mh_only = job[:4]
        window = job[4] if len(job) > 4 else None
        # Outside the job's own cron window, staleness is the designed state, not a fault.
        in_window = window is None or (window[0] <= hhmm_et <= window[1])
        p = Path(path)
        rec = {"job": name, "log": path, "problems": []}
        if not p.exists():
            rec["problems"].append("log missing")
            rec["age_min"] = None
        else:
            age = (now - p.stat().st_mtime) / 60
            rec["age_min"] = round(age, 1)
            # Staleness only counts inside the window the job is supposed to run in.
            if max_age is not None and not (mh_only and mo is not True) and in_window:
                if age > max_age:
                    rec["problems"].append("stale %.0fm (expected <%dm)" % (age, max_age))
            if age <= 180:  # only scan recently-touched logs; old tracebacks are noise
                try:
                    tail = p.read_text(errors="ignore").splitlines()[-40:]
                    last_err = max((i for i, ln in enumerate(tail) if ERR.search(ln)),
                                   default=None)
                    if last_err is not None:
                        healed = any(HEALED.search(ln) for ln in tail[last_err + 1:])
                        if not healed:
                            rec["problems"].append(
                                "error in tail: %s" % ERR.search(tail[last_err]).group(0))
                except Exception as e:
                    rec["problems"].append("unreadable: %s" % e)
        out.append(rec)
    return out


def check_desk_cycle(mo):
    """The desk cycle logs to /dev/null, so cycle_metadata IS the health signal.
    A cron that exits 0 while writing no cycle row is exactly the silent failure
    that has burned this desk before."""
    res = {"problems": [], "last_cycle": None, "status": None}
    if not DB.exists():
        res["problems"].append("desk_pipeline.sqlite missing")
        return res
    try:
        con = sqlite3.connect("file:%s?mode=ro" % DB, uri=True, timeout=5)
        row = con.execute(
            "SELECT cycle_id, started_at, completed_at, status, candidates_total "
            "FROM cycle_metadata ORDER BY started_at DESC LIMIT 1").fetchone()
        if not row:
            res["problems"].append("no cycles ever recorded")
            con.close()
            return res
        cid, started, completed, status, cand = row
        res.update({"last_cycle": started, "status": status, "candidates": cand})
        try:
            st = datetime.fromisoformat(started.replace("Z", "+00:00"))
            age_min = (datetime.now(st.tzinfo) - st).total_seconds() / 60
            res["age_min"] = round(age_min, 1)
            # Only a stale cycle DURING market hours is a real problem; overnight and
            # weekend gaps are the fleet working as designed.
            if mo is True and age_min > 40:
                res["problems"].append("no desk cycle for %.0fm during RTH" % age_min)
            # A dangling in_progress row is normal at EOD (the last flow cycle gets
            # cut off at the close). Only flag it while it can still matter.
            if status == "in_progress" and 30 < age_min < 1440:
                res["problems"].append(
                    "cycle stuck in_progress %.0fm (%s)" % (age_min, cid))
        except Exception as e:
            res["problems"].append("unparseable started_at: %s" % e)
        # Did today's cycles actually promote anything through the funnel?
        promoted = con.execute(
            "SELECT COALESCE(SUM(n_promoted),0), COUNT(*) FROM pipeline_metrics "
            "WHERE collected_at >= date('now','-1 day')").fetchone()
        res["promoted_24h"], res["metric_rows_24h"] = promoted
        con.close()
    except Exception as e:
        res["problems"].append("db read failed: %s" % e)
    return res


def check_output():
    """Did the pipeline actually PRODUCE something today? A cron can exit 0 and
    still emit nothing — that silent case is what burned us before."""
    res = {"db": str(DB), "problems": []}
    if not DB.exists():
        res["problems"].append("desk_pipeline.sqlite missing")
        return res
    try:
        con = sqlite3.connect("file:%s?mode=ro" % DB, uri=True, timeout=5)
        cur = con.cursor()
        cur.execute("SELECT name FROM sqlite_master WHERE type='table'")
        tables = {r[0] for r in cur.fetchall()}
        res["tables"] = len(tables)
        for t in ("desk_picks", "picks", "flow_alerts", "trades"):
            if t in tables:
                try:
                    cur.execute("SELECT COUNT(*) FROM %s" % t)
                    res[t] = cur.fetchone()[0]
                except Exception:
                    pass
        con.close()
    except Exception as e:
        res["problems"].append("db read failed: %s" % e)
    return res


# Allow-list, not deny-list. Most of the PM2 fleet is deliberately stopped — market-hours
# windowing (memory reference-pm2-efficiency-trim) plus bots parked during the 2026-07-19
# TG collapse. Alerting on "everything not online" trains Mike to ignore the alert, so we
# name ONLY the processes whose absence actually breaks trading.
CRITICAL_24_7 = {"alpaca-fill-listener", "option-signals", "option-relay",
                 "firebase-signal-relay", "boba-mega", "missionctrl", "kb-server",
                 "crypto-profit-lock-boba", "crypto-profit-lock-jazzy", "yf-holdings"}
# Windowed to RTH — being down overnight is correct, not a fault.
# MUST mirror the FLEET array in ~/bin/trading-fleet: these are the only processes
# anything actually starts at 9:00 ET. Listing extras here manufactures a permanent
# market-hours alarm for daemons no cron has ever brought up.
WINDOWED = {"trail-daemon", "trail-daemon-jazzy", "profit-lock-boba", "profit-lock-jazzy",
            "grid-daemon", "auto-bracket"}
# In pm2's list but deliberately NOT auto-started — lab/experimental rigs Mike runs by
# hand (moomoo-quotes awaits the OpenD setup capsule; jesse-lab + vibe-trading are labs).
# Down is their normal state at every hour; never alarm on them.
MANUAL_ONLY = {"moomoo-quotes", "vibe-trading", "jesse-lab"}


def check_pm2(mo):
    try:
        # pm2's shebang is `#!/usr/bin/env node`, so node must be on PATH too. This runs
        # fine from an interactive Monitor, but resolving it here means the checker can
        # never die the same silent death it exists to catch (cf. trading-fleet, 07-20).
        env = {**os.environ}
        node_bins = sorted((HOME / ".nvm/versions/node").glob("*/bin"))
        if node_bins:
            env["PATH"] = f"{node_bins[-1]}:{env.get('PATH','')}"
        raw = subprocess.run(["pm2", "jlist"], capture_output=True, text=True,
                             timeout=15, env=env).stdout
        procs = json.loads(raw)
        down = [p["name"] for p in procs
                if p.get("pm2_env", {}).get("status") != "online"]
        # Outside RTH, a windowed daemon being stopped is expected, not a fault.
        unexpected = [n for n in down if n in CRITICAL_24_7]
        if mo is True:
            unexpected += [n for n in down if n in WINDOWED]
        # Belt-and-braces: a lab rig re-added to WINDOWED later can't resurrect the alarm.
        unexpected = [n for n in unexpected if n not in MANUAL_ONLY]
        return {"online": len(procs) - len(down), "down_total": len(down),
                "unexpected_down": unexpected}
    except Exception as e:
        return {"error": str(e)}


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--json", action="store_true")
    ap.add_argument("--fingerprint", action="store_true",
                    help="stable hash of the PROBLEM SET only (ages/timestamps stripped) "
                         "so a repeating loop can latch and avoid re-pinging the same issue")
    a = ap.parse_args()
    mo = market_open()
    report = {
        "when_et": datetime.now(ET).strftime("%Y-%m-%d %H:%M %Z"),
        "market_open": mo,
        "logs": check_logs(mo),
        "desk_cycle": check_desk_cycle(mo),
        "output": check_output(),
        "pm2": check_pm2(mo),
    }
    bad = [r for r in report["logs"] if r["problems"]]
    for k in ("desk_cycle", "output"):
        if report[k]["problems"]:
            bad.append(report[k])
    if report["pm2"].get("unexpected_down"):
        bad.append({"job": "pm2", "problems": report["pm2"]["unexpected_down"]})
    report["status"] = "PROBLEM" if bad else "GREEN"

    if a.fingerprint:
        import hashlib
        probs = []
        for r in report["logs"]:
            probs += ["%s:%s" % (r["job"], p) for p in r["problems"]]
        for k in ("desk_cycle", "output"):
            probs += ["%s:%s" % (k, p) for p in report[k]["problems"]]
        probs += ["pm2:%s" % n for n in report["pm2"].get("unexpected_down", [])]
        # strip digits so "stale 41m" and "stale 47m" are the SAME incident
        norm = sorted(re.sub(r"\d+", "#", p) for p in probs)
        print("GREEN" if not norm else hashlib.md5("|".join(norm).encode()).hexdigest()[:8])
        return 1 if norm else 0

    if a.json:
        print(json.dumps(report, indent=1))
    else:
        print("%s  %s  (market_open=%s)" % (report["status"], report["when_et"], mo))
        for r in report["logs"]:
            mark = "!!" if r["problems"] else "ok"
            print("  %s %-16s age=%-7s %s" % (
                mark, r["job"], r["age_min"], "; ".join(r["problems"])))
        dc = report["desk_cycle"]
        print("  %s desk-cycle       last=%s status=%s age=%smin promoted24h=%s %s" % (
            "!!" if dc["problems"] else "ok", dc.get("last_cycle"), dc.get("status"),
            dc.get("age_min"), dc.get("promoted_24h"), "; ".join(dc["problems"])))
        o = report["output"]
        print("  db: %s" % ("; ".join(o["problems"]) if o["problems"]
                            else " ".join("%s=%s" % (k, v) for k, v in o.items()
                                          if k not in ("db", "problems"))))
        p = report["pm2"]
        if p.get("unexpected_down"):
            print("  !! pm2 unexpectedly down: %s" % ", ".join(p["unexpected_down"]))
        else:
            print("  ok pm2: %s online, %s down (all expected for this window)" % (
                p.get("online"), p.get("down_total")))
    return 1 if bad else 0


if __name__ == "__main__":
    sys.exit(main())
