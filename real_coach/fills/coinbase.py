"""coinbase.py — pull Coinbase RETAIL (v2) transactions per wallet into the vault.

Mike's CB coins were bought in the retail app, so Advanced-Trade fills are empty —
the history lives in v2 /accounts/<id>/transactions (verified live 2026-07-07 with
the existing CDP key; ES256 JWT hand-rolled here, no new deps beyond cryptography).
Mapping: buy/sell/trade → real fills at native-USD price; send/receive (transfers)
→ synthetic=1 rows valued at that day's native amount ("basis est." downstream).
Read-only. Advanced-Trade fills also swept for completeness (currently empty).
"""
from __future__ import annotations

import base64
import json
import secrets
import time
import urllib.request
from pathlib import Path

from cryptography.hazmat.primitives import hashes, serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric.utils import decode_dss_signature

from . import db

SEC = Path.home() / ".openclaw" / "secrets"
HOST = "api.coinbase.com"
SKIP_CCY = {"USD", "USDC"}


def _client():
    key_name = (SEC / "coinbase-api-key.txt").read_text().strip()
    pk = serialization.load_pem_private_key(
        (SEC / "coinbase-private.pem").read_bytes(), password=None)

    def b64u(b: bytes) -> str:
        return base64.urlsafe_b64encode(b).decode().rstrip("=")

    def get(path: str):
        uri = f"GET {HOST}{path.split('?')[0]}"
        header = {"alg": "ES256", "kid": key_name, "nonce": secrets.token_hex(16), "typ": "JWT"}
        now = int(time.time())
        payload = {"sub": key_name, "iss": "cdp", "nbf": now, "exp": now + 120, "uri": uri}
        signing = f"{b64u(json.dumps(header).encode())}.{b64u(json.dumps(payload).encode())}"
        der = pk.sign(signing.encode(), ec.ECDSA(hashes.SHA256()))
        r, s = decode_dss_signature(der)
        tok = f"{signing}.{b64u(r.to_bytes(32, 'big') + s.to_bytes(32, 'big'))}"
        req = urllib.request.Request(f"https://{HOST}{path}",
                                     headers={"Authorization": f"Bearer {tok}"})
        with urllib.request.urlopen(req, timeout=25) as r2:
            return json.loads(r2.read())
    return get


def _accounts(get) -> list[dict]:
    out, path = [], "/v2/accounts?limit=100"
    for _ in range(20):
        d = get(path)
        out += d.get("data", [])
        nxt = (d.get("pagination") or {}).get("next_uri")
        if not nxt:
            break
        path = nxt
    return out


def sync(con, full: bool = False) -> int:
    get = _client()
    new = 0
    for a in _accounts(get):
        ccy = a.get("currency", {})
        code = (ccy.get("code") if isinstance(ccy, dict) else ccy or "").upper()
        if not code or code in SKIP_CCY:
            continue
        bal = float((a.get("balance") or {}).get("amount") or 0)
        aid = a.get("id")
        # full backfill hits every wallet; incremental only wallets with a balance
        if not full and bal <= 0:
            continue
        path = f"/v2/accounts/{aid}/transactions?limit=100"
        for _ in range(30):
            try:
                d = get(path)
            except Exception as e:
                print(f"coinbase: tx fetch failed for {code}: {e}")
                break
            page_new = 0
            for tx in d.get("data", []):
                amt = float((tx.get("amount") or {}).get("amount") or 0)
                usd = float((tx.get("native_amount") or {}).get("amount") or 0)
                qty = abs(amt)
                if qty <= 0:
                    continue
                typ = tx.get("type") or "?"
                side = "buy" if amt > 0 else "sell"
                synthetic = 0 if typ in ("buy", "sell", "trade", "advanced_trade_fill") else 1
                px = abs(usd) / qty if qty else 0.0
                if db.insert_fill(
                        con, broker="coinbase", asset_class="crypto",
                        order_id=tx.get("id") or "", symbol=code, side=side,
                        position_effect=typ if synthetic else None,
                        qty=qty, price=round(px, 8),
                        amount_usd=round(usd, 2),
                        filled_at=tx.get("created_at") or "",
                        synthetic=synthetic,
                        raw={k: tx.get(k) for k in ("id", "type", "status", "amount",
                                                    "native_amount", "created_at",
                                                    "description")}):
                    new += 1
                    page_new += 1
            nxt = (d.get("pagination") or {}).get("next_uri")
            if not nxt:
                break
            if not full and d.get("data") and page_new == 0:
                break  # incremental: whole page already known (newest-first) → next wallet
            path = nxt
    con.commit()
    db.set_cursor(con, "coinbase", None, new)
    con.commit()
    return new
