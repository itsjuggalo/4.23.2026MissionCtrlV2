"""rh_stock.py — page ALL filled Robinhood STOCK orders (per-execution) into the vault.

Auth: the bearer that rh-session-keeper (:3011) keeps fresh in
~/.openclaw/secrets/robinhood-brokerage-token.txt — re-read per run, NEVER logs in
itself (the keeper owns login cadence; on 401 we skip and let it heal).
Symbols resolve via the public instruments endpoint, cached on disk.
"""
from __future__ import annotations

import json
import urllib.parse
import urllib.request
from pathlib import Path

from . import db

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "robinhood-brokerage-token.txt"
INSTR_CACHE = Path.home() / "portfolio" / ".rh_instruments.json"
API = "https://api.robinhood.com"
UA = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36"


def _get(url: str, token: str | None = None):
    headers = {"User-Agent": UA, "Accept": "application/json"}
    if token:
        headers["Authorization"] = f"Bearer {token}"
    req = urllib.request.Request(url, headers=headers)
    with urllib.request.urlopen(req, timeout=25) as r:
        return json.loads(r.read())


def _instr_map() -> dict:
    try:
        return json.loads(INSTR_CACHE.read_text())
    except Exception:
        return {}


def _resolve_symbol(instr_url: str, cache: dict) -> str:
    key = instr_url.rstrip("/").split("/")[-1]
    if key in cache:
        return cache[key]
    try:
        d = _get(instr_url)
        sym = (d.get("symbol") or key).upper()
    except Exception:
        sym = key
    cache[key] = sym
    try:
        INSTR_CACHE.write_text(json.dumps(cache))
    except Exception:
        pass
    return sym


def sync(con, full: bool = False) -> int:
    token = TOKEN_FILE.read_text().strip()
    cache = _instr_map()
    new = 0
    url = f"{API}/orders/?" + urllib.parse.urlencode({"page_size": 100})
    for _ in range(200):
        try:
            d = _get(url, token)
        except urllib.error.HTTPError as e:
            if e.code == 401:
                print("rh_stock: bearer rejected (401) — keeper will heal; skipping")
                return new
            raise
        page = d.get("results", [])
        page_new = 0
        for o in page:
            if o.get("state") != "filled":
                continue
            execs = o.get("executions") or []
            if not execs:
                continue
            sym = _resolve_symbol(o.get("instrument", ""), cache)
            side = o.get("side") or "buy"
            fees = float(o.get("fees") or 0)
            for i, ex in enumerate(execs):
                qty = float(ex.get("quantity") or 0)
                px = float(ex.get("price") or 0)
                if qty <= 0:
                    continue
                if db.insert_fill(
                        con, broker="robinhood", asset_class="stock",
                        order_id=o.get("id") or "", fill_id=ex.get("id") or str(i),
                        symbol=sym, side=side, qty=qty, price=px,
                        fees=fees / len(execs),
                        amount_usd=round(qty * px, 2) * (1 if side == "sell" else -1),
                        filled_at=ex.get("timestamp") or o.get("updated_at") or "",
                        raw={"order": {k: o.get(k) for k in
                                       ("id", "side", "type", "trigger", "average_price",
                                        "cumulative_quantity", "updated_at")},
                             "exec": ex}):
                    page_new += 1
        new += page_new
        url = d.get("next")
        if not url:
            break
        if not full and page and page_new == 0:
            break
    con.commit()
    db.set_cursor(con, "rh_stock", None, new)
    con.commit()
    return new
