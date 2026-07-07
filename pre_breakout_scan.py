#!/usr/bin/env python3
"""pre_breakout_scan.py — find stocks in ACCUMULATION *before* the move (real_coach P4).

Mike's ask: "find different stocks BEFORE they make even 30%." breakout_scanner.py
fires DURING the breakout; this fires BEFORE it — the Wyckoff accumulation read
ported from missionctrl verdictEngine.ts accumulation() (OBV slope + up/down volume
ratio over 21 sessions) plus base-tightness, proximity-under-pivot, and RS vs SPY.

Filter (all must hold, score ranks):
  • not broken out yet: close < 20d pivot high, but within 10% of it
  • base tight: 20d range / price ≤ 15%
  • accumulation: OBV(last) > OBV(mid) AND up/down volume ratio ≥ 1.3
  • relative strength: 20d return ≥ SPY's
Universe: sp500.txt + cc_watchlist + held stocks. Bars: Alpaca IEX (free, batched,
pattern from ~/scripts/breakout_scanner.py).

HONESTY RAIL: every emitted candidate lands in mike.sqlite scan_history and gets
graded at T+20/T+60 trading days (max forward return; did it hit +30% before −15%?).
--grade runs the grading pass; --backtest replays the filter monthly over ~2y and
prints the hit-rate vs the universe base rate — the screener earns trust with
receipts or gets tuned.

Usage:
  pre_breakout_scan.py [--send] [--top 8]     # scan + record (+ Telegram)
  pre_breakout_scan.py --grade                # grade matured scan_history rows
  pre_breakout_scan.py --backtest             # 2y monthly walk-forward report
Advisory only, read-only, never trades. Cron: 17:30 ET weekdays (--grade then scan).
"""
from __future__ import annotations

import argparse
import json
import sqlite3
import subprocess
import sys
import urllib.request
from datetime import datetime, timedelta, timezone
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
UNIVERSE = Path.home() / ".openclaw" / "data" / "sp500.txt"
WATCH = Path.home() / "portfolio" / "cc_watchlist.txt"
BOOK = Path.home() / "portfolio" / "unified_book.json"
DB = Path.home() / "portfolio" / "mike.sqlite"
OUT_JSON = Path.home() / "portfolio" / "pre_breakout.json"
DATA_BASE = "https://data.alpaca.markets/v2/stocks/bars"
TG = Path.home() / "bin" / "tg-send-msg"

# v3 parameters — WON the 2026-07-07 walk-forward sweep: 31.8% of picks hit +30%
# before −15% within 60 trading days vs 13.4% universe base (+18.4 pts edge over
# 12 monthly checkpoints). Key insight: +30% movers need VOLATILITY — a vol FLOOR
# (20d range ≥ 18% of price) beats the classic tight-base cap (v1 was −8.1 pts).
# Caveat: one bullish year, overlapping windows — live grading keeps the receipts.
MAX_PIVOT_DIST = 0.15     # within 15% under the 20d high
MIN_VOL20 = 0.18          # 20d range / price FLOOR (volatility gate)
MAX_BASE_RANGE = 0.80     # sanity ceiling only
MIN_UD_RATIO = 1.2
MIN_PRICE = 3.0


def _secret(name: str) -> str:
    return (SEC / name).read_text().strip()


def _http_json(url: str, headers: dict, timeout: int = 30):
    req = urllib.request.Request(url, headers=headers)
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read().decode())


def universe() -> list[str]:
    syms: list[str] = []
    if UNIVERSE.exists():
        syms += [s.strip().upper() for s in UNIVERSE.read_text().splitlines() if s.strip()]
    if WATCH.exists():
        syms += [s.strip().upper() for s in WATCH.read_text().splitlines() if s.strip()]
    try:
        book = json.loads(BOOK.read_text())
        syms += [p["symbol"].upper() for p in book.get("positions", [])
                 if p.get("asset_class") == "stock" and (p.get("mkt_value") or 0) >= 25]
    except Exception:
        pass
    seen, out = set(), []
    for s in syms:
        if s not in seen and s.replace(".", "").isalnum():
            seen.add(s)
            out.append(s)
    return out


def fetch_bars(symbols: list[str], days: int = 380) -> dict[str, list[dict]]:
    """Batched Alpaca IEX daily bars (breakout_scanner pattern, bisect on bad symbol)."""
    hdr = {"APCA-API-KEY-ID": _secret("alpaca-key-id"),
           "APCA-API-SECRET-KEY": _secret("alpaca-secret")}
    start = (datetime.now(timezone.utc) - timedelta(days=days)).strftime("%Y-%m-%d")
    out: dict[str, list[dict]] = {}

    def fetch_chunk(chunk: list[str]) -> bool:
        page = None
        while True:
            qs = (f"?symbols={','.join(chunk)}&timeframe=1Day&start={start}"
                  f"&limit=10000&adjustment=all&feed=iex")
            if page:
                qs += f"&page_token={page}"
            try:
                d = _http_json(DATA_BASE + qs, hdr)
            except Exception as e:
                if len(chunk) == 1:
                    print(f"drop {chunk[0]}: {e}", file=sys.stderr)
                    return True
                return False
            for sym, bl in (d.get("bars") or {}).items():
                out.setdefault(sym, []).extend(bl)
            page = d.get("next_page_token")
            if not page:
                return True

    def rec(chunk: list[str]):
        if not fetch_chunk(chunk):
            mid = len(chunk) // 2
            rec(chunk[:mid])
            rec(chunk[mid:])

    import time
    CHUNK = 100
    for i in range(0, len(symbols), CHUNK):
        rec(symbols[i:i + CHUNK])
        time.sleep(0.4)          # stay under Alpaca free-tier rate limit (429s)
    return out


