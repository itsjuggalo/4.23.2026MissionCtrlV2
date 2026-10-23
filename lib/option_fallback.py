"""Free option-mark fallbacks behind Robinhood (market-data rule section 3; Mike 2026-10-23: "there should be no
unavailable or missing data since we have resources").

Chain, in order, owned by price_guard.option_mid / option_quotes:
  1. Robinhood mark          (lib/rh_quote, read-only)                 - not in this file
  2. Yahoo option chain      (yfinance option_chain(expiry))           - "Yahoo · not Robinhood"
  3. CBOE delayed quotes     (cdn.cboe.com delayed_quotes options JSON) - "CBOE delayed ~15m"

yahoo_quote(occ) / cboe_quote(occ) -> (quote | None, why).  quote = {bid, ask, mid, last, as_of (epoch, DATA time),
as_of_et, provider, label}.  Never guesses: no usable two-sided bid/ask or no data time -> (None, reason).
  - Yahoo carries no quote timestamp, so as_of is the contract's lastTradeDate (the only dated field); an old last
    trade therefore makes the quote look old and the send-time gate will refuse it - conservative on purpose.
  - CBOE's top-level `timestamp` is not a stated zone, so as_of is the underlying's `last_trade_time` (ET, in the
    same file), the delayed feed's own data time.
`_fetch` arguments exist so tests run with stubs and no network.
"""
from __future__ import annotations

import json
import re
import time
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
_OCC = re.compile(r"^([A-Z]{1,6})(\d{6})([CP])(\d{8})$")
YAHOO_LABEL = "Yahoo · not Robinhood"
CBOE_LABEL = "CBOE delayed ~15m"
_CBOE_CACHE: dict[str, tuple[float, dict]] = {}
_CBOE_TTL_S = 20


def _num(v):
    try:
        f = float(v)
    except (TypeError, ValueError):
        return None
    return f if f == f else None


# Index options: CBOE serves them as _VIX / _SPX ... and Yahoo as ^VIX / ^SPX; weekly/PM roots share the base index.
_INDEX_BASE = {"VIX": "VIX", "VIXW": "VIX", "SPX": "SPX", "SPXW": "SPX", "NDX": "NDX", "NDXP": "NDX", "RUT": "RUT",
               "RUTW": "RUT", "XSP": "XSP", "DJX": "DJX", "XND": "XND"}


def cboe_symbol(root: str) -> str:
    return "_" + _INDEX_BASE[root] if root in _INDEX_BASE else root


def yahoo_symbol(root: str) -> str:
    return "^" + _INDEX_BASE[root] if root in _INDEX_BASE else root


def _parse(occ: str):
    m = _OCC.match(occ or "")
    if not m:
        return None
    root, ymd, cp, k = m.groups()
    expiry = datetime.strptime(ymd, "%y%m%d").date().isoformat()
    return root, expiry, cp, int(k) / 1000.0


def _quote(bid, ask, last, as_of: float | None, provider: str, label: str):
    bid, ask = _num(bid), _num(ask)
    if bid is None or ask is None or bid < 0 or ask <= 0 or ask < bid:
        return None, f"no usable bid/ask (bid {bid}, ask {ask})"
    if as_of is None:
        return None, "no data time on the quote"
    return {"bid": bid, "ask": ask, "mid": round((bid + ask) / 2, 2), "last": _num(last), "as_of": as_of,
            "as_of_et": datetime.fromtimestamp(as_of, ET).strftime("%Y-%m-%d %H:%M:%S ET"),
            "provider": provider, "label": label}, None


# ── Yahoo (yfinance) ──────────────────────────────────────────────────────────
_YF_CACHE: dict[tuple, tuple[float, object]] = {}


def _yf_chain(root: str, expiry: str):
    hit = _YF_CACHE.get((root, expiry))
    if hit and time.time() - hit[0] < _CBOE_TTL_S:
        return hit[1]
    import yfinance as yf   # lazy: the system python3 has no yfinance; the caller reports that as the reason
    ch = yf.Ticker(yahoo_symbol(root)).option_chain(expiry)
    _YF_CACHE[(root, expiry)] = (time.time(), ch)
    return ch


def yahoo_quote(occ: str, _fetch=None):
    p = _parse(occ)
    if not p:
        return None, "not an OCC symbol"
    root, expiry, cp, strike = p
    try:
        ch = (_fetch or _yf_chain)(root, expiry)
        df = ch.calls if cp == "C" else ch.puts
    except ImportError:
        return _yahoo_via_venv(occ)   # system python3 has no yfinance: ask the venv python (same free source)
    except Exception as e:  # noqa: BLE001
        return None, f"{type(e).__name__}: {str(e)[:80]}"
    rows = df[df["contractSymbol"] == occ]
    if rows.empty:
        return None, "contract not in the Yahoo chain"
    r = rows.iloc[0]
    ts = r.get("lastTradeDate")
    as_of = ts.timestamp() if ts is not None and hasattr(ts, "timestamp") else None
    return _quote(r.get("bid"), r.get("ask"), r.get("lastPrice"), as_of, "yahoo", YAHOO_LABEL)


VENV_PY = "/home/itsju/.venv/bin/python"


def _yahoo_via_venv(occ: str):
    import os
    import subprocess
    import sys
    if not os.path.exists(VENV_PY) or os.path.realpath(sys.executable) == os.path.realpath(VENV_PY):
        return None, "yfinance not installed in this python"
    try:
        r = subprocess.run([VENV_PY, os.path.abspath(__file__), occ], capture_output=True, text=True, timeout=40)
        out = json.loads(r.stdout.strip().splitlines()[-1])
    except Exception as e:  # noqa: BLE001
        return None, f"yfinance via venv failed ({type(e).__name__})"
    return out["quote"], out["why"]


# ── CBOE delayed quotes ───────────────────────────────────────────────────────
def _cboe_get(root: str) -> dict:
    import urllib.request
    hit = _CBOE_CACHE.get(root)
    if hit and time.time() - hit[0] < _CBOE_TTL_S:
        return hit[1]
    req = urllib.request.Request(f"https://cdn.cboe.com/api/global/delayed_quotes/options/{cboe_symbol(root)}.json",
                                 headers={"User-Agent": "Mozilla/5.0"})
    with urllib.request.urlopen(req, timeout=20) as r:
        d = json.load(r)
    _CBOE_CACHE[root] = (time.time(), d)
    return d


def cboe_quote(occ: str, _fetch=None):
    p = _parse(occ)
    if not p:
        return None, "not an OCC symbol"
    root = p[0]
    try:
        d = (_fetch or _cboe_get)(root)
        data = d["data"]
    except Exception as e:  # noqa: BLE001
        return None, f"{type(e).__name__}: {str(e)[:80]}"
    row = next((o for o in data.get("options") or [] if o.get("option") == occ), None)
    if not row:
        return None, "contract not in the CBOE chain"
    try:
        as_of = datetime.fromisoformat(str(data.get("last_trade_time"))).replace(tzinfo=ET).timestamp()
    except (TypeError, ValueError):
        as_of = None
    return _quote(row.get("bid"), row.get("ask"), row.get("last_trade_price"), as_of, "cboe", CBOE_LABEL)


LEGS = (("Yahoo", yahoo_quote), ("CBOE", cboe_quote))


if __name__ == "__main__":   # `python option_fallback.py <OCC>` -> {"quote": ..., "why": ...} (used by _yahoo_via_venv)
    import sys
    _q, _why = yahoo_quote(sys.argv[1])
    print(json.dumps({"quote": _q, "why": _why}))
