#!/usr/bin/env python3
"""Watch NVDA price and ping Mike when it crosses $227.50 (ITM for NVDA260603C00227500)."""
import json, time, urllib.request, sys
from datetime import datetime, timezone
from pathlib import Path

SEC      = Path.home() / ".openclaw" / "secrets"
DATA_API = "https://data.alpaca.markets"
STRIKE   = 227.50
OCC      = "NVDA260603C00227500"
INTERVAL = 30  # seconds between checks

def hdrs():
    return {"APCA-API-KEY-ID":     (SEC/"alpaca-boba-key-id").read_text().strip(),
            "APCA-API-SECRET-KEY": (SEC/"alpaca-boba-secret").read_text().strip()}

def get_nvda_mid():
    try:
        r = json.loads(urllib.request.urlopen(
            urllib.request.Request(DATA_API+"/v2/stocks/NVDA/quotes/latest", headers=hdrs()),
            timeout=8).read())
        q = r.get("quote",{})
        bid, ask = float(q.get("bp",0)), float(q.get("ap",0))
        return (bid+ask)/2 if ask else None
    except: return None

def get_opt_mid():
    try:
        r = json.loads(urllib.request.urlopen(
            urllib.request.Request(DATA_API+"/v1beta1/options/quotes/latest?symbols="+OCC, headers=hdrs()),
            timeout=8).read())
        q = r.get("quotes",{}).get(OCC,{})
        bid, ask = float(q.get("bp",0) or 0), float(q.get("ap",0) or 0)
        return (bid+ask)/2 if ask else None
    except: return None

def ping(msg):
    try:
        import subprocess
        subprocess.run(["python3", str(Path.home()/"scripts/ping_mike.py"), msg], timeout=10)
    except Exception as e:
        print("PING FAILED:", e)

def market_open():
    n = datetime.now(timezone.utc)
    if n.weekday() >= 5: return False
    h, m = (n.hour - 4) % 24, n.minute
    return (9,30) <= (h,m) < (16,0)

print(f"[nvda-watch] Monitoring NVDA vs ${STRIKE} strike — will ping on ITM cross", flush=True)

crossed    = False
last_price = None

while True:
    now_utc = datetime.now(timezone.utc)
    et_hour  = (now_utc.hour - 4) % 24

    if not market_open():
        print(f"[nvda-watch] Market closed — exiting", flush=True)
        sys.exit(0)

    price = get_nvda_mid()
    opt   = get_opt_mid()

    if price is None:
        print(f"[nvda-watch] No quote — retrying in {INTERVAL}s", flush=True)
        time.sleep(INTERVAL)
        continue

    status = "ITM" if price > STRIKE else "OTM"
    diff   = price - STRIKE
    opt_str = f"  opt_mid=${opt:.2f}" if opt else ""
    print(f"[nvda-watch] NVDA=${price:.2f}  strike=${STRIKE}  {status} ({diff:+.2f}){opt_str}", flush=True)

    if price >= STRIKE and not crossed:
        crossed = True
        opt_str2 = f" | option mid=${opt:.2f}" if opt else ""
        msg = (f"NVDA CALL ITM — NVDA=${price:.2f} crossed $227.50 strike "
               f"(+${price-STRIKE:.2f}){opt_str2} | NVDA260603C00227500 exp tomorrow")
        print(f"[nvda-watch] *** CROSSED ITM — pinging Mike ***", flush=True)
        ping(msg)
        # keep watching for further moves, re-ping if it drops back OTM then recrosses
    elif price < STRIKE and crossed:
        crossed = False  # reset so we ping again if it recrosses
        print(f"[nvda-watch] Dropped back OTM — watching for recross", flush=True)

    last_price = price
    time.sleep(INTERVAL)
