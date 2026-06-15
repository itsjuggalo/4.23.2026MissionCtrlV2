#!/usr/bin/env python3
"""flow_pick_track_record.py — cumulative edge of the auto-posted flow picks.

Aggregates every ~/.openclaw/state/flow_picks_log_*.jsonl (past, closed days only),
grades each pick by the underlying's move from pick-time spot → that day's close in
the pick's direction, and reports hit-rate + expectancy. This is the paper-proves-then-
live go-live gate (n≥50 + positive expectancy). Read-only. Weekly cron (Fri 4:15 ET).

Run with ~/.venv/bin/python (yfinance).
"""
from __future__ import annotations

import glob
import json
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state"
WIN = 0.3   # % move (in the pick's direction) to count as a win


def _close_on(ticker: str, date_str: str, cache: dict):
    """Daily close for ticker on date_str (YYYY-MM-DD). Cached. None if unavailable."""
    key = (ticker, date_str)
    if key in cache:
        return cache[key]
    val = None
    try:
        import yfinance as yf
        from datetime import datetime as _dt, timedelta
        d = _dt.strptime(date_str, "%Y-%m-%d")
        h = yf.Ticker(ticker).history(start=date_str, end=(d + timedelta(days=4)).strftime("%Y-%m-%d"))
        if len(h):
            val = float(h["Close"].iloc[0])
    except Exception:
        val = None
    cache[key] = val
    return val


def main():
    today = datetime.now(ET).strftime("%Y-%m-%d")
    files = sorted(glob.glob(str(STATE / "flow_picks_log_*.jsonl")))
    picks = []
    for f in files:
        date = f.split("flow_picks_log_")[-1].replace(".jsonl", "")
        if date >= today:        # only fully-closed days
            continue
        for ln in Path(f).read_text().splitlines():
            try:
                r = json.loads(ln)
                r["_date"] = date
                picks.append(r)
            except Exception:
                continue
    if not picks:
        sd.post(sd.resolve_channel("flow-picks"),
                "📈 **FLOW PICK TRACK RECORD** — no closed picks logged yet (need ≥1 prior trading day).")
        print("[track-record] no closed picks", flush=True)
        return

    cache = {}
    graded = []
    for r in picks:
        entry = r.get("spot")
        if not entry:
            continue
        close = _close_on(r["symbol"], r["_date"], cache)
        if not close:
            continue
        move = (close - entry) / entry * 100
        fav = move if r.get("isBullish") else -move   # direction-adjusted
        graded.append((r, fav))
    if not graded:
        print("[track-record] no gradable picks", flush=True)
        return

    n = len(graded)
    wins = [f for _, f in graded if f > WIN]
    losses = [f for _, f in graded if f < -WIN]
    flats = n - len(wins) - len(losses)
    hit = len(wins) / n * 100
    avg_win = sum(wins) / len(wins) if wins else 0
    avg_loss = sum(losses) / len(losses) if losses else 0
    expectancy = sum(f for _, f in graded) / n
    bull = [f for r, f in graded if r.get("isBullish")]
    bear = [f for r, f in graded if not r.get("isBullish")]
    bull_hit = (sum(1 for f in bull if f > WIN) / len(bull) * 100) if bull else 0
    bear_hit = (sum(1 for f in bear if f > WIN) / len(bear) * 100) if bear else 0
    days = len({r["_date"] for r, _ in graded})

    gate = "✅ POSITIVE" if expectancy > 0 else "🔴 NEGATIVE"
    n_gate = "✅" if n >= 50 else f"⏳ {n}/50"
    lines = [f"📈 **FLOW PICK TRACK RECORD** — {days} days, {n} picks",
             f"Hit rate **{hit:.0f}%** ({len(wins)}W / {len(losses)}L / {flats} flat)",
             f"Avg winner **{avg_win:+.1f}%** · avg loser **{avg_loss:+.1f}%**",
             f"Expectancy **{expectancy:+.2f}%/pick** ({gate})",
             f"Bullish {bull_hit:.0f}% ({len(bull)}) · Bearish {bear_hit:.0f}% ({len(bear)})",
             f"\n_Graded pick-time → same-day close, direction-adjusted. Go-live gate: n≥50 ({n_gate}) + positive expectancy._"]
    sd.post(sd.resolve_channel("flow-picks"), "\n".join(lines))
    print(f"[track-record] n={n} hit={hit:.0f}% exp={expectancy:+.2f}%", flush=True)


if __name__ == "__main__":
    main()
