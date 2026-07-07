"""rh_crypto.py — page ALL filled Robinhood-crypto orders into the fills vault.

Same Ed25519-signed official API rh_crypto_basis.py uses (read-only, lists orders,
places none). ~666 lifetime orders as of 2026-07-07. Incremental: stops paging once
a full page of already-seen orders is hit (orders come newest-first).
"""
from __future__ import annotations

import base64
import json
import time
import urllib.request
from pathlib import Path

from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey

from . import db

SEC = Path.home() / ".openclaw" / "secrets"
BASE = "https://trading.robinhood.com"


def _client():
    api_key = (SEC / "robinhood-api-key.txt").read_text().strip()
    pk = Ed25519PrivateKey.from_private_bytes(
        base64.b64decode((SEC / "robinhood-private.b64").read_text().strip()))

    def get(path):
        ts = str(int(time.time()))
        sig = base64.b64encode(pk.sign((api_key + ts + path + "GET").encode())).decode()
        req = urllib.request.Request(BASE + path, headers={
            "x-api-key": api_key, "x-signature": sig, "x-timestamp": ts})
        with urllib.request.urlopen(req, timeout=25) as r:
            return json.loads(r.read())
    return get


def sync(con, full: bool = False) -> int:
    get = _client()
    new = 0
    cursor = None
    for _ in range(80):  # hard page cap
        path = "/api/v1/crypto/trading/orders/?state=filled"
        if cursor:
            path += "&cursor=" + cursor
        d = get(path)
        page = d.get("results", [])
        page_new = 0
        for o in page:
            sym = (o.get("symbol") or "").split("-")[0].upper()
            qty = float(o.get("filled_asset_quantity") or 0)
            px = float(o.get("average_price") or 0)
            if not sym or qty <= 0:
                continue
            side = o.get("side") or "buy"
            if db.insert_fill(
                    con, broker="robinhood", asset_class="crypto",
                    order_id=o.get("id") or "", symbol=sym, side=side,
                    qty=qty, price=px,
                    amount_usd=round(qty * px, 2) * (1 if side == "sell" else -1),
                    filled_at=o.get("updated_at") or o.get("created_at") or "", raw=o):
                page_new += 1
        new += page_new
        nxt = d.get("next")
        if not nxt:
            break
        if not full and page and page_new == 0:
            break  # incremental: a whole page of known orders → done
        cursor = nxt.split("cursor=")[-1] if "cursor=" in nxt else None
        if not cursor:
            break
    con.commit()
    db.set_cursor(con, "rh_crypto", None, new)
    con.commit()
    return new
