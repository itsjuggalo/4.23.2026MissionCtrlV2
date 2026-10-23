"""Daily bars for the breakout scanners from the shared loader (pipeline/decision/lib/bars.get_bars: Robinhood daily
first, then the console cache, then yfinance). No Alpaca (market-data rule §1; staged 2026-10-22).

fetch_daily(symbols, days) -> ({sym: [{t,o,h,l,c,v}] oldest->newest, completed bars only}, {sym: source}).
Bars are RAW OHLC (split-adjusted by the source, dividends NOT applied); the Alpaca feed this replaces used
adjustment=all. A symbol the loader cannot serve is left out and logged to stderr, never filled.
"""
from __future__ import annotations

import sys
from concurrent.futures import ThreadPoolExecutor
from datetime import timezone

_MC = "/AIWorkWSL/web/missionctrl"


def _loader():
    if _MC not in sys.path:
        sys.path.insert(0, _MC)
    from pipeline.decision.lib import bars
    return bars


def _period(days: int) -> str:
    return "2y" if days > 365 else "1y"


def fetch_daily(symbols, days: int = 380, workers: int = 8, _get=None):
    get = _get or _loader().get_bars
    out, src = {}, {}

    def one(sym):
        try:
            bs = get(sym.replace(".", "-"), "1d", lookback_period=_period(days))
        except Exception as e:  # noqa: BLE001 - one bad symbol never aborts the scan
            print(f"[bars] drop {sym}: {type(e).__name__}: {str(e)[:80]}", file=sys.stderr)
            return sym, None, None
        rows = [{"t": r["t"].astimezone(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ"), "o": float(r["o"]),
                 "h": float(r["h"]), "l": float(r["l"]), "c": float(r["c"]), "v": float(r["v"])}
                for r in bs.df.to_dict("records")][-days:]
        return sym, rows, str(bs.source)

    with ThreadPoolExecutor(max_workers=workers) as ex:
        for sym, rows, source in ex.map(one, list(symbols)):
            if rows:
                out[sym], src[sym] = rows, source
    return out, src
