"""Live holdings, read-only, for the daily Claude-vs-Codex portfolio debate (Mike 2026-10-20 exception).

Reads Robinhood (stocks, options, crypto) and Coinbase at run time and returns them in memory. Nothing is
written to disk: the global rule allows holdings only inside this run and the debate post.

- Robinhood stocks/options: brokerage bearer token, fixed GET-only path allowlist (no order/account-write path).
- Robinhood crypto: the crypto Trading API key (holdings endpoint, GET).
- Coinbase: Advanced Trade accounts endpoint (GET, ES256 JWT).
- Prices: quote.v1 via quote_client (Robinhood first for stocks, Coinbase for crypto), each with source + as_of.
  Option marks: Robinhood marketdata/options.
A source that fails is reported in `missing` with the reason; no value is invented.
"""
from __future__ import annotations

import base64, json, secrets, sys, time, urllib.error, urllib.request
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
SEC = Path.home() / ".openclaw/secrets"
RH = "https://api.robinhood.com/"
_RH_ALLOWED = ("positions/", "options/aggregate_positions/", "marketdata/options/", "accounts/")
sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline")


def _rh_get(path: str) -> dict:
    if not path.startswith(_RH_ALLOWED):
        raise PermissionError(f"path not on the read-only allowlist: {path.split('?')[0]}")
    tok = (SEC / "robinhood-brokerage-token.txt").read_text().strip()
    req = urllib.request.Request(RH + path, headers={"Authorization": "Bearer " + tok, "Accept": "application/json"})
    with urllib.request.urlopen(req, timeout=15) as r:
        return json.load(r)


def _quotes(symbols):
    if not symbols:
        return {}
    from decision.lib.quote_client import get_canonical_quotes
    return {q["symbol"]: q for q in get_canonical_quotes(sorted(set(symbols))) if q.get("price") is not None}


def rh_stocks_options(missing: list) -> tuple[list, list]:
    stocks, options = [], []
    try:
        for p in _rh_get("positions/?nonzero=true")["results"]:
            qty = float(p["quantity"])
            if qty:
                stocks.append({"symbol": p["symbol"], "qty": qty, "avg_cost": float(p["average_buy_price"] or 0)})
    except Exception as e:
        missing.append(f"Robinhood stock positions: {type(e).__name__} {str(e)[:60]}")
    try:
        for a in _rh_get("options/aggregate_positions/?nonzero=True")["results"]:
            for leg in a["legs"]:
                options.append({"underlying": a["symbol"], "type": leg["option_type"], "strike": float(leg["strike_price"]),
                                "expiry": leg["expiration_date"], "side": leg["position_type"],
                                "contracts": float(a["quantity"]) * float(leg["ratio_quantity"]),
                                "avg_price": float(a["average_open_price"]) / float(a["trade_value_multiplier"] or 100),
                                "option_id": leg["option_id"]})
        if options:
            ids = ",".join(o["option_id"] for o in options)
            marks = {m["instrument_id"]: m for m in _rh_get(f"marketdata/options/?ids={ids}")["results"] if m}
            for o in options:
                m = marks.get(o["option_id"])
                o["mark"] = float(m["mark_price"]) if m and m.get("mark_price") else None
                o["mark_source"] = "Robinhood marketdata/options" if o["mark"] is not None else "UNAVAILABLE"
                o["mark_as_of"] = (m or {}).get("updated_at")
    except Exception as e:
        missing.append(f"Robinhood option positions: {type(e).__name__} {str(e)[:60]}")
    return stocks, options


def rh_crypto(missing: list) -> list:
    try:
        from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey
        key = (SEC / "robinhood-api-key.txt").read_text().strip()
        pk = Ed25519PrivateKey.from_private_bytes(base64.b64decode((SEC / "robinhood-private.b64").read_text().strip()))
        ts, path = str(int(time.time())), "/api/v1/crypto/trading/holdings/"
        sig = base64.b64encode(pk.sign((key + ts + path + "GET").encode())).decode()
        req = urllib.request.Request("https://trading.robinhood.com" + path,
                                     headers={"x-api-key": key, "x-timestamp": ts, "x-signature": sig})
        with urllib.request.urlopen(req, timeout=15) as r:
            res = json.load(r).get("results", [])
        return [{"asset": h["asset_code"], "qty": float(h["total_quantity"]), "venue": "Robinhood"}
                for h in res if float(h.get("total_quantity") or 0) > 0]
    except Exception as e:
        missing.append(f"Robinhood crypto: {type(e).__name__} {str(e)[:60]}")
        return []


