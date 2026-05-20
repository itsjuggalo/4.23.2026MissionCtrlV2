#!/usr/bin/env python3
"""
Fetches insider trading data from free sources:
1. OpenInsider (scraping - best for cluster buys and filtered views)
2. SEC EDGAR EFTS API (free, no key needed - authoritative Form 4 data)

Outputs structured text for brief synthesis.
Interpretation rules baked in: filters for open-market buys, C-suite,
cluster patterns, and conviction sizing.
"""
import sys
import json
import re
from datetime import datetime, timedelta, timezone
from urllib.request import Request, urlopen
from urllib.error import URLError
from html.parser import HTMLParser

SECRETS = "/home/ubuntu/.openclaw/secrets"
USER_AGENT = "ClaudeClaw/1.0 (insider-brief-fetcher)"


def fetch_url(url, timeout=15):
    """Fetch URL with proper headers."""
    req = Request(url, headers={"User-Agent": USER_AGENT})
    try:
        with urlopen(req, timeout=timeout) as resp:
            return resp.read().decode("utf-8", errors="replace")
    except (URLError, Exception) as e:
        return None


def parse_openinsider():
    """
    Scrape OpenInsider for recent notable insider purchases.
    Filters: last 7 days, open market purchases, sorted by value.
    """
    # Latest open market purchases, last 7 days
    url = (
        "http://openinsider.com/screener?"
        "s=&o=&pl=&ph=&ll=&lh=&fd=7&fdr=&td=0&tdr="
        "&feession=at&cession=at&t=1&t=2&tc=1&lk=&cnt=30&page=1"
    )
    html = fetch_url(url)
    if not html:
        return []

    trades = []
    rows = re.findall(r"<tr[^>]*>(.+?)</tr>", html, re.DOTALL)

    for row in rows:
        cells = re.findall(r"<td[^>]*>(.*?)</td>", row, re.DOTALL)
        if len(cells) < 13:
            continue

        clean = [re.sub(r"<[^>]+>", "", c).strip() for c in cells]

        # OpenInsider columns (17 total):
        # [0]=X [1]=Filing Date [2]=Trade Date [3]=Ticker [4]=Company
        # [5]=Insider Name [6]=Title [7]=Trade Type [8]=Price [9]=Qty
        # [10]=Owned [11]=deltaOwn% [12]=Value [13-16]=other

        # Extract ticker from the anchor tag
        ticker_match = re.search(r'ticker=(\w+)', cells[3]) or re.search(r'>(\w+)</a>', cells[3])
        ticker = ticker_match.group(1) if ticker_match else clean[3]

        # Only open market purchases (type contains "P - Purchase")
        trade_type = clean[7].strip()
        if "P" not in trade_type:
            continue

        # Parse value (index 12) - remove $ and commas
        value_str = clean[12].replace("$", "").replace(",", "").replace("+", "").strip()
        try:
            value = int(value_str)
        except (ValueError, TypeError):
            value = 0

        # Parse price (index 8)
        price_str = clean[8].replace("$", "").replace(",", "").strip()
        try:
            price = float(price_str)
        except (ValueError, TypeError):
            price = 0

        # Parse ownership change % (index 11)
        delta_own = clean[11].strip()

        # Extract title/role (index 6)
        title = clean[6].strip()

        # Determine if C-suite
        is_csuite = any(
            t in title.upper()
            for t in ["CEO", "CFO", "COO", "CTO", "PRES", "CHAIRMAN", "GC"]
        )

        trades.append({
            "filing_date": clean[1].strip(),
            "trade_date": clean[2].strip(),
            "ticker": ticker.strip(),
            "insider": clean[5].strip()[:30],
            "title": title[:20],
            "price": price,
            "qty_change": clean[9].strip(),
            "delta_own": delta_own,
            "value": value,
            "is_csuite": is_csuite,
        })

    return trades


