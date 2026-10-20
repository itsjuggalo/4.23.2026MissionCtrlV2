#!/usr/bin/env python3
"""precheck.py — the coach's pre-trade checklist (entry classification only).

R5 (Mike 2026-10-20): no stops, no targets, no sizing, no risk caps. This no longer
computes or requires a stop, never blocks an entry, and returns no risk/R:R figures.
It classifies the symbol (bucket), echoes the entry, and logs the check to
mike.sqlite:pre_trade_checks (a DEDICATED table, kept out of decision_ledger so it never
pollutes the sweep-verdict scorers). Advisory: never places or cancels an order.

CLI:
  precheck.py --symbol TSLA --class stock --side buy --entry 340 [--broker rh] [--json]
Deprecated flags --size/--stop/--target/--thesis/--compute-stop-only are accepted and ignored
(--compute-stop-only prints {"ok": false, "error": ...}).
"""
from __future__ import annotations

import argparse
import json
import sqlite3
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

SCRIPTS = Path(__file__).resolve().parent.parent  # 05_AUTOMATION/scripts
sys.path.insert(0, str(SCRIPTS))

from real_coach import book as bookmod  # noqa: E402
from real_coach import symbols as symmod  # noqa: E402

DB = Path.home() / "portfolio" / "mike.sqlite"
ET = ZoneInfo("America/New_York")


def _et_iso() -> str:
    return datetime.now(ET).strftime("%Y-%m-%dT%H:%M:%S ET")


def connect() -> sqlite3.Connection:
    con = sqlite3.connect(str(DB), timeout=30)
    ensure_table(con)
    return con


def ensure_table(con: sqlite3.Connection) -> None:
    con.execute(
        "CREATE TABLE IF NOT EXISTS pre_trade_checks("
        " id INTEGER PRIMARY KEY, ts TEXT NOT NULL, source TEXT,"
        " symbol TEXT, asset_class TEXT, broker TEXT, bucket TEXT,"
        " side TEXT, size_usd REAL, entry REAL, stop REAL, stop_source TEXT,"
        " computed_stop REAL, target REAL, risk_usd REAL, rr REAL,"
        " verdict TEXT, blocked INTEGER, reasons TEXT)")
    con.commit()


# ── the checklist ──────────────────────────────────────────────────────────────
def precheck(symbol: str, asset_class: str, side: str = "buy",
             size_usd: float | None = None, entry: float | None = None,
             stop: float | None = None, target: float | None = None,
             thesis: str | None = None, broker: str | None = None,
             direction: str | None = None, cfg: dict | None = None) -> dict:
    """size_usd / stop / target / thesis are accepted for call compatibility and ignored (R5)."""
    cfg = cfg or bookmod.load_config()
    symbol = symbol.upper().strip()
    asset_class = (asset_class or "stock").lower()
    side = "sell" if str(side).lower() == "sell" else "buy"
    is_option = asset_class == "option"
    direction = direction or ("short" if side == "sell" and not is_option else "long")
    bucket = bookmod.bucket_of(symbol, "stock" if is_option else asset_class, cfg)
    entry = float(entry) if entry not in (None, "") else None

    checks = [{"name": "Pre-check", "level": "GO",
               "detail": f"{bucket} {symbol} {side} — checklist clear (no stop/target/size checks, R5)."}]
    return {
        "ok": True, "symbol": symbol, "asset_class": asset_class, "bucket": bucket,
        "side": side, "direction": direction, "entry": entry,
        "verdict": "GO", "blocked": False, "checks": checks,
    }


def _fmt(x) -> str:
    if x is None:
        return "?"
    if abs(x) < 1:
        return f"{x:,.4f}"
    return f"{x:,.2f}"


def log_check(result: dict, source: str = "cli", broker: str | None = None) -> int | None:
    try:
        con = connect()
        cur = con.execute(
            "INSERT INTO pre_trade_checks(ts, source, symbol, asset_class, broker, bucket,"
            " side, entry, verdict, blocked, reasons) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
            (_et_iso(), source, result["symbol"], result["asset_class"], broker,
             result["bucket"], result["side"], result["entry"], result["verdict"],
             1 if result["blocked"] else 0,
             json.dumps([f"{c['level']}:{c['name']}" for c in result["checks"]])))
        con.commit()
        rid = cur.lastrowid
        con.close()
        return rid
    except Exception as e:
        print(f"log_check failed: {e}", file=sys.stderr)
        return None


def main() -> int:
    ap = argparse.ArgumentParser(description="coach pre-trade checklist")
    ap.add_argument("--symbol", required=True)
    ap.add_argument("--class", dest="asset_class", default="stock",
                    help="stock | crypto | option")
    ap.add_argument("--side", default="buy")
    ap.add_argument("--size", dest="size_usd", type=float)
    ap.add_argument("--entry", type=float)
    ap.add_argument("--stop", type=float)
    ap.add_argument("--target", type=float)
    ap.add_argument("--direction")
    ap.add_argument("--thesis")
    ap.add_argument("--broker")
    ap.add_argument("--source", default="cli")
    ap.add_argument("--compute-stop-only", action="store_true")
    ap.add_argument("--no-log", action="store_true")
    ap.add_argument("--json", action="store_true")
    a = ap.parse_args()

    if a.compute_stop_only:
        out = {"ok": False, "symbol": a.symbol.upper(),
               "error": "stops are not computed (R5: no stops, targets or risk caps)"}
        print(json.dumps(out) if a.json else out["error"])
        return 0

    r = precheck(a.symbol, a.asset_class, a.side, a.size_usd, a.entry, a.stop,
                 a.target, a.thesis, a.broker, a.direction)
    if not a.no_log:
        r["logged_id"] = log_check(r, a.source, a.broker)

    if a.json:
        print(json.dumps(r))
    else:
        icon = {"GO": "✓", "CAUTION": "⚠", "STOP": "✕"}[r["verdict"]]
        print(f"{icon} {r['verdict']} — {r['bucket']} {r['symbol']} {r['side']}"
              f"{' [BLOCKED]' if r['blocked'] else ''}")
        for c in r["checks"]:
            print(f"   [{c['level']}] {c['name']}: {c['detail']}")
    return 2 if r["blocked"] else 0


if __name__ == "__main__":
    raise SystemExit(main())
