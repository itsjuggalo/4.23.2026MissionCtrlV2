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
import json, os, re, sys, time, urllib.request, urllib.error, sqlite3
from datetime import datetime, timezone, timedelta
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
UNIVERSE = Path(os.environ.get("BREAKOUT_UNIVERSE", str(Path.home()/".openclaw/data/sp500.txt")))
FLOW_DB = Path(os.environ.get("MC_SIGNAL_TRACKER_DB") or Path.home() / "02_DATA/signal-tracker/tracker.sqlite")
# Raw vendor flow feeds in the signal tracker (relay = Firebase/FlowGreeks streams, scraper = option-scraper files,
# uw_feed = Unusual Whales Discord). Our own picks/debates/momentum alerts are not flow and stay out.
FLOW_FEEDS = ("relay:", "scraper:", "uw_feed:")
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
    FEED_USED[0] = feed
    return out


FEED_USED = ["iex"]
FLOW_STATUS: dict = {"source": "signal tracker (vendor flow alerts: UW, FlowGreeks, Firebase relay)", "newest": None, "stale": True}


def flow_tickers() -> dict[str, set[str]]:
    """Tickers with options flow in the last 3 days -> the flow directions seen (Mike's edge overlay).
    W8 MC-AUD-013: the direction is kept so a bearish print on a breakout is never shown as green confluence,
    and the overlay's own freshness is reported (FLOW_STATUS). Source (2026-10-22): the signal tracker's vendor
    flow alerts; the old desk_pipeline flow_candidates table stopped at 2026-06-09 (retired, DATA_SOURCES §7).
    Direction = the contract side: call -> BULLISH, put -> BEARISH."""
    if not FLOW_DB.exists():
        return {}
    try:
        con = sqlite3.connect(f"file:{FLOW_DB}?mode=ro", uri=True)
        cutoff = (datetime.now(timezone.utc) - timedelta(days=3)).timestamp()
        feed_sql = " OR ".join("feed LIKE ?" for _ in FLOW_FEEDS)
        feeds = [f + "%" for f in FLOW_FEEDS]
        rows = con.execute(f"SELECT occ FROM signals WHERE alert_at >= ? AND ({feed_sql})", (cutoff, *feeds)).fetchall()
        newest = con.execute(f"SELECT MAX(alert_at) FROM signals WHERE {feed_sql}", feeds).fetchone()[0]
        con.close()
        from zoneinfo import ZoneInfo
        FLOW_STATUS.update(newest=(datetime.fromtimestamp(newest, ZoneInfo("America/New_York")).strftime("%Y-%m-%d %H:%M ET")
                                   if newest else None), stale=not newest or newest < cutoff)
        out: dict[str, set[str]] = {}
        for (occ,) in rows:
            m = re.match(r"^([A-Z.]+?)\d{6}([CP])\d{8}$", str(occ or "").upper())
            if m:
                out.setdefault(m.group(1), set()).add("BULLISH" if m.group(2) == "C" else "BEARISH")
        return out
    except Exception as e:
        print(f"[scanner] flow lookup skipped: {e}", file=sys.stderr)
        return {}


def flow_tag(dirs: set[str] | None, mode: str) -> str:
    """'aligned' only when every flow print points the move's way; mixed/adverse/unknown are labelled as such."""
    if not dirs:
        return ""
    want = "BULLISH" if mode == "breakout" else "BEARISH"
    if dirs == {want}:
        return "aligned"
    if want in dirs:
        return "mixed"
    return "adverse" if dirs & {"BULLISH", "BEARISH"} else "unknown"


def bar_meta(bars: list[dict], feed: str, now: datetime | None = None) -> dict:
    """W8 MC-AUD-013: what the last bar is — its own date, whether today's session is still open (partial volume
    vs full-day averages) and whether it is an old EOD bar. Uses the MissionCtrl market clock."""
    from zoneinfo import ZoneInfo
    et = ZoneInfo("America/New_York")
    now = (now or datetime.now(timezone.utc)).astimezone(et)
    last = datetime.fromisoformat(str(bars[-1]["t"]).replace("Z", "+00:00")).astimezone(et).date()
    try:
        sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline")
        from market_clock import clock as _clock
        today_open = _clock.is_trading_day(now.date()) and now >= _clock.session_open(now.date())
        expected = now.date() if today_open else _clock.previous_trading_day(now.date())
        partial = today_open and now < _clock.session_close(now.date()) and last == now.date()
    except Exception:  # noqa: BLE001 — calendar unavailable: say so rather than guess
        return {"bar_date": last.isoformat(), "feed": feed, "session": "UNKNOWN (market clock unavailable)"}
    session = ("PARTIAL (session open — volume so far vs full-day average)" if partial
               else "COMPLETE" if last == expected else f"STALE (last bar {last.isoformat()}, expected {expected.isoformat()})")
    return {"bar_date": last.isoformat(), "feed": feed, "session": session}


def analyze(sym: str, bars: list[dict], flows, mode: str) -> dict | None:
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
        hi_label = "NEAR-52W-HIGH" if len(highs) >= 252 else f"NEAR-{len(highs)}D-HIGH"   # not an all-time high
        return {
            "symbol": sym, "direction": "breakout",
            "close": round(last_c, 2),
            "pct_vs_level": round((last_c / high_20 - 1) * 100, 1),   # above 20d high
            "rvol": round(rvol, 1),
            "extreme_52w": near_ath, "extreme_label": hi_label if near_ath else "",
            "vs_50dma_pct": round((last_c / sma50 - 1) * 100, 1),
            "has_flow": sym in flows, "flow_dir": flow_tag(flows.get(sym), mode),
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
            "extreme_52w": near_low,
            "extreme_label": ("NEAR-52W-LOW" if len(lows) >= 252 else f"NEAR-{len(lows)}D-LOW") if near_low else "",
            "vs_50dma_pct": round((last_c / sma50 - 1) * 100, 1),
            "has_flow": sym in flows, "flow_dir": flow_tag(flows.get(sym), mode),
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
    # W8 MC-AUD-013: provenance travels with the scan — bar date/session, feed, adjustment, flow-overlay freshness
    lasts = sorted((str(b[-1]["t"]), s) for s, b in bars.items() if b)
    meta = bar_meta(bars[lasts[-1][1]], FEED_USED[0]) if lasts else {"session": "UNAVAILABLE (no bars)"}
    result = {
        "bars": {**meta, "adjustment": "split+dividend adjusted (adjustment=all)",
                 "source": f"Alpaca {FEED_USED[0].upper()} daily bars — cross-check only, not Robinhood"},
        "flow_overlay": dict(FLOW_STATUS),
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
