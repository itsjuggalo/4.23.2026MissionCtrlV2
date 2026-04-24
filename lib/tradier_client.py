"""
Tradier sandbox client — used by position_sell_daemon.py to fetch live options
bid/ask/IV/greeks for stop-limit pricing decisions.

Caches responses for 60 seconds to avoid rate limits (sandbox allows ~120/min).
"""
import json
import os
import time
from pathlib import Path

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
CACHE_DIR = Path("/home/ubuntu/.openclaw/workspace/state/tradier_cache")
CACHE_DIR.mkdir(parents=True, exist_ok=True)
CACHE_TTL_SEC = 60

BASE = "https://sandbox.tradier.com/v1"


def _key():
    p = SECRETS / "tradier-sandbox-key"
    return p.read_text().strip() if p.exists() else ""


def _headers():
    return {"Authorization": f"Bearer {_key()}", "Accept": "application/json"}


def _cache_get(key: str):
    f = CACHE_DIR / f"{key}.json"
    if not f.exists():
        return None
    try:
        if time.time() - f.stat().st_mtime > CACHE_TTL_SEC:
            return None
        return json.loads(f.read_text())
    except Exception:
        return None


def _cache_set(key: str, value):
    try:
        (CACHE_DIR / f"{key}.json").write_text(json.dumps(value))
    except Exception:
        pass


def parse_occ_symbol(occ: str):
    """
    Parse Alpaca/OCC option symbol like 'MSFT260515P00410000'.
    Returns (underlying, expiry_yyyy_mm_dd, option_type, strike_float) or None.
    """
    try:
        occ = occ.strip().upper()
        # find where digits start — underlying can be 1-6 chars
        for i, c in enumerate(occ):
            if c.isdigit():
                und = occ[:i]
                rest = occ[i:]
                break
        else:
            return None
        if len(rest) < 15:
            return None
        yy, mm, dd = rest[0:2], rest[2:4], rest[4:6]
        opt_type = rest[6]  # 'C' or 'P'
        strike_raw = rest[7:15]
        strike = int(strike_raw) / 1000.0
        expiry = f"20{yy}-{mm}-{dd}"
        return (und, expiry, opt_type, strike)
    except Exception:
        return None


def fetch_option_quote(occ_symbol: str):
    """
    Fetch live bid/ask/IV/greeks for a single OCC-format option symbol.
    Returns dict or None on failure.
    """
    import requests
    parsed = parse_occ_symbol(occ_symbol)
    if not parsed:
        return None
    und, expiry, opt_type, strike = parsed
    cache_key = f"{und}_{expiry}"
    chain = _cache_get(cache_key)
    if chain is None:
        try:
            r = requests.get(
                f"{BASE}/markets/options/chains",
                headers=_headers(),
                params={"symbol": und, "expiration": expiry, "greeks": "true"},
                timeout=10,
            )
            if r.status_code != 200:
                return None
            chain = r.json()
            _cache_set(cache_key, chain)
        except Exception:
            return None

    opts = (chain.get("options", {}) or {}).get("option", []) or []
    want_type = "put" if opt_type == "P" else "call"
    for o in opts:
        if o.get("option_type") == want_type and abs(float(o.get("strike", 0)) - strike) < 0.001:
            g = o.get("greeks", {}) or {}
            return {
                "symbol": o.get("symbol"),
                "bid": float(o.get("bid", 0) or 0),
                "ask": float(o.get("ask", 0) or 0),
                "last": float(o.get("last", 0) or 0),
                "iv": float(g.get("mid_iv", 0) or 0),
                "delta": float(g.get("delta", 0) or 0),
                "theta": float(g.get("theta", 0) or 0),
                "gamma": float(g.get("gamma", 0) or 0),
                "vega": float(g.get("vega", 0) or 0),
            }
    return None


if __name__ == "__main__":
    import sys
    sym = sys.argv[1] if len(sys.argv) > 1 else "MSFT260515P00410000"
    q = fetch_option_quote(sym)
    print(json.dumps(q, indent=2) if q else f"No quote for {sym}")
