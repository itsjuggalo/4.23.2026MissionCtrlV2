#!/usr/bin/env python3
"""tg_alert_flood_sim.py — replay the last N days of trading_command sends from the tg ledger (READ-ONLY) through
the alert-flood policy in lib/tg_digest.py (Mike GO 2026-10-22, staged) and print the before/after counts.
Nothing is sent, queued or written.

  tg_alert_flood_sim.py [--days 7] [--json]

Policy replayed, in order:
  1. FYI charts (tg_digest.FYI_CHARTS)           → posted on the digest bot, not trading_command
  2. FYI text (tg_digest.mode == "digest")       → folded into the next digest (polymarket is new here)
  3. flow_ta_cards photos of one run (≤ 120 s)   → one album
  4. past the per-source daily cap (not exempt)  → folded into the next digest
"""
import argparse
import json
import sqlite3
import sys
from collections import Counter, defaultdict
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib import tg_digest as D  # noqa: E402

ET = ZoneInfo("America/New_York")
ALBUM_GAP_S = 120


def replay(rows):
    """rows = [(ts, day, source, html, text)] oldest first → per-row outcome list."""
    kept = Counter()                  # (day, source) → trading_command messages kept
    last_album = {}                   # day → ts of the last flow_ta_cards row
    out = []
    for ts, day, src, html, text in rows:
        if src in D.FYI_CHARTS:
            o = "digest_bot"
        elif D.mode(src, text or "", bool(html)) == "digest":
            o = "digest_fold"
        elif src == "flow_ta_cards.py" and ts - last_album.get(day, -1e9) <= ALBUM_GAP_S:
            o = "album_merged"
        elif src not in D.CAP_EXEMPT and kept[(day, src)] >= D.CAP_OVERRIDES.get(src, D.DAILY_CAP):
            o = "cap_fold"
        else:
            o = "kept"
        if src == "flow_ta_cards.py":
            last_album[day] = ts
        if o == "kept":
            kept[(day, src)] += 1
        out.append((ts, day, src, o))
    return out


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--days", type=int, default=7)
    ap.add_argument("--json", action="store_true")
    a = ap.parse_args()
    con = sqlite3.connect(f"file:{D.DB}?mode=ro", uri=True)
    rows = con.execute("SELECT ts, day, source, html, text FROM sends WHERE fn='trading_command' "
                       "AND ts > strftime('%s','now',?) ORDER BY ts", (f"-{a.days} days",)).fetchall()
    con.close()
    res = replay(rows)
    per_day = defaultdict(Counter)
    per_src = defaultdict(Counter)
    burst = defaultdict(Counter)      # the 09:50 minute
    for ts, day, src, o in res:
        per_day[day]["before"] += 1
        per_day[day][o] += 1
        per_src[src]["before"] += 1
        per_src[src][o] += 1
        if datetime.fromtimestamp(ts, ET).strftime("%H:%M") == "09:50":
            burst[day]["before"] += 1
            burst[day]["after"] += o == "kept"
    summary = {"days": a.days, "rows": len(res), "before": len(res), "after": sum(o == "kept" for *_, o in res),
               "outcomes": dict(Counter(o for *_, o in res)), "cap": D.DAILY_CAP, "cap_exempt": sorted(D.CAP_EXEMPT),
               "per_day": {d: dict(c) for d, c in sorted(per_day.items())},
               "burst_0950": {d: dict(c) for d, c in sorted(burst.items())},
               "per_source": {s: dict(c) for s, c in sorted(per_src.items(), key=lambda kv: -kv[1]["before"])}}
    if a.json:
        print(json.dumps(summary, indent=1)); return
    now = datetime.now(ET)
    print(f"trading_command replay · last {a.days} days · tg ledger (read-only) · run {now:%m-%d %H:%M} ET")
    print(f"TOTAL  before {summary['before']}  →  after {summary['after']}  ({summary['outcomes']})")
    print("\nday         before  after  digest_bot  digest_fold  album_merged  cap_fold   | 09:50 before→after")
    for d, c in sorted(per_day.items()):
        b = burst.get(d, Counter())
        print(f"{d}  {c['before']:>6} {c['kept']:>6} {c['digest_bot']:>11} {c['digest_fold']:>12} "
              f"{c['album_merged']:>13} {c['cap_fold']:>9}   | {b['before']} → {b['after']}")
    print("\nsource (before ≥ 5)            before  after   moved")
    for s, c in summary["per_source"].items():
        if c["before"] >= 5:
            moved = ", ".join(f"{k} {v}" for k, v in c.items() if k not in ("before", "kept"))
            print(f"  {s:28} {c['before']:>6} {c.get('kept', 0):>6}   {moved}")


if __name__ == "__main__":
    main()
