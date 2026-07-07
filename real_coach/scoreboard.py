#!/usr/bin/env python3
"""scoreboard.py — Sunday "Rules vs Gut" card (cron 11:30 ET Sunday).

Aggregates decision_outcomes: verdicts Mike FOLLOWED vs OVERRODE — who was right,
at each horizon, with the expectancy gap. This is the receipts machine his
discipline mode asked for. Sends a text scoreboard (card once data accrues).
"""
from __future__ import annotations

import sqlite3
import subprocess
import sys
from pathlib import Path

DB = Path.home() / "portfolio" / "mike.sqlite"
TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"


def main() -> int:
    con = sqlite3.connect(str(DB), timeout=30)
    total = con.execute("SELECT COUNT(*) FROM decision_ledger").fetchone()[0]
    acted = con.execute("SELECT mike_action, COUNT(*) FROM decision_ledger "
                        "WHERE mike_action!='pending' GROUP BY mike_action").fetchall()
    lines = ["🥊 RULES vs GUT — weekly scoreboard",
             f"decisions logged: {total}"]
    if acted:
        lines.append("your responses: " + ", ".join(f"{a}={n}" for a, n in acted))
    rows = con.execute(
        "SELECT dl.mike_action, o.horizon, COUNT(*), AVG(o.verdict_right)*100,"
        " AVG(o.pnl_pct) FROM decision_outcomes o JOIN decision_ledger dl"
        " ON dl.id=o.decision_id WHERE dl.mike_action IN ('followed','overrode')"
        " GROUP BY dl.mike_action, o.horizon ORDER BY 1, 2").fetchall()
    if rows:
        lines.append("")
        for action, hz, n, right_pct, avg_pnl in rows:
            lines.append(f"{'✅' if action == 'followed' else '✋'} {action} {hz}: "
                         f"{n} scored · verdict right {right_pct:.0f}% · "
                         f"avg move {avg_pnl:+.1f}%")
        lines.append("\n(right% = the coach's call; when you OVERRIDE and right% is "
                     "high, the rules were beating your gut)")
    else:
        lines.append("no scored FOLLOW/OVERRIDE decisions yet — tap the buttons on "
                     "coach cards this week and the receipts start Sunday.")
    msg = "\n".join(lines)
    print(msg)
    if "--send" in sys.argv:
        subprocess.run([sys.executable, str(TG_FLEET), "send", "trading_command", msg],
                       timeout=30, check=False)
    return 0


if __name__ == "__main__":
    sys.exit(main())
