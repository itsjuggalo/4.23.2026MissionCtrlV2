#!/usr/bin/env python3
"""
DIX / GEX daily ingester (Tier 2).

squeezemetrics.com publishes a free CSV of daily DIX (dark-index buy %) and
GEX (gamma exposure $). Signal rules:
  - DIX > 0.45 historically bullish; DIX < 0.38 historically bearish
  - GEX < 0 = "negative gamma" regime → reflexive volatility
  - Sudden 1-day moves > 2σ on either get a heads-up
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

SOURCE = "dix_gex"

URL = "https://squeezemetrics.com/monitor/static/DIX.csv"

DIX_BULL = 0.45
DIX_BEAR = 0.38


def main() -> int:
    try:
        text = _lib.http_get(URL, accept="text/csv")
    except Exception as e:
        print(f"[dix] fetch failed: {e}", file=sys.stderr)
        return 1

    reader = csv.DictReader(io.StringIO(text))
    rows = list(reader)
    if not rows:
        print("[dix] no rows", file=sys.stderr)
        return 1

    # Last 60 rows for z-score baseline
    recent = rows[-60:]
    parsed = []
    for r in recent:
        try:
            parsed.append({
                "date": r["date"],
                "price": float(r["price"]),
                "dix": float(r["dix"]),
                "gex": float(r["gex"]),
            })
        except (ValueError, KeyError):
            continue
    if len(parsed) < 5:
        print("[dix] insufficient data", file=sys.stderr)
        return 1

    last = parsed[-1]

    # Insert daily snapshot
    with _lib.get_db() as conn:
        conn.execute("""
            INSERT OR REPLACE INTO alt_dix_gex (ts, dix, gex, spx_close)
            VALUES (?, ?, ?, ?)
        """, (last["date"], last["dix"], last["gex"], last["price"]))
        conn.commit()

    new_count = pushed = 0
    headlines: list[tuple[str, float]] = []

    # Level signals
    if last["dix"] >= DIX_BULL:
        headlines.append((
            f"DIX {last['dix']*100:.1f}% — bullish dark-pool buying (>= 45%)",
            65 + min(15, int((last["dix"] - DIX_BULL) * 200)),
        ))
    elif last["dix"] <= DIX_BEAR:
        headlines.append((
            f"DIX {last['dix']*100:.1f}% — bearish dark-pool selling (<= 38%)",
            65 + min(15, int((DIX_BEAR - last["dix"]) * 200)),
        ))

    if last["gex"] < 0:
        headlines.append((
            f"GEX ${last['gex']/1e9:+.2f}B — negative gamma (reflexive vol risk)",
            75 + min(15, int(abs(last["gex"]) / 1e9 * 2)),
        ))

    # 1-day delta z-score
    if len(parsed) >= 20:
        dix_vals = [p["dix"] for p in parsed[:-1]]
        gex_vals = [p["gex"] for p in parsed[:-1]]
        dix_z = (last["dix"] - statistics.mean(dix_vals)) / (statistics.pstdev(dix_vals) or 1)
        gex_z = (last["gex"] - statistics.mean(gex_vals)) / (statistics.pstdev(gex_vals) or 1)
        if abs(dix_z) >= 2:
            headlines.append((
                f"DIX 1-day move {dix_z:+.1f}σ ({last['dix']*100:.1f}%)",
                70.0,
            ))
        if abs(gex_z) >= 2:
            headlines.append((
                f"GEX 1-day move {gex_z:+.1f}σ (${last['gex']/1e9:+.2f}B)",
                70.0,
            ))

    for headline, score in headlines:
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol="SPX",
            direction=None,
            headline=headline,
            url="https://squeezemetrics.com/monitor/dix",
            raw=last,
            quality_score=score,
            dedup_key=f"{last['date']}|{headline[:30]}",
        )
        if is_new:
            new_count += 1
            if _lib.push_if_top(sig_id, source=SOURCE, symbol="SPX",
                                headline=headline, quality_score=score):
                pushed += 1

    _lib.log_event(SOURCE, "tick", {
        "date": last["date"], "dix": last["dix"], "gex": last["gex"],
        "new": new_count, "pushed": pushed,
    })
    print(f"[dix] date={last['date']} dix={last['dix']:.3f} "
          f"gex={last['gex']/1e9:+.2f}B new={new_count} pushed={pushed}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
