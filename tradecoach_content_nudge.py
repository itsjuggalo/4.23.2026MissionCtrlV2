#!/usr/bin/env python3
"""tradecoach_content_nudge.py — daily 9a ET build-in-public content prompt.

Picks today's script (1-14, rotating; full kit: ~/restructure/TRADECOACH-CONTENT-KIT.md),
pulls live Exit Board counts from the local TradeCoach app (:3002) for a concrete
"today's footage" angle, and DMs Mike via tg_fleet trading_command (LaptopClaude bot).
Fail-open: if the app is down, the nudge still sends without live stats.

Usage: tradecoach_content_nudge.py [--dry-run]
"""
import json
import secrets
import sqlite3
import sys
import urllib.request
from datetime import date
from pathlib import Path

sys.path.insert(0, str(Path.home() / "scripts"))

DB = "/AIWorkWSL/web/tradecoach/data/tradecoach.sqlite"
START = date(2026, 7, 9)  # day 1

SCRIPTS = [
    ("The confession", "79% win rate. Still lost money.", "upload your 5y CSV on camera, grades animate in — hold on the F"),
    ("The F explained", "My median buy was $100. My biggest was $4,946.", "sizing section, the 49x stat, top-5 YOLO table"),
    ("$ left on the table", "Lead with the Post-Sell dollar number.", "Post-Sell page, Hall of Pain rows"),
    ("The blocked trade", "My app just told me NO.", "type an oversized ticket live, red gate banner, override textarea"),
    ("Holding losers", "I rode a position to -72%.", "deepest-rides table on the report card"),
    ("Exit Board day", "N of my holdings are below their stop line right now.", "BREACHED rows on the Exit Board"),
    ("Why no broker login", "This app can't touch my money.", "upload page privacy note, CSV flow"),
    ("Options net red", "I won 79% of my option trades and lost $1,373.", "options section, expired-worthless count"),
    ("FOMO test", "Did I chase? The data answers.", "FOMO section, chased-vs-patient medians"),
    ("Build log", "I built this SaaS in one day with AI agents.", "30s montage — code tree, PM2, pages"),
    ("The ledger", "Every time I overrule my rules, it gets scored.", "Override Ledger gut-vs-rules scoreboard"),
    ("Week trade log", "One week trading WITH a coach. Here's the diff.", "tickets history won/lost + a breach you acted on"),
    ("Someone else's card", "I graded a friend's trades.", "their grades vs yours (with permission)"),
    ("The number", "Day N. $X MRR. Here's the plan.", "pricing page + honest tracker, radical transparency"),
]


def exit_board_counts():
    """Mint a 1-day session for user 1 directly in the local DB, hit the API."""
    try:
        con = sqlite3.connect(DB)
        tok = secrets.token_hex(32)
        con.execute(
            "INSERT INTO sessions(token, user_id, expires_at) VALUES(?, 1, datetime('now','+1 day'))",
            (tok,),
        )
        con.execute("DELETE FROM sessions WHERE expires_at < datetime('now')")
        con.commit()
        con.close()
        req = urllib.request.Request(
            "http://127.0.0.1:3002/api/exit-board",
            headers={"Cookie": f"tc_session={tok}"},
        )
        with urllib.request.urlopen(req, timeout=60) as r:
            rows = json.load(r).get("rows", [])
        c = {}
        for row in rows:
            c[row.get("status", "?")] = c.get(row.get("status", "?"), 0) + 1
        return c
    except Exception:
        return None


def main():
    day_n = (date.today() - START).days + 1
    idx = (day_n - 1) % len(SCRIPTS)
    title, hook, shot = SCRIPTS[idx]

    lines = [
        f"🎬 TradeCoach content — day {day_n} (script {idx + 1}/14: {title})",
        f'HOOK: "{hook}"',
        f"SHOT: {shot}",
    ]
    counts = exit_board_counts()
    if counts:
        breached = counts.get("BREACHED", 0)
        near = counts.get("NEAR", 0)
        dead = counts.get("DEAD_BAG", 0)
        lines.append(f"📟 Exit Board right now: {breached} breached · {near} near · {dead} dead bags — today's live footage.")
    lines.append("📱 https://g59-wsl.taile1328b.ts.net:3002 · full kit: TRADECOACH-CONTENT-KIT.md")
    msg = "\n".join(lines)

    if "--dry-run" in sys.argv:
        print(msg)
        return 0
    import tg_fleet

    tg_fleet.send("trading_command", msg)
    print("sent:", msg.splitlines()[0])
    return 0


if __name__ == "__main__":
    sys.exit(main())