def accumulation(closes: list[float], vols: list[float]) -> tuple[bool, float]:
    """Port of verdictEngine.ts accumulation(): OBV rising + up/down vol ratio (21 sess)."""
    n = min(len(closes), len(vols))
    if n < 25:
        return False, 0.0
    c, v = closes[n - 21:], vols[n - 21:]
    obv, up, down = 0.0, 0.0, 0.0
    series = [0.0]
    for i in range(1, len(c)):
        if c[i] > c[i - 1]:
            obv += v[i]; up += v[i]
        elif c[i] < c[i - 1]:
            obv -= v[i]; down += v[i]
        series.append(obv)
    return series[-1] > series[len(series) // 2], (up / down if down > 0 else 2.0)


def evaluate(bars: list[dict], spy_ret20: float, asof: int | None = None,
             max_dist: float = MAX_PIVOT_DIST, min_vol20: float = MIN_VOL20,
             max_base: float = MAX_BASE_RANGE, min_ud: float = MIN_UD_RATIO) -> dict | None:
    """Pre-breakout filter on one symbol's bars (to index `asof`).

    v1 (tight-base cap) backtested NEGATIVE edge (5.3% vs 13.4% base): tightness
    anti-selects volatility, and +30% movers NEED volatility. v2 adds a volatility
    FLOOR (20d range / price ≥ min_vol20) instead — see --backtest sweep."""
    b = bars[:asof] if asof else bars
    if len(b) < 60:
        return None
    closes = [x["c"] for x in b]
    vols = [float(x.get("v") or 0) for x in b]
    px = closes[-1]
    if px < MIN_PRICE:
        return None
    hi20 = max(x["h"] for x in b[-20:])
    lo20 = min(x["l"] for x in b[-20:])
    if px >= hi20 or hi20 <= 0:
        return None                                # already broke out
    dist = (hi20 - px) / hi20
    if dist > max_dist:
        return None
    base = (hi20 - lo20) / px
    if base < min_vol20 or base > max_base:
        return None
    obv_rising, ud = accumulation(closes, vols)
    if not obv_rising or ud < min_ud:
        return None
    ret20 = px / closes[-21] - 1 if len(closes) >= 21 else 0
    if ret20 < spy_ret20:
        return None
    score = round(ud * 2 + (max_dist - dist) * 20 + base * 5 + (ret20 - spy_ret20) * 10, 2)
    return {"price": round(px, 2), "pivot": round(hi20, 2), "dist_pct": round(dist * 100, 1),
            "base_pct": round(base * 100, 1), "ud_ratio": round(ud, 2),
            "ret20_pct": round(ret20 * 100, 1), "score": score}


def scan(bars_all: dict, top: int) -> list[dict]:
    spy = bars_all.get("SPY") or []
    spy_ret20 = (spy[-1]["c"] / spy[-21]["c"] - 1) if len(spy) >= 21 else 0.0
    picks = []
    for sym, b in bars_all.items():
        if sym == "SPY":
            continue
        r = evaluate(b, spy_ret20)
        if r:
            r["symbol"] = sym
            picks.append(r)
    picks.sort(key=lambda r: -r["score"])
    return picks[:top]


def record(picks: list[dict]) -> None:
    con = sqlite3.connect(str(DB), timeout=30)
    for p in picks:
        con.execute("INSERT INTO scan_history(scanned_at, symbol, pivot, score, price_at)"
                    " VALUES(datetime('now','localtime'),?,?,?,?)",
                    (p["symbol"], p["pivot"], p["score"], p["price"]))
    con.commit()
    con.close()


def grade(bars_all: dict) -> int:
    """Grade matured scan_history rows: T+20/T+60 max forward return + hit rule."""
    con = sqlite3.connect(str(DB), timeout=30)
    rows = con.execute("SELECT id, scanned_at, symbol, price_at FROM scan_history "
                       "WHERE graded_at IS NULL").fetchall()
    graded = 0
    for rid, at, sym, p0 in rows:
        b = bars_all.get(sym)
        if not b or not p0:
            continue
        try:
            t0 = datetime.fromisoformat(str(at)).date()
        except Exception:
            continue
        idx = next((i for i, x in enumerate(b)
                    if str(x.get("t", ""))[:10] >= str(t0)), None)
        if idx is None:
            continue
        fut = b[idx + 1:]
        if len(fut) < 20:
            continue                                   # not matured yet

        def fwd(nbars):
            win = fut[:nbars]
            mx = max((x["h"] / p0 - 1) * 100 for x in win)
            hit30 = 0
            for x in win:                              # +30% before −15%?
                if (x["l"] / p0 - 1) * 100 <= -15:
                    break
                if (x["h"] / p0 - 1) * 100 >= 30:
                    hit30 = 1
                    break
            return mx, hit30

        m20, _ = fwd(20)
        m60, hit = fwd(min(60, len(fut)))
        con.execute("UPDATE scan_history SET fwd_max_ret_t20=?, fwd_max_ret_t60=?,"
                    " hit30_before_neg15=?, graded_at=datetime('now','localtime')"
                    " WHERE id=?", (round(m20, 1), round(m60, 1), hit, rid))
        graded += 1
    con.commit()
    con.close()
    return graded


VARIANTS = {
    # name: (max_dist, min_vol20, max_base, min_ud)
    "v1-tight-base": (0.10, 0.00, 0.15, 1.3),
    "v2-vol-floor": (0.10, 0.12, 0.60, 1.3),
    "v3-vol-floor-hi": (0.15, 0.18, 0.80, 1.2),
    "v4-accum-only": (0.15, 0.00, 9.99, 1.5),
}


def backtest(bars_all: dict, top: int) -> None:
    """Monthly walk-forward: each VARIANT's hit-rate vs the universe base rate."""
    spy = bars_all.get("SPY") or []
    if len(spy) < 120:
        print("not enough SPY history for backtest")
        return
    n = len(spy)
    checkpoints = list(range(80, n - 61, 21))          # ~monthly, leave 60 fwd bars
    stats = {k: [0, 0] for k in VARIANTS}              # name -> [wins, total]
    base_total = base_wins = 0
    for cp in checkpoints:
        spy_ret20 = spy[cp - 1]["c"] / spy[cp - 21]["c"] - 1
        for sym, b in bars_all.items():
            if sym == "SPY" or len(b) < cp + 61:
                continue
            p0 = b[cp - 1]["c"]
            fut = b[cp:cp + 60]
            hit = 0
            for x in fut:
                if (x["l"] / p0 - 1) * 100 <= -15:
                    break
                if (x["h"] / p0 - 1) * 100 >= 30:
                    hit = 1
                    break
            base_total += 1
            base_wins += hit
            for name, (md, mv, mb, mu) in VARIANTS.items():
                if evaluate(b, spy_ret20, asof=cp, max_dist=md, min_vol20=mv,
                            max_base=mb, min_ud=mu):
                    stats[name][0] += hit
                    stats[name][1] += 1
    base_rate = 100 * base_wins / max(base_total, 1)
    print(f"BACKTEST ({len(checkpoints)} monthly checkpoints, T+60, +30% before −15%)")
    print(f"  universe base rate: {base_wins}/{base_total} = {base_rate:.1f}%")
    for name, (w, t) in stats.items():
        if t:
            hr = 100 * w / t
            print(f"  {name}: {w}/{t} = {hr:.1f}%  (edge {hr - base_rate:+.1f} pts)")
        else:
            print(f"  {name}: zero picks")


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--top", type=int, default=8)
    ap.add_argument("--grade", action="store_true")
    ap.add_argument("--backtest", action="store_true")
    a = ap.parse_args()
    syms = universe()
    if "SPY" not in syms:
        syms.insert(0, "SPY")     # RS benchmark — sp500.txt holds constituents only
    print(f"universe: {len(syms)} symbols")
    bars_all = fetch_bars(syms, days=560 if a.backtest else 380)
    print(f"bars for {len(bars_all)}")
    if a.grade:
        print(f"graded {grade(bars_all)} matured scan rows")
        return 0
    if a.backtest:
        backtest(bars_all, a.top)
        return 0
    picks = scan(bars_all, a.top)
    OUT_JSON.write_text(json.dumps(
        {"at": datetime.now().isoformat(timespec="seconds"), "picks": picks}, indent=1))
    if not picks:
        print("no accumulation candidates today (filter is strict on purpose)")
        return 0
    record(picks)
    lines = ["🕵️ ACCUMULATION WATCH — names coiling UNDER the pivot (pre-breakout)"]
    for p in picks:
        lines.append(f"• {p['symbol']} ${p['price']} — {p['dist_pct']}% under pivot "
                     f"${p['pivot']}, base {p['base_pct']}%, u/d vol {p['ud_ratio']}× "
                     f"(score {p['score']})")
    lines.append("entry = pivot break with volume, stop = base low. Graded T+20/T+60 — "
                 "receipts in the Sunday scoreboard.")
    msg = "\n".join(lines)
    print(msg)
    if a.send:
        subprocess.run([str(TG), msg], timeout=20, check=False)
    return 0


if __name__ == "__main__":
    sys.exit(main())
