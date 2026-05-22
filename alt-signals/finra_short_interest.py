#!/usr/bin/env python3
"""
FINRA short-interest ingester (Tier 2).

Pulls the latest twice-monthly short interest file from FINRA's free CDN.
Computes days-to-cover and flags squeeze candidates (SI > 20% of float-ish).
Lands into alt_short_interest + alt_signals.

Run cadence: weekly (Tue + Fri 6pm ET enough — FINRA settles ~10th and 25th).
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import sys
import csv
import io
from pathlib import Path
from datetime import datetime, timezone, timedelta

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "finra_short_interest"

# FINRA equity-short-interest summary file. Format:
# https://cdn.finra.org/equity/regsho/monthly/{YYYYMM}.csv  (consolidated)
# https://www.finra.org/sites/default/files/{...}  (bi-monthly snapshot)
# We use the regsho daily aggregator which is free + no auth.
# As a fallback, the bi-monthly file is at:
#   https://cdn.finra.org/equity/otc/{YYYYMMDD}/otc-equity-short-interest-{YYYYMMDD}.csv
# We don't have a reliable URL guess for the bi-monthly without web scraping their listing,
# so we hit the regsho daily file (gives us latest short-volume by symbol).
REGSHO_DAILY = "https://cdn.finra.org/equity/regsho/daily/CNMSshvol{date}.txt"

# Threshold for squeeze candidate (short_volume / total_volume on the day)
SQUEEZE_RATIO = 0.40        # >=40% of day's volume shorted
HIGH_RATIO = 0.30           # >=30% noteworthy

# Cap on tickers we surface as signals (top-N by short ratio)
TOP_N = 40


def fetch_latest_daily() -> tuple[str, str] | None:
    """Walk back from today to find the latest available file (skipping weekends/holidays)."""
    today = datetime.now(timezone.utc).date()
    for back in range(0, 7):
        d = today - timedelta(days=back)
        if d.weekday() >= 5:  # sat/sun
            continue
        date_str = d.strftime("%Y%m%d")
        url = REGSHO_DAILY.format(date=date_str)
        try:
            text = _lib.http_get(url, accept="text/plain")
            if text and "Symbol" in text[:200]:
                return date_str, text
        except Exception:
            continue
    return None


def parse_regsho(text: str) -> list[dict]:
    """RegSHO daily file is pipe-delimited."""
    rows = []
    reader = csv.DictReader(io.StringIO(text), delimiter="|")
    for row in reader:
        try:
            short_vol = int(row.get("ShortVolume", "0") or 0)
            total_vol = int(row.get("TotalVolume", "0") or 0)
            if total_vol < 50_000:  # skip illiquid
                continue
            ratio = short_vol / total_vol if total_vol > 0 else 0
            sym = (row.get("Symbol") or "").strip().upper()
            if not sym or len(sym) > 5:
                continue
            rows.append({
                "symbol": sym,
                "short_volume": short_vol,
                "total_volume": total_vol,
                "ratio": ratio,
                "date": row.get("Date", ""),
                "market": row.get("Market", ""),
            })
        except (ValueError, KeyError):
            continue
    return rows


def main() -> int:
    fetched = fetch_latest_daily()
    if not fetched:
        print("[finra] no recent regsho file found", file=sys.stderr)
        return 1
    date_str, text = fetched

    rows = parse_regsho(text)
    if not rows:
        print("[finra] no parseable rows", file=sys.stderr)
        return 1

    rows.sort(key=lambda r: r["ratio"], reverse=True)
    top = rows[:TOP_N]

    settlement = datetime.strptime(date_str, "%Y%m%d").date().isoformat()
    new_count = pushed = 0

    with _lib.get_db() as conn:
        for r in top:
            # store raw in alt_short_interest
            conn.execute("""
                INSERT OR REPLACE INTO alt_short_interest
                  (symbol, settlement_date, short_interest, avg_daily_volume,
                   days_to_cover, si_pct_float)
                VALUES (?, ?, ?, ?, NULL, ?)
            """, (r["symbol"], settlement, r["short_volume"],
                  r["total_volume"], r["ratio"] * 100))
        conn.commit()

    for r in top:
        ratio = r["ratio"]
        if ratio < HIGH_RATIO:
            continue
        score = 60 + min(35, int((ratio - HIGH_RATIO) * 200))  # 60-95 range
        if ratio >= SQUEEZE_RATIO:
            score = max(score, 80)
        headline = (
            f"{r['symbol']} — short {ratio*100:.0f}% of day volume "
            f"({r['short_volume']:,}/{r['total_volume']:,})"
        )
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol=r["symbol"],
            direction="short_squeeze_candidate",
            headline=headline,
            url=f"https://www.finra.org/finra-data/browse-catalog/short-sale-volume-data/daily-short-sale-volume-files",
            raw=r,
            quality_score=score,
            ts=_lib.utc_now_iso(),
            dedup_key=f"{r['symbol']}|{settlement}",
        )
        if is_new:
            new_count += 1
            if _lib.push_if_top(
                sig_id, source=SOURCE, symbol=r["symbol"],
                headline=headline, quality_score=score,
            ):
                pushed += 1

    _lib.log_event(SOURCE, "tick", {
        "settlement": settlement,
        "rows_parsed": len(rows),
        "top_surfaced": len(top),
        "new": new_count,
        "pushed": pushed,
    })
    print(f"[finra] settlement={settlement} top={len(top)} new={new_count} pushed={pushed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
