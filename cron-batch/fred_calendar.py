#!/usr/bin/env python3
"""FRED economic calendar — daily digest of upcoming releases.
Tracks: CPI, NFP/jobs, FOMC, jobless claims, GDP, PCE, retail sales.
Posts to discord_economic_calendar_webhook (or tg_bridge fallback).
Cron: 7am ET + 4pm ET daily.
Key: ~/.openclaw/secrets/fred.txt (existing) or fred_api_key
"""
import json, time, requests
from pathlib import Path
from datetime import datetime, timezone, timedelta

SECRETS = Path.home() / ".openclaw" / "secrets"

# Webhook fallback chain
def _webhook():
    for name in ("discord_economic_calendar_webhook", "discord_fred_calendar_webhook", "discord_tg_bridge_webhook"):
        p = SECRETS / name
        if p.exists():
            return p.read_text().strip(), name
    return None, None

# API key fallback
def _key():
    for name in ("fred_api_key", "fred.txt"):
        p = SECRETS / name
        if p.exists():
            return p.read_text().strip()
    return None

# Series we care about (FRED series IDs)
TRACKED_SERIES = {
    "CPIAUCSL": "CPI (Consumer Price Index)",
    "PAYEMS": "Nonfarm Payrolls (NFP)",
    "FEDFUNDS": "Fed Funds Rate",
    "ICSA": "Initial Jobless Claims",
    "GDP": "GDP",
    "PCEPI": "PCE Price Index",
    "RSAFS": "Retail Sales",
    "UNRATE": "Unemployment Rate",
}

def main():
    key = _key()
    if not key:
        print("[fred] no API key at ~/.openclaw/secrets/fred_api_key or fred.txt")
        return
    webhook, wname = _webhook()
    if not webhook:
        print("[fred] no webhook available — set discord_economic_calendar_webhook")
        return

    # Get all upcoming release dates in next 14 days
    today = datetime.now().strftime("%Y-%m-%d")
    fortnight = (datetime.now() + timedelta(days=14)).strftime("%Y-%m-%d")

    try:
        r = requests.get(
            "https://api.stlouisfed.org/fred/releases/dates",
            params={
                "api_key": key, "file_type": "json",
                "realtime_start": today, "realtime_end": fortnight,
                "include_release_dates_with_no_data": "false",
                "limit": 100, "sort_order": "asc",
            },
            timeout=12,
        )
    except Exception as e:
        print(f"[fred] API error: {e}")
        return

    if r.status_code != 200:
        print(f"[fred] API status {r.status_code}: {r.text[:200]}")
        return

    releases = r.json().get("release_dates", [])
    # Tiered impact filter — HIGH = market-moving, MED = relevant
    HIGH_IMPACT = [
        "consumer price index", "cpi",
        "producer price index", "ppi",
        "employment situation", "nonfarm payroll", "payems", "nonfarm employees",
        "unemployment rate",
        "advance gdp", "gross domestic product", "gdp first", "gdp second", "gdp third",
        "fomc", "federal open market committee", "federal funds",
        "personal income and outlays", "pce price index", "personal consumption",
        "retail sales", "advance monthly retail",
        "ism manufacturing", "ism services", "ism non-manufacturing",
        "jolts", "job openings",
        "initial jobless claims", "continuing jobless claims",
        "treasury auction",
    ]
    MED_IMPACT = [
        "housing starts", "building permits", "new residential construction",
        "existing home sales", "new home sales",
        "durable goods", "manufacturers shipments",
        "consumer confidence", "consumer sentiment", "michigan",
        "industrial production", "capacity utilization",
        "international trade", "trade balance", "current account",
        "factory orders", "wholesale trade", "business inventories",
        "philadelphia fed", "empire state", "richmond fed", "kansas city fed", "dallas fed",
        "leading economic", "lei",
        "construction spending", "case-shiller",
        "challenger job cuts", "adp employment",
        "import price", "export price",
    ]
    relevant = []
    keywords = HIGH_IMPACT + MED_IMPACT  # combined for filter
    for rel in releases:
        name = (rel.get("release_name") or "").lower()
        # Tag with impact tier
        impact = None
        for kw in HIGH_IMPACT:
            if kw in name:
                impact = "HIGH"
                break
        if not impact:
            for kw in MED_IMPACT:
                if kw in name:
                    impact = "MED"
                    break
        if impact:
            rel["_impact"] = impact
            relevant.append(rel)

    if not relevant:
        print("[fred] no high-impact releases in next 14 days")
        return

    # Group by date
    by_date = {}
    for rel in relevant[:20]:
        date = rel.get("date", "?")
        by_date.setdefault(date, []).append(rel.get("release_name", "?"))

    fields = []
    for date in sorted(by_date.keys()):
        names = by_date[date]
        try:
            d_obj = datetime.strptime(date, "%Y-%m-%d")
            day_str = d_obj.strftime("%a %b %d")
        except: day_str = date
        fields.append({
            "name": f"📅 {day_str}",
            "value": "\n".join(f"• {n}" for n in names)[:1024],
            "inline": False,
        })

    payload = {
        "embeds": [{
            "title": "📊 Economic Calendar — Next 14 Days",
            "color": 0xf39c12,
            "fields": fields[:10],
            "timestamp": datetime.now(timezone.utc).isoformat(),
            "footer": {"text": f"Source: FRED | {len(relevant)} relevant releases"},
        }]
    }
    try:
        rr = requests.post(webhook, json=payload, timeout=10)
        print(f"[fred] webhook ({wname}): {rr.status_code} ({len(by_date)} dates posted)")
    except Exception as e:
        print(f"[fred] webhook error: {e}")

if __name__ == "__main__":
    main()
