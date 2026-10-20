"""rh_quote.py — shared READ-ONLY Robinhood option bid/ask helper.

rh_quotes(["SPY261016C00700000", ...]) -> {occ: {bid, ask, mid, last, as_of, as_of_et, source}}

Same fixed endpoint allowlist as the OME provider
(web/missionctrl/pipeline/decision/option_momentum/providers.py): instruments/,
options/instruments/, marketdata/options/ — nothing else; no account, position or order API.
Token = the rh-session-keeper file (never printed, never logged). A contract that cannot be
priced (no exact instrument, no bid/ask, no quote timestamp, any HTTP error) is simply absent
from the result — this helper never guesses. `as_of` is the quote's own observation time
(epoch seconds), never the fetch time.
"""
from __future__ import annotations

import os
import re
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
RH_TOKEN_FILE = Path.home() / ".openclaw/secrets/robinhood-brokerage-token.txt"
BASE = "https://api.robinhood.com/"
_ALLOWED = {"instruments/", "options/instruments/", "marketdata/options/"}
_OCC = re.compile(r"^([A-Z]{1,6})(\d{6})([CP])(\d{8})$")
_UUID = re.compile(r"^[0-9a-fA-F-]{36}$")
_ID_CACHE: dict[str, dict] = {}


def _num(v):
    try:
        f = float(v)
    except (TypeError, ValueError):
        return None
    return f if f == f else None


def _token() -> str | None:
    p = Path(os.environ.get("MC_OPTION_MOMENTUM_RH_TOKEN_FILE") or RH_TOKEN_FILE)
    try:
        if not p.is_file() or p.stat().st_size > 16384:
            return None
        t = p.read_text().strip()
    except OSError:
        return None
    return t if t and "\n" not in t else None


def parse_occ(occ: str) -> dict | None:
    m = _OCC.match(occ or "")
    if not m:
        return None
    root, ymd, cp, k = m.groups()
    try:
        expiry = datetime.strptime(ymd, "%y%m%d").date().isoformat()
    except ValueError:
        return None
    return {"occ": occ, "symbol": root, "expiry": expiry,
            "kind": "call" if cp == "C" else "put", "strike": int(k) / 1000.0}


def _get(session, token: str, path: str, params: dict) -> dict | None:
    if path not in _ALLOWED:
        raise ValueError("ENDPOINT_FORBIDDEN")
    try:
        r = session.get(BASE + path, params=params, timeout=10, allow_redirects=False,
                        headers={"Authorization": "Bearer " + token, "Accept": "application/json"})
        if r.status_code != 200:
            return None
        d = r.json()
    except Exception:  # noqa: BLE001 — any transport/parse failure = no quote
        return None
    return d if isinstance(d, dict) else None


def _results(d: dict | None) -> list:
    return [r for r in (d or {}).get("results", []) if isinstance(r, dict)]


def _resolve(session, token, c: dict) -> dict | None:
    if c["occ"] in _ID_CACHE:
        return _ID_CACHE[c["occ"]]
    und = [r for r in _results(_get(session, token, "instruments/", {"symbol": c["symbol"]}))
           if r.get("symbol") == c["symbol"]]
    if len(und) != 1 or not _UUID.match(str(und[0].get("tradable_chain_id") or "")):
        return None
    rows = _results(_get(session, token, "options/instruments/", dict(
        chain_id=und[0]["tradable_chain_id"], chain_symbol=c["symbol"], state="active",
        expiration_dates=c["expiry"], strike_price=f"{c['strike']:g}", type=c["kind"])))
    ok = [r for r in rows if r.get("chain_symbol") == c["symbol"]
          and r.get("expiration_date") == c["expiry"] and _num(r.get("strike_price")) == c["strike"]
          and r.get("type") == c["kind"] and _UUID.match(str(r.get("id") or ""))
          and _num(r.get("trade_value_multiplier")) == 100]
    if len(ok) != 1:
        return None
    _ID_CACHE[c["occ"]] = ok[0]
    return ok[0]


def _epoch(ts) -> float | None:
    try:
        return datetime.fromisoformat(str(ts).replace("Z", "+00:00")).timestamp()
    except (TypeError, ValueError):
        return None


def rh_quotes(occ_list, session=None) -> dict[str, dict]:
    """Read-only RH bid/ask per OCC symbol. Missing = could not price (never guessed)."""
    token = _token() if session is None else (_token() or "test-token")
    if not token:
        return {}
    if session is None:
        try:
            import requests
        except ImportError:
            return {}
        session = requests.Session()
    out: dict[str, dict] = {}
    targets: dict[str, str] = {}  # instrument id -> occ
    for occ in dict.fromkeys(occ_list or []):
        c = parse_occ(occ)
        if not c:
            continue
        row = _resolve(session, token, c)
        if row:
            targets[row["id"]] = occ
    ids = list(targets)
    for k in range(0, len(ids), 25):
        d = _get(session, token, "marketdata/options/", {"instruments": ",".join(
            BASE + "options/instruments/" + i + "/" for i in ids[k:k + 25])})
        for r in _results(d):
            i = next((x for x in ids if r.get("instrument") == BASE + "options/instruments/" + x + "/"
                      or r.get("instrument_id") == x), None)
            if not i:
                continue
            bid, ask = _num(r.get("bid_price")), _num(r.get("ask_price"))
            at = _epoch(r.get("quote_updated_at") or r.get("updated_at"))
            if bid is None or ask is None or bid < 0 or ask <= 0 or ask < bid or at is None:
                continue
            out[targets[i]] = {
                "bid": bid, "ask": ask, "mid": round((bid + ask) / 2, 2),
                "last": _num(r.get("last_trade_price")), "as_of": at,
                "iv": _num(r.get("implied_volatility")), "delta": _num(r.get("delta")),
                "high": _num(r.get("high_price")), "low": _num(r.get("low_price")),
                "as_of_et": datetime.fromtimestamp(at, ET).strftime("%Y-%m-%d %H:%M:%S ET"),
                "source": "robinhood"}
    return out


if __name__ == "__main__":
    for o, q in rh_quotes(sys.argv[1:]).items():
        print(o, f"bid {q['bid']} ask {q['ask']} as_of {q['as_of_et']}")
