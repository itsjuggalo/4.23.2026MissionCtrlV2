#!/usr/bin/env python3
"""
Daily Portfolio Snapshot — saves equity, positions, regime to SQLite
Run via cron: 0 16 * * 1-5  (market close, weekdays)
"""
import json
import urllib.request

MC_URL = "http://localhost:3033"

def fetch(endpoint):
    try:
        req = urllib.request.Request(f"{MC_URL}{endpoint}")
        with urllib.request.urlopen(req, timeout=10) as r:
            return json.loads(r.read())
    except Exception as e:
        print(f"  Error fetching {endpoint}: {e}")
        return None

def main():
    print("[snapshot] Fetching portfolio...")
    portfolio = fetch("/api/portfolio")
    regime = fetch("/api/regime")
    crypto = fetch("/api/crypto")

    if not portfolio:
        print("[snapshot] No portfolio data, skipping")
        return

    equity = float(portfolio.get("equity", 0) or portfolio.get("balance", 0))
    last_eq = float(portfolio.get("last_equity", 0))
    cash = float(portfolio.get("cash", 0))
    bp = float(portfolio.get("buying_power", 0))
    daily_pnl = equity - last_eq
    daily_pct = (daily_pnl / last_eq * 100) if last_eq else 0
    total_return = ((equity - 100000) / 100000 * 100)

    btc_price = 0
    if crypto and "bitcoin" in crypto:
        btc_price = crypto.get("bitcoin", {}).get("usd", 0) if crypto else 0

    snapshot = {
        "equity": equity,
        "cash": cash,
        "buying_power": bp,
        "daily_pnl": daily_pnl,
        "daily_pnl_pct": daily_pct,
        "total_return_pct": total_return,
        "positions": portfolio.get("positions", []),
        "btc_price": btc_price,
        "regime": regime.get("overall_regime", "") if regime else "",
        "bias": regime.get("direction_bias", "") if regime else "",
    }

    # POST to the equity history API
    data = json.dumps(snapshot).encode()
    req = urllib.request.Request(
        f"{MC_URL}/api/equity-history",
        data=data,
        headers={"Content-Type": "application/json"},
        method="POST"
    )
    try:
        with urllib.request.urlopen(req, timeout=10) as r:
            result = json.loads(r.read())
            print(f"[snapshot] Saved: equity=${equity:.2f}, return={total_return:.1f}%, btc=${btc_price:.0f}")
    except Exception as e:
        print(f"[snapshot] Save error: {e}")

if __name__ == "__main__":
    main()
