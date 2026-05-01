#!/usr/bin/env python3
"""Reusable R1 order/position verification. Run anytime to check daemon health."""
import requests, sys
from pathlib import Path
from datetime import datetime, timezone, timedelta

SECRETS = Path.home() / ".openclaw" / "secrets"
KEY = (SECRETS / "alpaca-r1-key-id").read_text().strip()
SEC = (SECRETS / "alpaca-r1-secret").read_text().strip()
BASE = "https://paper-api.alpaca.markets/v2"
H = {"APCA-API-KEY-ID": KEY, "APCA-API-SECRET-KEY": SEC}

def safe_get(url):
    """Returns list/dict or None if API errored."""
    try:
        r = requests.get(url, headers=H, timeout=10)
        if r.status_code != 200:
            print(f"  ⚠ {url.split('?')[0].split('/')[-1]}: HTTP {r.status_code} — {r.text[:120]}")
            return None
        return r.json()
    except Exception as e:
        print(f"  ⚠ {url}: {e}")
        return None

print("=== R1 verification ===\n")

acct = safe_get(f"{BASE}/account")
if acct:
    print(f"Account: {acct.get('account_number')}  Equity: ${float(acct.get('equity',0)):,.0f}  Cash: ${float(acct.get('cash',0)):,.0f}\n")

print("--- Open positions ---")
positions = safe_get(f"{BASE}/positions") or []
for p in positions:
    print(f"  {p['symbol']:30} qty={p['qty']:>4} avg=${float(p['avg_entry_price']):>8.2f} now=${float(p['current_price']):>8.2f} pnl={float(p['unrealized_plpc'])*100:+6.1f}%")
print(f"  Total: {len(positions)}\n")

print("--- Open orders ---")
orders = safe_get(f"{BASE}/orders?status=open&limit=50") or []
if not isinstance(orders, list):
    orders = []
for o in orders:
    print(f"  [{o['submitted_at'][:19]}] {o['symbol']:30} {o['side']} {o['type']:12} qty={o['qty']} stop={o.get('stop_price') or '-'} limit={o.get('limit_price') or '-'} status={o['status']}")
if not orders: print("  (none)")
print()

print("--- Closed/filled orders in last 24h ---")
cutoff = (datetime.now(timezone.utc) - timedelta(hours=24)).strftime("%Y-%m-%dT%H:%M:%SZ")
closed = safe_get(f"{BASE}/orders?status=closed&limit=30&after={cutoff}")
# THE FIX: validate type before iterating
if isinstance(closed, list) and closed:
    for o in closed:
        if not isinstance(o, dict): continue
        fap = o.get('filled_avg_price') or '-'
        fq = o.get('filled_qty', '0')
        fa = (o.get('filled_at') or '')[:19] or '-'
        print(f"  [{o.get('submitted_at','')[:19]}] {o.get('symbol','?'):30} {o.get('side','?')} {o.get('type','?'):12} qty={o.get('qty','?')} filled={fq}@${fap} status={o.get('status','?')} filled_at={fa}")
elif isinstance(closed, dict):
    print(f"  ⚠ API returned dict instead of list: {closed}")
else:
    print("  (none in last 24h)")
