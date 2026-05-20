#!/usr/bin/env python3
"""
VIX term-structure ingester (Tier 2).

Pulls VIX9D, VIX, VIX3M, VIX6M via yfinance (uv-run sub-process — same pattern
as stock-info.py). Flags regime flips:
  - VIX > VIX3M  → backwardation (stress)
  - VIX < VIX9D * 0.85 → vol crush
  - VIX > 28 absolute level

Runs daily after 4:30pm ET.
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import sys
import json
import subprocess
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
import _lib

SOURCE = "vix_term_structure"

SYMBOLS = ["^VIX9D", "^VIX", "^VIX3M", "^VIX6M"]

UV = "/home/itsju/.local/bin/uv"

# Inline uv-run script that yfinance-fetches VIX series and returns JSON
YF_SCRIPT = '''# /// script
# requires-python = ">=3.10"
# dependencies = ["yfinance"]
# ///
import sys, json
import yfinance as yf
out = {}
for sym in sys.argv[1:]:
    try:
        h = yf.Ticker(sym).history(period="2d")
        if not h.empty:
            out[sym] = float(h["Close"].iloc[-1])
    except Exception as e:
        out[sym + "_err"] = str(e)
print(json.dumps(out))
'''

YF_SCRIPT_PATH = _lib.STATE_DIR / "_vix_fetch.py"


def fetch_quotes() -> dict[str, float]:
    # Write the inline script once
    if not YF_SCRIPT_PATH.exists() or YF_SCRIPT_PATH.read_text() != YF_SCRIPT:
        YF_SCRIPT_PATH.write_text(YF_SCRIPT)

    cmd = [UV, "run", "--quiet", str(YF_SCRIPT_PATH), *SYMBOLS]
    proc = subprocess.run(cmd, capture_output=True, text=True, timeout=120)
    if proc.returncode != 0:
        raise RuntimeError(f"uv run failed: {proc.stderr[:500]}")
    data = json.loads(proc.stdout.strip().splitlines()[-1])
    return {k: v for k, v in data.items() if not k.endswith("_err") and isinstance(v, (int, float))}


def classify_regime(vix9d: float, vix: float, vix3m: float) -> tuple[str, float]:
    """Return (regime_label, quality_score)."""
    if vix3m > 0 and vix / vix3m > 1.02:
        ratio = vix / vix3m
        score = 70 + min(20, int((ratio - 1.02) * 500))
        return (f"backwardation ({ratio:.2f}x)", float(score))
    if vix9d > 0 and vix / vix9d < 0.85:
        return ("vol crush (front month deeply below short-vol)", 70.0)
    if vix > 28:
        return (f"elevated VIX ({vix:.1f})", 75.0)
    return ("contango (normal)", 0.0)


def main() -> int:
    try:
        quotes = fetch_quotes()
    except Exception as e:
        print(f"[vix] fetch failed: {e}", file=sys.stderr)
        return 1

    vix9d = quotes.get("^VIX9D", 0.0)
    vix = quotes.get("^VIX", 0.0)
    vix3m = quotes.get("^VIX3M", 0.0)
    vix6m = quotes.get("^VIX6M", 0.0)

    if not (vix > 0 and vix3m > 0):
        print(f"[vix] missing data: {quotes}", file=sys.stderr)
        return 1

    contango_9d_vix = (vix / vix9d) if vix9d > 0 else 0.0
    contango_vix_3m = (vix / vix3m) if vix3m > 0 else 0.0
    regime, score = classify_regime(vix9d, vix, vix3m)

    with _lib.get_db() as conn:
        conn.execute("""
            INSERT OR REPLACE INTO alt_vix_term_structure
              (ts, vix9d, vix, vix3m, vix6m, contango_9d_vix,
               contango_vix_3m, regime)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """, (_lib.utc_now_iso(), vix9d, vix, vix3m, vix6m,
              contango_9d_vix, contango_vix_3m, regime))
        conn.commit()

    new_count = pushed = 0
    if score > 0:
        headline = (
            f"VIX term structure: {regime} — "
            f"VIX9D={vix9d:.1f} VIX={vix:.1f} VIX3M={vix3m:.1f}"
        )
        sig_id, is_new = _lib.upsert_alt_signal(
            source=SOURCE,
            symbol="SPX",
            direction=None,
            headline=headline,
            url="https://www.cboe.com/tradable_products/vix/",
            raw={"vix9d": vix9d, "vix": vix, "vix3m": vix3m, "vix6m": vix6m, "regime": regime},
            quality_score=score,
            dedup_key=f"vix|{_lib.utc_now_iso()[:10]}",
        )
        if is_new:
            new_count += 1
            if _lib.push_if_top(sig_id, source=SOURCE, symbol="SPX",
                                headline=headline, quality_score=score):
                pushed += 1

    _lib.log_event(SOURCE, "tick", {
        "vix": vix, "vix3m": vix3m, "regime": regime,
        "new": new_count, "pushed": pushed,
    })
    print(f"[vix] vix={vix:.2f} vix3m={vix3m:.2f} regime={regime} new={new_count}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
