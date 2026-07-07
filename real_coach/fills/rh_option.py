"""rh_option.py — page ALL filled Robinhood OPTION orders (per-leg execution) into the vault.

Same bearer as rh_stock (keeper-owned, never logs in). Option-instrument details
(OCC symbol, strike, type, expiry) resolve via the options/instruments endpoint,
cached on disk. symbol column = underlying (chain_symbol); OCC in occ_symbol.
"""
from __future__ import annotations

import json
import urllib.parse
import urllib.request
from pathlib import Path

from . import db

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "robinhood-brokerage-token.txt"
OPT_CACHE = Path.home() / "portfolio" / ".rh_opt_instruments.json"
API = "https://api.robinhood.com"
UA = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36"


def _get(url: str, token: str | None = None):
    headers = {"User-Agent": UA, "Accept": "application/json"}
    if token:
        headers["Authorization"] = f"Bearer {token}"
    req = urllib.request.Request(url, headers=headers)
    with urllib.request.urlopen(req, timeout=25) as r:
        return json.loads(r.read())


def _occ(opt_url: str, cache: dict, token: str) -> dict:
    key = opt_url.rstrip("/").split("/")[-1]
    if key in cache:
        return cache[key]
    rec = {}
    try:
        d = _get(opt_url, token)
        rec = {"occ": d.get("occ_symbol"), "strike": d.get("strike_price"),
               "kind": d.get("type"), "expiry": d.get("expiration_date")}
    except Exception:
        pass
    cache[key] = rec
    try:
        OPT_CACHE.write_text(json.dumps(cache))
    except Exception:
        pass
    return rec


def sync(con, full: bool = False) -> int:
    token = TOKEN_FILE.read_text().strip()
    try:
        cache = json.loads(OPT_CACHE.read_text())
    except Exception:
        cache = {}
    new = 0
    url = f"{API}/options/orders/?" + urllib.parse.urlencode({"page_size": 100})
    for _ in range(200):
        try:
            d = _get(url, token)
        except urllib.error.HTTPError as e:
            if e.code == 401:
                print("rh_option: bearer rejected (401) — keeper will heal; skipping")
                return new
            raise
        page = d.get("results", [])
        page_new = 0
        for o in page:
            if o.get("state") != "filled":
                continue
            under = (o.get("chain_symbol") or "").upper()
            mult = 100.0
            for li, leg in enumerate(o.get("legs") or []):
                occ = _occ(leg.get("option", ""), cache, token)
                side = leg.get("side") or o.get("direction") or "buy"
                effect = leg.get("position_effect")
                for ei, ex in enumerate(leg.get("executions") or []):
                    qty = float(ex.get("quantity") or 0)
                    px = float(ex.get("price") or 0)   # per-share premium
                    if qty <= 0:
                        continue
                    if db.insert_fill(
                            con, broker="robinhood", asset_class="option",
                            order_id=o.get("id") or "",
                            fill_id=f"{leg.get('id', li)}:{ex.get('id', ei)}",
                            symbol=under, occ_symbol=occ.get("occ"),
                            side=side, position_effect=effect, qty=qty, price=px,
                            amount_usd=round(qty * px * mult, 2) * (1 if side == "sell" else -1),
                            filled_at=ex.get("timestamp") or o.get("updated_at") or "",
                            raw={"order_id": o.get("id"), "strategy": o.get("opening_strategy")
                                 or o.get("closing_strategy"), "occ": occ, "exec": ex}):
                        page_new += 1
        new += page_new
        url = d.get("next")
        if not url:
            break
        if not full and page and page_new == 0:
            break
    con.commit()
    db.set_cursor(con, "rh_option", None, new)
    con.commit()
    return new
