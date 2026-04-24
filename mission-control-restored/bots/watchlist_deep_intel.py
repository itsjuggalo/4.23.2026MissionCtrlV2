#!/usr/bin/env python3
"""Deep intel on watchlist stocks from Finnhub free endpoints."""

import json
import requests
from datetime import datetime
from pathlib import Path

FKEY = "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"
DIRECTIVES = Path.home() / ".openclaw" / "workspace" / "directives"
DIRECTIVES.mkdir(parents=True, exist_ok=True)
WATCHLIST = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]

def fget(path, params={}):
    params["token"] = FKEY
    try:
        r = requests.get(f"https://finnhub.io/api/v1/{path}", params=params, timeout=10)
        return r.json()
    except:
        return None

def build_intel():
    ts = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")
    lines = [f"# Watchlist Deep Intel\n", f"*Updated: {ts}*\n"]

    for sym in WATCHLIST:
        lines.append(f"\n---\n## {sym}\n")

        # Recommendations
        recs = fget("stock/recommendation", {"symbol": sym})
        if recs and len(recs) > 0:
            r = recs[0]
            total = r.get("strongBuy",0)+r.get("buy",0)+r.get("hold",0)+r.get("sell",0)+r.get("strongSell",0)
            lines.append(f"**Analyst Consensus ({r.get('period','')}):** {r.get('strongBuy',0)} Strong Buy, {r.get('buy',0)} Buy, {r.get('hold',0)} Hold, {r.get('sell',0)} Sell, {r.get('strongSell',0)} Strong Sell (n={total})")

        # Earnings surprises
        earnings = fget("stock/earnings", {"symbol": sym, "limit": 2})
        if earnings and len(earnings) > 0:
            for e in earnings:
                actual = e.get("actual", "N/A")
                est = e.get("estimate", "N/A")
                surp = e.get("surprisePercent", 0)
                period = e.get("period", "?")
                beat = "BEAT" if surp and surp > 0 else "MISS"
                lines.append(f"**Earnings {period}:** ${actual} vs ${est} est ({beat} {surp:+.1f}%)")

        # Insider sentiment
        sent = fget("stock/insider-sentiment", {"symbol": sym, "from": "2026-01-01", "to": "2026-12-31"})
        if sent and "data" in sent and len(sent["data"]) > 0:
            latest = sent["data"][-1]
            mspr = latest.get("mspr", 0)
            chg = latest.get("change", 0)
            direction = "BUYING" if mspr > 0 else "SELLING"
            lines.append(f"**Insider Sentiment:** {direction} (MSPR: {mspr:.1f}, net shares: {chg:+,})")

        # Key metrics
        metrics = fget("stock/metric", {"symbol": sym, "metric": "all"})
        if metrics and "metric" in metrics:
            m = metrics["metric"]
            pe = m.get("peBasicExclExtraTTM", "N/A")
            hi52 = m.get("52WeekHigh", "N/A")
            lo52 = m.get("52WeekLow", "N/A")
            beta = m.get("beta", "N/A")
            div_yield = m.get("currentDividendYieldTTM", "N/A")
            lines.append(f"**Key Metrics:** P/E: {pe}, 52W: ${lo52}-${hi52}, Beta: {beta}, Div Yield: {div_yield}%")

        # Recent insider transactions
        insider = fget("stock/insider-transactions", {"symbol": sym})
        if insider and "data" in insider and len(insider["data"]) > 0:
            recent = [t for t in insider["data"] if not t.get("isDerivative", False)][:3]
            if recent:
                lines.append("**Recent Insider Trades:**")
                for t in recent:
                    name = t.get("name", "Unknown")
                    chg = t.get("change", 0)
                    date = t.get("transactionDate", "?")
                    price = t.get("transactionPrice", 0)
                    action = "BOUGHT" if chg > 0 else "SOLD"
                    lines.append(f"  - {name} {action} {abs(chg):,} shares @ ${price} ({date})")

    return "\n".join(lines)

if __name__ == "__main__":
    print(f"[{datetime.utcnow()}] Building deep intel...")
    report = build_intel()
    (DIRECTIVES / "watchlist_deep_intel.md").write_text(report)
    print(f"Done. Saved to directives/watchlist_deep_intel.md")
