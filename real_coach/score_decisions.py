#!/usr/bin/env python3
"""score_decisions.py — nightly outcome scorer for the decision ledger (cron 17:45 ET).

For every ledger row with a matured horizon (T+1/7/30 calendar days) and no score
yet: reprice the symbol (yfinance stocks / CoinGecko-alias crypto via yfinance),
store pnl_pct vs price_at, and judge verdict_right:
  TRIM / EXIT / EXIT_ON_BOUNCE right  → price did NOT rise >+5% after the call
  HOLD / ADD right                    → price did NOT fall <−5% after the call
Symmetric ±5% dead-band = "no harm" counts for the verdict. Feeds scoreboard.py
(rules vs gut) and decision_qae.py (weekly quantum validation). Never raises.
"""
from __future__ import annotations

import sqlite3
import sys
import traceback
from datetime import datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
from real_coach import symbols as symmod  # noqa: E402

DB = Path.home() / "portfolio" / "mike.sqlite"
HORIZONS = {"T1": 1, "T7": 7, "T30": 30}
BAND = 5.0
BEAR_VERDICTS = ("TRIM", "EXIT", "EXIT_ON_BOUNCE")


def latest_price(sym: str, broker_ac: str) -> float | None:
    try:
        if broker_ac == "crypto":
            d = symmod.cg_prices([sym]).get(sym)
            if d and d.get("usd"):
                return float(d["usd"])
        import yfinance as yf
        t = symmod.ta_symbol(sym, broker_ac)
        h = yf.Ticker(t).history(period="5d", interval="1d")
        if len(h):
            return float(h["Close"].iloc[-1])
    except Exception:
        pass
    return None


def main() -> int:
    try:
        con = sqlite3.connect(str(DB), timeout=30)
        now = datetime.now()
        rows = con.execute(
            "SELECT id, ts, symbol, verdict, price_at,"
            " (SELECT asset_class FROM fills f WHERE f.symbol=decision_ledger.symbol"
            "  ORDER BY f.id DESC LIMIT 1) AS ac"
            " FROM decision_ledger WHERE price_at IS NOT NULL").fetchall()
        px_cache: dict[tuple, float | None] = {}
        scored = 0
        for did, ts, sym, verdict, price_at, ac in rows:
            try:
                t0 = datetime.fromisoformat(str(ts).replace(" ET", "")
                                            .replace("ET", "").strip())
            except Exception:
                continue
            ac = ac or "stock"
            for hz, days in HORIZONS.items():
                if now < t0 + timedelta(days=days):
                    continue
                if con.execute("SELECT 1 FROM decision_outcomes WHERE decision_id=? AND"
                               " horizon=?", (did, hz)).fetchone():
                    continue
                key = (sym, ac)
                if key not in px_cache:
                    px_cache[key] = latest_price(sym, ac)
                px = px_cache[key]
                if not px or not price_at:
                    continue
                pnl = (px / float(price_at) - 1) * 100
                if verdict in BEAR_VERDICTS:
                    right = 1 if pnl <= BAND else 0
                else:
                    right = 1 if pnl >= -BAND else 0
                con.execute("INSERT OR IGNORE INTO decision_outcomes(decision_id, horizon,"
                            " price, pnl_pct, verdict_right, scored_at)"
                            " VALUES(?,?,?,?,?,datetime('now','localtime'))",
                            (did, hz, px, round(pnl, 2), right))
                scored += 1
        con.commit()
        print(f"{datetime.now():%Y-%m-%d %H:%M} scored {scored} decision-horizons "
              f"({len(rows)} ledger rows)")
        return 0
    except Exception:
        print("score_decisions error:\n" + traceback.format_exc())
        return 0


if __name__ == "__main__":
    sys.exit(main())