def find_clusters(trades):
    """
    Identify cluster buys: multiple insiders buying the same stock
    within the same 7-day window.
    """
    by_ticker = {}
    for t in trades:
        tk = t["ticker"]
        if tk not in by_ticker:
            by_ticker[tk] = []
        by_ticker[tk].append(t)

    clusters = []
    for ticker, txns in by_ticker.items():
        if len(txns) >= 2:
            total_value = sum(t["value"] for t in txns)
            csuite_count = sum(1 for t in txns if t["is_csuite"])
            clusters.append({
                "ticker": ticker,
                "num_buyers": len(txns),
                "total_value": total_value,
                "csuite_buyers": csuite_count,
                "insiders": [
                    f"{t['insider']} ({t['title']})" for t in txns
                ],
            })

    # Sort by total value descending
    clusters.sort(key=lambda c: c["total_value"], reverse=True)
    return clusters


def fetch_edgar_recent_form4s(days=2):
    """
    Fetch recent Form 4 filings from SEC EDGAR full-text search.
    Free, no API key needed.
    """
    end = datetime.now().strftime("%Y-%m-%d")
    start = (datetime.now() - timedelta(days=days)).strftime("%Y-%m-%d")

    url = (
        f"https://efts.sec.gov/LATEST/search-index?"
        f"q=&forms=4&dateRange=custom&startdt={start}&enddt={end}"
    )
    data = fetch_url(url)
    if not data:
        return 0

    try:
        d = json.loads(data)
        total = d.get("hits", {}).get("total", {})
        if isinstance(total, dict):
            return total.get("value", 0)
        return int(total) if total else 0
    except (json.JSONDecodeError, ValueError):
        return 0


def format_output(trades, clusters, edgar_count):
    """Format insider data for brief consumption."""
    lines = []

    # Cluster buys - the most actionable signal
    if clusters:
        lines.append("CLUSTER BUYS (multiple insiders, same stock, 7 days):")
        for c in clusters[:5]:
            csuite_tag = f" [{c['csuite_buyers']} C-suite]" if c["csuite_buyers"] else ""
            lines.append(
                f"  {c['ticker']:6s} | {c['num_buyers']} buyers | "
                f"${c['total_value']:,.0f} total{csuite_tag}"
            )
            for ins in c["insiders"][:3]:
                lines.append(f"    - {ins}")
        lines.append("")

    # Top individual purchases by value (C-suite highlighted)
    big_buys = sorted(trades, key=lambda t: t["value"], reverse=True)
    csuite_buys = [t for t in big_buys if t["is_csuite"]]
    if csuite_buys:
        lines.append("C-SUITE BUYS (CEO/CFO/COO - highest signal):")
        for t in csuite_buys[:5]:
            lines.append(
                f"  {t['ticker']:6s} | {t['insider'][:20]:20s} | {t['title'][:10]:10s} | "
                f"${t['value']:>10,.0f} @ ${t['price']:.2f} | own {t['delta_own']}"
            )
        lines.append("")

    # Top buys by value regardless of role
    if big_buys:
        lines.append(f"TOP OPEN-MARKET PURCHASES (7 days, {len(trades)} total):")
        for t in big_buys[:8]:
            role_tag = " ***" if t["is_csuite"] else ""
            lines.append(
                f"  {t['trade_date'][:10]} | {t['ticker']:6s} | {t['insider'][:20]:20s} | "
                f"${t['value']:>10,.0f} @ ${t['price']:.2f} | own {t['delta_own']}{role_tag}"
            )
        lines.append("")

    # EDGAR volume context
    if edgar_count:
        lines.append(f"SEC EDGAR: {edgar_count} Form 4 filings in last 48h")

    if not lines:
        lines.append("No notable insider purchases in last 7 days")

    return "\n".join(lines)


def main():
    # Fetch from OpenInsider
    trades = parse_openinsider()

    # Find cluster patterns
    clusters = find_clusters(trades)

    # Get EDGAR filing volume for context
    edgar_count = fetch_edgar_recent_form4s(days=2)

    # Format and output
    output = format_output(trades, clusters, edgar_count)
    print(output)


if __name__ == "__main__":
    main()
