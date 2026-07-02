#!/usr/bin/env python3
"""Register a background task for watchdog tracking.

Usage:
  python3 register_task.py \\
    --name "Kronos retraining" \\
    --desc "Fine-tuning on expanded telegram dataset" \\
    --check log_tail \\
    --target /AIWorkWSL/web/missionctrl/logs/kronos_train.log \\
    --pattern "Training complete|Epoch 10" \\
    --timeout 6

Check types:
  log_tail   -- tail log file, match --pattern (regex) in last 100 lines
  process    -- ps aux match --pattern; ghost if not running past timeout
  file_newer -- file at --target exists and is newer than now
  sql        -- sqlite3 at --target, --pattern is a SELECT returning >0
"""
import argparse
import sqlite3
from datetime import datetime, timezone
from pathlib import Path

TASK_DB = Path.home() / "background_tasks.sqlite"


def main():
    ap = argparse.ArgumentParser(description="Register a background task")
    ap.add_argument("--name",    required=True,  help="Short task name")
    ap.add_argument("--desc",    default="",     help="Description")
    ap.add_argument("--check",   required=True,  choices=["log_tail", "process", "file_newer", "sql"],
                    help="How to detect completion")
    ap.add_argument("--target",  required=True,  help="Log path, process grep, file path, or DB path")
    ap.add_argument("--pattern", default="",     help="Regex or SQL SELECT for completion check")
    ap.add_argument("--timeout", type=float, default=4.0, help="Ghost threshold in hours (default 4)")
    ap.add_argument("--session", default="",     help="Claude session ID for traceability")
    args = ap.parse_args()

    if not TASK_DB.exists():
        print(f"DB not found: {TASK_DB}. Run init_task_db.py first.")
        return 1

    now = datetime.now(timezone.utc).isoformat(timespec="seconds")
    con = sqlite3.connect(str(TASK_DB), timeout=10)
    cur = con.execute(
        """INSERT INTO tasks
           (name, description, started_at, timeout_h, check_type, check_target, check_pattern, session_id)
           VALUES (?, ?, ?, ?, ?, ?, ?, ?)""",
        (args.name, args.desc, now, args.timeout, args.check, args.target, args.pattern, args.session),
    )
    task_id = cur.lastrowid
    con.commit()
    con.close()

    print(f"Registered task #{task_id}: {args.name}")
    print(f"  check: {args.check} on {args.target}")
    if args.pattern:
        print(f"  pattern: {args.pattern}")
    print(f"  timeout: {args.timeout}h")
    print(f"  watchdog will ping #pipeline-alerts when done")
    return 0


if __name__ == "__main__":
    exit(main())
