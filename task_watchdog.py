#!/usr/bin/env python3
"""Background task watchdog — checks registered tasks, notifies Discord on complete/ghost.

Registered via: ~/scripts/register_task.py or the /track Claude skill.
DB: ~/background_tasks.sqlite
Cron: */15 * * * *

Check types:
  log_tail    - tail POSIX path (check_target), match regex (check_pattern) in last 100 lines
  process     - grep 'ps aux' for check_pattern; ghost if not running past timeout
  file_newer  - check_target file exists AND is newer than task started_at
  sql         - sqlite3 check_target DB, check_pattern is a SELECT returning >0 rows
"""
import json
import os
import re
import sqlite3
import subprocess
import sys
import urllib.request
from datetime import datetime, timezone
from pathlib import Path

TASK_DB   = Path.home() / "background_tasks.sqlite"
WEBHOOK   = Path.home() / ".openclaw/secrets/discord_pipeline_alerts_webhook"
PING_SCRIPT = Path.home() / "scripts" / "ping_mike.py"

NOW = datetime.now(timezone.utc)


def webhook_url() -> str | None:
    # Discord disabled 2026-06-16 (Mike: ops/monitoring off Discord). The Telegram
    # alert (post_telegram) still fires, so task-ghost breakage is still surfaced —
    # just not in Discord. Re-enable by restoring the secret read below.
    return None


def post_discord(msg: str) -> None:
    url = webhook_url()
    if not url:
        print("no webhook configured", file=sys.stderr)
        return
    try:
        import requests as _req
        _req.post(url, json={"content": msg}, timeout=10)
    except Exception as e:
        print(f"discord post failed: {e}", file=sys.stderr)


def post_telegram(msg: str) -> None:
    # ping_mike.py sends PLAIN text (no parse_mode) -> strip Discord markdown so it reads clean
    plain = msg.replace("**", "").replace("`", "")
    try:
        subprocess.run(["/usr/bin/python3", str(PING_SCRIPT), plain],
                       timeout=20, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    except Exception as e:
        print(f"telegram ping failed: {e}", file=sys.stderr)


def notify(msg: str) -> None:
    """Fan out every watchdog alert to BOTH Discord #pipeline-alerts and Telegram."""
    post_discord(msg)
    post_telegram(msg)


def check_log_tail(target: str, pattern: str) -> bool:
    path = Path(os.path.expanduser(target))
    if not path.exists():
        return False
    try:
        lines = path.read_text(errors="replace").splitlines()
        tail = "\n".join(lines[-100:])
        return bool(re.search(pattern, tail, re.IGNORECASE))
    except Exception:
        return False


def check_process(pattern: str) -> bool:
    try:
        result = subprocess.run(["ps", "aux"], capture_output=True, text=True)
        return bool(re.search(pattern, result.stdout))
    except Exception:
        return False


def check_file_newer(target: str, started_at: str) -> bool:
    path = Path(os.path.expanduser(target))
    if not path.exists():
        return False
    try:
        mtime = datetime.fromtimestamp(path.stat().st_mtime, tz=timezone.utc)
        started = datetime.fromisoformat(started_at.replace("Z", "+00:00"))
        return mtime > started
    except Exception:
        return False


def check_sql(target: str, pattern: str) -> bool:
    db = Path(os.path.expanduser(target))
    if not db.exists():
        return False
    try:
        con = sqlite3.connect(str(db), timeout=5)
        row = con.execute(pattern).fetchone()
        con.close()
        return bool(row and row[0])
    except Exception:
        return False


def run_check(task: dict) -> bool:
    ct = task["check_type"]
    if ct in ("log_tail", "log"):  # 'log' = alias some /track registrations use
        return check_log_tail(task["check_target"], task["check_pattern"] or "")
    if ct == "process":
        return check_process(task["check_pattern"] or task["check_target"])
    if ct == "file_newer":
        return check_file_newer(task["check_target"], task["started_at"])
    if ct == "sql":
        return check_sql(task["check_target"], task["check_pattern"] or "SELECT 1")
    return False


def hours_running(started_at: str) -> float:
    try:
        started = datetime.fromisoformat(started_at.replace("Z", "+00:00"))
        if started.tzinfo is None:  # /track writes some rows tz-naive -> assume UTC
            started = started.replace(tzinfo=timezone.utc)
        return (NOW - started).total_seconds() / 3600
    except Exception:
        return 0.0


def main():
    if not TASK_DB.exists():
        return

    con = sqlite3.connect(str(TASK_DB), timeout=10)
    con.row_factory = sqlite3.Row
    tasks = con.execute(
        "SELECT * FROM tasks WHERE status = 'running' ORDER BY started_at"
    ).fetchall()

    for task in tasks:
        t = dict(task)
        name = t["name"]
        hrs  = hours_running(t["started_at"])
        done = run_check(t)
        is_ghost = hrs > (t["timeout_h"] or 4.0)

        if done:
            con.execute(
                "UPDATE tasks SET status='complete', completed_at=?, notes=? WHERE id=?",
                (NOW.isoformat(timespec="seconds"), f"detected after {hrs:.1f}h", t["id"]),
            )
            con.commit()
            notify(
                f"✅ **Task complete** — {name}\n"
                f"⏱ Ran for {hrs:.1f}h\n"
                f"📋 {t['description'] or ''}"
            )
            print(f"[watchdog] COMPLETE: {name}")

        elif is_ghost:
            con.execute(
                "UPDATE tasks SET status='ghost', completed_at=?, notes=? WHERE id=?",
                (NOW.isoformat(timespec="seconds"), f"timed out after {hrs:.1f}h (limit {t['timeout_h']}h)", t["id"]),
            )
            con.commit()
            notify(
                f"⚠️ **Task ghost** — {name}\n"
                f"⏱ Still running after {hrs:.1f}h (limit {t['timeout_h']:.0f}h) — may be stuck\n"
                f"📋 {t['description'] or ''}\n"
                f"🔍 Check: `{t['check_type']}` on `{t['check_target']}`"
            )
            print(f"[watchdog] GHOST: {name}")

        else:
            print(f"[watchdog] still running ({hrs:.1f}h / {t['timeout_h']}h): {name}")

    con.close()


if __name__ == "__main__":
    main()
