#!/usr/bin/env python3
"""
alpaca_fill_listener — websocket subscriber to Alpaca trade_updates stream.

When a sell fill arrives, immediately scans for sibling sell orders on the same symbol
whose quantity now exceeds remaining position quantity. Cancels them.

This is Layer 2 of the 3-layer protection scheme:
- Layer 1 (zero latency): pre-flight cleanup before placing buy orders
- Layer 2 (this): websocket-driven cancel within ~1s of any fill event
- Layer 3 (fallback): profit_lock_daemon cleanup_orphans every 60s

Manages BOTH R2 (Boba) and JazzyHazzy accounts via two parallel websocket connections.
"""
import json, asyncio, time, sys
from datetime import datetime, timezone
from pathlib import Path

try:
    import websockets
except ImportError:
    print("FATAL: pip install websockets --break-system-packages")
    sys.exit(1)
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
LOG_FILE = Path.home() / ".openclaw" / "workspace" / "memory" / "alpaca_fill_listener.jsonl"
LOG_FILE.parent.mkdir(parents=True, exist_ok=True)

WS_URL = "wss://paper-api.alpaca.markets/stream"
ALPACA_BASE = "https://paper-api.alpaca.markets/v2"

def _read(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""

ACCOUNTS = [
    {"name": "R2-Boba", "expected": "PA3R6MOPBWF7",
     "key": _read("alpaca-key-id"), "sec": _read("alpaca-secret")},
    {"name": "JazzyHazzy", "expected": "PA38IUKNR237",
     "key": _read("alpaca-jazzy-key-id"), "sec": _read("alpaca-jazzy-secret")},
]

def log(account, action, detail):
    entry = {"ts": datetime.now(timezone.utc).isoformat(),
             "account": account, "action": action, "detail": detail}
    with LOG_FILE.open("a") as f:
        f.write(json.dumps(entry) + "\n")
    print(f"[{account}] {action}: {str(detail)[:300]}", flush=True)

def is_option_symbol(sym):
    if not sym or len(sym) < 15: return False
    return any(c.isdigit() for c in sym[-15:]) and (sym[-9] in ("C","P"))

def cleanup_siblings(account_name, key, sec, filled_symbol, filled_order_id):
    """After a sell fill, cancel any other sell orders on the same symbol whose qty exceeds remaining position."""
    H = {"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec}
    try:
        # Get current position qty
        pr = requests.get(f"{ALPACA_BASE}/positions/{filled_symbol}", headers=H, timeout=10)
        if pr.status_code == 404:
            cur_qty = 0
        elif pr.status_code == 200:
            cur_qty = int(float(pr.json().get("qty", 0)))
        else:
            log(account_name, "sibling_check_fail", f"position GET HTTP {pr.status_code}")
            return
        # Get all open sell orders on this symbol
        orders_r = requests.get(f"{ALPACA_BASE}/orders?status=open&symbols={filled_symbol}&limit=100",
            headers=H, timeout=10)
        if orders_r.status_code != 200:
            log(account_name, "sibling_check_fail", f"orders GET HTTP {orders_r.status_code}")
            return
        siblings = [o for o in orders_r.json()
                    if o.get("symbol") == filled_symbol
                    and o.get("side") == "sell"
                    and o.get("id") != filled_order_id]
        if not siblings:
            return
        total_open = sum(int(float(o.get("qty", 0))) for o in siblings)
        # If holding 0, all siblings are orphans. If holding some but total_open > cur_qty, cancel oldest until in-line.
        cancelled_ids = []
        if cur_qty == 0:
            for o in siblings:
                cr = requests.delete(f"{ALPACA_BASE}/orders/{o.get('id')}", headers=H, timeout=10)
                if cr.status_code in (200, 204, 207):
                    cancelled_ids.append(o.get('id','')[:8])
        elif total_open > cur_qty:
            sorted_sibs = sorted(siblings, key=lambda o: o.get("created_at",""))
            excess = total_open - cur_qty
            for o in sorted_sibs:
                if excess <= 0: break
                oq = int(float(o.get("qty", 0)))
                cr = requests.delete(f"{ALPACA_BASE}/orders/{o.get('id')}", headers=H, timeout=10)
                if cr.status_code in (200, 204, 207):
                    cancelled_ids.append(o.get('id','')[:8])
                    excess -= oq
        if cancelled_ids:
            log(account_name, "sibling_cancelled",
                f"{filled_symbol} cur_qty={cur_qty} cancelled {len(cancelled_ids)} sibling(s): {','.join(cancelled_ids)}")
    except Exception as e:
        log(account_name, "sibling_check_error", str(e)[:200])

async def listen(acct):
    """Maintain a single websocket connection for one account, reconnecting on drop."""
    name = acct["name"]
    expected = acct["expected"]
    key = acct["key"]
    sec = acct["sec"]
    if not key or not sec:
        log(name, "fatal", "missing credentials")
        return
    backoff = 1
    while True:
        try:
            log(name, "connect", f"connecting to {WS_URL}")
            async with websockets.connect(WS_URL, ping_interval=20, ping_timeout=20) as ws:
                # Auth
                await ws.send(json.dumps({"action": "auth", "key": key, "secret": sec}))
                auth_resp = json.loads(await asyncio.wait_for(ws.recv(), timeout=15))
                if auth_resp.get("data", {}).get("status") != "authorized":
                    log(name, "auth_fail", str(auth_resp)[:200])
                    await asyncio.sleep(30)
                    continue
                # Subscribe to trade_updates
                await ws.send(json.dumps({"action": "listen", "data": {"streams": ["trade_updates"]}}))
                listen_resp = json.loads(await asyncio.wait_for(ws.recv(), timeout=15))
                log(name, "subscribed", f"trade_updates listening — {listen_resp.get('data',{})}")
                backoff = 1  # reset on successful connect

                async for raw in ws:
                    try:
                        msg = json.loads(raw)
                        if msg.get("stream") != "trade_updates":
                            continue
                        data = msg.get("data", {})
                        event = data.get("event", "")
                        order = data.get("order", {})
                        sym = order.get("symbol", "")
                        side = order.get("side", "")
                        oid = order.get("id", "")
                        # We only care about SELL fills on options
                        if event in ("fill", "partial_fill") and side == "sell" and is_option_symbol(sym):
                            log(name, "sell_fill", f"{sym} order={oid[:8]} event={event} qty={order.get('filled_qty')} price={order.get('filled_avg_price')}")
                            # Trigger sibling cleanup in a thread so we don't block the websocket loop
                            await asyncio.get_event_loop().run_in_executor(
                                None, cleanup_siblings, name, key, sec, sym, oid)
                    except Exception as inner_e:
                        log(name, "msg_parse_error", str(inner_e)[:200])
        except Exception as e:
            log(name, "ws_dropped", f"{type(e).__name__}: {str(e)[:200]} — reconnecting in {backoff}s")
            await asyncio.sleep(backoff)
            backoff = min(backoff * 2, 60)

async def main():
    log("listener", "startup", f"alpaca_fill_listener online, monitoring {len(ACCOUNTS)} accounts")
    await asyncio.gather(*[listen(a) for a in ACCOUNTS])

if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        pass
