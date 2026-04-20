#!/usr/bin/env python3
"""Fetches market news, earnings calendar, and quotes from Finnhub + EODHD."""

import json
import requests
from datetime import datetime, timedelta
from pathlib import Path

FINNHUB_KEY = "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"
EODHD_KEY = "demo"
DIRECTIVES = Path.home() / ".openclaw" / "workspace" / "directives"
DIRECTIVES.mkdir(parents=True, exist_ok=True)

WATCHLIST = ["AAPL", "NVDA", "TSLA", "MU", "LLY"]

def fetch_news():
    try:
        r = requests.get(f"https://finnhub.io/api/v1/news?category=general&token={FINNHUB_KEY}", timeout=10)
        return r.json()[:20]
    except:
        return []

def fetch_earnings():
    today = datetime.utcnow().strftime("%Y-%m-%d")
    future = (datetime.utcnow() + timedelta(days=7)).strftime("%Y-%m-%d")
    try:
        r = requests.get(f"https://finnhub.io/api/v1/calendar/earnings?from={today}&to={future}&token={FINNHUB_KEY}", timeout=10)
        data = r.json()
        return data.get("earningsCalendar", [])[:50]
    except:
        return []

def fetch_quote_eodhd(sym):
    """Try EODHD first."""
    try:
        r = requests.get(f"https://eodhd.com/api/real-time/{sym}.US?api_token={EODHD_KEY}&fmt=json", timeout=10)
        d = r.json()
        if "close" in d and d["close"] not in [None, "NA", 0]:
            return {"price": d["close"], "change_p": d.get("change_p", 0), "volume": d.get("volume", "N/A"), "source": "EODHD"}
    except:
        pass
    return None

def fetch_quote_finnhub(sym):
    """Finnhub fallback."""
    try:
        r = requests.get(f"https://finnhub.io/api/v1/quote?symbol={sym}&token={FINNHUB_KEY}", timeout=10)
        d = r.json()
        if d.get("c") and d["c"] > 0:
            return {"price": d["c"], "change_p": d.get("dp", 0), "volume": d.get("v", "N/A"), "source": "Finnhub"}
    except:
        pass
    return None

def fetch_quotes():
    quotes = {}
    for sym in WATCHLIST:
        q = fetch_quote_eodhd(sym)
        if not q:
            q = fetch_quote_finnhub(sym)
        if not q:
            q = {"price": "N/A", "change_p": 0, "volume": "N/A", "source": "none"}
        quotes[sym] = q
    return quotes

def build_news_md(news):
    ts = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")
    lines = [f"# Market News\n", f"*Updated: {ts}*\n"]
    for n in news:
        t = datetime.fromtimestamp(n.get("datetime", 0)).strftime("%H:%M")
        lines.append(f"- **[{t}]** {n.get('headline', 'N/A')} ({n.get('source', '')})")
    return "\n".join(lines)

def build_earnings_md(earnings):
    ts = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")
    lines = [f"# Earnings Calendar (Next 7 Days)\n", f"*Updated: {ts}*\n"]
    by_date = {}
    for e in earnings:
        d = e.get("date", "unknown")
        by_date.setdefault(d, []).append(e)
    for date in sorted(by_date.keys()):
        lines.append(f"\n## {date}")
        for e in by_date[date]:
            sym = e.get("symbol", "?")
            hour = e.get("hour", "")
            est = e.get("epsEstimate")
            rev = e.get("revenueEstimate")
            est_str = f"EPS est: {est}" if est else "EPS est: N/A"
            rev_str = f"Rev est: {rev}" if rev else ""
            lines.append(f"- **{sym}** ({hour}) {est_str} {rev_str}")
    return "\n".join(lines)

def build_quotes_md(quotes):
    ts = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")
    lines = [f"# Watchlist Quotes\n", f"*Updated: {ts}*\n"]
    for sym, q in quotes.items():
        p = q["price"]
        chg = q["change_p"]
        vol = q["volume"]
        src = q["source"]
        if p == "N/A":
            lines.append(f"- **{sym}**: Unavailable")
        else:
            lines.append(f"- **{sym}**: ${p} ({chg:+.2f}%) vol: {vol} [{src}]")
    return "\n".join(lines)

if __name__ == "__main__":
    print(f"[{datetime.utcnow()}] Fetching market data...")

    news = fetch_news()
    (DIRECTIVES / "market_news.md").write_text(build_news_md(news))
    print(f"  News: {len(news)} articles")

    earnings = fetch_earnings()
    (DIRECTIVES / "earnings_calendar.md").write_text(build_earnings_md(earnings))
    print(f"  Earnings: {len(earnings)} upcoming")

    quotes = fetch_quotes()
    (DIRECTIVES / "watchlist_quotes.md").write_text(build_quotes_md(quotes))
    for sym, q in quotes.items():
        print(f"  {sym}: ${q['price']} [{q['source']}]")

    print("Done.")
