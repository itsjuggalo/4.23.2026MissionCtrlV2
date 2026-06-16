#!/usr/bin/env python3
"""DB contention monitor — the *detection* layer for SQLite lock contention.

Prevention lives elsewhere (WAL + busy_timeout in the connect helpers, flock on
the cron wrappers). This script catches the failure modes that slip past
prevention, which in Mike's stack are the only real "deadlock-like" events:

  1. WAL REVERTED   — a shared DB silently dropped back to rollback journal
                      (delete/truncate). Under rollback journal a writer blocks
                      every reader, which is how "database is locked" storms
                      start. WAL is persistent, but a stray VACUUM / restore /
                      manual session can flip it; this re-flags + re-asserts it.
  2. LOCK STORMS    — recent log lines showing "database is locked / busy" or
                      "disk I/O error" across the pipeline / nightshift / life
                      logs (a contended writer that exhausted its busy_timeout).
  3. WEDGED CYCLES  — a /tmp/desk_*.lock held far longer than its wrapper's
                      timeout, i.e. a cron cycle that never released its flock
                      (the practical "deadlock": everything behind it is starved).

Findings post to the pipeline-alerts Discord webhook (same preference order the
wrappers use). Always prints a one-line summary. Exit 0 always (cron-friendly).

Cron: */30 * * * *  /usr/bin/python3 /home/itsju/scripts/db_contention_monitor.py
"""
from __future__ import annotations

import fcntl
import glob
import os
import re
import sqlite3
import subprocess
import sys
import time
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

HOME = Path.home()

# Shared DBs whose journal mode must stay WAL. (path, re_assert_if_reverted)
WAL_DBS = [
    (HOME / "LapClaw/pipeline/desk_pipeline.sqlite", True),
    (HOME / "background_tasks.sqlite", True),
    (HOME / "cron/nightshift/nightshift.sqlite", True),
]

# Logs to scan for contention signatures (only files touched recently are read).
LOG_GLOBS = [
    str(HOME / "LapClaw/pipeline/logs/*.log"),
    str(HOME / "cron/nightshift/logs/*.log"),
    str(HOME / "logs/*.log"),
    str(HOME / "scripts/task_watchdog.log"),
]
CONTENTION_RE = re.compile(
    r"database is locked|database is busy|disk I/O error|database disk image is malformed",
    re.IGNORECASE,
)
LOG_WINDOW_S = 35 * 60      # only scan logs modified within this window
LOG_TAIL_LINES = 400        # ...and only their tail (avoids re-counting old storms)

# flock lockfiles dropped by the desk cron wrappers.
LOCK_GLOB = "/tmp/desk_*.lock"
STALE_LOCK_S = 25 * 60      # held longer than any wrapper's timeout => wedged

WEBHOOK_CANDIDATES = [
    HOME / ".openclaw/secrets/discord_pipeline_alerts_webhook",
    HOME / ".openclaw/secrets/discord-webhook-risk-alerts.txt",
    HOME / ".openclaw/secrets/discord_daily_wrap_webhook",
]


def webhook_url() -> str | None:
    for c in WEBHOOK_CANDIDATES:
        try:
            if c.is_file():
                url = c.read_text().strip()
                if url.startswith("http"):
                    return url
        except Exception:
            continue
    return None


def post_discord(msg: str) -> None:
    url = webhook_url()
    if not url:
        return
    try:
        data = ('{"content": %s}' % _json_str(msg)).encode()
        # Discord/Cloudflare 403s the default Python-urllib User-Agent — set a real one.
        req = urllib.request.Request(
            url, data=data, headers={
                "Content-Type": "application/json",
                "User-Agent": "MissionControl-DBMonitor/1.0 (+https://missionctrl.serveftp.com)",
            }
        )
        urllib.request.urlopen(req, timeout=10).read()
    except Exception:
        pass


def _json_str(s: str) -> str:
    import json
    return json.dumps(s)


def check_wal() -> list[str]:
    findings = []
    for db, reassert in WAL_DBS:
        if not db.is_file():
            continue
        try:
            con = sqlite3.connect(str(db), timeout=10)
            mode = con.execute("PRAGMA journal_mode").fetchone()[0].lower()
            if mode != "wal":
                action = ""
                if reassert:
                    con.execute("PRAGMA journal_mode=WAL")
                    new = con.execute("PRAGMA journal_mode").fetchone()[0].lower()
                    action = f" → re-asserted ({'ok' if new == 'wal' else 'FAILED, now ' + new})"
                findings.append(f"WAL REVERTED: {db.name} was '{mode}'{action}")
            con.close()
        except Exception as e:
            findings.append(f"WAL CHECK ERROR: {db.name}: {e}")
    return findings


def _tail(path: str, n: int) -> list[str]:
    try:
        with open(path, "r", errors="replace") as f:
            return f.readlines()[-n:]
    except Exception:
        return []


def check_logs() -> list[str]:
    findings = []
    now = time.time()
    total = 0
    samples = []
    for pattern in LOG_GLOBS:
        for path in glob.glob(pattern):
            try:
                if now - os.path.getmtime(path) > LOG_WINDOW_S:
                    continue
            except OSError:
                continue
            for line in _tail(path, LOG_TAIL_LINES):
                if CONTENTION_RE.search(line):
                    total += 1
                    if len(samples) < 3:
                        samples.append(f"{os.path.basename(path)}: {line.strip()[:160]}")
    if total:
        findings.append(
            f"LOCK STORM: {total} contention line(s) in last {LOG_WINDOW_S // 60}min:\n  "
            + "\n  ".join(samples)
        )
    return findings


