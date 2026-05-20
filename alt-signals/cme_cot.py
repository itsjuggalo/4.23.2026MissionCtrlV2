#!/usr/bin/env python3
"""
CFTC Commitments of Traders weekly ingester (Tier 2).

Pulls TWO reports:
  1. Disaggregated futures-only (`f_disagg.txt`) — commodities: GOLD, OIL.
     Speculative aggregate = money_manager + other_reportables.
  2. Traders in Financial Futures (`FinFutWk.txt`) — financials + crypto:
     ES, NQ, RTY, BTC, ETH, SOL (and Treasuries if wanted later).
     Speculative aggregate = leveraged_money + other_reportables.

Each contract's speculative net positioning is z-scored against a rolling
52-week window persisted in the state file. >|1.5|σ flips fire a signal.

CFTC publishes Friday ~3:30pm ET for Tuesday's settlement.
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import csv
import io
import statistics
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "cme_cot"

# ---- Disaggregated futures-only (commodities) ----
DISAGG_COLS = {
    "market_name": 0,
    "report_date": 2,
    "open_interest": 7,
    # Speculative components
    "spec1_long": 13,   # M_Money_Positions_Long_All
    "spec1_short": 14,
    "spec2_long": 16,   # Other_Rept_Positions_Long_All
    "spec2_short": 17,
}

# ---- Traders in Financial Futures (financials + crypto) ----
TFF_COLS = {
    "market_name": 0,
    "report_date": 2,
    "open_interest": 7,
    # Speculative = Leveraged Money + Other Reportables
    "spec1_long": 14,   # Lev_Money_Positions_Long_All
    "spec1_short": 15,
    "spec2_long": 17,   # Other_Rept_Positions_Long_All
    "spec2_short": 18,
}

REPORTS = [
    {
        "url": "https://www.cftc.gov/dea/newcot/f_disagg.txt",
        "cols": DISAGG_COLS,
        "markets": [
            {"key": "GOLD", "name_part": "GOLD - COMMODITY EXCHANGE"},
            {"key": "OIL",  "name_part": "WTI-PHYSICAL"},
        ],
    },
    {
        "url": "https://www.cftc.gov/dea/newcot/FinFutWk.txt",
        "cols": TFF_COLS,
        "markets": [
            # We anchor on the LARGEST contract for each (E-MINI not MICRO).
            # name_part uses uppercase match.
            {"key": "ES",  "name_part": "E-MINI S&P 500 - CHICAGO MERCANTILE EXCHANGE"},
            {"key": "NQ",  "name_part": "NASDAQ MINI - CHICAGO MERCANTILE EXCHANGE"},
            {"key": "RTY", "name_part": "RUSSELL E-MINI - CHICAGO MERCANTILE EXCHANGE"},
            {"key": "BTC", "name_part": "BITCOIN - CHICAGO MERCANTILE EXCHANGE"},
            {"key": "ETH", "name_part": "ETHER CASH SETTLED - CHICAGO MERCANTILE EXCHANGE"},
            {"key": "SOL", "name_part": "MICRO SOL"},
        ],
    },
]


def parse_csv(text: str) -> list[list[str]]:
    return list(csv.reader(io.StringIO(text)))


def col(row: list[str], cols: dict[str, int], key: str) -> str:
    idx = cols.get(key)
    if idx is None or idx >= len(row):
        return ""
    return row[idx].strip()


def safe_int(v) -> int:
    try:
        return int(str(v).replace(",", "").strip())
    except Exception:
        return 0


def process_report(report: dict, state: dict) -> tuple[int, int, int]:
    """Returns (markets_seen, new_count, pushed)."""
    try:
        text = _lib.http_get(report["url"], accept="text/csv,text/plain")
    except Exception as e:
        print(f"[cot] fetch {report['url']}: {e}", file=sys.stderr)
        return (0, 0, 0)

    rows = parse_csv(text)
    if not rows:
        return (0, 0, 0)

    cols = report["cols"]
    market_rows: dict[str, list[list[str]]] = {}
    for row in rows:
        if not row:
            continue
        name = col(row, cols, "market_name").upper()
        if not name:
            continue
        for m in report["markets"]:
            if m["name_part"].upper() in name:
                market_rows.setdefault(m["key"], []).append(row)
                break

    history = state.setdefault("history", {})
    new_count = pushed = 0

    for m in report["markets"]:
        key = m["key"]
        candidates = market_rows.get(key, [])
        if not candidates:
            continue
        row = candidates[0]
        report_date = col(row, cols, "report_date")

        spec1_long = safe_int(col(row, cols, "spec1_long"))
        spec1_short = safe_int(col(row, cols, "spec1_short"))
        spec2_long = safe_int(col(row, cols, "spec2_long"))
        spec2_short = safe_int(col(row, cols, "spec2_short"))
        oi = safe_int(col(row, cols, "open_interest"))

        noncomm_long = spec1_long + spec2_long
        noncomm_short = spec1_short + spec2_short
        net = noncomm_long - noncomm_short

        # Rolling 52-week history per market
        hist = history.setdefault(key, [])
        if report_date and (not hist or hist[-1]["date"] != report_date):
            hist.append({"date": report_date, "net": net})
            history[key] = hist[-52:]

        nets = [h["net"] for h in hist if isinstance(h.get("net"), (int, float))]
        z = 0.0
        if len(nets) >= 8:
            mu = statistics.mean(nets)
            sd = statistics.pstdev(nets) or 1
            z = (net - mu) / sd

        with _lib.get_db() as conn:
            conn.execute("""
                INSERT OR REPLACE INTO alt_cot_positioning
                  (ts, market, noncomm_long, noncomm_short, noncomm_net,
                   noncomm_net_z, open_interest, week_of)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """, (_lib.utc_now_iso(), key, noncomm_long, noncomm_short, net,
                  z, oi, report_date))
            conn.commit()

        if abs(z) < 1.5:
            continue

        direction = "long_lean" if z > 0 else "short_lean"
        score = 60 + min(35, int(abs(z) * 12))
        headline = (
            f"{key} COT: spec net {net:+,} ({z:+.1f}σ, "
            f"{'added longs' if z > 0 else 'added shorts'}) "
            f"week of {report_date}"
        )
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=key,
            direction=direction,
            headline=headline,
            url="https://www.cftc.gov/MarketReports/CommitmentsofTraders/index.htm",
            raw={
                "report_date": report_date,
                "spec_long": noncomm_long,
                "spec_short": noncomm_short,
                "net": net, "z": z, "open_interest": oi,
            },
            quality_score=float(score),
            ts=_lib.utc_now_iso(),
            dedup_key=f"{key}|{report_date}",
        )
        if is_new:
            new_count += 1
            if _lib.push_if_top(sig_id, source=SOURCE, symbol=key,
                                headline=headline, quality_score=float(score)):
                pushed += 1

    return (len(market_rows), new_count, pushed)


def main() -> int:
    state = _lib.load_state(SOURCE, {"history": {}})
    total_seen = total_new = total_pushed = 0

    for report in REPORTS:
        seen, new, pushed = process_report(report, state)
        total_seen += seen
        total_new += new
        total_pushed += pushed

    _lib.save_state(SOURCE, state)
    _lib.log_event(SOURCE, "tick", {
        "markets_seen": total_seen,
        "new": total_new,
        "pushed": total_pushed,
    })
    print(f"[cot] markets_seen={total_seen} new={total_new} pushed={total_pushed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
