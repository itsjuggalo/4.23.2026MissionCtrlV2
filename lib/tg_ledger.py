#!/usr/bin/env python3
"""tg_ledger — passive record of every Telegram message the fleet sends (2026-09-28).

Hooked into the two shared send points (tg_fleet.send and lib/notify._send_message) so we
can see, per bot, which script sent what and when — the evidence base for rolling chatty
lanes (trading_command, flow_digest) into compact digests. Recording only: it never
changes, delays or blocks a send, and never raises.

  from lib.tg_ledger import record, source
  record(fn, text, ok, html=True)

  python3 lib/tg_ledger.py [--day YYYY-MM-DD] [--fn trading_command]   # per-source summary

DB: ~/.local/state/tg-ledger.sqlite  (table sends).
"""
from __future__ import annotations

import os
import sqlite3
import sys
import time
from pathlib import Path

DB = Path(os.environ.get("TG_LEDGER_DB", str(Path.home() / ".local/state/tg-ledger.sqlite")))
_SCHEMA = """CREATE TABLE IF NOT EXISTS sends (
    id INTEGER PRIMARY KEY, ts REAL NOT NULL, day TEXT NOT NULL, fn TEXT, source TEXT,
    ok INTEGER, html INTEGER, chars INTEGER, lines INTEGER, head TEXT, text TEXT)"""


def _script_of(argv: list[str]) -> str | None:
    for a in argv:
        b = os.path.basename(a)
        if b.endswith((".py", ".sh")) and b not in ("tg_fleet.py", "tg-send-msg"):
            return b
    return None


def source() -> str:
    """The script that asked for this send: this process's script, or — when tg_fleet.py
    runs as a CLI subprocess — the parent's (then grandparent's, for tg-send-msg)."""
    s = _script_of(sys.argv)
    if s:
        return s
    pid = os.getppid()
    for _ in range(3):
        try:
            argv = Path(f"/proc/{pid}/cmdline").read_bytes().decode(errors="replace").split("\0")
            s = _script_of(argv)
            if s:
                return s
            pid = int(Path(f"/proc/{pid}/stat").read_text().rsplit(")", 1)[1].split()[1])
        except Exception:
            break
    try:   # no script in the chain (e.g. an interactive/agent shell) → name the parent process
        return "via:" + Path(f"/proc/{os.getppid()}/comm").read_text().strip()
    except Exception:
        return os.path.basename(sys.argv[0] or "?")


def record(fn: str, text: str, ok: bool, *, html: bool = False, src: str | None = None) -> None:
    try:
        text = text or ""
        now = time.time()
        DB.parent.mkdir(parents=True, exist_ok=True)
        con = sqlite3.connect(DB, timeout=3)
        try:
            con.execute(_SCHEMA)
            con.execute(
                "INSERT INTO sends (ts, day, fn, source, ok, html, chars, lines, head, text)"
                " VALUES (?,?,?,?,?,?,?,?,?,?)",
                (now, time.strftime("%Y-%m-%d", time.localtime(now)), fn, src or source(),
                 int(bool(ok)), int(bool(html)), len(text), text.count("\n") + 1,
                 text.strip().split("\n", 1)[0][:160], text))
            con.commit()
        finally:
            con.close()
    except Exception:
        pass   # a ledger hiccup must never touch a real alert


def summary(day: str | None = None, fn: str | None = None) -> None:
    day = day or time.strftime("%Y-%m-%d")
    con = sqlite3.connect(f"file:{DB}?mode=ro", uri=True)
    q = "SELECT fn, source, COUNT(*), SUM(chars), MIN(ts), MAX(ts) FROM sends WHERE day=?"
    args: list = [day]
    if fn:
        q += " AND fn=?"; args.append(fn)
    rows = con.execute(q + " GROUP BY fn, source ORDER BY fn, COUNT(*) DESC", args).fetchall()
    hm = lambda t: time.strftime("%H:%M", time.localtime(t))
    print(f"{day}  {'fn':16} {'source':32} msgs  chars  first-last")
    for f, s, n, c, a, b in rows:
        print(f"      {f:16} {s:32} {n:4} {c:6}  {hm(a)}-{hm(b)}")
    print(f"      total {sum(r[2] for r in rows)} messages")


if __name__ == "__main__":
    a = sys.argv[1:]
    summary(a[a.index("--day") + 1] if "--day" in a else None,
            a[a.index("--fn") + 1] if "--fn" in a else None)
