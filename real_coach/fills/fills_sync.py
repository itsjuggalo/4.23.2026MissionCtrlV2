#!/usr/bin/env python3
"""fills_sync.py — orchestrate the four fills pullers into ~/portfolio/mike.sqlite.

Usage:
  fills_sync.py --backfill                 # full history, all sources
  fills_sync.py --incremental             # newest-first, stop at known rows (cron)
  fills_sync.py --source rh_crypto        # one source (rh_crypto|rh_stock|rh_option|coinbase)
  fills_sync.py --stats                   # row counts per source

Read-only against brokers; idempotent inserts. Prints new-fill summaries (the P2
after-trade interview hook consumes these). Cron-safe: per-source failures are
isolated, exit 0 always.
"""
from __future__ import annotations

import argparse
import sys
import traceback
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent.parent))  # scripts/

from real_coach.fills import db  # noqa: E402


def stats(con) -> None:
    print("fills by source:")
    for row in con.execute(
            "SELECT broker, asset_class, COUNT(*), MIN(filled_at), MAX(filled_at) "
            "FROM fills GROUP BY broker, asset_class ORDER BY 1,2"):
        print(f"  {row[0]:10} {row[1]:7} {row[2]:6} rows  {str(row[3])[:10]} → {str(row[4])[:10]}")
    tot = con.execute("SELECT COUNT(*) FROM fills").fetchone()[0]
    print(f"  total: {tot}")


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--backfill", action="store_true")
    ap.add_argument("--incremental", action="store_true")
    ap.add_argument("--source", default="all")
    ap.add_argument("--stats", action="store_true")
    a = ap.parse_args()

    con = db.connect()
    if a.stats:
        stats(con)
        return 0
    full = a.backfill

    sources = {}
    from real_coach.fills import rh_crypto, rh_stock, rh_option, coinbase
    sources = {"rh_crypto": rh_crypto.sync, "rh_stock": rh_stock.sync,
               "rh_option": rh_option.sync, "coinbase": coinbase.sync}
    run = sources if a.source == "all" else {a.source: sources[a.source]}

    total_new = 0
    for name, fn in run.items():
        try:
            n = fn(con, full=full)
            total_new += n
            print(f"{name}: +{n} new fills")
        except Exception:
            print(f"{name}: FAILED\n" + traceback.format_exc())
    if total_new:
        new_lines = []
        for row in con.execute(
                "SELECT broker, asset_class, symbol, side, qty, price, filled_at "
                "FROM fills WHERE synthetic=0 ORDER BY id DESC LIMIT ?",
                (min(total_new, 5),)):
            line = "|".join(str(x) for x in row)
            new_lines.append(line)
            print("NEW_FILL", line)
        # after-trade interview (P2): 3 quick TG buttons + a deep-dive capsule.
        # Backfills don't interview (that's history, not a fresh decision).
        if not full and new_lines:
            try:
                sys.path.insert(0, str(Path.home() / "05_AUTOMATION" / "profile"))
                import after_trade
                after_trade.run(new_lines)
            except Exception:
                print("after_trade hook failed:\n" + traceback.format_exc())
    stats(con)
    return 0


if __name__ == "__main__":
    sys.exit(main())