def _lock_holder_age(lockfile: str) -> float | None:
    """Return seconds the lock has been held, or None if free / unknown."""
    # Is it actually held? Try a non-blocking shared lock on our own fd.
    try:
        fd = os.open(lockfile, os.O_RDWR)
    except OSError:
        return None
    try:
        try:
            fcntl.flock(fd, fcntl.LOCK_EX | fcntl.LOCK_NB)
            fcntl.flock(fd, fcntl.LOCK_UN)  # we got it → not held
            return None
        except BlockingIOError:
            pass  # held by someone else → find the holder
    finally:
        os.close(fd)
    # Best-effort: holder PID via fuser, age via ps etimes.
    try:
        out = subprocess.run(
            ["fuser", lockfile], capture_output=True, text=True, timeout=5
        ).stdout.split()
        for pid in out:
            pid = pid.strip()
            if not pid.isdigit():
                continue
            et = subprocess.run(
                ["ps", "-o", "etimes=", "-p", pid], capture_output=True, text=True, timeout=5
            ).stdout.strip()
            if et.isdigit():
                return float(et)
    except Exception:
        pass
    return -1.0  # held but age unknown


def check_locks() -> list[str]:
    findings = []
    for lockfile in glob.glob(LOCK_GLOB):
        age = _lock_holder_age(lockfile)
        if age is None or age < 0:
            # Free, or held-but-age-unknown. Without the holder's age we can't
            # tell a wedged cycle from a normally-running one (a held desk lock
            # under STALE_LOCK_S is normal mid-cycle), so don't alert.
            continue
        if age > STALE_LOCK_S:
            findings.append(
                f"WEDGED CYCLE: {lockfile} held {int(age // 60)}min "
                f"(> {STALE_LOCK_S // 60}min timeout) — cron cycle never released its flock"
            )
    return findings


# ── Visual card (StarCraft ops card) — optional, falls back to full text ─────
# Reuses ~/05_AUTOMATION/scripts/lib/ops_card.py (which reuses the LifeClaw
# renderer primitives). A card bug NEVER drops the alert: _post_card returns
# False and main() posts the original text body instead.
sys.path.insert(0, str(HOME / "05_AUTOMATION/scripts/lib"))


def _storm_count(findings) -> int:
    for f in findings:
        m = re.search(r"LOCK STORM: (\d+)", f)
        if m:
            return int(m.group(1))
    return 0


def _card_spec(findings):
    import ops_card
    storm = _storm_count(findings)
    wedged = [f for f in findings if f.startswith("WEDGED")]
    wal = [f for f in findings if f.startswith("WAL REVERTED")]
    errs = [f for f in findings if "ERROR" in f]
    rows = []
    if storm:
        rows.append({"label": "Lock-storm lines (35m)", "value": str(storm),
                     "state": "crit" if storm > 50 else "warn"})
    if wedged:
        rows.append({"label": "Wedged cron cycles", "value": str(len(wedged)), "state": "crit"})
    if wal:
        rows.append({"label": "WAL reverted", "value": str(len(wal)), "state": "warn"})
    if errs:
        rows.append({"label": "Check errors", "value": str(len(errs)), "state": "warn"})
    rows.append({"label": "Total findings", "value": str(len(findings)),
                 "state": "crit" if (wedged or storm > 50) else "warn"})
    sample = [f.split("\n")[0][:90] for f in findings]
    return {
        "bot": "SPIDEY", "title": "DB CONTENTION", "glyph": "reticle",
        "status": "crit" if (wedged or storm > 50) else "warn",
        "status_text": "WEDGED" if wedged else ("LOCK STORM" if storm else "DEGRADED"),
        "rows": rows,
        "sections": [{"label": "Findings", "items": sample[:4]}] if sample else [],
        "subtitle": ops_card.now_et(),
        "footer": "db contention monitor · */30m",
    }


def _card_summary(findings) -> str:
    storm = _storm_count(findings)
    wedged = sum(1 for f in findings if f.startswith("WEDGED"))
    bits = []
    if storm:
        bits.append(f"{storm} lock lines/35m")
    if wedged:
        bits.append(f"{wedged} wedged cycle{'s' if wedged != 1 else ''}")
    bits.append(f"{len(findings)} finding{'s' if len(findings) != 1 else ''}")
    return ":lock: **DB contention** — " + " · ".join(bits)


def _post_card(findings) -> bool:
    try:
        import ops_card
    except Exception:
        return False
    url = webhook_url()
    if not url:
        return False
    try:
        out = f"/tmp/ops_card_dbcontention_{int(time.time())}.png"
        png = ops_card.render_ops_card(_card_spec(findings), out)
        return bool(png and ops_card.post_image(url, png, content=_card_summary(findings)))
    except Exception:
        return False


def main() -> None:
    findings = check_wal() + check_logs() + check_locks()
    ts = datetime.now(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ")
    if findings:
        body = f":lock: **DB contention monitor** — {len(findings)} finding(s) @ {ts}\n" + "\n".join(
            f"- {f}" for f in findings
        )
        print(body)
        # Discord posting DISABLED 2026-06-16 (Mike): DB-contention is infra
        # noise, not trading/politics. The monitor + WAL self-heal (check_wal)
        # still run every 30m and log findings here; we just no longer spam
        # Discord with them. Re-enable by restoring the _post_card/post_discord
        # calls below if an ops channel is ever wanted again.
        if "--discord" in sys.argv:  # opt-in only; cron does NOT pass it
            if not _post_card(findings):
                post_discord(body[:1900] + ("\n…(truncated)" if len(body) > 1900 else ""))
    else:
        print(f"{ts} db-contention-monitor: clean (WAL ok, no lock storms, no wedged cycles)")


if __name__ == "__main__":
    main()
