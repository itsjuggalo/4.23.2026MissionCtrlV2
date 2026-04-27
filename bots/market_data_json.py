#!/usr/bin/env python3
"""Saves market data as JSON for the dashboard."""
import json, requests
from datetime import datetime, timedelta
from pathlib import Path

FKEY = "d7n38hpr01qppri3d580d7n38hpr01qppri3d58g"
EODHD = "demo"
OUT = Path.home() / ".openclaw" / "workspace" / "directives"
OUT.mkdir(parents=True, exist_ok=True)
WATCHLIST = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]

def fget(path, params={}):
    params["token"] = FKEY
    try:
        r = requests.get(f"https://finnhub.io/api/v1/{path}", params=params, timeout=10)
        return r.json()
    except:
        return None

def get_quote(sym):
    try:
        r = requests.get(f"https://eodhd.com/api/real-time/{sym}.US?api_token={EODHD}&fmt=json", timeout=10)
        d = r.json()
        if d.get("close") and d["close"] not in [None, "NA", 0]:
            return {"price": d["close"], "change_p": d.get("change_p", 0), "volume": d.get("volume", 0), "source": "EODHD"}
    except: pass
    try:
        r = requests.get(f"https://finnhub.io/api/v1/quote?symbol={sym}&token={FKEY}", timeout=10)
        d = r.json()
        if d.get("c") and d["c"] > 0:
            return {"price": d["c"], "change_p": d.get("dp", 0), "volume": d.get("v", 0), "source": "Finnhub"}
    except: pass
    return None

data = {"updated": datetime.utcnow().isoformat(), "news": [], "quotes": {}, "intel": {}}

# News with URLs
news_raw = fget("news", {"category": "general"})
if isinstance(news_raw, list):
    for n in news_raw[:15]:
        data["news"].append({
            "time": datetime.fromtimestamp(n.get("datetime", 0)).strftime("%H:%M"),
            "headline": n.get("headline", ""),
            "source": n.get("source", ""),
            "url": n.get("url", ""),
        })

# Quotes
for sym in WATCHLIST:
    q = get_quote(sym)
    if q: data["quotes"][sym] = q

# Per-stock intel
today = datetime.utcnow().strftime("%Y-%m-%d")
for sym in WATCHLIST:
    info = {"symbol": sym}
    
    # Recommendations
    recs = fget("stock/recommendation", {"symbol": sym})
    if recs and len(recs) > 0:
        r = recs[0]
        total = r.get("strongBuy",0)+r.get("buy",0)+r.get("hold",0)+r.get("sell",0)+r.get("strongSell",0)
        buy_pct = round((r.get("strongBuy",0)+r.get("buy",0)) / max(total,1) * 100)
        info["analyst"] = {"strongBuy": r["strongBuy"], "buy": r["buy"], "hold": r["hold"], "sell": r["sell"], "strongSell": r["strongSell"], "total": total, "buyPct": buy_pct}

    # Latest earnings
    earnings = fget("stock/earnings", {"symbol": sym, "limit": 1})
    if earnings and len(earnings) > 0:
        e = earnings[0]
        info["earnings"] = {"actual": e.get("actual"), "estimate": e.get("estimate"), "surprisePct": round(e.get("surprisePercent", 0), 1), "period": e.get("period", ""), "beat": (e.get("surprisePercent", 0) or 0) > 0}

    # Insider sentiment
    sent = fget("stock/insider-sentiment", {"symbol": sym, "from": "2026-01-01", "to": "2026-12-31"})
    if sent and "data" in sent and len(sent["data"]) > 0:
        latest = sent["data"][-1]
        info["insider"] = {"mspr": round(latest.get("mspr", 0), 1), "netShares": latest.get("change", 0), "direction": "BUYING" if latest.get("mspr", 0) > 0 else "SELLING"}

    # Key metrics
    metrics = fget("stock/metric", {"symbol": sym, "metric": "all"})
    if metrics and "metric" in metrics:
        m = metrics["metric"]
        info["metrics"] = {"pe": m.get("peBasicExclExtraTTM"), "high52": m.get("52WeekHigh"), "low52": m.get("52WeekLow"), "beta": m.get("beta")}

    # Company news (top 3 with URLs)
    week_ago = (datetime.utcnow() - timedelta(days=3)).strftime("%Y-%m-%d")
    cnews = fget("company-news", {"symbol": sym, "from": week_ago, "to": today})
    if cnews and isinstance(cnews, list):
        info["news"] = [{"headline": n.get("headline",""), "source": n.get("source",""), "url": n.get("url",""), "time": datetime.fromtimestamp(n.get("datetime",0)).strftime("%m/%d %H:%M")} for n in cnews[:3]]

    data["intel"][sym] = info

(OUT / "dashboard_data.json").write_text(json.dumps(data, indent=2))
print(f"[{datetime.utcnow()}] Dashboard JSON saved. {len(data['news'])} news, {len(data['quotes'])} quotes, {len(data['intel'])} stocks")
