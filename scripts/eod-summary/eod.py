#!/usr/bin/env python3
"""End-of-day P&L summary for Boba + Jazzy.
Posts a Discord embed at 4:05 PM ET showing realized PnL, open positions, win rate.
"""
import os, sys, json, requests
from pathlib import Path
from datetime import datetime, timezone, timedelta
from zoneinfo import ZoneInfo

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
WEBHOOK = (SECRETS / "discord_webhook_autofix").read_text().strip()
ET = ZoneInfo("America/New_York")

def alpaca(account):
    k = (SECRETS / f"alpaca-{account}-key-id").read_text().strip()
    s = (SECRETS / f"alpaca-{account}-secret").read_text().strip()
    return {"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s}, "https://paper-api.alpaca.markets"

def fetch(account):
    h, base = alpaca(account)
    today = datetime.now(ET).strftime("%Y-%m-%dT00:00:00-05:00")
    acct = requests.get(f"{base}/v2/account", headers=h, timeout=10).json()
    pos = requests.get(f"{base}/v2/positions", headers=h, timeout=10).json()
    orders = requests.get(f"{base}/v2/orders?status=filled&after={today}&limit=100&direction=desc", headers=h, timeout=10).json()
    return acct, pos, orders

def fifo_pnl(orders):
    """Match buys/sells per symbol FIFO, return realized P&L list."""
    by_sym = {}
    for o in sorted(orders, key=lambda x: x.get("filled_at","")):
        s = o["symbol"]; by_sym.setdefault(s, {"buys": [], "sells": []})
        side = o["side"]; qty = float(o.get("filled_qty", 0)); px = float(o.get("filled_avg_price") or 0)
        if qty <= 0 or px <= 0: continue
        by_sym[s][f"{side}s"].append({"qty": qty, "px": px, "at": o.get("filled_at")})
    realized = []
    for sym, ob in by_sym.items():
        buys = [dict(b) for b in ob["buys"]]
        for sell in ob["sells"]:
            sell_qty = sell["qty"]
            while sell_qty > 0 and buys:
                b = buys[0]
                match = min(sell_qty, b["qty"])
                pnl = (sell["px"] - b["px"]) * match * (100 if "/" not in sym and len(sym) > 6 else 1)  # options multiplier
                realized.append({"sym": sym, "qty": match, "buy": b["px"], "sell": sell["px"], "pnl": pnl})
                b["qty"] -= match; sell_qty -= match
                if b["qty"] <= 0: buys.pop(0)
    return realized

def fmt_account(account):
    try:
        acct, pos, orders = fetch(account)
    except Exception as e:
        return None, f"Error: {e}"
    realized = fifo_pnl(orders)
    total_pnl = sum(r["pnl"] for r in realized)
    wins = [r for r in realized if r["pnl"] > 0]
    losses = [r for r in realized if r["pnl"] < 0]
    wr = (len(wins) / len(realized) * 100) if realized else 0
    biggest_win = max(realized, key=lambda r: r["pnl"]) if realized else None
    biggest_loss = min(realized, key=lambda r: r["pnl"]) if realized else None
    open_lines = []
    for p in pos:
        try:
            pnl_pct = float(p["unrealized_plpc"]) * 100
            open_lines.append(f"`{p['symbol']:<22}` {pnl_pct:+6.2f}% | ${float(p['unrealized_pl']):+.0f}")
        except: pass
    body = []
    body.append(f"**Equity**: ${float(acct.get('equity',0)):.2f}  ·  **Cash**: ${float(acct.get('cash',0)):.2f}")
    body.append(f"**Realized today**: ${total_pnl:+.2f} on {len(realized)} closed trades")
    body.append(f"**Win rate**: {wr:.0f}% ({len(wins)}W / {len(losses)}L)")
    if biggest_win: body.append(f"**Best**: {biggest_win['sym']} ${biggest_win['pnl']:+.2f}")
    if biggest_loss and biggest_loss['pnl'] < 0: body.append(f"**Worst**: {biggest_loss['sym']} ${biggest_loss['pnl']:+.2f}")
    if open_lines:
        body.append("")
        body.append(f"**Open positions** ({len(open_lines)}):")
        body.extend(open_lines[:10])
    return total_pnl, "\n".join(body)

def main():
    boba_pnl, boba_body = fmt_account("boba")
    jazzy_pnl, jazzy_body = fmt_account("jazzy")
    total = (boba_pnl or 0) + (jazzy_pnl or 0)
    color = 5763719 if total >= 0 else 15548997
    et_time = datetime.now(ET).strftime("%a %b %-d, %-I:%M %p ET")
    payload = {
        "username": "EOD Summary",
        "embeds": [{
            "author": {"name": f"Boba + Jazzy · End of Day · {et_time}"},
            "title": f"Combined: ${total:+.2f}",
            "color": color,
            "fields": [
                {"name": "🦙 Boba", "value": boba_body or "_no data_", "inline": False},
                {"name": "🎶 Jazzy", "value": jazzy_body or "_no data_", "inline": False},
            ],
            "timestamp": datetime.now(timezone.utc).isoformat(),
        }]
    }
    r = requests.post(WEBHOOK, json=payload, timeout=15)
    print(f"posted: HTTP {r.status_code}  combined=${total:+.2f}")

if __name__ == "__main__":
    main()
