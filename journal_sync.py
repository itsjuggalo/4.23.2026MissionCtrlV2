#!/usr/bin/env python3
"""journal_sync.py — populate missionctrl's Trade Journal from REAL Alpaca fills.

The journal page was empty because trade_journal only logged trades placed through
the dashboard's order routes — but trading happens via Alpaca/daemons. This pulls
actual FILL activities (Boba+Jazzy) and inserts them so the page shows real history.

Safe concurrent write to the live dashboard DB (WAL + busy_timeout). Dedupes by the
Alpaca activity id (stored in client_order_id, principal='alpaca-sync').
"""
import json
import sqlite3
import sys
import urllib.request
from datetime import datetime
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib.portfolio import _rd  # noqa: E402

DB = Path.home() / "web" / "missionctrl" / "data" / "dashboard_history.sqlite"
ACCTS = {"boba": ("alpaca-boba-key-id", "alpaca-boba-secret"),
         "jazzy": ("alpaca-jazzy-key-id", "alpaca-jazzy-secret")}

INS = """INSERT INTO trade_journal
 (ts,account,action,status,symbol,side,qty,entry_type,sl_price,tp_price,sl_pct,tp_pct,
  ref_price,notional_usd,client_order_id,alpaca_order_id,guard_failed,request_json,
  response_json,principal)
 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"""


def fills(k, s):
    url = "https://paper-api.alpaca.markets/v2/account/activities/FILL?page_size=100"
    req = urllib.request.Request(url, headers={
        "APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s, "User-Agent": "mc-journal/1.0"})
    with urllib.request.urlopen(req, timeout=20) as r:
        return json.loads(r.read())


def main():
    if not DB.exists():
        print(f"[journal-sync] DB missing: {DB}")
        return
    con = sqlite3.connect(str(DB), timeout=15)
    con.execute("PRAGMA busy_timeout=8000")
    con.execute("PRAGMA journal_mode=WAL")
    seen = {r[0] for r in con.execute(
        "SELECT client_order_id FROM trade_journal "
        "WHERE principal='alpaca-sync' AND client_order_id IS NOT NULL")}
    added = 0
    for acct, (kid, ksec) in ACCTS.items():
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acts = fills(k, s)
        except Exception as e:  # noqa: BLE001
            print(f"[journal-sync] {acct} fetch error: {e}")
            continue
        for a in acts:
            aid = a.get("id")
            if not aid or aid in seen:
                continue
            try:
                px = float(a.get("price", 0) or 0)
                qty = int(float(a.get("qty", 0) or 0))
                ts = int(datetime.fromisoformat(
                    a["transaction_time"].replace("Z", "+00:00")).timestamp() * 1000)
            except Exception:
                continue
            con.execute(INS, (ts, acct, "order", "submitted", a.get("symbol", "?"),
                              a.get("side"), qty, "market", None, None, None, None,
                              px, px * qty, aid, a.get("order_id"), None,
                              json.dumps({"src": "alpaca_fill", "activity": a}), None,
                              "alpaca-sync"))
            seen.add(aid)
            added += 1
    con.commit()
    con.close()
    print(f"[journal-sync] added {added} fills")


if __name__ == "__main__":
    main()
