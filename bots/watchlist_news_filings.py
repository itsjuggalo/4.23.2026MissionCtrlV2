#!/usr/bin/env python3
"""Per-symbol news and SEC filings for watchlist stocks."""

import requests
from datetime import datetime, timedelta
from pathlib import Path

FKEY = "d7n38hpr01qppri3d580d7n38hpr01qppri3d58g"
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

def build_report():
    ts = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")
    today = datetime.utcnow().strftime("%Y-%m-%d")
    week_ago = (datetime.utcnow() - timedelta(days=3)).strftime("%Y-%m-%d")
    lines = [f"# Watchlist News & Filings\n", f"*Updated: {ts}*\n"]

    for sym in WATCHLIST:
        lines.append(f"\n---\n## {sym}\n")

        # Company-specific news (last 3 days)
        news = fget("company-news", {"symbol": sym, "from": week_ago, "to": today})
        if news and isinstance(news, list) and len(news) > 0:
            lines.append("**Recent News:**")
            for n in news[:5]:
                t = datetime.fromtimestamp(n.get("datetime", 0)).strftime("%m/%d %H:%M")
                headline = n.get("headline", "N/A")
                source = n.get("source", "")
                lines.append(f"  - [{t}] {headline} ({source})")
        else:
            lines.append("**Recent News:** None in last 3 days")

        # SEC Filings (recent)
        filings = fget("stock/filings", {"symbol": sym})
        if filings and isinstance(filings, list) and len(filings) > 0:
            recent = filings[:3]
            lines.append("**Recent SEC Filings:**")
            for f in recent:
                form = f.get("form", "?")
                date = f.get("filedDate", "?")[:10]
                lines.append(f"  - Form {form} filed {date}")
        else:
            lines.append("**Recent SEC Filings:** None found")

        # Peers
        peers = fget("stock/peers", {"symbol": sym})
        if peers and isinstance(peers, list):
            peer_list = [p for p in peers if p != sym][:8]
            lines.append(f"**Peers:** {', '.join(peer_list)}")

    return "\n".join(lines)

if __name__ == "__main__":
    print(f"[{datetime.utcnow()}] Building news & filings report...")
    report = build_report()
    (DIRECTIVES / "watchlist_news_filings.md").write_text(report)
    print(f"Done. Saved to directives/watchlist_news_filings.md")
