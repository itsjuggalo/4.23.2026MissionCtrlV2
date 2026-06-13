#!/usr/bin/env python3
"""breakout_scanner.py — large-cap breakout + rising-volume scanner.

Deterministic (no LLM, free, fast). Scans the S&P 500 (tradeable large-cap proxy
for "Fortune 500") via Alpaca daily bars and flags names that are:
  - breaking out: today's close > prior-20-session high
  - on rising volume: RVOL = today vol / 20-session avg vol >= threshold (1.5)
  - in an uptrend: close > 50-day SMA  (filters dead-cat pops)
Bonus tags: NEAR-52W-HIGH (within 3%) and 🟢FLOW if the name also has live
options flow in desk_pipeline.sqlite (Mike's edge — breakout + flow = conviction).

Output: JSON {generated_at, count, hits:[...]} to stdout, sorted by RVOL desc.
Best-effort: missing key / network / thin data → symbol skipped, never crashes.

Env:
  BREAKOUT_RVOL   min RVOL (default 1.5)
  BREAKOUT_TOPN   max hits returned (default 12)
  BREAKOUT_UNIVERSE  path to symbol list (default ~/.openclaw/data/sp500.txt)
"""
from __future__ import annotations
import json, os, sys, time, urllib.request, urllib.error, sqlite3
from datetime import datetime, timezone, timedelta
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
UNIVERSE = Path(os.environ.get("BREAKOUT_UNIVERSE", str(Path.home()/".openclaw/data/sp500.txt")))
FLOW_DB = Path.home() / "LapClaw/pipeline/desk_pipeline.sqlite"
MIN_RVOL = float(os.environ.get("BREAKOUT_RVOL", "1.5"))
TOPN = int(os.environ.get("BREAKOUT_TOPN", "12"))
DATA_BASE = "https://data.alpaca.markets/v2/stocks/bars"


def _secret(*names: str) -> str | None:
    for n in names:
        p = SEC / n
        if p.exists():
            return p.read_text(encoding="utf-8").strip()
    return None


def _http_json(url: str, headers: dict, timeout: int = 30):
    req = urllib.request.Request(url, headers=headers)
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read().decode("utf-8"))


def load_universe() -> list[str]:
    if not UNIVERSE.exists():
        print(f"[scanner] universe file missing: {UNIVERSE}", file=sys.stderr)
        return []
    # Alpaca data API wants class shares dotted (BRK.B, BF.B) — keep CSV format as-is.
    syms = [s.strip().upper() for s in UNIVERSE.read_text().splitlines() if s.strip()]
    return [s for s in syms if s.replace(".", "").isalnum()]


def fetch_bars(symbols: list[str], key: str, sec: str) -> dict[str, list[dict]]:
    """Batch daily bars for ~1y. Returns {symbol: [bars oldest→newest]}."""
    hdr = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
    start = (datetime.now(timezone.utc) - timedelta(days=380)).strftime("%Y-%m-%d")
    out: dict[str, list[dict]] = {}

    def fetch_chunk(chunk: list[str], feed: str) -> bool:
        """Fetch one symbol batch (paginated). Returns False on HTTP error so the
        caller can bisect — a single malformed symbol 400s the whole batch."""
        page_token = None
        while True:
            qs = (f"?symbols={','.join(chunk)}&timeframe=1Day&start={start}"
                  f"&limit=10000&adjustment=all&feed={feed}")
            if page_token:
                qs += f"&page_token={page_token}"
            try:
                d = _http_json(DATA_BASE + qs, hdr)
            except Exception as e:
                if len(chunk) == 1:
                    print(f"[scanner] drop {chunk[0]} (feed={feed}): {e}", file=sys.stderr)
                    return True   # give up on this single symbol, don't bisect further
                return False
            for sym, blist in (d.get("bars") or {}).items():
                out.setdefault(sym, []).extend(blist)
            page_token = d.get("next_page_token")
            if not page_token:
                return True

    def fetch_recursive(chunk: list[str], feed: str):
        if not fetch_chunk(chunk, feed):     # batch failed → bisect to isolate bad symbol
            mid = len(chunk) // 2
            fetch_recursive(chunk[:mid], feed)
            fetch_recursive(chunk[mid:], feed)

    CHUNK = 100
    feed = "iex"   # free plan; flip to sip via probe below if iex returns nothing
    # quick feed probe on first symbol
    probe = symbols[:1]
    if not fetch_chunk(probe, "iex"):
        feed = "sip"
    for i in range(1 if out else 0, len(symbols), CHUNK):
        fetch_recursive(symbols[i:i+CHUNK], feed)
        time.sleep(0.15)   # gentle on rate limit
    return out