def coinbase(missing: list) -> list:
    try:
        from cryptography.hazmat.primitives.asymmetric.ec import ECDSA
        from cryptography.hazmat.primitives.asymmetric.utils import decode_dss_signature
        from cryptography.hazmat.primitives.hashes import SHA256
        from cryptography.hazmat.primitives.serialization import load_pem_private_key
        kid = (SEC / "coinbase-api-key.txt").read_text().strip()
        pk = load_pem_private_key((SEC / "coinbase-private.pem").read_bytes(), password=None)
        path, now = "/api/v3/brokerage/accounts?limit=250", int(time.time())
        b64 = lambda d: base64.urlsafe_b64encode(json.dumps(d).encode()).rstrip(b"=").decode()
        head = b64({"alg": "ES256", "kid": kid, "nonce": secrets.token_hex(16)})
        body = b64({"sub": kid, "iss": "cdp", "nbf": now, "exp": now + 120, "uri": "GET api.coinbase.com/api/v3/brokerage/accounts"})
        r_, s_ = decode_dss_signature(pk.sign(f"{head}.{body}".encode(), ECDSA(SHA256())))
        sig = base64.urlsafe_b64encode(r_.to_bytes(32, "big") + s_.to_bytes(32, "big")).rstrip(b"=").decode()
        req = urllib.request.Request("https://api.coinbase.com" + path, headers={"Authorization": f"Bearer {head}.{body}.{sig}"})
        with urllib.request.urlopen(req, timeout=15) as r:
            accts = json.load(r).get("accounts", [])
        out = []
        for a in accts:
            q = float(a["available_balance"]["value"]) + float(a["hold"]["value"])
            if q > 1e-6 and a["currency"] not in ("ETH2", "BSV"):
                out.append({"asset": a["currency"], "qty": q, "venue": "Coinbase"})
        return out
    except Exception as e:
        missing.append(f"Coinbase: {type(e).__name__} {str(e)[:60]}")
        return []


_RENAMED = {"RNDR": "RENDER", "MATIC": "POL"}


def _crypto_fallback(asset: str) -> dict:
    """market-data rule §3: Coinbase spot → Kraken ticker, each named; nothing found → price None."""
    now = datetime.now(ET).isoformat(timespec="seconds")
    for sym in dict.fromkeys([asset, _RENAMED.get(asset, asset)]):
        try:
            req = urllib.request.Request(f"https://api.coinbase.com/v2/prices/{sym}-USD/spot", headers={"CB-VERSION": "2016-02-18"})
            with urllib.request.urlopen(req, timeout=8) as r:
                return {"price": float(json.load(r)["data"]["amount"]), "source": f"Coinbase spot ({sym}-USD)", "as_of": now}
        except Exception:
            pass
        try:
            with urllib.request.urlopen(f"https://api.kraken.com/0/public/Ticker?pair={sym}USD", timeout=8) as r:
                res = json.load(r).get("result") or {}
            if res:
                return {"price": float(next(iter(res.values()))["c"][0]), "source": f"Kraken ({sym}USD)", "as_of": now}
        except Exception:
            pass
    return {}


def gather() -> dict:
    missing: list = []
    stocks, options = rh_stocks_options(missing)
    crypto = rh_crypto(missing) + coinbase(missing)
    stable = {"USD", "USDC", "USDT"}
    q = _quotes([s["symbol"] for s in stocks] + [c["asset"] + "-USD" for c in crypto if c["asset"] not in stable])
    for s in stocks:
        qq = q.get(s["symbol"])
        s.update(price=qq["price"] if qq else None, source=(qq or {}).get("source", {}).get("provider", "UNAVAILABLE"),
                 as_of=(qq or {}).get("as_of"), change_pct=((qq or {}).get("change") or {}).get("pct"))
    for c in crypto:
        if c["asset"] in stable:
            c.update(price=1.0, source="cash/stablecoin", as_of=None)
            continue
        qq = q.get(c["asset"] + "-USD")
        c.update(price=qq["price"] if qq else None, source=(qq or {}).get("source", {}).get("provider", "UNAVAILABLE"),
                 as_of=(qq or {}).get("as_of"), change_pct=((qq or {}).get("change") or {}).get("pct"),
                 change_basis=((qq or {}).get("change") or {}).get("basis"))
        if c["price"] is None:
            c.update(_crypto_fallback(c["asset"]))
    for row in stocks + crypto:
        if row["price"] is None:
            missing.append(f"price for {row.get('symbol') or row.get('asset')}: no quote.v1 answer")
    return {"as_of_et": datetime.now(ET).isoformat(timespec="seconds"), "stocks": stocks, "options": options,
            "crypto": crypto, "missing": missing}


if __name__ == "__main__":  # counts only — never print holdings to a log
    h = gather()
    print(json.dumps({"stocks": len(h["stocks"]), "options": len(h["options"]), "crypto": len(h["crypto"]),
                      "missing": h["missing"]}))
