"""Pre-send review for every fleet Telegram send (Mike, 2026-10-08: "all messages should be
reviewed for accuracy before being sent to telegram").

Deterministic and FAIL-OPEN: any error inside the review returns the original text, so a
lint bug can never drop a trading alert.

review(fn, text) -> (text | None, notes)
  None  = HOLD (not sent, logged to ~/.local/state/tg-lint.jsonl):
          - exact repeat of a message this lane already delivered in the last 30 min
          - unrendered template / placeholder / Python error text on a trading lane
  text  = possibly cleaned:
          - internal ids removed ("id MU:DECIPHER:2026…", "PCRX:SETUP:2026…")
          - runs of 3+ blank lines collapsed

CLI:  python3 lib/tg_lint.py --today      # holds + rewrites logged today
"""
from __future__ import annotations

import json
import os
import re
import sqlite3
import time
from pathlib import Path

LOG = Path(os.environ.get("TG_LINT_LOG", str(Path.home() / ".local/state/tg-lint.jsonl")))
LEDGER = Path(os.environ.get("TG_LEDGER_DB", str(Path.home() / ".local/state/tg-ledger.sqlite")))
REPEAT_WINDOW_S = 30 * 60
NON_TRADING = {"system_health", "life_wellness", "astrology", "winmeals"}

_ID = re.compile(r"(?:\s*[·|]\s*)?\bid\s+[A-Z][A-Z0-9.]{0,9}:[A-Z_]{3,}:[\w.:-]+"   # "· id MU:DECIPHER:2026…"
                 r"|\b[A-Z][A-Z0-9.]{0,9}:(?:SETUP|WATCH|DECIPHER|TRIGGER|BEST3):\d[\w.:-]*")
_BROKEN = re.compile(r"<DATE>|<PRICE>|<SYM(?:BOL)?>|\{[a-z_]{2,}\}|\$nan\b|\bnan%|\$None\b|"
                     r"Traceback \(most recent call last\)")
_BLANKS = re.compile(r"\n[ \t]*\n(?:[ \t]*\n)+")


def _recent_identical(fn: str, text: str) -> bool:
    if not LEDGER.exists():
        return False
    con = sqlite3.connect(f"file:{LEDGER}?mode=ro", uri=True, timeout=2)
    try:
        row = con.execute("select 1 from sends where fn=? and ok=1 and ts>=? and text=? limit 1",
                          (fn, time.time() - REPEAT_WINDOW_S, text)).fetchone()
    finally:
        con.close()
    return row is not None


def _log(fn: str, action: str, notes: list[str], text: str) -> None:
    try:
        LOG.parent.mkdir(parents=True, exist_ok=True)
        with LOG.open("a") as f:
            f.write(json.dumps({"ts": time.time(), "day": time.strftime("%Y-%m-%d"), "fn": fn,
                                "action": action, "notes": notes, "head": text[:160]}) + "\n")
    except Exception:
        pass


def review(fn: str, text: str) -> tuple[str | None, list[str]]:
    try:
        notes: list[str] = []
        out = text
        if fn not in NON_TRADING:
            m = _BROKEN.search(out)
            if m:
                notes.append(f"broken render: {m.group(0)!r}")
                _log(fn, "hold", notes, text)
                return None, notes
        cleaned = _ID.sub("", out)
        if cleaned != out:
            notes.append("internal id removed")
            out = cleaned
        collapsed = _BLANKS.sub("\n\n", out)
        if collapsed != out:
            out = collapsed
        if _recent_identical(fn, out) or (out != text and _recent_identical(fn, text)):
            notes.append(f"exact repeat within {REPEAT_WINDOW_S // 60} min")
            _log(fn, "hold", notes, text)
            return None, notes
        if notes:
            _log(fn, "rewrite", notes, text)
        return out, notes
    except Exception as e:   # fail-open: never drop a message because the reviewer broke
        _log(fn, "error", [f"{type(e).__name__}: {e}"], text)
        return text, []


if __name__ == "__main__":
    import sys
    if "--today" in sys.argv:
        day = time.strftime("%Y-%m-%d")
        rows = [json.loads(l) for l in LOG.read_text().splitlines() if l.strip()] if LOG.exists() else []
        rows = [r for r in rows if r.get("day") == day]
        for r in rows:
            print(time.strftime("%H:%M", time.localtime(r["ts"])), r["fn"], r["action"], "; ".join(r["notes"]), "|", r["head"][:80].replace("\n", " "))
        print(f"{len(rows)} reviewed-and-changed today")
