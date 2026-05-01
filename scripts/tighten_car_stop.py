#!/usr/bin/env python3
"""
One-shot: tighten CAR $300P 5/15 stop to lock in % of current gain.
Usage: python3 tighten_car_stop.py [--lock-pct 15]
  --lock-pct 15 = stop at entry+15% (default; locks in ~$13/contract on $86.50 entry)
  --lock-pct 20 = tighter, stop at entry+20%
  --lock-pct 0  = breakeven (matches PROTECT_ENTRY phase)
Cancels existing CAR stop_limit and places new one.
"""
import argparse, requests, sys
from pathlib import Path

SECRETS = Path.home() / ".openclaw" / "secrets"
KEY = (SECRETS / "alpaca-r1-key-id").read_text().strip()
SEC = (SECRETS / "alpaca-r1-secret").read_text().strip()
BASE = "https://paper-api.alpaca.markets/v2"
H = {"APCA-API-KEY-ID": KEY, "APCA-API-SECRET-KEY": SEC}
SYMBOL = "CAR260515P00300000"

ap = argparse.ArgumentParser()
ap.add_argument("--lock-pct", type=float, default=15.0, help="Lock-in pct above entry (default 15)")
ap.add_argument("--dry-run", action="store_true")
args = ap.parse_args()

# Account check
acct = requests.get(f"{BASE}/account", headers=H, timeout=10).json()
assert acct.get("account_number") == "PA3Y7UTNIQFZ", f"Wrong account: {acct.get('account_number')}"
print(f"✓ R1 account confirmed")

# Find position
positions = requests.get(f"{BASE}/positions", headers=H, timeout=10).json()
pos = next((p for p in positions if p["symbol"] == SYMBOL), None)
if not pos:
    print(f"✗ No open position for {SYMBOL}"); sys.exit(1)
entry = float(pos["avg_entry_price"])
qty = int(pos["qty"])
current = float(pos["current_price"])
pnl_pct = float(pos["unrealized_plpc"]) * 100
print(f"Position: qty={qty} entry=${entry:.2f} current=${current:.2f} pnl={pnl_pct:+.1f}%")

# Compute new stop
new_stop = round(entry * (1 + args.lock_pct/100), 2)
new_limit = round(new_stop * 0.90, 2)  # 10% below stop for limit
print(f"New stop: ${new_stop:.2f} (entry +{args.lock_pct:.0f}%) | limit: ${new_limit:.2f}")

if new_stop > current:
    print(f"⚠ New stop ${new_stop} >= current ${current} — would trigger immediately. Aborting.")
    sys.exit(2)

# Cancel existing sell orders on this symbol
orders = requests.get(f"{BASE}/orders?status=open&symbols={SYMBOL}", headers=H, timeout=10).json()
to_cancel = [o for o in orders if o["side"] == "sell"]
for o in to_cancel:
    print(f"Cancelling old order {o['id'][:8]} stop=${o.get('stop_price')} limit=${o.get('limit_price')}")
    if not args.dry_run:
        requests.delete(f"{BASE}/orders/{o['id']}", headers=H, timeout=10)

# Place new stop_limit
payload = {
    "symbol": SYMBOL, "qty": str(qty), "side": "sell", "type": "stop_limit",
    "time_in_force": "gtc", "stop_price": str(new_stop), "limit_price": str(new_limit)
}
if args.dry_run:
    print(f"DRY-RUN would place: {payload}"); sys.exit(0)
r = requests.post(f"{BASE}/orders", headers=H, json=payload, timeout=10)
print(f"Place result: HTTP {r.status_code}")
print(r.json() if r.status_code < 300 else r.text)
