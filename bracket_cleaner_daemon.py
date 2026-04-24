#!/usr/bin/env python3
"""
Bracket Cleaner Daemon — Polls Alpaca open orders every 30s.
When a sell order fills for a symbol, cancel the sibling (SL if TP filled, TP if SL filled).
Prevents orphaned orders that would accidentally double-sell.
"""
import os, time, json
from pathlib import Path
from datetime import datetime, timezone
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
KEY = (SECRETS / "alpaca-key-id").read_text().strip()
SEC = (SECRETS / "alpaca-secret").read_text().strip()
WEBHOOK = (SECRETS / "discord_bobatrades_webhook").read_text().strip() if (SECRETS / "discord_bobatrades_webhook").exists() else None

HEADERS = {"APCA-API-KEY-ID": KEY, "APCA-API-SECRET-KEY": SEC, "Content-Type": "application/json"}
BASE = "https://paper-api.alpaca.markets/v2"

# Track last-known order state between polls
seen_orders = {}  # id -> status

def post_discord(msg):
    if not WEBHOOK:
        return
    try:
        requests.post(WEBHOOK, json={"content": msg}, timeout=5)
    except Exception:
        pass

def get_open_orders():
    r = requests.get(f"{BASE}/orders?status=open&limit=100", headers=HEADERS, timeout=10)
    return r.json() if r.status_code == 200 else []

def get_recent_fills(since_iso):
    # Orders that filled since `since_iso`
    r = requests.get(f"{BASE}/orders?status=closed&after={since_iso}&limit=100", headers=HEADERS, timeout=10)
    if r.status_code != 200:
        return []
    return [o for o in r.json() if o.get("status") == "filled"]

def cancel_order(order_id, reason=""):
    r = requests.delete(f"{BASE}/orders/{order_id}", headers=HEADERS, timeout=10)
    return r.status_code in (200, 204)

def find_sibling_sell_orders(symbol, exclude_id):
    """Find other open sell orders for the same symbol."""
    orders = get_open_orders()
    return [o for o in orders
            if o["symbol"] == symbol
            and o["side"] == "sell"
            and o["id"] != exclude_id]

def main():
    print(f"[bracket-cleaner] Starting, polling every 30s")
    post_discord("🧹 Bracket cleaner daemon STARTED — will cancel orphaned legs when siblings fill")

    last_check = datetime.now(timezone.utc).isoformat()

    while True:
        try:
            # Check for newly filled orders since last check
            fills = get_recent_fills(last_check)

            for filled_order in fills:
                if filled_order["side"] != "sell":
                    continue  # We only care about sell-side fills (TP or SL hit)

                symbol = filled_order["symbol"]
                filled_id = filled_order["id"]
                filled_type = filled_order["order_type"]  # "limit" (TP) or "stop_limit" (SL)

                # Find orphaned sell orders for this symbol
                siblings = find_sibling_sell_orders(symbol, filled_id)

                for sibling in siblings:
                    ok = cancel_order(sibling["id"])
                    role_filled = "TP" if filled_type == "limit" else "SL"
                    role_orphan = "SL" if filled_type == "limit" else "TP"
                    msg = (f"{'✂️' if ok else '⚠️'} {symbol}: {role_filled} filled → "
                           f"{'cancelled' if ok else 'FAILED to cancel'} orphan {role_orphan} "
                           f"({sibling['order_type']} {sibling['id'][:8]})")
                    print(f"[bracket-cleaner] {msg}")
                    post_discord(msg)

            # Advance checkpoint
            last_check = datetime.now(timezone.utc).isoformat()

        except Exception as e:
            print(f"[bracket-cleaner] ERROR: {e}")

        time.sleep(30)

if __name__ == "__main__":
    main()