def flow_tickers() -> set[str]:
    """Tickers with options flow in the last 3 days (Mike's edge overlay)."""
    if not FLOW_DB.exists():
        return set()
    try:
        con = sqlite3.connect(f"file:{FLOW_DB}?mode=ro", uri=True)
        cutoff = (datetime.now(timezone.utc) - timedelta(days=3)).isoformat()
        rows = con.execute(
            "SELECT DISTINCT UPPER(COALESCE(ticker,symbol)) FROM flow_candidates "
            "WHERE created_at >= ?", (cutoff,)).fetchall()
        con.close()
        return {r[0] for r in rows if r[0]}
    except Exception as e:
        print(f"[scanner] flow lookup skipped: {e}", file=sys.stderr)
        return set()


def analyze(sym: str, bars: list[dict], flows: set[str], mode: str) -> dict | None:
    """mode: 'breakout' (up + rising vol + uptrend) or 'breakdown' (down + rising
    vol + downtrend). Both REQUIRE the volume surge — a move on no volume is noise."""
    if len(bars) < 55:
        return None
    closes = [b["c"] for b in bars]
    highs  = [b["h"] for b in bars]
    lows   = [b["l"] for b in bars]
    vols   = [b["v"] for b in bars]
    last_c, last_v = closes[-1], vols[-1]
    if last_c < 5:
        return None
    avg_v20 = sum(vols[-21:-1]) / 20.0
    sma50   = sum(closes[-50:]) / 50.0
    if avg_v20 <= 0:
        return None
    rvol = last_v / avg_v20
    if rvol < MIN_RVOL:
        return None
    high_52 = max(highs[-252:]) if len(highs) >= 252 else max(highs)
    low_52  = min(lows[-252:]) if len(lows) >= 252 else min(lows)

    if mode == "breakout":
        high_20 = max(highs[-21:-1])           # prior 20 sessions, excl today
        if not (last_c > high_20 and last_c > sma50):
            return None
        near_ath = last_c >= high_52 * 0.97
        return {
            "symbol": sym, "direction": "breakout",
            "close": round(last_c, 2),
            "pct_vs_level": round((last_c / high_20 - 1) * 100, 1),   # above 20d high
            "rvol": round(rvol, 1),
            "extreme_52w": near_ath, "extreme_label": "ATH" if near_ath else "",
            "vs_50dma_pct": round((last_c / sma50 - 1) * 100, 1),
            "has_flow": sym in flows,
            "score": round(rvol * (1.25 if sym in flows else 1.0) * (1.15 if near_ath else 1.0), 2),
        }
    else:  # breakdown
        low_20 = min(lows[-21:-1])
        if not (last_c < low_20 and last_c < sma50):
            return None
        near_low = last_c <= low_52 * 1.03
        return {
            "symbol": sym, "direction": "breakdown",
            "close": round(last_c, 2),
            "pct_vs_level": round((last_c / low_20 - 1) * 100, 1),     # below 20d low (neg)
            "rvol": round(rvol, 1),
            "extreme_52w": near_low, "extreme_label": "52W-LOW" if near_low else "",
            "vs_50dma_pct": round((last_c / sma50 - 1) * 100, 1),
            "has_flow": sym in flows,
            "score": round(rvol * (1.25 if sym in flows else 1.0) * (1.15 if near_low else 1.0), 2),
        }


def main():
    key, sec = _secret("alpaca-boba-key-id"), _secret("alpaca-boba-secret")
    if not key or not sec:
        print(json.dumps({"error": "no alpaca data keys", "hits": []}))
        return
    universe = load_universe()
    if not universe:
        print(json.dumps({"error": "empty universe", "hits": []}))
        return
    flows = flow_tickers()
    bars = fetch_bars(universe, key, sec)
    mode = os.environ.get("SCAN_MODE", "breakout")     # breakout | breakdown | both
    modes = ["breakout", "breakdown"] if mode == "both" else [mode]
    result = {
        "generated_at": datetime.now(timezone.utc).isoformat(timespec="seconds"),
        "universe": UNIVERSE.name, "scanned": len(bars), "min_rvol": MIN_RVOL,
    }
    for m in modes:
        hits = []
        for sym, blist in bars.items():
            try:
                r = analyze(sym, blist, flows, m)
                if r:
                    hits.append(r)
            except Exception as e:
                print(f"[scanner] analyze {sym} ({m}) fail: {e}", file=sys.stderr)
        hits.sort(key=lambda h: h["score"], reverse=True)
        result[f"{m}_count"] = len(hits)
        result[f"{m}s"] = hits[:TOPN]
    # back-com?compat: keep flat hits/count = breakouts for any existing reader
    if "breakout" in modes:
        result["count"] = result.get("breakout_count", 0)
        result["hits"] = result.get("breakouts", [])
    print(json.dumps(result, indent=2))


if __name__ == "__main__":
    main()
