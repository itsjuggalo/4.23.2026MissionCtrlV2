#!/usr/bin/env python3
"""
Congress Trading Scraper - Pulls politician trades from AInvest API per ticker.
Saves to ~/mission-control-restored/data/congress_trades.json
Cron: 0 */6 * * * python3 ~/mission-control-restored/bots/congress_scraper.py
"""
import json, os, time, requests
from datetime import datetime
from pathlib import Path

DATA_DIR = Path.home() / "mission-control-restored" / "data"
DATA_DIR.mkdir(parents=True, exist_ok=True)
OUTPUT = DATA_DIR / "congress_trades.json"
SECRETS = Path.home() / ".openclaw" / "secrets"
KEY = (SECRETS / "ainvest_api_key").read_text().strip() if (SECRETS / "ainvest_api_key").exists() else None

WATCHLIST = [
    "NVDA","AAPL","MSFT","GOOGL","AMZN","META","TSLA","AMD","AVGO","PLTR",
    "MU","INTC","CRM","ORCL","NFLX","DIS","JPM","BAC","GS","V",
    "MA","UNH","LLY","JNJ","PFE","ABBV","XOM","CVX","KO","PEP",
    "HD","COST","WMT","T","VZ","BA","CAT","GE","RTX","LMT",
    "COIN","MARA","RIOT","VST","CEG","CRWD","SNOW","NET","SQ","SOFI"
]

def fetch_congress(ticker):
    if not KEY: return []
    try:
        r = requests.get("https://openapi.ainvest.com/open/ownership/congress",
            params={"ticker": ticker}, headers={"Authorization": f"Bearer {KEY}"}, timeout=15)
        if r.status_code == 200:
            j = r.json()
            d = j.get("data")
            if isinstance(d, dict):
                trades = d.get("data", [])
                for t in trades: t["ticker"] = ticker
                return trades
    except Exception as e:
        print(f"  [congress] {ticker} error: {e}")
    return []

def classify_suspicious(trade):
    gap = trade.get("reporting_gap", "")
    try:
        days = int(''.join(c for c in gap if c.isdigit()))
        if days <= 15: return "Short-Term Event Window"
    except: pass
    size = trade.get("size", "")
    if any(s in size for s in ["$250K","$500K","$1M","$5M","$15M","$25M","$50M"]):
        return "Large Position"
    return None

def main():
    print(f"[congress] Starting scrape — {datetime.now().isoformat()}")
    if not KEY:
        print("[congress] ERROR: No AInvest API key"); return

    all_trades = []
    for i, ticker in enumerate(WATCHLIST):
        trades = fetch_congress(ticker)
        if trades:
            print(f"  [{i+1}/{len(WATCHLIST)}] {ticker}: {len(trades)} trades")
            all_trades.extend(trades)
        else:
            print(f"  [{i+1}/{len(WATCHLIST)}] {ticker}: 0")
        time.sleep(0.4)

    seen = set()
    unique = []
    for t in all_trades:
        if t.get("id") not in seen:
            seen.add(t.get("id"))
            t["suspicious"] = classify_suspicious(t)
            unique.append(t)

    unique.sort(key=lambda x: x.get("filing_date", ""), reverse=True)

    politicians = {}
    for t in unique:
        name = t.get("name", "")
        if name not in politicians:
            politicians[name] = {"name": name, "party": t.get("party",""), "state": t.get("state",""), "trades": 0, "buys": 0, "sells": 0, "tickers": set()}
        politicians[name]["trades"] += 1
        if t.get("trade_type") == "buy": politicians[name]["buys"] += 1
        else: politicians[name]["sells"] += 1
        politicians[name]["tickers"].add(t.get("ticker",""))

    for p in politicians.values():
        p["tickers"] = sorted(list(p["tickers"]))

    suspicious = [t for t in unique if t.get("suspicious")]

    output = {
        "last_updated": datetime.now().isoformat(),
        "total_trades": len(unique),
        "tickers_scanned": len(WATCHLIST),
        "politicians": sorted(politicians.values(), key=lambda x: x["trades"], reverse=True),
        "suspicious": suspicious[:20],
        "trades": unique
    }

    with open(OUTPUT, "w") as f:
        json.dump(output, f, indent=2)

    print(f"[congress] DONE — {len(unique)} trades, {len(politicians)} politicians -> {OUTPUT}")

if __name__ == "__main__":
    main()
